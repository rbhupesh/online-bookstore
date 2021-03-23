# online-bookstore
SpringBoot Application using H2 and unit test cases


#Assignment
Create a REST API for an online bookstore, where the user can perform the following operations:

CRUD operations on Books
Checkout operation for single or multiple books which will return the total payable amount.
Considerations>>

You can use either Spring boot or Quarkus
Book object should have the following attributes:
Name, Description, Author, Type/Classification, Price, ISBN

Checkout method will take list of books as parameters plus optional promotion code and return total price after discount (if applicable).
Promotion/Discounts is variant according to book type/classification, ex: fiction books may have 10% discount while comic books have 0% discount.
 
#Deliverables>>

OpenAPI spec for your REST service.
Unit tests for all operations
Able to run it both locally (from terminal) and to run it on docker container.
Source code project should be uploaded to GitHub
Notes:-

You can use any persistence method for Books (i.e. in memory, database, etc.)
 
#Solution  space
SpringBoot
H2 database
spring boot started test module
Postman client

#OpenAPI spec
http://localhost:8080/v3/api-docs/

To add new Book (post method)
http://localhost:8080/api/v1/book-store/books

e.g.  {
        "name": "Book3",
        "description": "Description3",
        "price": "10.25",
        "author": "Author3",
        "isbn": "ISBN3",
        "classification": "COMIC"
    }

To find books by ISBN (get method)
http://localhost:8080/api/v1/book-store/books/ISBN1
 
To Check out books (post method)
http://localhost:8080/api/v1/book-store/checkout
e.g. books ids are passed as payload
{
    "books":[
       2
    ]
}

#TODO
Add to cart api
Unit test cases for controller classes
Unit test cases fro DAO classes
