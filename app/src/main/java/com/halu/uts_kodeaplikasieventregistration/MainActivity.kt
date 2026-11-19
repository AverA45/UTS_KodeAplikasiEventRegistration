package com.halu.uts_kodeaplikasieventregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val satu = findViewById<EditText>(R.id.etSatu)
        val dua = findViewById<EditText>(R.id.etDua)
        val jumlahView = findViewById<EditText>(R.id.etJumlah)
        val tombol = findViewById<Button>(R.id.btnHitung)

        tombol.setOnClickListener {
            val teksSatu = satu.text.toString().trim()
            val teksDua = dua.text.toString().trim()
            val jumlah = jumlahView.text.toString().trim()
            val jumlahInt = jumlah.toInt()
            // PENJELASAN TODO-01: Konversi aman ke int melalui string terlebih dahulu yang kemudian diubah menjadi Int dengan .Int()

            val tarif: Int = 75000
            val total: Int = jumlahInt * tarif /* PERBAIKAN FIXME-04: hitung dengan operasi perkalian Int
                                                            dengan rumus jumlah tiket x harga tarif
                                                            disini perlu digarisbawahi bahwa jumlah tiket
                                                            harus diubah ke Int terlebih dahulu agar proses
                                                            berhasil
                                                */

            if (teksSatu.isEmpty()) {
                satu.error = "Nama Peserta harus diisi!"
                Toast.makeText(this, "Isi Nama Anda terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
            else if (teksDua.isEmpty()) {
                    dua.error = "Nama Event harus diisi!"
                    Toast.makeText(this, "Isi Nama Event terlebih dahulu!", Toast.LENGTH_SHORT).show()
                }
                else if (jumlah.isEmpty()) {
                        jumlahView.error = "Jumlah tiket harus diisi!"
                        Toast.makeText(this, "Isi jumlah tiket terlebih dahulu!", Toast.LENGTH_SHORT).show()
                    } // PENJELASAN: sekaligus saya tambah validasi ketiga agar jumlah tiket tidak kosong
            /* PENJELASAN TODO-02: validasi kedua (saya tambah 1 lagi untuk jumlah tiket)
                           String tidak kosong; beri error dengan menggunakan .error = "pesan"
                           dan hentikan proses
            */

                    else {
                        if (jumlahInt < 1) {
                            jumlahView.error = "Jumlah tiket hanya bisa 1-10"
                            Toast.makeText(this, "Isi jumlah tiket yang ingin dibeli antara 1-10", Toast.LENGTH_SHORT).show()
                        }
                        else if (jumlahInt > 10) {
                                jumlahView.error = "Jumlah tiket hanya bisa 1-10"
                                Toast.makeText(this, "Isi jumlah tiket yang ingin dibeli antara 1-10", Toast.LENGTH_SHORT).show()
                            } /* PENJELASAN TODO-03: validasi Int dalam rentang 1..10
                                        Pengkondisian tiket < 1 dan tiket > 10
                                        User hanya bisa input 1 hingga 10
                              */
                              else {
                                    val intent = Intent(
                                        this,
                                        ResultActivity::class.java
                                    ) // TODO-05: buat Explicit Intent menuju ResultActivity
                                    intent.putExtra("EXTRA_NAMA", teksSatu) //Nama Peserta, PENJELASAN TODO-06: kirim teksSatu sebagai String
                                    intent.putExtra("EXTRA_EVENT", teksDua) //Nama Event, PENJELASAN TODO-07: kirim teksDua sebagai String
                                    intent.putExtra("EXTRA_TIKET", jumlahInt) //Jumlah Tiket, PENJELASAN TODO-08: kirim jumlah sebagai Int
                                    intent.putExtra("EXTRA_TARIF", total) //Total Tarif, PENJELASAN TODO-09: kirim total sebagai Int
                                    startActivity(intent) // PENJELASAN TODO-10: Memulai untuk buka Activity tujuan
                              }
                        }
        }
    }
}

