// Camera_Fragment.kt
package com.dicoding.hagrinoscope.camera

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.dicoding.hagrinoscope.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Camera_Fragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private val REQUEST_CAMERA_PERMISSION = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_camera_, container, false)
        val scanButton: Button = view.findViewById(R.id.scanButton)
        val scanResultTextView: TextView = view.findViewById(R.id.scanResultTextView)

        scanButton.setOnClickListener {
            // Implementasikan logika pemindaian tanah dan tumbuhan di sini
            // Misalnya, menggunakan CameraX API untuk mendapatkan gambar dari kamera
            // dan menerapkan pemrosesan gambar untuk analisis tanah dan tumbuhan
            scanResultTextView.text = "Hasil Pemindaian: Tanah Subur, Tumbuhan Sehat"
            scanResultTextView.visibility = View.VISIBLE
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Memastikan izin kamera sudah diberikan sebelum menggunakan kamera
        if (allPermissionsGranted()) {
            // Inisialisasi kamera atau implementasikan fungsi pemindaian kamera di sini
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        }
    }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Camera_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
