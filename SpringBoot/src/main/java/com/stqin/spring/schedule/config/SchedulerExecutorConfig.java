package com.stqin.spring.schedule.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class SchedulerExecutorConfig implements SchedulingConfigurer {
    @Value("${scheduler.corePoolSize}")
    private int corePoolSize;
    @Value("${scheduler.maxPoolSize}")
    private int maxPoolSize;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public Executor taskExecutor() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(corePoolSize);
        executor.setMaximumPoolSize(maxPoolSize);
        executor.setRejectedExecutionHandler(new ScheduledThreadPoolExecutor.CallerRunsPolicy());
        return  executor;
    }
}
