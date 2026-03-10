//package Basic;
//
//public class ExceptionDemo {
//    public static void uploadPic(){
//
//        // try block must be followed by either a catch or a finally block or both
//        try{
//            System.out.println("Upload pic");
//            PictureFormatException e = new PictureFormatException();
//            throw e;
//        }
//        //catch block can never go to try block.
//        catch(PictureFormatException e){
//            System.out.println("size or format not correct");
//        }
//        //it can handle all the types of exception without checking other exceptions so we put it at the end
//        catch(Exception e){
//            System.out.println("some other error occurred");
//        }
//        finally{
//
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
//
//
//
package Basic;
import java.util.InputMismatchException;
import java.util.Scanner;

////Checked exceptions are those which does not align in runtime exception



public class ExceptionDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        try{
            for(int i = 0; i<5; i++){
                try{
                    int x = sc.nextInt();
                    s += x;
                    i--;
                }
                catch(InputMismatchException e){
                    System.out.println("input data type is integer so do not add any other type of input");
                }
            }
        }
        catch(Exception e){
            System.out.println("Some error occurred");
        }
        finally {
            sc.close();
        }
    }
}