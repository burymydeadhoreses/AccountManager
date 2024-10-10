# Simple Account Registration Example

## Java version is 21

### add user

```
curl --location "127.0.0.1:8080/user" ^
--header "Content-Type: application/json" ^
--data-raw "{""username"": ""burymydeadhoreses"", ""email"": ""mail@example.com"", ""birthdate"": ""2024-12-31""}"
```

### update user

```
curl --location --request PUT "127.0.0.1:8080/user" ^
--header "Content-Type: application/json" ^
--data-raw "{""username"": ""burymydeadhoreses"", ""email"": ""mail2@example.com""}"
```

### delete user

```
curl --location --request DELETE "127.0.0.1:8080/user/burymydeadhoreses" ^
--header "Content-Type: application/json" ^
--data-raw "{""username"": ""burymydeadhoreses"", ""email"": ""mail@example.com"", ""birthdate"": ""2024-12-31""}"
```

### get user

```
curl --location "127.0.0.1:8080/user/burymydeadhoreses"
```

### list users

```
curl --location "127.0.0.1:8080/user"
```

