package com.target.myRetail.dao;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.target.myRetail.domain.ProductsPrice;

@Repository
public class PriceDAO implements IPriceDAO {
	
	@Autowired
	@Qualifier("productPriceCollection")
	MongoCollection<Document> productPriceCollection;

	public ProductsPrice getPrice(int id) {
		BasicDBObject queryObject = new BasicDBObject();
		queryObject.put("_id", id);

		Document productPriceDocument = productPriceCollection.find(queryObject).first();

		if (productPriceDocument != null) {
			return new ProductsPrice(id, productPriceDocument.getDouble("value"),
					productPriceDocument.getString("currency_code"));
		}

		return null;
	}

	public void savePrice(double value, String currency_code, int id) {
		
		// Document creation
		BasicDBObject queryObject = new BasicDBObject();
		queryObject.put("_id", id);
		
		BasicDBObject values = new BasicDBObject();
		values.put("_id", id);
		values.put("value", value);
		values.put("currency_code", currency_code);
		
		UpdateOptions updateOptions = new UpdateOptions();
		updateOptions.upsert(true);
		
		productPriceCollection.replaceOne(queryObject, Document.parse(values.toJson()), updateOptions);
	}
}
