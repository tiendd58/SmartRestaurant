package media.t3h.com.smartrestaurant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import media.t3h.com.smartrestaurant.fragment.ChatFragment;
import media.t3h.com.smartrestaurant.fragment.ListTableFragment;
import media.t3h.com.smartrestaurant.fragment.MainFragment;

/**
 * Created by Ngoc on 9/3/2016.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag= new MainFragment();
                break;
            case 1:
                frag=new ListTableFragment();
                break;
            case 2:
                frag=new ChatFragment();
                break;
        }
        return frag;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Main";
                break;
            case 1:
                title="Order";
                break;
            case 2:
                title="Chat";
                break;
        }

        return title;
    }

}