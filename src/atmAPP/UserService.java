package atmAPP;
import atmAPP.User;

import java.util.Scanner;
public class UserService {
    static User user = new User();
    static Scanner scan = new Scanner(System.in);
    static int select;
    static int counter = 0;
    public static void start() {
        while (true) {
            System.out.println("Enter card number");
            String cardNumber = scan.next();
            System.out.println("Enter password");
            String password = scan.next();
            if (user.getCarNumber().equals(cardNumber) && user.getPassword().equals(password)) {
                menu();
            }else {
                counter++;
                if (counter == 3) {
                    System.out.println("Hesabınız Bloke olmuştur");
                    break;
                }
            }
        }
    }
    public static void menu() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");
        System.out.println("" +
                "\n1. Bakiye sorgula" +
                "\n2. Para yatirma" +
                "\n3. Para çekme" +
                "\n4. Para gönderme" +
                "\n5. Şifre değiştirme" +
                "\n0. Çıkış\n");
        while (true){
            select = scan.nextInt();
            switch (select) {
                case 1:
                    bakiyeSorgula();
                    break;
                case 2:
                    paraYatirma();
                    break;
                case 3:
                    paraCekme();
                    break;
                case 4:
                    paraGonderme();
                case 5:
                    sifreDegistirme();
                    break;
                case 0:
                    cikis();
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız!");
                    break;
            }
        }
    }
    private static void bakiyeSorgula() {
        System.out.println("Güncel Bakiyeniz: " + user.getBalance());
        ikinciSecim();
    }
    public static void paraYatirma() {

        System.out.println("Lütfen yatırmak istediğiniz para miktarını giriniz.");
        double miktar=scan.nextInt();
        if (miktar>0){
            user.setBalance(user.getBalance()+miktar);
            System.out.println("Güncel bakiyeniz : "+user.getBalance());
        }else {
            System.out.println("Yatırılan tutar 0 ve negatif olamaz");
        }

        ikinciSecim();
    }
    public static void paraCekme() {
        System.out.println("Lütfen çekmek istediğiniz para miktarını giriniz.");
        double miktar=scan.nextInt();
        if (miktar>0 || miktar<user.getBalance()){
            user.setBalance(user.getBalance()-miktar);
            System.out.println("Güncel bakiyeniz : "+user.getBalance());



        }else if (miktar> user.getBalance()) {
            System.out.println("Bakiyeniz ytersiz"+
                    "\n Güncel bakiyeniz "+user.getBalance());
        }
        else {
            System.out.println("Tutar 0 ve negatif olamaz");
        }

        ikinciSecim();
    }
    public static void paraGonderme() {
        System.out.println("Lütfen para göndereceğiniz hesabın iban numarasını giriniz.");
        String iban=scan.next();
        if(iban.substring(0,2).contains("TR")&&iban.length()==4){

            System.out.println("Göndermek istediğiniz miktari giriniz");
            double miktar = scan.nextDouble();

            if (miktar<user.getBalance()){
                user.setBalance(user.getBalance()-miktar);
                System.out.println("İşleminiz gerçekleştirildi \n" +
                        "Güncel bakiyeniz " + user.getBalance());
            }else {
                System.out.println("Bakiteniz yeterli değildir.");
            }

        }
        ikinciSecim();
    }
    public static void sifreDegistirme() {
        System.out.println("Şifre geçerli şifrenizi giriniz");
        String sifre=scan.next();

        if (sifre.equals(user.getPassword())){
            System.out.println("Yeni şifrenizi giriniz");
            String yeniSifre= scan.next();
            user.setPassword(yeniSifre);
            System.out.println("Şifreniz başarıyla değiştirilmiştir.");
            System.out.println(yeniSifre);
            ikinciSecim();
        }  else {
            System.out.println("Şifrenizi hatali girdiniz.");
            sifreDegistirme();
        }

    }
    public static void cikis() {
        System.exit(0);
    }
    public static void ikinciSecim() {
        System.out.println("Yapmak istediğiniz işlemi seçiniz" +
                "\n1. Ana Menü" +
                "\n0. Çıkış");
        int secim = scan.nextInt();
        if (secim == 1) {
            menu();
        } else if (secim == 0) {
            cikis();
        } else {
            System.out.println("Hatalı giriş 1 ya da 0 giriniz");
        }
    }
}