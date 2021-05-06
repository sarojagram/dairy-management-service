package com.agraminfotech.dairymanagement.vendorandCustomer;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.vendorandCustomer.dto.VendorAndCustomerDTO;
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
public class VendorAndCustomerDaoImpl implements VendorAndCustomerDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApiDTO> findAllActiveBasicInfoList(String accountType) {
        String queryString = "SELECT id,name FROM vendor_and_customer " +
                             "WHERE status=true AND deleted_status=false AND account_type=:accountType";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("accountType", accountType);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(ApiDTO.class))
                .getResultList();
    }

    @Override
    public List<VendorAndCustomerDTO> findAllDetailsInfoList(String accountType) {
        String queryString = "SELECT id,name,address,email,phone,mobile,account_type AS accountType,status " +
                             "FROM vendor_and_customer WHERE deleted_status=false AND account_type=:accountType";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("accountType", accountType);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(VendorAndCustomerDTO.class))
                .getResultList();
    }

    @Override
    public VendorAndCustomerDTO findDetailsInfoById(Long id) {
        String queryString = "SELECT v.id,v.name,v.address,v.email,v.phone,v.mobile,v.account_type AS accountType,v.status," +
                             "v.created_date AS createdDate,v.modified_date AS modifiedDate, " +
                             "(SELECT c.username FROM user AS c WHERE c.id=v.created_by_id) AS createdBy," +
                             "(SELECT m.username FROM user AS m WHERE m.id=v.modified_by_id) AS modifiedBy " +
                             " FROM vendor_and_customer AS v WHERE v.deleted_status=false AND v.id=:id";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("id", id);
        query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(VendorAndCustomerDTO.class));
        try{
            return (VendorAndCustomerDTO) query.getSingleResult();
        }catch(Exception e){
            return  null;
        }
    }
}
