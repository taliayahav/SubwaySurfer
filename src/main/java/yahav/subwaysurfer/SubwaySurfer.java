package yahav.subwaysurfer;

import java.util.List;

public class SubwaySurfer {
    List<Feature> features;

    public static class Feature {
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
