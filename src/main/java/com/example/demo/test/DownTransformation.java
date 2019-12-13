package com.example.demo.test;

import com.example.demo.po.Person;

/**
 * @Description:
 * @Author: ZYC
 * @Date: 2019-12-13
 **/
public class DownTransformation {

    private void test(){
        /*
        正常引用对象
         */
        Object noramlObject = new Object();
        Person normalPerson = new Person();
        /*
        向上转型
         */
        Object monkey = new Person();
        //Person转型为object,只能调用object方法
        monkey.toString();
        //如果要调用自己的方法,需要向下转型
        ((Person) monkey).getAge();
        /*
        向下转型
        前提是Person是Object子类
        如果不是会抛出异常
         */
        Person person = (Person)noramlObject;
        person.getAge();
        if (person instanceof Object){
            System.out.println("person 是 Object 的子类");
        }
    }
}
