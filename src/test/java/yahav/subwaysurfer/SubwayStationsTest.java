package yahav.subwaysurfer;

import org.junit.Test;
import com.google.gson.Gson;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;


public class SubwayStationsTest {


    @Test
    public void getStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaystations.json"));

        //when
        SubwayStations user = gson.fromJson(reader, SubwayStations.class);
        reader.close();

        //then
        assertEquals("Astor Pl", user.features.get(0).properties.name);
        assertEquals(1, user.features.get(0).properties.objectid);
        assertEquals(-73.99106999861966, user.features.get(0).geometry.getCoordinates().get(0));
        assertEquals(40.73005400028978, user.features.get(0).geometry.getCoordinates().get(1));
    }

    @Test
    public void findStartStation() throws IOException{
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("subwaystations.json"));
        Point2D.Double startPoint = new Point2D.Double(-73.9844575, 40.7701871 ); //mandarin hotel

        //when
        SubwayStations user = gson.fromJson(reader, SubwayStations.class);
        reader.close();


        //then
        assertEquals(94, user.findStartStation(startPoint.getX(),startPoint.getY()).properties.objectid); //columbus circle
    }
}