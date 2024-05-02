CREATE OR REPLACE PROCEDURE OPUSADM."BSA_CREATE_PRC" 
(
    p_fm_yrwk    IN  VARCHAR2,
    p_to_yrwk    IN  VARCHAR2,
    p_ind        IN  VARCHAR2, -- Optional[ , JO, SC]
    p_trd_cd     IN  VARCHAR2, -- Optional
    p_rlane_cd   IN  VARCHAR2, -- Optional
    p_dir_cd     IN  VARCHAR2, -- Optional
    p_user_id    IN  VARCHAR2, -- Input User ID
    p_error_code OUT VARCHAR2,
    p_error_msg  OUT VARCHAR2
)
Authid current_user
IS
/******************************************************************************
   Name         :   BSA_CREATE_PRC
   Purpose      :   BSA 대상을 생성
   Source       :   coa_mon_vvd
   Target       :   bsa_jnt_op_bzc
   Ver          :   1.0
   Date         :   2007.07.
   System       :   Sales Managemenet > Basic Slot Allotment
   Author       :   CyberLogitec
******************************************************************************/
/*
  1.Name       : 박은주
  2.Create Date: 2007.07.
  3.Description:
      - 용도: BSA대상을 선정
      - 파라미터: 년도,주차,Indicator
      - 특이사항
  4.Revision History
*/
------------------------------- [ 변수 선언부    ] --------------------------------------
/** 작업로그 관련 변수선언 **/
v_mig_st_dt        VARCHAR2(21)   := TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') ;
v_mig_err_msg      VARCHAR2(4000)                                ;
v_status_msg       VARCHAR2(4000)                                ;
v_dtl_msg          VARCHAR2(4000)                                ;

v_sql_cnt          number(18)     := 0                           ;
v_sls_fm_dt        VARCHAR2(8)    := ''                          ;
v_sls_to_dt        VARCHAR2(8)    := ''                          ;
v_user_id          VARCHAR2(100)  := 'BATCH'                     ; /* Auto Batch User-ID */
vvd_cre_error      EXCEPTION                                     ;

