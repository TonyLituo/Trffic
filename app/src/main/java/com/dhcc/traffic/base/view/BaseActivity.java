package com.dhcc.traffic.base.view;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dhcc.traffic.R;
import com.dhcc.traffic.base.presenter.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BaseActivity<V extends IBaseView, P extends IBasePresenter<V>> extends AppCompatActivity implements IBaseView {

    FrameLayout contentView;
    @BindView(R.id.toolbar)
    FrameLayout mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.error_view)
    FrameLayout mErrorView;


    protected String tag;

    protected P presenter;

    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = this.getClass().getSimpleName();

        setTranslucentStatus();

        setContentView(R.layout.activity_base);
//这里不能用butterknife绑定  还未初始化；也不能先初始化Butterknife，不然找不到contentView中的控件

        contentView = (FrameLayout) this.findViewById(R.id.base_contentview);

        contentView.addView(View.inflate(this, getLayoutResID(), null));

        mUnbinder = ButterKnife.bind(this);

        mToolbarTitle.setText(setToolbarTitle());

        addToolbar();

        initView();

        presenter = createPresenter();

        presenter.attach((V) this);

        showContentView();

        //透明状态栏内容延伸到状态栏，
        // 去掉默认的toolbar，xml中：android:fitsSystemWindows="false"
        //子类中调用 removeToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
        mUnbinder.unbind();
        mUnbinder = null;
    }

    public void showErrorView() {
        mErrorView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }

    public void showContentView() {
        mErrorView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    public void removeToolbar() {
        mToolbar.setVisibility(View.GONE);
    }

    public void addToolbar() {
        mToolbar.setVisibility(View.VISIBLE);
    }

    /**
     * 布局ID
     */

    @LayoutRes
    @NonNull
    protected abstract int getLayoutResID();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * p层创建
     *
     * @return
     */
    @NonNull
    protected abstract P createPresenter();

    /**
     * 标题
     *
     * @return
     */
    @NonNull
    protected abstract String setToolbarTitle();

    @OnClick({R.id.toolbar_img_left})
    public void onBaseClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_img_left:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 设置状态栏背景状态
     */
    private void setTranslucentStatus() {
        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
    }
}
