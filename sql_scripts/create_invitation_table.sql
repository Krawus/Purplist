DROP TABLE IF EXISTS invitations;
CREATE TABLE invitations(
        id int NOT NULL auto_increment,
        purplist_id int NOT NULL,
        sender_id int NOT NULL,
        receiver_id int NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (purplist_id) REFERENCES lists(id),
        FOREIGN KEY (sender_id) REFERENCES users(id),
        FOREIGN KEY (receiver_id) REFERENCES users(id)
    );