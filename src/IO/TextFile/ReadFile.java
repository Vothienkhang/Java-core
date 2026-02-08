package IO.TextFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

    public void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File  file = new File(filePath);

            // Kiểm tra nếu file không tồn ti thì ném ra ngoại lệ
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành tính tổng
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            // TH file khng tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi
            System.err.println(e);
        }
    }

    public static  void main(String[] args) {
        System.out.println("Nập đường dẫn của file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        ReadFile rf = new ReadFile();
        rf.readFileText(path);
    }
}
