package com.example.qradmin;



public class AttendanceRecord {
    private String studentName;
    private boolean isPresent;
    private String date;

    public AttendanceRecord() {
        // Default constructor required for calls to DataSnapshot.getValue(AttendanceRecord.class)
    }

    public AttendanceRecord(String studentName, boolean isPresent, String date) {
        this.studentName = studentName;
        this.isPresent = isPresent;
        this.date = date;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
