public class Person implements Comparable<Person> {
	private String name;
	private String type;

	public Person(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;

		if (obj instanceof Person) {
			Person person = (Person) obj;
			if (name.equals(person.name) && type.equals(person.type)) {
				ret = true;
			}
		}

		return ret;
	}

	@Override
	public String toString() {
		return String.format("Name=%s, Type=%s", name, type);
	}

	@Override
	public int compareTo(Person o) {
		return (name + type).compareTo(o.name + o.type);
	}

	@Override
	public int hashCode() {
		return (name + type).hashCode();
	}
}
