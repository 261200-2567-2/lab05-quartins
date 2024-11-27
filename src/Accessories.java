public interface Accessories {

    String getName(); // เช่น Boots หรือ Ring
    double getDamageBoost();
    double getDefenseBoost();
    double getHpBoost();
    double getManaBoost();
    double getSpeedBoost();

    void levelUp();
}
