DROP TABLE IF EXISTS list;
CREATE TABLE list(
		id int NOT NULL auto_increment,
        name varchar(50),
        content JSON,
        PRIMARY KEY (id)
	);
    
    