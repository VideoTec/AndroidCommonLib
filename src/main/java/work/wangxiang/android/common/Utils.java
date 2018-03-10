package work.wangxiang.android.common;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * android common util function
 * Created by wangxiang on 2018/3/9.
 */

public class Utils {
    public static boolean simpleRequestPermission(Activity ctx, String permission) {
        if (ActivityCompat.checkSelfPermission(ctx, permission)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ctx, new String[]{ permission }, 0);
            return false;
        }
        return true;
    }
}
