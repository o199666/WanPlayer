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
    String [] cili={
            "http://www.btakt.com/search/%E5%9C%B0%E6%96%B9-first-asc-1",//BT蚂蚁
            "https://www.btku1.com/search-%E7%8A%AC%E5%A4%9C%E5%8F%89-0-0-1.html",//BT酷
            "http://www.zhizhu11.com/so/%E6%97%A0%E9%97%B4%E9%81%93-first-asc-1",//蜘蛛搜索
            "http://www.diaosisou8.com/list/%E9%98%BF%E8%90%A8%E5%BE%B7/2/time_d"//屌丝搜
    };
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
