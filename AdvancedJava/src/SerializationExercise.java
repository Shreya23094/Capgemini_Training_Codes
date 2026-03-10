import java.io.*;

class Employee implements Serializable{
    transient public long time;
    int empId;
    String name;
    public Employee(int empId,String name) {
        super();
        this.empId = empId;
        this.name = name;
    }
    public String toString(){
        return "Employee : [empid = "+empId+" , name = "+name+"]";
    }
}
public class SerializationExercise {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        FileOutputStream fout = new FileOutputStream("empData.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
//        Object obj1 = new Employee(254,"pqr");
//        oos.writeObject(obj1);
        oos.writeObject(new Employee(234,"xyz"));
        oos.writeObject(new Employee(235,"abc"));
        oos.writeInt(987);
        oos.close();
        fout.close();
        System.out.println("Data written");

        FileInputStream fis = new FileInputStream("empData.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj1 = ois.readObject();
        Object obj2 = ois.readObject();
        int x = ois.readInt();  //control 2 + L, control + space, f1
        ois.close();
        fis.close();
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println("x : "+x);
    }
}
