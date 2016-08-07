package media.t3h.com.smartrestaurant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import media.t3h.com.smartrestaurant.R;

/**
 * Created by duyti on 8/5/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final int LOGIN = 1;
    public static final int TRANSFER_REGISTER = 2;
    private EditText etEmail, etPass;
    private Button btnLogin, btnTranferRegister;
    private TextView tvForgotPass;

    private OnClickButtonLoginListener listener;

    public void setOnClickButtonListener(OnClickButtonLoginListener event){
        listener=event;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_login,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        etEmail = (EditText) rootView.findViewById(R.id.et_email);
        etPass = (EditText) rootView.findViewById(R.id.et_pass);
        btnLogin = (Button) rootView.findViewById(R.id.btn_login);
        btnTranferRegister = (Button) rootView.findViewById(R.id.btn_transfer_register);
        tvForgotPass = (TextView) rootView.findViewById(R.id.tv_forgot_password);

        //setEvent
        btnLogin.setOnClickListener(this);
        btnTranferRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                listener.onClickListener(LOGIN);
                break;
            case R.id.btn_transfer_register:
                listener.onClickListener(TRANSFER_REGISTER);
                break;
            default:
                break;
        }
    }

    public interface OnClickButtonLoginListener{
        void onClickListener(int ID);
    }

}
