package com.kotlin.base.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.base.R
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("ffgfg")
    }
}
