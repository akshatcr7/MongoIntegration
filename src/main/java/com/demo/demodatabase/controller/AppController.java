package com.demo.demodatabase.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    /**
     * Configuration of the MongoDB Setup
     */
    public void mongoSetup() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("employees");
        //boolean auth = database.authenticate("username","pwd".toCharArray());
    }


    @RequestMapping("/create")
    private void createUser() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("employees");
        DBCollection collection = database.getCollection("users");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Akshat");
        document.put("age", 22);
        collection.insert(document);
    }


    @RequestMapping("/update")
    private void updateUser() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("employees");
        DBCollection collection = database.getCollection("users");
        BasicDBObject query = new BasicDBObject();
        query.put("name", "Akshat");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Aksh");
        BasicDBObject newUser = new BasicDBObject();
        newUser.put("$set", document);
        collection.update(query, newUser);
    }


    @RequestMapping("/read")
    private void readUser() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("employees");
        DBCollection collection = database.getCollection("users");
        BasicDBObject search = new BasicDBObject();
        search.put("name", "Aksh");
        DBCursor cursor = collection.find(search);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }


    @RequestMapping("/delete")
    private void deleteUser() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("employees");
        DBCollection collection = database.getCollection("users");
        BasicDBObject search = new BasicDBObject();
        search.put("name", "Aksh");
        collection.remove(search);
    }

}
