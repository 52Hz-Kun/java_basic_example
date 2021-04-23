package domain;

import service.Status;

public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString(){

        return getDetials() + "\t程序员\t" + status.getNAME() + "\t\t\t\t\t" + equipment.getDescription();
    }

    // 在开发团队列表里不再使用tiString方法，谢了个新方法调用，因为格式不同
    public String getDetailsForTeam(){
        return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
    }
}
