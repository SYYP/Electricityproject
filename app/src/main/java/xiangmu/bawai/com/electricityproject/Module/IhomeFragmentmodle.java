package xiangmu.bawai.com.electricityproject.Module;

import java.util.List;

import xiangmu.bawai.com.electricityproject.bean.Titlebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public interface IhomeFragmentmodle {

    void getdata(int index,IndexFragmentModelListener listener);

    interface IndexFragmentModelListener {

        public void onSuccess( List<Titlebean.DataBean> list);
        public void onFailed();


    }
}
