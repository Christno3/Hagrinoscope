package com.dicoding.hagrinoscope.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.hagrinoscope.R

class History_Fragment : Fragment() {

    private lateinit var historyAdapter: HistoryAdapter // Sesuaikan dengan adapter Anda
    private lateinit var historyRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history_, container, false)

        historyRecyclerView = view.findViewById(R.id.historyRecyclerView)

        // Inisialisasi adapter dan data dummy untuk RecyclerView
        historyAdapter = HistoryAdapter(getDummyHistoryData())

        // Setup RecyclerView
        historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        historyRecyclerView.adapter = historyAdapter

        return view
    }

    private fun getDummyHistoryData(): List<String> {
        // Mengembalikan data dummy untuk diinisialisasi dalam adapter
        return listOf(
            "Aktivitas Pertanian 1",
            "Aktivitas Pertanian 2",
            "Aktivitas Pertanian 3",
            "Aktivitas Pertanian 4",
            "Aktivitas Pertanian 5"
        )
    }
}
