package com.hql.mvvmdesign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hql.mvvmdesign.bean.ItemBean;
import com.hql.mvvmdesign.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView {
    private MainViewModel viewModel;
    private ActivityMainBinding mBinding;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        viewModel = new MainViewModel(this, this);
        mBinding.setViewModel(viewModel);
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mBinding.rcList.setLayoutManager(manager);
        mListAdapter = new ListAdapter(this);
        mBinding.rcList.setAdapter(mListAdapter);
    }


    @Override
    public void updateList(ArrayList<ItemBean> list) {
        mListAdapter.updateList(list);
    }
}
