package com.home.cleanarchitecturedemo.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.home.cleanarchitecturedemo.R
import com.home.cleanarchitecturedemo.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar()
    }

    /**
     * 設置toolbar與navController的交互
     */
    private fun setActionBar() {
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_fragment)
        NavigationUI.setupWithNavController(toolbar, navController)
    }
}