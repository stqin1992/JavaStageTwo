import com.stqin.study.spring.dao.UserDaoImpl;
import com.stqin.study.spring.dao.UserDaoImpl2;
import com.stqin.study.spring.server.UserServer;
import com.stqin.study.spring.server.UserServerImpl;
import org.junit.Test;

public class Mytest {

    @Test
    public void test(){
        UserServer userServer = new UserServerImpl();
        userServer.setDao(new UserDaoImpl2());
        userServer.getName();
    }

}
