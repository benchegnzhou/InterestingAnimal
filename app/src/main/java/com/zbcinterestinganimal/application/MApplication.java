package com.zbcinterestinganimal.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by benchengzhou on 2019/3/29  10:57 .
 * 作者邮箱： mappstore@163.com
 * 功能描述： 全局上下文
 * 类    名： MApplication
 * 备    注：
 */

public class MApplication extends Application {

    public static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
