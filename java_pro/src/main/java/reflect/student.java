package reflect;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    private String name;
    private int age;
    private String sex;

    public student(String name, int i) {
        this.name = name;
        this.age = i;
    }

    public void show(){
        System.out.println("show()方法执行");
    }
    public void show(String name){
        System.out.println("show(String name)方法执行");
    }
}
