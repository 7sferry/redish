# redish

this is a simple example to run spring boot & redis in docker.

to run this, execute `docker compose -f compose.yaml up -d` and it will run spring boot app at http://localhost:8989/set?key=nama&value=ferrys to set key and http://localhost:8989/get?key=nama to get key and a redis app at host port 6363 with password '12345'
