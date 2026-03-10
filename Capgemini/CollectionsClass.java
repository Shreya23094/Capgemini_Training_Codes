import java.util.ArrayList;

public class CollectionsClass {
    public static void main(String[] args) {
        ArrayList<String> arrTemp = new ArrayList<>();
        arrTemp.add("apple");
        arrTemp.add("banana");
        arrTemp.add("guava");
        System.out.println(arrTemp);
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("orange");
        arr2.addAll(arrTemp);
        System.out.println(arr2);
        arr2.remove(1);
        System.out.println(arr2);
        arr2.clear();
        System.out.println(arr2);
        arr2.addAll(arrTemp);
        arr2.add(1, "strawberry");
        System.out.println(arr2);
        System.out.println(arr2.contains("strawberry"));
        System.out.println(arr2.containsAll(arrTemp));
        for(String str : arr2){
            System.out.println(str);
        }
        arr2.remove("strawberry");
        System.out.println(arr2);
        arr2.removeAll(arrTemp);
        System.out.println(arr2);
        
    }
}
