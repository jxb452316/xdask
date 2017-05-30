package restaurant.management.access;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.management.model.UserLogin;
import restaurant.management.service.UserLoginService;

/**
 * Created by zhe.jiang on 2017/5/22.
 */
public class ShiroRealm extends AuthorizingRealm {
    public static final String REALM_NAME = "restaurant";

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserLoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserLogin login = (UserLogin)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        switch (login.getUsertype()) {
            case UserLogin.USER_TYPE_ADMINISTRATOR:
                info.addRole("admin");
                break;
            case UserLogin.USER_TYPE_EMPLOYEE:
                info.addRole("employee");
                break;
            case UserLogin.USER_TYPE_CUSTOMER:
                info.addRole("customer");
                break;
            case UserLogin.USER_TYPE_UNKNOWN:
                logger.info("unknown user type, with no authorization");
                break;
            default:
                throw new RuntimeException("unexpected user type");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserLogin login = loginService.authenticate(token.getUsername(), new String(token.getPassword()));
        if (login == null)
            throw new AuthenticationException("登录失败");
        return new SimpleAuthenticationInfo(
                login, token.getPassword(), REALM_NAME);
    }
}
