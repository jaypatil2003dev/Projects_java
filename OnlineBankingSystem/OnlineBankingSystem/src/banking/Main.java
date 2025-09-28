package banking;

public class Main {
	public static void main(String[] args) {
		UserService userService = new UserService();
		
		// Create a new user account
		userService.createUser("John Doe", "john@example.com", 5000.0);
		
		// check balance
		
		userService.viewBalance("john@example.com");
	}

}
