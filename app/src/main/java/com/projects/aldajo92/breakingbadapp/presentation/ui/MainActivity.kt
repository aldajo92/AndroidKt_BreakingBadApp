package com.projects.aldajo92.breakingbadapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.projects.aldajo92.breakingbadapp.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setupViews(this)
        }
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    private fun setupViews(binding: ActivityMainBinding) {
        navHostFragment =
            (supportFragmentManager.findFragmentById(binding.fragmentContainer.id) as NavHostFragment)
    }

    fun showProgressBar(showProgressBar: Boolean) {
        if (showProgressBar) {
            binding.progressBar.visibility = View.VISIBLE
            binding.loaderBackground.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.loaderBackground.visibility = View.GONE
        }
    }

    fun showToolbarTitle(title: String, enableToolbar: Boolean) {
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(enableToolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment_container)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}
