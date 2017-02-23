package com.mancy.shoppingmall_1020;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.mancy.shoppingmall_1020.base.BaseFragment;
import com.mancy.shoppingmall_1020.conmmunity.fragment.CommunityFragment;
import com.mancy.shoppingmall_1020.home.fragment.HomeFragment;
import com.mancy.shoppingmall_1020.shoppingcart.fragment.ShoppingCartFragment;
import com.mancy.shoppingmall_1020.type.fragment.TypeFragment;
import com.mancy.shoppingmall_1020.user.fragment.UserFragemnt;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private ArrayList<BaseFragment> fragments;


    // fragment 相对应的位置
    private int position;

    // 刚才被显示的fragment

    private Fragment tempFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //初始化 fragment

        initFragment();

        // 监听  radiogroup 状态的改变   并且切换到不同的fragment

        initListener();


    }

    private void initListener() {

         //  根据 点击事件 查找fragment

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;

                        break;
                    case R.id.rb_type:

                        position = 1;
                        break;
                    case R.id.rb_community:

                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;

                }

                //根据位置切换到对应的frament
                Fragment currentFragment = fragments.get(position);

                SwitchFragment(currentFragment);
            }
        });
            // 进入主页 默认的选择
        rgMain.check(R.id.rb_home);
    }

    private void SwitchFragment(Fragment currentFragment) {

        //切换到不同的页面

        if (tempFragment != currentFragment) {
            //得到fragmentMager

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();


            //如果没添加就添加

            if (!currentFragment.isAdded()) {

                // 缓存的隐藏

                if (tempFragment != null) {

                    ft.hide(tempFragment);

                }

                //添加

                ft.add(R.id.fl_main, currentFragment);


            } else {

                //缓存的隐藏

                if (tempFragment != null) {

                    ft.hide(tempFragment);
                }


                //显示

                ft.show(currentFragment);

            }

            //事物的提交

            ft.commit();


            //把当前的赋值成缓存的

            tempFragment = currentFragment;

        }


    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new HomeFragment());  // 添加  主页
        fragments.add(new TypeFragment()); // 添加  分类
        fragments.add(new CommunityFragment()); // 添加  发现
        fragments.add(new ShoppingCartFragment());   // 添加  购物车
        fragments.add(new UserFragemnt());   // 添加  用户

    }
}
