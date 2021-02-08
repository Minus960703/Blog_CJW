package com.blog_cjw.User;

public class UserVO {
    /*
    create table blog_cjw_user(
	userId varchar(50) not null,
    userPass varchar(50) not null,
    userName varchar(50) not null,
    userNick varchar(50) not null,
    userPhone varchar(50) not null,
    userEmail varchar(200) not null,
    primary key(userId)
);

     */

    private String userId;
    private String userPass;
    private String userName;
    private String userNick;
    private String userPhone;
    private String userEmail;
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
