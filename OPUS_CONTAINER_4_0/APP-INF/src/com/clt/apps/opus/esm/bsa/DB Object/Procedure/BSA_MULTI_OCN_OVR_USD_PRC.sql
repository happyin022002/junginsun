CREATE OR REPLACE PROCEDURE OPUSADM."BSA_MULTI_OCN_OVR_USD_PRC" 
/******************************************************************************
   1.Name         : 
   2.Create Date  : 2009.05.20
   3.Description:
      - 용도: BSA Over Ocean Over Used Slot Price 저장
      - 파라미터: 
      - 특이사항
        (1) BSA OP JOB code 설명
                - Over Used Long Leg  : 020
                - Over Used Short Leg : 021
            
        (2) Example :
           
        
   4.Revision History                        
******************************************************************************/
-- ===== Arguments ========================================
( in_ibFlag                 IN VARCHAR          -- IB sheet flag, I(nsert),U(pdate),D(elete)
 ,in_bsa_slt_cost_tp_cd     IN VARCHAR          -- bsa_slt_cost_tp_cd, Master의 PK 
 ,in_ovr_usd_slt_prc_seq    IN VARCHAR          -- ovr_usd_slt_prc_seq, Master의 PK
 ,in_cntr_full_flg          IN VARCHAR          -- F:FULL E:EMPTY A:ALL
 ,in_trd_cd                 IN VARCHAR          -- Trade code
 ,in_rlane_cd               IN VARCHAR          -- Revenue Lane code
 ,in_dir_cd                 IN VARCHAR          -- Direction code
 ,in_vvd_cd                 IN VARCHAR          -- VVD code
 ,in_bsa_slt_prc_fm_dt      IN VARCHAR          -- From Date (예:20070101)
 ,in_bsa_slt_prc_to_dt      IN VARCHAR          -- To Date
 ,in_crr_cd                 IN VARCHAR          -- Carrier code
 ,in_uc_amt                 IN VARCHAR 
 ,in_user_id                IN VARCHAR          -- User ID
)
Authid current_user
IS

-- ===== DECLARE ==========================================
   v_max_ovr_usd_slt_prc_seq   bsa_ocn_ovr_mst.ovr_usd_slt_prc_seq%TYPE;
   v_success_flg VARCHAR2(1);
   v_para VARCHAR2(1000);
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
    v_success_flg := 'Y';
    v_para := '['||in_ibFlag || '][' || in_bsa_slt_cost_tp_cd
                             || '][' || in_ovr_usd_slt_prc_seq
                             || '][' || in_cntr_full_flg
                             || '][' || in_trd_cd
                             || '][' || in_rlane_cd
                             || '][' || in_dir_cd
                             || '][' || in_vvd_cd
                             || '][' || in_bsa_slt_prc_fm_dt
                             || '][' || in_bsa_slt_prc_to_dt
                             || '][' || in_crr_cd
                             || '][' || in_uc_amt
                             || '][' || in_user_id;
--    enis_log_prc('', 'BSA_MULTI_OCN_OVR_USD_PRC',v_para, 'v.20090522' );
    
    BEGIN   
        IF in_ibFlag = 'D' THEN
            UPDATE bsa_ocn_ovr_mst
               SET delt_flg = 'Y'
                  ,upd_usr_id = in_user_id
                  ,upd_dt = SYSDATE
             WHERE bsa_slt_cost_tp_cd  = in_bsa_slt_cost_tp_cd
               AND ovr_usd_slt_prc_seq = in_ovr_usd_slt_prc_seq
               AND trd_cd = in_trd_cd
               AND rlane_cd = in_rlane_cd
               AND dir_cd  = in_dir_cd
            ;
        ELSE   

--          0.ovr_usd_slt_prc_seq 설정 : in_ovr_usd_slt_prc_seq 없을 경우 MAX + 1로 설정
            IF (in_ovr_usd_slt_prc_seq = '' OR in_ovr_usd_slt_prc_seq IS NULL)
            THEN
                SELECT NVL(MAX(ovr_usd_slt_prc_seq), 0) + 1 AS max_ovr_usd_slt_prc_seq 
                  INTO v_max_ovr_usd_slt_prc_seq            
                  FROM bsa_ocn_ovr_mst
                 WHERE bsa_slt_cost_tp_cd = in_bsa_slt_cost_tp_cd
                   AND trd_cd = in_trd_cd
                   AND rlane_cd = in_rlane_cd
                   AND dir_cd  = in_dir_cd
                ;
            ELSE 
                v_max_ovr_usd_slt_prc_seq := TO_NUMBER(in_ovr_usd_slt_prc_seq);
            END IF;
            