------------------------------- [ 커서 선언부    ] --------------------------------------


    -------------------------------------------------------------------------------------------
    -- JO 대상 선정 쿼리문
    -------------------------------------------------------------------------------------------
    CURSOR target_bsa_jo_cur ( v_fm_yrwk  VARCHAR2, v_to_yrwk  VARCHAR2, v_trd_cd   VARCHAR2, v_rlane_cd VARCHAR2, v_dir_cd   VARCHAR2 ) IS
    SELECT
           1          AS bsa_seq,
           x.trd_cd,
           x.rlane_cd,
           x.dir_cd,
           x.vop_cd,
           x.vsl_capa,
           x.vvd_cd,
           x.bsa_fm_dt,
           '99991231' AS bsa_to_dt,
           ROUND(x.vsl_capa) AS bsa_capa,
           x.vsl_capa AS fnl_co_bsa_capa,
           x.vsl_capa AS co_bsa_bfr_sub_capa,
           ''         AS jo_desc,
           'N'        AS spc_otr_swap_flg
      FROM (SELECT
                   a.trd_cd,
                   a.rlane_cd,
                   a.dir_cd,
                   e.vop_cd,
                   DECODE(NVL(b.sub_trd_capa,0),0,NVL(e.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0)) AS vsl_capa,
                   a.vsl_cd || a.skd_voy_no || a.dir_cd AS vvd_cd,
                   ROW_NUMBER() OVER(PARTITION BY a.trd_cd,a.rlane_cd,a.dir_cd,e.vop_cd,DECODE(NVL(b.sub_trd_capa,0),0,NVL(e.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0))
                                     ORDER BY NVL(TO_CHAR(MIN(a.n1st_lodg_port_etd_dt),'YYYYMMDD'),'99991231')
                                    ) AS rnum, /* MIN(n1st_lodg_port_etd_dt)조건중에서 한건만 추출 */
                   NVL(TO_CHAR(MIN(a.n1st_lodg_port_etd_dt),'YYYYMMDD'),' ') AS bsa_fm_dt
              FROM coa_mon_vvd a,
                   (
                   /*
                   vessel의 vessel capacity를 조회한다.
                   sub trade의 vessel cpapcity가 0이면 loadable capacity로 한다.
                   단 coa_bsa_vsl_rgst테이블에 데이터가 있으면 First loading port ETD date가 
                   vsl_aply_fom_dt, vsl_aply_to_dt 에 해당되는 vessel capacity정보를 적용시킨다.
                   */
                    SELECT DISTINCT  a.vsl_cd ,
                        a.sub_trd_cd ,
                        a.sub_trd_capa ,
                        a.stnd_ldb_capa ,
                        a.vop_cd ,
                       TO_CHAR( a.vsl_aply_fm_dt ,'yyyymmdd') vsl_aply_fom_dt,
                       TO_CHAR( a.vsl_aply_to_dt ,'yyyymmdd')  vsl_aply_to_dt
                  FROM (
                        SELECT x.vsl_cd, y.sub_trd_cd, y.sub_trd_capa, x.stnd_ldb_capa,
                               x.vop_cd, x.vsl_aply_fm_dt vsl_aply_fm_dt, x.vsl_aply_to_dt vsl_aply_to_dt 
                          FROM coa_vsl_rgst x,
                               (
                                SELECT b.vsl_cd, b.vsl_seq, b.sub_trd_cd, b.sub_trd_capa
                                  FROM mdm_sub_trd a, coa_vsl_sub_trd_capa b
                                 WHERE a.delt_flg <> 'Y'
                                   AND a.sub_trd_cd      = b.sub_trd_cd
                               ) y
                         WHERE x.vsl_cd             = y.vsl_cd(+)
                           AND x.vsl_seq            = y.vsl_seq(+)
                           AND NVL(x.delt_flg,'N')  = 'N'
                           AND x.vsl_tp_cd          = 'C'
                        ) a
                   ) b, 
                   (
                   /*
                   lane의 history정보가 있으면 First loading Port ETD date가 
                   lane_aply_fom_dt, lane_aply_to_dt 에 해당되는 Lane정보를 조회한다.
                   */
                   SELECT DISTINCT NVL(b.trd_cd          , a.trd_cd)         trd_cd,
                          NVL(b.rlane_cd        , a.rlane_cd)       rlane_cd,
                          NVL(b.dir_cd          , a.dir_cd)         dir_cd,
                          NVL(b.ioc_cd          , a.ioc_cd)         ioc_cd,
                          NVL(b.vsl_lane_tp_cd  , a.vsl_lane_tp_cd) vsl_lane_tp_cd,
                          NVL(b.stup_flg        , a.stup_flg)       stup_flg,
                          NVL(b.lane_aply_fm_dt, '19000101') lane_aply_fom_dt,
                          NVL(b.lane_aply_to_dt , '99991231') lane_aply_to_dt
                     FROM coa_lane_rgst a 
                          FULL OUTER JOIN                                           
                          coa_lane_tp_his b
                       ON (    a.trd_cd   = b.trd_cd
                           AND a.rlane_cd = b.rlane_cd
                           AND a.dir_cd   = b.dir_cd
                           AND a.ioc_cd   = b.ioc_cd)
                    WHERE a.delt_flg     <> 'Y'
                      AND a.trd_cd        = NVL(v_trd_cd  , a.trd_cd)
                      AND a.rlane_cd      = NVL(v_rlane_cd, a.rlane_cd)
                      AND a.dir_cd        = NVL(v_dir_cd  , a.dir_cd)
                   ) c, 
                   (
                   SELECT vsl_cd,  vop_cd , stnd_ldb_capa , 
                          NVL(TO_CHAR( vsl_aply_fm_dt,'yyyymmdd'), '19000101')       vsl_aply_fom_dt,
                          NVL(TO_CHAR( vsl_aply_to_dt,'yyyymmdd'), '99991231')       vsl_aply_to_dt,
                          vsl_clss_capa, trd_chk_flg, delt_flg
                     FROM coa_vsl_rgst  
                    
                   ) e
             WHERE a.vsl_cd            = b.vsl_cd(+)
               AND a.sub_trd_cd        = b.sub_trd_cd(+)
               AND a.vsl_cd            = e.vsl_cd(+)
               AND a.trd_cd            = c.trd_cd
               AND a.rlane_cd          = c.rlane_cd
               AND a.dir_cd            = c.dir_cd
               AND a.ioc_cd            = c.ioc_cd
               AND NVL(a.delt_flg,'N') <> 'Y'
               AND NVL(e.delt_flg,'N') <> 'Y'
               AND c.vsl_lane_tp_cd    = 'JO'
               AND a.trd_cd            = NVL(v_trd_cd  , a.trd_cd) 
               AND a.rlane_cd          = NVL(v_rlane_cd, a.rlane_cd)
               AND a.dir_cd            = NVL(v_dir_cd  , a.dir_cd)
               AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(c.lane_aply_fom_dt,'19000101') AND NVL(c.lane_aply_to_dt, '99991231')
               AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(b.vsl_aply_fom_dt ,'19000101') AND NVL(b.vsl_aply_to_dt , '99991231')
               AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(e.vsl_aply_fom_dt ,'19000101') AND NVL(e.vsl_aply_to_dt , '99991231')
               AND SUBSTR(a.sls_yrmon,0,4)||a.cost_wk BETWEEN v_fm_yrwk AND v_to_yrwk
               AND NOT EXISTS (SELECT 'OK'
                                 FROM bsa_jnt_op_bzc d
                                WHERE d.trd_cd   = a.trd_cd
                                  AND d.rlane_cd = a.rlane_cd
                                  AND d.dir_cd   = a.dir_cd
                                  AND d.vop_cd   = e.vop_cd
                                  AND d.vsl_capa = decode(nvl(b.sub_trd_capa,0),0,nvl(e.stnd_ldb_capa,0),nvl(b.sub_trd_capa,0))
                              )
             GROUP BY
                   a.trd_cd,
                   a.rlane_cd,
                   a.dir_cd,
                   e.vop_cd,
                   DECODE(NVL(b.sub_trd_capa,0),0,NVL(e.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0)),
                   a.vsl_cd || a.skd_voy_no || a.dir_cd
           ) x
     WHERE 1=1 
       AND x.vop_cd IS NOT NULL
       AND x.rnum = 1
    ;


    -------------------------------------------------------------------------------------------
    -- SC 대상 선정 쿼리문
    -------------------------------------------------------------------------------------------
    CURSOR target_bsa_sc_cur ( v_fm_yrwk  VARCHAR2, v_to_yrwk  VARCHAR2, v_trd_cd   VARCHAR2, v_rlane_cd VARCHAR2, v_dir_cd   VARCHAR2 ) IS
    SELECT
           1          AS bsa_seq,
           x.trd_cd,
           x.rlane_cd,
           x.dir_cd,
           1          AS vsl_seq,
           x.vvd_cd,
           x.bsa_fm_dt,
           '99991231' AS bsa_to_dt,
           ''         AS vsl_cd,
           0          AS co_fnl_bsa_capa,
           0          AS co_bsa_bfr_sub_capa,
           'N'        AS vsl_bsa_chk_flg,
           ''         AS scht_desc,
           'N'        AS vsl_mlt_inp_flg
      FROM (SELECT
                   a.trd_cd,
                   a.rlane_cd,
                   a.dir_cd,
                   a.vsl_cd || a.skd_voy_no || a.dir_cd AS vvd_cd,
                   ROW_NUMBER() OVER(PARTITION BY a.trd_cd,a.rlane_cd,a.dir_cd
                                     ORDER BY NVL(TO_CHAR(MIN(a.n1st_lodg_port_etd_dt),'YYYYMMDD'),'99991231')
                                     ) AS rnum, /* MIN(n1st_lodg_port_etd_dt)조건중에서 한건만 추출 */
                   NVL(TO_CHAR(MIN(a.n1st_lodg_port_etd_dt),'YYYYMMDD'),' ') AS bsa_fm_dt
              FROM coa_mon_vvd a,
                   (
                   /*
                   lane의 history정보가 있으면 First loading Port ETD date가 
                   lane_aply_fom_dt, lane_aply_to_dt 에 해당되는 Lane정보를 조회한다.
                   */
                   SELECT DISTINCT NVL(b.trd_cd          , a.trd_cd)         trd_cd,
                          NVL(b.rlane_cd        , a.rlane_cd)       rlane_cd,
                          NVL(b.dir_cd          , a.dir_cd)         dir_cd,
                          NVL(b.ioc_cd          , a.ioc_cd)         ioc_cd,
                          NVL(b.vsl_lane_tp_cd  , a.vsl_lane_tp_cd) vsl_lane_tp_cd,
                          NVL(b.stup_flg        , a.stup_flg)       stup_flg,
                          NVL(b.lane_aply_fm_dt, '19000101') lane_aply_fom_dt,
                          NVL(b.lane_aply_to_dt , '99991231') lane_aply_to_dt
                     FROM coa_lane_rgst a 
                          FULL OUTER JOIN 
                          coa_lane_tp_his b
                       ON (    a.trd_cd   = b.trd_cd
                           AND a.rlane_cd = b.rlane_cd
                           AND a.dir_cd   = b.dir_cd
                           AND a.ioc_cd   = b.ioc_cd)
                    WHERE a.delt_flg     <> 'Y'
                      AND a.trd_cd        = NVL(v_trd_cd  , a.trd_cd)
                      AND a.rlane_cd      = NVL(v_rlane_cd, a.rlane_cd)
                      AND a.dir_cd        = NVL(v_dir_cd  , a.dir_cd)
                  ) c
             WHERE a.trd_cd              = c.trd_cd
               AND a.rlane_cd            = c.rlane_cd
               AND a.dir_cd              = c.dir_cd
               AND a.ioc_cd              = c.ioc_cd
               AND NVL(a.delt_flg,'N')  <> 'Y'
               AND c.vsl_lane_tp_cd      = 'SC'
               AND a.trd_cd              = NVL(v_trd_cd  , a.trd_cd)
               AND a.rlane_cd            = NVL(v_rlane_cd, a.rlane_cd)
               AND a.dir_cd              = NVL(v_dir_cd  , a.dir_cd)
               AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN lane_aply_fom_dt AND lane_aply_to_dt
               AND SUBSTR(a.sls_yrmon,0,4)||a.cost_wk BETWEEN v_fm_yrwk AND v_to_yrwk
               AND NOT EXISTS (SELECT 'OK'
                                 FROM bsa_slt_chtr_bzc d
                                WHERE d.trd_cd   = a.trd_cd
                                  AND d.rlane_cd = a.rlane_cd
                                  AND d.dir_cd   = a.dir_cd
                              )
             GROUP BY
                   a.trd_cd,
                   a.rlane_cd,
                   a.dir_cd,
                   a.vsl_cd || a.skd_voy_no || a.dir_cd
           ) x
     WHERE x.rnum = 1
    ;

