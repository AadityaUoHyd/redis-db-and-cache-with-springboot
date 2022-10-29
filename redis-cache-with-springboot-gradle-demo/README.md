# Implementing Redis Cache with gradle using SpringBoot and MySQL

- Redis is a great choice for implementing a highly available in-memory cache to decrease data access latency, increase throughput, and ease the load off 
  your relational or NoSQL database and application. Here we tried to implement with LibraryApp..for GET, PUT and DELETE request.
  
- Applied @Cacheable for GET BY ID request, @CachePut for PUT request, @CacheEvict for DELETE request. Don't forget to add @EnableCaching annotation 
  at top of main class so that caching mechanism will be kick started.
  
- Once cache is applied, after first call the very next call onwards GET BY ID request will not go to MySQL Database, instead it'll take value from redis cache.
  One can verify this via using logger or monitoring hql-queries in console that 2nd time onwards for the very same request, no fetch query is fired from MySQL.
  @CachePut is used so that while updating object(a record in MySQL DB), the cache should be get updated as well. 
  And @CacheEvict will delete key/value pair from that object in cache as well, while deleting record from MySQL Database.
  
- Say we used GET request with id=3 then redis will have key as "librarybooks::3". use in redis-cli (127.0.0.1:6379 > keys *) to find keys of cache.

- Souces to learn from : https://www.baeldung.com/spring-boot-redis-cache 
