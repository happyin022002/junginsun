CREATE OR REPLACE PROCEDURE OPUSADM.BSA_RESET_VVD_PRC
          (
           p_year       IN VARCHAR2, -- Mandatory
           p_fm_yrmon   IN VARCHAR2, -- Mandatory
           p_to_yrmon   IN VARCHAR2, -- Mandatory
           p_fm_week    IN VARCHAR2, -- Mandatory
           p_to_week    IN VARCHAR2, -- Mandatory
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
    Name         :   BSA_RESET_VVD_PRC
    Purpose      :   VVD별로 생성된 데이터를 재 SETTING
    Source       :   coa_mon_vvd,
    Target       :   bsa_vvd_mst,bsa_vvd_otr_crr,bsa_vvd_perf,bsa_vvd_port_dwn,bsa_vvd_swap_info
    Ver          :   1.0
    Date         :   2006.10.20
    System       :   Sales ManageMent > Basic Slot Allotment
    Author       :   
******************************************************************************/
/*
 --------------------------------------------------------------------------------------------------
  1.Name       : 
  2.Create Date: 2006-12-26
  3.Description:
    - 용도: 1.  VVD별로 생성된 데이터를 재 SETTING
    - 파라미터: 년,주차,trade,revenue lane,ioc,vsl
                P_IND : 얘는 'BSA','PORT','SPC','PFMC' 세가지만 올 수 있다.
                        BSA  => BSA 정보만 RESETTING          : UI_ESM_BSA_0030 (TEU)
                        PFMC => 선복 임대 수입/비용 RESETTING : UI_ESM_BSA_0030 (Basic Slottage )
                        PORT => PORT 정보 RESETTING           : UI_ESM_BsA_0032
                        SPC  => SPC SWAP 정보 RESETTING       : UI_ESM_BSA_0104
    - 특이사항
  4.Revision History
 --------------------------------------------------------------------------------------------------
*/
/* Procedure의  Parameter기준의 대상항차 List 선정) */
CURSOR target_vvd_cur( v_year    VARCHAR2,
                       v_fm_mon  VARCHAR2, v_to_mon     VARCHAR2,
                       v_fm_week VARCHAR2, v_to_week    VARCHAR2,
                       v_trd_cd  VARCHAR2, v_rlane_cd   VARCHAR2, v_ioc_cd VARCHAR2,
                       v_vsl_cd  VARCHAR2, v_skd_voy_no VARCHAR2, v_dir_cd VARCHAR2) IS
SELECT a.trd_cd, a.rlane_cd,a.vsl_cd,a.skd_voy_no,a.dir_cd,a.ioc_cd,
       e.vop_cd, 
       NVL(SUBSTR(c.vsl_lane_tp_cd,1,1), f.bsa_op_cd) bsa_op_cd, a.sub_trd_cd, f.port_bsa_cfm_flg,
       DECODE(NVL(b.sub_trd_capa,0),0,NVL(e.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0)) vsl_capa,
       a.n1st_lodg_port_etd_dt as n1st_port_etd_dt, a.lst_lodg_port_cd as rev_port_cd,
       a.lst_lodg_port_etd_dt as rev_port_etd_dt
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
                       x.vop_cd, x.vsl_aply_fm_dt vsl_aply_fm_dt, x.vsl_aply_to_dt vsl_aply_to_dt, x.crr_cd vsl_crr_cd
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
       SELECT DISTINCT NVL(b.trd_cd , a.trd_cd)         trd_cd,
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
        WHERE NVL(a.delt_flg,'N') <> 'Y'
          AND a.trd_cd            = NVL(v_trd_cd  , a.trd_cd)
          AND a.rlane_cd          = NVL(v_rlane_cd, a.rlane_cd)
          AND a.dir_cd            = NVL(v_dir_cd  , a.dir_cd)
       ) c,
      (
       SELECT a.vsl_cd,  a.vop_cd ,   a.stnd_ldb_capa ,
              NVL(TO_CHAR(a.vsl_aply_fm_dt,'yyyymmdd'), '19000101')       vsl_aply_fom_dt,
              NVL(TO_CHAR(a.vsl_aply_to_dt,'yyyymmdd') , '99991231')       vsl_aply_to_dt,
              a.vsl_clss_capa, a.trd_chk_flg, a.delt_flg
         FROM coa_vsl_rgst a 
      ) e,
       bsa_vvd_mst f
 WHERE 1=1
   AND a.vsl_cd             = b.vsl_cd(+)
   AND a.sub_trd_cd         = b.sub_trd_cd(+)
   AND a.vsl_cd             = e.vsl_cd(+)
   AND a.trd_cd             = f.trd_cd
   AND a.rlane_cd           = f.rlane_cd
   AND a.ioc_cd             = f.ioc_cd
   AND a.vsl_cd             = f.vsl_cd
   AND a.skd_voy_no         = f.skd_voy_no
   AND a.dir_cd             = f.skd_dir_cd
   AND a.sls_yrmon         LIKE SUBSTR(v_year,1,4)||'%'
   AND a.cost_yrmon         BETWEEN NVL(v_fm_mon,a.cost_yrmon) AND NVL(v_to_mon,a.cost_yrmon)
   AND a.cost_wk            BETWEEN NVL(v_fm_week,a.cost_wk)   AND NVL(v_to_week,a.cost_wk)
   AND a.rlane_cd           = c.rlane_cd
   AND a.dir_cd             = c.dir_cd   
   AND a.trd_cd             = c.trd_cd      -- [CHM-201007841-01] Trade 조건 추가   
   AND NVL(a.delt_flg,'N') <> 'Y'
   AND NVL(e.delt_flg,'N') <> 'Y'
   AND c.vsl_lane_tp_cd     IN ('JO','SC')
   AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(c.lane_aply_fom_dt,'19000101') AND NVL(c.lane_aply_to_dt, '99991231')
   AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(b.vsl_aply_fom_dt ,'19000101') AND NVL(b.vsl_aply_to_dt , '99991231')
   AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(e.vsl_aply_fom_dt ,'19000101') AND NVL(e.vsl_aply_to_dt , '99991231')
   AND a.trd_cd             = NVL(v_trd_cd,a.trd_cd)
   AND a.rlane_cd           = NVL(v_rlane_cd,a.rlane_cd)
   AND a.ioc_cd             = NVL(v_ioc_cd,a.ioc_cd)
   AND a.vsl_cd             = NVL(v_vsl_cd,a.vsl_cd)
   AND a.skd_voy_no         = NVL(v_skd_voy_no,a.skd_voy_no)
   AND a.dir_cd             = NVL(v_dir_cd,a.dir_cd)
;

------------------------------[ 변수선언부 ]-----------------------
v_commit_unit      PLS_INTEGER    := 10000                   ;
v_read_count       number(10)     := 0                       ;

/** 작업로그 관련 변수선언 **/
v_mig_pgm_nm       varchar2(100)  := 'BSA_RESET_VVD_PRC' ;
v_mig_st_dt        date                                          ;
v_mig_err_msg      varchar2(1000)                                ;
v_status_msg       varchar2(1000)                                ;
v_dtl_msg          varchar2(3000)                                ;
v_info             varchar2(3000)                                ;
exist_chk          varchar2(1)    :='N'                          ;
v_step_no          varchar2(2);  
v_vsl_crr_cd       varchar2(3) ;/* 각 배별 선사 코드 */

