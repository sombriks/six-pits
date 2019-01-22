-- this is to sample that complex joins always should be solved as views when possible, keeping JPA queries as simple as
-- possible.

create view vw_high_score as 
select 
  player_id,
  count(game_id) as games,
  sum(score_points) as points 
from 
  score
group by
  player_id
order by
  points, games