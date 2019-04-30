package com.example.afalse.androidmonthdemo.bean;

public class DynastyText {
    private String title;   //古诗的名字
    private String count;   //古诗内容

    @Override
    public String toString() {
        return "DynastyText{" +
                "title='" + title + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public DynastyText(String title, String count) {

        this.title = title;
        this.count = count;
    }
}
