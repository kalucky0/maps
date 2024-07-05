package dev.kalucky0.maps;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourcePolicy;
import org.osmdroid.util.MapTileIndex;

public class TileSources {
    public static final OnlineTileSourceBase StandardResolution = new OnlineTileSourceBase("ORTO",
            13, 16, 512, null, new String[]{
            "https://geoportal.b-cdn.net/wss/service/PZGIK/ORTO/REST/StandardResolution/tile/"}, "(c) Geoportal",
            new TileSourcePolicy(2,
                    TileSourcePolicy.FLAG_NO_BULK
                            | TileSourcePolicy.FLAG_NO_PREVENTIVE
                            | TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                            | TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
            )) {
        @Override
        public String getTileURLString(long tileIndex) {
            return getBaseUrl() + MapTileIndex.getZoom(tileIndex) + "/" + MapTileIndex.getY(tileIndex) + "/" + MapTileIndex.getX(tileIndex);
        }
    };

    public static  final OnlineTileSourceBase HighResolution = new OnlineTileSourceBase("HIGH_ORTO",
            13, 16, 512, null, new String[]{
            "https://geoportal.b-cdn.net/wss/service/PZGIK/ORTO/REST/HighResolution/tile/"}, "(c) Geoportal",
            new TileSourcePolicy(2,
                    TileSourcePolicy.FLAG_NO_BULK
                            | TileSourcePolicy.FLAG_NO_PREVENTIVE
                            | TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                            | TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
            )) {
        @Override
        public String getTileURLString(long tileIndex) {
            return getBaseUrl() + MapTileIndex.getZoom(tileIndex) + "/" + MapTileIndex.getY(tileIndex) + "/" + MapTileIndex.getX(tileIndex);
        }
    };
}
