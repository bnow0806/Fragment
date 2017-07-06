package com.example.mureung.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class fragmentA extends Fragment implements OnMapReadyCallback {

    GoogleMap gMap;
    double lat = 37.541;
    double lng = 126.986;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);


        SupportMapFragment gMap = (SupportMapFragment)view.getSupportMapFragmentManager().findFragmentById(R.id.map);
        gMap.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15));
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(lat, lng));
        googleMap.addMarker(marker).showInfoWindow();

    }


}