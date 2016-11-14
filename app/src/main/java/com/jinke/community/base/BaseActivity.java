package com.jinke.community.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.jinke.community.utils.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by root on 16-11-13.
 */

public abstract class BaseActivity extends FragmentActivity {

    //布局文件ID
    protected abstract int getContentViewId();

    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void shouToast(String msg) {
        ToastUtils.showLong(BaseActivity.this, msg);
    }
}
