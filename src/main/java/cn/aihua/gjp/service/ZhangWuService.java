package cn.aihua.gjp.service;

//业务层 接收控制层的数据 将数据经过计算 传递给Dao层 去操作数据库

import cn.aihua.gjp.dao.ZhangWuDao;
import cn.aihua.gjp.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    //-----------------删除账务-----------------------
    public int deleteZhangWu(int zwid){
        return dao.deleteZhangWu(zwid);
    }

    //-----------------编辑账务-----------------------
    public int editZhangWu(ZhangWu zw){
        return dao.editZhangWu(zw);
    }

    //-------------添加账务----------------
    public int addZhangWu(ZhangWu zw){
        return dao.addZhangWu(zw);
    }

    //-------------查询账务----------------
    //按条件查询
    public List<ZhangWu> select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }

    //查询所有的账务数据
    public List<ZhangWu> selectAll(){
        return dao.selectAll();
    }
}
