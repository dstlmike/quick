package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
//String DB_URI = process.env.URI;
//String DB_Collection = process.env.DB_Collection;
//String DB_DataBase = process.env.SampleDB;
public class Connection {

    public static void main(String[] args) {
        String connectionString = System.getProperty(process.env.URI); //"mongodb+srv://gmgm:113hopest@cluster89278.oitd2c5.mongodb.net/sampledb?retryWrites=true&w=majority");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}
