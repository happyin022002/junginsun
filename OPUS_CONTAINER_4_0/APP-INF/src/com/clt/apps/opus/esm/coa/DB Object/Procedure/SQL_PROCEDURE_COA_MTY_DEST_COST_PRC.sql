CREATE OR REPLACE PROCEDURE OPUSADM."COA_MTY_DEST_COST_PRC" (in_cost_yrmon IN VARCHAR2)
Authid current_user 
IS
/******************************************************************************
   Name         :   COA_MTY_DEST_COST_PRC
   Purpose      :   EMU POD 하역비 단가 생성 (해당 년월 CNTR MVMT에 붙은 Steve 단가로부터 생성)
   Source       :   COA_CNTR_MTY_MVMT
   Target       :   COA_MTY_DEST_COST

******************************************************************************/

--------------------------------[     변수 선언   ]-----------------------

/** 작업로그 관련 변수선언 **/
BEGIN
   enis_log_prc(SYSDATE, 'COA_MTY_DEST_COST_PRC', 'V.20080611' || ' START');

---------------------------------[      BODY      ]-----------------------

   --STEP1 기존 데이터 삭제
   DELETE FROM coa_mty_dest_cost
         WHERE cost_yrmon = in_cost_yrmon;

   --STEP2 신규 데이터 등록 
   INSERT INTO coa_mty_dest_cost
               (cost_yrmon
               ,cost_loc_grp_cd
               ,cntr_org_dest_cd
               ,ecc_cd
               ,cntr_tpsz_cd
               ,sim_stvg_uc_amt
               ,mty_stvg_ttl_amt
               ,mty_qty
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT  cost_yrmon
              ,'E' -- ECC level 부터 만듬
              ,'D' -- POD 하역비므로 무조건 Dest
              ,coa_loc_fnc(yd_cd, 'ECC') ecc_cd
              ,cntr_tpsz_cd
              ,SUM(mty_stvg_ttl_amt)/count(*) --평균금액
              ,SUM(mty_stvg_ttl_amt) --total amount
              ,count(*) -- CNTR MVMT count
              ,'SYSTEM_COA_EMU'
              ,sysdate
              ,'SYSTEM_COA_EMU'
              ,sysdate  
        FROM coa_cntr_mty_mvmt
        WHERE cost_yrmon = in_cost_yrmon
        AND   NVL(mty_stvg_ttl_amt, 0) <> 0
        AND   MTY_COST_TP_CD = 'M'
        GROUP BY cost_yrmon, coa_loc_fnc(yd_cd, 'ECC'), cntr_tpsz_cd;
        
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- LCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////     
    INSERT INTO coa_mty_dest_cost
               (cost_yrmon
               ,cost_loc_grp_cd
               ,cntr_org_dest_cd
               ,ecc_cd
               ,cntr_tpsz_cd
               ,sim_stvg_uc_amt
               ,mty_stvg_ttl_amt
               ,mty_qty
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT  cost_yrmon
              ,'L' -- LCC level 
              ,'D' -- POD 하역비므로 무조건 Dest
              ,coa_loc_fnc(yd_cd, 'LCC') lcc_cd
              ,cntr_tpsz_cd
              ,SUM(mty_stvg_ttl_amt)/count(*) --평균금액
              ,SUM(mty_stvg_ttl_amt) --total amount
              ,count(*) -- CNTR MVMT count
              ,'SYSTEM_COA_EMU'
              ,sysdate
              ,'SYSTEM_COA_EMU'
              ,sysdate 
        FROM coa_cntr_mty_mvmt
        WHERE cost_yrmon = in_cost_yrmon
        AND   NVL(mty_stvg_ttl_amt, 0) <> 0
        AND   MTY_COST_TP_CD = 'M'
        GROUP BY cost_yrmon, coa_loc_fnc(yd_cd, 'LCC'),cntr_tpsz_cd;
            
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- RCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    INSERT INTO coa_mty_dest_cost
               (cost_yrmon
               ,cost_loc_grp_cd
               ,cntr_org_dest_cd
               ,ecc_cd
               ,cntr_tpsz_cd
               ,sim_stvg_uc_amt
               ,mty_stvg_ttl_amt
               ,mty_qty
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT  cost_yrmon
              ,'R' -- LCC level 
              ,'D' -- POD 하역비므로 무조건 Dest
              ,coa_loc_fnc(yd_cd, 'RCC') lcc_cd
              ,cntr_tpsz_cd
              ,SUM(mty_stvg_ttl_amt)/count(*) --평균금액
              ,SUM(mty_stvg_ttl_amt) --total amount
              ,count(*) -- CNTR MVMT count
              ,'SYSTEM_COA_EMU'
              ,sysdate
              ,'SYSTEM_COA_EMU'
              ,sysdate  
        FROM coa_cntr_mty_mvmt
        WHERE cost_yrmon = in_cost_yrmon
        AND   NVL(mty_stvg_ttl_amt, 0) <> 0
        AND   MTY_COST_TP_CD = 'M'
        GROUP BY cost_yrmon, coa_loc_fnc(yd_cd, 'RCC'), cntr_tpsz_cd;

   enis_log_prc(SYSDATE, 'COA_MTY_DEST_COST_PRC', 'End');
---------------------------------------------------------------------------------------------------------------------
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(SYSDATE, 'COA_MTY_DEST_COST_PRC', 'Error: ' || SQLERRM);
END coa_mty_dest_cost_prc;