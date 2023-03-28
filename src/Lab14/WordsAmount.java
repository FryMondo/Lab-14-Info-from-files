package Lab14;

import java.io.*;

class WordsCounter {
    public long counter(String filePath) {
        if (filePath == null || filePath.trim().equals("")) {
            throw new IllegalArgumentException("The path of the file is incorrect!");
        }
        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getParent() + "/output.txt"));
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            reader.close();
            writer.write("Amount of words: " + wordCount);
            writer.close();
            return 0;
        } catch (IOException exception) {
            return -1;
        }
    }

}

class amountOfWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Dell 7280\\Desktop\\JavaLabs\\src\\Lab14\\filesForTask1\\words.txt";
        WordsCounter wordsCounter = new WordsCounter();
        if (wordsCounter.counter(filePath) == 0) {
            System.out.println("The result was successfully transferred to the file \"output.txt\"");
        } else {
            System.out.println("Error while processing file!");
        }
    }
}