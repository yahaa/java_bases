import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zihua on 17-4-2.
 */
public class Test2 {
    private final static String s="999";
    public void one(String...args){
        for(String s:args){
            System.out.println(s);
        }
    }

    public void two(String []args){
        for(String s:args){
            System.out.println(s);
        }
    }

    @Test
    public void test(){
        System.out.println(s);
    }
}


class TXX{
    public void sss(){
        Test2 a=new Test2();
        System.out.println();
    }
}
