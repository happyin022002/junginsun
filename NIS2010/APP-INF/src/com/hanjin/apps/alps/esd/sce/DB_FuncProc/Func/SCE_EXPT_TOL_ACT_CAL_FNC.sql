CREATE OR REPLACE FUNCTION SCE_EXPT_TOL_ACT_CAL_FNC

(in_act_cd           IN    VARCHAR2
,in_loc_cd           IN    VARCHAR2
,in_cop_no           IN    VARCHAR2
--,in_cop_grp_seq      IN    VARCHAR2
,in_expt_tp_cd       IN    VARCHAR2
)
RETURN NUMBER
AUTHID CURRENT_USER
IS
/****************************************************************************************************************************
   Name     :   SCE_EXPT_TOL_ACT_CAL_FNC 2008년도 COP Exception 재개발 (2008/04~2008/05)
   Purpose  :   FROM-TO activity사이의 Tolerance를 구함
   Ver      :   1.0
   Author   :   SCEM
   Date     :   2008.04.24 JSAN
   Related  :   SCE_TIME_CHK_EXPT_ACT_PRC(called)
   Update   :   2008.06.03 JSAN 해당Tolerance의 Yard구하기 보완(우선순위:YARD>LOCATION>ALL)
                2008.07.30 JSAN Exception추가에 따른 Tolerance 보완(Activity보완)
                2008.07.31 JSAN Exception추가에 따른 Tolerance 보완(ExceptionType보완)
****************************************************************************************************************************/

v_noact_flg                VARCHAR2(1); 
V_FOML_PCT_NO               VARCHAR2(3);
V_FOML_TM_DY               VARCHAR2(2);
V_FOML_TM_HR               VARCHAR2(2);
V_FOML_TM_MNT               VARCHAR2(2);
V_T_COND_TM_HR             NUMBER;
V_YD_CD                       VARCHAR2(7);


v_result                   VARCHAR2(10);
v_loc_cd                   VARCHAR2(7);
v_min_cop_grp_seq          NUMBER;
v_tol_cond_cd              VARCHAR2(1);
v_c_cond_tm_hr             NUMBER;
v_act_flg                  VARCHAR2(1);

