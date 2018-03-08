package work.wangxiang.android.rxmvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * base presenter
 * 1. 持有 model 和 view 接口的实例
 * 2. 管理 RxJava Disposable 对象集合
 *
 * Created by wangxiang on 2018/3/3.
 */

public class PresenterBase<M, V> {
    protected M model;
    protected V view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    void setMV(M model, V view) {
        this.model = model;
        this.view = view;
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    void stop() {
        compositeDisposable.clear();
    }
}
