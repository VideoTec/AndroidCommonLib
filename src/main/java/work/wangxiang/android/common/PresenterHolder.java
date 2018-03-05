package work.wangxiang.android.common;
import android.util.Log;

import java.lang.reflect.ParameterizedType;

/**
 * PresenterHolder 功能:
 * 1. 实例化 model 和 presenter (根据泛型的类型参数)
 * 2. 为 presenter 绑定对应的 model 和 view
 * 3. 感知 view 的生命周期事件
 *
 * 使用方法:
 * presenterHolder = new PresenterHolder<XxxModel, XxxPresenter>(this){};
 * 使用匿名类构建对象的原因，参考:
 * http://josh-persistence.iteye.com/blog/2165613
 *
 * Created by wangxiang on 2018/3/3.
 */

public class PresenterHolder<M, P extends PresenterBase>{
    private static final String TAG = "PresenterHolder";
    private P presenter;

    @SuppressWarnings("unchecked")
    protected PresenterHolder(Object view) {
        M model = createInstance(0);
        presenter = createInstance(1);
        if (presenter != null) {
            presenter.setMV(model, view);
        }
    }

    public P presenter() {
        return this.presenter;
    }

    public void onUIStart() {

    }

    public void onUIStop() {
        presenter.stop();
    }

    @SuppressWarnings("unchecked")
    private <T> T createInstance(int index) {
        try {
            ParameterizedType pT = (ParameterizedType) getClass().getGenericSuperclass();
            return ((Class<T>)pT.getActualTypeArguments()[index]).newInstance();
        } catch (Exception e) {
            Log.e(TAG, "create m & p instance exception", e);
        }
        return null;
    }
}
