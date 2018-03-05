package work.wangxiang.android.common;

import android.app.Application;

/**
 * custom application class
 * 参考：
 * https://nfrolov.wordpress.com/2014/07/12/android-using-context-statically-and-in-singletons/
 * Created by wangxiang on 2018/2/27.
 */

public class App extends Application {
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static App getCtx() {
        return INSTANCE;
    }
}