------------------------------- [ 업무로직 구현부] --------------------------------------
BEGIN
    DBMS_OUTPUT.ENABLE;

    v_user_id    := NVL(p_user_id, v_user_id);
    v_mig_st_dt  := TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') ;
    
--    DBMS_OUTPUT.PUT_LINE('p_ind : ['||NVL(p_ind,'ALL')||'] [' || v_mig_st_dt || '] BSA Creation Start ... (PGM-ID=' || v_mig_pgm_nm || ')');

    
    /* JO Creation */
    IF  NVL(p_ind,'ALL') = 'JO' OR  NVL(p_ind,'ALL') = 'ALL' THEN
    enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', '---------------------------------------' , 'JO Creation');
        
        FOR param IN target_bsa_jo_cur (p_fm_yrwk, p_to_yrwk, p_trd_cd, p_rlane_cd, p_dir_cd) LOOP
            v_dtl_msg := TO_CHAR(target_bsa_jo_cur%rowcount) || '>>[' || param.bsa_seq || '][' || param.trd_cd   || '][' || param.rlane_cd || '][' || param.dir_cd           || '][' 
                             || param.vop_cd  || '][' || param.vsl_capa || '][' || param.vvd_cd   || '][' || param.bsa_fm_dt        || '][' 
                             || param.bsa_to_dt                         || '][' || param.bsa_capa || '][' || param.fnl_co_bsa_capa || ']['
                             || param.co_bsa_bfr_sub_capa              || '][' || param.jo_desc  || '][' || param.spc_otr_swap_flg || ']['
                             || p_user_id || '][' || p_fm_yrwk || '][' || p_to_yrwk || ']' ;
