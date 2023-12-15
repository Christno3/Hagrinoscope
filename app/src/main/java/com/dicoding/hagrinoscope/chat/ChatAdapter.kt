package com.dicoding.hagrinoscope.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.hagrinoscope.R

class ChatAdapter(private val chatData: MutableList<String>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = chatData[position]
        holder.messageTextView.text = message
    }

    override fun getItemCount(): Int {
        return chatData.size
    }

    fun addMessage(message: String) {
        chatData.add(message)
        notifyItemInserted(chatData.size - 1)
    }
}
