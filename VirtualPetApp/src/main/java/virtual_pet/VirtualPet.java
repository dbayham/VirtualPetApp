package virtual_pet;

public abstract class VirtualPet {
    protected String name;
    protected int boredom;
    protected boolean alive;
    protected int age;
    protected int changeVal;
    protected int lifeSpan;
    protected String description;

//    public VirtualPet(String name){
//        this.name = name;
//    }


    public VirtualPet(String name, int age, int lifeSpan) {
        this.name = name;
        this.boredom = 50;
        this.age = age;
        this.alive = true;
        this.changeVal = 10;
        this.lifeSpan = lifeSpan;
    }

    public VirtualPet(String name) {
        this.name = name;
    }


    //getter
    public String getName() {
        return name;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getAge() {
        return age;
    }

    public boolean getAlive() {
        return alive;
    }

    public abstract String status();

    public abstract void exercise();

}
