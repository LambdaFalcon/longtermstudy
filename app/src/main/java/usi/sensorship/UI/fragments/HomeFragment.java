package usi.sensorship.UI.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import usi.sensorship.R;
import usi.sensorship.UI.views.HomeView;
import usi.sensorship.UI.views.RegistrationView;
import usi.sensorship.local.database.controllers.LocalStorageController;
import usi.sensorship.local.database.controllers.SQLiteController;

/**
 * Created by usi on 04/02/17.
 */

public class HomeFragment extends Fragment {
//    private OnRegistrationSurveyChoice callback;
    private LocalStorageController localController;

    private RegistrationView registrationView;
    private HomeView homeView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        localController = SQLiteController.getInstance(getContext());
        View root = inflater.inflate(R.layout.home_layoutt, null);

        return root;
    }
}