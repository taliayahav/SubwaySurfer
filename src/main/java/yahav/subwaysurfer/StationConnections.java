package yahav.subwaysurfer;

import java.util.ArrayList;
import java.util.List;

public class StationConnections {
    public List<String> getStationLines(SubwayLines subwayLines, String station){
        List<String> linesWithStation = new ArrayList<String>();
        ArrayList<List<String>> lines = new ArrayList<List<String>>();
        lines.add(subwayLines.A);
        lines.add(subwayLines.B);
        lines.add(subwayLines.C);
        lines.add(subwayLines.D);
        lines.add(subwayLines.E);
        lines.add(subwayLines.F);
        lines.add(subwayLines.G);
        lines.add(subwayLines.J);
        lines.add(subwayLines.L);
        lines.add(subwayLines.M);
        lines.add(subwayLines.N);
        lines.add(subwayLines.Q);
        lines.add(subwayLines.R);
        lines.add(subwayLines.S);
        lines.add(subwayLines.W);
        lines.add(subwayLines.Z);
        lines.add(subwayLines.sixExpress);
        lines.add(subwayLines.sevenExpress);
        lines.add(subwayLines.one);
        lines.add(subwayLines.two);
        lines.add(subwayLines.three);
        lines.add(subwayLines.four);
        lines.add(subwayLines.five);
        lines.add(subwayLines.six);
        lines.add(subwayLines.seven);
        for(List<String> line: lines){
            if(line.contains(station)){
                linesWithStation.add(line.get(0));
            }
        }
        return linesWithStation;
    }
}
