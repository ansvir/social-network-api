CREATE TABLE IF NOT EXISTS social_network_post(
   id BIGINT NOT NULL auto_increment,
   post_date DATE NOT NULL,
   author VARCHAR(50),
   content VARCHAR(255),
   view_count BIGINT NOT NULL
);