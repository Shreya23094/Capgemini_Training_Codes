package Basic;

class PictureFormatException extends Exception {

    public PictureFormatException(String message) {
        super(message);
    }
}

public class ExceptionExercise {

    public static void uploadPic() {

        try {
            System.out.println("Upload pic");

            throw new PictureFormatException("Picture size or format not correct");

        }
        catch (PictureFormatException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Some other error occurred");
        }
        finally {
            System.out.println("Finally block executed");
        }
    }

    public static void main(String[] args) {
        uploadPic();
    }
}