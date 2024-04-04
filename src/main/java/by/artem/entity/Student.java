package by.artem.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;
}
