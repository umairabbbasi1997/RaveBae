package com.fictivestudios.ravebae.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.ResgistrationActivity
import com.fictivestudios.ravebae.utils.Constants
import com.fictivestudios.ravebae.utils.Constants.Companion.EMAIL
import com.fictivestudios.ravebae.utils.Constants.Companion.PHONE
import com.fictivestudios.ravebae.utils.Constants.Companion.isAccountLogin
import kotlinx.android.synthetic.main.fragment_pre_login.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PreLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PreLoginFragment : Fragment() {
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

        mView = inflater.inflate(R.layout.fragment_pre_login, container, false)


        mView.btn_phone.setOnClickListener {

            isAccountLogin = true
            Constants.loginType = PHONE
            ResgistrationActivity.getRegActivity
                ?.navControllerReg?.navigate(R.id.agreementFragment)
        }

        mView.btn_email.setOnClickListener{

            Constants.loginType = EMAIL
            ResgistrationActivity.getRegActivity
                ?.navControllerReg?.navigate(R.id.agreementFragment)

        }
        return mView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PreLoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PreLoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}