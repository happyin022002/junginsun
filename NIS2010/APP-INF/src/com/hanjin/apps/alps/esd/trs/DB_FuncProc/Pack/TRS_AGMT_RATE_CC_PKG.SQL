CREATE OR REPLACE PACKAGE TRS_AGMT_RATE_CC_PKG  
AUTHID CURRENT_USER  
IS  
/*###################################################################  
 # -- Type    : FUNCTION  
 # -- Author  : JONG HYEK CHOI  
 # -- Created : MAY 1, 2010  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : GET NODE COUNT  
#####################################################################*/  
FUNCTION GET_LINK_CNT_FNC  
(  
    pi_from_nod_cd       VARCHAR2  
   ,pi_via_nod_cd        VARCHAR2  
   ,pi_door_nod_cd       VARCHAR2  
   ,pi_to_nod_cd         VARCHAR2  
) RETURN NUMBER;  
  
/*###################################################################  
 # -- Type    : FUNCTION  
 # -- Author  : JONG HYEK CHOI  
 # -- Created : MAY 1, 2010  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM KILOMETER BETWEEN TWO NODES  
#####################################################################*/  
FUNCTION GET_CAL_DIST_2_NOD_FNC  
(  
    pi_dist_uom          VARCHAR2  
   ,pi_start_nod_cd      VARCHAR2  
   ,pi_end_nod_cd        VARCHAR2  
) RETURN NUMBER;  
  
/*###################################################################  
 # -- Type    : FUNCTION  
 # -- Author  : JONG HYEK CHOI  
 # -- Created : MAY 1, 2010  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM BETWEEN TWO NODES  
#####################################################################*/  
FUNCTION GET_CAL_DIST_BTWN_NOD_FNC  
(  
    pi_dist_uom          VARCHAR2  
   ,pi_agmt_rt_tp        VARCHAR2           /* P, PD, DP, D */  
   ,pi_cost_mod_cd       VARCHAR2           /* DR, Non-DR   */  
   ,pi_bound_cd          VARCHAR2           /* I, O         */  
   ,pi_from_nod_cd       VARCHAR2  
   ,pi_via_nod_cd        VARCHAR2  
   ,pi_door_nod_cd       VARCHAR2  
   ,pi_to_nod_cd         VARCHAR2  
) RETURN NUMBER;  
  
/*###################################################################  
 # -- Type    : PROCEDURE  
 # -- Author  : JONG HYEK CHOI  
 # -- Created : MAY 1, 2010  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : BASIC RATE CALCULATION MODULE  
#####################################################################*/  
PROCEDURE GET_BASIC_RATE_CALCULATION_PRC  
(  
    pi_system_indicator         IN  VARCHAR2    /* TRS, COA */  
   ,pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */  
   ,pi_trsp_agmt_ofc_cty_cd     IN  VARCHAR2  
   ,pi_trsp_agmt_seq            IN  NUMBER  
   ,pi_agmt_eq_knd              IN  VARCHAR2    /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */  
   ,pi_link_cnt                 IN  NUMBER      /* COUNT OF LINK FORM TRANSPORTATION   */  
   ,pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */  
   ,pi_vndr_seq                 IN  VARCHAR2  
   ,pi_basis_dt                 IN  DATE  
   ,pi_way_tp_cd                IN  VARCHAR2    /* ONEWAY or ROUNDTRIP      */  
   ,pi_eq_knd_cd                IN  VARCHAR2  
   ,pi_eq_tp_sz_cd              IN  VARCHAR2  
   ,pi_cmb_tp_cd                IN  VARCHAR2  
   ,pi_cgo_tp_cd                IN  VARCHAR2  
   ,pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */  
   ,pi_crr_mod_cd               IN  VARCHAR2  
   ,pi_cost_mod_cd              IN  VARCHAR2  
   ,pi_cust_nomi_trkr_ind_cd    IN  VARCHAR2    /*  CUST_NOMI_TRKR_IND_CD */  
   ,pi_cust_cnt_cd              IN  VARCHAR2  
   ,pi_cust_seq                 IN  NUMBER  
   ,pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */  
   ,pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */  
   ,pi_from_nod_cd              IN  VARCHAR2  
   ,pi_via_nod_cd               IN  VARCHAR2  
   ,pi_door_nod_cd              IN  VARCHAR2  
   ,pi_to_nod_cd                IN  VARCHAR2  
   ,pi_bundle_cnt               IN  NUMBER  
   ,pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
   ,pi_wgt_qty                  IN  NUMBER  
   ,pi_rcv_term                 IN  VARCHAR2  
   ,pi_de_term                  IN  VARCHAR2  
   ,pi_trsp_rvs_aply_flg        IN  VARCHAR2  
   ,pi_debug_flg                IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)  
   ,po_trsp_agmt_ofc_cty_cd     OUT VARCHAR2  
   ,po_trsp_agmt_seq            OUT NUMBER  
   ,po_trsp_agmt_rt_tp_ser_no   OUT NUMBER  
   ,po_vndr_seq                 OUT NUMBER  
   ,po_cust_nomi_trkr_flg       OUT VARCHAR2  
   ,po_cust_cnt_cd              OUT VARCHAR2  
   ,po_cust_seq                 OUT NUMBER  
   ,po_trsp_agmt_rt_tp_cd       OUT VARCHAR2  
   ,po_way_type                 OUT VARCHAR2  
   ,po_curr_cd                  OUT VARCHAR2  
   ,po_wtr_rcv_term_cd          OUT VARCHAR2  
   ,po_wtr_de_term_cd           OUT VARCHAR2  
   ,po_basic_rt                 OUT NUMBER  
   ,po_trsp_agmt_rt_tp_nm       OUT VARCHAR2  
   ,po_agmt_return_msg          OUT VARCHAR2  
   ,po_rtn_cd                   OUT NUMBER  
   ,po_rtn_msg                  OUT VARCHAR2  
);  
  
/*###################################################################  
 # -- Type    : PROCEDURE  
 # -- Author  : JONG HYEK CHOI  
 # -- Created : MAY 1, 2010  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA/TRS  
#####################################################################*/  
PROCEDURE GET_SCG_RATE_CALCULATION_PRC  
(  
    pi_system_indicator         IN  VARCHAR2    /* TRS, COA */  
   ,pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */  
   ,pi_scg_knd_indicator        IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */  
   ,pi_way_type                 IN  VARCHAR2    /* ONE or RND      */  
   ,pi_trsp_agmt_ofc_cty_cd     IN  VARCHAR2  
   ,pi_trsp_agmt_seq            IN  NUMBER  
   ,pi_trsp_agmt_rt_tp_ser_no   IN  NUMBER  
   ,pi_vndr_seq                 IN  VARCHAR2  
   ,pi_basis_dt                 IN  DATE  
   ,pi_eq_knd_cd                IN  VARCHAR2  
   ,pi_eq_tp_sz_cd              IN  VARCHAR2  
   ,pi_cgo_tp_cd                IN  VARCHAR2  
   ,pi_from_nod_cd              IN  VARCHAR2  
   ,pi_via_nod_cd               IN  VARCHAR2  
   ,pi_door_nod_cd              IN  VARCHAR2  
   ,pi_to_nod_cd                IN  VARCHAR2  
   ,pi_bundle_cnt               IN  NUMBER  
   ,pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
   ,pi_wgt_qty                  IN  NUMBER  
   ,pi_basic_rt                 IN  NUMBER  
   ,pi_basic_curr_cd            IN  VARCHAR2  
   ,pi_debug_flg                IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)  
   /* OUT PARAMETER */  
   ,po_scg_union_exp            OUT VARCHAR2  
   ,po_trsp_scg_cd              OUT VARCHAR2  
   ,po_trsp_agmt_scg_nod_seq    OUT NUMBER  
   ,po_trsp_agmt_scg_rt_seq     OUT NUMBER  
   ,po_scg_curr_cd              OUT VARCHAR2  
   ,po_scg_rate                 OUT NUMBER  
   ,po_rtn_cd                   OUT NUMBER  
   ,po_process_rslt_msg         OUT VARCHAR2  
   ,po_agmt_scg_rtn_msg         OUT VARCHAR2  
) ;  
  
/*###################################################################  
 # -- Type    : PROCEDURE  
 # -- Author  : JEONG SANG-KI  
 # -- Created : FEB 5, 2007  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA/TRS  
 #####################################################################*/  
PROCEDURE GET_RAIL_SCG_RATE_CALC_PRC  
(  
    pi_system_indicator     IN  VARCHAR2    /* TRS, COA */  
   ,pi_eq_tp_sz_cd          IN  VARCHAR2  
   ,pi_vndr_seq             IN  VARCHAR2  
   ,pi_trsp_agmt_ofc_cty_cd IN  VARCHAR2  
   ,pi_trsp_agmt_seq        IN  NUMBER  
   ,pi_scg_knd_indicator    IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */  
   ,pi_cgo_tp_cd            IN  VARCHAR2  
   ,pi_from_nod_cd          IN  VARCHAR2  
   ,pi_to_nod_cd            IN  VARCHAR2  
   ,pi_wgt_uom              IN  VARCHAR2    /* L-LBS, K-KG */  
   ,pi_wgt_qty              IN  NUMBER  
   ,pi_basis_dt             IN  DATE  
   ,pi_spcl_cgo_cd          IN  VARCHAR2  
   ,pi_bzc_curr_cd          IN  VARCHAR2  
   ,pi_bzc_rt               IN  NUMBER  
   ,pi_debug_flg            IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)  
   ,po_rail_curr_cd        OUT  VARCHAR2  
   ,po_rail_scg_rt         OUT  NUMBER  
   ,po_rtn_cd              OUT  NUMBER  
   ,po_rtn_msg             OUT  VARCHAR2  
);  
  
/*###################################################################  
 # -- Type    : PROCEDURE  
 # -- Author  : JEONG SANG-KI  
 # -- Created : FEB 1, 2007  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : ALL RATE COMBINATION FOR TRS NONE US RAIL S/O  
 #####################################################################*/  
PROCEDURE GET_TRS_ALL_RATE_PRC  
(  
    pi_system_indicator         IN VARCHAR2  
   ,pi_ctrl_ofc_cd              IN VARCHAR2    /* Pair - X , Distance - Mandatory */  
   ,pi_vndr_seq                 IN VARCHAR2  
   ,pi_basis_dt                 IN DATE  
   ,pi_way_tp_cd                IN VARCHAR2    /* 'ONE' or 'RND'      */  
   ,pi_eq_knd_cd                IN VARCHAR2  
   ,pi_eq_tp_sz_cd              IN VARCHAR2  
   ,pi_cmb_tp_cd                IN VARCHAR2  
   ,pi_cgo_tp_cd                IN VARCHAR2  
   ,pi_bound_cd                 IN VARCHAR2    /* OPTIONAL - IN/OUT BOUND */  
   ,pi_crr_mod_cd               IN VARCHAR2  
   ,pi_cost_mod_cd              IN VARCHAR2  
   ,pi_cust_nomi_trkr_flg       IN VARCHAR2  
   ,pi_cust_cnt_cd              IN VARCHAR2  
   ,pi_cust_seq                 IN NUMBER  
   ,pi_rail_svc_tp_cd           IN VARCHAR2    /* OPTIONAL */  
   ,pi_cmdt_cd                  IN VARCHAR2    /* OPTIONAL */  
   ,pi_from_nod_cd              IN VARCHAR2  
   ,pi_via_nod_cd               IN VARCHAR2  
   ,pi_door_nod_cd              IN VARCHAR2  
   ,pi_to_nod_cd                IN VARCHAR2  
   ,pi_bundle_cnt               IN NUMBER  
   ,pi_wgt_uom                  IN VARCHAR2    /* L-LBS, K-KG */  
   ,pi_wgt_qty                  IN NUMBER  
   ,pi_rcv_term                 IN VARCHAR2  -- 신규로 추가된 컬럼  
   ,pi_de_term                  IN VARCHAR2  -- 신규로 추가된 컬럼  
   ,pi_trsp_agmt_ofc_cty_cd     IN VARCHAR2  -- 신규로 추가된 컬럼  
   ,pi_trsp_agmt_seq            IN NUMBER    -- 신규로 추가된 컬럼  
   ,pi_spcl_cgo_cd              IN VARCHAR2  -- 신규로 추가된 컬럼  
   ,pi_debug_flg                IN VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)  
   /* OUT PARAMETER  */  
   ,po_trsp_agmt_ofc_cty_cd    OUT VARCHAR2  
   ,po_trsp_agmt_seq           OUT NUMBER  
   ,po_trsp_agmt_rt_tp_cd      OUT VARCHAR2  
   ,po_way_type                OUT VARCHAR2  
   ,po_trsp_agmt_rt_tp_nm      OUT VARCHAR2  
   ,po_sp_type                 OUT VARCHAR2  
   ,po_cust_nomi_trkr_flg      OUT VARCHAR2  
   ,po_cust_cnt_cd             OUT VARCHAR2  
   ,po_cust_seq                OUT NUMBER  
   ,po_local_curr_cd           OUT VARCHAR2  
   ,po_bzc_rt                  OUT NUMBER  
   ,po_fuel_scg_rt             OUT NUMBER  
   ,po_over_wgt_scg_rt         OUT NUMBER  
   ,po_hzs_scg_rt              OUT NUMBER  
   ,po_ttl_scg_rt              OUT NUMBER  
   ,po_vat_scg_rt              OUT NUMBER  
   ,po_isg_scg_rt              OUT NUMBER  
   ,po_tf_scg_rt               OUT NUMBER   -- 추후 추가 발생시 사용 하기 위해 미리 생성  
   ,po_agmt_return_msg         OUT VARCHAR2 -- 추가되는 return 항목이 있을 경우 $를 구분자로 하여 concat후 return한다.  
   ,po_local_curr_tot_amt      OUT NUMBER  
   ,po_usd_curr_tot_amt        OUT NUMBER  
   ,po_wtr_rcv_term_cd         OUT VARCHAR2  
   ,po_wtr_de_term_cd          OUT VARCHAR2  
   ,po_rtn_cd                  OUT NUMBER  
   ,po_rtn_msg                 OUT VARCHAR2  
);  
  
/*###################################################################  
 # -- Type    : PROCEDURE  
 # -- Author  : PARK JUN-YONG  
 # -- Created : MARCH 26, 2008  
 # -- Table   : TRS_AGMT_*  
 # -- Purpose : SOME RATE COMBINATION FOR TRS US RAIL S/O  
 #####################################################################*/  
PROCEDURE GET_USRAIL_CONV_AGMT_NO_PRC  
(  
    pi_vndr_seq                IN VARCHAR2  
   ,pi_cmdt_cd                 IN VARCHAR2    /* OPTIONAL */  
   ,pi_spcl_cgo_cntr_tp_cd     IN VARCHAR2    /* OPTIONAL */  
   ,po_rtn_cd                 OUT NUMBER  
   ,po_trsp_agmt_ofc_cty_cd   OUT VARCHAR2  
   ,po_trsp_agmt_seq          OUT NUMBER  
);  
  
/*###################################################################  
 # -- Type    : Function  
 # -- Author  : CJH  
 # -- Created : 2016.05.09  
 # -- Purpose : RATE 계산 Procedure를 Function으로 변경  
 #####################################################################*/  
FUNCTION GET_RATE_FNC  
(  
     pi_sys_cd               VARCHAR2 -- TRS COA 구분  
    ,pi_cre_ofc_cd           VARCHAR2  
    ,pi_vndr_cd              VARCHAR2  
    ,pi_cre_dt               DATE  
    ,pi_wy_tp_cd             VARCHAR2  
    ,pi_eq_knd_cd            VARCHAR2  
    ,pi_eq_tpsz_cd           VARCHAR2  
    ,pi_trsp_so_cmb_tp_cd    VARCHAR2  
    ,pi_cgo_tp_cd            VARCHAR2  
    ,pi_trsp_bnd_cd          VARCHAR2  
    ,pi_trsp_crr_mod_cd      VARCHAR2  
    ,pi_trsp_cost_dtl_mod_cd VARCHAR2 -- DOOR일 경우 'DR' 그렇지 않을 경우 'CY'  
    ,pi_cust_nomi_trkr_flg   VARCHAR2 -- HJS는 'N' CNT는 'Y'  
    ,pi_cust_cnt_cd          VARCHAR2 -- HJS는 null CNT는 값 입력  
    ,pi_cust_seq             NUMBER   -- HJS는 null CNT는 값 입력  
    ,pi_rail_ssvc_tp_cd      VARCHAR2  
    ,pi_cmdt_cd              VARCHAR2  
    ,pi_fm_nod_cd            VARCHAR2  
    ,pi_via_nod_cd           VARCHAR2  
    ,pi_dor_nod_cd           VARCHAR2  
    ,pi_to_nod_cd            VARCHAR2  
    ,pi_bundling_no          NUMBER  
    ,pi_wgt_meas_ut_cd       VARCHAR2  
    ,pi_cntr_wgt             NUMBER  
    ,pi_rcv_term             VARCHAR2  
    ,pi_de_term              VARCHAR2  
    ,pi_trsp_agmt_ofc_cty_cd VARCHAR2  
    ,pi_trsp_agmt_seq        NUMBER  
    ,pi_spcl_cgo_cd          VARCHAR2  
    ,pi_debug_flg            VARCHAR2  
)  
RETURN VARCHAR2;  
  
END TRS_AGMT_RATE_CC_PKG;
/

