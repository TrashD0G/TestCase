package com.artem.testcase.POJO

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RegresPOJO : Serializable {

    @SerializedName("data")
    var users: List<Data>? = null

}


class Data: Serializable{

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("email")
    var email: String = "null"

    @SerializedName("first_name")
    var firstName: String = "null"

    @SerializedName("last_name")
    var lastName: String = "null"

    @SerializedName("avatar")
    var avatar: String = "null"

}

