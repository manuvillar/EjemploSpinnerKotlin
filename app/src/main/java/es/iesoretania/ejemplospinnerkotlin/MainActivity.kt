package es.iesoretania.ejemplospinnerkotlin

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import es.iesoretania.ejemplospinnerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    val contenido = arrayOf("Primera", "Segunda", "Tercera")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter (this, R.layout.simple_spinner_item, contenido)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        binding.textView.textSize = 24F
        binding.textView.text = contenido[p2]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this, "No pulsado nada",Toast.LENGTH_LONG).show()
    }
}