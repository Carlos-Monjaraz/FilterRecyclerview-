package com.carlosmonjaraz.devmon.medicalterms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TermsAdapter(val listTerms: List<TermsModel>) : RecyclerView.Adapter<TermsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TermsHolder(layoutInflater.inflate(R.layout.item_terms, parent, false))
    }

    override fun onBindViewHolder(holder: TermsHolder, position: Int) {
        val item = listTerms[position]
        holder.render(item)
    }

    override fun getItemCount() = listTerms.size
}