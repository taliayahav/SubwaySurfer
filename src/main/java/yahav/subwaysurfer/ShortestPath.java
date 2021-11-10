package yahav.subwaysurfer;

import java.util.*;

public class ShortestPath {
    public List<SubwayStations.Station> dijkstraAlgorithm(SubwayLines subwayLines, SubwayStations station, SubwayStations.Station firstStation,
                                                          SubwayStations.Station endStation) {
        StationConnections stationConnections = new StationConnections();
        List<Integer> adjacentStations = null;
        HashMap<SubwayStations.Station, Integer> stationsWithDistance = new HashMap<>();
        HashMap<SubwayStations.Station, Integer> previousAdjacentStations = new HashMap<>();
        HashMap<SubwayStations.Station, Integer> visitedStations = new HashMap<>();
        List<SubwayStations.Station> stationList = new ArrayList<SubwayStations.Station>();
        initializeStationDistance(previousAdjacentStations, stationList, station, stationsWithDistance, firstStation);
        while(stationsWithDistance.size() >= 1)
        {
            Integer min = Collections.min(stationsWithDistance.values());
            SubwayStations.Station minStation = null;
            List<Integer> lowestDistanceStops = new ArrayList<>();
            if (stationsWithDistance.containsValue(min))
            {
                for (Map.Entry<SubwayStations.Station, Integer> entry : stationsWithDistance.entrySet())
                {
                    if (entry.getValue().equals(min))
                    {
                        minStation = entry.getKey();
                        break;
                    }
                }
            }
            adjacentStations = stationConnections.getStationLines(subwayLines, min);
            addDistanceToAdjacentStations(min, previousAdjacentStations, adjacentStations, stationsWithDistance, stationList);
            int indexOfMin = stationList.indexOf(minStation);
            visitedStations.put(stationList.get(indexOfMin), stationsWithDistance.get(stationList.get(indexOfMin)));
            stationsWithDistance.remove(stationList.get(indexOfMin), stationsWithDistance.get(stationList.get(indexOfMin)));
        }
        return findShortestPath(firstStation,endStation,previousAdjacentStations, stationList);
    }
    public void initializeStationDistance(HashMap<SubwayStations.Station, Integer> previousAdjacentStations,
                                          List<SubwayStations.Station> stationList, SubwayStations stations,
                                          HashMap<SubwayStations.Station, Integer> stationsWithDistance,
                                          SubwayStations.Station firstStation){
        for(SubwayStations.Station currentStation : stations.features){
            if(currentStation.properties.objectid == firstStation.properties.objectid) {
                stationsWithDistance.put(firstStation, 0);
            }
            else {
                stationsWithDistance.put(currentStation, Integer.MAX_VALUE);
                previousAdjacentStations.put(currentStation, null);
            }
            stationList.add(currentStation);
        }
    }
    public void addDistanceToAdjacentStations(Integer previousCurrentStation,
                                              HashMap<SubwayStations.Station, Integer> previousAdjacentStations,
                                              List<Integer> adjacentStations,
                                              HashMap<SubwayStations.Station, Integer> stationsWithDistance,
                                              List<SubwayStations.Station> stationList) {
        for (Integer adjacentStation : adjacentStations) {
            Integer distance = stationsWithDistance.get(adjacentStation);

            Integer indexOfStation = stationList.indexOf(adjacentStation);
            SubwayStations.Station currentStation = stationList.get(indexOfStation);

            Integer indexOfPrev = stationList.indexOf(previousCurrentStation);
            SubwayStations.Station previousStation = stationList.get(indexOfPrev);

            Integer previousDistance = stationsWithDistance.get(previousStation);

            if (distance > previousDistance + 1) {
                stationsWithDistance.remove(currentStation, distance);
                stationsWithDistance.put(currentStation, previousDistance + 1);

                previousAdjacentStations.remove(currentStation);
                previousAdjacentStations.put(currentStation, previousCurrentStation);
            }
        }
    }
    public List<SubwayStations.Station> findShortestPath(SubwayStations.Station firstStation, SubwayStations.Station endStation,
                                                         HashMap<SubwayStations.Station, Integer> previousAdjacentStations,
                                                         List<SubwayStations.Station> stationList)
    {
        List<SubwayStations.Station> pathToStartStation = new ArrayList<SubwayStations.Station>();
        SubwayStations.Station previousStation = null;
        pathToStartStation.add(endStation);
        do {
            int indexOfPrevious = stationList.indexOf(previousAdjacentStations.get(endStation));
            previousStation = stationList.get(indexOfPrevious);
            pathToStartStation.add(previousStation);
        } while(previousStation != firstStation);
        return pathToStartStation;
    }
}
