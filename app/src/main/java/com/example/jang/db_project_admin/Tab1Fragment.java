package com.example.jang.db_project_admin;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jang.db_project_admin.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class Tab1Fragment extends android.support.v4.app.Fragment {


    public Tab1Fragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);

    }

}
