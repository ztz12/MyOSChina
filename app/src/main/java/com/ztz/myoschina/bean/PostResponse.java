package com.ztz.myoschina.bean;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/3.
 */

public class PostResponse {

    /**
     * post_list : [{"answerCount":38,"answer":{"name":"sca7","time":"2017-05-03 18:35:35"},"author":"局长","id":2240334,"viewCount":1943,"title":"高手问答第 151 期 \u2014 人工智能／机器学习在电商场景下的应用","portrait":"https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000","authorid":2720166,"pubDate":"2017-05-01 22:17:28"},{"answerCount":0,"answer":"","author":"达尔文","id":2240582,"viewCount":106,"title":"【开源访谈】奇虎 360 陈宗志：开源能让项目走得更长久","portrait":"https://static.oschina.net/uploads/user/1451/2903254_50.jpg?t=1475462273000","authorid":2903254,"pubDate":"2017-05-03 14:22:32"},{"answerCount":0,"answer":"","author":"wzlinpc","id":2240622,"viewCount":0,"title":"eclipse hadoop 2.6.0插件访问hdfs，提示simple authentication is not enabled. ","portrait":"https://www.oschina.net/img/portrait.gif","authorid":3464465,"pubDate":"2017-05-03 19:39:30"},{"answerCount":0,"answer":"","author":"阿杰杰杰杰_gj","id":2240621,"viewCount":1,"title":"Jfinal能否在没有Action能匹配时执行通配Action","portrait":"https://static.oschina.net/uploads/user/1267/2535334_50.jpg?t=1448589225000","authorid":2535334,"pubDate":"2017-05-03 19:30:22"},{"answerCount":4,"answer":{"name":"逐日追星族","time":"2017-05-03 19:22:42"},"author":"PeterDWang","id":2240583,"viewCount":101,"title":"java 如何实现后台消息提醒功能","portrait":"https://static.oschina.net/uploads/user/1243/2486379_50.jpeg?t=1474353351000","authorid":2486379,"pubDate":"2017-05-03 14:23:41"},{"answerCount":0,"answer":"","author":"逆旅baby","id":2240620,"viewCount":2,"title":"请问，echarts里面怎样提前判断节点是否可以点击？","portrait":"https://static.oschina.net/uploads/user/1720/3440474_50.jpg?t=1492678083000","authorid":3440474,"pubDate":"2017-05-03 18:48:23"},{"answerCount":0,"answer":"","author":"sca7","id":2240619,"viewCount":1,"title":"时有促销活动，应该是怎么基于用户的 行为和节日的活动做促销的评分和排序？","portrait":"https://static.oschina.net/uploads/user/995/1991666_50.jpg?t=1472456196000","authorid":1991666,"pubDate":"2017-05-03 18:48:19"},{"answerCount":0,"answer":"","author":"VcGo","id":2240618,"viewCount":2,"title":"ES 大数据量的聚合","portrait":"https://static.oschina.net/uploads/user/1604/3209795_50.jpg?t=1483795016000","authorid":3209795,"pubDate":"2017-05-03 18:46:52"},{"answerCount":0,"answer":"","author":"sca7","id":2240617,"viewCount":4,"title":"商城每天每周都有很多新加入的商品，如何打评分？","portrait":"https://static.oschina.net/uploads/user/995/1991666_50.jpg?t=1472456196000","authorid":1991666,"pubDate":"2017-05-03 18:32:09"},{"answerCount":19,"answer":{"name":"李永曜","time":"2017-05-03 18:23:56"},"author":"HEI_MARK","id":2240543,"viewCount":329,"title":"一个java运行时字符串值诡异的问题！！！！","portrait":"https://www.oschina.net/img/portrait.gif","authorid":2329147,"pubDate":"2017-05-03 10:24:38"},{"answerCount":8,"answer":{"name":"孤单的不同世界","time":"2017-05-03 18:18:17"},"author":"GKTest","id":2240584,"viewCount":138,"title":"js转换json的时候，大的数值会改变，怎么解决","portrait":"https://static.oschina.net/uploads/user/793/1587335_50.png?t=1424830554000","authorid":1587335,"pubDate":"2017-05-03 14:27:42"},{"answerCount":7,"answer":{"name":"Shabby-滔","time":"2017-05-03 18:01:52"},"author":"shinningEyes丶果果","id":2240529,"viewCount":172,"title":"Java如何在不引入插件的前提下实现word文档的解析","portrait":"https://static.oschina.net/uploads/user/1730/3461076_50.jpeg?t=1493694549000","authorid":3461076,"pubDate":"2017-05-03 08:33:44"},{"answerCount":0,"answer":"","author":"风中海岸","id":2240616,"viewCount":1,"title":"row_number () OVER 如何转化为MYSQL的，多条件的","portrait":"https://static.oschina.net/uploads/user/737/1474779_50.jpg?t=1440900689000","authorid":1474779,"pubDate":"2017-05-03 17:53:57"},{"answerCount":0,"answer":"","author":"脑残酸菜","id":2240615,"viewCount":8,"title":"【求助大神】初学activiti,自定义用户组（角色），同角色不通部门如何处理","portrait":"https://www.oschina.net/img/portrait.gif","authorid":3464188,"pubDate":"2017-05-03 17:45:09"},{"answerCount":0,"answer":"","author":"奔跑者_cc","id":2240609,"viewCount":11,"title":"elasticsearch插入成功但是搜索缺搜索不到？","portrait":"https://static.oschina.net/uploads/user/1410/2821071_50.jpg?t=1470993400000","authorid":2821071,"pubDate":"2017-05-03 17:29:26"},{"answerCount":1,"answer":{"name":"自由自在的小鱼","time":"2017-05-03 17:18:25"},"author":"mason598","id":2240597,"viewCount":48,"title":"php如何解 QRcode","portrait":"https://www.oschina.net/img/portrait.gif","authorid":3461390,"pubDate":"2017-05-03 16:18:08"},{"answerCount":1,"answer":{"name":"忧郁的小王子","time":"2017-05-03 17:04:05"},"author":"秋风秋雨","id":2240603,"viewCount":27,"title":"MySQL 浮点型的精度范围与四舍五入","portrait":"https://www.oschina.net/img/portrait.gif","authorid":3222159,"pubDate":"2017-05-03 16:59:10"},{"answerCount":0,"answer":"","author":"火影T2","id":2240601,"viewCount":13,"title":"如何实现游戏自动准备","portrait":"https://www.oschina.net/img/portrait.gif","authorid":3217912,"pubDate":"2017-05-03 16:48:10"},{"answerCount":2,"answer":{"name":"漆黑的烈焰使","time":"2017-05-03 16:45:08"},"author":"CheneyWong","id":2240590,"viewCount":11,"title":"哪里有开源的 andriod hybrid 开发壳？","portrait":"https://static.oschina.net/uploads/user/129/258792_50.jpg?t=1376114047000","authorid":258792,"pubDate":"2017-05-03 15:45:50"},{"answerCount":2,"answer":{"name":"漆黑的烈焰使","time":"2017-05-03 16:43:10"},"author":"有梦想的菜鸟程序媴","id":2240361,"viewCount":16,"title":"怎么同时检测多个网络请求完成，结果是相互依赖且并联的","portrait":"https://static.oschina.net/uploads/user/1536/3072401_50.jpeg?t=1479947102000","authorid":3072401,"pubDate":"2017-05-02 10:50:53"}]
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private NoticeBean notice;
    private List<PostListBean> post_list;

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<PostListBean> getPost_list() {
        return post_list;
    }

    public void setPost_list(List<PostListBean> post_list) {
        this.post_list = post_list;
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

    public static class PostListBean {
        /**
         * answerCount : 38
         * answer : {"name":"sca7","time":"2017-05-03 18:35:35"}
         * author : 局长
         * id : 2240334
         * viewCount : 1943
         * title : 高手问答第 151 期 — 人工智能／机器学习在电商场景下的应用
         * portrait : https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000
         * authorid : 2720166
         * pubDate : 2017-05-01 22:17:28
         */

        private int answerCount;
        private AnswerBean answer;
        private String author;
        private int id;
        private int viewCount;
        private String title;
        private String portrait;
        private int authorid;
        private String pubDate;

        public int getAnswerCount() {
            return answerCount;
        }

        public void setAnswerCount(int answerCount) {
            this.answerCount = answerCount;
        }

        public AnswerBean getAnswer() {
            return answer;
        }

        public void setAnswer(AnswerBean answer) {
            this.answer = answer;
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

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public static class AnswerBean {
            /**
             * name : sca7
             * time : 2017-05-03 18:35:35
             */

            private String name;
            private String time;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
