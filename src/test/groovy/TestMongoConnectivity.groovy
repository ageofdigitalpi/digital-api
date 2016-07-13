import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import static com.mongodb.client.model.Filters.*;
import spock.lang.Specification

/**
 * Created by stefletcher on 08/07/2016.
 */
class TestMongoConnectivity extends Specification{
    MongoClient mongoClient
    MongoCollection<Document> collection
    def setup(){
        mongoClient = new MongoClient( "localhost" , 27017 );
    }
    def "test connect" () {
        given: "we are connected to a local database"
            assert mongoClient != null
            mongoClient.listDatabaseNames().each { println it }

        when: "a document is inserted into a new collection"
            MongoDatabase database = mongoClient.getDatabase("myDb")
            collection = database.getCollection("test")

            Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));

            collection.insertOne(doc)

        then: "we can find it again"
            Document myDoc = collection.find(eq("name", "MongoDB")).first()

            assert(myDoc.get("type").toString() == "database")
    }
}
