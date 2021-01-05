package GAAAA.AccountBook.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import GAAAA.AccountBook.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //如果欢迎页面不在最底层，则关闭页面
        if(!isTaskRoot()){
            finish();
        }

        //延时进入主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行在主线程
                //启动主页面
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                //关闭当前页面
                finish();

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        },2000);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus && Build.VERSION.SDK_INT >= 21);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}