package com.wan.player.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.wan.player.MainActivity;
import com.wan.player.R;
import com.wan.player.adapter.LocalDataAdapter;
import com.wan.player.adapter.NetDataAdapter;
import com.wan.player.base.BaseFragment;
import com.wan.player.bean.LocalDataBean;
import com.wan.player.bean.NetDataBean;
import com.wan.player.databinding.FragmentLocalBinding;
import com.wan.player.model.LoaclDataViewModel;
import com.wan.player.model.NetDataViewModel;
import com.wan.player.utlis.FilesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_local, container, false);
        View view = binding.getRoot();
        localViewModel= ViewModelProviders.of(this).get(LoaclDataViewModel.class);
        localViewModel.getNetData().observe(this, new Observer<List<LocalDataBean>>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onChanged(List<LocalDataBean> localDataBeans) {
                binding.localRecyc.setLayoutManager(new LinearLayoutManager( binding.localRecyc.getContext(), LinearLayoutManager.VERTICAL,false));
                binding.localRecyc.setAdapter(new LocalDataAdapter(localDataBeans));
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


}