--            DBMS_OUTPUT.PUT_LINE('Info >> ' || v_dtl_msg);
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', 'Info : ' || v_dtl_msg , 'JO Creation');
            
            
            /* STEP #1 : COA_BSA_JNT_OP_BZC Insert -------------------------------------------------------------*/
            v_status_msg := '1) BSA_JNT_OP_BZC Insert';
            INSERT INTO bsa_jnt_op_bzc (bsa_seq, trd_cd, rlane_cd, dir_cd, vop_cd, vsl_capa,
                                            vvd_cd, bsa_fm_dt, bsa_to_dt, bsa_capa, fnl_co_bsa_capa,
                                            co_bsa_bfr_sub_capa, jo_desc, spc_otr_swap_flg,
                                            cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT param.bsa_seq, param.trd_cd, param.rlane_cd, param.dir_cd, param.vop_cd, param.vsl_capa,
                   param.vvd_cd, param.bsa_fm_dt, param.bsa_to_dt, param.bsa_capa, param.fnl_co_bsa_capa,
                   param.co_bsa_bfr_sub_capa, param.jo_desc, param.spc_otr_swap_flg,
                   v_user_id, SYSDATE, v_user_id, SYSDATE
            FROM dual
            ;
            v_sql_cnt := sql%rowcount;
            --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'JO Creation');

            
            
            /* STEP #2 : COA_BSA_JNT_OP_CRR_CAPA Insert----------------------------------------------------------*/
            v_status_msg := '20 BSA_JNT_OP_CRR_CAPA Insert';
            INSERT INTO bsa_jnt_op_crr_capa (bsa_seq, trd_cd, rlane_cd, dir_cd, vop_cd, vsl_capa,
                                                 bsa_op_cd, bsa_op_jb_cd, crr_cd,
                                                 crr_bsa_capa, spc_ctrl_slt_capa,
                                                 cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT a.bsa_seq, a.trd_cd, a.rlane_cd, a.dir_cd, a.vop_cd, a.vsl_capa,
                   b.bsa_op_cd, b.bsa_op_jb_cd, b.crr_cd,
                   (CASE WHEN b.crr_cd=COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND b.bsa_op_jb_cd='007' THEN a.vsl_capa ELSE 0 END),
                   (CASE WHEN b.crr_cd=COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND b.bsa_op_jb_cd='007' THEN a.vsl_capa ELSE 0 END),
                   v_user_id, SYSDATE, v_user_id, SYSDATE
             FROM bsa_jnt_op_bzc a,
                  bsa_crr_rgst b
            WHERE a.bsa_seq   = param.bsa_seq
              AND a.trd_cd    = param.trd_cd
              AND a.rlane_cd  = param.rlane_cd
              AND a.dir_cd    = param.dir_cd
              AND a.vop_cd    = param.vop_cd
              AND a.vsl_capa  = param.vsl_capa
              AND b.bsa_op_cd = 'J'  /* JointOperating */
              AND b.aply_flg  = 'Y'
              /* ------------------------------------------------------------------------------------
                 2007.05.30
                 001,002,003,004,005는 coa_bsa_crr_rgst에 등록된 정보로 carrier를 생성하고
                 006~019까지는 001~005에서 사용하는 carrier들의 Distinct된 선사로 carrier를 생성한다.
                 ------------------------------------------------------------------------------------ */
              AND ( b.bsa_op_jb_cd   IN ('001','002','003','004','005')
                   OR b.crr_cd IN (
                                   SELECT DISTINCT crr_cd
                                     FROM bsa_crr_rgst
                                    WHERE bsa_op_cd   = 'J' 
                                      AND NVL(b.aply_flg,'N') = 'Y' 
                                      AND bsa_op_jb_cd in ('001','002','003','004','005')
                                   )
                   )
              /* ------------------------------------------------------------------------------------ */    
            ;
            v_sql_cnt := sql%rowcount;
            --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'JO Creation');
            
            
            
            /* STEP #3 : COA_BSA_JNT_OP_PORT_DWN Insert ---------------------------------------------------------*/
            v_status_msg := '3) BSA_JNT_OP_PORT_DWN Insert';
            INSERT INTO bsa_jnt_op_port_dwn (bsa_seq, trd_cd, rlane_cd, dir_cd, vop_cd, vsl_capa,
                                                 bsa_op_cd, bsa_op_jb_cd, crr_cd,
                                                 port_seq, port_cd, port_bsa_capa,
                                                 cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT a.bsa_seq, a.trd_cd, a.rlane_cd, a.dir_cd, a.vop_cd, a.vsl_capa,
                   b.bsa_op_cd, b.bsa_op_jb_cd, b.crr_cd,
                   c.seq, c.port_cd, 
--                   ROW_NUMBER() OVER(PARTITION BY a.bsa_seq,a.trd_cd,a.rlane_cd,a.dir_cd,a.vop_cd,
--                                                  b.vsl_capa,b.bsa_op_cd,b.bsa_op_jb_cd,b.crr_cd
--                                         ORDER BY c.seq),
--                   c.loc_cd,
                   DECODE(b.bsa_op_jb_cd,'007',DECODE(b.crr_cd,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC,b.crr_bsa_capa,0),0),
                   v_user_id, SYSDATE, v_user_id, SYSDATE
              FROM bsa_jnt_op_bzc      a,
                   bsa_jnt_op_crr_capa b,
                   (
                    /* trade, RLane, Bound 에서 사용하는 Port들을 조회한다. */
                    SELECT /*+ index_desc(x IDX1_COA_MON_VVD) */
                           DISTINCT x.trd_cd, x.rlane_cd, x.dir_cd, y.port_cd, y.seq
                      FROM coa_mon_vvd             x,
--                           coa_lane_rgst           z,
                           (
                           SELECT NVL(b.trd_cd          , a.trd_cd)         trd_cd,
                                  NVL(b.rlane_cd        , a.rlane_cd)       rlane_cd,
                                  NVL(b.dir_cd          , a.dir_cd)         dir_cd,
                                  NVL(b.ioc_cd          , a.ioc_cd)         ioc_cd,
                                  NVL(b.vsl_lane_tp_cd  , a.vsl_lane_tp_cd) vsl_lane_tp_cd,
                                  NVL(b.stup_flg        , a.stup_flg)       stup_flg,
                                  NVL(b.lane_aply_fm_dt, '19000101')       lane_aply_fom_dt,
                                  NVL(b.lane_aply_to_dt , '99991231')       lane_aply_to_dt
                             FROM coa_lane_rgst a 
                                  FULL OUTER JOIN 
                                  coa_lane_tp_his b
                               ON (    a.trd_cd   = b.trd_cd
                                   AND a.rlane_cd = b.rlane_cd
                                   AND a.dir_cd   = b.dir_cd
                                   AND a.ioc_cd   = b.ioc_cd)
                            WHERE NVL(a.delt_flg,'N') <> 'Y'
                              AND a.trd_cd             = NVL(param.trd_cd  , a.trd_cd)
                              AND a.rlane_cd           = NVL(param.rlane_cd, a.rlane_cd)
                              AND a.dir_cd             = NVL(param.dir_cd  , a.dir_cd)
                           ) z, 
                           (
                            -- 2007.10.17 에서 해당 해의 스케줄의 조회하도록 수정
                            SELECT b.vsl_slan_cd, b.pf_svc_tp_cd, b.skd_dir_cd, 
                                   ROW_NUMBER() OVER (PARTITION BY b.vsl_slan_cd, b.pf_svc_tp_cd, b.skd_dir_cd
                                                          ORDER BY b.port_rotn_seq) seq,
                                   b.port_rotn_seq, b.port_cd
                              FROM vsk_pf_skd a, vsk_pf_skd_dtl b
                             WHERE a.vsl_slan_cd   = b.vsl_slan_cd
                               AND a.pf_svc_tp_cd  = b.pf_svc_tp_cd
                               AND a.slan_stnd_flg = 'Y'
                               AND a.vsl_slan_cd   = substr(param.rlane_cd,1,3)
                               AND b.skd_dir_cd    = param.dir_cd
                               AND b.pf_svc_tp_cd  = SUBSTR(p_fm_yrwk,1,4)
                             ORDER by b.vsl_slan_cd, b.pf_svc_tp_cd, b.port_rotn_seq                           
                           ) y
                           -- coa_mon_vvd_port_op_dys y
                     WHERE 
--                           x.trd_cd              = y.trd_cd
--                       AND x.rlane_cd            = y.rlane_cd
--                       AND x.ioc_cd              = y.ioc_cd
--                       AND x.vsl_cd              = y.vsl_cd
--                       AND x.skd_voy_no          = y.skd_voy_no
--                       AND x.dir_cd              = y.dir_cd
                           substr(x.rlane_cd,1,3)  = y.vsl_slan_cd
                       AND x.dir_cd                = y.skd_dir_cd
                       AND x.trd_cd                = z.trd_cd
                       AND x.rlane_cd              = z.rlane_cd
                       AND x.ioc_cd                = z.ioc_cd
                       AND x.dir_cd                = z.dir_cd
                       AND z.vsl_lane_tp_cd        = 'JO'
                       AND NVL(z.stup_flg,'N')     = 'Y'
                       AND NVL(x.mon_tgt_flg, 'N') = 'N'
                       AND NVL(x.delt_flg,'N')     = 'N'
                       AND SUBSTR(x.sls_yrmon,0,4)||x.cost_wk         BETWEEN p_fm_yrwk AND p_to_yrwk
                       AND TO_CHAR(x.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(z.lane_aply_fom_dt,'19000101') AND NVL(z.lane_aply_to_dt, '99991231')
--                     GROUP BY y.trd_cd, y.rlane_cd, y.dir_cd, y.loc_cd
                   ) c
             WHERE a.bsa_seq   = b.bsa_seq
               AND a.trd_cd    = b.trd_cd
               AND a.rlane_cd  = b.rlane_cd
               AND a.dir_cd    = b.dir_cd
               AND a.vop_cd    = b.vop_cd
               AND a.vsl_capa  = b.vsl_capa
               AND a.trd_cd    = c.trd_cd
               AND a.rlane_cd  = c.rlane_cd
               AND a.dir_cd    = c.dir_cd
               AND a.bsa_seq   = param.bsa_seq
               AND a.trd_cd    = param.trd_cd
               AND a.rlane_cd  = param.rlane_cd
               AND a.dir_cd    = param.dir_cd
               AND a.vop_cd    = param.vop_cd
               AND a.vsl_capa  = param.vsl_capa
               AND b.bsa_op_jb_cd IN ('007','015','016')
            ;
            v_sql_cnt := sql%rowcount;
            --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'JO Creation');
            /* --------------------------------------------------------------------------------------------------*/
        END LOOP;         


        /* STEP #4 : 구간 주차에 대한 from~to Date를 구한다 -------------------------------------------------*/
        v_status_msg := '4) 주차구하기';
        SELECT TO_CHAR(MIN(n1st_lodg_port_etd_dt),'yyyymmdd'),TO_CHAR(MAX(n1st_lodg_port_etd_dt),'yyyymmdd')
          INTO v_sls_fm_dt, v_sls_to_dt
          FROM coa_mon_vvd
         WHERE SUBSTR(sls_yrmon,1,4)||cost_wk BETWEEN p_fm_yrwk AND p_to_yrwk
        ;
        v_sql_cnt := sql%rowcount;
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || v_sls_fm_dt || '~' || v_sls_to_dt || ']' , 'JO Creation');
    
    
        /* STEP #5 : Price Creation : COA_BSA_SLT_PRC Insert ------------------------------------------------*/
        v_status_msg := '5) BSA_SLT_PRC Insert';
        INSERT INTO bsa_slt_prc (slt_prc_seq, trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                                     bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt,
                                     co_bfr_sub_capa, sub_chtr_bsa_capa, crs_chtr_bsa_capa,
                                     cre_usr_id, cre_dt, upd_usr_id, upd_dt)
        SELECT 1, trd_cd, rlane_cd, dir_cd, '017',
               bsa_fm_dt, bsa_to_dt,
               0, 0, 0,
               v_user_id, SYSDATE, v_user_id, SYSDATE
          FROM (
                SELECT a.trd_cd, a.rlane_cd, a.dir_cd, a.bsa_fm_dt, a.bsa_to_dt,
                       NVL(b.dir_cd,'Y') AS ins_chk
                  FROM (
                        SELECT DISTINCT MIN(bsa_fm_dt) AS bsa_fm_dt, trd_cd, rlane_cd, dir_cd, bsa_to_dt
                          FROM bsa_jnt_op_bzc
                         WHERE bsa_fm_dt  >= v_sls_fm_dt
                           AND (bsa_to_dt <= NVL(v_sls_to_dt,'99991231') OR bsa_to_dt = '99991231')
                         GROUP BY trd_cd, rlane_cd, dir_cd, bsa_to_dt
                       ) a,
                       bsa_slt_prc b
                 WHERE a.trd_cd                = b.trd_cd(+)
                   AND a.rlane_cd              = b.rlane_cd(+)
                   AND a.dir_cd                = b.dir_cd(+)
                   AND b.bsa_slt_cost_tp_cd(+) = '017'
               )
         WHERE ins_chk = 'Y'
        ;
        v_sql_cnt := sql%rowcount;
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'JO Creation');



        /* STEP #6 : Price Creation : COA_BSA_SLT_PRC_CRR Insert --------------------------------------------*/
        v_status_msg := '6) BSA_SLT_PRC_CRR Insert';
        INSERT INTO bsa_slt_prc_crr (slt_prc_seq, trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                                         bsa_op_jb_cd, crr_cd,
                                         bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt, slt_prc_capa,
                                         cre_usr_id, cre_dt, upd_usr_id, upd_dt)
        SELECT 1, a.trd_cd, a.rlane_cd, a.dir_cd, a.bsa_slt_cost_tp_cd,
               b.bsa_op_jb_cd, b.crr_cd,
               a.bsa_slt_prc_fm_dt, a.bsa_slt_prc_to_dt, 0,
               v_user_id, SYSDATE, v_user_id, SYSDATE
        FROM (
              SELECT trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                     bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt
                FROM (
                      SELECT s.trd_cd, s.rlane_cd, s.dir_cd, s.bsa_slt_cost_tp_cd,
                             s.bsa_slt_prc_fm_dt, s.bsa_slt_prc_to_dt,
                             NVL(t.trd_cd,'Y') AS ins_chk
                        FROM bsa_slt_prc s,
                             bsa_slt_prc_crr t
                       WHERE s.slt_prc_seq        = t.slt_prc_seq (+)
                         AND s.trd_cd             = t.trd_cd (+)
                         AND s.rlane_cd           = t.rlane_cd (+)
                         AND s.dir_cd             = t.dir_cd (+)
                         AND s.bsa_slt_cost_tp_cd = t.bsa_slt_cost_tp_cd (+)
                         AND s.bsa_slt_prc_fm_dt >= v_sls_fm_dt
                         AND (s.bsa_slt_prc_to_dt<= NVL(v_sls_to_dt,'99991231') OR s.bsa_slt_prc_to_dt = '99991231')
                      )
               WHERE ins_chk = 'Y'
              ) a,
              (
               SELECT bsa_op_jb_cd, crr_cd
                 FROM bsa_crr_rgst
                WHERE bsa_op_jb_cd IN ('002','004')
                  AND bsa_op_cd = 'J'
                  AND aply_flg = 'Y'
              ) b
        ;
        v_sql_cnt := sql%rowcount;
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'JO Creation');
          
    END IF;
    
    
    

    /* SC Creation */
    IF NVL(p_ind,'ALL') = 'SC' OR NVL(p_ind,'ALL') = 'ALL' THEN
    enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', '---------------------------------------' , 'SC Creation');
