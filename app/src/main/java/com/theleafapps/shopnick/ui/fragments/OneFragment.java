package com.theleafapps.shopnick.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theleafapps.shopnick.R;
import com.theleafapps.shopnick.adapters.TabbedRecyclerAdapter;
import com.theleafapps.shopnick.models.Category;
import com.theleafapps.shopnick.models.CategoryItem;
import com.theleafapps.shopnick.models.SubCategory;
import com.theleafapps.shopnick.utils.Commons;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private TabbedRecyclerAdapter adapter;
    List<SubCategory> infoList = Collections.emptyList();

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();

        int category_id = bundle.getInt("category_id");

        View inflatedView = inflater.inflate(R.layout.fragment_one, container, false);

        recyclerView = (RecyclerView) inflatedView.findViewById(R.id.cardRecyclerView);

        if(Commons.catIdToSubCatMap.containsKey(category_id)) {
            infoList = Commons.catIdToSubCatMap.get(category_id);
        }

        adapter = new TabbedRecyclerAdapter(getActivity(),infoList,category_id);

        recyclerView.setAdapter(adapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.RED)
                        .build());

        return inflatedView;
    }

}