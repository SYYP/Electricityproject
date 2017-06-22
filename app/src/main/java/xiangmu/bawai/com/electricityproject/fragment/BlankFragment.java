package xiangmu.bawai.com.electricityproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xiangmu.bawai.com.electricityproject.Presenter.HomePresenter;

import xiangmu.bawai.com.electricityproject.R;
import xiangmu.bawai.com.electricityproject.View.IHomeFragmentview;
import xiangmu.bawai.com.electricityproject.adapter.HomeRecAdapter;
import xiangmu.bawai.com.electricityproject.base.BaseMvpFragment;
import xiangmu.bawai.com.electricityproject.bean.Titlebean;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends BaseMvpFragment<IHomeFragmentview,HomePresenter>implements IHomeFragmentview {
    private static final String ARG_PARAM1 = "param1";
    private int  mParam1;
    private RecyclerView recyclerview;

    public static BlankFragment newInstance(int param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        recyclerview = (RecyclerView) view.findViewById(R.id.recycletview);

        presenter.getdata(mParam1);
    }

    @Override
    public void onSuccess(List<Titlebean.DataBean> list) {
                list.remove(2);
        HomeRecAdapter homeRecAdapter=new HomeRecAdapter(getActivity(),list);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);


        recyclerview .setLayoutManager(manager);
        recyclerview .setAdapter(homeRecAdapter);
    }

    @Override
    public void onFailed() {

    }
}
