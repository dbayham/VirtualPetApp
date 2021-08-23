package virtual_pet;
public class OrganicPet<pubilc> extends VirtualPet {
    protected int hunger;
    private int age;
    protected int bathroom;
    protected int thirst;
    protected int changeVal;
    protected int ticksUntilCageClean;
    protected boolean alive;
    protected int boredom;


    public OrganicPet(String name, int age) {
        super(name);
        this.age = age;
        //Same as above for boredom
        this.boredom = boredom;
        this.hunger = 50;
        this.thirst = 50;
        this.bathroom = 50;
        this.changeVal = 10;
        this.ticksUntilCageClean = 5;
        this.alive = true;

    }

    public OrganicPet(String name, int age, int hunger, int thirst, int boredom, int ticksUntilCageClean) {
        super(name);
        this.ticksUntilCageClean = ticksUntilCageClean;
    }

    public void eat() {
        hunger = Math.max(hunger - changeVal, 0);
        bathroom = Math.min(bathroom + changeVal, 100);
        ticksUntilCageClean +=1;
    }

    public void drink() {
        thirst = Math.max(thirst - changeVal, 0);
        bathroom = Math.min(bathroom + changeVal, 100);
        ticksUntilCageClean +=1;
    }

    public void exercise() {
        boredom = Math.max(boredom - changeVal, 0);
        thirst +=20;
        bathroom = 0;
        ticksUntilCageClean +=1;
    }

    public void cageClean() {
        ticksUntilCageClean = 0;
    }


    public void tick() {
        hunger = Math.min(hunger + changeVal, 100);
        thirst = Math.min(thirst + changeVal, 100);
        boredom = Math.min(boredom + changeVal, 100);
        if (hunger == 100 || thirst == 100 || boredom == 100 || bathroom == 100) {
            alive = false;
        }
    }
    public String status(){
        String status = "";
        status += "Name: " + " " + name + " | ";
        status += "Age: " + " " +age + " | ";
        status += "Hunger:" + " " + hunger + " | ";
        status += "Thirst:" + " " +thirst + " | ";
        status += "Boredom:" + " " +boredom + " | ";
        status += "Bathroom:" + " " + bathroom + " | ";
        //status += "alive:" + " " + alive + " | ";
        status += "needs cleaning in:" + " " + ticksUntilCageClean + "\n";
        return status;
    }

//getters
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getBoredom() {
        return boredom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public boolean getAlive() {
        return alive;
    }

    public int getAge() {
        return age;
    }

    public int getTicksUntilCageClean() {
        return ticksUntilCageClean;
    }


}