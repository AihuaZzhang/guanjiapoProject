package cn.aihua.gjp.domain;

public class ZhangWu {
    private int zwid;
    private String flname;
    private double money;
    private String zhanghu;
    private String createtime;
    private String description;

    public ZhangWu(){

    }

    public ZhangWu(int zwid, String flname, double money, String zhanghu, String createtime, String description) {
        this.zwid = zwid;
        this.flname = flname;
        this.money = money;
        this.zhanghu = zhanghu;
        this.createtime = createtime;
        this.description = description;
    }

    public int getZwid() {
        return zwid;
    }

    public String getFlname() {
        return flname;
    }

    public double getMoney() {
        return money;
    }

    public String getZhanghu() {
        return zhanghu;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setZwid(int zwid) {
        this.zwid = zwid;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setZhanghu(String zhanghu) {
        this.zhanghu = zhanghu;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
