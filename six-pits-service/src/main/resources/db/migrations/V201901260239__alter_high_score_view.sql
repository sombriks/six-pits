
create or replace view vw_high_score as 
select 
  player_id,
  count(game_id) as games,
  sum(sc_points) as points 
from 
  (select 
    player_id,
    game_id,
    sum(score_points) as sc_points 
  from 
    score
  group by
    player_id, game_id) t1
group by
  player_id
order by
  points, games