package com.example.kursvalut.screens

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kursvalut.R
import com.example.kursvalut.model.privatbank.PrivatCurrencyItem
import kotlinx.android.synthetic.main.item.view.*

class PrivatbankAdapter : RecyclerView.Adapter<PrivatbankAdapter.PrivatHolder>() {

    private var itemList = ArrayList<PrivatCurrencyItem>()

    class PrivatHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrivatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PrivatHolder(view)
    }

    override fun onBindViewHolder(holder: PrivatHolder, position: Int) {
        holder.itemView.tv_currency_name.text = with(itemList[position]){"$ccy | $base_ccy"}
        holder.itemView.tv_currency_buy_value.text = itemList[position].buy
        holder.itemView.tv_currency_sell_value.text = itemList[position].sale
    }

    override fun getItemCount(): Int = itemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: ArrayList<PrivatCurrencyItem>) {
        itemList = list
        notifyDataSetChanged()
    }
}