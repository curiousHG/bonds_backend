# Bonds Backend

### APIS

#### Sample User requests
Post request to create a user
```
curl -X POST \
  http://localhost:8080/api/v1/addUser \
  -H 'Content-Type: application/json' \
  -d '{
    "name":"Debo",
    "email":"deb1@gmail.com",
    "role":"developer"
}'
```

Get request to get all users
```
curl -X GET \
  http://localhost:8080/api/v1/getAllUsers \
  -H 'Content-Type: application/json' \
```
