class Dog {

    private int age;
    private String name;
    private int weight;
    private boolean isAlive;
    private static int totalDogs;

    public Dog() {
        age = 10;
        name = "Doggy";
        weight = 100;
        isAlive = true;
        totalDogs++;
    }

    public Dog(int age, String name, int weight, boolean isAlive) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.isAlive = isAlive;
        totalDogs++;
    }

    public Dog(String name) {
        age = 10;
        this.name = name;
        weight = 100;
        isAlive = true;
        totalDogs++;
    }

    public int getAge() {
        return age;
    }

    public static int totalDogs() {
        return totalDogs;
    }

    public void birthday() {
        age++;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public String toString() {
        return "Our dog's name is " + name + ". He is " + age + " years old and weighs " + weight
                + " pounds. Is he alive: " + isAlive + ".";
    }

}
