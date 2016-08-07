package media.t3h.com.smartrestaurant.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import media.t3h.com.smartrestaurant.R;

/**
 * Created by duyti on 8/5/2016.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener  {

    private static final String ACCOUNT = "Account";
    private EditText etEmail, etPass, etRepass;
    private Button btnRegister;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    private OnClickButtonRegisterListener listener;

    public void setOnClickButtonListener(OnClickButtonRegisterListener event){
        listener=event;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_register,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        etEmail = (EditText) rootView.findViewById(R.id.et_email);
        etPass = (EditText) rootView.findViewById(R.id.et_pass);
        btnRegister = (Button) rootView.findViewById(R.id.btn_register);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        //setEvent
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                progressBar.setVisibility(View.VISIBLE);
                Firebase.setAndroidContext(getContext());
                auth = FirebaseAuth.getInstance();

                if(etRepass.getText().toString().equals(etPass.getText().toString())) {
                    String email = etEmail.getText().toString().trim();
                    String password = etPass.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (password.length() < 6) {
                        Toast.makeText(getContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    progressBar.setVisibility(View.VISIBLE);
                }
                break;
            default:
                break;
        }
    }

    public interface OnClickButtonRegisterListener{
        void onClickListener();
    }
}
