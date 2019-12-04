package com.cimc.framework.util;

import com.cimc.common.utils.StringUtils;
import com.cimc.common.utils.bean.BeanUtils;
import com.cimc.framework.shiro.realm.UserRealm;
import com.cimc.system.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * shiro 工具类
 *
 * @author chenz
 */
public class ShiroUtils {

    /**
     * 获取Subject对象
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取Shiro的Session对象
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * Shiro退出登录
     */
    public static void logout() {
        getSubject().logout();
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public static SysUser getSysUser() {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj)) {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }

    /**
     * 以其他用户身份，登录系统
     *
     * @param user
     */
    public static void setSysUser(SysUser user) {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    /**
     * 清理登录缓存信息
     */
    public static void clearCachedAuthorizationInfo() {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    /**
     * 获取登录Id
     *
     * @return
     */
    public static Long getUserId() {
        return getSysUser().getUserId().longValue();
    }

    /**
     * 获取登录用户名
     *
     * @return
     */
    public static String getLoginName() {
        return getSysUser().getLoginName();
    }

    /**
     * 获取Ip
     *
     * @return
     */
    public static String getIp() {
        return getSubject().getSession().getHost();
    }

    /**
     * 获取SessionId
     *
     * @return
     */
    public static String getSessionId() {
        return String.valueOf(getSubject().getSession().getId());
    }

    /**
     * 生成随机盐
     * 一个Byte占两个字节，此处生成的3字节，字符串长度为6
     */
    public static String randomSalt() {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }
}