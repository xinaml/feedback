package dnn.service;

import com.mongodb.WriteResult;
import dnn.dto.BaseDto;
import dnn.common.exception.SerException;
import dnn.entity.BaseEntity;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;
import java.util.Map;

/**
 * Created by huanghuanlai on 16/9/3.
 */
public interface IService<Entity extends BaseEntity, Dto extends BaseDto> {

    /**
     * 查询所有数据
     *
     * @return
     */
    List<Entity> findAll()throws SerException ;

    /**
     * 查询分页数据
     *
     * @param dto
     * @return
     */
    List<Entity> findByPage(Dto dto)throws SerException ;


    /**
     * 查询第一个对象
     *
     * @param conditions
     * @return
     */
    Entity findOne(Map<String,Object> conditions) throws SerException ;


    /**
     * 自定义查询
     *
     * @param criteria
     * @return
     */
    List<Entity> findByCriteria(Criteria criteria) throws SerException ;


    /**
     * 查询数据量
     *@param dto
     * @return
     */
    Long count(Dto dto)throws SerException;

    /**
     * 查询某个对象
     *
     * @param id
     * @return
     */
    Entity findById(String id)throws SerException;


    /**
     * 查询符合某个条件对象
     *
     * @param field
     * param values
     * @return
     */
    List<Entity> findByIn(String field,List<String> values)throws SerException;

    /**
     * 保存对象
     *
     * @param entity
     */
    void save(Entity entity)throws SerException;

    /**
     * 保存对象列表
     * @param entities
     */
    void save(List<Entity> entities)throws SerException;

    /**
     * 通过id删除对象
     *
     * @param id
     */
    void remove(String id)throws SerException;

    /**
     * 删除对象
     *
     * @param entity
     */
    void remove(Entity entity)throws SerException;

    /**
     * 删除对象列表
     *
     * @param entities
     */
    void remove(List<Entity> entities);


    /**
     * 更新对象
     *
     * @param entity
     */
    void update(Entity entity)throws SerException;

    /**
     * 更新对象列表
     *
     * @param entities
     */
    void update(List<Entity> entities);

    /**
     * 根据字段条件查询对象列表
     *
     * @param conditions
     */
    List<Entity> findByCis(Map<String, Object> conditions)throws SerException;

    /**
     * 根据字段条件查询对象列表数量
     *
     * @param conditions
     */
    long countByCis(Map<String, Object> conditions)throws SerException;

    /**
     * 模糊条件查询对象列表(只支持字段属性是字符串的查询)throws SerException
     *
     * @param conditions
     */
    List<Entity> findByFuzzy(Map<String, Object> conditions)throws SerException ;

    /**
     * 更新符合条件对象列表
     * @param entity
     * @param conditions
     */
    void UpdateByCis(Entity entity,Map<String, Object> conditions)throws SerException ;

    /**
     * 删除符合条件对象列表
     * @param conditions
     */
    int removeByCis(Map<String, Object> conditions)throws SerException ;

    /**
     * 根据列 和条件查找最大值对象
     * @param fields
     */
    Entity findByMax(List<Object> fields,Map<String,Object> conditions)throws SerException ;

    /**
     * 根据列和条件查找最大值对象
     * @param fields
     */
    Entity findByMin(List<Object> fields,Map<String,Object> conditions)throws SerException ;

    /**
     * 更新某个特定字段
     * @param entities
     * @param key  更新的键
     * @param value 要更新的值
     * @return
     * @throws SerException
     */
    WriteResult UpdateByCis2(Entity entities, String key , Object value)throws SerException ;

}
