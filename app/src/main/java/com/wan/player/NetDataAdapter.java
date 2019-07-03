package com.wan.player;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wan.player.bean.NetDataBean;

import java.util.List;


/**
 * Created by CWJ on 2019/7/3.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class NetDataAdapter extends RecyclerView.Adapter<NetDataAdapter.NetViewHolder> {
    private List<NetDataBean> list;

    public NetDataAdapter(List<NetDataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itme_netdata, parent, false);
        return new NetViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NetViewHolder holder, int position) {
        holder.binding.setVariable(BR.netdata, list.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NetViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        public NetViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
