import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Kadai1303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1:Load Goods");
		System.out.println("2:Save Goods");
		System.out.println("3:Add Goods");
		System.out.println("4:Print All Goods");
		System.out.println("9:End");
		int choice = 0;
		Set<Goods> hset = new HashSet<Goods>();

		while (choice != 9) {
			System.out.print("Choice-->");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("FileName-->");
				String filename = sc.next();
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {

					String line;
					while ((line = reader.readLine()) != null) {
						String[] fields = line.split(",");
						String code = fields[0];
						String name = fields[1];
						int price = Integer.parseInt(fields[2]);
						Goods good = new Goods(code, name, price);
						hset.add(good);

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 2) {
				List<Goods> list = new ArrayList<Goods>();
				list.addAll(hset);
				list.sort(new Comparator<Goods>() {
					@Override
					public int compare(Goods o1, Goods o2) {
						// TODO Auto-generated method stub
						return o1.getGoodsCode().compareToIgnoreCase(o2.getGoodsCode());
					}
				});
				System.out.print("FileName-->");
				String filename = sc.next();
				try (BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(filename)))) {
					for (int i = 0; i < list.size(); i++) {
						writer.write(list.get(i).getGoodsCode() + "," + list.get(i).getGoodsName() + ","
								+ list.get(i).getPrice());
						writer.flush();
						writer.newLine();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 3) {
				System.out.print("GoodsCode-->");
				String code = sc.next();
				System.out.print("GoodsName-->");
				String name = sc.next();
				System.out.print("Price-->");
				int price = sc.nextInt();
				Goods good = new Goods(code, name, price);
				boolean result = hset.contains(good);

				System.out.println();
				if (result) {
					System.out.println("Error : Goods  Exist");
				} else {
					hset.add(good);
				}
			}
			if (choice == 4) {
				List<Goods> list = new ArrayList<Goods>();
				list.addAll(hset);
				list.sort(new Comparator<Goods>() {
					@Override
					public int compare(Goods o1, Goods o2) {

						return o1.getGoodsCode().compareToIgnoreCase(o2.getGoodsCode());
					}
				});
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getGoodsCode() + "," + list.get(i).getGoodsName() + ","
							+ list.get(i).getPrice());
				}
			}

		}

	}

}
