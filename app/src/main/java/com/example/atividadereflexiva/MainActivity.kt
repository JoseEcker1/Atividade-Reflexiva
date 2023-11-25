package com.example.atividadereflexiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atividadereflexiva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        var n1 = binding.editTextNumber1.text
        var n2 = binding.editTextNumber2.text

        binding.button1.setOnClickListener {

            if(n1.toString().isEmpty() || n2.toString().isEmpty()){
                binding.textView2.text = "Resultado = Erro"
            } else{
                var resultado = Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString())
                binding.textView2.text = "Resultado = $resultado"
            }
        }

        binding.button2.setOnClickListener{
            if(n1.toString().isEmpty() || n2.toString().isEmpty()){
                binding.textView2.text = "Resultado = Erro"
            } else{
                var resultado = Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString())
                binding.textView2.text = "Resultado = $resultado"
            }
        }

        binding.button3.setOnClickListener {
            if(n1.toString().isEmpty() || n2.toString().isEmpty()){
                binding.textView2.text = "Resultado = Erro"
            } else{
                var resultado = (Integer.parseInt(n1.toString()) - Integer.parseInt(n2.toString()))
                binding.textView2.text = "Resultado = $resultado"
            }
        }

        binding.button4.setOnClickListener {
            if(n1.toString().isEmpty() || n2.toString().isEmpty()){
                binding.textView2.text = "Resultado = Erro"
            } else{
                var resultado = (n1.toString().toDouble() / n2.toString().toDouble())
                binding.textView2.text = String.format("Resultado = %.2f", resultado)
            }
        }

    }
}