--    DBMS_OUTPUT.PUT_LINE('SC Creation ------------------------------------------------------------');
    
    
        FOR param IN target_bsa_sc_cur (p_fm_yrwk, p_to_yrwk, p_trd_cd, p_rlane_cd, p_dir_cd) LOOP
            v_dtl_msg := '[' || param.bsa_seq || '][' || param.trd_cd   || '][' || param.rlane_cd || '][' || param.dir_cd           || '][' 
                             || param.vsl_seq || '][' || param.vvd_cd   || '][' || param.bsa_fm_dt|| '][' || param.bsa_to_dt        || '][' 
                             || param.vsl_cd  || '][' || param.co_fnl_bsa_capa                   || '][' || param.co_bsa_bfr_sub_capa || '][' 
                             || param.vsl_bsa_chk_flg || '][' || param.scht_desc|| '][' || param.vsl_mlt_inp_flg || ']';
            
--            DBMS_OUTPUT.PUT_LINE('Info >> ' || v_dtl_msg); 
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', 'Info : ' || v_dtl_msg , 'SC Creation');
            
                  
            /* STEP #1 : COA_BSA_SLT_CHTR_BZC Insert ------------------------------------------------------------*/
            v_status_msg := '1) BSA_SLT_CHTR_BZC Insert';
            INSERT INTO bsa_slt_chtr_bzc (bsa_seq, trd_cd, rlane_cd, dir_cd, vsl_seq,
                                              vvd_cd, bsa_fm_dt, bsa_to_dt, vsl_cd,
                                              co_fnl_bsa_capa, co_bsa_bfr_sub_capa,
                                              vsl_bsa_chk_flg, scht_desc, vsl_mlt_inp_flg,
                                              cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT param.bsa_seq, param.trd_cd,    param.rlane_cd,  param.dir_cd, param.vsl_seq,
                   param.vvd_cd,  param.bsa_fm_dt, param.bsa_to_dt, param.vsl_cd,
                   param.co_fnl_bsa_capa, param.co_bsa_bfr_sub_capa,
                   param.vsl_bsa_chk_flg, param.scht_desc, param.vsl_mlt_inp_flg,
                   v_user_id, SYSDATE, v_user_id, SYSDATE
            FROM dual
            ;
            v_sql_cnt := sql%rowcount;
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'SC Creation');

            /* STEP #2 : COA_BSA_SLT_CHTR_CRR_CAPA Insert -------------------------------------------------------*/
            v_status_msg := '2) BSA_SLT_CHTR_CRR_CAPA Insert';
            INSERT INTO bsa_slt_chtr_crr_capa (bsa_seq, trd_cd, rlane_cd, dir_cd, vsl_seq,
                                                   bsa_op_cd, bsa_op_jb_cd, crr_cd,
                                                   crr_bsa_capa,
                                                   cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT a.bsa_seq, a.trd_cd, a.rlane_cd, a.dir_cd, a.vsl_seq,
                   b.bsa_op_cd, b.bsa_op_jb_cd, b.crr_cd,
                   0,
                   v_user_id, SYSDATE, v_user_id, SYSDATE
              FROM bsa_slt_chtr_bzc a,
                   bsa_crr_rgst b
             WHERE a.bsa_seq           = param.bsa_seq
               AND a.trd_cd            = param.trd_cd
               AND a.rlane_cd          = param.rlane_cd
               AND a.dir_cd            = param.dir_cd
               AND a.vsl_seq           = param.vsl_seq
               AND b.bsa_op_cd         = 'S'  /* SpaceChartering */
               AND NVL(b.aply_flg,'N') = 'Y'
              /* ------------------------------------------------------------------------------------
                2007.05.30
                001,002,003,004,005는 coa_bsa_crr_rgst에 등록된 정보로 carrier를 생성하고
                006~019까지는 001~005에서 사용하는 carrier들의 Distinct된 선사로 carrier를 생성한다.
              ------------------------------------------------------------------------------------ */
              AND ( b.bsa_op_jb_cd   IN ('001','002','003','004','005')
                   OR b.crr_cd in (
                                   SELECT DISTINCT crr_cd
                                     FROM bsa_crr_rgst
                                    WHERE bsa_op_cd           = 'S' 
                                     AND NVL(b.aply_flg,'N')  = 'Y' 
                                     AND bsa_op_jb_cd in ('001','002','003','004','005')
                                   )
                 )   
              /* ------------------------------------------------------------------------------------ */    
            ;
            v_sql_cnt := sql%rowcount;
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'SC Creation');



            /* STEP #3 : COA_BSA_SLT_CHTR_PORT_DWN Insert -------------------------------------------------------*/
            v_status_msg := '3) BSA_SLT_CHTR_PORT_DWN Insert';
            INSERT INTO bsa_slt_chtr_port_dwn (bsa_seq, trd_cd, rlane_cd, dir_cd, vsl_seq,
                                                   bsa_op_cd, bsa_op_jb_cd, crr_cd,
                                                   port_seq, port_cd, port_bsa_capa,
                                                   cre_usr_id, cre_dt, upd_usr_id, upd_dt)
            SELECT a.bsa_seq, a.trd_cd, a.rlane_cd, a.dir_cd, a.vsl_seq,
                   b.bsa_op_cd, b.bsa_op_jb_cd, b.crr_cd, c.seq, c.port_cd,
