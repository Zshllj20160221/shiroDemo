import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zsh on 2017/7/22.
 * http://blog.csdn.net/edward0830ly/article/details/8250412
 */
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String [] args){

        logger.info("*******************************************************************");
        logger.debug("*******************************************************************");

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager= factory.getInstance();

        //这一句不能少
        SecurityUtils.setSecurityManager(securityManager);

        UsernamePasswordToken token = new UsernamePasswordToken("javass","cc");

        token.setRememberMe(true);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        boolean flag = subject.isPermitted("p1");

        System.out.println("flag=="+flag);
    }

}
