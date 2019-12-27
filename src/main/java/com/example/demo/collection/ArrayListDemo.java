package com.example.demo.collection;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayListDemo {
    /**
     * init.
     * ArrayList can set initialCapacity ,default is 10 ,new capacity = (old*3)/2+1.
     * ArrayList not thread-safe.
     * @return
     */
    private ArrayList initList(){
        ArrayList<String> arrayList = new ArrayList<>();
        //0
//        System.out.println("default ArrayList size :"+arrayList.size());
        //can define initCapacity
        ArrayList arrayList1 = new ArrayList(11);
        //0,size is not capacity
//        System.out.println("list.size():"+arrayList1.size());
        //add element
        for(int i =0;i<5000000;i++){
            arrayList.add(i+"");
        }
        //clone
        Object object = arrayList.clone();
//        System.out.println(object);
        return arrayList;
    }

    /**
     * clone return object.
     * this object can change to List.
     * [] can be clone.
     * 'null' element can be clone
     */
    public void arrayClone(){
        ArrayList arrayList = new ArrayList();
        Object object = arrayList.clone();
        arrayList.add("1");
        Object object1 = arrayList.clone();
        //[] can clone
        System.out.println("[] clone result :"+object);
        //["1"] can clone
        System.out.println("[1] clone result :"+object1);
        try {
            //if object can change to list (success)
            ArrayList arrayList1 = (ArrayList) object1;
            System.out.println("change success:"+arrayList1);
        }catch (Exception e){
            System.out.println("change fail");
        }
    }

    /**
     * add return boolean.
     * add(i,n) return void.
     * add can add 'null' ,return true and can exist in like [0,null,1].
     * add(null) will change the size.
     * add(i,n) will not replace the element.will add n to  i,the original i will to i-1
     * add(i,n),i can not beyond list size
     */
    public void add(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        //[1]
        boolean addResult = list.add("1");
        //true
        System.out.println("add result:"+addResult);
        //add null
        //0
        System.out.println("listTemp size:"+listTemp.size());
        boolean addNullResult = listTemp.add(null);
        //true
        System.out.println("add(null):"+addNullResult);
        //[null] size is 1
        System.out.println("[null]:"+listTemp.size());
        printList(listTemp);
        list.add(0, "0");
        printList(list);
        //cant add element beyond list size
        try {
            list.add(100, "100");
        }catch (Exception e){
            System.out.println("fail");
        }
        //[0,null,4,5,3]
        list.add(1, "3");
        list.add(1, "4");
        list.add(1, null);
        list.add(3, "5");
        printList(list);
    }

    /**
     *addAll return boolean
     *addAll cant addAll(null)
     *addAll can addAll([1,null,2])
     *[1,2,3] addAll([2,3,4]) return ture [1,2,3,4]
     */
    public void addAll(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();

        listTemp.add(0, "0");
        listTemp.add(1, null);
        listTemp.add(2, "2");
        printList(listTemp);
        //if can addAll(null)
        try {
            listTemp.addAll(null);
            System.out.println("addAll(null)success");
        }catch (Exception e){
            System.out.println("fail!");
        }
        //if can addAll([0,null,2])
        list.addAll(listTemp);
        //true
        System.out.println("addAll([0,null,2])"+ list.addAll(listTemp));
        printList(list);
        //[1,null,2].addAll([0,1,2,2]) [1,null,0,1,2,2,2]
        listTemp.add(1, "1");
        listTemp.add(2, "2");
        printList(listTemp);
        list.addAll(2, listTemp);
        printList(list);
    }

    /**
     *return int
     *can find null
     *if not exist return -1
     */
    private void indexOf(){
        List<String> list = new ArrayList();
        list.add("0");
        list.add(null);
        list.add("2" );
        printList(list);
        System.out.println("indexOf(0):"+list.indexOf("0"));
        System.out.println("indexOf(3):"+list.indexOf("3"));
        System.out.println("indexOf(null):"+list.indexOf(null));
        System.out.println("lastIndexOf(0):"+list.lastIndexOf("0"));
        System.out.println("lastIndexOf(3):"+list.lastIndexOf("3"));
        System.out.println("lastIndexOf(null):"+list.lastIndexOf(null));
    }

    /**
     *return E
     *cant get beyond list size
     */
    private void get(){
        List<String> list = new ArrayList();
        list.add("0");
        list.add("3");
        System.out.println("get(1):"+list.get(1));
        try {
            String getResult = list.get(120);
        }catch (Exception e){
            System.out.println("fail");
        }
    }

    /**
     * remove(i) return E
     * cant remove beyond size
     *
     * remove(obj) return boolean
     * can remove not exist obj ,[1,2].remove(3),return false
     *
     * removeAll return boolean
     * can remove not exist list, [1,2].remove([3,4]),return false
     * can remove longer list ,[1,2] remove [2,3,4],return true [1]
     **/
    private void remove(){
       
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        list.add("0");
        list.add("3");
        System.out.println("remove(0):"+list.remove(0));
        try {
            System.out.println("if can remove beyond list size:"+list.remove(120));
        }catch (Exception e){
            System.out.println("fail");
        }
        System.out.println("remove('3'):"+list.remove("3"));
        try {
            System.out.println("if can remove not exist obj:"+list.remove("5"));
        }catch (Exception  e){
            System.out.println("fail");
        }
        list.clear();
        listTemp.clear();
        list.add(0, "0");
        list.add(1, "1");
        list.add(2, "2");
        listTemp.add(0, "0");
        listTemp.add(1, "1");
        System.out.println("normal removeAll:"+list.removeAll(listTemp));
        //exist other Elements
        list.clear() ;
        listTemp.clear();
        list.add( "0");
        list.add( "1");
        list.add( "2");
        listTemp.add( "4");
        try {
            System.out.println("[0,1,2].removeAll([4]):"+list.removeAll(listTemp));
        }catch (Exception e){
            System.out.println("fail");
        }
        //remove longer list
        list.clear();
        listTemp.clear();
        list.add(0, "0");
        list.add("2");
        listTemp.add(0, "0");
        listTemp.add(1, "1");
        try {
            printList(list);
            System.out.println("[0,2].removeAll([0,1]):"+list.removeAll(listTemp));
            printList(list);
        }catch (Exception e){
            System.out.println("fail");
        }
    }
    /**
     * set return E
     * cant beyond list size
     */
    private void set(){
        List<String> list = new ArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        printList(list);
        System.out.println("set(2):"+list.set(2, "2.1"));
        System.out.println("set(3):"+list.set(3, "3"));
        printList(list);
    }

    /**
      contain return boolean
      [0,1,2] contain null return false
      [0,null,2] contain null return true
      containAll return boolean
      [0,1,2] containAll [0,1] return true
      [0,1,2] containAll [0,1,3] return false
      [0,1,2] containAll [0,1,3,3] return false
      [0,1,2] containAll [0,null,2] return false
      [0,1,2] containAll [0,1,2] return true
     */
    private void contain(){
        List<String> list = new ArrayList();
        List<String> listTemp = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        //false
        System.out.println("[0,1,2].contain([3]):"+list.contains("3"));
        //false
        System.out.println("[0,1,2].contain(null):"+list.contains(null));
        listTemp.add("0");
        listTemp.add("1");
        System.out.println("[0,1,2].containAll([0,1]):"+list.containsAll(listTemp));
        listTemp.add("3");
        System.out.println("[0,1,2].containAll([0,1,3]):"+list.containsAll(listTemp));
        listTemp.add("3");
        System.out.println("[0,1,2].containAll([0,1,3,3]):"+list.containsAll(listTemp));
        listTemp.clear();
        listTemp.add(0, "0");
        listTemp.add(1, null);
        listTemp.add(2, "2");
        System.out.println("[0,1,2].containAll([0,null,2]):"+list.containsAll(listTemp));
        System.out.println("[o,1,2].containAll([0,1,2]):"+list.containsAll(list));
    }

    /**
      clear return void
      [0,1,2] clear return []
      [] is not null
     **/
    private void clear(){
        List<String> list = new ArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        System.out.println("list.size():"+list.size());
        printList(list);
        list.clear();
        System.out.println("list.size():"+list.size());
        System.out.println(list);
        if(list == null){
            System.out.println("[] is null");
        }else{
            System.out.println("[] is not null");
        }
        list.add(null);
        if(list == null){
            System.out.println("[null] is null");
        }else{
            System.out.println("[null] is not null");
        }
    }

    /**
     isEmpty return boolean
     **/
    private void isEmpty(){
        List<String> list = new ArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        System.out.println("isEmpty:"+list.isEmpty());

        list.clear();
        System.out.println("after list.clear isEmpty:"+list.isEmpty());

        list.add("0");
        list.add("1");
        list.add("2");
        try {
            list = null;
            System.out.println("list = null success");
        }catch (Exception e){
            System.out.println("list = null fail");
        }
        //list has been null
        System.out.println(list.isEmpty());
    }

    /**
     * test traverse method
     * for method is quickest
     * iterator cost more time
     * iteratorList cost most time
     */
    public void traverseTest(){
        Long startTime = System.currentTimeMillis();
        ArrayList<String> arrayList = initList();
        Long endTime = System.currentTimeMillis();
        String value ="";
        System.out.println("add result:"+(endTime-startTime));

        //for
        startTime = System.currentTimeMillis();
        for(int i = 0 ;i<arrayList.size();i++){
            value =  arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("for result:"+(endTime - startTime));

        //for each
        startTime = System.currentTimeMillis();
        for(String s :arrayList){
            value = s;
        }
         endTime = System.currentTimeMillis();
        System.out.println("for each result:"+(endTime-startTime));

        //iterator
        startTime = System.currentTimeMillis();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            value = (String) iterator.next();
        }
         endTime = System.currentTimeMillis();
        System.out.println("iterator result:"+(endTime-startTime));

        //listLiterator
        ListIterator<String> iteratorList = arrayList.listIterator();
        while (iteratorList.hasNext()){
            value = iteratorList.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("iteratorList result:"+(endTime-startTime));
    }

    /** print list **/
    private void printList(List list){
        System.out.println("-----start------");
        for (int i = 0 ;i<list.size();i++){
            System.out.println(i+"Element:"+list.get(i));
        }
        System.out.println("----------------");
    }
}
