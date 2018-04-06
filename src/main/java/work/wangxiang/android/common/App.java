package work.wangxiang.android.common;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * custom application class
 * 参考：
 * https://nfrolov.wordpress.com/2014/07/12/android-using-context-statically-and-in-singletons/
 * Created by wangxiang on 2018/2/27.
 */

public class App extends Application {
    private final static String TAG = "App";
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        RxJavaPlugins.setErrorHandler(throwable -> Log.e(TAG, "exception after RxJava unsubscribe", throwable));
    }

    public static App getCtx() {
        return INSTANCE;
    }

    public void showSoftKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideSoftKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
