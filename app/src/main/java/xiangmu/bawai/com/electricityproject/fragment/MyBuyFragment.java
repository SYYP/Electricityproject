package xiangmu.bawai.com.electricityproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xiangmu.bawai.com.electricityproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyBuyFragment extends Fragment {


    public MyBuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_buy, container, false);
    }

}
