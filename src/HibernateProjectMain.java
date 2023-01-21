import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.graph.Graph;
import org.hibernate.query.Query;

import javax.persistence.EntityGraph;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HibernateProjectMain {

    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(Customer.class).addAnnotatedClass(Student.class).addAnnotatedClass(Book.class)
            .addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).buildSessionFactory();
    public static void main(String[] args) throws InterruptedException {
        Session session = sessionFactory.openSession();
        System.out.println("test");
        session.beginTransaction();
        List<Address> addresses = new ArrayList<>();
        Person person = new Person(1,"John");
        addresses.add(new Address(1,"Toronto"));
        addresses.add(new Address(2,"Calgary"));
        addresses.add(new Address(3,"Moncton"));
        Person person2 = new Person(2,"Mat");
        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(new Address(5,"Colombo"));
        addresses1.add(new Address(6,"Delhi"));
        addresses1.add(new Address(7,"Chicago"));
        addresses1.add(new Address(8,"Dubai"));
        Person person3 = new Person(3,"Tom");
        person.setAddress(addresses);
        session.save(person);
        person2.setAddress(addresses1);
        session.save(person2);
        session.save(person3);
        System.out.println("hi");

        session.getTransaction().commit();
        session.clear();
        //Where clause can be added after p.addresses if need be
        //No need to provide the join columns as in join
        //from Person p join fetch p.addresses on p.id = p.addresses.per_id
        //The above is not possible since p.addresses is a list which has no per_id.
        Query query = session.createQuery("from Person p");
        List<Person> personList = query.getResultList();
        personList.stream().forEach(p -> {
//            System.out.print(p.getName() + " : ");
            p.getAddress().stream().forEach(a -> System.out.print(a.getName() +" , "));
            System.out.println();
        });
        session.clear();
        Query query1 = session.createQuery("from Person p");
        List<Person> personList1 = query1.getResultList();
        personList1.get(0).getAddress().get(0).getName();

//        System.out.println(1);
//        Query query = session.createQuery("from Person");
//        EntityGraph<Person> personEntityGraph = session.createEntityGraph(Person.class);
//        personEntityGraph.addAttributeNodes("addresses");
//        personEntityGraph.addSubgraph("books").addAttributeNodes("authors");
//        query.setHint("javax.persistence.fetchgraph",personEntityGraph);
////        System.out.println(2);
//        List<Person> personList = query.getResultList();
////        System.out.println(3);
//        for (Person p : personList){
////            System.out.println(4);
//            System.out.println(p.getAddress());
//        }
//        Query query = session.createSQLQuery("select p.name,a.name as city_name from Person p inner join Address a on p.id=a.per_id and a.name like '%o'");
//        List<Object[]> list = query.getResultList();
//        for (Object[] objects : list){
//            System.out.print(objects[0]+ " : ");
//            System.out.println(objects[1]);
//        }

//        System.out.println(2);
//        System.out.println(person1.getName());
//        System.out.println(3);
//        System.out.println(person1.getAddress());
//        System.out.println(4);
//        session.clear();

//        Customer customer = new Customer("aa"+System.currentTimeMillis(), Date.valueOf("2020-11-12"));
//        session.remove(customer);
//        System.out.println(1);
//        Student student = new Student("john","peter",Date.valueOf("2019-12-15"));
//        session.remove(student);
//        System.out.println(4);
//        session.save(student);
//        System.out.println(2);
//        System.out.println(3);
//        session.getTransaction().commit();
//        System.out.println(student.getId());
//        Book book = new Book(101,"Mahabharat");
//        System.out.println(10);
//        Book book4 = session.find(Book.class,101);
//        session.saveOrUpdate(book);
//        System.out.println(session.contains(book));
//        System.out.println(11);
//        session.getTransaction().commit();
//        session.close();
//        Book book1 = session.find(Book.class,101);
//        session.detach(book1);
//        book1.setName("Ramayana");
//        Book book2 = session.find(Book.class,101);
//        System.out.println(book2.getName());
//        session.update(book1);
//        System.out.println(session.contains(book1)+ " "+book1.getName());
//        System.out.println(session.contains(book2) + " "+ book2.getName());
//        session.flush();
//        session.close();
//        System.out.println(session.contains(book));
//        session.remove(book);
//        System.out.println(session.contains(book));
//        session.getTransaction().commit();
//        session.close();
//        Book book5 = session.find(Book.class,101);
//        session.detach(book5);
//        book5.setId(103);
//        session.update(book5);
//        System.out.println(session.contains(book5));
//        System.out.println(11);
//        session.getTransaction().commit();
//        session.close();
//        Query<Student> studentQuery = session.createQuery("from Student s where s.join_date=?2",Student.class);
//        studentQuery.setParameter(2,Date.valueOf("1995-08-15"));
//        System.out.println(studentQuery.getResultList());

//        studentQuery = session.createQuery("update Student s set s.first_name=?1 where s.last_name=?2");
//        studentQuery.setParameter(1,"Mat");
//        studentQuery.setParameter(2,"Peter");
//        int rownum = studentQuery.executeUpdate();
//        System.out.println(rownum);
//        Student student = session.find(Student.class,53);
//        System.out.println(student.getFirst_name());
////        session.detach(student);
//        student.setFirst_name("Shing");
//        Student student1 = new Student(57,"Ind","Pat",Date.valueOf("2022-10-15"));
//        session.merge(student1);
//        System.out.println("before commit");
//        session.getTransaction().commit();
//        System.out.println(session.contains(student1));
//        session.close();
//        Customer customer = new Customer(Long.valueOf(100),"customer1",Date.valueOf("2022-11-15"));
//        Long id = (Long) session.save(customer);
//        System.out.println(id);
//        Customer customer1 = new Customer(id,"customer2",Date.valueOf("2022-11-15"));
//        session.saveOrUpdate(customer1);
//        session.getTransaction().commit();
//        session.close();
//        Book book = new Book(50,"Triassic");
//        session.saveOrUpdate(book);
//        Book book1 = new Book (100, "Jur");
//        session.merge(book1);
//        System.out.println("Jur");
//        Customer customer = new Customer(Long.valueOf(20),"test4",Date.valueOf("2022-11-15"));
//        System.out.println(1);
//        session.merge(customer);
//        System.out.println(2);
//        session.flush();
//        session.close();


//        Book book = session.find(Book.class, 100);
//        session.detach(book);
//        System.out.println(book.getName());
//        book.setName("Jurassic");
//        System.out.println(5);
//        session.saveOrUpdate(book);
//        session.getTransaction().commit();
//        session.close();
//        Book book = new Book(104,"Ramayana");
//        System.out.println(1);
//        session.save(book);
//        Book book1 = new Book(104,"Mahabharata");
//        session.merge(book1);
//        System.out.println(2);
//        session.getTransaction().commit();
//        System.out.println(3);
//        session.close();
//        sessionFactory.close();
//        Customer customer =  new Customer(65L,"test",Date.valueOf("1985-10-25"));
//        session.saveOrUpdate(customer);
//        session.getTransaction().commit();
//        session.close();
//        Book book = new Book(100,"Harry Potter");
//        session.save(book);
//        System.out.println(session.contains(book));
//        session.detach(book);
//        System.out.println(session.contains(book));
//        session.getTransaction().commit();
//        session.close();

//        session.clear();
//        session.beginTransaction();
//        book = session.get(Book.class, 100);
//        session.remove(book);
//        System.out.println(session.contains(book));
//        Thread.sleep(30000);
//        session.getTransaction().commit();



    }
}
