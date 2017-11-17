package singleton;

public class DBConnection2
{
    public static final int PORT = 2020;
    private String user;
    private String pass;
    private String host;
    private String dbName;
    private int port;

    // static singleton
    private static DBConnection2 instance;

    @Override
    public String toString()
    {
        return "DBConnection2{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", host='" + host + '\'' +
                ", dbName='" + dbName + '\'' +
                ", port=" + port +
                '}';
    }

    // stop instantiation outside of this class
    private DBConnection2 (String user, String pass, String host, String dbName, int port)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.dbName = dbName;
        this.port = port;
    }

    public static DBConnection2 getInstance()
    {
        // lazy initialization
        // use the double checked locking pattern (avoid this)
        // instead use synchronization on the entire method
        if (instance == null)
        {
            synchronized (DBConnection2.class)
            {
                if (instance == null)
                {
                    instance = new DBConnection2("ablanchard3", "pass123", " ablanchard3@mail.greenriver.edu",
                            "movie", PORT);
                }
            }
        }

        return instance;
    }

    public Boolean connect()
    {
        // do something
        return false;
    }
}