/* 오류 변수 선언 */
vvd_cre_error EXCEPTION;

/** BSA_SLT_CHTR_BZC 테이블의 PK [CHM-201005480-01] **/
bscb_trd_cd        varchar2(3);
bscb_rlane_cd      varchar2(5);
bscb_dir_cd        varchar2(1);
bscb_vsl_seq       number(3);
bscb_bsa_seq       number(3);

------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
DBMS_OUTPUT.ENABLE;

/** 시작일시 설정 **/
v_mig_st_dt := SYSDATE ;
--DBMS_OUTPUT.PUT_LINE('['||v_mig_pgm_nm||']  : VVD별 BSA 생성'||TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS'));
enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', '---------------------------------------' , 'VVD Reset');
    

FOR bsa_target_vvd IN target_vvd_cur(p_year,p_fm_yrmon,p_to_yrmon,p_fm_week,p_to_week,
                                     p_trd_cd,p_rlane_cd,p_ioc_cd,
                                     p_vsl_cd,p_skd_voy_no,p_dir_cd) LOOP

    v_dtl_msg := to_char(target_vvd_cur%rowcount)||'==>'||bsa_target_vvd.trd_cd||':'||bsa_target_vvd.rlane_cd   ||':'||bsa_target_vvd.vsl_cd    ||':'||bsa_target_vvd.skd_voy_no||':'||bsa_target_vvd.dir_cd||':'||
                 bsa_target_vvd.ioc_cd           ||':'|| bsa_target_vvd.vop_cd ||':'|| bsa_target_vvd.bsa_op_cd ||':'|| bsa_target_vvd.vsl_capa ||':'||to_char(bsa_target_vvd.n1st_port_etd_dt,'yyyymmdd')  || ':' ||
                 p_user_id                       ||':'|| p_year                || '.' || p_fm_yrmon || '~' || p_to_yrmon || ':' || p_fm_week || '~' || p_to_week  ;
    v_info    := bsa_target_vvd.trd_cd||':'||bsa_target_vvd.rlane_cd   ||':'||bsa_target_vvd.vsl_cd || bsa_target_vvd.skd_voy_no|| bsa_target_vvd.dir_cd||':'||
                 bsa_target_vvd.ioc_cd           ||':'|| bsa_target_vvd.vop_cd ||':'|| bsa_target_vvd.bsa_op_cd ||':'|| bsa_target_vvd.vsl_capa ||':'||to_char(bsa_target_vvd.n1st_port_etd_dt,'yyyymmdd')  || ':' ||
                 p_year                || '.' || p_fm_week || '~' || p_to_week  ;
--    DBMS_OUTPUT.PUT_LINE('INFO : ' || v_dtl_msg);
      enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', 'Info : ' || v_dtl_msg , 'VVD Reset'); 
    
    /* VSL의 선사 정보 찾기 */
    BEGIN
        SELECT crr_cd
          INTO v_vsl_crr_cd
          FROM coa_vsl_rgst
         WHERE DELT_FLG <> 'Y'
           AND vsl_cd = bsa_target_vvd.vsl_cd
           AND rownum = 1
        ;
    EXCEPTION
        WHEN NO_DATA_FOUND then
             v_step_no := '0';
             v_vsl_crr_cd :='';
        WHEN OTHERS THEN
             v_step_no := '0';
             RAISE;
    END ;
    DBMS_OUTPUT.PUT_LINE('1');


    /* master table 기본 정보 Update */
    v_step_no := '1';
    v_status_msg := '1) master table 기본 정보 Update';
    UPDATE bsa_vvd_mst
       SET (bsa_op_cd, crr_cd, vsl_capa, bsa_capa, vop_cd, rev_port_cd, rev_port_etd_dt, n1st_port_etd_dt) =
           (
           SELECT bsa_target_vvd.bsa_op_cd, v_vsl_crr_cd, bsa_target_vvd.vsl_capa, bsa_target_vvd.vsl_capa,
                  decode(bsa_target_vvd.bsa_op_cd,'J', bsa_target_vvd.vop_cd,'S','OTH'),           
                  --bsa_target_vvd.vop_cd,
                  bsa_target_vvd.rev_port_cd, bsa_target_vvd.rev_port_etd_dt, bsa_target_vvd.n1st_port_etd_dt
             FROM DUAL
           )
     WHERE trd_cd     = bsa_target_vvd.trd_cd
       AND rlane_cd   = bsa_target_vvd.rlane_cd
       AND vsl_cd     = bsa_target_vvd.vsl_cd
       AND skd_voy_no = bsa_target_vvd.skd_voy_no
       AND skd_dir_cd = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--    DBMS_OUTPUT.PUT_LINE('2 : [' || to_char(SQL%rowcount)||']');
    
    /*
      JO->SC 변경 유무를 체크한다.
      1: JO
      1 이상이면 SC
    */
    SELECT COUNT(*)
      INTO v_read_count
      FROM bsa_vvd_crr_perf
     WHERE trd_cd       = bsa_target_vvd.trd_cd
       AND rlane_cd     = bsa_target_vvd.rlane_cd
       AND vsl_cd       = bsa_target_vvd.vsl_cd
       AND skd_voy_no   = bsa_target_vvd.skd_voy_no
       AND skd_dir_cd   = bsa_target_vvd.dir_cd
       and bsa_op_jb_cd = '000'
    ;
--    DBMS_OUTPUT.PUT_LINE('>>>>>>>>>>>>>>>>>>>>>>>' || v_read_count || ' : ' || bsa_target_vvd.bsa_op_cd);
    
    /** BSA_SLT_CHTR_BZC 테이블의 PK 구하기 [CHM-201005480-01] **/
    BEGIN
        SELECT  X.TRD_CD, X.RLANE_CD, X.DIR_CD, X.VSL_SEQ, X.BSA_SEQ
        INTO    bscb_trd_cd, bscb_rlane_cd, bscb_dir_cd, bscb_vsl_seq, bscb_bsa_seq
        FROM
            (    SELECT  TRD_CD, RLANE_CD, DIR_CD, VSL_SEQ, BSA_SEQ, VSL_CD, MAX ( VSL_CD ) OVER () VSL_CD2
                 FROM    BSA_SLT_CHTR_BZC
                 WHERE   TRD_CD                    = bsa_target_vvd.trd_cd
                 AND     RLANE_CD                  = bsa_target_vvd.rlane_cd
                 AND     DIR_CD                    = bsa_target_vvd.dir_cd
                 AND     bsa_target_vvd.bsa_op_cd  ='S'
                 AND     NVL(VSL_CD,'X')           = DECODE(VSL_CD,NULL,'X', bsa_target_vvd.vsl_cd)
                 AND     bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(BSA_FM_DT,'yyyymmdd') AND TO_DATE(BSA_TO_DT,'yyyymmdd')+0.99999 
            ) X
        WHERE   NVL(X.VSL_CD2, 'X' ) = decode ( X.VSL_CD, NULL, 'X', bsa_target_vvd.vsl_cd ); 
    EXCEPTION
        WHEN NO_DATA_FOUND then
             bscb_trd_cd      := '';
             bscb_rlane_cd    := '';
             bscb_dir_cd      := '';
             bscb_vsl_seq     := -1;
             bscb_bsa_seq     := -1;
        WHEN OTHERS THEN
             v_step_no := '11';
             RAISE;
    END ;

    IF v_read_count <= 1 AND bsa_target_vvd.bsa_op_cd = 'S' THEN
    
        /* Carrier별 실적 Table 물량 Delete */  
        v_step_no := '2';
        v_status_msg := '2) Carrier별 실적 Table 물량 Delete[COA_BSA_VVD_CRR_PERF]';
        DELETE FROM bsa_vvd_crr_perf
         WHERE trd_cd       = bsa_target_vvd.trd_cd
           AND rlane_cd     = bsa_target_vvd.rlane_cd
           AND vsl_cd       = bsa_target_vvd.vsl_cd
           AND skd_voy_no   = bsa_target_vvd.skd_voy_no
           AND skd_dir_cd   = bsa_target_vvd.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--        DBMS_OUTPUT.PUT_LINE('3 : [' || TO_CHAR(sql%rowcount) || ']');
        
        /* Carrier별 실적 Table 물량 Insert */  
        v_step_no := '3';
        v_status_msg := '3) Carrier별 실적 Table 물량 Insert[COA_BSA_VVD_CRR_PERF]';
        INSERT INTO bsa_vvd_crr_perf 
        (
         trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, 
         bsa_op_jb_cd, crr_cd, crr_bsa_capa, crr_perf_amt, 
         cre_usr_id, cre_dt, upd_usr_id, upd_dt
        )
        SELECT  x.trd_cd, x.rlane_cd, x.vsl_cd, x.skd_voy_no, x.dir_cd, 
                decode(bsa_target_vvd.bsa_op_cd||x.bsa_op_jb_cd,'S001','000',x.bsa_op_jb_cd),
                x.crr_cd, x.crr_bsa_capa, x.crr_perf_amt,
                p_user_id, SYSDATE, p_user_id, SYSDATE
        FROM (
--              SELECT  bsa_target_vvd.trd_cd     AS trd_cd,
--                      bsa_target_vvd.rlane_cd   AS rlane_cd,
--                      bsa_target_vvd.vsl_cd     AS vsl_cd,
--                      bsa_target_vvd.skd_voy_no AS skd_voy_no,
--                      bsa_target_vvd.dir_cd     AS dir_cd,                           
--                      e.bsa_op_jb_cd,
--                      e.crr_cd,
--                      e.crr_bsa_capa,
--                      0                AS crr_perf_amt                          
--              FROM coa_bsa_jnt_op_bzc d,
--                   coa_bsa_jnt_op_crr_capa e
--              WHERE d.BSA_SEQ                   = e.BSA_SEQ
--                AND d.trd_cd                    = e.trd_cd 
--                AND d.rlane_cd                  = e.rlane_cd 
--                AND d.dir_cd                    = e.dir_cd 
--                AND d.vop_cd                    = e.vop_cd 
--                AND d.vsl_capa                  = e.vsl_capa 
--                AND d.trd_cd                    = bsa_target_vvd.trd_cd
--                AND d.rlane_cd                  = bsa_target_vvd.rlane_cd
--                AND d.dir_cd                    = bsa_target_vvd.dir_cd
--                AND d.vop_cd                    = bsa_target_vvd.vop_cd
--                AND d.vsl_capa                  = bsa_target_vvd.vsl_capa     
--                AND bsa_target_vvd.bsa_op_cd    ='J'
--                AND ((e.vop_cd = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND e.bsa_op_jb_cd = '001') OR e.bsa_op_jb_cd IN ('002','003','004','005'))
--                AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
--              UNION ALL
              SELECT  bsa_target_vvd.trd_cd,
                      bsa_target_vvd.rlane_cd,
                      bsa_target_vvd.vsl_cd,
                      bsa_target_vvd.skd_voy_no,
                      bsa_target_vvd.dir_cd,
                      e.bsa_op_jb_cd,
                      e.crr_cd,
                      e.crr_bsa_capa,
                      0 AS crr_perf_amt       
              FROM bsa_slt_chtr_bzc d,
                   bsa_slt_chtr_crr_capa e
              WHERE d.bsa_seq                   = e.bsa_seq
                AND d.trd_cd                    = e.trd_cd 
                AND d.rlane_cd                  = e.rlane_cd 
                AND d.dir_cd                    = e.dir_cd                 
                AND d.vsl_seq                   = e.vsl_seq
                AND d.trd_cd                    = bscb_trd_cd    -- bsa_target_vvd.trd_cd
                AND d.rlane_cd                  = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
                AND d.dir_cd                    = bscb_dir_cd    -- bsa_target_vvd.dir_cd
                AND d.vsl_seq                   = bscb_vsl_seq
                AND d.bsa_seq                   = bscb_bsa_seq
                AND bsa_target_vvd.bsa_op_cd    ='S'
--              AND NVL(d.vsl_cd,'X')           = DECODE(d.vsl_cd,NULL,'X',bsa_target_vvd.vsl_cd)          
                AND e.bsa_op_jb_cd              IN ('001','002','003','004','005')   
--              AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
             ) x
        ; 
        enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');                
--        DBMS_OUTPUT.PUT_LINE('3 : [' || TO_CHAR(sql%rowcount) || ']');

    ELSE
        v_step_no := '4';
        v_status_msg := '4) Carrier별 실적 Table 물량 Update[COA_BSA_VVD_CRR_PERF]';
        UPDATE bsa_vvd_crr_perf  z
           SET z.crr_bsa_capa = (
                                 SELECT e.crr_bsa_capa
                                   FROM bsa_jnt_op_bzc d,bsa_jnt_op_crr_capa e
                                  WHERE d.bsa_seq      = e.bsa_seq
                                    AND d.trd_cd       = e.trd_cd
                                    AND d.rlane_cd     = e.rlane_cd
                                    AND d.dir_cd       = e.dir_cd
                                    AND d.vop_cd       = e.vop_cd
                                    AND d.vsl_capa     = e.vsl_capa
                                    AND d.trd_cd       = bsa_target_vvd.trd_cd
                                    AND d.rlane_cd     = bsa_target_vvd.rlane_cd
                                    AND d.dir_cd       = bsa_target_vvd.dir_cd
                                    AND d.vop_cd       = bsa_target_vvd.vop_cd
                                    AND d.vsl_capa     = bsa_target_vvd.vsl_capa
                                    and bsa_target_vvd.bsa_op_cd ='J'
                                    AND ((e.vop_cd = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND e.bsa_op_jb_cd = '001') OR e.bsa_op_jb_cd IN ('002','003','004','005'))
                                    AND z.trd_cd       = e.trd_cd
                                    AND z.rlane_cd     = e.rlane_cd
                                    AND z.skd_dir_cd   = e.dir_cd
                                    and z.bsa_op_jb_cd = e.bsa_op_jb_cd
                                    and z.crr_cd       = e.crr_cd
                                    AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
                                 UNION ALL
                                 SELECT  e.crr_bsa_capa
                                   FROM bsa_slt_chtr_bzc d,bsa_slt_chtr_crr_capa e
                                  WHERE d.bsa_seq                = e.bsa_seq
                                    AND d.trd_cd                 = e.trd_cd
                                    AND d.rlane_cd               = e.rlane_cd
                                    AND d.dir_cd                 = e.dir_cd
                                    AND d.vsl_seq                = e.vsl_seq
                                    AND d.trd_cd                 = bscb_trd_cd    -- bsa_target_vvd.trd_cd
                                    AND d.rlane_cd               = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
                                    AND d.dir_cd                 = bscb_dir_cd    -- bsa_target_vvd.dir_cd
                                    AND d.vsl_seq                = bscb_vsl_seq
                                    AND d.bsa_seq                = bscb_bsa_seq
                                    and bsa_target_vvd.bsa_op_cd = 'S'
--                                  AND NVL(d.vsl_cd,'X')        = DECODE(D.VSL_CD,NULL,'X',bsa_target_vvd.vsl_cd)
                                    AND e.bsa_op_jb_cd           IN ('001','002','003','004','005')
                                    AND z.trd_cd                 = e.trd_cd
                                    AND z.rlane_cd               = e.rlane_cd
                                    AND z.skd_dir_cd             = e.dir_cd
                                    and z.bsa_op_jb_cd           = DECODE(e.bsa_op_jb_cd,'001','000',e.bsa_op_jb_cd)
                                    and z.crr_cd                 = e.crr_cd
--                                  AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
                                 )
         WHERE z.trd_cd       = bsa_target_vvd.trd_cd
           AND z.rlane_cd     = bsa_target_vvd.rlane_cd
           AND z.vsl_cd       = bsa_target_vvd.vsl_cd
           AND z.skd_voy_no   = bsa_target_vvd.skd_voy_no
           AND z.skd_dir_cd   = bsa_target_vvd.dir_cd
           and z.bsa_op_jb_cd IN ('001','002','003','004','005','000')
        ;
        enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--        DBMS_OUTPUT.PUT_LINE('3 : [' || to_char(SQL%rowcount)||']');
        
    END IF;
    
    
    /* MASTER TABLE Update */
    /* Master의 물량 기준 정보 Update */
    v_step_no := '5';
    v_status_msg := '5) Master의 물량 기준 정보 Update[coa_bsa_vvd_mst]';
    UPDATE bsa_vvd_mst
       SET (vsl_capa, bsa_capa, fnl_co_bsa_capa, co_bsa_bfr_sub_capa) = (
                                                                           SELECT bsa_target_vvd.vsl_capa, bsa_capa, 0 co_final, co_bsa_bfr_sub_capa
                                                                             FROM bsa_jnt_op_bzc
                                                                            WHERE trd_cd     = bsa_target_vvd.trd_cd
                                                                              AND rlane_cd   = bsa_target_vvd.rlane_cd
                                                                              AND dir_cd     = bsa_target_vvd.dir_cd
                                                                              AND VOP_CD     = bsa_target_vvd.vop_cd
                                                                              AND vsl_capa   = bsa_target_vvd.vsl_capa
                                                                              AND bsa_target_vvd.bsa_op_cd ='J'
                                                                              AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(bsa_fm_dt,'yyyymmdd') AND TO_DATE(bsa_to_dt,'yyyymmdd')+0.99999
                                                                           UNION ALL
                                                                           SELECT bsa_target_vvd.vsl_capa,0,d.co_fnl_bsa_capa,d.co_bsa_bfr_sub_capa
                                                                             FROM bsa_slt_chtr_bzc d
                                                                            WHERE d.trd_cd                 = bscb_trd_cd    -- bsa_target_vvd.trd_cd
                                                                              AND d.rlane_cd               = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
                                                                              AND d.dir_cd                 = bscb_dir_cd    -- bsa_target_vvd.dir_cd
                                                                              AND d.vsl_seq                = bscb_vsl_seq
                                                                              AND d.bsa_seq                = bscb_bsa_seq
                                                                              AND bsa_target_vvd.bsa_op_cd ='S'
--                                                                            AND nvl(vsl_cd,'X') = DECODE(vsl_cd,NULL,'X', bsa_target_vvd.vsl_cd)
--                                                                            AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(bsa_fm_dt,'yyyymmdd') AND TO_DATE(bsa_to_dt,'yyyymmdd')+0.99999
                                                                          )
     WHERE trd_cd     = bsa_target_vvd.trd_cd
       AND rlane_cd   = bsa_target_vvd.rlane_cd
       AND vsl_cd     = bsa_target_vvd.vsl_cd
       AND skd_voy_no = bsa_target_vvd.skd_voy_no
       AND skd_dir_cd = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--    DBMS_OUTPUT.PUT_LINE('4 : [' || to_char(SQL%rowcount)||']'|| bsa_target_vvd.bsa_op_cd);


    /* vvd Carrier별 물량을 감안한 최종 물량 기준 정보 Update */
    v_step_no := '6';
    v_status_msg := '6) vvd Carrier별 물량을 감안한 최종 물량 기준 정보 Update[coa_bsa_vvd_mst]';
    UPDATE bsa_vvd_mst
       SET (fnl_co_bsa_capa,co_bsa_capa,co_bsa_rto,chtr_bsa_rto) =
           (
            SELECT fnl_co_bsa_capa,cht_out,
                   fnl_co_bsa_capa/DECODE((fnl_co_bsa_capa+cht_out),0,1,(fnl_co_bsa_capa+cht_out)) co_rto,
                   1 - fnl_co_bsa_capa/DECODE((fnl_co_bsa_capa+cht_out),0,1,(fnl_co_bsa_capa+cht_out)) cht_rto
              FROM (
                    SELECT trd_cd,rlane_cd,vsl_cd,skd_voy_no,skd_dir_cd,
                           bsa_op_cd,vop_cd,
                           DECODE(bsa_op_cd,'S',fnl_co_bsa_capa,(co_bsa_bfr_sub_capa - sco+sci-cco+cci)) fnl_co_bsa_capa,
                           DECODE(vop_cd,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC,DECODE(bsa_op_cd,'J',ini+sco+cco,ini+sco),
                           DECODE(bsa_op_cd,'J',SCO+CCO,sco)) cht_out,
                           co_bsa_bfr_sub_capa
                      FROM (
                            SELECT a.trd_cd,a.rlane_cd,a.vsl_cd,a.skd_voy_no,a.skd_dir_cd,
                                   a.fnl_co_bsa_capa,a.bsa_op_cd,a.vop_cd,
                                   a.co_bsa_bfr_sub_capa,
                                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'001',b.crr_bsa_capa)),0) ini,
                                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'002',b.crr_bsa_capa)),0) sco,
                                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'003',b.crr_bsa_capa)),0) sci,
                                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'004',b.crr_bsa_capa)),0) cco,
                                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'005',b.crr_bsa_capa)),0) cci
                              FROM bsa_vvd_mst a, bsa_vvd_crr_perf b
                             WHERE a.trd_cd     = b.trd_cd(+)
                               AND a.rlane_cd   = b.rlane_cd(+)
                               AND a.vsl_cd     = b.vsl_cd(+)
                               AND a.skd_voy_no = b.skd_voy_no(+)
                               AND a.skd_dir_cd = b.skd_dir_cd(+)
                               AND a.trd_cd     = bsa_target_vvd.trd_cd
                               AND a.rlane_cd   = bsa_target_vvd.rlane_cd
                               AND a.vsl_cd     = bsa_target_vvd.vsl_cd
                               AND a.skd_voy_no = bsa_target_vvd.skd_voy_no
                               AND a.skd_dir_cd = bsa_target_vvd.dir_cd
                             GROUP BY a.trd_cd,a.rlane_cd,a.vsl_cd,a.skd_voy_no,a.skd_dir_cd,
                                      a.fnl_co_bsa_capa,a.bsa_op_cd,a.vop_cd,
                                      a.co_bsa_bfr_sub_capa
                            )
                    )
           )
     WHERE trd_cd     = bsa_target_vvd.trd_cd
       AND rlane_cd   = bsa_target_vvd.rlane_cd
       AND vsl_cd     = bsa_target_vvd.vsl_cd
       AND skd_voy_no = bsa_target_vvd.skd_voy_no
       AND skd_dir_cd = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--    DBMS_OUTPUT.PUT_LINE('5 : [' || to_char(SQL%rowcount)||']');


    /* Port Step Up/Down Insert
       Port BSA Confirm Flag가 'N' 일때만 update 해준다.*/
    IF bsa_target_vvd.port_bsa_cfm_flg = 'N' THEN
        v_step_no := '7';
        v_status_msg := '7) Port Step Up/Down Insert[coa_bsa_vvd_port_dwn]';
        UPDATE /*+ CHOOSE */bsa_vvd_port_dwn z
           SET port_bsa_capa = (
                               SELECT DISTINCT b.port_bsa_capa
                                 FROM bsa_jnt_op_bzc a,bsa_jnt_op_port_dwn b
                                WHERE a.bsa_seq = b.bsa_seq
                                  AND a.trd_cd    = b.trd_cd
                                  AND a.rlane_cd  = b.rlane_cd
                                  AND a.dir_cd    = b.dir_cd
                                  AND a.vop_cd    = b.vop_cd
                                  AND a.vsl_capa  = b.vsl_capa
                                  AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'yyyymmdd')
                                                                          AND TO_DATE(a.bsa_to_dt,'yyyymmdd')+0.99999
                                  AND a.trd_cd          = bsa_target_vvd.trd_cd
                                  AND a.rlane_cd        = bsa_target_vvd.rlane_cd
                                  AND a.dir_cd          = bsa_target_vvd.dir_cd
                                  AND a.vop_cd          = bsa_target_vvd.vop_cd
                                  AND a.vsl_capa        = bsa_target_vvd.vsl_capa
                                  AND z.bsa_op_jb_cd    = b.bsa_op_jb_cd
                                  AND z.crr_cd          = b.crr_cd
                                  AND z.port_cd         = b.port_cd
                                  AND bsa_target_vvd.bsa_op_cd ='J'
                                UNION ALL
                               SELECT DISTINCT b.port_bsa_capa
                                 FROM bsa_slt_chtr_bzc a,bsa_slt_chtr_port_dwn b
                                WHERE a.bsa_seq         = b.bsa_seq
                                  AND a.trd_cd          = b.trd_cd
                                  AND a.rlane_cd        = b.rlane_cd
                                  AND a.dir_cd          = b.dir_cd
                                  AND a.vsl_seq         = b.vsl_seq
