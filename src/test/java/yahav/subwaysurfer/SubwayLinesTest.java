package yahav.subwaysurfer;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

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
        assertNotNull(user.E);
        assertNotNull(user.E.get(0));
        assertFalse(user.E.isEmpty());
        assertEquals("29", user.sixExpress.get(0));
        assertEquals("133", user.two.get(0));
    }
}