package com.amirmistikplay.metaeducation.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amirmistikplay.metaeducation.R;
import com.amirmistikplay.metaeducation.TaskActivity.AlgebraActivity;
import com.amirmistikplay.metaeducation.TaskActivity.GeometryActivity;
import com.amirmistikplay.metaeducation.TaskActivity.InformaticActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "task1";
    private static final String ARG_PARAM2 = "task2";

    private String mParam1;
    private String mParam2;

    public TaskFragment() {
        // Required empty public constructor
    }

    public static TaskFragment newInstance(String param1, String param2) {
        TaskFragment fragment = new TaskFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    LinearLayout algebra_to_video, geometry_to_video, informatics_to_video;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        algebra_to_video = view.findViewById(R.id.algebra_panel_video);
        geometry_to_video = view.findViewById(R.id.geometry_panel_video);
        informatics_to_video = view.findViewById(R.id.informatica_panel_video);

        algebra_to_video.setOnClickListener(this);
        geometry_to_video.setOnClickListener(this);
        informatics_to_video.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.algebra_panel_video:
                intent = new Intent(view.getContext(), AlgebraActivity.class);
                startActivity(intent);
                break;
            case R.id.geometry_panel_video:
                intent = new Intent(view.getContext(), GeometryActivity.class);
                startActivity(intent);
                break;
            case R.id.informatica_panel_video:
                intent = new Intent(view.getContext(), InformaticActivity.class);
                startActivity(intent);
                break;
        }
    }
}