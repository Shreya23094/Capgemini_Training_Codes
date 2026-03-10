package Basic;

import java.io.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class MarksDB {
    String filename;
    ObjectInputStream oos = null;
    ObjectInputStream ois = null;
    public MarksDB(String filename){
        super();
        this.filename = filename;
    }
    public void printAll() throws IOException{
        FileInputStream fin = new FileInputStream("empData.bin");
        ObjectInputStream ois = new ObjectInputStream(fin);
        while(ois.available() > 0){
            int roll =  ois.readInt();
            int marks = ois.readInt();
            System.out.println(roll + "\t" + marks);
        }
        ois.close();
        fin.close();
    }
    public void writeData(int roll,int marks) throws IOException{
        FileOutputStream fout = new FileOutputStream(filename,true);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeInt(roll);
        oos.writeInt(marks);
        oos.close();
        fout.close();
    }
}
