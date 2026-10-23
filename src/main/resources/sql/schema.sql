-- user table
CREATE TABLE IF NOT EXISTS user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    created_on date DEFAULT CURRENT_DATE(),
    PRIMARY KEY (user_id),
    );

-- messagetable
CREATE TABLE IF NOT EXISTS messagedb (
    msg_id INT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(100) NOT NULL,
    message VARCHAR(255) NOT NULL,
    privacy VARCHAR(255),
    likes int DEFAULT 0;
    date date DEFAULT CURRENT_DATE(),
    PRIMARY KEY (msg_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id),
);

public MessageModel(String name, String message, String privpub, LocalDate date){
        this.name = name;
        this.message = message;
        this.privpub = privpub;
        this.date = date;
        this.likes = 0;