package cn.aihua.gjp.view;

//视图层 用户看到和操作的界面 数据传递给controller

import cn.aihua.gjp.controller.ZhangWuController;
import cn.aihua.gjp.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private ZhangWuController controller = new ZhangWuController();

    /*
        实现界面效果
        接收用户输入
        根据数据调用不同的方法
     */
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("-------管家婆家庭记账软件-------");
            System.out.println("1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");

            //接收用户输入的数据
            int choose = sc.nextInt();
            //判断接收数据 调用不同功能
            switch (choose){
                case 1:
                    //添加账务
                    addZhangWu();
                    break;
                case 2:
                    //编辑账务
                    editZhangWu();
                    break;
                case 3:
                    //删除账务
                    deleteZhangWu();
                    break;
                case 4:
                    //查询账务
                    selectZhangWu();
                    break;
                case 5:
                    //退出系统
                    System.exit(0);
                    break;
            }
        }
    }

    //-----------------删除账务-----------------------
    private void deleteZhangWu(){
        selectAll();
        System.out.println("进入删除功能,请输入以下数据:");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的ID");
        int zwid = sc.nextInt();

        int row = controller.deleteZhangWu(zwid);
        if (row > 0){
            System.out.println("删除账务成功");
        }else {
            System.out.println("删除账务失败");
        }
    }

    //-----------------编辑账务-----------------------
    private void editZhangWu(){
        selectAll();
        System.out.println("进入编辑功能,请输入以下数据:");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改的ID");
        int zwid = sc.nextInt();
        System.out.println("请输入新分类名称");
        String flname = sc.next();
        System.out.println("请输入新金额");
        double money = sc.nextDouble();
        System.out.println("请输入新账户");
        String zhanghu = sc.next();
        System.out.println("请输入新日期:格式xxxx-xx-xx");
        String createtime = sc.next();
        System.out.println("请输入新具体描述");
        String description = sc.next();

        ZhangWu zw = new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
        int row = controller.editZhangWu(zw);
        if (row > 0){
            System.out.println("编辑账务成功");
        }else {
            System.out.println("编辑账务失败");
        }
    }

    //-----------------添加账务-----------------------
    private void addZhangWu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分类名称");
        String flname = sc.next();
        System.out.println("请输入金额");
        double money = sc.nextDouble();
        System.out.println("请输入账户");
        String zhanghu = sc.next();
        System.out.println("请输入日期:格式xxxx-xx-xx");
        String createtime = sc.next();
        System.out.println("请输入具体描述");
        String description = sc.next();

        //封装ZhangWu对象
        ZhangWu zw = new ZhangWu(0,flname,money,zhanghu,createtime,description);

        //将接收到的数据 调用controller层方法 传递数据
        int row = controller.addZhangWu(zw);
        if (row > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    //-----------------查询账务-----------------------
    private void selectZhangWu(){
        System.out.println("1.查询所有 2.按条件查询");
        Scanner sc = new Scanner(System.in);
        int selectChoose = sc.nextInt();
        if (selectChoose == 1){
            //查询所有
            selectAll();
        }else {
            //按条件查询
            select();
        }
    }

    private void selectAll(){
        //调用控制层方法查询所有数据
        List<ZhangWu> list = controller.selectAll();
        printZhangWu(list);
    }

    private void select(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始日期:");
        String startDate = sc.nextLine();
        System.out.println("请输入结束日期:");
        String endDate = sc.nextLine();

        List<ZhangWu> list = controller.select(startDate,endDate);
        if (list.size() != 0){
            printZhangWu(list);
        }else {
            System.out.println("没有查询到数据");
        }
    }

    private void printZhangWu(List<ZhangWu> list) {
        //输出表头
        System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t\t\t说明");
        for (ZhangWu zw: list){
            System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t"+zw.getCreatetime()+"\t\t"+zw.getDescription());
        }
    }
}
