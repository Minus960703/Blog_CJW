package com.blog_cjw.Board;

import java.util.Date;

public class BoardVO {
	/*

create table blog_cjw_board(
	bno int not null auto_increment,
    userId varchar(50) not null,
    title varchar(300) not null,
    bCon text not null,
    bThumbnail varchar(500) not null,
    viewCnt int default '0',
    bDate timestamp default NOW(),
    primary key(bno)
);
	 */
	
	private int bno;
	private String userId;
	private String title;
	private String bCon;
	private String bThumbnail;
	private int viewCnt;
	private Date bDate;
	private String bPart;
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
