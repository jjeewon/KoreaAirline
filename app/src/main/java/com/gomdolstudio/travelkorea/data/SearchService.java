package com.gomdolstudio.travelkorea.data;

import com.gomdolstudio.travelkorea.data.entity.Ticket;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {
    @GET("&{numOfRows}&{pageNo}&{depAirportId}&{arrAirportId}&{depPlandTime}&{airlineId}")
    Single<List<Ticket>> getTicket(@Query("numOfRows") String numOfRows, @Query("pageNo") String pageNo,
                                   @Query("depAirportId") String depAirportId, @Query("arrAirportId") String arrAirportId,
                                   @Query("depPlandTime") String depPlandTime,@Query("airlineId") String airlineId
                                   );
}
