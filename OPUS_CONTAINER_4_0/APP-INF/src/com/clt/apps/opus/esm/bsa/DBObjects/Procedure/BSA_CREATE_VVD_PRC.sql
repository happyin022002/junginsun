CREATE OR REPLACE PROCEDURE OPUSADM.BSA_CREATE_VVD_PRC
    (
    p_year       IN VARCHAR2, -- MANDatory  ex) '2006'
    p_fm_yrmon   IN VARCHAR2, -- MANDatory  ex) '200601'
    p_to_yrmon   IN VARCHAR2, -- MANDatory  ex) '200612'
    p_fm_week    IN VARCHAR2, -- MANDatory  ex) '23'
    p_to_week    IN VARCHAR2, -- MANDatory  ex) '52'
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
  Name         :   BSA_CREATE_VVD_PRC
  Purpose      :   대상항차 기준의 BSA 생성 로직
  Source       :   coa_mon_vvd,
  Target       :   bsa_vvd_mst,bsa_vvd_otr_crr,bsa_vvd_perf,
                   bsa_vvd_port_dwn,bsa_vvd_swap_info
  Ver          :   1.0                       
  Date         :   2006.10.20  
  System       :   Sales Managemenet > Basic Slot Allotment
  Author       :   CyberLogitec
******************************************************************************/
/* 
  1.Name       : 
  2.Create Date: 2006-12-26
  3.Description: 
      - 용도: 1. 해당 조회조건의 대항항차 선정
              2. 기존 BSA MST Table 에 있는지 Check후
              2-1. 있으면 : 다시 재계산해서 UPDATE
              2-2. 없으면 : 재계산 로직 그대로 하여 Insert(초기값이 들어가게 됨)
      - 파라미터: 년,주차,trade,revenue lane,ioc,vsl
      - 특이사항 
        (1) Trunk IPC 로직 미확정
  4.Revision History :
*/ 

------------------------------- [ 커서 선언부    ] --------------------------------------
    /* Procedure의  Parameter기준의 대상항차 List 선정) */
    CURSOR target_vvd_cur(v_year       VARCHAR2,
                          v_fm_yrmon   VARCHAR2,
                          v_to_yrmon   VARCHAR2,
                          v_fm_week    VARCHAR2,
                          v_to_week    VARCHAR2,
                          v_trd_cd     VARCHAR2,
                          v_rlane_cd   VARCHAR2,
                          v_ioc_cd     VARCHAR2,
                          v_vsl_cd     VARCHAR2,
                          v_skd_voy_no VARCHAR2,
                          v_dir_cd     VARCHAR2 ) IS 
    SELECT a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd, a.ioc_cd,
           a.lst_lodg_port_cd, a.lst_lodg_port_etd_dt, a.n1st_lodg_port_etd_dt,
           a.ioc_rule_desc, a.sub_trd_cd, a.slan_cd, 
           DECODE(NVL(b.sub_trd_capa,0),0,NVL(e.stnd_ldb_capa,0),NVL(b.sub_trd_capa,0)) vsl_capa,
           e.vop_cd, c.vsl_lane_tp_cd,
           DECODE(e.vop_cd, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC,e.vop_cd,e.crr_cd) crr_cd,NVL(c.stup_flg,'N') stup_flg
     FROM  coa_mon_vvd a,
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
            WHERE a.delt_flg     <> 'Y'
              AND a.trd_cd        = NVL(v_trd_cd  , a.trd_cd)
              AND a.rlane_cd      = NVL(v_rlane_cd, a.rlane_cd)
              AND a.dir_cd        = NVL(v_dir_cd  , a.dir_cd)
           ) c,     
           (
           SELECT  vsl_cd,    vop_cd ,  stnd_ldb_capa , 
                  NVL(TO_CHAR(vsl_aply_fm_dt,'yyyymmdd'), '19000101')  vsl_aply_fm_dt,
                  NVL(TO_CHAR(vsl_aply_to_dt,'yyyymmdd') , '99991231') vsl_aply_to_dt,
                  vsl_clss_capa,  trd_chk_flg,  delt_flg, crr_cd
             FROM coa_vsl_rgst   
           ) e
    WHERE a.vsl_cd             = b.vsl_cd(+)
       AND a.vsl_cd             = e.vsl_cd(+)
       AND a.sub_trd_cd         = b.sub_trd_cd(+)
       AND a.trd_cd             = c.trd_cd
       AND a.rlane_cd           = c.rlane_cd
       AND a.dir_cd             = c.dir_cd
       AND NVL(a.delt_flg,'N') <> 'Y'
       AND NVL(e.delt_flg,'N') <> 'Y'
       AND c.vsl_lane_tp_cd     IN ('JO','SC')
       AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(c.lane_aply_fom_dt,'19000101') AND NVL(c.lane_aply_to_dt, '99991231')
       AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(b.vsl_aply_fom_dt ,'19000101') AND NVL(b.vsl_aply_to_dt , '99991231')
       AND TO_CHAR(a.n1st_lodg_port_etd_dt,'yyyymmdd') BETWEEN NVL(e.vsl_aply_fm_dt ,'19000101') AND NVL(e.vsl_aply_to_dt , '99991231')
       AND a.sls_yrmon         LIKE SUBSTR(v_year,1,4)||'%'
       AND a.cost_yrmon         BETWEEN NVL(v_fm_yrmon,a.cost_yrmon) AND NVL(v_to_yrmon,a.cost_yrmon)
       AND a.cost_wk            BETWEEN NVL(v_fm_week,a.cost_wk)     AND NVL(v_to_week,a.cost_wk)
       AND a.trd_cd             = NVL(v_trd_cd,a.trd_cd)
       AND a.rlane_cd           = NVL(v_rlane_cd,a.rlane_cd)
       AND a.ioc_cd             = NVL(v_ioc_cd,a.ioc_cd)
       AND a.vsl_cd             = NVL(v_vsl_cd,a.vsl_cd)
       AND a.skd_voy_no         = NVL(v_skd_voy_no,a.skd_voy_no)
       AND a.dir_cd             = NVL(v_dir_cd,a.dir_cd)                                   
    ;                                     

------------------------------- [ 변수 선언부    ] --------------------------------------
v_commit_unit      PLS_INTEGER    := 10000                    ;
v_read_count       number(10)     := 0                        ;

/** 작업로그 관련 변수선언 **/  
v_mig_pgm_nm       varchar2(100)  := 'BSA_CREATE_VVD_PRC' ; 
v_mig_sub_sys_cd   varchar2(3)    := 'COA'                    ;
v_mig_pic_nm       varchar2(20)   := 'COA'                    ;
v_tgt_tbl_nm       varchar2(100)  := 'COA_MON_VVD'            ; 
v_src_tbl_nm       varchar2(100)  := 'VSK_VSL_PORT_SKD'       ;
v_mig_st_dt        date                                       ;
v_mig_knt          number(18)                                 ;
v_mig_err_msg      varchar2(1000)                             ;
v_status_msg       varchar2(1000)                             ;
v_err_dtl_msg      varchar2(1000)                             ;
v_dtl_msg          varchar2(1000)                             ;
tnk_update_flg     varchar2(1)    :='N'                       ;
exist_chk          varchar2(1)    :='N'                       ;
v_bsa_capa         number(18,3)   :=0;
v_fnl_co_bsa_capa number(18,3)   :=0;
v_co_bsa_bfr_sub_capa number(18,3);

