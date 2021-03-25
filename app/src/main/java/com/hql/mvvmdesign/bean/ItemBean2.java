package com.hql.mvvmdesign.bean;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/23
 * <br /> Description :
 *  与com.hql.mvvmdesign.ItemBean.ItemBean 的区别在于没有继承BaseObservable和@Bindable，并且title和url是public修饰
 *  databinging需要实现监听private修饰变量的改变就要这么做
 */
public class ItemBean2 {
    public String title;
    public String url;

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
