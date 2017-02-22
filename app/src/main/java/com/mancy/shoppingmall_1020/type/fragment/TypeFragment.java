package com.mancy.shoppingmall_1020.type.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.shoppingmall_1020.base.BaseFragment;

/**
 * Created by Mancy on 2017/2/22.
 * <p>
 * 分类
 */

public class TypeFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {

        textView = new TextView(mcontext);

        textView.setTextColor(Color.RED);

        textView.setTextSize(30);

        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    public void initData() {
        super.initData();

        textView.setText("我是分类");

        Log.e("TAG", "initData: 分类内容");
    }
}
