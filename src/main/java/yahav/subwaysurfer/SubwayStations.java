package yahav.subwaysurfer;

import java.util.List;

public class SubwayStations {
    List<Station> features;

    public static class Station {
        Properties properties;
        Geometry geometry;
    }

    static class Properties {
        String objectid;
        String name;

        public String getObjectID() {
            return objectid;
        }

        public String getName() {
            return name;
        }
    }

    static class Geometry {
        List<Double> coordinates;

        public List getCoordinates() {
            return coordinates;
        }
    }
}
