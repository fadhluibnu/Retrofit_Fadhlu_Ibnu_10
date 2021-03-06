package com.example.retrofit_fadhluibnu_10.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_fadhluibnu_10.R
import com.example.retrofit_fadhluibnu_10.adapter.ProvinceAdapter
import com.example.retrofit_fadhluibnu_10.api.RetrofitClient
import com.example.retrofit_fadhluibnu_10.model.ProvinsiResponse
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }

    private fun showProvince(){
        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instanece.getProvinsi().enqueue(object : Callback<ArrayList<ProvinsiResponse>>{
            override fun onResponse(
                call: Call<ArrayList<ProvinsiResponse>>,
                response: Response<ArrayList<ProvinsiResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}