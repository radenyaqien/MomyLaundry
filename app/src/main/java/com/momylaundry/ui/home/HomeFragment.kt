package com.momylaundry.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.momylaundry.MainActivity
import com.momylaundry.databinding.FragmentHomeBinding
import com.momylaundry.utils.DummyData
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: HomeServicesAdapter
    private lateinit var carousel:HomeCarouselAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setToolbar()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setCarousel()
    }
    private fun setToolbar(){
        (activity as MainActivity).setSupportActionBar(binding.toolbarHome)
        (activity as MainActivity).supportActionBar.let {
            it?.setDisplayShowTitleEnabled(false)
            it?.setDisplayHomeAsUpEnabled(false)
            it?.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setRecyclerView(){
        adapter = HomeServicesAdapter()
        adapter.setData(DummyData.getListService())
        binding.rvServices.setHasFixedSize(true)
        binding.rvServices.adapter = adapter
    }

    private fun setCarousel(){
        carousel = HomeCarouselAdapter()
        carousel.renewItem(DummyData.getListCarouse())
        binding.imageSlider.setSliderAdapter(carousel)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.FANTRANSFORMATION)
        binding.imageSlider.scrollTimeInSec = 4
        binding.imageSlider.startAutoCycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}