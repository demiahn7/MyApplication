package com.example.jphomel.myapplication.member;

/**
 * Created by jpHomeL on 2016-10-01.
 */

/* in SQLite
 create table if not exists member(
      id          text    primary key,
      pw          text,
      name        text,
      addr        text,
      phone       text,
      email       text,
      profileImg  text
 );
 */
public class MemberDTO {
    private String id, pw, name, addr, phone, email, profileImg;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //Alt + Insert 를 이용해서 생성한다.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
