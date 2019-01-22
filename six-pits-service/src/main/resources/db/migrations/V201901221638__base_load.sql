-- now we insert the data we need to existis prior to the core entities

insert into player_status (player_status_id,player_status_description) values (1,'Offline');
insert into player_status (player_status_id,player_status_description) values (2,'Online');
insert into player_status (player_status_id,player_status_description) values (3,'Gaming');

insert into game_status (game_status_id,game_status_description) values (1,'Player challenged');
insert into game_status (game_status_id,game_status_description) values (2,'Started');
insert into game_status (game_status_id,game_status_description) values (3,'Player 1 won');
insert into game_status (game_status_id,game_status_description) values (4,'Player 2 won');
insert into game_status (game_status_id,game_status_description) values (5,'Player 1 aborted');
insert into game_status (game_status_id,game_status_description) values (6,'Player 2 aborted');
insert into game_status (game_status_id,game_status_description) values (7,'Draw');
