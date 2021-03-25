package com.hql.mvvmdesign;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

import com.hql.mvvmdesign.bean.ItemBean;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/17
 * <br /> Description :
 */
public class MainViewModel extends AndroidViewModel {
    public ObservableField<Integer> choose = new ObservableField<>();
    private MainModel mMainModel;
    private ArrayList<ItemBean> mListData = new ArrayList<>();
    public ObservableField<Boolean> isUpdateList = new ObservableField<>(false);
    public ObservableField<Boolean> isListVisible = new ObservableField<>(false);
    public ObservableField<String> mEdContent = new ObservableField<>("");
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public MainViewModel(Application application) {
        super(application);
        mMainModel = new MainModel(callBack);
        mListData = new ArrayList<>();
    }

    public void onCheckRB(View view) {
        Log.d("hql", "点击事件 :" + view.getId());
        if (choose.get() == 0) {
            choose.set(1);
        } else {
            choose.set(0);
        }
        mMainModel.getPicList(choose.get());
    }
    private MainModel.onModelCallBack callBack = new MainModel.onModelCallBack() {
        @Override
        public void onGetPicList(ArrayList<ItemBean> list) {
            Log.d("hql", "回调事件  更新列表:" + list.size());
            mListData.clear();
            mListData.addAll(list);
            isUpdateList.set(!isUpdateList.get());
        }
    };

    public ArrayList<ItemBean> getListData() {
        return mListData;
    }
    public void changeListState() {
        isListVisible.set(!isListVisible.get());
    }

    public void initData() {
        choose.set(0);
        mMainModel.getPicList(choose.get());
        isListVisible.set(true);
    }
}
