package com.hql.mvvmdesign.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/18
 * <br /> Description :
 */
public class ItemBean extends BaseObservable {
    // 用 @Bindable 标记过参数\方法会在 BR 中生成一个 entry。
    // 当数据发生变化时需要调用 notifyPropertyChanged(BR.content)
    // 通知系统 BR.content这个 entry 的数据已经发生变化以更新UI。
    private String title;
    private String url;


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
