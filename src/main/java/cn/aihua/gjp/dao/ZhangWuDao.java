package cn.aihua.gjp.dao;

//实现对数据表gjp_zhangwu表数据的增删改查操作
//使用dbutil工具类完成 创建qr

import cn.aihua.gjp.domain.ZhangWu;
import cn.aihua.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    //查询数据库 获取所有的账务数据
    public List<ZhangWu> selectAll(){
        String sql = "SELECT *FROM gjp_zhangwu";
        try {
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败");
        }
    }
}
