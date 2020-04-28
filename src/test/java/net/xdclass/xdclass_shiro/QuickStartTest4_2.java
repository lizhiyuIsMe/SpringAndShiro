package net.xdclass.xdclass_shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


/**
 * 单元测试用例执行顺序
 *
 * @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
 */
public class QuickStartTest4_2 {
    //创建一个最简单的Realm
    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    //创建一个SecurityManager
    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init() {
        //初始化用户名 密码
        accountRealm.addAccount("xdclass", "123");
        accountRealm.addAccount("jack", "456");
        //构建环境
        defaultSecurityManager.setRealm(accountRealm);
    }


    @Test
    public void testAuthentication() {

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //当前操作主体， application user
        Subject subject = SecurityUtils.getSubject();

        //用户输入的账号密码
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken("jack", "456");

        subject.login(usernamePasswordToken);


        System.out.println("认证结果:"+subject.isAuthenticated());


    }


}
