package com.bartechspaceship.eShowStarWarsDemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.bartechspaceship.eShowStarWarsDemo.Adapters.SectionsStatePagerAdapter;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode1;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode2;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode3;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode4;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode5;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode6;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentEpisode7;
import com.bartechspaceship.eShowStarWarsDemo.Fragments.FragmentFilmSelection;
import com.bartechspaceship.eShowStarWarsDemo.R;

public class MainActivity extends AppCompatActivity {

    //Creating Variables
    private ViewPager mViewPager;
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    public static TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.containter);
        setupViewPager(mViewPager);

    }

    //Returns to Fragment 0 (FragmentFilmSelection)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mViewPager.setCurrentItem(0, true);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        //In Order of Movie Release Dates
        adapter.addFragment(new FragmentFilmSelection(), "Fragment 1");//0
        adapter.addFragment(new FragmentEpisode4(), "Fragment2");
        adapter.addFragment(new FragmentEpisode5(), "Fragment3");
        adapter.addFragment(new FragmentEpisode6(), "Fragment4");
        adapter.addFragment(new FragmentEpisode1(), "Fragment5");
        adapter.addFragment(new FragmentEpisode2(), "Fragment6");
        adapter.addFragment(new FragmentEpisode3(), "Fragment7");
        adapter.addFragment(new FragmentEpisode7(), "Fragment8");
        viewPager.setAdapter(adapter);
    }


    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }



}

