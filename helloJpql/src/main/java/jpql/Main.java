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
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(20);

//            Team team = new Team();
//            team.setName("team");
//
//            em.persist(team);
//            member.setTeam(team);

//            em.persist(member);

//            em.flush();
//            em.clear();

            Team team1 = em.createQuery("select t from Member m join m.team t", Team.class)
                    .getSingleResult();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
