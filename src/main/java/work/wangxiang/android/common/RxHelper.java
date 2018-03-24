package work.wangxiang.android.common;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * RxHelper
 * Created by wangxiang on 2018/3/24.
 */

public class RxHelper {
    public static <T> Observable<T> observableComputation(Observable<T> ob) {
        return ob.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }
    public static <T> Observable<T> observableCIo(Observable<T> ob) {
        return ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public static <T> Single<T> singleComputation(Single<T> single) {
        return single.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }
    public static <T> Single<T> singleIo(Single<T> single) {
        return single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public static Completable completableComputation(Completable completable) {
        return completable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }
    public static Completable completableIo(Completable completable) {
        return completable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
