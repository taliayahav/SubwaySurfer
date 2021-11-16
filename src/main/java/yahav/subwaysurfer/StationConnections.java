package yahav.subwaysurfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StationConnections {
    public List<Integer> getStationLines(SubwayLines subwayLines, Integer station){
        List<Integer> linesWithStation = new ArrayList<Integer>();
        ArrayList<List<Integer>> lines = new ArrayList<List<Integer>>();
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
        for(List<Integer> line: lines){
            if(line.contains(station)) {
                int index = line.indexOf(station);
                addToList(station, linesWithStation, line, index+1);
                addToList(station, linesWithStation, line, index-1);
            }
        }
        linesWithStation.remove(station);
        return linesWithStation;
    }

    private void addToList(Integer station, List<Integer> linesWithStation, List<Integer> line, int index) {
        if (index > 0 && index < line.size()-2) {
            if (!linesWithStation.contains(line.get(index))) {
                linesWithStation.add(line.get(index));
            }
        }
    }
}
