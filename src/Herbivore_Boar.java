import java.util.HashMap;

public class Herbivore_Boar extends Herbivore {

    private static final double weight = 400;
    private static final int cellsPerStep = 2;
    private static final double kilosForSatiety = 50;
    private static HashMap<Class<?>, Integer> whom = whomInit(Herbivore_Boar.class);
    Herbivore_Boar(int y, int x) {
        super(y, x);
    }
    @Override
    public Responce move() {
        return super.move(cellsPerStep);
    }
    public Responce eat() { return super.eat(weight, kilosForSatiety, whom); }
}
