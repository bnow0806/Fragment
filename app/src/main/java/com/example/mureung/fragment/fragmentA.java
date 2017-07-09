package com.example.mureung.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class fragmentA extends Fragment{

    MapView   mMapView;

    double a = 37.541;
    double b = 126.986;
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmenta, container, false);

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        final TextView lat=(TextView)view.findViewById(R.id.lat);
        lat.setText("위도: "+a);
        final TextView lng=(TextView)view.findViewById(R.id.lng);
        lng.setText("경도: "+b);

        // a,b 입력받도록 변경
        LatLng sydney = new LatLng(a, b);
        MarkerOptions marker=new MarkerOptions().position(sydney);
        /*marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon01));아이콘 바꾸는 코드*/

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 17));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.addMarker(markerOptions);
                final TextView lat=(TextView)view.findViewById(R.id.lat);
                a=latLng.latitude;
                b=latLng.longitude;
                lat.setText("위도: "+a);
                final TextView lng=(TextView)view.findViewById(R.id.lng);
                lng.setText("경도: "+b);
            }});
    }});
        return view;
    }
 @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    }