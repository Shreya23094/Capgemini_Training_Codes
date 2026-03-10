import java.util.*;

public class shoppingCart {
    public static void main(String[] args) {
        List<String[]> cart = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        boolean flag = true;
        String name, company;
        String[] collect;
        boolean exist = false;
        while(flag){
            System.out.println("\nSelect option to perform : \ntype 1 to add mobile company\ntype 2 to remove the brand\ntype 3 to see if this brand exist\ntype 4 to exit.");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter your name:");
                    name = sc.nextLine();
                    System.out.println("\nEnter the company name:");
                    company = sc.nextLine();
                    collect = new String[]{name, company};
                    cart.add(collect);
                    break;
                case 2:
                    System.out.println("\nEnter your name : ");
                    name = sc.nextLine();
                    System.out.println("\nEnter the company name : ");
                    company = sc.nextLine();
                    exist = false;
                    for(int i = 0; i<cart.size(); i++){
                        if (cart.get(i)[0].equals(name) && cart.get(i)[1].equals(company)) {
                            cart.remove(i);
                            exist = true;
                            System.out.println("\nThis cart details have been removed.");
                        }
                    }
                    if(!exist){
                        System.out.println("\nThis does not exist");
                    }
                    break;
                case 3:
                    System.out.println("\nEnter your name : ");
                    name = sc.nextLine();
                    System.out.println("\nEnter the company name : ");
                    company = sc.nextLine();
                    exist = false;
                    for(String[] c : cart){
                        if (c[0].equals(name) && c[1].equals(company)) {
                            System.out.println("\nThis company "+company+" with the owner "+name+" does exist");
                            exist = true;
                        }
                    }
                    if(!exist){
                        System.out.println("\nThis company with this owner does not exist.");
                    }
                    break;
                case 4:
                    flag = false;
                    System.out.println("\nThank you for using the services.");
                    break;
                default:
                    System.out.println("\nInvalid option selected");
                    break;
            }
        }
        sc.close();
    }
}
