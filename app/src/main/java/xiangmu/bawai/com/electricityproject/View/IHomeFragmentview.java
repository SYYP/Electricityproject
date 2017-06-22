package xiangmu.bawai.com.electricityproject.View;

import java.util.List;

import xiangmu.bawai.com.electricityproject.bean.Titlebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public interface IHomeFragmentview {
    public void onSuccess( List<Titlebean.DataBean> list);

    public void onFailed();
}
