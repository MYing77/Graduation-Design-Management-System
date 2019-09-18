package com.ysj.core.po;

public class Title {
	private String seltitlState;
	
	private String sId;
	
	private String sName;
	
	private String tName;
	
	private Long titlId;

    private String titlName;

    private String tId;

    private String titlSource;

    private String titlType;

    private String titlDescribe;

    private String titlState;

    private String selState;
    
    private String major;
    
    private Teacher teacher;
	
    public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSeltitlState() {
		return seltitlState;
	}

	public void setSeltitlState(String seltitlState) {
		this.seltitlState = seltitlState;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Long getTitlId() {
        return titlId;
    }

    public void setTitlId(Long titlId) {
        this.titlId = titlId;
    }

    public String getTitlName() {
        return titlName;
    }

    public void setTitlName(String titlName) {
        this.titlName = titlName == null ? null : titlName.trim();
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String getTitlSource() {
        return titlSource;
    }

    public void setTitlSource(String titlSource) {
        this.titlSource = titlSource == null ? null : titlSource.trim();
    }

    public String getTitlType() {
        return titlType;
    }

    public void setTitlType(String titlType) {
        this.titlType = titlType == null ? null : titlType.trim();
    }

    public String getTitlDescribe() {
        return titlDescribe;
    }

    public void setTitlDescribe(String titlDescribe) {
        this.titlDescribe = titlDescribe == null ? null : titlDescribe.trim();
    }

    public String getTitlState() {
        return titlState;
    }

    public void setTitlState(String titlState) {
        this.titlState = titlState == null ? null : titlState.trim();
    }

    public String getSelState() {
        return selState;
    }

    public void setSelState(String selState) {
        this.selState = selState == null ? null : selState.trim();
    }
}