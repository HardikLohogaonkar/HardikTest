package com.peopleinteractive.hardiktest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peopleinteractive.hardiktest.databinding.ItemUserListBinding
import com.peopleinteractive.hardiktest.interfaces.IonItemClickListener
import com.peopleinteractive.hardiktest.model.User
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserAdapter(var mUserList: List<User.Result>, var onIonItemClickListener: IonItemClickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolderUser>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {

        val itemUserListBinding =
            ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolderUser(itemUserListBinding)
    }

    override fun getItemCount() = mUserList.size

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {

        holder.itemUserListBinding.user = mUserList[position]

        holder.itemView.fabDecline.setOnClickListener {

            onIonItemClickListener.onItemClick(/*true,*/position,holder)
            notifyDataSetChanged()
        }
    }

    class ViewHolderUser(var itemUserListBinding: ItemUserListBinding) :
        RecyclerView.ViewHolder(itemUserListBinding.root) {

    }
}