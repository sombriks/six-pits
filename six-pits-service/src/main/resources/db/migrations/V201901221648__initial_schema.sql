-- our core entities are player, game and score

create table player (
  player_id integer not null primary key auto_increment,
  player_creation timestamp not null default CURRENT_TIMESTAMP(),
  player_name varchar(255) unique not null,
  player_hash varchar(255) not null,
  player_status_id integer not null default 1,
  foreign key (player_status_id) references player_status(player_status_id)
);

create table game (
  game_id integer not null primary key auto_increment,
  game_creation timestamp not null default CURRENT_TIMESTAMP(),
  game_status_id integer not null default 1,
  player_id_1 integer not null,
  player_id_2 integer not null,
  foreign key (game_status_id) references game_status(game_status_id),
  foreign key (player_id_1) references player(player_id),
  foreign key (player_id_2) references player(player_id)
);

create table score (
  score_id integer not null primary key auto_increment,
  score_creation timestamp not null default CURRENT_TIMESTAMP(),
  score_points integer not null default 1,
  game_id integer not null,
  player_id integer not null,
  foreign key (game_id) references game(game_id) on delete cascade,
  foreign key (player_id) references player(player_id) on delete cascade
);