## CMD NOTES

Ctrl+L (or write clear command) - clean the console

echo $SHELL - output:/usr/bin/bash - shows whitch console we use

echo hello - output: hello

Ctrl+A - mouse goes to the beginning of the line

Ctrl+E - mouse goes to the end of the line

Alt+B - mouse goes back on one word

Alt+F - mouse goes forwards on one word

Alt+Backspace - deletes word fully backwads

Alt+D - deletes word fully forwards

date - output:Sat Mar 12 15:29:39     2022

whoami - output:Bogdan 

Ctrl+up or Ctrl+down - shows previous command

#### Directories:Folder Operations

pwd - output:/c/Users/Bogdan/Desktop - present working directory

ls - shows list of files inside this file

cd /c/Users/Bogdan/Desktop/sample - goes to the file sample

cd .. - goes to the previous directory

```cd -``` - output/c/Users/Bogdan/Desktop/sample goes back to the directory

cd ~ - goes to the beginning of the directory

mkdir new_file - creates new file with name new_file

rm -rf new_file - removes file with name new_file

mv new_file sample - moves new_file to the sample (sample/new_file)

mkdir -p new/new1/new2 - creates path new/new1/new2 

tree.com //a - shows structure of all files in this path
 
tree.com //a new - shows structure of file new only
 
cat query.sql - shows the content of the file query.sql

less query.sql - shows the content of the file need to press Q in order to out

cat | less | tail | head - shows content of the file

mv new newest rename file from new to the newest

touch query1.sql - creates file query1.sql

echo "select * from users;" > query1.sql - rewrites to the file query1.sql line select * from users;

echo "select * from tickets;" >> query1.sql writes to the file query1.sql line select * from tickets;


cp -v query1.sql query.sql - copies query1 content to query

