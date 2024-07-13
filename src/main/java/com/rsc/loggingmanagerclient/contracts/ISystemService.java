package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.dtos.SystemDto;

import java.util.List;

public interface ISystemService {

    List<SystemDto> getAll();
}
