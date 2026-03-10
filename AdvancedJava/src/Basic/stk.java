package Basic;

public class stk {
    int[] a = new int[10];
    int top = -1;
    void push(int x){
        if(top == a.length){
            System.out.println("overflow");
            return;
        }
    }
    int pop() throws Exception{
        if(top==-1){
            System.out.println("underflow");
            Exception e = new Exception("underflow");
            throw e;
        }else {
            return a[top--];
        }
    }
}
