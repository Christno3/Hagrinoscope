package com.dicoding.hagrinoscope.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.hagrinoscope.R

class HistoryAdapter(private val historyData: List<String>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val historyItemTextView: TextView = itemView.findViewById(R.id.historyTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history_, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyItem = historyData[position]
        holder.historyItemTextView.text = historyItem
    }

    override fun getItemCount(): Int {
        return historyData.size
    }
}
