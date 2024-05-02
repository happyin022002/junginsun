CREATE OR REPLACE PROCEDURE COA_CREATE_NTWK_COST_ALL_PRC (
   in_yr             IN       VARCHAR2   --
  ,in_fm_mon         IN       VARCHAR2   --
  ,in_to_mon         IN       VARCHAR2   --
  ,in_fm_wk          IN       VARCHAR2   --
  ,in_to_wk          IN       VARCHAR2   --
  ,in_mon_or_wk      IN       VARCHAR2   -- M: 월단위 생성, W: 주단위 생성
  ,in_fm_step        IN       VARCHAR2   -- (1~6단계)
  ,in_all_flg        IN       VARCHAR2   -- (Y or N)
  ,in_ind            IN       VARCHAR2   -- 1단계시 COA,BSA 구분 필수
  ,in_mss_chk_flg    IN       VARCHAR2   -- Y: 여러주일때, N: 한주일때
  ,in_trd_cd         IN       VARCHAR2   --
  ,in_rlane_cd       IN       VARCHAR2   --
  ,in_ioc_cd         IN       VARCHAR2   --
  ,in_vsl_cd         IN       VARCHAR2   --
  ,in_skd_voy_no     IN       VARCHAR2   --
  ,in_dir_cd         IN       VARCHAR2   --
  ,in_stnd_cost_cd   IN       VARCHAR2   --
  ,in_user_id        IN       VARCHAR2   -- Input User ID
  ,in_log_lvl        IN       VARCHAR2 DEFAULT '9'
  ,out_err_cd        OUT      VARCHAR2
  ,out_err_msg       OUT      VARCHAR2
) 
Authid current_user
IS
   /******************************************************************************
     1. Purpose      :   Network Cost 모든 단계 생성
     2. Revision History
        1) 2014.06.01 Initial Creation
        2) 2014.11.18 SMY Slot Internal Pricing  
         
         
      EX)
        -- 단계(1:타겟VVD 운항일수, 2:TS QTY, 3:NT[4초] COST 4:CHT. In/Out, 5:CO/CHT Portion, 6:TS 배부)
        DECLARE
           p_error_code   VARCHAR2 (4000);
           p_error_msg    VARCHAR2 (4000);
        BEGIN
           coa_create_ntwk_cost_all_prc ('2008'   -- 기준년
                                        ,NULL -- FROM 월
                                        ,NULL -- TO 월
                                        ,'18'   -- FROM 주
                                        ,'22'   -- TO   주
                                        ,'W' -- WEEK
                                        ,'2'   -- 단계
                                        ,'N'   -- Y: 전단계처리, N: 단계별처리
                                        ,''    -- 1단계시 COA,BSA 구분 필수
                                        ,'Y'   -- Y: Missing check, N: Missing uncheck
                                        ,NULL   -- trd_cd
                                        ,NULL   -- rlane_cd
                                        ,NULL   -- ioc_cd
                                        ,NULL   -- vsl_cd
                                        ,NULL   -- skd_voy_no
                                        ,NULL   -- dir_cd
                                        ,NULL   -- stnd_cost_cd
                                        ,'SYS_COA'   -- usr_id
                                        ,'3'   -- 로그레벨 1: 최하위 ~ 9: 최상위
                                        ,p_error_code
                                        ,p_error_msg
                                        );
           COMMIT;
        END;

        SELECT * FROM ENIS_LOG
        WHERE MOD_NAME = 'COA_CREATE_NTWK_COST_ALL_PRC'
          AND EXEC_DT > SYSDATE - 1/24
        ORDER BY EXEC_DT DESC;


      과제         :
      1. 테스트 완료 후
       -- Log Table 생성
       -- Step Log 기록 및 Error 결과 Log 기록

       


   ******************************************************************************/
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 주차만큼 루프
   -- 200801
   -- 200802
   -- ...
   -- 200805 이렇게 만들어짐
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   CURSOR cost_yrmon_cursor IS
      SELECT in_yr cost_yr
            ,LPAD(cpy_no, 2, '0') cost_mon
            ,NULL cost_wk
        FROM com_cpy_no
       WHERE cpy_no BETWEEN in_fm_mon AND in_to_mon;

   CURSOR cost_yrwk_cursor IS
      SELECT in_yr cost_yr
            ,NULL cost_mon
            ,LPAD(cpy_no, 2, '0') cost_wk
        FROM com_cpy_no
       WHERE cpy_no BETWEEN in_fm_wk AND in_to_wk;

   v_step           VARCHAR2(100);
   v_mss_cnt        NUMBER(10);
   v_log_mod_nm     VARCHAR2(30)  := 'COA_CREATE_NTWK_COST_ALL_PRC';
   v_log_appl_info  VARCHAR2(30)  := '';
   v_start_time     TIMESTAMP;
   v_duration       NUMBER(10) := 0;
   -- 예외의 이름을 선언
   not_completed EXCEPTION;
   v_stnd_cost_interprc_cd VARCHAR2(10) := '5460000%'; -- 2014.11.18 Slot Internal Pricing
