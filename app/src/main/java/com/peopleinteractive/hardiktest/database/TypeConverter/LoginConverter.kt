package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class LoginConverter {

    @TypeConverter
    fun fromString(value: String?): User.Login {
        val listType = object :
            TypeToken<User.Login?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Login?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}