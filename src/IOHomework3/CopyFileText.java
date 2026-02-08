package IOHomework3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the source file: ");
        String sourcePath = sc.nextLine();

        System.out.println("Enter the target file: ");
        String targetPath = sc.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Check source existing
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist");
            return;
        }

        // Check target file existing
        if (targetFile.exists()) {
            System.out.println("Target file already exist");
            return;
        }

        int count = 0;

        try (
            FileReader reader = new FileReader(sourceFile);
            FileWriter writer = new FileWriter(targetFile);
        )
        {
        int ch;
        while ((ch = reader.read()) != -1) {
            writer.write(ch);
            count++;
        }
            System.out.println("Copy completed");
            System.out.println("Total characters copied: " + count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
