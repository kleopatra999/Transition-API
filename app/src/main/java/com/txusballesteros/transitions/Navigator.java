package com.txusballesteros.transitions;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Navigator {
    public static void navigateTo(Activity owner, Intent intent, Pair... sharedElements) {
        View decorView = owner.getWindow().getDecorView();
        View navigationView = decorView.findViewById(android.R.id.navigationBarBackground);
        View statusView = decorView.findViewById(android.R.id.statusBarBackground);
        View actionBar = decorView.findViewById(R.id.appBarLayout);

        List<Pair> participants = new ArrayList<>();
        addParticipantToList(navigationView, participants);
        addParticipantToList(statusView, participants);
        addParticipantToList(actionBar, participants);
        if (sharedElements != null && sharedElements.length > 0) {
            participants.addAll(Arrays.asList(sharedElements));
        }

        ActivityOptionsCompat options = ActivityOptionsCompat
               .makeSceneTransitionAnimation(owner,
                                             participants.toArray(new Pair[participants.size()]));
        owner.startActivity(intent, options.toBundle());
    }

    private static void addParticipantToList(View participant, List<Pair> list) {
        if (participant != null) {
            list.add(new Pair<>(participant, participant.getTransitionName()));
        }
    }
}