--                   ROW_NUMBER() OVER(PARTITION BY a.bsa_seq,a.trd_cd,a.rlane_cd,a.dir_cd,a.vsl_seq,
--                                                  b.bsa_op_cd,b.bsa_op_jb_cd,b.crr_cd
--                                         ORDER BY c.seq),
--                   c.loc_cd,
                   DECODE(b.bsa_op_jb_cd,'007',DECODE(b.crr_cd,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC,b.crr_bsa_capa,0),0),
                   v_user_id, SYSDATE, v_user_id, SYSDATE
              FROM bsa_slt_chtr_bzc      a,
                   bsa_slt_chtr_crr_capa b,
                   (
                    SELECT /*+ index_desc(x IDX1_COA_MON_VVD) */
                           DISTINCT x.trd_cd, x.rlane_cd, x.dir_cd, y.port_cd, y.seq
                      FROM coa_mon_vvd             x,
--                           coa_lane_rgst           z,
                           (
                           SELECT NVL(b.trd_cd          , a.trd_cd)         trd_cd,
                                  NVL(b.rlane_cd        , a.rlane_cd)       rlane_cd,
                                  NVL(b.dir_cd          , a.dir_cd)         dir_cd,
                                  NVL(b.ioc_cd          , a.ioc_cd)         ioc_cd,
                                  NVL(b.vsl_lane_tp_cd  , a.vsl_lane_tp_cd) vsl_lane_tp_cd,
                                  NVL(b.stup_flg        , a.stup_flg)       stup_flg,
                                  NVL(b.lane_aply_fm_dt, '19000101')       lane_aply_fom_dt,
                                  NVL(b.lane_aply_to_dt , '99991231')       lane_aply_to_dt
                             FROM coa_lane_rgst a 
                                  FULL OUTER JOIN 
                                  coa_lane_tp_his b
                               ON (    a.trd_cd   = b.trd_cd
                                   AND a.rlane_cd = b.rlane_cd
                                   AND a.dir_cd   = b.dir_cd
                                   AND a.ioc_cd   = b.ioc_cd)
                            WHERE a.delt_flg     <> 'Y'
                              AND a.trd_cd        = NVL(param.trd_cd  , a.trd_cd)
                              AND a.rlane_cd      = NVL(param.rlane_cd, a.rlane_cd)
                              AND a.dir_cd        = NVL(param.dir_cd  , a.dir_cd)
                           ) z, 
                           (
                            SELECT b.vsl_slan_cd, b.pf_svc_tp_cd, b.skd_dir_cd, 
                                   ROW_NUMBER() OVER (PARTITION BY b.vsl_slan_cd, b.pf_svc_tp_cd, b.skd_dir_cd
                                                          ORDER BY b.port_rotn_seq) seq,
                                   b.port_rotn_seq, b.port_cd
                              FROM vsk_pf_skd a, vsk_pf_skd_dtl b
                             WHERE a.vsl_slan_cd   = b.vsl_slan_cd
                               AND a.pf_svc_tp_cd  = b.pf_svc_tp_cd
                               AND a.slan_stnd_flg = 'Y'
                               AND a.vsl_slan_cd   = substr(param.rlane_cd,1,3)
                               AND b.skd_dir_cd    = param.dir_cd
                             ORDER by b.vsl_slan_cd, b.pf_svc_tp_cd, b.port_rotn_seq                           
                           ) y
                           -- coa_mon_vvd_port_op_dys y
                     WHERE 
--                           x.trd_cd              = y.trd_cd
--                       AND x.rlane_cd            = y.rlane_cd
--                       AND x.ioc_cd              = y.ioc_cd
--                       AND x.vsl_cd              = y.vsl_cd
--                       AND x.skd_voy_no          = y.skd_voy_no
--                       AND x.dir_cd              = y.dir_cd
                           substr(x.rlane_cd,1,3)  = y.vsl_slan_cd
                       AND x.dir_cd                = y.skd_dir_cd
                       AND x.trd_cd                = z.trd_cd
                       AND x.rlane_cd              = z.rlane_cd
                       AND x.ioc_cd                = z.ioc_cd
                       AND x.dir_cd                = z.dir_cd
                       AND x.trd_cd                = z.trd_cd
                       AND x.rlane_cd              = z.rlane_cd
                       AND x.ioc_cd                = z.ioc_cd
                       AND x.dir_cd                = z.dir_cd
                       AND z.vsl_lane_tp_cd        = 'SC'
                       AND NVL(z.stup_flg,'N')     = 'Y'
                       AND SUBSTR(x.sls_yrmon,1,4)||x.cost_wk         BETWEEN p_fm_yrwk AND p_to_yrwk
                       AND TO_CHAR(x.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(z.lane_aply_fom_dt,'19000101') AND NVL(z.lane_aply_to_dt, '99991231')

                    ) c
             WHERE a.bsa_seq   = b.bsa_seq
               AND a.trd_cd    = b.trd_cd
               AND a.rlane_cd  = b.rlane_cd
               AND a.dir_cd    = b.dir_cd
               AND a.vsl_seq   = b.vsl_seq
               AND a.trd_cd    = c.trd_cd
               AND a.rlane_cd  = c.rlane_cd
               AND a.dir_cd    = c.dir_cd
               AND a.bsa_seq   = param.bsa_seq
               AND a.trd_cd    = param.trd_cd
               AND a.rlane_cd  = param.rlane_cd
               AND a.dir_cd    = param.dir_cd
               AND a.vsl_seq   = param.vsl_seq
               AND b.bsa_op_jb_cd IN ('007','015','016')
            ;
            v_sql_cnt := sql%rowcount;
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
            enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'SC Creation');
        END LOOP;



        /* STEP #4 : 구간 주차에 대한 from~to Date를 구한다 -------------------------------------------------*/
        v_status_msg := '4) 주차구하기';
        SELECT TO_CHAR(MIN(n1st_lodg_port_etd_dt),'yyyymmdd'),TO_CHAR(MAX(n1st_lodg_port_etd_dt),'yyyymmdd')
          INTO v_sls_fm_dt, v_sls_to_dt
          FROM coa_mon_vvd
         WHERE SUBSTR(sls_yrmon,1,4)||cost_wk BETWEEN p_fm_yrwk AND p_to_yrwk
        ;
        v_sql_cnt := sql%rowcount;
