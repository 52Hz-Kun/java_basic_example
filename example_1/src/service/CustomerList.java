package service;

import bean.Customer;

public class CustomerList {
    private Customer[] customers; // 保存对象的数组
    private int total = 0; // 记录已经保存客户对象的个数

    /**
     * 用来初始化customer数组的构造器
     * @param totalCustomer：指定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的客户添加到数组中
     * @param customer：客户对象
     * @return true：成功；false：失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * 修改数组中指定索引的对象
     * @param index：索引的值
     * @param cust：新的对象
     * @return true：替换成功；false：替换失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index >= 0 && index <= total - 1){
            customers[index] = cust;
            return true;
        }
        return false;
    }

    /**
     * 删除指定索引位置上的客户
     * @param index
     * @return true:成功；false;失败
     */
    public boolean deleteCustomer(int index){
        if(index >= 0 && index <= total - 1){

            for(int i = index; i < total - 1;i++){
                customers[i] = customers[i+1];
            }
            // 我傻了，没想到！
            // 删除最后一个位置的对象
            customers[total - 1] = null;
            total--;
            return true;
        }
        return false;
    }

    /**
     * 获得所有对象的信息
     * @return
     */
    public Customer[] getAllCustomers(){
        // 淦，不能直接传整个数组，又sb了！
        // return customers;
        Customer[] cus = new Customer[total];
        for(int i = 0;i < total;i++){
            cus[i] = customers[i];
        }
        return cus;
    }

    /**
     * 获取指定索引位置的客户
     * @param index
     * @return 如果找到，true，没有找到，false
     */
    public Customer getCustomer(int index){
        //淦，又忘了索引的限制！
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 获取客户的数量
     * @return total
     */
    public int getTotal(){
        return total;
    }

}
