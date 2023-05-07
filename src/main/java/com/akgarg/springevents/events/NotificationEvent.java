package com.akgarg.springevents.events;

public record NotificationEvent(String recipient, String message) {
}