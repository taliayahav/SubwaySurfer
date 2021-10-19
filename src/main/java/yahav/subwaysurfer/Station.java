package yahav.subwaysurfer;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Station {
    List<Feature> features;

    public static class Feature{
        Properties properties;
        Geometry geometry;

    }
    static class Geometry{
        List<Double> coordinates;

        public List getCoordinates(){
            return coordinates;
        }
        
    }
}
