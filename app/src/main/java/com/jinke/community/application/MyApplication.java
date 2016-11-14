package com.jinke.community.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by root on 16-11-13.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        UMShareAPI.get(this);
        setPlatFormConfig();
    }

    public void setPlatFormConfig() {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5537d1801123e13c41b5c46568b91502");
    }
}
