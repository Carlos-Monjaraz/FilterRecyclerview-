package com.carlosmonjaraz.devmon.medicalterms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosmonjaraz.devmon.medicalterms.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMedicalTerms.layoutManager = LinearLayoutManager(this)
        binding.rvMedicalTerms.adapter = TermsAdapter(Provider.listMedicalTerms)
    }
}