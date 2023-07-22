public interface Creature {

    Responce eat();

    Responce reproduce();

    Responce move();

    //------------------------

    int getId();

    Cell getCoords();

}
