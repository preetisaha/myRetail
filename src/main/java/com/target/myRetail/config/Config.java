package com.target.myRetail.config;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Collation;
import com.target.myRetail.api.TargetApiClient;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Configuration
public class Config {

	@Bean
	public Retrofit getRetrofit() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://redsky.target.com/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		return retrofit;
	}

	@Bean
	public TargetApiClient getTargetApiClient(@Autowired Retrofit retrofit) {
		return retrofit.create(TargetApiClient.class);
	}

	@Bean
	public MongoDatabase getMongoDatabase() {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://preetisaha:mongodb123$@test-shard-00-00-xepxu.mongodb.net:27017,test-shard-00-01-xepxu.mongodb.net:27017,test-shard-00-02-xepxu.mongodb.net:27017/test?ssl=true&replicaSet=test-shard-0&authSource=admin");
		MongoClient mongoClient = new MongoClient(uri);
		return mongoClient.getDatabase("test");
	}
	
	@Bean
	@Qualifier("productPriceCollection")
	public MongoCollection<Document> getCollection(MongoDatabase mongoDatabase){
		return mongoDatabase.getCollection("product_price");
	}
}
