package com.mancy.shoppingmall_1020.shoppingcart.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.shoppingmall_1020.base.BaseFragment;

/**
 * Created by Mancy on 2017/2/22.
 * <p>
 * 购物车
 */

public class ShoppingCartFragment extends BaseFragment {

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

        textView.setText("我是购物车");

        Log.e("TAG", "initData: 购物车内容");
    }
}
