package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.dtos.*;

import java.util.List;

public interface ISystemService {
    List<SystemDto> getAll();

    BaseDto<String> CreateSystem(CreateSystemDto createSystemDto) throws Exception;

    BaseDto<String> UpdateSystem(int systemId,UpdateSystemDto updateSystemDto) throws Exception;

    PaginatedBaseDto<List<ErrorLogDto>> getErrorLogs(int systemId, int pageSize,int pageNumber);

    PaginatedBaseDto<List<TrackingLogDto>> getTrackingLogs(int systemId, int pageSize,int pageNumber);

    BaseDto<String> DeleteSystem(int systemId) throws Exception;
}
