package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var root: View
    lateinit var navController: NavController
    lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding.btnSendBalance.setOnClickListener {
            navController.navigate(R.id.viewBalanceFragment)
        }
        homeBinding.btnSendMoney.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToSenderFragment3()
            navController.navigate(action)
        }
        homeBinding.btnViewTransaction.setOnClickListener {
            navController.navigate(R.id.viewTransactionFragment)
        }
        return homeBinding.getRoot()
    }

}