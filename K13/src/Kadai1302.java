import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Kadai1302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// Set<Seiseki> hSet = new HashSet<>();
		Set<Seiseki> tSet = new TreeSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader("seiseki.txt"))) {
			String record;
			while ((record = br.readLine()) != null) {
				String[] items = record.split(",");

				Seiseki seiseki = new Seiseki(items[0], items[1], Integer.parseInt(items[2]));

				// hSet.add(seiseki);
				tSet.add(seiseki);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Seiseki s : tSet) {
			System.out.println(s.getBango() + "\t" + s.getName() + "\t" + s.getTen());
		}
	}

}
