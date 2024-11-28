public class Fighter extends CharacterBase {
    public Fighter(String name) {
        super(name,10,50);
    }

    public void levelUp() {
        super.levelUp();
        maxMana += 5;
        Mana = maxMana;
        damage += 10;
    }

    public void fighterATK(Character opponent) {
        if (this == opponent) { // ตรวจสอบว่ากำลังโจมตีตัวเองหรือไม่
            System.out.println(name + " cannot attack themselves!");
            return;
        }

        double attackDamage = this.damage; // ใช้ค่า damage ของ Fighter
        System.out.println(name + " attacks and deals " + attackDamage + " damage!");

        if (opponent instanceof Fighter target) { //ตรวจสอบว่าเป็นobject ของ Fighter ไหม
            target.Hp -= Math.max(0,attackDamage - target.def); //ลด Hp ของคู่ต่อสู้
        } else if (opponent instanceof Mage target) {//ถ้าเป็น object ของ mage
            target.Hp -= Math.max(0,attackDamage - target.def); //ลดค่า Hp ของคู่ต่อสู้
        }

    }
}
