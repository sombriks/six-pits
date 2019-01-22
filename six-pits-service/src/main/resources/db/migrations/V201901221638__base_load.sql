-- now we insert the data we need to existis prior to the core entities

insert into player_status (player_status_id,player_status_description) values (1,'Offline');
insert into player_status (player_status_id,player_status_description) values (2,'Online');
insert into player_status (player_status_id,player_status_description) values (3,'Gaming');

insert into game_status (game_status_id,game_status_descripotion) values (1,'Created');
insert into game_status (game_status_id,game_status_descripotion) values (2,'Started');
insert into game_status (game_status_id,game_status_descripotion) values (3,'Finished');
insert into game_status (game_status_id,game_status_descripotion) values (4,'Aborted');
