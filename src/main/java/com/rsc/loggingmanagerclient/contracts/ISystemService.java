package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.dtos.CreateSystemDto;
import com.rsc.loggingmanagerclient.dtos.SystemDto;

import java.util.List;

public interface ISystemService {

    List<SystemDto> getAll();

    BaseDto<String> CreateSystem(CreateSystemDto createSystemDto) throws Exception;
}
