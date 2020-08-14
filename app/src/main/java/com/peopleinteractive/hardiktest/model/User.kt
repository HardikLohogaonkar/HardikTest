package com.peopleinteractive.hardiktest.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.peopleinteractive.hardiktest.database.TypeConverter.*


data class User(

    @SerializedName("info")
    val info: Info,

    @TypeConverters(ResultConverter::class)
    @SerializedName("results")
    val results: List<Result>
) {
    @TypeConverters(InfoConverter::class)
    data class Info(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: Int,
        @SerializedName("seed")
        val seed: String,
        @SerializedName("version")
        val version: String
    )

    @Entity(tableName = "user")
    @TypeConverters(ResultConverter::class)
    data class Result(
        @PrimaryKey(autoGenerate = true)
        var userId: Int,
        @SerializedName("cell")
        var cell: String,
        @SerializedName("dob")
        var dob: Dob,
        @SerializedName("email")
        var email: String,
        @SerializedName("gender")
        var gender: String,
        @SerializedName("id")
        var id: Id,
        @SerializedName("location")
        var location: Location,
        @SerializedName("login")
        var login: Login,
        @SerializedName("name")
        var name: Name,
        @SerializedName("nat")
        var nat: String,
        @SerializedName("phone")
        var phone: String,
        @SerializedName("picture")
        var picture: Picture,
        @SerializedName("registered")
        var registered: Registered
    )

    @TypeConverters(DobConverter::class)
    data class Dob(
        @SerializedName("age")
        var age: Int,
        @SerializedName("date")
        var date: String
    )

    @TypeConverters(IdConverter::class)
    data class Id(
        @SerializedName("name")
        var name: String,
        @SerializedName("value")
        var value: String
    )

    @TypeConverters(LocationConverter::class)
    data class Location(
        @SerializedName("city")
        var city: String,
        @SerializedName("coordinates")
        var coordinates: Coordinates,
        @SerializedName("country")
        var country: String,
        @SerializedName("postcode")
        var postcode: String,
        @SerializedName("state")
        var state: String,
        @SerializedName("street")
        var street: Street,
        @SerializedName("timezone")
        var timezone: Timezone
    )

    @TypeConverters(CoordinatesConverter::class)
    data class Coordinates(
        @SerializedName("latitude")
        var latitude: String,
        @SerializedName("longitude")
        var longitude: String
    )

    @TypeConverters(StreetConverter::class)
    data class Street(
        @SerializedName("name")
        var name: String,
        @SerializedName("number")
        var number: Int
    )

    @TypeConverters(TimezonConverter::class)
    data class Timezone(
        @SerializedName("description")
        var description: String,
        @SerializedName("offset")
        var offset: String
    )

    @TypeConverters(LoginConverter::class)
    data class Login(
        @SerializedName("md5")
        var md5: String,
        @SerializedName("password")
        var password: String,
        @SerializedName("salt")
        var salt: String,
        @SerializedName("sha1")
        var sha1: String,
        @SerializedName("sha256")
        var sha256: String,
        @SerializedName("username")
        var username: String,
        @SerializedName("uuid")
        var uuid: String
    )

    @TypeConverters(NameConverter::class)
    data class Name(
        @SerializedName("first")
        var first: String,
        @SerializedName("last")
        var last: String,
        @SerializedName("title")
        var title: String
    )

    @TypeConverters(PictureConverter::class)
    data class Picture(
        @SerializedName("large")
        var large: String? = " ",
        @SerializedName("medium")
        var medium: String? = " ",
        @SerializedName("thumbnail")
        var thumbnail: String? = " "
    )

    @TypeConverters(RegisterConverter::class)
    data class Registered(
        @SerializedName("age")
        var age: Int,
        @SerializedName("date")
        var date: String
    )
}
