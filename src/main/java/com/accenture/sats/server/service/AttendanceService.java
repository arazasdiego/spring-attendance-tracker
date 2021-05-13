package com.accenture.sats.server.service;

import com.accenture.sats.server.entity.Learner;

import java.util.List;

public interface AttendanceService {
    Learner timeIn(Learner learner);

    Learner timeOut(Learner learner);

    List<Learner> getLearners();
}
