package com.dpt.dt.dao.impl;

import com.dpt.dt.dao.BaseDao;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author 邓鹏涛
 * @date 2019/8/8 22:06
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class clazz;  // 用于接收运行期泛型类型
    protected String clazzName; // 类名
    protected String keyName; // 主键id
    protected String defaultOrderColum; // 默认排序列

    public abstract void setClazzName(String clazzName);

    public abstract void setKeyName(String keyName);

    public abstract void setDefaultOrderColum(String defaultOrderColum);

    public BaseDaoImpl() {
        // 获取当前类型的带有泛型的父类
        ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class)ptClass.getActualTypeArguments()[0];
    }

    public Serializable save(T o) {
        return currentSession().save(o);
    }

    public void update(T o) {
        currentSession().update(o);
    }

    public void saveOrUpdate(T o) {
        currentSession().saveOrUpdate(o);
    }

    public T merge(T o) {
        return (T)currentSession().merge(o);
    }

    public void deleteById(Serializable id) {
        T t = getById(id);
        currentSession().delete(t);
    }

    public void delete(T o) {
        currentSession().delete(o);
    }

    public Integer deleteBatch(Serializable[] ids) {
        Query query = currentSession().createQuery("delete from" + clazzName + "where " + keyName + "in (:ids)");
        return query.executeUpdate();
    }

    public Integer deleteBatch(List<Serializable> ids) {
        Query query = currentSession().createQuery("delete from" + clazzName + "where " + keyName + "in (:ids)");
        return query.executeUpdate();
    }

    public T getById(Serializable id) {
        return (T)currentSession().get(clazz, id);
    }

    public T get(String hql) {
        List<T> l = this.find(hql);
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    public T get(String hql, Object[] param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    public T get(String hql, List<Object> param) {
        return null;
    }

    public List<T> find(String hql) {
        return null;
    }

    public List<T> find(String hql, Object[] param) {
        return null;
    }

    public List<T> find(String hql, List<Object> param) {
        return null;
    }

    public List<T> find(String hql, Integer start, Integer rows) {
        return null;
    }

    public List<T> find(String hql, Object[] param, Integer start, Integer rows) {
        return null;
    }

    public List<T> find(String hql, List<Object> param, Integer start, Integer rows) {
        return null;
    }

    public List<T> find(Integer start, Integer rows) {
        return null;
    }

    public List<T> findAll() {
        return null;
    }

    public List<T> nativeFind(String sql) {
        return null;
    }

    public List<T> nativeFind(String sql, Map<String, Object> param) {
        return null;
    }

    public Object uniqueResult(String hql) {
        return null;
    }

    public Object uniqueResult(String hql, Object[] param) {
        return null;
    }

    public Object uniqueResult(String hql, List<Object> param) {
        return null;
    }

    public Object count() {
        return null;
    }

    public Integer executeHql(String hql) {
        return null;
    }

    public Integer executeHql(String hql, Object[] param) {
        return null;
    }

    public Integer executeHql(String hql, List<Object> param) {
        return null;
    }

    public Integer executeSql(String sql) {
        return null;
    }

    public Integer executeSql(String sql, Map<String, Object> param) {
        return null;
    }

    public ProcedureCall callProc(String name) {
        return null;
    }
}
