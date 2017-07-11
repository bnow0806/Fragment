package com.example.mureung.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;


public class fragmentA extends Fragment{

    private KakaoLink kakaoLink;
    private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;

    MapView   mMapView;

    double a = 37.541;
    double b = 126.986;
    private GoogleMap mMap;
    // a,b 입력받도록 변경해야됨

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmenta, container, false);
        // fragmenta로 view 그림
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
        //mapView를 받아서 callback함수 실행
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                final TextView lat=(TextView)view.findViewById(R.id.lat);
                lat.setText("위도: "+a);
                final TextView lng=(TextView)view.findViewById(R.id.lng);
                lng.setText("경도: "+b);

                MarkerOptions marker=new MarkerOptions().position( new LatLng(a, b));
        /*marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon01)); 마커의 아이콘 바꾸는 코드*/

                mMap.addMarker(marker);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 17));
        //googlemap에 마커찍기, 카메라 이동
            }});


        Button button = (Button) view.findViewById(R.id.kakaoshare);
        button.setOnClickListener(new View.OnClickListener()
        {   //button click시 실행코드
            @Override
            public void onClick(View v)
            {
                try {
                    //kakaotalk 웹주소 공유코드
                    String text="https://www.google.com/maps/search/"+a+","+b+"/data=!4m2!2m1!4b1?hl=ko&nogmmr=1";
                    kakaoLink = KakaoLink.getKakaoLink(getActivity().getApplicationContext());
                    kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
                    kakaoTalkLinkMessageBuilder.addText(text);
                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(),getActivity());
                    kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

                } catch (KakaoParameterException e) {
                    e.getMessage();
                }
            }

        });
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    //링크보내는 매소드

   /* private KakaoLink kakaoLink;
        private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;

    /*private void sendLink(){

    }*/
}

    /*Uri gmmIntentUri = Uri.parse("geo:0,0?q="+a+","+b);
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent); intent로 구현하는방법*/

