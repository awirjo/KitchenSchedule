package sr.unasat.schedule.kitchen.dao;

import sr.unasat.schedule.kitchen.configuration.JPAConfig;
import sr.unasat.schedule.kitchen.entities.Menu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class MenuDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();

//    public MenuDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<Menu> retrieveMenuList() {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> menuList = query.getResultList();
        entityManager.getTransaction().commit();
        return menuList;
    }

    public Menu findByMealOfDay(String special_meals) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.special_meals = :special_meals";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("special_meals", special_meals).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByDinnerGroup(String dinner) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.dinner = :dinner";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("dinner", dinner).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForIct(String breakfast) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.breakfast = :breakfast";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("breakfast", breakfast).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForHrm(String lunch) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.lunch = :lunch";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("lunch", lunch).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForMining(String dinner) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.dinner = :dinner";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("dinner", dinner).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }

    public Menu insertMenu(Menu menu) {
        entityManager.getTransaction().begin();
        entityManager.persist(menu);
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu insertMenuChain(Menu menuChain) {
        entityManager.getTransaction().begin();
        entityManager.persist(menuChain);
        entityManager.getTransaction().commit();
        return menuChain;
    }

    public int updateMenu(Menu menu) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Menu m SET m.special_meals = :special_meals where m.description = :description");
        query.setParameter("special_meals", menu.getSpecial_meals());
        query.setParameter("description", menu.getDescription());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteMenu(String breakfast) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Menu m where m.breakfast = :breakfast");
        query.setParameter("breakfast", breakfast);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