BEGIN

    --1.YARD>LOCATION>ALL
    
    BEGIN
    

        SELECT FOML_PCT_NO, FOML_TM_DY, FOML_TM_HR, FOML_TM_MNT, YD_CD
               INTO  V_FOML_PCT_NO, V_FOML_TM_DY, V_FOML_TM_HR, V_FOML_TM_MNT, V_YD_CD 
        FROM (SELECT (CASE WHEN YD_CD = in_loc_cd THEN FOML_PCT_NO
                      WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_PCT_NO 
                      WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_PCT_NO END) FOML_PCT_NO
                    ,(CASE WHEN YD_CD = in_loc_cd THEN FOML_TM_DY
                           WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_DY 
                           WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_DY END) FOML_TM_DY
                    ,(CASE WHEN YD_CD = in_loc_cd THEN FOML_TM_HR
                           WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_HR 
                           WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_HR END) FOML_TM_HR
                    ,(CASE WHEN YD_CD = in_loc_cd THEN FOML_TM_MNT
                           WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_MNT 
                           WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN FOML_TM_MNT END) FOML_TM_MNT 
                    ,YD_CD
                    ,(CASE WHEN LENGTH(in_loc_cd) = 7 AND YD_CD = in_loc_cd THEN '1'
                           WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN '2' 
                           WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5)  AND YD_CD <> in_loc_cd THEN '3' 
                           ELSE 'X' END) PRI_VAL      
              FROM   SCE_EXPT_TOL
              WHERE  ACT_CD     =  SUBSTR(in_act_cd,1,6)
              AND    NXT_ACT_CD =  (case when in_expt_tp_cd = '1' or in_expt_tp_cd = '4' then SUBSTR(in_act_cd,7,6) else 'X' end) 
              AND  ( YD_CD      LIKE SUBSTR(in_loc_cd,1,5)||'%'||'%'  OR  YD_CD      =  'ALL' )
              AND    ACT_FLG    =  'Y'
              AND    COP_EXPT_TP_CD = in_expt_tp_cd
              ) A
        WHERE A.PRI_VAL = (SELECT MIN(PRI_VAL)
                           FROM (SELECT YD_CD
                               ,(CASE WHEN LENGTH(in_loc_cd) = 7 AND YD_CD = in_loc_cd THEN '1'
                                      WHEN YD_CD = SUBSTR(in_loc_cd,1,5) AND YD_CD <> in_loc_cd THEN '2' 
                                      WHEN YD_CD = 'ALL' AND YD_CD <> SUBSTR(in_loc_cd,1,5)  AND YD_CD <> in_loc_cd THEN '3' 
                                      ELSE 'X' END) PRI_VAL      
                           FROM   SCE_EXPT_TOL
                           WHERE  ACT_CD     =  SUBSTR(in_act_cd,1,6)
                           AND    NXT_ACT_CD =  (case when in_expt_tp_cd = '1' or in_expt_tp_cd = '4' then SUBSTR(in_act_cd,7,6) else 'X' end) 
                           AND  ( YD_CD      LIKE SUBSTR(in_loc_cd,1,5)||'%'||'%'  OR  YD_CD      =  'ALL' )
                           AND    ACT_FLG    =  'Y'
                           AND    COP_EXPT_TP_CD = in_expt_tp_cd
                           ) A
                           WHERE A.PRI_VAL <> 'X' );
        
        v_noact_flg := 'N';  
        
    EXCEPTION
        WHEN OTHERS THEN
        /* v_noact_flg가 'Y'인 경우
               1.해당From-To Activity 없음
               2.YARD>LOCATION>ALL 해당Location 없음 */
        v_noact_flg := 'Y';

    END; 


    /* 해당 Tolerance 존재 */
    IF v_noact_flg = 'N'  THEN
        --2.Tolarance 시간 계산 : Departure인 경우 이전 cop그룹의 시간
        IF V_FOML_PCT_NO IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('V_FOML_PCT_NO IS NULL');
        -- 테스트를 위해 일단 막아놈, 나중에 풀 것
        /*
            IF SUBSTR(in_act_cd, 11, 1) = 'D' THEN
            
                SELECT tz_dwll_tm_hrs * TO_NUMBER(V_FOML_PCT_NO) /100 INTO V_T_COND_TM_HR
                FROM   sce_cop_grp
                WHERE  cop_no = in_cop_no
                AND    cop_grp_seq = ( SELECT max(cop_grp_seq)
                                       FROM   sce_cop_grp
                                       WHERE  cop_no = in_cop_no
                                       AND    cop_grp_seq < :in_cop_grp_seq);            
            ELSE
    
                SELECT tz_dwll_tm_hrs * TO_NUMBER(V_FOML_PCT_NO) /100 INTO V_T_COND_TM_HR
                FROM   sce_cop_grp
                WHERE  cop_no = in_cop_no
                AND    cop_grp_seq = :in_cop_grp_seq;
                
            END IF;
            */
            
        END IF;
    
        --NXT_ACT_CD = 'X'는 VESSEL EXCEPTION의 경우   
        SELECT (CASE WHEN (V_FOML_TM_DY||V_FOML_TM_HR||V_FOML_TM_MNT) IS NULL THEN  V_T_COND_TM_HR
                     WHEN (V_FOML_TM_DY||V_FOML_TM_HR||V_FOML_TM_MNT) IS NOT NULL 
                     THEN (TO_NUMBER(V_FOML_TM_DY)*24*60 
                         + TO_NUMBER(V_FOML_TM_HR)*60 
                         + TO_NUMBER(V_FOML_TM_MNT))
                END ) 
                INTO v_result
        FROM   SCE_EXPT_TOL
        WHERE  ACT_CD     =  SUBSTR(in_act_cd,1,6)
        AND    NXT_ACT_CD =  NVL(SUBSTR(in_act_cd,7,6),'X')
        AND    yd_cd       = V_YD_CD
        AND    COP_EXPT_TP_CD = in_expt_tp_cd; 
       
    ELSE
            
        v_result := 9999999;
            
    END IF; 
 
    RETURN v_result;
    EXCEPTION
        WHEN OTHERS THEN
--              DBMS_OUTPUT.PUT_LINE('[Error : sce_expt_tol_cal_fnc] '); 
--            DBMS_OUTPUT.PUT_LINE('STEP['||v_step||'] ' || SQLERRM);
        RETURN 0;
END SCE_EXPT_TOL_ACT_CAL_FNC;
/
