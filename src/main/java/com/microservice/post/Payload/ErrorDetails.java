package com.microservice.post.Payload;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String mssg;
    private String path;

    public ErrorDetails(Date date, String mssg, String path) {
        this.date = date;
        this.mssg = mssg;
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public String getMssg() {
        return mssg;
    }

    public String getPath() {
        return path;
    }
}
