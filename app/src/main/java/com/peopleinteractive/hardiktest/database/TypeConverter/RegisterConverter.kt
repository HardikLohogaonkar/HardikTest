package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class RegisterConverter {

    @TypeConverter
    fun fromString(value: String?): User.Registered {
        val listType = object :
            TypeToken<User.Registered?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Registered?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}