package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.models.UpdateSystemModel;
import com.rsc.loggingmanagerclient.viewmodels.*;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;

    private HomeViewModel homeViewModel;

    private LogoutViewModel logoutViewModel;

    private EnrollSystemViewModel enrollSystemViewModel;

    private UpdateSystemViewModel updateSystemViewModel;

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

    public UpdateSystemViewModel getUpdateSystemViewModel(UpdateSystemModel updateSystemModel){
        this.updateSystemViewModel = new UpdateSystemViewModel(updateSystemModel);
        return this.updateSystemViewModel;
    }

}
