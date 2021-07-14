package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationcomponenetpractice.Utils.Data
import com.example.navigationcomponenetpractice.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater, container, false)

        clickListener()
        return binding.root
    }

    private fun clickListener() {
        binding.etAmount.setText(Data.amount.value.toString())
        binding.btnSave.setOnClickListener {
            var data = binding.etAmount.text.toString().toLong()
            Data.amount.value = data
        }
    }


}