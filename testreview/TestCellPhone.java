public class TestCellPhone {
    public static void test() {
        CellPhone noiseMaker = new CellPhone();
        Tune t1 = new Tune(); 
        Tune t2 = new ObnoxiousTune();
        noiseMaker.ring(t1);
        noiseMaker.ring(t2);
    }
}