BEGIN
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 파라메터 로그 출력
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   enis_log_prc('', v_log_mod_nm, 'START-[V.20141118]', NULL);

   IF (in_log_lvl <= '2') THEN
      v_start_time := SYSTIMESTAMP;
   END IF;

   out_err_msg := out_err_msg || 'W/M: ' || in_mon_or_wk;
   out_err_msg := out_err_msg || ',Year:' || in_yr;
   out_err_msg := out_err_msg || ',Month:' || in_fm_mon || '~' || in_to_mon;
   out_err_msg := out_err_msg || ',Week:' || in_fm_wk || '~' || in_to_wk;
   out_err_msg := out_err_msg || ',' || in_user_id;
   enis_log_prc('', v_log_mod_nm, out_err_msg, NULL);
   out_err_msg := NULL;

   IF (in_log_lvl <= '3') THEN
      enis_log_prc('', v_log_mod_nm, 'in_trd_cd: ' || in_trd_cd, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_rlane_cd: ' || in_rlane_cd, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_ioc_cd: ' || in_ioc_cd, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_vsl_cd: ' || in_vsl_cd, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_skd_voy_no: ' || in_skd_voy_no, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_dir_cd: ' || in_dir_cd, NULL);
      enis_log_prc('', v_log_mod_nm, 'in_stnd_cost_cd: ' || in_stnd_cost_cd, NULL);
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 1단계 : Target VVD/VVD 조정/운항일수
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////

   enis_log_prc('', v_log_mod_nm, 'check point 01 --->', NULL);


   IF (in_fm_step = '1') THEN
     -- ========================================================================================
      v_step := '1. Target VVD/운항일수';
     --//////////////////////////////////////////////////////////////////
     -- 1-1. Target VVD
     --//////////////////////////////////////////////////////////////////
     IF (in_log_lvl <= '3') THEN
        enis_log_prc('', v_log_mod_nm, '1-1. Target VVD', NULL);
     END IF;
     
     SELECT count(*)
       INTO v_duration
       FROM coa_wk_prd
      WHERE cost_yr = in_yr
        AND cost_wk BETWEEN in_fm_wk AND in_to_wk;
     
     v_log_appl_info := '1-1. Target VVD';
     enis_log_prc('', v_log_mod_nm, 'START', v_log_appl_info);
     
     coa_create_target_vvd_prc(in_yr
                              ,in_fm_wk
                              ,v_duration
                              ,in_ind
                              ,in_trd_cd
                              ,in_rlane_cd
                              ,in_ioc_cd
                              ,in_vsl_cd
                              ,in_skd_voy_no
                              ,in_dir_cd
                              ,in_user_id
                              ,out_err_cd
                              ,out_err_msg
                              );
                              
     IF out_err_cd <> '00000' THEN 
        enis_log_prc(SYSDATE, v_log_mod_nm, 'Error! (' || out_err_cd || ')',v_log_appl_info);
        RAISE not_completed;           
           
     ELSE
        enis_log_prc('', v_log_mod_nm, 'END', v_log_appl_info);
     END IF;
     --//////////////////////////////////////////////////////////////////
     -- 1-2. Target VVD FLAG UPDATE
     --//////////////////////////////////////////////////////////////////
     -- 2009.09.14 현재 해당 프로시저 미생성으로 인해 주석 처리 
     IF (in_log_lvl <= '3') THEN
        enis_log_prc('', v_log_mod_nm, '1-2. Target VVD FLAG UPDATE', NULL);
     END IF;
     
     v_log_appl_info := '1-2. Target VVD FLAG UPDATE';
     enis_log_prc('', v_log_mod_nm, 'START', v_log_appl_info);
     
     coa_target_vvd_flg_upd_prc(in_yr
                               ,in_fm_wk
                               ,in_to_wk
                               ,in_trd_cd
                               ,in_rlane_cd
                               ,in_ioc_cd
                               ,in_vsl_cd
                               ,in_skd_voy_no
                               ,in_dir_cd
                               ,in_user_id
                               ,out_err_cd
                               ,out_err_msg
                               );
     enis_log_prc('', v_log_mod_nm, 'END', v_log_appl_info);
     -- ========================================================================================
     
     --//////////////////////////////////////////////////////////////////
     -- 1-3. Operation Days
     --//////////////////////////////////////////////////////////////////
     v_log_appl_info := '1-3. Operation Days';
     enis_log_prc('', v_log_mod_nm, 'START -- in_yr:'||in_yr||',in_fm_wk:'||in_fm_wk||',v_duration:'||v_duration||',in_user_id:'||in_user_id, v_log_appl_info);

     coa_create_operation_days_prc(in_yr, in_fm_wk ,v_duration, in_user_id, out_err_cd, out_err_msg);

     -- Missing 메시지 생성
     v_mss_cnt := 0;

     IF in_mss_chk_flg = 'Y' THEN
        SELECT COUNT(*)
          INTO v_mss_cnt
          FROM coa_mon_vvd a, coa_mon_vvd_port_op_dys b
         WHERE 1 = 1
           AND a.trd_cd = b.trd_cd(+)
           AND a.rlane_cd = b.rlane_cd(+)
           AND a.ioc_cd = b.ioc_cd(+)
           AND a.vsl_cd = b.vsl_cd(+)
           AND a.skd_voy_no = b.skd_voy_no(+)
           AND a.dir_cd = b.dir_cd(+)
           AND a.sls_yrmon LIKE in_yr || '%'
           AND a.cost_wk BETWEEN in_fm_wk AND in_to_wk
           AND a.rlane_cd <> 'RBCCO'
           AND a.delt_flg = 'N'
           AND b.trd_cd IS NULL;
     END IF;

     -- Missing 건수가 존재
     IF (v_mss_cnt > 0) THEN
        out_err_cd := 'CHK01';
        out_err_msg := 'Error     :';
     ELSE
        out_err_msg := 'Completed :';
     END IF;

     out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
     -- Step Log 기록
     enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);

   END IF;

   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 2단계 : TS QTY
   -- (!주의) TS QTY는 Loop을 돌지 않음
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_fm_step = '2') THEN
      v_step := '2. TS QTY';

      IF (in_log_lvl <= '3') THEN
         enis_log_prc('', v_log_mod_nm, v_step, NULL);
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 주단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'W') THEN
         coa_create_ts_qty_prc(
                                in_yr
                               ,NULL   --in_fm_mon
                               ,NULL   --in_to_mon
                               ,in_fm_wk
                               ,in_to_wk
                               ,in_trd_cd
                               ,in_rlane_cd
                               ,in_ioc_cd
                               ,in_vsl_cd
                               ,in_skd_voy_no
                               ,in_dir_cd
                               ,in_user_id
                               ,out_err_cd
                               ,out_err_msg
                               );      
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 월단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'M') THEN
         coa_create_ts_qty_prc(
                                in_yr
                               ,in_fm_mon
                               ,in_to_mon
                               ,NULL   --in_fm_wk
                               ,NULL   --in_to_wk
                               ,in_trd_cd
                               ,in_rlane_cd
                               ,in_ioc_cd
                               ,in_vsl_cd
                               ,in_skd_voy_no
                               ,in_dir_cd
                               ,in_user_id
                               ,out_err_cd
                               ,out_err_msg
                               );
      END IF;

      IF out_err_cd <> '00000' THEN
         out_err_msg := 'Error     :';
      ELSE
         out_err_msg := 'Completed :';
      END IF;

      -- Step Log 기록
      enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 3단계 : Network Cost by VVD > Network Cost
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_fm_step = '3') THEN
      v_step := '3. NT COST';

      IF (in_log_lvl <= '3') THEN
         enis_log_prc('', v_log_mod_nm, v_step, NULL);
      END IF;

      IF (in_mss_chk_flg = 'Y') THEN   -- 여러주 일때
         -- 범위가 한주이상일때는 cre_slct_flg 무시되고 모두 체크한다.
         DELETE FROM coa_ntwk_cost_cre;   -- 항상 row 12개만 생성함

         -- 변동비 : 53*, 고정비 : 54*
         INSERT INTO coa_ntwk_cost_cre
            SELECT   stnd_cost_cd
                    ,(CASE
                         WHEN stnd_cost_cd = '53101000' THEN ''   -- Port Expense
                         WHEN stnd_cost_cd = '53102000' THEN ''   -- CANAL TRANSIT FEE
                         WHEN stnd_cost_cd = '53200000' THEN ''   -- Bunker Exp
                         WHEN stnd_cost_cd = '54100000' THEN 'OWN'   -- Crew Exp
                         WHEN stnd_cost_cd = '54150000' THEN 'OWN'   -- VSL Repair
                         WHEN stnd_cost_cd = '54180000' THEN 'OWN'   -- VSL Telecomm Exp
                         WHEN stnd_cost_cd = '54200000' THEN 'OWN'   -- VSL Store
                         WHEN stnd_cost_cd = '54250000' THEN 'OWN'   -- Insurance
                         WHEN stnd_cost_cd = '54300000' THEN 'OWN'   -- Lubricant Exp
                         WHEN stnd_cost_cd = '54350000' THEN 'CHT'   -- TIME CHARTERAGE
                         WHEN stnd_cost_cd = '54450000' THEN 'OWN'   -- VSL Depreciation
                         WHEN stnd_cost_cd = '54550000' THEN 'OWN'   -- Other Exp
                         ELSE ''
                      END
                     ) AS vsl_oshp_cd   -- vsl ownership
                    ,(CASE
                         WHEN stnd_cost_cd = '53101000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '53102000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() 
                         WHEN stnd_cost_cd = '53200000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54100000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54150000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54180000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54200000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54250000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54300000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54350000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54450000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         WHEN stnd_cost_cd = '54550000' THEN COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()
                         ELSE ''
                      END
                     ) AS vop_cd   -- vsl operation
                    ,'R' AS cre_sts_cd   -- R: Ready, M: Manual, C: Complete
                    ,'Y' AS cre_slct_flg   -- Network Cost by VVD  화면에서 선택한다.
                    ,in_user_id
                    ,SYSDATE
                    ,in_user_id
                    ,SYSDATE
                FROM coa_stnd_acct_v
               WHERE stnd_cost_tp_cd = 'O'   -- O(Other): 기타수익, S(Sale): 영업수익, C:CM, P:OP
                 AND coa_cost_src_prt_cd IN
                                   ('PA', 'CO')   -- CO: COMMON, PA:PERFORMANCE ASSESSMENT, RA: RELATIONSHIP ATTRACTIVENESS
                 AND mgrp_cost_cd in ('OV','OF')
                 AND stnd_cost_cd NOT IN('54400000', '65000000')   -- SC, ABC 제외
            ORDER BY acct_dp_seq;
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 주단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'W') THEN
         FOR cost_yrwk IN cost_yrwk_cursor LOOP
            coa_create_ntcost_prc(cost_yrwk.cost_yr
                                 ,cost_yrwk.cost_mon
                                 ,cost_yrwk.cost_wk
                                 ,in_trd_cd
                                 ,in_rlane_cd
                                 ,in_vsl_cd
                                 ,in_skd_voy_no
                                 ,in_dir_cd
                                 ,in_user_id
                                 ,in_log_lvl
                                 ,out_err_cd
                                 ,out_err_msg
                                 );

            IF (out_err_cd <> '00000') THEN   -- 에러 발생하면
               EXIT;
            END IF;
         END LOOP;

         -- Missing 메시지 생성
         -- Missing 이 발생하면 유저가 Missing 를 다 제거한다.
         v_mss_cnt := 0;

         SELECT COUNT(*)
           INTO v_mss_cnt
           FROM coa_mss_sts
          WHERE 1 = 1
            AND prc_nm = 'COA_CREATE_NTCOST_PRC'
            AND cost_yrwk BETWEEN in_yr || in_fm_wk AND in_yr || in_to_wk;

         -- Missing 건수가 존재
         IF (v_mss_cnt > 0) THEN
            out_err_cd := 'CHK03 : Network Cost';
            out_err_msg := 'Error     :';
         ELSE
            out_err_msg := 'Completed :';
         END IF;

         out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
         -- Missing Log 기록
         enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 월단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'M') THEN
         FOR cost_yrmon IN cost_yrmon_cursor LOOP
            coa_create_ntcost_prc(cost_yrmon.cost_yr
                                 ,cost_yrmon.cost_mon
                                 ,cost_yrmon.cost_wk
                                 ,in_trd_cd
                                 ,in_rlane_cd
                                 ,in_vsl_cd
                                 ,in_skd_voy_no
                                 ,in_dir_cd
                                 ,in_user_id
                                 ,in_log_lvl
                                 ,out_err_cd
                                 ,out_err_msg
                                 );

            IF (out_err_cd <> '00000') THEN   -- 에러 발생하면
               EXIT;
            END IF;
         END LOOP;

         -- Missing 메시지 생성
         -- Missing 이 발생하면 유저가 Missing 를 다 제거한다.
         v_mss_cnt := 0;

         SELECT COUNT(*)
           INTO v_mss_cnt
           FROM coa_mss_sts
          WHERE 1 = 1
            AND prc_nm = 'COA_CREATE_NTCOST_PRC'
            AND cost_yrwk LIKE in_yr || '%'
            AND cost_mon BETWEEN in_fm_mon AND in_to_mon;

         -- Missing 건수가 존재
         IF (v_mss_cnt > 0) THEN
            out_err_cd := 'CHK03 : Network Cost';
            out_err_msg := 'Error     :';
         ELSE
            out_err_msg := 'Completed :';
         END IF;

         out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
         -- Missing Log 기록
         enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);
      END IF;
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 4단계 : Network Cost by VVD > Solt Charter In&Out
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_fm_step = '4') THEN
      v_step := '4. Solt Cht In/Out';

      IF (in_log_lvl <= '3') THEN
         enis_log_prc('', v_log_mod_nm, v_step, NULL);
      END IF;

      IF in_mss_chk_flg = 'Y' THEN
         -- Missing Check를 위한 셋팅
         DELETE FROM coa_slt_chtr_info;   -- 전체 삭제후 3개의 행 생성

         INSERT INTO coa_slt_chtr_info
            SELECT 'J' slt_tp_cd   -- JO 이고 CO
                  ,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC() vop_cd
                  ,NULL incm_bzc_chtr_cd
                  ,NULL incm_sub_lse_cd
                  ,NULL incm_crs_chtr_cd
                  ,NULL expn_bzc_chtr_cd
                  ,NULL expn_sub_chtr_cd
                  ,NULL expn_crs_chtr_cd
                  ,'R' AS op_cre_sts_cd   -- Ready
                  ,'Y' AS cre_slct_flg   -- 화면에서 선택한다.
                  ,in_user_id
                  ,SYSDATE
                  ,in_user_id
                  ,SYSDATE
              FROM DUAL
            UNION ALL
            SELECT 'J' slt_tp_cd   -- JO 이고 OTH
                  ,'OTH' vop_cd
                  ,NULL incm_bzc_chtr_cd
                  ,NULL incm_sub_lse_cd
                  ,NULL incm_crs_chtr_cd
                  ,'C' expn_bzc_chtr_cd
                  ,NULL expn_sub_chtr_cd
                  ,NULL expn_crs_chtr_cd
                  ,'R' AS op_cre_sts_cd   -- Ready
                  ,'Y' AS cre_slct_flg   -- 화면에서 선택한다.
                  ,in_user_id
                  ,SYSDATE
                  ,in_user_id
                  ,SYSDATE
              FROM DUAL
            UNION ALL
            SELECT 'S' slt_tp_cd   -- SC 이고 OTH
                  ,'OTH' vop_cd
                  ,NULL incm_bzc_chtr_cd
                  ,NULL incm_sub_lse_cd
                  ,NULL incm_crs_chtr_cd
                  ,'C' expn_bzc_chtr_cd
                  ,NULL expn_sub_chtr_cd
                  ,NULL expn_crs_chtr_cd
                  ,'R' AS op_cre_sts_cd   -- Ready
                  ,'Y' AS cre_slct_flg   -- 화면에서 선택한다.
                  ,in_user_id
                  ,SYSDATE
                  ,in_user_id
                  ,SYSDATE
              FROM DUAL;
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 주단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'W') THEN
         FOR cost_yrwk IN cost_yrwk_cursor LOOP
            coa_create_spc_cht_prc(cost_yrwk.cost_yr
                                  ,cost_yrwk.cost_mon
                                  ,cost_yrwk.cost_wk
                                  ,in_trd_cd
                                  ,in_rlane_cd
                                  ,in_vsl_cd
                                  ,in_skd_voy_no
                                  ,in_dir_cd
                                  ,in_user_id
                                  ,in_log_lvl
                                  ,out_err_cd
                                  ,out_err_msg
                                  );

            IF (out_err_cd <> '00000') THEN   -- 에러 발생하면
               EXIT;
            END IF;
         END LOOP;

         -- Missing 메시지 생성
         -- Missing 이 발생하면 유저가 Missing 를 다 제거한다.
         v_mss_cnt := 0;

         SELECT COUNT(*)
           INTO v_mss_cnt
           FROM coa_mss_sts
          WHERE 1 = 1
            AND bsa_zr_flg = 'N'
            AND prc_nm = 'COA_CREATE_SPC_CHT_PRC'
            AND cost_yrwk BETWEEN in_yr || in_fm_wk AND in_yr || in_to_wk;

         -- Missing 건수가 존재
         IF (v_mss_cnt > 0) THEN
            out_err_cd := 'CHK04-Solt Cht In/Out';
            out_err_msg := 'Error     :';
         ELSE
            out_err_msg := 'Completed :';
         END IF;

         out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
         -- Missing Log 기록
         enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 월단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'M') THEN
         FOR cost_yrmon IN cost_yrmon_cursor LOOP
            coa_create_spc_cht_prc(cost_yrmon.cost_yr
                                  ,cost_yrmon.cost_mon
                                  ,cost_yrmon.cost_wk
                                  ,in_trd_cd
                                  ,in_rlane_cd
                                  ,in_vsl_cd
                                  ,in_skd_voy_no
                                  ,in_dir_cd
                                  ,in_user_id
                                  ,in_log_lvl
                                  ,out_err_cd
                                  ,out_err_msg
                                  );

            IF out_err_cd <> '00000' THEN
               EXIT;
            END IF;
         END LOOP;

         -- Missing 메시지 생성
         v_mss_cnt := 0;

         SELECT COUNT(*)
           INTO v_mss_cnt
           FROM coa_mss_sts
          WHERE prc_nm = 'COA_CREATE_SPC_CHT_PRC'
            AND bsa_zr_flg = 'N'
            AND cost_yrwk LIKE in_yr || '%'
            AND cost_mon BETWEEN in_fm_mon AND in_to_mon;

         -- Missing 건수가 존재
         IF (v_mss_cnt > 0) THEN
            out_err_cd := 'CHK04-Solt Cht In/Out';
            out_err_msg := 'Error     :';
         ELSE
            out_err_msg := 'Completed :';
         END IF;

         out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
         -- Step Log 기록
         enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);
      END IF; 
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 5단계 : Company Sales/Slot Cht-out
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_fm_step = '5') THEN
      v_step := '5. CO Sales/Slot Cht-out';

      IF (in_log_lvl <= '3') THEN
         enis_log_prc('', v_log_mod_nm, v_step, NULL);
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 주단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'W') THEN
         FOR cost_yrwk IN cost_yrwk_cursor LOOP
            DELETE FROM coa_mss_sts
                  WHERE prc_nm = 'Company Sales/Slot Cht-out'
                    AND cost_yrwk = cost_yrwk.cost_yr || cost_yrwk.cost_wk;

            -- OP1의  Company Sales/Slot Cht-out 진행
            MERGE INTO coa_vvd_hir b1
               USING (SELECT a1.trd_cd
                            ,a1.rlane_cd
                            ,a1.ioc_cd
                            ,a1.vsl_cd
                            ,a1.skd_voy_no
                            ,a1.dir_cd
                            ,a2.stnd_cost_cd
                            ,NVL(a2.ntwk_hir_cost_amt, 0) ntwk_hir_cost_amt   -- NT COST
                            ,CASE
                                WHEN(    NVL(a3.fnl_co_bsa_capa, 0) = 0
                                     AND NVL(a3.co_bsa_capa, 0) = 0) THEN 1
                                ELSE NVL(a3.co_bsa_rto, 0)
                             END co_sls_rto   -- co RATIO
                            ,CASE
                                WHEN(    NVL(a3.fnl_co_bsa_capa, 0) = 0
                                     AND NVL(a3.co_bsa_capa, 0) = 0) THEN 0
                                ELSE NVL(a3.chtr_bsa_rto, 0)
                             END co_rto   -- CO RATIO
                        FROM coa_mon_vvd a1, coa_vvd_hir a2, bsa_vvd_mst a3
                       WHERE a1.trd_cd             = a2.trd_cd
                         AND a1.rlane_cd           = a2.rlane_cd
                         AND a1.ioc_cd             = a2.ioc_cd
                         AND a1.vsl_cd             = a2.vsl_cd
                         AND a1.skd_voy_no         = a2.skd_voy_no
                         AND a1.dir_cd             = a2.dir_cd
                         AND a1.trd_cd             = a3.trd_cd
                         AND a1.rlane_cd           = a3.rlane_cd
                         AND a1.ioc_cd             = a3.ioc_cd
                         AND a1.vsl_cd             = a3.vsl_cd
                         AND a1.skd_voy_no         = a3.skd_voy_no
                         AND a1.dir_cd             = a3.skd_dir_cd
                         AND NVL(a1.delt_flg, 'N') = 'N'
                         AND a1.sub_trd_cd         NOT IN ('IP')
                         AND a2.stnd_cost_cd       NOT LIKE  v_stnd_cost_interprc_cd  -- 2014.11.18 Slot Internal Pricing
                         AND SUBSTR(a1.sls_yrmon,1,4) || a1.cost_wk = cost_yrwk.cost_yr || cost_yrwk.cost_wk
                         AND a1.trd_cd             = NVL(in_trd_cd, a1.trd_cd)
                         AND a1.rlane_cd           = NVL(in_rlane_cd, a1.rlane_cd)
                         AND a1.ioc_cd             = NVL(in_ioc_cd, a1.ioc_cd)
                         AND a1.vsl_cd             = NVL(in_vsl_cd, a1.vsl_cd)
                         AND a1.skd_voy_no         = NVL(in_skd_voy_no, a1.skd_voy_no)
                         AND a1.dir_cd             = NVL(in_dir_cd, a1.dir_cd)) b2
               ON (    b1.trd_cd       = b2.trd_cd
                   AND b1.rlane_cd     = b2.rlane_cd
                   AND b1.ioc_cd       = b2.ioc_cd
                   AND b1.vsl_cd       = b2.vsl_cd
                   AND b1.skd_voy_no   = b2.skd_voy_no
                   AND b1.dir_cd       = b2.dir_cd
                   AND b1.stnd_cost_cd = b2.stnd_cost_cd
                  )
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.co_sls_amt = b2.ntwk_hir_cost_amt * b2.co_sls_rto
                        ,b1.co_amt      = b2.ntwk_hir_cost_amt * b2.co_rto
                        ,b1.upd_usr_id  = in_user_id
                        ,b1.upd_dt      = SYSDATE
                  ;            
   
            MERGE INTO coa_mss_sts a1
               USING (SELECT   *
                          FROM (SELECT   'Company Sales/Slot Cht-out' prc_nm
                                        , SUBSTR(a1.sls_yrmon, 1, 4) || a1.cost_wk cost_yrwk
                                        ,'XX' cost_mon
                                        ,'XXXXXXXX' stnd_cost_cd
                                        ,a1.trd_cd
                                        ,a1.ioc_cd
                                        ,a1.rlane_cd
                                        ,a1.vsl_cd
                                        ,a1.skd_voy_no
                                        ,a1.dir_cd
                                        ,
                                         --/////////////////////////////////////////////////////////
                                         -- IA, NMXAE, bsa_zr_flg = 'Y' 는 Missing 처리 안함
                                         --/////////////////////////////////////////////////////////
                                         CASE
                                            WHEN(   (    a1.trd_cd = 'IAS'
                                                     AND SUBSTR(a1.rlane_cd, -2) = 'IA')                                                 
                                                 OR NVL(a1.bsa_zr_flg, 'N') = 'Y'
                                                ) THEN 'N'
                                            ELSE CASE
                                              WHEN (SUM(NVL(a2.ntwk_hir_cost_amt, 0)) > 0) THEN 'N' -- OP4
                                            ELSE 'Y'
                                         END
                                         END is_mss
                                        ,NVL(a1.bsa_zr_flg, 'N') bsa_zr_flg
                                        ,'Network Cost is 0' cost_calc_rmk
                                    FROM coa_mon_vvd a1, coa_vvd_hir a2
                                   WHERE a1.trd_cd       = a2.trd_cd
                                     AND a1.rlane_cd     = a2.rlane_cd
                                     AND a1.ioc_cd       = a2.ioc_cd
                                     AND a1.vsl_cd       = a2.vsl_cd
                                     AND a1.skd_voy_no   = a2.skd_voy_no
                                     AND a1.dir_cd       = a2.dir_cd
                                     AND a1.sls_yrmon    LIKE cost_yrwk.cost_yr || '%'
                                     AND a1.cost_wk      = cost_yrwk.cost_wk
                                     AND a1.delt_flg     = 'N'
                                     AND a1.sub_trd_cd   NOT IN ('IP')
                                     AND a2.stnd_cost_cd NOT LIKE v_stnd_cost_interprc_cd  -- 2014.11.18 Slot Internal Pricing
                                GROUP BY a1.sls_yrmon
                                        ,a1.cost_wk
                                        ,a1.trd_cd
                                        ,a1.ioc_cd
                                        ,a1.rlane_cd
                                        ,a1.vsl_cd
                                        ,a1.skd_voy_no
                                        ,a1.dir_cd
                                        ,NVL(a1.bsa_zr_flg, 'N'))
                         WHERE is_mss = 'Y'
                            OR bsa_zr_flg = 'Y'
                      ORDER BY is_mss DESC) a2
               ON (a1.prc_nm       = a2.prc_nm
               AND a1.cost_yrwk    = a2.cost_yrwk
               AND a1.cost_mon     = a2.cost_mon
               AND a1.stnd_cost_cd = a2.stnd_cost_cd
               AND a1.trd_cd       = a2.trd_cd
               AND a1.ioc_cd       = a2.ioc_cd
               AND a1.rlane_cd     = a2.rlane_cd
               AND a1.vsl_cd       = a2.vsl_cd
               AND a1.skd_voy_no   = a2.skd_voy_no
               AND a1.dir_cd       = a2.dir_cd)
               WHEN NOT MATCHED THEN
                  INSERT(a1.prc_nm, a1.cost_yrwk, a1.cost_mon, a1.stnd_cost_cd, a1.trd_cd, a1.ioc_cd, a1.rlane_cd
                        ,a1.vsl_cd, a1.skd_voy_no, a1.dir_cd, a1.cost_calc_rmk, a1.bsa_zr_flg, a1.cre_usr_id, a1.cre_dt, a1.upd_usr_id, a1.upd_dt)
                  VALUES(a2.prc_nm, a2.cost_yrwk, a2.cost_mon, a2.stnd_cost_cd, a2.trd_cd, a2.ioc_cd, a2.rlane_cd
                        ,a2.vsl_cd, a2.skd_voy_no, a2.dir_cd, a2.cost_calc_rmk, a2.bsa_zr_flg, in_user_id, SYSDATE, in_user_id, SYSDATE);
         END LOOP;

         -- Missing 메시지 생성
         v_mss_cnt := 0;

         IF in_mss_chk_flg = 'Y' THEN
            SELECT COUNT(*)
              INTO v_mss_cnt
              FROM coa_mss_sts
             WHERE prc_nm = 'Company Sales/Slot Cht-out'
               AND cost_yrwk BETWEEN in_yr || in_fm_wk AND in_yr || in_to_wk
               AND bsa_zr_flg = 'N';
         END IF;
      END IF;

      --/////////////////////////////////////////////////////////////////////////////////////
      -- 월단위 생성
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'M') THEN
         FOR cost_yrmon IN cost_yrmon_cursor LOOP
            DELETE FROM coa_mss_sts
                  WHERE prc_nm = 'Company Sales/Slot Cht-out'
                    AND cost_yrwk = cost_yrmon.cost_yr
                    AND cost_mon = cost_yrmon.cost_mon;

            MERGE INTO coa_vvd_hir b1
               USING (SELECT a1.trd_cd
                            ,a1.rlane_cd
                            ,a1.ioc_cd
                            ,a1.vsl_cd
                            ,a1.skd_voy_no
                            ,a1.dir_cd
                            ,a2.stnd_cost_cd
                            ,NVL(a2.ntwk_hir_cost_amt, 0) ntwk_hir_cost_amt   -- NT COST
                            ,CASE
                                WHEN(    NVL(a3.fnl_co_bsa_capa, 0) = 0
                                     AND NVL(a3.co_bsa_capa, 0) = 0) THEN 1
                                ELSE NVL(a3.co_bsa_rto, 0)
                             END co_sls_rto   -- CO RATIO
                            ,CASE
                                WHEN(    NVL(a3.fnl_co_bsa_capa, 0) = 0
                                     AND NVL(a3.co_bsa_capa, 0) = 0) THEN 0
                                ELSE NVL(a3.chtr_bsa_rto, 0)
                             END co_rto   -- CO RATIO
                        FROM coa_mon_vvd a1, coa_vvd_hir a2, bsa_vvd_mst a3
                       WHERE a1.trd_cd       = a2.trd_cd
                         AND a1.rlane_cd     = a2.rlane_cd
                         AND a1.ioc_cd       = a2.ioc_cd
                         AND a1.vsl_cd       = a2.vsl_cd
                         AND a1.skd_voy_no   = a2.skd_voy_no
                         AND a1.dir_cd       = a2.dir_cd
                         AND a1.trd_cd       = a3.trd_cd
                         AND a1.rlane_cd     = a3.rlane_cd
                         AND a1.ioc_cd       = a3.ioc_cd
                         AND a1.vsl_cd       = a3.vsl_cd
                         AND a1.skd_voy_no   = a3.skd_voy_no
                         AND a1.dir_cd       = a3.skd_dir_cd
                         AND NVL(a1.delt_flg, 'N') = 'N'
                         AND a1.sub_trd_cd   NOT IN ('IP')
                         AND a2.stnd_cost_cd NOT LIKE  v_stnd_cost_interprc_cd -- 2014.11.18 Slot Internal Pricing
                         AND a1.cost_yrmon   LIKE cost_yrmon.cost_yr || cost_yrmon.cost_mon
                         AND a1.trd_cd       = NVL(in_trd_cd, a1.trd_cd)
                         AND a1.rlane_cd     = NVL(in_rlane_cd, a1.rlane_cd)
                         AND a1.ioc_cd       = NVL(in_ioc_cd, a1.ioc_cd)
                         AND a1.vsl_cd       = NVL(in_vsl_cd, a1.vsl_cd)
                         AND a1.skd_voy_no   = NVL(in_skd_voy_no, a1.skd_voy_no)
                         AND a1.dir_cd       = NVL(in_dir_cd, a1.dir_cd)) b2
               ON (b1.trd_cd       = b2.trd_cd
               AND b1.rlane_cd     = b2.rlane_cd
               AND b1.ioc_cd       = b2.ioc_cd
               AND b1.vsl_cd       = b2.vsl_cd
               AND b1.skd_voy_no   = b2.skd_voy_no
               AND b1.dir_cd       = b2.dir_cd
               AND b1.stnd_cost_cd = b2.stnd_cost_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.co_sls_amt = b2.ntwk_hir_cost_amt * b2.co_sls_rto
                        ,b1.co_amt = b2.ntwk_hir_cost_amt * b2.co_rto,b1.upd_usr_id = in_user_id, b1.upd_dt = SYSDATE
                  ;
                  
                 
            MERGE INTO coa_mss_sts a1
               USING (SELECT   *
                          FROM (SELECT   'Company Sales/Slot Cht-out' prc_nm
                                        ,SUBSTR(a1.cost_yrmon, 1, 4) cost_yrwk
                                        ,SUBSTR(a1.cost_yrmon, 5, 2) cost_mon
                                        ,'XXXXXXXX' stnd_cost_cd
                                        ,a1.trd_cd
                                        ,a1.ioc_cd
                                        ,a1.rlane_cd
                                        ,a1.vsl_cd
                                        ,a1.skd_voy_no
                                        ,a1.dir_cd
                                        ,
                                         --/////////////////////////////////////////////////////////
                                         -- IA, NMXAE, bsa_zr_flg = 'Y' 는 Missing 처리 안함
                                         --/////////////////////////////////////////////////////////
                                         CASE
                                            WHEN(   (    a1.trd_cd = 'IAS'
                                                     AND SUBSTR(a1.rlane_cd, -2) = 'IA')
                                                OR NVL(a1.bsa_zr_flg, 'N') = 'Y'
                                                ) THEN 'N'
                                            ELSE CASE
                                              WHEN (SUM(NVL(a2.ntwk_hir_cost_amt, 0)) > 0)  THEN 'N'
                                            ELSE 'Y'
                                         END
                                         END is_mss
                                        ,NVL(a1.bsa_zr_flg, 'N') bsa_zr_flg
                                        ,'Network Cost is 0' cost_calc_rmk
                                    FROM coa_mon_vvd a1, coa_vvd_hir a2
                                   WHERE a1.trd_cd       = a2.trd_cd
                                     AND a1.rlane_cd     = a2.rlane_cd
                                     AND a1.ioc_cd       = a2.ioc_cd
                                     AND a1.vsl_cd       = a2.vsl_cd
                                     AND a1.skd_voy_no   = a2.skd_voy_no
                                     AND a1.dir_cd       = a2.dir_cd
                                     AND a1.delt_flg     = 'N'
                                     AND a1.sub_trd_cd   NOT IN ('IP')
                                     AND a2.stnd_cost_cd NOT LIKE v_stnd_cost_interprc_cd -- 2014.11.18 Slot Internal Pricing
                                     AND a1.cost_yrmon   LIKE cost_yrmon.cost_yr || cost_yrmon.cost_mon
                                GROUP BY a1.cost_yrmon             
                                        ,a1.trd_cd                 
                                        ,a1.ioc_cd                 
                                        ,a1.rlane_cd               
                                        ,a1.vsl_cd                 
                                        ,a1.skd_voy_no             
                                        ,a1.dir_cd                 
                                        ,NVL(a1.bsa_zr_flg, 'N'))  
                         WHERE is_mss = 'Y'                        
                            OR bsa_zr_flg = 'Y'                    
                      ORDER BY is_mss DESC) a2                     
               ON (a1.prc_nm       = a2.prc_nm                     
               AND a1.cost_yrwk    = a2.cost_yrwk                  
               AND a1.cost_mon     = a2.cost_mon                   
               AND a1.stnd_cost_cd = a2.stnd_cost_cd               
               AND a1.trd_cd       = a2.trd_cd                     
               AND a1.ioc_cd       = a2.ioc_cd                     
               AND a1.rlane_cd     = a2.rlane_cd                   
               AND a1.vsl_cd       = a2.vsl_cd                     
               AND a1.skd_voy_no   = a2.skd_voy_no                 
               AND a1.dir_cd       = a2.dir_cd)                    
               WHEN NOT MATCHED THEN                               
                  INSERT(a1.prc_nm                                 
                       , a1.cost_yrwk                              
                       , a1.cost_mon                               
                       , a1.stnd_cost_cd                           
                       , a1.trd_cd                                 
                       , a1.ioc_cd                                 
                       , a1.rlane_cd                               
                       , a1.vsl_cd                                 
                       , a1.skd_voy_no                             
                       , a1.dir_cd                                 
                       , a1.cost_calc_rmk                          
                       , a1.bsa_zr_flg                             
                       , a1.cre_usr_id                             
                       , a1.cre_dt                                 
                       , a1.upd_usr_id                             
                       , a1.upd_dt                                 
                  )VALUES(                                         
                         a2.prc_nm                                 
                       , a2.cost_yrwk                              
                       , a2.cost_mon                               
                       , a2.stnd_cost_cd                           
                       , a2.trd_cd                                 
                       , a2.ioc_cd                                 
                       , a2.rlane_cd                               
                       , a2.vsl_cd                                 
                       , a2.skd_voy_no                             
                       , a2.dir_cd                                 
                       , a2.cost_calc_rmk                          
                       , a2.bsa_zr_flg                             
                       , in_user_id                                
                       , SYSDATE                                   
                       , in_user_id                                
                       , SYSDATE                                   
                  );                                               
         END LOOP;                                                 
                                                                   
         -- Missing 메시지 생성                                    
         v_mss_cnt := 0;                                           
                                                                   
         IF in_mss_chk_flg = 'Y' THEN                              
            SELECT COUNT(*)                                        
              INTO v_mss_cnt                                       
              FROM coa_mss_sts                                     
             WHERE prc_nm = 'Company Sales/Slot Cht-out'               
               AND cost_yrwk = in_yr                               
               AND cost_mon BETWEEN in_fm_mon AND in_to_mon        
               AND bsa_zr_flg = 'N';                               
         END IF;                                                   
      END IF;                                                      
                                                                   
      -- Missing 건수가 존재                                       
      IF (v_mss_cnt > 0) THEN                                      
         out_err_cd := 'CHK05';                                    
         out_err_msg := 'Error     :';                             
      ELSE                                                         
         out_err_cd := '00000';                                    
         out_err_msg := 'Completed :';                             
      END IF;                                                      
                                                                   
      out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;      
      -- Step Log 기록                                             
      enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);         
   END IF;                                                         
                                                                   
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- 6단계 : TS 배부                                              
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_fm_step = '6') THEN                                      
      v_step := '6. TS Allocation';                                
                                                                   
      --/////////////////////////////////////////////////////////////////////////////////////
      -- 주단위 생성                                               
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'W') THEN                                 
         FOR cost_yrwk IN cost_yrwk_cursor LOOP                    
            IF (in_log_lvl <= '3') THEN                            
               enis_log_prc('', v_log_mod_nm, v_step, NULL);       
            END IF;                                                
                                                                   
            coa_create_ts_ctrb_prc(cost_yrwk.cost_yr               
                                  ,cost_yrwk.cost_mon              
                                  ,cost_yrwk.cost_wk               
                                  ,in_trd_cd                       
                                  ,in_rlane_cd                     
                                  ,in_ioc_cd                       
                                  ,in_vsl_cd                       
                                  ,in_skd_voy_no                   
                                  ,in_dir_cd                       
                                  ,in_user_id                      
                                  ,out_err_cd                      
                                  ,out_err_msg                     
                                  );                               
                                                                   
            IF out_err_cd <> '00000' THEN                          
               EXIT;                                               
            END IF;                                                
                                                                   
            -- Missing 메시지 생성                                 
            v_mss_cnt := 0;                                        
                                                                   
            IF in_mss_chk_flg = 'Y' THEN                           
               SELECT SUM(n1st_asgn_amt)                           
                 INTO v_mss_cnt                                    
                 FROM coa_vvd_hir;                                 
            END IF;                                                
                                                                   
            -- Missing 건수가 존재                                 
            IF (v_mss_cnt <> 0) THEN                               
               out_err_cd := 'CHK06';                              
               out_err_msg := 'Error     :';                       
            ELSE                                                   
               out_err_msg := 'Completed :';                       
            END IF;                                                
                                                                   
            out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
            -- Step Log 기록                                       
            enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);   
         END LOOP;                                                 
      END IF;                                                      
                                                                   
      --/////////////////////////////////////////////////////////////////////////////////////
      -- 월단위 생성                                               
      --/////////////////////////////////////////////////////////////////////////////////////
      IF (in_mon_or_wk = 'M') THEN                                 
         FOR cost_yrmon IN cost_yrmon_cursor LOOP                  
            IF (in_log_lvl <= '3') THEN                            
               enis_log_prc('', v_log_mod_nm, v_step, NULL);       
            END IF;                                                
                                                                   
            coa_create_ts_ctrb_prc(cost_yrmon.cost_yr              
                                  ,cost_yrmon.cost_mon             
                                  ,cost_yrmon.cost_wk              
                                  ,in_trd_cd                       
                                  ,in_rlane_cd                     
                                  ,in_ioc_cd                       
                                  ,in_vsl_cd                       
                                  ,in_skd_voy_no                   
                                  ,in_dir_cd                       
                                  ,in_user_id                      
                                  ,out_err_cd                      
                                  ,out_err_msg                     
                                  );                               
                                                                   
            IF out_err_cd <> '00000' THEN                          
               EXIT;                                               
            END IF;                                                
                                                                   
            -- Missing 메시지 생성                                 
            v_mss_cnt := 0;                                        
                                                                   
            IF in_mss_chk_flg = 'Y' THEN                           
               SELECT SUM(n1st_asgn_amt)                           
                 INTO v_mss_cnt                                    
                 FROM coa_vvd_hir;                                 
            END IF;                                                
                                                                   
            -- Missing 건수가 존재                                 
            IF (v_mss_cnt <> 0) THEN                               
               out_err_cd := 'CHK06';                              
               out_err_msg := 'Error     :';                       
            ELSE                                                   
               out_err_msg := 'Completed :';                       
            END IF;                                                
                                                                   
            out_err_msg := out_err_msg || ',Missing:' || v_mss_cnt;
            -- Step Log 기록                                       
            enis_log_prc('', v_log_mod_nm, out_err_msg, v_step);   
         END LOOP;                                                 
      END IF;                                                      
   END IF;                                                         
                                                  
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
   -- END LOG                                                      
   --////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                   
   enis_log_prc('', v_log_mod_nm, 'END', NULL);                    
                                                                   
   IF (in_log_lvl <= '2') THEN                                     
      enis_log_prc('', v_log_mod_nm, '소요시간: ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
   END IF;                                                         
                                                                   
-------------------------------[ 예외처리부      ]-----------------------
EXCEPTION                                                          
   WHEN OTHERS THEN                                                
      enis_log_prc('', v_log_mod_nm, v_step || ' >> ' || SQLERRM, 'ERROR');
      RAISE;                                                       
END COA_CREATE_NTWK_COST_ALL_PRC;