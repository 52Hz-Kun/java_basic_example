package service;

import domain.*;

/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 *
 */

public class NameListService {

    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {

            // 获取员工的类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            // 后面都是Employee的子类，先把父类的所有属性都赋值
            // 获取Employee的4个基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;// 为了后面避免重名，这里只声明获取
            double bonus;
            int stock;

            switch(type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    // 新建了个方法，根据不同的员工获取不同的设备对象（通过接口）
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * @Description 获取指定index上员工的设备的对象
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                return new Notebook(Data.EQUIPMENTS[index][1], price);
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }
        return null;
    }

    /**
     * 获取当前所有员工
     * @return
     */
    public Employee[] getAllEmployee(){
        return employees;
    }

    /**
     * 获取指定ID的员工
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id){
                return employees[i];
            }
        }

        throw new TeamException("没有此ID的员工");
    }
}