--                                AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'yyyymmdd')
--                                                                        AND TO_DATE(a.bsa_to_dt,'yyyymmdd')+0.99999
                                  AND a.trd_cd          = bscb_trd_cd    -- bsa_target_vvd.trd_cd
                                  AND a.rlane_cd        = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
                                  AND a.dir_cd          = bscb_dir_cd    -- bsa_target_vvd.dir_cd
                                  AND a.vsl_seq         = bscb_vsl_seq
                                  AND a.bsa_seq         = bscb_bsa_seq
                                  AND z.bsa_op_jb_cd    = b.bsa_op_jb_cd
                                  AND z.crr_cd          = b.crr_cd
                                  AND z.port_cd         = b.port_cd
                                  AND bsa_target_vvd.bsa_op_cd ='S'
--                                AND NVL(a.vsl_cd,'X') = DECODE(a.VSL_CD,NULL,'X',bsa_target_vvd.vsl_cd)
                                )
         WHERE z.trd_cd     = bsa_target_vvd.trd_cd
           AND z.rlane_cd   = bsa_target_vvd.rlane_cd
           AND z.vsl_cd     = bsa_target_vvd.vsl_cd
           AND z.skd_voy_no = bsa_target_vvd.skd_voy_no
           AND z.skd_dir_cd = bsa_target_vvd.dir_cd
           AND z.port_seq   <> 999
        ;
        enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--        DBMS_OUTPUT.PUT_LINE('6 : [' || to_char(SQL%rowcount)||']');
    END IF;

  
     /* Port Step Up/Down에 선사별 값 Insert */
     v_step_no := '8';
     v_status_msg := '8) Port Step Up/Down에 선사별 값 Insert[coa_bsa_vvd_port_dwn]'; 
         update /*+ CHOOSE */bsa_vvd_port_dwn z
            set z.port_bsa_capa = (
                                  SELECT e.crr_bsa_capa                          
                                    FROM bsa_jnt_op_bzc d,bsa_jnt_op_crr_capa e
                                   WHERE d.bsa_seq  = e.bsa_seq 
                                     AND d.trd_cd     = e.trd_cd 
                                     AND d.rlane_cd   = e.rlane_cd 
                                     AND d.dir_cd     = e.dir_cd 
                                     AND d.vop_cd     = e.vop_cd 
                                     AND d.vsl_capa   = e.vsl_capa 
                                     AND d.trd_cd     = bsa_target_vvd.trd_cd
                                     AND d.rlane_cd   = bsa_target_vvd.rlane_cd
                                     AND d.dir_cd     = bsa_target_vvd.dir_cd
                                     AND d.vop_cd     = bsa_target_vvd.vop_cd
                                     AND d.vsl_capa   = bsa_target_vvd.vsl_capa
                                     AND e.bsa_op_jb_cd = z.bsa_op_jb_cd
                                     AND e.crr_cd       = z.crr_cd
                                     AND bsa_target_vvd.bsa_op_cd ='J'
                                     AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') 
                                                                             AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
                                   UNION ALL
                                  SELECT /*+ ordered */e.crr_bsa_capa    
                                     FROM bsa_slt_chtr_bzc d,bsa_slt_chtr_crr_capa e
                                    WHERE d.bsa_seq         = e.bsa_seq
                                      AND d.trd_cd          = e.trd_cd 
                                      AND d.rlane_cd        = e.rlane_cd 
                                      AND d.dir_cd          = e.dir_cd                 
                                      AND d.vsl_seq         = e.vsl_seq
                                      AND d.trd_cd          = bscb_trd_cd    -- bsa_target_vvd.trd_cd
                                      AND d.rlane_cd        = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
                                      AND d.dir_cd          = bscb_dir_cd    -- bsa_target_vvd.dir_cd
                                      AND d.vsl_seq         = bscb_vsl_seq
                                      AND d.bsa_seq         = bscb_bsa_seq
                                      AND bsa_target_vvd.bsa_op_cd ='S'
                                      AND e.bsa_op_jb_cd = z.bsa_op_jb_cd
                                      AND e.crr_cd       = z.crr_cd            
--                                    AND nvl(d.vsl_cd,'X') = DECODE(D.VSL_CD,NULL,'X',bsa_target_vvd.vsl_cd)           
--                                    AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') 
--                                                                            AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
                                    )
      where z.trd_cd     = bsa_target_vvd.trd_cd
        AND z.rlane_cd   = bsa_target_vvd.rlane_cd
        AND z.vsl_cd     = bsa_target_vvd.vsl_cd
        AND z.skd_voy_no = bsa_target_vvd.skd_voy_no
        AND z.skd_dir_cd = bsa_target_vvd.dir_cd
        AND z.PORT_SEQ   = 999    
        AND z.port_cd    = 'XXXXX'  
        and z.bsa_op_jb_cd IN ('007','015','016')      
     ;   
     enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');    
