package com.ysj.core.po;

public class BaseMajor {
    private String majorId;

    private String majorName;

    private String deptId;

    private Integer majorState;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public Integer getMajorState() {
        return majorState;
    }

    public void setMajorState(Integer majorState) {
        this.majorState = majorState;
    }
}