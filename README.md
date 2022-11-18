# Spring Redis Caching
this is an example usage of spring redis through spring boot and spring data redis.
## How to Run
download the docker compose file from github:
- https://github.com/dmgiangi/spring-redis-caching \
  or directly:
- https://raw.githubusercontent.com/dmgiangi/spring-redis-caching/master/docker-compose.yml

```bash
docker compose up -d
```
then to create a new element:
```bash
curl --location --request POST 'http://localhost:8080/scan-context' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text": "New Scan Context",
    "anDouble": 1.55,
    "anInteger": 11
}' | jsonpp
```
to get the created element (substitute #UUID with the one received from the post request):
```bash
curl --location --request GET 'http://localhost:8080/scan-context/#UUID'
```
to delete the created element (substitute #UUID with the one received from the post request):
```bash
curl --location --request DELETE 'http://localhost:8080/scan-context/#UUID'
```
in order to connect directly to te redis-cli use:
```bash
docker exec -ti src-redis redis-cli -a eYVX7EwVmmxKPCDmwMtyKVge8oLd2t81
```
