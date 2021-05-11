import list.MyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testAdd();
        testAddWithIndex();
        testGet();
        testIndexOf();
        testRemove();
        testSet();
        TestCollections.listTest();
        TestCollections.setTest();
        TestCollections.mapTest();
    }

    public static void testAdd(){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                list.add(j);
            }
            end = System.nanoTime();
            time1 += (end - start);
            list.clear();

            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                myList.add(j);
            }
            end = System.nanoTime();
            myList.clear();
            time2 += (end - start);
        }
        System.out.println("Среднее время add(мой список): " + time2/100);
        System.out.println("Среднее время add: " + time1/100);
    }
    public static void testAddWithIndex(){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();

        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                list.add(j, j);
            }
            end = System.nanoTime();
            time1 += (end - start);
            list.clear();

            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                myList.add(j, j);
            }
            end = System.nanoTime();
            myList.clear();
            time2 += (end - start);
        }
        System.out.println("Среднее время add with index(мой список): " + time2/100);
        System.out.println("Среднее время add with index: " + time1/100);
    }
    public  static void testGet() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;
        for(int j = 0; j < 10000; j++){
            list.add(j);
            myList.add(j);
        }

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                list.get(j);
            }
            end = System.nanoTime();
            time1 += (end - start);

            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                myList.get(j);
            }
            end = System.nanoTime();
            time2 += (end - start);
        }
        System.out.println("Среднее время get(мой список): " + time2/100);
        System.out.println("Среднее время get: " + time1/100);
    }
    public  static void testIndexOf() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;
        for(int j = 0; j < 10000; j++){
            list.add(j);
            myList.add(j);
        }

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                list.indexOf(j);
            }
            end = System.nanoTime();
            time1 += (end - start);

            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                myList.indexOf(j);
            }
            end = System.nanoTime();
            time2 += (end - start);
        }
        System.out.println("Среднее время indexOf(мой список): " + time2/100);
        System.out.println("Среднее время indexOf: " + time1/100);
    }
    public  static void testRemove() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;
        for(int j = 0; j < 10000; j++){
            list.add(j);
            myList.add(j);
        }

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = list.size() - 1; j > 0; j--){
                list.remove(j);
            }
            end = System.nanoTime();
            time1 += (end - start);

            start = System.nanoTime();
            for(int j = myList.size() - 1; j > 0; j--){
                myList.remove(j);
            }
            end = System.nanoTime();
            time2 += (end - start);
        }
        System.out.println("Среднее время remove(мой список): " + time2/100);
        System.out.println("Среднее время remove: " + time1/100);
    }
    public  static void testSet() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int j = 0; j < 10000; j++){
            list.add(j);
            myList.add(j);
        }
        long start = 0;
        long end = 0;
        long time1 = 0;
        long time2 = 0;

        for(int i = 0; i < 100; i++){
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                list.set(j, j);
            }
            end = System.nanoTime();
            time1 += (end - start);
            start = System.nanoTime();
            for(int j = 0; j < 10000; j++){
                myList.set(j, j);
            }
            end = System.nanoTime();
            time2 += (end - start);
        }
        System.out.println("Среднее время set(мой список): " + time2/100);
        System.out.println("Среднее время set: " + (time1/100));
    }
}
