package com.hql.mvvmdesign;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import com.hql.mvvmdesign.bean.ItemBean;
import com.hql.mvvmdesign.databinding.ActivityMainBinding;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/17
 * <br /> Description :
 */
public class MainViewModel extends BaseObservable {
    private Activity mActivity;
    //private ActivityMainBinding mBinding;

    // 用 @Bindable 标记过参数\方法会在 BR 中生成一个 entry。 当数据发生变化时需要调用 notifyPropertyChanged(BR.content) 通知系统 BR.content这个 entry 的数据已经发生变化以更新UI。
    //@Bindable
    public ObservableField<Integer> choose = new ObservableField<>();
    private MainModel mMainModel;
    private IView mView;
    public MainViewModel(Activity activity, IView view ) {
        mActivity = activity;
        mView = view;
        choose.set(0);
        mMainModel = new MainModel(callBack);
        mMainModel.getPicList(choose.get());
    }

    public void onCheckRB(View view) {
        Log.d("hql", "点击事件 :" + view.getId());
        if (choose.get() == 0) {
            choose.set(1);

        } else {
            choose.set(0);
        }
        //notifyPropertyChanged(BR.choose);

        mMainModel.getPicList(choose.get());

    }
    private MainModel.onModelCallBack callBack = new MainModel.onModelCallBack() {
        @Override
        public void onGetPicList(ArrayList<ItemBean> list) {
            Log.d("hql", "回调事件 :" );
            mView.updateList(list);
        }
    };
}
