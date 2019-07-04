package com.wan.player.fragment;

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

import com.wan.player.MainActivity;
import com.wan.player.R;
import com.wan.player.base.BaseFragment;
import com.wan.player.bean.LocalDataBean;
import com.wan.player.bean.NetDataBean;
import com.wan.player.databinding.FragmentLocalBinding;
import com.wan.player.model.LoaclDataViewModel;
import com.wan.player.model.NetDataViewModel;

import java.io.File;
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
    String[] flieType={"MP4","flv","Mov","M3U8","Ts","RMVB","3GP","MPEG","AVI"};
    LoaclDataViewModel localViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_local, container, false);
        View view = binding.getRoot();
        localViewModel= ViewModelProviders.of(this).get(LoaclDataViewModel.class);
        localViewModel.getNetData().observe(this, new Observer<List<LocalDataBean>>() {
            @Override
            public void onChanged(List<LocalDataBean> localDataBeans) {

            }
        });
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void netData() {
        localViewModel.getFlie();

    }
    public static boolean sdCardIsAvailable() {
        //首先判断存储是否可用
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sd = new File(Environment.getExternalStorageDirectory().getPath());
           //   getRootDirectory: /system
           //   getDataDirectory: /data
           //   getExternalStorageState: /mounted  安装
           //   getExternalStorageDirectory: /storage/emulated/0  安装

            Log.e("qq", "sd = " + sd);//sd = /storage/emulated/0
            return sd.canWrite();
        } else {
            return false;
        }
    }
    @Override
    protected void initView() {
        binding.appTitle.titleTv.setText("本地视频");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,flieType);
        binding.appTitle.titleSp.setAdapter(spinnerAdapter);
    }
}
