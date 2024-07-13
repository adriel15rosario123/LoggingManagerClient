package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.dtos.EnrollSystem;

import java.util.List;

public interface ISystemService {

    List<EnrollSystem> getAll();
}
