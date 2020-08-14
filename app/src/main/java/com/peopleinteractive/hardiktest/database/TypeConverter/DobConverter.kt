package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class DobConverter {

    @TypeConverter
    fun fromString(value: String?): User.Dob {
        val listType = object :
            TypeToken<User.Dob?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Dob?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}