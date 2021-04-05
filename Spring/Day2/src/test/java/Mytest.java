import com.stqin.study.spring.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Mytest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.setStr("ss");
        System.out.println(hello.getStr());
    }
}
