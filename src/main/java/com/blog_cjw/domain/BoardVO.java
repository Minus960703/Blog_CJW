package com.blog_cjw.domain;

import java.util.Date;

public class BoardVO {
	/*
	 * CREATE TABLE blog_cjw_board(
	bno INT NOT NULL AUTO_INCREMENT,
	bwriter VARCHAR(50) NOT NULL,
	bThumbnail VARCHAR(500) NOT NULL,
	bTitle VARCHAR(50) NOT NULL,
	bCon text NOT NULL,
	bDate timestamp DEFAULT NOW(),
	bPart VARCHAR(100) NOT NULL,
	viewCnt INT DEFAULT 0,
	PRIMARY KEY(bno)
);
	 */
	
	private int bno;
	private String userId;
	private String bThumbnail;
	private String title;
	private String bCon;
	private Date bDate;
	private String bPart;
	private int viewCnt;
	
	private String userNick;
	
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getbThumbnail() {
		return bThumbnail;
	}
	public void setbThumbnail(String bThumbnail) {
		this.bThumbnail = bThumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getbCon() {
		return bCon;
	}
	public void setbCon(String bCon) {
		this.bCon = bCon;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbPart() {
		return bPart;
	}
	public void setbPart(String bPart) {
		this.bPart = bPart;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
