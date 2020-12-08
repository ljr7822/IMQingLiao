package com.example.iwen.factory.presenter.account;

import android.text.TextUtils;

import com.example.iwen.common.Common;
import com.example.iwen.common.factory.data.DataSource;
import com.example.iwen.common.factory.presenter.BasePresenter;
import com.example.iwen.factory.R;
import com.example.iwen.factory.data.helper.AccountHelper;
import com.example.iwen.factory.model.api.account.LoginModel;
import com.example.iwen.factory.model.db.User;
import com.example.iwen.factory.persistence.Account;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import java.util.regex.Pattern;

/**
 * 具体登录逻辑的实现类
 *
 * @author : iwen大大怪
 * create : 12-7 007 14:31
 */
public class LoginPresenter
        extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter , DataSource.Callback<User> {

    public LoginPresenter(LoginContract.View mView) {
        super(mView);
    }

    @Override
    public void login(String phone, String password) {
        start();
        final LoginContract.View view = getView();
        if (!checkMobile(phone)) {
            view.showError(R.string.data_account_register_invalid_parameter_mobile);
        } else if (password.length() < 6) {
            view.showError(R.string.data_account_register_invalid_parameter_password);
        } else {
            // 尝试获取PushId
            LoginModel loginModel = new LoginModel(phone, password, Account.getPushId());
            // 发起网络请求
            AccountHelper.login(loginModel, this);
        }
    }

    @Override
    public void onDataLoad(User user) {
        //告知界面登录成功
        final LoginContract.View view = getView();
        if (view == null)
            return;
        //该方法是从网络回调的，需要回主线程更新UI
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                view.loginSuccess();
            }
        });
    }

    @Override
    public void onDataNotAvailable(final int strRes) {
        final LoginContract.View view = getView();
        if (view == null)
            return;
        //该方法是从网络回调的，需要回主线程更新UI
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                //告知界面注册失败，显示错误
                view.showError(strRes);
            }
        });
    }

    public boolean checkMobile(String phone) {
        //手机号不为空，并且满足格式
        return !TextUtils.isEmpty(phone) && Pattern.matches(Common.Constance.REGEX_MOBILE, phone);
    }
}
