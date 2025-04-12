package com.cy.class03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 */
public class Code05_HashMapTreeMap {

    public static class Node {
        private int value;

        public Node(int v) {
            this.value = v;
        }
    }

    /**
     * HashMap (K, V)表
     * hash表巨强的一点是，不管他存了多少条记录，他增删改查都是常数时间，o(1)
     * 但是，虽然是常数时间，它跟数据量无关，但是它是一个比较大的常数时间，远远比数组寻址啊，加减等常数时间要大的多。
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zuochengyun", "我是左程云");
        System.out.println(map.containsKey("zuochengyun"));
        System.out.println(map.containsKey("zuo"));
        System.out.println(map.get("zuochengyun"));

        map.put("zuochengyun", "他是左程云");
        System.out.println(map.get("zuochengyun"));

//        map.remove("zuochengyun");
//        System.out.println(map.get("zuochengyun"));

        /**
         * String 按值传递，它不会去认test1的内存地址，只要你查的内容我有，就返回true。
         */
        String test1 = "zuochengyun";
        String test2 = "zuochengyun";
        System.out.println(map.containsKey(test1));
        System.out.println(map.containsKey(test2));

        /**
         * 在java中Integer的a和b的内存地址其实是不一样的，
         * 但是hash表内部不管你什么内存地址，只要你们值查的是一个东西，我就告诉你存在。
         *
         * Integer Double Float String Char
         * 这些在hash表里都是按值传递
         *
         * 跟它有区别的就是非原生类型。
         */
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1234567, "我是1234567");
        Integer a = 1234567;
        Integer b = 1234567;
        System.out.println(a == b);
        System.out.println(map2.containsKey(a));
        System.out.println(map2.containsKey(b));

        /**
         * 非基础类型，非原生类型，hash表内部按引用传递，你当初内存地址作为key的玩意，有没有加进来？
         * 我不关心你内部的值，就问你内存地址。
         *
         * HashMap存key的时候消耗的内存空间:
         * 1.如果是值类型的，比如String，那就会占用具体的String占用的字节数。
         * 2.如果是引用类型，比如Node，那只会占用存内存地址的空间，8字节。具体Node内部值比如是String占用了多大那是Node自己开辟的内存区域大小的事情。
         * 在hashMap里就是存一个内存地址而已，消耗8字节。
         */
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map3 = new HashMap<>();
        map3.put(node1, "我进来了!");
        System.out.println(map3.containsKey(node1));
        System.out.println(map3.containsKey(node2));

        System.out.println("-------------------------------------------");

        /**
         * TreeMap，有序表
         * treeMap里面它也是根据String Inerger Double...等按值传递或者非基础类型按引用传递的。
         *
         * TreeMap比HashMap强大的地方是，treeMap内部会按照key排好序。
         * 既然TreeMap比HashMap强，为什么HashMap还存在？因为TreeMap你可以认为下面所有的这些方法时间复杂度都是logN级别，它没有像HashMap的那么强o(1)
         * 但是TreeMap也很强，能够做到每一次加、每一次查、每一次删、每一次floorKey、ceilingKey，时间复杂度全是logN级别的。
         */
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        treeMap1.put(3, "我是3");
        treeMap1.put(0, "我是3");
        treeMap1.put(7, "我是3");
        treeMap1.put(2, "我是3");
        treeMap1.put(5, "我是3");
        treeMap1.put(9, "我是3");

        System.out.println(treeMap1.containsKey(7));
        System.out.println(treeMap1.containsKey(6));
        System.out.println(treeMap1.get(3));

        treeMap1.put(3, "他是3");
        System.out.println(treeMap1.get(3));

//        treeMap1.remove(3);
//        System.out.println(treeMap1.get(3));

        //可见，treeMap一put进数据的时候，就是排好序的
        for(Map.Entry<Integer, String> entry: treeMap1.entrySet()) {
            System.out.println("键：" + entry.getKey() + " 值：" + entry.getValue());
        }

        System.out.println(treeMap1.firstKey());        //0
        System.out.println(treeMap1.lastKey());         //9
        // <=5 离5最近的key告诉我
        System.out.println(treeMap1.floorKey(5));       //5
        // <=6 离6最近的key告诉我
        System.out.println(treeMap1.floorKey(6));       //5
        // >=5 离5最近的key告诉我
        System.out.println(treeMap1.ceilingKey(5));     //5
        // >=6 离6最近的key告诉我
        System.out.println(treeMap1.ceilingKey(6));     //7

        /**
         * 如果是非基础类型，比如Node，有序表TreeMap还能不能用？不能直接用了。
         * 下面treeMap2的put node3会报错:
         * Exception in thread "main" java.lang.ClassCastException: com.cy.class03.Code05_HashMapTreeMap$Node cannot be cast to java.lang.Comparable
         * 因为我们要求key一定要是可以比较的，如果你不告诉它怎么比较，它就死给你看~
         * 那你怎么样用key为自己定义的class呢？你就需要在TreeMap的new的构造参数里面把怎么比较传进去。TreeMap(Comparator<? super K> comparator)
         * 如果你想用treeMap，那么它的key一定是可以比较的
         */
        Node node3 = new Node(3);
		Node node4 = new Node(4);
		TreeMap<Node, String> treeMap2 = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
		treeMap2.put(node3, "我是node3");
		treeMap2.put(node4, "我是node4");
    }
}
