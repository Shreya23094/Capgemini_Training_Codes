//print last two bytes of the file

package Basic;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("data.txt","r");
//        long len = file.length();
//        file.skipBytes((int)len-2);
//        int ch = 0;
//        while(ch!=-1){
//            ch = file.read();
//            if(ch==-1){break;}
//            System.out.print((char) ch);
//        }

        file.seek(file.length()-2);
        System.out.println((char)file.read() +""+ (char)file.read());
    }
}