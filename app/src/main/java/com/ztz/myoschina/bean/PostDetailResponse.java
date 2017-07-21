package com.ztz.myoschina.bean;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/8.
 */

public class PostDetailResponse {

    /**
     * answerCount : 1
     * author : 局长
     * id : 2241145
     * viewCount : 23
     * title : 高手问答第 152 期 — 聊聊架构，洞见架构之道
     * portrait : https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000
     * body : <style type='text/css'>pre {white-space:pre-wrap;word-wrap:break-word;}</style><p>OSCHINA 本期高手问答（<strong>2017&nbsp;</strong><strong>年 5&nbsp;月 9&nbsp;日 — 5&nbsp;月 15&nbsp;日</strong>）我们请来了<a href='https://my.oschina.net/u/3446899' target="_blank" rel="nofollow"></a><a href='https://my.oschina.net/u/3446899' target="_blank" rel="nofollow">@kevinarch</a> （王概凯）为大家解答关于架构的问题。</p>
     <p>王概凯，资深架构师，《聊聊架构》一书作者。</p>
     <p>提起“架构”，大部分开发者都会觉得十分高大上、遥不可及。他们或许会认为这对于开发没有实质性的帮助。但其实不然，站在更高的维度上看待和思考问题，能带来不一样的思路和启发。这对于开发恰恰是十分重要的，毕竟开发就是思考的结晶。</p>
     <p>再看现在的技术圈子，关于架构的讨论和分享很多，不少公司都乐意分享自己的架构实践、架构图，也会有很多同行互相参考、借鉴。但事实上，因为公司的业务、规模、发展情况都不一样，所以很多时候会发现很难实现真正意义上的借鉴。究其根本，是因为大家缺少对架构的本质理念的思考。没能透过众多的架构相关分享看清架构的本质，何以真正解决问题？</p>
     <p>本期高手问答欢迎大家围绕架构这个话题，一起探讨架构的相关问题。</p>
     <p>为了鼓励踊跃提问，<a href='https://my.oschina.net/u/2720166' target="_blank" rel="nofollow"></a><a href='https://my.oschina.net/u/2720166' target="_blank" rel="nofollow">@局长</a> 会在问答结束后从提问者中抽取&nbsp;<strong>5&nbsp;</strong>名幸运会员赠予<strong>《聊聊架构》</strong>一书。</p>
     <p><img alt="" src="https://static.oschina.net/uploads/space/2017/0508/181113_ifOt_2720166.jpg"></p>
     <p>本书通过大量的实例，一步一步揭示出架构背后的原理，以及架构在软件行业的发展，并通过企业实例来展示软件架构的实际应用，向读者揭示最本质的架构之道。</p>
     <p>购买方式：请扫描下方二维码进行购买</p>
     <p><img alt="" src="https://static.oschina.net/uploads/space/2017/0508/180612_Y6Dn_2720166.png"></p>
     <p><span style="color:#008080"><strong>OSChina 高手问答一贯的风格，不欢迎任何与主题无关的讨论和喷子。</strong></span></p>
     <p>下面欢迎大家就架构相关的问题向<a href='https://my.oschina.net/u/3446899' target="_blank" rel="nofollow"></a><a href='https://my.oschina.net/u/3446899' target="_blank" rel="nofollow">@kevinarch</a> 提问，请直接回帖提问。</p>
     * authorid : 2720166
     * pubDate : 2017-05-08 18:43:52
     * favorite : 0
     * url : https://www.oschina.net/question/2720166_2241145
     * tags : ["高手问答"]
     */

    private int answerCount;
    private String author;
    private int id;
    private int viewCount;
    private String title;
    private String portrait;
    private String body;
    private int authorid;
    private String pubDate;
    private int favorite;
    private String url;
    private List<String> tags;

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
