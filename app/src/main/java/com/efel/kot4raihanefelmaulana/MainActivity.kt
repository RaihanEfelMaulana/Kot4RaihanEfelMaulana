package com.efel.kot4raihanefelmaulana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var nama:EditText
    lateinit var datePicker: DatePicker
    lateinit var btnproses: Button
    lateinit var output : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nama = findViewById(R.id.edittitle)
        datePicker = findViewById(R.id.datepicker)
        btnproses = findViewById(R.id.btnproses)
        output = findViewById(R.id.txtoutput)

        val tglSekarang = Calendar.getInstance()
        val initTanggal = datePicker.init(
            tglSekarang.get(Calendar.YEAR),
            tglSekarang.get(Calendar.MONTH),
            tglSekarang.get(Calendar.DAY_OF_MONTH)
        ) { datePicker, year, month, day ->
            val month = month+1
            val tglDipilih = "$day - $month -$year"
            Toast.makeText(this@MainActivity, tglDipilih, Toast.LENGTH_SHORT).show()

            btnproses.setOnClickListener {
                val nmbarang = nama.text.toString()
                val out = "Detail Transaksi Pembelian\n" +
                        "Nama Barang = $nmbarang\n" +
                        "Tanggal Pembelian = $tglDipilih"
                output.text = out


            }
        }


    }
}