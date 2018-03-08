package work.wangxiang.utils;

import android.util.Log;
import java.lang.reflect.ParameterizedType;

/**
 * java class type utils
 * Created by wangxiang on 2018/3/7.
 */

public class TypeUtils {
    private final static String TAG = "TypeUtils";

    /***
     * 运行时创建父类（模板类），泛型的实例
     * @param childObj 模板类子类的实例
     * @param typeIndex 泛型参数的索引
     */
    @SuppressWarnings("unchecked")
    public static <T> T getTypeInstance(Object childObj, int typeIndex) {
        try {
            ParameterizedType pT = (ParameterizedType) childObj.getClass().getGenericSuperclass();
            return ((Class<T>)pT.getActualTypeArguments()[typeIndex]).newInstance();
        } catch (Exception e) {
            Log.e(TAG, "create m & p instance exception", e);
        }
        return null;
    }
}
