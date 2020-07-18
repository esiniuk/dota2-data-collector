package datacollectors;

import bisnessobjects.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class CreateFullFile {

    public static void main(String[] agrs) throws IOException {

        File outputFile = new File("fullData.json");
        File matchesData = new File("matches.csv");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        BufferedReader matchesReader = new BufferedReader(new FileReader(matchesData));
        String match;
        Matches matches = new Matches();
        while ((match = matchesReader.readLine()) != null) {
            String[] realMatch = match.split(",");
            matches.matches.add(new Match(realMatch[0], realMatch[1], realMatch[2],
                    new Ban(realMatch[3], new PickBanDB(realMatch[1], realMatch[3]), new CounterPickDB(realMatch[2], realMatch[3])),
                    new Ban(realMatch[4], new PickBanDB(realMatch[2], realMatch[4]), new CounterPickDB(realMatch[1], realMatch[4])),
                    new Ban(realMatch[5], new PickBanDB(realMatch[1], realMatch[5]), new CounterPickDB(realMatch[2], realMatch[5])),
                    new Ban(realMatch[6], new PickBanDB(realMatch[2], realMatch[6]), new CounterPickDB(realMatch[1], realMatch[6])),
                    new Ban(realMatch[7], new PickBanDB(realMatch[1], realMatch[7]), new CounterPickDB(realMatch[2], realMatch[7])),
                    new Ban(realMatch[8], new PickBanDB(realMatch[2], realMatch[8]), new CounterPickDB(realMatch[1], realMatch[8])),
                    new Ban(realMatch[9], new PickBanDB(realMatch[1], realMatch[9]), new CounterPickDB(realMatch[2], realMatch[9])),
                    new Ban(realMatch[10], new PickBanDB(realMatch[2], realMatch[10]), new CounterPickDB(realMatch[1], realMatch[10])),
                    new Pick(realMatch[11], new PickBanDB(realMatch[1], realMatch[11]), new CounterPickDB(realMatch[2], realMatch[11])),
                    new Pick(realMatch[12], new PickBanDB(realMatch[2], realMatch[12]), new CounterPickDB(realMatch[1], realMatch[12])),
                    new Pick(realMatch[13], new PickBanDB(realMatch[2], realMatch[13]), new CounterPickDB(realMatch[1], realMatch[13])),
                    new Pick(realMatch[14], new PickBanDB(realMatch[1], realMatch[14]), new CounterPickDB(realMatch[2], realMatch[14])),
                    new Ban(realMatch[15], new PickBanDB(realMatch[1], realMatch[15]), new CounterPickDB(realMatch[2], realMatch[15])),
                    new Ban(realMatch[16], new PickBanDB(realMatch[2], realMatch[16]), new CounterPickDB(realMatch[1], realMatch[16])),
                    new Pick(realMatch[17], new PickBanDB(realMatch[2], realMatch[17]), new CounterPickDB(realMatch[1], realMatch[17])),
                    new Pick(realMatch[18], new PickBanDB(realMatch[1], realMatch[18]), new CounterPickDB(realMatch[2], realMatch[18])),
                    new Pick(realMatch[19], new PickBanDB(realMatch[2], realMatch[19]), new CounterPickDB(realMatch[1], realMatch[19])),
                    new Pick(realMatch[20], new PickBanDB(realMatch[1], realMatch[20]), new CounterPickDB(realMatch[2], realMatch[20])),
                    new Ban(realMatch[21], new PickBanDB(realMatch[2], realMatch[21]), new CounterPickDB(realMatch[1], realMatch[21])),
                    new Ban(realMatch[22], new PickBanDB(realMatch[1], realMatch[22]), new CounterPickDB(realMatch[2], realMatch[22])),
                    new Pick(realMatch[23], new PickBanDB(realMatch[1], realMatch[23]), new CounterPickDB(realMatch[2], realMatch[23])),
                    new Pick(realMatch[24], new PickBanDB(realMatch[2], realMatch[24]), new CounterPickDB(realMatch[1], realMatch[24]))
            ));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(matches);
        fileOutputStream.write(json.getBytes());

        fileOutputStream.close();
    }

}
