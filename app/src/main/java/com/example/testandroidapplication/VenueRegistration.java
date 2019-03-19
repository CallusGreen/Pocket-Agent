package com.example.testandroidapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class VenueRegistration extends Fragment {

    private VenueProfileCreation venueProfileCreation = new VenueProfileCreation();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.venue_registration, container, false);

        Button venueRegister = v.findViewById(R.id.venue_register);
        Button venueCancel = v.findViewById(R.id.venue_cancel);
        EditText venueEmail = v.findViewById(R.id.venue_email);
        final EditText venuePassword = v.findViewById(R.id.venue_password);
        final EditText venueConfirmPassword = v.findViewById(R.id.venue_confirm_password);
        final RegisterFragmentVOrA registerFragmentVOrA = new RegisterFragmentVOrA();

        venueCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        registerFragmentVOrA).commit();

            }
        });

        venueRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,
                        venueProfileCreation).commit();
            }
        });

        return v;
    }
}
