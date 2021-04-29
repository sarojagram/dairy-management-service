package com.agraminfotech.dairymanagement.security.setting;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
@Transactional
public class SettingDaoImpl implements SettingDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public SettingDTO findBasicByUserId(Long userId) {
        String queryString = "select id as id,operation_date_setting as operationDateSetting from tbl_setting where user_id=:userId";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("userId",userId);
        query.unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.aliasToBean(SettingDTO.class));

        return (SettingDTO) query.getSingleResult();
    }

    @Override
    public String getUserOperationDateSetting(Long userId) {
        String queryString = "select operation_date_setting as operationDateSetting from tbl_setting where user_id=:userId";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("userId",userId);
        query.unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.aliasToBean(SettingDTO.class));
        try{
            return (String) query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean isUserSettingAlreadyPresent(Long userId) {
        String queryString = "select count(id) from tbl_user where user_id=:userId";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("userId",userId);
        BigInteger total = (BigInteger) query.getSingleResult();
        if(total != null && total.compareTo(BigInteger.ZERO) > 0) return true;

        return false;
    }

    @Override
    public Long getUserSettingIdByUserId(Long userId) {
        String queryString = "select id from tbl_user where user_id=:userId";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("userId",userId);
        try{
            BigInteger id = (BigInteger) query.getSingleResult();
            return id.longValue();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
