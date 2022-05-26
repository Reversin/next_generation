package com.example.rtest5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rtest5.R
import com.example.rtest5.utils.findLocationOfCenterOnTheScreen
import com.example.rtest5.utils.open
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val positions = view.findLocationOfCenterOnTheScreen()
        fab1.setOnClickListener {
//            val positions = it.findLocationOfCenterOnTheScreen()
            val positions = intArrayOf(0, 0)
            activity?.supportFragmentManager?.open {
                // Pass center as the end position of the circular reveal
                add(R.id.container, OneFragment.newInstance(positions)).addToBackStack(null)
            }
        }

        fab2.setOnClickListener {
//            val positions = it.findLocationOfCenterOnTheScreen()
            val positions = intArrayOf(0, 0)
            activity?.supportFragmentManager?.open {
                // Pass center as the end position of the circular reveal
                add(R.id.container, TwoFragment.newInstance(positions)).addToBackStack(null)
            }
        }
    }
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        val mWidth = this.resources.displayMetrics.widthPixels
//        val mHeight = this.resources.displayMetrics.heightPixels
//
//
//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            val positions = intArrayOf(0, 0)
//            activity?.supportFragmentManager?.open {
//                // Pass center as the end position of the circular reveal
//                add(R.id.container, OneFragment.newInstance(positions)).addToBackStack(null)
//            }
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            val positions = intArrayOf(0, 0)
//            activity?.supportFragmentManager?.open {
//                // Pass center as the end position of the circular reveal
//                add(R.id.container, TwoFragment.newInstance(positions)).addToBackStack(null)
//            }
//        }
//    }
}
