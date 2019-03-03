 # Basic description
RESTful API that interacts with a PostgreSQL database. Implemented in Java with Spring Boot and Mavenized. Edited in eclipse.  
  
 # Example HTTP requests via cURL (be sure to update as needed)
 ## Create a product
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"lookupCode":"lookupcode4","count":175}' https://uarkregserv.herokuapp.com/api/product/`  
 ## Update an existing product by record ID
`curl -i -s -H "Content-Type: application/json" -X PUT -d '{"id":"bee20aed-5245-46a7-b19c-9ef6abd4ca5c","lookupCode":"lookupcode4","count":200}' https://uarkregserv.herokuapp.com/api/product/bee20aed-5245-46a7-b19c-9ef6abd4ca5c`  
 ## Delete an existing product by record ID
`curl -i -s -X DELETE https://uarkregserv.herokuapp.com/api/product/bee20aed-5245-46a7-b19c-9ef6abd4ca5c`  
