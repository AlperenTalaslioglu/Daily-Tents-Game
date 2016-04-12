package dailyTents;

public class Tent extends Item {
	private Tree treeOfTent;
	private boolean isFound = false;

	public Tent() {
		super("T");
	}

	public Tree getTreeOfTent() {
		return treeOfTent;
	}

	public boolean hasNotTree() {
		return treeOfTent == null;
	}

	public void setTreeToTent(Tree tree) {
		if (tree == null) {
			throw new NullPointerException();
		}
		this.treeOfTent = tree;
	}

	public boolean isTentFound() {
		return isFound;
	}

	public void setFoundTent() {
		this.isFound = true;
	}

	@Override
	public String toString() {
		return "T";
	}
}
