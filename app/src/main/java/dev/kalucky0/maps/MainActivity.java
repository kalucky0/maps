package dev.kalucky0.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;

public class MainActivity extends Activity {

    private MapView map = null;
    private boolean isHighResolution = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);
        IMapController mapController = map.getController();

        mapController.setCenter(new GeoPoint(79.49f, -87.33f));
        mapController.setZoom(13f);
        map.setMaxZoomLevel(17.0);
        map.setMinZoomLevel(13.0);

        RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(map);
        mRotationGestureOverlay.setEnabled(true);
        map.setMultiTouchControls(true);
        map.getOverlays().add(mRotationGestureOverlay);

        map.setTileSource(TileSources.StandardResolution);

        findViewById(R.id.places).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Fast travel");

            String[] cities = Cities.list.keySet().toArray(new String[0]);
            GeoPoint[] geoPoints = Cities.list.values().toArray(new GeoPoint[0]);
            builder.setItems(cities, (dialog, which) -> {
                mapController.animateTo(geoPoints[which]);
                Toast.makeText(MainActivity.this, "Travelling to " + cities[which], Toast.LENGTH_SHORT).show();
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        findViewById(R.id.location).setOnClickListener(v -> Toast.makeText(MainActivity.this, map.getMapCenter().toString().replace(",", ",\n"), Toast.LENGTH_LONG).show());

        findViewById(R.id.resolution).setOnClickListener(v -> {
            if (isHighResolution) map.setTileSource(TileSources.StandardResolution);
            else map.setTileSource(TileSources.HighResolution);
            isHighResolution = !isHighResolution;
        });
    }

    public void onResume() {
        super.onResume();
        map.onResume();
    }

    public void onPause() {
        super.onPause();
        map.onPause();
    }
}