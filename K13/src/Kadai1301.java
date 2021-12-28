import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Kadai1301 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new LinkedHashSet<>();

		String cont = "Yes";
		while (!cont.equals("No")) {
			System.out.print("String -->");
			set.add(sc.next());

			System.out.print("Continue-->");
			cont = sc.next();
		}

		System.out.print("File Name-->");
		String name = sc.next();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {

			for (String s : set) {
				bw.write(s);
				bw.flush();
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
