package media.t3h.com.smartrestaurant.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.fragment.LoginFragment;
import media.t3h.com.smartrestaurant.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnClickButtonRegisterListener,
        LoginFragment.OnClickButtonLoginListener{

    private FragmentManager manager;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        loginFragment = new LoginFragment();
        loginFragment.setOnClickButtonListener(this);
        registerFragment = new RegisterFragment();
        registerFragment.setOnClickButtonListener(this);
        manager.beginTransaction().add(R.id.container_login, loginFragment)
                .add(R.id.container_login, registerFragment)
                .show(loginFragment)
                .hide(registerFragment).commit();
    }

    @Override
    public void onClickListener() {
        //if success
        manager.beginTransaction().show(loginFragment)
                .hide(registerFragment).commit();
    }

    @Override
    public void onClickListener(int ID) {
        switch (ID){
            case LoginFragment.LOGIN:

                break;
            case LoginFragment.TRANSFER_REGISTER:
                manager.beginTransaction().show(registerFragment)
                        .hide(loginFragment).addToBackStack(null).commit();
                break;
            default:
                break;
        }
    }
}
