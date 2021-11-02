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
        StationConnections stationConnections = new StationConnections();
        Set<String> expected = new HashSet<String>();
        expected.add("128");
        expected.add("419");

        //when
        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
        reader.close();

        //then
        Assert.assertEquals(expected, stationConnections.getStationLines(user, "123"));
    }
}