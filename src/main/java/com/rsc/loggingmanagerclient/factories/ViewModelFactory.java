package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.viewmodels.EnrollSystemViewModel;
import com.rsc.loggingmanagerclient.viewmodels.HomeViewModel;
import com.rsc.loggingmanagerclient.viewmodels.LoginViewModel;
import com.rsc.loggingmanagerclient.viewmodels.LogoutViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;

    private HomeViewModel homeViewModel;

    private LogoutViewModel logoutViewModel;

    private EnrollSystemViewModel enrollSystemViewModel;

    private ServiceFactory serviceFactory;

    public ViewModelFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;

    }

    public LoginViewModel getLoginViewModel() {
        this.loginViewModel = new LoginViewModel();
        return this.loginViewModel;
    }

    public HomeViewModel getHomeViewModel(){
        this.homeViewModel = new HomeViewModel(serviceFactory.getSystemService());
        return this.homeViewModel;
    }

    public LogoutViewModel getLogoutViewModel(){
        this.logoutViewModel = new LogoutViewModel();
        return this.logoutViewModel;
    }

    public EnrollSystemViewModel getEnrollSystemViewModel(){
        this.enrollSystemViewModel = new EnrollSystemViewModel();
        return this.enrollSystemViewModel;
    }

}
