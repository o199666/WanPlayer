package com.wan.player.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.wan.player.R;
import com.wan.player.adapter.NetDataAdapter1;
import com.wan.player.base.BaseFragment;
import com.wan.player.bean.NetDataBean;
import com.wan.player.databinding.FragmentNetBinding;
import com.wan.player.model.NetDataViewModel;

import java.util.List;

/**
 * Created by CWJ on 2019/7/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class NetFragment extends BaseFragment {
    FragmentNetBinding binding;
    NetDataViewModel viewModel;
    String [] ciliType={
            "磁力一",//BT蚂蚁
            "磁力二",//BT酷
            "磁力三 ",//蜘蛛搜索
            "磁力四"//屌丝搜
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_net, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(this).get(NetDataViewModel.class);
        viewModel.getNetData().observe(this, new Observer<List<NetDataBean>>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onChanged(List<NetDataBean> netDataBeans) {
                binding.recyView.setLayoutManager(new LinearLayoutManager( binding.recyView.getContext(), LinearLayoutManager.VERTICAL,false));
                binding.recyView.setAdapter(new NetDataAdapter1(netDataBeans,getActivity()));
            }
        });
        binding.recyView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "下载了"+position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void startMyThread() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void netData() {
        binding.sosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyThread();
            }
        });


    }
    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        binding.appTitle.titleTv.setText("磁力搜索");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,ciliType);
        binding.appTitle.titleSp.setAdapter(spinnerAdapter);
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            viewModel.queryNetDataList(binding.sosEt.getText().toString().trim());
        }
    }

}
