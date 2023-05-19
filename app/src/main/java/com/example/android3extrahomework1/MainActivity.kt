package com.example.android3extrahomework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.android3extrahomework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setUpObserve()
        setUpListeners()
    }

    private fun setUpObserve() {
        viewModel?.number?.observe(this) { count ->
            binding.textView.text = count.toString()

            if (viewModel?.count == 10 || viewModel?.count == -10){
                binding.textView.setTextColor(getColor(R.color.purple_200))
            }else{
                binding.textView.setTextColor(getColor(R.color.black))
            }
        }
    }

    private fun setUpListeners() {
        clickPlus()
        clickMinus()
    }

    private fun clickPlus() {
       binding.plusButton.setOnClickListener {
           viewModel?.setPlus()
       }
    }

    private fun clickMinus() {
        binding.minusButton.setOnClickListener {
            viewModel?.setMinus()
        }
    }
}