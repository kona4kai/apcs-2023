package unit11.b;

// let's explore inheritance!
public class Bear {
    // composition
    private Zoo whereILive;
    private String name;

    public Bear() {
        this.name = "Mr. Bear";
    }

    public Bear(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Bear yunZi  = new Panda("Yun Zi");
        Bear mrBear = new Bear();
        System.out.println(yunZi.getName());
        System.out.println(mrBear.getName());
        // Panda mrPandaBear = new Panda();
    }
}

// https://wwf.panda.org/wwf_news/?163461/Is-the-giant-panda-a-bear
class Panda extends Bear {

    public Panda() {}
    public Panda(String name) {
        super(name);
    }
}

// https://en.wikipedia.org/wiki/List_of_giant_pandas
class Zoo {
    // composition
    private Panda inhabitant;
}

// Zookeeper, Visitor, etc.
