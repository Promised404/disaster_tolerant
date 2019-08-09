package com.dpt.dt.pojo;

import javax.persistence.*;

/**
 * @author 邓鹏涛
 * @date 2019/8/8 21:49
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @ManyToMany
    @Column(name = "parent_id")
    private SysMenu parentMenu;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private SysMenu url;

    @Column(name = "perms")
    private SysMenu perms;

    @Column(name = "type")
    private Integer type;

    @Column(name = "icon")
    private String icon;

    @Column(name = "order_num")
    private Integer orderNum;

    public SysMenu() {
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public SysMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(SysMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysMenu getUrl() {
        return url;
    }

    public void setUrl(SysMenu url) {
        this.url = url;
    }

    public SysMenu getPerms() {
        return perms;
    }

    public void setPerms(SysMenu perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
