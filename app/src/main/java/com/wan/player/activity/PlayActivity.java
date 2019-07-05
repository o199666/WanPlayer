package com.wan.player.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.wan.player.R;
import com.wan.player.base.BaseActivity;
import com.wan.player.bean.LocalDataBean;
import com.wan.player.databinding.ActivityPlayBinding;

/**
 * Created by CWJ on 2019/7/5.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class PlayActivity extends BaseActivity {
    ActivityPlayBinding binding;
    LocalDataBean localDataBean;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play);
        localDataBean = (LocalDataBean) getIntent().getSerializableExtra("localfile");
        binding.videoplayer.setVisibility(View.VISIBLE);
        binding.videoplayer.setUp(localDataBean.getFilePtah()
                , localDataBean.getFileName());
        Glide.with(this).load(localDataBean.getFileImag()).into(binding.videoplayer.thumbImageView);
        binding.videoplayer.startVideo();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }
}
