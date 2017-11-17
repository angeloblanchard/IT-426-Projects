package singleton;

public class DBConnection
{
    public static final int PORT = 2020;
    private String user;
    private String pass;
    private String host;
    private String dbName;
    private int port;

    // static singleton
    private static DBConnection instance;

    @Override
    public String toString()
    {
        return "DBConnection{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", host='" + host + '\'' +
                ", dbName='" + dbName + '\'' +
                ", port=" + port +
                '}';
    }

    // stop instantiation outside of this class
    private DBConnection (String user, String pass, String host, String dbName, int port)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.dbName = dbName;
        this.port = port;
    }

    public static DBConnection getInstance()
    {
        // lazy initialization
        if (instance == null)
        {
            instance = new DBConnection("ablanchard3", "pass123", " ablanchard3@mail.greenriver.edu",
                    "movie", PORT);
        }

        return instance;
    }

    public Boolean connect()
    {
        // do something
        return false;
    }
}
