package proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements action{
    String name;
    String sex;

    @Override
    public void sing(){
        System.out.println(name+"正在唱歌");
    }
    @Override
    public void dance(){
        System.out.println(name+"正在跳舞");
    }
}
