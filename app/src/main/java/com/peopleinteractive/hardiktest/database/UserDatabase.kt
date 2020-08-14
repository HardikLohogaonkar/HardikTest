package com.peopleinteractive.hardiktest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.peopleinteractive.hardiktest.dao.UserDao
import com.peopleinteractive.hardiktest.database.TypeConverter.*
import com.peopleinteractive.hardiktest.model.User

@Database(entities = [(User.Result::class)], exportSchema = false, version = 1)
@TypeConverters(
    value = [(ResultConverter::class), (InfoConverter::class), (CoordinatesConverter::class)
        , (DobConverter::class), (IdConverter::class)
        , (LocationConverter::class), (LoginConverter::class)
        , (NameConverter::class), (PictureConverter::class)
        , (RegisterConverter::class), (StreetConverter::class), (TimezonConverter::class)]
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDatabaseDao(): UserDao

    companion object {

        fun getDatabase(context: Context): UserDatabase =
            Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}