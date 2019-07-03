package com.wan.player.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wan.player.bean.LocalDataBean;
import com.wan.player.bean.NetDataBean;

import java.io.File;
import java.util.List;

public class LoaclDataViewModel extends ViewModel {
    private MutableLiveData<List<LocalDataBean>> data;
    public MutableLiveData<List<LocalDataBean>> getNetData() {
        if (null == data) {
            data = new MutableLiveData<>();
        }
        return data;
    }
    String[] flieType={"MP4","flv","Mov","M3U8","Ts","RMVB","3GP","MPEG","AVI","mkv"};

    /**
     * 读取目录下的所有文件
     *
     * @param dir
     *            目录
     * @param fileNames
     *            保存文件名的集合
     * @return
     */
    public   void findFileList(File dir, List<String> fileNames) {
        // 判断是否存在目录
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 读取目录下的所有目录文件信息
        String[] files = dir.list();
        // 循环，添加文件名或回调自身
        for (int i = 0; i < files.length; i++) {
            File file = new File(dir, files[i]);
            // 如果文件
            if (file.isFile()) {
                // 添加文件全路径名
                fileNames.add(dir + "\\" + file.getName());
                //循环判断是否是音频文件
                for (int j = 0; j <flieType.length ; j++) {
                    if (file.getName().contains(flieType[i])){
                        fileNames.add(dir + "\\" + file.getName());
                    }

                }
            } else {// 如果是目录
                // 回调自身继续查询
                findFileList(file, fileNames);
            }
        }
    }


}



