package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.Utils.UserInfo
import com.example.navigationcomponenetpractice.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var currentbackstack = findNavController().currentBackStackEntry
        var statehandle = currentbackstack!!.savedStateHandle

        statehandle.getLiveData<Boolean>(LoginFragment.Login_Successful)
            .observe(currentbackstack!!) {
                if (!it) {
                    var startDestination = findNavController().graph.startDestination
                    var option = NavOptions.Builder().setPopUpTo(startDestination, true).build()
                    findNavController().navigate(startDestination, null, option)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        if (UserInfo.user == null) {
            Toast.makeText(requireActivity(), "Login first to continue!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.loginFragment)
        } else {
            var name = UserInfo.user!!.user
            binding.tvWelcome.text = "Wellcome ${name}"

        }
        return binding.root
    }

}