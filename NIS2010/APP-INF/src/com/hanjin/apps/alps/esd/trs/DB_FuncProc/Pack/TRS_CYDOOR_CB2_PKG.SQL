CREATE OR REPLACE PACKAGE TRS_CYDOOR_CB2_PKG
AUTHID CURRENT_USER
IS 
 /*################################################################### 
 # -- Author  : CHOI JONG HYEK
 # -- Created : AUG 18, 2009 
 # -- Purpose : CY & DOOR SO 대상 조회시 사용 (CB2)
 #####################################################################*/ 
 
    -- Return받을 Record 선언
    TYPE PG_TYPE_MASTER1 IS RECORD
    (
      IB_VVD_CD                  TRS_TRSP_SVC_ORD_GLO_TMP.TRNK_VVD_CD%TYPE
    , OB_VVD_CD                  TRS_TRSP_SVC_ORD_GLO_TMP.TRNK_VVD_CD%TYPE
    , CTRL_OFC_CD                TRS_TRSP_SVC_ORD_GLO_TMP.CTRL_OFC_CD%TYPE
    , COP_NO                     TRS_TRSP_SVC_ORD_GLO_TMP.COP_NO%TYPE
    , EQ_NO                      TRS_TRSP_SVC_ORD_GLO_TMP.EQ_NO%TYPE
    , EQ_TPSZ_CD                 TRS_TRSP_SVC_ORD_GLO_TMP.EQ_TPSZ_CD%TYPE
    , COST_ACT_GRP_SEQ           TRS_TRSP_SVC_ORD_GLO_TMP.COST_ACT_GRP_SEQ%TYPE
    , COST_ACT_GRP_CD            TRS_TRSP_SVC_ORD_GLO_TMP.COST_ACT_GRP_CD%TYPE
    , VNDR_SEQ                   TRS_TRSP_SVC_ORD_GLO_TMP.VNDR_SEQ%TYPE
    , TRSP_COST_DTL_MOD_CD       TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_COST_DTL_MOD_CD%TYPE
    , TRSP_CRR_MOD_CD            TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_CRR_MOD_CD%TYPE
    , FM_NOD_CD                  TRS_TRSP_SVC_ORD_GLO_TMP.FM_NOD_CD%TYPE
    , FM_NOD_YARD                TRS_TRSP_SVC_ORD_GLO_TMP.FM_NOD_YD_NO%TYPE
    , TO_NOD_CD                  TRS_TRSP_SVC_ORD_GLO_TMP.TO_NOD_CD%TYPE
    , TO_NOD_YARD                TRS_TRSP_SVC_ORD_GLO_TMP.TO_NOD_YD_NO%TYPE
    , VIA_NOD_CD                 TRS_TRSP_SVC_ORD_GLO_TMP.VIA_NOD_CD%TYPE
    , VIA_NOD_YARD               TRS_TRSP_SVC_ORD_GLO_TMP.VIA_NOD_YD_NO%TYPE
    , DOR_NOD_CD                 TRS_TRSP_SVC_ORD_GLO_TMP.DOR_NOD_CD%TYPE
    , DOR_NOD_YARD               TRS_TRSP_SVC_ORD_GLO_TMP.DOR_NOD_YD_NO%TYPE
    , FM_NOD_CD2                 TRS_TRSP_SVC_ORD_GLO_TMP.FM_NOD_CD%TYPE
    , FM_NOD_YARD2               TRS_TRSP_SVC_ORD_GLO_TMP.FM_NOD_YD_NO%TYPE
    , TO_NOD_CD2                 TRS_TRSP_SVC_ORD_GLO_TMP.TO_NOD_CD%TYPE
    , TO_NOD_YARD2               TRS_TRSP_SVC_ORD_GLO_TMP.TO_NOD_YD_NO%TYPE
    , VIA_NOD_CD2                TRS_TRSP_SVC_ORD_GLO_TMP.VIA_NOD_CD%TYPE
    , VIA_NOD_YARD2              TRS_TRSP_SVC_ORD_GLO_TMP.VIA_NOD_YD_NO%TYPE
    , DOR_NOD_CD2                TRS_TRSP_SVC_ORD_GLO_TMP.DOR_NOD_CD%TYPE
    , DOR_NOD_YARD2              TRS_TRSP_SVC_ORD_GLO_TMP.DOR_NOD_YD_NO%TYPE
    , N1ST_NOD_PLN_DT            VARCHAR2(10)
    , N1ST_NOD_PLN_DT_HMS        VARCHAR2(10)
    , LST_NOD_PLN_DT             VARCHAR2(10)
    , LST_NOD_PLN_DT_HMS         VARCHAR2(10)
    , DOR_NOD_PLN_DT             VARCHAR2(10)
    , DOR_NOD_PLN_DT_HMS         VARCHAR2(10)
    , DOR_ARR_DT_DD              VARCHAR2(10)
    , DOR_ARR_DT_HMS             VARCHAR2(10)
    , DOR_ARR_DT                 VARCHAR2(20)
    , DOR_NOD_PLN                VARCHAR2(20)
    , TRO_SEQ                    TRS_TRSP_SVC_ORD_GLO_TMP.TRO_SEQ%TYPE
    , TRO_SUB_SEQ                TRS_TRSP_SVC_ORD_GLO_TMP.TRO_SUB_SEQ%TYPE
    , TRO_CNFM                   VARCHAR2(1)
    , TRO_CFM_OFC_CD             TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_OFC_CD%TYPE
    , TRO_CFM_USR_ID             TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_USR_ID%TYPE
    , TRO_CFM_UPD_DT1            VARCHAR2(10)
    , TRO_CFM_UPD_DT2            VARCHAR2(10)
    , TRO_CFM_CURR_CD            TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_CURR_CD%TYPE
    , TRO_CFM_REV_AMT            TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_REV_AMT%TYPE
    , TRO_LOD_REF_NO             TRS_TRSP_SVC_ORD_GLO_TMP.TRO_LOD_REF_NO%TYPE
    , TRO_REP_CMDT_CD            TRS_TRSP_SVC_ORD_GLO_TMP.TRO_REP_CMDT_CD%TYPE
    , TRSP_BND_CD                TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_BND_CD%TYPE
    , TRNS_RQST_OFC_CD           TRS_TRSP_SVC_ORD_GLO_TMP.TRNS_RQST_OFC_CD%TYPE
    , TRNS_RQST_USR_ID           TRS_TRSP_SVC_ORD_GLO_TMP.TRNS_RQST_USR_ID%TYPE
    , TRNS_RQST_RSN              TRS_TRSP_SVC_ORD_GLO_TMP.TRNS_RQST_RSN%TYPE
    , RAIL_CMB_THRU_TP_CD        TRS_TRSP_SVC_ORD_GLO_TMP.RAIL_CMB_THRU_TP_CD%TYPE
    , BKG_RCVDE_TERM_CD          TRS_TRSP_SVC_ORD_GLO_TMP.BKG_RCVDE_TERM_CD%TYPE
    , BKG_NO                     TRS_TRSP_SVC_ORD_GLO_TMP.BKG_NO%TYPE
    , POD_CONTI_CD               TRS_TRSP_SVC_ORD_GLO_TMP.POD_CONTI_CD%TYPE
    , FM_LOC_CONTI_CD            TRS_TRSP_SVC_ORD_GLO_TMP.FM_LOC_CONTI_CD%TYPE
    , CUST_NOMI_TRKR_FLG         TRS_TRSP_SVC_ORD_GLO_TMP.CUST_NOMI_TRKR_FLG%TYPE
    , CUST_CNT_CD                TRS_TRSP_SVC_ORD_GLO_TMP.CUST_CNT_CD%TYPE
    , CUST_SEQ                   TRS_TRSP_SVC_ORD_GLO_TMP.CUST_SEQ%TYPE
    , CNEE_CUST_CNT_CD           TRS_TRSP_SVC_ORD_GLO_TMP.CNEE_CUST_CNT_CD%TYPE
    , CNEE_CUST_SEQ              TRS_TRSP_SVC_ORD_GLO_TMP.CNEE_CUST_SEQ%TYPE
    , SHPR_CUST_CNT_CD           TRS_TRSP_SVC_ORD_GLO_TMP.SHPR_CUST_CNT_CD%TYPE
    , SHPR_CUST_SEQ              TRS_TRSP_SVC_ORD_GLO_TMP.SHPR_CUST_SEQ%TYPE
    , ACT_CUST_CD                TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_CD%TYPE
    , ACT_CUST_CNT_CD            TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_CNT_CD%TYPE
    , ACT_CUST_SEQ               TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_SEQ%TYPE
    , ACT_CUST_ADDR_SEQ          TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_ADDR_SEQ%TYPE
    , DOR_PST_CD                 TRS_TRSP_SVC_ORD_GLO_TMP.DOR_PST_CD%TYPE
    , FCTRY_NM                   TRS_TRSP_SVC_ORD_GLO_TMP.FCTRY_NM%TYPE
    , DOR_DE_ADDR                TRS_TRSP_SVC_ORD_GLO_TMP.DOR_DE_ADDR%TYPE
    , CNTC_PSON_PHN_NO           TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_PHN_NO%TYPE
    , CNTC_PSON_FAX_NO           TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_FAX_NO%TYPE
    , CNTC_PSON_NM               TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_NM%TYPE
    , SPCL_INSTR_RMK             TRS_TRSP_SVC_ORD_GLO_TMP.SPCL_INSTR_RMK%TYPE
    , USA_DO_USR_INFO            TRS_TRSP_SVC_ORD_GLO_TMP.DO_CTNT%TYPE
    , DO_CRE_DATE                VARCHAR2(10)
    , DO_CRE_TIME                VARCHAR2(10)
    , BL_NO                      TRS_TRSP_SVC_ORD_GLO_TMP.BL_NO%TYPE
    , BKG_CGO_TP_CD              TRS_TRSP_SVC_ORD_GLO_TMP.BKG_CGO_TP_CD%TYPE
    , CGO_TP_CD                  TRS_TRSP_SVC_ORD_GLO_TMP.CGO_TP_CD%TYPE
    , PKGCODE                    VARCHAR2(2)
    , TRUNKVVD                   TRS_TRSP_SVC_ORD_GLO_TMP.TRNK_VVD_CD%TYPE
    , SLAN_CD                    TRS_TRSP_SVC_ORD_GLO_TMP.SLAN_CD%TYPE
    , POR_CD                     TRS_TRSP_SVC_ORD_GLO_TMP.POR_CD%TYPE
    , POL_CD                     TRS_TRSP_SVC_ORD_GLO_TMP.POL_CD%TYPE
    , POD_CD                     TRS_TRSP_SVC_ORD_GLO_TMP.POD_CD%TYPE
    , DEL_CD                     TRS_TRSP_SVC_ORD_GLO_TMP.DEL_CD%TYPE
    , BKG_BDR_DT                 DATE
    , BKG_BDR_FLG                VARCHAR2(1)
    , SEALNO                     VARCHAR2(200)
    , SEALNO2                    VARCHAR2(200)
    , CNTR_WGT                   TRS_TRSP_SVC_ORD_GLO_TMP.CNTR_WGT%TYPE
    , WGT_MEAS_UT_CD             VARCHAR2(3)
    , NOOFPKG                    NUMBER(9)
    , SPCL_CGO_CNTR_TP_CD        VARCHAR2(10)
    , SHPR_CUST_NM               TRS_TRSP_SVC_ORD_GLO_TMP.SHPR_CUST_NM%TYPE
    , CNEE_CUST_NM               TRS_TRSP_SVC_ORD_GLO_TMP.CNEE_CUST_NM%TYPE
    , CNTR_KGS_WGT               NUMBER(9,3)
    , CNTR_LBS_WGT               NUMBER(9,3)
    , NTFY_CUST_NM               TRS_TRSP_SVC_ORD_GLO_TMP.NTFY_CUST_NM%TYPE
    , SC_NO                      TRS_TRSP_SVC_ORD_GLO_TMP.SC_NO%TYPE
    , RFANO                      TRS_TRSP_SVC_ORD_GLO_TMP.GEN_RFA_NO%TYPE
    , CMDT_CD                    TRS_TRSP_SVC_ORD_GLO_TMP.CMDT_CD%TYPE
    , CMDT_NAME                  VARCHAR2(200)
    , CGOR_FRT_PAY_IND_FLG       VARCHAR2(1)
    , CGOR_ORG_BL_RCVR_IND_FLG   VARCHAR2(1)
    , CGOR_CSTMS_ACPT_RE_IND_FLG VARCHAR2(1)
    , OWNR_CO_CD                 VARCHAR2(1)
    , IMDT_EXT_FLG               VARCHAR2(1)
    , LSTM_CD                    VARCHAR2(2)
    , IBD_CSTMS_CLR_LOC_CD       VARCHAR2(5)
    , DOR_SVC_TP_CD              TRS_TRSP_SVC_ORD_GLO_TMP.DOR_SVC_TP_CD%TYPE
    , INTER_RMK                  TRS_TRSP_SVC_ORD_GLO_TMP.INTER_RMK%TYPE
    , CRE_USR_ID                 TRS_TRSP_SVC_ORD_GLO_TMP.CRE_USR_ID%TYPE
    , UPD_USR_ID                 TRS_TRSP_SVC_ORD_GLO_TMP.UPD_USR_ID%TYPE
    , TRSP_SO_OFC_CTY_CD         TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_SO_OFC_CTY_CD%TYPE
    , TRSP_NXT_PORT_CD           VARCHAR2(5)
    , LST_LOC_CD                 VARCHAR2(5)
    , CUSTOMSCLEARANCENO         TRS_TRSP_SVC_ORD_GLO_TMP.CSTMS_CLR_NO%TYPE
    , CUSTOMSCLEARANCE           VARCHAR2(1)
    , MLT_STOP_DE_FLG            TRS_TRSP_SVC_ORD_GLO_TMP.MLT_STOP_DE_FLG%TYPE
    , PROC_CFM_IND_CD            VARCHAR2(1)
    , TRSP_COST_DTL_MOD_SEP      VARCHAR2(4)
    , UPLN_SO_FLG                TRS_TRSP_SVC_ORD_GLO_TMP.UPLN_SO_FLG%TYPE
    , DCGO_SEQ                   TRS_TRSP_SVC_ORD_GLO_TMP.DCGO_SEQ%TYPE
    , RC_SEQ                     TRS_TRSP_SVC_ORD_GLO_TMP.RC_SEQ%TYPE
    , AWK_CGO_SEQ                TRS_TRSP_SVC_ORD_GLO_TMP.AWK_CGO_SEQ%TYPE
    , CNTR_PKUP_NO               TRS_TRSP_SVC_ORD_GLO_TMP.CNTR_PKUP_NO%TYPE
    , AVAL_DT                    VARCHAR2(10)
    , AVAL_DT_HMS                VARCHAR2(10)
    , LST_FREE_DT                VARCHAR2(10)
    , LST_FREE_DT_HMS            VARCHAR2(10)
    , BKG_QTY                    VARCHAR2(500)
    , CSTMS_CLR_NO               TRS_TRSP_SVC_ORD_GLO_TMP.CSTMS_CLR_NO%TYPE
    , REP_CMDT_CD                TRS_TRSP_SVC_ORD_GLO_TMP.REP_CMDT_CD%TYPE
    , REV_CURR_CD                TRS_TRSP_SVC_ORD_GLO_TMP.REV_CURR_CD%TYPE
    , TRSP_RQST_ORD_REV_AMT      TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_REV_AMT%TYPE
    , TRSP_RQST_ORD_BND_CD       TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_BND_CD%TYPE
    , TRSP_RQST_ORD_SEQ          TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_SEQ%TYPE
    , TRSP_SO_STS_CD             TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_SO_STS_CD%TYPE
    , TRSP_SO_STS_NM             TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_SO_STS_NM%TYPE
    , CHK1                       VARCHAR2(10)
    , PRT_BKG_NO                 TRS_TRSP_SVC_ORD_GLO_TMP.BKG_NO%TYPE
    , RAIL_CRE_DT_DD             VARCHAR2(10)
    , RAIL_CRE_DT_HMS            VARCHAR2(10)
    , RAIL_TO_NOD_CD             VARCHAR2(10)
    , LSE_CNTR_FLG               VARCHAR2(1)
    , TRSP_CRR_MOD_CD2           TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_CRR_MOD_CD%TYPE
    , FEEDERVVD                  TRS_TRSP_SVC_ORD_GLO_TMP.TRNK_VVD_CD%TYPE 
    );

    -- Type재정의
    TYPE SET_TYPE1 IS TABLE OF PG_TYPE_MASTER1;

	-- 함수선언(Return의 Pipelined 기술)
	/* -------------------------------------------------------------------------------*/
	/* 함수명 : F_GET_CY_CANDIDATE
       사용 방법 :  select * from table(TRS_CYDOOR_CB2_PKG.F_GET_CY_CANDIDATE
                    ('HAMBB', 'CY', '20090501', '20090530', 'D2',
                    'DEHAMY1', 'CY', 'E'));     
	   파라메터  :                                                                    */
    /* -------------------------------------------------------------------------------*/
    FUNCTION F_GET_CY_CANDIDATE(
        p_so_office        IN varchar2,
        p_costmode         IN varchar2,
        p_frm_plandate     IN varchar2,
        p_to_plandate      IN varchar2,
        p_eq_tpsz_cd       IN varchar2,
        p_node             IN varchar2,
        p_cydoor_div       IN varchar2,
        p_ui_conti_cd      IN varchar2
    )
    RETURN  SET_TYPE1 PIPELINED;

