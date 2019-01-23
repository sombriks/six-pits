-- test dataset offers a known state which isn't an empty database. in this scenario, Bob and Joe are online, Betty and
-- Carl are offline and Alice and Mary are gaming.

insert into player (player_id,player_name,player_hash,player_status_id) values (1,'Joe','e10adc3949ba59abbe56e057f20f883e',2);
insert into player (player_id,player_name,player_hash,player_status_id) values (2,'Mary','e10adc3949ba59abbe56e057f20f883e',3);
insert into player (player_id,player_name,player_hash,player_status_id) values (3,'Alice','e10adc3949ba59abbe56e057f20f883e',3);
insert into player (player_id,player_name,player_hash,player_status_id) values (4,'Bob','e10adc3949ba59abbe56e057f20f883e',2);
insert into player (player_id,player_name,player_hash) values (5,'Carl','e10adc3949ba59abbe56e057f20f883e');
insert into player (player_id,player_name,player_hash) values (6,'Betty','e10adc3949ba59abbe56e057f20f883e');

-- a few games occured already. one still running.

insert into game (game_id,game_status_id,player_id_1,player_id_2) values (1,3,2,1);
insert into game (game_id,game_status_id,player_id_1,player_id_2) values (2,3,2,3);
insert into game (game_id,game_status_id,player_id_1,player_id_2) values (3,3,2,4);
insert into game (game_id,game_status_id,player_id_1,player_id_2) values (4,3,2,5);
insert into game (game_id,game_status_id,player_id_1,player_id_2) values (5,4,2,6);

-- Mary and Alice still gaming.

insert into game (game_id,game_status_id,player_id_1,player_id_2) values (6,2,2,3);

-- Betty challenged Bob.

insert into game (game_id,game_status_id,player_id_1,player_id_2) values (7,1,6,4);

-- finally, a few scores.

insert into score(score_id,game_id,player_id) values (1,1,2);
insert into score(score_id,game_id,player_id) values (2,1,2);
insert into score(score_id,game_id,player_id) values (3,1,1);

insert into score(score_id,game_id,player_id) values (4,2,2);
insert into score(score_id,game_id,player_id) values (5,2,2);
insert into score(score_id,game_id,player_id) values (6,2,3);

insert into score(score_id,game_id,player_id) values (7,3,2);
insert into score(score_id,game_id,player_id) values (8,3,2);
insert into score(score_id,game_id,player_id) values (9,3,4);

insert into score(score_id,game_id,player_id) values (10,4,2);
insert into score(score_id,game_id,player_id) values (11,4,2);
insert into score(score_id,game_id,player_id) values (12,4,5);

insert into score(score_id,game_id,player_id) values (13,5,2);
insert into score(score_id,game_id,player_id) values (14,5,6);
insert into score(score_id,game_id,player_id) values (15,5,6);

insert into score(score_id,game_id,player_id) values (16,6,2);
insert into score(score_id,game_id,player_id) values (17,6,3);
