package com.stqin.spring.schedule.db;

import com.stqin.spring.schedule.dao.TestDao;
import com.stqin.spring.schedule.entity.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseHandle {
    @Autowired
    private TestDao testDao;

    public void insertStaffInfo(StaffInfo staffInfo) throws Exception {
        testDao.insertStaffInfo(staffInfo);
    }

//    public StaffInfo queryStaffInfo(StaffInfo staffInfo) throws Exception {
//        return testDao.queryStaffInfo(staffInfo);
//    }
}
