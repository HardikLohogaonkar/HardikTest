package com.peopleinteractive.hardiktest.interfaces

import com.peopleinteractive.hardiktest.ui.adapter.UserAdapter

interface IonItemClickListener {

    fun onItemClick(/*isDecline: Boolean,*/ position: Int, holder: UserAdapter.ViewHolderUser)
}