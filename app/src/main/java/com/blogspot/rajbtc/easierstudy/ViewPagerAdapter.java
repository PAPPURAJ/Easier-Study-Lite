package com.blogspot.rajbtc.easierstudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] tabName = {"Switch", "Motor", "Robot"};


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

                if(position==0)
                    return  new SwitchFragment();
                else if(position==1)
                    return new MotorFragment();
                return new RobotFragment();
    }

    @Override
    public int getCount() {
        return tabName.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }




}