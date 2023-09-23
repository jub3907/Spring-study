package jpql;

import jpql.domain.Member;
import jpql.domain.Team;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class Main {

    @Transactional
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();
        try {

            Team team1 = new Team();
            team1.setName("team1");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("team2");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(20);
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            member2.setTeam(team1);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(20);
            member3.setTeam(team2);
            em.persist(member3);


            Member member4 = new Member();
            member4.setUsername("member4");
            member4.setAge(20);
            em.persist(member4);

            em.flush();
            em.clear();

            Member singleResult = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();

            System.out.println("singleResult = " + singleResult);

            tx.commit();
        } catch (Exception e) {
            System.out.println("rollback");
            System.out.println("e = " + e);
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
