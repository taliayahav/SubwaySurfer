package yahav.subwaysurfer;

import java.awt.geom.Point2D;
import java.util.List;

public class SubwayStations {
    List<Station> features;

    static class Station {
        public List<Station> connections;
        Properties properties;
        Geometry geometry;

        public Station(List<Station> connections) {
            this.connections = connections;
        }

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
    public Station findStartStation(double startLatitude, double startLongitude) {
        double closestStartDistance = Double.MAX_VALUE;
        SubwayStations.Station closestStartStation = features.get(0);
        Point2D.Double givenStartPoint = new Point2D.Double(startLatitude, startLongitude);
        for(SubwayStations.Station station : features){
            Point2D.Double stationStartPoint = new Point2D.Double(station.geometry.coordinates.get(0), station.geometry.coordinates.get(1));
            double distance = Point2D.distance(stationStartPoint.x, stationStartPoint.y, givenStartPoint.x, givenStartPoint.y);
            if(closestStartDistance > distance){
                closestStartDistance = distance;
                closestStartStation = station;
            }
        }
        return closestStartStation;
    }
    public Station findEndStation(double endLatitude, double endLongitude){
//            double closestEndDistance = Double.MAX_VALUE;
        SubwayStations.Station closestEndStation = SubwayStations.this.features.get(0);
//            Point2D.Double endPoint = new Point2D.Double(endLatitude, endLongitude);
//            for(SubwayStations.Station station : features){
//                Point2D.Double stationEndPoint = new Point2D.Double(station.geometry.coordinates.get(0), station.geometry.coordinates.get(1));
//                double endDistance = Math.sqrt((stationEndPoint.getX()-endPoint.getX()*2) + (stationEndPoint.getY() - endPoint.getY()*2));
//                if(closestEndDistance > endDistance){
//                    closestEndDistance = endDistance;
//                    closestEndStation = station;
        findStartStation(endLatitude, endLongitude);
        //  }
        //}
        return closestEndStation;
    }
}


