import java.lang.reflect.Field;

public class ReflectionDemo {

    public static void main(String[] args) {

        try {
            Employee emp = new Employee();
            Class<?> obj = emp.getClass();
            Field[] fields = obj.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName() + " : " + field.get(emp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
