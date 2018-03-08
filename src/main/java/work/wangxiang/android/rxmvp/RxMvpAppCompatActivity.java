package work.wangxiang.android.rxmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import work.wangxiang.utils.TypeUtils;

/**
 * rx Mvp activity base
 * Created by wangxiang on 2018/3/7.
 */

public abstract class RxMvpAppCompatActivity<M, P extends PresenterBase> extends AppCompatActivity {
    protected P presenter;

    protected abstract int getLayoutId();

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        M model = TypeUtils.getTypeInstance(this, 0);
        presenter = TypeUtils.getTypeInstance(this, 1);
        if (presenter != null) {
            presenter.setMV(model, this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }
}
