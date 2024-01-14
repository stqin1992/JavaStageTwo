package com.stqin.spring.schedule.dao;

import com.stqin.spring.schedule.entity.StaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao {
//    StaffInfo queryStaffInfo(StaffInfo staffInfo) throws Exception;
    List<StaffInfo> queryStaffInfoList() throws Exception;
    void insertStaffInfo(StaffInfo staffInfo) throws Exception;
}
