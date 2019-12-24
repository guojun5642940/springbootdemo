package com.guoj.model;

public class Menu {
    private Integer id;

    private Integer parentId;

    private String menuName;

    private String menuUrl;

    private String menuType;

    private Integer menuSort;

    private Integer menuClickCount;

    private String canceled;

    private String menuIcon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public Integer getMenuClickCount() {
        return menuClickCount;
    }

    public void setMenuClickCount(Integer menuClickCount) {
        this.menuClickCount = menuClickCount;
    }

    public String getCanceled() {
        return canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled == null ? null : canceled.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }
}