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
     * 初始化 ArrayList 该方法显示ArrayList的独有方法
     * @return
     */
    private ArrayList arrayListTest(){
        /**
         * 1.可以初始化容量大小,ArrayList的默认容量是10
         * 2.新的容量=“(原始容量x3)/2 + 1
         * 3.ArrayList 不是线程安全的
         */
        ArrayList<String> arrayList = new ArrayList<>(11);
        //复制
        Object object = arrayList.clone();
        System.out.println(object);
        //删除多余空间
        return arrayList;
    }


    /**
     * 该方法显示List的方法
     * @return
     */
    private List listTest(){
        /**
         1.一般用List list = new ArrayList() ,而不用 ArrayList list = new ArrayList()
         使用向上转型,以后需要更改就不用改太多
         **/
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        //添加元素,自动在下一位置添加,boolean
        boolean addResult = list.add("1");
        listTemp.add(null);
        //在指定位置添加,void
        list.add(0, "2");
        //添加集合,boolean
        boolean addAllResult = list.addAll(listTemp);
        //在指定位置添加集合,boolean
        boolean addAllResult2 = list.addAll(3, listTemp);
        //正向查找,可以查找null
        int forward = list.indexOf("1");
        System.out.println(forward);
        //反向查找,可以查找null
        int backward = list.lastIndexOf("1");
        System.out.println(backward);
        //根据索引获取元素
        String getResult = list.get(120);
        System.out.println(getResult);
        //返回大小
        int size = list.size();
        //是否为空
        boolean isEmpty = listTemp.isEmpty();
        System.out.println(isEmpty);
        //清空,void
        list.clear();
        //是否包含
        boolean containsResult = list.contains("new");
        boolean containsAll = list.containsAll(listTemp);
        System.out.println(containsAll);
        //删除集合
        boolean removeAll = list.removeAll(listTemp);
        System.out.println(removeAll);
        //删除选定内容
        boolean removeResult = list.remove("23");
        //删除指定位置,返回对象
        String removeIndexReslut = list.remove(0);
        System.out.println(removeIndexReslut);
        //设定对象
        String setResult = list.set(0, "newString");
        System.out.println(setResult);
        return list;
    }



    public static void main(String[] args) {






    }
}
