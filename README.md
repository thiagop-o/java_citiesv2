<h2>java_citiesv2</h2>

<h3>Comandos utilizaos no docker</h3>

```
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

docker run -it --rm --net=host -v ${PWD}:/tmp postgres /bin/bash

docker exec -it cities-db /bin/bash
```



