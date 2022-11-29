package com.example.kursvalut.screens

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.kursvalut.R
import com.example.kursvalut.data.check_internet.isOnline
import kotlinx.android.synthetic.main.fragment_monobank.view.*
import kotlinx.android.synthetic.main.fragment_privatbank.view.*

class MonobankFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MonobankAdapter
    private val viewModel: SecondViewModel by activityViewModels()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_monobank, container, false)
        sync(view)
        viewModel.signalOnRefresh.observe(viewLifecycleOwner) {
            sync(view)
        }
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun sync(view: View) {
        if (isOnline(requireContext())) {
            view.rv_mono.visibility = View.VISIBLE
            view.no_internet_layout.visibility = View.GONE
            val viewModel = ViewModelProvider(this)[FirstViewModel::class.java]
            recyclerView = view.rv_mono
            adapter = MonobankAdapter()
            recyclerView.adapter = adapter
            viewModel.getMonoCurrency()
            viewModel.monoList.observe(viewLifecycleOwner) { list ->
                list.body()?.let { adapter.updateList(it) }
            }
        } else {
            view.rv_mono.visibility = View.GONE
            view.no_internet_layout.visibility = View.VISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MonobankFragment()
    }
}