# DOCKER NOTES

![image](C:\Users\Bogdan\IdeaProjects\mongodb_crud\src\main\resources\images\docker_arc.png)

docker --version 

docker ps -> list of running containers

docker ps -a -> list of all containers

docker stop 7b9f301d146f -> stops container with id 7b9f301d146f

docker run -d -p 80:80 amigoscode/2048 -> run the container amigoscode/2048

docker images | docker image ls -> shows list of all running images

docker start id -> starts the container with id - id

docker rm id -> removes container

docker rm -f id -> force remove

```
export FORMAT="ID\t{{.ID}}\nNAME\t{{.Names}}\nIMAGE\t{{.Image}}\nPORTS\t{{.Ports}}\nCOMMAND\t{{.Command}}\nCREATED\t{{.CreatedAt}}\nSTATUS\t{{.Status}}\n"
```
  -> vertical format for the list of containers 

docker ps --format=$FORMAT -> command for the format

docker run -p 80:80 -p 5000:80 -p 3000:80 -d amigoscode/2048 -> run the container on few ports

docker run --name 2048 -p 81:80 -p 5000:80 -p 3000:80 -d amigoscode/2048 -> changing name to 2048

docker run --name website -d -p 8080:80 nginx -> -d means detach mode

docker image rm nginx | docker rmi nginx -> removes image nginx but first need to remove this container -> docker rm -f website

docker pull nginx -> pulling nginx image without running

docker image inspect name_of_image 


