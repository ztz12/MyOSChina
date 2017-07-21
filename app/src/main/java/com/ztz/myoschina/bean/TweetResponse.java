package com.ztz.myoschina.bean;

/**
 * Created by wqewqe on 2017/5/9.
 */

public class TweetResponse {

    /**
     * imgBig : https://static.oschina.net/uploads/space/2017/0508/111625_1Dhq_244077.jpg,2017/0508/111632_T89t_244077.jpg,2017/0508/111636_GXbv_244077.jpg,2017/0508/111641_LggR_244077.jpg,2017/0508/111644_I7Pd_244077.jpg
     * author : 最爱不懂
     * id : 13193733
     * portrait : https://static.oschina.net/uploads/user/122/244077_50.jpg?t=1491745270000
     * authorid : 244077
     * body : <a href='https://my.oschina.net/u/2921900' target="_blank" rel="nofollow">@吕不懂。</a> 需要准备的东西,我都准备好了,我在民政局大厅等你......
     * pubDate : 2017-05-08 11:15:52
     * imgSmall : https://static.oschina.net/uploads/space/2017/0508/111625_1Dhq_244077_thumb.jpg,2017/0508/111632_T89t_244077_thumb.jpg,2017/0508/111636_GXbv_244077_thumb.jpg,2017/0508/111641_LggR_244077_thumb.jpg,2017/0508/111644_I7Pd_244077_thumb.jpg
     * commentCount : 82
     */

    private String imgBig;
    private String author;
    private int id;
    private String portrait;
    private int authorid;
    private String body;
    private String pubDate;
    private String imgSmall;
    private int commentCount;

    public String getImgBig() {
        return imgBig;
    }

    public void setImgBig(String imgBig) {
        this.imgBig = imgBig;
    }

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

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
