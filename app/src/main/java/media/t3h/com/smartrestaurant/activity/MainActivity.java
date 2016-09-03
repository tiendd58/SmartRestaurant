package media.t3h.com.smartrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import media.t3h.com.smartrestaurant.R;

/**
 * Created by Ngoc on 9/1/2016.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getName();
    private DrawerLayout mDrawer;
    private ImageView ivMenu;
    private TextView mTxtAboutApp, mTxtOrderTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ivMenu = (ImageView) findViewById(R.id.iv_menu_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTxtAboutApp = (TextView) findViewById(R.id.txt_about_app);
        mTxtOrderTable = (TextView) findViewById(R.id.txt_order_table);
        ivMenu.setOnClickListener(this);
        mTxtOrderTable.setOnClickListener(this);
        mTxtAboutApp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_menu_drawer:
                mDrawer.openDrawer(Gravity.LEFT);
                mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                break;
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
            default:
                break;
        }
    }
}
