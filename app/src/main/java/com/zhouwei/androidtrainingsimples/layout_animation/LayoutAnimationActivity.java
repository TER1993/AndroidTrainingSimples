package com.zhouwei.androidtrainingsimples.layout_animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import com.zhouwei.androidtrainingsimples.R;

/**
 *
 * @author xu
 * @date 17/3/31
 */

public class LayoutAnimationActivity extends AppCompatActivity {

    private LayoutAnimationController mAnimationController;

    private LinearLayout mLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.setting_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.text_alpha);
        animation.setFillAfter(true);
        mAnimationController = new LayoutAnimationController(animation);
        mAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        // mAnimationController.setDelay(1.2f);

        mLayout = findViewById(R.id.layout_container);
        mLayout.setLayoutAnimation(mAnimationController);

    }

    @Override
    protected void onResume() {
        super.onResume();
        startAnim();
    }

    private void startAnim(){
        mLayout.setVisibility(View.VISIBLE);
        mAnimationController.start();
    }

}
