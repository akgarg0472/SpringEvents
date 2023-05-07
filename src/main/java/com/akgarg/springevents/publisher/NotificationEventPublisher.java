package com.akgarg.springevents.publisher;

import com.akgarg.springevents.events.NotificationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class NotificationEventPublisher {

    private static final Logger LOGGER = Logger.getLogger("NotificationEventPublisher");

    private final ApplicationEventPublisher eventPublisher;

    public NotificationEventPublisher(final ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    public void publish(final NotificationEvent event) {
        if (event == null) {
            LOGGER.warning("Not publishing Notification event because event is null");
            return;
        }

        this.eventPublisher.publishEvent(event);
    }

}
