package com.blog_cjw.Comment;

import java.util.Date;

public class CommentVO {
    /*

create table bcomment(
	bno int not null,
    userId varchar(50) not null,
    cno int not null auto_increment,
	cCon varchar(2000) not null,
    cDate timestamp default NOW(),
	primary key(cno)
);

alter table bcomment
add constraint bcomment_bno foreign key(bno)
references blog_cjw_board(bno);

alter table bcomment
add constraint bcomment_userId foreign key(userId)
references blog_cjw_user(userId);
     */
    private int bno;
    private String userId;
    private int cno;
    private String cCon;
    private Date cDate;

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
}
