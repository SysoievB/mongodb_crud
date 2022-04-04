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

db.users.renameCollection("новое_название")
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

Для добавления в коллекцию могут использоваться три ее метода:

 - insertOne(): добавляет один документ

 - insertMany(): добавляет несколько документов

 - insert(): может добавлять как один, так и несколько документов

load("D:/users.js") -> Для загузки файла в текущую базу данных применяется функция load(), 
в которую в качестве параметра передается путь к файлу

db.users.find().pretty() -> ля вывода документов в более удобном наглядном представлении мы можем 
добавить вызов метода pretty()

db.users.findOne() -> Функция find() позволяет возвратить несколько документов. Еще одна функция 
findOne() работает похожим образом, только возвращает один документ

#### Настройка запросов и сортировка

MongoDB представляет ряд функций, которые помогают управлять выборкой из бд. Одна из них - функция limit. 
Она задает максимально допустимое количество получаемых документов. Количество передается в виде числового 
параметра. Например, ограничим выборку тремя документами:

```
> db.users.find().limit(3)
```
В данном случае мы получим первые три документа (если в коллекции 3 и больше документов). Но что, если мы 
хотим произвести выборку не сначала, а пропустив какое-то количество документов? В этом нам поможет функция 
skip. Например, пропустим первые три записи:

```
> db.users.find().skip(3)
```
MongoDB предоствляет возможности отсортировать полученный из бд набор данных с помощью функции sort. 
Передавая в эту функцию значения 1 или -1, мы можем указать в каком порядке сортировать: по возрастанию 
(1) или по убыванию (-1). Во многом эта функция по действию аналогична выражению ORDER BY в SQL. 
Например, сортировка по возрастанию по полю name:

```
> db.users.find().sort({name: 1})
```
Ну и в конце надо отметить, что мы можем совмещать все эти функции в одной цепочке:

```
> db.users.find().sort({name: 1}).skip(3).limit(3)
```


count() -> можно получить число элементов в коллекции

db.users.distinct("name") -> only unique names

#### Условные операторы
Условные операторы задают условие, которому должно соответствовать значение поля документа:

 - $eq (равно)

 - $ne (не равно)

 - $gt (больше чем)

 - $lt (меньше чем)

 - $gte (больше или равно)

 - $lte (меньше или равно)

 - $in определяет массив значений, одно из которых должно иметь поле документа

 - $nin определяет массив значений, которые не должно иметь поле документа

#### Логические операторы
Логические операторы выполняются над условиями выборки:

 - $or: соединяет два условия, и документ должен соответствовать одному из этих условий

 - $and: соединяет два условия, и документ должен соответствовать обоим условиям

 - $not: документ должен НЕ соответствовать условию

 - $nor: соединяет два условия, и документ должен НЕ соответстовать обоим условиям
 
#### Поиск по массивам
Ряд операторов предназначены для работы с массивами:

 - $all: определяет набор значений, которые должны иметься в массиве

 - $size: определяет количество элементов, которые должны быть в массиве

 - $elemMatch: определяет условие, которым должны соответствовать элемены в массиве

#### replaceOne
Если нам надо полностью заменить один документ другим, также может использоваться функция replaceOne:

```
db.collection.replaceOne(filter, update, options)
```
 - filter: принимает запрос на выборку документа, который надо обновить

 - update: представляет новый документ, который заместит старый при обновлении

 - options: определяет дополнительные параметры при обновлении документов, основным из которых является параметр upsert.

Если параметр upsert имеет значение true, что mongodb будет обновлять документ, если он найден, и 
создавать новый, если такого документа нет. Если же он имеет значение false, то mongodb не будет 
создавать новый документ, если запрос на выборку не найдет ни одного документа.

Например:

```
db.users.replaceOne({name: "Bob"}, {name: "Bob", age: 25})
```
В данном случае находим документ, в котором name ="Bob", и заменяем его документом {name: "Bob", age: 25}

#### updateOne и updateMany
Часто не требуется обновлять весь документ, а только значение одного или нескольких его свойств. 
Для этого применяются функции updateOne() - она обновляет только один документ и updateMany() - 
позволяет обновить множество документов.

Для обновления отдельных полей в этих функциях применяется оператор $set. Если документ не содержит 
обновляемое поле, то оно создается.

```
> db.users.updateOne({name : "Tom", age: 25}, {$set: {age : 28}})
```
Здесь мы ищем документ с name="Tom" и age=25 и устанавливаем для его свойства age значение 28

$push позволяет добавить еще одно значение к уже существующему
```
db.users.updateOne({name : "Tom"}, {$push: {languages: "russian"}})
```

Оператор $addToSet подобно оператору $push добавляет объекты в массив. Отличие состоит в том, 
что $addToSet добавляет данные, если их еще нет в массиве ( при добавлении через $push данные 
дублируются, если добавляются элементы, которые уже есть в массиве):

```
> db.users.updateOne({name : "Tom"}, {$addToSet: {languages: "russian"}})
```

Оператор $pop позволяет удалять элемент из массива:
```
> db.users.updateOne({name : "Tom"}, {$pop: {languages: 1}})
```
Указывая для ключа languages значение 1, мы удаляем первый элемент с конца. 
Чтобы удалить первый элемент сначала массива, надо передать отрицательное значение:

```
> db.users.updateOne({name : "Tom"}, {$pop: {languages: -1}})
```

deleteOne() - удаляет один документ 

deleteMany() - позволяет удалить несколько документов
