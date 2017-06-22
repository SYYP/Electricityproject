package xiangmu.bawai.com.electricityproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import xiangmu.bawai.com.electricityproject.R;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class IActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acti);
    }
}
