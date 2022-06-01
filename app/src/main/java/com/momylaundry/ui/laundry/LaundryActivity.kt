package com.momylaundry.ui.laundry

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.momylaundry.R
import com.momylaundry.databinding.ActivityLaundryBinding
import com.momylaundry.model.LaundryModel
import com.momylaundry.ui.confirm_order.ConfirmOrderActivity
import com.momylaundry.utils.DummyData

class LaundryActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLaundryBinding
    private var data: LaundryModel?=null
    private var total:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaundryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        setRecyclerView()
        setActionButton()
    }



    private fun setToolbar() {
        setSupportActionBar(binding.toolbarLaundry.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbarLaundry.titleToolbar.text = getString(R.string.title_order_laundry)
    }

    private fun setRecyclerView() {
        binding.rvLaundry.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)
        binding.rvLaundry.setHasFixedSize(true)
        val adapterTemp = LaundryListAdapter(object: LaundryListAdapter.ItemLaundryCallback {
            override fun onAddItems(quantity: Int) {
                total += quantity
                Log.d("CHECK LAGI", quantity.toString())
                Log.d("CHECK GAIn", total.toString())
                binding.totalItems.text = getString(R.string.total_items, total.toString())
            }

        })

        adapterTemp.setData(DummyData.getListItemLaundry())
        binding.rvLaundry.adapter = adapterTemp
    }

    private fun setActionButton() {
        binding.buttonConfirmOrder.setOnClickListener {
            startActivity(Intent(this,ConfirmOrderActivity::class.java))
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}