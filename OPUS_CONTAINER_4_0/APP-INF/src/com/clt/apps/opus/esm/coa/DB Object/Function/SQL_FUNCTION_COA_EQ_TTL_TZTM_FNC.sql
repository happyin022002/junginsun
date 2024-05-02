CREATE OR REPLACE FUNCTION OPUSADM."COA_EQ_TTL_TZTM_FNC" (in_yyyymm IN VARCHAR, in_por_cd IN VARCHAR, in_del_cd IN VARCHAR,in_tpsz_cd IN VARCHAR)
   RETURN NUMBER   -- RETURN TYPE
   Authid current_user
/******************************************************************************
   Name         :   COA_EQ_TTL_TZTM
   Purpose      :   장비 POR-DEL까지의 일수 구하기
   Source       :   coa_rout_dys_if_mgmt
   Target       :
   Example      :
   SELECT COA_EQ_TTL_TZTM ('200705','KRPUS','USLGB','D4')
   FROM DUAL  

******************************************************************************/

IS
-- ===== DECLARE ==========================================
   v_eq_dys coa_rout_dys_if_mgmt.EQ_DYS%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
        SELECT NVL2(e_days,e_days,r_days)
          into v_eq_dys
          FROM (              
            SELECT MIN(DECODE(cost_loc_grp_cd,'E',eq_dys)) e_days,
                   MIN(DECODE(cost_loc_grp_cd,'R',eq_dys)) r_days
             FROM coa_rout_dys_if_mgmt a1
            WHERE a1.cost_yr         = SUBSTR(in_yyyymm, 1, 4)
              AND a1.cntr_tpsz_cd    = in_tpsz_cd
              AND a1.cost_loc_grp_cd IN('E','R')   -- ECC
              AND (
                    (    a1.org_loc_cd  = coa_loc_fnc(in_por_cd, 'ECC') 
                     AND a1.dest_loc_cd = coa_loc_fnc(in_del_cd, 'ECC'))
                  OR (   a1.org_loc_cd  = coa_loc_fnc(in_por_cd, 'RCC') 
                     AND a1.dest_loc_cd = coa_loc_fnc(in_del_cd, 'RCC'))
                  )
           )
        ;
   RETURN v_eq_dys;
END;
-- ===== End of Function ==================================