--     DBMS_OUTPUT.PUT_LINE('7 : [' || to_char(SQL%rowcount)||']');
                 
    /* Other Carrier TEU 정보 Insert */
    v_step_no := '9';
    v_status_msg := '9) Other Carrier TEU 정보 Insert[coa_bsa_vvd_otr_crr]'; 
     update bsa_vvd_otr_crr z
        set (z.crr_bsa_capa, z.spc_ctrl_slt_capa) = (                   
          SELECT e.spc_ctrl_slt_capa, decode(e.bsa_op_jb_cd,'007',e.spc_ctrl_slt_capa) spc_capa                         
            FROM bsa_jnt_op_bzc d,bsa_jnt_op_crr_capa e
           WHERE d.bsa_seq      = e.bsa_seq
             AND d.trd_cd       = e.trd_cd 
             AND d.rlane_cd     = e.rlane_cd 
             AND d.dir_cd       = e.dir_cd 
             AND d.vop_cd       = e.vop_cd 
             AND d.vsl_capa     = e.vsl_capa 
             AND d.trd_cd       = bsa_target_vvd.trd_cd
             AND d.rlane_cd     = bsa_target_vvd.rlane_cd
             AND d.dir_cd       = bsa_target_vvd.dir_cd
             AND d.vop_cd       = bsa_target_vvd.vop_cd
             AND d.vsl_capa     = bsa_target_vvd.vsl_capa
             and e.bsa_op_jb_cd = z.bsa_op_jb_cd
             --and z.bsa_op_jb_cd = bsa_target_vvd.bsa_op_cd
             and e.crr_cd       = z.crr_cd
             and bsa_target_vvd.bsa_op_cd ='J'            
             AND e.bsa_op_jb_cd in ('007','008','009','010','011','012','013','014','022')
             AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') 
                                                     AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
           UNION ALL
          SELECT e.crr_bsa_capa,decode(e.bsa_op_jb_cd,'007',e.crr_bsa_capa)
             FROM bsa_slt_chtr_bzc d,bsa_slt_chtr_crr_capa e
            WHERE d.bsa_seq      = e.bsa_seq
              AND d.trd_cd          = e.trd_cd 
              AND d.rlane_cd        = e.rlane_cd 
              AND d.dir_cd          = e.dir_cd                 
              AND d.vsl_seq         = e.vsl_seq
              AND d.trd_cd          = bscb_trd_cd    -- bsa_target_vvd.trd_cd
              AND d.rlane_cd        = bscb_rlane_cd  -- bsa_target_vvd.rlane_cd
              AND d.dir_cd          = bscb_dir_cd    -- bsa_target_vvd.dir_cd
              AND d.vsl_seq         = bscb_vsl_seq
              AND d.bsa_seq         = bscb_bsa_seq
              and e.bsa_op_jb_cd    = z.bsa_op_jb_cd
              --and z.bsa_op_jb_cd    = bsa_target_vvd.bsa_op_cd
              and e.crr_cd          = z.crr_cd              
              and bsa_target_vvd.bsa_op_cd ='S'
--            AND nvl(d.vsl_cd,'X') = DECODE(D.VSL_CD,NULL,'X',bsa_target_vvd.vsl_cd)          
              AND e.bsa_op_jb_cd in ('007','008','009','010','011','012','013','014','022')  
--            AND bsa_target_vvd.n1st_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'yyyymmdd') 
--                                                    AND TO_DATE(d.bsa_to_dt,'yyyymmdd')+0.99999
            )
      where trd_cd     = bsa_target_vvd.trd_cd
        AND rlane_cd   = bsa_target_vvd.rlane_cd
        AND vsl_cd     = bsa_target_vvd.vsl_cd
        AND skd_voy_no = bsa_target_vvd.skd_voy_no
        AND skd_dir_cd = bsa_target_vvd.dir_cd      
      ; 
      enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--      DBMS_OUTPUT.PUT_LINE('8 : [' || to_char(SQL%rowcount)||']');                                 
    
    /* 기존에 swap된 것들 반영해준다 */
    /* 선사별 반영 */
    v_step_no := '10';
    v_status_msg := '10) Swap정보를 산사별로 반영[coa_bsa_vvd_otr_crr]'; 
    -- 2008.01.21 최적화운영팀(CDO) 김지숙대리
    -- Free Addition 및 swap을 BSA가 아닌 다른 Type size에서 처리하도록 변경하였으므로 아래와 같이
    -- 008, 009를 제외한 다른 타입에도 spc_ctrl_slt_capa를 구해준다.
    UPDATE bsa_vvd_otr_crr a
       SET a.spc_ctrl_slt_capa = 
