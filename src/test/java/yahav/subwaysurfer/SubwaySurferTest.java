package yahav.subwaysurfer;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SubwaySurferTest {

    @Test
    public void getStations(){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/subwaystations.json"));
            User user = gson.fromJson(reader, User.class);
            System.out.println(user);
            reader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
