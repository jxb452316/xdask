package restaurant.management;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restaurant.management.access.ShiroRealm;
import restaurant.management.repository.UserLoginRepository;
import restaurant.management.service.UserLoginService;
import restaurant.management.service.impl.UserLoginServiceImpl;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhe.jiang on 2017/5/22.
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public UserLoginService userLoginService() {
        return new UserLoginServiceImpl();
    }

    @Bean
    public Realm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        return sm;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager sm) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/index");
        shiroFilter.setUnauthorizedUrl("/forbidden");
        Map<String, String> filterChainDefinitionMapping = new LinkedHashMap<>();

        filterChainDefinitionMapping.put("/login", "anon");
        filterChainDefinitionMapping.put("/css/**", "anon");
        filterChainDefinitionMapping.put("/example/**", "anon");
        filterChainDefinitionMapping.put("/font-awesome/**", "anon");
        filterChainDefinitionMapping.put("/fonts/**", "anon");
        filterChainDefinitionMapping.put("/img/**", "anon");
        filterChainDefinitionMapping.put("/js/**", "anon");
        filterChainDefinitionMapping.put("/static/**", "anon");

//        filterChainDefinitionMapping.put("/admin", "authc");
//        filterChainDefinitionMapping.put("/employee", "authc");
//        filterChainDefinitionMapping.put("/customer", "authc");
        filterChainDefinitionMapping.put("/**", "anon");

        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
        shiroFilter.setSecurityManager(sm);

        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new FormAuthenticationFilter());

        shiroFilter.setFilters(filters);
        return shiroFilter;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
