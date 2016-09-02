package media.t3h.com.smartrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import media.t3h.com.smartrestaurant.R;

/**
 * Created by Ngoc on 9/2/2016.
 */
public class TableInfoActivity extends Activity {
    private TextView mTxtTableName, mTxtStatusTable, mTxtWaiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_info_table);
        initView();
        catchIntent();
    }

    private void initView() {
        mTxtStatusTable = (TextView) findViewById(R.id.txt_status_table);
        mTxtTableName = (TextView) findViewById(R.id.txt_table_name);
        mTxtWaiter = (TextView) findViewById(R.id.txt_waiter_of_table);
    }

    private void catchIntent() {
        Intent intentResult = getIntent();
        Bundle bundleResult = intentResult.getBundleExtra(ListTableActivity.BUNDLE);
        String tableName = bundleResult.getString(ListTableActivity.NAME_TABLE);
        String tableStatus = bundleResult.getString(ListTableActivity.STATUS_TABLE);
        String tableWaiter = bundleResult.getString(ListTableActivity.WAITER_TABLE);
        Toast.makeText(this, tableName + "-" + tableStatus + "-"+ tableWaiter, Toast.LENGTH_SHORT).show();
    }
}
