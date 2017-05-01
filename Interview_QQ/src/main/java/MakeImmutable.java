import java.util.ArrayList;
import java.util.List;

public final class MakeImmutable {
	
	private final String name;
	private final List<String> accounts;
	
	public MakeImmutable(String name, List<String> accounts) {
		this.name = name;
		List<String> ac = new ArrayList<String>();
		ac.addAll(accounts);
		this.accounts = ac;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getAccounts() {
		List<String> accountCopy = new ArrayList<String>();
		accountCopy.addAll(accounts);
		return accountCopy;
	}

}
