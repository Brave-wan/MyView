package com.jinke.community.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jinke.community.R;
import com.jinke.community.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.util.Map;

import butterknife.Bind;

/**
 * Created by root on 16-11-13.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.app_auth_qq)
    ImageView authQQ;

    @Bind(R.id.app_auth_weixin)
    ImageView authWeixin;

    private UMShareAPI mShareAPI = null;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mShareAPI = UMShareAPI.get(this);
        authQQ.setOnClickListener(this);
        authWeixin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        SHARE_MEDIA platform = null;
        switch (view.getId()) {
            case R.id.app_auth_qq:
                platform = SHARE_MEDIA.QQ;
                break;

            case R.id.app_auth_weixin:
                platform = SHARE_MEDIA.WEIXIN;
                break;
        }
        mShareAPI.deleteOauth(LoginActivity.this, platform, umdelAuthListener);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("kakaoxx", "requestCode=" + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.HandleQQError(this, requestCode, umAuthListener);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * delauth callback interface
     **/
    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "delete Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "delete Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "delete Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


    /**
     * auth callback interface
     **/
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            for (String key : data.keySet()) {
                Log.e("xxxxxx key = " + key + "    value= " + data.get(key));
            }
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail" + t.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
}
