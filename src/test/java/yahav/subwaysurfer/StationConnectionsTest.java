package yahav.subwaysurfer;

import com.google.gson.Gson;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StationConnectionsTest {

    @Test
    public void returnConnectingStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaylines.json"));
        StationConnections stationConnections = new StationConnections();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(419, 128));
        List<Integer> actual = new ArrayList<Integer>();

        //when
        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
        reader.close();
        actual = stationConnections.getStationLines(user, 123);

        //then
        Assert.assertEquals(expected, actual);
    }
}