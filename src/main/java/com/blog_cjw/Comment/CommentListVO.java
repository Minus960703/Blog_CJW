package com.blog_cjw.Comment;

import java.util.Date;

public class CommentListVO {
    private int bno;
    private String userId;
    private int cno;
    private String cCon;
    private Date cDate;
    private String userNick;

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

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getcCon() {
        return cCon;
    }

    public void setcCon(String cCon) {
        this.cCon = cCon;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
