import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PersonTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Person> hSet = new HashSet<>();
		Set<Person> lSet = new LinkedHashSet<>();
		Set<Person> tSet = new TreeSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader("person.txt"))) {
			String record;
			while ((record = br.readLine()) != null) {
				String[] items = record.split(",");
				Person person = new Person(items[0], items[1]);

				hSet.add(person);
				lSet.add(person);
				tSet.add(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("-- Print HashSet --");
		for (Person p : hSet) {
			System.out.println(p.toString());
		}

		System.out.println();
		System.out.println("-- Print LinkedHashSet --");
		for (Person p : lSet) {
			System.out.println(p.toString());
		}

		System.out.println();
		System.out.println("-- Print TreeSet --");
		for (Person p : tSet) {
			System.out.println(p.toString());
		}

		System.out.println();
		System.out.print("Name --> ");
		String name = sc.next();

		System.out.print("Type --> ");
		String type = sc.next();

		Person person = new Person(name, type);

		boolean result = hSet.contains(person);

		System.out.println();
		if (result) {
			System.out.println(person.toString() + "  Contain");
		} else {
			System.out.println(person.toString() + "  Not Contain");
		}

		result = hSet.add(person);

		System.out.println();
		if (!result) {
			System.out.println("Error : " + person.toString() + "  Exist");
		}
		System.out.println("-- Print HashSet --");
		for (Person p : hSet) {
			System.out.println(p.toString());
		}

	}
}