--          1. Over Used Master Data Insert/Update
            MERGE INTO bsa_ocn_ovr_mst a1
              USING (SELECT in_bsa_slt_cost_tp_cd AS bsa_slt_cost_tp_cd
                           ,v_max_ovr_usd_slt_prc_seq AS ovr_usd_slt_prc_seq
                           ,in_cntr_full_flg AS cntr_full_flg
                           ,in_trd_cd AS trd_cd
                           ,in_rlane_cd AS rlane_cd
                           ,in_dir_cd AS dir_cd
                           ,in_vvd_cd AS vvd_cd
                           ,in_bsa_slt_prc_fm_dt AS bsa_slt_prc_fm_dt
                           ,in_bsa_slt_prc_to_dt AS bsa_slt_prc_to_dt
                           ,'N' AS delt_flg
                           ,in_user_id AS cre_usr_id
                           ,in_user_id AS upd_usr_id
                       FROM dual
                    ) a2
                 ON (    a1.bsa_slt_cost_tp_cd  = a2.bsa_slt_cost_tp_cd
                     AND a1.ovr_usd_slt_prc_seq = a2.ovr_usd_slt_prc_seq
                     AND a1.trd_cd = a2.trd_cd
                     AND a1.rlane_cd = a2.rlane_cd
                     AND a1.dir_cd = a2.dir_cd
                    )
              WHEN NOT MATCHED THEN
                INSERT( a1.bsa_slt_cost_tp_cd, a1.ovr_usd_slt_prc_seq, a1.cntr_full_flg
                       ,a1.trd_cd, a1.rlane_cd, a1.dir_cd, a1.vvd_cd
                       ,a1.bsa_slt_prc_fm_dt, a1.bsa_slt_prc_to_dt
                       ,a1.delt_flg, a1.cre_usr_id, a1.cre_dt, a1.upd_usr_id, a1.upd_dt)
                VALUES( a2.bsa_slt_cost_tp_cd, a2.ovr_usd_slt_prc_seq, a2.cntr_full_flg
                       ,a2.trd_cd, a2.rlane_cd, a2.dir_cd, a2.vvd_cd
                       ,a2.bsa_slt_prc_fm_dt, a2.bsa_slt_prc_to_dt
                       ,'N', a2.cre_usr_id, SYSDATE, a2.upd_usr_id, SYSDATE)
              WHEN MATCHED THEN
               UPDATE
                  SET 
--                      a1.trd_cd            = a2.trd_cd
--                     ,a1.rlane_cd          = a2.rlane_cd
--                     ,a1.dir_cd            = a2.dir_cd
                      a1.vvd_cd            = a2.vvd_cd
                     ,a1.bsa_slt_prc_fm_dt = a2.bsa_slt_prc_fm_dt
                     ,a1.bsa_slt_prc_to_dt = a2.bsa_slt_prc_to_dt
                     ,a1.cntr_full_flg     = a2.cntr_full_flg
                     ,a1.delt_flg          = a2.delt_flg
                     ,a1.upd_usr_id        = a2.upd_usr_id
                     ,a1.upd_dt            = SYSDATE
            ;
            
--          2. Over Used Slot Price Inset/Update[선사별]
            MERGE INTO bsa_ocn_ovr_slt_prc a1
              USING ( SELECT in_bsa_slt_cost_tp_cd AS bsa_slt_cost_tp_cd
                            ,v_max_ovr_usd_slt_prc_seq AS ovr_usd_slt_prc_seq
                            ,in_trd_cd AS trd_cd --
                            ,in_rlane_cd AS rlane_cd --
                            ,in_dir_cd AS dir_cd --
                            ,in_cntr_full_flg AS cntr_full_flg
                            ,SUBSTR( crr_cd
                                    ,INSTR(crr_cd, '|', 1, LEVEL) + 1
                                    ,INSTR(crr_cd, '|', 1, LEVEL + 1) - INSTR(crr_cd, '|', 1, LEVEL) - 1) AS crr_cd
                            ,TO_NUMBER(SUBSTR( uc_amt
                                              ,INSTR(uc_amt, '|', 1, LEVEL) + 1
                                              ,INSTR(uc_amt, '|', 1, LEVEL + 1) - INSTR(uc_amt, '|', 1, LEVEL) - 1)) AS uc_amt
                            ,in_user_id AS cre_usr_id
                            ,in_user_id AS upd_usr_id
                        FROM (SELECT in_crr_cd AS crr_cd
                                    ,in_uc_amt AS uc_amt
                                FROM dual)
                     CONNECT BY LEVEL <= LENGTH(crr_cd) - LENGTH(REPLACE(crr_cd, '|')) - 1
                    ) a2
                 ON (    a1.bsa_slt_cost_tp_cd  = a2.bsa_slt_cost_tp_cd
                     AND a1.ovr_usd_slt_prc_seq = a2.ovr_usd_slt_prc_seq
                     AND a1.trd_cd            = a2.trd_cd --
                     AND a1.rlane_cd          = a2.rlane_cd --
                     AND a1.dir_cd            = a2.dir_cd --
                     AND a1.crr_cd              = a2.crr_cd
                    )
               WHEN NOT MATCHED THEN
                    INSERT( a1.bsa_slt_cost_tp_cd, a1.ovr_usd_slt_prc_seq, a1.trd_cd, a1.rlane_cd, a1.dir_cd, a1.crr_cd, a1.uc_amt
                           ,a1.cre_usr_id, a1.cre_dt, a1.upd_usr_id, a1.upd_dt)
                    VALUES( a2.bsa_slt_cost_tp_cd, a2.ovr_usd_slt_prc_seq, a2.trd_cd, a2.rlane_cd, a2.dir_cd, a2.crr_cd, a2.uc_amt
                           ,a2.cre_usr_id, SYSDATE, a2.upd_usr_id, SYSDATE)
               WHEN MATCHED THEN
                    UPDATE
                       SET a1.uc_amt     = a2.uc_amt
                          ,a1.upd_usr_id = a2.upd_usr_id
                          ,a1.upd_dt     = SYSDATE
            ;
        END IF;            

    END;
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc('', 'BSA_MULTI_OCN_OVR_USD_PRC', 'ERROR: '||SQLERRM||', PARA : ' || v_para, '');
      RAISE;
    
END BSA_MULTI_OCN_OVR_USD_PRC;
-- ===== End of Function ==================================