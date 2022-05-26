package com.example.rtest5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rtest5.contracts.ActivityContract
import com.example.rtest5.fragments.DashboardFragment
import com.example.rtest5.fragments.OneFragment
import com.example.rtest5.presenters.ActivityPresenter
import com.example.rtest5.utils.ExitWithAnimation
import com.example.rtest5.utils.exitCircularReveal
import com.example.rtest5.utils.findLocationOfCenterOnTheScreen
import com.example.rtest5.utils.open

class MainActivity : AppCompatActivity(), ActivityContract.View {
    lateinit var presenter: ActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ActivityPresenter(this)
        presenter.onOrientationChanged(resources.configuration.orientation)
    }

    override fun onBackPressed() {
        with(supportFragmentManager.findFragmentById(R.id.container)) {
            // Check if the current fragment implements the [ExitWithAnimation] interface or not
            // Also check if the [ExitWithAnimation.isToBeExitedWithAnimation] is `true` or not
            if ((this as? ExitWithAnimation)?.isToBeExitedWithAnimation() == true) {
                if (this.posX == null || this.posY == null) {
                    super.onBackPressed()
                } else {
                    this.view?.exitCircularReveal(this.posX!!, this.posY!!) {
                        super.onBackPressed()
                    } ?: super.onBackPressed()
                }
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun showOneScreen(positionAnimation: IntArray) {
        supportFragmentManager.open {
            val pos = window.decorView.findLocationOfCenterOnTheScreen()
            add(R.id.container, OneFragment.newInstance(pos))
                .addToBackStack(null)
        }
    }

    override fun showDashboardScreen() {
        supportFragmentManager.open {
            add(R.id.container, DashboardFragment.newInstance())
                .addToBackStack(null)
        }
    }
}
