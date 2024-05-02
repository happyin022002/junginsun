CREATE OR REPLACE PROCEDURE OPUSADM."BSA_HIGH_CUBIC_RT_PRC" 
/******************************************************************************
   1.Name         :   
   2.Create Date  : 2009.06.23
   3.Description:
      - 용도: BSA High Cubic Rate 저장  
      - 파라미터: 
      - 특이사항
        
   4.Revision History      
******************************************************************************/
-- ===== Arguments ========================================
( in_ibFlag                 IN VARCHAR          -- IB sheet flag, I(nsert),U(pdate),D(elete)
 ,in_cntr_tpsz_cd           IN VARCHAR          -- cntr_tpsz_cd, Master의 PK 
 ,in_bsa_seq                IN VARCHAR          -- bsa_seq, Master의 PK
 ,in_vop_cd                 IN VARCHAR          -- OPU:자선사 운영,  OTH:타선사 운항
 ,in_trd_cd                 IN VARCHAR          -- Trade code
 ,in_rlane_cd               IN VARCHAR          -- Revenue Lane code
 ,in_dir_cd                 IN VARCHAR          -- Direction code
 ,in_vvd_cd                 IN VARCHAR          -- VVD code
 ,in_bsa_fm_dt              IN VARCHAR          -- From Date (예:20070101)
 ,in_bsa_to_dt              IN VARCHAR          -- To Date
 ,in_crr_cd                 IN VARCHAR          -- Carrier code
 ,in_hc_rt                  IN VARCHAR          -- within rate (D7에만 존재)
 ,in_hc_ovr_rt              IN VARCHAR          -- over rate (D3,D5,D7 모두 존재)
 ,in_rt_tp_flg              IN VARCHAR          -- R:RATE V:VOID 
 ,in_user_id                IN VARCHAR          -- User ID
)
Authid current_user
IS

-- ===== DECLARE ==========================================
   v_max_bsa_seq   bsa_high_cubic_rt_mst.bsa_seq%TYPE;
   v_success_flg VARCHAR2(1);
   v_para VARCHAR2(4000);
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
    v_success_flg := 'Y';
    v_para := '['||in_ibFlag || '][' || in_cntr_tpsz_cd
                             || '][' || in_bsa_seq
                             || '][' || in_vop_cd
                             || '][' || in_trd_cd
                             || '][' || in_rlane_cd
                             || '][' || in_dir_cd
                             || '][' || in_vvd_cd
                             || '][' || in_bsa_fm_dt
                             || '][' || in_bsa_to_dt
                             || '][' || in_crr_cd
                             || '][' || in_hc_rt
                             || '][' || in_hc_ovr_rt                             
                             || '][' || in_rt_tp_flg
                             || '][' || in_user_id;
    enis_log_prc('', 'BSA_HIGH_CUBIC_RT_PRC', v_para , 'v.20090522' );
    BEGIN   
        IF in_ibFlag = 'D' THEN
            UPDATE BSA_HIGH_CUBIC_RT_MST
               SET delt_flg = 'Y'
                  ,upd_usr_id = in_user_id
                  ,upd_dt = SYSDATE
             WHERE cntr_tpsz_cd  = in_cntr_tpsz_cd
               AND bsa_seq  = in_bsa_seq
            ;
        ELSE   

--          0.ovr_usd_slt_prc_seq 설정 : in_ovr_usd_slt_prc_seq 없을 경우 MAX + 1로 설정
            IF (in_bsa_seq = '' OR in_bsa_seq IS NULL)
            THEN
                SELECT NVL(MAX(bsa_seq), 0) + 1 AS max_bsa_seq 
                  INTO v_max_bsa_seq            
                  FROM bsa_high_cubic_rt_mst
                 WHERE cntr_tpsz_cd = in_cntr_tpsz_cd
                ;
            ELSE 
                v_max_bsa_seq := TO_NUMBER(in_bsa_seq);
            END IF;
            
