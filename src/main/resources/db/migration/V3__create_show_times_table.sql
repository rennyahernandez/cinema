CREATE TABLE IF NOT EXISTS show_times (
     id BIGINT NOT NULL AUTO_INCREMENT,
     movie_id BIGINT NOT NULL,
     show_date_time TIMESTAMP,
     PRIMARY KEY (id)
);