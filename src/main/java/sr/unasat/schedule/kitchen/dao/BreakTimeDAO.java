package sr.unasat.schedule.kitchen.dao;

import sr.unasat.schedule.kitchen.configuration.JPAConfig;
import sr.unasat.schedule.kitchen.entities.BreakTime;
import sr.unasat.schedule.kitchen.entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class BreakTimeDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();


//    public BreakTimeDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<BreakTime> retrieveBreakTimeList() {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }

    public BreakTime findByServingTime(String serving_time) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b  where b.serving_time = :serving_time";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        BreakTime breakTime = query.setParameter("serving_time", serving_time).getSingleResult();
        entityManager.getTransaction().commit();
        return breakTime;
    }

    public BreakTime insertBreakTime(BreakTime breakTime) {
        entityManager.getTransaction().begin();
        entityManager.persist(breakTime);
        entityManager.getTransaction().commit();
        return breakTime;
    }

    public int updateBreakTime(BreakTime breakTime) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE BreakTime b SET b.serving_time = :serving_time where b.serving_date = :serving_date");
        query.setParameter("serving_time", breakTime.getServing_time());
        query.setParameter("serving_date", breakTime.getServing_date());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteBreakTimeMeal(String serving_time) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from BreakTime b where b.serving_time = :serving_time");
        query.setParameter("serving_time", serving_time);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    public List<BreakTime> findBreakTimeByDepartment(Department departmentFind) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b  where b.department = :department";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("department", departmentFind).getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }

}
