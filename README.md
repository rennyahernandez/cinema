# cinema

## Use Cases Assumptions
 * Movie Owners can update movie catalog: show times, prices, movie info in general.
   * One Movie has One Price.
   * One Movie has Many Show Times. 
   * Movie Show Times are Stored as Timestamp values for simplicity. 
   * For the sake of simplicity, the `PUT /cinema/show-time` endpoint can only update the date and time values.

## Technical Assumptions
   * In production environments, database migration changes must be supervised. We may assume that no code is in production and there is no production data before release.
   * API Docs are available using `host:port/api-docs`