package dev.kalucky0.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourcePolicy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.MapTileIndex;
import org.osmdroid.views.MapView;

public class MainActivity extends Activity {

    MapView map = null;
    final String key = "E2kq2g3urKS1u_WXQ3gqO2501Oe4SFQoLu8e7-wWh4jkXHHNKgm5NmcbNO9F78KeLXF9dkV1AhzKTj3F3ulxKw..";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();

        mapController.setCenter(new GeoPoint(79.49f, -87.33f));
        mapController.setZoom(13f);
        map.setMaxZoomLevel(17.0);
        map.setMinZoomLevel(13.0);

        map.setTileSource(new OnlineTileSourceBase("ORTO",
                13, 17, 512, key, new String[]{
                "https://mapy.geoportal.gov.pl/wss/service/PZGIK/ORTO/REST/StandardResolution/tile/"}, "",
                new TileSourcePolicy(2,
                        TileSourcePolicy.FLAG_NO_BULK
                                | TileSourcePolicy.FLAG_NO_PREVENTIVE
                                | TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                                | TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
                )) {
            @Override
            public String getTileURLString(long pMapTileIndex) {
                Log.e("URL", " === " + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex) + " === ");
                return getBaseUrl() + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex)
                        + "?token=" + mImageFilenameEnding + "&rfh=1";
            }
        });

        findViewById(R.id.places).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Fast travel");

            String[] cities = {"Warszawa", "Gdańsk", "Kraków", "Poznań", "Wrocław", "Ostrołęka"};
            builder.setItems(cities, (dialog, which) -> {
                switch (which) {
                    case 0: // Warszawa
                        mapController.animateTo(new GeoPoint(76.23f, -92.9f));
                        break;
                    case 1: // Gdańsk
                        mapController.animateTo(new GeoPoint(82.88f, -118.86f));
                        break;
                    case 2: // Kraków
                        mapController.animateTo(new GeoPoint(63f, -104.25f));
                        break;
                    case 3: // Poznań
                        mapController.animateTo(new GeoPoint(76.97f, -137.91f));
                        break;
                    case 4: // Wrocław
                        mapController.animateTo(new GeoPoint(70.49f, -137.45f));
                        break;
                    case 5: // Ostrołęka
                        mapController.setCenter(new GeoPoint(79.49f, -87.33f));
                        break;
                }
                Toast.makeText(MainActivity.this, "Travelling to " + cities[which], Toast.LENGTH_SHORT).show();
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        findViewById(R.id.location).setOnClickListener(v -> Toast.makeText(MainActivity.this, map.getMapCenter().toString().replace(",", ",\n"), Toast.LENGTH_LONG).show());
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