package com.bb.amazebooksapi

import android.content.ClipData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Book {
    @SerializedName("kind")
    @Expose
    var kind: String? = null

    @SerializedName("totalItems")
    @Expose
    var totalItems: Int? = null

    @SerializedName("items")
    @Expose
    var items: List<ClipData.Item>? = null

}