--    SELECT a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, 
--           a.bsa_op_jb_cd, a.crr_cd, a.crr_bsa_capa, a.spc_ctrl_slt_capa,
           NVL(a.crr_bsa_capa,0) + 
           NVL((
               SELECT 
                      DECODE(a.crr_cd, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC, NVL(b.pur_teu_capa,0)-NVL(b.sls_teu_capa,0)+NVL(b.free_add_teu_capa,0), 
                                              NVL(b.sls_teu_capa,0)-NVL(b.pur_teu_capa,0)+NVL(b.slt_swap_teu_capa,0)) cacl
                 FROM  bsa_vvd_swap_info b
                WHERE a.trd_cd       = b.trd_cd
                  AND a.rlane_cd     = b.rlane_cd
                  AND a.vsl_cd       = b.vsl_cd
                  AND a.skd_voy_no   = b.skd_voy_no
                  AND a.skd_dir_cd   = b.skd_dir_cd
                  AND a.bsa_op_jb_cd = b.bsa_op_jb_cd
                  AND a.crr_cd       = b.crr_cd
               ),0) 
--      FROM coa_bsa_vvd_otr_crr a
     WHERE 1=1
       AND a.trd_cd       = bsa_target_vvd.trd_cd
       AND a.rlane_cd     = bsa_target_vvd.rlane_cd
       AND a.vsl_cd       = bsa_target_vvd.vsl_cd
       AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
       AND a.skd_dir_cd   = bsa_target_vvd.dir_cd
       AND a.crr_cd      <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC   
       AND a.bsa_op_jb_cd not in ('008','009')
