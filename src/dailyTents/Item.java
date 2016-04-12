package dailyTents;

public class Item {
	public String type = "X";

	public Item() {
	}

	public Item(String type) {
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}
