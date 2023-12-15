// Chat_Fragment.kt
package com.dicoding.hagrinoscope.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.hagrinoscope.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Chat_Fragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var chatAdapter: ChatAdapter // Sesuaikan dengan adapter Anda
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSendMessage: Button
    private lateinit var chatRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        // Inisialisasi adapter dan data dummy untuk RecyclerView
        chatAdapter = ChatAdapter(getDummyChatData().toMutableList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat_, container, false)

        editTextMessage = view.findViewById(R.id.editTextMessage)
        buttonSendMessage = view.findViewById(R.id.buttonSendMessage)
        chatRecyclerView = view.findViewById(R.id.chatRecyclerView)

        // Setup RecyclerView
        chatRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        chatRecyclerView.adapter = chatAdapter

        buttonSendMessage.setOnClickListener {
            // Tambahkan logika untuk mengirim pesan ke RecyclerView di sini
            val newMessage = editTextMessage.text.toString()
            chatAdapter.addMessage(newMessage)
            editTextMessage.text.clear()
        }

        return view
    }

    private fun getDummyChatData(): List<String> {
        // Mengembalikan data dummy untuk diinisialisasi dalam adapter
        return listOf(
            "Hello!",
            "How are you?",
            "I'm doing well, thank you!",
            "What about you?",
            "Let's chat about agriculture!"
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Chat_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
