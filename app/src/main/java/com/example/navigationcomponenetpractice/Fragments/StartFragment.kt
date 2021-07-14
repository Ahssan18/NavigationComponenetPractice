package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponenetpractice.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        clickListener()
        return binding.root
    }

    private fun clickListener() {
        binding.vtbNext.setOnClickListener {
            var action = StartFragmentDirections.actionStartFragmentToProfileFragment()
            findNavController().navigate(action)
        }
    }
}