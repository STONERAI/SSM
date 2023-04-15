import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {

    /**
     * 使一级缓存失效的四种情况：
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作 --->可能影响缓存中的数据
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     */
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empByEmpId = mapper.getEmpByEmpId(1);
        Emp empByEmpId1 = mapper.getEmpByEmpId(1);
        System.out.println(empByEmpId == empByEmpId1);
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        Emp empByEmpId2 = mapper1.getEmpByEmpId(1);
        System.out.println(empByEmpId == empByEmpId2);
        sqlSession.close();
        sqlSession1.close();
    }
}
