public class Mage extends CharacterBase {

    public Mage(String name) {
        super(name,10,50);
    }


    public void levelUp() {
        super.levelUp();
        maxMana += 10;
        Mana = maxMana;
        runSpeed += 2;
        def += 5;
        damage += 5;
    }

    public void MageATK(Character opponent) {
        if (this == opponent) { // ตรวจสอบว่ากำลังโจมตีตัวเองหรือไม่
            System.out.println(name + " cannot attack themselves!");
            return;
        }

        double attackDamage = this.damage + this.Mana * 0.5; // เพิ่มความเสียหายตาม Mana
        System.out.println(name + " casts a spell and deals " + attackDamage + " damage!");

        if (opponent instanceof Fighter target) {
            //Fighter target = (Fighter) opponent;
            target.Hp -= Math.max(0, attackDamage - target.def); //ลด HP ตามความเสียหาย
        } else if (opponent instanceof Mage target) {
            //Mage target = (Mage) opponent;
            target.Hp -= Math.max(0, attackDamage - target.def);
        }
    }
}
