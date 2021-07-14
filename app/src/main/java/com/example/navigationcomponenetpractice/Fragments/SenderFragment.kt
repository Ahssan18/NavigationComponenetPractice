package com.example.navigationcomponenetpractice.Fragments

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponenetpractice.App.AppId
import com.example.navigationcomponenetpractice.R
import com.example.navigationcomponenetpractice.databinding.FragmentSenderBinding


class SenderFragment : Fragment() {
    lateinit var binding: FragmentSenderBinding
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener {
            var name = binding.etSenderName.text.toString()
            var action = SenderFragmentDirections.actionSenderFragmentToSendMoneyFragment2(name)
            findNavController().navigate(action)
            var pendingIntent = findNavController().createDeepLink().setGraph(R.navigation.nav_main)
                .setDestination(R.id.sendMoneyFragment)
                .setArguments(SendMoneyFragmentArgs(name).toBundle())
                .createPendingIntent()
            createNotification(pendingIntent, name)
        }
        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    private fun createNotification(pendingIntent: PendingIntent, name: String) {
        var notification =
            NotificationCompat.Builder(requireActivity(), AppId)
                .setSmallIcon(R.mipmap.ic_launcher).
                setContentIntent(pendingIntent)
                .setContentTitle("Nav Component")
                .setContentText("Money send to $name").build()
        NotificationManagerCompat.from(requireActivity()).notify(1000, notification)


    }


}