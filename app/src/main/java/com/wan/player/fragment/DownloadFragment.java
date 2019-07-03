package com.wan.player.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.wan.player.R;
import com.wan.player.base.BaseFragment;
import com.wan.player.databinding.FragmentDownloadBinding;

/**
 * Created by CWJ on 2019/7/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class DownloadFragment extends BaseFragment {
    FragmentDownloadBinding downloadBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        downloadBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_download, container, false);
        View view = downloadBinding.getRoot();
        return view;
    }

    @Override
    protected void netData() {

    }

    @Override
    protected void initView() {
        downloadBinding.appTitle.titleTv.setText("下载管理");
        downloadBinding.appTitle.titleSp.setVisibility(View.GONE);
    }
}
