package com.accenture.sats.server.service;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.exception.AttendanceException;
import com.accenture.sats.server.repositories.LearnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private LearnerRepository learnerRepository;

    private static Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Autowired
    public AttendanceServiceImpl(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    public Learner timeIn(Learner learner) {
        Optional<Learner> learnerFromDb = this.learnerRepository.findByEid(learner.getEid());

        if (learnerFromDb.isPresent()) {
            logger.error(AttendanceException.ALREADY_TIMED_IN);
            throw new AttendanceException(AttendanceException.ALREADY_TIMED_IN);
        }
        learner.setTimeIn(LocalDateTime.now());

        logger.info(learner.getEid() + " has successfully timed-in.");

        return this.learnerRepository.save(learner);
    }

    public Learner timeOut(Learner learner) {
        Optional<Learner> query = this.learnerRepository.findByEid(learner.getEid());

        if (query.isEmpty()) {
            logger.error(AttendanceException.NO_TIMED_IN);
            throw new AttendanceException(AttendanceException.NO_TIMED_IN);
        }
        Learner currentLearner = query.get();

        if (currentLearner.getTimeOut() != null) {
            logger.error(AttendanceException.ALREADY_TIMED_OUT);
            throw new AttendanceException(AttendanceException.ALREADY_TIMED_OUT);
        }

        currentLearner.setTimeOut(LocalDateTime.now());

        logger.info(currentLearner.getEid() + " has successfully timed-out.");

        return this.learnerRepository.save(currentLearner);
    }

    public List<Learner> getLearners() {
        logger.info("Retrieved all learners...");
        return this.learnerRepository.findAll();
    }
}
