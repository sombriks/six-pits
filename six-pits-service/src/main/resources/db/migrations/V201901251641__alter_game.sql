-- adding missing information on game table

alter table game add column game_turn integer not null default 1;
alter table game add column game_pit1_player1 integer not null default 6;
alter table game add column game_pit2_player1 integer not null default 6;
alter table game add column game_pit3_player1 integer not null default 6;
alter table game add column game_pit4_player1 integer not null default 6;
alter table game add column game_pit5_player1 integer not null default 6;
alter table game add column game_pit6_player1 integer not null default 6;
alter table game add column game_pit1_player2 integer not null default 6;
alter table game add column game_pit2_player2 integer not null default 6;
alter table game add column game_pit3_player2 integer not null default 6;
alter table game add column game_pit4_player2 integer not null default 6;
alter table game add column game_pit5_player2 integer not null default 6;
alter table game add column game_pit6_player2 integer not null default 6;
alter table game add column game_big_pit_player1 integer not null default 0;
alter table game add column game_big_pit_player2 integer not null default 0;
