package com.example.mureung.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    // a,b 입력받도록 변경

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

                MarkerOptions marker=new MarkerOptions().position( new LatLng(a, b));
        /*marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon01));아이콘 바꾸는 코드*/

                mMap.addMarker(marker);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 17));

                mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions().position(latLng);
                        mMap.clear();
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                        mMap.addMarker(markerOptions);
                        final TextView lat=(TextView)view.findViewById(R.id.lat);
                        a=latLng.latitude;
                        b=latLng.longitude;
                        lat.setText("위도: "+a);
                        final TextView lng=(TextView)view.findViewById(R.id.lng);
                        lng.setText("경도: "+b);
                        Log.e("222","222");

                        //lat,lng 보내는 코드, 어차피 수정안했을때는 다시보내줄 필요 x
                    }});

            }});
        Button button = (Button) view.findViewById(R.id.kakaoshare);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //intent 공유
             Log.e("111","1111");
            }
        });
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
}




/*uri intent
Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
mapIntent.setPackage("com.google.android.apps.maps");
if (mapIntent.resolveActivity(getPackageManager()) != null) {
    startActivity(mapIntent);
}
 */