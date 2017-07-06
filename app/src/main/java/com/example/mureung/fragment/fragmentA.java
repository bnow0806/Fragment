package com.example.mureung.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class fragmentA extends Fragment{

    MapView   mMapView;
    private GoogleMap gMap;

    double lat = 37.541;
    double lng = 126.986;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);

        mMapView = (MapView) view.findViewById(R.id.mapView);
                 mMapView.onCreate(savedInstanceState);
               mMapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        mMapView.getMapAsync(new OnMapReadyCallback() {

    @Override
    public void onMapReady(GoogleMap mMap) {
        googleMap=mMap;
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15));
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(lat, lng));
        googleMap.addMarker(marker).showInfoWindow();
    }
        });
    return view;
    }
      @Override
         public void onResume() {
             super.onResume();
             mMapView.onResume();
         }
         @Override
         public void onPause() {
             super.onPause();
             mMapView.onPause();
         }
         @Override
         public void onDestroy() {
             super.onDestroy();
             mMapView.onDestroy();
         }
         @Override
         public void onLowMemory() {
             super.onLowMemory();
             mMapView.onLowMemory();
       }
}