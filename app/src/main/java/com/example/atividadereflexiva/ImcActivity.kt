package com.example.atividadereflexiva

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atividadereflexiva.databinding.ActivityImcBinding

class ImcActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: Adapter
    private lateinit var binding: ActivityImcBinding
    private var lista = mutableListOf<Int>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        recyclerView = findViewById(R.id.rv1)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        lista.add(lista.size+1)
        recyclerAdapter = Adapter(lista)
        recyclerView.adapter = recyclerAdapter

        binding.adicionar.setOnClickListener {
            lista.add(lista.size+1)
            recyclerAdapter.notifyItemInserted(lista.size-1)
            binding.numPessoas.text=lista.size.toString()
        }

        binding.remover.setOnClickListener {
            if(lista.size>1) {
                lista.removeAt(lista.size - 1)
                recyclerAdapter.notifyItemRemoved(lista.size + 1)
                binding.numPessoas.text = lista.size.toString()
            }else if(lista.size==1) {
                lista.clear()
                lista.add(lista.size+1)
                recyclerAdapter.notifyDataSetChanged()
                binding.numPessoas.text = lista.size.toString()
            }
        }
    }
}