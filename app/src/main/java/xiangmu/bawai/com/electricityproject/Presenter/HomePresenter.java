package xiangmu.bawai.com.electricityproject.Presenter;

import android.view.View;

import java.util.List;

import xiangmu.bawai.com.electricityproject.Module.HomeFragmentMpdule;
import xiangmu.bawai.com.electricityproject.Module.IhomeFragmentmodle;
import xiangmu.bawai.com.electricityproject.View.IHomeFragmentview;
import xiangmu.bawai.com.electricityproject.base.BasePresnter;
import xiangmu.bawai.com.electricityproject.bean.Titlebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class HomePresenter extends BasePresnter<IHomeFragmentview>{

      private HomeFragmentMpdule homeFragmentMpdule;

    public HomePresenter(){
        homeFragmentMpdule=new HomeFragmentMpdule();

    }

       //拿到moudle的数据
     public void getdata(int index){
         homeFragmentMpdule.getdata( index,new IhomeFragmentmodle.IndexFragmentModelListener() {
             @Override
             public void onSuccess(List<Titlebean.DataBean> list) {
                view.onSuccess(list);
             }

             @Override
             public void onFailed() {
              view.onFailed();
             }
         });
     }
}
