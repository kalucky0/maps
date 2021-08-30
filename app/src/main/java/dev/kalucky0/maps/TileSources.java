package dev.kalucky0.maps;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourcePolicy;
import org.osmdroid.util.MapTileIndex;

public class TileSources {
    private static final String key = "YiIpixv1GSOBggfD4Lu1bmFJ8zSAk5xjQywCoXDiqsw9oeF4Nv9TgmSdNsMozf9T8t1qHtNK_RAB9SudZJIRkQ..";

    public static final OnlineTileSourceBase StandardResolution = new OnlineTileSourceBase("ORTO",
            13, 17, 512, key, new String[]{
            "https://mapy.geoportal.gov.pl/wss/service/PZGIK/ORTO/REST/StandardResolution/tile/"}, "(c) Geoportal",
            new TileSourcePolicy(2,
                    TileSourcePolicy.FLAG_NO_BULK
                            | TileSourcePolicy.FLAG_NO_PREVENTIVE
                            | TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                            | TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
            )) {
        @Override
        public String getTileURLString(long pMapTileIndex) {
            return getBaseUrl() + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex)
                    + "?token=" + mImageFilenameEnding + "&rfh=1";
        }
    };

    public static  final OnlineTileSourceBase HighResolution = new OnlineTileSourceBase("HIGH_ORTO",
            13, 17, 512, key, new String[]{
            "https://mapy.geoportal.gov.pl/wss/service/PZGIK/ORTO/REST/HighResolution/tile/"}, "(c) Geoportal",
            new TileSourcePolicy(2,
                    TileSourcePolicy.FLAG_NO_BULK
                            | TileSourcePolicy.FLAG_NO_PREVENTIVE
                            | TileSourcePolicy.FLAG_USER_AGENT_MEANINGFUL
                            | TileSourcePolicy.FLAG_USER_AGENT_NORMALIZED
            )) {
        @Override
        public String getTileURLString(long pMapTileIndex) {
            return getBaseUrl() + MapTileIndex.getZoom(pMapTileIndex) + "/" + MapTileIndex.getY(pMapTileIndex) + "/" + MapTileIndex.getX(pMapTileIndex)
                    + "?token=" + mImageFilenameEnding + "&rfh=1";
        }
    };
}
