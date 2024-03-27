-- Created the tables in postgres locally and tested it on my machine --

SELECT training.user_id,
       my_user.username,
       training.training_id,
       training.training_date,
       COUNT(training.training_id) AS "count"
FROM "User" AS my_user
JOIN training_details AS training ON my_user.user_id = training.user_id
GROUP BY training.user_id, my_user.username, training.training_id, training.training_date
HAVING COUNT(training.training_id) > 1
ORDER BY training.training_date DESC;
