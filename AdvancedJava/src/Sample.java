import java.io.*;

public class Sample {
    public static void main(String[] args) throws IOException {
        readLineBySkippingAlternate("data.txt","dataCopy.txt");
        readBySkippingAlternate("data.txt","dataCopy.txt");
    }
    public static void readLineBySkippingAlternate(String inputFile, String outputFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        FileWriter fout = new FileWriter(outputFile);

        String ch="";
        while(ch!=null){
            ch = br.readLine();
            if(ch==null){break;}
            fout.write(ch);
            fout.write("\n");
            br.readLine();
        }

        br.close();
        fout.close();
        System.out.println("Written all the text from file 1 to file 2 alternatively skipping lines");
    }

    public static void readBySkippingAlternate(String inputFile, String outputFile) throws IOException{
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fout = new FileOutputStream(outputFile);

        int ch = 0;
        while(ch!=-1){
            ch = fis.read();
            if(ch==-1){break;}
            fout.write(ch);
            fis.read();
        }

        fis.close();
        fout.close();
        System.out.println("Written all the text from file 1 to file 2 alternatively skipping characters");
    }
//    public static void copyhalfwordEachLine(String inputFile, String outputFile){
//
//    }
//    public static String halfWords(String line){
//        String[] words = line.split("[ ]+");
//        //line.split("\\s+");
//
//    }
}