--          1. BSA_HIGH_CUBIC_RT Master Data Insert/Update
            MERGE INTO BSA_HIGH_CUBIC_RT_MST a1
              USING (SELECT in_cntr_tpsz_cd AS cntr_tpsz_cd
                           ,v_max_bsa_seq AS bsa_seq
                           ,in_vop_cd AS vop_cd
                           ,in_trd_cd AS trd_cd
                           ,in_rlane_cd AS rlane_cd
                           ,in_dir_cd AS dir_cd
                           ,in_vvd_cd AS vvd_cd
                           ,in_bsa_fm_dt AS bsa_fm_dt
                           ,in_bsa_to_dt AS bsa_to_dt
                           ,'N' AS delt_flg
                           ,in_user_id AS cre_usr_id
                           ,in_user_id AS upd_usr_id
                       FROM dual
                    ) a2
                 ON (    a1.cntr_tpsz_cd  = a2.cntr_tpsz_cd
                     AND a1.bsa_seq = a2.bsa_seq
                    )
              WHEN NOT MATCHED THEN
                INSERT( a1.cntr_tpsz_cd, a1.bsa_seq, a1.vop_cd
                       ,a1.trd_cd, a1.rlane_cd, a1.dir_cd, a1.vvd_cd
                       ,a1.bsa_fm_dt, a1.bsa_to_dt
                       ,a1.delt_flg, a1.cre_usr_id, a1.cre_dt, a1.upd_usr_id, a1.upd_dt)
                VALUES( a2.cntr_tpsz_cd, a2.bsa_seq, a2.vop_cd
                       ,a2.trd_cd, a2.rlane_cd, a2.dir_cd, a2.vvd_cd
                       ,a2.bsa_fm_dt, a2.bsa_to_dt
                       ,'N', a2.cre_usr_id, SYSDATE, a2.upd_usr_id, SYSDATE)
              WHEN MATCHED THEN
               UPDATE
                  SET a1.trd_cd            = a2.trd_cd
                     ,a1.rlane_cd          = a2.rlane_cd
                     ,a1.dir_cd            = a2.dir_cd
                     ,a1.vvd_cd            = a2.vvd_cd
                     ,a1.bsa_fm_dt         = a2.bsa_fm_dt
                     ,a1.bsa_to_dt         = a2.bsa_to_dt
                     ,a1.vop_cd            = a2.vop_cd
                     ,a1.delt_flg          = a2.delt_flg
                     ,a1.upd_usr_id        = a2.upd_usr_id
                     ,a1.upd_dt            = SYSDATE
            ;
             enis_log_prc('', 'BSA_HIGH_CUBIC_RT_PRC', '1. BSA_HIGH_CUBIC_RT Master Data Insert/Update' , '' );
--          2. Over Used Slot Price Inset/Update[선사별]
            MERGE INTO bsa_high_cubic_rt_dtl a1
              USING ( SELECT in_cntr_tpsz_cd AS cntr_tpsz_cd
                            ,v_max_bsa_seq AS bsa_seq
--                            ,in_rt_tp_flg AS rt_tp_flg
                            ,SUBSTR( crr_cd
                                    ,INSTR(crr_cd, '|', 1, LEVEL) + 1
                                    ,INSTR(crr_cd, '|', 1, LEVEL + 1) - INSTR(crr_cd, '|', 1, LEVEL) - 1) AS crr_cd
                            ,TO_NUMBER(SUBSTR( hc_rt
                                              ,INSTR(hc_rt, '|', 1, LEVEL) + 1
                                              ,INSTR(hc_rt, '|', 1, LEVEL + 1) - INSTR(hc_rt, '|', 1, LEVEL) - 1)) AS hc_rt        
                            ,TO_NUMBER(SUBSTR( hc_ovr_rt
                                              ,INSTR(hc_ovr_rt, '|', 1, LEVEL) + 1
                                              ,INSTR(hc_ovr_rt, '|', 1, LEVEL + 1) - INSTR(hc_ovr_rt, '|', 1, LEVEL) - 1)) AS hc_ovr_rt
                            ,SUBSTR( rt_tp_flg
                                    ,INSTR(rt_tp_flg, '|', 1, LEVEL) + 1
                                    ,INSTR(rt_tp_flg, '|', 1, LEVEL + 1) - INSTR(rt_tp_flg, '|', 1, LEVEL) - 1) AS rt_tp_flg                                              
                            ,in_user_id AS cre_usr_id
                            ,in_user_id AS upd_usr_id
                        FROM (SELECT in_crr_cd AS crr_cd
                                    ,in_hc_ovr_rt AS hc_ovr_rt
                                    ,in_hc_rt AS hc_rt
                                    ,in_rt_tp_flg AS rt_tp_flg
                                FROM dual)
                     CONNECT BY LEVEL <= LENGTH(crr_cd) - LENGTH(REPLACE(crr_cd, '|')) - 1
                    ) a2
                 ON (    a1.cntr_tpsz_cd  = a2.cntr_tpsz_cd
                     AND a1.bsa_seq  = a2.bsa_seq
                     AND a1.crr_cd              = a2.crr_cd
                    )
               WHEN NOT MATCHED THEN
                    INSERT( a1.cntr_tpsz_cd, a1.bsa_seq, a1.crr_cd, a1.rt_tp_flg, a1.hc_rt, a1.hc_ovr_rt
                           ,a1.cre_usr_id, a1.cre_dt, a1.upd_usr_id, a1.upd_dt)
                    VALUES( a2.cntr_tpsz_cd, a2.bsa_seq, a2.crr_cd, a2.rt_tp_flg, a2.hc_rt, a2.hc_ovr_rt
                           ,a2.cre_usr_id, SYSDATE, a2.upd_usr_id, SYSDATE)
               WHEN MATCHED THEN
                    UPDATE
                       SET a1.hc_ovr_rt     = a2.hc_ovr_rt
                          ,a1.hc_rt         = a2.hc_rt
                          ,a1.rt_tp_flg     = a2.rt_tp_flg
                          ,a1.upd_usr_id = a2.upd_usr_id
                          ,a1.upd_dt     = SYSDATE
                          
            ;
            enis_log_prc('', 'BSA_HIGH_CUBIC_RT_PRC', '2. Over Used Slot Price Inset/Update[선사별]' , '' );
        END IF;            
    END;

EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc('', 'BSA_HIGH_CUBIC_RT_PRC', 'ERROR: '||SQLERRM ||', PARA : ' || v_para, '');
      RAISE;
    
END BSA_HIGH_CUBIC_RT_PRC;
-- ===== End of Function ==================================