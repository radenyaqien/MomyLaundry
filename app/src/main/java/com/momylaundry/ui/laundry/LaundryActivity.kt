package com.momylaundry.ui.laundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.momylaundry.R
import com.momylaundry.databinding.ActivityLaundryBinding
import com.momylaundry.model.LaundryModel
import com.momylaundry.ui.confirm_order.ConfirmOrderActivity
import com.momylaundry.utils.DummyData
import java.util.*

class LaundryActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLaundryBinding
    private var data: LaundryModel?=null
    private var qty:Int = 0
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

                Log.d("CHECK QTY IN ACTIVITY ", qty.toString() )
                Log.d("CHECK QTY IN  ", quantity.toString() )
                binding.totalItems.text = getString(R.string.total_items,qty.toString())
            }

            override fun onMinusItems(id: Int, quantity: Int, total: Int) {
                data?.id.let {

                }
            }

            override fun onSetQty(laundry: LaundryModel){
                qty = laundry.quantity!!
                Log.d("CHECK QTY IN SETQTY  ", laundry.quantity.toString() )
                binding.priceItem.text = getString(R.string.price_cost,qty.toString())
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