package com.example.application;

public class RelativeTime {
    private double execution_time;
    private double period_time;
    private double deadline_time;

    public RelativeTime(double execution_time, double period_time, double deadline_time) {
        this.execution_time = execution_time;
        this.period_time = period_time;
        this.deadline_time = deadline_time;
    }

    public RelativeTime(double execution_time) {
        this.execution_time = execution_time;
    }

    public double getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(double execution_time) {
        this.execution_time = execution_time;
    }

    public double getPeriod_time() {
        return period_time;
    }

    public void setPeriod_time(double period_time) {
        this.period_time = period_time;
    }

    public double getDeadline_time() {
        return deadline_time;
    }

    public void setDeadline_time(double deadline_time) {
        this.deadline_time = deadline_time;
    }
}
