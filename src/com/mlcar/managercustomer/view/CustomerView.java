package com.mlcar.managercustomer.view;

import com.mlcar.managercustomer.bean.Customer;
import com.mlcar.managercustomer.service.CustomerList;
import utils.CMUtility;

import javax.crypto.CipherOutputStream;
import java.awt.*;
import java.util.Scanner;

/**
 * @Description 视图层, 显示数据
 * @auther Admin
 * @date 2020/5/23 9:08
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("lili", '女', 12, "197979", "131231@qq.com");
        customerList.addCustomer(customer);
    }
    /**
     * @Description 显示用户界面
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while(isFlag) {
            System.out.println("\n-------------------客户操作管理系统-------------------");
            System.out.println("                     1 添加客户");
            System.out.println("                     2 修改客户");
            System.out.println("                     3 删除客户");
            System.out.println("                     4 客户列表");
            System.out.println("                     5 退出");
            System.out.print("          请选择(1-5):");
            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N)");
                    char iscomfirm = CMUtility.readConfirmSelection();
                    if(iscomfirm == 'Y'){
                        System.out.println("退出");
                        isFlag = false;
                    }

            }
        }
    }

    /**
     * @Description 添加客户的操作
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void addNewCustomer() {
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char gender = CMUtility.readChar();
        System.out.print("年龄:");
        int age= CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱:");
        String email =CMUtility.readString(20);
        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("\n-------------------添加成功!-------------------");
        }else{
            System.out.println("\n-------------------客户目录已满,添加失败!-------------------");
        }
    }
    /**
     * @Description 修改客户的操作
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void modifyCustomer() {
        System.out.println("-------------------修改客户-------------------");
        Customer cust;
        int number;
        for (;;){
            System.out.println("请输入修改信息编号:(-1退出)");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }
            cust = customerList.getCustomer(number -1);
            if(cust == null){
                System.out.println("没有该条记录!");
            }else{
                break;
            }
        }
        System.out.print("姓名("+ cust.getName()+"):");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("性别("+ cust.getGender() +"):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄("+ cust.getAge() +"):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话("+ cust.getPhone() +"):");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("邮箱("+ cust.getEmail() +"):");
        String email = CMUtility.readString(20, cust.getEmail());
        Customer newCust = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number-1, newCust);
        if(isReplaced == true){
            System.out.println("-------------------修改完成!-------------------");
        }else{
            System.out.println("-------------------修改失败!-------------------");
        }

    }
    private void deleteCustomer() {
        System.out.println("-------------------删除客户-------------------");
        System.out.println("请输入修改信息编号:(-1退出)");
        int number = CMUtility.readInt();
        if(number ==-1){
            return;
        }
        Customer cust = customerList.getCustomer(number-1);
        if(cust ==null){
            System.out.println("没有该条记录!");
        }else{
            System.out.println("是否确认删除(Y/N)");
            char isYes = CMUtility.readChar();
            if(isYes == 'Y'){
                boolean isDeleted = customerList.deleteCustomer(number-1);
                if(isDeleted ==true){
                    System.out.println("-------------------删除客户成功!-------------------");
                }else{
                    System.out.println("-------------------删除客户失败!-------------------");
                }
            }else {
                return;
            }


        }

    }
    /**
     * @Description 展示客户信息列表
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void listAllCustomer() {
        System.out.println("-------------------客户列表-------------------");

        if(customerList.getTotal() == 0){
            System.out.println("没有记录!");
        }else {
            System.out.println("编号\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println(i+1 + "\t" + cust.getName() + "\t" + cust.getGender() + "\t\t" + cust.getAge() + "\t\t" + cust.getPhone() + "\t" + cust.getEmail());

            }
        }

        System.out.println("-------------------客户列表完成-------------------");
    }

    public static void main(String[] args) {
        CustomerView view  = new CustomerView();
        view.enterMainMenu();

    }

}
