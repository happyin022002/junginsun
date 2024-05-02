CREATE OR REPLACE FUNCTION SCE_COP_SKD_LGC_CAL_FNC

(in_cop_foml_cd      IN    VARCHAR2
,in_tz_dwll_tm_hrs   IN    NUMBER
,in_date_bef         IN    DATE
,in_date_aft         IN    DATE
,in_pct_value        IN    NUMBER
,in_tm_value         IN    NUMBER
)

RETURN date
authid current_user 
IS

v_result          DATE;
v_pct_value       NUMBER;
v_tz_dwll_tm_hrs  NUMBER;

BEGIN

     v_tz_dwll_tm_hrs := in_tz_dwll_tm_hrs;
     v_pct_value      := in_pct_value;


    IF in_pct_value IS NULL THEN
           v_pct_value      := 0;
    END IF;

    IF in_tz_dwll_tm_hrs IS NULL THEN
           v_tz_dwll_tm_hrs      := 0;
    END IF;

    IF in_cop_foml_cd = '+' THEN

           SELECT  TO_DATE(TO_CHAR(TO_TIMESTAMP(TO_CHAR(in_date_bef, 'YYYYMMDDHH24MISS'), 'YYYYMMDDHH24MISS')
                           + (NUMTODSINTERVAL(NVL(v_tz_dwll_tm_hrs / 2,0) * v_pct_value / 100, 'HOUR'))
                           ,'YYYYMMDDHH24MISS'),'YYYYMMDDHH24MISS')

           INTO v_result
           FROM DUAL;

    ELSIF in_cop_foml_cd = '-' THEN

           SELECT  TO_DATE(TO_CHAR(TO_TIMESTAMP(TO_CHAR(in_date_aft, 'YYYYMMDDHH24MISS'), 'YYYYMMDDHH24MISS')
                           - (NUMTODSINTERVAL(NVL(v_tz_dwll_tm_hrs / 2,0) * v_pct_value / 100, 'HOUR'))
                           ,'YYYYMMDDHH24MISS'),'YYYYMMDDHH24MISS')
           INTO v_result
           FROM DUAL;

    END IF;

    RETURN v_result;

END;
/
