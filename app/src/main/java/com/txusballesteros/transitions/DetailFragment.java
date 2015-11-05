package com.txusballesteros.transitions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private static final String ARG_TITLE = "title";

    public static DetailFragment newInstance(@NonNull String title) {
        Bundle arguments = new Bundle(1);
        arguments.putString(ARG_TITLE, title);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String title = getArguments().getString(ARG_TITLE);
        ((TextView)view.findViewById(R.id.title)).setText(title);
    }
}
