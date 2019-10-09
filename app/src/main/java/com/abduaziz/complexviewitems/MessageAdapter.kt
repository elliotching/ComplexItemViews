package com.abduaziz.complexviewitems

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by abduaziz on 2/5/19 at 2:10 PM.
 */

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val list = arrayListOf<Message>()

    init {
        list.add(Message(text = "Here is his contact", attachment = Attachment(Attachment.TYPE_CONTACT)))
        list.add(Message(text = "Listen to this", attachment = Attachment(Attachment.TYPE_MUSIC)))
        list.add(Message(text = "From my China trip", attachment = Attachment(Attachment.TYPE_PHOTO)))
        list.add(Message(text = "", attachment = Attachment(Attachment.TYPE_MUSIC)))
        list.add(Message(text = "Here is her contact", attachment = Attachment(Attachment.TYPE_PHOTO)))
    }

    override fun getItemViewType(position: Int): Int {
        val message = list[position]
        var flags = 0

        if (message.attachment.isPhoto()) {
            flags = flags or 1
            Log.d("tag", flags.toString())
        }

        if (message.attachment.isMusic()) {
            flags = flags or 2
            Log.d("tag", flags.toString())
        }

        if (message.attachment.isContact()) {
            flags = flags or 4
            Log.d("tag", flags.toString())
        }

        if (message.text.isNotBlank()) {
            flags = flags or 8
            Log.d("tag", flags.toString())
        }

        return flags
    }


    override fun onCreateViewHolder(parent: ViewGroup, itemViewType: Int): MessageViewHolder {
        val messageParent = LinearLayout(parent.context)
        messageParent.orientation = LinearLayout.VERTICAL
        messageParent.setPadding(0,0,0,80)

        if (itemViewType and 1 >= 1){
            // here, you should add ImageView
            // for the sake of easiness, let me add simple textview
            val tvPhoto = TextView(parent.context)
            tvPhoto.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
            tvPhoto.text = "Photo message"
            messageParent.addView(tvPhoto)
        }

        if (itemViewType and 2 >= 1){
            // add textView with "music"
            val tvMusic = TextView(parent.context)
            tvMusic.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
            tvMusic.text = "Awesome music.mp3"
            messageParent.addView(tvMusic)
        }

        if (itemViewType and 4 >= 1){
            // contact
            val tvContact = TextView(parent.context)
            tvContact.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
            tvContact.text = "Sherlock Holmes +1000-000-00-00"
            messageParent.addView(tvContact)
        }

        if (itemViewType and 8 >= 1){
            // add textview
            val tvText = TextView(parent.context)
            tvText.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
            tvText.text = "Hey, how are you doing?"
            messageParent.addView(tvText)
        }

        return MessageViewHolder(messageParent)
    }

    override fun onBindViewHolder(p0: MessageViewHolder, p1: Int) {
        // todo
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}