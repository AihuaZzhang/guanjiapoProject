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

    //-----------------删除账务-----------------------
    public int deleteZhangWu(int zwid){
        try {
            String sql = "delete from gjp_zhangwu where zwid=?";
            return qr.update(sql,zwid);
        }catch (SQLException ex){
            throw new RuntimeException("编辑账务失败");
        }
    }

    //-----------------编辑账务-----------------------
    public int editZhangWu(ZhangWu zw){
        try {
            String sql = "update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            return qr.update(sql,params);
        }catch (SQLException ex){
            throw new RuntimeException("编辑账务失败");
        }
    }

    //-------------添加账务----------------
    public int addZhangWu(ZhangWu zw){
        try {
            String sql = "insert into gjp_zhangwu values(?,?,?,?,?,?)";
            Object[] paras = {null,zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            return qr.update(sql,paras);
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("添加失败");
        }
    }

    //-------------查询账务----------------
    //按条件查询
    public List<ZhangWu> select(String startDate,String endDate){
        String sql = "select *from gjp_zhangwu where createtime between ? and ?";
        Object[] params = {startDate,endDate};
        try {
            return qr.query(sql,new BeanListHandler<>(ZhangWu.class),params);
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("条件查询失败");
        }
    }

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
