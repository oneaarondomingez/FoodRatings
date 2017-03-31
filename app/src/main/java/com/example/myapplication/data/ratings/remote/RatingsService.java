package com.example.myapplication.data.ratings.remote;

import com.example.myapplication.data.ratings.entities.authority.ResultAuthority;
import com.example.myapplication.data.ratings.entities.establishments.ResultEstablishments;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by user on 3/30/17.
 */

public interface RatingsService {
    String BASE_URL = "http://api.ratings.food.gov.uk/";

    //    http://api.ratings.food.gov.uk/authorities/basic
    //    http://api.ratings.food.gov.uk/establishments?localAuthorityId=177&pageNumber=1&pageSize=953


    @GET("/authorities/basic/")
    Observable<ResultAuthority> getAuthorities();

    @GET("/establishments?pageNumber=1")
    Observable<ResultEstablishments> getEstablishments(@Query("localAuthorityId") Integer localAuthorityId,
                                                       @Query("pageSize") Integer pageSize);
}
