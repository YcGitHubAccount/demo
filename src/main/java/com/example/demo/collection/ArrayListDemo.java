package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ZYC
 * @Date: 2019-12-13
 **/
public class ArrayListDemo {

    /**
     * 一般用List list = new ArrayList() ,而不用 ArrayList list = new ArrayList(),使用向上转型,以后需要更改就不用改太多
     *
     * 1.可以初始化容量大小,ArrayList的默认容量是10
     * 2.新的容量 = (原始容量x3)/2 + 1
     * 3.ArrayList 不是线程安全的
     * 4.初始化容量不是size
     */
    private ArrayList createList(){
        ArrayList<String> arrayList = new ArrayList<>();
        //size是0
        System.out.println("默认的ArrayList容量:"+arrayList.size());
        //可以自定义容量
        ArrayList arrayList1 = new ArrayList(11);
        System.out.println("ArrayList1容量:"+arrayList1.size());
        arrayList.add("1");
        arrayList.add(null);
        arrayList.add("3");
        //复制
        Object object = arrayList.clone();
        //[1, null, 3]
        System.out.println(object);
        return arrayList;
    }

    /**
     * 1.clone 返回 object,object可以转型为List
     * 2.没有元素也可以clone
     *
     * **/
    private void arrayClone(){
        ArrayList arrayList = new ArrayList();
        //复制,返回Object
        Object object = arrayList.clone();
        arrayList.add("1");
        Object object1 = arrayList.clone();
        //[]
        System.out.println("没有元素clone后的结果:"+object);
        //["1"]
        System.out.println("添加一个元素clone后的结果"+object1);
        //转型成功
        try {
            ArrayList arrayList1 = (ArrayList) object1;
            System.out.println("转型成功:"+arrayList1);
        }catch (Exception e){
            System.out.println("转型失败!");
        }
    }

    /**
     * 1.list可以添加null
     * 2.add直接添加null,list的size不变
     * 3.可以在list的中间添加null,[0,null,4,5,3]
     * 4.add不会替换元素,在元素前面添加
     * 4.add的index不能超过size
     * **/
    private void add(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();

        /**
         *  add:
         *  添加元素,自动在下一位置添加,boolean
         *
         *  **/
        boolean addResult = list.add("1");
        //true
        System.out.println("add的结果是返回boolean:"+addResult);
        //添加null
        //0
        System.out.println("添加null之前,listTemp的Size:"+listTemp.size());
        boolean addNullResult = listTemp.add(null);
        //true
        System.out.println("add添加null返回:"+addNullResult);
        //1 null会占据一个位置
        System.out.println("添加null之后,listTemp的Size:"+listTemp.size());

        /** 在指定位置添加,void **/
        list.add(0, "0");
        printList(list);
        //超容量异常,不能在容量之外增加值
        try {
            list.add(100, "100");
        }catch (Exception e){
            System.out.println("不能在容量之外增加值");
        }
        //中间是否可以存在null,可以存在null,add的index不能超过size
        list.add(3, "3");
        //不是替换,在中间插入元素,原来在1位置的移到了后面
        list.add(1, "3");
        list.add(1, "4");
        list.add(1, null);
        list.add(3, "5");
        //[0,null,4,5,3]
        printList(list);
    }



    /**
          1.addAll不能添加null,会抛出空指针异常
          2.添加的集合不会抵消已有的元素,会插入其中
     */
    private void addAll(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();

        listTemp.add(0, "0");
        listTemp.add(1, null);
        listTemp.add(2, "2");
        printList(listTemp);
        /**  addAll 添加集合 boolean**/
        //是否可以添加null,不能,空指针异常,注意addAll时要判断是否为null
        boolean addAllResult = listTemp.addAll(null);
        System.out.println("addAll添加null的结果:"+addAllResult);
        //添加的集合时候是否可以存在空格
        list.addAll(listTemp);
        //true
        System.out.println("添加的集合时候是否可以存在空格"+ list.addAll(listTemp));
        printList(list);
        //是否会清除已有的元素,不会
        listTemp.add(1, "1");
        listTemp.add(2, "2");
        printList(listTemp);
        list.addAll(2, listTemp);
        printList(list);
    }

    private void indexOf(){
        List<String> list = new ArrayList();
        list.add(0, "0");
        list.add(3, "3");
        printList(list);
        /**正向查找与反向查找 int **/
        System.out.println("正向查找元素0:"+list.indexOf("0"));
        System.out.println("正向查找元素3:"+list.indexOf("3"));
        System.out.println("正向查找元素null:"+list.indexOf(null));
        System.out.println("正向反找元素0:"+list.lastIndexOf("0"));
        System.out.println("正向反找元素3:"+list.lastIndexOf("3"));
        System.out.println("正向反找元素null:"+list.lastIndexOf(null));
    }


