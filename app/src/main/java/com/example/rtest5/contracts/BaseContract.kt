package com.example.rtest5.contracts

interface BaseContract {
    interface View

    interface Presenter<view: View>
}