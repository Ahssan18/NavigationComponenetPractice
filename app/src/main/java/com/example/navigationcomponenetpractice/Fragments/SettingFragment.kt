package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSettingBinding.inflate(inflater, container, false)
        binding.btnAbout.setOnClickListener {
            var action=SettingFragmentDirections.actionSettingFragmentToAboutFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }


}