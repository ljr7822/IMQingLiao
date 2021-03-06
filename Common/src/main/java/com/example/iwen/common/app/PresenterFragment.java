package com.example.iwen.common.app;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.iwen.common.factory.presenter.BaseContract;

/**
 * @author : iwen大大怪
 * create : 12-7 007 14:02
 */
public abstract class PresenterFragment<Presenter extends BaseContract.Presenter>
        extends Fragment
        implements BaseContract.View<Presenter> {

    protected Presenter mPresenter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 在界面Attach时触发Presenter
        initPresenter();
    }

    protected abstract Presenter initPresenter();

    @Override
    public void showError(int str) {
        // 显示错误,优先使用占位布局
        if (mPlaceHolderView != null) {
            mPlaceHolderView.triggerError(str);
        } else {
            // 显示错误
            Application.showToast(str);
        }
    }

    @Override
    public void showLoading() {
        // 显示一个Loading,优先使用占位布局
        if (mPlaceHolderView != null) {
            mPlaceHolderView.triggerLoading();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter !=null){
            mPresenter.destroy();
        }
    }
}
