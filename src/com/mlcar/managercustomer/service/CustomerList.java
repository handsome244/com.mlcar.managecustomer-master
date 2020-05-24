package com.mlcar.managercustomer.service;

import com.mlcar.managercustomer.bean.Customer;

/**
 * @Description control层,处理业务逻辑
 * @auther Admin
 * @date 2020/5/23 9:07
 */
public class CustomerList {
    private Customer[] customers; //用来保存客户对象的数组
    private int total = 0;//记录已保存客户对象的数量

    /**
     * 初始化Customer 构造器
     * @param totalCustomer , 制定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    /**
     * @Description 将新增客户添加到数组中
     * ` * @param customer`
     * @return 成功返回true, 失败返回false
     * @throws
     * @auther Admin
     * @date 2020/5/23
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }
    /**
     * @Description 修改制定位置上的用户信息
     *  * @param index
     * @param cust
     * @return 成功返回true, 失败返回false
     * @throws
     * @auther Admin
     * @date 2020/5/23 10:08
     */
    public boolean replaceCustomer(int index ,Customer cust){
        if(index < 0 || index >=total){
            return false;
        }
        customers[index] = cust;
        return true;
    }
    /**
     * @Description 删除指定位置的客户信息
     *  * @param index
     * @return 成功true, 失败false
     * @throws
     * @auther Admin
     * @date 2020/5/23 10:33
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >=total){
            return false;
        }
        for (int i = 0; i < total-1; i++) {
            customers[i] = customers[i +1];

        }
        customers[--total] = null;
        return  true ;
    }
    /**
     * @Description 获取客户数据的数组
     *  * @param
     * @return custs
     * @throws
     * @auther Admin
     * @date 2020/5/23 10:33
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];

        }
        return custs;
    }
    /**
     * @Description 获取制定位置的客户的信息
     *  * @param index
     * @return 找到元素返回元素信息, 没有找到则返回null
     * @throws
     * @auther Admin
     * @date 2020/5/23 10:34
     */
    public Customer getCustomer(int index) {
        if(index < 0 || index >= total){
            return null;
        }

        return customers[index];
    }

    /**
     * @Description 存储客户的数量
     *  * @param
     * @return total
     * @throws
     * @auther Admin
     * @date 2020/5/23 10:36
     */
    public int getTotal() {
        return total;
    }
}
