package Lab14;

import java.io.*;

class Merger {
    public void fileMerge(String destinationFile, String baseFileName) {
        if (destinationFile == null || destinationFile.trim().equals("")) {
            throw new IllegalArgumentException("The path of the destination file is incorrect!");
        }
        if (baseFileName == null || baseFileName.trim().equals("")) {
            throw new IllegalArgumentException("The path of input files are incorrect!");
        }
        String extension = "txt";
        int fileCount = 0;
        byte[] buffer = new byte[1024];
        try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
            while (true) {
                String fileName = baseFileName + (fileCount < 100 ? (fileCount < 10 ? "00" : "0") : "")
                        + fileCount + "." + extension;
                File file = new File(fileName);
                if (!file.exists()) {
                    break;
                }
                try (FileInputStream fis = new FileInputStream(fileName)) {
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
                fileCount++;
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

class MergedFiles {
    public static void main(String[] args) {
        String destination = "C:\\Users\\Dell 7280\\Desktop\\JavaProject\\src\\Lab14\\filesForTask2\\destination.txt";
        String baseFile = "C:\\Users\\Dell 7280\\Desktop\\JavaProject\\src\\Lab14\\filesForTask2\\file.";
        Merger merger = new Merger();
        merger.fileMerge(destination, baseFile);
    }
}