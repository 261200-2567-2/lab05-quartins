public class Mage implements Character {
    String name;
    int level = 1;
    double maxHp = 100;
    double Hp = maxHp;
    double maxMana = 70;
    double Mana = maxMana;
    double runSpeed = 20;
    double def = 10;
    double damage = 10;

    Accessories accessories;

    public Mage(String name) {
        this.name = name;
    }

    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP : " + Hp + "/" + maxHp);
        System.out.println("Mana : " + Mana + "/" + maxMana);
        System.out.println("Run Speed : " + runSpeed);
        System.out.println("Def : " + def + "    Damage : " + damage);
    }

    public void levelUp() {
        level++;
        maxHp += 10;
        maxMana += 10;
        runSpeed += 2;
        def += 5;
        damage += 5;
        System.out.println(name + " leveled up to level " + level);
    }

    public void equipAccessory(Accessories accessory) {
        if (this.accessories != null) {
            System.out.println("Remove current accessory first.");
            return;
        }
        this.accessories = accessory;
        this.damage += accessory.getDamageBoost();
        this.def += accessory.getDefenseBoost();
        this.maxHp += accessory.getHpBoost();
        this.maxMana += accessory.getManaBoost();
        System.out.println(name + " equipped " + accessory.getName());
    }

    public void deleteAccessory() {
        if (this.accessories == null) {
            System.out.println("No accessory to remove.");
            return;
        }
        this.damage -= accessories.getDamageBoost();
        this.damage += accessories.getDamageBoost();
        this.def -= accessories.getDefenseBoost();
        this.maxHp -= accessories.getHpBoost();
        this.maxMana -= accessories.getManaBoost();
        System.out.println(name + " removed " + accessories.getName());
        this.accessories = null;
    }

    public void MageATK(Character opponent) {
        if (this == opponent) { // ตรวจสอบว่ากำลังโจมตีตัวเองหรือไม่
            System.out.println(name + " cannot attack themselves!");
            return;
        }

        double attackDamage = this.damage + this.Mana * 0.1; // เพิ่มความเสียหายตาม Mana
        System.out.println(name + " casts a spell and deals " + attackDamage + " damage!");

        if (opponent instanceof Fighter) {
            Fighter target = (Fighter) opponent;
            target.Hp -= Math.max(0, attackDamage - target.def); //ลด HP ตามความเสียหาย
        } else if (opponent instanceof Mage) {
            Mage target = (Mage) opponent;
            target.Hp -= Math.max(0, attackDamage - target.def);
        }
    }
}
