CREATE OR REPLACE PROCEDURE OPUSADM."BSA_RESET_VVD_ZERO_PRC" 
    (
    p_trd_cd     IN VARCHAR2, -- Optional
    p_rlane_cd   IN VARCHAR2, -- Optional
    p_ioc_cd     IN VARCHAR2, -- Optional
    p_vsl_cd     IN VARCHAR2, -- Optional
    p_skd_voy_no IN VARCHAR2, -- Optional
    p_dir_cd     IN VARCHAR2, -- Optional
    p_user_id    IN VARCHAR2, -- Input User ID
    p_error_code OUT VARCHAR2,
    p_error_msg  OUT VARCHAR2
    )
Authid current_user
IS
/******************************************************************************
  Name         :   BSA_RESET_VVD_ZERO_PRC
  Purpose      :   대상항차 기준의 BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다
  Source       :   coa_mon_vvd,
  Target       :   bsa_vvd_mst, bsa_vvd_otr_crr, bsa_vvd_perf,
                   bsa_vvd_port_dwn, bsa_vvd_swap_info
  Ver          :   1.0                       
  Date         :   2007.10.  
  System       :   Sales ManageMent > Basic Slot Allotment
  Author       :   
  Used         :   ESM_COA_0029
******************************************************************************/
/* 
  1.Name       : 
  2.Create Date: 2007-10-
  3.Description: 
      - 용도: 1. 해당 조회조건의 대항항차 중 BSA Flag가 Y항차 선정
              2. BSA VVD의 CAPA정보를 0으로 UPDATE한다
      - 파라미터: 년,월,주차,trade,revenue lane,ioc,vsl
      - 특이사항 
        
  4.Revision History :          
*/ 

------------------------------- [ 커서 선언부    ] --------------------------------------

------------------------------- [ 변수 선언부    ] --------------------------------------
/** 작업로그 관련 변수선언 **/  
v_mig_pgm_nm       varchar2(100)  := 'BSA_RESET_VVD_ZERO_PRC' ; 
v_status_msg       varchar2(2000)                             ;
v_dtl_msg          varchar2(2000)                             ;
------------------------------- [ 업무로직 구현부] --------------------------------------
BEGIN
    DBMS_OUTPUT.ENABLE;
  
    enis_log_prc(SYSDATE, v_mig_pgm_nm, '---------------------------------------' , 'BSA VVD Zero');
    v_dtl_msg := '['|| p_trd_cd ||']['|| p_rlane_cd ||']['|| p_ioc_cd ||']['|| p_vsl_cd ||']['|| p_skd_voy_no ||']['|| p_dir_cd ||']['|| p_user_id ||']';

    enis_log_prc(SYSDATE, v_mig_pgm_nm, 'Info : ' || v_dtl_msg , 'BSA VVD Zero');  

    v_status_msg := '01) COA_MON_VVD 에 들어있는 BSA 정보를 0 으로 UPDATE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd,
--           co_bsa_rto, chtr_bsa_rto, vvd_bsa_capa
--      FROM coa_mon_vvd
     UPDATE coa_mon_vvd 
        SET co_bsa_rto  = '1',
            chtr_bsa_rto = '0',
            vvd_bsa_capa = '0',
            upd_usr_id   = p_user_id,
            upd_dt       = SYSDATE
      WHERE 1=1
        AND NVL(delt_flg,'N')  <> 'Y'
        AND NVL(bsa_zr_flg,'N') = 'Y'
        AND trd_cd              = NVL(p_trd_cd, trd_cd)
        AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
        AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
        AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
        AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
        AND dir_cd              = NVL(p_dir_cd, dir_cd)
--        AND cost_yrmon          LIKE p_year || '%'
--        AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--        AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    
    
    v_status_msg := '02) COA_BSA_VVD_MST 에있는 CAPA, 임대차 비용/수입을 0으로 UPDATE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd,
--           bsa_op_cd, ioc_cd, vop_cd, crr_cd, vsl_capa,
--           bsa_capa, fnl_co_bsa_capa, n2nd_fnl_co_bsa_capa, co_bsa_capa,
--           co_bsa_rto, chtr_bsa_rto, co_bsa_bfr_sub_capa,
--           expn_bzc_chtr_amt, expn_sub_chtr_amt, expn_crs_chtr_amt,
--           incm_bzc_chtr_amt, incm_sub_chtr_amt, incm_crs_chtr_amt,
--           free_add_teu_capa, free_add_wgt, spc_otr_swap_flg
--      FROM coa_bsa_vvd_mst
     UPDATE bsa_vvd_mst 
        SET bsa_capa              = '0',
            fnl_co_bsa_capa      = '0',
            n2nd_fnl_co_bsa_capa = '0',
            co_bsa_capa           = '0',
            co_bsa_rto           = '1',
            chtr_bsa_rto          = '0',
            co_bsa_bfr_sub_capa  = '0',
            expn_bzc_chtr_amt     = '0',
            expn_sub_chtr_amt     = '0',
            expn_crs_chtr_amt     = '0',
            incm_bzc_chtr_amt     = '0',
            incm_sub_chtr_amt     = '0',
            incm_crs_chtr_amt     = '0',
            free_add_teu_capa     = '0',
            free_add_wgt          = '0',
            spc_otr_swap_flg      = 'N',
            upd_usr_id            = p_user_id,
            upd_dt                = SYSDATE
      WHERE (trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd)
         IN (
             SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd
               FROM coa_mon_vvd
              WHERE 1=1
                AND NVL(delt_flg,'N')  <> 'Y'
                AND NVL(bsa_zr_flg,'N') = 'Y'
                AND trd_cd              = NVL(p_trd_cd, trd_cd)
                AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
                AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
                AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
                AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
                AND dir_cd              = NVL(p_dir_cd, dir_cd)
--                AND cost_yrmon          LIKE p_year || '%'
--                AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--                AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
           )
    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    
    
    v_status_msg := '03) COA_BSA_VVD_OTR_CRR 의 타선사의 CAPA정보를 0 으로 UPDATE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd,
