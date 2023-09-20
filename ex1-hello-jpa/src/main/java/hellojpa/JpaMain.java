package hellojpa;

import hellojpa.parent.Child;
import hellojpa.parent.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

public class JpaMain {

    @Transactional
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();
        try {
            Child child1 = new Child();
            Child child2 = new Child();

            child1.setName("child1");
            child2.setName("child2");

            Parent parent = new Parent();
            parent.setName("parent");
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            Parent parent1 = em.find(Parent.class, parent.getId());
            parent1.getChildList().remove(0);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
