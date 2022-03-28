# DOCKER NOTES

![image](https://github.com/SysoievB/mongodb_crud/blob/main/src/main/resources/images/docker_arc.png)

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

docker run bash bash -c "echo foo > bar.txt && cat bar.txt" - writes line to the file and shows it

docker volume ls -> list of volumes 

#### Image Tagging and Versioning

docker pull image_name -> always pulls latest, should pull another image name instead of latest

docker tag dashboard:latest dashbord:1 -> renaming & coping tag from dashboard:latest to dashboard:1(should never use latest in production)

docker run --name dashboard -d -p 8080:80 nginx  -> run own container where dashboard is the name of project

docker exec dashboard ls -> shows file structure of dashboard

docker network create mongo -> creates network(container for few separate containers) with name mongo

docker inspect dashboard -> shows all information about container dashboard

 docker network ls -> list of networks
 
 Docker compose - is a tool for defining and running multi-container docker applications using a yaml file

### Docker own container creation

Dockerfile:
```
FROM container_name

WORKDIR /app

COPY . .

CMD ["container_name", "file_name"]
```
docker build .

docker run container_id

