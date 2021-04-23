package domain;

public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonues, int stock) {
        super(id, name, age, salary, equipment, bonues);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){

        return getDetials() + "\t架构师\t" + getStatus().getNAME() + "\t" + getBonues() + "\t" + stock + "\t" + getEquipment().getDescription();
    }
}
