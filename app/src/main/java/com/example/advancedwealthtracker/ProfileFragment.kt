package com.example.advancedwealthtracker


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profileTV = view.findViewById<TextView>(R.id.sa_ze_tv_profile)

        profileTV.text = "Student: Saba Apkhadze\nBirth Date: 10 June 2004\nCoefficient K: 1.2"
    }
}