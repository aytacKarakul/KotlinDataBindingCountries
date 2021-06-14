package com.example.kotlindatabindingcountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindatabindingcountries.R
import com.example.kotlindatabindingcountries.databinding.ItemCountryBinding
import com.example.kotlindatabindingcountries.model.Country
import com.example.kotlindatabindingcountries.view.FeedFragmentDirections

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener{

    private var uuid = 0

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this

    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.findViewById<TextView>(R.id.countryUuidText).text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}