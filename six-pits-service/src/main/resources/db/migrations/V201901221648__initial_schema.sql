-- our core entities are player, game and score

create table player (
  player_id integer not null primay key autoincrement,
  player_creation timestamp not null default CURRENT_TIMESTAMP(),
  player_name varchar(255) unique not null,
  player_hash varchar(255) not null,
  player_status_id integer not null default 1,
  foreign key (player_status_id) references player_status(player_status_id)
);

create table game (
  game_id integer not null primary key autoincrement,
  
);