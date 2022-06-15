package com.example.ss6.dao;

import com.example.ss6.entity.Phone;
import com.example.ss6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PhoneDAO {


    public void insertPhone(Phone phone){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updatePhone(Phone phone){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(phone);
            transaction.commit();

        }catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public void deletePhone(int id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            if (phone != null){
                session.delete(phone);
            }
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public Phone findPhone(int id){
        Transaction transaction = null;
        Phone phone = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            phone = session.get(Phone.class, id);
            transaction.commit();
        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return phone;
    }


    public List<Phone> getPhone() {
        Transaction transaction = null;
        List <Phone> listPhone = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
//            NativeQuery query = session.createNativeQuery("select * from product where id = :pID", ProductEntity.class);
//            Query query = session.createQuery("from ProductEntity p where p.id = :pID");
//            query.setParameter("pID", 1);
            Query query = session.createQuery("from Phone");
            listPhone = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listPhone;
    }
}
