DROP TABLE IF EXISTS lists;
CREATE TABLE lists(
		id int NOT NULL auto_increment,
        name varchar(50),
        content JSON,
        PRIMARY KEY (id)
	);
    
    
