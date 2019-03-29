package com.ztsc.commonutils.logcat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.ztsc.commonutils.CommonUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * http://www.flvcd.com/
 *  .--,       .--,
 * ( (  \.---./  ) )
 *  '.__/o   o\__.'
 *     {=  ^  =}
 *      >  -  <
 *     /       \
 *    //       \\
 *   //|   .   |\\
 *   "'\       /'"_.-~^`'-.
 *      \  _  /--'         `
 *    ___)( )(___
 *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 */

/**
 * 输入log
 *
 * @author zbc
 */
public class LogUtil {

    private final static String tag = CommonUtil.getInstance().getConfig().LogTag;
    //通过配置文件控制log日志
    private final static boolean state = CommonUtil.getInstance().getConfig().LogOpen;


    /**
     * It is used for json pretty print
     */
    private static final int JSON_INDENT = 2;



    public static void d(String str) {
        if (state) {
            Log.d(tag, str);
        }
    }

    /**
     * 带有类名信息的log
     * @author:zbc
     * @param mTag
     * @param str
     */
    public static void d(String mTag, String str) {
        if (state) {
            Log.d(mTag, str);
        }
    }


    /**
     * @author:zbc
     * @param context
     * @param str
     */
    public static void d(Context context, String str) {
        String mTag = context.getClass().getSimpleName();
        mTag = TextUtils.isEmpty(mTag) ? tag : mTag;
        if (state) {
            Log.d(mTag, str);
        }
    }
    public static void e(String str) {
        if (state) {
            Log.e(tag, str);
        }
    }
    /**
     * 带有类名信息的log
     * @author:zbc
     * @param mTag
     * @param str
     */
    public static void e(String mTag, String str) {
        mTag = TextUtils.isEmpty(mTag) ? tag : mTag;
        if (state) {
            Log.e(mTag, str);
        }
    }


    /**
     * @author:zbc
     * @param context
     * @param str
     */
    public static void e(Context context, String str) {
        String mTag = context.getClass().getSimpleName();
        mTag = TextUtils.isEmpty(mTag) ? tag : mTag;
        if (state) {
            Log.e(mTag, str);
        }
    }

    /**
     * 打印错误级别的日志，带有错误
     * 此
     * @param msg
     * @param tr
     * @return
     */
    public static void e(  String msg, Throwable tr) {
        if (state) {
            Log.e(tag, msg,tr);
        }
    }


    /**
     * 打印错误级别的日志，带有错误
     * 此
     * @param context
     * @param msg
     * @param tr
     * @return
     */
    public static void e(  Context context,String  msg, Throwable tr) {
        String mTag = context.getClass().getSimpleName();
        mTag = TextUtils.isEmpty(mTag) ? tag : mTag;
        if (state){
            Log.e(mTag, msg,tr);
        }
    }

    /**
     *
     * @param json
     */
    public static void json(String json) {
        if (TextUtils.isEmpty(json)) {
            LogUtil.e("Empty/Null json content");
            return;
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String message = jsonObject.toString(JSON_INDENT);
                LogUtil.e(message);
                return;
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String message = jsonArray.toString(JSON_INDENT);
                LogUtil.e(message);
                return;
            }
            LogUtil.e("Invalid Json");
        } catch (JSONException e) {
            LogUtil.e("Invalid Json");
        }
    }

}
