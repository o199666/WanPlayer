package com.wan.player.model;

import android.os.Environment;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wan.player.bean.LocalDataBean;
import com.wan.player.bean.NetDataBean;
import com.wan.player.utlis.FilesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.wan.player.utlis.FilesUtil.getVideoFile;

public class LoaclDataViewModel extends ViewModel {
    private MutableLiveData<List<LocalDataBean>> data;

    public MutableLiveData<List<LocalDataBean>> getNetData() {
        if (null == data) {
            data = new MutableLiveData<>();
        }
        getFlie();
        return data;
    }


    File sd = new File(Environment.getExternalStorageDirectory().getPath());

    public void getFlie() {
        Log.d("获取的路径", sd + "");
        FileThread thread = new FileThread();
        thread.start();

    }
    public class FileThread extends Thread {
        @Override
        public void run() {
            super.run();
            List<LocalDataBean> localDataBeans = new ArrayList<>();
            data.postValue(getVideoFile(localDataBeans, sd));
        }
    }
}



