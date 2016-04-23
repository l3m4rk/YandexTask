package edu.l3m4rk.yandextask.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.ui.fragment.artist_details.ArtistDetailsFragment;
import edu.l3m4rk.yandextask.ui.fragment.artists.ArtistsFragment;

public final class MainActivity extends BaseActivity
        implements ArtistsFragment.OnItemSelectedListener,
        FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (savedInstanceState == null) {
            changeFragment(ArtistsFragment.newInstance(), false);
        }
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.container_main, fragment);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    @Override
    public void onItemSelected(long selectedId) {
        changeFragment(ArtistDetailsFragment.newInstance(selectedId), true);
    }

    @Override
    public void onBackStackChanged() {
        FragmentManager fm = getSupportFragmentManager();
        ActionBar toolbar = getSupportActionBar();
        final boolean showHomeAsUp = fm.getBackStackEntryCount() > 0;
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }
}