    private void get(){
        /** 获取指定位置的元素 返回 E**/
        List<String> list = new ArrayList();
        list.add(0, "0");
        list.add(3, "3");
        System.out.println("获取位置为3的元素:"+list.get(3));
        //是否能获取超过容量的元素
        try {
            String getResult = list.get(120);
        }catch (Exception e){
            System.out.println("不能获取超过容量的元素");
        }
    }

    private void remove(){
        /**remove 删除 E**/
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        list.add(0, "0");
        list.add(3, "3");
        //删除指定位置
        System.out.println("删除元素位置0:"+list.remove(0));
        //是否能删除超过集合容量
        try {
            System.out.println("是否能删除超过集合容量:"+list.remove(120));
        }catch (Exception e){
            System.out.println("不能删除超过集合容量");
        }

        /**remove Object **/
        System.out.println("删除元素'3':"+list.remove("3"));
        try {
            System.out.println("删除不存在的元素:"+list.remove("5"));
        }catch (Exception  e){
            System.out.println("不能删除不存在的数据");
        }
        /** 删除集合removeAll boolean**/
        //1.正常移除
        list.clear();
        listTemp.clear();
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        listTemp.add(0, "0");
        listTemp.add(1, "1");
        System.out.println("list删除集合removeAll的结果:"+list.removeAll(listTemp));
        //2.存在其他元素
        list.clear() ;
        listTemp.clear();
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        listTemp.add(2, "4");
        try {
            System.out.println("removeAll中listTemp中存在list不存在的元素:"+list.removeAll(listTemp));
            list.removeAll(listTemp);
        }catch (Exception e){
            System.out.println("不能移除不存在的元素");
        }
        //长度不一致
        list.clear();
        listTemp.clear();
        list.add(0, "0");
        listTemp.add(0, "0");
        listTemp.add(1, "1");
        try {
            System.out.println("removeAll中listTemp的容量大于list的容量:"+list.removeAll(listTemp));
        }catch (Exception e){
            System.out.println("不能移除容量更大的集合");
        }
    }

    private void set(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        /** set  E**/
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        printList(list);
        System.out.println("设置位置2的元素为:"+list.set(2, "2.1"));
        System.out.println("设置位置3的元素为:"+list.set(3, "3"));
        printList(list);
    }

    private void contain(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        /** contain  boolean**/
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        System.out.println("list包含3:"+list.contains("3"));
        System.out.println("list包含null:"+list.contains(null));
        /** containAll**/
        listTemp.add(0, "0");
        listTemp.add(1, "1");
        System.out.println("list包含listTemp:"+list.containsAll(listTemp));
        listTemp.add(2, "3");
        System.out.println("list包含listTemp,元素不一致:"+list.containsAll(listTemp));
        listTemp.add(3, "3");
        System.out.println("list包含listTemp,listTemp长度更长:"+list.containsAll(listTemp));
        listTemp.clear();
        listTemp.add(0, "0");
        listTemp.add(1, null);
        listTemp.add(2, "2");
        System.out.println("list包含listTemp,listTemp有null:"+list.containsAll(listTemp));
        System.out.println("包含自己:"+list.containsAll(list));
    }

    private void clear(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        /** clear  void**/
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        System.out.println("list的Size"+list.size());
        printList(list);
        list.clear();
        System.out.println("list的Size"+list.size());
        if(list == null){
            System.out.println("list是null");
        }else{
            System.out.println("list不是null");
        }
        printList(list);
    }

    private void isEmpty(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        /** isEmpty  boolean**/
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        System.out.println("是否为空:"+list.isEmpty());

        list.clear();
        System.out.println("clear后是否为空:"+list.isEmpty());

        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        list = null;
        System.out.println("赋值为null后是否为空:"+list.isEmpty());
    }




    public static void main(String[] args) {
        ArrayListDemo arrayListDemo  = new ArrayListDemo();
        arrayListDemo.addAll();
    }



    /** 遍历输出list **/
    private void printList(List list){
        System.out.println("-----开始打印------");
        for (int i = 0 ;i<list.size();i++){
            System.out.println("第"+i+"个元素是:"+list.get(i));
        }
        System.out.println("-----打印结束-------");
    }
}
