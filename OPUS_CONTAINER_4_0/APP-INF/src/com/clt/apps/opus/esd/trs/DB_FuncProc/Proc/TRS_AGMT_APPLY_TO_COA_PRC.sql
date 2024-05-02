CREATE OR REPLACE PROCEDURE OPUSADM.TRS_AGMT_APLY_TO_COA_PRC(pi_bkg_no        IN COA_COM_PARA.BKG_NO%TYPE,
                                                     pi_start_pctl_no IN COA_COM_PARA.PCTL_NO%TYPE,
                                                     pi_end_pctl_no   IN COA_COM_PARA.PCTL_NO%TYPE,
                                                     pi_debug_flg     IN VARCHAR,
                                                     po_rtn_cd        OUT NUMBER)
AUTHID CURRENT_USER

  IS

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JEONG SANG-KI
  # -- Created : JAN 23, 2007
  # -- Table   : TRS_AGMT_*
  # -- Purpose : SERVICE PROVIDER RATE CALCULATION for COst Assignment.
  # __________________________________________________________________
  # >> SURCHARGE CALCULATION RULE FOR COA <<
  # 1. COA_COST_SRC_CD V8 : RATE TYPE(2) + DETAIL TYPE(2) + Carrior Mode(2)
  #  1-1. TR : BASIC RATE
  #  1-2. SC : Surcharge -> FU/OW
  #   1-2-1. TRS_AGMT_SCG_RT.CURR_CD값이 '%' 이면 1-1에 대한 RATE
  #   1-2-2. TRS_AGMT_SCG_RT.CURR_CD값이 '%' 아니고 CURRENCY CODE이면 FU/OW에 따른 RATE
  #  1-3. SM : Surcharge의 하나로 COA_COM_COST_PARA.BKG_CGO_TP_CD = 'R'(Revenue Empty)인 경우만 해당됨. - 1-2와 동일.
  # __________________________________________________________________
  # >> SURCHARGE CALCULATION RULE FOR TRS <<
  # 1. FUEL SURCHARGE : FUA에서 찾고 없으면 FUE에서 찾는다.
  #  1-1. 동일한 ROUTE에 대한 동일한 RATE
  # 2. OVER WEIGHT SURCHARG
  #  2-1. S/O WEIGHT > TRS_AGMT_SCG_RT.TO_WGT 일경우에 RATE 적용.
  # __________________________________________________________________
  # >> TRANS. MODE = 'WD'/'WR'/'RW'/'WT'/'TW'인경우에 Agreement Pair Type의 Water Receiving Term & Water Delivery Term을 COA에 UPDATE - 2007.03.08 <<
  # Agreement Table_Name : TRS_AGMT_EQ_RT
  # 'WD'      - PAIR ONLY
  # 'WR'      - PAIR + PAIR/distance, DISTANCE/pair, DISTANCE
  # 'RW'      - PAIR ONLY
  # 'WT'      - PAIR ONLY
  # 'TW'      - PAIR ONLY
  # COA Table_Name       : COA_COM_COST_PARA
  #     Column_Name #1      - xxx
  #     Column_Name #2      - xxx
  #####################################################################*/

  /* RETURN CODE DEFINITION */
  /* --------------------------
  # 0   : SUCESS
  -------- FAILURE ------------
  # -1  : FAILURE
  ----------------------------- */

      CHO                CONSTANT VARCHAR2(3)  := 'CO';
      CHR                CONSTANT VARCHAR2(3)  := 'CR';
      THO                CONSTANT VARCHAR2(3)  := 'TO';
      THR                CONSTANT VARCHAR2(3)  := 'TR';

      COA_TR             CONSTANT VARCHAR2(3)  := 'TR';
      COA_SC             CONSTANT VARCHAR2(3)  := 'SC';
      COA_SM             CONSTANT VARCHAR2(3)  := 'TR';

      COA_BZC            CONSTANT VARCHAR2(3)  := 'BZC';
      COA_SC_FU          CONSTANT VARCHAR2(3)  := 'FU';
      COA_SC_OW          CONSTANT VARCHAR2(3)  := 'OW';

      COA_WAY_TP         CONSTANT VARCHAR2(3)  := '';
      C_SCG_TP_DIV                VARCHAR2(1)  := '%';

      v_bound_cd                  VARCHAR2(10) := '';
      v_cost_mod_cd               VARCHAR2(10) := '';
      v_crr_mod_cd                VARCHAR2(10) := '';
      v_fst_vndr_seq              NUMBER(6)    := 0;
      v_snd_vndr_seq              NUMBER(6)    := 0;
      v_trd_vndr_seq              NUMBER(6)    := 0;
      v_ctrl_ofc_cd               VARCHAR2(10) := '';
      v_basis_dt                  DATE         := SYSDATE;
      v_from_nod_cd               VARCHAR2(7)  := '';
      v_via_nod_cd                VARCHAR2(7)  := '';
      v_door_nod_cd               VARCHAR2(7)  := '';
      v_to_nod_cd                 VARCHAR2(7)  := '';
      v_cust_nomi_trkr_flg        VARCHAR2(1)  := '';
      v_cust_cnt_cd               VARCHAR2(10) := '';
      v_cust_seq                  NUMBER(6)    := 0;
      v_cmdt_cd                   VARCHAR2(10) := '';
      v_cgo_tp_cd                 VARCHAR2(10) := '';
      v_wgt_uom                   VARCHAR2(10) := '';
      v_wgt_qty                   NUMBER(18,3) := 0;

      v_rail_svc_tp_cd            VARCHAR2(10) := '';
      v_1st_rail_crr_tp_cd        VARCHAR2(2)  := '';     /* CO, CR, TO, TR     */
      v_2nd_rail_crr_tp_cd        VARCHAR2(2)  := '';     /* CO, CR, TO, TR     */
      v_3rd_rail_crr_tp_cd        VARCHAR2(2)  := '';     /* CO, CR, TO, TR     */

      v_rcv_term_cd               VARCHAR2(10) := '';
      v_de_term_cd                VARCHAR2(10) := '';

      v_trs_agmt_rt_knd           VARCHAR2(5)  := '';     /* BZC, SCG Indicator */

      /* US IRG 변경에 따른 추가 : 2007/04/24      */
      v_1st_trsp_agmt_ofc_cty_cd  TRS_AGMT_EQ_RT.TRSP_AGMT_OFC_CTY_CD%TYPE   ;
      v_1st_trsp_agmt_seq         TRS_AGMT_EQ_RT.TRSP_AGMT_SEQ%TYPE          ;
      v_2nd_trsp_agmt_ofc_cty_cd  TRS_AGMT_EQ_RT.TRSP_AGMT_OFC_CTY_CD%TYPE   ;
      v_2nd_trsp_agmt_seq         TRS_AGMT_EQ_RT.TRSP_AGMT_SEQ%TYPE          ;
      v_3rd_trsp_agmt_ofc_cty_cd  TRS_AGMT_EQ_RT.TRSP_AGMT_OFC_CTY_CD%TYPE   ;
      v_3rd_trsp_agmt_seq         TRS_AGMT_EQ_RT.TRSP_AGMT_SEQ%TYPE          ;

      v_tmp_trsp_agmt_ofc_cty_cd  TRS_AGMT_EQ_RT.TRSP_AGMT_OFC_CTY_CD%TYPE   ;
      v_tmp_trsp_agmt_seq         TRS_AGMT_EQ_RT.TRSP_AGMT_SEQ%TYPE          ;

      v_agmt_ref_1st_no           TRS_AGMT_HDR.AGMT_REF_NO%TYPE              ;
      v_agmt_ref_2nd_no           TRS_AGMT_HDR.AGMT_REF_NO%TYPE              ;
      v_agmt_ref_3rd_no           TRS_AGMT_HDR.AGMT_REF_NO%TYPE              ;

      v_tmp_agmt_ref_no           TRS_AGMT_HDR.AGMT_REF_NO%TYPE              ;

      /* US IRG 변경에 따른 추가 : 2007/04/24      */

      link_cnt                    NUMBER(1)    := 0;

      C_SYSTEM_INDICATOR CONSTANT VARCHAR2(3)  := 'COA';

      /* PRIMARY KEY */
      v_pctl_no                   COA_COM_COST_PARA.PCTL_NO%TYPE             ;
      v_cost_act_grp_seq          COA_COM_COST_PARA.COST_ACT_GRP_SEQ%TYPE    ;
      v_cntr_tpsz_cd              COA_COM_COST_PARA.CNTR_TPSZ_CD%TYPE        ;
      v_coa_cost_src_cd           COA_COM_COST_PARA.COA_COST_SRC_CD%TYPE     ;

      /* TRS RATE CAL PROCEDURE - OUTPUT PARAMETER */
      vo_way_type                 VARCHAR2(3)  := '';
      vo_curr_cd                  VARCHAR2(3)  := '';
      vo_final_rt                 NUMBER(18,3) := 0;

      vo_wtr_rcv_term_cd          TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE        ;
      vo_wtr_de_term_cd           TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE         ;

      vo_fuel_scg_rt              NUMBER(18,3) := 0;
      vo_fuel_scg_rt_tp           VARCHAR2(3)  := '';
      vo_over_wgt_scg_rt          NUMBER(18,3) := 0;
      vo_over_wgt_scg_rt_tp       VARCHAR2(3)  := '';
      vo_rt_cal_rtn_cd            NUMBER(18,3) := 0;
      vo_rt_cal_rtn_msg           VARCHAR2(100):= '';

      vo_basic_rt_rtn_cd          NUMBER        ;
      vo_scg_rt_rtn_cd            NUMBER        ;

      /* TEMPORAY VARIABLES */
      v_tmp_from_nod_cd           VARCHAR2(7)  := '';
      v_tmp_via_nod_cd            VARCHAR2(7)  := '';
      v_tmp_door_nod_cd           VARCHAR2(7)  := '';
      v_tmp_to_nod_cd             VARCHAR2(7)  := '';

      v_tmp_1st_nod_cd            VARCHAR2(7)  := '';
      v_tmp_2nd_nod_cd            VARCHAR2(7)  := '';
      v_tmp_3rd_nod_cd            VARCHAR2(7)  := '';
      v_tmp_4th_nod_cd            VARCHAR2(7)  := '';

      v_coa_tmp_1st_nod_cd        VARCHAR2(7)  := '  ';
      v_coa_tmp_2nd_nod_cd        VARCHAR2(7)  := '  ';
      v_coa_tmp_3rd_nod_cd        VARCHAR2(7)  := '  ';
      v_coa_tmp_4th_nod_cd        VARCHAR2(7)  := '  ';

      vo_basic_rate_tmp           NUMBER(18,3) := 0;
      vo_scg_rate_tmp             NUMBER(18,3) := 0;
      vo_fuel_scg_rate_tmp        NUMBER(18,3) := 0;
      vo_ovw_scg_rate_tmp         NUMBER(18,3) := 0;
      vo_hzm_scg_rate_tmp         NUMBER(18,3) := 0;
      vo_ttl_scg_rate_tmp         NUMBER(18,3) := 0;
      vo_local_curr_tot_amt       NUMBER(18,3) := 0;
      vo_usd_curr_tot_amt         NUMBER(18,3) := 0;

      v_vndr_seq                  NUMBER(6)    := 0;
      v_vndr_eff_flag             VARCHAR2(1)  := '';           /* Y : S/P Effective, N : S/P Non-Effective */

      vo_scg_cd                   VARCHAR2(5)  := '';
      vo_trsp_agmt_rt_tp_nm       VARCHAR2(50);
      vo_sp_type                  VARCHAR2(10);
      debug_flg                   VARCHAR2(1);

      /* TRS AGREEMENT SEARCH DEFAULT KEY FROM FINDING OUT BASIC RATE CALCULATION */
      vo_trsp_agmt_ofc_cty_cd     TRS_AGMT_EQ_RT.TRSP_AGMT_OFC_CTY_CD%TYPE    ;
      vo_trsp_agmt_seq            TRS_AGMT_EQ_RT.TRSP_AGMT_SEQ%TYPE           ;
      vo_trsp_agmt_rt_tp_seq_no   TRS_AGMT_EQ_RT.TRSP_AGMT_RT_TP_SER_NO%TYPE  ;

      vo_trsp_scg_cd              TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE           ;
      vo_trsp_agmt_scg_seq        TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE ;

      vo_scg_union_exp            VARCHAR2(50)                                ;

      vo_vndr_seq                 TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE            ;
      vo_cust_nomi_trkr_flg       TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE      ;
      vo_cust_cnt_cd              TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE             ;
      vo_cust_seq                 TRS_AGMT_RT_TP.CUST_SEQ%TYPE                ;
      vo_trsp_agmt_rt_tp_cd       TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE      ;

      vo_process_rslt_msg         VARCHAR2(1000)                              ;

      v_tmp_outer_loop_cnt        NUMBER       := 0                           ;

      v_rtn_cd                    NUMBER       := 0                           ;
      v_trsp_agmt_ofc_cty_cd      TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE    ;
      v_trsp_agmt_seq             TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE           ;
      v_spcl_cgo_cntr_tp_cd       VARCHAR2(5)  := ''                          ;

      CURSOR TRS_AGMT_RATE_CSR IS

        SELECT Y.COST_ACT_GRP_CD                                                                  /* ACTIVITY GROUP CODE          */
             , DECODE(SUBSTR(Y.COST_ACT_GRP_CD,1,1),'I','I','O','O','') BOUND_CD                  /* BOUND CD I/O/T               */
             , CASE
                 WHEN Y.COST_ACT_GRP_CD = 'TRWD' OR SUBSTR(Y.COST_ACT_GRP_CD,1,1) = 'P' THEN 'CY' /* TS -->> PR(E)+PO(ST) 구분됨. */
                 ELSE CASE SUBSTR(Y.COST_ACT_GRP_CD,2,1)
                        WHEN 'D' THEN 'DR'
                        WHEN 'Y' THEN 'CY'
                        ELSE ''
                      END
               END COST_MODE_CD                                                                   /* COST MODE CODE D/Y           */
             , SUBSTR(Y.COST_ACT_GRP_CD,3,2) TRSP_CRR_MOD_CD                                      /* TRANSPORTATION MODE CODE     */
             , Y.N1ST_VNDR_SEQ FST_VNDR_SEQ                                                       /* SERVICE PROVIDER             */
             , Y.N2ND_VNDR_SEQ SND_VNDR_SEQ
             , Y.N3RD_VNDR_SEQ TRD_VNDR_SEQ
             , Y.CTRL_OFC_CD                                                                      /* CONTROL OFFICE CODE          */
             , NVL(Y.N1ST_ESTM_DT,SYSDATE) BASIS_DT                                               /* APPLY BASIS TIME             */
             , Y.N1ST_NOD_CD FROM_NOD_CD                                                          /* ROUTE - FROM NODE            */
             , CASE LENGTH(Y.N4TH_NOD_CD)
                 WHEN 7 THEN CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1)
                               WHEN 'I' THEN Y.N2ND_NOD_CD
                               WHEN 'O' THEN Y.N3RD_NOD_CD
                               ELSE ''
                             END
                 ELSE CASE SUBSTR(Y.COST_ACT_GRP_CD,2,1)
                        WHEN 'D' THEN ''
                        ELSE CASE LENGTH(Y.N3RD_NOD_CD)
                               WHEN 7 THEN Y.N2ND_NOD_CD
                               ELSE ''
                             END
                        END
               END VIA_NOD_CD                                                                     /* ROUTE - VIA NODE             */
             , CASE LENGTH(Y.N4TH_NOD_CD)
                 WHEN 7 THEN CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1)
                               WHEN 'I' THEN Y.N3RD_NOD_CD
                               WHEN 'O' THEN Y.N2ND_NOD_CD
                               ELSE ''
                             END
                 ELSE CASE SUBSTR(Y.COST_ACT_GRP_CD,2,1)
                        WHEN 'D' THEN Y.N2ND_NOD_CD
                        ELSE ''
                      END
               END DOOR_NOD_CD                                                                    /* ROUTE - DOOR NODE            */
             , CASE LENGTH(Y.N4TH_NOD_CD)
                 WHEN 7 THEN Y.N4TH_NOD_CD
                 ELSE CASE LENGTH(Y.N3RD_NOD_CD)
                        WHEN 7 THEN Y.N3RD_NOD_CD
                        ELSE Y.N2ND_NOD_CD
                      END
               END TO_NOD_CD                                                                      /* ROUTE - TO NODE              */
             , Y.CUST_NOMI_TRKR_FLG
             , CASE
                 WHEN Y.CUST_NOMI_TRKR_FLG = 'Y' THEN CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1)
                                                        WHEN 'I' THEN X.CNEE_CNT_CD
                                                        WHEN 'O' THEN X.SHPR_CNT_CD
                                                        ELSE ''
                                                      END
                 ELSE ''
               END CUST_CNT_CD                                                                    /* CNT CUSTOMER CNT CODE        */
             , CASE
                 WHEN Y.CUST_NOMI_TRKR_FLG = 'Y' THEN CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1)
                   WHEN 'I' THEN X.CNEE_SEQ
                   WHEN 'O' THEN X.SHPR_SEQ
                   ELSE 0
                 END
                 ELSE 0
               END CUST_SEQ                                                                       /* CNT CUSTOMER SEQ             */
             , X.CMDT_CD                                                                          /* COMMODITY CODE               */
             , Y.CNTR_TPSZ_CD                                                                     /* PRIMARY KEY COLUMN #3        */ /* EQ TYPE SIZE CODE */
