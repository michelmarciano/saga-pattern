# COMAND DOCKER COMPOSE

### Comandos básicos do Docker Compose

```bash 
docker-compose up --build -d # Inicia os containers em segundo plano  
```
```bash
docker-compose down # Para e remove os containers, redes e volumes criados pelo up
```
```bash
python3 build.py # Executa o script build.py para construir a imagem do Docker
```

# COMAND DOCKER MONGO-DB
### Comandos básicos do Docker MongoDB

```bash
docker exec -it order-db mongosh "mongodb://admin:admin@localhost:27017" # Acessa o container do MongoDB
```
```bash