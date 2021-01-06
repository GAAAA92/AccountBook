package GAAAA.AccountBook.Activitys;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import GAAAA.AccountBook.Fragments.LiushuiFragment;
import GAAAA.AccountBook.Fragments.ShezhiFragment;
import GAAAA.AccountBook.Fragments.TongjiFragment;
import GAAAA.AccountBook.Fragments.ZhanghuFragment;
import GAAAA.AccountBook.R;

public class MainActivity extends AppCompatActivity {

    private long firstClickTime = 0, secondClickTime = 0;
    private boolean isFirstClick = true;
    private int currentIndex = 3;


    TextView topTitle;
    FrameLayout centerContent;
    Fragment[] fragments;
    RadioGroup rg_bottom;
    RadioButton[] radioButtons;
    Button btn_add;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusBarFullTransparent();
        setFitSystemWindow(true);

        initView();
        radioButtons[0].setChecked(true);
    }

    //双击退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isFirstClick) {
                firstClickTime = System.currentTimeMillis();
                Toast.makeText(this, "双击退出", Toast.LENGTH_SHORT).show();
                isFirstClick = false;
                return true;   //return true 表示 "自己" 处理按键答复，即不会退出应用
            } else {
                secondClickTime = System.currentTimeMillis();
                if (secondClickTime - firstClickTime < 800) {
                    this.finish();
                    System.exit(0);
                } else {
                    firstClickTime = secondClickTime;
                    Toast.makeText(this, "双击退出", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void initView(){
        topTitle = findViewById(R.id.topTitle);

        centerContent = findViewById(R.id.centerContent);
        fragments = new Fragment[]{ new LiushuiFragment(), new TongjiFragment(), new ZhanghuFragment(), new ShezhiFragment()};

        //设置RadioGroup和RadioBUtton相关事件
        //RadioButton图标大小
        //RadioGroup选中改变事件，切换fragment
        rg_bottom = findViewById(R.id.rg_bottom);
        radioButtons = new RadioButton[]{ findViewById(R.id.rb_liushui), findViewById(R.id.rb_tongji), findViewById(R.id.rb_zhanghu), findViewById(R.id.rb_shezhi)};
        for (int i = 0; i < radioButtons.length; i++){
            Drawable[] drawables = new Drawable[4];
            drawables = radioButtons[i].getCompoundDrawables();
            drawables[1].setBounds(0, 0, 65, 65);
            radioButtons[i].setCompoundDrawables(null, drawables[1],null,null);
        }
        rg_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_liushui:
                        setIndexSelected(0);
                        topTitle.setText("流水");
                        break;
                    case R.id.rb_tongji:
                        setIndexSelected(1);
                        topTitle.setText("统计");
                        break;
                    case R.id.rb_zhanghu:
                        setIndexSelected(2);
                        topTitle.setText("账户");
                        break;
                    case R.id.rb_shezhi:
                        topTitle.setText("设置");
                        setIndexSelected(3);
                        break;
                }
            }
        });

        //Button点击事件，切换到activity_add
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setIndexSelected(int index){
        if(currentIndex == index){
            return;
        }
        ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragments[currentIndex]);
        if(!fragments[index].isAdded()){
            ft.add(centerContent.getId(), fragments[index]).show(fragments[index]);
        }else{
            ft.show(fragments[index]);
        }
        ft.commit();
        currentIndex = index;
    }






















    /**
     * 全透状态栏
     */
    protected void setStatusBarFullTransparent() {
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 如果需要内容紧贴着StatusBar
     * 应该在对应的xml布局文件中，设置根布局fitsSystemWindows=true。
     */
    private View contentViewGroup;

    protected void setFitSystemWindow(boolean fitSystemWindow) {
        if (contentViewGroup == null) {
            contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        }
        contentViewGroup.setFitsSystemWindows(fitSystemWindow);
    }
}