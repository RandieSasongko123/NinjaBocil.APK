package com.example.ninjabocil.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninjabocil.R;
import com.example.ninjabocil.adapter.AdapterNinja;
import com.example.ninjabocil.api.APIRequestData;
import com.example.ninjabocil.api.RetroServer;
import com.example.ninjabocil.models.ninja;
import com.example.ninjabocil.models.skill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeroFragment extends Fragment {

    private RecyclerView rvNinja;
    private RecyclerView.Adapter adNinja;
    private RecyclerView.LayoutManager lmNinja;
    private List<ninja> ninjaList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HeroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeroFragment newInstance(String param1, String param2) {
        HeroFragment fragment = new HeroFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvNinja = view.findViewById(R.id.rv_hero);
        lmNinja = new LinearLayoutManager(getView().getContext(), LinearLayoutManager.VERTICAL, false);
        rvNinja.setLayoutManager(lmNinja);
    }

    private void retrieveNinja() {
        APIRequestData API = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<ninja>> proses= API.getNinja();

        proses.enqueue(new Callback<List<ninja>>() {
            @Override
            public void onResponse(Call<List<ninja>> call, Response<List<ninja>> response) {
                ninjaList = response.body();
                adNinja = new AdapterNinja(ninjaList);
                rvNinja.setAdapter(adNinja);
            }

            @Override
            public void onFailure(Call<List<ninja>> call, Throwable t) {

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveNinja();
    }
}