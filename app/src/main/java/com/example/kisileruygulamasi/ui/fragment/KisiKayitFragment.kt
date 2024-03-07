package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class KisiKayitFragment : Fragment() {

private lateinit var viewModel: KisiKayitViewModel
    private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            viewModel.kaydet(kisi_ad, kisi_tel)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    fun kaydet(kisi_ad: String, kisi_tel: String) {
    Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}