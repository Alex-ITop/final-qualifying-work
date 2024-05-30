package main.java;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataParsing {

    public static void main(String[] args) throws IOException {
        String path_root = "E:\\4 КУРС\\ДИПЛОМ ВКР\\final-qualifying-work\\initial data\\зуб\\";
        BufferedReader br = null;
        try {
            File file = new File(path_root + "материал 1\\Material_1_dent_sint_100.txt");

            int ind = 0;
            String FIND = "SINT";
            if(!file.exists())
                file.createNewFile();

            br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                line = line.replaceFirst("^\\s*", "");
//                for (int i = 0; i < 100; i++) {
                    if (line.contains(FIND)) {
                        String[] value = line.split("\\s+");
                        List<String> names = Arrays.asList(value);
                        int index = names.indexOf(FIND);
                        String nextLine = br.readLine();
//                        while (!nextLine.equals("") || !nextLine.equals(" \n")) {
                        while (nextLine.length() > 3) {
                                nextLine = nextLine.replaceFirst("^\\s*", "");
                                nextLine = nextLine.replaceAll("-", "  -");
                                String[] element = nextLine.split("\\s+");
                                System.out.println(element[index]);
                                nextLine = br.readLine();
//                            nextLine = nextLine.replaceFirst("^\\s*", "");
//                                System.out.println(nextLine);
                            }



//                        System.out.println(Arrays.toString(element));
//                        for (String word : value) {
//                            System.out.println(word);
//                        }
                    }
            }
//            while((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch(IOException e) {
            System.out.print("Error: " + e);
        } finally {
            try{
                br.close();
            } catch (IOException e) {
                System.out.print("Error: " + e);
            }

        }
    }
}
