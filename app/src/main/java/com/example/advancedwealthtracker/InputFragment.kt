package com.example.advancedwealthtracker

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Naming: sa_ze_ (Saba + ze)
        val incomeET = view.findViewById<TextInputEditText>(R.id.sa_ze_et_income)
        val expensesET = view.findViewById<TextInputEditText>(R.id.sa_ze_et_expenses)
        val incomeLayout = view.findViewById<TextInputLayout>(R.id.sa_ze_til_income)
        val expensesLayout = view.findViewById<TextInputLayout>(R.id.sa_ze_til_expenses)
        val saveBtn = view.findViewById<MaterialButton>(R.id.sa_ze_btn_save)

        saveBtn.setOnClickListener {
            val incStr = incomeET.text.toString()
            val expStr = expensesET.text.toString()

            incomeLayout?.error = null
            expensesLayout?.error = null

            if (incStr.isEmpty() || expStr.isEmpty()) {
                if (incStr.isEmpty()) incomeLayout?.error = "Required"
                if (expStr.isEmpty()) expensesLayout?.error = "Required"
            } else {
                try {
                    val bundle = Bundle().apply {
                        putDouble("income_key", incStr.toDouble())
                        putDouble("expenses_key", expStr.toDouble())
                    }
                    parentFragmentManager.setFragmentResult("sa_ze_request_key", bundle)

                    // გვარი იწყება ხმოვანზე (A) -> Horizontal
                    activity?.findViewById<ViewPager2>(R.id.sa_ze_view_pager)?.currentItem = 1
                } catch (e: Exception) {
                    incomeLayout?.error = "Invalid"
                }
            }
        }
    }
}