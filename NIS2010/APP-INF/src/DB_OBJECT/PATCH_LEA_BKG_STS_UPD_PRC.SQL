CREATE OR REPLACE PROCEDURE LEAADM.PATCH_LEA_BKG_STS_UPD_PRC (rev_yrmon_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : ???
  2.Create Date: 2007-03-02
  3.Description:
      - ??: ???? ??? LEA_ACCL_DTL?? Cost code?? Accrual ??
      - ????: ??????(in_exeyrmon(Format:'YYYYMM'))
      - ????
        (1) Accrual ?? ??? ???? Function(lea_accl_cal_fnc)?
            ?? ??  ????? Update ??
  4.Revision History
    2007-03-02:???:????.
*******************************************************************************/
   /* Variable Declare --------------------------------------------------------*/
   v_cur_idx       NUMBER := 0;
   
  
   /* Cursor Declare ------------------------------------------------------------*/
   CURSOR bkg_sts_upd_cur
   IS
      select /*+ parallel(i,40) parallel(d,40) */
      i.bkg_no, i.bkg_no_split, i.cntr_no, i.cost_act_grp_seq, i.coa_cost_src_cd,
      i.bkg_sts_cd ibkg_sts_cd, d.bkg_sts_cd dbkg_sts_cd,
      CASE
          WHEN i.thrp_rt_flg = 'Y' THEN 'N'                      
          --Booking's Status ? Waiting ?? ????? ???? Accrual ???? ??('N') 
          --WHEN i.bkg_sts_cd ='W' THEN 'N'
          WHEN i.bkg_sts_cd = 'W' OR i.bkg_sts_cd = 'X' OR i.bkg_sts_cd = 'S' THEN 'N'
          --Dispatch CNTR? ???? Mapping,Allocate ???? ??
          WHEN i.delt_flg = 'Y' THEN 'N'
          --?? ??? NOBC? NIBC? ???? TMNDFL, TMFDFL Cost? ???? ??? Hard coding ??
          WHEN (i.cost_act_grp_cd = 'NOBC' OR i.cost_act_grp_cd = 'NIBC')
             AND
               (i.coa_cost_src_cd = 'TMNDFL' OR i.coa_cost_src_cd = 'TMFDFL') THEN 'N'
          ELSE 'Y'
      END  mapg_aloc_flg --mapg_aloc_flg(Mapping Allocate flag)
      from lea_estm_cost_if i, lea_accl_dtl d
      where 1=1
      and i.bkg_no = d.bkg_no
      and i.bkg_no_split = d.bkg_no_split
      and i.cntr_no = d.cntr_no
      and i.cost_act_grp_seq = d.cost_act_grp_seq
      and i.coa_cost_src_cd = d.coa_cost_src_cd
      and i.estm_upd_flg = 'N'
      and d.rev_yrmon = rev_yrmon_in
      and i.bkg_sts_cd <> d.bkg_sts_cd
   ;


BEGIN
   
   lea_log_prc ('patch_lea_bkg_sts_upd_prc() start.' || rev_yrmon_in );

   FOR upd IN bkg_sts_upd_cur
   LOOP
      v_cur_idx := v_cur_idx + 1;  --Update Data Counter
      
      UPDATE lea_accl_dtl
      set bkg_sts_cd = upd.ibkg_sts_cd,
          mapg_aloc_flg = upd.mapg_aloc_flg,
          upd_usr_id = 'PATCH_DELT_FLG',
          upd_dt = SYSDATE          
      where bkg_no = upd.bkg_no
      and bkg_no_split = upd.bkg_no_split
      and cntr_no = upd.cntr_no
      and cost_act_grp_seq = upd.cost_act_grp_seq
      and coa_cost_src_cd = upd.coa_cost_src_cd
      ;

      --10000 ?? ??? Commit
      IF MOD(v_cur_idx, 10000) = 0 THEN
         lea_log_prc('Working.....' || v_cur_idx); 
         COMMIT;
      END IF;
      
    
     
   END LOOP;
   
    
   lea_log_prc ('patch_lea_bkg_sts_upd_prc() end.('||v_cur_idx||')');
   
   commit;
   
   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
       
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE); 
END;