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


public class SubwaySurferTest {


    @Test
    public void getStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaystations.json"));

        //when
        SubwaySurfer user = gson.fromJson(reader, SubwaySurfer.class);
        reader.close();

        //then
        Assert.assertNotNull(user.features);
        Assert.assertNotNull(user.features.get(0).properties.name);
        Assert.assertNotNull(user.features.get(0).geometry.coordinates);
        assertFalse(user.features.isEmpty());
        assertFalse(user.features.get(0).geometry.coordinates.isEmpty());
    }
}