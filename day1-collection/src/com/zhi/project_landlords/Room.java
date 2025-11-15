package com.zhi.project_landlords;

import java.util.*;

public class Room {
    //1.准备54张牌
    private List<Card> cards=new ArrayList<>();
    public void start(){
        //2.定义玩家
        List<Card> xiaobai=new ArrayList<>();
        List<Card> xiaoming=new ArrayList<>();
        List<Card> xiaohong=new ArrayList<>();
        //3.定义花色，牌值，大小王
        String[] colors={"♠","♥","♣","♦"};
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //4.存放牌
        int value=0;
        for (String number : numbers) {
            value++;
            for (String color : colors) {
                cards.add(new Card(color,number,value));
            }
        }
        Collections.addAll(cards,new Card("🤡","small",100),new Card("🤡","big",101));
        //5.打乱牌
        Collections.shuffle(cards);
        //6.发牌
        for (int i = 0; i < cards.size()-3; i++) {
            Card card = cards.get(i);
            switch (i%3){
                case 0:
                    xiaobai.add(card);
                    break;
                case 1:
                    xiaoming.add(card);
                    break;
                case 2:
                    xiaohong.add(card);
                    break;
            }
        }
        //三张底牌
        List<Card> diPai=cards.subList(cards.size()-3,cards.size());
        System.out.println("底牌："+diPai);
        //假设小明叫地主
        System.out.println("小明叫地主");
        //底牌给小明
        xiaoming.addAll(diPai);

        Map<String,List<Card>> players=new HashMap<>();
        players.put("小白",xiaobai);
        players.put("小明",xiaoming);
        players.put("小红",xiaohong);

//        for (List<Card> play : players.values()){
//            System.out.println(play);
//        }
        //7.整理牌
        cardSort(xiaobai);
        cardSort(xiaoming);
        cardSort(xiaohong);

        for (List<Card> play : players.values()){
            System.out.println(play);
        }
    }

    private void cardSort(List<Card> name) {
        Collections.sort(name,(o1, o2)->o2.getValue()-o1.getValue());
    }
}
