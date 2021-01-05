package com.orendasoftware.crs.presentation.view.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orendasoftware.crs.R;

public class SplashFragment extends Fragment {

    private Handler handler;
    private Runnable callback;
    private boolean flag= false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        handler = new Handler();
        callback = new Runnable() {
            @Override
            public void run() {
                if(!flag) {
                    flag = true;
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment);
                }
                getActivity().getFragmentManager().popBackStack();
            }
        };
        handler.postDelayed(callback, 2000);
        return view;
    }
}
