import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by stefletcher on 08/07/2016.
 */
public class MongoDbConnector {
    public void listDatabaseNames() {
        // To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
        // if it's a member of a replica set:

        MongoClient mongoClient = new MongoClient( "localhost" , 32771 );

        for (String s : mongoClient.listDatabaseNames()) {
            System.out.println("#### "+s);
        }
    }
}
