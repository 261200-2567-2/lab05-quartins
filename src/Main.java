public class Main {
    public static void main(String[] args) {
        // สร้างตัวละคร
        Fighter fighter = new Fighter("Archer");
        Mage mage = new Mage("Wizard");

        // สร้างอุปกรณ์เสริม
        Boots boots = new Boots();
        Ring ring = new Ring();

        // แสดงสถานะเริ่มต้น
        System.out.println("********************************");
        System.out.println("**** Character Status ****");
        fighter.showStatus();
        mage.showStatus();

        // สวมอุปกรณ์
        System.out.println("\n**** Equipping Accessories ****");
        fighter.equipAccessory(boots);
        mage.equipAccessory(ring);


        // แสดงสถานะหลังสวมอุปกรณ์
        System.out.println("\n**** Status After Equipping Accessories ****");
        fighter.showStatus();
        mage.showStatus();

        // ตัวละครเลเวลอัพ
        System.out.println("\n**** Leveling Up ****");
        fighter.levelUp();
        mage.levelUp();

        ring.levelUp();

        // แสดงสถานะหลังเลเวลอัพ
        System.out.println("\n***** Status After Level Up *****");
        fighter.showStatus();
        mage.showStatus();

        // การโจมตี
        System.out.println("\n**** Battle ****");
        System.out.println("Fighter attacks Mage:");
        fighter.fighterATK(mage);
        mage.showStatus();

        System.out.println("Mage attacks Fighter:");
        mage.MageATK(fighter);
        fighter.showStatus();

        // ถอดอุปกรณ์
        System.out.println("\n**** Removing Accessories ****");
        fighter.deleteAccessory();
        mage.deleteAccessory();

        // แสดงสถานะหลังถอดอุปกรณ์
        System.out.println("\n**** Status After Removing Accessories ****");
        fighter.showStatus();
        mage.showStatus();

        System.out.println("\n***** Test attack ****");
        fighter.fighterATK(fighter);
    }
}
