om.example.a1102map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import com.utsman.samplegooglemapsdirection.R;
import com.utsman.samplegooglemapsdirection.java.model.DirectionResponses;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @SuppressLint("Registered")
    public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

        private GoogleMap map;
        private LatLng fkip;
        private LatLng monas;



        @Override
    public void onMapReady(GoogleMap googleMap) {
            map = googleMap;

            MarkerOptions markerFkip = new MarkerOptions()
                    .position(fkip)
                    .title("FKIP");
            MarkerOptions markerMonas = new MarkerOptions()
                    .position(monas)
                    .title("Monas");

            map.addMarker(markerFkip);
            map.addMarker(markerMonas);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(monas, 11.6f));


            String fromFKIP = String.valueOf(fkip.latitude) + "," + String.valueOf(fkip.longitude);
            String toMonas = String.valueOf(monas.latitude) + "," + String.valueOf(monas.longitude);

            ApiServices apiServices = RetrofitClient.apiServices(this);





    }
}
