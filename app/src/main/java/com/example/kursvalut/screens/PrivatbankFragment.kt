package com.example.kursvalut.screens

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.kursvalut.R
import com.example.kursvalut.data.check_internet.isOnline
import kotlinx.android.synthetic.main.fragment_privatbank.view.*
import kotlinx.android.synthetic.main.fragment_privatbank.view.no_internet_layout2

class PrivatbankFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PrivatbankAdapter
    private val viewModel: SecondViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_privatbank, container, false)
        sync(view)
        viewModel.signalOnRefresh.observe(viewLifecycleOwner) {
            sync(view)
        }
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun sync(view: View) {
        if (isOnline(requireContext())) {
            view.rv_privat.visibility = View.VISIBLE
            view.no_internet_layout2.visibility = View.GONE
            val viewModel = ViewModelProvider(this)[FirstViewModel::class.java]
            recyclerView = view.rv_privat
            adapter = PrivatbankAdapter()
            recyclerView.adapter = adapter
            viewModel.getPrivatCurrency()
            viewModel.privatList.observe(viewLifecycleOwner) { list ->
                list.body()?.let { adapter.updateList(it) }
            }
        } else {
            view.rv_privat.visibility = View.GONE
            view.no_internet_layout2.visibility = View.VISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PrivatbankFragment()
    }
}