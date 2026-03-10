//package Basic;
//
//public class FilesList {
//    public static void main(String[] args) {
//        File file = new File("src");
//        System.out.println("exists "+file.exists());
//        System.out.println("exists "+file.isFile());
//
//        System.out.println("exists "+file.isDirectory());
//        System.out.println();
//
//
//        File file = new File("d:/galgotias");
//        if(!file.exist()){
//            try{
//                boolean created = file.mkdir();
//                System.out.println("Dir created"+created);
//            }
//        }
//        catch(SecurityException e){
//            System.out.println("");
//        }
//    }
//}
