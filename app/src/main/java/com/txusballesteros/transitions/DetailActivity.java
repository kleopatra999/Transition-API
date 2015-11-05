package com.txusballesteros.transitions;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        loadFragment();
        configureTransitions();
        configureToolbar();
    }

    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadFragment() {
        String title = getIntent().getExtras().getString(EXTRA_TITLE);
        Fragment fragment = DetailFragment.newInstance(title);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_holder, fragment)
                .commit();
    }

    private void configureTransitions() {
        getWindow().setAllowEnterTransitionOverlap(false);
    }
}
