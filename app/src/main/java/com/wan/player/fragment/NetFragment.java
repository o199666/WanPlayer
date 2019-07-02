package com.wan.player.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.wan.player.R;
import com.wan.player.base.BaseFragment;
import com.wan.player.databinding.FragmentNetBinding;

/**
 * Created by CWJ on 2019/7/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class NetFragment extends BaseFragment {
    FragmentNetBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_net, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    protected void netData() {

    }
    @Override
    protected void initView() {

    }
}
