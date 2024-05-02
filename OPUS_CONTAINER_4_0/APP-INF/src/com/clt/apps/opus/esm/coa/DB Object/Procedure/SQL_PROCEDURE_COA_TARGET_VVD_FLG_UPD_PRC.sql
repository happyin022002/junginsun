CREATE OR REPLACE PROCEDURE OPUSADM.COA_TARGET_VVD_FLG_UPD_PRC (
       p_year       IN  VARCHAR2,
       p_fm_wk      IN  VARCHAR2,
       p_to_wk      IN  VARCHAR2,
       p_trd_cd     IN  VARCHAR2, -- Optional
       p_rlane_cd   IN  VARCHAR2, -- Optional
       p_ioc_cd     IN  VARCHAR2, -- Optional
       p_vsl_cd     IN  VARCHAR2, -- Optional
       p_skd_voy_no IN  VARCHAR2, -- Optional
       p_dir_cd     IN  VARCHAR2, -- Optional
       p_usr_id     IN  VARCHAR2,
       p_err_cd     OUT VARCHAR2,
       p_err_msg    OUT VARCHAR2
)
Authid current_user
IS
/******************************************************************************
   NAME:       COA_TARGET_VVD_FLG_UPD_PRC
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2007-05-16          1. Created this procedure.

   NOTES:

   Automatically available Auto Replace Keywords:
      Object Name:     COA_TARGET_VVD_FLG_UPD_PRC
      Sysdate:         2007-05-16
      Date and Time:   2007-05-16, 오후 8:47:56, and 2007-05-16 오후 8:47:56
      Username:         (set in TOAD Options, Procedure Editor)
      Table Name:       (set in the "New PL/SQL Object" dialog)

******************************************************************************/
/*
  1.Name       : PEJ
  2.Create Date: 2007-05-
  3.Description:
      - 용도: 대상항차 보정작업
      - 파라미터:
      - 특이사항
        (1)
  4.Revision History
*/
------------------------------[ 변수선언부             ]-----------------------
    v_mig_st_dt     date                                          ;
    v_mig_err_msg   varchar2(1000)                                ;
    v_mig_msg       varchar2(1000)                                ;

------------------------------- [ 업무로직 구현부] ----------------------------

