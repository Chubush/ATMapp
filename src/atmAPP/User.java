package atmAPP;

public class User {

    private String cardNumber="1234";
    private String password="1234";
    private double balance;

    public User(String carNumber, String password, double balance) {
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = balance;
    }

    public String getCarNumber() {
        return cardNumber;
    }

    public void setCardNumber(String carNumber) {
        this.cardNumber = carNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "carNumber='" + cardNumber + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
