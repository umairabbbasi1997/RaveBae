package com.fictivestudios.ravebae.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import com.fictivestudios.ravebae.model.Chat
import com.fictivestudios.ravebae.utils.Constants
import kotlinx.android.synthetic.main.item_message_received.view.*
import kotlinx.android.synthetic.main.item_message_sent.view.*

import kotlinx.android.synthetic.main.item_received.view.iv_user
import kotlinx.android.synthetic.main.item_swipe_card.view.*

class ConversationAdapter(users: List<Chat>)  : RecyclerView.Adapter<ConversationAdapter.ProfileViewHolder>() {

    private var users: List<Chat>? = users

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ProfileViewHolder{

        val view:View

        if (viewType == Constants.VIEW_TYPE_MESSAGE_RECEIVED)
        {
             view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_received, parent, false)
        }
        else
        {
             view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_sent, parent, false)
        }


        return ProfileViewHolder(view)


    }


    override fun getItemViewType(position: Int): Int {
        return users?.get(position)!!.messageType
    }

    override fun getItemCount() = users?.size ?: 1

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

        holder.itemView.iv_user.setOnClickListener {
            MainActivity.getMainActivity
                ?.navController?.navigate(R.id.userProfileFragment)
        }

        if (users?.get(position)!!.messageType==Constants.VIEW_TYPE_MESSAGE_SENT)
        {
            holder.itemView.tv_text_sent.text = users?.get(position)!!.textMessage
        }
        else
        {
            holder.itemView.tv_text_received.text = users?.get(position)!!.textMessage

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