END TRS_CYDOOR_CB2_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_CYDOOR_CB2_PKG AS
FUNCTION F_GET_CY_CANDIDATE(
    p_so_office        IN varchar2,
    p_costmode         IN varchar2,
    p_frm_plandate     IN varchar2,
    p_to_plandate      IN varchar2,
    p_eq_tpsz_cd       IN varchar2,
    p_node             IN varchar2,
    p_cydoor_div       IN varchar2,
    p_ui_conti_cd      IN varchar2
)
RETURN  SET_TYPE1 PIPELINED

IS
    PRAGMA AUTONOMOUS_TRANSACTION;
    v_select1          varchar2(4000);
    v_select2          varchar2(4000);
    v_select3          varchar2(4000);
    v_select4          varchar2(4000);
    v_select5          varchar2(4000);
    v_select6          varchar2(4000);
    v_sub_end          varchar2(100);
    v_costmode         varchar2(300)  := '';
    
    v_trsp_rqst_ord_so_cfm_ind_cd TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_SO_CFM_IND_CD%TYPE       := '';
    v_cstms_clr_no            TRS_TRSP_SVC_ORD_GLO_TMP.CSTMS_CLR_NO%TYPE          := '';
    v_rep_cmdt_cd             TRS_TRSP_SVC_ORD_GLO_TMP.REP_CMDT_CD%TYPE           := '';
    v_rev_curr_cd             TRS_TRSP_SVC_ORD_GLO_TMP.REV_CURR_CD%TYPE           := '';
    v_trsp_rqst_ord_rev_amt   TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_REV_AMT%TYPE := '';
    v_tro_cfm_ofc_cd          TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_OFC_CD%TYPE        := '';
    v_tro_cfm_usr_id          TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_USR_ID%TYPE        := '';
    v_tro_cfm_upd_dt          TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_UPD_DT%TYPE        := '';
    v_tro_cfm_rev_amt         TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_REV_AMT%TYPE       := '';
    v_tro_cfm_curr_cd         TRS_TRSP_SVC_ORD_GLO_TMP.TRO_CFM_CURR_CD%TYPE       := '';
    v_tro_rep_cmdt_cd         TRS_TRSP_SVC_ORD_GLO_TMP.TRO_REP_CMDT_CD%TYPE       := '';
    v_trsp_rqst_ord_bnd_cd    TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_BND_CD%TYPE  := '';
    v_trsp_rqst_ord_seq       TRS_TRSP_SVC_ORD_GLO_TMP.TRSP_RQST_ORD_SEQ%TYPE     := '';
    v_cntr_wgt                TRS_TRSP_SVC_ORD_GLO_TMP.CNTR_WGT %TYPE             := '';
    v_dor_addr_tp_cd1         BKG_EUR_TRO_DTL.DOR_ADDR_TP_CD%TYPE                 := '';
    v_dor_addr_tp_cd2         BKG_EUR_TRO_DTL.DOR_ADDR_TP_CD%TYPE                 := '';
    v_dor_arr_dt              TRS_TRSP_SVC_ORD_GLO_TMP.DOR_ARR_DT%TYPE            := '';
    v_tro_lod_ref_no          TRS_TRSP_SVC_ORD_GLO_TMP.TRO_LOD_REF_NO%TYPE        := '';
    v_dor_pst_cd              TRS_TRSP_SVC_ORD_GLO_TMP.DOR_PST_CD%TYPE            := '';
    v_dor_de_addr             TRS_TRSP_SVC_ORD_GLO_TMP.DOR_DE_ADDR%TYPE           := '';
    v_fctry_nm                TRS_TRSP_SVC_ORD_GLO_TMP.FCTRY_NM%TYPE              := '';
    v_cntc_pson_phn_no        TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_PHN_NO%TYPE      := '';
    v_cntc_pson_nm            TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_NM%TYPE          := '';
    v_mlt_stop_de_flg         TRS_TRSP_SVC_ORD_GLO_TMP.MLT_STOP_DE_FLG%TYPE       := ''; 
    v_act_cust_cd             TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_CD%TYPE           := '';
    v_act_cust_cnt_cd         TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_CNT_CD%TYPE       := '';
    v_act_cust_seq            TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_SEQ%TYPE          ;
    v_cntc_pson_fax_no        TRS_TRSP_SVC_ORD_GLO_TMP.CNTC_PSON_FAX_NO%TYPE      := '';
    v_spcl_instr_rmk          TRS_TRSP_SVC_ORD_GLO_TMP.SPCL_INSTR_RMK%TYPE        := '';
    v_usa_do_usr_info         VARCHAR(200)                                        := '';
    v_do_dt                   TRS_TRSP_SVC_ORD_GLO_TMP.DO_DT%TYPE ;

    v_dcgo_seq                TRS_TRSP_SVC_ORD_GLO_TMP.DCGO_SEQ%TYPE           := '';
    v_rc_seq                  TRS_TRSP_SVC_ORD_GLO_TMP.RC_SEQ%TYPE             := '';
    v_awk_cgo_seq             TRS_TRSP_SVC_ORD_GLO_TMP.AWK_CGO_SEQ%TYPE        := '';
    v_act_cust_addr_seq       TRS_TRSP_SVC_ORD_GLO_TMP.ACT_CUST_ADDR_SEQ%TYPE  := '';

    v_line                    varchar2(10)  :=  CHR(13);
    user_define_error         EXCEPTION;
    user_err_msg              varchar(1000) := '';

    /*************************************************************/
    /* Cursor선언(Record Type선언부와 일치해야 합니다.) */
    /*************************************************************/

    CURSOR CUR_DATA IS

    SELECT  SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '$', 1, 1) - 1) AS IB_VVD_CD
           ,SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '$', 1, 1) - 1) AS OB_VVD_CD
           ,X.CTRL_OFC_CD
           ,X.COP_NO
           ,(CASE WHEN X.EQ_NO = 'HJCU0000000' THEN ''
                  WHEN X.TRSP_BND_CD = 'O' AND X.TRSP_COST_DTL_MOD_CD  = 'DOOR' THEN ''
                  ELSE X.EQ_NO
            END) AS EQ_NO
           ,X.EQ_TPSZ_CD
           ,X.COST_ACT_GRP_SEQ
           ,X.COST_ACT_GRP_CD
           ,X.VNDR_SEQ
           ,DECODE(X.TRSP_COST_DTL_MOD_CD,'','CY',X.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_CD
           ,X.TRSP_CRR_MOD_CD
           ,X.FM_NOD_CD
           ,X.FM_NOD_YD_NO AS FM_NOD_YARD
           ,X.TO_NOD_CD
           ,X.TO_NOD_YD_NO AS TO_NOD_YARD
           ,X.VIA_NOD_CD
           ,X.VIA_NOD_YD_NO AS VIA_NOD_YARD
           ,X.DOR_NOD_CD
           ,X.DOR_NOD_YD_NO AS DOR_NOD_YARD
           ,'' AS FM_NOD_CD2    -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS FM_NOD_YARD2  -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS TO_NOD_CD2    -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS TO_NOD_YARD2  -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS VIA_NOD_CD2   -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS VIA_NOD_YARD2 -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS DOR_NOD_CD2   -- java Adapter에서 데이타를 셋팅한다.
           ,'' AS DOR_NOD_YARD2 -- java Adapter에서 데이타를 셋팅한다.
           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'YYYYMMDD'  )                              AS N1ST_NOD_PLN_DT
           ,TO_CHAR(X.N1ST_NOD_PLN_DT, 'HH24:MI:SS')                              AS N1ST_NOD_PLN_DT_HMS
           ,TO_CHAR(X.LST_NOD_PLN_DT, 'YYYYMMDD'  )                               AS LST_NOD_PLN_DT
           ,TO_CHAR(X.LST_NOD_PLN_DT, 'HH24:MI:SS')                               AS LST_NOD_PLN_DT_HMS
           ,TO_CHAR(NVL2(X.DOR_ARR_DT, X.DOR_ARR_DT, X.DOR_NOD_PLN_DT), 'YYYYMMDD'  ) AS DOR_NOD_PLN_DT
           ,TO_CHAR(NVL2(X.DOR_ARR_DT, X.DOR_ARR_DT, X.DOR_NOD_PLN_DT), 'HH24:MI:SS') AS DOR_NOD_PLN_DT_HMS    
           ,TO_CHAR(X.DOR_ARR_DT, 'YYYYMMDD'  )  AS DOR_ARR_DT_DD
           ,TO_CHAR(X.DOR_ARR_DT, 'HH24:MI:SS')  AS DOR_ARR_DT_HMS
           ,TO_CHAR(X.DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS DOR_ARR_DT
           ,TO_CHAR(X.DOR_NOD_PLN_DT, 'YYYYMMDDHH24MISS')                         AS DOR_NOD_PLN
           ,X.TRO_SEQ
           ,X.TRO_SUB_SEQ
           ,DECODE(X.TRO_SEQ, NULL, 'N', 'Y') AS TRO_CNFM
           ,X.TRO_CFM_OFC_CD
           ,X.TRO_CFM_USR_ID
           ,TO_CHAR(X.TRO_CFM_UPD_DT, 'YYYYMMDD') AS TRO_CFM_UPD_DT1
           ,TO_CHAR(X.TRO_CFM_UPD_DT, 'HH24MISS') AS TRO_CFM_UPD_DT2
           ,X.TRO_CFM_CURR_CD
           ,X.TRO_CFM_REV_AMT
           ,X.TRO_LOD_REF_NO
           ,X.TRO_REP_CMDT_CD
           ,X.TRSP_BND_CD
           ,X.TRNS_RQST_OFC_CD
           ,X.TRNS_RQST_USR_ID
           ,X.TRNS_RQST_RSN
           ,X.RAIL_CMB_THRU_TP_CD
           ,X.BKG_RCVDE_TERM_CD
           ,X.BKG_NO
           ,X.POD_CONTI_CD
           ,DECODE(X.FM_LOC_CONTI_CD, 'F', 'E', X.FM_LOC_CONTI_CD) AS FM_LOC_CONTI_CD
           ,X.CUST_NOMI_TRKR_FLG
           ,X.CUST_CNT_CD
           ,X.CUST_SEQ
           ,X.CNEE_CUST_CNT_CD
           ,X.CNEE_CUST_SEQ
           ,X.SHPR_CUST_CNT_CD
           ,X.SHPR_CUST_SEQ
           ,X.ACT_CUST_CD
           ,X.ACT_CUST_CNT_CD
           ,X.ACT_CUST_SEQ
           ,X.ACT_CUST_ADDR_SEQ
           ,X.DOR_PST_CD
           ,X.FCTRY_NM
           ,X.DOR_DE_ADDR
           ,X.CNTC_PSON_PHN_NO
           ,X.CNTC_PSON_FAX_NO
           ,X.CNTC_PSON_NM
           ,X.SPCL_INSTR_RMK
           ,X.DO_CTNT AS USA_DO_USR_INFO
           ,TO_CHAR(X.DO_DT, 'YYYY-MM-DD') AS DO_CRE_DATE
           ,TO_CHAR(X.DO_DT, 'HH24:MI:SS') AS DO_CRE_TIME
           ,X.BL_NO
           ,X.BKG_CGO_TP_CD
           ,X.CGO_TP_CD
           ,SUBSTR(X.BKG_CNTR, 1, INSTR(X.BKG_CNTR, '$', 1, 1) - 1) AS PKGCODE
           ,X.TRNK_VVD_CD AS TRUNKVVD
           ,X.SLAN_CD
           ,X.POR_CD
           ,X.POL_CD
           ,X.POD_CD
           ,X.DEL_CD
           ,TO_DATE(SUBSTR(X.BDR_INFO, 1, INSTR(X.BDR_INFO, '$', 1, 1) - 1),'YYYYMMDDHH24MISS') AS BKG_BDR_DT -- SUBSTR의 첫번째 값
           ,SUBSTR(X.BDR_INFO, INSTR(X.BDR_INFO, '$', 1, 1) + 1) BKG_BDR_FLG -- SUBSTR의 두번째 값
           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 1) AS SEALNO
           ,(SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO  = X.BKG_NO AND CNTR_NO = X.EQ_NO AND CNTR_SEAL_SEQ = 2) AS SEALNO2
           ,NVL2(CNTR_WGT, CNTR_WGT, TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 8) + 1, INSTR(X.BKG_CNTR, '$', 1, 9) - INSTR(X.BKG_CNTR, '$', 1, 8) - 1))) AS CNTR_WGT
           ,SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 2) + 1, INSTR(X.BKG_CNTR, '$', 1, 3) - INSTR(X.BKG_CNTR, '$', 1, 2) - 1) AS WGT_MEAS_UT_CD
           ,TO_NUMBER(TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 1) + 1, INSTR(X.BKG_CNTR, '$', 1, 2) - INSTR(X.BKG_CNTR, '$', 1, 1) - 1))) AS NOOFPKG
       
           ,NVL2(X.TRO_SEQ,
                DECODE( X.POD_CONTI_CD, 'E' , DECODE (X.DCGO_SEQ, NULL, DECODE(X.RC_SEQ, NULL, DECODE(X.AWK_CGO_SEQ, NULL, '', 'AK'), 'RF'), 'DG')
                   ,CASE WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 3) + 1, INSTR(X.BKG_CNTR, '$', 1, 4) - INSTR(X.BKG_CNTR, '$', 1, 3) - 1) = 'Y' THEN 'DG'                            
                         WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 4) + 1, INSTR(X.BKG_CNTR, '$', 1, 5) - INSTR(X.BKG_CNTR, '$', 1, 4) - 1) = 'Y' THEN 'BB'                            
                         WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 5) + 1, INSTR(X.BKG_CNTR, '$', 1, 6) - INSTR(X.BKG_CNTR, '$', 1, 5) - 1) = 'Y' THEN 'AK'                            
                         WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 6) + 1, INSTR(X.BKG_CNTR, '$', 1, 7) - INSTR(X.BKG_CNTR, '$', 1, 6) - 1) = 'Y' THEN 'RF'                             
                         WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 7) + 1, INSTR(X.BKG_CNTR, '$', 1, 8) - INSTR(X.BKG_CNTR, '$', 1, 7) - 1) = 'Y' THEN 'RD'                              
                    ELSE ''                                                                 
                    END 
                ),
                CASE WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 3) + 1, INSTR(X.BKG_CNTR, '$', 1, 4) - INSTR(X.BKG_CNTR, '$', 1, 3) - 1) = 'Y' THEN 'DG'                            
                     WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 4) + 1, INSTR(X.BKG_CNTR, '$', 1, 5) - INSTR(X.BKG_CNTR, '$', 1, 4) - 1) = 'Y' THEN 'BB'                            
                     WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 5) + 1, INSTR(X.BKG_CNTR, '$', 1, 6) - INSTR(X.BKG_CNTR, '$', 1, 5) - 1) = 'Y' THEN 'AK'                            
                     WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 6) + 1, INSTR(X.BKG_CNTR, '$', 1, 7) - INSTR(X.BKG_CNTR, '$', 1, 6) - 1) = 'Y' THEN 'RF'                              
                     WHEN SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 7) + 1, INSTR(X.BKG_CNTR, '$', 1, 8) - INSTR(X.BKG_CNTR, '$', 1, 7) - 1) = 'Y' THEN 'RD'                             
                ELSE ''                                                                 
                END
            ) AS SPCL_CGO_CNTR_TP_CD
           ,X.SHPR_CUST_NM
           ,X.CNEE_CUST_NM
           ,TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 2) + 1, INSTR(X.BKG_CNTR, '$', 1, 3) - INSTR(X.BKG_CNTR, '$', 1, 2) - 1), 
                                                       NVL2(CNTR_WGT, CNTR_WGT, TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 8) + 1, INSTR(X.BKG_CNTR, '$', 1, 9) - INSTR(X.BKG_CNTR, '$', 1, 8) - 1)))
                                                  ) AS CNTR_KGS_WGT -- EUR TRO에 Weight가 없으면 BKG CNTR 의 Weight값을 조회한다.

           ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 2) + 1, INSTR(X.BKG_CNTR, '$', 1, 3) - INSTR(X.BKG_CNTR, '$', 1, 2) - 1), 
                                                       NVL2(CNTR_WGT, CNTR_WGT, TRIM(SUBSTR(X.BKG_CNTR, INSTR(X.BKG_CNTR, '$', 1, 8) + 1, INSTR(X.BKG_CNTR, '$', 1, 9) - INSTR(X.BKG_CNTR, '$', 1, 8) - 1)))
                                                  ) AS CNTR_LBS_WGT -- EUR TRO에 Weight가 없으면 BKG CNTR 의 Weight값을 조회한다.
           ,X.NTFY_CUST_NM
           ,X.SC_NO
           ,X.GEN_RFA_NO AS RFANO
           ,X.CMDT_CD
           , NVL((SELECT LPAD(NVL(V.PCK_TP_CD, ' '),2, ' ') || TO_CHAR(V.PCK_QTY)
                    FROM BKG_CNTR_MF_DESC V
                   WHERE V.BKG_NO = X.BKG_NO
                     AND V.CNTR_NO  = X.EQ_NO
                     AND V.CNTR_MF_SEQ = 1),
                 (SELECT REPLACE(W.CMDT_NM, CHR(13)||CHR(10)||CHR(9)||CHR(43), ' ') 
                    FROM MDM_COMMODITY W
                   WHERE W.CMDT_CD = X.CMDT_CD) 
                ) AS CMDT_NAME

           ,DECODE(p_ui_conti_cd, 'M', SUBSTR(X.CGO_RLSE, 1, INSTR(X.CGO_RLSE, '$', 1, 1) - 1), '') AS CGOR_FRT_PAY_IND_FLG
           ,DECODE(p_ui_conti_cd, 'M', SUBSTR(X.CGO_RLSE, INSTR(X.CGO_RLSE, '$', 1, 1) + 1, INSTR(X.CGO_RLSE, '$', 1, 2) - INSTR(X.CGO_RLSE, '$', 1, 1) - 1), '') AS CGOR_ORG_BL_RCVR_IND_FLG
           ,DECODE(p_ui_conti_cd, 'M', SUBSTR(X.CGO_RLSE, INSTR(X.CGO_RLSE, '$', 1, 2) + 1), '') AS CGOR_CSTMS_ACPT_RE_IND_FLG           
           ,SUBSTR(X.MST_CNTR, 1, INSTR(X.MST_CNTR, '$', 1, 1) - 1) OWNR_CO_CD
           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '$', 1, 1) + 1, INSTR(X.MST_CNTR, '$', 1, 2) - INSTR(X.MST_CNTR, '$', 1, 1) - 1) IMDT_EXT_FLG
           ,SUBSTR(X.MST_CNTR, INSTR(X.MST_CNTR, '$', 1, 2) + 1) LSTM_CD
           ,(SELECT RLSE_HIS.CSTMS_LOC_CD FROM BKG_CGO_RLSE_HIS RLSE_HIS WHERE RLSE_HIS.BL_NO = X.BL_NO AND HIS_SEQ = 1) AS IBD_CSTMS_CLR_LOC_CD
           ,X.DOR_SVC_TP_CD
           ,X.INTER_RMK
           ,X.CRE_USR_ID
           ,X.UPD_USR_ID
           ,X.TRSP_SO_OFC_CTY_CD
           ,DECODE(SUBSTR(X.BKG_VVD_IB, INSTR(X.BKG_VVD_IB, '$', 1, 2) + 1), 'U'
                  , SUBSTR(X.BKG_VVD_IB, INSTR(X.BKG_VVD_IB, '$', 1, 1) + 1, INSTR(X.BKG_VVD_IB, '$', 1, 2) - INSTR(X.BKG_VVD_IB, '$', 1, 1) - 1) 
                  , SUBSTR(X.BKG_VVD_OB, INSTR(X.BKG_VVD_OB, '$', 1, 1) + 1, INSTR(X.BKG_VVD_OB, '$', 1, 2) - INSTR(X.BKG_VVD_OB, '$', 1, 1) - 1) ) AS TRSP_NXT_PORT_CD
           ,TRS_CYDOOR_COMM_PKG.GET_MULTI_LST_LOC(X.FM_NOD_CD, X.TO_NOD_CD) AS LST_LOC_CD
           ,X.CSTMS_CLR_NO  AS CUSTOMSCLEARANCENO
           ,DECODE(X.CSTMS_CLR_NO,NULL, '', 'Y')   AS CUSTOMSCLEARANCE
           ,X.MLT_STOP_DE_FLG
           ,X.TRSP_RQST_ORD_SO_CFM_IND_CD
           ,TRS_CYDOOR_COMM_PKG.GET_TRSP_COST_DTL_MOD_SEP(X.TRSP_COST_DTL_MOD_CD, X.FM_NOD_CD, X.TO_NOD_CD, X.TRSP_BND_CD) AS TRSP_COST_DTL_MOD_SEP
           ,X.UPLN_SO_FLG
           ,X.DCGO_SEQ
           ,X.RC_SEQ
           ,X.AWK_CGO_SEQ
           ,X.CNTR_PKUP_NO
           ,TO_CHAR(X.AVAL_DT, 'YYYYMMDD')       AS AVAL_DT
           ,TO_CHAR(X.AVAL_DT, 'HH24:MI:SS')     AS AVAL_DT_HMS
           ,TO_CHAR(X.LST_FREE_DT, 'YYYYMMDD')   AS LST_FREE_DT
           ,TO_CHAR(X.LST_FREE_DT, 'HH24:MI:SS') AS LST_FREE_DT_HMS
           ,(SELECT DECODE(NVL(U.EQ_SUBST_CGO_QTY, 0), 0, U.CNTR_TPSZ_CD
                           ||' '||U.OP_CNTR_QTY, U.CNTR_TPSZ_CD||' '||U.OP_CNTR_QTY
                           ||'-SUB '||U.EQ_SUBST_CNTR_TPSZ_CD ||' '||U.EQ_SUBST_CGO_QTY
                          )
              FROM BKG_QUANTITY U
             WHERE U.BKG_NO       = X.BKG_NO
               AND U.CNTR_TPSZ_CD = X.EQ_TPSZ_CD) AS BKG_QTY
           ,X.CSTMS_CLR_NO
           ,X.REP_CMDT_CD
           ,X.REV_CURR_CD
           ,X.TRSP_RQST_ORD_REV_AMT
           ,X.TRSP_RQST_ORD_BND_CD
           ,X.TRSP_RQST_ORD_SEQ
           ,X.TRSP_SO_STS_CD
           ,X.TRSP_SO_STS_NM
           ,CASE WHEN X.MST_LCL_CD = 'P'
                  AND SUBSTR(X.BDR_INFO, INSTR(X.BDR_INFO, '$', 1, 1) + 1) = 'N'
                  AND X.TRSP_BND_CD            = 'I'
                  AND X.TRSP_COST_DTL_MOD_CD   = 'DOOR'
                 THEN 'FALSE'
                 WHEN X.MST_LCL_CD = 'P'
                 THEN 'TRUE'
                 ELSE 'FALSE'
            END                      AS  CHK1
           ,(SELECT U.BKG_NO
               FROM SCE_COP_HDR U
              WHERE U.MST_COP_NO = X.COP_NO
                AND ROWNUM = 1) AS PRT_BKG_NO

           ,TO_CHAR(X.RAIL_CRE_DT, 'YYYY-MM-DD') AS RAIL_CRE_DT_DD
           ,TO_CHAR(X.RAIL_CRE_DT, 'HH24:MI:SS') AS RAIL_CRE_DT_HMS
           ,X.RAIL_TO_NOD_CD
           ,'' LSE_CNTR_FLG
           ,'' TRSP_CRR_MOD_CD2
           ,CASE WHEN X.TRSP_BND_CD = 'I' THEN SUBSTR(X.BKG_VVD_IB, 1, INSTR(X.BKG_VVD_IB, '$', 1, 1) - 1)
                 WHEN X.TRSP_BND_CD = 'O' THEN SUBSTR(X.BKG_VVD_OB, 1, INSTR(X.BKG_VVD_OB, '$', 1, 1) - 1)
                ELSE ''
            END AS FEEDERVVD

    FROM  (SELECT TMP.*
                ,(SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ')||'$'||NVL(IB.POD_CD, ' ')||'$'||NVL(IB.VSL_PRE_PST_CD, ' ')
                    FROM BKG_VVD IB
                   WHERE IB.BKG_NO = TMP.BKG_NO
                     AND IB.POD_CD = TMP.FM_NOD_CD
                     --AND IB.VSL_PRE_PST_CD <> 'T'
                     AND ROWNUM = 1) BKG_VVD_IB
                ,(SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')||'$'||NVL(OB.POD_CD, ' ')
                    FROM BKG_VVD OB
                   WHERE OB.BKG_NO = TMP.BKG_NO
                     AND OB.POL_CD = TMP.TO_NOD_CD
                     --AND OB.VSL_PRE_PST_CD <> 'T'
                     AND ROWNUM = 1) BKG_VVD_OB
                ,(SELECT NVL(RLSE.FRT_CLT_FLG, ' ') || '$' || NVL(RLSE.OBL_RDEM_FLG, ' ') || '$' || DECODE(RLSE.CSTMS_CLR_CD, 'Y', 'Y', ' ')
                    FROM BKG_CGO_RLSE RLSE
                   WHERE RLSE.BL_NO = TMP.BL_NO) CGO_RLSE
                ,(SELECT NVL(BKG_CNTR.PCK_TP_CD, ' ') || '$' || NVL(TO_CHAR(BKG_CNTR.PCK_QTY), ' ') || '$' || NVL(WGT_UT_CD, ' ')
                         || '$' || NVL(BKG_CNTR.DCGO_FLG , ' ') || '$' || NVL(BKG_CNTR.BB_CGO_FLG , ' ') || '$' || NVL(BKG_CNTR.AWK_CGO_FLG , ' ') 
                         || '$' || NVL(BKG_CNTR.RC_FLG , ' ') || '$' || NVL(BKG_CNTR.RD_CGO_FLG , ' ') || '$' || NVL(TO_CHAR(BKG_CNTR.CNTR_WGT) , ' ') || '$'
                    FROM BKG_CONTAINER BKG_CNTR
                   WHERE BKG_CNTR.BKG_NO  = TMP.BKG_NO
                     AND BKG_CNTR.CNTR_NO = TMP.EQ_NO ) BKG_CNTR
                ,(SELECT NVL(MST_CNTR.OWNR_CO_CD, ' ') || '$' || NVL(MST_CNTR.IMDT_EXT_FLG, ' ') || '$' || NVL(MST_CNTR.LSTM_CD, ' ')
                    FROM MST_CONTAINER MST_CNTR
                   WHERE MST_CNTR.CNTR_NO = TMP.EQ_NO) MST_CNTR
                ,(SELECT TO_CHAR(BDR_DT,'YYYYMMDDHH24MISS')||'$'||NVL(BDR_FLG,'N')
                    FROM BKG_BL_DOC DOC
                   WHERE DOC.BKG_NO = TMP.BKG_NO) BDR_INFO
             FROM TRS_TRSP_SVC_ORD_GLO_TMP TMP) X
    ;

