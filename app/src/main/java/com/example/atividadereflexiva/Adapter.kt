package com.example.atividadereflexiva

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atividadereflexiva.databinding.ItemRecyclerBinding

class Adapter(var lista: MutableList<Int>) : RecyclerView.Adapter<Adapter.Holder>(){

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding: ItemRecyclerBinding = ItemRecyclerBinding.bind(itemView)

        fun bindData(pos: Int) {
            binding.pessoaId.text = (pos + 1).toString()
            binding.resultadoImc.text = "0"
            binding.btnCal.setOnClickListener {
                if(binding.altura.text.toString().trim().isEmpty() || binding.peso.text.toString().trim().isEmpty()){
                    binding.resultadoImc.text = "Erro"
                }else{
                    binding.resultadoImc.text = calcImc(binding.altura.text.toString().toDouble(), binding.peso.text.toString().toDouble())
                }
            }
        }

        private fun calcImc(altura: Double, peso: Double): String {
            var imc = peso / (altura * altura)
            return String.format("%.2f", imc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}