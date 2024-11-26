import activeRecord.DBConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class TestDBConnection {
    @Test
    public void test(){
        Connection connect1 = DBConnection.getConnection();
        Connection connect2 = DBConnection.getConnection();
        assertEquals(connect1, connect2);
        assertInstanceOf(Connection.class, connect1);
        DBConnection.setNomDB("test");
        connect1 = DBConnection.getConnection();
        assertNotSame(connect1, connect2);
    }
}
