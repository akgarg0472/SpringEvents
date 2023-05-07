package com.akgarg.springevents.controller;

import com.akgarg.springevents.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/foo")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(final NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public Map<String, String> hit() {
        this.notificationService.sendNotification();
        return Map.of(
                "message", "API request successful",
                "status", "200",
                "timestamp", new Date().toString()
        );
    }

}

