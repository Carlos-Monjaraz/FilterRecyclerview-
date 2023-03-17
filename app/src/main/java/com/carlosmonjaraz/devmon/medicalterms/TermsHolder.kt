package com.carlosmonjaraz.devmon.medicalterms

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.carlosmonjaraz.devmon.medicalterms.databinding.ItemTermsBinding

class TermsHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemTermsBinding.bind(view)

    fun render(termsModel: TermsModel) {
        binding.txtTerm.text = termsModel.term
        binding.txtDescription.text = termsModel.description
    }
}