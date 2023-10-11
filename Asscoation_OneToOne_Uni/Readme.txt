@MapsId is an annotation in JPA (Java Persistence API) that is used to indicate a shared primary key association between two entities in a one-to-one relationship. It allows one entity to share its primary key with another entity, effectively linking them through their primary key values. This is often used when one entity is an extension of another or when two entities share a common key.

@Entity
public class PersonDetails {
    @Id
    private Long id;  No @GeneratedValue, as it shares the id with Person
    private String address;
    private String phoneNumber;
    Constructors, getters, setters, etc.
}

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @MapsId  Indicates that id is shared with PersonDetails
    private PersonDetails details;
    Constructors, getters, setters, etc.
}


https://studygyaan.com/spring-boot/one-to-one-relationship-in-jpa#foreign-key
