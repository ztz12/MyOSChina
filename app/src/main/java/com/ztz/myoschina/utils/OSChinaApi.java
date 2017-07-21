package com.ztz.myoschina.utils;

/**
 * Created by wqewqe on 2017/4/27.
 */

public class OSChinaApi {
    public static final String HOST="http://www.oschina.net";//主机地址
    public static final String TOKEN=HOST+"/action/openapi/token";
    public static final String NEWS_LIST=HOST+"/action/openapi/news_list";

    //问答
    public static final String POST_LIST=HOST+"/action/openapi/post_list";

    //获取动弹列表 
    public static final String TWEET_LIST = HOST + "/action/openapi/tweet_list";
    //新闻详情
    public static final String NEWS_DETAIL=HOST+"/action/openapi/news_detail";

    //帖子详情
    public static final String POST_DETAIL=HOST+"/action/openapi/post_detail";

    //动弹详情
    public static final String TWEET_DETAIL=HOST+"/action/openapi/tweet_detail";

    //评论列表
    public static final String COMMENT_LIST=HOST+"/action/openapi/comment_list";

}
