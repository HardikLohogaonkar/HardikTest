package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class PictureConverter {

    @TypeConverter
    fun fromString(value: String?): User.Picture {
        val listType = object :
            TypeToken<User.Picture?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Picture?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}