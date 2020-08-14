package com.peopleinteractive.hardiktest.network

import android.util.Log
import com.peopleinteractive.hardiktest.app.App.Companion.mInstance
import com.peopleinteractive.hardiktest.database.UserDatabase
import com.peopleinteractive.hardiktest.viewModel.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkApiCall(mNetworkService: NetworkService) {

    private var networkApiServices: NetworkService? = null

    init {
        this.networkApiServices = mNetworkService
    }

    fun getUserList(
        id: String,
        viewModel: UserViewModel
    ): Disposable? {
        return networkApiServices?.getUser(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
//                Log.e("it", it.toString())
                when {
                    it != null -> {
                        viewModel.onSuccessUserData(it)
                        UserDatabase.getDatabase(mInstance).getDatabaseDao().insertUser(it.results)
                    }

                    else -> viewModel.setErrorMessage("Error while getting data")
                }
            }, {


//                Log.e("Error", it.toString())
            })

    }
}