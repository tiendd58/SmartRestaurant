package media.t3h.com.smartrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.object.Table;

/**
 * Created by Ngoc on 9/2/2016.
 */
public class TableInfoActivity extends Activity implements View.OnClickListener {
    private TextView mTxtTableName, mTxtStatusTable, mTxtWaiter;
    private Button mBtnBookTable;
    private String idTable ="";
    private Firebase rootTable;
    private boolean isEmpty; // 0 = true, 1 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_info_table);
        initView();
        catchIntent();
        initFireBase();
        updateView();
        changeStatusTable();
    }


    private void updateView() {
        mTxtTableName.setText("Table "+idTable);
    }

    private void initFireBase() {
        Firebase.setAndroidContext(this);
        Firebase root = new Firebase("https://smartrestaurant-c0523.firebaseio.com/");
        rootTable = root.child("Table").child("Table" +idTable);
    }

    private void initView() {
        mTxtStatusTable = (TextView) findViewById(R.id.txt_status_table);
        mTxtTableName = (TextView) findViewById(R.id.txt_table_name);
        mTxtWaiter = (TextView) findViewById(R.id.txt_waiter_of_table);
        mBtnBookTable = (Button) findViewById(R.id.btn_book_the_table);

        mBtnBookTable.setOnClickListener(this);
    }

    private void catchIntent() {
        Intent intentResult = getIntent();
        idTable = intentResult.getStringExtra(ListTableActivity.ID_TABLE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_book_the_table:
                if(isEmpty) {
                    rootTable.child("status").setValue(Table.OCCUPY);
                } else {
                    rootTable.child("status").setValue(Table.EMPTY);
                }
                changeStatusTable();
                break;

            default:
                    break;
        }
    }

    private void changeStatusTable() {
        final Firebase rootStatus = rootTable.child("status");
        rootStatus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue().toString().equals("0")) {
//                    rootStatus.setValue(Table.OCCUPY);
                    mBtnBookTable.setBackgroundResource(R.drawable.state_button_set_the_tables);
                    mBtnBookTable.setText("Đặt bàn");
                    mTxtStatusTable.setText("Trống");
                    mTxtStatusTable.setTextColor(Color.GREEN);
                    isEmpty = true;
                }
                if(dataSnapshot.getValue().toString().equals("1")) {
//                    rootStatus.setValue(Table.EMPTY);
                    mBtnBookTable.setBackgroundResource(R.drawable.state_button_unset_the_tables);
                    mBtnBookTable.setText("Hủy đặt bàn");
                    mTxtStatusTable.setText("Hết");
                    mTxtStatusTable.setTextColor(Color.RED);
                    isEmpty = false;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
