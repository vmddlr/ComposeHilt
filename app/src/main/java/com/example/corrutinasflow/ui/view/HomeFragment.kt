package com.example.corrutinasflow.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corrutinasflow.data.adapter.WeatherAdapter
import com.example.corrutinasflow.data.domain.CalculateFibonacciUserCase
import com.example.corrutinasflow.data.model.SportEntity
import com.example.corrutinasflow.data.model.WeatherEntityResponse
import com.example.corrutinasflow.databinding.FragmentHomeBinding
import com.example.corrutinasflow.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    private val fibonacciUserCase = CalculateFibonacciUserCase()
    private lateinit var job : Job

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setUpEditText()

        this.viewModel.getWeatherViewModel()
        this.viewModel.mldWeather.observe(viewLifecycleOwner, {
            this.formatGradeCelsius(it)
        })

        this.viewModel.getSportListViewModel()
        this.viewModel.mldSport.observe(viewLifecycleOwner, {
            this.setUpRecyclerView(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()

        if(this.job.isActive){
            job.cancel()
        }
    }

    private fun setUpRecyclerView(list: List<SportEntity>) {
        this.binding.rvSport.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
            adapter = WeatherAdapter(list)
        }
    }

    private fun setUpEditText() {
        this.binding.tieNumber.addTextChangedListener { n ->
            if(this::job.isInitialized && this.job.isActive){
                this.job.cancel()
            }

            this.binding.tvResult.text = "Calculando..."
            val time = System.currentTimeMillis()

            job = CoroutineScope(Job()).launch(Dispatchers.Default) {
                if (n!!.isNotEmpty()) {
                    val fib = fibonacciUserCase.getCalculateFibonacci(n.toString().toLong())
                    withContext(Dispatchers.Main){
                        this@HomeFragment.binding.tvResult.text =
                            "R=${"%,d".format(fib)}\n in ${System.currentTimeMillis() - time} ms"
                    }

                }
            }

        }
    }

    private fun formatGradeCelsius(entity: WeatherEntityResponse) {
        val temp = "${entity.main?.temp} C"
        val name = entity.name
        val country = entity.sys?.country

        binding.tvTitle.text = "$temp in $name, $country"
    }
}