package com.wan.player.model;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.orhanobut.logger.Logger;
import com.wan.player.bean.NetDataBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CWJ on 2019/7/3.
 * Author:Chen
 * Email:1181620038@qq.com
 * Ver:1
 * DEC:
 */
public class NetDataViewModel extends ViewModel {
    private MutableLiveData<List<NetDataBean>> data;
    public MutableLiveData<List<NetDataBean>> getNetData() {
        if (null == data) {
            data = new MutableLiveData<>();
        }
        return data;
    }
    /**
     * 获取查询列表
     */
    List<NetDataBean> list=new ArrayList<>();
    public void queryNetDataList(String keyword)   {
        String url1 = "http://www.btakt.com/search/"+keyword+"-first-asc-1";
        try {
            Document  document = Jsoup.connect(url1)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
                    //如果是这种方式，这里务必带上
                    .header("Connection", "close")
                    //超时时间
                    .timeout(8000)
                      .get();
            Element wall=document.getElementById("wall");
            //获取标题
            Elements lie=wall.getElementsByAttributeValue("class","search-item");
            //循环每一行
            Elements titles;
            for (int i = 0; i <lie.size() ; i++) {
                  titles=lie.select("a[href]");
//                    Log.d("每一行:",""+titles.select("a[href]").get(i).f());
            }


            //获取下载链接
            Elements downs=wall.getElementsByAttributeValue("class","item-bar");
            Elements down=downs.select("a[href]");
            //获取大小
            Elements filesizes=wall.getElementsByAttributeValue("class","cpill yellow-pill");
            Elements feilesize=filesizes.select("b");
            for (int i = 0; i <down.size() ; i++) {
//                list.add(new NetDataBean(title.get(i).text(),down.get(i).attr("href"),feilesize.get(i).text()));
//                Logger.d("连接标题:"+down.get(i).text());
//                Logger.d("连接:"+down.get(i).attr("href"));
//                Logger.d("标题:"+title.get(i).getElementsByTag("a").get(0).text());
//                Logger.d("详细如路径:"+title.get(i).attr("href"));
//                Logger.d("大小:"+feilesize.get(i).text());
                data.postValue(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询详细信息，获取下载、播放链接。
     */

    public void queryNetData(String name) {
        queryNetDataList(name);
    }
}
