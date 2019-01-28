public interface SpaceShip {
    Boolean launch();
    Boolean land();
    Boolean canCarry(Item item);
    void carry(Item item);

}
