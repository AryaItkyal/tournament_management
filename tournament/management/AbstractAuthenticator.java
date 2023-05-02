import java.sql.Connection;

public abstract class AbstractAuthenticator {

    protected final Connection connection;

    public AbstractAuthenticator(Connection connection) {
        this.connection = connection;
    }

    public abstract void authenticate(String username, String password) throws AuthenticationException;

}

