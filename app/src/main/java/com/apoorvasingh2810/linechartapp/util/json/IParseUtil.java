package com.apoorvasingh2810.linechartapp.util.json;

/**
 * @author lite.zhang
 * @name BabyNurse
 * @class name：wirush.radar.babynurse.framework.utils.json
 * @class describe
 * @time 2019/7/31 15:56
 * @change
 * @chang
 * @class
 */
public interface IParseUtil {

    /**
     * Converts a json string into a T bean.
     */
    <T> T parseJson(String json, Class<T> tClass);

    /**
     * Converts a json string into a T bean. T should be a Interface generic type.
     */
    <T> T parseInterfaceGenericJson(String json, Class tClass);

    /**
     * Converts an object into a string.
     */
    String toJson(Object object);
}
