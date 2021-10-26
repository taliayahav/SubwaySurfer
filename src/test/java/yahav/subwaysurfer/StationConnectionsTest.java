package yahav.subwaysurfer;

import com.google.gson.Gson;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class StationConnectionsTest {

    @Test
    public void returnConnectingStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaylines.json"));
        Reader reader2 = Files.newBufferedReader(Paths.get("subwaystations.json"));
        StationConnections stationConnections = new StationConnections();
        Set<String> expected = new HashSet<String>();
        expected.add("186");

        //when
        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
        SubwayStations user2 = gson.fromJson(reader2, SubwayStations.class);
        reader.close();

        //then
        Assert.assertEquals(expected, stationConnections.getStationLines(user, "55"));
    }
}