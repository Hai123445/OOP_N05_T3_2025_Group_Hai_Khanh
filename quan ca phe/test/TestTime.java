public class TestTime {
<<<<<<< HEAD

    public static void Test(){
        System.out.println("Minute: "+Time.calculateMinutes(2, 30));
        System.out.println("Seconds in hour: "+Time.secondsInHours());
    }
=======
 public static void test() {
 Time t1 = new Time();
 Time t2 = new Time(20, 3, 45);
 t1.setHour(7).setMinute(32).setSecond(23);
 System.out.println("t1 is " + t1);
 System.out.println("t2 is " + t2);
 }
>>>>>>> c7669e15996efb7ff6eb1166944307d3a9372f20
}