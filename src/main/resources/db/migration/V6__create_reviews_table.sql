CREATE TABLE IF NOT EXISTS movie_reviews (
     id BIGINT NOT NULL AUTO_INCREMENT,
     movie_id BIGINT NOT NULL,
     rating  TINYINT,
     comments TEXT,
     PRIMARY KEY (id)
);