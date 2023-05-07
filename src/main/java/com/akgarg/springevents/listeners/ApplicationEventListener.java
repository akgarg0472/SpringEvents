package com.akgarg.springevents.listeners;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ApplicationEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = Logger.getLogger("ApplicationEventListener");

    @Override
    public void onApplicationEvent(@NonNull final ApplicationReadyEvent event) {
        if (LOGGER.isLoggable(Level.INFO)) {
            final WebApplicationType webApplicationType = event.getSpringApplication().getWebApplicationType();
            LOGGER.info("Received Application Ready Event for application type: %s".formatted(webApplicationType));
        }
    }

}
