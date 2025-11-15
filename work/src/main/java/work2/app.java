package work2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class app {
    public static void main(String[] args) {
        Set<Integer> set=new LinkedHashSet<>();
        while(set.size()<100){
            int random=(int)(Math.random()*199+1);
            set.add(random);
        }
        System.out.println( set);
        List<Prisoner> list=new ArrayList<>();
        int index=1;
        for(Integer value:set){
            list.add(new Prisoner(index,value));
            index++;
        }
        System.out.println(list);
        System.out.println(kill( list));

    }
    public static List<Prisoner> kill(List<Prisoner> list){
        if(list==null||list.isEmpty()){
            return new ArrayList<>();
        }
        if(list.size()<=1) return list;


        List<Prisoner> list1=new ArrayList<>();
        for(int i=1;i<list.size();i+=2){
            list1.add(list.get(i));
        }
        return kill(list1);

    }
}
