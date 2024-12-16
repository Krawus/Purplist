DROP TABLE IF EXISTS lists;
-- ------------------------
-- create_lists_table.sql -> create the lists table
CREATE TABLE lists(
		id int NOT NULL auto_increment,
        name varchar(50),
        content JSON,
        PRIMARY KEY (id)
	);

-- create sercurity tables.sql -> create the users and authorities tables
CREATE TABLE users (
  id INT NOT NULL auto_increment,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);
  
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username, authority);
    
-- create_users_lists_join_table.sql -> create the users_lists_join_table - for many to many realtion
CREATE TABLE users_lists_join_table(
	user_id INT NOT NULL,
    list_id INT NOT NULL,
    PRIMARY KEY(user_id, list_id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(list_id) REFERENCES lists(id)
);

-- populate_security_tables.sql -> populate the users and authorities tables
INSERT INTO users (username, password, enabled)
  values ('user',
    '{noop}user',
    1);

INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER');
  
  
INSERT INTO users (username, password, enabled)
  values ('admin',
    '{noop}admin',
    1);

INSERT INTO authorities (username, authority)
  values ('admin', 'ROLE_ADMIN');
  
  
INSERT INTO users (username, password, enabled)
  values ('user1',
    '{noop}user1',
    1);

INSERT INTO authorities (username, authority)
  values ('user1', 'ROLE_USER');
  

-- --insert_values_into_list.sql -> insert values into the lists table
INSERT INTO lists(name, content) values ('test_list2', '{"element1": 1, "element2": 0}');
INSERT INTO lists(name, content) values ('shopping_list', '{"ketchup": 1, "garlic": 0, "water":0}');
    
