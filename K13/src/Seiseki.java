public class Seiseki implements Comparable<Seiseki> {
	private String bango;
	private String name;
	private int ten;

	public Seiseki(String bango, String name, int ten) {
		this.bango = bango;
		this.name = name;
		this.ten = ten;
	}

	public String getBango() {
		return bango;
	}

	public String getName() {
		return name;
	}

	public int getTen() {
		return ten;
	}

	public int compareTo(Seiseki o) {
		int ret = 1;
		if (this.ten == o.ten) {
			ret = 0;

		} else if (this.ten < o.ten) {
			ret = -1;
		}
		return ret;
	}

}
