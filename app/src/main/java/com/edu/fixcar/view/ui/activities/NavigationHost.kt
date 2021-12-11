package com.edu.fixcar.view.ui.activities

import androidx.appcompat.app.AppCompatActivity

interface NavigationHost {
    fun navigateTo(fragment: AppCompatActivity, addToBackstack: Boolean)
}