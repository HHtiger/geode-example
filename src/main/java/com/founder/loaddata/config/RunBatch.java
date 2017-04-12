package com.founder.loaddata.config;

import com.founder.loaddata.config.job.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tiger on 2017/2/23.
 */

@Configuration
@EnableBatchProcessing
public class RunBatch {

    private static Logger logger = LoggerFactory.getLogger(RunBatch.class);


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private LoadBzdzAddJlxxxbJob loadBzdzAddJlxxxbJob;

    @Autowired
    private LoadBzdzAddJlxXzqhbJob loadBzdzAddJlxXzqhbJob;

    @Autowired
    private LoadBzdzAddGagxtzTask loadBzdzAddGagxtzTask;

    @Autowired
    private LoadBzdzAddMldzdxb loadBzdzAddMldzdxb;

    @Autowired
    private LoadBzdzAddJlxZzjgb loadBzdzAddJlxZzjgb;

    @Autowired
    private LoadBzdzAddChdzdxb loadBzdzAddChdzdxb;

    @Bean
    public JobExecutionListenerSupport JobCompletionNotificationListener() {

        return new JobExecutionListenerSupport(){
            @Override
            public void afterJob(JobExecution jobExecution) {
                if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
                    logger.info("!!! JOB FINISHED! Time to verify the results");
                }
            }
        };
    }

    @Bean
    public Job loadJob() throws Exception {
        return jobBuilderFactory.get("loadJob")
//                .incrementer(new RunIdIncrementer())
                .listener(JobCompletionNotificationListener())
//                .flow(loadBzdzAddJlxxxbJob.stepBzdzAddJlxxxb(stepBuilderFactory))
//                .flow(loadBzdzAddJlxXzqhbJob.stepBzdzAddJlxXzqhb(stepBuilderFactory))
//                .flow(loadBzdzAddGagxtzTask.stepBzdzAddGagxtzTask(stepBuilderFactory))
//                .flow(loadBzdzAddJlxZzjgb.stepBzdzAddJlxZzjgb(stepBuilderFactory))
                .flow(loadBzdzAddMldzdxb.stepBzdzAddMldzdxb(stepBuilderFactory))
//                .flow(loadBzdzAddChdzdxb.stepBzdzAddChdzdxb(stepBuilderFactory))
                .end()
                .build();
    }

}
