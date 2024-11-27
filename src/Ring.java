public class Ring implements Accessories {
    private int level = 1;

    @Override
    public String getName() {
        return "Ring";
    }

    @Override
    public double getSpeedBoost() {
        return 0;
    }

    @Override
    public double getDamageBoost() {
        return 5;
    }

    @Override
    public double getDefenseBoost() {
        return  4;
    }

    @Override
    public double getHpBoost() {
        return 5;
    }

    @Override
    public double getManaBoost() {
        return 5;
    }

    @Override
    public void levelUp() {
        getManaBoost();
        level++;
    }
}
