package esanchez.devel.weather.script;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import esanchez.devel.weather.cryptography.Cryptography;

public class CreateApiCredentials {

	public static void main(String[] args) {

		String user = "weatherAdmin";
		String password = Cryptography.encode("qwertyui");

		String connectionString = "mongodb://127.0.0.1:27017";
		MongoClient mongoClient = MongoClients.create(connectionString);

		mongoClient
			.getDatabase("weather-api-location")
			.getCollection("apiUser")
			.insertOne(new Document().append("name", user).append("password", password));

		mongoClient.close();
	}
}
