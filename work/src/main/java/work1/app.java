package work1;

import java.util.*;

public class app {
    public static void main(String[] args) {
        //红球：1-35
        int[] redBall={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
        //蓝球：1-15
        int[] blueBall={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Set<Integer> set=new TreeSet<>();
        while(!(set.size()==6)){
            int random=(int)(Math.random()*34);
            set.add(redBall[random]);
        }
        // 将 LinkedHashSet 转换为 TreeSet，会自动排序
        System.out.println(set);
        set.add(blueBall[(int)(Math.random()*14)]);
        //升序排序

        System.out.println(set);
        int[] result={10,12,30,16,7,17,12};
        int redCout=0;
        int blueCout=0;
        for (int i = 0; i < result.length; i++){
            if(set.contains(result[i])){
                if(i<6){
                    redCout++;
                }else{
                    blueCout++;
                }
            }
        }
        System.out.println("中奖："+redCout+"个红球"+blueCout+"个蓝球");
    }
}
