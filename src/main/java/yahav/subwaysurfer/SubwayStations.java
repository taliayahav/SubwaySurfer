package yahav.subwaysurfer;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class SubwayStations {
    List<Station> features;

    public class Station {
        public List<Station> connections;
        Properties properties;
        Geometry geometry;

        public Station(List<Station> connections) {
            this.connections = connections;
        }

        public class Properties {
            int objectid;
            String name;

            public int getObjectID() {
                return objectid;
            }

            public String getName() {
                return name;
            }
        }

        public class Geometry {
            List<Double> coordinates;

            public List getCoordinates() {
                return coordinates;
            }
        }
        public Station findStartStation(Double startLatitude, Double startLongitude) {
            double closestStartDistance = Double.MAX_VALUE;
            SubwayStations.Station closestStartStation = SubwayStations.this.features.get(0);
            Point2D.Double startPoint = new Point2D.Double(startLatitude, startLongitude);
            for(SubwayStations.Station station : features){
                Point2D.Double stationStartPoint = new Point2D.Double(station.geometry.coordinates.get(0), station.geometry.coordinates.get(1));
                double distance = Math.sqrt((stationStartPoint.getX()-startPoint.getX()*2) + (stationStartPoint.getY() - startPoint.getY()*2));
                if(closestStartDistance > distance){
                    closestStartDistance = distance;
                    closestStartStation = station;
                }
            }
            return closestStartStation;
        }
        public Station findEndStation(Double endLatitude, Double endLongitude){
            double closestEndDistance = Double.MAX_VALUE;
            SubwayStations.Station closestEndStation = SubwayStations.this.features.get(0);
            Point2D.Double endPoint = new Point2D.Double(endLatitude, endLongitude);
            for(SubwayStations.Station station : features){
                Point2D.Double stationEndPoint = new Point2D.Double(station.geometry.coordinates.get(0), station.geometry.coordinates.get(1));
                double endDistance = Math.sqrt((stationEndPoint.getX()-endPoint.getX()*2) + (stationEndPoint.getY() - endPoint.getY()*2));
                if(closestEndDistance > endDistance){
                    closestEndDistance = endDistance;
                    closestEndStation = station;
                }
            }
            return closestEndStation;
        }
    }
}


