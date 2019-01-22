-- first we make statuses

create table player_status (
  player_status_id integer not null primay key,
  player_status_description varchar(255) unique not null
);

create table game_status (
  game_status_id integer not null primay key,
  game_status_description varchar(255) unique not null
);