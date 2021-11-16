package yahav.subwaysurfer;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShortestPathTest {
    @Test
    public void getStationLines() throws IOException {
        //given
//        Gson gson = new Gson();
//        Reader reader = Files.newBufferedReader(Paths.get("subwaylines.json"));
//        Reader stationReader = Files.newBufferedReader(Paths.get("subwaystations.json"));
//
//        //when
//        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
//        reader.close();
//        SubwayStations stationUser = gson.fromJson(stationReader, SubwayStations.class);
//        stationReader.close();
//        List<SubwayStations.Station> findNearestPath = new ShortestPath().dijkstraAlgorithm(user, stationUser, stationUser.features.get(1), stationUser.features.get(3));
//
//        //then
//        assertEquals(2, findNearestPath.get(0).properties.objectid);
    }
}