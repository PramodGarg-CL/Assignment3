package cpm.example.sample.assignment3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import cpm.example.sample.assignment3.AppConstants;
import cpm.example.sample.assignment3.R;
import cpm.example.sample.assignment3.fragment.ViewPagerFragment;

/**
 * Contains viewpager with tablayout
 */

public class ScreenCActivity extends BaseActivity {
    // private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_c);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //add the viewpager to the framelayout o activity
        fragmentTransaction.replace(R.id.frame_layout, ViewPagerFragment.getInstance(AppConstants.CODE_VIEWPAGER_ACTIVITY));
        fragmentTransaction.commit();

    }
}
