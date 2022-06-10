package com.fictivestudios.ravebae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fictivestudios.imdfitness.activities.fragments.BaseFragment
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import com.fictivestudios.ravebae.adapter.PlaylistAdapter
import com.fictivestudios.ravebae.adapter.SpotifyAdapter
import com.fictivestudios.ravebae.utils.Titlebar
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*
import kotlinx.android.synthetic.main.fragment_preferences.view.*
import kotlinx.android.synthetic.main.fragment_preferences.view.btn_save_changes

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PreferencesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PreferencesFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var isMale=false
    private var isFemale=false
    private var isCouple=false

    private lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBtnBack(getString(R.string.preferences),R.color.purple)
        titlebar.showTitleBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_preferences, container, false)


        mView.btn_male.setOnClickListener {
            if (!isMale)
            {
                mView.btn_male.setBackgroundResource(R.drawable.round_button_bg)
                mView.btn_male.setTextColor(resources.getColor(R.color.white))

                mView.btn_female.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_female.setTextColor(resources.getColor(R.color.gray))
                mView.btn_couple.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_couple.setTextColor(resources.getColor(R.color.gray))
            }
        }


        mView.btn_save_changes.setOnClickListener {
            MainActivity.getMainActivity?.onBackPressed()
        }

        mView.btn_female.setOnClickListener {

            if (!isFemale)
            {
                mView.btn_female.setBackgroundResource(R.drawable.round_button_bg)
                mView.btn_female.setTextColor(resources.getColor(R.color.white))

                mView.btn_couple.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_couple.setTextColor(resources.getColor(R.color.gray))
                mView.btn_male.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_male.setTextColor(resources.getColor(R.color.gray))
            }
        }

        mView.btn_couple.setOnClickListener {
            if (!isCouple)
            {
                mView.btn_couple.setBackgroundResource(R.drawable.round_button_bg)
                mView.btn_couple.setTextColor(resources.getColor(R.color.white))


                mView.btn_male.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_male.setTextColor(resources.getColor(R.color.gray))
                mView.btn_female.setBackgroundResource(R.drawable.round_button_white_bg)
                mView.btn_female.setTextColor(resources.getColor(R.color.gray))

            }
        }

        mView.rv_spotify_playlist.adapter = PlaylistAdapter()


        return mView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PreferencesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PreferencesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}