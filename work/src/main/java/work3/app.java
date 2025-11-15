package work3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class app {

    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("东湖",0);
        map.put("黄鹤楼",0);
        map.put("木兰文化区",0);
        map.put("归元禅寺",0);
        String info="10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺" +
                "#10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖#10004,小昭,女,2023-07-22 08:11:21,东湖";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //根据#分割
        List<Student> list=new ArrayList<>();
        String[] infos=info.split("#");
        for(String s:infos){
            String[] info1=s.split(",");
            Student student=new Student(Long.valueOf(info1[0]),info1[1],info1[2],LocalDateTime.parse(info1[3],formatter),info1[4]);
            list.add(student);
        }
        for(Student s:list){
            String location = s.getLocation();
            String[] locs=location.split("-");
            for(String loc:locs){
                if(map.containsKey(loc)){
                    map.put(loc,map.get(loc)+1);
                }
            }
        }
        System.out.println(map);

        int max=0;
        for(Integer value1:map.values()){
            if(value1>max){
                max=value1;
            }
        }
        System.out.println("最多人想去景点有：");
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==max){
                System.out.println(entry.getKey());
            }
        }
        System.out.println("没有选择最多人想去景点的有：");
        for(Student s: list){
            String location = s.getLocation();
            String[] locs=location.split("-");
            for(String loc:locs){
                if(!loc.equals(map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey())){
                    System.out.print(s.getName());
                }
            }
        }


    }
}
