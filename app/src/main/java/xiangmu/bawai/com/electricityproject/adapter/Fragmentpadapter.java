package xiangmu.bawai.com.electricityproject.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import xiangmu.bawai.com.electricityproject.bean.Titlebean;
import xiangmu.bawai.com.electricityproject.fragment.BlankFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Fragmentpadapter extends FragmentPagerAdapter {


    String [] titles = {"上新","纸尿裤","奶粉","洗护喂养","玩具","服饰","车窗","图书","车床桌椅"} ;


    public Fragmentpadapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
