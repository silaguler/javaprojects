import java.util.Random;

public class Rocket implements SpaceShip {
    protected int cost;
    protected double weight;
    protected double max_item_weight;
    protected double item_weight_carried;
    protected double chance_crash;
    protected double chance_explode;


    protected double ranGenerator(double prob_failing){
        Random ran = new Random();
        double r = ran.nextGaussian();
        return r*0.3+prob_failing;
    }

    @Override
    public Boolean launch() {
        return true;
    }

    @Override
    public Boolean land() {
        return true;
    }

    @Override
    final public Boolean canCarry(Item item) {
        Boolean result;
        if(item.getWeight() == this.max_item_weight - this.item_weight_carried){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    final public void carry(Item item) {
        this.item_weight_carried += item.getWeight();
    }
}
