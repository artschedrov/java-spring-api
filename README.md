# java-spring-api

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
