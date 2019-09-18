package com.ysj.core.po;

import java.util.Date;

public class ReplyGroup {
    private String replyId;

    private String replyLeader;

    private String replyPlace;

    private Date replyDatetime;

    private Short batch;

    private String creator;

    private String replyStudent;

    private String replyMember;

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId == null ? null : replyId.trim();
    }

    public String getReplyLeader() {
        return replyLeader;
    }

    public void setReplyLeader(String replyLeader) {
        this.replyLeader = replyLeader == null ? null : replyLeader.trim();
    }

    public String getReplyPlace() {
        return replyPlace;
    }

    public void setReplyPlace(String replyPlace) {
        this.replyPlace = replyPlace == null ? null : replyPlace.trim();
    }

    public Date getReplyDatetime() {
        return replyDatetime;
    }

    public void setReplyDatetime(Date replyDatetime) {
        this.replyDatetime = replyDatetime;
    }

    public Short getBatch() {
        return batch;
    }

    public void setBatch(Short batch) {
        this.batch = batch;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getReplyStudent() {
        return replyStudent;
    }

    public void setReplyStudent(String replyStudent) {
        this.replyStudent = replyStudent == null ? null : replyStudent.trim();
    }

    public String getReplyMember() {
        return replyMember;
    }

    public void setReplyMember(String replyMember) {
        this.replyMember = replyMember == null ? null : replyMember.trim();
    }
}