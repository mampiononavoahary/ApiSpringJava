#CREATE TYPE topic AS topicEnum('ROMMAN','COMMEDY','OTHER');

#CREATE TABLE Book(
# id int primary key not null,
# bookName varchar(200),
# pagesNumbers int,
# topicEnum topic,
# releaseDate date,
# authorId varchar(200) REFERENCES Author(authorId),
# status boolean
#);

# INSERT INTO Book values(1,'Le Navire',250,'ROMMAN','2005-02-27','1',true);
# INSERT INTO Book values(2,'L''ARES ET L''OPUS DE I',300,'1970-10-10','2',false);