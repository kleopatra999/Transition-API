package com.txusballesteros.transitions;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    public static Fragment getFragment() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        view.findViewById(R.id.command1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCommand1();
            }
        });

        view.findViewById(R.id.command2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCommand2();
            }
        });
    }

    private void runCommand1() {
        Button sharedVew = (Button)getView().findViewById(R.id.command1);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TITLE, sharedVew.getText());
        Navigator.navigateTo(getActivity(), intent);
    }

    private void runCommand2() {
        Button sharedVew = (Button)getView().findViewById(R.id.command2);
        Pair sharedElement = new Pair<>(sharedVew, sharedVew.getTransitionName());
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TITLE, sharedVew.getText());
        Navigator.navigateTo(getActivity(), intent, sharedElement);
    }
}
