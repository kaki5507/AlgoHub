
 
 SELECT SCORE, EMP_NO, EMP_NAME, POSITION , EMAIL
   FROM (SELECT RANK() OVER(ORDER BY SUM(B.SCORE) DESC) AS RNK,
                A.EMP_NO,
                A.EMP_NAME,
                A.POSITION,
                A.EMAIL,
                SUM(B.SCORE) AS SCORE
           FROM HR_EMPLOYEES A
           JOIN HR_GRADE B
             ON A.EMP_NO = B.EMP_NO
          WHERE B.YEAR = '2022'
       GROUP BY A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
                ) C
    WHERE RNK = 1