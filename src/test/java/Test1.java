import com.zihua.testAnnotations.MyTest;
import com.zihua.testEnum.Season;
import org.junit.Test;

/**
 * Created by zihua on 17-3-24.
 */
public class Test1 {
    @Test
    public void test1(){
        for(Season s:Season.values()){
            System.out.println(s.name());
            System.out.println(s.getDeclaringClass());
        }
    }

    @Test
    @MyTest(id = -1)
    public void test2(){
        System.out.println(56555);
    }
}
