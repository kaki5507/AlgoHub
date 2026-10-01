SELECT ID, CASE WHEN (RNK / CNT) * 100 <= 25 THEN 'CRITICAL'
            WHEN (RNK / CNT) * 100 <= 50 THEN 'HIGH'
            WHEN (RNK / CNT) * 100 <= 75 THEN 'MEDIUM'
            ELSE 'LOW' END AS COLONY_NAME
  FROM (
        SELECT  ID
                ,RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS RNK
                ,COUNT(1) OVER() AS CNT
          FROM ECOLI_DATA
       ) T
 ORDER BY ID