v_info             varchar2(3000)                                ;
v_step_no          varchar2(2);  

/** 오류 변수 선언 **/
vvd_cre_error      EXCEPTION                                  ;
not_null_ins       EXCEPTION;    -- STEP 1
not_first_etd      EXCEPTION;

/** BSA_SLT_CHTR_BZC 테이블의 PK [CHM-201005480-01] **/
bscb_trd_cd        varchar2(3);
bscb_rlane_cd      varchar2(5);
bscb_dir_cd        varchar2(1);
bscb_vsl_seq       number(3);
bscb_bsa_seq       number(3);



/* not_null_test는 선언된 예외 이름 
 -1400 Error 처리번호는 표준 Oracle7 Server Error 번호 */
PRAGMA EXCEPTION_INIT(not_null_ins, -1400);       -- STEP 2
PRAGMA EXCEPTION_INIT(not_first_etd, -1410);
    
------------------------------- [ 업무로직 구현부] --------------------------------------
BEGIN
    DBMS_OUTPUT.ENABLE('10000000000');
  
    /** 시작일시 설정 **/
    v_mig_st_dt := SYSDATE ;
--    DBMS_OUTPUT.PUT_LINE('['||v_mig_pgm_nm||']  : VVD별 BSA 생성 '||TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS'));   
    enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', '---------------------------------------' , 'VVD Creation');
    
    FOR param  IN target_vvd_cur(   p_year, p_fm_yrmon, p_to_yrmon, p_fm_week, p_to_week,
                                    p_trd_cd, p_rlane_cd, p_ioc_cd,
                                    p_vsl_cd, p_skd_voy_no, p_dir_cd) LOOP                                         

        v_dtl_msg := '[' || to_char(target_vvd_cur%rowcount) || '][' || param.trd_cd     || '][' || param.rlane_cd         || '][' || param.vsl_cd               || '][' || param.skd_voy_no            || '][' 
                         || param.dir_cd                     || '][' || param.ioc_cd     || '][' || param.lst_lodg_port_cd || '][' || to_char(param.lst_lodg_port_etd_dt,'yyyymmdd') || '][' || to_char(param.n1st_lodg_port_etd_dt,'yyyymmdd') || '][' 
                         || param.ioc_rule_desc              || '][' || param.sub_trd_cd || '][' || param.slan_cd          || '][' || param.vsl_capa             || '][' || param.vop_cd                || '][' 
                         || param.vsl_lane_tp_cd             || '][' || param.stup_flg   || '][' 
                         || p_user_id || '][' || p_year || '][' || p_fm_yrmon || '][' || p_to_yrmon || '][' || p_fm_week || '][' || p_to_week || ']' ;
        v_info    := param.trd_cd||':'||param.rlane_cd  ||':'|| param.vsl_cd    || param.skd_voy_no|| param.dir_cd||':'||
                     param.ioc_cd||':'|| param.vop_cd   ||':'|| param.vsl_lane_tp_cd ||':'|| param.vsl_capa ||':'||param.vop_cd||':'||to_char(param.n1st_lodg_port_etd_dt,'yyyymmdd')  || ':' ||
                     p_year      ||'.'|| p_fm_week      ||'~'|| p_to_week ;

--        DBMS_OUTPUT.PUT_LINE('Info >> ' || v_dtl_msg);
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', 'Info : ' || v_dtl_msg , 'VVD Creation');    
        
        
        /* -----------------------------------------------------------------------------------------------------------
           First ETD DATE 가 올해가 아닐 경우 에러로 처리한다[2007.07.07]
           First ETD DATE 의 년도가 올해와 같지 않으면 올해1-3달 한것 보다 작으면 에러로 처리한다.[2007.07.24]
           ----------------------------------------------------------------------------------------------------------- */
        v_status_msg  := 'First ETD DATE CHECK!';
--        IF TO_CHAR(param.n1st_lodg_port_etd_dt,'YYYY') < TO_CHAR(SYSDATE, 'YYYY')  THEN
--            IF TO_CHAR(param.n1st_lodg_port_etd_dt,'YYYYMMDD') < TO_CHAR(ADD_MONTHS(TO_DATE(TO_CHAR(SYSDATE, 'YYYY')||'0101'),-5), 'YYYYMMDD') THEN
--    --          DBMS_OUTPUT.PUT_LINE('    ' || v_status_msg || ' >> ' || v_err_dtl_msg);
--                RAISE not_first_etd;
--            END IF;
--        END IF;
        
        /* 1. 해당 정보가 COA BSA MST Table에 있는지 Check 
           2. 있으면 계산 수식에 의해서 UPDATE
           3. 없으면 계산 수식에 의해서 INSERT
        */
    --    DBMS_OUTPUT.PUT_LINE('    COA BSA MASTER TABlE CHEDCK!' || ' >> ' || v_err_dtl_msg);
        BEGIN               
            SELECT 'Y'
            INTO exist_chk
            FROM dual
            WHERE NOT EXISTS (
                              SELECT 1
                                FROM bsa_vvd_mst
                               WHERE trd_cd     = param.trd_cd
                                 AND rlane_cd   = param.rlane_cd
                                 AND vsl_cd     = param.vsl_cd
                                 AND skd_voy_no = param.skd_voy_no
                                 AND skd_dir_cd = param.dir_cd
--                                 AND bsa_op_cd  = SUBSTR(param.vsl_lane_tp_cd,1,1)
                            )
            ;   
            EXCEPTION 
                WHEN NO_DATA_FOUND THEN
                    BEGIN
                        v_step_no :='0';
                        exist_chk :='N';
                    END; 
        END;
                                           
        IF exist_chk = 'Y' THEN /* 없으므로 Insert */
            /* Master Table Insert */
            v_step_no :='1';
            v_status_msg := '1) Master Table Insert[BSA_VVD_MST]';
            INSERT INTO bsa_vvd_mst
            (
             trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, 
             bsa_op_cd, ioc_cd, vop_cd, vsl_capa, bsa_capa, 
             fnl_co_bsa_capa, n2nd_fnl_co_bsa_capa, co_bsa_capa, 
             co_bsa_rto, chtr_bsa_rto, co_bsa_bfr_sub_capa, 
             rev_port_cd, rev_port_etd_dt, n1st_port_etd_dt, ioc_rule_desc, 
             expn_bzc_chtr_amt, expn_sub_chtr_amt, expn_crs_chtr_amt, 
             incm_bzc_chtr_amt, incm_sub_chtr_amt, incm_crs_chtr_amt, 
             free_add_teu_capa, free_add_wgt, spc_otr_swap_flg, crr_cd,
             cre_usr_id, cre_dt, upd_usr_id, upd_dt
            )
            VALUES
            (
             param.trd_cd, param.rlane_cd, param.vsl_cd, param.skd_voy_no, param.dir_cd,
             SUBSTR(param.vsl_lane_tp_cd,1,1), param.ioc_cd,
             decode(param.vsl_lane_tp_cd,'JO',param.vop_cd,'SC','OTH'),
             param.vsl_capa, 0,
             0, 0, 0, 0, 0, 0,
             param.lst_lodg_port_cd, param.lst_lodg_port_etd_dt, param.n1st_lodg_port_etd_dt, param.ioc_rule_desc, 
             0, 0, 0,
             0, 0, 0,
             0, 0, 'N',param.crr_cd,
             p_user_id, SYSDATE, p_user_id, SYSDATE    
            ); 
            enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation');   
            --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ');
        ELSE
            -- Vessel 정보가 변경되는 경우 이를 적용시켜 주기 위해서 정보변경
            v_step_no :='1';
            v_status_msg := '1) Master Table Update';
            UPDATE bsa_vvd_mst
               SET (bsa_op_cd, crr_cd, vsl_capa, bsa_capa, vop_cd) =
                   (
                   SELECT SUBSTR(param.vsl_lane_tp_cd,1,1), param.crr_cd, param.vsl_capa, param.vsl_capa,
                          decode(param.vsl_lane_tp_cd,'JO',param.vop_cd,'SC','OTH')
                     FROM DUAL
                   )
             WHERE trd_cd     = param.trd_cd
               AND rlane_cd   = param.rlane_cd
               AND vsl_cd     = param.vsl_cd
               AND skd_voy_no = param.skd_voy_no
               AND skd_dir_cd = param.dir_cd
            ;                   
        END IF;  
                         
        /** BSA_SLT_CHTR_BZC 테이블의 PK 구하기 [CHM-201005480-01] **/
        BEGIN
            SELECT  X.TRD_CD, X.RLANE_CD, X.DIR_CD, X.VSL_SEQ, X.BSA_SEQ
            INTO    bscb_trd_cd, bscb_rlane_cd, bscb_dir_cd, bscb_vsl_seq, bscb_bsa_seq
            FROM
                (    SELECT  TRD_CD, RLANE_CD, DIR_CD, VSL_SEQ, BSA_SEQ, VSL_CD, MAX ( VSL_CD ) OVER () VSL_CD2
                     FROM    BSA_SLT_CHTR_BZC
                     WHERE   TRD_CD                 = param.trd_cd
                     AND     RLANE_CD               = param.rlane_cd
                     AND     DIR_CD                 = param.dir_cd
                     AND     param.vsl_lane_tp_cd   ='SC'
                     AND     NVL(VSL_CD,'X')        = DECODE(VSL_CD,NULL,'X', param.vsl_cd)
                     AND     param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(BSA_FM_DT,'yyyymmdd') AND TO_DATE(BSA_TO_DT,'yyyymmdd')+0.99999 
                ) X
            WHERE   NVL(X.VSL_CD2, 'X' ) = decode ( X.VSL_CD, NULL, 'X', param.vsl_cd ); 
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

        /* Carrier별 실적 Table 물량 Insert */ 
        v_step_no :='2'; 
        v_status_msg := '2) Carrier별 실적 Table 물량 Insert[BSA_VVD_CRR_PERF]';
        INSERT INTO bsa_vvd_crr_perf 
        (
         trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, 
         bsa_op_jb_cd, crr_cd, crr_bsa_capa, crr_perf_amt, 
         cre_usr_id, cre_dt, upd_usr_id, upd_dt
        )
        SELECT  x.trd_cd, x.rlane_cd, x.vsl_cd, x.skd_voy_no, x.dir_cd, 
                decode(param.vsl_lane_tp_cd||x.bsa_op_jb_cd,'SC001','000',x.bsa_op_jb_cd),
                x.crr_cd, x.crr_bsa_capa, x.crr_perf_amt,
                p_user_id, SYSDATE, p_user_id, SYSDATE
        FROM (
              SELECT  param.trd_cd     AS trd_cd,
                      param.rlane_cd   AS rlane_cd,
                      param.vsl_cd     AS vsl_cd,
                      param.skd_voy_no AS skd_voy_no,
                      param.dir_cd     AS dir_cd,                           
                      e.bsa_op_jb_cd,
                      e.crr_cd,
                      e.crr_bsa_capa,
                      0                AS crr_perf_amt                          
              FROM bsa_jnt_op_bzc d,
                   bsa_jnt_op_crr_capa e
              WHERE d.BSA_SEQ                   = e.BSA_SEQ
                AND d.trd_cd                    = e.trd_cd 
                AND d.rlane_cd                  = e.rlane_cd 
                AND d.dir_cd                    = e.dir_cd 
                AND d.vop_cd                    = e.vop_cd 
                AND d.vsl_capa                  = e.vsl_capa 
                AND d.trd_cd                    = param.trd_cd
                AND d.rlane_cd                  = param.rlane_cd
                AND d.dir_cd                    = param.dir_cd
                AND d.vop_cd                    = param.vop_cd
                AND d.vsl_capa                  = param.vsl_capa     
                AND param.vsl_lane_tp_cd        ='JO'
                AND ((e.vop_cd = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND e.bsa_op_jb_cd = '001') OR e.bsa_op_jb_cd IN ('002','003','004','005'))
                AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
              UNION ALL
              SELECT  param.trd_cd,
                      param.rlane_cd,
                      param.vsl_cd,
                      param.skd_voy_no,
                      param.dir_cd,
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
                AND d.trd_cd                    = bscb_trd_cd    -- param.trd_cd
                AND d.rlane_cd                  = bscb_rlane_cd  -- param.rlane_cd
                AND d.dir_cd                    = bscb_dir_cd    -- param.dir_cd
                AND d.vsl_seq                   = bscb_vsl_seq
                AND d.bsa_seq                   = bscb_bsa_seq
                AND param.vsl_lane_tp_cd        ='SC'
--              AND NVL(d.vsl_cd,'X')           = DECODE(d.vsl_cd,NULL,'X',param.vsl_cd)          
                AND e.bsa_op_jb_cd              IN ('001','002','003','004','005')   
--              AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
             ) x
        WHERE NOT EXISTS(
                         SELECT 1
                         FROM bsa_vvd_crr_perf y
                         WHERE y.trd_cd       = param.trd_cd
                           AND y.rlane_cd     = param.rlane_cd
                           AND y.vsl_cd       = param.vsl_cd
                           AND y.skd_voy_no   = param.skd_voy_no
                           AND y.skd_dir_cd   = param.dir_cd
                           AND y.bsa_op_jb_cd = DECODE(param.vsl_lane_tp_cd||x.bsa_op_jb_cd,'SC001','000',x.bsa_op_jb_cd)
                           AND y.crr_cd       = x.crr_cd
                        )
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation');         
--        DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ');
        
        /* Port Step Up/Down Insert*/
        -- stup_flg 정보는 Lane 테이블에 step up/down에서 선택이 된 Lane의 정보만 
        -- port 단위로 데이터를 내려준다.
--        DBMS_OUTPUT.PUT_LINE('param.stup_flg : '||param.stup_flg);
        IF param.stup_flg = 'Y' THEN 
            v_step_no :='3';
            v_status_msg := '3) Port Step Up/Down 선사의 Port 정보 Insert[삭제된 PORT정보 삭제]';
            -- vessel schedule이 변경되어 삭제된 port가 있을경우 port step up/down의 해당 port정보를 삭제한다.
            DELETE FROM bsa_vvd_port_dwn
             WHERE 1=1
               AND trd_cd   = param.trd_cd
               AND rlane_cd = param.rlane_cd
               AND port_cd  <> 'XXXXX'
               AND (vsl_cd, skd_voy_no, skd_dir_cd, port_cd) in
                   (
                    -- 1 start -------------------------------------------------------------------
                    SELECT DISTINCT vsl_cd, skd_voy_no, skd_dir_cd, port_cd
                      FROM bsa_vvd_port_dwn
                     WHERE 1=1
                       AND trd_cd     = param.trd_cd
                       AND rlane_cd   = param.rlane_cd
                       AND vsl_cd     = param.vsl_cd
                       AND skd_voy_no = param.skd_voy_no
                       AND skd_dir_cd = param.dir_cd
                       AND port_cd    <>'XXXXX'
                    MINUS
                    SELECT DISTINCT vsl_cd, skd_voy_no, skd_dir_cd, vps_port_cd
                      FROM vsk_vsl_port_skd
                     WHERE 1=1
                       AND vsl_cd     = param.vsl_cd
                       AND skd_voy_no = param.skd_voy_no
                       AND skd_dir_cd = param.dir_cd
                       AND NVL(skd_cng_sts_cd,'*') <> 'S'
                   -- 1 start -------------------------------------------------------------------
                   )
            ; 
            enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
            
            v_step_no :='4';
            v_status_msg := '4) Port Step Up/Down 선사의 Port 정보 Insert[PORT의 SEQ 변경]';
            -- port seq를 변경하기 위해 기존가 가지고 있는 값을 변경시킨다.
            UPDATE bsa_vvd_port_dwn x
               SET x.port_seq  =  x.port_seq + 20
             WHERE 
                   x.trd_cd       = param.trd_cd
               AND x.rlane_cd     = param.rlane_cd
               AND x.vsl_cd       = param.vsl_cd
               AND x.skd_voy_no   = param.skd_voy_no
               AND x.skd_dir_cd   = param.dir_cd
               AND x.bsa_op_jb_cd IN ('007','015','016')
               AND x.port_cd     <> 'XXXXX'
            ;
            enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
            
            v_step_no :='5';            
            v_status_msg := '5) Port Step Up/Down 선사의 Port 정보 Insert[BSA_VVD_PORT_DWN]';
            -- vessel schedule이 변경되어 추가된 port가 있을경우 port step up/down 테이블에 추가해 주고
            -- vessel seq를 vessel schedule의 seq로 update한다.
            MERGE INTO bsa_vvd_port_dwn x
            USING (  
                    SELECT b.trd_cd, b.rlane_cd, b.bsa_op_jb_cd, b.crr_cd,
--                           a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.port_cd, a.port_seq,
                           b.vsl_cd, b.skd_voy_no, b.skd_dir_cd, b.vps_port_cd port_cd, b.clpt_seq port_seq, 
                           ROW_NUMBER() OVER(PARTITION BY b.trd_cd, b.rlane_cd, b.bsa_op_jb_cd, b.crr_cd, b.vsl_cd, b.skd_voy_no, b.skd_dir_cd ORDER BY b.clpt_seq) seq,
                           decode(nvl(a.crr_bsa_capa,0),0, nvl(a.port_bsa_capa,0),a.crr_bsa_capa) port_bsa_capa,  p_user_id cre_usr_id
                      FROM
                           (
                            -- Start 2 -------------------------------------------------------------------------------------------
                            SELECT x.trd_cd, x.rlane_cd, x.vsl_cd, x.skd_voy_no, x.skd_dir_cd, 
                                   x.bsa_op_jb_cd, x.crr_cd, x.port_seq, x.port_cd, x.port_bsa_capa, y.crr_bsa_capa
                              FROM bsa_vvd_port_dwn x,
                                   (
                                    -- Start 1 -----------------------------------------------------------------------------------
                                    SELECT distinct a.trd_cd, a.rlane_cd, param.vsl_cd vsl_cd, param.skd_voy_no skd_voy_no, a.dir_cd, 
                                           b.bsa_op_jb_cd, b.crr_cd, b.crr_bsa_capa
                                      FROM bsa_jnt_op_bzc a, 
                                           bsa_jnt_op_crr_capa b
                                     WHERE a.bsa_seq                   = b.bsa_seq
                                       AND a.trd_cd                    = b.trd_cd
                                       AND a.rlane_cd                  = b.rlane_cd
                                       AND a.dir_cd                    = b.dir_cd
                                       AND a.vop_cd                    = b.vop_cd
                                       AND a.vsl_capa                  = b.vsl_capa
                                       AND b.bsa_op_jb_cd              IN ('007','015','016')
                                       AND a.trd_cd                    = param.trd_cd
                                       AND a.rlane_cd                  = param.rlane_cd
                                       AND a.dir_cd                    = param.dir_cd                   
                                       AND a.vop_cd                    = param.vop_cd
                                       AND a.vsl_capa                  = param.vsl_capa
                                       AND param.stup_flg              = 'Y' 
                                       AND param.vsl_lane_tp_cd        = 'JO'
                                       AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(a.bsa_to_dt,'YYYYMMDD')+0.99999  
                                    UNION ALL
                                    SELECT a.trd_cd, a.rlane_cd, param.vsl_cd vsl_cd, param.skd_voy_no skd_voy_no, a.dir_cd, 
                                           b.bsa_op_jb_cd, b.crr_cd, b.crr_bsa_capa
                                      FROM bsa_slt_chtr_bzc a, 
                                           bsa_slt_chtr_crr_capa b
                                     WHERE a.bsa_seq                   = b.bsa_seq
                                       AND a.trd_cd                    = b.trd_cd
                                       AND a.rlane_cd                  = b.rlane_cd
                                       AND a.dir_cd                    = b.dir_cd
                                       AND a.vsl_seq                   = b.vsl_seq
                                       AND b.bsa_op_jb_cd              IN ('007','015','016')
                                       AND a.trd_cd                    = bscb_trd_cd    -- param.trd_cd
                                       AND a.rlane_cd                  = bscb_rlane_cd  -- param.rlane_cd
                                       AND a.dir_cd                    = bscb_dir_cd    -- param.dir_cd
                                       AND a.vsl_seq                   = bscb_vsl_seq
                                       AND a.bsa_seq                   = bscb_bsa_seq
                                       AND param.stup_flg              = 'Y' 
                                       AND param.vsl_lane_tp_cd        = 'SC'
--                                     AND NVL(a.vsl_cd,'X')           = DECODE(a.vsl_cd, NULL, 'X', param.vsl_cd) 
--                                     AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(a.bsa_to_dt,'YYYYMMDD')+0.99999  
                                    -- Start 1 -----------------------------------------------------------------------------------
                                  ) y
                              WHERE 1=1
                                AND x.trd_cd       = y.trd_cd 
                                AND x.rlane_cd     = y.rlane_cd
                                AND x.vsl_cd       = y.vsl_cd
                                AND x.skd_voy_no   = y.skd_voy_no
                                AND x.skd_dir_cd   = y.dir_cd
                                AND x.bsa_op_jb_cd = y.bsa_op_jb_cd
                                AND x.crr_cd       = y.crr_cd
                                AND x.vsl_cd       = param.vsl_cd
                                AND x.skd_voy_no   = param.skd_voy_no
                                AND x.skd_dir_cd   = param.dir_cd             
                                AND x.port_cd      <> 'XXXXX'
                            -- Start 2 -------------------------------------------------------------------------------------------
                           ) a,
                           (
                           SELECT y.trd_cd, y.rlane_cd, y.bsa_op_jb_cd, y.crr_cd,
                                  x.vsl_cd, x.skd_voy_no, x.skd_dir_cd, x.vps_port_cd, MAX(x.clpt_seq) clpt_seq
                             FROM vsk_vsl_port_skd x,
                                  (
                                    SELECT distinct param.trd_cd trd_cd, param.rlane_cd rlane_cd, bsa_op_jb_cd, crr_cd
                                      FROM bsa_crr_rgst
                                     WHERE bsa_op_jb_cd IN ('007','015','016')                                   
                                  ) y
                            WHERE 1=1
                              AND vsl_cd       = param.vsl_cd
                              AND skd_voy_no   = param.skd_voy_no
                              AND skd_dir_cd   = param.dir_cd
                              AND NVL(skd_cng_sts_cd,'*') <> 'S'
                           GROUP BY y.trd_cd, y.rlane_cd, y.bsa_op_jb_cd, y.crr_cd, 
                                    x.vsl_cd, x.skd_voy_no, x.skd_dir_cd, x.vps_port_cd
                          ) b
                     WHERE 1=1
                       AND a.trd_cd(+)       = b.trd_cd
                       AND a.rlane_cd(+)     = b.rlane_cd
                       AND a.bsa_op_jb_cd(+) = b.bsa_op_jb_cd
                       AND a.crr_cd(+)       = b.crr_cd
                       AND a.vsl_cd(+)       = b.vsl_cd
                       AND a.skd_voy_no(+)   = b.skd_voy_no
                       AND a.skd_dir_cd(+)   = b.skd_dir_cd
                       AND a.port_cd(+)      = b.vps_port_cd   
            ) y
            ON
            (
                    x.trd_cd       = y.trd_cd
                AND x.rlane_cd     = y.rlane_cd
                AND x.vsl_cd       = y.vsl_cd
                AND x.skd_voy_no   = y.skd_voy_no
                AND x.skd_dir_cd   = y.skd_dir_cd
                AND x.bsa_op_jb_cd = y.bsa_op_jb_cd
                AND x.crr_cd       = y.crr_cd
                AND x.port_cd      = y.port_cd
            )
            WHEN MATCHED THEN
                UPDATE 
                   SET x.port_seq      = y.seq,
                       x.upd_usr_id    = y.cre_usr_id,
                       x.upd_dt        = SYSDATE
            WHEN NOT MATCHED THEN
                INSERT (
                        trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, 
                        bsa_op_jb_cd, crr_cd, port_seq, port_cd, port_bsa_capa, 
                        cre_usr_id, cre_dt, upd_usr_id, upd_dt
                       )
                VALUES (y.trd_cd, y.rlane_cd, y.vsl_cd, y.skd_voy_no, y.skd_dir_cd,
                        y.bsa_op_jb_cd, y.crr_cd, y.seq, y.port_cd, y.port_bsa_capa,
                        y.cre_usr_id, SYSDATE, y.cre_usr_id, SYSDATE
                       )
            ;
            enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
--            DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
        END IF;
        
        
    
        /* Port Step Up/Down에 선사별 값 Insert */
        v_step_no :='6';
        v_status_msg := '6) Port Step Up/Down에 선사별 값 Insert[BSA_VVD_PORT_DWN]'; 
        -- contract의 bsa의 capa정보를 port step up/down 테이블에 입력한다.
        INSERT INTO bsa_vvd_port_dwn (
                                          trd_cd,rlane_cd,vsl_cd,skd_voy_no,skd_dir_cd,
                                          bsa_op_jb_cd,crr_cd,port_seq,port_cd,port_bsa_capa,
                                          cre_usr_id,cre_dt, upd_usr_id, upd_dt
                                         )
        SELECT x.trd_cd,x.rlane_cd,x.vsl_cd,x.skd_voy_no,x.dir_cd,
               x.bsa_op_jb_cd,x.crr_cd,x.port_seq,x.port_cd,
               x.crr_bsa_capa,p_user_id,SYSDATE,p_user_id,SYSDATE
        FROM (
              SELECT a.trd_cd         AS trd_cd,
                     a.rlane_cd       AS rlane_cd,
                     param.vsl_cd     AS vsl_cd,
                     param.skd_voy_no AS skd_voy_no,
                     param.dir_cd     AS dir_cd,                           
                     b.bsa_op_jb_cd,
                     b.crr_cd,
                     999              AS port_seq,
                     'XXXXX'          AS port_cd,
                     b.crr_bsa_capa
              FROM bsa_jnt_op_bzc a,bsa_jnt_op_crr_capa b
              WHERE a.bsa_seq                    = b.bsa_seq
                AND a.trd_cd                     = b.trd_cd 
                AND a.rlane_cd                   = b.rlane_cd 
                AND a.dir_cd                     = b.dir_cd 
                AND a.vop_cd                     = b.vop_cd 
                AND a.vsl_capa                   = b.vsl_capa 
                AND a.trd_cd                     = param.trd_cd
                AND a.rlane_cd                   = param.rlane_cd
                AND a.dir_cd                     = param.dir_cd
                AND a.vop_cd                     = param.vop_cd
                AND a.vsl_capa                   = param.vsl_capa 
                AND param.STUP_FLG               = 'Y'    
                AND param.vsl_lane_tp_cd         = 'JO'
                AND b.bsa_op_jb_cd               IN ('007','015','016')
                AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(a.bsa_to_dt,'YYYYMMDD')+0.99999
              UNION ALL
              SELECT a.trd_cd         AS trd_cd,
                     a.rlane_cd       AS rlane_cd,
                     param.vsl_cd     AS vsl_cd,
                     param.skd_voy_no AS skd_voy_no,
                     param.dir_cd     AS dir_cd,                           
                     b.bsa_op_jb_cd,
                     b.crr_cd,
                     999              AS port_seq,
                     'XXXXX'          AS port_cd,
                     b.crr_bsa_capa    
              FROM bsa_slt_chtr_bzc a,bsa_slt_chtr_crr_capa b
              WHERE a.bsa_seq                   = b.bsa_seq
                AND a.trd_cd                    = b.trd_cd 
                AND a.rlane_cd                  = b.rlane_cd 
                AND a.dir_cd                    = b.dir_cd                 
                AND a.vsl_seq                   = b.vsl_seq
                AND a.trd_cd                    = bscb_trd_cd    -- param.trd_cd
                AND a.rlane_cd                  = bscb_rlane_cd  -- param.rlane_cd
                AND a.dir_cd                    = bscb_dir_cd    -- param.dir_cd
                AND a.vsl_seq                   = bscb_vsl_seq
                AND a.bsa_seq                   = bscb_bsa_seq
                AND param.STUP_FLG              = 'Y'
                AND param.vsl_lane_tp_cd        = 'SC'
--              AND NVL(a.vsl_cd,'X')           = DECODE(a.vsl_cd,NULL,'X',param.vsl_cd)          
                AND b.bsa_op_jb_cd              IN ('007','015','016')   
--              AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(a.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(a.bsa_to_dt,'YYYYMMDD')+0.99999
            ) x
        WHERE NOT EXISTS(
                         SELECT 1
                         FROM bsa_vvd_port_dwn B
                         WHERE b.trd_cd     = x.trd_cd
                           AND b.rlane_cd   = x.rlane_cd
                           AND b.vsl_cd     = x.vsl_cd
                           AND b.skd_voy_no = x.skd_voy_no
                           AND b.skd_dir_cd = x.dir_cd
                           AND b.port_seq   = 999
                           AND b.port_cd    = 'XXXXX'                             
                           AND b.crr_cd     = x.crr_cd
                        ) 
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
        
        
        /* Other Carrier TEU 정보 Insert */
        v_step_no :='7';
        v_status_msg := '7) Other Carrier TEU 정보 Insert[BSA_VVD_OTR_CRR]'; 
        INSERT INTO bsa_vvd_otr_crr(trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd,
                                        bsa_op_jb_cd, crr_cd, crr_bsa_capa, spc_ctrl_slt_capa,
                                        cre_usr_id, cre_dt, upd_usr_id, upd_dt       
                                       ) 
        SELECT x.trd_cd, x.rlane_cd, x.vsl_cd, x.skd_voy_no, x.dir_cd,
               x.bsa_op_jb_cd, x.crr_cd, x.crr_bsa_capa, x.spc_capa, 
               p_user_id, SYSDATE ,p_user_id,SYSDATE
          FROM (                    
                SELECT param.trd_cd     AS trd_cd,
                       param.rlane_cd   AS rlane_cd,
                       param.vsl_cd     AS vsl_cd,
                       param.skd_voy_no AS skd_voy_no,
                       param.dir_cd     AS dir_cd,                           
                       e.bsa_op_jb_cd   AS bsa_op_jb_cd,
                       e.crr_cd,
                       e.crr_bsa_capa, 
                       DECODE(e.bsa_op_jb_cd,'007',e.spc_ctrl_slt_capa,0) AS spc_capa                    
                  FROM bsa_jnt_op_bzc d,bsa_jnt_op_crr_capa e
                 WHERE d.bsa_SEQ                   = e.bsa_SEQ
                   AND d.trd_cd                    = e.trd_cd 
                   AND d.rlane_cd                  = e.rlane_cd 
                   AND d.dir_cd                    = e.dir_cd 
                   AND d.vop_cd                    = e.vop_cd 
                   AND d.vsl_capa                  = e.vsl_capa 
                   AND d.trd_cd                    = param.trd_cd
                   AND d.rlane_cd                  = param.rlane_cd
                   AND d.dir_cd                    = param.dir_cd
                   AND d.vop_cd                    = param.vop_cd
                   AND d.vsl_capa                  = param.vsl_capa 
                   AND param.vsl_lane_tp_cd        ='JO'            
                   AND e.bsa_op_jb_cd              in ('007','008','009','010','011','012','013','014','022')
                   AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
                 UNION ALL
                SELECT param.trd_cd,
                       param.rlane_cd,

                       param.vsl_cd,
                       param.skd_voy_no,
                       param.dir_cd,
                       e.bsa_op_jb_cd,
                       e.crr_cd,
                       e.crr_bsa_capa,
                       DECODE(e.bsa_op_jb_cd,'007',e.crr_bsa_capa)
                  FROM bsa_slt_chtr_bzc d, bsa_slt_chtr_crr_capa e
                 WHERE d.bsa_seq                   = e.bsa_seq
                   AND d.trd_cd                    = e.trd_cd 
                   AND d.rlane_cd                  = e.rlane_cd 
                   AND d.dir_cd                    = e.dir_cd                 
                   AND d.vsl_seq                   = e.vsl_seq
                   AND d.trd_cd                    = bscb_trd_cd    -- param.trd_cd
                   AND d.rlane_cd                  = bscb_rlane_cd  -- param.rlane_cd
                   AND d.dir_cd                    = bscb_dir_cd    -- param.dir_cd
                   AND d.vsl_seq                   = bscb_vsl_seq
                   AND d.bsa_seq                   = bscb_bsa_seq
                   AND param.vsl_lane_tp_cd        ='SC'
--                 AND NVL(d.vsl_cd,'X')           = DECODE(d.vsl_cd,NULL,'X',param.vsl_cd)          
                   AND e.bsa_op_jb_cd              in ('007','008','009','010','011','012','013','014','022')  
--                 AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(d.bsa_fm_dt,'YYYYMMDD') AND TO_DATE(d.bsa_to_dt,'YYYYMMDD')+0.99999
                ) x
         WHERE NOT EXISTS (
                           SELECT 1
                             FROM bsa_vvd_otr_crr y
                            WHERE y.trd_cd       = x.trd_cd
                              AND y.rlane_cd     = x.rlane_cd
                              AND y.vsl_cd       = x.vsl_cd
                              AND y.skd_voy_no   = x.skd_voy_no
                              AND y.skd_dir_cd   = x.dir_cd
                              AND y.bsa_op_jb_cd = x.bsa_op_jb_cd
                              AND y.crr_cd       = x.crr_cd
                          )  
        ; 
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation');                                  
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
        
        BEGIN
        /* MASTER TABLE Update */
        /* Master의 물량 기준 정보 Update */
        v_step_no :='8';
        v_status_msg  := '8) Master의 물량 기준 정보 SELECT'; 
        SELECT bsa_capa, co_final, co_bsa_bfr_sub_capa
          INTO v_bsa_capa, v_fnl_co_bsa_capa, v_co_bsa_bfr_sub_capa
          FROM (
                SELECT bsa_capa, 0 co_final, co_bsa_bfr_sub_capa
                  FROM bsa_jnt_op_bzc
                 WHERE trd_cd      = param.trd_cd
                   AND rlane_cd    = param.rlane_cd
                   AND dir_cd      = param.dir_cd
                   AND vop_cd      = param.vop_cd
                   AND vsl_capa    = param.vsl_capa 
                   AND 'JO'        = param.vsl_lane_tp_cd
                   AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(bsa_fm_dt,'YYYYMMDD') AND TO_DATE(bsa_to_dt,'YYYYMMDD')+0.99999
                UNION ALL
                SELECT 0, d.co_fnl_bsa_capa, d.co_bsa_bfr_sub_capa             
                  FROM bsa_slt_chtr_bzc d
                 WHERE d.trd_cd    = bscb_trd_cd    -- param.trd_cd
                   AND d.rlane_cd  = bscb_rlane_cd  -- param.rlane_cd
                   AND d.dir_cd    = bscb_dir_cd    -- param.dir_cd
                   AND d.vsl_seq   = bscb_vsl_seq
                   AND d.bsa_seq   = bscb_bsa_seq
                   AND 'SC'        = param.vsl_lane_tp_cd
--                 AND NVL(vsl_cd,'X') = DECODE(vsl_cd,NULL,'X', param.vsl_cd)      
--                 AND param.n1st_lodg_port_etd_dt BETWEEN TO_DATE(bsa_fm_dt,'YYYYMMDD') AND TO_DATE(bsa_to_dt,'YYYYMMDD')+0.99999
               )
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
        
        /*
          해당  VVD의 First Loading Port ETD Date에 해당하는 Contract 정보가 있을때만 처리한다.
        */
        v_step_no :='9';
        v_status_msg  := '9) Master의 물량 기준 정보 UPDATE[BSA_VVD_MST]'; 
        UPDATE bsa_vvd_mst
           set bsa_capa             = NVL(v_bsa_capa, bsa_capa),
               fnl_co_bsa_capa     = NVL(v_fnl_co_bsa_capa, fnl_co_bsa_capa),
               co_bsa_bfr_sub_capa = NVL(v_co_bsa_bfr_sub_capa, co_bsa_bfr_sub_capa),
               crr_cd               = param.crr_cd,
               upd_usr_id           = p_user_id,
               upd_dt               = SYSDATE
         WHERE trd_cd     = param.trd_cd
           AND rlane_cd   = param.rlane_cd
           AND vsl_cd     = param.vsl_cd
           AND skd_voy_no = param.skd_voy_no
           AND skd_dir_cd = param.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
        
    	
    	EXCEPTION 
    	   WHEN NO_DATA_FOUND then
                p_error_code   := SQLCODE;
                p_error_msg    := '[Create BSA VVD PRC] : No Data Found Error : [' || v_mig_err_msg || ']' ||  v_status_msg || '  '|| SQLERRM || ' >>> ' || v_dtl_msg ;
                enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', p_error_msg, 'VVD Creation'); 
                DBMS_OUTPUT.PUT_LINE( p_error_msg);
        	    --RAISE;           
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE( 'OTHERS > ' || SQLERRM);
                --RAISE;
    	END;
    
          
            
        /* vvd Carrier별 물량을 감안한 최종 물량 기준 정보 Update */
        v_step_no :='10';
        v_status_msg := '10) vvd Carrier별 물량을 감안한 최종 물량 기준 정보 Update[BSA_VVD_MST]'; 
        UPDATE bsa_vvd_mst
        SET (rev_port_cd, rev_port_etd_dt, n1st_port_etd_dt, 
             fnl_co_bsa_capa, n2nd_fnl_co_bsa_capa, co_bsa_capa, co_bsa_rto, chtr_bsa_rto) = 
            (
             SELECT param.lst_lodg_port_cd, param.lst_lodg_port_etd_dt, param.n1st_lodg_port_etd_dt,
                    fnl_co_bsa_capa, fnl_co_bsa_capa, cht_out,
                    fnl_co_bsa_capa/DECODE((fnl_co_bsa_capa+cht_out),0,1,(fnl_co_bsa_capa+cht_out)) co_rto,
                    1 - fnl_co_bsa_capa/DECODE((fnl_co_bsa_capa+cht_out),0,1,(fnl_co_bsa_capa+cht_out)) cht_rto
             FROM (    
                   SELECT trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd,
                          bsa_op_cd,vop_cd,
                          DECODE(bsa_op_cd,'S', fnl_co_bsa_capa, (co_bsa_bfr_sub_capa - sco+sci-cco+cci)) fnl_co_bsa_capa,
                          DECODE(vop_cd,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC, DECODE(bsa_op_cd,'J',ini+sco+cco, ini+sco),
                                               DECODE(bsa_op_cd,'J',sco+cco, sco)) cht_out,                   
                          co_bsa_bfr_sub_capa
                   FROM (
                         SELECT a.trd_cd,a.rlane_cd,a.vsl_cd,a.skd_voy_no,a.skd_dir_cd,
                                a.fnl_co_bsa_capa,a.bsa_op_cd,a.vop_cd,
                                a.co_bsa_bfr_sub_capa,
                                NVL(SUM(DECODE(b.bsa_op_jb_cd,'001',crr_bsa_capa)),0) ini,
                                NVL(SUM(DECODE(b.bsa_op_jb_cd,'002',crr_bsa_capa)),0) sco,
                                NVL(SUM(DECODE(b.bsa_op_jb_cd,'003',crr_bsa_capa)),0) sci,
                                NVL(SUM(DECODE(b.bsa_op_jb_cd,'004',crr_bsa_capa)),0) cco,
                                NVL(SUM(DECODE(b.bsa_op_jb_cd,'005',crr_bsa_capa)),0) cci
                         FROM bsa_vvd_mst a, bsa_vvd_crr_perf b
                         WHERE a.trd_cd     = b.trd_cd(+)
                           AND a.rlane_cd   = b.rlane_cd(+)
                           AND a.vsl_cd     = b.vsl_cd(+)
                           AND a.skd_voy_no = b.skd_voy_no(+)
                           AND a.skd_dir_cd = b.skd_dir_cd(+)
                           AND a.trd_cd     = param.trd_cd
                           AND a.rlane_cd   = param.rlane_cd
                           AND a.vsl_cd     = param.vsl_cd
                           AND a.skd_voy_no = param.skd_voy_no
                           AND a.skd_dir_cd = param.dir_cd
                         GROUP BY a.trd_cd,a.rlane_cd,a.vsl_cd,a.skd_voy_no,a.skd_dir_cd,
                                  a.fnl_co_bsa_capa,a.bsa_op_cd,a.vop_cd,
                                  a.co_bsa_bfr_sub_capa
                        ) 
                  )
            )
        WHERE trd_cd     = param.trd_cd
          AND rlane_cd   = param.rlane_cd
          AND vsl_cd     = param.vsl_cd
          AND skd_voy_no = param.skd_voy_no
          AND skd_dir_cd = param.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
    
    
        /* 
          JO Other 선사 정보를 Carrier별 Table에 Insert
          2007.03.26 이석준 
        */
        IF param.vop_cd = 'OTH' AND param.vsl_lane_tp_cd = 'JO' THEN
            BEGIN
                v_step_no :='11';
                v_status_msg := '11) JO Other 선사 정보를 Carrier별 Table에 Insert[BSA_VVD_CRR_PERF]';
                INSERT INTO bsa_vvd_crr_perf 
                (
                 trd_cd, rlane_cd, vsl_cd, skd_voy_no, skd_dir_cd, 
                 bsa_op_jb_cd, crr_cd, crr_bsa_capa, crr_perf_amt, 
                 cre_usr_id, cre_dt, upd_usr_id, upd_dt
                )
                SELECT a.trd_cd, a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, 
                       '000' bsa_op_jb_cd, 
                       a.crr_cd, a.co_bsa_bfr_sub_capa, 0,
                       p_user_id, SYSDATE, p_user_id, SYSDATE
                  FROM bsa_vvd_mst a
                 WHERE a.trd_cd     = param.trd_cd
                   AND a.rlane_cd   = param.rlane_cd
                   AND a.vsl_cd     = param.vsl_cd
                   AND a.skd_voy_no = param.skd_voy_no
                   AND a.skd_dir_cd = param.dir_cd 
                   AND NOT EXISTS (
                                  SELECT 1
                                    FROM bsa_vvd_crr_perf b
                                   WHERE b.trd_cd       = a.trd_cd
                                     AND b.rlane_cd     = a.rlane_cd
                                     AND b.vsl_cd       = a.vsl_cd
                                     AND b.skd_voy_no   = a.skd_voy_no
                                     AND b.skd_dir_cd   = a.skd_dir_cd
                                     AND b.bsa_op_jb_cd = '000'
                                 )
                ;
                enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
                --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
                EXCEPTION
                    WHEN not_null_ins THEN
                        v_mig_err_msg :='['||param.trd_cd||']['||param.rlane_cd||']['||param.vsl_cd||']['||param.skd_voy_no||']['||param.dir_cd||'] Not Found Carrier Info';
                        RAISE;
                    WHEN OTHERS THEN
                        RAISE;
            END ;
        END IF;
          
        
        /* Carrier별 선복 임대차 비용 계산 Update */
        v_step_no :='12';
        v_status_msg := '12) Carrier별 선복 임대차 비용 계산 Update';
        UPDATE bsa_vvd_crr_perf a
           SET crr_perf_amt = NVL((
                               SELECT decode(a.bsa_op_jb_cd,'001',c.slt_prc_capa     * a.crr_bsa_capa,
                                                            '002',c.slt_prc_capa     * a.crr_bsa_capa,
                                                            '003',b.sub_chtr_bsa_capa* a.crr_bsa_capa,
                                                            '004',c.slt_prc_capa     * a.crr_bsa_capa,
                                                            '005',b.crs_chtr_bsa_capa* a.crr_bsa_capa,
                                                            '000',b.co_bfr_sub_capa * a.crr_bsa_capa) crr_perf 
                                 from bsa_vvd_crr_perf d,(
                                       SELECT co_bfr_sub_capa,  /* Company before sub */
                                              sub_chtr_bsa_capa, /* 003 */
                                              crs_chtr_bsa_capa  /* 005 */
                                         FROM bsa_slt_prc a
                                        WHERE a.trd_cd   = param.trd_cd
                                          AND a.rlane_cd = param.rlane_cd
                                          AND a.dir_cd   = param.dir_cd
                                          AND param.n1st_lodg_port_etd_dt >=TO_DATE(bsa_slt_prc_fm_dt,'YYYYMMDD')
                                          AND param.n1st_lodg_port_etd_dt <=TO_DATE(bsa_slt_prc_to_dt,'YYYYMMDD')+0.99999
                                          AND a.bsa_slt_cost_tp_cd = '017') b,
                                      (/* 수입 */
                                       SELECT bsa_op_jb_cd,crr_cd,slt_prc_capa
                                         FROM bsa_slt_prc_crr a
                                        WHERE a.trd_cd   = param.trd_cd
                                          AND a.rlane_cd = param.rlane_cd
                                          AND a.dir_cd   = param.dir_cd
                                          AND param.n1st_lodg_port_etd_dt >=TO_DATE(bsa_slt_prc_fm_dt,'YYYYMMDD')
                                          AND param.n1st_lodg_port_etd_dt <=TO_DATE(bsa_slt_prc_to_dt,'YYYYMMDD')+0.99999
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
        WHERE a.trd_cd       = param.trd_cd
          AND a.rlane_cd     = param.rlane_cd
          AND a.vsl_cd       = param.vsl_cd
          AND a.skd_voy_no   = param.skd_voy_no
          AND a.skd_dir_cd   = param.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨');
        
        
        /* Carrier별 선복 임대차 비용 계산 - JOO 요청으로 Slot Price 추가 */
        v_step_no :='13';
        v_status_msg := '13) Carrier별 선복 임대차 비용 - Slot Price Update' ;
         UPDATE bsa_vvd_crr_perf 
           SET slt_prc_capa = NVL(decode(NVL(CRR_BSA_CAPA,0),0,0, (CRR_PERF_AMT / CRR_BSA_CAPA)) ,0)
         WHERE trd_cd       = param.trd_cd
          AND rlane_cd     = param.rlane_cd
          AND vsl_cd       = param.vsl_cd
          AND skd_voy_no   = param.skd_voy_no
          AND skd_dir_cd   = param.dir_cd
        ;
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation');   
        
    
        /* VVD별 선복 임대차 비용 계산 Update */
        v_step_no :='14';
        v_status_msg := '14) VVD별 선복 임대차 비용 계산 Update';
        UPDATE bsa_vvd_mst a
           SET (a.expn_bzc_chtr_amt,a.expn_sub_chtr_amt,a.expn_crs_chtr_amt,
                a.incm_bzc_chtr_amt,a.incm_sub_chtr_amt,a.incm_crs_chtr_amt)
               =
               (
--                c.oth,c.ssi,c.cci,c.ini,c.sso,c.cco
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
         WHERE a.trd_cd       = param.trd_cd
           AND a.rlane_cd     = param.rlane_cd
           AND a.vsl_cd       = param.vsl_cd
           AND a.skd_voy_no   = param.skd_voy_no
           AND a.skd_dir_cd   = param.dir_cd
        ; 
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ');
        
        v_step_no :='15';
        v_status_msg := '15) VVD별 선복 임대차 비율 Update[COA_MON_VVD]';
        UPDATE  COA_MON_VVD
           SET (CO_BSA_RTO,         
                CHTR_BSA_RTO,
                VVD_BSA_CAPA) = (
                                 SELECT CO_BSA_RTO,CHTR_BSA_RTO,FNL_CO_BSA_CAPA
                                 FROM BSA_VVD_MST
                                 WHERE trd_cd       = param.trd_cd
                                   AND rlane_cd     = param.rlane_cd
                                   AND vsl_cd       = param.vsl_cd
                                   AND skd_voy_no   = param.skd_voy_no
                                   AND skd_dir_cd   = param.dir_cd)
        WHERE trd_cd       = param.trd_cd
          AND rlane_cd     = param.rlane_cd
          AND vsl_cd       = param.vsl_cd
          AND skd_voy_no   = param.skd_voy_no
          AND dir_cd       = param.dir_cd
        ;  
        enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', v_status_msg || '[' || TO_CHAR(sql%rowcount) || ']' , 'VVD Creation'); 
        --DBMS_OUTPUT.PUT_LINE(v_status_msg || ' : ' || TO_CHAR(sql%rowcount) || '건 처리됨 ' );
           
           
    END LOOP;    
    DBMS_OUTPUT.PUT_LINE('BSA_CREATE_VVD_PRC OK');
    p_error_code := '00000';
    p_error_msg  := 'Completed!';
--    COMMIT;
--------------------- [ 예외 처리부    ] --------------------------------------
EXCEPTION                                  
    WHEN not_null_ins THEN   
         p_error_code   := SQLCODE;
         p_error_msg    := '[Create BSA VVD PRC Error(Not Null Insert)!!]♀[BSAVVDCreation'||v_step_no|| SQLERRM || ']♀[' || v_info || ']♀[' || v_status_msg ||']' ;
         enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', '[Create BSA VVD PRC Error(Not Null Insert)!!] : [' || v_mig_err_msg || ']' || v_status_msg || '  '|| SQLERRM || ' >>> ' || v_dtl_msg , 'Exception'); 
         DBMS_OUTPUT.PUT_LINE( p_error_msg || ' '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
    
    WHEN not_first_etd THEN  
         p_error_code   := SQLCODE;
         p_error_msg    := '[Create BSA VVD PRC Error(Not First ETD)!!]♀[BSAVVDCreation'||v_step_no|| SQLERRM || ']♀[' || v_info || ']♀[' || v_status_msg ||']' ;
         enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', '[Create BSA VVD PRC Error(Not First ETD)!!] : [' || v_mig_err_msg || ']' || v_status_msg || '  '|| SQLERRM || ' >>> ' || v_dtl_msg , 'Exception'); 
         DBMS_OUTPUT.PUT_LINE( p_error_msg || ' '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));

    WHEN OTHERS THEN   
         p_error_code   := SQLCODE;
         p_error_msg    := '[Create BSA VVD PRC Error!!]♀[BSAVVDCreation'||v_step_no|| SQLERRM || ']♀[' || v_info || ']♀[' || v_status_msg ||']' ;
         enis_log_prc(SYSDATE, 'BSA_CREATE_VVD_PRC', '[Create BSA VVD PRC Error!!] : [' || v_mig_err_msg || ']' || v_status_msg || '  '|| SQLERRM || ' >>> ' || v_dtl_msg , 'Exception'); 
         DBMS_OUTPUT.PUT_LINE( p_error_msg || ' '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));

END BSA_CREATE_VVD_PRC;