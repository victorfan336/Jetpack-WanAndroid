package com.win.ft_home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.win.ft_home.databinding.NavigationPageLayoutBinding
import com.win.ft_home.model.navigation.NavigationItemSub
import com.win.lib_image_loader.app.ImageLoaderManager

/**
 * Create by liwen on 2020/5/26
 */
class NavigationPageAdapter constructor(context: Context) :
    PagedListAdapter<NavigationItemSub, NavigationPageAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<NavigationItemSub>() {
            override fun areItemsTheSame(
                oldItem: NavigationItemSub,
                newItem: NavigationItemSub
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: NavigationItemSub,
                newItem: NavigationItemSub
            ): Boolean {
                return oldItem == oldItem
            }

        }
    ) {

    private val mContext = context
    private val mInflater = LayoutInflater.from(mContext)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NavigationPageLayoutBinding.inflate(mInflater, parent, false)

        return ViewHolder(binding.root, binding, mContext)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.setData(item)
    }


    class ViewHolder(
        itemView: View,
        binding: NavigationPageLayoutBinding,
        context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private val mBinding = binding
        private val mContext = context

        fun setData(item: NavigationItemSub?) {
            mBinding.itemData = item
            mBinding.context = mContext
            ImageLoaderManager.getInstance()
                .displayImageForView(mBinding.pic, item!!.envelopePic)

        }
    }
}