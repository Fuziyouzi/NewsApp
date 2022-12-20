package com.example.newsapp.presenter.tabs

import android.os.Bundle
import android.view.View
import com.example.newsapp.presenter.base.BaseFragment
import com.example.newsapp.R
import com.example.newsapp.databinding.MyNewsFragmetBinding
import com.example.newsapp.presenter.models.ListOfCountry
import com.example.newsapp.presenter.models.ListOfCountryImpl
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MyNewsFragment: BaseFragment<MyNewsFragmetBinding>(
    MyNewsFragmetBinding::inflate
) {
    private val listOfCountry: ListOfCountry = ListOfCountryImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        bin.btnChoose.setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.choose_country)
                .setPositiveButton(R.string.ok){_,_ ->
                    listOfCountry.getCodeOfCountry(bin.userCountry.text.toString())
                    bin.userCountry.visibility = View.VISIBLE
                }
                .setNegativeButton(R.string.cancel){dialog, _ ->
                 dialog.dismiss()
                }
                .setSingleChoiceItems(listOfCountry.getList() , 1){dialog, which ->
                    bin.userCountry.text = listOfCountry.getList()[which]
                }
                .show()
        }
    }


}