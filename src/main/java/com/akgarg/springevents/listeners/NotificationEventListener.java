package com.akgarg.springevents.listeners;

import com.akgarg.springevents.events.NotificationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class NotificationEventListener {

    private static final Logger LOGGER = Logger.getLogger("NotificationEventListener");

    @EventListener
    public void listen(@NonNull final NotificationEvent event) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Received notification event:" + event);
        }
    }

}
