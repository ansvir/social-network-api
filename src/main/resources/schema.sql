CREATE TABLE IF NOT EXISTS social_network_post(
   id BIGINT NOT NULL auto_increment,
   post_date DATE,
   author VARCHAR(50),
   content VARCHAR(256),
   view_count BIGINT NOT NULL
);