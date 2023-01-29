package util;

import game.Main;

import java.io.*;
import java.util.ArrayList;

public class ResourceManager {
    private static BufferedReader reader;

    /**Reads a .txt file containing the floor*/
    public ArrayList<String> readFloorFile(String fileName) {
        System.out.println("[ResourceManager]: Reading "+fileName);

        ArrayList<String> strings = new ArrayList<String>();

        //reader = new BufferedReader(new FileReader(fileName));
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        reader = new BufferedReader(new InputStreamReader(is));

        try {
            String str = reader.readLine();
            strings.add(str);

            while(str!=null) {
                str = reader.readLine();
                strings.add(str);
            }

        } catch(IOException e) {
            System.out.println("[ResourceManager] [ERROR]: IOException");
        }

        return strings;
    }
}
