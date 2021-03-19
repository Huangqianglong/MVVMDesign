package com.hql.mvvmdesign;

import com.hql.mvvmdesign.bean.ItemBean;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/17
 * <br /> Description :
 */
public class MainModel {
    private String[] animal = new String[]{"https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3002158521,1917679147&fm=26&gp=0.jpg",
            "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3696122063,3336290491&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1123729743,2925020587&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2695158842,1510507004&fm=26&gp=0.jpg"
            , "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3158493700,1959212419&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2455455903,1837933558&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=295536446,3788772626&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3232477584,2308603899&fm=26&gp=0.jpg"
    };
    private String[] scenery = new String[]{
            "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2926199504,3558053336&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2070700487,1289116766&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2645146465,2274849274&fm=26&gp=0.jpg"
            , "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=186994698,2465857429&fm=26&gp=0.jpg"
            , "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1707371206,3427308196&fm=26&gp=0.jpg"
            , "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1847995214,2223562836&fm=26&gp=0.jpg"
            , "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=364397611,3916868751&fm=26&gp=0.jpg"
            , "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1515412546,198037659&fm=26&gp=0.jpg"

    };
    onModelCallBack mCallBack;

    public MainModel(onModelCallBack callBack) {
        mCallBack = callBack;
    }

    ArrayList<ItemBean> mDataList = new ArrayList<>();

    public void getPicList(int choose) {
        mDataList.clear();
        switch (choose) {
            case 0:
                for (int i = 0; i < animal.length; i++) {
                    ItemBean itemBean = new ItemBean();
                    itemBean.setTitle(("Title" + i));
                    itemBean.setUrl(animal[i]);
                    mDataList.add(itemBean);
                }

                break;
            case 1:
                for (int i = 0; i < scenery.length; i++) {
                    ItemBean itemBean = new ItemBean();
                    itemBean.setTitle(("Title" + i));
                    itemBean.setUrl(scenery[i]);
                    mDataList.add(itemBean);
                }
                break;
            default:
                break;
        }
        mCallBack.onGetPicList(mDataList);
    }

    interface onModelCallBack {
        void onGetPicList(ArrayList<ItemBean> list);
    }
}
