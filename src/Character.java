public interface Character {
    void showStatus();
    void equipAccessory(Accessories accessories);
    void deleteAccessory();
    void levelUp();
}

abstract class CharacterBase implements Character {
    String name;
    int level = 1;
    double maxHp = 100;
    double Hp = maxHp;
    double maxMana = 50 ;
    double Mana = maxMana;
    double runSpeed = 20;
    double def=10;
    double damage;

    Accessories accessories;

    public CharacterBase(String name, double damage,double maxMana) {
        this.name = name;
        this.damage = damage;
        this.maxMana = maxMana;
    }

    @Override
    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP : " + Hp + "/" + maxHp);
        System.out.println("Mana : " + Mana + "/" + maxMana);
        System.out.println("Run Speed : " + runSpeed);
        System.out.println("Def : " + def + "   Damage : " + damage);
    }

    @Override
    public void levelUp() {
        level++;
        maxHp += 10;
        maxMana += 5;
        Hp = maxHp;
        Mana = maxMana;
        runSpeed += 5;
        def += 5;
        damage += 5;
        System.out.println(name + " leveled up to level " + level);
    }

    public void equipAccessory(Accessories accessory) {
        if (this.accessories != null) { //เช็คว่ามีอุปกรณ์อยู่แล้วรึเปล่า
            System.out.println("Remove current accessory first."); //ถ้ามีอยู่ให้แสดงข้อความให้ถอดชิ้นเดิมออก
            return;
        }
        //ถ้ายังไม่มีให้ติดตั้งแล้วเพิ่มค่าให้ตัวละครตามอุปกร์ที่เพิ่ม
        this.accessories = accessory;
        this.runSpeed += accessory.getSpeedBoost();
        this.damage += accessory.getDamageBoost();
        this.def += accessory.getDefenseBoost();
        this.maxHp += accessory.getHpBoost();
        this.maxMana += accessory.getManaBoost();

        if(Mana > maxMana) Mana = maxMana;
        if(Hp > maxHp) Hp = maxHp;


        System.out.println(name + " equipped " + accessory.getName());
    }

    public void deleteAccessory() {
        if (this.accessories == null) { //เช็คว่ามีอุปกรณ์เสริมอยู่ไหม
            System.out.println("No accessory to remove.");
            return;
        }
        //ถอดอุปกรณ์แล้วลบค่าความสามารถออกตามที่เคยให้
        this.runSpeed -=accessories.getSpeedBoost();
        this.damage -= accessories.getDamageBoost();
        this.def -= accessories.getDefenseBoost();
        this.maxHp -= accessories.getHpBoost();
        this.maxMana -= accessories.getManaBoost();

        if(Mana > maxMana) Mana = maxMana;
        if(Hp > maxHp) Hp = maxHp;

        System.out.println(name + " removed " + accessories.getName());
        this.accessories = null;
    }

}