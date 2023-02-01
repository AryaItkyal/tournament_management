import java.sql.*;

public class NormalAuthenticator extends AbstractAuthenticator {

    public NormalAuthenticator(Connection connection) {
        super(connection);
    }

    @Override
    public void authenticate(String username, String password) throws AuthenticationException {
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, password FROM user WHERE username = '" + username + "'");

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (password.length() < 4) {
                    throw new AuthenticationException("Password is too short.");
                }
                if (storedPassword.equals(password)) {
                    // Authentication successful
                } else {
                    throw new AuthenticationException("Incorrect password.");
                }
            } else {
                throw new AuthenticationException("User does not exist.");
            }

        } catch (SQLException ex) {
            throw new AuthenticationException("Error occurred while authenticating user.");
        }

    }

}
