package com.example.rtest5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rtest5.R
import com.example.rtest5.utils.ExitWithAnimation
import com.example.rtest5.utils.startCircularReveal

class TwoFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): TwoFragment = TwoFragment().apply {
            if (exit != null && exit.size == 2) {
                posX = exit[0]
                posY = exit[1]
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(true)
    }
}
