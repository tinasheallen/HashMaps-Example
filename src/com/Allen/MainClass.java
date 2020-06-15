package com.Allen;

import java.util.*;
import java.util.Random;

public class MainClass {


    /**
     * Metoda ce genereaza cu sir de caractere aleator
     * @return intoarce sirul aleator construit
     */
    private static String getRandString()
    {
        int a;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++)
        {
            a=r.nextInt(20);
            char c = (char)(a + 'a');
            sb.append(c);
        }
        return sb.toString();

    }

    /**
     * Metoda ce genereaza aleator un numar intreg
     * @return intoarce intregul generat aleator
     */
    private static Integer getRandInt() {
        Random r = new Random();

        return new Integer( r.nextInt() +1);

    }

    /**
     * Metoda in care se va analiza durata accesarii in tabela de dispersie
     * @param args
     */
    public static void main(String[] args) {

        Student student;
        LazyStudent lazy;
        String nume;
        int varsta;
        List<Student> list=new ArrayList<Student>();
        List<Student> list2=new ArrayList<Student>();
        List<LazyStudent> list3=new ArrayList<LazyStudent>();
        List<LazyStudent> list4=new ArrayList<LazyStudent>();
        for(int i=0;i<2000;i++)
        {
            nume=MainClass.getRandString();
            //System.out.println(nume);
            varsta=Math.abs(MainClass.getRandInt()%30);
            //System.out.println(varsta);
            student=new Student(nume,varsta);
            lazy=new LazyStudent(nume,varsta);
            list.add(student);
            list3.add(lazy);
        }
        list2.addAll(list);

        //student
        MyHashMap<Student,Integer> map=new MyHashMapImpl<Student,Integer>(10);
        Iterator<Student> it=list.iterator();
        while(it.hasNext())
        {
            student=it.next();
            map.put(student, MainClass.getRandInt()%10+1);
        }
        long time1=System.currentTimeMillis();

        for(int i=0;i<1000;i++)
        {
            student=list2.get(Math.abs(MainClass.getRandInt()%2000));
            map.get(student);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);

        //lazyStudent
        list4.addAll(list3);
        MyHashMap<LazyStudent,Integer> map2=new MyHashMapImpl<LazyStudent,Integer>(10);
        Iterator<LazyStudent> it2=list3.iterator();
        while(it2.hasNext())
        {
            lazy=it2.next();
            map2.put(lazy, MainClass.getRandInt()%10+1);
        }
        long time3=System.currentTimeMillis();

        for(int i=0;i<1000;i++)
        {
            lazy=list4.get(Math.abs(MainClass.getRandInt()%2000));
            map2.get(lazy);
        }
        long time4=System.currentTimeMillis();
        System.out.println(time4-time3);
    }

}
