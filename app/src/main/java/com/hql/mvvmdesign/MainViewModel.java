package com.hql.mvvmdesign;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.hql.mvvmdesign.bean.ItemBean;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/17
 * <br /> Description :
 */
public class MainViewModel extends ViewModel {
    //private Activity mActivity;
    //private ActivityMainBinding mBinding;

    // 用 @Bindable 标记过参数\方法会在 BR 中生成一个 entry。 当数据发生变化时需要调用 notifyPropertyChanged(BR.content) 通知系统 BR.content这个 entry 的数据已经发生变化以更新UI。
    //@Bindable
    public ObservableField<Integer> choose = new ObservableField<>();
    private MainModel mMainModel;
    //private IView mView;
    private  ArrayList<ItemBean> mListData = new ArrayList<>();
    public ObservableField<Boolean> isUpdateList = new ObservableField<>(false);
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public MainViewModel() {
        //mActivity = activity;
        //mView = view;
        choose.set(0);
        mMainModel = new MainModel(callBack);
        mMainModel.getPicList(choose.get());
        mListData = new ArrayList<>();
        //observe
    }

    public void onCheckRB(View view) {
        Log.d("hql", "点击事件 :" + view.getId());
        //mHandler.sendEmptyMessageDelayed(1, 5000);
        if (choose.get() == 0) {
            choose.set(1);

        } else {
            choose.set(0);
        }
        //notifyPropertyChanged(BR.choose);

        mMainModel.getPicList(choose.get());
    }

    public ArrayList<ItemBean> getListData() {
        return mListData;
    }

    private MainModel.onModelCallBack callBack = new MainModel.onModelCallBack() {
        @Override
        public void onGetPicList(ArrayList<ItemBean> list) {
            Log.d("hql", "回调事件  更新列表:"+list.size());
            mListData.clear();
            mListData.addAll(list);
            isUpdateList.set(!isUpdateList.get());
            //mView.updateList(list);
        }
    };
}
