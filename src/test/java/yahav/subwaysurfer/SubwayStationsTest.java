package yahav.subwaysurfer;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SubwayStationsTest {


    @Test
    public void getStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaylines.json"));

        //when
        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
        reader.close();

        //then
        Assert.assertEquals("55", user.A.get(0));
        Assert.assertNotNull(user.E);
        Assert.assertNotNull(user.E.get(0));
        assertFalse(user.E.isEmpty());
    }
}