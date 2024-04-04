package by.artem.entity;

import by.artem.util.HibernateUtil;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class CourseTrainerTest {

    @Test
    public void addTreinerCourse() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Trainer trainer = Trainer.builder()
                    .name("Andrei")
                    .build();

            var course = session.get(Course.class, 1);



            trainer.addCourse(course);
            session.save(trainer);
            System.out.println(trainer.getCourses());
            session.getTransaction().commit();
        }
    }
}
