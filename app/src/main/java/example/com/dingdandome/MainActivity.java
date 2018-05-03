package example.com.dingdandome;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    String[] title = {"全部", "待支付", "已支付", "已取消"};
    public static String ss = "全部";
    private ImageView mImageview1;
    private ImageView mDingdanFan;
    private TabLayout mDingdanTabLayout;
    private ViewPager mViewPager;
    private FrameLayout mDingdanFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDingdanFan = (ImageView) findViewById(R.id.dingdanFan);
        mImageview1 = (ImageView) findViewById(R.id.imageview1);
        mDingdanTabLayout = (TabLayout) findViewById(R.id.dingdanTabLayout);
        mDingdanFrameLayout = (FrameLayout) findViewById(R.id.dingdanFrameLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager1);
        mImageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPopupWindow.showPopupWindow(mViewPager, MainActivity.this, mImageview1);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.dingdanFrameLayout, new MyDingDanFra()).commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < title.length; i++) {
            //添加tab
            mDingdanTabLayout.addTab(mDingdanTabLayout.newTab().setText(title[i]));
        }
        mDingdanTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Toast.makeText(Main6Activity.this,tab.getText(),Toast.LENGTH_SHORT).show();
                if (tab.getText().equals(title[0])) {
                    ss = title[0];
                } else if (tab.getText().equals(title[1])) {
                    ss = title[1];
                } else if (tab.getText().equals(title[2])) {
                    ss = title[2];
                } else if (tab.getText().equals(title[3])) {
                    ss = title[3];
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.dingdanFrameLayout, new MyDingDanFra()).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
