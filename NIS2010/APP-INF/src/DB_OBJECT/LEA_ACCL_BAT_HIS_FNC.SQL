CREATE OR REPLACE FUNCTION LEAADM.LEA_ACCL_BAT_HIS_FNC (
   bat_his_rec_in   IN   lea_bat_pkg.bat_his_rec,
   mode_in          IN   VARCHAR2
)
   RETURN VARCHAR
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도:
      - 파라미터:
      - 특이사항
        (1)
  4.Revision History
    2007-02-02:김상모
*******************************************************************************/
   PRAGMA AUTONOMOUS_TRANSACTION;   -- COMMIT Control
   
   v_bat_id   lea_accl_bat_his.bat_id%TYPE;
BEGIN
   --lea_log_prc (   '@@@lea_accl_bat_his_fnc() called, parameter exe_yrmon:' || bat_his_rec_in.exe_yrmon || ' bat_id:' || bat_his_rec_in.bat_id || ' mode:' || mode_in);
   --lea_log_prc('bat_his_rec_in.bat_cmpl_flg: '||bat_his_rec_in.bat_cmpl_flg);
   CASE mode_in
      WHEN 'BS'
      THEN                                      --Batch History Start(Insert)
         INSERT INTO lea_accl_bat_his
                     (exe_yrmon,
                      bat_id, bat_st_dt, bat_cmpl_flg,
                      bat_rmk, cre_dt
                     )
              VALUES (bat_his_rec_in.exe_yrmon,
                      TO_CHAR (SYSDATE, 'yyyymmddhh24miss'), SYSDATE, 'N',
                      bat_his_rec_in.bat_rmk, SYSDATE
                     );

         -- Get Max Bat ID
         SELECT /*+ INDEX_DESC( lea_accl_bat_his XPKLEA_ACCL_BAT_HIS ) */
                bat_id
           INTO v_bat_id
           FROM lea_accl_bat_his
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon AND ROWNUM = 1;

      WHEN 'BC'
      THEN                                    --Batch History Complete(Update)
         UPDATE lea_accl_bat_his
            SET bat_end_dt = SYSDATE,
                bat_cmpl_flg = bat_his_rec_in.bat_cmpl_flg,
                bat_rmk = bat_his_rec_in.bat_rmk
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon
            AND bat_id = bat_his_rec_in.bat_id;

      WHEN 'BE'
      THEN                                 --Batch History (New) Estimate Cost
         UPDATE lea_accl_bat_his
            SET estm_st_dt = bat_his_rec_in.estm_st_dt,
                estm_end_dt = bat_his_rec_in.estm_end_dt,
                estm_knt = bat_his_rec_in.estm_knt
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon
            AND bat_id = bat_his_rec_in.bat_id;

      WHEN 'BU'
      THEN                                --Batch History Update Estimate Cost
         UPDATE lea_accl_bat_his
            SET estm_upd_st_dt = bat_his_rec_in.estm_upd_st_dt,
                estm_upd_end_dt = bat_his_rec_in.estm_upd_end_dt,
                estm_upd_knt = bat_his_rec_in.estm_upd_knt
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon
            AND bat_id = bat_his_rec_in.bat_id;

      WHEN 'MA'
      THEN                                --Batch History Update Actual Cost Mapping, Allocate(PART)
         UPDATE lea_accl_bat_his
            SET mapg_aloc_st_dt  = bat_his_rec_in.mapg_aloc_st_dt,
                mapg_aloc_end_dt = bat_his_rec_in.mapg_aloc_end_dt,
                mapg_aloc_knt    = bat_his_rec_in.mapg_aloc_knt
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon
            AND bat_id    = bat_his_rec_in.bat_id;      
      
      WHEN 'AC'
      THEN                                --Batch History Update Accrual Cost Calculation
         UPDATE lea_accl_bat_his
            SET accl_st_dt = bat_his_rec_in.accl_st_dt,
                accl_end_dt = bat_his_rec_in.accl_end_dt,
                accl_knt = bat_his_rec_in.accl_knt
          WHERE exe_yrmon = bat_his_rec_in.exe_yrmon
            AND bat_id = bat_his_rec_in.bat_id;            
   END CASE;


   IF mode_in = 'BS' OR mode_in = 'BC' THEN
      /* Batch Program Status(Running, Normal or Abnormal Completed */
      UPDATE lea_accl_cond_itm
         SET accl_bat_sts_cd = bat_his_rec_in.accl_bat_sts_cd
       WHERE exe_yrmon = bat_his_rec_in.exe_yrmon;
   END IF;
    
   COMMIT;
   
   RETURN v_bat_id;
   
   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);     
END;