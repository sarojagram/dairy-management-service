package com.agraminfotech.dairymanagement.product.attribute;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.product.attribute.dto.AttributeDTO;
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
public class AttributeDaoImpl implements AttributeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApiDTO> findAllBasic() {
        String queryString = "SELECT id,name AS name FROM attribute WHERE status=1";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(ApiDTO.class))
                .getResultList();
    }

    @Override
    public List<AttributeDTO> findAttributeInfo() {
        String queryString = "SELECT a.id AS id,a.name AS name, a.value AS value, a.remarks AS remarks,a.created_date AS createdDate,a.modified_date AS modifiedDate,u.username AS modifiedBy, u.username AS createdBy FROM USER u,attribute a WHERE u.id=a.created_by_id";
        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(AttributeDTO.class))
                .getResultList();
    }
}
