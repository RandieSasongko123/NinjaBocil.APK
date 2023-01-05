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
import android.widget.Toast;

import com.example.ninjabocil.R;
import com.example.ninjabocil.adapter.AdapaterTailed;
import com.example.ninjabocil.api.APIRequestData;
import com.example.ninjabocil.api.RetroServer;
import com.example.ninjabocil.models.tailed;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TailedBeastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TailedBeastFragment extends Fragment {

    private RecyclerView rvTailed;
    private RecyclerView.Adapter adTailed;
    private RecyclerView.LayoutManager lmTailed;
    private List<tailed> listTailed = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TailedBeastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TailedBeastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TailedBeastFragment newInstance(String param1, String param2) {
        TailedBeastFragment fragment = new TailedBeastFragment();
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

        rvTailed = view.findViewById(R.id.rv_tailed);

        lmTailed = new LinearLayoutManager(getView().getContext(), LinearLayoutManager.VERTICAL, false);
        rvTailed.setLayoutManager(lmTailed);
    }

    private void retrieveTailed() {
        APIRequestData API = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<tailed>> proses = API.getTailed();

        proses.enqueue(new Callback<List<tailed>>() {
            @Override
            public void onResponse(Call<List<tailed>> call, Response<List<tailed>> response) {

                listTailed = response.body();

//                Toast.makeText(getView().getContext(), "Response : " + listChara, Toast.LENGTH_SHORT).show();

                adTailed = new AdapaterTailed(listTailed);
                rvTailed.setAdapter(adTailed);
            }

            @Override
            public void onFailure(Call<List<tailed>> call, Throwable t) {
                Toast.makeText(getView().getContext(), "Gagal menghubungi server : " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tailed_beast, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveTailed();
    }
}