package com.wan.player.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wan.player.R;
import com.wan.player.activity.PlayActivity;
import com.wan.player.adapter.LocalDataAdapter1;
import com.wan.player.base.BaseFragment;
import com.wan.player.bean.LocalDataBean;
import com.wan.player.databinding.FragmentLocalBinding;
import com.wan.player.model.LoaclDataViewModel;

import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by CWJ on 2019/7/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:本地搜索文件目录
 */
public class LocalFragment extends BaseFragment {
    FragmentLocalBinding binding;
    LoaclDataViewModel localViewModel;
    LocalDataAdapter1 adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_local, container, false);
        View view = binding.getRoot();
        localViewModel= ViewModelProviders.of(this).get(LoaclDataViewModel.class);
        localViewModel.getNetData().observe(this, new Observer<List<LocalDataBean>>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onChanged(  List<LocalDataBean> localDataBeans) {
                setLocalPlay(localDataBeans);
            }
        });
        return view;
    }
    @Override
    protected void netData() {

    }
    @Override
    protected void initView() {

    }

    @SuppressLint("WrongConstant")
    public void setLocalPlay(final List<LocalDataBean> localDataBeans){
        binding.localRecyc.setLayoutManager(new LinearLayoutManager( binding.localRecyc.getContext(), LinearLayoutManager.VERTICAL,false));
        adapter=  new LocalDataAdapter1(localDataBeans,getActivity());
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        binding.localRecyc.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(getActivity(), PlayActivity.class);
                intent.putExtra("localfile",localDataBeans.get(position));
                startActivity(intent);
            }
        });
    }


}
