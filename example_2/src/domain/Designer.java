package domain;

public class Designer extends Programmer{
    private double bonues; // 奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonues) {
        super(id, name, age, salary, equipment);
        this.bonues = bonues;
    }

    public double getBonues() {
        return bonues;
    }

    public void setBonues(double bonues) {
        this.bonues = bonues;
    }

    @Override
    public String toString(){

        return getDetials() + "\t设计师\t" + getStatus().getNAME() + "\t" + bonues + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师\t" + getSalary();
    }
}
