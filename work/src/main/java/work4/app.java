package work4;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        Liquid water=new Liquid("水",4,24);
        Liquid milk=new Liquid("牛奶",8,160);
        Liquid wuliangye=new Liquid("五粮液",2,4000);
        Liquid cola=new Liquid("可乐",6,108);
        Liquid maotai=new Liquid("茅台",1,4000);
        List<Liquid> list=new ArrayList<>();
        list.add(water);
        list.add(milk);
        list.add(wuliangye);
        list.add(cola);
        list.add(maotai);
        int maxValue=0;
        int index=getMax(list);
        for(int i=1;i<11;i++){
            if(list.get(index).getWeight()<=0){
                list.remove(index);
                index=getMax(list);
            }
            maxValue+=list.get(index).getPrice();
            list.get(index).setWeight(list.get(index).getWeight()-1);
            System.out.println("第"+i+"升拿的是"+list.get(index));
        }
        System.out.println("总价为："+maxValue);


    }
    public static int getMax(List<Liquid> list) {
        int maxPrice = 0;
        for (Liquid l : list) {
            if (l.getPrice() > maxPrice) {
                maxPrice = l.getPrice();
            }
        }
        int i;
        for (i=0;i<list.size();i++){
            if (list.get(i).getPrice() == maxPrice) {
                System.out.println(list.get(i));
                return i;
            }
        }
        return i;
    }
}
