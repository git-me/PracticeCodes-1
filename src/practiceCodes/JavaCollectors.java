import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaCollectors {

    public static void main(String[] args) {

        Person p1=new Person("1","A","India", 2200);
        Person p2=new Person("2","B","India", 3411);
        Person p3=new Person("3","C","germany",4353);
        Person p4=new Person("4","D","usa",2311);
        Person p5=new Person("5","E","israel",3456);
        Person p6=new Person("6","F","usa",2334);
        Person p7=new Person("7","G","germany",5032);
        Person p8=new Person("8","H","israel",432);
        Person p9=new Person("9","I","usa",5462);
       final  List<Person> ls=new ArrayList<>();
        ls.add(p1);
        ls.add(p2);
        ls.add(p3);
        ls.add(p4);
        ls.add(p5);
        ls.add(p6);
        ls.add(p7);
        ls.add(p8);
        ls.add(p9);
        System.out.println(" --------------------------------------------------------------------------------------------------");
       System.out.println("printing person");
        ls.stream().forEachOrdered((Person p)->System.out.println(p));
        System.out.println(" --------------------------------------------------------------------------------------------------");
        ls.forEach(System.out::println);
        System.out.println(" -----------------------------------------using filter---------------------------------------------------------");
        List<Person> listOfFilteredSalary=ls.stream().filter(p->!(p.getCountry().equals("usa"))).collect(Collectors.toList());
        listOfFilteredSalary.forEach(System.out::println);
        System.out.println(" -------------------------------------------||||-------------------------------------------------------");
        System.out.println("printing using groupby country");
        Map<String, List<Person>> temp =ls.stream().collect(Collectors.groupingBy(Person :: getCountry));
       System.out.println(temp);
        System.out.println(" --------------------------------------------------------------------------------------------------");
        temp.entrySet().forEach(entry->{System.out.println("key :  "+ entry.getKey() + "    value :  " + entry.getValue());});
        System.out.println(" --------------------------------------------------------------------------------------------------");
       System.out.println("using partitioningBy");
        Map<Boolean, List<Person>> temp2 =ls.stream().collect(Collectors.partitioningBy((Person p)->p.getCountry().equalsIgnoreCase("usa")));
        System.out.println(" --------------------------------------------------------------------------------------------------");
        temp2.entrySet().forEach(e->{System.out.println("Key: "+ e.getKey() + "value: "+ e.getValue());});
        System.out.println(" --------------------------------------------------------------------------------------------------");

        System.out.println(temp2);
        System.out.println(" --------------------------------------------------------------------------------------------------");

        System.out.println("conveting list of persons to map with key value as (getCountry,getName)");
        Map<String, String> temp3=ls.stream().collect(Collectors.toMap(Person::getCountry,Person::getName,(older,newValue)->older));
        System.out.println(temp3);
        System.out.println(" --------------------------------------------------------------------------------------------------");
        System.out.println("conveting list of persons to map with key value as (getId,getCountry)");
        Map<String, String> temp4=ls.stream().collect(Collectors.toMap(Person::getId,Person::getCountry));
        System.out.println(" --------------------------------------------------------------------------------------------------");
        temp4.forEach((k,u)->System.out.println("key : "+k+"   "+"value : "+u));

        //collecting the name in a list
       List<String> listOfId = ls.stream().map(Person::getName).collect(Collectors.toList());
       System.out.println(listOfId);
       // sorting the country name based on the treeset default comparator
        Set<String> sortedCountryName =ls.stream().map(Person::getCountry).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(" --------------------------------------------------------------------------------------------------");
        System.out.println(sortedCountryName);
        //grouping  by country and calculating the salary
        Map<String, Integer> salryByCountry=ls.stream().collect(Collectors.groupingBy(Person::getCountry,Collectors.summingInt(Person::getSalary)));
      System.out.println(salryByCountry);
        //even salry of person object
       List<Person> evenSalary = ls.stream().collect(Collectors.filtering((Person p)->p.getSalary()%2==0,Collectors.toList()));
       System.out.println(evenSalary);
       //using compareTo which return Optional object of type person with max salary
       Optional<Person>lst= ls.stream().max(Person::compareTo);
       System.out.println(lst);
    }

}
class Person implements Comparable<Person>{

   private String Id;
    private String name;
   private String country;
    private Integer salary;

    public Integer getSalary() {
        return salary;
    }



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person(String id, String name, String country, Integer salary) {
        Id = id;
        this.name = name;
        this.country = country;
        this.salary=salary;

    }

    @Override
    public String toString() {
        return "Person{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return getSalary().compareTo(person.getSalary());
    }
}