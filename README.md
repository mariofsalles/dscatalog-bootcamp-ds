# DSCATALOG-BOOTCAMP-DS

The back-end is working!

# GET/products/{id}
````json
{
    "id": 1,
    "name": "The Lord of the Rings",
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    "price": 90.5,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "date": "2020-07-13T20:50:07.123450Z",
    "categories": [
        {
            "id": 2,
            "name": "Eletrônicos"
        }
    ]
}
````

# GET/products
````json
{
    "content": [
        {
            "id": 1,
            "name": "The Lord of the Rings",
            "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "price": 90.5,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
            "date": "2020-07-13T20:50:07.123450Z",
            "categories": []
        },
        {
            "id": 2,
            "name": "Smart TV",
            "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "price": 2190.0,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",
            "date": "2020-07-14T10:00:00Z",
            "categories": []
        },
        {
            "id": 3,
            "name": "Macbook Pro",
            "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "price": 1250.0,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg",
            "date": "2020-07-14T10:00:00Z",
            "categories": []
        },
        {
        "And":"Several"
        }
````
# POST/products
Request:
````JSON
{
  "date": "2020-07-20T10:00:00Z",
  "description": "The new generation PS5 video game",
  "name": "PS5",
  "imgUrl": "",
  "price": 600.0,
  "categories": [
    {
      "id": 1
    },
    {
      "id": 3
    }
  ]
}
````
Response:
````JSON
{
    "id": 26,
    "name": "PS5",
    "description": "The new generation PS5 video game",
    "price": 600.0,
    "imgUrl": "",
    "date": "2020-07-20T10:00:00Z",
    "categories": []
}
````
# PUT/products/{id}
Request:
````JSON
{
  "date": "2020-07-20T10:00:00Z",
  "description": "Updated product description",
  "name": "Updated product name",
  "imgUrl": "",
  "price": 600.0,
  "categories": [
    {
      "id": 1
    },
    {
      "id": 3
    }
  ]
}
````
Response:
````JSON
{
    "id": 28,
    "name": "PS5",
    "description": "The new generation PS5 video game",
    "price": 600.0,
    "imgUrl": "",
    "date": "2020-07-20T10:00:00Z",
    "categoriesDto": []
}
````
# DELETE/product/{id}
Request
````JSON
{
}
````
Response:
````JSON
{
}
````
