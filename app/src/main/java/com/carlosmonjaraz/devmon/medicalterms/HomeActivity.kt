package com.carlosmonjaraz.devmon.medicalterms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosmonjaraz.devmon.medicalterms.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    private var medicalTermsList : MutableList<TermsModel> = Provider.listMedicalTerms.toMutableList()
    private lateinit var adapter : TermsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        initRecyclerView()
    }

    private fun initListener() {
        binding.svTerm.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(newText: String?) : Boolean {
                searchByTerm(newText.orEmpty())
                return false
            }
        })
    }

    private fun initRecyclerView() {
        adapter = TermsAdapter(medicalTermsList)

        binding.rvMedicalTerms.layoutManager = LinearLayoutManager(this)
        binding.rvMedicalTerms.adapter = adapter
    }

    private fun searchByTerm(term: String) {
        val listFilter = medicalTermsList.filter {
            termModel -> termModel.term.lowercase().contains(term.lowercase())
        }
        setVisibilityComponent(listFilter.isEmpty())
        adapter.updateList(listFilter)
    }

    private fun setVisibilityComponent(visibility: Boolean) {
        binding.llEmpty.isVisible = visibility
        binding.rvMedicalTerms.isVisible = !visibility
    }
}