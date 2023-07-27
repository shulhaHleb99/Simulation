import java.util.HashMap;

public class Herbivore_Larva extends Herbivore {

    static final double weight = 0.01;
    static final int cellsPerStep = 0;
    static final double kilosForSatiety = 0;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Larva.class);
    Herbivore_Larva(int y, int x) {
        super(y, x);
    }

    @Override
    public Responce move() {
        return new Responce(1);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
