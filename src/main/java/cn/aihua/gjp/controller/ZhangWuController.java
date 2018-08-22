package cn.aihua.gjp.controller;

//接收用户的view层数据 将其传递给service层

import cn.aihua.gjp.domain.ZhangWu;
import cn.aihua.gjp.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    //-----------------删除账务-----------------------
    public int deleteZhangWu(int zwid){
        return service.deleteZhangWu(zwid);
    }

    //-----------------编辑账务-----------------------
    public int editZhangWu(ZhangWu zw){
        return service.editZhangWu(zw);
    }

    //-------------添加账务----------------
    public int addZhangWu(ZhangWu zw){
        return service.addZhangWu(zw);
    }

    //-------------查询账务----------------
    //按条件查询
    public List<ZhangWu> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }

    //查询所有的账务数据
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }
}
