package com.hql.mvvmdesign;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hql.mvvmdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private ListAdapter mListAdapter;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //取得viewModel
        mMainViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MainViewModel.class);
        mBinding.setViewModel(mMainViewModel);
        initView();
        mMainViewModel.initData();
    }

    private void initView() {
        Log.d("hql", "初始化view");
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mBinding.rcList.setLayoutManager(manager);
        mListAdapter = new ListAdapter(this);
        mBinding.rcList.setAdapter(mListAdapter);
        mMainViewModel.isUpdateList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("hql", "isUpdateList isListVisible  sender :" + ((ObservableField<Boolean>) sender).get() + ">>propertyId>" + propertyId);
                mListAdapter.updateList(mMainViewModel.getListData());
            }
        });
        mMainViewModel.isListVisible.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("hql", "isListVisible  sender :" + sender.toString() + ">>propertyId>" + propertyId);
                mBinding.rcList.setVisibility(mMainViewModel.isListVisible.get() ? View.VISIBLE : View.GONE);
                mBinding.btnShowList.setText(mMainViewModel.isListVisible.get() ? "点击隐藏列表" : "点击显示列表");
            }
        });
    }
}
