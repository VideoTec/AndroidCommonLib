package work.wangxiang.android.rxmvp;

import work.wangxiang.utils.TypeUtils;

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
 * 这是一个辅助类，使用场景:
 * 使用于用于没有继承 RxMvpAppCompatActivity RxMvpFragment 的 activity 和 fragment
 *
 * Created by wangxiang on 2018/3/3.
 */

public class PresenterHolder<M, P extends PresenterBase> {
    private P presenter;

    @SuppressWarnings("unchecked")
    PresenterHolder(Object view) {
        M model = TypeUtils.getTypeInstance(this, 0);
        presenter = TypeUtils.getTypeInstance(this, 1);
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
}
