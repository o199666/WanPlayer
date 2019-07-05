package com.wan.player.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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
public class LocalDataAdapter1 extends BaseQuickAdapter<LocalDataBean, BaseViewHolder> {
    Activity contex;
    public LocalDataAdapter1( @Nullable List<LocalDataBean> data, Activity contex) {
        super(R.layout.item_localdata1, data);
        this.contex = contex;
    }
    @Override
    protected void convert(BaseViewHolder helper, LocalDataBean item) {
        ImageView img=helper.getView(R.id.local_iv);
        TextView title=helper.getView(R.id.localtitle_tv);
        TextView size=helper.getView(R.id.localsize_tv);
        TextView time=helper.getView(R.id.localtime_tv);
            Glide
                .with(contex)
                    .load(item.getFileImag())
                    .into(img);
        title.setText(item.getFileName());
        size.setText(item.getFilePtah());
        time.setText(item.getFileTime());
    }
}
