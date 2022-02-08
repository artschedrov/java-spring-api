# java-spring-api

Simple java spring app with MySQL

```
javaspringapi/
├─ controller/
├─ service/
├─ entity/
├─ exception/
├─ model/
├─ repository/
├─ JavaSpringApiApplication.java 

```

```
+-------------------+        +-------------------------+
|        User       |        |           Todo          |
+-------------------+        +-------------------------+
| id LONG           |        |  id LONG                |
|                   |        |                         |
| username STRING   |        |  Title STRING           |
|                   +--------+                         |
| password STRING   |        |  complete BOOLEAN       |
|                   |        |                         |
|                   |        |  user_id REFERENCE user |
+-------------------+        |                         |
                             +-------------------------+
```                             
