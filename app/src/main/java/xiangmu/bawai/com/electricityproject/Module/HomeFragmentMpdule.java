package xiangmu.bawai.com.electricityproject.Module;

import com.google.gson.Gson;

import java.util.List;

import xiangmu.bawai.com.electricityproject.bean.Titlebean;
import xiangmu.bawai.com.electricityproject.network.BaseObserable;
import xiangmu.bawai.com.electricityproject.network.RetrofitFactory;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class HomeFragmentMpdule implements IhomeFragmentmodle  {
/*
首页{

纸尿裤：http://lib.suning.com/app/redbaby/babydiapers-64.json
奶粉：{http://lib.suning.com/app/version/babymilk.json  查询工具 ，其他都是 频道名.json
http://lib.suning.com/app/redbaby/babymilk-41.json 注意可能截取字符串}
洗喂护养：http://lib.suning.com/app/redbaby/BabyBottles-56.json
玩具：http://lib.suning.com/app/redbaby/babytoys-50.json
服饰：http://lib.suning.com/app/redbaby/babyclothes-49.json
图书：http://lib.suning.com/app/redbaby/babybooks-39.json
车床座椅：http://lib.suning.com/app/redbaby/babycarriage-35.json

}
 */
private String [] url = {
        "http://lib.suning.com/app/redbaby/babydiapers-64.json",
        "http://lib.suning.com/app/redbaby/babymilk-41.json",
        "http://lib.suning.com/app/redbaby/BabyBottles-56.json",
        "http://lib.suning.com/app/redbaby/babytoys-50.json",
        "http://lib.suning.com/app/redbaby/babyclothes-49.json",
        "http://lib.suning.com/app/redbaby/babybooks-39.json",
        "http://lib.suning.com/app/redbaby/babycarriage-35.json"} ;

    public void getdata( int index,final IndexFragmentModelListener listener) {
        RetrofitFactory.get(url[index], new BaseObserable() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Titlebean titlebean = gson.fromJson(result, Titlebean.class);
                List<Titlebean.DataBean> data = titlebean.getData();
                listener.onSuccess(data);
            }

            @Override
            public void onFailed() {
             listener.onFailed();
            }
        }) ;

    }
}