BEGIN
    DBMS_OUTPUT.ENABLE;

    /** 시작일시 설정 **/
    v_mig_st_dt := sysdate ;

    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('모든 Port가 skip되었을 경우 상태플래그 DELT_FLG=Y');
    -- VSL_SKD TABLE에는 있으나 VSK_VSL_PORT_SKD TABLE의 DATA를 모두 날린 경우가 존재한다.
    -- ALL PORT SKIP인경우
    -- ------------------------------------------------------------------------------------------- --
    -- 모든 PORT가 SKIP이면 DELT_FLG='Y'
    UPDATE coa_mon_vvd a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
     WHERE NOT EXISTS (SELECT 1
                         FROM vsk_vsl_port_skd b
                        WHERE a.vsl_cd              = b.vsl_cd
                          AND a.skd_voy_no          = b.skd_voy_no
                          AND a.dir_cd              = b.skd_dir_cd
                          AND a.slan_cd             = b.slan_cd
                          AND NVL(b.skd_cng_sts_cd,'*') <> 'S')
       AND a.sls_yrmon   LIKE p_year || '%'
       AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
       AND a.rlane_cd    <> 'RBCCO'
       AND a.mon_tgt_flg <> 'Y'
       AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
       AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
       AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
       AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
       AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
       AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
    ;
    v_mig_msg := '모든 Port가 skip되었을 경우 상태플래그 DELT_FLG=Y 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);

    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('PORT중에 하나라도 SKIP이 아닌것이 있으면 DELT_FLG=N');
    -- ------------------------------------------------------------------------------------------- --
    -- PORT중에 하나라도 SKIP이 아닌것이 있으면 DELT_FLG='N'
    UPDATE coa_mon_vvd a
       SET a.delt_flg   = 'N',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
     WHERE EXISTS (SELECT 1
                     FROM vsk_vsl_port_skd b
                    WHERE a.vsl_cd              = b.vsl_cd
                      AND a.skd_voy_no          = b.skd_voy_no
                      AND a.dir_cd              = b.skd_dir_cd
                      AND a.slan_cd             = b.slan_cd
                      AND NVL(b.skd_cng_sts_cd,'*') <> 'S')
       AND a.sls_yrmon   LIKE p_year || '%'
       AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
       AND a.rlane_cd    <> 'RBCCO'
       AND a.mon_tgt_flg <> 'Y'
       AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
       AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
       AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
       AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
       AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
       AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
    ;
    v_mig_msg := 'PORT중에 하나라도 SKIP이 아닌것이 있으면 DELT_FLG=N 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('역내구간이 모두 skip되었을 경우 상태플래그 업데이트');
    -- ------------------------------------------------------------------------------------------- --
    UPDATE COA_MON_VVD a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE (a.trd_cd, a.rlane_cd, a.ioc_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd)
       IN ( SELECT DISTINCT trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd
              FROM (
                     -- 역내구간이 모두 skip이 되었을때 Ocean을 삭제처리한다. conti 가 하나만 존재하는경우
                    SELECT trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd
                      FROM (
                            SELECT DISTINCT trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd,
                                   COUNT(conti_cd) OVER(PARTITION BY trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd ) conti_cnt
                              FROM (

                                    SELECT DISTINCT c.trd_cd, c.rlane_cd, c.ioc_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd,b.conti_cd,
                                           -- a.vps_port_cd, c.lst_lodg_port_cd, a.clpt_seq, a.cng_sts_cd,
                                           c.delt_flg
                                    FROM vsk_vsl_port_skd a, mdm_location b, coa_mon_vvd c
                                    WHERE a.vps_port_cd = b.loc_cd
                                      AND a.vsl_cd      = c.vsl_cd
                                      AND a.skd_voy_no  = c.skd_voy_no
                                      AND a.skd_dir_cd  = c.dir_cd
                                      AND NVL(a.skd_cng_sts_cd,'*') <> 'S'
                                      AND c.ioc_cd      = 'O'
                                      AND c.mon_tgt_flg <> 'Y'
                                      AND c.delt_flg    <> 'Y'
                                      AND c.rlane_cd    <> 'RBCCO'
                                      AND c.sls_yrmon  LIKE p_year || '%'
                                      AND c.cost_wk    BETWEEN p_fm_wk AND p_to_wk
                                      AND c.trd_cd      = NVL(p_trd_cd    , c.trd_cd)
                                      AND c.rlane_cd    = NVL(p_rlane_cd  , c.rlane_cd)
                                      AND c.ioc_cd      = NVL(p_ioc_cd    , c.ioc_cd)
                                      AND c.vsl_cd      = NVL(p_vsl_cd    , c.vsl_cd)
                                      AND c.skd_voy_no  = NVL(p_skd_voy_no, c.skd_voy_no)
                                      AND c.dir_cd      = NVL(p_dir_cd    , c.dir_cd)
                                   )
                           )
                     WHERE conti_cnt = 1
                )
          )
    ;
    v_mig_msg := '역내구간이 모두 skip되었을 경우 상태플래그 업데이트 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);

    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('Ocean Port가 모두 skip되었을 경우 상태플래그 업데이트');
    -- ------------------------------------------------------------------------------------------- --
    UPDATE COA_MON_VVD a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE (a.trd_cd, a.rlane_cd, a.ioc_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd)
       IN ( SELECT DISTINCT trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd
              FROM (
                    -- Ocean 이 모두 skip이 되었을때 즉 Ocean의 포트갯수()와 Skip된 갯수가 같으면
                    SELECT c.trd_cd, c.rlane_cd, c.ioc_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.vps_port_cd, c.lst_lodg_port_cd, a.clpt_seq, a.skd_cng_sts_cd, b.conti_cd,
                           SUM(1) OVER(PARTITION BY c.trd_cd, c.rlane_cd, c.ioc_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd ) o_cnt,
                           SUM(DECODE(a.skd_cng_sts_cd,'S',1)) OVER(partition by c.trd_cd, c.rlane_cd, c.ioc_cd, a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) s_cnt,
                           c.delt_flg
                    FROM vsk_vsl_port_skd a, mdm_location b, coa_mon_vvd c
                    WHERE a.vps_port_cd = b.loc_cd
                      AND a.vsl_cd      = c.vsl_cd
                      AND a.skd_voy_no  = c.skd_voy_no
                      AND a.skd_dir_cd  = c.dir_cd
                      AND b.conti_cd    <> 'A'         -- Ocean에 해당하는 port가 아닌경우를 제외한다.
                      AND c.ioc_cd      = 'O'
                      AND c.mon_tgt_flg <> 'Y'
                      AND c.delt_flg    <> 'Y'
                      AND c.rlane_cd    <> 'RBCCO'
                      AND c.sls_yrmon  LIKE p_year || '%'
                      AND c.cost_wk    BETWEEN p_fm_wk AND p_to_wk
                      AND c.trd_cd      = NVL(p_trd_cd    , c.trd_cd)
                      AND c.rlane_cd    = NVL(p_rlane_cd  , c.rlane_cd)
                      AND c.ioc_cd      = NVL(p_ioc_cd    , c.ioc_cd)
                      AND c.vsl_cd      = NVL(p_vsl_cd    , c.vsl_cd)
                      AND c.skd_voy_no  = NVL(p_skd_voy_no, c.skd_voy_no)
                      AND c.dir_cd      = NVL(p_dir_cd    , c.dir_cd)
                   )
              WHERE 1=1
                AND o_cnt               = s_cnt
          )
    ;
    v_mig_msg := 'Ocean Port가 모두 skip되었을 경우 상태플래그 업데이트 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);

    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('Ocean을 Skip하여 모두 삭제 한경우 즉 IPC구간만 존재하는 경우 Ocean을 삭제 delt_flg=Y');
    -- ------------------------------------------------------------------------------------------- --
    UPDATE coa_mon_vvd a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE NOT EXISTS (
                        SELECT DISTINCT a.rlane_cd,a.trd_cd,a.ioc_cd,a.vsl_cd,a.skd_voy_no,a.dir_cd,c.conti_cd,d.to_conti_cd
                        FROM vsk_vsl_port_skd b,mdm_location c,mdm_dtl_rev_lane d
                        WHERE 1=1
                          and a.vsl_cd        = b.vsl_cd
                          and a.skd_voy_no    = b.skd_voy_no
                          and a.dir_cd        = b.skd_dir_cd
                          and a.slan_cd       = b.slan_cd
                          AND a.rlane_cd      = d.rlane_cd
                          AND a.dir_cd        = d.vsl_slan_dir_cd
                          AND a.ioc_cd        = d.ioc_cd
                          AND b.vps_port_cd   = c.loc_cd
                          AND c.conti_cd      = d.to_conti_cd
                          AND a.trd_cd        = d.trd_cd
                          AND NVL(b.skd_cng_sts_cd,'*') <> 'S'
                        )
      AND a.sls_yrmon   LIKE p_year || '%'
      AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
      AND a.ioc_cd      = 'O'
      AND a.mon_tgt_flg <> 'Y'
      AND a.delt_flg    <> 'Y'
      AND a.rlane_cd    <> 'RBCCO'
      AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
      AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
      AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
      AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
      AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
      AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
      ;
      v_mig_msg := 'Ocean을 Skip하여 모두 삭제 한경우 즉 IPC구간만 존재하는 경우 Ocean을 삭제 delt_flg=Y 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
      DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    -- 2007.08.06 추가
    -- DBMS_OUTPUT.PUT_LINE('VSK_VSL_SKD.SKD_STS_CD = 'CLO' 스케줄에서 Close된 노선에 대해서 삭제된 노선으로 변경한다.);
    -- ------------------------------------------------------------------------------------------- --
    UPDATE coa_mon_vvd a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE EXISTS (
                  SELECT b.skd_sts_cd
                    FROM vsk_vsl_skd b
                   WHERE 1=1
                     AND a.vsl_cd        = b.vsl_cd
                     AND a.skd_voy_no    = b.skd_voy_no
                     AND a.dir_cd        = b.skd_dir_cd
                     AND a.slan_cd       = b.vsl_slan_cd
                     AND b.skd_sts_cd    = 'CLO'
                 )
      AND a.sls_yrmon   LIKE p_year || '%'
      AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
      AND a.ioc_cd      = 'O'
      AND a.mon_tgt_flg <> 'Y'
      AND a.delt_flg    <> 'Y'
      AND a.rlane_cd    <> 'RBCCO'
      AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
      AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
      AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
      AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
      AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
      AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
      ;
      v_mig_msg := '스케줄에서 Close된 노선에 대해서 삭제된 노선으로 변경한다. delt_flg=Y 처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
      DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    -- 2007.05.30 추가
    -- DBMS_OUTPUT.PUT_LINE('COA_LANE_RGST 테이블에서 삭제된 노선은 대상항차에서도 삭제된 노선으로 변경한다.');
    -- ------------------------------------------------------------------------------------------- --
    UPDATE coa_mon_vvd a
       SET a.delt_flg   = 'Y',
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE  EXISTS (
                    SELECT 'OK'
                    FROM  coa_lane_rgst b
                    WHERE a.rlane_cd = b.rlane_cd
                      AND a.dir_cd   = b.dir_cd
                      AND a.trd_cd   = b.trd_cd
                      AND a.ioc_cd   = b.ioc_cd
                      AND a.delt_flg <> b.delt_flg
                      AND b.delt_flg = 'Y'
                  )
       AND a.sls_yrmon   LIKE p_year || '%'
       AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
       AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
       AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
       AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
       AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
       AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
       AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
    ;
    v_mig_msg := 'COA_LANE_RGST 테이블에서 삭제된 노선은 대상항차에서도 삭제된 노선으로 변경한다.처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('LST_LODG_PORT_ETD_DT를 업데이트한다.');
    -- ------------------------------------------------------------------------------------------- --
    -- LST_LODG_PORT_ETD_DT를 업데이트한다.
    UPDATE coa_mon_vvd a
       SET a.lst_lodg_port_etd_dt = (SELECT MAX(b.vps_etd_dt)
                                       FROM vsk_vsl_port_skd b
                                      WHERE a.vsl_cd           = b.vsl_cd
                                        AND a.skd_voy_no       = b.skd_voy_no
                                        AND a.dir_cd           = b.skd_dir_cd
                                        AND a.lst_lodg_port_cd = b.vps_port_cd
                                        AND NVL(b.skd_cng_sts_cd,'*') <> 'S'
                                  ),
           a.upd_usr_id = p_usr_id,
           a.upd_dt     = SYSDATE
    WHERE a.sls_yrmon   LIKE p_year || '%'
      AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
      AND a.rlane_cd    <> 'RBCCO'
      AND a.mon_tgt_flg <> 'Y'
      AND a.delt_flg    = 'N'
      AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
      AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
      AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
      AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
      AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
      AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
    ;
    v_mig_msg := 'LST_LODG_PORT_ETD_DT를 업데이트한다.처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    -- DBMS_OUTPUT.PUT_LINE('N1ST_LODG_PORT_ETD_DT 를 업데이트한다.');
    -- ------------------------------------------------------------------------------------------- --
    -- N1ST_LODG_PORT_ETD_DT 를 업데이트한다.
    UPDATE coa_mon_vvd a
       SET a.n1st_lodg_port_etd_dt = (SELECT MIN(b.vps_etd_dt)
                                        FROM vsk_vsl_port_skd b
                                       WHERE a.vsl_cd     = b.vsl_cd
                                         AND a.skd_voy_no = b.skd_voy_no
                                         AND a.dir_cd     = b.skd_dir_cd
                                         AND NVL(b.skd_cng_sts_cd,'*') <> 'S'
                                     )
    WHERE a.sls_yrmon LIKE p_year || '%'
      AND a.cost_wk    BETWEEN p_fm_wk AND p_to_wk
      AND a.rlane_cd   <> 'RBCCO'
      AND a.delt_flg   = 'N' ;
      
    v_mig_msg := 'N1ST_LODG_PORT_ETD_DT 를 업데이트한다.처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
    DBMS_OUTPUT.PUT_LINE(v_mig_msg);


    -- ------------------------------------------------------------------------------------------- --
    --DBMS_OUTPUT.PUT_LINE('COST_YRMON, COST_WK를 다시 구해준다.');
    -- ------------------------------------------------------------------------------------------- --
    -- COST_YRMON, COST_WK를 다시 구해준다.
--    UPDATE coa_mon_vvd a
--       SET a.cost_yrmon = DECODE(NVL(mon_tgt_flg,'N'), 'N', SUBSTR(TO_CHAR(a.lst_lodg_port_etd_dt,'YYYYMM'),1,6), a.cost_yrmon),
--           a.cost_wk    = DECODE(NVL(wky_mnl_flg,'P'), 'P', (SELECT b.cost_wk
--                                                               FROM coa_wk_prd b
--                                                              WHERE TO_CHAR(a.lst_lodg_port_etd_dt,'YYYYMMDD') >=sls_fm_dt
--                                                                AND TO_CHAR(a.lst_lodg_port_etd_dt,'YYYYMMDD') <=sls_to_dt
--                                                                AND b.cost_yr = TO_CHAR(a.lst_lodg_port_etd_dt,'YYYY')
--                                                              ), a.cost_wk)
--    WHERE a.cost_yrmon  LIKE p_year || '%'
--      AND a.cost_wk     BETWEEN p_fm_wk AND p_to_wk
--      AND a.rlane_cd    <> 'RBCCO'
--      AND a.mon_tgt_flg <> 'Y'
--      AND a.delt_flg    = 'N'
--      AND a.lst_lodg_port_etd_dt IS NOT NULL
--      AND a.trd_cd      = NVL(p_trd_cd    , a.trd_cd)
--      AND a.rlane_cd    = NVL(p_rlane_cd  , a.rlane_cd)
--      AND a.ioc_cd      = NVL(p_ioc_cd    , a.ioc_cd)
--      AND a.vsl_cd      = NVL(p_vsl_cd    , a.vsl_cd)
--      AND a.skd_voy_no  = NVL(p_skd_voy_no, a.skd_voy_no)
--      AND a.dir_cd      = NVL(p_dir_cd    , a.dir_cd)
--    ;
--    v_mig_msg := 'COST_YRMON, COST_WK를 다시 구해준다.처리건수 : [' || TO_CHAR(SQL%ROWCOUNT) || ']';
--    DBMS_OUTPUT.PUT_LINE(v_mig_msg);

    p_err_cd   := '00000';
    p_err_msg  := 'Completed!';
    DBMS_OUTPUT.PUT_LINE('OK');
--    commit;
-----------------[ 예외처리부            ]-----------------------
   EXCEPTION
     WHEN OTHERS THEN
         p_err_cd     := SQLCODE;
         p_err_msg    := v_mig_msg||'==>'||SQLERRM;
         DBMS_OUTPUT.PUT_LINE('[Modify Target VVD Flag PRC] : Error!! ]' || v_mig_err_msg || '], ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));

END COA_TARGET_VVD_FLG_UPD_PRC;