package com.apoorvasingh2810.linechartapp.util.json;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

/**
 * @author lite.zhang
 * @name BabyNurse
 * @class name：wirush.radar.babynurse.framework.utils.json
 * @class describe
 * @time 2019/7/31 15:58
 */
public class GsonUtil implements IParseUtil {
    private static Gson gson = new Gson();

    /**
     * Converts a json string into a T bean.
     */
    public static <T> T convertJson2Bean(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    /**
     * Converts an object into a string.
     */
    public static String convertObject2Json(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T parseJson(String json, Class<T> tClass) {
        return GsonUtil.convertJson2Bean(json, tClass);
    }

    @Override
    public <T> T parseInterfaceGenericJson(String json, Class tClass) {
        return gson.fromJson(json, (((ParameterizedType)
                (tClass.getClass().getGenericInterfaces())[0])
                .getActualTypeArguments()[0]));
    }

    @Override
    public String toJson(Object object) {
        return GsonUtil.convertObject2Json(object);
    }

}

