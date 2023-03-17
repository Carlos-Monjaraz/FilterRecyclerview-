package com.carlosmonjaraz.devmon.medicalterms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TermsAdapter(var medicalTermsList: List<TermsModel>) : RecyclerView.Adapter<TermsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TermsHolder(layoutInflater.inflate(R.layout.item_terms, parent, false))
    }

    override fun onBindViewHolder(holder: TermsHolder, position: Int) {
        val item = medicalTermsList[position]
        holder.render(item)
    }

    override fun getItemCount() = medicalTermsList.size

    fun updateList(listTerms: List<TermsModel>) {
        this.medicalTermsList = listTerms
        notifyDataSetChanged()
    }
}