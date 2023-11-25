package com.example.atividadereflexiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atividadereflexiva.databinding.ActivitySobreBinding

class SobreActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySobreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}