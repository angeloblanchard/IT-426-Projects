package singleton;

import java.util.HashMap;
import java.util.Map;

public class DBConnection3
{

    public static final int PORT = 2020;
    private String user;
    private String pass;
    private String host;
    private String dbName;
    private int port;
    private DBType dbType;

    @Override
    public String toString()
    {
        return "DBConnection3{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", host='" + host + '\'' +
                ", dbName='" + dbName + '\'' +
                ", port=" + port +
                ", dbType=" + dbType +
                '}';
    }

    // static singleton
    private static Map<DBType, DBConnection3> instances = new HashMap<>();

    // stop instantiation outside of this class
    private DBConnection3 (String user, String pass, String host, String dbName, int port, DBType dbType)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.dbName = dbName;
        this.port = port;
        this.dbType = dbType;
    }

    public static DBConnection3 getInstance(DBType dbType)
    {
        // precondition
        if (dbType == null)
        {
            return null;
        }
        if (!instances.containsKey(dbType))
        {
            instances.put(dbType, new DBConnection3("ablanchard3", "pass123", " ablanchard3@mail.greenriver.edu",
                    "movie", PORT, DBType.MYSQL));
        }

        return instances.get(dbType);
    }

    public Boolean connect()
    {
        // do something
        return false;
    }
}
