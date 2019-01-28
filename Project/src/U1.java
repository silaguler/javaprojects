import java.util.Random;

public class U1 extends Rocket{

    public U1() {
        this.cost = 100;
        this.weight = 10;
        this.max_item_weight = 18;
        this.item_weight_carried = 0;
        this.chance_crash = 1 * (this.item_weight_carried / this.max_item_weight) / 100;
        this.chance_explode = 5 * (this.item_weight_carried / this.max_item_weight) / 100;
    }

    @Override
    public Boolean launch() {
        Boolean result;
        if(super.ranGenerator(0.4)>=0.5){
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    @Override
    public Boolean land() {
        Boolean result;
        if(super.ranGenerator(0.6)>=0.5){
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
