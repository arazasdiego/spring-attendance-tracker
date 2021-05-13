package com.accenture.sats.server.exception;

public class AttendanceException extends RuntimeException {

    public static final String NO_TIMED_IN = "Learner has not timed-in";
    public static final String ALREADY_TIMED_IN = "Learner already timed-in";
    public static final String ALREADY_TIMED_OUT = "Learner already timed-out";

    public AttendanceException(String message) {
        super(message);
    }
}