--       and (a.crr_bsa_capa is not null and (a.crr_bsa_capa > 0 or a.spc_ctrl_slt_capa>0))
    ;    
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   
--    DBMS_OUTPUT.PUT_LINE('9 : [' || to_char(SQL%rowcount)||']');
    
    /* Company 선사에 FREE ADDITION 반영 */
    v_step_no := '11';
    v_status_msg := '11) Company 선사에 FREE ADDITION 반영[coa_bsa_vvd_otr_crr]'; 
    UPDATE bsa_vvd_otr_crr a
       SET a.spc_ctrl_slt_capa = 
--    SELECT a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.bsa_op_jb_cd, a.crr_cd, a.crr_bsa_capa, a.spc_ctrl_slt_capa, 
           NVL(a.crr_bsa_capa,0) +
           NVL((
           SELECT 
                  b.pur_teu_capa-b.sls_teu_capa+b.free_add_teu_capa cacl
             FROM  
                  (
                   SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC crr_cd,
                          SUM(NVL(pur_teu_capa,0)) pur_teu_capa, 
                          SUM(NVL(sls_teu_capa,0)) sls_teu_capa, 
                          SUM(NVL(free_add_teu_capa,0)) free_add_teu_capa
                     FROM bsa_vvd_swap_info 
                    WHERE trd_cd       = bsa_target_vvd.trd_cd
                      AND rlane_cd     = bsa_target_vvd.rlane_cd
                      AND vsl_cd       = bsa_target_vvd.vsl_cd
                      AND skd_voy_no   = bsa_target_vvd.skd_voy_no
                      AND skd_dir_cd   = bsa_target_vvd.dir_cd
                    GROUP BY trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, bsa_op_jb_cd
                  ) b     
            WHERE a.trd_cd       = b.trd_cd
              AND a.rlane_cd     = b.rlane_cd
              AND a.vsl_cd       = b.vsl_cd
              AND a.skd_voy_no   = b.skd_voy_no
              AND a.skd_dir_cd   = b.skd_dir_cd
              AND a.bsa_op_jb_cd = b.bsa_op_jb_cd
              AND a.crr_cd       = b.crr_cd
              AND a.bsa_op_jb_cd not in ('008','009')
           ),0) 