BEGIN
    DELETE FROM TRS_TRSP_SVC_ORD_GLO_TMP;
    DELETE FROM TRS_SVC_ORD_LOG_GLO_TMP;

    v_select1 := ''
    ||v_line||'INSERT INTO TRS_TRSP_SVC_ORD_GLO_TMP ( '
    ||v_line||' CTRL_OFC_CD'
    ||v_line||',COP_NO'
    ||v_line||',EQ_NO'
    ||v_line||',EQ_TPSZ_CD'
    ||v_line||',COST_ACT_GRP_SEQ'
    ||v_line||',COST_ACT_GRP_CD'
    ||v_line||',VNDR_SEQ'
    ||v_line||',TRSP_CRR_MOD_CD'
    ||v_line||',FM_NOD_CD'
    ||v_line||',FM_NOD_YD_NO'
    ||v_line||',TO_NOD_CD'
    ||v_line||',TO_NOD_YD_NO'
    ||v_line||',VIA_NOD_CD'
    ||v_line||',VIA_NOD_YD_NO'
    ||v_line||',DOR_NOD_CD'
    ||v_line||',DOR_NOD_YD_NO'
    ||v_line||',TRSP_BND_CD'
    ||v_line||',TRNS_RQST_OFC_CD'
    ||v_line||',TRNS_RQST_USR_ID'
    ||v_line||',TRNS_RQST_RSN'
    ||v_line||',RAIL_CMB_THRU_TP_CD'
    ||v_line||',SC_NO'
    ||v_line||',GEN_RFA_NO'
    ||v_line||',INTER_RMK'
    ||v_line||',TRSP_SO_STS_CD'
    ||v_line||',MST_LCL_CD'
    ||v_line||',FM_LOC_CONTI_CD'
    ||v_line||',BKG_NO'
    ||v_line||',N1ST_NOD_PLN_DT'
    ||v_line||',BKG_RCVDE_TERM_CD'
    ||v_line||',BL_NO'
    ||v_line||',BKG_CGO_TP_CD'
    ||v_line||',CGO_TP_CD'
    ||v_line||',TRNK_VVD_CD'
    ||v_line||',SLAN_CD'
    ||v_line||',POR_CD'
    ||v_line||',POL_CD'
    ||v_line||',POD_CD'
    ||v_line||',DEL_CD'
    ||v_line||',CMDT_CD'
    ||v_line||',DOR_NOD_PLN_DT'
    ||v_line||',LST_NOD_PLN_DT'
    ||v_line||',TRSP_COST_DTL_MOD_CD'
    ||v_line||',UPLN_SO_FLG'
    ||v_line||',TRSP_SO_STS_NM'
    ||v_line||',POD_CONTI_CD'
    ||v_line||',BKG_TRO_NO'
    ||v_line||',CRE_DT'
    ||v_line||',CRE_USR_ID'
    ||v_line||',UPD_DT'
    ||v_line||',UPD_USR_ID'
    ||v_line||' ) ';

    v_select2 := 'SELECT ';
    v_select2 := v_select2||'/*+ NO_EXPAND */';
    v_select2 := v_select2||''
    ||v_line||' * '
    ||v_line||' FROM ( '
    ||v_line||'   SELECT '
    ||v_line||'';

    v_select3 := ''
    ||v_line||'   B.CTRL_OFC_CD '
    ||v_line||' , A.COP_NO                    '
    ||v_line||' , NVL(A.CNTR_NO, '' '') EQ_NO '
    ||v_line||' , A.CNTR_TPSZ_CD              '
    ||v_line||' , B.COST_ACT_GRP_SEQ          '
    ||v_line||' , B.COST_ACT_GRP_CD           '
    ||v_line||' , B.N1ST_VNDR_SEQ             '
    ||v_line||' , SUBSTR(B.COST_ACT_GRP_CD,3) TRSP_CRR_MOD_CD '
    ||v_line||' , SUBSTR(B.N1ST_NOD_CD,1,5)  FM_NOD_CD '
    ||v_line||' , SUBSTR(B.N1ST_NOD_CD,6)    FM_NOD_YARD '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''TO'' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''NODE'') TO_NOD_CD    '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''TO'' , B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''YARD'') TO_NOD_YARD  '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''VIA'', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''NODE'') VIA_NOD_CD   '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''VIA'', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''YARD'') VIA_NOD_YARD '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''DOR'', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''NODE'') DOR_NOD_CD   '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC(''DOR'', B.PCTL_IO_BND_CD, B.PCTL_COST_MOD_CD, B.N1ST_NOD_CD, B.N2ND_NOD_CD, B.N3RD_NOD_CD, B.N4TH_NOD_CD, ''YARD'') DOR_NOD_YARD '
    ||v_line||' , B.PCTL_IO_BND_CD              '
    ||v_line||' , B.TRNS_RQST_OFC_CD            '
    ||v_line||' , B.TRNS_RQST_USR_ID            '
    ||v_line||' , B.TRNS_RQST_RSN               '
    ||v_line||' , B.INLND_ROUT_INV_BIL_PATT_CD  '
    ||v_line||' , C.SC_NO                       '
    ||v_line||' , C.RFA_NO                      '
    ||v_line||' , NVL2(B.DELT_USR_ID, ''Candidate Delete :''||B.DELT_USR_ID, '''') || NVL2(B.DELT_DT, '' / ''||TO_CHAR(B.DELT_DT,''YYYYMMDDHH24MISS''), '''') INTER_RMK     '
    ||v_line||' , B.TRSP_SO_STS_CD '
    ||v_line||' , DECODE(A.MST_COP_NO, A.COP_NO, ''P'', ''X'')   MST_LCL_CD '
    ||v_line||' , TRS_CYDOOR_COMM_PKG.GET_CONTI_CD(SUBSTR(B.N1ST_NOD_CD,1,5)) AS FM_LOC_CONTI_CD  '
    ||v_line||' , A.BKG_NO                      '
    ||v_line||' , B.N1ST_NOD_PLN_DT             '
    ||v_line||' , DECODE(B.PCTL_IO_BND_CD, ''I'',C.DE_TERM_CD, ''O'',C.RCV_TERM_CD, '''')   BKG_RCVDE_TERM_CD '
    ||v_line||' , C.BL_NO '
    ||v_line||' , C.BKG_CGO_TP_CD     '
    ||v_line||' , ''F'' CGO_TP_CD     '
    ||v_line||' , (C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD) TRUNKVVD '
    ||v_line||' , C.SLAN_CD           '
    ||v_line||' , C.POR_CD POR_CD     '
    ||v_line||' , C.POL_CD POL_CD     '
    ||v_line||' , C.POD_CD POD_CD     '
    ||v_line||' , C.DEL_CD DEL_CD     '
    ||v_line||' , C.CMDT_CD           '
    ||v_line||' , B.DOR_ARR_DT AS DOR_NOD_PLN_DT '
    ||v_line||' , B.LST_NOD_PLN_DT    '
    ||v_line||' , DECODE(B.PCTL_COST_MOD_CD,''C'',''CY'',''Z'',''DOOR'','''') TRSP_COST_DTL_MOD_CD '
    ||v_line||' , DECODE(B.PCTL_COST_MOD_CD, '''', ''Y'', '''') UPLN_SO_FLG ' -- PCTL_COST_MOD_CD 가 NULL 인 경우는 Unplaned S/O만 해당되므로 Planed는 모두 ''
    ||v_line||' , (SELECT SUBSTR(COMMCODE_PKG.GET_COMDTL_NAME_FNC(''CD00286'', B.TRSP_SO_STS_CD), 1, 64) FROM DUAL) TRSP_SO_STS_NM ' -- DUAL 테이블을 사용하면 동일한 데이타는 한번만 조회하게 된다. SUBSTR을 사용하지 않았을 경우 기본 4000byte를 사용하게 된다.
    ||'';
    
    v_select4 := '';
    IF p_cydoor_div = 'DR' THEN
        v_select4 := v_select4 ||''
        ||v_line||' , (SELECT CONTI_CD FROM MDM_LOCATION PD WHERE PD.LOC_CD = C.POD_CD) POD_CONTI_CD '
        ||v_line||' , (SELECT MAPG.TRO_SEQ||''$''||MAPG.TRO_SUB_SEQ  '
        ||v_line||'    FROM SCE_TRO_MAPG MAPG '
        ||v_line||'    WHERE MAPG.COP_NO    = B.COP_NO '
        ||v_line||'    AND MAPG.IO_BND_CD = B.PCTL_IO_BND_CD '
        ||v_line||'    AND MAPG.AREA_CONTI_CD = ''' || p_ui_conti_cd || ''') TRO_SEQ ' ;
    ELSE
        v_select4 := v_select4 ||''
        ||v_line||' , NULL POD_CONTI_CD'
        ||v_line||' , NULL TRO_SEQ'
        || '';
    END IF;
    
    v_select4 := v_select4 ||''
    ||v_line||' , SYSDATE CRE_DT'
    ||v_line||' , ''PKG''   CRE_USR_ID'
    ||v_line||' , SYSDATE UPD_DT'
    ||v_line||' , ''PKG''   UPD_USR_ID'
    || '';

    v_select5 := ''
    ||v_line||' FROM SCE_COP_HDR A '
    ||v_line||', SCE_PLN_SO_LIST B '
    ||v_line||', BKG_BOOKING C '
    ||'';

    v_select5 := v_select5||v_line||' WHERE A.COP_NO=B.COP_NO'
    ||v_line|| ' AND A.COP_STS_CD IN (''C'',''T'',''F'')'
    ||v_line|| ' AND A.BKG_NO = C.BKG_NO'
    ||v_line|| ' ' ;
    
--------------------------------------------------------------------
    v_select6 := ' AND B.CTRL_OFC_CD = :pv_so_office';
    v_select6 := v_select6||v_line|| ' AND B.TRSP_SO_STS_CD = ''P''';
    
    /* CY , DOOR 구분 */
    IF p_cydoor_div = 'DR' THEN
        v_select6 := v_select6||''
                     ||v_line||' AND B.PCTL_COST_MOD_CD = ''Z'' ';
    ELSE
        v_select6 := v_select6||''
                     ||v_line||' AND B.PCTL_COST_MOD_CD <> ''Z'' ';
    END IF;
    
    IF p_costmode = 'DR' THEN
        v_select6 := v_select6||''
                     ||v_line||' AND B.DOR_ARR_DT BETWEEN TO_DATE(:p_frm_plandate,''YYYYMMDDHH24MISS'') AND TO_DATE(:pv_to_plandate,''YYYYMMDDHH24MISS'')'
                     ||v_line||' AND B.PCTL_IO_BND_CD = ''O'''
                     ||v_line||' AND B.N2ND_NOD_CD = :pv_node';
    ELSE 
        v_select6 := v_select6||''
                     ||v_line||' AND B.N1ST_NOD_PLN_DT BETWEEN TO_DATE(:pv_frm_plandate,''YYYYMMDDHH24MISS'') AND TO_DATE(:pv_to_plandate,''YYYYMMDDHH24MISS'')'
                     ||v_line||' AND B.N1ST_NOD_CD = :pv_node';
    END IF;

    v_select6 := v_select6||' AND   A.CNTR_TPSZ_CD = :pv_eq_tpsz_cd';
    
    v_select6 := v_select6||' AND   SUBSTR(B.COST_ACT_GRP_CD, 3) IN (''TD'', ''WT'', ''TR'', ''TW'', ''RT'') ';

    /* 미주 Rail일 경우엔 Mexico는 제외한다. */
    IF p_ui_conti_cd = 'M' THEN
        v_select6 := v_select6||''
                     ||v_line|| ' AND B.INLND_ROUT_INV_BIL_PATT_CD IS NULL ';
    END IF;

    v_sub_end := v_line||' ) AA WHERE 1=1 ';

    IF p_costmode = 'CY' THEN
        v_costmode := v_line||' AND (AA.TRSP_COST_DTL_MOD_CD = ''CY'' AND AA.EQ_NO <> ''HJCU0000000'') ';
    END IF;

    BEGIN
        EXECUTE IMMEDIATE v_select1 || v_select2 || v_select3 || v_select4 || v_select5 || v_select6 
                      || v_sub_end
                      || v_costmode
                      USING p_so_office, p_frm_plandate, p_to_plandate, p_node, p_eq_tpsz_cd
                      ;
    EXCEPTION
        WHEN OTHERS THEN
            INSERT INTO TRS_SVC_ORD_LOG_GLO_TMP (LOG_TP_CD
                        ,LOG_SQL_CTNT1, LOG_SQL_CTNT2,LOG_SQL_CTNT3,LOG_SQL_CTNT4
                        ,CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID)
                 VALUES ('ERR',
                         v_select1, v_select2||v_select3,v_select4||v_select5||v_select6,
                            v_sub_end
                         || v_costmode
                         ,SYSDATE, 'PKG', SYSDATE, 'PKG'
                        );
            COMMIT;
            user_err_msg := 'EXECUTE IMMEDIATE ERROR ';
            RAISE user_define_error;
    END;

    /* 2.1 Customer 자료 UPDATE */
    /* temp insert시 입력 inline view 사용을 피하기 위하여 update로 처리 
       TRO 정보조회시 필요하므로 RETURN CURSOR 전에 데이타가 존재하여야 한다.
    */
    BEGIN
        UPDATE TRS_TRSP_SVC_ORD_GLO_TMP X
           SET (X.SHPR_CUST_CNT_CD, X.SHPR_CUST_SEQ, X.SHPR_CUST_NM) = 
                   (SELECT U.CUST_CNT_CD,
                           U.CUST_SEQ,
                           REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')
                      FROM BKG_CUSTOMER U
                     WHERE U.BKG_NO = X.BKG_NO
                       AND U.BKG_CUST_TP_CD = 'S')
              ,(X.CNEE_CUST_CNT_CD, X.CNEE_CUST_SEQ, X.CNEE_CUST_NM) = 
                   (SELECT U.CUST_CNT_CD,
                           U.CUST_SEQ,
                           REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')
                      FROM BKG_CUSTOMER U
                     WHERE U.BKG_NO = X.BKG_NO
                       AND U.BKG_CUST_TP_CD = 'C')
              ,(X.NTFY_CUST_NM) = 
                   (SELECT REPLACE(NVL(U.CUST_NM, ' '),CHR(13)||CHR(10),' ')
                      FROM BKG_CUSTOMER U
                     WHERE U.BKG_NO = X.BKG_NO
                       AND U.BKG_CUST_TP_CD = 'N')
              ,(X.CNTR_PKUP_NO, X.AVAL_DT, X.LST_FREE_DT) = 
                   (SELECT PU.PKUP_NO, PU.PKUP_AVAL_DT, PU.LST_FREE_DT
                      FROM BKG_PKUP_NTC_PKUP_NO PU
                     WHERE PU.BKG_NO = X.BKG_NO
                       AND PU.CNTR_NO = X.EQ_NO
                       AND PU.OFC_CD = X.CTRL_OFC_CD)
               ;
    EXCEPTION
        WHEN OTHERS THEN
            user_err_msg := '2.1 Customer info Update Error';
            RAISE user_define_error;
    END;

    /****************************************************************/
    /* 2.추가로 필요한 자료를 조회하기 위하여 Loop를 돌기 시작      */
    /****************************************************************/

    FOR CUR_DATA IN (SELECT BKG_NO, EQ_NO, CMDT_CD, COP_NO, COST_ACT_GRP_SEQ
                            ,TRSP_COST_DTL_MOD_CD, FM_NOD_CD, TO_NOD_CD, TRSP_BND_CD
                            ,FM_LOC_CONTI_CD, DOR_NOD_CD, DOR_NOD_YD_NO, BL_NO
                            ,SHPR_CUST_CNT_CD, SHPR_CUST_SEQ, SHPR_CUST_NM, CNEE_CUST_CNT_CD, CNEE_CUST_SEQ, CNEE_CUST_NM, NTFY_CUST_NM
                            ,SUBSTR(BKG_TRO_NO, 1, INSTR(BKG_TRO_NO, '$', 1, 1) - 1) TRO_SEQ
                            ,SUBSTR(BKG_TRO_NO, INSTR(BKG_TRO_NO, '$', 1, 1) + 1) TRO_SUB_SEQ
                       FROM TRS_TRSP_SVC_ORD_GLO_TMP
                    ) LOOP
        /*************************************************************/
        /* 3. US D/O, TRO, CUSTOMER 정보 조회                        */
        /*************************************************************/
        /* 3.1 EUR TRO 정보 조회 */
        IF CUR_DATA.TRSP_COST_DTL_MOD_CD = 'DOOR' AND p_ui_conti_cd = 'E' THEN
            IF CUR_DATA.TRO_SEQ IS NOT NULL THEN
                BEGIN
                    SELECT HD.ACT_CNT_CD||HD.ACT_CUST_SEQ  AS ACT_CUST_CD
                         , HD.ACT_CNT_CD   AS ACT_CUST_CNT_CD
                         , HD.ACT_CUST_SEQ AS ACT_CUST_SEQ
                         , HD.TRO_PROC_CD  AS TRSP_RQST_ORD_SO_CFM_IND_CD
                         , HD.CSTMS_CLR_NO AS CSTMS_CLR_NO
                         , HD.REP_CMDT_CD  AS REP_CMDT_CD
                         , HD.CURR_CD      AS REV_CURR_CD
                         , NVL(HD.TRNS_REV_AMT,0)+NVL(HD.NMF_TRNS_REV_AMT, 0) AS TRSP_RQST_ORD_REV_AMT
                         , HD.CFM_OFC_CD   AS TRO_CFM_OFC_CD
                         , HD.CFM_USR_ID   AS TRO_CFM_USR_ID
                         , HD.CFM_UPD_DT   AS TRO_CFM_UPD_DT
                         , HD.CFM_REV_AMT  AS TRO_CFM_REV_AMT
                         , HD.CFM_CURR_CD  AS TRO_CFM_CURR_CD
                         , HD.REP_CMDT_CD  AS TRO_REP_CMDT_CD
                         , HD.IO_BND_CD    AS TRSP_RQST_ORD_BND_CD
                         , HD.TRO_SEQ      AS TRSP_RQST_ORD_SEQ
                         , HD.CGO_WGT      AS CNTR_WGT
                         , HD.DCGO_SEQ     AS DCGO_SEQ
                         , HD.RC_SEQ       AS RC_SEQ
                         , HD.AWK_CGO_SEQ  AS AWK_CGO_SEQ
                      INTO v_act_cust_cd
                         , v_act_cust_cnt_cd
                         , v_act_cust_seq
                         , v_trsp_rqst_ord_so_cfm_ind_cd
                         , v_cstms_clr_no
                         , v_rep_cmdt_cd
                         , v_rev_curr_cd
                         , v_trsp_rqst_ord_rev_amt
                         , v_tro_cfm_ofc_cd
                         , v_tro_cfm_usr_id
                         , v_tro_cfm_upd_dt
                         , v_tro_cfm_rev_amt
                         , v_tro_cfm_curr_cd
                         , v_tro_rep_cmdt_cd
                         , v_trsp_rqst_ord_bnd_cd
                         , v_trsp_rqst_ord_seq
                         , v_cntr_wgt
                         , v_dcgo_seq
                         , v_rc_seq
                         , v_awk_cgo_seq
                      FROM BKG_EUR_TRO HD
                     WHERE HD.BKG_NO      = CUR_DATA.BKG_NO
                       AND HD.IO_BND_CD   = CUR_DATA.TRSP_BND_CD
                       AND HD.TRO_SEQ     = CUR_DATA.TRO_SEQ;
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                           v_act_cust_cd            := '';
                           v_act_cust_cnt_cd        := '';
                           v_act_cust_seq           := NULL;
                           v_trsp_rqst_ord_so_cfm_ind_cd        := '';
                           v_cstms_clr_no           := '';
                           v_rep_cmdt_cd            := '';
                           v_rev_curr_cd            := '';
                           v_trsp_rqst_ord_rev_amt  := NULL;
                           v_tro_cfm_ofc_cd         := '';
                           v_tro_cfm_usr_id         := '';
                           v_tro_cfm_upd_dt         := NULL;
                           v_tro_cfm_rev_amt        := NULL;
                           v_tro_cfm_curr_cd        := '';
                           v_tro_rep_cmdt_cd        := '';
                           v_trsp_rqst_ord_bnd_cd   := '';
                           v_trsp_rqst_ord_seq      := NULL;
                           v_cntr_wgt               := NULL;
                           v_dcgo_seq               := NULL;
                           v_rc_seq                 := NULL;
                           v_awk_cgo_seq            := NULL;
                    WHEN OTHERS THEN
                        user_err_msg := '3.1 EUR TRO (BKG_NO : ' || CUR_DATA.BKG_NO || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', TRO_SEQ : ' || CUR_DATA.TRO_SEQ ||')';
                        RAISE user_define_error;
                END;

                /* 3.2. EUR TRO DETAIL 정보 조회1 */
                BEGIN
                    SELECT  DTL.DOR_ADDR_TP_CD
                           ,DTL.ARR_DT      AS DOR_ARR_DT
                           ,DTL.LOD_REF_NO  AS TRO_LOD_REF_NO
                           ,DTL.DOR_ZIP_ID  AS DOR_PST_CD
                           ,RTRIM(SUBSTR(DTL.DOR_ADDR,31,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,61,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,91,30)) AS DOR_DE_ADDR
                           ,SUBSTR(DTL.DOR_ADDR,1,30) AS FCTRY_NM
                           ,DTL.CNTC_PHN_NO  AS CNTC_PSON_PHN_NO
                           ,DTL.CNTC_PSON_NM AS CNTC_PSON_NM
                           ,(CASE WHEN (SELECT COUNT(1)
                                          FROM BKG_EUR_TRO_DTL X
                                         WHERE X.BKG_NO      = DTL.BKG_NO
                                           AND X.IO_BND_CD   = DTL.IO_BND_CD
                                           AND X.TRO_SEQ     = DTL.TRO_SEQ
                                           AND X.TRO_SEQ     = CUR_DATA.TRO_SEQ) > 1 THEN 'Y'
                                 ELSE '' END) MLT_STOP_DE_FLG
                      INTO  v_dor_addr_tp_cd1
                           ,v_dor_arr_dt
                           ,v_tro_lod_ref_no
                           ,v_dor_pst_cd
                           ,v_dor_de_addr
                           ,v_fctry_nm
                           ,v_cntc_pson_phn_no
                           ,v_cntc_pson_nm
                           ,v_mlt_stop_de_flg
                      FROM BKG_EUR_TRO_DTL DTL
                     WHERE BKG_NO      = CUR_DATA.BKG_NO
                       AND IO_BND_CD   = CUR_DATA.TRSP_BND_CD
                       AND TRO_SEQ     = CUR_DATA.TRO_SEQ
                       AND TRO_SUB_SEQ = 1;
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                        v_dor_addr_tp_cd1  := '';
                        v_dor_arr_dt       := '';
                        v_tro_lod_ref_no   := '';
                        v_dor_pst_cd       := '';
                        v_dor_de_addr      := '';
                        v_fctry_nm         := '';
                        v_cntc_pson_phn_no := '';
                        v_cntc_pson_nm     := '';
                        v_mlt_stop_de_flg  := '';
                    WHEN OTHERS THEN
                        user_err_msg := '3.2 EUR TRO DTL1 (BKG_NO : ' || CUR_DATA.BKG_NO || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', TRO_SEQ : ' || CUR_DATA.TRO_SEQ ||')';
                        RAISE user_define_error;
                END;

                /* 3.3. EUR TRO DETAIL 정보 조회2 */
                IF v_dor_addr_tp_cd1 != 'D' THEN
                    BEGIN
                        SELECT  DTL.DOR_ADDR_TP_CD
                               ,DTL.ARR_DT      AS DOR_ARR_DT
                               ,DTL.LOD_REF_NO  AS TRO_LOD_REF_NO
                               ,DTL.DOR_ZIP_ID  AS DOR_PST_CD
                               ,RTRIM(SUBSTR(DTL.DOR_ADDR,31,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,61,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,91,30)) AS DOR_DE_ADDR
                               ,SUBSTR(DTL.DOR_ADDR,1,30) AS FCTRY_NM
                               ,DTL.CNTC_PHN_NO  AS CNTC_PSON_PHN_NO
                               ,DTL.CNTC_PSON_NM AS CNTC_PSON_NM
                          INTO  v_dor_addr_tp_cd2
                               ,v_dor_arr_dt
                               ,v_tro_lod_ref_no
                               ,v_dor_pst_cd
                               ,v_dor_de_addr
                               ,v_fctry_nm
                               ,v_cntc_pson_phn_no
                               ,v_cntc_pson_nm
                          FROM BKG_EUR_TRO_DTL DTL
                         WHERE BKG_NO      = CUR_DATA.BKG_NO
                           AND IO_BND_CD   = CUR_DATA.TRSP_BND_CD
                           AND TRO_SEQ     = CUR_DATA.TRO_SEQ
                           AND TRO_SUB_SEQ = 2;
                    EXCEPTION
                        WHEN NO_DATA_FOUND THEN
                            v_dor_addr_tp_cd2  := '';
                            v_dor_arr_dt       := '';
                            v_tro_lod_ref_no   := '';
                            v_dor_pst_cd       := '';
                            v_dor_de_addr      := '';
                            v_fctry_nm         := '';
                            v_cntc_pson_phn_no := '';
                            v_cntc_pson_nm     := '';
                        WHEN OTHERS THEN
                            user_err_msg := '3.3 EUR TRO DTL2 (BKG_NO : ' || CUR_DATA.BKG_NO || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', TRO_SEQ : ' || CUR_DATA.TRO_SEQ ||')';
                            RAISE user_define_error;
                    END;
                END IF;

                /* 3.4. EUR TRO DETAIL 정보 조회3 */
                IF v_dor_addr_tp_cd2 != 'D' THEN
                    BEGIN
                        SELECT  DTL.ARR_DT      AS DOR_ARR_DT
                               ,DTL.LOD_REF_NO  AS TRO_LOD_REF_NO
                               ,DTL.DOR_ZIP_ID  AS DOR_PST_CD
                               ,RTRIM(SUBSTR(DTL.DOR_ADDR,31,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,61,30))||' '||RTRIM(SUBSTR(DTL.DOR_ADDR,91,30)) AS DOR_DE_ADDR
                               ,SUBSTR(DTL.DOR_ADDR,1,30) AS FCTRY_NM
                               ,DTL.CNTC_PHN_NO  AS CNTC_PSON_PHN_NO
                               ,DTL.CNTC_PSON_NM AS CNTC_PSON_NM
                          INTO  v_dor_arr_dt
                               ,v_tro_lod_ref_no
                               ,v_dor_pst_cd
                               ,v_dor_de_addr
                               ,v_fctry_nm
                               ,v_cntc_pson_phn_no
                               ,v_cntc_pson_nm
                          FROM BKG_EUR_TRO_DTL DTL
                         WHERE BKG_NO      = CUR_DATA.BKG_NO
                           AND IO_BND_CD   = CUR_DATA.TRSP_BND_CD
                           AND TRO_SEQ     = CUR_DATA.TRO_SEQ
                           AND TRO_SUB_SEQ = 3;
                    EXCEPTION
                        WHEN NO_DATA_FOUND THEN
                            v_dor_arr_dt       := '';
                            v_tro_lod_ref_no   := '';
                            v_dor_pst_cd       := '';
                            v_dor_de_addr      := '';
                            v_fctry_nm         := '';
                            v_cntc_pson_phn_no := '';
                            v_cntc_pson_nm     := '';
                        WHEN OTHERS THEN
                            user_err_msg := '3.4 EUR TRO DTL3 (BKG_NO : ' || CUR_DATA.BKG_NO || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', TRO_SEQ : ' || CUR_DATA.TRO_SEQ ||')';
                            RAISE user_define_error;
                    END;
                END IF;
            ELSE
                /* 3.5. TRO 정보가 없을 경우엔 CUSTOMER 테이블에서 DOOR 주소를 조회 */
                BEGIN
                    SELECT  
                            ATH.ACT_CUST_CNT_CD||ATH.ACT_CUST_SEQ   AS ACT_CUST_CD
                           ,ATH.ACT_CUST_CNT_CD   AS ACT_CUST_CNT_CD
                           ,ATH.ACT_CUST_SEQ      AS ACT_CUST_SEQ
                           ,ATD.ACT_CUST_ZIP_CD   AS DOR_PST_CD
                           ,ATD.ACT_CUST_ADDR     AS DOR_DE_ADDR
                           ,ATD.ACT_CUST_NM       AS FCTRY_NM
                           ,ATD.ACT_CUST_PHN_NO   AS CNTC_PSON_PHN_NO
                           ,ATD.ACT_CUST_FAX_NO   AS CNTC_PSON_FAX_NO
                           ,ATD.CNTC_PSON_NM      AS CNTC_PSON_NM
                           ,ATD.TRSP_ACT_CUST_SEQ AS ACT_CUST_ADDR_SEQ
                      INTO  v_act_cust_cd
                           ,v_act_cust_cnt_cd
                           ,v_act_cust_seq
                           ,v_dor_pst_cd
                           ,v_dor_de_addr
                           ,v_fctry_nm
                           ,v_cntc_pson_phn_no
                           ,v_cntc_pson_fax_no
                           ,v_cntc_pson_nm
                           ,v_act_cust_addr_seq
                      FROM TRS_TRSP_USA_ACT_CUST        ATH
                         , TRS_TRSP_USA_ACT_CUST_DTL    ATD
                     WHERE 1 = 1
                       AND ATH.TRSP_ACT_CUST_NO = ATD.TRSP_ACT_CUST_NO
                       AND ATH.ACT_CUST_CNT_CD = DECODE(CUR_DATA.TRSP_BND_CD, 'I', CUR_DATA.CNEE_CUST_CNT_CD, 'O',CUR_DATA.SHPR_CUST_CNT_CD )
                       AND ATH.ACT_CUST_CNT_CD = DECODE(CUR_DATA.TRSP_BND_CD, 'I', CUR_DATA.CNEE_CUST_SEQ, 'O',CUR_DATA.SHPR_CUST_SEQ )
                       AND ATH.DOR_NOD_CD      = CUR_DATA.DOR_NOD_CD||CUR_DATA.DOR_NOD_YD_NO
                       AND ATH.ACT_CUST_BND_CD = CUR_DATA.TRSP_BND_CD
                       AND ATD.DFLT_ACT_CUST_FLG = 'Y'
                       AND ATH.DELT_FLG = 'N'
                       AND ATD.DELT_FLG = 'N';
                   EXCEPTION
                       WHEN NO_DATA_FOUND THEN
                           v_act_cust_cd      := '';
                           v_act_cust_cnt_cd  := '';
                           v_act_cust_seq     := NULL;
                           v_dor_pst_cd       := '';
                           v_dor_de_addr      := '';
                           v_fctry_nm         := '';
                           v_cntc_pson_phn_no := '';
                           v_cntc_pson_fax_no := '';
                           v_cntc_pson_nm     := '';
                           v_act_cust_addr_seq := '';
                       WHEN OTHERS THEN
                           user_err_msg := '3.5 CUSTOMER (CNEE_CUST_SEQ : ' || CUR_DATA.CNEE_CUST_SEQ || 'SHPR_CUST_SEQ : ' || CUR_DATA.SHPR_CUST_SEQ || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', DOR_NOD_CD : ' || CUR_DATA.DOR_NOD_CD||CUR_DATA.DOR_NOD_YD_NO ||')';
                           RAISE user_define_error;
                END;
            END IF; -- IF CUR_DATA.TRO_SEQ IS NOT NULL THEN 
            
        END IF;
        
        /*************************************************************/
        /* 미주 DO, TRO, CUSTOMER 정보 조회                          */
        /* 미주 : DO, TRO, CUSTOMER 순으로 조회                      */
        /* 아주 : TRO, CUSTOMER 순으로 조회                          */
        /*************************************************************/ 
        /* 3.6. AMERICA US D/O 정보 조회 */
        IF CUR_DATA.TRSP_COST_DTL_MOD_CD = 'DOOR' AND (p_ui_conti_cd = 'M' OR p_ui_conti_cd = 'A') THEN
            IF p_ui_conti_cd = 'M' THEN
                BEGIN
                    SELECT  DOH.ACT_CUST_ZIP_CD                              DOR_PST_CD
                          , DOH.FCTRY_NM                                     FCTRY_NM
                          , DOH.ACT_CUST_N1ST_ADDR||' '||DOH.ACT_CUST_CTY_NM DOR_DE_ADDR
                          , DOH.CNTC_PSON_PHN_NO                             CNTC_PSON_PHN_NO
                          , DOH.CNTC_PSON_FAX_NO                             CNTC_PSON_FAX_NO
                          , DOH.CNTC_PSON_NM                                 CNTC_PSON_NM
                          , DOD.DO_RMK                                       SPCL_INSTR_RMK
                          , CASE WHEN DOH.IF_SYS_KND_CD = 'W' THEN
                                 DOH.USR_EML ||
                                 CASE WHEN DOH.USR_EML IS NOT NULL AND DOH.USR_PHN_NO IS NOT NULL THEN ' / ' END || DOH.USR_PHN_NO
                                 ELSE DOH.CRE_USR_ID
                            END USA_DO_USR_INFO
                          , NVL(DOH.UPD_DT, DOH.CRE_DT)                        DO_DT
                          , CASE WHEN DOH.IF_SYS_KND_CD = 'W' THEN 'WEB' 
                                 WHEN DOH.IF_SYS_KND_CD = 'E' THEN 'TRS D/O'
                            END ACT_CUST_CD
                      INTO  v_dor_pst_cd
                          , v_fctry_nm
                          , v_dor_de_addr
                          , v_cntc_pson_phn_no
                          , v_cntc_pson_fax_no
                          , v_cntc_pson_nm
                          , v_spcl_instr_rmk
                          , v_usa_do_usr_info
                          , v_do_dt
                          , v_act_cust_cd
                      FROM  TRS_TRSP_USA_DO_HDR DOH,
                            TRS_TRSP_USA_DO_DTL DOD
                     WHERE  DOH.BL_NO   = DOD.BL_NO
                       AND  DOH.BL_NO   = CUR_DATA.BL_NO
                       AND  DOD.EQ_NO   = CUR_DATA.EQ_NO;
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                       v_dor_pst_cd       := '';
                       v_fctry_nm         := '';
                       v_dor_de_addr      := '';
                       v_cntc_pson_phn_no := '';
                       v_cntc_pson_fax_no := '';
                       v_cntc_pson_nm     := '';
                       v_spcl_instr_rmk   := '';
                       v_usa_do_usr_info  := '';
                       v_do_dt        := NULL;
                       v_act_cust_cd      := '';
                   WHEN OTHERS THEN
                       user_err_msg := '3.6 AMERICA US D/O (BL_NO : ' || CUR_DATA.BL_NO ||')';
                       RAISE user_define_error;
                END;
            END IF;

            /* 3.7. US D/O가 없을 경우TRO 정보 조회  */
            IF v_act_cust_cd = '' THEN
                BEGIN
                    SELECT  DOR_PST_NO       AS DOR_PST_CD
                          , ACT_SHPR_NM      AS FCTRY_NM 
                          , ACT_SHPR_CNT_CD  AS ACT_CUST_CNT_CD
                          , ACT_SHPR_SEQ     AS ACT_CUST_SEQ
                          , ACT_SHPR_CNT_CD || ACT_SHPR_SEQ AS ACT_CUST_CD
                          , ACT_SHPR_ADDR    AS DOR_DE_ADDR
                          , ACT_SHPR_PHN_NO  AS CNTC_PSON_PHN_NO
                          , CNTC_FAX_NO      AS CNTC_PSON_FAX_NO
                          , CNTC_PSON_NM     AS CNTC_PSON_NM
                          , CFM_FLG          AS TRSP_RQST_ORD_SO_CFM_IND_CD
                          , CFM_DT
                          , DIFF_RMK         AS TRSP_RQST_ORD_RMK 
                     INTO   v_dor_pst_cd 
                          , v_fctry_nm
                          , v_act_cust_cnt_cd
                          , v_act_cust_seq
                          , v_act_cust_cd
                          , v_dor_de_addr
                          , v_cntc_pson_phn_no
                          , v_cntc_pson_fax_no
                          , v_cntc_pson_nm
                          , v_trsp_rqst_ord_so_cfm_ind_cd
                          , v_tro_cfm_upd_dt
                          , v_spcl_instr_rmk
                     FROM BKG_TRO
                    WHERE BKG_NO      = CUR_DATA.BKG_NO
                      AND IO_BND_CD   = CUR_DATA.TRSP_BND_CD
                      AND RTN_TRO_FLG = 'N'
                      AND TRO_SEQ     = CUR_DATA.TRO_SEQ; 
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                        v_dor_pst_cd       := '';
                        v_fctry_nm         := '';
                        v_act_cust_cnt_cd  := '';
                        v_act_cust_seq     := NULL;
                        v_act_cust_cd      := '';
                        v_dor_de_addr      := '';
                        v_cntc_pson_phn_no := '';
                        v_cntc_pson_fax_no := '';
                        v_cntc_pson_nm     := '';
                        v_trsp_rqst_ord_so_cfm_ind_cd  := '';
                        v_tro_cfm_upd_dt   := NULL;
                        v_spcl_instr_rmk   := '';
                    WHEN OTHERS THEN
                        user_err_msg := '3.7 AMERICA US D/O (BL_NO : ' || CUR_DATA.BL_NO ||')';
                        RAISE user_define_error;
                END;
            END IF;

            /* 3.8. TRO 정보가 없을 경우엔 CUSTOMER 테이블에서 DOOR 주소를 조회 */
            IF v_act_cust_cd = '' THEN
                BEGIN
                    SELECT  
                            ATH.ACT_CUST_CNT_CD||ATH.ACT_CUST_SEQ   AS ACT_CUST_CD
                           ,ATH.ACT_CUST_CNT_CD   AS ACT_CUST_CNT_CD
                           ,ATH.ACT_CUST_SEQ      AS ACT_CUST_SEQ
                           ,ATD.ACT_CUST_ZIP_CD   AS DOR_PST_CD
                           ,ATD.ACT_CUST_ADDR     AS DOR_DE_ADDR
                           ,ATD.ACT_CUST_NM       AS FCTRY_NM
                           ,ATD.ACT_CUST_PHN_NO   AS CNTC_PSON_PHN_NO
                           ,ATD.ACT_CUST_FAX_NO   AS CNTC_PSON_FAX_NO
                           ,ATD.CNTC_PSON_NM      AS CNTC_PSON_NM
                           ,ATD.TRSP_ACT_CUST_SEQ AS ACT_CUST_ADDR_SEQ
                      INTO  v_act_cust_cd
                           ,v_act_cust_cnt_cd
                           ,v_act_cust_seq
                           ,v_dor_pst_cd
                           ,v_dor_de_addr
                           ,v_fctry_nm
                           ,v_cntc_pson_phn_no
                           ,v_cntc_pson_fax_no
                           ,v_cntc_pson_nm
                           ,v_act_cust_addr_seq
                      FROM TRS_TRSP_USA_ACT_CUST        ATH
                         , TRS_TRSP_USA_ACT_CUST_DTL    ATD
                     WHERE 1 = 1
                       AND ATH.TRSP_ACT_CUST_NO = ATD.TRSP_ACT_CUST_NO
                       AND ATH.ACT_CUST_CNT_CD = DECODE(CUR_DATA.TRSP_BND_CD, 'I', CUR_DATA.CNEE_CUST_CNT_CD, 'O',CUR_DATA.SHPR_CUST_CNT_CD )
                       AND ATH.ACT_CUST_CNT_CD = DECODE(CUR_DATA.TRSP_BND_CD, 'I', CUR_DATA.CNEE_CUST_SEQ, 'O',CUR_DATA.SHPR_CUST_SEQ )
                       AND ATH.DOR_NOD_CD      = CUR_DATA.DOR_NOD_CD||CUR_DATA.DOR_NOD_YD_NO
                       AND ATH.ACT_CUST_BND_CD = CUR_DATA.TRSP_BND_CD
                       AND ATD.DFLT_ACT_CUST_FLG = 'Y'
                       AND ATH.DELT_FLG = 'N'
                       AND ATD.DELT_FLG = 'N';
                   EXCEPTION
                       WHEN NO_DATA_FOUND THEN
                           v_act_cust_cd      := '';
                           v_act_cust_cnt_cd  := '';
                           v_act_cust_seq     := NULL;
                           v_dor_pst_cd       := '';
                           v_dor_de_addr      := '';
                           v_fctry_nm         := '';
                           v_cntc_pson_phn_no := '';
                           v_cntc_pson_fax_no := '';
                           v_cntc_pson_nm     := '';
                           v_act_cust_addr_seq := '';
                       WHEN OTHERS THEN
                           user_err_msg := '3.8 CUSTOMER (CNEE_CUST_SEQ : ' || CUR_DATA.CNEE_CUST_SEQ || 'SHPR_CUST_SEQ : ' || CUR_DATA.SHPR_CUST_SEQ || ', TRSP_BND_CD : ' || CUR_DATA.TRSP_BND_CD || ', DOR_NOD_CD : ' || CUR_DATA.DOR_NOD_CD||CUR_DATA.DOR_NOD_YD_NO ||')';
                           RAISE user_define_error;
                END;
            END IF;
        END IF;

        /*************************************************************/
        /* 4. 조회 정보 UPDATE                                       */
        /*************************************************************/
        /* 4.1 추가 자료 UPDATE */
        UPDATE  TRS_TRSP_SVC_ORD_GLO_TMP                                                                 
               /* 여기서 부터는 DOOR 건만 해당된다. */
              SET TRO_SEQ            = CUR_DATA.TRO_SEQ
              ,TRO_SUB_SEQ           = CUR_DATA.TRO_SUB_SEQ
              ,ACT_CUST_CD           = v_act_cust_cd
              ,ACT_CUST_CNT_CD       = v_act_cust_cnt_cd
              ,ACT_CUST_SEQ          = v_act_cust_seq
              ,TRSP_RQST_ORD_SO_CFM_IND_CD       = v_trsp_rqst_ord_so_cfm_ind_cd
              ,CSTMS_CLR_NO          = v_cstms_clr_no
              ,REP_CMDT_CD           = v_rep_cmdt_cd
              ,REV_CURR_CD           = v_rev_curr_cd
              ,TRSP_RQST_ORD_REV_AMT = v_trsp_rqst_ord_rev_amt
              ,TRO_CFM_OFC_CD        = v_tro_cfm_ofc_cd
              ,TRO_CFM_USR_ID        = v_tro_cfm_usr_id
              ,TRO_CFM_UPD_DT        = v_tro_cfm_upd_dt
              ,TRO_CFM_REV_AMT       = v_tro_cfm_rev_amt
              ,TRO_CFM_CURR_CD       = v_tro_cfm_curr_cd
              ,TRO_REP_CMDT_CD       = v_tro_rep_cmdt_cd
              ,TRSP_RQST_ORD_BND_CD  = v_trsp_rqst_ord_bnd_cd
              ,TRSP_RQST_ORD_SEQ     = v_trsp_rqst_ord_seq
              ,CNTR_WGT              = v_cntr_wgt
              ,DOR_ARR_DT            = v_dor_arr_dt
              ,TRO_LOD_REF_NO        = v_tro_lod_ref_no
              ,DOR_PST_CD            = v_dor_pst_cd
              ,DOR_DE_ADDR           = v_dor_de_addr
              ,FCTRY_NM              = v_fctry_nm
              ,CNTC_PSON_PHN_NO      = v_cntc_pson_phn_no
              ,CNTC_PSON_FAX_NO      = v_cntc_pson_fax_no
              ,CNTC_PSON_NM          = v_cntc_pson_nm
              ,MLT_STOP_DE_FLG       = v_mlt_stop_de_flg
              ,SPCL_INSTR_RMK        = v_spcl_instr_rmk
              ,DO_CTNT               = v_usa_do_usr_info
              ,DO_DT                 = v_do_dt
              ,DCGO_SEQ              = v_dcgo_seq
              ,RC_SEQ                = v_rc_seq
              ,AWK_CGO_SEQ           = v_awk_cgo_seq
              ,ACT_CUST_ADDR_SEQ     = v_act_cust_addr_seq
         WHERE COP_NO           = CUR_DATA.COP_NO
           AND COST_ACT_GRP_SEQ = CUR_DATA.COST_ACT_GRP_SEQ;

    END LOOP;
    
    /*************************************************************/
    /* 대상 추출 SQL을 LOG 테이블에 저장                         */
    /*************************************************************/
    INSERT INTO TRS_SVC_ORD_LOG_GLO_TMP (LOG_TP_CD
                ,LOG_SQL_CTNT1, LOG_SQL_CTNT2,LOG_SQL_CTNT3,LOG_SQL_CTNT4
                ,CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID)
         VALUES( 'OK',
                 v_select1, v_select2||v_select3,v_select4||v_select5||v_select6,
                 v_sub_end
              || v_costmode
              ,SYSDATE, 'PKG', SYSDATE, 'PKG'
         );

    COMMIT;

    FOR RET_DATA IN CUR_DATA LOOP
        PIPE ROW(RET_DATA);
    END LOOP;

    RETURN;

EXCEPTION
    WHEN user_define_error THEN
        RAISE_APPLICATION_ERROR(-20001, user_err_msg);
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'TRS_CYDOOR_PKG Error');
END F_GET_CY_CANDIDATE ;

END TRS_CYDOOR_CB2_PKG;
