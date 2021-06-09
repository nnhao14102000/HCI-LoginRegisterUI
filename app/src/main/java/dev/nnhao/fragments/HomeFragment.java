package dev.nnhao.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.SlidingDrawer;

import dev.nnhao.loginregisterui.R;

public class HomeFragment extends Fragment {

    private SlidingDrawer slidingDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        slidingDrawer = (SlidingDrawer)getView().findViewById(R.id.slideDrawer1);
        slidingDrawer.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_bottom));
    }
}