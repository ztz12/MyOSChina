package com.ztz.myoschina.bean;

import java.util.List;

/**
 * Created by wqewqe on 2017/4/27.
 */

public class NewsResponse {

    /**
     * newslist : [{"author":"淡漠悠然","id":86887,"title":"MySQL 5.7.19 发布，开源数据库服务器","type":4,"authorid":2305107,"pubDate":"2017-07-18 10:30:29","commentCount":0},{"author":"Wizzer","id":86886,"title":"NutzWk 4.1.5 发布，Java 企业级开源开发框架","type":4,"authorid":736552,"pubDate":"2017-07-18 10:22:41","commentCount":1},{"author":"许雪里","id":86885,"title":"XXL-JOB v1.8.0 发布，分布式任务调度平台","type":4,"authorid":1046342,"pubDate":"2017-07-18 10:15:00","commentCount":4},{"author":"wendal","id":86884,"title":"nutz-book-project 3.1.0 新增 QQ 机器人模块","type":4,"authorid":61077,"pubDate":"2017-07-18 10:14:10","commentCount":1},{"author":"Tevin","id":86883,"title":"amWiki v1.2.0 发布，增加本地模式","type":4,"authorid":811864,"pubDate":"2017-07-18 09:53:05","commentCount":0},{"author":"wendal","id":86882,"title":"NutzMore 1.r.62 发布，Nutz 官方插件集","type":4,"authorid":61077,"pubDate":"2017-07-18 09:30:03","commentCount":0},{"author":"LoveAngel","id":86881,"title":"SBDoc 2.3.0 发布，支持 rap 和 swagger 的导入","type":4,"authorid":1995470,"pubDate":"2017-07-18 09:25:22","commentCount":2},{"author":"Kerbores","id":86880,"title":"spring-boot-nutz-starter 1.r.62发布","type":4,"authorid":1427223,"pubDate":"2017-07-18 09:12:55","commentCount":1},{"author":"我不是AI","id":86878,"title":"Red language 0.6.3 发布，macOS GUI","type":4,"authorid":126040,"pubDate":"2017-07-18 08:51:50","commentCount":2},{"author":"Google","id":86876,"title":"Nutz 1.r.62 发布，Java 应用框架  ","type":4,"authorid":99667,"pubDate":"2017-07-18 08:35:16","commentCount":6},{"author":"王练","id":86875,"title":"码云推荐 | PHP 性能跟踪监控系统 Fiery","type":0,"authorid":2896879,"pubDate":"2017-07-18 08:14:53","url":"https://git.oschina.net/thinkpc/fiery","object":0,"commentCount":0},{"author":"王练","id":86874,"title":"每日一博 | Spring 思维导图让 Spring 不再难懂之 mvc 篇","type":3,"authorid":2896879,"pubDate":"2017-07-18 08:13:53","commentCount":13,"object":1438733},{"author":"局长","id":86873,"title":"DataGrip 2017.2 RC 发布，多引擎数据库环境","type":4,"authorid":2720166,"pubDate":"2017-07-18 08:11:45","commentCount":7},{"author":"王练","id":86872,"title":"TAITAN \u2014\u2014 实时数据通讯和服务端开发用的网络引擎","type":1,"authorid":2896879,"pubDate":"2017-07-18 08:11:10","object":45641,"commentCount":0},{"author":"王练","id":86871,"title":"协作翻译 | 7 月份五大令人惊叹的 iOS 库","type":7,"authorid":2896879,"pubDate":"2017-07-18 08:10:08","object":10003935,"commentCount":0},{"author":"王练","id":86870,"title":"OSChina 周二乱弹 \u2014\u2014你会教自己的孩子写代码吗","type":3,"authorid":2896879,"pubDate":"2017-07-18 08:03:49","commentCount":25,"object":1454431},{"author":"王练","id":86869,"title":"JetBrains 调查：Java 开发者偏爱 Java 8 和 Spring MVC","type":4,"authorid":2896879,"pubDate":"2017-07-18 08:02:39","commentCount":20},{"author":"局长","id":86868,"title":"PyCharm 2017.2 EAP 7 发布，Python IDE","type":4,"authorid":2720166,"pubDate":"2017-07-18 08:02:02","commentCount":1},{"author":"王练","id":86867,"title":"主流程序员需要知道的九大非主流编程语言","type":4,"authorid":2896879,"pubDate":"2017-07-18 08:01:11","commentCount":10},{"author":"王练","id":86866,"title":"Angular 5 已在路上，承诺会比 Angular 4 更快更小","type":4,"authorid":2896879,"pubDate":"2017-07-18 08:00:22","commentCount":19}]
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private NoticeBean notice;
    private List<NewslistBean> newslist;

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
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

    public static class NewslistBean {
        /**
         * author : 淡漠悠然
         * id : 86887
         * title : MySQL 5.7.19 发布，开源数据库服务器
         * type : 4
         * authorid : 2305107
         * pubDate : 2017-07-18 10:30:29
         * commentCount : 0
         * url : https://git.oschina.net/thinkpc/fiery
         * object : 0
         */

        private String author;
        private int id;
        private String title;
        private int type;
        private int authorid;
        private String pubDate;
        private int commentCount;
        private String url;
        private int object;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAuthorid() {
            return authorid;
        }

        public void setAuthorid(int authorid) {
            this.authorid = authorid;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getObject() {
            return object;
        }

        public void setObject(int object) {
            this.object = object;
        }
    }
}
