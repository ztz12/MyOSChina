package com.ztz.myoschina.bean;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/10.
 */

public class CommentResponse2 {

    /**
     * commentList : [{"commentPortrait":"https://static.oschina.net/uploads/user/526/1052786_50.jpg?t=1414912475000","commentAuthorId":1052786,"commentAuthor":"BeGit","id":13228449,"client_type":0,"pubDate":"2017-05-10 12:36:55","content":"那个连接地址，我这好像没有"}]
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private NoticeBean notice;
    private List<CommentListBean> commentList;

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class NoticeBean {
        /**
         * referCount : 0
         * replyCount : 0
         * msgCount : 0
         * fansCount : 0
         */

        private int referCount;
        private int replyCount;
        private int msgCount;
        private int fansCount;

        public int getReferCount() {
            return referCount;
        }

        public void setReferCount(int referCount) {
            this.referCount = referCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getMsgCount() {
            return msgCount;
        }

        public void setMsgCount(int msgCount) {
            this.msgCount = msgCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }
    }

    public static class CommentListBean {
        /**
         * commentPortrait : https://static.oschina.net/uploads/user/526/1052786_50.jpg?t=1414912475000
         * commentAuthorId : 1052786
         * commentAuthor : BeGit
         * id : 13228449
         * client_type : 0
         * pubDate : 2017-05-10 12:36:55
         * content : 那个连接地址，我这好像没有
         */

        private String commentPortrait;
        private int commentAuthorId;
        private String commentAuthor;
        private int id;
        private int client_type;
        private String pubDate;
        private String content;

        public String getCommentPortrait() {
            return commentPortrait;
        }

        public void setCommentPortrait(String commentPortrait) {
            this.commentPortrait = commentPortrait;
        }

        public int getCommentAuthorId() {
            return commentAuthorId;
        }

        public void setCommentAuthorId(int commentAuthorId) {
            this.commentAuthorId = commentAuthorId;
        }

        public String getCommentAuthor() {
            return commentAuthor;
        }

        public void setCommentAuthor(String commentAuthor) {
            this.commentAuthor = commentAuthor;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getClient_type() {
            return client_type;
        }

        public void setClient_type(int client_type) {
            this.client_type = client_type;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
