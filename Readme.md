# Crud cassandra using springboot with docker

### Start Cassandra docker

```bash
docker pull cassandra:3.11.10

docker images
// check here your cassandra image pulled

docker run -d --name cassandra-node -p 9042:9042 cassandra:3.11.10

docker ps
// check here your cassandra image running
```

### Run commands into Cassandra docker image

```bash
docker exec -it cassandra-node bash
cqlsh
```

### Creating a Keyspace using Cqlsh

A keyspace in Cassandra is a namespace that defines data replication on nodes. A cluster contains one keyspace per node. Given below is the syntax for creating a keyspace using the statement CREATE KEYSPACE.
```bash
CREATE KEYSPACE mykeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
```

### Create a Table using Cqlsh (into a specific Keyspace)

```bash
use mykeyspace
CREATE TABLE User( id int PRIMARY KEY, name text);
```

---
### Describe Keyspaces − This command lists all the keyspaces in a cluster. Given below is the usage of this command.

```bash
describe keyspaces;
```

### Describe tables − This command lists all the tables in a keyspace. Given below is the usage of this command.

```bash
describe tables:
```

### Describe table − This command provides the description of a table. Given below is the usage of this command.

```bash
describe table user;
```

---
### Some useful docker commands
```bash
docker images
docker ps
docker ps -a
docker stop "CONTAINER ID or NAME"
docker rm "CONTAINER ID or NAME"
```