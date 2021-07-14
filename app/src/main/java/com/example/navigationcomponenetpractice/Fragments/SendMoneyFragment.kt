package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.Utils.Data
import com.example.navigationcomponenetpractice.databinding.FragmentSendMoneyBinding


class SendMoneyFragment : Fragment() {
    //    var args= SendMoneyFragmentArgs by navArgs()
    lateinit var binding: FragmentSendMoneyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        binding.etAmount.setText(Data.amount.value.toString())
        var name = requireArguments().getString("name")
        binding.textView.text = "Send money to $name"
        binding.button.setOnClickListener {
            var action = SendMoneyFragmentDirections.actionSendMoneyFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        binding.btnSubmit.setOnClickListener {

            var amount: String = et_amount.text.toString()
            var action = SendMoneyFragmentDirections.actionSendMoneyFragmentToDialogueFragment(
                name!!,
                amount = amount.toLong()
            )
            findNavController().navigate(action)
        }
        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)
        }
        return binding.root
    }


}


