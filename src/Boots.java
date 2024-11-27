public class Boots implements Accessories {
    private int level = 1;

    @Override
    public String getName() {
        return "Boots";
    }

    @Override
    public double getDamageBoost() {
        return 5 * level;
    }

    @Override
    public double getSpeedBoost() {
        return 10;
    }

    @Override
    public double getDefenseBoost() {
        return 5;
    }

    @Override
    public double getHpBoost() {
        return 5;
    }

    @Override
    public double getManaBoost() {
        return 0;
    }


    public void levelUp() {
        level++;
    }
}