CREATE OR REPLACE PACKAGE BODY TRS_AGMT_RATE_CC_PKG 
IS            
/*###################################################################            
 # -- Type    : FUNCTION            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : 전체 NOD의 링크 갯수 구하기            
#####################################################################*/            
FUNCTION GET_LINK_CNT_FNC            
(            
    pi_from_nod_cd  VARCHAR2            
   ,pi_via_nod_cd   VARCHAR2            
   ,pi_door_nod_cd  VARCHAR2            
   ,pi_to_nod_cd    VARCHAR2            
) RETURN NUMBER            
IS            
    v_rtn_value NUMBER(1) := 0;            
BEGIN            
    IF pi_from_nod_cd IS NOT NULL AND LENGTH(pi_from_nod_cd) = 7 THEN            
        v_rtn_value := v_rtn_value + 1;            
    END IF;            
    IF pi_via_nod_cd IS NOT NULL AND LENGTH(pi_via_nod_cd) = 7 THEN            
        v_rtn_value := v_rtn_value + 1;            
    END IF;            
    IF pi_door_nod_cd IS NOT NULL AND LENGTH(pi_door_nod_cd) = 7 THEN            
        v_rtn_value := v_rtn_value + 1;            
    END IF;            
    IF pi_to_nod_cd IS NOT NULL AND LENGTH(pi_to_nod_cd) = 7 THEN            
        v_rtn_value := v_rtn_value + 1;            
    END IF;            
    RETURN v_rtn_value - 1;        /* 전체 POINT수에서 1을 뺀값이 LINK수이다. */            
EXCEPTION            
    WHEN NO_DATA_FOUND THEN            
        RETURN 0;            
        DBMS_OUTPUT.PUT_LINE('GET_LINK_CNT_FNC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
END;            
            
/*###################################################################            
 # -- Type    : FUNCTION            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM KILOMETER BETWEEN TWO NODES            
#####################################################################*/            
FUNCTION GET_CAL_DIST_2_NOD_FNC            
(            
    pi_dist_uom          VARCHAR2            
   ,pi_start_nod_cd      VARCHAR2            
   ,pi_end_nod_cd        VARCHAR2            
) RETURN NUMBER            
IS            
    v_rtn_value NUMBER (15,6) := 0;            
BEGIN            
    SELECT CASE UPPER(SUBSTR(pi_dist_uom,1,1)) WHEN 'K' THEN DECODE(UPPER(X.DIST_MEAS_UT_CD), 'KM', X.BZC_DIST, 'ML', X.CONV_DIST, 0)            
                                               WHEN 'M' THEN DECODE(UPPER(X.DIST_MEAS_UT_CD), 'ML', X.BZC_DIST, 'KM', X.CONV_DIST, 0)            
                                               ELSE 0            
           END            
      INTO v_rtn_value            
      FROM TRS_AGMT_DIST X            
     WHERE X.FM_NOD_CD   = pi_start_nod_cd            
       AND X.TO_NOD_CD   = pi_end_nod_cd            
    ;            
            
    IF NVL(v_rtn_value, 0) = 0 THEN            
        SELECT CASE UPPER(SUBSTR(pi_dist_uom,1,1)) WHEN 'K' THEN DECODE(UPPER(X.DIST_MEAS_UT_CD), 'KM', X.BZC_DIST, 'ML', X.CONV_DIST, 0)            
                                                   WHEN 'M' THEN DECODE(UPPER(X.DIST_MEAS_UT_CD), 'ML', X.BZC_DIST, 'KM', X.CONV_DIST, 0)            
                                                   ELSE 0            
               END            
          INTO v_rtn_value            
          FROM TRS_AGMT_DIST X            
         WHERE X.FM_NOD_CD   = pi_end_nod_cd            
           AND X.TO_NOD_CD   = pi_start_nod_cd            
        ;            
    END IF;            
    RETURN v_rtn_value;            
EXCEPTION            
    WHEN NO_DATA_FOUND THEN            
        RETURN 0;            
        DBMS_OUTPUT.PUT_LINE('GET_CAL_DIST_2_NOD_FNC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
END;            
            
/*###################################################################            
 # -- Type    : FUNCTION            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Updated : AUG 27, 2009, POONG YEON CHO            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM BETWEEN SEVERAL NODES            
#####################################################################*/            
FUNCTION GET_CAL_DIST_BTWN_NOD_FNC            
(            
    pi_dist_uom          VARCHAR2            
   ,pi_agmt_rt_tp        VARCHAR2           /* PD, DP, D  except P */            
   ,pi_cost_mod_cd       VARCHAR2           /* DR, Non-DR          */            
   ,pi_bound_cd          VARCHAR2           /* I, O                */            
   ,pi_from_nod_cd       VARCHAR2            
   ,pi_via_nod_cd        VARCHAR2            
   ,pi_door_nod_cd       VARCHAR2            
   ,pi_to_nod_cd         VARCHAR2            
) RETURN NUMBER            
IS            
    v_link_cnt  NUMBER(1)     := 0;            
    v_rtn_value NUMBER (15,6) := 0;            
BEGIN            
    v_link_cnt := GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);            
            
    /* 1 Link Not Available, PD나 DP는 복합운송에만 가능한 TYPE */            
    IF pi_agmt_rt_tp = 'PD' THEN            
        /* 복합운송이기때문에 2LINK인경우 FM~VIA~TO뿐이다 : VIA~TO   */            
        IF v_link_cnt = 2 THEN            
           v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_to_nod_cd);            
        /* INBOUND : VIA~DOOR~TO, OUTBOUND : VIA~TO       */            
        ELSIF v_link_cnt = 3 THEN            
            IF pi_bound_cd = 'I' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_door_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_door_nod_cd, pi_to_nod_cd);            
            ELSIF pi_bound_cd = 'O' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_to_nod_cd);            
            END IF;            
        END IF;            
    /* 1 Link Not Available */            
    ELSIF pi_agmt_rt_tp = 'DP' THEN            
        /* 복합운송이기때문에 2LINK인경우 FM~VIA~TO뿐이다 : FROM~VIA   */            
        IF v_link_cnt = 2 THEN            
           v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_via_nod_cd);            
        /* INBOUND : FROM~VIA, OUTBOUND : FROM~DOOR~VIA       */            
        ELSIF v_link_cnt = 3 THEN            
            IF pi_bound_cd = 'I' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_via_nod_cd);            
            ELSIF pi_bound_cd = 'O' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_door_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_door_nod_cd, pi_via_nod_cd);            
            END IF;            
        END IF;            
    ELSIF pi_agmt_rt_tp = 'D' THEN            
        /* FROM~TO */            
        IF v_link_cnt = 1 THEN            
           v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_to_nod_cd);            
        /* DOOR운송 : FROM~DOOR~TO, DOOR이외의 운송 : FROM~VIA~TO        */            
        ELSIF v_link_cnt = 2 THEN            
           IF pi_cost_mod_cd = 'DR' THEN            
               v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_door_nod_cd);            
               v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_door_nod_cd, pi_to_nod_cd);            
           ELSE            
               v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_via_nod_cd);            
               v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_to_nod_cd);            
           END IF;            
        /* INBOUND : FROM~VIA~DOOR~TO, OUTBOUND : FROM~DOOR~VIA~TO       */            
        ELSIF v_link_cnt = 3 THEN            
            IF pi_bound_cd = 'I' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_via_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_door_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_door_nod_cd, pi_to_nod_cd);            
            ELSIF pi_bound_cd = 'O' THEN            
                v_rtn_value := GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_from_nod_cd, pi_door_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_door_nod_cd, pi_via_nod_cd);            
                v_rtn_value := v_rtn_value + GET_CAL_DIST_2_NOD_FNC(pi_dist_uom, pi_via_nod_cd, pi_to_nod_cd);            
            END IF;            
        END IF;            
    END IF;            
RETURN v_rtn_value;            
EXCEPTION            
    WHEN NO_DATA_FOUND THEN            
        RETURN 0;            
        DBMS_OUTPUT.PUT_LINE('GET_CAL_DIST_BTWN_NOD_FNC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
END;            
            
/*###################################################################            
 # -- Type    : PROCEDURE            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : BASIC RATE CALCULATION MODULE            
#####################################################################*/            
PROCEDURE GET_BASIC_RATE_CALCULATION_PRC            
(            
    pi_system_indicator         IN  VARCHAR2    /* TRS, COA */            
   ,pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */            
   ,pi_trsp_agmt_ofc_cty_cd     IN  VARCHAR2            
   ,pi_trsp_agmt_seq            IN  NUMBER            
   ,pi_agmt_eq_knd              IN  VARCHAR2    /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */            
   ,pi_link_cnt                 IN  NUMBER      /* COUNT OF LINK FORM TRANSPORTATION   */            
   ,pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */            
   ,pi_vndr_seq                 IN  VARCHAR2            
   ,pi_basis_dt                 IN  DATE            
   ,pi_way_tp_cd                IN  VARCHAR2    /* ONEWAY or ROUNDTRIP      */            
   ,pi_eq_knd_cd                IN  VARCHAR2            
   ,pi_eq_tp_sz_cd              IN  VARCHAR2            
   ,pi_cmb_tp_cd                IN  VARCHAR2            
   ,pi_cgo_tp_cd                IN  VARCHAR2            
   ,pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */            
   ,pi_crr_mod_cd               IN  VARCHAR2            
   ,pi_cost_mod_cd              IN  VARCHAR2            
   ,pi_cust_nomi_trkr_ind_cd    IN  VARCHAR2    /*  CUST_NOMI_TRKR_IND_CD */            
   ,pi_cust_cnt_cd              IN  VARCHAR2            
   ,pi_cust_seq                 IN  NUMBER            
   ,pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */            
   ,pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */            
   ,pi_from_nod_cd              IN  VARCHAR2            
   ,pi_via_nod_cd               IN  VARCHAR2            
   ,pi_door_nod_cd              IN  VARCHAR2            
   ,pi_to_nod_cd                IN  VARCHAR2            
   ,pi_bundle_cnt               IN  NUMBER            
   ,pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */            
   ,pi_wgt_qty                  IN  NUMBER            
   ,pi_rcv_term                 IN  VARCHAR2            
   ,pi_de_term                  IN  VARCHAR2            
   ,pi_trsp_rvs_aply_flg        IN  VARCHAR2            
   ,pi_debug_flg                IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)            
   ,po_trsp_agmt_ofc_cty_cd     OUT VARCHAR2            
   ,po_trsp_agmt_seq            OUT NUMBER            
   ,po_trsp_agmt_rt_tp_ser_no   OUT NUMBER            
   ,po_vndr_seq                 OUT NUMBER            
   ,po_cust_nomi_trkr_flg       OUT VARCHAR2            
   ,po_cust_cnt_cd              OUT VARCHAR2            
   ,po_cust_seq                 OUT NUMBER            
   ,po_trsp_agmt_rt_tp_cd       OUT VARCHAR2            
   ,po_way_type                 OUT VARCHAR2            
   ,po_curr_cd                  OUT VARCHAR2            
   ,po_wtr_rcv_term_cd          OUT VARCHAR2            
   ,po_wtr_de_term_cd           OUT VARCHAR2            
   ,po_basic_rt                 OUT NUMBER            
   ,po_trsp_agmt_rt_tp_nm       OUT VARCHAR2            
   ,po_agmt_return_msg          OUT VARCHAR2            
   ,po_rtn_cd                   OUT NUMBER            
   ,po_rtn_msg                  OUT VARCHAR2            
)            
IS            
    C_WAY_TYPE_PRIORITY          CONSTANT VARCHAR2(15)    := 'RND_PRIORITY';            
    C_CONV_KG_FROM_LBS           CONSTANT NUMBER(10,6)    := 2.204;            
    vo_trsp_agmt_ofc_cty_cd      TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;            
    vo_trsp_agmt_seq             TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;            
    vo_trsp_agmt_rt_tp_ser_no    TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;            
    vo_vndr_seq                  TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;            
    vo_cust_nomi_trkr_flg        TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE ;            
    vo_cust_cnt_cd               TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;            
    vo_cust_seq                  TRS_AGMT_RT_TP.CUST_SEQ%TYPE;            
    vo_trsp_agmt_rt_tp_cd        TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;            
    vo_way_type                  VARCHAR2(3);            
    vo_curr_cd                   VARCHAR2(3);            
    vo_basic_rt                  NUMBER(18,3);            
    vo_wtr_rcv_term_cd           TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;            
    vo_wtr_de_term_cd            TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;            
    vo_trsp_agmt_rt_tp_nm        VARCHAR2(50);            
    vo_delt_flg                  VARCHAR2(1);            
    vo_trsp_agmt_nod_seq         NUMBER(12);            
    vo_trsp_agmt_rt_seq          NUMBER(12);            
    vo_trsp_agmt_rt_his_seq      NUMBER(12);            
    vo_agmt_return_msg           VARCHAR2(1000); -- 추가되는 return 항목이 있을 경우 $를 구분자로 하여 concat후 return한다.            
            
    v_eq_tp_all                  VARCHAR2(4);            
    v_eq_sz_all                  VARCHAR2(4);            
    v_aoc_flag                  VARCHAR2(1) := CASE WHEN SUBSTR(pi_system_indicator,1,3)='COA' THEN SUBSTR(pi_system_indicator,5,1) END;            
    v_system_indicator          VARCHAR2(4) := SUBSTR(pi_system_indicator,1,4);   
    v_mas_cd                    VARCHAR2(3) := SUBSTR(pi_system_indicator,1,3); 
            
