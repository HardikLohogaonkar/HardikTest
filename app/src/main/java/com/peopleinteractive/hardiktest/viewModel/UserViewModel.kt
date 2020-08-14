package com.peopleinteractive.hardiktest.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peopleinteractive.hardiktest.app.App.Companion.mInstance
import com.peopleinteractive.hardiktest.database.UserDatabase
import com.peopleinteractive.hardiktest.model.User
import com.peopleinteractive.hardiktest.network.NetworkApiCall
import com.peopleinteractive.hardiktest.network.NetworkApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


open class UserViewModel : ViewModel() {

    var mUserList = MutableLiveData<User>()
    var mUsers = MutableLiveData<List<User.Result>>()

    private val mNetworkClient = NetworkApiCall(NetworkApiClient.getNetworkServices())
    private val errorMessageData = MutableLiveData<String>()

    fun getErrorMessage(): LiveData<String> {
        return errorMessageData
    }

    fun setErrorMessage(errorMessage: String) {
        errorMessageData.postValue(errorMessage)
    }

    fun getUserList(id: String) {
        mNetworkClient.getUserList(id, this)
    }

    fun onSuccessUserData(it: User?) {
        mUserList.postValue(it)

    }

    fun getAllUsers(): MutableLiveData<List<User.Result>> {
        val user = UserDatabase.getDatabase(mInstance)
            .getDatabaseDao()
            .getAllUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                mUsers.value = it
                mUsers.postValue(it)

            }, {

            })

        return mUsers
    }

}