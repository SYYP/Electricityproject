package xiangmu.bawai.com.electricityproject.base;

import android.app.Application;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class IApplication extends Application {
    public static IApplication application ;
    @Override
    public void onCreate() {
        super.onCreate();
          application=this;
    }
}
