package com.ysj.core.po;

public class BaseDept {
    private String deptId;

    private String deptName;

    private Integer deptState;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getDeptState() {
        return deptState;
    }

    public void setDeptState(Integer deptState) {
        this.deptState = deptState;
    }
}