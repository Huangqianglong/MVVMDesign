package com.hql.mvvmdesign.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/18
 * <br /> Description :
 */
public class ItemBean extends BaseObservable {
    String title;
    String url;


    public String getTitle() {
        return title;
    }

    @Bindable
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    @Bindable
    public void setUrl(String url) {
        this.url = url;
    }
}
