package com.zhouwei.androidtrainingsimples;

import android.support.v7.widget.DividerItemDecoration;

import com.zhouwei.rvadapterlib.base.Cell;
import com.zhouwei.rvadapterlib.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouwei on 17/3/20.
 */

public class HomeFragment extends AbsBaseFragment<String> {
    public static final String TITLE[] = new String[]{
            "无效"
            ,"无效"
            ,"ViewPagerWrapper Simple"
            ,"SnapHelper Simple"
            ,"LayoutAnimation Simple"
            ,"CalendarView Simples"
            ,"Android 底部导航栏最佳实践"
            ,"Service Simple"
            ,"仿掌上英雄联盟皮肤浏览效果"
            ,"Glide Simples"
            ,"Rx_FlapMap_Simple"
            ,"Inflate simples"
            ,"弧形HeaderView"
            ,"弧形ViewPager"
            ,"弧形HeaderView图片背景"
    };
    @Override
    public void onRecyclerViewInitialized() {
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mBaseAdapter.setData(getCells(Arrays.asList(TITLE)));
    }

    @Override
    public void onPullRefresh() {
      mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected List<Cell> getCells(List<String> list) {
        List<Cell> cells = new ArrayList<>();
        for (int i=0;i< list.size();i++){
            cells.add(new MainItemCell(list.get(i)));
        }
        return cells;
    }
}
