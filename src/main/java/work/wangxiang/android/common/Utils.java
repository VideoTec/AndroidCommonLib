package work.wangxiang.android.common;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.google.protobuf.ByteString;

import java.nio.ByteBuffer;
import java.util.UUID;

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

    public static ByteString getUuidByteString() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return ByteString.copyFrom(bb.array());
    }
}