BEGIN            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('♠=========== GET_BASIC_RATE_CALCULATION_PRC PARAMETER START ==============' );            
        DBMS_OUTPUT.PUT_LINE('pi_system_indicator VARCHAR2(100) :=''' || pi_system_indicator     ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_so_knd_cd   VARCHAR2(100) :=''' || pi_trsp_so_knd_cd       ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd VARCHAR2(100) :=''' || pi_trsp_agmt_ofc_cty_cd ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq  NUMBER(30)    :=''' || pi_trsp_agmt_seq        ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_agmt_eq_knd    VARCHAR2(100) :=''' || pi_agmt_eq_knd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_link_cnt       NUMBER(30)    :=''' || pi_link_cnt             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_ctrl_ofc_cd    VARCHAR2(100) :=''' || pi_ctrl_ofc_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_vndr_seq       NUMBER(30)    :=''' || pi_vndr_seq             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_basis_dt       DATE          := TO_DATE(''' || TO_CHAR(pi_basis_dt,'YYYYMMDD') ||''',''YYYYMMDD'');');            
        DBMS_OUTPUT.PUT_LINE('pi_way_tp_cd      VARCHAR2(100) :=''' || pi_way_tp_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_eq_knd_cd      VARCHAR2(100) :=''' || pi_eq_knd_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd    VARCHAR2(100) :=''' || pi_eq_tp_sz_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cmb_tp_cd      VARCHAR2(100) :=''' || pi_cmb_tp_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd      VARCHAR2(100) :=''' || pi_cgo_tp_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_bound_cd       VARCHAR2(100) :=''' || pi_bound_cd             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_crr_mod_cd     VARCHAR2(100) :=''' || pi_crr_mod_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cost_mod_cd    VARCHAR2(100) :=''' || pi_cost_mod_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cust_nomi_trkr_ind_cd    VARCHAR2(3) :=''' || pi_cust_nomi_trkr_ind_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cust_cnt_cd    VARCHAR2(100) :=''' || pi_cust_cnt_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cust_seq       NUMBER(30)    :=''' || pi_cust_seq             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_rail_svc_tp_cd VARCHAR2(100) :=''' || pi_rail_svc_tp_cd       ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cmdt_cd        VARCHAR2(100) :=''' || pi_cmdt_cd              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd    VARCHAR2(100) :=''' || pi_from_nod_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_via_nod_cd     VARCHAR2(100) :=''' || pi_via_nod_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_door_nod_cd    VARCHAR2(100) :=''' || pi_door_nod_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd      VARCHAR2(100) :=''' || pi_to_nod_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_bundle_cnt     NUMBER(30)    :=''' || pi_bundle_cnt           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_uom        VARCHAR2(100) :=''' || pi_wgt_uom              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_qty        NUMBER(30)    :=''' || pi_wgt_qty              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_rcv_term       VARCHAR2(100) :=''' || pi_rcv_term             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_de_term        VARCHAR2(100) :=''' || pi_de_term              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_rvs_aply_flg    VARCHAR2(1)   :=''' || pi_trsp_rvs_aply_flg    ||''';');            
        DBMS_OUTPUT.PUT_LINE('v_aoc_flag        VARCHAR2(100) :=''' || v_aoc_flag              ||''';');            
        DBMS_OUTPUT.PUT_LINE('v_system_indicator        VARCHAR2(100) :=''' || v_system_indicator              ||''';');     
        DBMS_OUTPUT.PUT_LINE('v_mas_cd        VARCHAR2(100) :=''' || v_system_indicator              ||''';'); 
        DBMS_OUTPUT.PUT_LINE('♠=========== GET_BASIC_RATE_CALCULATION_PRC PARAMETER END ==============' );            
    END IF;            
            
    -- Equipment Type별로 All Type 셋팅            
    IF pi_eq_knd_cd = 'U' THEN            
        v_eq_tp_all := SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL';            
        v_eq_sz_all := 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1);            
    ELSIF pi_eq_knd_cd = 'Z' THEN            
        IF LENGTH(PI_EQ_TP_SZ_CD) = 2 THEN            
            v_eq_tp_all := SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL';            
            v_eq_sz_all := 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1);            
        ELSIF LENGTH(pi_eq_tp_sz_cd) = 3 THEN            
            v_eq_tp_all := SUBSTR(PI_EQ_TP_SZ_CD,1,2)||'AL';            
            v_eq_sz_all := 'AL'||SUBSTR(pi_eq_tp_sz_cd,3,1);            
        END IF;            
    ELSIF pi_eq_knd_cd = 'G' THEN            
        v_eq_tp_all := '';            
        v_eq_sz_all := '';            
    END IF;            
            
    SELECT TRSP_AGMT_OFC_CTY_CD  , TRSP_AGMT_SEQ  , TRSP_AGMT_RT_TP_SER_NO  , CURR_CD  , EQUIPMENT_RATE            
         , WAY_TYPE  , VNDR_SEQ  , CUST_NOMI_TRKR_FLG  , CUST_CNT_CD  , CUST_SEQ            
         , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD, TRSP_AGMT_RT_TP_NM            
         , DELT_FLG, TRSP_AGMT_NOD_SEQ, TRSP_AGMT_RT_SEQ, TRSP_AGMT_RT_HIS_SEQ            
         , TRSP_AGMT_OLD_FLG||'$'||AGMT_MTY_PKUP_RTN_YD_CD||'$'||TO_WGT||'$'||CFM_FLG||'$'||TRSP_AGMT_RT_SEQ||'$'||TRSP_AGMT_UPD_DT||'$'||CUST_NOMI_TRKR_IND_CD||'$'||CMDT_GRP_CD||'$'||WGT_MEAS_UT_CD||'$F' -- 마지막 F는 값이 없을 경우 정규식으로 Split시 컬럼의 갯수가 변경되는 경우가 있어서 임의의 값으로 붙여줌..향후 값이 추가될 경우엔 '$F' 앞에 추가하면 됨. 즉, 마지막은 항상 '$F'            
      INTO vo_trsp_agmt_ofc_cty_cd , vo_trsp_agmt_seq     , vo_trsp_agmt_rt_tp_ser_no, vo_curr_cd, vo_basic_rt            
         , vo_way_type, vo_vndr_seq, vo_cust_nomi_trkr_flg, vo_cust_cnt_cd           , vo_cust_seq            
         , vo_trsp_agmt_rt_tp_cd   , vo_wtr_rcv_term_cd   , vo_wtr_de_term_cd        , vo_trsp_agmt_rt_tp_nm            
         , vo_delt_flg, vo_trsp_agmt_nod_seq, vo_trsp_agmt_rt_seq, vo_trsp_agmt_rt_his_seq, vo_agmt_return_msg            
      FROM (            
           SELECT C.TRSP_AGMT_OFC_CTY_CD            
                 ,C.TRSP_AGMT_SEQ            
                 ,C.TRSP_AGMT_RT_TP_SER_NO            
                 ,B.VNDR_SEQ            
                 ,E.EFF_FM_DT            
                 ,E.EFF_TO_DT            
                 ,C.TRSP_AGMT_RT_TP_CD            
                 ,C.CUST_NOMI_TRKR_FLG            
                 ,C.CUST_CNT_CD            
                 ,C.CUST_SEQ            
                 ,CASE WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  IS NULL          THEN 9            
                       WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  = 'ALAL'         THEN 4            
                       WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd  THEN 1            
                       ELSE 3            
                  END  EQ_TPSZ_PRIOR_ORDER            
                 ,CASE WHEN pi_way_tp_cd = 'ONE'                                             THEN 'ONE'            
                       WHEN pi_way_tp_cd = 'RND'                                             THEN 'RND'            
                       WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'      THEN NVL2(E.TRSP_RND_RT   , 'RND', 'ONE')            
                       ELSE                                                                     NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')            
                  END  WAY_TYPE            
                 ,E.CURR_CD            
                 ,CASE WHEN C.TRSP_AGMT_RT_TP_CD = 'D' AND D.TRSP_DIST_TP_CD = 'P' THEN -- PD, DP일 경우엔 TRSP_DIST_TP_CD는 'F'만 입력가능하다.            
                            CASE WHEN pi_way_tp_cd = 'ONE'                                        THEN NVL(E.TRSP_ONE_WY_RT, 0)*TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, C.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)            
                                 WHEN pi_way_tp_cd = 'RND'                                        THEN NVL(E.TRSP_RND_RT, 0)*TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, C.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)            
                                 WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR' THEN NVL(E.TRSP_RND_RT, NVL(E.TRSP_ONE_WY_RT    , 0))*TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, C.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)            
                                 ELSE                                                             NVL(E.TRSP_ONE_WY_RT    , NVL(E.TRSP_RND_RT, 0))*TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, C.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)            
                            END            
                       ELSE            
                           CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN E.TRSP_ONE_WY_RT            
                                WHEN pi_way_tp_cd = 'RND'                                         THEN E.TRSP_RND_RT            
                                WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)            
                                ELSE                                                              NVL(E.TRSP_ONE_WY_RT    , E.TRSP_RND_RT)            
                           END            
                  END AS EQUIPMENT_RATE            
                 ,CASE WHEN E.WTR_RCV_TERM_CD IN ('C','I','O','T','V','Y') THEN E.WTR_RCV_TERM_CD ELSE '' END AS WTR_RCV_TERM_CD            
                 ,CASE WHEN E.WTR_DE_TERM_CD  IN ('C','I','O','T','V','Y') THEN E.WTR_DE_TERM_CD  ELSE '' END AS WTR_DE_TERM_CD            
                 ,DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', 1, 'PD', 2, 'DP', 3, 'D', 4) RT_TP_ORDER            
                 ,(SELECT CD.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CD WHERE  CD.INTG_CD_ID = 'CD00954' AND CD.INTG_CD_VAL_CTNT  = C.TRSP_AGMT_RT_TP_CD) TRSP_AGMT_RT_TP_NM            
                 ,E.DELT_FLG ,E.TRSP_AGMT_NOD_SEQ, E.TRSP_AGMT_RT_SEQ, E.TRSP_AGMT_RT_HIS_SEQ            
                 ,(CASE WHEN (SYSDATE - E.CRE_DT > 730) THEN 'Y' ELSE 'N' END)  TRSP_AGMT_OLD_FLG            
                 ,(CASE WHEN pi_bound_cd = 'O' AND pi_cost_mod_cd = 'DR' THEN D.FM_NOD_CD            
                        WHEN pi_bound_cd = 'I' AND pi_cost_mod_cd = 'DR' THEN D.TO_NOD_CD            
                   END) AGMT_MTY_PKUP_RTN_YD_CD            
                 ,E.TO_WGT            
                 ,NVL(F.CFM_FLG, 'Y') CFM_FLG            
                 ,TO_CHAR(E.UPD_DT, 'YYYYMMDDHH24MISS') TRSP_AGMT_UPD_DT 
                 ,CASE WHEN v_mas_cd = 'COA' THEN (CASE WHEN C.CUST_CNT_CD = 'XX' THEN 1 ELSE 2 END) 
                       ELSE (CASE WHEN (C.CUST_NOMI_TRKR_FLG = (CASE pi_cust_cnt_cd WHEN 'XX' THEN 'N' ELSE  'Y' END )) AND C.CUST_CNT_CD  = pi_cust_cnt_cd AND C.CUST_SEQ = pi_cust_seq THEN 1            
                                  ELSE 2  
                             END) 
                  END AS CUST_RNK           
                 ,C.CUST_NOMI_TRKR_IND_CD         
                 ,C.CMDT_GRP_CD         
                 ,E.WGT_MEAS_UT_CD         
            FROM  TRS_AGMT_HDR   A            
                 ,TRS_AGMT_APLY_VNDR B            
                 ,TRS_AGMT_RT_TP C            
                 ,TRS_AGMT_NOD   D            
                 ,TRS_AGMT_EQ_RT_HIS E            
                 ,TRS_AGMT_EQ_RT F -- HISTORY에만 존재하는 RATE는 아무런 의미가 없다.            
           WHERE  A.TRSP_AGMT_OFC_CTY_CD   = B.TRSP_AGMT_OFC_CTY_CD            
             AND  A.TRSP_AGMT_SEQ          = B.TRSP_AGMT_SEQ            
             AND  A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD            
             AND  A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ            
             AND  C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD            
             AND  C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ            
             AND  C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO            
             AND  D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD            
             AND  D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ            
             AND  D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO            
             AND  D.TRSP_AGMT_NOD_SEQ      = E.TRSP_AGMT_NOD_SEQ            
             AND  E.TRSP_AGMT_OFC_CTY_CD   = F.TRSP_AGMT_OFC_CTY_CD            
             AND  E.TRSP_AGMT_SEQ          = F.TRSP_AGMT_SEQ            
             AND  E.TRSP_AGMT_RT_TP_SER_NO = F.TRSP_AGMT_RT_TP_SER_NO            
             AND  E.TRSP_AGMT_NOD_SEQ      = F.TRSP_AGMT_NOD_SEQ            
             AND  E.TRSP_AGMT_RT_SEQ       = F.TRSP_AGMT_RT_SEQ            
             AND  A.CTRT_OFC_CD            = DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', A.CTRT_OFC_CD, pi_ctrl_ofc_cd)            
             AND  E.EQ_KND_CD              = pi_eq_knd_cd            
             AND  DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', B.VNDR_SEQ) = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))            
             AND  C.CGO_TP_CD              = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE '0' END            
             AND  C.TRSP_COST_MOD_CD  = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(TRSP_AGMT_RT_TP_CD, 'P', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'), 'D', 'DC'))            
                                             WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN CASE WHEN pi_cmb_tp_cd = 'CF' THEN 'MM'            
                                                                                                      WHEN C.TRSP_COST_MOD_CD ='MF' AND SUBSTR(pi_eq_tp_sz_cd,1,1) IN ('F','A','P') THEN 'MF'            
                                                                                                      ELSE DECODE(TRSP_AGMT_RT_TP_CD, 'P','CY','D', 'DC')            
                                                                                                  END            
                                             WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'            
                                             WHEN pi_eq_knd_cd = 'G'                        THEN DECODE(TRSP_AGMT_RT_TP_CD, 'P', 'CY', 'D', 'DC')            
                                             ELSE ''            
                                        END            
             AND  C.AGMT_TRSP_TP_CD   = pi_crr_mod_cd            
             AND  C.RAIL_SVC_TP_CD    = NVL(pi_rail_svc_tp_cd, '00')            
--             AND  C.CUST_NOMI_TRKR_FLG = CASE pi_cust_cnt_cd WHEN 'XX' THEN 'N' ELSE  'Y' END            
             AND  C.CUST_NOMI_TRKR_IND_CD LIKE (CASE WHEN v_mas_cd = 'COA' THEN C.CUST_NOMI_TRKR_IND_CD ELSE pi_cust_nomi_trkr_ind_cd END) -- HJS,CNT,CPT,HPT,MIC            
             AND  C.CUST_CNT_CD       = (CASE WHEN v_mas_cd = 'COA' THEN C.CUST_CNT_CD ELSE pi_cust_cnt_cd END) 
             AND  C.CUST_SEQ          = (CASE WHEN v_mas_cd = 'COA' THEN C.CUST_SEQ ELSE pi_cust_seq END) 
             AND (            
                  (            
                         (D.FM_NOD_CD  = CASE WHEN v_system_indicator = 'COA2' AND pi_bound_cd = 'O' AND pi_cost_mod_cd = 'DR' THEN D.FM_NOD_CD -- COA에서 비용 추정시에는 Empty Pickup Yard(Out Bound)는 확인하지 않는다.            
                                              ELSE DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000')            
                                         END            
                         )            
                     AND (D.TO_NOD_CD  = CASE WHEN v_system_indicator = 'COA2' AND pi_bound_cd = 'I' AND pi_cost_mod_cd = 'DR' THEN D.TO_NOD_CD -- COA에서 비용 추정시에는 Empty Return Yard(In Bound)는 확인하지 않는다.            
                                              ELSE DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000')            
                                         END            
                         )            
                  )            
                OR            
                  (      E.TRSP_RVS_APLY_FLG = 'Y' -- Reverse로 AGMT등록은 Yard운송만 가능하므로 COA Empty Pickup/Return Yard 예외처리는 필요없다.            
                     AND (D.FM_NOD_CD  = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000') )            
                     AND (D.TO_NOD_CD  = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000') )            
                  )            
                 )            
             AND  D.VIA_NOD_CD = CASE pi_link_cnt WHEN 1 THEN '0000000'            
                                                  WHEN 2 THEN            
                                                          CASE pi_cost_mod_cd WHEN 'DR' THEN '0000000'            
                                                                              ELSE DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))            
                                                          END            
                                                  WHEN 3 THEN DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))            
                                                  ELSE '0000000'            
                                 END            
             AND  D.DOR_NOD_CD = CASE pi_link_cnt WHEN 1 THEN '0000000'            
                                                  WHEN 2 THEN            
                                                          CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))            
                                                                              ELSE '0000000'            
                                                          END            
                                                  WHEN 3 THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))            
                                                  ELSE '0000000'            
                                 END            
             AND  D.TRSP_AGMT_DIST >= DECODE(D.TRSP_AGMT_DIST, 0, 0, TRS_AGMT_RATE_CC_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, C.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd))            
            
             AND  E.EFF_FM_DT  <= pi_basis_dt    
             AND  E.EFF_TO_DT + (CASE WHEN SUBSTR(pi_system_indicator,1,3) = 'COA'     
                                     THEN (CASE WHEN E.EFF_TO_DT < TO_DATE('29991231', 'YYYYMMDD') THEN 100 ELSE 0 END)    
                                     ELSE 0     
                                END) >= pi_basis_dt                  
                 
             AND  NVL(F.AGMT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= pi_basis_dt           
                   
             /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */            
             AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (PI_EQ_TP_SZ_CD, V_EQ_TP_ALL, V_EQ_SZ_ALL, 'ALAL')            
             /* ONLY CONTAINER-WEIGHT */            
             AND CASE WHEN pi_agmt_eq_knd = 'U' AND pi_cgo_tp_cd = 'F' THEN            
                      CASE WHEN SUBSTR( DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD) ,1,1) = 'K' THEN E.TO_WGT            
                           ELSE ROUND(E.TO_WGT / C_CONV_KG_FROM_LBS, 3)            
                      END            
                      ELSE 1            
                 END            
                 >=            
                 CASE WHEN pi_agmt_eq_knd = 'U' AND pi_cgo_tp_cd = 'F' THEN            
                      CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty            
                           ELSE ROUND(pi_wgt_qty / C_CONV_KG_FROM_LBS, 3)            
                      END            
                      ELSE 1            
                 END            
             /* ONLY Chassis + Empty Flatrack Container */            
             AND CASE WHEN  C.TRSP_COST_MOD_CD <> 'CY' AND pi_agmt_eq_knd = 'Z' THEN DECODE(E.TRSP_AGMT_BDL_QTY, 0, 1, E.TRSP_AGMT_BDL_QTY)            
                      ELSE 1            
                 END            
                 =            
                 CASE WHEN  C.TRSP_COST_MOD_CD <> 'CY' AND pi_agmt_eq_knd = 'Z' THEN NVL(pi_bundle_cnt,1)            
                      ELSE 1            
                 END            
             /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/            
             AND  (C.CMDT_GRP_CD  = ( SELECT X.TRSP_GRP_CMDT_CD            
                                        FROM TRS_TRSP_CMDT_GRP X            
                                           , TRS_CMDT_GRP_CZ   Y            
                                       WHERE X.DELT_FLG = 'N'            
                                         AND X.DELT_FLG          = Y.DELT_FLG            
                                         AND X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD            
                                         AND X.VNDR_SEQ          = pi_vndr_seq            
                                         AND Y.CMDT_CD           = pi_cmdt_cd            
                                     )            
                  OR            
                  C.CMDT_GRP_CD        = 'XXXX'            
                  )            
             /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */            
             AND CASE WHEN PI_WAY_TP_CD = 'ONE' THEN CASE WHEN E.TRSP_ONE_WY_RT > 0 THEN 1 END            
                      WHEN PI_WAY_TP_CD = 'RND' THEN CASE WHEN E.TRSP_RND_RT >    0 THEN 1 END            
                      ELSE 1            
                 END            
                 =            
                 CASE WHEN PI_WAY_TP_CD = 'ONE' THEN 1            
                      WHEN PI_WAY_TP_CD = 'RND' THEN 1            
                      ELSE 1            
                 END            
             AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', A.TRSP_AGMT_OFC_CTY_CD, 'N/A')            
             AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', A.TRSP_AGMT_SEQ       , 1)            
             AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN E.WTR_RCV_TERM_CD            
                      ELSE '1'            
                 END            
                 =            
                 CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term            
                      ELSE '1'            
                 END            
             AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN E.WTR_DE_TERM_CD            
                      ELSE '1'            
                 END            
                 =            
                 CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term            
                      ELSE '1'            
                 END            
             AND E.TRSP_RVS_APLY_FLG LIKE DECODE(pi_trsp_rvs_aply_flg, 'N', '%', pi_trsp_rvs_aply_flg)            
             AND E.DELT_FLG = 'N'            
        ORDER BY CUST_RNK            
                ,RT_TP_ORDER                     ASC            
                ,EQ_TPSZ_PRIOR_ORDER             ASC            
                ,LENGTH(DECODE(D.FM_NOD_CD,'0000000' ,'N/A', D.FM_NOD_CD)) DESC            
                ,LENGTH(DECODE(D.VIA_NOD_CD,'0000000' ,'N/A', D.VIA_NOD_CD)) DESC            
                ,LENGTH(DECODE(D.DOR_NOD_CD,'0000000' ,'N/A', D.DOR_NOD_CD)) DESC            
                ,LENGTH(DECODE(D.TO_NOD_CD,'0000000' ,'N/A', D.TO_NOD_CD)) DESC            
                ,D.TRSP_AGMT_DIST                ASC            
                ,E.TO_WGT                        ASC            
                ,CASE WHEN (D.FM_NOD_CD  = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000'))            
                       AND (D.TO_NOD_CD  = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000')) THEN 'N'            
                      ELSE E.TRSP_RVS_APLY_FLG            
                 END ASC            
                ,E.TRSP_AGMT_RT_HIS_SEQ          DESC -- HISTORY 자료중 마지막으로 등록된 RATE를 조회한다.            
        )            
    WHERE   ROWNUM < 2;            
            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('♠=========== GET_BASIC_RATE_CALCULATION_PRC QUERY SQL START =============' );            
        DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_EQ_RT_HIS WHERE 1=1 ');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_OFC_CTY_CD  = '''||vo_trsp_agmt_ofc_cty_cd||'''');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SEQ  = '||vo_trsp_agmt_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_TP_SER_NO  = '||vo_trsp_agmt_rt_tp_ser_no);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_NOD_SEQ  = '||vo_trsp_agmt_nod_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_SEQ  = '||vo_trsp_agmt_rt_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_HIS_SEQ  = '||vo_trsp_agmt_rt_his_seq);            
        DBMS_OUTPUT.PUT_LINE('♠============ GET_BASIC_RATE_CALCULATION_PRC QUERY SQL END ===============' );            
    END IF;            
            
    -- delete check여부는 TRS_AGMT_EQ_RT테이블에는 live자료만 존재하므로 없어도 무방하다.            
    IF vo_delt_flg = 'N' THEN            
        po_trsp_agmt_ofc_cty_cd    := vo_trsp_agmt_ofc_cty_cd   ;            
        po_trsp_agmt_seq           := vo_trsp_agmt_seq          ;            
        po_trsp_agmt_rt_tp_ser_no  := vo_trsp_agmt_rt_tp_ser_no ;            
        po_vndr_seq                := vo_vndr_seq               ;            
        po_cust_nomi_trkr_flg      := vo_cust_nomi_trkr_flg     ;            
        po_cust_cnt_cd             := vo_cust_cnt_cd            ;            
        po_cust_seq                := vo_cust_seq               ;            
        po_trsp_agmt_rt_tp_cd      := vo_trsp_agmt_rt_tp_cd     ;            
        po_way_type                := vo_way_type               ;            
        po_curr_cd                 := vo_curr_cd                ;            
        po_basic_rt                := vo_basic_rt               ;            
        po_wtr_rcv_term_cd         := vo_wtr_rcv_term_cd        ;            
        po_wtr_de_term_cd          := vo_wtr_de_term_cd         ;            
        po_trsp_agmt_rt_tp_nm      := vo_trsp_agmt_rt_tp_nm     ;            
        po_agmt_return_msg         := vo_agmt_return_msg        ;            
        po_rtn_cd := 0;            
    ELSE            
        po_rtn_cd := -2;            
        DBMS_OUTPUT.PUT_LINE('GET_BASIC_RATE_CALCULATION_PRC <BASIC RATE DELETE>');            
    END IF;            
EXCEPTION            
    WHEN NO_DATA_FOUND THEN            
         po_rtn_cd  := -99;            
         po_rtn_msg := 'GET_BASIC_RATE_CALCULATION_PRC <NO_DATA_FOUND>';            
         IF pi_debug_flg = 'Y' THEN            
             DBMS_OUTPUT.PUT_LINE('GET_BASIC_RATE_CALCULATION_PRC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
         END IF;            
    WHEN OTHERS THEN            
         po_rtn_cd := -1;            
         po_rtn_msg := 'GET_BASIC_RATE_CALCULATION_PRC <OTHERS>';            
         IF pi_debug_flg = 'Y' THEN            
             DBMS_OUTPUT.PUT_LINE('GET_BASIC_RATE_CALCULATION_PRC <OTHERS> ERROR MSG = ['||SQLERRM||']');            
         END IF;            
END;            
            
/*###################################################################            
 # -- Type    : PROCEDURE            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA  TRS            
 #####################################################################*/            
PROCEDURE GET_SCG_RATE_CALCULATION_PRC            
(            
    pi_system_indicator         IN  VARCHAR2    /* TRS, COA */            
   ,pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */            
   ,pi_scg_knd_indicator        IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE, VT : VAT SURCHARGE */            
   ,pi_way_type                 IN  VARCHAR2    /* ONE or RND      */            
   ,pi_trsp_agmt_ofc_cty_cd     IN  VARCHAR2            
   ,pi_trsp_agmt_seq            IN  NUMBER            
   ,pi_trsp_agmt_rt_tp_ser_no   IN  NUMBER            
   ,pi_vndr_seq                 IN  VARCHAR2            
   ,pi_basis_dt                 IN  DATE            
   ,pi_eq_knd_cd                IN  VARCHAR2            
   ,pi_eq_tp_sz_cd              IN  VARCHAR2            
   ,pi_cgo_tp_cd                IN  VARCHAR2            
   ,pi_from_nod_cd              IN  VARCHAR2            
   ,pi_via_nod_cd               IN  VARCHAR2            
   ,pi_door_nod_cd              IN  VARCHAR2            
   ,pi_to_nod_cd                IN  VARCHAR2            
   ,pi_bundle_cnt               IN  NUMBER            
   ,pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */            
   ,pi_wgt_qty                  IN  NUMBER            
   ,pi_basic_rt                 IN  NUMBER            
   ,pi_basic_curr_cd            IN  VARCHAR2            
   ,pi_debug_flg                IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)            
   /* OUT PARAMETER */            
   ,po_scg_union_exp            OUT VARCHAR2            
   ,po_trsp_scg_cd              OUT VARCHAR2            
   ,po_trsp_agmt_scg_nod_seq    OUT NUMBER            
   ,po_trsp_agmt_scg_rt_seq     OUT NUMBER            
   ,po_scg_curr_cd              OUT VARCHAR2            
   ,po_scg_rate                 OUT NUMBER            
   ,po_rtn_cd                   OUT NUMBER            
   ,po_process_rslt_msg         OUT VARCHAR2            
   ,po_agmt_scg_rtn_msg         OUT VARCHAR2            
)            
IS            
    vo_agmt_scg_rt_div_cd       VARCHAR2(1);            
    vo_delt_flg                 VARCHAR2(1);            
    vo_scg_union_exp            VARCHAR2(100);            
    vo_trsp_scg_cd              VARCHAR2(6);            
    vo_trsp_agmt_scg_nod_seq    NUMBER(12);            
    vo_trsp_agmt_scg_rt_seq     NUMBER(12);            
    vo_scg_curr_cd              VARCHAR2(3);            
    vo_scg_rate                 NUMBER(15,3);            
    vo_trsp_agmt_rt_his_seq     NUMBER(12);            
            
    v_scg1                      VARCHAR2(3);            
    v_scg2                      VARCHAR2(3);            
    v_scg_title                 VARCHAR2(20);            
    v_aoc_flag                  VARCHAR2(1) := CASE WHEN SUBSTR(pi_system_indicator,1,3)='COA' THEN SUBSTR(pi_system_indicator,5,1) END;            
    v_system_indicator          VARCHAR2(4) := SUBSTR(pi_system_indicator,1,4);            
    vo_agmt_scg_rtn_msg         VARCHAR2(1000);            
            
BEGIN            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('' );            
        DBMS_OUTPUT.PUT_LINE('♥========== GET_SCG_RATE_CALCULATION_PRC PARAMETER START('||pi_scg_knd_indicator||')===============' );            
        DBMS_OUTPUT.PUT_LINE('pi_system_indicator     VARCHAR2(100) := ''' || pi_system_indicator     ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_so_knd_cd       VARCHAR2(100) := ''' || pi_trsp_so_knd_cd       ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_scg_knd_indicator    VARCHAR2(100) := ''' || pi_scg_knd_indicator    ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_way_type             VARCHAR2(100) := ''' || pi_way_type             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd VARCHAR2(100) := ''' || pi_trsp_agmt_ofc_cty_cd ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq          NUMBER(30) := ''' || pi_trsp_agmt_seq        ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_rt_tp_ser_no NUMBER(30) := ''' || pi_trsp_agmt_rt_tp_ser_no    ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_vndr_seq               NUMBER(30) := ''' || pi_vndr_seq             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_basis_dt               DATE := TO_DATE(''' || TO_CHAR(pi_basis_dt,'YYYYMMDD') ||''',''YYYYMMDD'');');            
        DBMS_OUTPUT.PUT_LINE('pi_eq_knd_cd      VARCHAR2(100) := ''' || pi_eq_knd_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd    VARCHAR2(100) := ''' || pi_eq_tp_sz_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd      VARCHAR2(100) := ''' || pi_cgo_tp_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd    VARCHAR2(100) := ''' || pi_from_nod_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_via_nod_cd     VARCHAR2(100) := ''' || pi_via_nod_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_door_nod_cd    VARCHAR2(100) := ''' || pi_door_nod_cd          ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd      VARCHAR2(100) := ''' || pi_to_nod_cd            ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_bundle_cnt     NUMBER(30) := ''' || pi_bundle_cnt           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_uom        VARCHAR2(100) := ''' || pi_wgt_uom              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_qty        NUMBER(30) := ''' || pi_wgt_qty              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_basic_rt       NUMBER(15,3) := ''' || pi_basic_rt             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_basic_curr_cd  VARCHAR2(100) := ''' || pi_basic_curr_cd        ||''';');            
        DBMS_OUTPUT.PUT_LINE('♥========== GET_SCG_RATE_CALCULATION_PRC PARAMETER END('||pi_scg_knd_indicator||')===============' );            
    END IF;            
            
    IF pi_scg_knd_indicator = 'FU' THEN            
        v_scg1 := 'FUE';            
        v_scg2 := 'FUA';            
        v_scg_title := 'Fuel Surcharge';            
    ELSIF pi_scg_knd_indicator = 'VT' THEN            
        v_scg1 := 'VAT';            
        v_scg2 := '';            
        v_scg_title := 'Vat Surcharge';            
    ELSIF pi_scg_knd_indicator = 'OW' THEN            
        v_scg1 := 'OW';            
        v_scg2 := '';            
        v_scg_title := 'OverWeight Surcharge';            
    ELSIF pi_scg_knd_indicator = 'TF' THEN            
        v_scg1 := 'TOL';            
        v_scg2 := '';            
        v_scg_title := 'Toll Fee Surcharge';            
    END IF;            
    po_rtn_cd := 0;  /* INITIAL SETTING AS SUCCESS */            
            
    SELECT SURCHARGE_UNION_EXP, TRSP_SCG_CD, TRSP_AGMT_SCG_NOD_SEQ, TRSP_AGMT_SCG_RT_SEQ, LOCAL_SCG_CURR_CD_OR_PERCENT            
          ,CASE WHEN AGMT_SCG_RT_DIV_CD = 'F' THEN FUEL_SURCHARGE_RATE_OR_PERCENT            
                WHEN AGMT_SCG_RT_DIV_CD = 'R' THEN ROUND( (pi_basic_rt * FUEL_SURCHARGE_RATE_OR_PERCENT/100), 3)            
           END FUEL_SURCHARGE_RATE_OR_PERCENT            
          ,AGMT_SCG_RT_DIV_CD            
          ,DELT_FLG, TRSP_AGMT_RT_HIS_SEQ, CFM_FLG            
      INTO vo_scg_union_exp, vo_trsp_scg_cd, vo_trsp_agmt_scg_nod_seq, vo_trsp_agmt_scg_rt_seq, vo_scg_curr_cd            
          ,vo_scg_rate, vo_agmt_scg_rt_div_cd            
          ,vo_delt_flg, vo_trsp_agmt_rt_his_seq, vo_agmt_scg_rtn_msg            
      FROM (            
            SELECT  v_scg_title ||' = ['||C.TRSP_SCG_CD||']->['||E.TRSP_AGMT_EQ_TP_SZ_CD||']->['||B.CMDT_GRP_CD||']->['||E.CRE_DT||']'  SURCHARGE_UNION_EXP            
                   ,E.TRSP_AGMT_OFC_CTY_CD            
                   ,E.TRSP_AGMT_SEQ            
                   ,E.TRSP_AGMT_RT_TP_SER_NO            
                   ,C.TRSP_SCG_CD            
                   ,CASE WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  IS NULL          THEN 9            
                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  = 'ALAL'         THEN 4            
                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  LIKE '%AL%'      THEN 2            
                         WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  = pi_eq_tp_sz_cd THEN 1            
                         ELSE 3            
                    END  EQ_TPSZ_PRIOR_ORDER            
                   ,E.CURR_CD AS LOCAL_SCG_CURR_CD_OR_PERCENT            
                   ,CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT            
                                     WHEN 'RND' THEN E.TRSP_RND_RT            
                    END FUEL_SURCHARGE_RATE_OR_PERCENT            
                   ,E.AGMT_SCG_RT_DIV_CD            
                   ,C.TRSP_AGMT_SCG_NOD_SEQ            
                   ,E.TRSP_AGMT_SCG_RT_SEQ            
                   ,E.DELT_FLG            
                   ,E.TRSP_AGMT_RT_HIS_SEQ            
                   ,NVL(F.CFM_FLG, 'Y') CFM_FLG            
                   ,TO_CHAR(F.UPD_DT, 'YYYYMMDDHH24MISS') TRSP_AGMT_UPD_DT            
              FROM  TRS_AGMT_APLY_VNDR         A            
                   ,TRS_AGMT_RT_TP             B            
                   ,TRS_AGMT_SCG_NOD           C            
                   ,TRS_AGMT_SCG_RT_HIS        E            
                   ,TRS_AGMT_SCG_RT            F -- HISTORY에만 존재하는 RATE는 아무런 의미가 없다.            
             WHERE  A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD            
               AND  A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ            
               AND  B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD            
               AND  B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ            
               AND  B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO            
               AND  C.TRSP_AGMT_OFC_CTY_CD          = E.TRSP_AGMT_OFC_CTY_CD            
               AND  C.TRSP_AGMT_SEQ                 = E.TRSP_AGMT_SEQ            
               AND  C.TRSP_AGMT_RT_TP_SER_NO        = E.TRSP_AGMT_RT_TP_SER_NO            
               AND  C.TRSP_AGMT_SCG_NOD_SEQ         = E.TRSP_AGMT_SCG_NOD_SEQ            
               AND  E.TRSP_AGMT_OFC_CTY_CD          = F.TRSP_AGMT_OFC_CTY_CD            
               AND  E.TRSP_AGMT_SEQ                 = F.TRSP_AGMT_SEQ            
               AND  E.TRSP_AGMT_RT_TP_SER_NO        = F.TRSP_AGMT_RT_TP_SER_NO            
               AND  E.TRSP_AGMT_SCG_NOD_SEQ         = F.TRSP_AGMT_SCG_NOD_SEQ            
               AND  E.TRSP_AGMT_SCG_RT_SEQ          = F.TRSP_AGMT_SCG_RT_SEQ            
               AND  B.TRSP_AGMT_OFC_CTY_CD          = pi_trsp_agmt_ofc_cty_cd            
               AND  B.TRSP_AGMT_SEQ                 = pi_trsp_agmt_seq            
               AND  B.TRSP_AGMT_RT_TP_SER_NO        = pi_trsp_agmt_rt_tp_ser_no            
               AND  C.TRSP_SCG_CD                  IN (v_scg1, v_scg2)            
               AND  E.EQ_KND_CD                     = pi_eq_knd_cd            
               AND  DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))            
               AND  C.AGMT_ROUT_ALL_FLG             = CASE WHEN C.FM_NOD_CD = '0000000' AND C.TO_NOD_CD = '0000000' THEN 'Y' ELSE 'N' END            
               AND  C.FM_NOD_CD                     = CASE WHEN C.TRSP_SCG_CD = 'FUE' THEN DECODE(LENGTH(C.FM_NOD_CD ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))            
                                                           WHEN C.TRSP_SCG_CD = 'FUA' THEN '0000000'            
                                                           WHEN C.TRSP_SCG_CD = 'VAT' THEN DECODE(LENGTH( DECODE(C.FM_NOD_CD, '0000000', 'N/A', C.FM_NOD_CD) ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000')            
                                                           WHEN C.TRSP_SCG_CD = 'TOL' THEN DECODE(LENGTH(C.FM_NOD_CD ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))            
                                                           ELSE '0000000'            
                                                      END            
               AND  C.VIA_NOD_CD                    = CASE WHEN C.TRSP_SCG_CD = 'FUE' THEN NVL(DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd , 5, SUBSTR(pi_via_nod_cd ,1,5)), '0000000')            
                                                           WHEN C.TRSP_SCG_CD = 'FUA' THEN '0000000'     
                                                           WHEN C.TRSP_SCG_CD = 'VAT' THEN DECODE(LENGTH( DECODE(C.VIA_NOD_CD, '0000000', 'N/A', C.VIA_NOD_CD) ), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5), '0000000')    
                                                           ELSE '0000000'            
                                                      END            
               AND  C.DOR_NOD_CD                    = CASE WHEN C.TRSP_SCG_CD = 'FUE' THEN NVL(DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5)), '0000000')            
                                                           WHEN C.TRSP_SCG_CD = 'FUA' THEN '0000000'            
                                                           WHEN C.TRSP_SCG_CD = 'VAT' THEN DECODE(LENGTH( DECODE(C.DOR_NOD_CD, '0000000', 'N/A', C.DOR_NOD_CD) ), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5), '0000000')            
                                                           WHEN C.TRSP_SCG_CD = 'TOL' THEN NVL(DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5)), '0000000')            
                                                           ELSE '0000000'            
                                                      END            
               AND  C.TO_NOD_CD                     = CASE WHEN C.TRSP_SCG_CD = 'FUE' THEN DECODE(LENGTH(C.TO_NOD_CD ), 7, pi_to_nod_cd  , 5, SUBSTR(pi_to_nod_cd  ,1,5))            
                                                           WHEN C.TRSP_SCG_CD = 'FUA' THEN '0000000'            
                                                           WHEN C.TRSP_SCG_CD = 'VAT' THEN DECODE(LENGTH( DECODE(C.TO_NOD_CD, '0000000', 'N/A', C.TO_NOD_CD) ), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000')            
                                                           WHEN C.TRSP_SCG_CD = 'TOL' THEN DECODE(LENGTH(C.TO_NOD_CD ), 7, pi_to_nod_cd  , 5, SUBSTR(pi_to_nod_cd  ,1,5))            
                                                           ELSE '0000000'            
                                                      END            
               AND  E.EFF_FM_DT                    <= pi_basis_dt            
               AND  E.EFF_TO_DT + (CASE WHEN SUBSTR(pi_system_indicator,1,3) = 'COA'     
                                     THEN (CASE WHEN E.EFF_TO_DT < TO_DATE('29991231', 'YYYYMMDD') THEN 100 ELSE 0 END)    
                                     ELSE 0     
                                END) >= pi_basis_dt    
               AND  NVL(F.AGMT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= pi_basis_dt            
               AND  CASE WHEN C.TRSP_SCG_CD = 'OW' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD), E.TO_WGT)            
                         ELSE 1            
                    END            
                    >            
                    CASE WHEN C.TRSP_SCG_CD = 'OW' THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(NVL(pi_wgt_uom, 'KGS'), pi_wgt_qty)            
                          ELSE 0            
                    END            
                /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */            
               AND  E.TRSP_AGMT_EQ_TP_SZ_CD        IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')            
                /* BASIC RATE WAY TYPE에 따라서 SURCHAGE WAY TYPE 결정 */            
               AND  CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT            
                                     WHEN 'RND' THEN E.TRSP_RND_RT            
                    END IS NOT NULL            
               /* 0:FUE >> FUA, 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST) */            
               AND  E.DELT_FLG = 'N'            
               ORDER BY C.TRSP_SCG_CD                      DESC                        /* */            
                       ,EQ_TPSZ_PRIOR_ORDER                ASC            
                       ,B.CMDT_GRP_CD                      ASC            
                       ,LENGTH(DECODE(C.FM_NOD_CD ,'0000000' ,'N/A', C.FM_NOD_CD))  DESC            
                       ,LENGTH(DECODE(C.VIA_NOD_CD,'0000000' ,'N/A', C.VIA_NOD_CD)) DESC            
                       ,LENGTH(DECODE(C.DOR_NOD_CD,'0000000' ,'N/A', C.DOR_NOD_CD)) DESC            
                       ,LENGTH(DECODE(C.TO_NOD_CD ,'0000000' ,'N/A', C.TO_NOD_CD))  DESC            
                       ,E.TRSP_AGMT_RT_HIS_SEQ          DESC -- HISTORY 자료중 마지막으로 등록된 RATE를 조회한다.            
    )            
    WHERE ROWNUM < 2;            
            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('♥=========== GET_SCG_RATE_CALCULATION_PRC QUERY SQL START =============' );            
        DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_SCG_RT_HIS WHERE 1=1 ');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_OFC_CTY_CD  = '''||pi_trsp_agmt_ofc_cty_cd||'''');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SEQ  = '||pi_trsp_agmt_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_TP_SER_NO  = '||pi_trsp_agmt_rt_tp_ser_no);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_NOD_SEQ  = '||vo_trsp_agmt_scg_nod_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_RT_SEQ  = '||vo_trsp_agmt_scg_rt_seq);            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_HIS_SEQ  = '||vo_trsp_agmt_rt_his_seq);            
        DBMS_OUTPUT.PUT_LINE('AND CFM_FLG  = '||vo_agmt_scg_rtn_msg);            
        DBMS_OUTPUT.PUT_LINE('♥=========== GET_SCG_RATE_CALCULATION_PRC QUERY SQL END ===============' );            
    END IF;            
            
    IF vo_delt_flg = 'N' THEN            
        po_scg_union_exp         := vo_scg_union_exp;            
        po_trsp_scg_cd           := vo_trsp_scg_cd;            
        po_trsp_agmt_scg_nod_seq := vo_trsp_agmt_scg_nod_seq;            
        po_trsp_agmt_scg_rt_seq  := vo_trsp_agmt_scg_rt_seq;            
        po_scg_curr_cd           := vo_scg_curr_cd;            
        po_scg_rate              := vo_scg_rate;            
    ELSE            
        po_rtn_cd := -2;            
        IF pi_debug_flg = 'Y' THEN            
            DBMS_OUTPUT.PUT_LINE('GET_SCG_RATE_CALCULATION_PRC <SURCHARGE RATE DELETE>');            
        END IF;            
    END IF;            
            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_scg_rate : ' || po_scg_rate);            
    END IF;            
            
    IF vo_agmt_scg_rt_div_cd = 'R' THEN -- Surcharge가 Ratio일 경우 Surcharge에는 Currency가 존재하지 않으므로 Basic가 동일하게 처리한다.            
        po_scg_curr_cd := pi_basic_curr_cd;            
    END IF;            
    IF pi_basic_curr_cd != po_scg_curr_cd  THEN            
        po_rtn_cd           := -101;            
        po_process_rslt_msg := 'BASIC/SURCHARGE CURRECY CODE IS DIFFERENCT ';            
    END IF;            
            
    IF vo_agmt_scg_rtn_msg = 'N' THEN            
        po_agmt_scg_rtn_msg    := vo_agmt_scg_rtn_msg;            
    END IF;            
            
EXCEPTION            
     WHEN NO_DATA_FOUND THEN            
          po_rtn_cd := -99;            
          po_process_rslt_msg := 'GET_SCG_RATE_CALCULATION_PRC <NO_DATA_FOUND>';            
          IF pi_debug_flg = 'Y' THEN            
              DBMS_OUTPUT.PUT_LINE('GET_SCG_RATE_CALCULATION_PRC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
          END IF;            
     WHEN OTHERS THEN            
          po_rtn_cd := -1;            
          po_process_rslt_msg := 'GET_SCG_RATE_CALCULATION_PRC <OTHERS>';            
          IF pi_debug_flg = 'Y' THEN            
              DBMS_OUTPUT.PUT_LINE('GET_SCG_RATE_CALCULATION_PRC <OTHERS> ERROR MSG = ['||SQLERRM||']');            
          END IF;            
END GET_SCG_RATE_CALCULATION_PRC;            
            
/*###################################################################            
 # -- Type    : PROCEDURE            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA  TRS            
 #####################################################################*/            
PROCEDURE GET_RAIL_SCG_RATE_CALC_PRC            
(            
    pi_system_indicator     IN  VARCHAR2    /* TRS, COA */            
   ,pi_eq_tp_sz_cd          IN  VARCHAR2            
   ,pi_vndr_seq             IN  VARCHAR2            
   ,pi_trsp_agmt_ofc_cty_cd IN  VARCHAR2            
   ,pi_trsp_agmt_seq        IN  NUMBER            
   ,pi_scg_knd_indicator    IN  VARCHAR2    /* FSG : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */            
   ,pi_cgo_tp_cd            IN  VARCHAR2            
   ,pi_from_nod_cd          IN  VARCHAR2            
   ,pi_to_nod_cd            IN  VARCHAR2            
   ,pi_wgt_uom              IN  VARCHAR2    /* L-LBS, K-KG */            
   ,pi_wgt_qty              IN  NUMBER            
   ,pi_basis_dt             IN  DATE            
   ,pi_spcl_cgo_cd          IN  VARCHAR2            
   ,pi_bzc_curr_cd          IN  VARCHAR2            
   ,pi_bzc_rt               IN  NUMBER            
   ,pi_debug_flg            IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)            
   ,po_rail_curr_cd        OUT  VARCHAR2            
   ,po_rail_scg_rt         OUT  NUMBER            
   ,po_rtn_cd              OUT  NUMBER            
   ,po_rtn_msg             OUT  VARCHAR2            
)            
IS            
    v_wgt_qty              NUMBER(9,3);            
    v_eq_sz                VARCHAR2(2)  ;            
    C_CONV_LB_FROM_KGS     CONSTANT NUMBER(10,6)    := 2.204;            
            
    vo_delt_flg            VARCHAR2(1);            
    vo_rail_curr_cd        VARCHAR2(3);            
    vo_rail_scg_rt         NUMBER(15,3);            
    vo_trsp_agmt_scg_seq   NUMBER(12);            
    vo_trsp_agmt_rt_his_seq   NUMBER(12);            
    v_aoc_flag                  VARCHAR2(1) := CASE WHEN SUBSTR(pi_system_indicator,1,3)='COA' THEN SUBSTR(pi_system_indicator,5,1) END;            
    v_system_indicator          VARCHAR2(4) := SUBSTR(pi_system_indicator,1,4);            
            
BEGIN            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('' );            
        DBMS_OUTPUT.PUT_LINE('♣=========== GET_RAIL_SCG_RATE_CALC_PRC PARAMETER START('||pi_scg_knd_indicator||')' );            
        DBMS_OUTPUT.PUT_LINE('pi_system_indicator  VARCHAR2(100) := ''' || pi_system_indicator      ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd       VARCHAR2(100) := ''' || pi_eq_tp_sz_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_vndr_seq          NUMBER(30) := ''' || pi_vndr_seq              ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd VARCHAR2(100) := ''' || pi_trsp_agmt_ofc_cty_cd  ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq     NUMBER(30) := ''' || pi_trsp_agmt_seq         ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_scg_knd_indicator VARCHAR2(100) := ''' || pi_scg_knd_indicator     ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd   VARCHAR2(100) := ''' || pi_cgo_tp_cd             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd VARCHAR2(100) := ''' || pi_from_nod_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd   VARCHAR2(100) := ''' || pi_to_nod_cd             ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_uom     VARCHAR2(100) := ''' || pi_wgt_uom               ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_wgt_qty     NUMBER(30) := ''' || pi_wgt_qty               ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_basis_dt    DATE  := TO_DATE(''' || TO_CHAR(pi_basis_dt,'YYYYMMDD') ||''',''YYYYMMDD'');');            
        DBMS_OUTPUT.PUT_LINE('pi_spcl_cgo_cd VARCHAR2(100) := ''' || pi_spcl_cgo_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_bzc_curr_cd VARCHAR2(100) := ''' || pi_bzc_curr_cd           ||''';');            
        DBMS_OUTPUT.PUT_LINE('pi_bzc_rt      NUMBER(15,3) := ''' || pi_bzc_rt                ||''';');            
        DBMS_OUTPUT.PUT_LINE('♣=========== GET_RAIL_SCG_RATE_CALC_PRC PARAMETER END('||pi_scg_knd_indicator||')' );            
    END IF;            
            
    IF pi_wgt_uom = 'KGS' THEN            
        v_wgt_qty := ROUND(pi_wgt_qty * C_CONV_LB_FROM_KGS, 0);            
    ELSE            
        v_wgt_qty := pi_wgt_qty;            
    END IF;            
            
    v_eq_sz := SUBSTR(pi_eq_tp_sz_cd,2,1);            
    SELECT CURR_CD, RAIL_SCG_RT, DELT_FLG            
          ,TRSP_AGMT_SCG_SEQ, TRSP_AGMT_RT_HIS_SEQ            
      INTO vo_rail_curr_cd, vo_rail_scg_rt, vo_delt_flg            
          ,vo_trsp_agmt_scg_seq, vo_trsp_agmt_rt_his_seq            
      FROM (  
            SELECT  E.CURR_CD            
                   ,CASE WHEN pi_scg_knd_indicator = 'FSG' THEN ROUND(pi_bzc_rt * (E.TRSP_RAIL_RTO / 100), NVL(E.RAIL_RTO_NO,0))            
                         WHEN pi_scg_knd_indicator = 'ISG' THEN (pi_bzc_rt * (E.TRSP_RAIL_RTO / 100)) * -1  
                         WHEN pi_scg_knd_indicator = 'FUM'   
                             THEN ROUND(CASE WHEN v_eq_sz = '2' OR v_eq_sz = '3' THEN NVL(E.FX_SCG_20FT_RT, E.FX_SCG_ALL_RT)            
                                             WHEN v_eq_sz = '4' OR v_eq_sz = '5' THEN NVL(E.FX_SCG_40FT_RT, E.FX_SCG_ALL_RT)            
                                             WHEN v_eq_sz = '6' OR v_eq_sz = '7' THEN NVL(E.FX_SCG_45FT_RT, E.FX_SCG_ALL_RT)            
                                        END  
                                     * (SELECT CASE DIST_UT_CD WHEN 'M' THEN LNK_DIST  
                                                               WHEN 'K' THEN ROUND(LNK_DIST / 1.609344)         
                                               END DIST  
                                          FROM PRD_INLND_EACH_LNK  A  
                                         WHERE LNK_ORG_NOD_CD  = pi_from_nod_cd  
                                           AND LNK_DEST_NOD_CD = pi_to_nod_cd  
                                           AND TRSP_MOD_CD     = 'RD'  
                                           AND NVL(DELT_FLG, 'N') = 'N'  
                                       )  
                                  ,NVL(E.RAIL_RTO_NO,0))  
                         ELSE CASE WHEN v_eq_sz = '2' OR v_eq_sz = '3' THEN NVL(E.FX_SCG_20FT_RT, E.FX_SCG_ALL_RT)            
                                   WHEN v_eq_sz = '4' OR v_eq_sz = '5' THEN NVL(E.FX_SCG_40FT_RT, E.FX_SCG_ALL_RT)            
                                   WHEN v_eq_sz = '6' OR v_eq_sz = '7' THEN NVL(E.FX_SCG_45FT_RT, E.FX_SCG_ALL_RT)            
                              END   
                    END AS RAIL_SCG_RT            
                   ,E.DELT_FLG            
                   ,E.TRSP_AGMT_SCG_SEQ            
                   ,E.TRSP_AGMT_RT_HIS_SEQ            
              FROM  TRS_AGMT_HDR       A            
                   ,TRS_AGMT_APLY_VNDR B            
                   ,TRS_AGMT_RAIL_SCG_RT_HIS E            
                   ,TRS_AGMT_RAIL_SCG_RT  F            
             WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD            
               AND A.TRSP_AGMT_SEQ        = B.TRSP_AGMT_SEQ            
               AND B.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD            
               AND B.TRSP_AGMT_SEQ        = E.TRSP_AGMT_SEQ            
               AND B.VNDR_SEQ             = E.VNDR_SEQ            
               AND E.TRSP_AGMT_SCG_SEQ    = F.TRSP_AGMT_SCG_SEQ            
               AND E.VNDR_SEQ             = pi_vndr_seq            
               AND E.TRSP_RAIL_SCG_CD     = CASE WHEN pi_spcl_cgo_cd = 'DG' AND pi_scg_knd_indicator  = 'HZS' THEN 'HZS'            
                                                 WHEN pi_spcl_cgo_cd = 'DG' AND pi_scg_knd_indicator != 'HZS' THEN ''            
                                                 WHEN pi_spcl_cgo_cd IS NULL AND pi_scg_knd_indicator != 'HZS' THEN pi_scg_knd_indicator            
                                            END            
               AND E.TRSP_AGMT_OFC_CTY_CD = pi_trsp_agmt_ofc_cty_cd            
               AND E.TRSP_AGMT_SEQ        = pi_trsp_agmt_seq            
               AND E.AGMT_ROUT_ALL_FLG    = CASE WHEN E.FM_NOD_CD = '00' THEN 'Y' ELSE 'N' END            
               AND E.FM_NOD_CD            = CASE WHEN E.FM_NOD_CD <> '00' THEN DECODE(LENGTH(E.FM_NOD_CD ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))            
                                                 ELSE '00'            
                                            END            
               AND E.TO_NOD_CD            = CASE WHEN E.TO_NOD_CD <> '00' THEN DECODE(LENGTH(E.TO_NOD_CD ), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))            
                                                 ELSE '00'            
                                            END            
               AND E.CGO_TP_CD = pi_cgo_tp_cd            
               AND NVL(E.LBS_OVR_WGT,0)  <= NVL2(v_wgt_qty, v_wgt_qty, 1)            
               AND E.EFF_FM_DT           <= pi_basis_dt    
               AND E.EFF_TO_DT + (CASE WHEN SUBSTR(pi_system_indicator,1,3) = 'COA'     
                                     THEN (CASE WHEN E.EFF_TO_DT < TO_DATE('29991231', 'YYYYMMDD') THEN 100 ELSE 0 END)    
                                     ELSE 0     
                                END) >= pi_basis_dt     
               AND NVL(F.AGMT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= pi_basis_dt            
               AND E.AGMT_EQ_SZ_NO        = CASE WHEN pi_scg_knd_indicator = 'OWS' THEN            
                                                      CASE WHEN v_eq_sz = '2' OR v_eq_sz = '3' THEN '20'            
                                                           WHEN v_eq_sz = '4' OR v_eq_sz = '5' THEN '40'            
                                                           WHEN v_eq_sz = '6' OR v_eq_sz = '7' THEN '45'            
                                                      END            
                                                 ELSE '00'            
                                            END            
               AND E.CURR_CD              = CASE WHEN pi_scg_knd_indicator IN ('FSG', 'ISG') THEN 'XXX'            
                                                 ELSE pi_bzc_curr_cd            
                                            END            
               AND E.DELT_FLG             = 'N'            
             ORDER BY LENGTH(DECODE(E.FM_NOD_CD,'00' ,'N/A', E.FM_NOD_CD)) DESC            
                     ,LENGTH(DECODE(E.TO_NOD_CD,'00' ,'N/A', E.TO_NOD_CD)) DESC            
                     ,E.AGMT_ROUT_ALL_FLG       DESC            
                     ,E.TRSP_AGMT_RT_HIS_SEQ    DESC -- HISTORY 자료중 마지막으로 등록된 RATE를 조회한다.            
         )            
         WHERE ROWNUM < 2;            
            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('♣=========== GET_RAIL_SCG_RATE_CALC_PRC QUERY SQL START('||pi_scg_knd_indicator||')' );            
        DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_RAIL_SCG_RT_HIS WHERE 1=1 ');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_SEQ = '''||vo_trsp_agmt_scg_seq||'''');            
        DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_HIS_SEQ = '||vo_trsp_agmt_rt_his_seq);            
        DBMS_OUTPUT.PUT_LINE('♣=========== GET_RAIL_SCG_RATE_CALC_PRC QUERY SQL END('||pi_scg_knd_indicator||')' );            
    END IF;            
            
    IF vo_delt_flg = 'N' THEN            
        po_rail_curr_cd     := vo_rail_curr_cd;            
        po_rail_scg_rt      := vo_rail_scg_rt;            
    ELSE            
        po_rtn_cd := -2;            
        DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <SURCHARGE RATE DELETE>('||pi_scg_knd_indicator||') ====');            
    END IF;            
            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.PUT_LINE('Return Scg Rate('||pi_scg_knd_indicator||') => po_rail_scg_rt : ' || po_rail_scg_rt);            
    END IF;            
            
    IF pi_scg_knd_indicator IN ('FSG', 'ISG') THEN -- Surcharge가 Ratio일 경우 Surcharge에는 Currency가 존재하지 않으므로 Basic가 동일하게 처리한다.            
        po_rail_curr_cd := pi_bzc_curr_cd;            
    END IF;            
            
    IF pi_bzc_curr_cd != po_rail_curr_cd  THEN            
        po_rtn_cd  := -101;            
        po_rtn_msg := 'BASIC/RAIL SURCHARGE CURRECY CODE IS DIFFERENCT ';            
    END IF;            
EXCEPTION            
    WHEN NO_DATA_FOUND THEN            
         po_rtn_cd := -99;            
         po_rtn_msg := 'GET_RAIL_SCG_RATE_CALC_PRC <NO_DATA_FOUND> ';            
         IF pi_debug_flg = 'Y' THEN            
             DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');            
         END IF;            
    WHEN OTHERS THEN            
         po_rtn_cd := -1;            
         po_rtn_msg := 'GET_RAIL_SCG_RATE_CALC_PRC <OTHERS> ';            
         IF pi_debug_flg = 'Y' THEN            
             DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <OTHERS> ERROR MSG = ['||SQLERRM||']');            
         END IF;            
END GET_RAIL_SCG_RATE_CALC_PRC;            
            
/*###################################################################            
 # -- Type    : PROCEDURE            
 # -- Author  : JONG HYEK CHOI            
 # -- Created : MAY 1, 2010            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : ALL RATE COMBINATION FOR COA            
 #####################################################################*/            
PROCEDURE GET_TRS_ALL_RATE_PRC            
(            
    pi_system_indicator         IN VARCHAR2            
   ,pi_ctrl_ofc_cd              IN VARCHAR2    /* Pair - X , Distance - Mandatory */            
   ,pi_vndr_seq                 IN VARCHAR2            
   ,pi_basis_dt                 IN DATE            
   ,pi_way_tp_cd                IN VARCHAR2    /* 'ONE' or 'RND'      */            
   ,pi_eq_knd_cd                IN VARCHAR2            
   ,pi_eq_tp_sz_cd              IN VARCHAR2            
   ,pi_cmb_tp_cd                IN VARCHAR2            
   ,pi_cgo_tp_cd                IN VARCHAR2            
   ,pi_bound_cd                 IN VARCHAR2    /* OPTIONAL - IN/OUT BOUND */            
   ,pi_crr_mod_cd               IN VARCHAR2            
   ,pi_cost_mod_cd              IN VARCHAR2            
   ,pi_cust_nomi_trkr_flg       IN VARCHAR2            
   ,pi_cust_cnt_cd              IN VARCHAR2            
   ,pi_cust_seq                 IN NUMBER            
   ,pi_rail_svc_tp_cd           IN VARCHAR2    /* OPTIONAL */            
   ,pi_cmdt_cd                  IN VARCHAR2    /* OPTIONAL */            
   ,pi_from_nod_cd              IN VARCHAR2            
   ,pi_via_nod_cd               IN VARCHAR2            
   ,pi_door_nod_cd              IN VARCHAR2            
   ,pi_to_nod_cd                IN VARCHAR2            
   ,pi_bundle_cnt               IN NUMBER            
   ,pi_wgt_uom                  IN VARCHAR2    /* L-LBS, K-KG */            
   ,pi_wgt_qty                  IN NUMBER            
   ,pi_rcv_term                 IN VARCHAR2  -- 신규로 추가된 컬럼            
   ,pi_de_term                  IN VARCHAR2  -- 신규로 추가된 컬럼            
   ,pi_trsp_agmt_ofc_cty_cd     IN VARCHAR2  -- 신규로 추가된 컬럼            
   ,pi_trsp_agmt_seq            IN NUMBER    -- 신규로 추가된 컬럼            
   ,pi_spcl_cgo_cd              IN VARCHAR2  -- 신규로 추가된 컬럼            
   ,pi_debug_flg                IN VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)            
   /* OUT PARAMETER  */            
   ,po_trsp_agmt_ofc_cty_cd    OUT VARCHAR2            
   ,po_trsp_agmt_seq           OUT NUMBER            
   ,po_trsp_agmt_rt_tp_cd      OUT VARCHAR2            
   ,po_way_type                OUT VARCHAR2            
   ,po_trsp_agmt_rt_tp_nm      OUT VARCHAR2            
   ,po_sp_type                 OUT VARCHAR2            
   ,po_cust_nomi_trkr_flg      OUT VARCHAR2            
   ,po_cust_cnt_cd             OUT VARCHAR2            
   ,po_cust_seq                OUT NUMBER            
   ,po_local_curr_cd           OUT VARCHAR2            
   ,po_bzc_rt                  OUT NUMBER            
   ,po_fuel_scg_rt             OUT NUMBER            
   ,po_over_wgt_scg_rt         OUT NUMBER            
   ,po_hzs_scg_rt              OUT NUMBER            
   ,po_ttl_scg_rt              OUT NUMBER            
   ,po_vat_scg_rt              OUT NUMBER            
   ,po_isg_scg_rt              OUT NUMBER            
   ,po_tf_scg_rt               OUT NUMBER    -- 추후 추가 발생시 사용 하기 위해 미리 생성            
   ,po_agmt_return_msg         OUT VARCHAR2  -- 추가되는 return 항목이 있을 경우 $를 구분자로 하여 concat후 return한다.            
   ,po_local_curr_tot_amt      OUT NUMBER            
   ,po_usd_curr_tot_amt        OUT NUMBER            
   ,po_wtr_rcv_term_cd         OUT VARCHAR2            
   ,po_wtr_de_term_cd          OUT VARCHAR2            
   ,po_rtn_cd                  OUT NUMBER            
   ,po_rtn_msg                 OUT VARCHAR2            
)            
IS            
    C_WAY_TYPE_PRIORITY    CONSTANT VARCHAR2(15)    := 'RND_PRIORITY';            
            
    vo_trsp_agmt_ofc_cty_cd         TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;            
    vo_trsp_agmt_seq                TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;            
    vo_trsp_agmt_rt_tp_ser_no       TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;            
    vo_trsp_scg_cd                  TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;            
    vo_trsp_agmt_scg_nod_seq        TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;            
    vo_trsp_agmt_scg_rt_seq         TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;            
    vo_scg_union_exp                VARCHAR2(100);            
    vo_vndr_seq                     TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;            
    vo_cust_nomi_trkr_flg           TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE;            
    vo_cust_cnt_cd                  TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;            
    vo_cust_seq                     TRS_AGMT_RT_TP.CUST_SEQ%TYPE;            
    vo_trsp_agmt_rt_tp_cd           TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;            
    vo_way_type                     VARCHAR2(3);            
    vo_fu_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_ow_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_dg_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_tl_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_is_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_bzc_rt                       NUMBER(18,3);            
    vo_fu_scg_rt                    NUMBER(18,3);            
    vo_ow_scg_rt                    NUMBER(18,3);            
    vo_dg_scg_rt                    NUMBER(18,3);            
    vo_tl_scg_rt                    NUMBER(18,3);            
    vo_is_scg_rt                    NUMBER(18,3);            
    vo_wtr_rcv_term_cd              TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;            
    vo_wtr_de_term_cd               TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;            
    vo_bzc_rtn_cd                   NUMBER(5);            
    vo_bzc_rtn_msg                  VARCHAR2(1000);            
    vo_fu_scg_rtn_cd                NUMBER(5);            
    vo_ow_scg_rtn_cd                NUMBER(5);            
    vo_dg_scg_rtn_cd                NUMBER(5);            
    vo_tl_scg_rtn_cd                NUMBER(5);            
    vo_is_scg_rtn_cd                NUMBER(5);            
    vo_fu_scg_rtn_msg               VARCHAR2(1000);            
    vo_ow_scg_rtn_msg               VARCHAR2(1000);            
    vo_dg_scg_rtn_msg               VARCHAR2(1000);            
    vo_tl_scg_rtn_msg               VARCHAR2(1000);            
    vo_is_scg_rtn_msg               VARCHAR2(1000);            
    vo_bzc_curr_cd                  VARCHAR2(3);            
    vo_trsp_agmt_rt_tp_nm           VARCHAR2(50);            
    vo_agmt_return_msg              VARCHAR2(1000);            
            
    v_trsp_so_knd_indicator         VARCHAR2(15);            
    v_new_rail_svc_tp_cd            VARCHAR2(2);            
    v_new_way_tp_cd                 VARCHAR2(15);            
    v_agmt_eq_knd_cd                VARCHAR2(1);            
    v_eq_tare_wgt                   NUMBER(18,3);            
    v_eq_tot_wgt                    NUMBER(18,3);            
    v_link_cnt                      NUMBER(1);            
    v_cust_cnt_cd                   TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;            
    v_cust_seq                      TRS_AGMT_RT_TP.CUST_SEQ%TYPE;            
    v_basis_dt                      DATE;            
    v_eq_tp_sz_cd                   VARCHAR2(4);            
    v_cust_nomi_trkr_ind_cd         VARCHAR2(3);            
            
    vo_bzc_vat_union_exp            VARCHAR2(100);            
    vo_trsp_bzc_vat_cd              TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;            
    vo_trsp_agmt_bzc_vat_nod_seq    TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;            
    vo_trsp_agmt_bzc_vat_rt_seq     TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;            
    vo_bzc_vat_curr_cd              VARCHAR2(3)  := '';            
    vo_bzc_vat_rt                   NUMBER(18,3);            
    vo_bzc_vat_rtn_cd               NUMBER(5);            
    vo_bzc_vat_rtn_msg              VARCHAR2(1000);            
            
    vo_fu_vat_union_exp             VARCHAR2(100);            
    vo_trsp_fu_vat_cd               TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;            
    vo_trsp_agmt_fu_vat_nod_seq     TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;            
    vo_trsp_agmt_fu_vat_rt_seq      TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;            
    vo_fu_vat_curr_cd               VARCHAR2(3)  := '';            
    vo_fu_vat_rt                    NUMBER(18,3);            
    vo_fu_vat_rtn_cd                NUMBER(5);            
    vo_fu_vat_rtn_msg               VARCHAR2(1000);            
            
    vo_vat_scg_rt                   NUMBER(18,3);            
            
    vo_tf_union_exp                 VARCHAR2(100);            
    vo_trsp_tf_scg_cd               TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;            
    vo_trsp_agmt_tf_nod_seq         TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;            
    vo_trsp_agmt_tf_rt_seq          TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;            
    vo_tf_scg_curr_cd               VARCHAR2(3)  := '';            
    vo_tf_scg_rt                    NUMBER(18,3);            
    vo_tf_scg_rtn_cd                NUMBER(5);            
    vo_tf_scg_rtn_msg               VARCHAR2(1000);            
    vo_agmt_fu_scg_rtn_msg          VARCHAR2(1000);            
    vo_agmt_bzc_vat_rtn_msg         VARCHAR2(1000);            
    vo_agmt_fu_vat_rtn_msg          VARCHAR2(1000);            
    vo_agmt_tf_scg_rtn_msg          VARCHAR2(1000);            
            
BEGIN            
    IF pi_debug_flg = 'Y' THEN            
        DBMS_OUTPUT.ENABLE(1000000);            
    END IF;            
    v_link_cnt        := TRS_AGMT_RATE_CC_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);            
    v_eq_tare_wgt     := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(NVL(pi_wgt_uom, 'KGS'), pi_eq_tp_sz_cd) ;            
    v_eq_tot_wgt      := NVL(v_eq_tare_wgt,0) + NVL(pi_wgt_qty,0);            
    v_basis_dt        := TO_DATE(TO_CHAR(pi_basis_dt,'YYYYMMDD'),'YYYYMMDD');            
            
    /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */            
    IF pi_cgo_tp_cd = 'M' AND (SUBSTR(pi_eq_tp_sz_cd,1,1) = 'F' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'A' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'P') THEN            
        v_agmt_eq_knd_cd := 'Z';            
    ELSE            
        v_agmt_eq_knd_cd := pi_eq_knd_cd;            
    END IF;            
            
    /* NONE_USRAIL SO, US RAIL SO 판단 START */            
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN            
        v_trsp_so_knd_indicator := 'USRAIL';            
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd,1,2) ;   /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */            
        IF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'O' THEN            
            v_new_way_tp_cd := 'ONE' ;  /* ONE    */            
        ELSIF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'R' THEN            
            v_new_way_tp_cd := 'RND' ;  /* RND */            
        ELSE            
            v_new_way_tp_cd := ''    ;            
        END IF;            
            
        v_cust_nomi_trkr_ind_cd := 'HJS';            
        v_cust_cnt_cd     := 'XX';            
        v_cust_seq        := 0;            
    ELSE            
        v_trsp_so_knd_indicator := 'NONE_USRAIL' ;            
        v_new_way_tp_cd := ''    ;            
        /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */            
        IF pi_cust_nomi_trkr_flg = 'Y' THEN   -- Only ETS            
           v_cust_nomi_trkr_ind_cd := 'MIC';            
           v_cust_cnt_cd     := pi_cust_cnt_cd;            
           v_cust_seq        := pi_cust_seq   ;            
            
        ELSIF pi_cust_nomi_trkr_flg IN ('CNT','CPT','HPT', 'MIC', '%') THEN            
            v_cust_nomi_trkr_ind_cd := pi_cust_nomi_trkr_flg;            
            v_cust_cnt_cd     := pi_cust_cnt_cd;            
            v_cust_seq        := pi_cust_seq   ;            
        ELSE            
            v_cust_nomi_trkr_ind_cd := 'HJS';            
            v_cust_cnt_cd     := 'XX';            
            v_cust_seq        := 0;            
        END IF;            
    END IF;            
            
    /* COMBINED TYPE CODE CONVERSION */            
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN            
        v_new_way_tp_cd := pi_way_tp_cd;            
    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR pi_cmb_tp_cd = 'FM' THEN            
        v_new_way_tp_cd := C_WAY_TYPE_PRIORITY ;   /* roundtrip currency priority */            
    ELSE            
        v_new_way_tp_cd := '';            
    END IF;            
            
    /* R Type의 Container의 Special Cargo정보가 'RD'일 경우엔 D Type으로 Rate를 찾는다. */            
    IF SUBSTR(pi_eq_tp_sz_cd,1,1) = 'R' AND pi_spcl_cgo_cd = 'RD' THEN            
        v_eq_tp_sz_cd := 'D'||SUBSTR(pi_eq_tp_sz_cd,2,1);            
    ELSE            
        v_eq_tp_sz_cd := pi_eq_tp_sz_cd;            
    END IF;            
            
    /* D3일 경우 D2 Rate로 적용되도록 CNTR TP/SZ를 변경한다. Tare Weight는 원래 TP/SZ로 적용 (Tare Weight 조회 로직은 상단에 있음) */            
    IF v_eq_tp_sz_cd = 'D3' THEN            
        v_eq_tp_sz_cd := 'D2';            
    END IF;            
            
    /* BASIC RATE CALCULATION */            
    GET_BASIC_RATE_CALCULATION_PRC   (            
        pi_system_indicator            
       ,v_trsp_so_knd_indicator ,pi_trsp_agmt_ofc_cty_cd ,pi_trsp_agmt_seq ,v_agmt_eq_knd_cd    ,v_link_cnt            
       ,pi_ctrl_ofc_cd          ,pi_vndr_seq             ,v_basis_dt       ,v_new_way_tp_cd     ,pi_eq_knd_cd            
       ,v_eq_tp_sz_cd           ,pi_cmb_tp_cd            ,pi_cgo_tp_cd     ,pi_bound_cd         ,pi_crr_mod_cd            
       ,pi_cost_mod_cd          ,v_cust_nomi_trkr_ind_cd ,v_cust_cnt_cd    ,v_cust_seq          ,v_new_rail_svc_tp_cd,pi_cmdt_cd            
       ,pi_from_nod_cd          ,pi_via_nod_cd           ,pi_door_nod_cd   ,pi_to_nod_cd        ,pi_bundle_cnt            
       ,pi_wgt_uom              ,v_eq_tot_wgt            ,pi_rcv_term      ,pi_de_term          ,'N'            
       ,pi_debug_flg            
       -- OUT PARAMETER            
       ,vo_trsp_agmt_ofc_cty_cd ,vo_trsp_agmt_seq  ,vo_trsp_agmt_rt_tp_ser_no ,vo_vndr_seq           ,vo_cust_nomi_trkr_flg            
       ,vo_cust_cnt_cd          ,vo_cust_seq       ,vo_trsp_agmt_rt_tp_cd     ,vo_way_type           ,vo_bzc_curr_cd            
       ,vo_wtr_rcv_term_cd      ,vo_wtr_de_term_cd ,vo_bzc_rt                 ,vo_trsp_agmt_rt_tp_nm ,vo_agmt_return_msg            
       ,vo_bzc_rtn_cd           ,vo_bzc_rtn_msg            
    );            
            
    IF vo_bzc_rtn_cd = 0 THEN            
        IF v_trsp_so_knd_indicator = 'USRAIL' THEN            
            -- MILEAGE FUEL SURCHARGE   
            GET_RAIL_SCG_RATE_CALC_PRC            
            (   
                pi_system_indicator            
               ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd  ,vo_trsp_agmt_seq ,'FUM'            
               ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,NULL       ,NULL ,v_basis_dt            
               ,NULL           ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
               -- OUT PARAMETER            
               ,vo_fu_scg_curr_cd ,vo_fu_scg_rt            
               ,vo_fu_scg_rtn_cd  ,vo_fu_scg_rtn_msg                  
            );   
  
            IF vo_fu_scg_rtn_cd = -99 THEN -- MILEAGE FUEL SURCHARGE가 없을 경우에만 수행한다.   
                -- FUEL SURCHARGE            
                GET_RAIL_SCG_RATE_CALC_PRC            
                (            
                    pi_system_indicator            
                   ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd   ,vo_trsp_agmt_seq ,'FSG'            
                   ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,NULL        ,NULL  ,v_basis_dt            
                   ,NULL           ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
                   -- OUT PARAMETER            
                   ,vo_fu_scg_curr_cd ,vo_fu_scg_rt            
                   ,vo_fu_scg_rtn_cd  ,vo_fu_scg_rtn_msg            
                );   
            END IF;   
            -- OVER WEIGHT SURCHARGE            
            GET_RAIL_SCG_RATE_CALC_PRC            
            (            
                pi_system_indicator            
               ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd  ,vo_trsp_agmt_seq ,'OWS'            
               ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,pi_wgt_uom ,pi_wgt_qty ,v_basis_dt            
               ,NULL           ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
               -- OUT PARAMETER            
               ,vo_ow_scg_curr_cd ,vo_ow_scg_rt            
               ,vo_ow_scg_rtn_cd  ,vo_ow_scg_rtn_msg            
            );            
            -- HAZMAT SURCHARGE            
            GET_RAIL_SCG_RATE_CALC_PRC            
            (            
                pi_system_indicator            
               ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd  ,vo_trsp_agmt_seq ,'HZS'            
               ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,NULL       ,NULL ,v_basis_dt            
               --,pi_spcl_cgo_cd
               ,CASE WHEN INSTR (pi_spcl_cgo_cd, 'DG') > 0 THEN 'DG' END
               ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
               -- OUT PARAMETER            
               ,vo_dg_scg_curr_cd ,vo_dg_scg_rt            
               ,vo_dg_scg_rtn_cd  ,vo_dg_scg_rtn_msg            
            );            
            -- ETC TOTAL SURCHARGE            
            GET_RAIL_SCG_RATE_CALC_PRC            
            (            
                pi_system_indicator            
               ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd  ,vo_trsp_agmt_seq ,'TTL'            
               ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,NULL       ,NULL ,v_basis_dt            
               ,NULL           ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
               -- OUT PARAMETER            
               ,vo_tl_scg_curr_cd ,vo_tl_scg_rt            
               ,vo_tl_scg_rtn_cd  ,vo_tl_scg_rtn_msg            
            );            
            
            IF SUBSTR(pi_system_indicator,1,4) IN ('COA1', 'COA2') THEN            
                -- Incentive SURCHARGE            
                GET_RAIL_SCG_RATE_CALC_PRC            
                (            
                    pi_system_indicator            
                   ,v_eq_tp_sz_cd  ,pi_vndr_seq    ,vo_trsp_agmt_ofc_cty_cd  ,vo_trsp_agmt_seq ,'ISG'            
                   ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,NULL       ,NULL ,v_basis_dt            
                   ,NULL           ,vo_bzc_curr_cd ,vo_bzc_rt    ,pi_debug_flg            
                   -- OUT PARAMETER            
                   ,vo_is_scg_curr_cd ,vo_is_scg_rt            
                   ,vo_is_scg_rtn_cd  ,vo_is_scg_rtn_msg            
                );            
            END IF;            
        ELSE            
            /* FUEL SURCHARGE RATE CALCULATION */            
            GET_SCG_RATE_CALCULATION_PRC (            
                pi_system_indicator ,v_trsp_so_knd_indicator   ,'FU'           ,vo_way_type   ,vo_trsp_agmt_ofc_cty_cd            
               ,vo_trsp_agmt_seq   ,vo_trsp_agmt_rt_tp_ser_no ,pi_vndr_seq    ,v_basis_dt            
               ,pi_eq_knd_cd       ,v_eq_tp_sz_cd             ,pi_cgo_tp_cd   ,pi_from_nod_cd            
               ,pi_via_nod_cd      ,pi_door_nod_cd            ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL            
               ,NULL               ,vo_bzc_rt                 ,vo_bzc_curr_cd ,pi_debug_flg            
               /* OUT PARAMETER */            
               ,vo_scg_union_exp   ,vo_trsp_scg_cd ,vo_trsp_agmt_scg_nod_seq  ,vo_trsp_agmt_scg_rt_seq ,vo_fu_scg_curr_cd            
               ,vo_fu_scg_rt            
               ,vo_fu_scg_rtn_cd   ,vo_fu_scg_rtn_msg, vo_agmt_fu_scg_rtn_msg            
            );            
            
            
            /* VAT SURCHARGE AMOUNT RATE CALCULATION */            
            GET_SCG_RATE_CALCULATION_PRC (            
                pi_system_indicator ,v_trsp_so_knd_indicator   ,'VT'           ,vo_way_type   ,vo_trsp_agmt_ofc_cty_cd            
               ,vo_trsp_agmt_seq   ,vo_trsp_agmt_rt_tp_ser_no ,pi_vndr_seq    ,v_basis_dt            
               ,pi_eq_knd_cd       ,v_eq_tp_sz_cd             ,pi_cgo_tp_cd   ,pi_from_nod_cd            
               ,pi_via_nod_cd      ,pi_door_nod_cd            ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL            
               ,NULL               ,vo_bzc_rt                 ,vo_bzc_curr_cd ,pi_debug_flg            
               /* OUT PARAMETER */            
               ,vo_bzc_vat_union_exp   ,vo_trsp_bzc_vat_cd ,vo_trsp_agmt_bzc_vat_nod_seq  ,vo_trsp_agmt_bzc_vat_rt_seq ,vo_bzc_vat_curr_cd            
               ,vo_bzc_vat_rt            
               ,vo_bzc_vat_rtn_cd   ,vo_bzc_vat_rtn_msg, vo_agmt_bzc_vat_rtn_msg            
            );            
            
            /* VAT SURCHARGE AMOUNT RATE CALCULATION */            
            GET_SCG_RATE_CALCULATION_PRC (            
                pi_system_indicator ,v_trsp_so_knd_indicator   ,'VT'           ,vo_way_type   ,vo_trsp_agmt_ofc_cty_cd            
               ,vo_trsp_agmt_seq   ,vo_trsp_agmt_rt_tp_ser_no ,pi_vndr_seq    ,v_basis_dt            
               ,pi_eq_knd_cd       ,v_eq_tp_sz_cd             ,pi_cgo_tp_cd   ,pi_from_nod_cd            
               ,pi_via_nod_cd      ,pi_door_nod_cd            ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL            
               ,NULL               ,vo_fu_scg_rt              ,vo_bzc_curr_cd ,pi_debug_flg            
               /* OUT PARAMETER */            
               ,vo_fu_vat_union_exp   ,vo_trsp_fu_vat_cd ,vo_trsp_agmt_fu_vat_nod_seq  ,vo_trsp_agmt_fu_vat_rt_seq ,vo_fu_vat_curr_cd            
               ,vo_fu_vat_rt            
               ,vo_fu_vat_rtn_cd   ,vo_fu_vat_rtn_msg, vo_agmt_fu_vat_rtn_msg            
            );            
            
            vo_vat_scg_rt          := vo_bzc_vat_rt + NVL(vo_fu_vat_rt,0);            
            
            /* TOLL FEE SURCHARGE RATE CALCULATION */            
            GET_SCG_RATE_CALCULATION_PRC (            
                pi_system_indicator ,v_trsp_so_knd_indicator   ,'TF'           ,vo_way_type   ,vo_trsp_agmt_ofc_cty_cd            
               ,vo_trsp_agmt_seq   ,vo_trsp_agmt_rt_tp_ser_no ,pi_vndr_seq    ,v_basis_dt            
               ,pi_eq_knd_cd       ,v_eq_tp_sz_cd             ,pi_cgo_tp_cd   ,pi_from_nod_cd            
               ,pi_via_nod_cd      ,pi_door_nod_cd            ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL            
               ,NULL               ,vo_bzc_rt                 ,vo_bzc_curr_cd ,pi_debug_flg            
               /* OUT PARAMETER */            
               ,vo_tf_union_exp   ,vo_trsp_tf_scg_cd ,vo_trsp_agmt_tf_nod_seq  ,vo_trsp_agmt_tf_rt_seq ,vo_tf_scg_curr_cd            
               ,vo_tf_scg_rt            
               ,vo_tf_scg_rtn_cd   ,vo_tf_scg_rtn_msg, vo_agmt_tf_scg_rtn_msg            
            );            
            
        END IF;            
        po_rtn_cd                  := 0                    ;            
        po_rtn_msg                 := 'SUCCESS'            ;            
    ELSE            
        po_rtn_cd   := vo_bzc_rtn_cd;   /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */            
        po_rtn_msg  := vo_bzc_rtn_msg || ' ________ ' || vo_fu_scg_rtn_msg || ' ________ ' || vo_ow_scg_rtn_msg;            
    END IF;            
            
    /* DIFFERENT CURRENCY 체크 */            
    IF vo_fu_scg_rtn_cd < -100 THEN po_rtn_cd := vo_fu_scg_rtn_cd; po_rtn_msg := vo_fu_scg_rtn_msg; END IF;            
    IF vo_ow_scg_rtn_cd < -100 THEN po_rtn_cd := vo_ow_scg_rtn_cd; po_rtn_msg := vo_ow_scg_rtn_msg; END IF;            
    IF vo_dg_scg_rtn_cd < -100 THEN po_rtn_cd := vo_dg_scg_rtn_cd; po_rtn_msg := vo_dg_scg_rtn_msg; END IF;            
    IF vo_tl_scg_rtn_cd < -100 THEN po_rtn_cd := vo_tl_scg_rtn_cd; po_rtn_msg := vo_tl_scg_rtn_msg; END IF;            
    IF vo_is_scg_rtn_cd < -100 THEN po_rtn_cd := vo_is_scg_rtn_cd; po_rtn_msg := vo_is_scg_rtn_msg; END IF;            
    IF vo_tf_scg_rtn_cd < -100 THEN po_rtn_cd := vo_tf_scg_rtn_cd; po_rtn_msg := vo_tf_scg_rtn_msg; END IF;            
            
    IF pi_debug_flg = 'Y' THEN            
        IF vo_fu_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_is_scg_rtn_cd :' ||'('||vo_is_scg_rtn_cd || ')' || vo_fu_scg_rtn_msg ); END IF;            
        IF vo_ow_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_ow_scg_rtn_cd :' ||'('||vo_ow_scg_rtn_cd || ')' || vo_ow_scg_rtn_msg ); END IF;            
        IF vo_dg_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_dg_scg_rtn_cd :' ||'('||vo_dg_scg_rtn_cd || ')' || vo_dg_scg_rtn_msg ); END IF;            
        IF vo_tl_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_tl_scg_rtn_cd :' ||'('||vo_tl_scg_rtn_cd || ')' || vo_tl_scg_rtn_msg ); END IF;            
        IF vo_is_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_is_scg_rtn_cd :' ||'('||vo_is_scg_rtn_cd || ')' || vo_is_scg_rtn_msg ); END IF;            
        IF vo_tf_scg_rtn_cd < -100 THEN DBMS_OUTPUT.PUT_LINE('◆ERR◆ vo_tf_scg_rtn_cd :' ||'('||vo_tf_scg_rtn_cd || ')' || vo_tf_scg_rtn_msg ); END IF;            
    END IF;            
            
    IF po_rtn_cd = 0 THEN            
        po_trsp_agmt_ofc_cty_cd     := vo_trsp_agmt_ofc_cty_cd;            
        po_trsp_agmt_seq            := vo_trsp_agmt_seq;            
        po_local_curr_cd            := vo_bzc_curr_cd;            
            
        IF v_trsp_so_knd_indicator = 'USRAIL' THEN            
            po_bzc_rt := vo_bzc_rt ;            
            po_fuel_scg_rt     := NVL(vo_fu_scg_rt,0) ;            
            po_over_wgt_scg_rt := NVL(vo_ow_scg_rt,0) ;            
            po_hzs_scg_rt      := NVL(vo_dg_scg_rt,0) ;            
            po_ttl_scg_rt      := NVL(vo_tl_scg_rt,0) ;            
            po_isg_scg_rt      := NVL(vo_is_scg_rt,0) ;            
        ELSE            
            po_bzc_rt                   := vo_bzc_rt;            
            po_fuel_scg_rt              := NVL(vo_fu_scg_rt,0);            
            po_over_wgt_scg_rt          := NVL(vo_ow_scg_rt,0);            
            po_tf_scg_rt                := NVL(vo_tf_scg_rt,0);            
        END IF;            
            
        po_cust_nomi_trkr_flg       := vo_cust_nomi_trkr_flg;            
        po_way_type                 := vo_way_type;            
            
--        IF vo_cust_nomi_trkr_flg = 'Y' THEN po_sp_type := 'CNT'; ELSE po_sp_type := 'HJS'; END IF;  TRS_AGMT_RT_TP테이블 CUST_NOMI_TRKR_IND_CD 항목으로 대체            
            
        po_local_curr_tot_amt   := vo_bzc_rt + NVL(vo_fu_scg_rt,0) + NVL(vo_ow_scg_rt,0) + NVL(vo_dg_scg_rt,0) + NVL(vo_tl_scg_rt,0) + NVL(vo_vat_scg_rt,0) + NVL(vo_is_scg_rt,0)+NVL(po_tf_scg_rt,0);            
        po_cust_cnt_cd          := vo_cust_cnt_cd                                     ;            
        po_cust_seq             := vo_cust_seq                                        ;            
        po_trsp_agmt_rt_tp_cd   := vo_trsp_agmt_rt_tp_cd                              ;            
        po_way_type             := vo_way_type;            
        po_trsp_agmt_rt_tp_nm   := vo_trsp_agmt_rt_tp_nm;            
        po_cust_cnt_cd          := vo_cust_cnt_cd;            
        po_cust_seq             := vo_cust_seq;            
        po_local_curr_cd        := vo_bzc_curr_cd;            
        po_wtr_rcv_term_cd      := vo_wtr_rcv_term_cd;            
        po_wtr_de_term_cd       := vo_wtr_de_term_cd;            
            
        po_vat_scg_rt           := vo_vat_scg_rt;            
            
        /* CHM-201535825 Surcharge confirm 대상 추가 */            
        IF vo_agmt_fu_scg_rtn_msg = 'N' OR vo_agmt_bzc_vat_rtn_msg = 'N' OR vo_agmt_fu_vat_rtn_msg = 'N' OR vo_agmt_tf_scg_rtn_msg = 'N' THEN            
            vo_agmt_return_msg      := SUBSTR(vo_agmt_return_msg, 1, INSTR(vo_agmt_return_msg, '$', 1, 3)) || 'N' || SUBSTR(vo_agmt_return_msg, INSTR(vo_agmt_return_msg,'$', 1, 4));            
        END IF;            
            
        po_agmt_return_msg      := vo_agmt_return_msg;            
            
        /* TOTAL AMOUNT - USD CURRENCY   */            
        IF po_local_curr_tot_amt > 0 THEN            
            po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(vo_bzc_curr_cd, po_local_curr_tot_amt);            
        END IF;            
            
        IF pi_debug_flg = 'Y' THEN            
            DBMS_OUTPUT.PUT_LINE('' );            
            DBMS_OUTPUT.PUT_LINE('============ Calc Parameter ===============' );            
            DBMS_OUTPUT.PUT_LINE('v_link_cnt :' || v_link_cnt );            
            DBMS_OUTPUT.PUT_LINE('v_eq_tare_wgt :' || v_eq_tare_wgt );            
            DBMS_OUTPUT.PUT_LINE('◀◀◀◀◀◀◀ Retrun Parameter ▶▶▶▶▶▶▶' );            
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_ofc_cty_cd:' || po_trsp_agmt_ofc_cty_cd );            
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_seq     :' || po_trsp_agmt_seq        );            
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_cd:' || po_trsp_agmt_rt_tp_cd   );            
            DBMS_OUTPUT.PUT_LINE('po_way_type          :' || po_way_type             );            
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_nm:' || po_trsp_agmt_rt_tp_nm   );            
            DBMS_OUTPUT.PUT_LINE('po_sp_type           :' || po_sp_type              );            
            DBMS_OUTPUT.PUT_LINE('po_cust_nomi_trkr_flg:' || po_cust_nomi_trkr_flg   );            
            DBMS_OUTPUT.PUT_LINE('po_cust_cnt_cd       :' || po_cust_cnt_cd          );            
            DBMS_OUTPUT.PUT_LINE('po_cust_seq          :' || po_cust_seq             );            
            DBMS_OUTPUT.PUT_LINE('po_local_curr_cd     :' || po_local_curr_cd        );            
            DBMS_OUTPUT.PUT_LINE('po_bzc_rt            :' || po_bzc_rt               );            
            DBMS_OUTPUT.PUT_LINE('po_fuel_scg_rt       :' || po_fuel_scg_rt          );            
            DBMS_OUTPUT.PUT_LINE('po_over_wgt_scg_rt   :' || po_over_wgt_scg_rt      );            
            DBMS_OUTPUT.PUT_LINE('po_hzs_scg_rt        :' || po_hzs_scg_rt           );            
            DBMS_OUTPUT.PUT_LINE('po_ttl_scg_rt        :' || po_ttl_scg_rt           );            
            DBMS_OUTPUT.PUT_LINE('po_isg_scg_rt        :' || po_isg_scg_rt           );            
            DBMS_OUTPUT.PUT_LINE('po_vat_scg_rt        :' || po_vat_scg_rt           );            
            DBMS_OUTPUT.PUT_LINE('po_tf_scg_rt         :' || po_tf_scg_rt           );            
            DBMS_OUTPUT.PUT_LINE('po_local_curr_tot_amt:' || po_local_curr_tot_amt   );            
            DBMS_OUTPUT.PUT_LINE('po_usd_curr_tot_amt  :' || po_usd_curr_tot_amt     );            
            DBMS_OUTPUT.PUT_LINE('po_wtr_rcv_term_cd   :' || po_wtr_rcv_term_cd      );            
            DBMS_OUTPUT.PUT_LINE('po_wtr_de_term_cd    :' || po_wtr_de_term_cd       );            
            DBMS_OUTPUT.PUT_LINE('po_agmt_return_msg   :' || po_agmt_return_msg      );            
        END IF;            
            
    END IF;            
    EXCEPTION            
        WHEN OTHERS THEN            
            po_rtn_cd := -1;            
            IF pi_debug_flg = 'Y' THEN            
                DBMS_OUTPUT.PUT_LINE('GET_TRS_ALL_RATE_PRC <OTHERS> ERROR MSG = ['||SQLERRM||']');            
            END IF;            
    END GET_TRS_ALL_RATE_PRC;            
            
/*###################################################################            
 # -- Type    : PROCEDURE            
 # -- Author  : PARK JUN-YONG            
 # -- Created : MARCH 26, 2008            
 # -- Table   : TRS_TRSP_AGMT_*            
 # -- Purpose : SOME RATE COMBINATION FOR TRS US RAIL S/O            
 #####################################################################*/            
PROCEDURE GET_USRAIL_CONV_AGMT_NO_PRC            
(            
    pi_vndr_seq                IN VARCHAR2            
   ,pi_cmdt_cd                 IN VARCHAR2    /* OPTIONAL */            
   ,pi_spcl_cgo_cntr_tp_cd     IN VARCHAR2    /* OPTIONAL */            
   ,po_rtn_cd                 OUT NUMBER            
   ,po_trsp_agmt_ofc_cty_cd   OUT VARCHAR2            
   ,po_trsp_agmt_seq          OUT NUMBER            
)            
IS            
    vo_trsp_grp_cmdt_cd       TRS_CMDT_GRP_CZ.TRSP_GRP_CMDT_CD%TYPE;            
BEGIN  
    po_rtn_cd := 1;  
-- 119993, 108299 S/P 미사용으로 GET_USRAIL_CONV_AGMT_NO_PRC 주석 처리 (향후 S/P 사용시 하드코딩 변경 필요)  
--    IF pi_vndr_seq = '119993' THEN            
--        BEGIN            
--            SELECT TRSP_GRP_CMDT_CD            
--              INTO vo_trsp_grp_cmdt_cd            
--              FROM TRS_CMDT_GRP_CZ            
--             WHERE VNDR_SEQ = pi_vndr_seq            
--               AND CMDT_CD  = pi_cmdt_cd            
--               AND DELT_FLG = 'N'            
--               AND ROWNUM = 1;            
--        EXCEPTION            
--           WHEN OTHERS THEN            
--           po_rtn_cd := 1;            
--        END;            
--            
--        IF pi_spcl_cgo_cntr_tp_cd = 'G' THEN /* GRAIN BULK */            
--            po_trsp_agmt_ofc_cty_cd := 'NYC';            
--            po_trsp_agmt_seq := 1049;            
--            po_rtn_cd := 0;            
--        ELSIF vo_trsp_grp_cmdt_cd = '8000' THEN            
--            po_trsp_agmt_ofc_cty_cd := 'NYC';            
--            po_trsp_agmt_seq := 1047;            
--            po_rtn_cd := 0;            
--        ELSIF vo_trsp_grp_cmdt_cd = '8001' THEN            
--            po_trsp_agmt_ofc_cty_cd := 'NYC';            
--            po_trsp_agmt_seq := 1049;            
--            po_rtn_cd := 0;            
--        ELSIF vo_trsp_grp_cmdt_cd = '8002' THEN            
--            po_trsp_agmt_ofc_cty_cd := 'NYC';            
--            po_trsp_agmt_seq := 1051;            
--            po_rtn_cd := 0;            
--        ELSE            
--            po_rtn_cd := 1;            
--        END IF;            
--    ELSIF pi_vndr_seq = '108299' THEN            
--        IF pi_cmdt_cd IN ('980034', '100700') THEN            
--            po_trsp_agmt_ofc_cty_cd := 'NYC';            
--            po_trsp_agmt_seq := 15129;            
--            po_rtn_cd := 0;            
--        END IF;            
--    ELSE            
--        po_rtn_cd := 1;            
--    END IF;            
            
END GET_USRAIL_CONV_AGMT_NO_PRC;        
        
/*###################################################################        
 # -- Type    : Function        
 # -- Author  : CJH        
 # -- Created : 2016.05.09        
 # -- Purpose : RATE 계산 Procedure를 Function으로 변경        
 #####################################################################*/        
FUNCTION GET_RATE_FNC             
(            
     pi_sys_cd               VARCHAR2 -- TRS COA 구분            
    ,pi_cre_ofc_cd           VARCHAR2            
    ,pi_vndr_cd              VARCHAR2              
    ,pi_cre_dt               DATE            
    ,pi_wy_tp_cd             VARCHAR2            
    ,pi_eq_knd_cd            VARCHAR2            
    ,pi_eq_tpsz_cd           VARCHAR2            
    ,pi_trsp_so_cmb_tp_cd    VARCHAR2            
    ,pi_cgo_tp_cd            VARCHAR2            
    ,pi_trsp_bnd_cd          VARCHAR2            
    ,pi_trsp_crr_mod_cd      VARCHAR2            
    ,pi_trsp_cost_dtl_mod_cd VARCHAR2 -- DOOR일 경우 'DR' 그렇지 않을 경우 'CY'            
    ,pi_cust_nomi_trkr_flg   VARCHAR2 -- HJS는 'N' CNT는 'Y'            
    ,pi_cust_cnt_cd          VARCHAR2 -- HJS는 null CNT는 값 입력            
    ,pi_cust_seq             NUMBER   -- HJS는 null CNT는 값 입력            
    ,pi_rail_ssvc_tp_cd      VARCHAR2            
    ,pi_cmdt_cd              VARCHAR2            
    ,pi_fm_nod_cd            VARCHAR2            
    ,pi_via_nod_cd           VARCHAR2            
    ,pi_dor_nod_cd           VARCHAR2            
    ,pi_to_nod_cd            VARCHAR2            
    ,pi_bundling_no          NUMBER            
    ,pi_wgt_meas_ut_cd       VARCHAR2            
    ,pi_cntr_wgt             NUMBER            
    ,pi_rcv_term             VARCHAR2            
    ,pi_de_term              VARCHAR2            
    ,pi_trsp_agmt_ofc_cty_cd VARCHAR2            
    ,pi_trsp_agmt_seq        NUMBER            
    ,pi_spcl_cgo_cd          VARCHAR2        
    ,pi_debug_flg            VARCHAR2        
)            
RETURN VARCHAR2            
IS                                                                                                                        
    o_out                 VARCHAR2(1000) ; -- RETURN            
    v_cust_nomi_trkr_flg  VARCHAR2(1) ;            
               
    po_trsp_agmt_ofc_cty_cd    TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;            
    po_trsp_agmt_seq           TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;          
    po_trsp_agmt_rt_tp_cd      TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;         
    po_way_type                VARCHAR2(3);        
    po_trsp_agmt_rt_tp_nm      VARCHAR2(50) ;            
    po_sp_type                 VARCHAR2(10) ;            
    po_cust_nomi_trkr_flg      VARCHAR2(10) ;            
    po_cust_cnt_cd             VARCHAR2(10) ;            
    po_cust_seq                NUMBER        ;            
    po_local_curr_cd           VARCHAR2(3) ;            
    po_bzc_rt                  NUMBER        ;            
    po_fuel_scg_rt             NUMBER        ;            
    po_over_wgt_scg_rt         NUMBER        ;            
    po_hzs_scg_rt              NUMBER        ;            
    po_ttl_wgt_scg_rt          NUMBER        ;            
    po_vat_scg_rt              NUMBER        ;            
    po_scg1_rt                 NUMBER        ;            
    po_scg2_rt                 NUMBER        ;            
    po_scg3_rt                 VARCHAR2(4000);            
    po_local_curr_tot_amt      NUMBER        ;            
    po_usd_curr_tot_amt        NUMBER        ;            
    po_wtr_rcv_term_cd         TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;             
    po_wtr_de_term_cd          TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;           
    po_rtn_cd                  NUMBER        ;            
    po_rtn_msg                 VARCHAR2(100) ;                
               
    v_agmt_old_flg             VARCHAR2(10)  ;           
    v_mt_retrun_yd             VARCHAR2(10)  ;           
    v_weight                   VARCHAR2(20)  ;           
    v_cfm_flg                  VARCHAR2(20)  ;           
    v_trsp_agmt_rt_seq         VARCHAR2(20)  ;           
    v_agmt_upd_dt              VARCHAR2(50)  ;           
    v_cnt_ind_cd               VARCHAR2(20)  ;           
    v_cmdt_grp_cd              VARCHAR2(20)  ;          
    v_wgt_meas_ut_cd           VARCHAR2(20)  ;          
        
BEGIN            
    IF LENGTH(pi_cust_cnt_cd) > 1 THEN            
        v_cust_nomi_trkr_flg := 'Y';            
    ELSE            
        v_cust_nomi_trkr_flg := 'N';            
    END IF;            
            
    TRS_AGMT_RATE_CC_PKG.GET_TRS_ALL_RATE_PRC            
      (            
       pi_sys_cd -- TRS, COA 구분            
      ,pi_cre_ofc_cd            
      ,pi_vndr_cd                 
      ,TO_DATE(TO_CHAR(pi_cre_dt, 'YYYYMMDD'), 'YYYYMMDD') -- pi_cre_dt            
      ,pi_wy_tp_cd            
      ,'U' --pi_eq_knd_cd             
      ,pi_eq_tpsz_cd         
      ,pi_trsp_so_cmb_tp_cd        
      ,pi_cgo_tp_cd        
      ,pi_trsp_bnd_cd        
      ,pi_trsp_crr_mod_cd        
      ,pi_trsp_cost_dtl_mod_cd -- DOOR일 경우 'DR' 그렇지 않을 경우 'CY'            
      ,pi_cust_nomi_trkr_flg   -- HJS는 'N' CNT는 'Y'            
      ,pi_cust_cnt_cd          -- HJS는 null, CNT는 값 입력            
      ,pi_cust_seq             -- HJS는 null, CNT는 값 입력            
      ,pi_rail_ssvc_tp_cd        
      ,pi_cmdt_cd        
      ,pi_fm_nod_cd        
      ,pi_via_nod_cd        
      ,pi_dor_nod_cd        
      ,pi_to_nod_cd        
      ,pi_bundling_no        
      ,pi_wgt_meas_ut_cd        
      ,pi_cntr_wgt        
      ,pi_rcv_term        
      ,pi_de_term        
      ,pi_trsp_agmt_ofc_cty_cd        
      ,pi_trsp_agmt_seq        
      ,pi_spcl_cgo_cd        
      ,pi_debug_flg        
                
      ,po_trsp_agmt_ofc_cty_cd            
      ,po_trsp_agmt_seq            
      ,po_trsp_agmt_rt_tp_cd            
      ,po_way_type            
      ,po_trsp_agmt_rt_tp_nm            
      ,po_sp_type            
      ,po_cust_nomi_trkr_flg            
      ,po_cust_cnt_cd            
      ,po_cust_seq            
      ,po_local_curr_cd            
      ,po_bzc_rt            
      ,po_fuel_scg_rt            
      ,po_over_wgt_scg_rt            
      ,po_hzs_scg_rt            
      ,po_ttl_wgt_scg_rt              
      ,po_vat_scg_rt            
      ,po_scg1_rt            
      ,po_scg2_rt            
      ,po_scg3_rt              
      ,po_local_curr_tot_amt            
      ,po_usd_curr_tot_amt            
      ,po_wtr_rcv_term_cd            
      ,po_wtr_de_term_cd            
      ,po_rtn_cd            
      ,po_rtn_msg            
    );            
               
    v_agmt_old_flg := TRS_GET_TOKEN_FNC(po_scg3_rt, 1, '$');           
    v_mt_retrun_yd := TRS_GET_TOKEN_FNC(po_scg3_rt, 2, '$');           
    v_weight := TRS_GET_TOKEN_FNC(po_scg3_rt, 3, '$');           
    v_cfm_flg := TRS_GET_TOKEN_FNC(po_scg3_rt, 4, '$');           
    v_trsp_agmt_rt_seq := TRS_GET_TOKEN_FNC(po_scg3_rt, 5, '$');           
    v_agmt_upd_dt := TRS_GET_TOKEN_FNC(po_scg3_rt, 6, '$');           
    v_cnt_ind_cd := TRS_GET_TOKEN_FNC(po_scg3_rt, 7, '$');         
    v_cmdt_grp_cd := TRS_GET_TOKEN_FNC(po_scg3_rt, 8, '$');         
    v_wgt_meas_ut_cd := TRS_GET_TOKEN_FNC(po_scg3_rt, 9, '$');         
        
    IF v_cmdt_grp_cd = 'XXXX' THEN          
       v_cmdt_grp_cd := '' ;         
    END IF;         
            
    IF v_wgt_meas_ut_cd = 'XXX' THEN          
       v_wgt_meas_ut_cd := '' ;         
    END IF;         
         
SELECT '{'           
     ||'TRSP_AGMT_OFC_CTY_CD='||po_trsp_agmt_ofc_cty_cd           
     ||',TRSP_AGMT_SEQ='||po_trsp_agmt_seq           
     ||',RATE_TYPE='||po_trsp_agmt_rt_tp_cd           
     ||',TRSP_AGMT_WY_TP_CD='||po_way_type           
     ||',SP_TYPE='||po_sp_type           
     ||',CNT_FLG='||po_cust_nomi_trkr_flg            
     ||',CUST_CNT_CD='||po_cust_cnt_cd            
     ||',CUST_CNT_SEQ='||po_cust_seq            
     ||',CURR_CD='||po_local_curr_cd            
     ||',BZC_AMT='||po_bzc_rt            
     ||',FUEL_SCG_AMT='||po_fuel_scg_rt            
     ||',OW_SCG_AMT='||po_over_wgt_scg_rt            
     ||',HAZ_SCG_AMT='||po_hzs_scg_rt            
     ||',TTL_SCG_AMT='||po_ttl_wgt_scg_rt              
     ||',SCG_VAT_AMT='||po_vat_scg_rt            
     ||',INCNT_SCG_AMT='||po_scg1_rt            
     ||',TOLL_FEE_AMT='||po_scg2_rt            
     ||',TTL_AMT='||po_local_curr_tot_amt           
     ||',TTL_USD_AMT='||po_usd_curr_tot_amt           
     ||',AGMT_OLD_FLG='||v_agmt_old_flg            
     ||',MTY_RTN_YD_CD ='||v_mt_retrun_yd            
     ||',TO_WGT='||v_weight            
     ||',AGMT_CFM_FLG='||v_cfm_flg            
     ||',TRSP_AGMT_RT_SEQ='||v_trsp_agmt_rt_seq            
     ||',AGMT_UPD_DT='||v_agmt_upd_dt            
     ||',CUST_NOMI_TRKR_IND_CD='||v_cnt_ind_cd          
     ||',CMDT_GRP_CD='||v_cmdt_grp_cd         
     ||',WGT_MEAS_UT_CD='||v_wgt_meas_ut_cd         
     ||'}'           
                
  INTO o_out         
  FROM DUAL;           
         
  RETURN o_out;            
END GET_RATE_FNC;        
          
END TRS_AGMT_RATE_CC_PKG;
/
