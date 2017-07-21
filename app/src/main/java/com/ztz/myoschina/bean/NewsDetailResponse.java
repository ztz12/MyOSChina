package com.ztz.myoschina.bean;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/8.
 */

public class NewsDetailResponse {

    /**
     * author : snowdream
     * id : 84560
     * authorid : 190084
     * title : ToyBricks 0.9.10 发布，安卓项目模块化解决方案
     * body : <style type='text/css'>pre {white-space:pre-wrap;word-wrap:break-word;}</style><p>&nbsp;ToyBricks 是一个Android项目模块化的解决方案，主要包括四个部分，APT注解，APT注解处理器，ToyBricks 插件（Gradle Plugin）,ToyBricks 库。<br><img src="http://upload-images.jianshu.io/upload_images/66954-57bf455f0fdee874.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240"></p>
     <h3>更新内容：</h3>
     <ol>
     <li><p>新增校验功能，不符合规则将导致编译失败。</p></li>
     <li><p>新增对Kotlin的支持，现在可以同时支持Kotlin，Java</p></li>
     <li><p>新增对Android Build Variants的支持</p></li>
     <li><p>新增对Proguard免配置的支持</p></li>
     </ol>
     * pubDate : 2017-05-08 11:14:24
     * favorite : 0
     * url : https://www.oschina.net/news/84560/toybricks-0-9-10
     * relativies : [{"title":"KBEngine v0.9.10 发布，分布式游戏服务端引擎","url":"https://www.oschina.net/news/81576/kbengine-0-9-10"},{"title":"Apache Guacamole 0.9.10，无客户端远程桌面网关","url":"https://www.oschina.net/news/80557/apache-guacamole-0-9-10"},{"title":"Onyx 0.9.10-beta4 发布，分布式计算系统","url":"https://www.oschina.net/news/77015/onyx-0-9-10-beta4"},{"title":"Onyx 0.9.10-beta2 和 beta3，分布式计算系统","url":"https://www.oschina.net/news/76985/onyx-0-9-10-beta2-beta3"},{"title":"Onyx 0.9.10-beta1 发布，分布式计算系统","url":"https://www.oschina.net/news/76516/onyx-0-9-10-beta1"},{"title":"rspamd 0.9.10 发布，反垃圾邮件系统","url":"https://www.oschina.net/news/65400/rspamd-0-9-10"},{"title":"HPX 0.9.10 发布，并行 C++ 运行时系统","url":"https://www.oschina.net/news/60862/hpx-0-9-10"},{"title":"NeoLua-0.9.10 发布，Lua 的 .NET 实现","url":"https://www.oschina.net/news/58334/neolua-0-9-10"},{"title":"NetworkManager 0.9.10 即将发布，网络管理工具","url":"https://www.oschina.net/news/53047/well-build-a-dream-house-of-net"},{"title":"PdfParser 0.9.10 版本发布，PHP的PDF解析库","url":"https://www.oschina.net/news/46742/pdfparser-0-9-10"}]
     * commentCount : 2
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private String author;
    private int id;
    private int authorid;
    private String title;
    private String body;
    private String pubDate;
    private int favorite;
    private String url;
    private int commentCount;
    private NoticeBean notice;
    private List<RelativiesBean> relativies;

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

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<RelativiesBean> getRelativies() {
        return relativies;
    }

    public void setRelativies(List<RelativiesBean> relativies) {
        this.relativies = relativies;
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

    public static class RelativiesBean {
        /**
         * title : KBEngine v0.9.10 发布，分布式游戏服务端引擎
         * url : https://www.oschina.net/news/81576/kbengine-0-9-10
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
