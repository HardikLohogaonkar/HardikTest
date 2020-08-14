package com.peopleinteractive.hardiktest.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.peopleinteractive.hardiktest.R
import com.peopleinteractive.hardiktest.databinding.ActivityMainBinding
import com.peopleinteractive.hardiktest.interfaces.IonItemClickListener
import com.peopleinteractive.hardiktest.model.User
import com.peopleinteractive.hardiktest.ui.adapter.UserAdapter
import com.peopleinteractive.hardiktest.utility.NetworkConnection
import com.peopleinteractive.hardiktest.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user_list.view.*


class MainActivity : AppCompatActivity(), IonItemClickListener {

    private var mUserList = ArrayList<User.Result>()
    private lateinit var mUserAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserList.clear()

        performDataBinding()
        initRclView()

    }

    private fun performDataBinding() {
        val mNetworkConnection = NetworkConnection(this)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val userViewModel: UserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.lifecycleOwner = this

        mNetworkConnection.observe(this, Observer { isConnected ->

            if (isConnected) {
                userViewModel.getUserList("10")
                userViewModel.mUserList.observe(this, userListObserver)

            } else {

                mUserList.clear()
                userViewModel.getAllUsers()
            }
        })
    }

    private fun initRclView() {
        mUserAdapter = UserAdapter(mUserList, this)
        rvUser.adapter = mUserAdapter
    }

    private val userListObserver = Observer<User> {
        it?.let { it1 ->
            mUserList.clear()
            mUserList.addAll(it1.results)
            mUserAdapter.notifyDataSetChanged()
        }
    }

    override fun onItemClick(
//        isDecline: Boolean,
        position: Int,
        holder: UserAdapter.ViewHolderUser
    ) {

        holder.itemView.fabAccept.visibility = View.INVISIBLE
        holder.itemView.fabDecline.visibility = View.INVISIBLE
        holder.itemView.tvAccept.visibility = View.INVISIBLE
        holder.itemView.tvDecline.visibility = View.INVISIBLE
        holder.itemView.tvDeclineInvite.visibility = View.VISIBLE
    }
}