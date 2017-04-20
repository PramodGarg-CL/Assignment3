package cpm.example.sample.assignment3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cpm.example.sample.assignment3.R;

/**
 * Created by darknight on 20/4/17.
 */

public class ViewPagerFragment extends BaseFragment {
    private CustomViewPager mViewPager;
    private Fragment fragment1;
    private Fragment fragment2;
    private TabLayout mTabLayout;
    private String mTitleFragment1;
    private String mTitleFragment2;

    private int code;

    /**
     * Returns the instance of ViewPagerFragment
     *
     * @param code Determines whether the viewpager is of the activity or the fragment1
     * @return instance of ViewpagerFragment
     */
    public static ViewPagerFragment getInstance(int code) {
        ViewPagerFragment pagerFragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("code", code);
        pagerFragment.setArguments(bundle);
        return pagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_viewpager, container, false);
        init(view);


        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                if (position == 0) return fragment1;
                else return fragment2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) return mTitleFragment1;
                else return mTitleFragment2;

            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    /**
     * Intialises the views of fragment1
     * if viewpager is in @{@link cpm.example.sample.assignment3.activity.ScreenCActivity}
     * enable TabLayout
     *
     * @param view
     */
    private void init(View view) {
        mViewPager = (CustomViewPager) view.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        code = getArguments().getInt("code");


        if (code == CODE_VIEWPAGER_ACTIVITY) {
            /*
            If viewpager of activity get 2 instance of viewpager.
             */
            mTitleFragment1 = getString(R.string.tab_layout_title_upcoming);
            mTitleFragment2 = getString(R.string.tab_layout_title_past);

            //  mTabLayout.setVisibility(View.VISIBLE);
            mTabLayout.setTabTextColors(ContextCompat.getColor(getActivity(), android.R.color.white),
                    ContextCompat.getColor(getActivity(), R.color.colorAccent));
            mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            // disable the swipe on the viewpager
            mViewPager.setPagingEnabled(false);
            fragment1 = ViewPagerFragment.getInstance(CODE_VIEWPAGER_UPCOMING);
            fragment2 = ViewPagerFragment.getInstance(CODE_VIEWPAGER_PAST);


        } else {
            /*
            If viewpager in fragment1, get instance 2 of fragment1
             */
            mTabLayout.setBackgroundResource(android.R.color.white);
            mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            //enable views change on swipe of viewpager
            mViewPager.setPagingEnabled(true);
            if (code == CODE_VIEWPAGER_PAST) {
                //set Titles to tablayout
                mTitleFragment1 = getString(R.string.tab_layout_title_completed);
                mTitleFragment2 = getString(R.string.tab_layout_title_cancelled);

                //returns fragments with code
                fragment1 = MyFragment.getInstance(CODE_FRAGMENT_EVENT_COMPLETED);
                fragment2 = MyFragment.getInstance(CODE_FRAGMENT_EVENT_CANCELLED);
            } else if (code == CODE_VIEWPAGER_UPCOMING) {
                //set Titles to tablayout
                mTitleFragment1 = getString(R.string.tab_layout_title_accepted);
                mTitleFragment2 = getString(R.string.tab_layout_title_pending);

                fragment1 = MyFragment.getInstance(CODE_FRAGMENT_EVENT_ACCEPTED);
                fragment2 = MyFragment.getInstance(CODE_FRAGMENT_EVENT_PENDING);
            }
        }
    }
}
