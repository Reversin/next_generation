package com.example.rtest5.presenters

import android.content.res.Configuration
import com.example.rtest5.R
import com.example.rtest5.contracts.ActivityContract
import com.example.rtest5.fragments.OneFragment
import com.example.rtest5.utils.open

class ActivityPresenter(private val view: ActivityContract.View) : ActivityContract.Presenter {
    override fun onOrientationChanged(orientation: Int) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            val positions = it.findLocationOfCenterOnTheScreen()
//            val positions = intArrayOf(0, 0)
            val position = intArrayOf(0, 0)
            view.showOneScreen(position)
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            view.showDashboardScreen()
        }
    }
}