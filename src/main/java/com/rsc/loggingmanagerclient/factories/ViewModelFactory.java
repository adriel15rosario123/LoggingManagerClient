package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.viewmodels.HomeViewModel;
import com.rsc.loggingmanagerclient.viewmodels.LoginViewModel;
import com.rsc.loggingmanagerclient.viewmodels.LogoutViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;

    private HomeViewModel homeViewModel;

    private LogoutViewModel logoutViewModel;

    private ServiceFactory serviceFactory;

    public ViewModelFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;

    }

    public LoginViewModel getLoginViewModel() {
        this.loginViewModel = new LoginViewModel(serviceFactory.getUserService());
        return this.loginViewModel;
    }

    public HomeViewModel getHomeViewModel(){
        this.homeViewModel = new HomeViewModel();
        return this.homeViewModel;
    }

    public LogoutViewModel getLogoutViewModel(){
        this.logoutViewModel = new LogoutViewModel();
        return this.logoutViewModel;
    }

}
