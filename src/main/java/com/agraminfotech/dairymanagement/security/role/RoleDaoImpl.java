package com.agraminfotech.dairymanagement.security.role;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements  RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApiDTO> findAllBasicInfo() {
        String queryString = "Select id As id,name AS name FROM role WHERE status=true";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(ApiDTO.class))
                .getResultList();
    }
}
