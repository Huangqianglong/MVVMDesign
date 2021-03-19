package com.hql.mvvmdesign;

import com.hql.mvvmdesign.bean.ItemBean;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/18
 * <br /> Description :
 */
public interface IView {
    void updateList(ArrayList<ItemBean> list);
}
