# Spring boot device seller

## Endpoints

### sign up

````aidl
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 82

{
    "name":"mobumahi",
    "username":"mobumahi",
    "password":"abc1" 

}
````


### sign in

````aidl
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 54

{
    "username": "maahi",
    "password": "abc1"
}
````