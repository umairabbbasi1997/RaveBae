package com.fictivestudios.ravebae.fragments

import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.DEFAULT_BOLD
import android.graphics.fonts.Font
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.fictivestudios.imdfitness.activities.fragments.BaseFragment
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.ResgistrationActivity
import com.fictivestudios.ravebae.utils.Constants
import com.fictivestudios.ravebae.utils.Constants.Companion.EMAIL
import com.fictivestudios.ravebae.utils.Constants.Companion.PHONE
import com.fictivestudios.ravebae.utils.Titlebar
import kotlinx.android.synthetic.main.fragment_agreement.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgreementFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgreementFragment : BaseFragment() {
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

    override fun setTitlebar(titlebar: Titlebar) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_agreement, container, false)


        makeTextLink(mView.tv_i_have_read,"Terms & conditions"
        ,true,R.color.white,
            {                ResgistrationActivity.getRegActivity
                ?.navControllerReg?.navigate(R.id.termsAndConditionsFragment)})


        makeTextLink(mView.tv_i_have_read,"privacy & policy"
            ,true,R.color.white,
            {                ResgistrationActivity.getRegActivity
                ?.navControllerReg?.navigate(R.id.privacyAndPolicyFragment)})

        mView.btn_i_agree.setOnClickListener {

            if (Constants.loginType == EMAIL)
            {

                ResgistrationActivity.getRegActivity
                    ?.navControllerReg?.navigate(R.id.loginFragment)
            }
            else if (Constants.loginType == PHONE)
            {
                 ResgistrationActivity.getRegActivity
                    ?.navControllerReg?.navigate(R.id.otpFragment)
            }
        }




        return mView
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun makeTextLink(textView: TextView, str: String, underlined: Boolean, color: Int?, action: (() -> Unit)? = null) {
        val spannableString = SpannableString(textView.text)
        val textColor = color ?: textView.currentTextColor
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                action?.invoke()
            }
            override fun updateDrawState(drawState: TextPaint) {
                super.updateDrawState(drawState)
                drawState.isUnderlineText = underlined
                drawState.color = Color.WHITE
                drawState.typeface = DEFAULT_BOLD
            }
        }
        val index = spannableString.indexOf(str)
        spannableString.setSpan(clickableSpan, index, index + str.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.highlightColor = Color.WHITE

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AgreementFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgreementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}