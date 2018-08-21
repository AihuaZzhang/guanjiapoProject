package cn.aihua.gjp.service;

//业务层 接收控制层的数据 将数据经过计算 传递给Dao层 去操作数据库

import cn.aihua.gjp.dao.ZhangWuDao;
import cn.aihua.gjp.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    //查询所有的账务数据
    public List<ZhangWu> selectAll(){
        return dao.selectAll();
    }
}
