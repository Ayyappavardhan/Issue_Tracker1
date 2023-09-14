package com.accenture.issue_tracker.service;

import com.accenture.issue_tracker.model.ITSMTableData;
import com.accenture.issue_tracker.mq.MQConfig;
import com.accenture.issue_tracker.repository.ITSMTAbleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ITSMTableDataService {
    private static final Logger logger = LoggerFactory.getLogger(JobService.class);


    private final ITSMTAbleRepository itsmTableRepository;
    private final AmqpTemplate rabbitTemplate;
    private static String QUEUE;

//    @Value("${queue_name}")
//    public void setQueue(String queue) {
//        ITSMTableDataService.QUEUE = queue;
//    }

    public ITSMTableDataService(ITSMTAbleRepository itsmTableRepository, AmqpTemplate rabbitTemplate) {
        this.itsmTableRepository = itsmTableRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    @Transactional
    public String insertNewRecord(ITSMTableData data) {
        logger.info("Data come from third party DB");
        ITSMTableData savedData = itsmTableRepository.save(data);
        logger.info("Data inserted into ITSM table");
        logger.info("MQ started");
        rabbitTemplate.convertAndSend(MQConfig.QUEUE
                ,savedData);
        return "Message sent";
    }
}
