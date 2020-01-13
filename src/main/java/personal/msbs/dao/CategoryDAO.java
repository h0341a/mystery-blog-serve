package personal.msbs.dao;

import org.springframework.stereotype.Repository;
import personal.msbs.model.entity.Category;

/**
 * @author ling
 */
@Repository
public interface CategoryDAO {

    /**
     * 根据名字查询分组
     * @param name 名字
     * @return 返回分组信息
     */
    public Category selectByName(String name);
    /**
     * 根据id查询分组
     * @param id id
     * @return 返回分组信息
     */
    public Category selectById(int id);
    /**
     * 插入新分组,插入后新分组id会返回到newCategory这个对象中
     * @param newCategory 新分组信息
     * @return 返回影响的sql条数
     */
    public int insert(Category newCategory);

}
