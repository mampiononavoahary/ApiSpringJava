 CREATE TABLE IF NOT EXISTS Subscribers(
    id varchar(200) primary key not null,
    name varchar(200),
    sex char(1),
    reference varchar(200)
 );

 INSERT INTO Subscribers values('1','Albert','H','SD124');
 INSERT INTO Subscribers values('2','EL OAH','H','SD135');
 INSERT INTO Subscribers values('3','SAH','F','SD12535');