--        DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || v_sls_fm_dt || '~' || v_sls_to_dt || ']' , 'SC Creation');
    
    
    
        /* STEP #5 : Price Creation : COA_BSA_SLT_PRC Insert ------------------------------------------------*/
        v_status_msg := '5) BSA_SLT_PRC Insert';
        INSERT INTO bsa_slt_prc (slt_prc_seq, trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                                     bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt,
                                     co_bfr_sub_capa, sub_chtr_bsa_capa, crs_chtr_bsa_capa,
                                     cre_usr_id, cre_dt, upd_usr_id, upd_dt)
        SELECT 1, trd_cd, rlane_cd, dir_cd, '017',
               bsa_fm_dt, bsa_to_dt,
               0, 0, 0,
               v_user_id, SYSDATE, v_user_id, SYSDATE
          FROM (
                SELECT a.trd_cd, a.rlane_cd, a.dir_cd, a.bsa_fm_dt, a.bsa_to_dt,
                       NVL(b.dir_cd,'Y') AS ins_chk
                  FROM (
                        SELECT DISTINCT MIN(bsa_fm_dt) AS bsa_fm_dt, trd_cd, rlane_cd, dir_cd, bsa_to_dt
                          FROM bsa_slt_chtr_bzc
                         WHERE bsa_fm_dt  >= v_sls_fm_dt
                           AND (bsa_to_dt <= NVL(v_sls_to_dt,'99991231') OR bsa_to_dt = '99991231')
                         GROUP BY trd_cd, rlane_cd, dir_cd, bsa_to_dt
                       ) a,
                       bsa_slt_prc b
                 WHERE a.trd_cd                = b.trd_cd(+)
                   AND a.rlane_cd              = b.rlane_cd(+)
                   AND a.dir_cd                = b.dir_cd(+)
                   AND b.bsa_slt_cost_tp_cd(+) = '017'
               )
         WHERE ins_chk = 'Y'
        ;
        v_sql_cnt := sql%rowcount;
