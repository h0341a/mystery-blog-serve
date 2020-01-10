CREATE TABLE user(
                     uid TINYINT AUTO_INCREMENT PRIMARY KEY,
                     username VARCHAR(16) UNIQUE ,
                     password VARCHAR(32)
);

CREATE TABLE blog_category(
                              id TINYINT	AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR (16) NOT NULL UNIQUE,
                              description VARCHAR(128)
);

INSERT INTO blog_category(name) VALUES ('未分类');

CREATE TABLE blog(
                     bid INTEGER AUTO_INCREMENT PRIMARY KEY,
                     title VARCHAR(24) NOT NULL UNIQUE ,
                     category_id TINYINT DEFAULT 1,
                     description VARCHAR(64),
                     content TEXT NOT NULL ,
                     create_date DATETIME NOT NULL DEFAULT NOW(),
                     FOREIGN KEY (`category_id`) REFERENCES blog_category(`id`)
);

CREATE TABLE visits(
                       blog_id INTEGER NOT NULL ,
                       create_date DATETIME NOT NULL DEFAULT NOW(),
                       FOREIGN KEY (`blog_id`) REFERENCES blog(bid)
);

CREATE TABLE comment(
                        cid INTEGER AUTO_INCREMENT PRIMARY KEY,
                        nickname VARCHAR(8) NOT NULL ,
                        email VARCHAR (64),
                        content VARCHAR(128) NOT NULL,
                        blog_id INTEGER NOT NULL ,
                        star_count INTEGER DEFAULT 0,
                        parent_cid INTEGER DEFAULT 0,
                        create_date DATETIME NOT NULL DEFAULT NOW(),
                        FOREIGN KEY (`blog_id`) REFERENCES blog(bid)
);
CREATE TABLE star(
                     blog_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                     create_date DATETIME NOT NULL DEFAULT NOW(),
                     FOREIGN KEY (`blog_id`) REFERENCES blog(bid)
);

