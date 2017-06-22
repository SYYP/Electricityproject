package xiangmu.bawai.com.electricityproject;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import xiangmu.bawai.com.electricityproject.fragment.CateGoryFragment;
import xiangmu.bawai.com.electricityproject.fragment.HomeFragment;
import xiangmu.bawai.com.electricityproject.fragment.LepinFragment;
import xiangmu.bawai.com.electricityproject.fragment.MyBuyFragment;
import xiangmu.bawai.com.electricityproject.fragment.ShoppFragment;


/*
主页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton tabHome;
    private RadioButton tabCategory;
    private RadioButton tabLepin;
    private RadioButton tabShopping;
    private RadioButton tabMyBuy;
    private FrameLayout realContent;
    private Fragment currentf;
    private HomeFragment hf;
    private CateGoryFragment gf;
    private LepinFragment lf;
    private ShoppFragment sf;
    private MyBuyFragment my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragments(new HomeFragment());


    }


    private void initView() {
        tabHome = (RadioButton) findViewById(R.id.tabHome);
        tabCategory = (RadioButton) findViewById(R.id.tabCategory);
        tabLepin = (RadioButton) findViewById(R.id.tabLepin);
        tabShopping = (RadioButton) findViewById(R.id.tabShopping);
        tabMyBuy = (RadioButton) findViewById(R.id.tabMyBuy);
        realContent = (FrameLayout) findViewById(R.id.realContent);
        tabHome.setOnClickListener(this);
        tabCategory.setOnClickListener(this);
        tabLepin.setOnClickListener(this);
        tabShopping.setOnClickListener(this);
        tabMyBuy.setOnClickListener(this);
    }

    private void addFragments(Fragment f) {
        // 第一步：得到fragment管理类
        FragmentManager manager = getSupportFragmentManager();
        // 第二步：开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();

        if (currentf != null) {
            //每次把前一个fragment给隐藏了
            transaction.hide(currentf);
        }

        //isAdded:判断当前的fragment对象是否被加载过
        if (!f.isAdded()) {
            // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
            transaction.add(R.id.realContent, f);
        }
        //显示当前的fragment
        transaction.show(f);

        // 第四步：提交
        transaction.commit();

        currentf = f;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tabHome:
                if(hf==null){
                    hf=new HomeFragment();
                }

                addFragments(hf);
                break;

            case R.id.tabCategory:
                if(gf==null){
                    gf=new CateGoryFragment();
                }

                addFragments(gf);
                break;

            case R.id.tabLepin:
                if(lf==null){
                    lf=new LepinFragment();
                }

                addFragments(lf);
                break;

            case R.id.tabShopping:
                if(sf==null){
                    sf=new ShoppFragment();
                }

                addFragments(sf);
                break;
            case R.id.tabMyBuy:
                if(my==null){
                    my=new MyBuyFragment();
                }

                addFragments(my);
                break;
        }
    }
}
