package sr.unasat.schedule.kitchen.dao;

import sr.unasat.schedule.kitchen.configuration.JPAConfig;
import sr.unasat.schedule.kitchen.entities.BreakTime;
import sr.unasat.schedule.kitchen.entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DepartmentDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();

//    public DepartmentDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<Department> retrieveDepartmentList() {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        List<Department> departmentList = query.getResultList();
        entityManager.getTransaction().commit();
        return departmentList;
    }

    public Department findByDepartment(String name) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  where d.name = :name";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        return department;
    }

    public Department insertDepartment(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        return department;
    }

    public int updateDepartment(Department department) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Department d SET d.name = :name where d.regular_break = :regular_break");
        query.setParameter("name", department.getName());
        query.setParameter("regular_break", department.getRegular_break());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteDepartmentBreak(String regular_break) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Department d where d.regular_break = :regular_break");
        query.setParameter("regular_break", regular_break);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public Department findByDepartmentEmployee(String employeeName) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  join d.employees em where em.firstName = :firstName";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("firstName", employeeName).getSingleResult();
        entityManager.getTransaction().commit();
        return department;
    }
    public boolean verifyDepartmentByEmployee(String employeeName) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  join d.employees em where em.firstName = :firstName";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("firstName", employeeName).getSingleResult();
        entityManager.getTransaction().commit();
        if(department != null){
            return true;
        }else{
            return false;
        }
    }

}
