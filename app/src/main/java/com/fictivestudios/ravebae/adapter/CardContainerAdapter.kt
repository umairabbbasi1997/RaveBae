package com.fictivestudios.ravebae.adapter

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import kotlinx.android.synthetic.main.item_swipe_card.view.*

class CardContainerAdapter () : RecyclerView.Adapter<CardContainerAdapter.ProfileViewHolder>() {

    private var profiles: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ProfileViewHolder{


            val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_swipe_card, parent, false)

        return ProfileViewHolder(view)


    }




    override fun getItemCount() = profiles?.size ?: 10

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
      holder.itemView.iv_user_image.setBackgroundResource(R.drawable.user_dp)

        holder.itemView.iv_user_image.setOnClickListener {
            MainActivity.getMainActivity
                ?.navController?.navigate(R.id.userProfileFragment)
        }
    }

    fun setProfiles(profiles: List<ContactsContract.Profile>) {
       /* this.profiles = profiles
        notifyDataSetChanged()*/
    }

     class ProfileViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }
}