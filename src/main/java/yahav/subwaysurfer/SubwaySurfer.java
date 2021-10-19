package yahav.subwaysurfer;

import java.util.List;

public class SubwaySurfer {
    List<Feature> features;

    public static class Feature {
        Properties properties;
        Geometry geometry;

    }
    static class Properties {
        int objectID;
        String name;

        public int getObjectID() {
            return objectID;
        }
        public String getName() {
            return name;
        }

    }
    static class Geometry {
        List<Double> coordinates;
        public List getCoordinates()
        {
            return coordinates;
        }
    }
}
