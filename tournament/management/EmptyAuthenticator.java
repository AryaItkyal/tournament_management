import java.sql.*;

public class EmptyAuthenticator extends AbstractAuthenticator {

    public EmptyAuthenticator(Connection connection) {
        super(connection);
    }

    @Override
    public void authenticate(String username, String password) throws AuthenticationException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new AuthenticationException("Empty username or password.");
        } else {
            // Authentication successful
        }
    }

}