package media.t3h.com.smartrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.adapter.PageAdapter;

/**
 * Created by Ngoc on 9/1/2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getName();
    private DrawerLayout mDrawer;
    private TextView mTxtAboutApp, mTxtOrderTable, mTxtListFood;
    ViewPager pager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
//        ivMenu = (ImageView) findViewById(R.id.iv_menu_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTxtAboutApp = (TextView) findViewById(R.id.txt_about_app);
        mTxtOrderTable = (TextView) findViewById(R.id.txt_order_table);
        mTxtListFood = (TextView) findViewById(R.id.txt_list_food);
//        getSupportActionBar().hide();
        pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        FragmentManager manager=getSupportFragmentManager();
        PageAdapter adapter=new PageAdapter(manager);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setTabsFromPagerAdapter(adapter);

//        ivMenu.setOnClickListener(this);
        mTxtOrderTable.setOnClickListener(this);
        mTxtAboutApp.setOnClickListener(this);
        mTxtListFood.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_about_app:
                Intent intent2 = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent2);
                mDrawer.closeDrawers();
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
            case R.id.txt_order_table:
                Intent intent = new Intent(MainActivity.this, ListTableActivity.class);
                startActivity(intent);
                mDrawer.closeDrawers();
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
            case R.id.txt_list_food:
                Intent intent3 = new Intent(MainActivity.this, IntroFoodDrinkDessertActivity.class);
                startActivity(intent3);
                mDrawer.closeDrawers();
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
            default:
                break;
        }
    }
}
