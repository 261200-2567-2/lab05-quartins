public class Fighter implements Character {
    String name;
    int level = 1;
    double maxHp = 100;
    double Hp = maxHp;
    double maxMana = 50;
    double Mana = maxMana;
    double runSpeed = 20;
    double def;
    double damage = 15;

    Accessories accessories;

    public Fighter(String name) {
        this.name = name;
        this.def = 10;
    }

    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP : " + Hp + "/" + maxHp);
        System.out.println("Mana : " + Mana + "/" + maxMana);
        System.out.println("Run Speed : " + runSpeed);
        System.out.println("Def : " + def + "   Damage : " + damage);
    }

    public void levelUp() {
        level++;
        maxHp += 10;
        maxMana += 5;
        runSpeed += 2;
        def += 10;
        damage += 10;
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
        System.out.println(name + " removed " + accessories.getName());
        this.accessories = null;
    }

    public void fighterATK(Character opponent) {
        if (this == opponent) { // ตรวจสอบว่ากำลังโจมตีตัวเองหรือไม่
            System.out.println(name + " cannot attack themselves!");
            return;
        }

        double attackDamage = this.damage; // ใช้ค่า damage ของ Fighter
        System.out.println(name + " attacks and deals " + attackDamage + " damage!");
        if (opponent instanceof Fighter) { //ตรวจสอบว่าเป็นobject ของ Fighter ไหม
            Fighter target = (Fighter) opponent; //ถ้าเป็นให้แปลงเป็น Fighterเพื่อเข้าถึงค่าตัวแปรและmethod
            target.Hp -= attackDamage - target.def; //ลด Hp ของ target
        } else if (opponent instanceof Mage) {
            Mage target = (Mage) opponent;
            target.Hp -= attackDamage - target.def;
        }

    }
}
