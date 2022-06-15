package com.example.ss6.dao;

import com.example.ss6.entity.Brand;
import com.example.ss6.entity.Phone;
import com.example.ss6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BrandDAO {


    public void insertBrand(Brand product){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public List<Phone> findProductByBrand(int id) {
        Transaction transaction = null;
        List <Phone> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
//            NativeQuery query = session.createNativeQuery("select * from product where id = :pID", ProductEntity.class);
            Query query = session.createQuery("select c.phones from Brand c where c.id = :pID");
            query.setParameter("pID", id);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

//    public void updateCategory(ProductEntity product){
//        Transaction transaction = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(product);
//            transaction.commit();
//
//        }catch (Exception ex){
//            if(transaction != null){
//                transaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//    }
//    public void deleteCategory(int id){
//        Transaction transaction = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            ProductEntity product = session.get(ProductEntity.class, id);
//            if (product != null){
//                session.delete(product);
//            }
//            transaction.commit();
//        }catch (Exception ex){
//            if(transaction != null){
//                transaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//    }
//    public ProductEntity findCategory(int id){
//        Transaction transaction = null;
//        ProductEntity product = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            product = session.get(ProductEntity.class, id);
//            transaction.commit();
//        }catch (Exception ex){
//            if (transaction != null){
//                transaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        return product;
//    }
//
//    public List<ProductEntity> getCategory(){
//        Transaction transaction = null;
//        List<ProductEntity> listProduct = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createQuery("from ProductEntity");
//            listProduct = query.getResultList();
//            transaction.commit();
//        }catch (Exception ex){
//            if(transaction != null){
//                transaction.rollback();
//            }
//            ex.printStackTrace();
//        }
//        return listProduct;
//    }
}
