package org.nishkarma.broker.errorprocess.repository;

import java.util.List;

import org.nishkarma.broker.errorprocess.model.TbJmsProcessErrLog;

public interface TbJmsProcessErrLogMapper {

    int insert(TbJmsProcessErrLog record);

    TbJmsProcessErrLog selectByPrimaryKey(Short errorLogId);

    List<TbJmsProcessErrLog> selectToProcess();

    int updateByPrimaryKey(TbJmsProcessErrLog record);
    
    int updateProcessStatus(TbJmsProcessErrLog record);
}