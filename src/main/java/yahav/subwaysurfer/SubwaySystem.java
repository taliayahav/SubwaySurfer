package yahav.subwaysurfer;

import java.util.List;

public class SubwaySystem {
    List<Station> features;

    public static class Station {
        Properties properties;
        Properties.Geometry geometry;

    static class Properties {
        int ObjectID;
        String name;

        public int getObjectID() {
            return ObjectID;
        }
        public String getName() {
            return name;
        }
        static class Geometry {
            List<Double> coordinates;
            public List getCoordinates()
            {
                return coordinates;
            }
            }
        }
    }
}
