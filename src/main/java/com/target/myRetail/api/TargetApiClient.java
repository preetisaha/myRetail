package com.target.myRetail.api;

import com.target.myRetail.domain.ProductInfo;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TargetApiClient {

	 @GET ("v2/pdp/tcin/{id}")
     retrofit2.Call<ProductInfo> getProductInfo(
             @Path("id") int id
            
      );
}