--      FROM coa_bsa_vvd_otr_crr a
     WHERE 1=1   
       AND a.trd_cd       = bsa_target_vvd.trd_cd
       AND a.rlane_cd     = bsa_target_vvd.rlane_cd
       AND a.vsl_cd       = bsa_target_vvd.vsl_cd
       AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
       AND a.skd_dir_cd   = bsa_target_vvd.dir_cd  
       AND a.crr_cd       = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC 
       AND a.bsa_op_jb_cd not in ('008','009')
     ;   
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset'); 
--    DBMS_OUTPUT.PUT_LINE('11 : [' || to_char(SQL%rowcount)||']');
  
  
    /* BSA VVD MST 2ND FINAL 반영 */
    v_step_no := '12';
    v_status_msg := '12) BSA VVD MST 2ND FINAL 반영[coa_bsa_vvd_mst]'; 
    UPDATE bsa_vvd_mst
       SET n2nd_fnl_co_bsa_capa = (SELECT spc_ctrl_slt_capa
                                      FROM bsa_vvd_otr_crr
                                     WHERE trd_cd       = bsa_target_vvd.trd_cd
                                       AND rlane_cd     = bsa_target_vvd.rlane_cd
                                       AND vsl_cd       = bsa_target_vvd.vsl_cd
                                       AND skd_voy_no   = bsa_target_vvd.skd_voy_no
                                       AND skd_dir_cd   = bsa_target_vvd.dir_cd
                                       AND crr_cd       = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC
                                       AND bsa_op_jb_cd = '007'
                                     )
     WHERE trd_cd       = bsa_target_vvd.trd_cd
       AND rlane_cd     = bsa_target_vvd.rlane_cd
       AND vsl_cd       = bsa_target_vvd.vsl_cd
       AND skd_voy_no   = bsa_target_vvd.skd_voy_no
       AND skd_dir_cd   = bsa_target_vvd.dir_cd
    ; 
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');
--    DBMS_OUTPUT.PUT_LINE('11 : [' || to_char(SQL%rowcount)||']');    
    
    v_step_no := '13';
    v_status_msg := '13) JO Other 선사 정보를 Carrier별 Table에 Update[coa_bsa_vvd_crr_perf]';
    IF bsa_target_vvd.vop_cd = 'OTH' AND bsa_target_vvd.bsa_op_cd = 'J' THEN
        /* 
           JO는 000 정보가 해당 VESSEL의 선사만 존재, SC는 000정보가 선사별로 존재 함 따라서 
           SC에서 JO로 변경되었을때를 대비하여 000의 필요없는 선사정보를 삭제한다.
        */
        DELETE 
          FROM bsa_vvd_crr_perf a
         WHERE a.trd_cd       = bsa_target_vvd.trd_cd
           AND a.rlane_cd     = bsa_target_vvd.rlane_cd
           AND a.vsl_cd       = bsa_target_vvd.vsl_cd
           AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
           AND a.skd_dir_cd   = bsa_target_vvd.dir_cd                         
           AND a.bsa_op_jb_cd = '000'
           AND a.crr_cd NOT IN (
                                    SELECT DISTINCT b.crr_cd
                                      FROM bsa_vvd_mst b
                                     WHERE a.trd_cd     = b.trd_cd
                                       AND a.rlane_cd   = b.rlane_cd
                                       AND a.vsl_cd     = b.vsl_cd
                                       AND a.skd_voy_no = b.skd_voy_no
                                       AND a.skd_dir_cd = b.skd_dir_cd
                                    )
        ;
          
        UPDATE bsa_vvd_crr_perf a
           SET (a.crr_cd,a.crr_bsa_capa) = (SELECT b.crr_cd, b.co_bsa_bfr_sub_capa
                                              FROM bsa_vvd_mst b
                                             WHERE a.trd_cd     = b.trd_cd
                                               AND a.rlane_cd   = b.rlane_cd
                                               AND a.vsl_cd     = b.vsl_cd
                                               AND a.skd_voy_no = b.skd_voy_no
                                               AND a.skd_dir_cd = b.skd_dir_cd
                                           )
         WHERE a.trd_cd       = bsa_target_vvd.trd_cd
           AND a.rlane_cd     = bsa_target_vvd.rlane_cd
           AND a.vsl_cd       = bsa_target_vvd.vsl_cd
           AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
           AND a.skd_dir_cd   = bsa_target_vvd.dir_cd                         
           AND a.bsa_op_jb_cd = '000'
        ;
     END IF;
     enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');
