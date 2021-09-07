package com.zl.easybuy;/**
 * @author suke
 * @create 2021-09-07 10:52
 */

/**
 * TODO
 * @ClassName: Test1
 * @author: suke
 * @since: 2021/9/7 10:52
 */
public class Test1 {
    public static void main(String[] args) {
        int i1 = 733;  // Integer 对象  -128~127    从缓存获取    超过 -128~127  new 创建对象   new Integer(733);
        int i2 = 733;  //Integer 对象  new 创建对象   new Integer(733);
        System.out.println(i1 == i2);  // 比较是否是同一个对象
    }
}
