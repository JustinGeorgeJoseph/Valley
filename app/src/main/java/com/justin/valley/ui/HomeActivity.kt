package com.justin.valley.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justin.valley.R
import com.justin.valley.adapters.HomeAdapter
import com.justin.valley.databinding.ActivityMainBinding
import com.justin.valley.utils.TAG_LOG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel : HomeViewModel by viewModels()

    private  var homeAdapter : HomeAdapter? = null

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        setContentView(binding?.root)
        setupView()
        lifecycleScope.launchWhenCreated {
            homeViewModel.refreshHomeContents()
        }
        getContents()
    }

    private fun setupView() {
        homeAdapter = HomeAdapter()
        binding?.recyHome?.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = homeAdapter
        }
    }

    private fun getContents() {
        lifecycleScope.launch(Dispatchers.Main) {
            homeViewModel.getContents().collect{
                withContext(Dispatchers.Main){
                    homeAdapter?.submitList(it)
                }
            }
        }
    }
}