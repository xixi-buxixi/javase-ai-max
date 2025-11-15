package com.zhi.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class movieOperator {
    private static List<movies> movies=new ArrayList<movies>();
    private static Scanner sc=new Scanner(System.in);


    public void start() {
        while (true) {
            System.out.println("====电影操作系统====");
            System.out.println("1.添加电影");
            System.out.println("2.下架电影");
            System.out.println("3.查询电影");
            System.out.println("4.下架某明星所有电影");
            System.out.println("5.显示所有电影");
            System.out.println("6.退出");
            System.out.println("请输入你的选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    deleteMovie();
                    break;
                case 3:
                    queryMovie();
                    break;
                case 4:
                    deleteMovieByStar();
                    break;
                case 5:
                    showMovie();
                    break;
                case 6:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }
            }
        }

    private void showMovie() {
        System.out.println("=========================");
        for (movies movie : movies) {
            System.out.println(movie);
        }
    }

    private void deleteMovieByStar() {
        System.out.println("=========================");
        System.out.println("请输入明星名称：");
        String star=sc.next();
        for (int i=0;i<movies.size();i++){
            if (movies.get(i).getActor().contains(star)){
                movies.remove(i);
                i--;
            }
        }
        System.out.println("删除成功");
        showMovie();

    }

    private void queryMovie() {
        System.out.println("=========================");
        System.out.println("请输入电影名称：");
        //根据电影名称查询电影对象
        String name=sc.next();
        queryByName(name);


    }

    private void queryByName(String name) {
        System.out.println("=========================");
        System.out.println("请输入电影名称：");
        for (movies movie : movies) {
            if (movie.getName().contains(name)) {
                System.out.println(movie);
            }else {
                System.out.println("没有此电影");
            }
        }
    }

    private void deleteMovie() {
        System.out.println("=========================");
        System.out.println("请输入电影名称：");
        String name=sc.next();
        for (int i=0;i<movies.size();i++){
            if (movies.get(i).getName().contains(name)){
                movies.remove(i);
                System.out.println("删除成功");
                showMovie();
                return;
            }
        }
        System.out.println("没有此电影");
        showMovie();

    }

    private void addMovie() {
        System.out.println("=========================");
        movies movie=new movies();
        //给电影对象注入数据
        System.out.println("请输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请输入电影评分：");
        movie.setScore(sc.nextDouble());
        System.out.println("请输入主演：");
        movie.setActor(sc.next());
        System.out.println("请输入价格：");
        movie.setPrice(sc.nextDouble());
        movies.add(movie);
        System.out.println("添加成功");
        showMovie();
    }
}

