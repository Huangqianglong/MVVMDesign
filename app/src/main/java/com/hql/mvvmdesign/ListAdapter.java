package com.hql.mvvmdesign;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.hql.mvvmdesign.bean.ItemBean;

import java.util.ArrayList;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/18
 * <br /> Description :
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.BindingViewHolder> {
    private ArrayList<ItemBean> mData;
    public LayoutInflater mInflater;
    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(mInflater, R.layout.item_list, null, false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        //binding.setVariable(c)
        binding.setVariable(BR.info, mData.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateList(ArrayList<ItemBean> list) {
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
        Log.d("hql", "list 大小：" + list.size());
    }


    public static class BindingViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;

        public BindingViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            mBinding = dataBinding;
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }
    }

}
