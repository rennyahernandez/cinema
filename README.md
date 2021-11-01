# cinema

## Use Cases Assumptions
 * Movie Owners can update movie catalog: show times, prices, movie info in general.
   * One Movie has One Price.
   * One Movie has Many Show Times. 
   * Movie Show Times are Stored as Timestamp values for simplicity. 
   * For the sake of simplicity, the `PUT /cinema/show-time` endpoint can only update the date and time values.