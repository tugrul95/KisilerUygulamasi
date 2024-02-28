package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener

import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {


    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet, ","1111")
        val k2 = Kisiler(2, "Zeynep, ","1111")
        val k3 = Kisiler(3, "Beyza, ","1111")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = KisilerAdapter(requireContext(), kisilerListesi)
        binding.kisilerRv.adapter = kisilerAdapter

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())



        //Navigation.findNavController(binding.fab).navigate(R.id.kisiKayitGecis)

        binding.fab.setOnClickListener {
            Log.e("test", "çalıştı")
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//harf girdikçe ve sildikçe
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//klavyedeki
                ara(query)
                return true
            }
        })
        // Inflate the layout for this fragment
        return binding.root
    }

    fun ara(aramaKelimesi: String) {
        Log.e("Kişi ara", aramaKelimesi)
    }

}