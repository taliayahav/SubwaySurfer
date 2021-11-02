package yahav.subwaysurfer;

import com.google.gson.Gson;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;

public class SubwayLinesTest {
    @Test
    public void getStationLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaylines.json"));

        //when
        SubwayLines user = gson.fromJson(reader, SubwayLines.class);
        reader.close();

        //then
        Assert.assertNotNull(user.E);
        Assert.assertNotNull(user.E.get(0));
        assertFalse(user.E.isEmpty());
    }
}