package com.chethan.userlogin.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.chethan.userlogin.R
import com.chethan.userlogin.common.DataBoundListAdapter
import com.chethan.userlogin.databinding.DataItemBinding
import com.chethan.userlogin.model.UserInfo

/**
 * Created by Chethan on 5/2/2019.
 */

class DataAdapter(
    private val dataBindingComponent: DataBindingComponent, private val callback: ((UserInfo) -> Unit)?
) :
    DataBoundListAdapter<UserInfo, DataItemBinding>(diffCallback = object : DiffUtil.ItemCallback<UserInfo>() {

        override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
            return oldItem.firstName == newItem.firstName
        }

        override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
            return oldItem.firstName == newItem.firstName
                    && oldItem.secondName == newItem.secondName
        }

    }
    ) {
    override fun createBinding(parent: ViewGroup): DataItemBinding {
        val binding = DataBindingUtil
            .inflate<DataItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.data_item,
                parent,
                false,
                dataBindingComponent
            )

        binding.root.setOnClickListener {
            binding.userInfo?.let {
                callback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: DataItemBinding, item: UserInfo) {
        binding.userInfo = item
    }

}