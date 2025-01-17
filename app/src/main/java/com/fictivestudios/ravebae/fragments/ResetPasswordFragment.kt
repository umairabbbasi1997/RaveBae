package com.fictivestudios.ravebae.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import com.fictivestudios.ravebae.activites.ResgistrationActivity
import com.fictivestudios.ravebae.utils.Constants
import kotlinx.android.synthetic.main.fragment_forgot.view.*
import kotlinx.android.synthetic.main.fragment_forgot.view.et_email
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_reset_password.view.*
import kotlinx.android.synthetic.main.fragment_reset_password.view.et_pass

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResetPasswordFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResetPasswordFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_reset_password, container, false)

        mView.btn_reset.setOnClickListener {

            validateFields()
        }

        return mView
    }


    private fun validateFields() {

        if (mView.et_confirm_pass.text.toString().isNullOrBlank()&&
            mView.et_pass.text.toString().isNullOrBlank()
        )
        {
            Toast.makeText(context, getString(R.string.fields_cant_be_empty), Toast.LENGTH_SHORT).show()
            return
        }


        if (mView.et_pass.text.toString().length <8 )
        {
            mView.et_pass.setError(getString(R.string.password_must_be))
            return
        }

        if ( mView.et_confirm_pass.text.toString().length <8 )
        {
            mView.et_confirm_pass.setError(getString(R.string.password_must_be))
            return
        }
        else
        {
            ResgistrationActivity.getRegActivity
                ?.navControllerReg?.navigate(R.id.loginFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResetPasswordFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResetPasswordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}