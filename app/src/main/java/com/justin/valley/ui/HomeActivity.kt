package com.justin.valley.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.justin.valley.R
import com.justin.valley.utils.TAG_LOG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenCreated {
            homeViewModel.refreshHomeContents()
        }
        getContents()
    }

    private fun getContents() {
        lifecycleScope.launch(Dispatchers.Main) {
            homeViewModel.getContents().collect{
                Log.d("TAG_JUSTIN","---> ${it.size}")
            }
        }
    }
}