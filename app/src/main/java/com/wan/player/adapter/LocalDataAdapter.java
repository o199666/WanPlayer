package com.wan.player.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wan.player.BR;
import com.wan.player.R;
import com.wan.player.bean.LocalDataBean;

import java.util.List;

/**
 * Created by CWJ on 2019/7/4.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class LocalDataAdapter extends RecyclerView.Adapter<LocalDataAdapter.LocalHolder> {
    private List<LocalDataBean> localDataBeanList;

    public LocalDataAdapter(List<LocalDataBean> localDataBeanList) {
        this.localDataBeanList = localDataBeanList;
    }

    @NonNull
    @Override
    public LocalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_localdata, parent, false);
        return new LocalDataAdapter.LocalHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull LocalHolder holder, int position) {
        holder.binding.setVariable(BR.localdata, localDataBeanList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return localDataBeanList.size();
    }

    class LocalHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        public LocalHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