--           crr_cd, crr_bsa_capa, spc_ctrl_slt_capa
--      FROM coa_bsa_vvd_otr_crr b      
     UPDATE bsa_vvd_otr_crr 
        SET crr_bsa_capa      = '0',
            spc_ctrl_slt_capa = '0',
            upd_usr_id        = p_user_id,
            upd_dt            = SYSDATE
      WHERE (trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd)
         IN (
             SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd
               FROM coa_mon_vvd
              WHERE 1=1
                AND NVL(delt_flg,'N')  <> 'Y'
                AND NVL(bsa_zr_flg,'N') = 'Y'
                AND trd_cd              = NVL(p_trd_cd, trd_cd)
                AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
                AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
                AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
                AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
                AND dir_cd              = NVL(p_dir_cd, dir_cd)
--                AND cost_yrmon          LIKE p_year || '%'
--                AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--                AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
           )

    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    
    
    v_status_msg := '04) COA_BSA_VVD_CRR_PERF 의 선사별 CAPA정보를 0 으로 UPDATE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd,
--           crr_cd, crr_bsa_capa, crr_perf_amt
--      FROM coa_bsa_vvd_crr_perf
     UPDATE bsa_vvd_crr_perf 
        SET crr_bsa_capa = '0',
            crr_perf_amt = '0',
            slt_prc_capa = '0', -- JOO 요청으로 Slot Price 추가
            upd_usr_id   = p_user_id,
            upd_dt       = SYSDATE
      WHERE (trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd)
         IN (
             SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd
               FROM coa_mon_vvd
              WHERE 1=1
                AND NVL(delt_flg,'N')  <> 'Y'
                AND NVL(bsa_zr_flg,'N') = 'Y'
                AND trd_cd              = NVL(p_trd_cd, trd_cd)
                AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
                AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
                AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
                AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
                AND dir_cd              = NVL(p_dir_cd, dir_cd)
--                AND cost_yrmon          LIKE p_year || '%'
--                AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--                AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
           )

    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    
    
    v_status_msg := '05) COA_BSA_VVD_PORT_DWN 의 선사별 PORT의 CAPA정보를 0 으로 UPDATE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd,
--           crr_cd, port_bsa_capa
--      FROM coa_bsa_vvd_port_dwn b
     UPDATE bsa_vvd_port_dwn 
        SET port_bsa_capa = '0',
            upd_usr_id    = p_user_id,
            upd_dt        = SYSDATE
      WHERE (trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd)
         IN (
             SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd
               FROM coa_mon_vvd
              WHERE 1=1
                AND NVL(delt_flg,'N')  <> 'Y'
                AND NVL(bsa_zr_flg,'N') = 'Y'
                AND trd_cd              = NVL(p_trd_cd, trd_cd)
                AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
                AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
                AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
                AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
                AND dir_cd              = NVL(p_dir_cd, dir_cd)
--                AND cost_yrmon          LIKE p_year || '%'
--                AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--                AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
           )
    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    
    
    v_status_msg := '06) COA_BSA_VVD_SWAP_INFO 의 해당 항차 정보를 DELETE';
--    SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd
--      FROM coa_bsa_vvd_swap_info 
      DELETE FROM bsa_vvd_swap_info 
      WHERE (trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd)
         IN (
             SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, dir_cd
               FROM coa_mon_vvd
              WHERE 1=1
                AND NVL(delt_flg,'N')  <> 'Y'
                AND NVL(bsa_zr_flg,'N') = 'Y'
                AND trd_cd              = NVL(p_trd_cd, trd_cd)
                AND rlane_cd            = NVL(p_rlane_cd, rlane_cd)
                AND ioc_cd              = NVL(p_ioc_cd, ioc_cd)
                AND vsl_cd              = NVL(p_vsl_cd, vsl_cd)
                AND skd_voy_no          = NVL(p_skd_voy_no, skd_voy_no)
                AND dir_cd              = NVL(p_dir_cd, dir_cd)
--                AND cost_yrmon          LIKE p_year || '%'
--                AND cost_wk             BETWEEN NVL(p_fm_week, cost_wk) AND NVL(p_to_week, cost_wk)
--                AND cost_yrmon          BETWEEN NVL(p_fm_yrmon, cost_yrmon) AND NVL(p_to_yrmon, cost_yrmon)
           )
    ;
    enis_log_prc(SYSDATE, v_mig_pgm_nm, v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'BSA VVD Zero'); 
    

    DBMS_OUTPUT.PUT_LINE('BSA_RESET_VVD_ZERO_PRC OK');
    p_error_code := '00000';
    p_error_msg  := 'Completed!';
--    COMMIT;
--------------------- [ 예외 처리부    ] --------------------------------------
EXCEPTION                  
    WHEN OTHERS THEN   
         p_error_code   := SQLCODE;
         p_error_msg    := '[BSA VVD ZERO PRC] : Failed to Create BSA VVD INFO : [' || v_status_msg || '][' || v_dtl_msg || '][' || SQLCODE || ']['|| SQLERRM || ']';
         DBMS_OUTPUT.PUT_LINE( p_error_msg || ':'||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
         enis_log_prc(SYSDATE, v_mig_pgm_nm, p_error_msg , 'Exception'); 
END BSA_RESET_VVD_ZERO_PRC;