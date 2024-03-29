package com.cimc.common.enums;

/**
 * 用户会话
 *
 * @author chenz
 */
public enum OnlineStatus {
    /**
     * 用户状态
     */
    ON_LINE("在线"), OFF_LINE("离线");

    private final String info;

    OnlineStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}