package com.amirmistikplay.metaeducation.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amirmistikplay.metaeducation.AwardActivity;
import com.amirmistikplay.metaeducation.R;
import com.amirmistikplay.metaeducation.StatisticActivity;
import com.amirmistikplay.metaeducation.TestActivity;
import com.amirmistikplay.metaeducation.database.ViewCourses;
import com.amirmistikplay.metaeducation.webview.WebViewActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "home1";
    private static final String ARG_PARAM2 = "home2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    LinearLayout algebra_panel, geometry_panel, informatica_panel;
    LinearLayout statistic, browser, everyday_award, award, debug;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        algebra_panel = view.findViewById(R.id.algebra_panel);
        geometry_panel = view.findViewById(R.id.geometry_panel);
        informatica_panel = view.findViewById(R.id.informatica_panel);
        statistic = view.findViewById(R.id.statistic_panel);
        browser = view.findViewById(R.id.first_panel_algebra);
        everyday_award = view.findViewById(R.id.award_panel);
        award = view.findViewById(R.id.achievement);
        debug = view.findViewById(R.id.debug);

        algebra_panel.setOnClickListener(this);
        geometry_panel.setOnClickListener(this);
        informatica_panel.setOnClickListener(this);
        statistic.setOnClickListener(this);
        browser.setOnClickListener(this);
        everyday_award.setOnClickListener(this);
        award.setOnClickListener(this);
        debug.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.algebra_panel:
                OpenTest(view, 0);
                break;
            case R.id.geometry_panel:
                OpenTest(view, 1);
                break;
            case R.id.informatica_panel:
                OpenTest(view, 2);
                break;
            case R.id.statistic_panel:
                OpenStatistic(view);
                break;
            case R.id.first_panel_algebra:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());

                // set title

                alertDialogBuilder.setTitle("Fair Use Policy");
                alertDialogBuilder.setIcon(R.drawable.ic_metatoken);

                // set dialog message
                alertDialogBuilder.setMessage(getString(R.string.privacy_policy))
                        .setCancelable(false)
                        .setPositiveButton("Accept",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                OpenBrowser(view);
                            }
                        })
                        .setNegativeButton("Decline",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                break;
            case R.id.award_panel:
                setEverydayAward(view);
                break;
            case R.id.achievement:
                OpenAward(view);
                break;
            case R.id.debug:
                DebugOpen(view);
                break;
        }
    }

    private void OpenStatistic(View view){
        Intent openstatistic = new Intent(view.getContext(), StatisticActivity.class);
        startActivity(openstatistic);
    }

    private void OpenTest(View view, int task){
        Intent opentest = new Intent(view.getContext(), TestActivity.class);
        opentest.putExtra("task", task);
        startActivity(opentest);
    }

    private void DebugOpen(View view){
        Intent intent = new Intent(view.getContext(), ViewCourses.class);
        startActivity(intent);
    }

    private void OpenBrowser(View view){
        Intent intent = new Intent(view.getContext(), WebViewActivity.class);
        startActivity(intent);
    }

    private void OpenAward(View view){
        Intent intent = new Intent(view.getContext(), AwardActivity.class);
        startActivity(intent);
    }

    private void setEverydayAward(View view) {
        SharedPreferences settings = view.getContext().getSharedPreferences("wallet", 0);
        SharedPreferences.Editor editor = settings.edit();

        long time_last, current_time;
        int money;

        current_time = (System.currentTimeMillis() / 1000L);

        if(settings.contains("time")) {
            time_last = settings.getLong("time", 0);
        } else {
            time_last = 1000000000;
        }

        if(current_time - time_last <= 86400){
            Toast.makeText(view.getContext(), (86400 - (current_time - time_last)) + " seconds left", Toast.LENGTH_SHORT).show();
            return;
        } else {
            money = settings.getInt("meta", 0);

            editor.putLong("time", System.currentTimeMillis() / 1000L);
            editor.putInt("meta", money + 10);
            editor.apply();

            Toast.makeText(view.getContext(), "You get 10 metacoin", Toast.LENGTH_SHORT).show();
        }
    }
}