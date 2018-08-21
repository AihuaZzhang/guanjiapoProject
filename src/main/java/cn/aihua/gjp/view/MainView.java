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
                    break;
                case 2:
                    //编辑账务
                    break;
                case 3:
                    //删除账务
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

    //查询账务
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
        //输出表头
        System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t\t\t说明");
        for (ZhangWu zw: list){
            System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t"+zw.getCreatetime()+"\t\t"+zw.getDescription());
        }
    }

    private void select(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始日期:");
        String startDate = sc.nextLine();
        System.out.println("请输入结束日期:");
        String endDate = sc.nextLine();

    }
}
