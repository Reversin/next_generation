package com.example.rtest5.contracts

interface ActivityContract : BaseContract {
    interface View : BaseContract.View {
        fun showOneScreen(positionAnimation : IntArray)

        fun showDashboardScreen()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onOrientationChanged(orientation: Int)
    }
}