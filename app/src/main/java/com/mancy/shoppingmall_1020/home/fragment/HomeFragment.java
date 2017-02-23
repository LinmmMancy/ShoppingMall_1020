package com.mancy.shoppingmall_1020.home.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mancy.shoppingmall_1020.R;
import com.mancy.shoppingmall_1020.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mancy on 2017/2/22.
 * <p>
 * 主页
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tv_search_home)
    TextView tvSearchHome;
    @BindView(R.id.tv_message_home)
    TextView tvMessageHome;
    @BindView(R.id.rv_home)
    android.support.v7.widget.RecyclerView rvHome;
    @BindView(R.id.ib_top)
    ImageButton ibTop;
    private TextView textView;


    @Override
    public View initView() {

        View view = View.inflate(mcontext, R.layout.fragment_home, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();


        Log.e("TAG", "initData: 主页内容");
    }


    @OnClick({R.id.tv_search_home, R.id.tv_message_home, R.id.rv_home, R.id.ib_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search_home:
                Toast.makeText(mcontext, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_message_home:
                Toast.makeText(mcontext, "消息", Toast.LENGTH_SHORT).show();

                break;

            case R.id.ib_top:

                Toast.makeText(mcontext, "置顶", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
