package com.ysj.core.po;

public class ReviewKey {
    private String sId;

    private String memberTId;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getMemberTId() {
        return memberTId;
    }

    public void setMemberTId(String memberTId) {
        this.memberTId = memberTId == null ? null : memberTId.trim();
    }
}