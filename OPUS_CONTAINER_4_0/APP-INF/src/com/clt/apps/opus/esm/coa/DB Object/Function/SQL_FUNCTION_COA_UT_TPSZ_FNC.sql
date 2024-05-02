CREATE OR REPLACE FUNCTION OPUSADM."COA_UT_TPSZ_FNC" 
/******************************************************************************
   Name         :   COA_UT_TPSZ_FNC
   Purpose      :   COST_UT_AMT_CD 와 CNTR_TPSZ_CD 로 TPSZ 조회
   Source       :
   Target       :  
   Example      :
   SELECT coa_ut_tpsz_fnc ('SIZ', 'D4') AS cntr_tpsz_cd
     FROM DUAL

   SELECT coa_ut_tpsz_fnc (NULL, 'D4') AS cntr_tpsz_cd
     FROM DUAL
******************************************************************************/

-- ===== Arguments ========================================
(in_cost_ut_amt_cd IN VARCHAR, in_cntr_tpsz_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_rslt_tpsz_cd   coa_nod_avg_stnd_cost.cntr_tpsz_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
--/////////////////////////////////////////////////////////////////////////////////////////////////////
-- SPCL TPSZ 변환
-- SPCL : A2 A4 D8 D9 DW DX F2 F4 F5 O2 O4 P2 P4 Q2 Q4 R4 R7 S2 S4 T2 T4
---------------->> 2008.09.09 변경 후
-- F2 : A2, F2
-- F4 : A4, F4, F5
-- O4 : O2, S2
-- O4 : O4, S4
-- T2 : T2
-- T4 : T4
-- 기타 SPCL tpsz는 기존과 같이 SP2, SP4 구분함.
--/////////////////////////////////////////////////////////////////////////////////////////////////////
   
      BEGIN
         IF (in_cost_ut_amt_cd = 'TPS')                 -- Type Size
         THEN
            v_rslt_tpsz_cd := in_cntr_tpsz_cd;
         ELSIF (   in_cost_ut_amt_cd = 'SIZ'
                OR in_cost_ut_amt_cd = 'SZ')            -- Sizw
         THEN
            IF (SUBSTR(in_cntr_tpsz_cd, -1) = '2')
            THEN
               v_rslt_tpsz_cd := '20';
            ELSE
               v_rslt_tpsz_cd := '40';
            END IF;
         ELSIF (in_cost_ut_amt_cd = 'BOX')              -- BOX
         THEN
            v_rslt_tpsz_cd := 'BOX';
         ELSE
            v_rslt_tpsz_cd := in_cntr_tpsz_cd;          -- 해당사항이 없으면 자신의 타입을 리턴
         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            BEGIN
               v_rslt_tpsz_cd := in_cntr_tpsz_cd;
            END;
      END;
      
   IF (in_cost_ut_amt_cd = 'TPS' OR in_cost_ut_amt_cd IS NULL) --인자가 null일경우에도 SPCL CNTR 체크하여 return
   THEN
       BEGIN
--          SELECT DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', 'SP2', 'SP4')
          SELECT spcl_cntr_tpsz_cd
            INTO v_rslt_tpsz_cd
            FROM coa_spcl_repo_cntr_rgst
           WHERE list_bx_set_lvl_cd = '0001'
             AND spcl_cgo_flg = 'Y'
             AND delt_flg = 'N'
             AND cntr_tpsz_cd = in_cntr_tpsz_cd;
       EXCEPTION
          WHEN OTHERS
          THEN
             BEGIN
                v_rslt_tpsz_cd := in_cntr_tpsz_cd;
             END;
       END;       
   END IF;
   

   RETURN v_rslt_tpsz_cd;
END;
-- ===== End of Function ==================================