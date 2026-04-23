package com.example.advancedwealthtracker



import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    private val wealthManager = WealthManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Naming: sa_ze_
        val resultTV = view.findViewById<TextView>(R.id.sa_ze_tv_result)

        parentFragmentManager.setFragmentResultListener("sa_ze_request_key", viewLifecycleOwner) { _, bundle ->
            val income = bundle.getDouble("income_key")
            val expenses = bundle.getDouble("expenses_key")

            val result = wealthManager.calculateFinalSavings(income, expenses)
            resultTV.text = String.format("%.2f", result)
        }
    }
}