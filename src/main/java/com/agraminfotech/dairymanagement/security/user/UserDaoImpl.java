package com.agraminfotech.dairymanagement.security.user;

import com.agraminfotech.dairymanagement.base.ApiDTO;
import com.agraminfotech.dairymanagement.security.user.dto.UserDTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApiDTO> findAllBasic() {
        String queryString = "SELECT id,first_name AS name FROM user WHERE enabled=true";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(ApiDTO.class))
                .getResultList();
    }

    @Override
    public List<UserDTO> findAllUserDetails() {
        String queryString = "SELECT id,first_name AS firstName,last_name AS lastName,middle_name AS middleName," +
                             "address,phone,email,username,mobile,enabled,birth_date As birthDate FROM user";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        return query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class))
                .getResultList();
    }

    @Override
    public UserDTO findUserDetailById(Long id) {
        String queryString = "SELECT id,first_name AS firstName,last_name AS lastName,middle_name AS middleName," +
                "address,phone,email,username,mobile,enabled,birth_date As birthDate FROM user WHERE id=:id";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);
        query.setParameter("id", id);
        query.unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class));
        try{
            return (UserDTO) query.getSingleResult();
        }catch(Exception e){
            return  null;
        }
    }

    @Override
    public boolean isRootUserAlreadyPresent() {
        String queryString = "select count(id) from user where created_by_id is null";

        Session session = entityManager.unwrap(Session.class).getSession();
        Query query = session.createSQLQuery(queryString);

        try{
            BigInteger total = (BigInteger) query.getSingleResult();
            if(total.equals(BigInteger.ZERO)) return false;
            else return true;
        }catch(Exception e){
            e.printStackTrace();
            return  true;
        }
    }
}
