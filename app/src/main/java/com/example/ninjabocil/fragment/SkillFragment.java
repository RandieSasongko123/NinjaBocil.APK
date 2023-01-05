package com.example.ninjabocil.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninjabocil.R;
import com.example.ninjabocil.adapter.AdapterSkill;
import com.example.ninjabocil.api.APIRequestData;
import com.example.ninjabocil.api.RetroServer;
import com.example.ninjabocil.models.skill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    private RecyclerView rvSkill;
    private RecyclerView.Adapter adapterSkill;
    private RecyclerView.LayoutManager lmSkill;
    private List<skill> skillList = new ArrayList<>();
    private MenuItem menuItem;
    private SearchView searchView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillFragment newInstance(String param1, String param2) {
        SkillFragment fragment = new SkillFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mysearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mysearch(query);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void mysearch(String query) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSkill = view.findViewById(R.id.rv_Skill);
        lmSkill = new LinearLayoutManager(getView().getContext(), LinearLayoutManager.VERTICAL, false);
        rvSkill.setLayoutManager(lmSkill);

    }

    private void retrieveSkilL() {
        APIRequestData API = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<skill>> proses= API.getSkill();

        proses.enqueue(new Callback<List<skill>>() {
            @Override
            public void onResponse(Call<List<skill>> call, Response<List<skill>> response) {
                skillList = response.body();
                adapterSkill = new AdapterSkill(skillList);
                rvSkill.setAdapter(adapterSkill);
            }

            @Override
            public void onFailure(Call<List<skill>> call, Throwable t) {

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveSkilL();
    }
}