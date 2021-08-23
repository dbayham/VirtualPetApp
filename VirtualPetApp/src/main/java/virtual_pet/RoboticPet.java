package virtual_pet;
public class RoboticPet extends VirtualPet{

    protected int battLevel;
    protected int changeVal;
    protected int ticksUntilNeedClean;
    protected int boredom;


    public RoboticPet(String name) {
        super(name);
        battLevel= 80;
        this.changeVal= -10;
        ticksUntilNeedClean = 5;
    }
    public RoboticPet(String name, int age, int battLevel) {
        super(name, age, battLevel);
        this.ticksUntilNeedClean = ticksUntilNeedClean;
        this.battLevel = battLevel;
    }

    public void charge() {
        battLevel = 100;
    }

    public void exercise() {
        boredom = Math.max(boredom - changeVal, 0);
        battLevel = Math.max(battLevel - 10, 0);
        battLevel = Math.min(battLevel + changeVal, 100);

    }

    public void performCleaning() {
        ticksUntilNeedClean = 5;
    }

    public void tick() {
        boredom = Math.min (boredom + changeVal, 100);
        battLevel = Math.min(battLevel + changeVal, 0);
        if (battLevel == 0 || boredom == 100) {
            alive = false;
        }
    }

    public String status(){
        String status = "";
        status += "Name: " + " " + name + " | ";
        status += "Age: " + " " +age + " | ";
        status += "Battery Level:" + " " + battLevel + " | ";
        status += "Boredom:" + " " + boredom + "\n";
       // status += "alive:" + " " + alive + "\n";
        return status;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getBattLevel() {
        return battLevel;
    }

    public int getBoredom() {
        return boredom;
    }

    public boolean getAlive() {
        return alive;
    }

    public int getAge() {
        return age;
    }

    public int getTicksUntilNeedClean(){
        return ticksUntilNeedClean;
    }

}