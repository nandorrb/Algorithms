/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FnzSecondRoundTest {

    static class Person {
        String name;
        String surname;
        String nationality;

        public Person(String name,
                      String surname,
                      String nationality) {
            this.name = name;
            this.surname = surname;
            this.nationality = nationality;
        }

    }

    public static void main(String[] args) {

        Person person1 = new Person("Name1", "Surname1", "Italy");
        Person person2 = new Person("Name2", "Surname2", "Germany");
        Person person3 = new Person("Name3", "Surname3", "Germany");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        // V1
        personList.sort(
                (personA, personB) ->
                        personA.name.compareToIgnoreCase(personB.name)
        );

        // V2
        // personList.sort(Comparator.comparing(person -> person.name, String.CASE_INSENSITIVE_ORDER));


        Map<String, Integer> result = new HashMap<>();
        for (Person person : personList) {
            if (result.containsKey(person.nationality)) {
                result.put(person.nationality, result.get(person.nationality) + 1);
            }
            else {
                result.put(person.nationality, 1);
            }
        }

        // Print most common Nationality
        System.out.println(
                result.entrySet().stream().max(
                        (a, b) ->
                                a.getValue().compareTo(b.getValue())
                ).get().getKey()
        );

    }
}
