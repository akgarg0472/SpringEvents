package com.akgarg.springevents.service;

import com.akgarg.springevents.events.NotificationEvent;
import com.akgarg.springevents.publisher.NotificationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationService {

    private static final Logger LOGGER = Logger.getLogger("NotificationService");
    private final NotificationEventPublisher notificationEventPublisher;

    public NotificationService(final NotificationEventPublisher notificationEventPublisher) {
        this.notificationEventPublisher = notificationEventPublisher;
    }

    public void sendNotification() {
        LOGGER.info("Going to publish Notification event...");
        final var recipient = getRecipient();
        final var message = getMessage(recipient);
        final var notificationEvent = new NotificationEvent(recipient, message);
        notificationEventPublisher.publish(notificationEvent);
    }

    private String getMessage(final String recipient) {
        return "Hi " + recipient + ". Welcome to the Spring Event masterclass";
    }

    private String getRecipient() {
        final var recipients = new String[]{"tom.collins@email.abc", "william.ashbless@email.xyz", "zak.piotr@xyz.group", "rwater.john@platform.pqr"};
        return recipients[Math.toIntExact(System.currentTimeMillis() % recipients.length)];
    }

}
