package xiangmu.bawai.com.electricityproject.network;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public abstract class BaseObserable implements Observer<String> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull String s) {
          onSuccess(s);
        Log.d("tag",s);
    }

    @Override
    public void onError(@NonNull Throwable e) {
      onFailed();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(String result);
    public abstract void onFailed();

}
