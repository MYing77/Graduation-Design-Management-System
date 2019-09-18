package com.ysj.core.po;

public class Review1 extends ReviewKey {
	
	private String memberTId2;
	
	private String memberTName2;
	
	private String reviewScore2;
	
    private Integer reviewScore;

    private String reviewComments;

    private String replyId;
    
    private Long fId;
    
    private String fName;
    
    private String agree;
    
    private Long titlId;
    
    private String tId;
    
    private String tName;
    
    private String memberTName;
    
    private String sName;
    
    private String titlName;
    
    private String major;
    
    private Short batch;
    
    private String reviewType;
    
    private String replyLeader;
    
    private String replyScore2;

    public String getReplyScore2() {
		return replyScore2;
	}

	public void setReplyScore2(String replyScore2) {
		this.replyScore2 = replyScore2;
	}

	public String getMemberTId2() {
		return memberTId2;
	}

	public void setMemberTId2(String memberTId2) {
		this.memberTId2 = memberTId2;
	}

	public String getMemberTName2() {
		return memberTName2;
	}

	public void setMemberTName2(String memberTName2) {
		this.memberTName2 = memberTName2;
	}

	public String getReviewScore2() {
		return reviewScore2;
	}

	public void setReviewScore2(String reviewScore2) {
		this.reviewScore2 = reviewScore2;
	}

	public String getReplyLeader() {
		return replyLeader;
	}

	public void setReplyLeader(String replyLeader) {
		this.replyLeader = replyLeader;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public String getMemberTName() {
		return memberTName;
	}

	public void setMemberTName(String memberTName) {
		this.memberTName = memberTName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public Long getTitlId() {
		return titlId;
	}

	public void setTitlId(Long titlId) {
		this.titlId = titlId;
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

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getTitlName() {
		return titlName;
	}

	public void setTitlName(String titlName) {
		this.titlName = titlName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Short getBatch() {
		return batch;
	}

	public void setBatch(Short batch) {
		this.batch = batch;
	}

	public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments == null ? null : reviewComments.trim();
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId == null ? null : replyId.trim();
    }
}