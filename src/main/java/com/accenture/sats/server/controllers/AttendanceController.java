package com.accenture.sats.server.controllers;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.exception.AttendanceException;
import com.accenture.sats.server.response.ErrorResponse;
import com.accenture.sats.server.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/attendance/timeIn")
    public Learner timeIn(@RequestBody Learner learner) {

        return this.attendanceService.timeIn(learner);
    }

    @PostMapping("/attendance/timeOut")
    public Learner timeOut(@RequestBody Learner learner) {

        return this.attendanceService.timeOut(learner);
    }

    @GetMapping("/attendance")
    public List<Learner> getLearners() {
        return this.attendanceService.getLearners();
    }
}
