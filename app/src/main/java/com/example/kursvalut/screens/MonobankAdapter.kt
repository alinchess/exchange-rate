package com.example.kursvalut.screens

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kursvalut.R
import com.example.kursvalut.model.monobank.MonoCurrencyItem
import kotlinx.android.synthetic.main.item.view.*
import java.util.Currency

class MonobankAdapter : RecyclerView.Adapter<MonobankAdapter.MonoHolder>() {

    private var itemList = emptyList<MonoCurrencyItem>()
    private val currencyCodes = Currency.getAvailableCurrencies()

    class MonoHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MonoHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: MonoHolder, position: Int) {
        val currencyName = getCurrencyName(itemList[position].currencyCodeA)
        val currencyNameBase = getCurrencyName(itemList[position].currencyCodeB)
        holder.itemView.tv_currency_name.text = "$currencyName | $currencyNameBase"
        holder.itemView.tv_currency_buy_value.text = with(itemList[position]) {
            if(rateBuy == 0.0) "-" else rateBuy.toString()
        }
            holder.itemView.tv_currency_sell_value.text = with(itemList[position]) {
                if(rateSell == 0.0) "-" else rateSell.toString()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<MonoCurrencyItem>) {
        itemList = list
        notifyDataSetChanged()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getCurrencyName(numericCode: Int): String {
        val currency = currencyCodes.filter { it.numericCode == numericCode }
        if (currency.isEmpty()) {
            throw Exception("Nu such currency with numeric code $numericCode")
        }
        return currency[0].currencyCode
    }

}