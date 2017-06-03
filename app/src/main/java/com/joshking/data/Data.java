package com.joshking.data;

/**
 * Created by Joshking on 2017/6/3.
 */

public class Data {

    private String title;//标题
    private String content;//内容
    private String times;//时间
    private int ids;//编号


    public Data(String ti, String con, String time, int id){
        this.title = ti;
        this.content = con;
        this.times = time;
        this.ids = id;
    }

    public Data(String ti, String con, String time){
        this.title=ti;
        this.content=con;
        this.times=time;
    }

    public Data(String ti, String time, int i){
        this.ids=i;
        this.title=ti;
        this.times=time;
    }

    public Data(String ti, String con){
        this.title=ti;
        this.content=con;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTimes() {
        return times;
    }

    public int getIds() {
        return ids;
    }
}
