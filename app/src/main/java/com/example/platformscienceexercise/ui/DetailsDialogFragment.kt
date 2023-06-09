package com.example.platformscienceexercise.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.platformscienceexercise.R
import com.example.platformscienceexercise.databinding.DialogDesignBinding
import com.example.platformscienceexercise.ui.model.MaxSuitabilityUI

class DetailsDialogFragment (private val item: MaxSuitabilityUI): DialogFragment() {

    private lateinit var binding : DialogDesignBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogDesignBinding.inflate(layoutInflater)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding.apply {
                this.tvDriverName.text = item.driver.name
                this.tvDriverLastName.text = item.driver.lastName
                val fullAddress = getString(R.string.str_full_address, item.shipment.zipCode.toString(), item.shipment.address)
                this.tvShipmentAddress.text = fullAddress
                val maxSuit = getString(R.string.str_max_suitability, item.maxSuitability.toString())
                this.tvMaxSuitability.text = maxSuit
            }

            builder.setView(binding.root).apply {
             this.setPositiveButton(R.string.str_positive_dialog) { _, _ -> dialog?.dismiss() }
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}