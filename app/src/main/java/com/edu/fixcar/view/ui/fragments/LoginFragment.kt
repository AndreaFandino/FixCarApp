package com.edu.fixcar.view.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edu.fixcar.R
import com.edu.fixcar.view.ui.activities.NavigationHost
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.sing_up_button.setOnClickListener({
            (activity as NavigationHost).navigateTo(AdminDetailDialogFragment(),false)
        })

        view.login_button.setOnClickListener({
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.error_password)
            } else {
                // Clear the error.
                password_text_input.error = null
                //Navigate to the next Fragment
                (activity as NavigationHost).navigateTo(HomeFragment(),false)
            }
        })

        // Clear the error once more than 8 characters are typed.
        view.password_edit_text.setOnKeyListener({ _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!)) {
                // Clear the error.
                password_text_input.error = null
            }
            false
        })

        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >=8
    }

}