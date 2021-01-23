package com.artem.testcase.repository

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "users_table")
data class Users (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val email: String,
    var firstName: String,
    var lastName: String,
    var avatar: String
) : Parcelable
