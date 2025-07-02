public class testUser {
    public static void test1(){
       User User = new User(1,"user1","123456");
    public static void test() {
        User user = new User();

        user.setUser("Nguyen Van A", "123 Le Loi, Ha Noi");

        System.out.println("Ten nguoi dung: " + user.getName());
        System.out.println("Dia chi nguoi dung: " + user.getAddress());
    }
}
