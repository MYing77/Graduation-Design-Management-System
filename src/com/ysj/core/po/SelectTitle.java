package com.ysj.core.po;

public class SelectTitle extends SelectTitleKey {
    private int tScore;

    private String tComments;

    private Double replyScore;

    private String replyComments;

    private String seltitlState;
    
    private String titlName;
    
    private String tId;
    
    private String tName;
    
    private String sName;
    
    private String major;
    
    private int batch;

    public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public String getTitlName() {
		return titlName;
	}

	public void setTitlName(String titlName) {
		this.titlName = titlName;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int gettScore() {
        return tScore;
    }

    public void settScore(int tScore) {
        this.tScore = tScore;
    }

    public String gettComments() {
        return tComments;
    }

    public void settComments(String tComments) {
        this.tComments = tComments == null ? null : tComments.trim();
    }

    public Double getReplyScore() {
        return replyScore;
    }

    public void setReplyScore(Double replyScore) {
        this.replyScore = replyScore;
    }

    public String getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(String replyComments) {
        this.replyComments = replyComments == null ? null : replyComments.trim();
    }

    public String getSeltitlState() {
        return seltitlState;
    }

    public void setSeltitlState(String seltitlState) {
        this.seltitlState = seltitlState == null ? null : seltitlState.trim();
    }
}