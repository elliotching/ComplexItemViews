package com.abduaziz.complexviewitems

/**
 * Created by abduaziz on 2/5/19 at 2:07 PM.
 */

data class Attachment(val type: Int = 0) {
    companion object {
        val TYPE_PHOTO = 1
        val TYPE_MUSIC = 2
        val TYPE_CONTACT = 3
        // and other types ..
    }

    fun isPhoto() = type == TYPE_PHOTO
    fun isMusic() = type == TYPE_MUSIC
    fun isContact() = type == TYPE_CONTACT
}

data class Message(val id: Long = 0L,
                   val fromId: Long = 0L,
                   val text: String = "",
                   val attachment: Attachment = Attachment())