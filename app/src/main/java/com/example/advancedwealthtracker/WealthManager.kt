package com.example.advancedwealthtracker





class WealthManager {
    // Saba (4) + Apkhadze (8) = 12
    // დაბადების რიცხვი = 10
    // K = 12 / 10 = 1.2
    private val k: Double = 1.2

    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * k
    }
}