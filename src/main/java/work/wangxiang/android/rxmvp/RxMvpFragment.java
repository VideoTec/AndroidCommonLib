package work.wangxiang.android.rxmvp;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.wangxiang.utils.TypeUtils;

/**
 * Rx Mvp fragment base
 * Created by wangxiang on 2018/3/7.
 */

public abstract class RxMvpFragment<M, P extends PresenterBase> extends Fragment {
    protected P presenter;

    protected abstract int getLayoutId();
    protected abstract void initView(View rootView, ViewDataBinding binding);
    protected abstract void initData();

    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        M model = TypeUtils.getTypeInstance(this, 0);
        presenter = TypeUtils.getTypeInstance(this, 1);
        if (presenter != null) {
            presenter.setMV(model, this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil
                .inflate(inflater, getLayoutId(), container, false);
        View root = binding.getRoot();
        initView(root, binding);
        initData();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }
}
