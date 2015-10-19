package com.txusballesteros.transitions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureTransitions();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showFragment();
    }

    private void configureTransitions() {
        Transition transition = new Slide(Gravity.LEFT);
        getWindow().setExitTransition(transition);
//        getWindow().setSharedElementExitTransition(new Fade());
    }

    private void showFragment() {
        Fragment fragment = MainFragment.getFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.content,fragment)
                .commit();
    }
}
