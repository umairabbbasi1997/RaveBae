package com.fictivestudios.ravebae.fragments

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import com.fictivestudios.ravebae.activites.ResgistrationActivity
import com.fictivestudios.ravebae.utils.Constants
import kotlinx.android.synthetic.main.fragment_change_passowrd.*
import kotlinx.android.synthetic.main.fragment_change_passowrd.view.*
import kotlinx.android.synthetic.main.fragment_change_passowrd.view.iv_show_repeat_pass
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChangePassowrdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChangePassowrdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mView: View

    private var isShowRepeatPass = false
    private var isShowPass = false
    private var isShowNewPass = false

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
        mView = inflater.inflate(R.layout.fragment_change_passowrd, container, false)

        mView.btn_save.setOnClickListener {
            validateFields()
        }


        mView.iv_show_pass.setOnClickListener {
            if (isShowPass)
            {
                isShowPass = false
                mView.iv_show_pass.setImageResource(R.drawable.ic_baseline_visibility_24)
                mView.et_old_pass.transformationMethod = PasswordTransformationMethod()
            }
            else
            {
                isShowPass = true
                mView.iv_show_pass.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                mView.et_old_pass.transformationMethod = null
            }

        }

        mView.iv_show_repeat_pass.setOnClickListener {
            if (isShowRepeatPass)
            {
                isShowRepeatPass = false
                mView.iv_show_repeat_pass.setImageResource(R.drawable.ic_baseline_visibility_24)
                mView.et_reenter_pass.transformationMethod = PasswordTransformationMethod()
            }
            else
            {
                isShowRepeatPass = true
                mView.iv_show_repeat_pass.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                mView.et_reenter_pass.transformationMethod = null
            }

        }

        mView.iv_show_new_pass.setOnClickListener {
            if (isShowNewPass)
            {
                isShowNewPass = false
                mView.iv_show_new_pass.setImageResource(R.drawable.ic_baseline_visibility_24)
                mView.et_new_pass.transformationMethod = PasswordTransformationMethod()
            }
            else
            {
                isShowNewPass = true
                mView.iv_show_new_pass.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                mView.et_new_pass.transformationMethod = null
            }

        }

        return mView
    }


    private fun validateFields() {

       /* if (mView.et_old_pass.text.toString().isNullOrBlank()&&
            mView.et_reenter_pass.text.toString().isNullOrBlank()&&
            mView.et_new_pass.text.toString().isNullOrBlank()
        )
        {
            Toast.makeText(context, getString(R.string.fields_cant_be_empty), Toast.LENGTH_SHORT).show()
            return
        }*/


        if (!mView.et_old_pass.text.toString().isValidPassword() )
        {
            mView.et_old_pass.setError(getString(R.string.password_must_be))
            return
        }





        if (!mView.et_new_pass.text.toString().isValidPassword() )
        {
            mView.et_new_pass.setError(getString(R.string.password_must_be))
            return
        }

/*

        if (!mView.et_reenter_pass.text.toString().isValidPassword() )
        {
            mView.et_reenter_pass.setError(getString(R.string.password_must_be))
            return
        }
*/

        if (mView.et_new_pass.text.toString() != mView.et_reenter_pass.text.toString() )
        {
            mView.et_reenter_pass.setError(getString(R.string.password_doesnt_match))
            return
        }

       /* if (mView.et_reenter_pass.text.toString().length <8 )
        {
            mView.et_reenter_pass.setError(getString(R.string.password_must_be))
            return
        }*/

        if (mView.et_old_pass.text.toString() == mView.et_new_pass.text.toString())
        {
            mView.et_new_pass.setError(getString(R.string.old_pass_and_new_pass_cant_be_same))
            return
        }



        else
        {

            MainActivity.getMainActivity?.onBackPressed()
        }
    }

    fun CharSequence.isValidPassword(): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val pattern = Pattern.compile(passwordPattern)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChangePassowrdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChangePassowrdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}