package com.fictivestudios.ravebae.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import kotlinx.android.synthetic.main.item_received.view.*
import kotlinx.android.synthetic.main.item_swipe_card.view.*

class SpotifyAdapter  : RecyclerView.Adapter<SpotifyAdapter.ProfileViewHolder>() {

    private var users: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ProfileViewHolder{


            val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spotify, parent, false)

        return ProfileViewHolder(view)


    }




    override fun getItemCount() = users?.size ?: 10

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

    }

    fun setProfiles(profiles: List<ContactsContract.Profile>) {
       /* this.profiles = profiles
        notifyDataSetChanged()*/
    }

     class ProfileViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }
}