--    DBMS_OUTPUT.PUT_LINE('12 : [' || to_char(SQL%rowcount)||']');     
  
    /* Carrier별 선복 임대차 비용 계산 Update */
    v_step_no := '14';
    v_status_msg := '14) Carrier별 선복 임대차 비용 계산 Update[coa_bsa_vvd_crr_perf]';
    UPDATE bsa_vvd_crr_perf a
       SET crr_perf_amt = NVL((
                           SELECT decode(a.bsa_op_jb_cd,'001',c.slt_prc_capa*a.crr_bsa_capa,
                                                        '002',c.slt_prc_capa*a.crr_bsa_capa,
                                                        '003',b.sub_chtr_bsa_capa*a.crr_bsa_capa,
                                                        '004',c.slt_prc_capa*a.crr_bsa_capa,
                                                        '005',b.crs_chtr_bsa_capa*a.crr_bsa_capa,
                                                        '000',b.co_bfr_sub_capa * a.crr_bsa_capa) crr_perf 
                             from bsa_vvd_crr_perf d,(
                                   SELECT co_bfr_sub_capa,  /* Company before sub */
                                          sub_chtr_bsa_capa, /* 003 */
                                          crs_chtr_bsa_capa  /* 005 */
                                     FROM bsa_slt_prc a
                                    WHERE a.trd_cd   = bsa_target_vvd.trd_cd
                                      AND a.rlane_cd = bsa_target_vvd.rlane_cd
                                      AND a.dir_cd   = bsa_target_vvd.dir_cd
                                      AND bsa_target_vvd.n1st_port_etd_dt >=TO_DATE(bsa_slt_prc_fm_dt,'YYYYMMDD')
                                      AND bsa_target_vvd.n1st_port_etd_dt <=TO_DATE(bsa_slt_prc_to_dt,'YYYYMMDD')+0.99999
                                      AND a.bsa_slt_cost_tp_cd = '017') b,
                                  (/* 수입 */
                                   SELECT bsa_op_jb_cd,crr_cd,slt_prc_capa
                                     FROM bsa_slt_prc_crr a
                                    WHERE a.trd_cd   = bsa_target_vvd.trd_cd
                                      AND a.rlane_cd = bsa_target_vvd.rlane_cd
                                      AND a.dir_cd   = bsa_target_vvd.dir_cd
                                      AND bsa_target_vvd.n1st_port_etd_dt >=TO_DATE(bsa_slt_prc_fm_dt,'YYYYMMDD')
                                      AND bsa_target_vvd.n1st_port_etd_dt <=TO_DATE(bsa_slt_prc_to_dt,'YYYYMMDD')+0.99999
                                      AND a.bsa_slt_cost_tp_cd = '017'
                                ) c 
                          WHERE d.bsa_op_jb_cd  = c.bsa_op_jb_cd(+)
                            AND d.crr_cd        = c.crr_cd(+)
                            AND a.trd_cd        = d.trd_cd
                            AND a.vsl_cd        = d.vsl_cd
                            AND a.rlane_cd      = d.rlane_cd
                            AND a.skd_voy_no    = d.skd_voy_no
                            AND a.skd_dir_cd    = d.skd_dir_cd
                            AND a.bsa_op_jb_cd  = d.bsa_op_jb_cd
                            AND a.crr_cd        = d.crr_cd
                          ),0)
    WHERE a.trd_cd       = bsa_target_vvd.trd_cd
      AND a.rlane_cd     = bsa_target_vvd.rlane_cd
      AND a.vsl_cd       = bsa_target_vvd.vsl_cd
      AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
      AND a.skd_dir_cd   = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');
--    DBMS_OUTPUT.PUT_LINE('13 : [' || to_char(SQL%rowcount)||']');    

    /* Carrier별 선복 임대차 비용 계산 - JOO 요청으로 Slot Price 추가 */
        v_step_no :='15';
        v_status_msg := '15) Carrier별 선복 임대차 비용 - Slot Price Update' ;
         UPDATE bsa_vvd_crr_perf 
           SET slt_prc_capa = NVL(decode(NVL(CRR_BSA_CAPA,0),0,0, (CRR_PERF_AMT / CRR_BSA_CAPA)) ,0)
         WHERE trd_cd      = bsa_target_vvd.trd_cd
          AND rlane_cd     = bsa_target_vvd.rlane_cd
          AND vsl_cd       = bsa_target_vvd.vsl_cd
          AND skd_voy_no   = bsa_target_vvd.skd_voy_no
          AND skd_dir_cd   = bsa_target_vvd.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');   


      
    /* VVD별 선복 임대차 비용 계산 Update */
    v_step_no := '16';
    v_status_msg := '16) VVD별 선복 임대차 비용 계산 Update[coa_bsa_vvd_mst]';
    UPDATE bsa_vvd_mst a
       SET (a.expn_bzc_chtr_amt,a.expn_sub_chtr_amt,a.expn_crs_chtr_amt,
            a.incm_bzc_chtr_amt,a.incm_sub_chtr_amt,a.incm_crs_chtr_amt)
           =
           (
--           c.oth,c.ssi,c.cci,c.ini,c.sso,c.cco
            SELECT --a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'000',b.crr_perf_amt)),0) oth,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'003',b.crr_perf_amt)),0) ssi,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'005',b.crr_perf_amt)),0) cci,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'001',b.crr_perf_amt)),0) ini,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'002',b.crr_perf_amt)),0) sso,
                   NVL(SUM(DECODE(b.bsa_op_jb_cd,'004',b.crr_perf_amt)),0) cco
              FROM bsa_vvd_crr_perf b
             WHERE 1=1
               AND a.trd_cd     = b.trd_cd
               AND a.rlane_cd   = b.rlane_cd
               AND a.vsl_cd     = b.vsl_cd
               AND a.skd_voy_no = b.skd_voy_no
               AND a.skd_dir_cd = b.skd_dir_cd
             --GROUP BY a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd
           )
     WHERE a.trd_cd       = bsa_target_vvd.trd_cd
       AND a.rlane_cd     = bsa_target_vvd.rlane_cd
       AND a.vsl_cd       = bsa_target_vvd.vsl_cd
       AND a.skd_voy_no   = bsa_target_vvd.skd_voy_no
       AND a.skd_dir_cd   = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');
--    DBMS_OUTPUT.PUT_LINE('14 : [' || to_char(SQL%rowcount)||']');    
    
    v_step_no := '17';
    v_status_msg := '17) VVD별 Rato를 재계산 Update[coa_mon_vvd]';
    UPDATE coa_mon_vvd
       SET  (co_bsa_rto,
             chtr_bsa_rto,
             vvd_bsa_capa) = (SELECT co_bsa_rto,chtr_bsa_rto,fnl_co_bsa_capa
                                FROM bsa_vvd_mst
                               WHERE trd_cd       = bsa_target_vvd.trd_cd
                                 AND rlane_cd     = bsa_target_vvd.rlane_cd
                                 AND vsl_cd       = bsa_target_vvd.vsl_cd
                                 AND skd_voy_no   = bsa_target_vvd.skd_voy_no
                                 AND skd_dir_cd   = bsa_target_vvd.dir_cd)
      WHERE trd_cd       = bsa_target_vvd.trd_cd
        AND rlane_cd     = bsa_target_vvd.rlane_cd
        AND vsl_cd       = bsa_target_vvd.vsl_cd
        AND skd_voy_no   = bsa_target_vvd.skd_voy_no
        AND dir_cd       = bsa_target_vvd.dir_cd
    ;
    enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Reset');  
--    DBMS_OUTPUT.PUT_LINE('15 : [' || to_char(SQL%rowcount)||']');
 
    END LOOP;  
    
    DBMS_OUTPUT.PUT_LINE('BSA_RESET_VVD_PRC OK');
    p_error_code := '00000';
    p_error_msg  := 'Completed!';

-------------------------[ 예외처리부            ]----------------------- 
   EXCEPTION
     WHEN OTHERS THEN         
         p_error_code   := SQLCODE;
         p_error_msg    := '[BSA RESETTING PRC Error!!]♀[BSAReset'||v_step_no|| SQLERRM || ']♀[' || v_info || ']♀[' || v_status_msg ||']' ;
         enis_log_prc(SYSDATE, 'BSA_RESET_VVD_PRC',  '[BSA RESETTING PRC Error!!][BSAReset'||v_step_no|| SQLERRM || ']♀[' || v_dtl_msg|| ']♀[' || v_status_msg ||']', 'Exception');  
         DBMS_OUTPUT.PUT_LINE( p_error_msg || ' '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
         
END BSA_RESET_VVD_PRC;