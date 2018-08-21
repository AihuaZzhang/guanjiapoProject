package cn.aihua.gjp.controller;

//接收用户的view层数据 将其传递给service层

import cn.aihua.gjp.domain.ZhangWu;
import cn.aihua.gjp.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    //查询所有的账务数据
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }
}
