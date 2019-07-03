package com.wan.player.base;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by CWJ on 2019/7/2.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initDate();
    }

    /**
     * 所有初始化的空间放这个里面。
     * @param
     */
    public abstract void initView();

    /**
     * 数据初始化
     */
    public abstract void initDate();
    @Override
    public void onRestart() {
        super.onRestart();
        Logger.d(TAG, "onRestart: 重启" );
    }
}
