package com.example.navigationcomponenetpractice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.navigationcomponenetpractice.databinding.FragmentNotificationBinding
import java.util.*

class NotificationFragment : Fragment() {
    lateinit var biding: FragmentNotificationBinding
    lateinit var list: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding = FragmentNotificationBinding.inflate(inflater, container, false)
        list = ArrayList<String>()
        for (i in 1..20) {
            list.add("notificatio $i")
        }

        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, list)
        biding.listview.adapter = adapter
        return biding.root
    }
}