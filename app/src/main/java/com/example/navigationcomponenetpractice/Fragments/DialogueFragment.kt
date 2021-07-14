package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.navigationcomponenetpractice.databinding.FragmentDialogueBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DialogueFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentDialogueBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogueBinding.inflate(inflater, container, false)
        var name = requireArguments().getString("name")
        var amount = requireArguments().getLong("amount")
        binding.textView2.text = "Are you sure you want to send  $amount to $name ?"
        binding.btnSend.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                "Are you sure you want to send  $amount to $name ?",
                Toast.LENGTH_LONG
            ).show()
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        return binding.root
    }


}