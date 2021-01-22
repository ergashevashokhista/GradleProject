import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test1 {
    @Test
    public void test1(){
        Assertions.assertEquals(true,true);
    }

    @Test
    public void testMM(){
        Assertions.assertEquals(6.0,mm(2.0));
    }
    static Double mm(Double a){
        return a*a;
    }
}
