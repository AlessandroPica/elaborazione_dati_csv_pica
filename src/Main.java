import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/Grado-diffusione-del-PC-nelle-imprese-con-meno-di-10-addetti.csv";
        String outputFile = "report.csv";

        List<Record> records = loadRecords(inputFile);
        saveReport(outputFile, records);
    }

    private static List<Record> loadRecords(String filePath) {
        List<Record> records = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            br.readLine(); // Salta l'intestazione
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int anno = Integer.parseInt(parts[0]);
                String regione = parts[1];
                double percentuale = Double.parseDouble(parts[2]);
                records.add(new Record(anno, regione, percentuale));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private static void saveReport(String filePath, List<Record> records) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))) {
            bw.write("Regione;Anno;Percentuale\n");
            for (Record record : records) {
                bw.write(record.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
