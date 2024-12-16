CREATE TABLE users_lists_join_table(
	user_id INT NOT NULL,
    list_id INT NOT NULL,
    PRIMARY KEY(user_id, list_id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(list_id) REFERENCES lists(id)
)
