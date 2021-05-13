package com.accenture.sats.server.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "learner")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "eid")
    private String eid;

    @Column(name = "time_in", columnDefinition = "TIMESTAMP")
    private LocalDateTime timeIn;

    @Column(name = "time_out", columnDefinition = "TIMESTAMP")
    private LocalDateTime timeOut;

    public Learner() {

    }

    public Learner(String eid, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.eid = eid;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                '}';
    }
}
