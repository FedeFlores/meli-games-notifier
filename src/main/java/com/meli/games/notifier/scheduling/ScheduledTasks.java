package com.meli.games.notifier.scheduling;

import com.meli.games.notifier.service.NotifierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private NotifierService notifierService;

    @Scheduled(fixedDelayString = "${delay}")
    public void notifierScheduler() {
        log.info("Starting process at: {}", dateFormat.format(new Date()));
        notifierService.notifyNewListings();
    }

}
