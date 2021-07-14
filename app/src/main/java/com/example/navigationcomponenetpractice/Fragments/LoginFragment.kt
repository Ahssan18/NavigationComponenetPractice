package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponenetpractice.Utils.User
import com.example.navigationcomponenetpractice.Utils.UserInfo
import com.example.navigationcomponenetpractice.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    companion object {
        var Login_Successful = "Login_Successful"
    }

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        var savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(Login_Successful, false)
        binding.btnLogin.setOnClickListener {
            var name = binding.etName.text.toString()
            UserInfo.user = User(name)
            savedStateHandle.set(Login_Successful, true)
            findNavController().popBackStack()
        }
        return binding.root
    }

}