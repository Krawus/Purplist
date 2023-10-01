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
  