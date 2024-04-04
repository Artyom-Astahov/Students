package by.artem.entity;

import by.artem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void updateCourse() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var course = session.get(Course.class, 1);
            course.setTitle("Java Enterprise 2.0");
            session.update(course);
            session.getTransaction().commit();
        }
    }

    @Test
    public void deleteCourse() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var course = session.get(Course.class, 1);
            session.delete(course);
            session.getTransaction().commit();
        }
    }

    @Test
    public void addStudentForCourse() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            var course = session.get(Course.class, 10);

            Student egor = Student.builder()
                    .name("Egor")
                    .build();
            session.save(egor);

            egor.setCourse(course);

            session.save(egor);


            session.getTransaction().commit();
        }
    }


    @Test
    public void deleteStudentScoreBelow6() {
        Course course = Course.builder()
                .title("Java Enterprise")
                .build();

        Student tanya = Student.builder()
                .name("Tanya")
                .build();

        Student artem = Student.builder()
                .name("Artem")
                .build();

        Student ivan = Student.builder()
                .name("Ivan")
                .build();

        Student petya = Student.builder()
                .name("Petya")
                .build();

        Student igor = Student.builder()
                .name("Igor")
                .build();
        Student slava = Student.builder()
                .name("Slava")
                .build();

        StudentProfile profileTanya = StudentProfile.builder()
                .score(6)
                .build();
        StudentProfile profileArtem = StudentProfile.builder()
                .score(9)
                .build();
        StudentProfile profileIvan = StudentProfile.builder()
                .score(7)
                .build();
        StudentProfile profilePetya = StudentProfile.builder()
                .score(8)
                .build();
        StudentProfile profileIgor = StudentProfile.builder()
                .score(3)
                .build();
        StudentProfile profileSlava = StudentProfile.builder()
                .score(2)
                .build();


        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//            session.save(course);
//
//            tanya.setCourse(course);
//            artem.setCourse(course);
//            ivan.setCourse(course);
//            petya.setCourse(course);
//            igor.setCourse(course);
//            slava.setCourse(course);
//
//            session.save(tanya);
//            session.save(artem);
//            session.save(ivan);
//            session.save(petya);
//            session.save(igor);
//            session.save(slava);
//
//            profileTanya.setStudent(tanya);
//            profileArtem.setStudent(artem);
//            profileIvan.setStudent(ivan);
//            profilePetya.setStudent(petya);
//            profileIgor.setStudent(igor);
//            profileSlava.setStudent(slava);


            session.get(Course.class, 1)
                    .getStudents()
                    .removeIf(student -> student.getStudentProfile().getScore() < 6);

            session.getTransaction().commit();

        }

    }
}
