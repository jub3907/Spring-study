package hellojpa;

import hellojpa.embeded.Address;
import hellojpa.parent.Child;
import hellojpa.parent.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public class JpaMain {

    @Transactional
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1", "street", "zipcode"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new Address("old1", "street", "zipcode"));
            member.getAddressHistory().add(new Address("old2", "street", "zipcode"));

            em.persist(member);

            em.flush();
            em.clear();

            // 값 타입 조회
            Member member1 = em.find(Member.class, member.getId());
            Set<String> favoriteFoods = member1.getFavoriteFoods();
            List<Address> addressHistory = member1.getAddressHistory();

            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

            for (Address address : addressHistory) {
                System.out.println("address = " + address);
            }

            // 값 타입 수정
            // 치킨 -> 한식
            member1.getFavoriteFoods().remove("치킨");
            member1.getFavoriteFoods().add("한식");

            member1.getAddressHistory().remove(new Address("old1", "street", "zipcode"));
            member1.getAddressHistory().add(new Address("new_old_City", "street", "zipcode"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
