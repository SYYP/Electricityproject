package xiangmu.bawai.com.electricityproject.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


import xiangmu.bawai.com.electricityproject.Presenter.HomePresenter;
import xiangmu.bawai.com.electricityproject.R;
import xiangmu.bawai.com.electricityproject.View.IHomeFragmentview;
import xiangmu.bawai.com.electricityproject.adapter.Fragmentpadapter;
import xiangmu.bawai.com.electricityproject.base.BaseMvpFragment;
import xiangmu.bawai.com.electricityproject.base.IFragment;
import xiangmu.bawai.com.electricityproject.bean.Titlebean;

public class HomeFragment extends IFragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);

        return view;

    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) view.findViewById(R.id.first_viewpager);
          Fragmentpadapter fragmentPagerAdapter=new Fragmentpadapter(getChildFragmentManager());
            viewPager.setAdapter(fragmentPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
