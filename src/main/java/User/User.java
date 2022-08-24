package User;

public class User {

    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Returns true if login details given equals self details
    public Boolean authenticateUser(String username, String password){
        if(this.username.equals(username) && this.password.equals(password)){
            // Correct Login Details
            return true;
        }
        else{
            // Wrong Login Details
            return false;
        }
    }

}
