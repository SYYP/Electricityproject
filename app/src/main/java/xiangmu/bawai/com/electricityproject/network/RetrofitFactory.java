package xiangmu.bawai.com.electricityproject.network;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import xiangmu.bawai.com.electricityproject.network.cookie.CookiesManager;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class RetrofitFactory {
    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookiesManager())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS)
            .build();

  //生成动态代理
   public static   ApiServise apiServise=new Retrofit.Builder()
             .addConverterFactory(ScalarsConverterFactory.create())
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//该方法将Call改为observable,retrofit与Rxjava关联
            .client(okHttpClient)
             .build().create(ApiServise.class);


      public static  void get(String url,Observer<String> observer){

                apiServise.get(url).subscribeOn(Schedulers.io())
                          .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(observer);

      }
    public static void get(String url, Map<String,String> map, Observer<String> observer){

        apiServise.get(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }





    public static void post(String url,Map<String,String> map, Observer<String> observer){
        apiServise.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