--        DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'SC Creation');
        
        
        
        /* STEP #6 : Price Creation : COA_BSA_SLT_PRC_CRR Insert --------------------------------------------*/
        v_status_msg := '6) BSA_SLT_PRC_CRR Insert';
        INSERT INTO bsa_slt_prc_crr (slt_prc_seq, trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                                         bsa_op_jb_cd, crr_cd,
                                         bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt, slt_prc_capa,
                                         cre_usr_id, cre_dt, upd_usr_id, upd_dt)
        SELECT 1, a.trd_cd, a.rlane_cd, a.dir_cd, a.bsa_slt_cost_tp_cd,
               b.bsa_op_jb_cd, b.crr_cd,
               a.bsa_slt_prc_fm_dt, a.bsa_slt_prc_to_dt, 0,
               v_user_id, SYSDATE, v_user_id, SYSDATE
        FROM (
              SELECT trd_cd, rlane_cd, dir_cd, bsa_slt_cost_tp_cd,
                     bsa_slt_prc_fm_dt, bsa_slt_prc_to_dt
                FROM (
                      SELECT s.trd_cd, s.rlane_cd, s.dir_cd, s.bsa_slt_cost_tp_cd,
                             s.bsa_slt_prc_fm_dt, s.bsa_slt_prc_to_dt,
                             NVL(t.trd_cd,'Y') AS ins_chk
                        FROM bsa_slt_prc s,
                             bsa_slt_prc_crr t
                       WHERE s.slt_prc_seq        = t.slt_prc_seq (+)
                         AND s.trd_cd             = t.trd_cd (+)
                         AND s.rlane_cd           = t.rlane_cd (+)
                         AND s.dir_cd             = t.dir_cd (+)
                         AND s.bsa_slt_cost_tp_cd = t.bsa_slt_cost_tp_cd (+)
                         AND s.bsa_slt_prc_fm_dt >= v_sls_fm_dt
                         AND (s.bsa_slt_prc_to_dt<= NVL(v_sls_to_dt,'99991231') OR s.bsa_slt_prc_to_dt = '99991231')
                      )
               WHERE ins_chk = 'Y'
              ) a,
              (
              SELECT bsa_op_jb_cd, crr_cd
                FROM bsa_crr_rgst
               WHERE bsa_op_jb_cd IN ('001','002','004')
                 AND bsa_op_cd = 'S'
                 AND aply_flg  = 'Y'
              ) b
        ;
        v_sql_cnt := sql%rowcount;
--        DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(v_sql_cnt) || '건 처리됨 ');
        enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', v_status_msg || '[' || TO_CHAR(v_sql_cnt)|| ']' , 'SC Creation');
        
    END IF ;

    /* 성공적으로 항차 생성 완료시 */
    DBMS_OUTPUT.PUT_LINE('OK');
    p_error_code :=  '00000';
    p_error_msg  := 'Completed!';
    
-----------------[ 예외처리부            ]-----------------------
   EXCEPTION
     WHEN OTHERS THEN
     
         p_error_code   := SQLCODE;
         p_error_msg    := v_status_msg || '  '|| SQLERRM || ' >>> ' || v_dtl_msg ;
         DBMS_OUTPUT.PUT_LINE('[Create Target VVD PRC] : Error!! ][' || v_mig_err_msg || '] info : [' || p_error_msg || '] '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
         enis_log_prc(SYSDATE, 'BSA_CREATE_PRC', p_error_msg, 'Exception');
END BSA_CREATE_PRC;