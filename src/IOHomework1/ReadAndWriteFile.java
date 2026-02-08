package IOHomework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String path) {
        List<Integer> numbers = new ArrayList<>();

        try {
            File file = new File(path);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Giá trị lớn nhất là: " + max);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
