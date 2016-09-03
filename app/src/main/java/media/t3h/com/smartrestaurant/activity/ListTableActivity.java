package media.t3h.com.smartrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.object.Table;

/**
 * Created by Ngoc on 8/28/2016.
 */
public class ListTableActivity extends Activity implements View.OnClickListener {
    public static final int NUMBER_TABLE = 9;
    public static final String ID_TABLE = "ID_TABLE";

    private Firebase root;
    private ImageView[] mIVTable;
    private int[] idTable = new int[] {R.id.iv_table1,R.id.iv_table2,R.id.iv_table3,
            R.id.iv_table4,R.id.iv_table5,R.id.iv_table6,
            R.id.iv_table7,R.id.iv_table8,R.id.iv_table9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);

        initFireBase();
        initView();
//        createListTables();
    }

    private void initView() {
        mIVTable = new ImageView[NUMBER_TABLE];

        for (int i =0 ; i <NUMBER_TABLE; i++) {
            mIVTable[i] = (ImageView) findViewById(idTable[i]);
            mIVTable[i].setOnClickListener(this);
        }

    }

    private void initFireBase() {
        Firebase.setAndroidContext(this);
        root = new Firebase("https://smartrestaurant-c0523.firebaseio.com/");
    }

    @Override
    public void onClick(View view) {
        for (int i =0 ; i< NUMBER_TABLE; i++) {
            if(view.getId() == idTable[i]) {
                /*
                    Phần lấy dữ liệu từ Firebase ve bao gom: id, status và waiter trong bảng Table
                    rồi chuyển dữ liệu này sang bên TableInfoActivity

                 */

                Firebase rootID = root.child("Table").child("Table"+(i+1)).child("id");

                rootID.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Intent intent = new Intent(ListTableActivity.this, TableInfoActivity.class);
                        intent.putExtra(ID_TABLE, dataSnapshot.getValue().toString());
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

//                if(count[0]==1) {
//                    Intent intent = new Intent(ListTableActivity.this, TableInfoActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString(NAME_TABLE, name[0]);
//                    bundle.putString(STATUS_TABLE, status);
//                    bundle.putString(WAITER_TABLE, waiter);
//                    intent.putExtra(BUNDLE, bundle);
//                    startActivity(intent);
//                }


            }

        }

    }









    private void createListTables() {
//        Firebase alanRef = root.child("table");
//        alanRef.push().setValue(new Table(1,"Table1" , 1));
        root.child("Table").child("Table1").child("id").setValue(1);
        root.child("Table").child("Table1").child("name").setValue("Table 1");
        root.child("Table").child("Table1").child("status").setValue(0);

        root.child("Table").child("Table2").child("id").setValue(2);
        root.child("Table").child("Table2").child("name").setValue("Table 2");
        root.child("Table").child("Table2").child("status").setValue(0);

        root.child("Table").child("Table3").child("id").setValue(3);
        root.child("Table").child("Table3").child("name").setValue("Table 3");
        root.child("Table").child("Table3").child("status").setValue(0);

        root.child("Table").child("Table4").child("id").setValue(4);
        root.child("Table").child("Table4").child("name").setValue("Table 4");
        root.child("Table").child("Table4").child("status").setValue(0);

        root.child("Table").child("Table5").child("id").setValue(5);
        root.child("Table").child("Table5").child("name").setValue("Table 5");
        root.child("Table").child("Table5").child("status").setValue(0);

        root.child("Table").child("Table6").child("id").setValue(1);
        root.child("Table").child("Table6").child("name").setValue("Table 6");
        root.child("Table").child("Table6").child("status").setValue(0);

        root.child("Table").child("Table7").child("id").setValue(7);
        root.child("Table").child("Table7").child("name").setValue("Table 7");
        root.child("Table").child("Table7").child("status").setValue(0);

        root.child("Table").child("Table8").child("id").setValue(8);
        root.child("Table").child("Table8").child("name").setValue("Table 8");
        root.child("Table").child("Table8").child("status").setValue(0);

        root.child("Table").child("Table9").child("id").setValue(9);
        root.child("Table").child("Table9").child("name").setValue("Table 9");
        root.child("Table").child("Table9").child("status").setValue(0);
    }

}
