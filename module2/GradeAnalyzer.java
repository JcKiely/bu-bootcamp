import java.io.*;
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static String filename = "scores.txt";
    static int numberOfScores = 0;
    static int numberOfInvalid = 0;
    static int countA, countB, countC, countD, countE = 0;
 
    public static void main(String[] args) {


        // read scores
        ArrayList<Integer> listOfScores = readScores(filename);


        // calculate average score
        double average = calculateAverage(listOfScores);


        // determine max and min score
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;


        for (int i = 0; i < listOfScores.size(); i++) {
            int score_i = listOfScores.get(i);
            if (listOfScores.get(i) > highest) {
                highest = score_i;
            }
            if (listOfScores.get(i) < lowest) {
                lowest = score_i;
            }
        }


        // count grade bands
        for (int i = 0; i < listOfScores.size(); i++) {
            int score_i = listOfScores.get(i);
            if (score_i >= 90) {
                countA++;
            }
            else if (score_i >= 80 && score_i <= 89) {
                countB++;
            }
            else if (score_i >= 70 && score_i <= 79) {
                countC++;
            }
            else if (score_i >= 60 && score_i <= 69) {
                countD++;
            }
            else if (score_i < 60) {
                countE++;
            }
        }
       
        // write report
        writeReport(listOfScores, average, highest, lowest, "report.txt");
    }
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scoresArrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String lineTrimmed = line.trim();
                try {
                    int n = Integer.parseInt(lineTrimmed);
                    scoresArrayList.add(n);
                    numberOfScores++;
                } catch (NumberFormatException e) {
                    if (lineTrimmed.isEmpty()) {                
                        System.out.println("Blank (invalid) line has been skipped");
                    }
                    else {
                        System.out.println("Skipping invalid value: " + lineTrimmed);
                    }
                    numberOfInvalid++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scoresArrayList;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double total = 0.0;
        double average = 0.0;
        if(scores.size() > 0) {
            for(int i = 0; i < scores.size(); i++) {
                total = total + scores.get(i);
                average = total / scores.size();
            }
        }
        return average;
    }
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("%s%n", "=== Grade Analysis Report ==="));
            writer.write(String.format("%-25s%d%n", "Total scores processed: ", numberOfScores));
            writer.write(String.format("%-25s%d%n%n", "Invalid lines skipped: ", numberOfInvalid));
            writer.write(String.format("%-17s%.2f%n", "Average score: ", avg));
            writer.write(String.format("%-17s%d%n","Highest score: ", high));
            writer.write(String.format("%-17s%d%n%n","Lowest score: ", low));
            writer.write(String.format("%-30s%n","Grade distribution: "));  
            writer.write(String.format("%-17s%d%n","  A (90-100): ", countA));  
            writer.write(String.format("%-17s%d%n","  B (80-89): ", countB));  
            writer.write(String.format("%-17s%d%n","  C (70-79): ", countC));  
            writer.write(String.format("%-17s%d%n","  D (60-69): ", countD));  
            writer.write(String.format("%-17s%d%n","  F (below 60): ", countE));  


            System.out.println(String.format("%s%n", "=== Grade Analysis Report ==="));
            System.out.println(String.format("%-25s%d%n", "Total scores processed: ", numberOfScores));
            System.out.println(String.format("%-25s%d%n%n", "Invalid lines skipped: ", numberOfInvalid));
            System.out.println(String.format("%-17s%.2f%n", "Average score: ", avg));
            System.out.println(String.format("%-17s%d%n","Highest score: ", high));
            System.out.println(String.format("%-17s%d%n%n","Lowest score: ", low));
            System.out.println(String.format("%-30s%n","Grade distribution: "));  
            System.out.println(String.format("%-17s%d%n","  A (90-100): ", countA));  
            System.out.println(String.format("%-17s%d%n","  B (80-89): ", countB));  
            System.out.println(String.format("%-17s%d%n","  C (70-79): ", countC));  
            System.out.println(String.format("%-17s%d%n","  D (60-69): ", countD));  
            System.out.println(String.format("%-17s%d%n","  F (below 60): ", countE));
       } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
       }
    }
}

