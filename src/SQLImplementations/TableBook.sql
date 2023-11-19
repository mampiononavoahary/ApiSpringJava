CREATE TYPE IF NOT EXISTS topic AS topicEnum('ROMMAN','COMMEDY','OTHER');

CREATE TABLE IF NOT EXISTS Book(
     id int primary key not null,
     bookName varchar(200),
     pagesNumbers int,
     topicEnum topic,
     releaseDate date,
     authorId varchar(200) REFERENCES Author(authorId),
     status boolean
);

 INSERT INTO Book values(1,'Le Navire',250,'ROMMAN','2005-02-27','1',true);
 INSERT INTO Book values(2,'L''ARES ET L''OPUS DE I',300,'OTHER','1970-12-12','2',false);
 INSERT INTO Book values(3,'MOMIE',60,'COMMEDY','2005-10-26','1',true);