package com.ztz.myoschina.bean;

/**
 * Created by wqewqe on 2017/5/9.
 */

public class TweetResponse2 {

    /**
     * author : zjtxqjj
     * id : 13213797
     * portrait : https://static.oschina.net/uploads/user/136/273695_50.gif?t=1396057332000
     * authorid : 273695
     * body : 今天是5月9号，是比克大魔王纪念日
     * pubDate : 2017-05-09 14:29:51
     * commentCount : 0
     */

    private String author;
    private int id;
    private String portrait;
    private int authorid;
    private String body;
    private String pubDate;
    private int commentCount;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
