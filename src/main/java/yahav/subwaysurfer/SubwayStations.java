package yahav.subwaysurfer;

import java.awt.geom.Point2D;
import java.util.List;

public class SubwayStations {
   public List<Station> features;

    static class Station {
        Properties properties;
        Geometry geometry;
        List<Station> connections;

        static class Properties {
            int objectid;
            String name;

            public int getObjectID() {
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
    public Station findStation(double latitude, double longitude) {
        double closestStartDistance = Double.MAX_VALUE;
        SubwayStations.Station closestStation = features.get(0);
        Point2D.Double givenStartPoint = new Point2D.Double(latitude, longitude);
        for (SubwayStations.Station station : features) {
            Point2D.Double stationStartPoint = new Point2D.Double(station.geometry.coordinates.get(0), station.geometry.coordinates.get(1));
            double distance = Point2D.distance(stationStartPoint.x, stationStartPoint.y, givenStartPoint.x, givenStartPoint.y);
            if (closestStartDistance > distance) {
                closestStartDistance = distance;
                closestStation = station;
            }
        }
        return closestStation;
    }
}


