package com.bb.amazebooksapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccessInfo<Epub, Pdf> {
    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("viewability")
    @Expose
    var viewability: String? = null

    @SerializedName("embeddable")
    @Expose
    var embeddable: Boolean? = null

    @SerializedName("publicDomain")
    @Expose
    var publicDomain: Boolean? = null

    @SerializedName("textToSpeechPermission")
    @Expose
    var textToSpeechPermission: String? = null

    @SerializedName("epub")
    @Expose
    var epub: Epub? = null
        private set

    @SerializedName("pdf")
    @Expose
    var pdf: Pdf? = null
        private set

    @SerializedName("webReaderLink")
    @Expose
    var webReaderLink: String? = null

    @SerializedName("accessViewStatus")
    @Expose
    var accessViewStatus: String? = null

    @SerializedName("quoteSharingAllowed")
    @Expose
    var quoteSharingAllowed: Boolean? = null

    fun setEpub(epub: Epub) {
        this.epub = epub
    }

    fun setPdf(pdf: Pdf) {
        this.pdf = pdf
    }

}