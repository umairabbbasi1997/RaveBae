package com.fictivestudios.ravebae.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fictivestudios.imdfitness.activities.fragments.BaseFragment
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.ResgistrationActivity
import com.fictivestudios.ravebae.utils.Constants
import com.fictivestudios.ravebae.utils.Titlebar
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.fragment_signup.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : BaseFragment() {
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

       mView = inflater.inflate(R.layout.fragment_signup, container, false)

        mView.btn_create?.setOnClickListener {

            validateFields()
        }

        mView.btn_upload.setOnClickListener {

            openImagePicker()

        }
        mView.iv_profile.setOnClickListener {
            openImagePicker()
        }

        return mView

    }

    private fun openImagePicker()
    {    ImagePicker.with(this)
        .crop()	    			//Crop image(Optional), Check Customization for more option
        .compress(1024)			//Final image size will be less than 1 MB(Optional)
        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
        .start()

    }

    private fun validateFields() {

        if (mView.et_username.text.toString().isNullOrBlank()||
            mView.et_email.text.toString().isNullOrBlank()||
            mView.et_pass.text.toString().isNullOrBlank()||
            mView.et_confirm_pass.text.toString().isNullOrBlank()
        )
        {
            Toast.makeText(context, getString(R.string.fields_cant_be_empty), Toast.LENGTH_SHORT).show()
            return
        }

        if (!Constants.isValidEmail(mView.et_email.text.toString()))
        {
            mView.et_email.setError(getString(R.string.invalid_email_format))
            return
        }
        if (mView.et_pass.text.toString().length <8 )
        {
            mView.et_pass.setError(getString(R.string.password_must_be))
            return
        }
        if (mView.et_pass.text.toString() != mView.et_confirm_pass.text.toString() )
        {
            mView.et_confirm_pass.setError(getString(R.string.confirm_pass_doesnt_match))

            return
        }

        else
        {
            Constants.isAccountLogin = true
            ResgistrationActivity.getRegActivity
               ?.navControllerReg?.navigate(R.id.otpFragment)

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            mView.iv_profile.setImageURI(uri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}