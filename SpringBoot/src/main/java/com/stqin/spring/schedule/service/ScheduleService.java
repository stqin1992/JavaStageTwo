package com.stqin.spring.schedule.service;

import com.stqin.spring.schedule.db.DataBaseHandle;
import com.stqin.spring.schedule.entity.StaffInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@EnableScheduling
@Slf4j
@EnableAsync
@Component
public class ScheduleService {
    @Autowired
    private DataBaseHandle dataBaseHandle;

    int count= 2;
//    @Scheduled(initialDelay = 3*1000, fixedDelay = 1*1000) //毫秒为单位，该函数全部完成之后，暂停一秒开始执行第二次
    public void fixedDelayTest(){
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        log.info(name + "-->FixedDelay test");
    }

    @Async
    @Scheduled(initialDelay = 3*1000, fixedRate = 5*1000) //毫秒为单位，调用一次函数，马上开始计时一秒，然后执行第二次
    public void fixedRateTest() throws Exception {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        synchronized (ScheduleService.class) {

            Thread.sleep(1000);
            log.info(name + "-->syn"+ --count);
            if(count<0) {
                return;
            }
        }
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setId(UUID.randomUUID().toString());
        staffInfo.setName("");
        staffInfo.setDeptId("0001");
        staffInfo.setSalary(10000);
        dataBaseHandle.insertStaffInfo(staffInfo);
//        dataBaseHandle.queryStaffInfo(staffInfo);


//        for (int i = 0; i < count; i++) {
//            Thread.sleep(3000);
//            log.info(name + "-->FixedRate test"+i);
//        }

    }

}
