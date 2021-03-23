package com.hql.mvvmdesign;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hql.mvvmdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IView {
    //private MainViewModel viewModel;
    private ActivityMainBinding mBinding;
    private ListAdapter mListAdapter;
    private MainViewModel mMainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //viewModel = new MainViewModel();

        mMainViewModel =  new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MainViewModel.class);
        mBinding.setViewModel(mMainViewModel);
        initView();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mBinding.rcList.setLayoutManager(manager);
        mListAdapter = new ListAdapter(this,mMainViewModel.getListData());
        mBinding.rcList.setAdapter(mListAdapter);
        mMainViewModel.isUpdateList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("hql","收到监听变化 size:"+mMainViewModel.getListData().size());
                mListAdapter.updateList(mMainViewModel.getListData());
            }
        });
    }


//    @Override
//    public void updateList(ArrayList<ItemBean> list) {
//        mListAdapter.updateList(list);
//    }
}
