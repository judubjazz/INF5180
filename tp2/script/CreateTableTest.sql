SELECT
  table_name, owner
FROM
  all_tables
WHERE
  owner='JU'
ORDER BY
  owner, table_name;