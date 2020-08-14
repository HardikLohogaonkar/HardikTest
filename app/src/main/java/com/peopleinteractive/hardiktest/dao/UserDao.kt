package com.peopleinteractive.hardiktest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peopleinteractive.hardiktest.dao.DatabaseQuery.GET_ALL_USERS
import com.peopleinteractive.hardiktest.model.User
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(result: List<User.Result>)

    @Query(GET_ALL_USERS)
    fun getAllUsers(): Flowable<List<User.Result>>
}