--             TODO 2016.03.11 S.W. KIM
--             , 'F' CGO_TP_CD
             , DECODE(X.BKG_CGO_TP_CD, 'R', 'M', NVL(X.BKG_CGO_TP_CD, 'F')) CGO_TP_CD            /* COA_COM_COST_PARA.BKG_CGO_TP_CD = 'R'(Revenue Empty)인 경우 Empty Rate 적용 */
             , X.BKG_WGT_UT_CD AS BKG_WGT_UT_CD
             , NVL((SELECT TO_NUMBER(TRIM(REGEXP_SUBSTR(TRS_GET_COM_SO_RAIL_WGT_FNC('C', null, null, null, A.BKG_NO, A.CNTR_NO, A.CNTR_TPSZ_CD, 'LBS'), '[^|]+', 1, 1)))
                          FROM SCE_COP_HDR A
                         WHERE A.COP_NO = X.PCTL_NO),0) AS BKG_WGT
             , CASE SUBSTR(Y.COST_ACT_GRP_CD,3, 2)
                 WHEN 'RD' THEN SUBSTR(Y.RAIL_SVC_TP_CD,1,1)||SUBSTR(Y.RAIL_SVC_TP_CD,3,1)
                 ELSE ''
               END RAIL_SVC_TP_CD                                                                 /* RAIL SERVICE TYPE CODE CO/CR/TO/TR - CRR MODE = 'RD' 일때만 존재. */
             , SUBSTR(Y.N1ST_RAIL_CRR_TP_CD,1,2) N1ST_RAIL_CRR_TP_CD
             , SUBSTR(Y.N2ND_RAIL_CRR_TP_CD,1,2) N2ND_RAIL_CRR_TP_CD
             , SUBSTR(Y.N3RD_RAIL_CRR_TP_CD,1,2) N3RD_RAIL_CRR_TP_CD
             , Y.PCTL_NO                                                                          /* PRIMARY KEY COLUMN #1        */
             , Y.COST_ACT_GRP_SEQ                                                                 /* PRIMARY KEY COLUMN #2        */
             , Y.COA_COST_SRC_CD                                                                  /* PRIMARY KEY COLUMN #4        */ /* COA COST CODE : TR-basic/SC-surcharge */
             , DECODE(LENGTH(Y.N4TH_NOD_CD),7,3,DECODE(LENGTH(Y.N3RD_NOD_CD),7,2,1)) LINK_CNT
             , CASE SUBSTR(Y.COA_COST_SRC_CD,1,2)
                 WHEN 'TR' THEN 'BZC'
                 WHEN 'SC' THEN CASE SUBSTR(Y.COA_COST_SRC_CD,3,2)
                                  WHEN 'FA' THEN 'FU'
                                  WHEN 'FC' THEN 'FU'
                  WHEN 'FU' THEN 'FU'
                                  WHEN 'OW' THEN 'OW'
                                  ELSE 'AD'
                                END
                 WHEN 'SM' THEN CASE SUBSTR(Y.COA_COST_SRC_CD,3,2)
                                  WHEN 'FA' THEN 'FU'
                                  WHEN 'FC' THEN 'FU'
                  WHEN 'FU' THEN 'FU'
                                  WHEN 'OW' THEN 'OW'
                                  ELSE 'AD'
                                END
                 ELSE ''
               END TRS_AGMT_RT_KND
             , Y.N1ST_NOD_CD
             , Y.N2ND_NOD_CD
             , Y.N3RD_NOD_CD
             , Y.N4TH_NOD_CD
             , Y.N1ST_TRSP_AGMT_OFC_CTY_CD AGMT_OFC_CTY_1ST_CD
             , Y.N1ST_TRSP_AGMT_SEQ AGMT_1ST_SEQ
             , Y.N2ND_TRSP_AGMT_OFC_CTY_CD AGMT_OFC_CTY_2ND_CD
             , Y.N2ND_TRSP_AGMT_SEQ AGMT_2ND_SEQ
             , Y.N3RD_TRSP_AGMT_OFC_CTY_CD AGMT_OFC_CTY_3RD_CD
             , Y.N3RD_TRSP_AGMT_SEQ AGMT_3RD_SEQ
             , CASE
                 WHEN SUBSTR(Y.CNTR_TPSZ_CD,0,1)='R' AND X.SOC_FLG='Y' AND X.RF_SPCL_FLG='N' THEN 'RD'
                 WHEN SUBSTR(Y.CNTR_TPSZ_CD,0,1)='R' AND X.RD_SPCL_FLG='Y' THEN 'RD'
                 WHEN DG_SPCL_FLG = 'Y' THEN 'DG'
                 ELSE 'GP'
               END SPCL_CGO_CNTR_TP_CD
          FROM COA_COM_PARA X
             , COA_COM_COST_PARA Y
         WHERE X.PCTL_NO = Y.PCTL_NO
           AND Y.COST_SRC_SYS_CD = 'TRS'
           AND Y.COST_ASS_BSE_CD = 'C'
           AND NVL(X.BKG_NO , 'N/A') = NVL(pi_bkg_no , 'N/A')
           AND X.PCTL_NO BETWEEN pi_start_pctl_no AND pi_end_pctl_no ;

  BEGIN
  /*===================================================================================
  * BILLING PATTERN CODE (COMBINED THROUGH TYPE CODE)
  * ----------- [W/O ISSUED TO] ---- [INVOICE RECEIVED FROM] --- [Invoice S/P Count]
  * S1R     :   A                    A                                    1
  * C2T     :   A                    A                                    1
  * C3T     :   A                    A                                    1
  * C2R     :   A                    A,B                                  2
  * C3R     :   A                    A,B,C                                3
  * S2R     :   A,B                  A,B                                  2
  * S3R     :   A,B,C                A,B,C                                3
  * C2C     :   A                    B(+A)                                1
  * C3S     :   A                    B(+A),C                              2
  -------------------------------------------------------------------------------------
  * TRUCK   :   1
  *====================================================================================*/

      /** 초기값 설정 **/
      debug_flg := pi_debug_flg;
      IF debug_flg <> 'Y' THEN
        debug_flg := 'N';
      END IF;

      /* LOG */
      IF debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('[TRS_AGMT_APPLY_TO_COA] : Started (Input Parameter - ' || pi_start_pctl_no || ', ' || pi_end_pctl_no || '), ****************' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
      END IF;

      FOR AGMT_RATE_LIST IN TRS_AGMT_RATE_CSR LOOP

          v_tmp_outer_loop_cnt := v_tmp_outer_loop_cnt + 1;
          IF debug_flg = 'Y' THEN
              DBMS_OUTPUT.PUT_LINE('________________________________________________________________________________');
              DBMS_OUTPUT.PUT_LINE('_____________________________ OUTER LOOP COUNT = ['||v_tmp_outer_loop_cnt||'] ___________________________');
          END IF;

          v_ctrl_ofc_cd       := AGMT_RATE_LIST.CTRL_OFC_CD        ;
          v_fst_vndr_seq      := AGMT_RATE_LIST.FST_VNDR_SEQ       ;
          v_snd_vndr_seq      := AGMT_RATE_LIST.SND_VNDR_SEQ       ;
          v_trd_vndr_seq      := AGMT_RATE_LIST.TRD_VNDR_SEQ       ;
          v_basis_dt          := AGMT_RATE_LIST.BASIS_DT           ;
          v_crr_mod_cd        := AGMT_RATE_LIST.TRSP_CRR_MOD_CD    ;
          v_cost_mod_cd       := AGMT_RATE_LIST.COST_MODE_CD       ;
          v_bound_cd          := AGMT_RATE_LIST.BOUND_CD           ;
          v_cntr_tpsz_cd      := AGMT_RATE_LIST.CNTR_TPSZ_CD       ;
          v_cgo_tp_cd         := AGMT_RATE_LIST.CGO_TP_CD          ;
          v_from_nod_cd       := AGMT_RATE_LIST.FROM_NOD_CD        ;
          v_via_nod_cd        := AGMT_RATE_LIST.VIA_NOD_CD         ;
          v_door_nod_cd       := AGMT_RATE_LIST.DOOR_NOD_CD        ;
          v_to_nod_cd         := AGMT_RATE_LIST.TO_NOD_CD          ;
          v_cust_nomi_trkr_flg:= AGMT_RATE_LIST.CUST_NOMI_TRKR_FLG ;
          v_cust_cnt_cd       := AGMT_RATE_LIST.CUST_CNT_CD        ;
          v_cust_seq          := AGMT_RATE_LIST.CUST_SEQ           ;
          v_1st_rail_crr_tp_cd:= AGMT_RATE_LIST.N1ST_RAIL_CRR_TP_CD;     /* CHO, CHR, THO, THR     */
          v_2nd_rail_crr_tp_cd:= AGMT_RATE_LIST.N2ND_RAIL_CRR_TP_CD;     /* CHO, CHR, THO, THR     */
          v_3rd_rail_crr_tp_cd:= AGMT_RATE_LIST.N3RD_RAIL_CRR_TP_CD;     /* CHO, CHR, THO, THR     */

          v_cmdt_cd           := AGMT_RATE_LIST.CMDT_CD            ;
          v_wgt_uom           := AGMT_RATE_LIST.BKG_WGT_UT_CD      ;
          v_wgt_qty           := AGMT_RATE_LIST.BKG_WGT            ;

          v_pctl_no           := AGMT_RATE_LIST.PCTL_NO            ;
          v_cost_act_grp_seq  := AGMT_RATE_LIST.COST_ACT_GRP_SEQ   ;
          v_coa_cost_src_cd   := AGMT_RATE_LIST.COA_COST_SRC_CD    ;

          link_cnt            := AGMT_RATE_LIST.LINK_CNT           ;

          v_trs_agmt_rt_knd   := AGMT_RATE_LIST.TRS_AGMT_RT_KND    ;

          /* US IRG 변경에 따른 추가 : 2007/04/24      */
          v_1st_trsp_agmt_ofc_cty_cd     := AGMT_RATE_LIST.AGMT_OFC_CTY_1ST_CD      ;
          v_1st_trsp_agmt_seq            := AGMT_RATE_LIST.AGMT_1ST_SEQ             ;
          v_2nd_trsp_agmt_ofc_cty_cd     := AGMT_RATE_LIST.AGMT_OFC_CTY_2ND_CD      ;
          v_2nd_trsp_agmt_seq            := AGMT_RATE_LIST.AGMT_2ND_SEQ             ;
          v_3rd_trsp_agmt_ofc_cty_cd     := AGMT_RATE_LIST.AGMT_OFC_CTY_3RD_CD      ;
          v_3rd_trsp_agmt_seq            := AGMT_RATE_LIST.AGMT_3RD_SEQ             ;

          v_tmp_1st_nod_cd               := AGMT_RATE_LIST.N1ST_NOD_CD              ;
          v_tmp_2nd_nod_cd               := AGMT_RATE_LIST.N2ND_NOD_CD              ;
          v_tmp_3rd_nod_cd               := AGMT_RATE_LIST.N3RD_NOD_CD              ;
          v_tmp_4th_nod_cd               := AGMT_RATE_LIST.N4TH_NOD_CD              ;

          IF LENGTH(v_tmp_1st_nod_cd) > 0 THEN
            v_coa_tmp_1st_nod_cd           := AGMT_RATE_LIST.N1ST_NOD_CD              ;
          END IF;
          IF LENGTH(v_tmp_2nd_nod_cd) > 0 THEN
            v_coa_tmp_2nd_nod_cd           := AGMT_RATE_LIST.N2ND_NOD_CD              ;
          END IF;
          IF LENGTH(v_tmp_3rd_nod_cd) > 0 THEN
            v_coa_tmp_3rd_nod_cd           := AGMT_RATE_LIST.N3RD_NOD_CD              ;
          END IF;
          IF LENGTH(v_tmp_4th_nod_cd) > 0 THEN
            v_coa_tmp_4th_nod_cd           := AGMT_RATE_LIST.N4TH_NOD_CD              ;
          END IF;

          /* US IRG 변경에 따른 추가 : 2007/04/24      */

          /************************************************************************************************************
           pi_pair_dist_indicator VARCHAR2   -- P : PAIR, D : DISTANCE
         , pi_eq_knd_cd           VARCHAR2   -- U : Container, Z : CHassis, G : Genset
         , pi_cgo_tp_cd           VARCHAR2   -- F : Full, M : EMpty
         , pi_eq_tpsz_cd          VARCHAR2   -- D2, R2, F?, ...
         , pi_cmb_tp_cd           VARCHAR2   -- BD : Bundle, CF : Combined Case One, FF : Full+Full, FM : Full_Empty
         , pi_cost_mod_cd         VARCHAR2   -- DR : Door
          **************************************************************************************************************/

          v_tmp_from_nod_cd       := AGMT_RATE_LIST.FROM_NOD_CD     ;
          v_tmp_via_nod_cd        := AGMT_RATE_LIST.VIA_NOD_CD      ;
          v_tmp_door_nod_cd       := AGMT_RATE_LIST.DOOR_NOD_CD     ;
          v_tmp_to_nod_cd         := AGMT_RATE_LIST.TO_NOD_CD       ;
          v_spcl_cgo_cntr_tp_cd   := AGMT_RATE_LIST.SPCL_CGO_CNTR_TP_CD;

          vo_rt_cal_rtn_cd := 0;

          /* FINAL TOTAL RATE INITIALIZE */
          vo_final_rt := 0;

          IF debug_flg = 'Y' THEN
            DBMS_OUTPUT.put_line('______________________________ <<< COA AGMT 적용대상 >>> 분기하는 값 <<<'||vo_rt_cal_rtn_cd||' ______________________________');
          END IF;

          IF vo_rt_cal_rtn_cd = 0 THEN
              /* US RAIL BILLING : S/P RATE */
              IF v_crr_mod_cd = 'RD' AND ( v_1st_rail_crr_tp_cd = CHO OR v_1st_rail_crr_tp_cd = CHR OR v_1st_rail_crr_tp_cd = THO OR v_1st_rail_crr_tp_cd = THR) THEN

                  v_vndr_eff_flag := 'Y';

                  /* LINK ... FOR LOOP START */
                  FOR i IN 1..link_cnt LOOP
                      IF i = 1 THEN
                          v_from_nod_cd       := v_tmp_1st_nod_cd  ;
                          v_via_nod_cd        := ''                ;
                          v_door_nod_cd       := ''                ;
                          v_to_nod_cd         := v_tmp_2nd_nod_cd  ;

                          v_vndr_seq          := v_fst_vndr_seq       ;
                          v_rail_svc_tp_cd    := v_1st_rail_crr_tp_cd ;

                          v_tmp_trsp_agmt_ofc_cty_cd   := v_1st_trsp_agmt_ofc_cty_cd ;
                          v_tmp_trsp_agmt_seq          := v_1st_trsp_agmt_seq        ;

                      ELSIF i = 2 THEN
                          v_from_nod_cd       := v_tmp_2nd_nod_cd  ;
                          v_via_nod_cd        := ''                ;
                          v_door_nod_cd       := ''                ;
                          v_to_nod_cd         := v_tmp_3rd_nod_cd ;

                          v_vndr_seq          := v_snd_vndr_seq       ;
                          v_rail_svc_tp_cd    := v_2nd_rail_crr_tp_cd ;

                          v_tmp_trsp_agmt_ofc_cty_cd   := v_2nd_trsp_agmt_ofc_cty_cd ;
                          v_tmp_trsp_agmt_seq          := v_2nd_trsp_agmt_seq        ;

                      ELSIF i = 3 THEN
                          v_from_nod_cd       := v_tmp_3rd_nod_cd ;
                          v_via_nod_cd        := ''               ;
                          v_door_nod_cd       := ''               ;
                          v_to_nod_cd         := v_tmp_4th_nod_cd ;

                          v_vndr_seq          := v_trd_vndr_seq       ;
                          v_rail_svc_tp_cd    := v_3rd_rail_crr_tp_cd ;

                          v_tmp_trsp_agmt_ofc_cty_cd   := v_3rd_trsp_agmt_ofc_cty_cd ;
                          v_tmp_trsp_agmt_seq          := v_3rd_trsp_agmt_seq        ;
                      END IF;

                      TRS_AGMT_RATE_CC_PKG.GET_TRS_ALL_RATE_PRC
                      (
                            v_ctrl_ofc_cd          /* Pair - X , Distance - Mandatory */
                          , v_vndr_seq
                          , v_basis_dt
                          , COA_WAY_TP             /* way type code - Only ONEWAY     */
                          , 'U'                    /* EQ TYPE */
                          , v_cntr_tpsz_cd
                          , ''                     /* COMBINED TYPE CODE */
                          , v_cgo_tp_cd
                          , v_bound_cd
                          , v_crr_mod_cd
                          , v_cost_mod_cd
                          , v_cust_nomi_trkr_flg
                          , v_cust_cnt_cd
                          , v_cust_seq
                          , v_rail_svc_tp_cd
                          , v_cmdt_cd
                          , v_from_nod_cd
                          , v_via_nod_cd
                          , v_door_nod_cd
                          , v_to_nod_cd
                          , 0                    /* COUNT OF BUNDLING */
                          , v_wgt_uom
                          , v_wgt_qty
                          , ''  /* pi_rcv_term */
                          , ''  /* pi_de_term */
                          , v_tmp_trsp_agmt_ofc_cty_cd
                          , v_tmp_trsp_agmt_seq
                          , v_spcl_cgo_cntr_tp_cd
                          , debug_flg /* pi_debug_flg   */
                          , vo_trsp_agmt_ofc_cty_cd
                          , vo_trsp_agmt_seq
                          , vo_trsp_agmt_rt_tp_cd
                          , vo_way_type
                          , vo_trsp_agmt_rt_tp_nm  /* po_trsp_agmt_rt_tp_nm */
                          , vo_sp_type /* po_sp_type */
                          , vo_cust_nomi_trkr_flg
                          , vo_cust_cnt_cd
                          , vo_cust_seq
                          , vo_curr_cd
                          , vo_basic_rate_tmp
                          , vo_fuel_scg_rate_tmp
                          , vo_ovw_scg_rate_tmp
                          , vo_hzm_scg_rate_tmp
                          , vo_ttl_scg_rate_tmp
                          , vo_local_curr_tot_amt
                          , vo_usd_curr_tot_amt
                          , vo_wtr_rcv_term_cd
                          , vo_wtr_de_term_cd
                          , vo_basic_rt_rtn_cd
                          , vo_process_rslt_msg
                      );

                      IF v_trs_agmt_rt_knd = COA_BZC THEN
                          vo_final_rt       := vo_final_rt + NVL(vo_basic_rate_tmp, 0) + NVL(vo_ovw_scg_rate_tmp, 0) + NVL(vo_hzm_scg_rate_tmp, 0) + NVL(vo_ttl_scg_rate_tmp, 0);
                          vo_rt_cal_rtn_cd  := vo_basic_rt_rtn_cd;
                          IF debug_flg = 'Y' THEN
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'||v_coa_cost_src_cd||'/'||v_cost_act_grp_seq);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> NO :'||i);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> v_basis_dt:'||v_basis_dt);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> v_wgt_qty:'||v_wgt_qty);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> v_wgt_uom:'||v_wgt_uom);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> vo_final_rt:'||vo_final_rt);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> vo_basic_rate_tmp:'||vo_basic_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> vo_fuel_scg_rate_tmp:'||vo_fuel_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> vo_ovw_scg_rate_tmp:'||vo_ovw_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>> vo_local_curr_tot_amt:'||vo_local_curr_tot_amt);
                              DBMS_OUTPUT.PUT_LINE('RAIL BASIC RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');
                           END IF;
                      ELSIF v_trs_agmt_rt_knd = COA_SC_FU /*OR v_trs_agmt_rt_knd = COA_SC_OW*/ THEN
                          vo_final_rt       := vo_final_rt + NVL(vo_fuel_scg_rate_tmp, 0);
                          vo_rt_cal_rtn_cd  := vo_basic_rt_rtn_cd;
                          IF debug_flg = 'Y' THEN
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'||v_coa_cost_src_cd||'/'||v_cost_act_grp_seq);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_final_rt:'||vo_final_rt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_basis_dt:'||v_basis_dt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_wgt_qty:'||v_wgt_qty);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_wgt_uom:'||v_wgt_uom);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_basic_rate_tmp:'||vo_basic_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_fuel_scg_rate_tmp:'||vo_fuel_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_ovw_scg_rate_tmp:'||vo_ovw_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_local_curr_tot_amt:'||vo_local_curr_tot_amt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');
                          END IF;
                      END IF;
                      /* RATE CALCULATION END */

                  END LOOP;
                  /* LINK ... FOR LOOP END */

                  IF debug_flg = 'Y' THEN
                      DBMS_OUTPUT.PUT_LINE('US RAIL S/O RATE CALCULATION FINAL RESULT = ['||vo_final_rt||']');
                  END IF;
              ELSE
              /* NONE US RAIL TRANSPORTATION - EXCEPT US RAIL TRANSPORTATION */

                  IF v_snd_vndr_seq IS NOT NULL AND v_trd_vndr_seq IS NOT NULL AND LENGTH(v_snd_vndr_seq) = 6 AND LENGTH(v_trd_vndr_seq) = 6 THEN
                      IF  v_fst_vndr_seq != v_snd_vndr_seq OR v_fst_vndr_seq != v_trd_vndr_seq THEN
                          v_vndr_eff_flag := 'N';
                      ELSE
                          v_vndr_eff_flag := 'Y';
                      END IF;
                  ELSIF v_snd_vndr_seq IS NOT NULL AND LENGTH(v_snd_vndr_seq) = 6 THEN
                      IF  v_fst_vndr_seq != v_snd_vndr_seq THEN
                          v_vndr_eff_flag := 'N';
                      ELSE
                          v_vndr_eff_flag := 'Y';
                      END IF;
                  ELSIF v_trd_vndr_seq IS NOT NULL AND LENGTH(v_trd_vndr_seq) = 6 THEN
                      IF  v_fst_vndr_seq != v_trd_vndr_seq THEN
                          v_vndr_eff_flag := 'N';
                      ELSE
                          v_vndr_eff_flag := 'Y';
                      END IF;
                  ELSE
                      v_vndr_eff_flag := 'Y';
                  END IF;

                  v_vndr_seq := v_fst_vndr_seq;

                  v_from_nod_cd       := v_tmp_from_nod_cd  ;
                  v_via_nod_cd        := v_tmp_via_nod_cd   ;
                  v_door_nod_cd       := v_tmp_door_nod_cd  ;
                  v_to_nod_cd         := v_tmp_to_nod_cd    ;

                  /* US RAIL 이외의 운송에 대하여 S/P의 유효성 체크 -> 유효할때만 RATE CALCULATION */
                  IF v_vndr_eff_flag = 'Y' THEN
                      IF debug_flg = 'Y' THEN
                          DBMS_OUTPUT.put_line('______________________________ <<< NONE US RAIL >>> BASIC/FU <<<'||v_trs_agmt_rt_knd||'>>> v_vndr_eff_flag = ['||v_vndr_eff_flag||'] ______________________________');
                      END IF;
                          /* BASIC RATE CALCULATION START */
                            TRS_AGMT_RATE_CC_PKG.GET_TRS_ALL_RATE_PRC
                            (
                                  v_ctrl_ofc_cd          /* Pair - X , Distance - Mandatory */
                                , v_vndr_seq
                                , v_basis_dt
                                , COA_WAY_TP             /* way type code - Only ONEWAY     */
                                , 'U'                    /* EQ TYPE */
                                , v_cntr_tpsz_cd
                                , ''                     /* COMBINED TYPE CODE */
                                , v_cgo_tp_cd
                                , v_bound_cd
                                , v_crr_mod_cd
                                , v_cost_mod_cd
                                , v_cust_nomi_trkr_flg
                                , v_cust_cnt_cd
                                , v_cust_seq
                                , v_rail_svc_tp_cd
                                , v_cmdt_cd
                                , v_from_nod_cd
                                , v_via_nod_cd
                                , v_door_nod_cd
                                , v_to_nod_cd
                                , 0                    /* COUNT OF BUNDLING */
                                , v_wgt_uom
                                , v_wgt_qty
                                , ''  /* pi_rcv_term */
                                , ''  /* pi_de_term */
                                , v_tmp_trsp_agmt_ofc_cty_cd
                                , v_tmp_trsp_agmt_seq
                                , v_spcl_cgo_cntr_tp_cd
                                , debug_flg /* pi_debug_flg   */
                                , vo_trsp_agmt_ofc_cty_cd
                                , vo_trsp_agmt_seq
                                , vo_trsp_agmt_rt_tp_cd
                                , vo_way_type
                                , vo_trsp_agmt_rt_tp_nm  /* po_trsp_agmt_rt_tp_nm */
                                , vo_sp_type /* po_sp_type */
                                , vo_cust_nomi_trkr_flg
                                , vo_cust_cnt_cd
                                , vo_cust_seq
                                , vo_curr_cd
                                , vo_basic_rate_tmp
                                , vo_fuel_scg_rate_tmp
                                , vo_ovw_scg_rate_tmp
                                , vo_hzm_scg_rate_tmp
                                , vo_ttl_scg_rate_tmp
                                , vo_local_curr_tot_amt
                                , vo_usd_curr_tot_amt
                                , vo_wtr_rcv_term_cd
                                , vo_wtr_de_term_cd
                                , vo_basic_rt_rtn_cd
                                , vo_process_rslt_msg
                            );

                      IF v_trs_agmt_rt_knd = COA_BZC THEN
                          vo_final_rt       := NVL(vo_basic_rate_tmp, 0);
                          vo_rt_cal_rtn_cd  := vo_basic_rt_rtn_cd;

                          IF debug_flg = 'Y' THEN
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'||v_coa_cost_src_cd||'/'||v_cost_act_grp_seq);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> vo_final_rt:'||vo_final_rt);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> v_basis_dt:'||v_basis_dt);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> v_wgt_qty:'||v_wgt_qty);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> v_wgt_uom:'||v_wgt_uom);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> vo_basic_rate_tmp:'||vo_basic_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> vo_fuel_scg_rate_tmp:'||vo_fuel_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> vo_ovw_scg_rate_tmp:'||vo_ovw_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>> vo_local_curr_tot_amt:'||vo_local_curr_tot_amt);
                              DBMS_OUTPUT.PUT_LINE('BASIC RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');
                          END IF;

                      ELSIF v_trs_agmt_rt_knd = COA_SC_FU /*OR v_trs_agmt_rt_knd = COA_SC_OW*/ THEN
                          vo_final_rt       := NVL(vo_fuel_scg_rate_tmp, 0);
                          vo_rt_cal_rtn_cd  := vo_basic_rt_rtn_cd;

                          IF debug_flg = 'Y' THEN
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'||v_coa_cost_src_cd||'/'||v_cost_act_grp_seq);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_final_rt:'||vo_final_rt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_basis_dt:'||v_basis_dt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_wgt_qty:'||v_wgt_qty);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> v_wgt_uom:'||v_wgt_uom);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_basic_rate_tmp:'||vo_basic_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_fuel_scg_rate_tmp:'||vo_fuel_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_ovw_scg_rate_tmp:'||vo_ovw_scg_rate_tmp);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>> vo_local_curr_tot_amt:'||vo_local_curr_tot_amt);
                              DBMS_OUTPUT.PUT_LINE('FU SCG RATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>');
                          END IF;

                      END IF;
                      /* RATE CALCULATION END */

                  ELSE
                  /* Non-Effective S/P */

                      IF debug_flg = 'Y' THEN
                          DBMS_OUTPUT.PUT_LINE('');
                          DBMS_OUTPUT.PUT_LINE(' ======================== [[[ Non-Effective S/P ]]] ======================== ');
                          DBMS_OUTPUT.PUT_LINE('');
                      END IF;

                      vo_rt_cal_rtn_cd     := -99;

                  END IF;
                  /* US RAIL 이외의 운송에 대하여 S/P의 유효성 체크 + RATE CALCULATION END. */

                  IF debug_flg = 'Y' THEN
                      DBMS_OUTPUT.PUT_LINE('NONE US RAIL S/O RATE CALCULATION FINAL RESULT = ['||vo_final_rt||']');
                  END IF;

              END IF;
              /* S/P RATE CALCULATION END. */

          END IF;

          /* UNIT TOTAL BASIC RATE */
          /* UPDATE 'Y' WHEN REAL RATE IS ZERO VALUE, UPDATE 'N' WHEN RATE NOT FOUND + RATE ZERO 강제세팅 */

          /* EFFECTIVE S/P + BASIC/FUEL */

          IF (v_trs_agmt_rt_knd = COA_BZC OR v_trs_agmt_rt_knd = COA_SC_FU) AND v_vndr_eff_flag = 'Y' THEN
              IF debug_flg = 'Y' THEN
                  DBMS_OUTPUT.put_line('PCTL_NO = ['||v_pctl_no||'] - COST_ACT_GRP_SEQ = ['||v_cost_act_grp_seq||'] - CNTR_TPSZ_CD = ['||v_cntr_tpsz_cd||'] - COA_COST_SRC_CD = ['||v_coa_cost_src_cd||'] <<< ['||TRS_AGMT_RATE_CSR%ROWCOUNT||'th updated! ***'||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'***');
                  DBMS_OUTPUT.put_line('vo_rt_cal_rtn_cd =['||vo_rt_cal_rtn_cd||'],  way_type = ['||vo_way_type||'], vo_final_rt = ['||vo_final_rt||'], vo_curr_cd = ['||vo_curr_cd||']'||', vo_final_rt = ['||vo_final_rt||'] ___ '||TRS_AGMT_RATE_CSR%ROWCOUNT||'th updated! ***'||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'***');
              ELSE
                  UPDATE     COA_COM_COST_PARA  Y
                  SET        Y.LOCL_CURR_CD     = CASE vo_rt_cal_rtn_cd WHEN 0   THEN vo_curr_cd    -- SUCCESS(RATE FOUND).
                                                                        ELSE ''
                                                  END
                           , Y.ESTM_UC_AMT      = CASE vo_rt_cal_rtn_cd WHEN 0   THEN vo_final_rt   -- SUCCESS(RATE FOUND).
                                                                        ELSE 0
                                                  END
                           , Y.RESPB_UC_AMT     = CASE vo_rt_cal_rtn_cd WHEN 0   THEN vo_final_rt   -- SUCCESS(RATE FOUND).
                                                                        ELSE 0
                                                  END
                           , Y.CTRT_RTN_FLG     = CASE vo_rt_cal_rtn_cd WHEN 0   THEN 'Y'           -- SUCCESS(RATE FOUND).
                                                                        ELSE 'N'
                                                  END
                           , Y.WTR_RCV_TERM_CD  = CASE vo_rt_cal_rtn_cd WHEN 0   THEN DECODE(vo_wtr_rcv_term_cd,'0','',vo_wtr_rcv_term_cd)  -- SUCCESS(RATE FOUND).
                                                                        ELSE ''
                                                  END
                           , Y.WTR_DE_TERM_CD   = CASE vo_rt_cal_rtn_cd WHEN 0   THEN DECODE(vo_wtr_de_term_cd,'0','',vo_wtr_de_term_cd)   -- SUCCESS(RATE FOUND).
                                                                        ELSE ''
                                                  END
                  WHERE      Y.PCTL_NO          = v_pctl_no
                  AND        Y.COST_ACT_GRP_SEQ = v_cost_act_grp_seq
                  AND        Y.CNTR_TPSZ_CD     = v_cntr_tpsz_cd
                  AND        Y.COA_COST_SRC_CD  = v_coa_cost_src_cd
                  ;
              END IF;
          END IF;
      END LOOP;

      po_rtn_cd   := 0;

      IF debug_flg = 'Y' THEN
          DBMS_OUTPUT.PUT_LINE('[TRS_AGMT_APPLY_TO_COA] : FINISHED TIME IS ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
      END IF;

  EXCEPTION
      WHEN OTHERS THEN
           po_rtn_cd := -1;
           DBMS_OUTPUT.PUT_LINE('%%TRS_AGMT_APPLY_TO_COA_PRC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
      RAISE;
  END TRS_AGMT_APLY_TO_COA_PRC;
