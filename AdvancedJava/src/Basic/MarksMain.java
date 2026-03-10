package Basic;
import java.io.*;

public class MarksMain {
    public static void main(String[] args) throws IOException{
        MarksDB db = new MarksDB("marks.dat");
        db.writeData(123,45);
        db.writeData(125,45);
        db.writeData(190,45);
        db.writeData(24,45);

        db.printAll();
    }
}
