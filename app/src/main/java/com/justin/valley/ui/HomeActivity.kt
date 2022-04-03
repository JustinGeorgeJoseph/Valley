package com.justin.valley.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.justin.valley.R
import com.justin.valley.adapters.HomeAdapter
import com.justin.valley.databinding.ActivityMainBinding
import com.justin.valley.utils.HomeRefreshStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
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
        getContents()
        lifecycleScope.launchWhenStarted {
            homeViewModel.fetchHomeContents()
        }
    }

    private fun setupView() {
        homeAdapter = HomeAdapter()
        binding?.recyHome?.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = homeAdapter
        }
        binding?.swipeRefresh?.setOnRefreshListener {
            lifecycleScope.launch(Dispatchers.IO){
                homeViewModel.refreshHomeContents()
            }
        }
    }

    private fun getContents() {
        lifecycleScope.launch(Dispatchers.Main) {
            homeViewModel.getContents().collect{
                    homeAdapter?.submitList(it)
            }
        }
        homeViewModel.homeRefreshStatus.observe(this){
            if (it == HomeRefreshStatus.ENDED){
                binding?.swipeRefresh?.isRefreshing = false
            }
        }
    }
}