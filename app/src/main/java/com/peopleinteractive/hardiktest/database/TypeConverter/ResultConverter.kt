package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.*

class ResultConverter {
    /*@TypeConverter
    fun fromString(value: String?): User.Result {
        val listType = object :
            TypeToken<User.Result?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Result?): String {
        val gson = Gson()
        return gson.toJson(list)
    }*/


    @TypeConverter
    fun fromString(value: String?): com.peopleinteractive.hardiktest.model.User.Result {
        val listType = object :
            TypeToken<com.peopleinteractive.hardiktest.model.User.Result?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: com.peopleinteractive.hardiktest.model.User.Result?): String {
        val gson = Gson()
        return gson.toJson(list)
    }


}