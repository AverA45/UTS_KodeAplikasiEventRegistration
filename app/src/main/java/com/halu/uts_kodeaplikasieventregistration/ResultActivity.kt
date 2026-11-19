package com.halu.uts_kodeaplikasieventregistration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val ringkasan = findViewById<TextView>(R.id.tvRingkasan)
        val totalView = findViewById<TextView>(R.id.tvTotal)
        val satu: String? = intent.getStringExtra("EXTRA_NAMA") // PENJELASAN TODO-11: terima String pertama dari putExtra di MainActivity
        val dua: String? = intent.getStringExtra("EXTRA_EVENT") // PENJELASAN TODO-12: terima String kedua dari putExtra di MainActivity
        val jumlah: Int = intent.getIntExtra("EXTRA_TIKET", 0) // PENJELASAN TODO-13: terima Int (bukan getStringExtra) dari putExtra di MainActivity
        val total: Int = intent.getIntExtra("EXTRA_TARIF", 0) // PENJELASAN TODO-14: terima Int total dari putExtra di MainActivity

        ringkasan.text = getString(R.string.teksRingkasan, satu, dua, jumlah)
        /* PENJELASAN TODO-15: tampilkan String dan jumlah pada ringkasan
                       yang berisi tentang satu: Nama Peserta
                                            dua: Nama Event
                                            Jumlah: Total Tiket
         */


        totalView.text = getString(R.string.teksTotal, total)
        /* PENJELASAN TODO-16: tampilkan total (konversi Int ke teks hanya di UI)
                                menampilkan total harga yang telah diterima,
                                kemudian dikonversi menjadi teks dengan cara
                                .text
         */
    }
}