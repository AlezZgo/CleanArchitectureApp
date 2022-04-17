package com.example.cleanarchitectureapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.databinding.FragmentFirstBinding
import com.example.cleanarchitectureapp.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        sharedViewModel.text.observe(viewLifecycleOwner){
            binding.textView.text = it
        }
        return binding.root
    }

}