## MONGODB_NOTES

to view all running container - docker ps 

Bash into container - docker exec -it containerId bash

Connect to db - mongo mongodb://localhost:27017 -u rootuser -p rootpass

show dbs; -> List database

use db_name; -> creates db or if it exists - switch to it

db.getName(); -> show name of db

db.dropDatabase(); -> removes db

DB methods:

        db.adminCommand(nameOrDocument) - switches to 'admin' db, and runs command [just calls db.runCommand(...)]
        
        db.aggregate([pipeline], {options}) - performs a collectionless aggregation on this database; returns a cursor
        
        db.auth(username, password)
        
        db.commandHelp(name) returns the help for the command
        
        db.createUser(userDocument)
        
        db.createView(name, viewOn, [{$operator: {...}}, ...], {viewOptions})
        
        db.currentOp() displays currently executing operations in the db
        
        db.dropDatabase(writeConcern)
        
        db.dropUser(username)
        
        db.eval() - deprecated
        
        db.fsyncLock() flush data to disk and lock server for backups
        
        db.fsyncUnlock() unlocks server following a db.fsyncLock()
        
        db.getCollection(cname) same as db['cname'] or db.cname
        
        db.getCollectionInfos([filter]) - returns a list that contains the names and options of the db's collections
        
        db.getCollectionNames()
        
        db.getLastError() - just returns the err msg string
        
        db.getLastErrorObj() - return full status object
        
        db.getLogComponents()
        
        db.getMongo() get the server connection object
        
        db.getMongo().setSecondaryOk() allow queries on a replication secondary server
        
        db.getName()
        
        db.getProfilingLevel() - deprecated
        
        db.getProfilingStatus() - returns if profiling is on and slow threshold
        
        db.getReplicationInfo()
        
        db.getSiblingDB(name) get the db at the same server as this one
        
        db.getWriteConcern() - returns the write concern used for any operations on this db, inherited from server object if set
        
        db.hostInfo() get details about the server's host
        
        db.isMaster() check replica primary status
        
        db.hello() check replica primary status
        
        db.killOp(opid) kills the current operation in the db
        
        db.listCommands() lists all the db commands
        
        db.loadServerScripts() loads all the scripts in db.system.js
        
        db.logout()
        
        db.printCollectionStats()
        
        db.printReplicationInfo()
        
        db.printShardingStatus()
        
        db.printSecondaryReplicationInfo()
        
        db.rotateCertificates(message) - rotates certificates, CRLs, and CA files and logs an optional message
        
        db.runCommand(cmdObj) run a database command.  if cmdObj is a string, turns it into {cmdObj: 1}
        
        db.serverStatus()
        
        db.setLogLevel(level,<component>)
        
        db.setProfilingLevel(level,slowms) 0=off 1=slow 2=all
        
        db.setVerboseShell(flag) display extra information in shell output
        
        db.setWriteConcern(<write concern doc>) - sets the write concern for writes to the db
        
        db.shutdownServer()
        
        db.stats()
        
        db.unsetWriteConcern(<write concern doc>) - unsets the write concern for writes to the db
        
        db.version() current version of the server
        
        db.watch() - opens a change stream cursor for a database to report on all  changes to its non-system collections.

collection -> table in SQL

document -> object or a string of the table in SQL

db.createCollection("person") 
output: { "ok" : 1 } 

show collections
output: person

db.person.stats() -> all info about the collection

db.person.drop() -> removes collection
output: true

```
db.createCollection( <name>,
   {
     capped: <boolean>,
     autoIndexId: <boolean>,
     size: <number>,
     max: <number>,
     storageEngine: <document>,
     validator: <document>,
     validationLevel: <string>,
     validationAction: <string>,
     indexOptionDefaults: <document>,
     viewOn: <string>,              // Added in MongoDB 3.4
     pipeline: <pipeline>,          // Added in MongoDB 3.4
     collation: <document>,         // Added in MongoDB 3.4
     writeConcern: <document>
   }
)       -> layout for collection creation
```
        
db.student.insert(student) -> insert new object with name student

 ObjectId("609fca6996fbd361579277d3").getTimestamp() -> returns time when object was created
 
db.student.insertMany(students) -> students is a file js with many objects

Всего имеется следующие типы значений:

- String: строковый тип данных, как в приведенном выше примере (для строк используется кодировка UTF-8)

- Array (массив): тип данных для хранения массивов элементов

- Binary data (двоичные данные): тип для хранения данных в бинарном формате

 - Boolean: булевый тип данных, хранящий логические значения TRUE или FALSE, например, {"married": FALSE}

 - Date: хранит дату в формате времени Unix

 - Double: числовой тип данных для хранения чисел с плавающей точкой

 - Integer: используется для хранения целочисленных значений размером 32 бита, например, {"age": 29}

 - Long: используется для хранения целочисленных значений размером 64 бита

 - JavaScript: тип данных для хранения кода javascript

 - Min key/Max key: используются для сравнения значений с наименьшим/наибольшим элементов BSON

 - Null: тип данных для хранения значения Null

 - Object: строковый тип данных, как в приведенном выше примере

 - ObjectId: тип данных для хранения id документа

 - Regular expression: применяется для хранения регулярных выражений

 - Decimal128: тип данных для хранения десятичных дробных чисел размером 128 бит, которые позволяют решить 
проблемы с проблемой точности вычислений при использовании дробных чисел, которые представляют тип Double.

 - Timestamp: применяется для хранения времени

