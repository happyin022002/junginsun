CREATE OR REPLACE PACKAGE OPUSADM.TRS_AGMT_RATE_CC_PKG 
AUTHID CURRENT_USER 
IS

TYPE RAIL_TYPE_MST IS RECORD (
    PO_RAIL_CURR_CD         VARCHAR2(4000),
    PO_RAIL_SCG_RT          NUMBER(18,3),
    PO_RAIL_SCG_SEQ         NUMBER(10),
    PO_COM_SCG_KND_CD       VARCHAR2(4000),
    PO_COM_SCG_SEQ          NUMBER(12)
);

-- Return Type Instance
TYPE RAIL_TYPE1 IS TABLE OF RAIL_TYPE_MST INDEX BY PLS_INTEGER;

  /*###################################################################
   # -- Type    : FUNCTION
   # -- Author  : JONG HYEK CHOI
   # -- Created : MAY 1, 2010
   # -- Table   : TRS_AGMT_*
   # -- Purpose : GET NODE COUNT
  #####################################################################*/
  FUNCTION GET_LINK_CNT_FNC(pi_from_nod_cd VARCHAR2,
                            pi_via_nod_cd  VARCHAR2,
                            pi_door_nod_cd VARCHAR2,
                            pi_to_nod_cd   VARCHAR2) RETURN NUMBER;

  /*###################################################################
   # -- Type    : PROCEDURE
   # -- Author  : JONG HYEK CHOI
   # -- Created : MAY 1, 2010
   # -- Table   : TRS_AGMT_*
   # -- Purpose : BASIC RATE CALCULATION MODULE
  #####################################################################*/
  PROCEDURE GET_BASIC_RATE_CALC_PRC(pi_system_indicator       IN VARCHAR2, /* TRS, COA */
                                           pi_trsp_so_knd_cd         IN VARCHAR2, /* NONE US RAIL, USRAIL */
                                           pi_trsp_agmt_ofc_cty_cd   IN VARCHAR2,
                                           pi_trsp_agmt_seq          IN NUMBER,
                                           pi_agmt_eq_knd            IN VARCHAR2, /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                           pi_link_cnt               IN NUMBER, /* COUNT OF LINK FORM TRANSPORTATION   */
                                           pi_ctrl_ofc_cd            IN VARCHAR2, /* Pair - X , Distance - Mandatory */
                                           pi_vndr_seq               IN VARCHAR2,
                                           pi_basis_dt               IN DATE,
                                           pi_way_tp_cd              IN VARCHAR2, /* ONEWAY or ROUNDTRIP      */
                                           pi_eq_knd_cd              IN VARCHAR2,
                                           pi_eq_tp_sz_cd            IN VARCHAR2,
                                           pi_cmb_tp_cd              IN VARCHAR2,
                                           pi_cgo_tp_cd              IN VARCHAR2,
                                           pi_bound_cd               IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                           pi_crr_mod_cd             IN VARCHAR2,
                                           pi_cost_mod_cd            IN VARCHAR2,
                                           pi_cust_cnt_cd            IN VARCHAR2,
                                           pi_cust_seq               IN NUMBER,
                                           pi_rail_svc_tp_cd         IN VARCHAR2, /* OPTIONAL */
                                           pi_cmdt_cd                IN VARCHAR2, /* OPTIONAL */
                                           pi_from_nod_cd            IN VARCHAR2,
                                           pi_via_nod_cd             IN VARCHAR2,
                                           pi_door_nod_cd            IN VARCHAR2,
                                           pi_to_nod_cd              IN VARCHAR2,
                                           pi_bundle_cnt             IN NUMBER,
                                           pi_wgt_uom                IN VARCHAR2, /* L-LBS, K-KG */
                                           pi_wgt_qty                IN NUMBER,
                                           pi_rcv_term               IN VARCHAR2,
                                           pi_de_term                IN VARCHAR2,
                                           pi_trsp_rvs_aply_flg      IN VARCHAR2,
                                           pi_spcl_cgo_cd            IN VARCHAR2,
                                           pi_debug_flg              IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG )
                                           /* OUT PARAMETER */
                                           po_trsp_agmt_ofc_cty_cd   OUT VARCHAR2,
                                           po_trsp_agmt_seq          OUT NUMBER,
                                           po_trsp_agmt_rt_tp_ser_no OUT NUMBER,
                                           po_vndr_seq               OUT NUMBER,
                                           po_cust_nomi_trkr_flg     OUT VARCHAR2,
                                           po_cust_cnt_cd            OUT VARCHAR2,
                                           po_cust_seq               OUT NUMBER,
                                           po_trsp_agmt_rt_tp_cd     OUT VARCHAR2,
                                           po_way_type               OUT VARCHAR2,
                                           po_curr_cd                OUT VARCHAR2,
                                           po_wtr_rcv_term_cd        OUT VARCHAR2,
                                           po_wtr_de_term_cd         OUT VARCHAR2,
                                           po_basic_rt               OUT NUMBER,
                                           po_trsp_agmt_rt_tp_nm     OUT VARCHAR2,
                                           po_rtn_cd                 OUT NUMBER,
                                           po_rtn_msg                OUT VARCHAR2);

  /*###################################################################
   # -- Type    : PROCEDURE
   # -- Author  : JONG HYEK CHOI
   # -- Created : MAY 1, 2010
   # -- Table   : TRS_AGMT_*
   # -- Purpose : SURCHARGE RATE CALCULATION FOR COA/TRS
  #####################################################################*/
  PROCEDURE GET_SCG_RATE_CALC_PRC(pi_system_indicator       IN VARCHAR2, /* TRS, COA */
                                         pi_trsp_so_knd_cd         IN VARCHAR2, /* NONE US RAIL, USRAIL */
                                         pi_scg_knd_indicator      IN VARCHAR2, /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                         pi_way_type               IN VARCHAR2, /* ONE or RND      */
                                         pi_trsp_agmt_ofc_cty_cd   IN VARCHAR2,
                                         pi_trsp_agmt_seq          IN NUMBER,
                                         pi_trsp_agmt_rt_tp_ser_no IN NUMBER,
                                         pi_vndr_seq               IN VARCHAR2,
                                         pi_basis_dt               IN DATE,
                                         pi_eq_knd_cd              IN VARCHAR2,
                                         pi_eq_tp_sz_cd            IN VARCHAR2,
                                         pi_cgo_tp_cd              IN VARCHAR2,
                                         pi_bound_cd               IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                         pi_crr_mod_cd             IN VARCHAR2,
                                         pi_cost_mod_cd            IN VARCHAR2,
                                         pi_from_nod_cd            IN VARCHAR2,
                                         pi_via_nod_cd             IN VARCHAR2,
                                         pi_door_nod_cd            IN VARCHAR2,
                                         pi_to_nod_cd              IN VARCHAR2,
                                         pi_bundle_cnt             IN NUMBER,
                                         pi_wgt_uom                IN VARCHAR2, /* L-LBS, K-KG */
                                         pi_wgt_qty                IN NUMBER,
                                         pi_basic_rt               IN NUMBER,
                                         pi_basic_curr_cd          IN VARCHAR2,
                                         pi_spcl_cgo_cd            IN VARCHAR2,
                                         pi_debug_flg              IN VARCHAR2,  -- Debug Flag ('Y' : DBMS LOG 기록)
                                         /* OUT PARAMETER */
                                         po_scg_union_exp         OUT VARCHAR2,
                                         po_trsp_scg_cd           OUT VARCHAR2,
                                         po_trsp_agmt_scg_nod_seq OUT NUMBER,
                                         po_trsp_agmt_scg_rt_seq  OUT NUMBER,
                                         po_scg_curr_cd           OUT VARCHAR2,
                                         po_scg_rate              OUT NUMBER,
                                         po_rtn_cd                OUT NUMBER,
                                         po_process_rslt_msg      OUT VARCHAR2);

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JEONG SANG-KI
  # -- Created : FEB 5, 2007
  # -- Table   : TRS_AGMT_*
  # -- Purpose : SURCHARGE RATE CALCULATION FOR COA/TRS
  #####################################################################*/
  PROCEDURE GET_RAIL_SCG_RATE_CALC_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                       pi_eq_tp_sz_cd          IN VARCHAR2,
                                       pi_vndr_seq             IN VARCHAR2,
                                       pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                       pi_trsp_agmt_seq        IN NUMBER,
                                       pi_scg_knd_indicator    IN VARCHAR2, /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                       pi_cgo_tp_cd            IN VARCHAR2,
                                       pi_from_nod_cd          IN VARCHAR2,
                                       pi_to_nod_cd            IN VARCHAR2,
                                       pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                       pi_wgt_qty              IN NUMBER,
                                       pi_basis_dt             IN DATE,
                                       pi_spcl_cgo_cd          IN VARCHAR2,
                                       pi_bzc_curr_cd          IN VARCHAR2,
                                       pi_bzc_rt               IN NUMBER,
                                       pi_bound_cd             IN VARCHAR2,
                                       pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                       /* OUT PARAMETER */
                                       po_rail_curr_cd         OUT VARCHAR2,
                                       po_rail_scg_rt          OUT NUMBER,
                                       po_rtn_cd               OUT NUMBER,
                                       po_rtn_msg              OUT VARCHAR2,
                                       po_return               OUT RAIL_TYPE1);

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JEONG SANG-KI
  # -- Created : FEB 1, 2007
  # -- Table   : TRS_AGMT_*
  # -- Purpose : ALL RATE COMBINATION FOR TRS NONE US RAIL S/O
  #####################################################################*/
  PROCEDURE GET_TRS_ALL_RATE_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                 pi_ctrl_ofc_cd          IN VARCHAR2, /* Pair - X , Distance - Mandatory */
                                 pi_vndr_seq             IN VARCHAR2,
                                 pi_basis_dt             IN DATE,
                                 pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                 pi_eq_knd_cd            IN VARCHAR2,
                                 pi_eq_tp_sz_cd          IN VARCHAR2,
                                 pi_cmb_tp_cd            IN VARCHAR2,
                                 pi_cgo_tp_cd            IN VARCHAR2,
                                 pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                 pi_crr_mod_cd           IN VARCHAR2,
                                 pi_cost_mod_cd          IN VARCHAR2,
                                 pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                 pi_cust_cnt_cd          IN VARCHAR2,
                                 pi_cust_seq             IN NUMBER,
                                 pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                 pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                 pi_from_nod_cd          IN VARCHAR2,
                                 pi_via_nod_cd           IN VARCHAR2,
                                 pi_door_nod_cd          IN VARCHAR2,
                                 pi_to_nod_cd            IN VARCHAR2,
                                 pi_bundle_cnt           IN NUMBER,
                                 pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                 pi_wgt_qty              IN NUMBER,
                                 pi_rcv_term             IN VARCHAR2,
                                 pi_de_term              IN VARCHAR2,
                                 pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                 pi_trsp_agmt_seq        IN NUMBER,
                                 pi_spcl_cgo_cd          IN VARCHAR2,
                                 pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                 /* OUT PARAMETER  */
                                 po_trsp_agmt_ofc_cty_cd OUT VARCHAR2,
                                 po_trsp_agmt_seq        OUT NUMBER,
                                 po_trsp_agmt_rt_tp_cd   OUT VARCHAR2,
                                 po_way_type             OUT VARCHAR2,
                                 po_trsp_agmt_rt_tp_nm   OUT VARCHAR2,
                                 po_sp_type              OUT VARCHAR2,
                                 po_cust_nomi_trkr_flg   OUT VARCHAR2,
                                 po_cust_cnt_cd          OUT VARCHAR2,
                                 po_cust_seq             OUT NUMBER,
                                 po_local_curr_cd        OUT VARCHAR2,
                                 po_bzc_rt               OUT NUMBER,
                                 po_fuel_scg_rt          OUT NUMBER,
                                 po_over_wgt_scg_rt      OUT NUMBER,
                                 po_hzs_scg_rt           OUT NUMBER,
                                 po_ttl_scg_rt           OUT NUMBER,
                                 po_local_curr_tot_amt   OUT NUMBER,
                                 po_usd_curr_tot_amt     OUT NUMBER,
                                 po_wtr_rcv_term_cd      OUT VARCHAR2,
                                 po_wtr_de_term_cd       OUT VARCHAR2,
                                 po_rtn_cd               OUT NUMBER,
                                 po_rtn_msg              OUT VARCHAR2);

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : KIM SEONG WOOK
  # -- Created : AUG 10, 2015
  # -- Table   : TRS_AGMT_*
  # -- Purpose : ALL RATE COMBINATION FOR TRS US RAIL S/O
  #####################################################################*/
  PROCEDURE GET_USRAIL_ALL_RATE_PRC(pi_ctrl_ofc_cd          IN VARCHAR2, /* Pair - X , Distance - Mandatory */
                                    pi_vndr_seq             IN VARCHAR2,
                                    pi_basis_dt             IN DATE,
                                    pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                    pi_eq_knd_cd            IN VARCHAR2,
                                    pi_eq_tp_sz_cd          IN VARCHAR2,
                                    pi_cmb_tp_cd            IN VARCHAR2,
                                    pi_cgo_tp_cd            IN VARCHAR2,
                                    pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                    pi_crr_mod_cd           IN VARCHAR2,
                                    pi_cost_mod_cd          IN VARCHAR2,
                                    pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                    pi_cust_cnt_cd          IN VARCHAR2,
                                    pi_cust_seq             IN NUMBER,
                                    pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                    pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                    pi_from_nod_cd          IN VARCHAR2,
                                    pi_via_nod_cd           IN VARCHAR2,
                                    pi_door_nod_cd          IN VARCHAR2,
                                    pi_to_nod_cd            IN VARCHAR2,
                                    pi_bundle_cnt           IN NUMBER,
                                    pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                    pi_wgt_qty              IN NUMBER,
                                    pi_tare_wgt_uom         IN VARCHAR2 DEFAULT 'L', /* L-LBS, K-KG */
                                    pi_tare_wgt_qty         IN NUMBER  DEFAULT 0,
                                    pi_rcv_term             IN VARCHAR2,
                                    pi_de_term              IN VARCHAR2,
                                    pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                    pi_trsp_agmt_seq        IN NUMBER,
                                    pi_spcl_cgo_cd          IN VARCHAR2,
                                    pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                    /* OUT PARAMETER  */
                                    po_trsp_agmt_ofc_cty_cd    OUT VARCHAR2,
                                    po_trsp_agmt_seq           OUT NUMBER,
                                    po_trsp_agmt_rt_tp_cd      OUT VARCHAR2,
                                    po_way_type                OUT VARCHAR2,
                                    po_trsp_agmt_rt_tp_nm      OUT VARCHAR2,
                                    po_sp_type                 OUT VARCHAR2,
                                    po_cust_nomi_trkr_flg      OUT VARCHAR2,
                                    po_cust_cnt_cd             OUT VARCHAR2,
                                    po_cust_seq                OUT NUMBER,
                                    po_local_curr_cd           OUT VARCHAR2,
                                    po_bzc_rt                  OUT NUMBER,
                                    po_fuel_scg_rt             OUT NUMBER,
                                    po_over_wgt_scg_rt         OUT NUMBER,
                                    po_hzs_scg_rt              OUT NUMBER,
                                    po_ttl_scg_rt              OUT NUMBER,
                                    po_local_curr_tot_amt      OUT NUMBER,
                                    po_usd_curr_tot_amt        OUT NUMBER,
                                    po_wtr_rcv_term_cd         OUT VARCHAR2,
                                    po_wtr_de_term_cd          OUT VARCHAR2,
                                    po_rtn_cd                  OUT NUMBER,
                                    po_rtn_msg                 OUT VARCHAR2,
                                    po_fuel_scg                OUT VARCHAR2,
                                    po_over_wgt_scg            OUT VARCHAR2,
                                    po_hzs_scg                 OUT VARCHAR2,
                                    po_ttl_scg                 OUT VARCHAR2);

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : KIM SEONG WOOK
  # -- Created : AUG 26, 2016
  # -- Table   : TRS_AGMT_*
  # -- Purpose : TRS ALL RATE COMBINATION FOR COA
  #####################################################################*/
  PROCEDURE GET_RATE_FOR_COA_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                 pi_ctrl_ofc_cd          IN VARCHAR2, /* Pair - X , Distance - Mandatory */
                                 pi_vndr_seq             IN VARCHAR2,
                                 pi_basis_dt             IN DATE,
                                 pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                 pi_eq_knd_cd            IN VARCHAR2,
                                 pi_eq_tp_sz_cd          IN VARCHAR2,
                                 pi_cmb_tp_cd            IN VARCHAR2,
                                 pi_cgo_tp_cd            IN VARCHAR2,
                                 pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                 pi_crr_mod_cd           IN VARCHAR2,
                                 pi_cost_mod_cd          IN VARCHAR2,
                                 pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                 pi_cust_cnt_cd          IN VARCHAR2,
                                 pi_cust_seq             IN NUMBER,
                                 pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                 pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                 pi_from_nod_cd          IN VARCHAR2,
                                 pi_via_nod_cd           IN VARCHAR2,
                                 pi_door_nod_cd          IN VARCHAR2,
                                 pi_to_nod_cd            IN VARCHAR2,
                                 pi_bundle_cnt           IN NUMBER,
                                 pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                 pi_wgt_qty              IN NUMBER,
                                 pi_rcv_term             IN VARCHAR2,
                                 pi_de_term              IN VARCHAR2,
                                 pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                 pi_trsp_agmt_seq        IN NUMBER,
                                 pi_spcl_cgo_cd          IN VARCHAR2,
                                 pi_coa_cost_src_cd      IN VARCHAR2, -- COA_COST_SRC_CD
                                 pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                 /* OUT PARAMETER  */
                                 po_trsp_agmt_ofc_cty_cd OUT VARCHAR2,
                                 po_trsp_agmt_seq        OUT NUMBER,
                                 po_trsp_agmt_rt_tp_cd   OUT VARCHAR2,
                                 po_way_type             OUT VARCHAR2,
                                 po_trsp_agmt_rt_tp_nm   OUT VARCHAR2,
                                 po_sp_type              OUT VARCHAR2,
                                 po_cust_nomi_trkr_flg   OUT VARCHAR2,
                                 po_cust_cnt_cd          OUT VARCHAR2,
                                 po_cust_seq             OUT NUMBER,
                                 po_local_curr_cd        OUT VARCHAR2,
                                 po_bzc_rt               OUT NUMBER,
                                 po_fuel_scg_rt          OUT NUMBER,
                                 po_over_wgt_scg_rt      OUT NUMBER,
                                 po_hzs_scg_rt           OUT NUMBER,
                                 po_ttl_scg_rt           OUT NUMBER,
                                 po_local_curr_tot_amt   OUT NUMBER,
                                 po_usd_curr_tot_amt     OUT NUMBER,
                                 po_wtr_rcv_term_cd      OUT VARCHAR2,
                                 po_wtr_de_term_cd       OUT VARCHAR2,
                                 po_rtn_cd               OUT NUMBER,
                                 po_rtn_msg              OUT VARCHAR2);

END TRS_AGMT_RATE_CC_PKG;
/

CREATE OR REPLACE PACKAGE BODY OPUSADM.TRS_AGMT_RATE_CC_PKG IS
  /*###################################################################
   # -- Type    : FUNCTION
   # -- Author  : JONG HYEK CHOI
   # -- Created : MAY 1, 2010
   # -- Table   : TRS_TRSP_AGMT_*
   # -- Purpose : 전체 NOD의 링크 갯수 구하기
  #####################################################################*/
  FUNCTION GET_LINK_CNT_FNC(pi_from_nod_cd VARCHAR2,
                            pi_via_nod_cd  VARCHAR2,
                            pi_door_nod_cd VARCHAR2,
                            pi_to_nod_cd   VARCHAR2) RETURN NUMBER IS
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
      DBMS_OUTPUT.PUT_LINE('GET_LINK_CNT_FNC <NO_DATA_FOUND> ERROR MSG = [' || SQLERRM || ']');
  END;

  /*###################################################################
   # -- Type    : PROCEDURE
   # -- Author  : JONG HYEK CHOI
   # -- Created : MAY 1, 2010
   # -- Table   : TRS_TRSP_AGMT_*
   # -- Purpose : BASIC RATE CALCULATION MODULE
  #####################################################################*/
  PROCEDURE GET_BASIC_RATE_CALC_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                           pi_trsp_so_knd_cd       IN VARCHAR2, /* NONE US RAIL, USRAIL */
                                           pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                           pi_trsp_agmt_seq        IN NUMBER,
                                           pi_agmt_eq_knd          IN VARCHAR2, /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                           pi_link_cnt             IN NUMBER, /* COUNT OF LINK FORM TRANSPORTATION   */
                                           pi_ctrl_ofc_cd          IN VARCHAR2,
                                           pi_vndr_seq             IN VARCHAR2,
                                           pi_basis_dt             IN DATE,
                                           pi_way_tp_cd            IN VARCHAR2, /* ONEWAY or ROUNDTRIP      */
                                           pi_eq_knd_cd            IN VARCHAR2,
                                           pi_eq_tp_sz_cd          IN VARCHAR2,
                                           pi_cmb_tp_cd            IN VARCHAR2,
                                           pi_cgo_tp_cd            IN VARCHAR2,
                                           pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                           pi_crr_mod_cd           IN VARCHAR2,
                                           pi_cost_mod_cd          IN VARCHAR2,
                                           pi_cust_cnt_cd          IN VARCHAR2,
                                           pi_cust_seq             IN NUMBER,
                                           pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                           pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                           pi_from_nod_cd          IN VARCHAR2,
                                           pi_via_nod_cd           IN VARCHAR2,
                                           pi_door_nod_cd          IN VARCHAR2,
                                           pi_to_nod_cd            IN VARCHAR2,
                                           pi_bundle_cnt           IN NUMBER,
                                           pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                           pi_wgt_qty              IN NUMBER,
                                           pi_rcv_term             IN VARCHAR2,
                                           pi_de_term              IN VARCHAR2,
                                           pi_trsp_rvs_aply_flg    IN VARCHAR2,
                                           pi_spcl_cgo_cd          IN VARCHAR2,
                                           pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                           /* OUT PARAMETER */
                                           po_trsp_agmt_ofc_cty_cd   OUT VARCHAR2,
                                           po_trsp_agmt_seq          OUT NUMBER,
                                           po_trsp_agmt_rt_tp_ser_no OUT NUMBER,
                                           po_vndr_seq               OUT NUMBER,
                                           po_cust_nomi_trkr_flg     OUT VARCHAR2,
                                           po_cust_cnt_cd            OUT VARCHAR2,
                                           po_cust_seq               OUT NUMBER,
                                           po_trsp_agmt_rt_tp_cd     OUT VARCHAR2,
                                           po_way_type               OUT VARCHAR2,
                                           po_curr_cd                OUT VARCHAR2,
                                           po_wtr_rcv_term_cd        OUT VARCHAR2,
                                           po_wtr_de_term_cd         OUT VARCHAR2,
                                           po_basic_rt               OUT NUMBER,
                                           po_trsp_agmt_rt_tp_nm     OUT VARCHAR2,
                                           po_rtn_cd                 OUT NUMBER,
                                           po_rtn_msg                OUT VARCHAR2) IS

    C_WAY_TYPE_PRIORITY CONSTANT VARCHAR2(15) := 'RND_PRIORITY';
    C_CONV_KG_FROM_LBS  CONSTANT NUMBER(10, 6) := 0.453599;

    vo_trsp_agmt_ofc_cty_cd   TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;
    vo_trsp_agmt_seq          TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_ser_no TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;
    vo_vndr_seq               TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;
    vo_cust_nomi_trkr_flg     TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE;
    vo_cust_cnt_cd            TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    vo_cust_seq               TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_cd     TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;
    vo_way_type               VARCHAR2(3);
    vo_curr_cd                VARCHAR2(3);
    vo_basic_rt               NUMBER(18, 3);
    vo_wtr_rcv_term_cd        TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;
    vo_wtr_de_term_cd         TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;
    vo_trsp_agmt_rt_tp_nm     VARCHAR2(50);
    vo_trsp_agmt_nod_seq      NUMBER(12);
    vo_trsp_agmt_rt_seq       NUMBER(12);

    v_eq_tp_all               VARCHAR2(4);
    v_eq_sz_all               VARCHAR2(4);
    vo_wgt_qty                NUMBER(18, 3);

  BEGIN

    IF pi_debug_flg = 'Y' THEN

      DBMS_OUTPUT.PUT_LINE('============ GET_BASIC_RATE_CALC_PRC PARAMETER START ===============');
      DBMS_OUTPUT.PUT_LINE('pi_system_indicator      VARCHAR2(100)    :=''' || pi_system_indicator || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_so_knd_cd        VARCHAR2(100)    :=''' || pi_trsp_so_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd  VARCHAR2(100)    :=''' || pi_trsp_agmt_ofc_cty_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq         NUMBER(30)       :=''' || pi_trsp_agmt_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_agmt_eq_knd           VARCHAR2(100)    :=''' || pi_agmt_eq_knd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_link_cnt              NUMBER(30)       :=''' || pi_link_cnt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_ctrl_ofc_cd           VARCHAR2(100)    :=''' || pi_ctrl_ofc_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_vndr_seq              NUMBER(30)       :=''' || pi_vndr_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basis_dt              DATE             := TO_DATE(''' || TO_CHAR(pi_basis_dt, 'YYYYMMDD') || ''',''YYYYMMDD'');');
      DBMS_OUTPUT.PUT_LINE('pi_way_tp_cd             VARCHAR2(100)    :=''' || pi_way_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_eq_knd_cd             VARCHAR2(100)    :=''' || pi_eq_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd           VARCHAR2(100)    :=''' || pi_eq_tp_sz_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cmb_tp_cd             VARCHAR2(100)    :=''' || pi_cmb_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd             VARCHAR2(100)    :=''' || pi_cgo_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_bound_cd              VARCHAR2(100)    :=''' || pi_bound_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_crr_mod_cd            VARCHAR2(100)    :=''' || pi_crr_mod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cost_mod_cd           VARCHAR2(100)    :=''' || pi_cost_mod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cust_cnt_cd           VARCHAR2(100)    :=''' || pi_cust_cnt_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cust_seq              NUMBER(30)       :=''' || pi_cust_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_rail_svc_tp_cd        VARCHAR2(100)    :=''' || pi_rail_svc_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cmdt_cd               VARCHAR2(100)    :=''' || pi_cmdt_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd           VARCHAR2(100)    :=''' || pi_from_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_via_nod_cd            VARCHAR2(100)    :=''' || pi_via_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_door_nod_cd           VARCHAR2(100)    :=''' || pi_door_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd             VARCHAR2(100)    :=''' || pi_to_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_bundle_cnt            NUMBER(30)       :=''' || pi_bundle_cnt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_uom               VARCHAR2(100)    :=''' || pi_wgt_uom || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_qty               NUMBER(30)       :=''' || pi_wgt_qty || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_rcv_term              VARCHAR2(100)    :=''' || pi_rcv_term || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_de_term               VARCHAR2(100)    :=''' || pi_de_term || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_rvs_aply_flg     VARCHAR2(1)      :=''' || pi_trsp_rvs_aply_flg || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_spcl_cgo_cd           VARCHAR2(100)    := ''' || pi_spcl_cgo_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('============ GET_BASIC_RATE_CALC_PRC PARAMETER END ===============');

    END IF;

    -- Equipment Type별로 All Type 셋팅
    IF pi_eq_knd_cd = 'U' THEN
      v_eq_tp_all := SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL';
      v_eq_sz_all := 'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1);

    ELSIF pi_eq_knd_cd = 'Z' THEN

      IF LENGTH(PI_EQ_TP_SZ_CD) = 2 THEN
        v_eq_tp_all := SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL';
        v_eq_sz_all := 'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1);

      ELSIF LENGTH(pi_eq_tp_sz_cd) = 3 THEN
        v_eq_tp_all := SUBSTR(PI_EQ_TP_SZ_CD, 1, 2) || 'AL';
        v_eq_sz_all := 'AL' || SUBSTR(pi_eq_tp_sz_cd, 3, 1);
      END IF;

    ELSIF pi_eq_knd_cd = 'G' THEN
      v_eq_tp_all := '';
      v_eq_sz_all := '';
    END IF;

    IF pi_wgt_qty > 999999.99 THEN
        vo_wgt_qty := 999999.99;
    ELSE
        vo_wgt_qty := pi_wgt_qty;
    END IF;

    SELECT TRSP_AGMT_OFC_CTY_CD,
           TRSP_AGMT_SEQ,
           TRSP_AGMT_RT_TP_SER_NO,
           CURR_CD,
           EQUIPMENT_RATE,
           WAY_TYPE,
           VNDR_SEQ,
           CUST_NOMI_TRKR_FLG,
           CUST_CNT_CD,
           CUST_SEQ,
           TRSP_AGMT_RT_TP_CD,
           WTR_RCV_TERM_CD,
           WTR_DE_TERM_CD,
           TRSP_AGMT_RT_TP_NM,
           TRSP_AGMT_NOD_SEQ,
           TRSP_AGMT_RT_SEQ
      INTO vo_trsp_agmt_ofc_cty_cd,
           vo_trsp_agmt_seq,
           vo_trsp_agmt_rt_tp_ser_no,
           vo_curr_cd,
           vo_basic_rt,
           vo_way_type,
           vo_vndr_seq,
           vo_cust_nomi_trkr_flg,
           vo_cust_cnt_cd,
           vo_cust_seq,
           vo_trsp_agmt_rt_tp_cd,
           vo_wtr_rcv_term_cd,
           vo_wtr_de_term_cd,
           vo_trsp_agmt_rt_tp_nm,
           vo_trsp_agmt_nod_seq,
           vo_trsp_agmt_rt_seq
      FROM (SELECT C.TRSP_AGMT_OFC_CTY_CD,
                   C.TRSP_AGMT_SEQ,
                   C.TRSP_AGMT_RT_TP_SER_NO,
                   B.VNDR_SEQ,
                   E.EFF_FM_DT,
                   E.EFF_TO_DT,
                   C.TRSP_AGMT_RT_TP_CD,
                   C.CUST_NOMI_TRKR_FLG,
                   C.CUST_CNT_CD,
                   C.CUST_SEQ,
                   CASE
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd THEN 1
                     ELSE 3
                   END EQ_TPSZ_PRIOR_ORDER,
                   CASE
                     WHEN pi_way_tp_cd = 'ONE' THEN 'ONE'
                     WHEN pi_way_tp_cd = 'RND' THEN 'RND'
                     WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR' THEN
                        NVL2(E.TRSP_RND_RT, 'RND', 'ONE')
                     ELSE
                        NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')
                   END WAY_TYPE,
                   E.CURR_CD,
                   CASE
                     WHEN pi_way_tp_cd = 'ONE' THEN E.TRSP_ONE_WY_RT
                     WHEN pi_way_tp_cd = 'RND' THEN E.TRSP_RND_RT
                     WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR' THEN
                        NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)
                     ELSE
                        NVL(E.TRSP_ONE_WY_RT, E.TRSP_RND_RT)
                   END AS EQUIPMENT_RATE,
                   E.WTR_RCV_TERM_CD,
                   E.WTR_DE_TERM_CD,
                   (SELECT CD.INTG_CD_VAL_DP_DESC
                      FROM COM_INTG_CD_DTL CD
                     WHERE CD.INTG_CD_ID = 'CD00954'
                       AND CD.INTG_CD_VAL_CTNT = C.TRSP_AGMT_RT_TP_CD) TRSP_AGMT_RT_TP_NM,
                   E.TRSP_AGMT_NOD_SEQ,
                   E.TRSP_AGMT_RT_SEQ,
                   C.TRSP_BND_CD,             -- 2015.04.27
                   C.SPCL_CGO_CNTR_TP_CD     -- 2015.04.27
              FROM TRS_AGMT_HDR       A,
                   TRS_AGMT_APLY_VNDR B,
                   TRS_AGMT_RT_TP     C,
                   TRS_AGMT_NOD       D,
                   TRS_AGMT_EQ_RT     E
             WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
               AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
               AND A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD
               AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ
               AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD
               AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ
               AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO
               AND D.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
               AND D.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
               AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
               AND D.TRSP_AGMT_NOD_SEQ = E.TRSP_AGMT_NOD_SEQ
               AND A.CTRT_OFC_CD = DECODE(C.TRSP_AGMT_RT_TP_CD,
                                          'P',
                                          A.CTRT_OFC_CD,
                                          pi_ctrl_ofc_cd)
               AND E.EQ_KND_CD = pi_eq_knd_cd
               AND DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', B.VNDR_SEQ) =
                   DECODE(pi_trsp_so_knd_cd,
                          'USRAIL',
                          '0',
                          TO_NUMBER(pi_vndr_seq))
               AND C.CGO_TP_CD = CASE WHEN pi_eq_knd_cd = 'U'
                                      THEN pi_cgo_tp_cd
                                      ELSE '0'
                                 END
               AND C.TRSP_COST_MOD_CD = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F'
                                             THEN DECODE(pi_cmb_tp_cd, 'CF', 'MM', DECODE(TRSP_AGMT_RT_TP_CD, 'P', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'), 'D', 'DC'))
                                             WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M'
                                             THEN DECODE(pi_cmb_tp_cd, 'CF', 'MM', DECODE(TRSP_AGMT_RT_TP_CD, 'P', 'CY', 'D', 'DC'))
                                             WHEN pi_eq_knd_cd = 'Z'
                                             THEN 'BS'
                                             WHEN pi_eq_knd_cd = 'G'
                                             THEN DECODE(TRSP_AGMT_RT_TP_CD, 'P', 'CY', 'D', 'DC')
                                             ELSE ''
                                        END
               AND C.AGMT_TRSP_TP_CD = pi_crr_mod_cd AND C.RAIL_SVC_TP_CD = NVL(pi_rail_svc_tp_cd, '00')
               /* 161019 : COA에서 호출 시 TRS Customer Code를 무시하도록 NVL 처리 */
               AND NVL2(pi_cust_cnt_cd, C.CUST_NOMI_TRKR_FLG, 'N') = CASE NVL(pi_cust_cnt_cd, 'XX')
                                                                     WHEN 'XX'
                                                                     THEN 'N'
                                                                     ELSE 'Y'
                                                                END
               AND NVL2(pi_cust_cnt_cd, C.CUST_CNT_CD, 'XX') = NVL(pi_cust_cnt_cd, 'XX')
               AND NVL2(pi_cust_seq, C.CUST_SEQ, 0) = NVL(pi_cust_seq, 0)
               AND (   (    D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')
                        AND D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
                       )
                    OR (    D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
                        AND D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')
                        AND E.TRSP_RVS_APLY_FLG = 'Y'
                       )
                   )
--               AND (   (D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
--                       )
--                    OR (D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000') AND E.TRSP_RVS_APLY_FLG = 'Y'
--                       )
--                   )
               AND D.VIA_NOD_CD = CASE pi_link_cnt
                                       WHEN 1
                                       THEN '0000000'
                                       WHEN 2
                                       THEN CASE pi_cost_mod_cd
                                                 WHEN 'DR'
                                                 THEN '0000000'
                                                 ELSE DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd, 1, 5))
                                             END
                                       WHEN 3
                                       THEN DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd, 1, 5))
                                       ELSE '0000000'
                                   END
               AND D.DOR_NOD_CD = CASE pi_link_cnt
                                       WHEN 1
                                       THEN '0000000'
                                       WHEN 2
                                       THEN CASE pi_cost_mod_cd
                                                 WHEN 'DR'
                                                 THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd, 1, 5))
                                                 ELSE '0000000'
                                            END
                                       WHEN 3
                                       THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd, 1, 5))
                                       ELSE '0000000'
                                   END
               AND E.EFF_FM_DT <= pi_basis_dt
               AND E.EFF_TO_DT >= pi_basis_dt
               /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
               AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (PI_EQ_TP_SZ_CD, V_EQ_TP_ALL, V_EQ_SZ_ALL, 'ALAL')
               /* ONLY CONTAINER-WEIGHT */
               AND CASE
                       WHEN pi_agmt_eq_knd = 'U' AND pi_cgo_tp_cd = 'F'
                       THEN CASE
                                WHEN SUBSTR(DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD), 1, 1) = 'K'
                                THEN E.TO_WGT ELSE ROUND(E.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                       ELSE 1
                   END >= CASE
                              WHEN pi_agmt_eq_knd = 'U' AND pi_cgo_tp_cd = 'F'
                              THEN CASE
                                       WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'), 1, 1) = 'K'
                                       THEN vo_wgt_qty ELSE ROUND(vo_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                   END
                              ELSE 1
                          END
               /* ONLY Chassis + Empty Flatrack Container */
               AND CASE
                       WHEN pi_agmt_eq_knd = 'Z'
                       THEN DECODE(E.TRSP_AGMT_BDL_QTY, 0, 1, E.TRSP_AGMT_BDL_QTY)
                       ELSE 1
                   END = CASE
                             WHEN pi_agmt_eq_knd = 'Z'
                             THEN NVL(pi_bundle_cnt, 1)
                             ELSE 1
                         END
               /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
               AND (C.CMDT_GRP_CD = (SELECT X.TRSP_GRP_CMDT_CD
                                       FROM TRS_TRSP_CMDT_GRP X,
                                            TRS_CMDT_GRP_CZ   Y
                                      WHERE X.DELT_FLG = 'N'
                                        AND X.DELT_FLG = Y.DELT_FLG
                                        AND X.TRSP_GRP_CMDT_CD = Y.TRSP_GRP_CMDT_CD
                                        AND X.VNDR_SEQ = pi_vndr_seq
                                        AND X.VNDR_SEQ = Y.VNDR_SEQ
                                        AND Y.CMDT_CD = pi_cmdt_cd) OR C.CMDT_GRP_CD = 'XXXX')
               /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
               AND CASE
                       WHEN PI_WAY_TP_CD = 'ONE'
                       THEN CASE
                                WHEN E.TRSP_ONE_WY_RT > 0
                                THEN 1
                            END
                       WHEN PI_WAY_TP_CD = 'RND'
                       THEN CASE
                                WHEN E.TRSP_RND_RT > 0
                                THEN 1
                            END
                       ELSE 1
                   END = CASE
                             WHEN PI_WAY_TP_CD = 'ONE'
                             THEN 1
                             WHEN PI_WAY_TP_CD = 'RND'
                             THEN 1
                             ELSE 1
                         END
               AND DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', A.TRSP_AGMT_OFC_CTY_CD, 'N/A')
               AND DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq, 1) = DECODE(pi_trsp_so_knd_cd, 'USRAIL', A.TRSP_AGMT_SEQ, 1)
               AND CASE
                       WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL
                       THEN E.WTR_RCV_TERM_CD
                       ELSE '1'
                   END = CASE
                             WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL
                             THEN pi_rcv_term
                             ELSE '1'
                         END
               AND CASE
                       WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL
                       THEN E.WTR_DE_TERM_CD
                       ELSE '1'
                   END = CASE
                             WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL
                             THEN pi_de_term ELSE '1'
                         END
               AND E.TRSP_RVS_APLY_FLG LIKE DECODE(pi_trsp_rvs_aply_flg, 'N', '%', pi_trsp_rvs_aply_flg)
               /* 2015.04.27 CASE WHEN S/O TRSP_BND_CD = 'T' THEN W/O TRSP_BND_CD IS NULL OR TRSP_BND_CD IN ('Y', 'N') */
               AND CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_bound_cd = 'T' THEN DECODE(C.TRSP_BND_CD, NULL, 'N', 'Y', 'N', C.TRSP_BND_CD)
               WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND NVL(pi_bound_cd,'N') <> 'T' THEN DECODE(C.TRSP_BND_CD, NULL, 'N', C.TRSP_BND_CD)
                        ELSE 'N'
                   END = 'N'
               AND (C.SPCL_CGO_CNTR_TP_CD IS NULL
                     OR
                    CASE WHEN pi_spcl_cgo_cd IS NULL THEN C.SPCL_CGO_CNTR_TP_CD
                         ELSE pi_spcl_cgo_cd
                    END = C.SPCL_CGO_CNTR_TP_CD)
             ORDER BY CASE WHEN pi_system_indicator = 'COA' THEN NVL(E.AGMT_COST_FLG, '0')
                           ELSE '1'
                       END DESC,
                      EQ_TPSZ_PRIOR_ORDER ASC,
                      C.CMDT_GRP_CD ASC,
                      LENGTH(DECODE(D.FM_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    D.FM_NOD_CD)) DESC,
                      LENGTH(DECODE(D.VIA_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    D.VIA_NOD_CD)) DESC,
                      LENGTH(DECODE(D.DOR_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    D.DOR_NOD_CD)) DESC,
                      LENGTH(DECODE(D.TO_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    D.TO_NOD_CD)) DESC,
                      E.TO_WGT ASC,
                      E.TRSP_RVS_APLY_FLG DESC,
                      /* 2015.04.27 WHEN pi_bound_cd = 'T' THEN 'T' FIRST, 'A', NULL LAST */
                      CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_bound_cd = 'T' THEN C.TRSP_BND_CD
           WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND NVL(pi_bound_cd,'N') <> 'T' THEN C.TRSP_BND_CD
                           ELSE NULL
                      END DESC NULLS LAST,
                      C.SPCL_CGO_CNTR_TP_CD,
--                      E.TRSP_AGMT_RT_SEQ DESC, -- 자료중 마지막으로 등록된 RATE를 조회한다.
                      CASE
                         WHEN pi_way_tp_cd = 'ONE' THEN E.TRSP_ONE_WY_RT
                         WHEN pi_way_tp_cd = 'RND' THEN E.TRSP_RND_RT
                         WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR' THEN
                            NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)
                         ELSE
                            NVL(E.TRSP_ONE_WY_RT, E.TRSP_RND_RT)
                      END
            )
     WHERE ROWNUM < 2;

    IF pi_debug_flg = 'Y' THEN

      DBMS_OUTPUT.PUT_LINE('============ GET_BASIC_RATE_CALC_PRC QUERY SQL START ===============');
      DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_EQ_RT_HIS WHERE 1=1 ');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_OFC_CTY_CD  = ''' || vo_trsp_agmt_ofc_cty_cd || '''');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SEQ  = ' || vo_trsp_agmt_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_TP_SER_NO  = ' || vo_trsp_agmt_rt_tp_ser_no);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_NOD_SEQ  = ' || vo_trsp_agmt_nod_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_SEQ  = ' || vo_trsp_agmt_rt_seq);
      DBMS_OUTPUT.PUT_LINE('============ GET_BASIC_RATE_CALC_PRC QUERY SQL END ===============');

    END IF;

    po_trsp_agmt_ofc_cty_cd   := vo_trsp_agmt_ofc_cty_cd;
    po_trsp_agmt_seq          := vo_trsp_agmt_seq;
    po_trsp_agmt_rt_tp_ser_no := vo_trsp_agmt_rt_tp_ser_no;
    po_vndr_seq               := vo_vndr_seq;
    po_cust_nomi_trkr_flg     := vo_cust_nomi_trkr_flg;
    po_cust_cnt_cd            := vo_cust_cnt_cd;
    po_cust_seq               := vo_cust_seq;
    po_trsp_agmt_rt_tp_cd     := vo_trsp_agmt_rt_tp_cd;
    po_way_type               := vo_way_type;
    po_curr_cd                := vo_curr_cd;
    po_basic_rt               := vo_basic_rt;
    po_wtr_rcv_term_cd        := vo_wtr_rcv_term_cd;
    po_wtr_de_term_cd         := vo_wtr_de_term_cd;
    po_trsp_agmt_rt_tp_nm     := vo_trsp_agmt_rt_tp_nm;
    po_rtn_cd                 := 0;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      po_rtn_cd  := -99;
      po_rtn_msg := 'GET_BASIC_RATE_CALC_PRC <NO_DATA_FOUND>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_BASIC_RATE_CALC_PRC <NO_DATA_FOUND> ERROR MSG = [' ||
                             SQLERRM || ']');
      END IF;
    WHEN OTHERS THEN
      po_rtn_cd  := -1;
      po_rtn_msg := 'GET_BASIC_RATE_CALC_PRC <OTHERS>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_BASIC_RATE_CALC_PRC <OTHERS> ERROR MSG = [' ||
                             SQLERRM || ']');
      END IF;
  END;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JONG HYEK CHOI
  # -- Created : MAY 1, 2010
  # -- Table   : TRS_TRSP_AGMT_*
  # -- Purpose : SURCHARGE RATE CALCULATION FOR COA, TRS
  #####################################################################*/
  PROCEDURE GET_SCG_RATE_CALC_PRC(pi_system_indicator       IN VARCHAR2, /* TRS, COA */
                                         pi_trsp_so_knd_cd         IN VARCHAR2, /* NONE US RAIL, USRAIL */
                                         pi_scg_knd_indicator      IN VARCHAR2, /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE, OR COST CODE FOR COA */
                                         pi_way_type               IN VARCHAR2, /* ONE or RND      */
                                         pi_trsp_agmt_ofc_cty_cd   IN VARCHAR2,
                                         pi_trsp_agmt_seq          IN NUMBER,
                                         pi_trsp_agmt_rt_tp_ser_no IN NUMBER,
                                         pi_vndr_seq               IN VARCHAR2,
                                         pi_basis_dt               IN DATE,
                                         pi_eq_knd_cd              IN VARCHAR2,
                                         pi_eq_tp_sz_cd            IN VARCHAR2,
                                         pi_cgo_tp_cd              IN VARCHAR2,
                                         pi_bound_cd               IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                         pi_crr_mod_cd             IN VARCHAR2,
                                         pi_cost_mod_cd            IN VARCHAR2,
                                         pi_from_nod_cd            IN VARCHAR2,
                                         pi_via_nod_cd             IN VARCHAR2,
                                         pi_door_nod_cd            IN VARCHAR2,
                                         pi_to_nod_cd              IN VARCHAR2,
                                         pi_bundle_cnt             IN NUMBER,
                                         pi_wgt_uom                IN VARCHAR2, /* L-LBS, K-KG */
                                         pi_wgt_qty                IN NUMBER,
                                         pi_basic_rt               IN NUMBER,
                                         pi_basic_curr_cd          IN VARCHAR2,
                                         pi_spcl_cgo_cd            IN VARCHAR2,
                                         pi_debug_flg              IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                         /* OUT PARAMETER */
                                         po_scg_union_exp         OUT VARCHAR2,
                                         po_trsp_scg_cd           OUT VARCHAR2,
                                         po_trsp_agmt_scg_nod_seq OUT NUMBER,
                                         po_trsp_agmt_scg_rt_seq  OUT NUMBER,
                                         po_scg_curr_cd           OUT VARCHAR2,
                                         po_scg_rate              OUT NUMBER,
                                         po_rtn_cd                OUT NUMBER,
                                         po_process_rslt_msg      OUT VARCHAR2) IS

    vo_agmt_scg_rt_div_cd    VARCHAR2(1);
    vo_scg_union_exp         VARCHAR2(100);
    vo_trsp_scg_cd           VARCHAR2(6);
    vo_trsp_agmt_scg_nod_seq NUMBER(12);
    vo_trsp_agmt_scg_rt_seq  NUMBER(12);
    vo_scg_curr_cd           VARCHAR2(3);
    vo_scg_rate              NUMBER(15, 3);

    v_scg1      VARCHAR2(7);
    v_scg2      VARCHAR2(6);
    v_scg3      VARCHAR2(6);
    v_scg_title VARCHAR2(20);
    vo_wgt_qty                NUMBER(18, 3);

  BEGIN

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.PUT_LINE('');
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC PARAMETER START(' || pi_scg_knd_indicator || ')===============');
      DBMS_OUTPUT.PUT_LINE('pi_system_indicator      VARCHAR2(100)    := ''' || pi_system_indicator || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_so_knd_cd        VARCHAR2(100)    := ''' || pi_trsp_so_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_scg_knd_indicator     VARCHAR2(100)    := ''' || pi_scg_knd_indicator || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_way_type              VARCHAR2(100)    := ''' || pi_way_type || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd  VARCHAR2(100)    := ''' || pi_trsp_agmt_ofc_cty_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq            NUMBER(30)    := ''' || pi_trsp_agmt_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_rt_tp_ser_no   NUMBER(30)    := ''' || pi_trsp_agmt_rt_tp_ser_no || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_vndr_seq                 NUMBER(30)    := ''' || pi_vndr_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basis_dt                       DATE    := TO_DATE(''' || TO_CHAR(pi_basis_dt, 'YYYYMMDD') || ''',''YYYYMMDD'');');
      DBMS_OUTPUT.PUT_LINE('pi_eq_knd_cd             VARCHAR2(100)    := ''' || pi_eq_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd           VARCHAR2(100)    := ''' || pi_eq_tp_sz_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd             VARCHAR2(100)    := ''' || pi_cgo_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_bound_cd              VARCHAR2(100)    :='''  || pi_bound_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_crr_mod_cd            VARCHAR2(100)    :='''  || pi_crr_mod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd           VARCHAR2(100)    := ''' || pi_from_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_via_nod_cd            VARCHAR2(100)    := ''' || pi_via_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_door_nod_cd           VARCHAR2(100)    := ''' || pi_door_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd             VARCHAR2(100)    := ''' || pi_to_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_bundle_cnt               NUMBER(30)    := ''' || pi_bundle_cnt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_uom               VARCHAR2(100)    := ''' || pi_wgt_uom || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_qty                  NUMBER(30)    := ''' || pi_wgt_qty || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basic_rt               NUMBER(15,3)    := ''' || pi_basic_rt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basic_curr_cd         VARCHAR2(100)    := ''' || pi_basic_curr_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_spcl_cgo_cd           VARCHAR2(100)    := ''' || pi_spcl_cgo_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC PARAMETER END(' || pi_scg_knd_indicator || ')===============');
    END IF;

    IF pi_scg_knd_indicator = 'FU' OR (pi_system_indicator = 'COA' AND SUBSTR(pi_scg_knd_indicator,3,2) = 'FU')THEN
      v_scg1      := 'CD30002';
      v_scg2      := 'SCFAAL';
      v_scg3      := 'SCFCAL';
      v_scg_title := 'Fuel Surcharge';
    ELSIF pi_scg_knd_indicator = 'OW' THEN
      v_scg1      := 'CD30002';
      v_scg2      := 'SCOWAL';
      v_scg3      := '';
      v_scg_title := 'OverWeight Surcharge';
    ELSE
      v_scg1      := 'CD30002';
      v_scg2      := pi_scg_knd_indicator;
      v_scg3      := pi_scg_knd_indicator;
      v_scg_title := 'Surcharge For COA';
    END IF;

    IF pi_wgt_qty > 999999.99 THEN
        vo_wgt_qty := 999999.99;
    ELSE
        vo_wgt_qty := pi_wgt_qty;
    END IF;

    po_rtn_cd := 0; /* INITIAL SETTING AS SUCCESS */

    SELECT SURCHARGE_UNION_EXP,
           TRSP_SCG_CD,
           TRSP_AGMT_SCG_NOD_SEQ,
           TRSP_AGMT_SCG_RT_SEQ,
           LOCAL_SCG_CURR_CD_OR_PERCENT,
           CASE
             WHEN AGMT_SCG_RT_DIV_CD = 'F' THEN
              FUEL_SURCHARGE_RATE_OR_PERCENT
             WHEN AGMT_SCG_RT_DIV_CD = 'R' THEN
              ROUND((pi_basic_rt * FUEL_SURCHARGE_RATE_OR_PERCENT / 100), 3)
           END FUEL_SURCHARGE_RATE_OR_PERCENT,
           AGMT_SCG_RT_DIV_CD
      INTO vo_scg_union_exp,
           vo_trsp_scg_cd,
           vo_trsp_agmt_scg_nod_seq,
           vo_trsp_agmt_scg_rt_seq,
           vo_scg_curr_cd,
           vo_scg_rate,
           vo_agmt_scg_rt_div_cd
      FROM (SELECT v_scg_title || ' = [' || C.TRSP_SCG_CD || ']->[' ||
                   E.TRSP_AGMT_EQ_TP_SZ_CD || ']->[' || B.CMDT_GRP_CD ||
                   ']->[' || E.CRE_DT || ']' SURCHARGE_UNION_EXP,
                   E.TRSP_AGMT_OFC_CTY_CD,
                   E.TRSP_AGMT_SEQ,
                   E.TRSP_AGMT_RT_TP_SER_NO,
                   C.TRSP_SCG_CD,
                   CASE
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%' THEN 2
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd THEN 1
                     ELSE 3
                   END EQ_TPSZ_PRIOR_ORDER,
                   E.CURR_CD AS LOCAL_SCG_CURR_CD_OR_PERCENT,
--                   CASE pi_way_type
--                     WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
--                     WHEN 'RND' THEN E.TRSP_RND_RT
--                   END FUEL_SURCHARGE_RATE_OR_PERCENT,
--                   E.AGMT_SCG_RT_DIV_CD,
                   CASE pi_way_type WHEN 'ONE' THEN
                                                   CASE WHEN E.COM_SCG_APLY_FLG = '1'
                                                        THEN F.TRSP_ONE_WY_RT
                                                        ELSE E.TRSP_ONE_WY_RT
                                                    END
                                    WHEN 'RND' THEN
                                                   CASE WHEN E.COM_SCG_APLY_FLG = '1'
                                                        THEN F.TRSP_RND_RT
                                                        ELSE E.TRSP_RND_RT
                                                    END
                   END FUEL_SURCHARGE_RATE_OR_PERCENT,
                   CASE WHEN E.COM_SCG_APLY_FLG = '0'
                        THEN E.AGMT_SCG_RT_DIV_CD
                        ELSE F.AGMT_SCG_RT_DIV_CD
                    END AGMT_SCG_RT_DIV_CD,
                   C.TRSP_AGMT_SCG_NOD_SEQ,
                   E.TRSP_AGMT_SCG_RT_SEQ,
                   B.TRSP_BND_CD,           -- 2015.04.27
                   B.SPCL_CGO_CNTR_TP_CD   -- 2015.04.27
              FROM TRS_AGMT_APLY_VNDR A,
                   TRS_AGMT_RT_TP     B,
                   TRS_AGMT_SCG_NOD   C,
                   TRS_AGMT_SCG_RT    E,
               (SELECT COM_SCG_KND_CD, MAX(EQ_TPSZ_CD) TRSP_AGMT_EQ_TP_SZ_CD, MAX(CURR_CD) CURR_CD, MAX(RT_TP_CD) AGMT_SCG_RT_DIV_CD
                      ,DECODE(pi_cost_mod_cd, 'DR', 0, SUM(NVL(ONE_WY_RT, RND_RT))) TRSP_ONE_WY_RT
                      ,DECODE(pi_cost_mod_cd, 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), 0) TRSP_RND_RT
                      ,DECODE(pi_cost_mod_cd, 'DR', SUM(NVL(RND_RT, ONE_WY_RT)), SUM(NVL(ONE_WY_RT, RND_RT))) ETC_ADD_AMT
                      ,COM_SCG_SEQ
                  FROM (
                         SELECT COM_SCG_KND_CD, ONE_WY_RT, RND_RT, EQ_TPSZ_CD, CURR_CD, RT_TP_CD
                               ,ROW_NUMBER() OVER (ORDER BY SCC_CD, LCC_CD, RCC_CD, BND_CD
                                                           ,DECODE(EQ_TPSZ_CD, pi_eq_tp_sz_cd,1, 'ALAL', 2, SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL', 3,
                                                                               'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1), 4) ASC) RN
                               ,COM_SCG_SEQ
                           FROM TRS_COM_SCG_MGMT
                          WHERE 1=1
                            AND TRSP_COST_MOD_CD = DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY')
                            AND AGMT_TRSP_TP_CD  = pi_crr_mod_cd
                         AND (SCC_CD = MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'SCC') OR
                           LCC_CD IN (MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'LCC')) OR
                           RCC_CD IN (MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'RCC'))
                             )
                            AND NVL(CGO_TP_CD, DECODE(pi_cgo_tp_cd, 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(pi_cgo_tp_cd, 'F', 'F', 'C', 'F', 'M', 'M')
                            AND NVL(BND_CD, pi_bound_cd) = pi_bound_cd
                            AND pi_basis_dt BETWEEN EFF_FM_DT AND EFF_TO_DT
                        )
                  --WHERE RN = 1
                  GROUP BY COM_SCG_KND_CD
                          ,COM_SCG_SEQ
               ) F
             WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
               AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
               AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD
               AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ
               AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO
               AND C.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
               AND C.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
               AND C.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
               AND C.TRSP_AGMT_SCG_NOD_SEQ = E.TRSP_AGMT_SCG_NOD_SEQ
               AND E.WO_APLY_FLG ='1'
               AND B.TRSP_AGMT_OFC_CTY_CD = pi_trsp_agmt_ofc_cty_cd
               AND B.TRSP_AGMT_SEQ = pi_trsp_agmt_seq
               AND B.TRSP_AGMT_RT_TP_SER_NO = pi_trsp_agmt_rt_tp_ser_no
               AND C.TRSP_SCG_CD IN (SELECT INTG_CD_VAL_CTNT
                                       FROM COM_INTG_CD_DTL
                                      WHERE INTG_CD_ID = v_scg1
                                        AND INTG_CD_VAL_CTNT IN (v_scg2, v_scg3))
               AND E.EQ_KND_CD = pi_eq_knd_cd
               AND DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) =
                   DECODE(pi_trsp_so_knd_cd,
                          'USRAIL',
                          '0',
                          TO_NUMBER(pi_vndr_seq))
               /* 161020 PCW : Surcharge 조회 시 From/Via/Door/To Node가 전부 Blank로 입력된 경우만 AGTM_ROUT_ALL_FLG = 'Y' */
               AND C.AGMT_ROUT_ALL_FLG = CASE WHEN C.FM_NOD_CD = '0000000' AND C.VIA_NOD_CD = '0000000' AND C.DOR_NOD_CD = '0000000' AND C.TO_NOD_CD = '0000000'
                                              THEN 'Y'
                                              ELSE 'N'
                                         END
               AND ((
                          C.FM_NOD_CD  = DECODE(LENGTH(DECODE(C.FM_NOD_CD,'0000000', NULL, C.FM_NOD_CD)), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')
                      AND C.VIA_NOD_CD = DECODE(LENGTH(DECODE(C.VIA_NOD_CD,'0000000', NULL, C.VIA_NOD_CD)), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd, 1, 5), '0000000')
                      AND C.DOR_NOD_CD = DECODE(LENGTH(DECODE(C.DOR_NOD_CD,'0000000', NULL, C.DOR_NOD_CD)), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd, 1, 5), '0000000')
                      AND C.TO_NOD_CD  = DECODE(LENGTH(DECODE(C.TO_NOD_CD,'0000000', NULL, C.TO_NOD_CD)), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
                   ) OR (
                          C.FM_NOD_CD  = '0000000'
                      AND C.VIA_NOD_CD = '0000000'
                      AND C.DOR_NOD_CD = '0000000'
                      AND C.TO_NOD_CD  = '0000000'
                   ))
               AND E.EFF_FM_DT <= pi_basis_dt
               AND E.EFF_TO_DT >= pi_basis_dt
               AND CASE WHEN C.TRSP_SCG_CD = 'SCOWAL'
                        THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD), E.TO_WGT)
                        ELSE 1
                   END >= CASE WHEN C.TRSP_SCG_CD = 'SCOWAL'
                              THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(NVL(pi_wgt_uom, 'KGS'), vo_wgt_qty)
                              ELSE 0
                         END
               AND (
                        E.TRSP_AGMT_EQ_TP_SZ_CD IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL', 'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1), 'ALAL')
                        OR
                        (E.COM_SCG_APLY_FLG = '1' AND E.TRSP_AGMT_EQ_TP_SZ_CD = 'XXXX')
                   )
               AND CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_bound_cd = 'T' THEN DECODE(B.TRSP_BND_CD, NULL, 'N', 'Y', 'N', B.TRSP_BND_CD)
               WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND NVL(pi_bound_cd,'N') <> 'T' THEN DECODE(B.TRSP_BND_CD, NULL, 'N', B.TRSP_BND_CD)
                        ELSE 'N'
                   END = 'N'
               AND (B.SPCL_CGO_CNTR_TP_CD IS NULL
                     OR
                    CASE WHEN pi_spcl_cgo_cd IS NULL THEN B.SPCL_CGO_CNTR_TP_CD
                         ELSE pi_spcl_cgo_cd
                    END = B.SPCL_CGO_CNTR_TP_CD)
               AND C.TRSP_SCG_CD            = F.COM_SCG_KND_CD(+)
               AND (E.COM_SCG_APLY_FLG != '1' OR (E.COM_SCG_APLY_FLG = '1' AND (NVL(F.TRSP_ONE_WY_RT,0) > 0 OR NVL(F.TRSP_RND_RT,0) > 0)))
             ORDER BY CASE WHEN pi_system_indicator = 'COA' THEN NVL(E.AGMT_COST_FLG, '0')
                           ELSE '1'
                       END DESC,
                      C.TRSP_SCG_CD DESC /* */,
                      EQ_TPSZ_PRIOR_ORDER ASC,
                      B.CMDT_GRP_CD ASC,
                      LENGTH(DECODE(C.FM_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    C.FM_NOD_CD)) DESC,
                      LENGTH(DECODE(C.VIA_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    C.VIA_NOD_CD)) DESC,
                      LENGTH(DECODE(C.DOR_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    C.DOR_NOD_CD)) DESC,
                      LENGTH(DECODE(C.TO_NOD_CD,
                                    '0000000',
                                    'N/A',
                                    C.TO_NOD_CD)) DESC,
                      /* 2015.04.27 WHEN pi_bound_cd = 'T' THEN 'T' FIRST, 'A', NULL LAST */
                      CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_bound_cd = 'T' THEN B.TRSP_BND_CD
           WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND NVL(pi_bound_cd,'N') <> 'T' THEN B.TRSP_BND_CD
                           ELSE NULL
                      END DESC NULLS LAST,
                      B.SPCL_CGO_CNTR_TP_CD,
--                      E.TRSP_AGMT_SCG_RT_SEQ DESC, -- 자료중 마지막으로 등록된 RATE를 조회한다.
                      CASE pi_way_type
                        WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
                        WHEN 'RND' THEN E.TRSP_RND_RT
                      END
            )
     WHERE ROWNUM < 2;

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC QUERY SQL START ===============');
      DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_SCG_RT_HIS WHERE 1=1 ');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_OFC_CTY_CD  = ''' || pi_trsp_agmt_ofc_cty_cd || '''');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SEQ  = ' || pi_trsp_agmt_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_TP_SER_NO  = ' || pi_trsp_agmt_rt_tp_ser_no);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_NOD_SEQ  = ' || vo_trsp_agmt_scg_nod_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_RT_SEQ  = ' || vo_trsp_agmt_scg_rt_seq);
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC QUERY SQL END ===============');
    END IF;

    po_scg_union_exp         := vo_scg_union_exp;
    po_trsp_scg_cd           := vo_trsp_scg_cd;
    po_trsp_agmt_scg_nod_seq := vo_trsp_agmt_scg_nod_seq;
    po_trsp_agmt_scg_rt_seq  := vo_trsp_agmt_scg_rt_seq;
    po_scg_curr_cd           := vo_scg_curr_cd;
    po_scg_rate              := vo_scg_rate;

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_scg_union_exp         : ' || po_scg_union_exp);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_trsp_scg_cd           : ' || po_trsp_scg_cd);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_trsp_agmt_scg_nod_seq : ' || po_trsp_agmt_scg_nod_seq);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_trsp_agmt_scg_rt_seq  : ' || po_trsp_agmt_scg_rt_seq);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_scg_curr_cd           : ' || po_scg_curr_cd);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_scg_rate              : ' || po_scg_rate);
      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => vo_agmt_scg_rt_div_cd    : ' || vo_agmt_scg_rt_div_cd);
    END IF;

    IF vo_agmt_scg_rt_div_cd = 'R' THEN
      po_scg_curr_cd := pi_basic_curr_cd;
    END IF;

    IF po_scg_curr_cd !='XXX' AND pi_basic_curr_cd != po_scg_curr_cd THEN
      po_rtn_cd           := -101;
      po_process_rslt_msg := 'BASIC/SURCHARGE CURRECY CODE IS DIFFERENCT ';
    END IF;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      po_rtn_cd           := -99;
      po_process_rslt_msg := 'GET_SCG_RATE_CALC_PRC <NO_DATA_FOUND>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_SCG_RATE_CALC_PRC <NO_DATA_FOUND> ERROR MSG = [' || SQLERRM || ']');
      END IF;
    WHEN OTHERS THEN
      po_rtn_cd           := -1;
      po_process_rslt_msg := 'GET_SCG_RATE_CALC_PRC <OTHERS>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_SCG_RATE_CALC_PRC <OTHERS> ERROR MSG = [' || SQLERRM || ']');
      END IF;
  END GET_SCG_RATE_CALC_PRC;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : HYUNG WOOK CHOI
  # -- Created : DEC. 11, 2014
  # -- Table   : TRS_AGMT_*
  # -- Purpose : ADDITIONAL SURCHARGE RATE CALCULATION FOR COA  TRS
  #####################################################################*/
  PROCEDURE GET_SCG_ADD_CALC_PRC(pi_system_indicator       IN VARCHAR2, /* TRS, COA */
                                        pi_trsp_so_knd_cd         IN VARCHAR2, /* NONE US RAIL, USRAIL */
                                        pi_scg_knd_indicator      IN VARCHAR2, /* ADDITIONAL */
                                        pi_way_type               IN VARCHAR2, /* ONE or RND      */
                                        pi_trsp_agmt_ofc_cty_cd   IN VARCHAR2,
                                        pi_trsp_agmt_seq          IN NUMBER,
                                        pi_trsp_agmt_rt_tp_ser_no IN NUMBER,
                                        pi_vndr_seq               IN VARCHAR2,
                                        pi_basis_dt               IN DATE,
                                        pi_eq_knd_cd              IN VARCHAR2,
                                        pi_eq_tp_sz_cd            IN VARCHAR2,
                                        pi_cgo_tp_cd              IN VARCHAR2,
                                        pi_from_nod_cd            IN VARCHAR2,
                                        pi_via_nod_cd             IN VARCHAR2,
                                        pi_door_nod_cd            IN VARCHAR2,
                                        pi_to_nod_cd              IN VARCHAR2,
                                        pi_bundle_cnt             IN NUMBER,
                                        pi_wgt_uom                IN VARCHAR2, /* L-LBS, K-KG */
                                        pi_wgt_qty                IN NUMBER,
                                        pi_basic_rt               IN NUMBER,
                                        pi_basic_curr_cd          IN VARCHAR2,
                                        pi_debug_flg              IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                        /* OUT PARAMETER */
                                        po_scg_union_exp         OUT VARCHAR2,
                                        po_trsp_scg_cd           OUT VARCHAR2,
                                        po_trsp_agmt_scg_nod_seq OUT NUMBER,
                                        po_trsp_agmt_scg_rt_seq  OUT NUMBER,
                                        po_scg_curr_cd           OUT VARCHAR2,
                                        po_scg_rate              OUT NUMBER,
                                        po_rtn_cd                OUT NUMBER,
                                        po_process_rslt_msg      OUT VARCHAR2) IS

    vo_agmt_scg_rt_div_cd    VARCHAR2(1);
    vo_scg_union_exp         VARCHAR2(100);
    vo_trsp_scg_cd           VARCHAR2(6);
    vo_trsp_agmt_scg_nod_seq NUMBER(12);
    vo_trsp_agmt_scg_rt_seq  NUMBER(12);
    vo_scg_curr_cd           VARCHAR2(3);
    vo_scg_rate              NUMBER(15, 3);

    v_scg1      VARCHAR2(3);
    v_scg2      VARCHAR2(3);
    v_scg3      VARCHAR2(3);
    v_scg_title VARCHAR2(20);
    vo_wgt_qty                NUMBER(18, 3);

  BEGIN

    IF pi_debug_flg = 'Y' THEN

      DBMS_OUTPUT.PUT_LINE('');
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC PARAMETER START(' || pi_scg_knd_indicator || ')===============');
      DBMS_OUTPUT.PUT_LINE('pi_system_indicator      VARCHAR2(100)    := ''' || pi_system_indicator || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_so_knd_cd        VARCHAR2(100)    := ''' || pi_trsp_so_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_scg_knd_indicator     VARCHAR2(100)    := ''' || pi_scg_knd_indicator || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_way_type              VARCHAR2(100)    := ''' || pi_way_type || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd  VARCHAR2(100)    := ''' || pi_trsp_agmt_ofc_cty_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq            NUMBER(30)    := ''' || pi_trsp_agmt_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_rt_tp_ser_no   NUMBER(30)    := ''' || pi_trsp_agmt_rt_tp_ser_no || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_vndr_seq                 NUMBER(30)    := ''' || pi_vndr_seq || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basis_dt                       DATE    := TO_DATE(''' || TO_CHAR(pi_basis_dt, 'YYYYMMDD') || ''',''YYYYMMDD'');');
      DBMS_OUTPUT.PUT_LINE('pi_eq_knd_cd             VARCHAR2(100)    := ''' || pi_eq_knd_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd           VARCHAR2(100)    := ''' || pi_eq_tp_sz_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd             VARCHAR2(100)    := ''' || pi_cgo_tp_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd           VARCHAR2(100)    := ''' || pi_from_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_via_nod_cd            VARCHAR2(100)    := ''' || pi_via_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_door_nod_cd           VARCHAR2(100)    := ''' || pi_door_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd             VARCHAR2(100)    := ''' || pi_to_nod_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_bundle_cnt               NUMBER(30)    := ''' || pi_bundle_cnt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_uom               VARCHAR2(100)    := ''' || pi_wgt_uom || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_wgt_qty                  NUMBER(30)    := ''' || pi_wgt_qty || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basic_rt               NUMBER(15,3)    := ''' || pi_basic_rt || ''';');
      DBMS_OUTPUT.PUT_LINE('pi_basic_curr_cd         VARCHAR2(100)    := ''' || pi_basic_curr_cd || ''';');
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_RATE_CALC_PRC PARAMETER END(' || pi_scg_knd_indicator || ')===============');
    END IF;

    v_scg1      := 'CD30002';
    v_scg2      := 'SCFAAL';
    v_scg3      := 'SCFCAL';
    v_scg_title := 'Additional Surcharge';

    IF pi_wgt_qty > 999999.99 THEN
        vo_wgt_qty := 999999.99;
    ELSE
        vo_wgt_qty := pi_wgt_qty;
    END IF;

    po_rtn_cd := 0; /* INITIAL SETTING AS SUCCESS */

    SELECT SURCHARGE_UNION_EXP,
           TRSP_SCG_CD,
           TRSP_AGMT_SCG_NOD_SEQ,
           TRSP_AGMT_SCG_RT_SEQ,
           LOCAL_SCG_CURR_CD_OR_PERCENT,
           FUEL_SURCHARGE_RATE_OR_PERCENT,
           AGMT_SCG_RT_DIV_CD
      INTO vo_scg_union_exp,
           vo_trsp_scg_cd,
           vo_trsp_agmt_scg_nod_seq,
           vo_trsp_agmt_scg_rt_seq,
           vo_scg_curr_cd,
           vo_scg_rate,
           vo_agmt_scg_rt_div_cd
      FROM (SELECT v_scg_title || ' = [' || C.TRSP_SCG_CD || ']->[' ||
                   E.TRSP_AGMT_EQ_TP_SZ_CD || ']->[' || B.CMDT_GRP_CD ||
                   ']->[' || E.CRE_DT || ']' SURCHARGE_UNION_EXP,
                   E.TRSP_AGMT_OFC_CTY_CD,
                   E.TRSP_AGMT_SEQ,
                   E.TRSP_AGMT_RT_TP_SER_NO,
                   C.TRSP_SCG_CD,
                   CASE
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD IS NULL THEN 9
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = 'ALAL' THEN 4
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD LIKE '%AL%' THEN 2
                     WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd THEN 1
                     ELSE 3
                   END EQ_TPSZ_PRIOR_ORDER,
                   E.CURR_CD AS LOCAL_SCG_CURR_CD_OR_PERCENT,
                   CASE pi_way_type
                     WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
                     WHEN 'RND' THEN E.TRSP_RND_RT
                   END FUEL_SURCHARGE_RATE_OR_PERCENT,
                   E.AGMT_SCG_RT_DIV_CD,
                   C.TRSP_AGMT_SCG_NOD_SEQ,
                   E.TRSP_AGMT_SCG_RT_SEQ
              FROM TRS_AGMT_APLY_VNDR A,
                   TRS_AGMT_RT_TP     B,
                   TRS_AGMT_SCG_NOD   C,
                   TRS_AGMT_SCG_RT    E
             WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
               AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
               AND B.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD
               AND B.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ
               AND B.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO
               AND C.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
               AND C.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
               AND C.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
               AND C.TRSP_AGMT_SCG_NOD_SEQ = E.TRSP_AGMT_SCG_NOD_SEQ
               AND B.TRSP_AGMT_OFC_CTY_CD = pi_trsp_agmt_ofc_cty_cd
               AND B.TRSP_AGMT_SEQ = pi_trsp_agmt_seq
               AND B.TRSP_AGMT_RT_TP_SER_NO = pi_trsp_agmt_rt_tp_ser_no
               AND C.TRSP_SCG_CD IN (SELECT INTG_CD_VAL_CTNT
                                       FROM COM_INTG_CD_DTL
                                      WHERE INTG_CD_ID = v_scg1
                                        AND INTG_CD_VAL_CTNT NOT IN (v_scg2, v_scg3))
               AND E.EQ_KND_CD = pi_eq_knd_cd
               AND DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) =
                   DECODE(pi_trsp_so_knd_cd,
                          'USRAIL',
                          '0',
                          TO_NUMBER(pi_vndr_seq))
               /* 161020 PCW : Surcharge 조회 시 From/Via/Door/To Node가 전부 Blank로 입력된 경우만 AGTM_ROUT_ALL_FLG = 'Y' */
               AND C.AGMT_ROUT_ALL_FLG = CASE WHEN C.FM_NOD_CD = '0000000' AND C.VIA_NOD_CD = '0000000' AND C.DOR_NOD_CD = '0000000' AND C.TO_NOD_CD = '0000000'
                                              THEN 'Y'
                                              ELSE 'N'
                                         END
               AND C.FM_NOD_CD = CASE WHEN C.TRSP_SCG_CD = 'SCFAAL'
                                      THEN '0000000'
                                      ELSE DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5))
                                 END
               AND C.VIA_NOD_CD = CASE WHEN C.TRSP_SCG_CD = 'SCFAAL'
                                       THEN '0000000'
                                       ELSE NVL(DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd, 1, 5)), '0000000')
                                  END
               AND C.DOR_NOD_CD = CASE WHEN C.TRSP_SCG_CD = 'SCFAAL'
                                       THEN '0000000'
                                       ELSE NVL(DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd, 1, 5)), '0000000')
                                  END
               AND C.TO_NOD_CD = CASE WHEN C.TRSP_SCG_CD = 'SCFAAL'
                                      THEN '0000000'
                                      ELSE DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5))
                                 END
               AND E.EFF_FM_DT <= pi_basis_dt
               AND E.EFF_TO_DT >= pi_basis_dt
               AND CASE WHEN C.TRSP_SCG_CD = 'SCOWAL'
                        THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD), E.TO_WGT)
                        ELSE 1
                   END >= CASE WHEN C.TRSP_SCG_CD = 'SCOWAL'
                              THEN TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(NVL(pi_wgt_uom, 'KGS'), vo_wgt_qty)
                              ELSE 0
                         END
               /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
               AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL', 'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1), 'ALAL')
                /* BASIC RATE WAY TYPE에 따라서 SURCHAGE WAY TYPE 결정 */
               AND CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT WHEN 'RND' THEN E.TRSP_RND_RT END IS NOT NULL
               /* 0:FUE >> FUA, 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST) */
            );

    IF pi_debug_flg = 'Y' THEN

      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_ADD_CALC_PRC QUERY SQL START ===============');
      DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_SCG_RT WHERE 1=1 ');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_OFC_CTY_CD  = ''' || pi_trsp_agmt_ofc_cty_cd || '''');
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SEQ  = ' || pi_trsp_agmt_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_RT_TP_SER_NO  = ' || pi_trsp_agmt_rt_tp_ser_no);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_NOD_SEQ  = ' || vo_trsp_agmt_scg_nod_seq);
      DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_RT_SEQ  = ' || vo_trsp_agmt_scg_rt_seq);
      DBMS_OUTPUT.PUT_LINE('============ GET_SCG_ADD_CALC_PRC QUERY SQL END ===============');

    END IF;

    po_scg_union_exp         := vo_scg_union_exp;
    po_trsp_scg_cd           := vo_trsp_scg_cd;
    po_trsp_agmt_scg_nod_seq := vo_trsp_agmt_scg_nod_seq;
    po_trsp_agmt_scg_rt_seq  := vo_trsp_agmt_scg_rt_seq;
    po_scg_curr_cd           := vo_scg_curr_cd;
    po_scg_rate              := vo_scg_rate;

    IF pi_debug_flg = 'Y' THEN

      DBMS_OUTPUT.PUT_LINE('Return Scg Rate => po_scg_rate : ' || po_scg_rate);

    END IF;

    IF vo_agmt_scg_rt_div_cd = 'R' THEN

     -- Surcharge가 Ratio일 경우 Surcharge에는 Currency가 존재하지 않으므로 Basic가 동일하게 처리한다.
      po_scg_curr_cd := pi_basic_curr_cd;

    END IF;

    IF pi_basic_curr_cd != po_scg_curr_cd THEN

      po_rtn_cd           := -101;
      po_process_rslt_msg := 'BASIC/SURCHARGE CURRECY CODE IS DIFFERENCT ';

    END IF;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      po_rtn_cd           := -99;
      po_process_rslt_msg := 'GET_SCG_ADD_CALC_PRC <NO_DATA_FOUND>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_SCG_ADD_CALC_PRC <NO_DATA_FOUND> ERROR MSG = [' ||
                             SQLERRM || ']');
      END IF;
    WHEN OTHERS THEN
      po_rtn_cd           := -1;
      po_process_rslt_msg := 'GET_SCG_ADD_CALC_PRC <OTHERS>';
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_SCG_ADD_CALC_PRC <OTHERS> ERROR MSG = [' ||
                             SQLERRM || ']');
      END IF;
  END GET_SCG_ADD_CALC_PRC;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JONG HYEK CHOI
  # -- Created : MAY 1, 2010
  # -- Table   : TRS_TRSP_AGMT_*
  # -- Purpose : SURCHARGE RATE CALCULATION FOR COA  TRS
  #####################################################################*/
  PROCEDURE GET_RAIL_SCG_RATE_CALC_PRC(pi_system_indicator     IN VARCHAR2 /* TRS, COA */,
                                       pi_eq_tp_sz_cd          IN VARCHAR2,
                                       pi_vndr_seq             IN VARCHAR2,
                                       pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                       pi_trsp_agmt_seq        IN NUMBER,
                                       pi_scg_knd_indicator    IN VARCHAR2 /* FSG : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */,
                                       pi_cgo_tp_cd            IN VARCHAR2,
                                       pi_from_nod_cd          IN VARCHAR2,
                                       pi_to_nod_cd            IN VARCHAR2,
                                       pi_wgt_uom              IN VARCHAR2 /* L-LBS, K-KG */,
                                       pi_wgt_qty              IN NUMBER,
                                       pi_basis_dt             IN DATE,
                                       pi_spcl_cgo_cd          IN VARCHAR2,
                                       pi_bzc_curr_cd          IN VARCHAR2,
                                       pi_bzc_rt               IN NUMBER,
                                       pi_bound_cd             IN VARCHAR2,
                                       pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITE DBMS LOG)
                                       /* OUT PARAMETER */
                                       po_rail_curr_cd         OUT VARCHAR2,
                                       po_rail_scg_rt          OUT NUMBER,
                                       po_rtn_cd               OUT NUMBER,
                                       po_rtn_msg              OUT VARCHAR2,
                                       po_return               OUT RAIL_TYPE1) IS

    v_wgt_qty NUMBER(9, 3);
    v_eq_sz   VARCHAR2(2);
    C_CONV_LB_FROM_KGS CONSTANT NUMBER(10, 6) := 2.204623;

    vo_delt_flg          VARCHAR2(1);
    vo_rail_curr_cd      VARCHAR2(3);
    vo_rail_scg_rt       NUMBER(15, 3);
    vo_com_scg_knd_cd    VARCHAR2(6);
    vo_com_scg_seq       NUMBER(12);
    cur_rail_scg_count   NUMBER(5) ;

    po_rail_scg_seq         NUMBER;
    po_com_scg_knd_cd       VARCHAR2(6);
    po_com_scg_seq          NUMBER;

  BEGIN

    IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC PARAMETER START(' || pi_scg_knd_indicator || ')===============');
        DBMS_OUTPUT.PUT_LINE('pi_system_indicator        VARCHAR2(100)  := ''' || pi_system_indicator || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_eq_tp_sz_cd             VARCHAR2(100)  := ''' || pi_eq_tp_sz_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_vndr_seq                   NUMBER(30)  := ''' || pi_vndr_seq || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_ofc_cty_cd    VARCHAR2(100)  := ''' || pi_trsp_agmt_ofc_cty_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_trsp_agmt_seq              NUMBER(30)  := ''' || pi_trsp_agmt_seq || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_scg_knd_indicator       VARCHAR2(100)  := ''' || pi_scg_knd_indicator || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_cgo_tp_cd               VARCHAR2(100)  := ''' || pi_cgo_tp_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd             VARCHAR2(100)  := ''' || pi_from_nod_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd               VARCHAR2(100)  := ''' || pi_to_nod_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_wgt_uom                 VARCHAR2(100)  := ''' || pi_wgt_uom || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_wgt_qty                    NUMBER(30)  := ''' || pi_wgt_qty || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_basis_dt                        DATE   := TO_DATE(''' || TO_CHAR(pi_basis_dt, 'YYYYMMDD') || ''',''YYYYMMDD'');');
        DBMS_OUTPUT.PUT_LINE('pi_spcl_cgo_cd             VARCHAR2(100)  := ''' || pi_spcl_cgo_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_bzc_curr_cd             VARCHAR2(100)  := ''' || pi_bzc_curr_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_bzc_rt                   NUMBER(15,3)  := ''' || pi_bzc_rt || ''';');
        DBMS_OUTPUT.PUT_LINE('pi_bound_cd                VARCHAR2(100)  := ''' || pi_bound_cd || ''';');
        DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC PARAMETER END(' || pi_scg_knd_indicator || ')===============');
    END IF;

    IF pi_wgt_uom = 'KGS' THEN
      v_wgt_qty := ROUND(pi_wgt_qty * C_CONV_LB_FROM_KGS, 3);
    ELSE
      v_wgt_qty := pi_wgt_qty;
    END IF;

    /* Agreement Inquiry by Route 에서 팝업으로 TRS_GET_AGMT_SCG_CALC_FNC통해서 조회할 때 3 또는 4자리가 들어올 수 있음 */
    IF LENGTH(pi_eq_tp_sz_cd) = 3 AND SUBSTR(pi_eq_tp_sz_cd, 1, 2) = 'AL' THEN
        v_eq_sz := SUBSTR(pi_eq_tp_sz_cd, 3, 1);
    ELSIF LENGTH(pi_eq_tp_sz_cd) = 3 AND SUBSTR(pi_eq_tp_sz_cd, 2, 2) = 'AL' THEN
        v_eq_sz := SUBSTR(pi_eq_tp_sz_cd, 2, 2);
    ELSIF LENGTH(pi_eq_tp_sz_cd) = 4 THEN
        v_eq_sz := SUBSTR(pi_eq_tp_sz_cd, 3, 2);
    ELSE
        v_eq_sz := SUBSTR(pi_eq_tp_sz_cd, 2, 1);
    END IF;

    cur_rail_scg_count := 1;

    IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC => START SEARCH ===============');
    END IF;

    FOR cur_rail_scg IN (
    SELECT CURR_CD, RAIL_SCG_RT, DELT_FLG, TRSP_AGMT_SCG_SEQ, COM_SCG_KND_CD,COM_SCG_SEQ
      FROM (SELECT E.CURR_CD,
                   CASE
                     WHEN pi_scg_knd_indicator = 'FSG' AND E.COM_SCG_APLY_FLG = '1' AND F.AGMT_SCG_RT_DIV_CD = 'F'
                          THEN F.TRSP_ONE_WY_RT
                     WHEN pi_scg_knd_indicator = 'FSG' AND E.COM_SCG_APLY_FLG = '1' AND F.AGMT_SCG_RT_DIV_CD = 'R'
                          THEN ROUND(pi_bzc_rt * (F.TRSP_ONE_WY_RT / 100), NVL(E.RAIL_RTO_NO, 0))
                     WHEN pi_scg_knd_indicator = 'FSG'
                          THEN ROUND(pi_bzc_rt * (E.TRSP_RAIL_RTO / 100), NVL(E.RAIL_RTO_NO, 0))
                     ELSE
                          CASE
                          WHEN v_eq_sz = '2' OR v_eq_sz = '3' THEN
                                NVL(E.FX_SCG_20FT_RT, E.FX_SCG_ALL_RT)
                          WHEN v_eq_sz = '4' OR v_eq_sz = '5' THEN
                                NVL(E.FX_SCG_40FT_RT, E.FX_SCG_ALL_RT)
                          WHEN v_eq_sz = '6' OR v_eq_sz = '7' THEN
                                NVL(E.FX_SCG_45FT_RT, E.FX_SCG_ALL_RT)
                          END
                   END AS RAIL_SCG_RT,
                   E.DELT_FLG,
                   E.TRSP_AGMT_SCG_SEQ,
                   CASE WHEN E.COM_SCG_APLY_FLG = '0'
                        THEN NULL
                        ELSE F.COM_SCG_KND_CD
                   END AS COM_SCG_KND_CD,
                   CASE WHEN E.COM_SCG_APLY_FLG = '0'
                        THEN NULL
                        ELSE F.COM_SCG_SEQ
                   END AS COM_SCG_SEQ
              FROM TRS_AGMT_HDR         A,
                   TRS_AGMT_APLY_VNDR   B,
                   TRS_AGMT_RAIL_SCG_RT E,
                   (SELECT COM_SCG_KND_CD, MAX(EQ_TPSZ_CD) TRSP_AGMT_EQ_TP_SZ_CD, MAX(CURR_CD) CURR_CD, MAX(RT_TP_CD) AGMT_SCG_RT_DIV_CD
                          ,SUM(NVL(ONE_WY_RT, RND_RT)) TRSP_ONE_WY_RT
                          ,0 TRSP_RND_RT
                          ,SUM(NVL(ONE_WY_RT, RND_RT)) ETC_ADD_AMT
                          ,COM_SCG_SEQ
                      FROM (
                             SELECT 'FSG'  COM_SCG_KND_CD, ONE_WY_RT, RND_RT, EQ_TPSZ_CD, CURR_CD, RT_TP_CD
                                   ,ROW_NUMBER() OVER (ORDER BY SCC_CD, LCC_CD, RCC_CD, BND_CD
                                                               ,DECODE(EQ_TPSZ_CD, pi_eq_tp_sz_cd,1, 'ALAL', 2, SUBSTR(pi_eq_tp_sz_cd, 1, 1) || 'AL', 3,
                                                                                   'AL' || SUBSTR(pi_eq_tp_sz_cd, 2, 1), 4) ASC
                                                               ,CGO_TP_CD NULLS LAST) RN
                                   ,COM_SCG_SEQ
                               FROM TRS_COM_SCG_MGMT
                              WHERE 1=1
                                AND TRSP_COST_MOD_CD = 'CY'
                                AND AGMT_TRSP_TP_CD  = 'RD'
                                AND (SCC_CD = MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'SCC') OR
                               LCC_CD IN (MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'LCC')) OR
                               RCC_CD IN (MST_LOC_FNC(SUBSTR(pi_from_nod_cd, 1, 5), 'RCC'))
                                    )
                                AND NVL(CGO_TP_CD, DECODE(pi_cgo_tp_cd, 'F', 'F', 'C', 'F', 'M', 'M')) = DECODE(pi_cgo_tp_cd, 'F', 'F', 'C', 'F', 'M', 'M')
                                AND NVL(BND_CD, NVL(pi_bound_cd,'X')) = NVL(pi_bound_cd,'X')
                                AND COM_SCG_KND_CD = 'SCFAAL'
                                AND pi_basis_dt BETWEEN EFF_FM_DT AND EFF_TO_DT
                            )
                      WHERE RN = 1
                      GROUP BY COM_SCG_KND_CD
                              ,COM_SCG_SEQ
                   ) F
             WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
               AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
               AND B.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
               AND B.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
               AND B.VNDR_SEQ = E.VNDR_SEQ
               AND E.VNDR_SEQ = pi_vndr_seq
               AND E.WO_APLY_FLG ='1'
               AND E.TRSP_RAIL_SCG_CD = F.COM_SCG_KND_CD(+)
               AND E.TRSP_RAIL_SCG_CD = pi_scg_knd_indicator
               AND NVL(E.SPCL_CGO_CNTR_TP_CD, 'NULL') = CASE
                                                            WHEN pi_scg_knd_indicator = 'HZS' AND pi_spcl_cgo_cd IN ('DG','AD','RD') THEN pi_spcl_cgo_cd
                                                            WHEN pi_scg_knd_indicator = 'HZS' AND pi_spcl_cgo_cd NOT IN ('DG','AD','RD') THEN 'XX'
                                                            WHEN pi_scg_knd_indicator = 'HZS' AND pi_spcl_cgo_cd IS NULL THEN 'XX'
                                                            WHEN pi_scg_knd_indicator != 'HZS' THEN 'NULL'
                                                        END
               AND E.TRSP_AGMT_OFC_CTY_CD = pi_trsp_agmt_ofc_cty_cd
               AND E.TRSP_AGMT_SEQ = pi_trsp_agmt_seq

               AND NVL(E.FM_NOD_CD, '00') = DECODE(LENGTH(E.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), NVL(E.FM_NOD_CD, '00'))
               AND NVL(E.TO_NOD_CD, '00') = DECODE(LENGTH(E.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), NVL(E.TO_NOD_CD, '00'))
               AND NVL(E.CGO_TP_CD, '0')  = DECODE(NVL(E.CGO_TP_CD, '0'), '0', '0', pi_cgo_tp_cd)

               AND NVL(E.LBS_OVR_WGT, 0) <= NVL2(v_wgt_qty, v_wgt_qty, 1)
               AND E.EFF_FM_DT <= pi_basis_dt
               AND E.EFF_TO_DT >= pi_basis_dt
               AND E.AGMT_EQ_SZ_NO = CASE
                                         WHEN pi_scg_knd_indicator = 'OWS'
                                         THEN CASE
                                                  WHEN v_eq_sz = '2' OR v_eq_sz = '3'
                                                  THEN '20'
                                                  WHEN v_eq_sz = '4' OR v_eq_sz = '5'
                                                  THEN '40'
                                                  WHEN v_eq_sz = '6' OR v_eq_sz = '7'
                                                  THEN '45'
                                              END
                                         ELSE '00'
                                     END
               AND E.CURR_CD = CASE
                                   WHEN pi_scg_knd_indicator = 'FSG'
                                   THEN 'XXX' ELSE pi_bzc_curr_cd
                               END
               AND CASE WHEN pi_scg_knd_indicator != 'FSG' THEN
                            CASE WHEN v_eq_sz = '2' OR v_eq_sz = '3' THEN
                                    NVL(E.FX_SCG_20FT_RT, E.FX_SCG_ALL_RT)
                                 WHEN v_eq_sz = '4' OR v_eq_sz = '5' THEN
                                    NVL(E.FX_SCG_40FT_RT, E.FX_SCG_ALL_RT)
                                 WHEN v_eq_sz = '6' OR v_eq_sz = '7' THEN
                                    NVL(E.FX_SCG_45FT_RT, E.FX_SCG_ALL_RT)
                            END
                        ELSE 100
                   END IS NOT NULL
               AND (E.SPCL_CGO_CNTR_TP_CD IS NULL
                     OR
                    CASE WHEN pi_scg_knd_indicator = 'FSG' THEN E.SPCL_CGO_CNTR_TP_CD
                         WHEN pi_spcl_cgo_cd IS NULL AND pi_scg_knd_indicator != 'FSG' THEN E.SPCL_CGO_CNTR_TP_CD
                         ELSE pi_spcl_cgo_cd
                    END = E.SPCL_CGO_CNTR_TP_CD)
             ORDER BY LENGTH(DECODE(E.FM_NOD_CD, NULL, 'N/A', E.FM_NOD_CD)) DESC,
                      LENGTH(DECODE(E.TO_NOD_CD, NULL, 'N/A', E.TO_NOD_CD)) DESC,
                      E.CGO_TP_CD NULLS LAST
--                      E.TRSP_AGMT_SCG_SEQ DESC
            )
     WHERE pi_scg_knd_indicator = 'TTL'
        OR (pi_scg_knd_indicator !='TTL' AND ROWNUM < 2)
     )
     LOOP
        vo_rail_curr_cd   := cur_rail_scg.CURR_CD;
        vo_rail_scg_rt    := cur_rail_scg.RAIL_SCG_RT;
        vo_delt_flg       := cur_rail_scg.DELT_FLG;
        po_rail_scg_seq   := cur_rail_scg.TRSP_AGMT_SCG_SEQ;
        vo_com_scg_knd_cd := cur_rail_scg.COM_SCG_KND_CD;
        vo_com_scg_seq    := cur_rail_scg.COM_SCG_SEQ;

        IF pi_debug_flg = 'Y' THEN
          DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC QUERY SQL START ===============');
          DBMS_OUTPUT.PUT_LINE('SELECT * FROM TRS_AGMT_RAIL_SCG_RT WHERE 1=1 ');
          DBMS_OUTPUT.PUT_LINE('AND TRSP_AGMT_SCG_SEQ  = ''' || po_rail_scg_seq || '''');
          DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC QUERY SQL END ===============');
        END IF;

        IF vo_delt_flg = 'N' THEN
          po_rail_curr_cd   := vo_rail_curr_cd;
          po_rail_scg_rt    := NVL(po_rail_scg_rt,0) + NVL(vo_rail_scg_rt, 0);
        ELSE
          po_rtn_cd := -2;

            IF pi_debug_flg = 'Y' THEN
                DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <SURCHARGE RATE DELETE>');
            END IF;
        END IF;

        IF pi_debug_flg = 'Y' THEN
          DBMS_OUTPUT.PUT_LINE('Return Scg Del Flag            => vo_delt_flg       : ' || vo_delt_flg);
          DBMS_OUTPUT.PUT_LINE('Return Scg Curr Cd             => vo_rail_curr_cd   : ' || vo_rail_curr_cd);
          DBMS_OUTPUT.PUT_LINE('Return Scg Rate                => po_rail_scg_rt    : ' || vo_rail_scg_rt);
          DBMS_OUTPUT.PUT_LINE('Return Scg Rate Seq            => po_rail_scg_seq   : ' || po_rail_scg_seq);
          DBMS_OUTPUT.PUT_LINE('Return Scg Common Rate Kind Cd => po_com_scg_knd_cd : ' || vo_com_scg_knd_cd);
          DBMS_OUTPUT.PUT_LINE('Return Scg Common Rate Seq     => po_com_scg_seq    : ' || vo_com_scg_seq);
        END IF;

        IF pi_scg_knd_indicator = 'FSG' THEN
          po_rail_curr_cd := pi_bzc_curr_cd;
        END IF;

        IF pi_bzc_curr_cd != po_rail_curr_cd THEN
          po_rtn_cd  := -101;
          po_rtn_msg := 'BASIC/RAIL SURCHARGE CURRECY CODE IS DIFFERENCT ';
        END IF;

        po_return(cur_rail_scg_count).PO_RAIL_CURR_CD := vo_rail_curr_cd;
        po_return(cur_rail_scg_count).PO_RAIL_SCG_RT := vo_rail_scg_rt;
        po_return(cur_rail_scg_count).PO_RAIL_SCG_SEQ := po_rail_scg_seq;
        po_return(cur_rail_scg_count).PO_COM_SCG_KND_CD := vo_com_scg_knd_cd;
        po_return(cur_rail_scg_count).PO_COM_SCG_SEQ := vo_com_scg_seq;
        cur_rail_scg_count := cur_rail_scg_count + 1;
     END LOOP;

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.PUT_LINE('Return Curr Cd  => po_rail_curr_cd  : ' || po_rail_curr_cd);
      DBMS_OUTPUT.PUT_LINE('Return Tot Rate => po_rail_scg_rt   : ' || po_rail_scg_rt);
      DBMS_OUTPUT.PUT_LINE('Return Cd       => po_rtn_cd        : ' || po_rtn_cd);
      DBMS_OUTPUT.PUT_LINE('Return Msg      => po_rtn_msg       : ' || po_rtn_msg);
    END IF;

    IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('============ GET_RAIL_SCG_RATE_CALC_PRC => END SEARCH ===============');
    END IF;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
        po_rtn_cd  := -99;
        po_rtn_msg := 'GET_RAIL_SCG_RATE_CALC_PRC <NO_DATA_FOUND> ';

        IF pi_debug_flg = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <NO_DATA_FOUND> ERROR MSG = [' || SQLERRM || ']');
        END IF;
    WHEN OTHERS THEN
        po_rtn_cd  := -1;
        po_rtn_msg := 'GET_RAIL_SCG_RATE_CALC_PRC <OTHERS> ';

        IF pi_debug_flg = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('GET_RAIL_SCG_RATE_CALC_PRC <OTHERS> ERROR MSG = [' || SQLERRM || ']');
        END IF;

  END GET_RAIL_SCG_RATE_CALC_PRC;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JONG HYEK CHOI
  # -- Created : MAY 1, 2010
  # -- Table   : TRS_TRSP_AGMT_*
  # -- Purpose : ALL RATE COMBINATION FOR COA
  #####################################################################*/
  PROCEDURE GET_TRS_ALL_RATE_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                 pi_ctrl_ofc_cd          IN VARCHAR2,
                                 pi_vndr_seq             IN VARCHAR2,
                                 pi_basis_dt             IN DATE,
                                 pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                 pi_eq_knd_cd            IN VARCHAR2,
                                 pi_eq_tp_sz_cd          IN VARCHAR2,
                                 pi_cmb_tp_cd            IN VARCHAR2,
                                 pi_cgo_tp_cd            IN VARCHAR2,
                                 pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                 pi_crr_mod_cd           IN VARCHAR2,
                                 pi_cost_mod_cd          IN VARCHAR2,
                                 pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                 pi_cust_cnt_cd          IN VARCHAR2,
                                 pi_cust_seq             IN NUMBER,
                                 pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                 pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                 pi_from_nod_cd          IN VARCHAR2,
                                 pi_via_nod_cd           IN VARCHAR2,
                                 pi_door_nod_cd          IN VARCHAR2,
                                 pi_to_nod_cd            IN VARCHAR2,
                                 pi_bundle_cnt           IN NUMBER,
                                 pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                 pi_wgt_qty              IN NUMBER,
                                 pi_rcv_term             IN VARCHAR2,
                                 pi_de_term              IN VARCHAR2,
                                 pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                 pi_trsp_agmt_seq        IN NUMBER,
                                 pi_spcl_cgo_cd          IN VARCHAR2,
                                 pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITEDBMS LOG)
                                 /* OUT PARAMETER */
                                 po_trsp_agmt_ofc_cty_cd OUT VARCHAR2,
                                 po_trsp_agmt_seq        OUT NUMBER,
                                 po_trsp_agmt_rt_tp_cd   OUT VARCHAR2,
                                 po_way_type             OUT VARCHAR2,
                                 po_trsp_agmt_rt_tp_nm   OUT VARCHAR2,
                                 po_sp_type              OUT VARCHAR2,
                                 po_cust_nomi_trkr_flg   OUT VARCHAR2,
                                 po_cust_cnt_cd          OUT VARCHAR2,
                                 po_cust_seq             OUT NUMBER,
                                 po_local_curr_cd        OUT VARCHAR2,
                                 po_bzc_rt               OUT NUMBER,
                                 po_fuel_scg_rt          OUT NUMBER,
                                 po_over_wgt_scg_rt      OUT NUMBER,
                                 po_hzs_scg_rt           OUT NUMBER,
                                 po_ttl_scg_rt           OUT NUMBER,
                                 po_local_curr_tot_amt   OUT NUMBER,
                                 po_usd_curr_tot_amt     OUT NUMBER,
                                 po_wtr_rcv_term_cd      OUT VARCHAR2,
                                 po_wtr_de_term_cd       OUT VARCHAR2,
                                 po_rtn_cd               OUT NUMBER,
                                 po_rtn_msg              OUT VARCHAR2) IS

    C_SYSTEM_INDICATOR  CONSTANT VARCHAR2(3) := 'TRS';
    C_WAY_TYPE_PRIORITY CONSTANT VARCHAR2(15) := 'RND_PRIORITY';

    vo_trsp_agmt_ofc_cty_cd   TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;
    vo_trsp_agmt_seq          TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_ser_no TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;
    vo_trsp_scg_cd            TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;
    vo_trsp_agmt_scg_nod_seq  TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;
    vo_trsp_agmt_scg_rt_seq   TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;
    vo_scg_union_exp          VARCHAR2(100);
    vo_vndr_seq               TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;
    vo_cust_nomi_trkr_flg     TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE;
    vo_cust_cnt_cd            TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    vo_cust_seq               TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_cd     TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;
    vo_way_type               VARCHAR2(3);
    vo_fu_scg_curr_cd         VARCHAR2(3) := '';
    vo_ow_scg_curr_cd         VARCHAR2(3) := '';
    vo_dg_scg_curr_cd         VARCHAR2(3) := '';
    vo_tl_scg_curr_cd         VARCHAR2(3) := '';
    vo_bzc_rt                 NUMBER(18, 3);
    vo_fu_scg_rt              NUMBER(18, 3);
    vo_ow_scg_rt              NUMBER(18, 3);
    vo_dg_scg_rt              NUMBER(18, 3);
    vo_tl_scg_rt              NUMBER(18, 3);
    vo_fu_scg_seq             NUMBER(12);
    vo_ow_scg_seq             NUMBER(12);
    vo_dg_scg_seq             NUMBER(12);
    vo_tl_scg_seq             NUMBER(12);
    vo_wtr_rcv_term_cd        TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;
    vo_wtr_de_term_cd         TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;
    vo_bzc_rtn_cd             NUMBER(5);
    vo_bzc_rtn_msg            VARCHAR2(1000);
    vo_fu_scg_rtn_cd          NUMBER(5);
    vo_ow_scg_rtn_cd          NUMBER(5);
    vo_dg_scg_rtn_cd          NUMBER(5);
    vo_tl_scg_rtn_cd          NUMBER(5);
    vo_fu_scg_rtn_msg         VARCHAR2(1000);
    vo_ow_scg_rtn_msg         VARCHAR2(1000);
    vo_dg_scg_rtn_msg         VARCHAR2(1000);
    vo_tl_scg_rtn_msg         VARCHAR2(1000);
    vo_bzc_curr_cd            VARCHAR2(3);
    vo_trsp_agmt_rt_tp_nm     VARCHAR2(50);

    vo_fuel_com_scg_knd_cd     VARCHAR2(6);
    vo_over_wgt_com_scg_knd_cd VARCHAR2(6);
    vo_hzs_com_scg_knd_cd      VARCHAR2(6);
    vo_ttl_com_scg_knd_cd      VARCHAR2(6);
    vo_fuel_com_scg_seq        NUMBER(12);
    vo_over_wgt_com_scg_seq    NUMBER(12);
    vo_hzs_com_scg_seq         NUMBER(12);
    vo_ttl_com_scg_seq         NUMBER(12);

    v_trsp_so_knd_indicator VARCHAR2(15);
    v_new_rail_svc_tp_cd    VARCHAR2(2);
    v_new_way_tp_cd         VARCHAR2(15);
    v_agmt_eq_knd_cd        VARCHAR2(1);
    v_eq_tare_wgt           NUMBER(18, 3);
    v_eq_tot_wgt            NUMBER(18, 3);
    v_link_cnt              NUMBER(1);
    v_cust_cnt_cd           TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    v_cust_seq              TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    v_basis_dt              DATE;
    v_eq_tp_sz_cd           VARCHAR2(4);
    v_system_indicator         VARCHAR2(3);

    po_return TRS_AGMT_RATE_CC_PKG.RAIL_TYPE1;

  BEGIN

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.ENABLE(1000000);
    END IF;

    v_link_cnt    := TRS_AGMT_RATE_CC_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd,
                                                           pi_via_nod_cd,
                                                           pi_door_nod_cd,
                                                           pi_to_nod_cd);
    v_eq_tare_wgt := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(NVL(pi_wgt_uom,
                                                                     'KGS'),
                                                                 pi_eq_tp_sz_cd);
    v_eq_tot_wgt  := NVL(v_eq_tare_wgt, 0) + NVL(pi_wgt_qty, 0);
    v_basis_dt    := TO_DATE(TO_CHAR(pi_basis_dt, 'YYYYMMDD'), 'YYYYMMDD');

    /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */
    IF pi_cgo_tp_cd = 'M'
        AND (SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'F'
                OR
             SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'A'
                OR
             SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'P') THEN
      v_agmt_eq_knd_cd := 'Z';

    ELSE

      v_agmt_eq_knd_cd := pi_eq_knd_cd;

    END IF;

    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN

      v_trsp_so_knd_indicator := 'USRAIL';
      v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd, 1, 2); /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */

      IF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'O' THEN

        v_new_way_tp_cd := 'ONE'; /* ONE    */

      ELSIF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'R' THEN

        v_new_way_tp_cd := 'RND'; /* RND */

      ELSE

        v_new_way_tp_cd := '';

      END IF;

      v_cust_cnt_cd := 'XX';
      v_cust_seq    := 0;

    ELSE

      v_trsp_so_knd_indicator := 'NONE_USRAIL';
      v_new_way_tp_cd         := '';

      /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
      IF pi_cust_nomi_trkr_flg = 'Y' THEN

        v_cust_cnt_cd := pi_cust_cnt_cd;
        v_cust_seq    := pi_cust_seq;

      ELSE

        v_cust_cnt_cd := 'XX';
        v_cust_seq    := 0;

      END IF;

    END IF;

    /* COMBINED TYPE CODE CONVERSION */
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN

      v_new_way_tp_cd := pi_way_tp_cd;

    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR
          pi_cmb_tp_cd = 'FM' THEN

      v_new_way_tp_cd := C_WAY_TYPE_PRIORITY; /* roundtrip currency priority */

    ELSE

      v_new_way_tp_cd := '';

    END IF;

    /* R Type의 Container의 Special Cargo정보가 'RD'일 경우엔 D Type으로 Rate를 찾는다. */
    IF SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'R' AND pi_spcl_cgo_cd = 'RD' THEN
      v_eq_tp_sz_cd := 'D' || SUBSTR(pi_eq_tp_sz_cd, 2, 1);
    ELSE
      v_eq_tp_sz_cd := pi_eq_tp_sz_cd;
    END IF;

    /* SET   SYSTEM INDICATOR PARAMETER */
    IF pi_system_indicator = 'COA' THEN
        v_system_indicator := pi_system_indicator;
    ELSE
        v_system_indicator := C_SYSTEM_INDICATOR;
    END IF;
  
    /* BASIC RATE CALCULATION */
    GET_BASIC_RATE_CALC_PRC(       v_system_indicator,
                                   v_trsp_so_knd_indicator,
                                   pi_trsp_agmt_ofc_cty_cd,
                                   pi_trsp_agmt_seq,
                                   v_agmt_eq_knd_cd,
                                   v_link_cnt,
                                   pi_ctrl_ofc_cd,
                                   pi_vndr_seq,
                                   v_basis_dt,
                                   v_new_way_tp_cd,
                                   pi_eq_knd_cd,
                                   v_eq_tp_sz_cd,
                                   pi_cmb_tp_cd,
                                   pi_cgo_tp_cd,
                                   pi_bound_cd,
                                   pi_crr_mod_cd,
                                   pi_cost_mod_cd,
                                   v_cust_cnt_cd,
                                   v_cust_seq,
                                   v_new_rail_svc_tp_cd,
                                   pi_cmdt_cd,
                                   pi_from_nod_cd,
                                   pi_via_nod_cd,
                                   pi_door_nod_cd,
                                   pi_to_nod_cd,
                                   pi_bundle_cnt,
                                   pi_wgt_uom,
                                   v_eq_tot_wgt,
                                   pi_rcv_term,
                                   pi_de_term,
                                   'N',
                                   pi_spcl_cgo_cd,
                                   pi_debug_flg,

                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   vo_trsp_agmt_rt_tp_ser_no,
                                   vo_vndr_seq,
                                   vo_cust_nomi_trkr_flg,
                                   vo_cust_cnt_cd,
                                   vo_cust_seq,
                                   vo_trsp_agmt_rt_tp_cd,
                                   vo_way_type,
                                   vo_bzc_curr_cd,
                                   vo_wtr_rcv_term_cd,
                                   vo_wtr_de_term_cd,
                                   vo_bzc_rt,
                                   vo_trsp_agmt_rt_tp_nm,
                                   vo_bzc_rtn_cd,
                                   vo_bzc_rtn_msg);

    IF vo_bzc_rtn_cd = 0 THEN
      IF v_trsp_so_knd_indicator = 'USRAIL' THEN
        -- FUEL SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'FSG',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_fu_scg_curr_cd,
                                   vo_fu_scg_rt,
                                   vo_fu_scg_rtn_cd,
                                   vo_fu_scg_rtn_msg,
                                   po_return);
        -- OVER WEIGHT SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'OWS',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   pi_wgt_uom,
                                   pi_wgt_qty,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_ow_scg_curr_cd,
                                   vo_ow_scg_rt,
                                   vo_ow_scg_rtn_cd,
                                   vo_ow_scg_rtn_msg,
                                   po_return);
        -- HAZMAT SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'HZS',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   pi_spcl_cgo_cd,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_dg_scg_curr_cd,
                                   vo_dg_scg_rt,
                                   vo_dg_scg_rtn_cd,
                                   vo_dg_scg_rtn_msg,
                                   po_return);
        -- ETC TOTAL SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'TTL',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_tl_scg_curr_cd,
                                   vo_tl_scg_rt,
                                   vo_tl_scg_rtn_cd,
                                   vo_tl_scg_rtn_msg,
                                   po_return);
      ELSE
        /* FUEL SURCHARGE RATE CALCULATION */
        GET_SCG_RATE_CALC_PRC(       v_system_indicator,
                                     v_trsp_so_knd_indicator,
                                     'FU',
                                     vo_way_type,
                                     vo_trsp_agmt_ofc_cty_cd,
                                     vo_trsp_agmt_seq,
                                     vo_trsp_agmt_rt_tp_ser_no,
                                     pi_vndr_seq,
                                     v_basis_dt,
                                     pi_eq_knd_cd,
                                     v_eq_tp_sz_cd,
                                     pi_cgo_tp_cd,
                                     pi_bound_cd,
                                     pi_crr_mod_cd,
                                     pi_cost_mod_cd,
                                     pi_from_nod_cd,
                                     pi_via_nod_cd,
                                     pi_door_nod_cd,
                                     pi_to_nod_cd,
                                     pi_bundle_cnt,
                                     NULL,
                                     NULL,
                                     vo_bzc_rt,
                                     vo_bzc_curr_cd,
                                     pi_spcl_cgo_cd,
                                     pi_debug_flg,

                                     vo_scg_union_exp,
                                     vo_trsp_scg_cd,
                                     vo_trsp_agmt_scg_nod_seq,
                                     vo_trsp_agmt_scg_rt_seq,
                                     vo_fu_scg_curr_cd,
                                     vo_fu_scg_rt,
                                     vo_fu_scg_rtn_cd,
                                     vo_fu_scg_rtn_msg);
      END IF;
      po_rtn_cd  := 0;
      po_rtn_msg := 'SUCCESS';
    ELSE
      po_rtn_cd  := vo_bzc_rtn_cd; /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */
      po_rtn_msg := vo_bzc_rtn_msg || ' ________ ' || vo_fu_scg_rtn_msg || ' ________ ' || vo_ow_scg_rtn_msg;
    END IF;

    /* DIFFERENT CURRENCY 체크 */
    IF vo_fu_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_fu_scg_rtn_cd;
      po_rtn_msg := vo_fu_scg_rtn_msg;
    END IF;
    IF vo_ow_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_ow_scg_rtn_cd;
      po_rtn_msg := vo_ow_scg_rtn_msg;
    END IF;
    IF vo_dg_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_dg_scg_rtn_cd;
      po_rtn_msg := vo_dg_scg_rtn_msg;
    END IF;
    IF vo_tl_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_tl_scg_rtn_cd;
      po_rtn_msg := vo_tl_scg_rtn_msg;
    END IF;

    IF po_rtn_cd = 0 THEN
      po_trsp_agmt_ofc_cty_cd := vo_trsp_agmt_ofc_cty_cd;
      po_trsp_agmt_seq        := vo_trsp_agmt_seq;
      po_local_curr_cd        := vo_bzc_curr_cd;

      IF v_trsp_so_knd_indicator = 'USRAIL' THEN
        po_bzc_rt := vo_bzc_rt;
        --po_bzc_rt := vo_bzc_rt + NVL(vo_fu_scg_rt,0) + NVL(vo_ow_scg_rt,0) + NVL(vo_dg_scg_rt,0) + NVL(vo_tl_scg_rt,0);
        po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
        po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
        po_hzs_scg_rt      := NVL(vo_dg_scg_rt, 0);
        po_ttl_scg_rt      := NVL(vo_tl_scg_rt, 0);
      ELSE
        po_bzc_rt          := vo_bzc_rt;
        po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
        po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
      END IF;
      po_cust_nomi_trkr_flg := vo_cust_nomi_trkr_flg;
      po_way_type           := vo_way_type;
      IF vo_cust_nomi_trkr_flg = 'Y' THEN
        po_sp_type := 'CNT';
      ELSE
        /*po_sp_type := 'HJS';*/
        po_sp_type := 'NYK';
      END IF;

      po_local_curr_tot_amt := vo_bzc_rt + NVL(vo_fu_scg_rt, 0) +
                               NVL(vo_ow_scg_rt, 0) + NVL(vo_dg_scg_rt, 0) +
                               NVL(vo_tl_scg_rt, 0);
      po_cust_cnt_cd        := vo_cust_cnt_cd;
      po_cust_seq           := vo_cust_seq;
      po_trsp_agmt_rt_tp_cd := vo_trsp_agmt_rt_tp_cd;
      po_way_type           := vo_way_type;
      po_trsp_agmt_rt_tp_nm := vo_trsp_agmt_rt_tp_nm;
      po_cust_cnt_cd        := vo_cust_cnt_cd;
      po_cust_seq           := vo_cust_seq;
      po_local_curr_cd      := vo_bzc_curr_cd;
      po_wtr_rcv_term_cd    := vo_wtr_rcv_term_cd;
      po_wtr_de_term_cd     := vo_wtr_de_term_cd;

      /* TOTAL AMOUNT - USD CURRENCY   */
      IF po_local_curr_tot_amt > 0 THEN
        po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(vo_bzc_curr_cd, po_local_curr_tot_amt);
      END IF;

      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('============ Calc Parameter ===============');
        DBMS_OUTPUT.PUT_LINE('v_link_cnt :' || v_link_cnt);
        DBMS_OUTPUT.PUT_LINE('v_eq_tare_wgt :' || v_eq_tare_wgt);
        DBMS_OUTPUT.PUT_LINE('============ Retrun Parameter ===============');
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_ofc_cty_cd :' || po_trsp_agmt_ofc_cty_cd);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_seq        :' || po_trsp_agmt_seq);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_cd   :' || po_trsp_agmt_rt_tp_cd);
        DBMS_OUTPUT.PUT_LINE('po_way_type             :' || po_way_type);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_nm   :' || po_trsp_agmt_rt_tp_nm);
        DBMS_OUTPUT.PUT_LINE('po_sp_type              :' || po_sp_type);
        DBMS_OUTPUT.PUT_LINE('po_cust_nomi_trkr_flg   :' || po_cust_nomi_trkr_flg);
        DBMS_OUTPUT.PUT_LINE('po_cust_cnt_cd          :' || po_cust_cnt_cd);
        DBMS_OUTPUT.PUT_LINE('po_cust_seq             :' || po_cust_seq);
        DBMS_OUTPUT.PUT_LINE('po_local_curr_cd        :' || po_local_curr_cd);
        DBMS_OUTPUT.PUT_LINE('po_bzc_rt               :' || po_bzc_rt);
        DBMS_OUTPUT.PUT_LINE('po_fuel_scg_rt          :' || po_fuel_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_over_wgt_scg_rt      :' || po_over_wgt_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_hzs_scg_rt           :' || po_hzs_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_ttl_scg_rt           :' || po_ttl_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_local_curr_tot_amt   :' || po_local_curr_tot_amt);
        DBMS_OUTPUT.PUT_LINE('po_usd_curr_tot_amt     :' || po_usd_curr_tot_amt);
        DBMS_OUTPUT.PUT_LINE('po_wtr_rcv_term_cd      :' || po_wtr_rcv_term_cd);
        DBMS_OUTPUT.PUT_LINE('po_wtr_de_term_cd       :' || po_wtr_de_term_cd);
      END IF;

    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      po_rtn_cd := -1;
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_TRS_ALL_RATE_PRC <OTHERS> ERROR MSG = [' || SQLERRM || ']');
      END IF;
  END GET_TRS_ALL_RATE_PRC;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : KIM SEONG WOOK
  # -- Created : AUG 10, 2015
  # -- Table   : TRS_AGMT_*
  # -- Purpose : ALL RATE COMBINATION FOR TRS US RAIL S/O
  #####################################################################*/
  PROCEDURE GET_USRAIL_ALL_RATE_PRC(pi_ctrl_ofc_cd          IN VARCHAR2,
                                    pi_vndr_seq             IN VARCHAR2,
                                    pi_basis_dt             IN DATE,
                                    pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                    pi_eq_knd_cd            IN VARCHAR2,
                                    pi_eq_tp_sz_cd          IN VARCHAR2,
                                    pi_cmb_tp_cd            IN VARCHAR2,
                                    pi_cgo_tp_cd            IN VARCHAR2,
                                    pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                    pi_crr_mod_cd           IN VARCHAR2,
                                    pi_cost_mod_cd          IN VARCHAR2,
                                    pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                    pi_cust_cnt_cd          IN VARCHAR2,
                                    pi_cust_seq             IN NUMBER,
                                    pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                    pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                    pi_from_nod_cd          IN VARCHAR2,
                                    pi_via_nod_cd           IN VARCHAR2,
                                    pi_door_nod_cd          IN VARCHAR2,
                                    pi_to_nod_cd            IN VARCHAR2,
                                    pi_bundle_cnt           IN NUMBER,
                                    pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                    pi_wgt_qty              IN NUMBER,
                                    pi_tare_wgt_uom         IN VARCHAR2 DEFAULT 'L', /* L-LBS, K-KG */
                                    pi_tare_wgt_qty         IN NUMBER  DEFAULT 0,
                                    pi_rcv_term             IN VARCHAR2,
                                    pi_de_term              IN VARCHAR2,
                                    pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                    pi_trsp_agmt_seq        IN NUMBER,
                                    pi_spcl_cgo_cd          IN VARCHAR2,
                                    pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITEDBMS LOG)
                                    /* OUT PARAMETER */
                                    po_trsp_agmt_ofc_cty_cd OUT VARCHAR2,
                                    po_trsp_agmt_seq        OUT NUMBER,
                                    po_trsp_agmt_rt_tp_cd   OUT VARCHAR2,
                                    po_way_type             OUT VARCHAR2,
                                    po_trsp_agmt_rt_tp_nm   OUT VARCHAR2,
                                    po_sp_type              OUT VARCHAR2,
                                    po_cust_nomi_trkr_flg   OUT VARCHAR2,
                                    po_cust_cnt_cd          OUT VARCHAR2,
                                    po_cust_seq             OUT NUMBER,
                                    po_local_curr_cd        OUT VARCHAR2,
                                    po_bzc_rt               OUT NUMBER,
                                    po_fuel_scg_rt          OUT NUMBER,
                                    po_over_wgt_scg_rt      OUT NUMBER,
                                    po_hzs_scg_rt           OUT NUMBER,
                                    po_ttl_scg_rt           OUT NUMBER,
                                    po_local_curr_tot_amt   OUT NUMBER,
                                    po_usd_curr_tot_amt     OUT NUMBER,
                                    po_wtr_rcv_term_cd      OUT VARCHAR2,
                                    po_wtr_de_term_cd       OUT VARCHAR2,
                                    po_rtn_cd               OUT NUMBER,
                                    po_rtn_msg              OUT VARCHAR2,
                                    po_fuel_scg             OUT VARCHAR2,
                                    po_over_wgt_scg         OUT VARCHAR2,
                                    po_hzs_scg              OUT VARCHAR2,
                                    po_ttl_scg              OUT VARCHAR2) IS

    C_SYSTEM_INDICATOR  CONSTANT VARCHAR2(3) := 'TRS';
    C_WAY_TYPE_PRIORITY CONSTANT VARCHAR2(15) := 'RND_PRIORITY';

    vo_trsp_agmt_ofc_cty_cd   TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;
    vo_trsp_agmt_seq          TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_ser_no TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;
    vo_trsp_scg_cd            TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;
    vo_trsp_agmt_scg_nod_seq  TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;
    vo_trsp_agmt_scg_rt_seq   TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;
    vo_scg_union_exp          VARCHAR2(100);
    vo_vndr_seq               TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;
    vo_cust_nomi_trkr_flg     TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE;
    vo_cust_cnt_cd            TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    vo_cust_seq               TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_cd     TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;
    vo_way_type               VARCHAR2(3);
    vo_fu_scg_curr_cd         VARCHAR2(3) := '';
    vo_ow_scg_curr_cd         VARCHAR2(3) := '';
    vo_dg_scg_curr_cd         VARCHAR2(3) := '';
    vo_tl_scg_curr_cd         VARCHAR2(3) := '';
    vo_bzc_rt                 NUMBER(18, 3);
    vo_fu_scg_rt              NUMBER(18, 3);
    vo_ow_scg_rt              NUMBER(18, 3);
    vo_dg_scg_rt              NUMBER(18, 3);
    vo_tl_scg_rt              NUMBER(18, 3);
    vo_wtr_rcv_term_cd        TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;
    vo_wtr_de_term_cd         TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;
    vo_bzc_rtn_cd             NUMBER(5);
    vo_bzc_rtn_msg            VARCHAR2(1000);
    vo_fu_scg_rtn_cd          NUMBER(5);
    vo_ow_scg_rtn_cd          NUMBER(5);
    vo_dg_scg_rtn_cd          NUMBER(5);
    vo_tl_scg_rtn_cd          NUMBER(5);
    vo_fu_scg_rtn_msg         VARCHAR2(1000);
    vo_ow_scg_rtn_msg         VARCHAR2(1000);
    vo_dg_scg_rtn_msg         VARCHAR2(1000);
    vo_tl_scg_rtn_msg         VARCHAR2(1000);
    vo_bzc_curr_cd            VARCHAR2(3);
    vo_trsp_agmt_rt_tp_nm     VARCHAR2(50);
    vo_fuel_scg_seq           NUMBER(12);
    vo_over_wgt_scg_seq       NUMBER(12);
    vo_hzs_scg_seq            NUMBER(12);
    vo_ttl_scg_seq            NUMBER(12);

    vo_fuel_com_scg_knd_cd     VARCHAR2(6);
    vo_over_wgt_com_scg_knd_cd VARCHAR2(6);
    vo_hzs_com_scg_knd_cd      VARCHAR2(6);
    vo_ttl_com_scg_knd_cd      VARCHAR2(6);
    vo_fuel_com_scg_seq        NUMBER(12);
    vo_over_wgt_com_scg_seq    NUMBER(12);
    vo_hzs_com_scg_seq         NUMBER(12);
    vo_ttl_com_scg_seq         NUMBER(12);

    v_trsp_so_knd_indicator VARCHAR2(15);
    v_new_rail_svc_tp_cd    VARCHAR2(2);
    v_new_way_tp_cd         VARCHAR2(15);
    v_agmt_eq_knd_cd        VARCHAR2(1);
    v_eq_tare_wgt           NUMBER(18, 3);
    v_eq_tot_wgt            NUMBER(18, 3);
    v_link_cnt              NUMBER(1);
    v_cust_cnt_cd           TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    v_cust_seq              TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    v_basis_dt              DATE;
    v_eq_tp_sz_cd           VARCHAR2(4);

    po_return_fsg RAIL_TYPE1;
    po_return_ows RAIL_TYPE1;
    po_return_hzs RAIL_TYPE1;
    po_return_ttl RAIL_TYPE1;

    vo_fuel_scg           VARCHAR2(4000);
    vo_over_wgt_scg       VARCHAR2(4000);
    vo_hzs_scg            VARCHAR2(4000);
    vo_ttl_scg            VARCHAR2(4000);

    po_fuel_scg_seq            NUMBER;
    po_over_wgt_scg_seq        NUMBER;
    po_hzs_scg_seq             NUMBER;
    po_ttl_scg_seq             NUMBER;
    po_fuel_com_scg_knd_cd     VARCHAR2(10);
    po_over_wgt_com_scg_knd_cd VARCHAR2(10);
    po_hzs_com_scg_knd_cd      VARCHAR2(10);
    po_ttl_com_scg_knd_cd      VARCHAR2(10);
    po_fuel_com_scg_seq        NUMBER;
    po_over_wgt_com_scg_seq    NUMBER;
    po_hzs_com_scg_seq         NUMBER;
    po_ttl_com_scg_seq         NUMBER;

  BEGIN

    IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.ENABLE(1000000);
    END IF;

    v_link_cnt    := TRS_AGMT_RATE_CC_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);
    
    
    IF NVL(pi_tare_wgt_qty, 0) = 0 THEN 
       v_eq_tare_wgt := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(NVL(pi_wgt_uom, 'KGS'), pi_eq_tp_sz_cd);
    ELSE
       v_eq_tare_wgt := pi_tare_wgt_qty;
    END IF;
    
    v_eq_tot_wgt  := NVL(v_eq_tare_wgt, 0) + NVL(pi_wgt_qty, 0);
    v_basis_dt    := TO_DATE(TO_CHAR(pi_basis_dt, 'YYYYMMDD'), 'YYYYMMDD');

    /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */
    IF pi_cgo_tp_cd = 'M' AND (   SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'F'
                               OR SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'A'
                               OR SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'P') THEN
        v_agmt_eq_knd_cd := 'Z';
    ELSE
        v_agmt_eq_knd_cd := pi_eq_knd_cd;
    END IF;

    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
        v_trsp_so_knd_indicator := 'USRAIL';
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd, 1, 2);  /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */

        IF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'O' THEN
            v_new_way_tp_cd := 'ONE'; /* ONE    */
        ELSIF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'R' THEN
            v_new_way_tp_cd := 'RND'; /* RND */
        ELSE
            v_new_way_tp_cd := '';
        END IF;

        v_cust_cnt_cd := 'XX';
        v_cust_seq    := 0;
    ELSE
        v_trsp_so_knd_indicator := 'NONE_USRAIL';
        v_new_way_tp_cd         := '';

        /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
        IF pi_cust_nomi_trkr_flg = 'Y' THEN
            v_cust_cnt_cd := pi_cust_cnt_cd;
            v_cust_seq    := pi_cust_seq;
        ELSE
            v_cust_cnt_cd := 'XX';
            v_cust_seq    := 0;
        END IF;
    END IF;


    IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('============ CHECK PARAMETER ===============');
        DBMS_OUTPUT.PUT_LINE('v_trsp_so_knd_indicator :' || v_trsp_so_knd_indicator);
        DBMS_OUTPUT.PUT_LINE('============ CHECK PARAMETER ===============');
    END IF;


    /* COMBINED TYPE CODE CONVERSION */
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN
        v_new_way_tp_cd := pi_way_tp_cd;
    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR pi_cmb_tp_cd = 'FM' THEN
        v_new_way_tp_cd := C_WAY_TYPE_PRIORITY; /* roundtrip currency priority */
    ELSE
        v_new_way_tp_cd := '';
    END IF;

    /* R Type의 Container의 Special Cargo정보가 'RD'일 경우엔 D Type으로 Rate를 찾는다. */
    IF SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'R' AND pi_spcl_cgo_cd = 'RD' THEN
        v_eq_tp_sz_cd := 'D' || SUBSTR(pi_eq_tp_sz_cd, 2, 1);
    ELSE
        v_eq_tp_sz_cd := pi_eq_tp_sz_cd;
    END IF;

    /* BASIC RATE CALCULATION */
    GET_BASIC_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                   v_trsp_so_knd_indicator,
                                   pi_trsp_agmt_ofc_cty_cd,
                                   pi_trsp_agmt_seq,
                                   v_agmt_eq_knd_cd,
                                   v_link_cnt,
                                   pi_ctrl_ofc_cd,
                                   pi_vndr_seq,
                                   v_basis_dt,
                                   v_new_way_tp_cd,
                                   pi_eq_knd_cd,
                                   v_eq_tp_sz_cd,
                                   pi_cmb_tp_cd,
                                   pi_cgo_tp_cd,
                                   pi_bound_cd,
                                   pi_crr_mod_cd,
                                   pi_cost_mod_cd,
                                   v_cust_cnt_cd,
                                   v_cust_seq,
                                   v_new_rail_svc_tp_cd,
                                   pi_cmdt_cd,
                                   pi_from_nod_cd,
                                   pi_via_nod_cd,
                                   pi_door_nod_cd,
                                   pi_to_nod_cd,
                                   pi_bundle_cnt,
                                   pi_wgt_uom,
                                   v_eq_tot_wgt,
                                   pi_rcv_term,
                                   pi_de_term,
                                   'N',
                                   pi_spcl_cgo_cd,
                                   pi_debug_flg,

                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   vo_trsp_agmt_rt_tp_ser_no,
                                   vo_vndr_seq,
                                   vo_cust_nomi_trkr_flg,
                                   vo_cust_cnt_cd,
                                   vo_cust_seq,
                                   vo_trsp_agmt_rt_tp_cd,
                                   vo_way_type,
                                   vo_bzc_curr_cd,
                                   vo_wtr_rcv_term_cd,
                                   vo_wtr_de_term_cd,
                                   vo_bzc_rt,
                                   vo_trsp_agmt_rt_tp_nm,
                                   vo_bzc_rtn_cd,
                                   vo_bzc_rtn_msg);

    IF vo_bzc_rtn_cd = 0 THEN
        IF v_trsp_so_knd_indicator = 'USRAIL' THEN
            -- FUEL SURCHARGE
            GET_RAIL_SCG_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                       v_eq_tp_sz_cd,
                                       pi_vndr_seq,
                                       vo_trsp_agmt_ofc_cty_cd,
                                       vo_trsp_agmt_seq,
                                       'FSG',
                                       pi_cgo_tp_cd,
                                       pi_from_nod_cd,
                                       pi_to_nod_cd,
                                       NULL,
                                       NULL,
                                       v_basis_dt,
                                       NULL,
                                       vo_bzc_curr_cd,
                                       vo_bzc_rt,
                                       pi_bound_cd,
                                       pi_debug_flg,
                                       vo_fu_scg_curr_cd,
                                       vo_fu_scg_rt,
                                       vo_fu_scg_rtn_cd,
                                       vo_fu_scg_rtn_msg,
                                       po_return_fsg);

            -- OVER WEIGHT SURCHARGE
            GET_RAIL_SCG_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                       v_eq_tp_sz_cd,
                                       pi_vndr_seq,
                                       vo_trsp_agmt_ofc_cty_cd,
                                       vo_trsp_agmt_seq,
                                       'OWS',
                                       pi_cgo_tp_cd,
                                       pi_from_nod_cd,
                                       pi_to_nod_cd,
                                       pi_wgt_uom,
                                       pi_wgt_qty,
                                       v_basis_dt,
                                       NULL,
                                       vo_bzc_curr_cd,
                                       vo_bzc_rt,
                                       pi_bound_cd,
                                       pi_debug_flg,
                                       vo_ow_scg_curr_cd,
                                       vo_ow_scg_rt,
                                       vo_ow_scg_rtn_cd,
                                       vo_ow_scg_rtn_msg,
                                       po_return_ows);

            -- HAZMAT SURCHARGE
            GET_RAIL_SCG_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                       v_eq_tp_sz_cd,
                                       pi_vndr_seq,
                                       vo_trsp_agmt_ofc_cty_cd,
                                       vo_trsp_agmt_seq,
                                       'HZS',
                                       pi_cgo_tp_cd,
                                       pi_from_nod_cd,
                                       pi_to_nod_cd,
                                       NULL,
                                       NULL,
                                       v_basis_dt,
                                       pi_spcl_cgo_cd,
                                       vo_bzc_curr_cd,
                                       vo_bzc_rt,
                                       pi_bound_cd,
                                       pi_debug_flg,
                                       vo_dg_scg_curr_cd,
                                       vo_dg_scg_rt,
                                       vo_dg_scg_rtn_cd,
                                       vo_dg_scg_rtn_msg,
                                       po_return_hzs);

            -- ETC TOTAL SURCHARGE
            GET_RAIL_SCG_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                       v_eq_tp_sz_cd,
                                       pi_vndr_seq,
                                       vo_trsp_agmt_ofc_cty_cd,
                                       vo_trsp_agmt_seq,
                                       'TTL',
                                       pi_cgo_tp_cd,
                                       pi_from_nod_cd,
                                       pi_to_nod_cd,
                                       NULL,
                                       NULL,
                                       v_basis_dt,
                                       NULL,
                                       vo_bzc_curr_cd,
                                       vo_bzc_rt,
                                       pi_bound_cd,
                                       pi_debug_flg,
                                       vo_tl_scg_curr_cd,
                                       vo_tl_scg_rt,
                                       vo_tl_scg_rtn_cd,
                                       vo_tl_scg_rtn_msg,
                                       po_return_ttl);

        ELSE
            /* FUEL SURCHARGE RATE CALCULATION */
            GET_SCG_RATE_CALC_PRC(C_SYSTEM_INDICATOR,
                                         v_trsp_so_knd_indicator,
                                         'FU',
                                         vo_way_type,
                                         vo_trsp_agmt_ofc_cty_cd,
                                         vo_trsp_agmt_seq,
                                         vo_trsp_agmt_rt_tp_ser_no,
                                         pi_vndr_seq,
                                         v_basis_dt,
                                         pi_eq_knd_cd,
                                         v_eq_tp_sz_cd,
                                         pi_cgo_tp_cd,
                                         pi_bound_cd,
                                         pi_crr_mod_cd,
                                         pi_cost_mod_cd,
                                         pi_from_nod_cd,
                                         pi_via_nod_cd,
                                         pi_door_nod_cd,
                                         pi_to_nod_cd,
                                         pi_bundle_cnt,
                                         NULL,
                                         NULL,
                                         vo_bzc_rt,
                                         vo_bzc_curr_cd,
                                         pi_spcl_cgo_cd,
                                         pi_debug_flg,

                                         vo_scg_union_exp,
                                         vo_trsp_scg_cd,
                                         vo_trsp_agmt_scg_nod_seq,
                                         vo_trsp_agmt_scg_rt_seq,
                                         vo_fu_scg_curr_cd,
                                         vo_fu_scg_rt,
                                         vo_fu_scg_rtn_cd,
                                         vo_fu_scg_rtn_msg);
        END IF;
        po_rtn_cd  := 0;
        po_rtn_msg := 'SUCCESS';
    ELSE
        po_rtn_cd  := vo_bzc_rtn_cd; /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */
        po_rtn_msg := vo_bzc_rtn_msg || ' ________ ' || vo_fu_scg_rtn_msg || ' ________ ' || vo_ow_scg_rtn_msg;
    END IF;

    /* DIFFERENT CURRENCY 체크 */
    IF vo_fu_scg_rtn_cd < -100 THEN
        po_rtn_cd  := vo_fu_scg_rtn_cd;
        po_rtn_msg := vo_fu_scg_rtn_msg;
    END IF;
    IF vo_ow_scg_rtn_cd < -100 THEN
        po_rtn_cd  := vo_ow_scg_rtn_cd;
        po_rtn_msg := vo_ow_scg_rtn_msg;
    END IF;
    IF vo_dg_scg_rtn_cd < -100 THEN
        po_rtn_cd  := vo_dg_scg_rtn_cd;
        po_rtn_msg := vo_dg_scg_rtn_msg;
    END IF;
    IF vo_tl_scg_rtn_cd < -100 THEN
        po_rtn_cd  := vo_tl_scg_rtn_cd;
        po_rtn_msg := vo_tl_scg_rtn_msg;
    END IF;

    IF po_rtn_cd = 0 THEN
        po_trsp_agmt_ofc_cty_cd := vo_trsp_agmt_ofc_cty_cd;
        po_trsp_agmt_seq        := vo_trsp_agmt_seq;
        po_local_curr_cd        := vo_bzc_curr_cd;

        IF v_trsp_so_knd_indicator = 'USRAIL' THEN
            po_bzc_rt := vo_bzc_rt;
            po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
            po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
            po_hzs_scg_rt      := NVL(vo_dg_scg_rt, 0);
            po_ttl_scg_rt      := NVL(vo_tl_scg_rt, 0);
            IF po_return_fsg.COUNT > 0 THEN
                For i IN po_return_fsg.First .. po_return_fsg.Last Loop
                    IF i > 1 THEN
                        po_fuel_scg := po_fuel_scg || '|';
                    END IF;
                    po_fuel_scg := po_fuel_scg || po_return_fsg(i).PO_RAIL_CURR_CD || '^' ||
                                                 po_return_fsg(i).PO_RAIL_SCG_RT || '^' ||
                                                 po_return_fsg(i).PO_RAIL_SCG_SEQ || '^' ||
                                                 po_return_fsg(i).PO_COM_SCG_KND_CD || '^' ||
                                                 po_return_fsg(i).PO_COM_SCG_SEQ;
                End Loop;
            END IF;

            IF po_return_ows.COUNT > 0 THEN
                For i IN po_return_ows.First .. po_return_ows.Last Loop
                    IF i > 1 THEN
                        po_over_wgt_scg := po_over_wgt_scg || '|';
                    END IF;
                    po_over_wgt_scg := po_over_wgt_scg || po_return_ows(i).PO_RAIL_CURR_CD || '^' ||
                                                         po_return_ows(i).PO_RAIL_SCG_RT || '^' ||
                                                         po_return_ows(i).PO_RAIL_SCG_SEQ || '^' ||
                                                         po_return_ows(i).PO_COM_SCG_KND_CD || '^' ||
                                                         po_return_ows(i).PO_COM_SCG_SEQ;
                End Loop;
            END IF;

            IF po_return_hzs.COUNT > 0 THEN
                For i IN po_return_hzs.First .. po_return_hzs.Last Loop
                    IF i > 1 THEN
                        po_hzs_scg := po_hzs_scg || '|';
                    END IF;
                    po_hzs_scg := po_hzs_scg || po_return_hzs(i).PO_RAIL_CURR_CD || '^' ||
                                               po_return_hzs(i).PO_RAIL_SCG_RT || '^' ||
                                               po_return_hzs(i).PO_RAIL_SCG_SEQ || '^' ||
                                               po_return_hzs(i).PO_COM_SCG_KND_CD || '^' ||
                                               po_return_hzs(i).PO_COM_SCG_SEQ;
                End Loop;
            END IF;

            IF po_return_ttl.COUNT > 0 THEN
                For i IN po_return_ttl.First .. po_return_ttl.Last Loop
                    IF i > 1 THEN
                        po_ttl_scg := po_ttl_scg || '|';
                    END IF;
                    po_ttl_scg := po_ttl_scg || po_return_ttl(i).PO_RAIL_CURR_CD || '^' ||
                                               po_return_ttl(i).PO_RAIL_SCG_RT || '^' ||
                                               po_return_ttl(i).PO_RAIL_SCG_SEQ || '^' ||
                                               po_return_ttl(i).PO_COM_SCG_KND_CD || '^' ||
                                               po_return_ttl(i).PO_COM_SCG_SEQ;
                End Loop;
            END IF;

        ELSE
            po_bzc_rt          := vo_bzc_rt;
            po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
            po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
        END IF;

        po_cust_nomi_trkr_flg := vo_cust_nomi_trkr_flg;
        po_way_type           := vo_way_type;

        IF vo_cust_nomi_trkr_flg = 'Y' THEN
            po_sp_type := 'CNT';
        ELSE
            po_sp_type := 'NYK';
        END IF;

        po_local_curr_tot_amt := vo_bzc_rt + NVL(vo_fu_scg_rt, 0) +
                               NVL(vo_ow_scg_rt, 0) + NVL(vo_dg_scg_rt, 0) +
                               NVL(vo_tl_scg_rt, 0);
        po_cust_cnt_cd        := vo_cust_cnt_cd;
        po_cust_seq           := vo_cust_seq;
        po_trsp_agmt_rt_tp_cd := vo_trsp_agmt_rt_tp_cd;
        po_way_type           := vo_way_type;
        po_trsp_agmt_rt_tp_nm := vo_trsp_agmt_rt_tp_nm;
        po_cust_cnt_cd        := vo_cust_cnt_cd;
        po_cust_seq           := vo_cust_seq;
        po_local_curr_cd      := vo_bzc_curr_cd;
        po_wtr_rcv_term_cd    := vo_wtr_rcv_term_cd;
        po_wtr_de_term_cd     := vo_wtr_de_term_cd;

        /* TOTAL AMOUNT - USD CURRENCY   */
        IF po_local_curr_tot_amt > 0 THEN
            po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(vo_bzc_curr_cd, po_local_curr_tot_amt);
        END IF;

        IF pi_debug_flg = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('');
            DBMS_OUTPUT.PUT_LINE('============ Calc Parameter ===============');
            DBMS_OUTPUT.PUT_LINE('v_link_cnt :' || v_link_cnt);
            DBMS_OUTPUT.PUT_LINE('v_eq_tare_wgt :' || v_eq_tare_wgt);
            DBMS_OUTPUT.PUT_LINE('============ Retrun Parameter ===============');
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_ofc_cty_cd :' || po_trsp_agmt_ofc_cty_cd);
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_seq        :' || po_trsp_agmt_seq);
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_cd   :' || po_trsp_agmt_rt_tp_cd);
            DBMS_OUTPUT.PUT_LINE('po_way_type             :' || po_way_type);
            DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_nm   :' || po_trsp_agmt_rt_tp_nm);
            DBMS_OUTPUT.PUT_LINE('po_sp_type              :' || po_sp_type);
            DBMS_OUTPUT.PUT_LINE('po_cust_nomi_trkr_flg   :' || po_cust_nomi_trkr_flg);
            DBMS_OUTPUT.PUT_LINE('po_cust_cnt_cd          :' || po_cust_cnt_cd);
            DBMS_OUTPUT.PUT_LINE('po_cust_seq             :' || po_cust_seq);
            DBMS_OUTPUT.PUT_LINE('po_local_curr_cd        :' || po_local_curr_cd);
            DBMS_OUTPUT.PUT_LINE('po_bzc_rt               :' || po_bzc_rt);
            DBMS_OUTPUT.PUT_LINE('po_fuel_scg_rt          :' || po_fuel_scg_rt);
            DBMS_OUTPUT.PUT_LINE('po_over_wgt_scg_rt      :' || po_over_wgt_scg_rt);
            DBMS_OUTPUT.PUT_LINE('po_hzs_scg_rt           :' || po_hzs_scg_rt);
            DBMS_OUTPUT.PUT_LINE('po_ttl_scg_rt           :' || po_ttl_scg_rt);
            DBMS_OUTPUT.PUT_LINE('po_fuel_scg_seq         :' || po_fuel_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_over_wgt_scg_seq     :' || po_over_wgt_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_hzs_scg_seq          :' || po_hzs_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_ttl_scg_seq          :' || po_ttl_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_local_curr_tot_amt   :' || po_local_curr_tot_amt);
            DBMS_OUTPUT.PUT_LINE('po_usd_curr_tot_amt     :' || po_usd_curr_tot_amt);
            DBMS_OUTPUT.PUT_LINE('po_wtr_rcv_term_cd      :' || po_wtr_rcv_term_cd);
            DBMS_OUTPUT.PUT_LINE('po_wtr_de_term_cd       :' || po_wtr_de_term_cd);

            DBMS_OUTPUT.PUT_LINE('po_fuel_com_scg_knd_cd      :' || po_fuel_com_scg_knd_cd);
            DBMS_OUTPUT.PUT_LINE('po_over_wgt_com_scg_knd_cd  :' || po_over_wgt_com_scg_knd_cd);
            DBMS_OUTPUT.PUT_LINE('po_hzs_com_scg_knd_cd       :' || po_hzs_com_scg_knd_cd);
            DBMS_OUTPUT.PUT_LINE('po_ttl_com_scg_knd_cd       :' || po_ttl_com_scg_knd_cd);
            DBMS_OUTPUT.PUT_LINE('po_fuel_com_scg_seq         :' || po_fuel_com_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_over_wgt_com_scg_seq     :' || po_over_wgt_com_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_hzs_com_scg_seq          :' || po_hzs_com_scg_seq);
            DBMS_OUTPUT.PUT_LINE('po_ttl_com_scg_seq          :' || po_ttl_com_scg_seq);
        END IF;

    END IF;
  EXCEPTION
    WHEN OTHERS THEN
        po_rtn_cd := -1;
        IF pi_debug_flg = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('GET_USRAIL_ALL_RATE_PRC <OTHERS> ERROR MSG = [' || SQLERRM || ']');
        END IF;
  END GET_USRAIL_ALL_RATE_PRC;

  /*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : KIM SEONG WOOK
  # -- Created : AUG 26, 2016
  # -- Table   : TRS_AGMT_*
  # -- Purpose : TRS ALL RATE COMBINATION FOR COA
  #####################################################################*/
  PROCEDURE GET_RATE_FOR_COA_PRC(pi_system_indicator     IN VARCHAR2, /* TRS, COA */
                                 pi_ctrl_ofc_cd          IN VARCHAR2,
                                 pi_vndr_seq             IN VARCHAR2,
                                 pi_basis_dt             IN DATE,
                                 pi_way_tp_cd            IN VARCHAR2, /* 'ONE' or 'RND'      */
                                 pi_eq_knd_cd            IN VARCHAR2,
                                 pi_eq_tp_sz_cd          IN VARCHAR2,
                                 pi_cmb_tp_cd            IN VARCHAR2,
                                 pi_cgo_tp_cd            IN VARCHAR2,
                                 pi_bound_cd             IN VARCHAR2, /* OPTIONAL - IN/OUT BOUND */
                                 pi_crr_mod_cd           IN VARCHAR2,
                                 pi_cost_mod_cd          IN VARCHAR2,
                                 pi_cust_nomi_trkr_flg   IN VARCHAR2,
                                 pi_cust_cnt_cd          IN VARCHAR2,
                                 pi_cust_seq             IN NUMBER,
                                 pi_rail_svc_tp_cd       IN VARCHAR2, /* OPTIONAL */
                                 pi_cmdt_cd              IN VARCHAR2, /* OPTIONAL */
                                 pi_from_nod_cd          IN VARCHAR2,
                                 pi_via_nod_cd           IN VARCHAR2,
                                 pi_door_nod_cd          IN VARCHAR2,
                                 pi_to_nod_cd            IN VARCHAR2,
                                 pi_bundle_cnt           IN NUMBER,
                                 pi_wgt_uom              IN VARCHAR2, /* L-LBS, K-KG */
                                 pi_wgt_qty              IN NUMBER,
                                 pi_rcv_term             IN VARCHAR2,
                                 pi_de_term              IN VARCHAR2,
                                 pi_trsp_agmt_ofc_cty_cd IN VARCHAR2,
                                 pi_trsp_agmt_seq        IN NUMBER,
                                 pi_spcl_cgo_cd          IN VARCHAR2,
                                 pi_coa_cost_src_cd      IN VARCHAR2, -- COA_COST_SRC_CD
                                 pi_debug_flg            IN VARCHAR2, -- Debug Flag ('Y' : WRITEDBMS LOG)
                                 /* OUT PARAMETER */
                                 po_trsp_agmt_ofc_cty_cd OUT VARCHAR2,
                                 po_trsp_agmt_seq        OUT NUMBER,
                                 po_trsp_agmt_rt_tp_cd   OUT VARCHAR2,
                                 po_way_type             OUT VARCHAR2,
                                 po_trsp_agmt_rt_tp_nm   OUT VARCHAR2,
                                 po_sp_type              OUT VARCHAR2,
                                 po_cust_nomi_trkr_flg   OUT VARCHAR2,
                                 po_cust_cnt_cd          OUT VARCHAR2,
                                 po_cust_seq             OUT NUMBER,
                                 po_local_curr_cd        OUT VARCHAR2,
                                 po_bzc_rt               OUT NUMBER,
                                 po_fuel_scg_rt          OUT NUMBER,
                                 po_over_wgt_scg_rt      OUT NUMBER,
                                 po_hzs_scg_rt           OUT NUMBER,
                                 po_ttl_scg_rt           OUT NUMBER,
                                 po_local_curr_tot_amt   OUT NUMBER,
                                 po_usd_curr_tot_amt     OUT NUMBER,
                                 po_wtr_rcv_term_cd      OUT VARCHAR2,
                                 po_wtr_de_term_cd       OUT VARCHAR2,
                                 po_rtn_cd               OUT NUMBER,
                                 po_rtn_msg              OUT VARCHAR2) IS

    C_SYSTEM_INDICATOR  CONSTANT VARCHAR2(3) := 'TRS';
    C_WAY_TYPE_PRIORITY CONSTANT VARCHAR2(15) := 'RND_PRIORITY';

    vo_trsp_agmt_ofc_cty_cd   TRS_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE;
    vo_trsp_agmt_seq          TRS_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_ser_no TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE;
    vo_trsp_scg_cd            TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;
    vo_trsp_agmt_scg_nod_seq  TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;
    vo_trsp_agmt_scg_rt_seq   TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;
    vo_scg_union_exp          VARCHAR2(100);
    vo_vndr_seq               TRS_AGMT_APLY_VNDR.VNDR_SEQ%TYPE;
    vo_cust_nomi_trkr_flg     TRS_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE;
    vo_cust_cnt_cd            TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    vo_cust_seq               TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    vo_trsp_agmt_rt_tp_cd     TRS_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE;
    vo_way_type               VARCHAR2(3);
    vo_fu_scg_curr_cd         VARCHAR2(3) := '';
    vo_ow_scg_curr_cd         VARCHAR2(3) := '';
    vo_dg_scg_curr_cd         VARCHAR2(3) := '';
    vo_tl_scg_curr_cd         VARCHAR2(3) := '';
    vo_bzc_rt                 NUMBER(18, 3);
    vo_fu_scg_rt              NUMBER(18, 3);
    vo_ow_scg_rt              NUMBER(18, 3);
    vo_dg_scg_rt              NUMBER(18, 3);
    vo_tl_scg_rt              NUMBER(18, 3);
    vo_fu_scg_seq             NUMBER(12);
    vo_ow_scg_seq             NUMBER(12);
    vo_dg_scg_seq             NUMBER(12);
    vo_tl_scg_seq             NUMBER(12);
    vo_wtr_rcv_term_cd        TRS_AGMT_EQ_RT.WTR_RCV_TERM_CD%TYPE;
    vo_wtr_de_term_cd         TRS_AGMT_EQ_RT.WTR_DE_TERM_CD%TYPE;
    vo_bzc_rtn_cd             NUMBER(5);
    vo_bzc_rtn_msg            VARCHAR2(1000);
    vo_fu_scg_rtn_cd          NUMBER(5);
    vo_ow_scg_rtn_cd          NUMBER(5);
    vo_dg_scg_rtn_cd          NUMBER(5);
    vo_tl_scg_rtn_cd          NUMBER(5);
    vo_fu_scg_rtn_msg         VARCHAR2(1000);
    vo_ow_scg_rtn_msg         VARCHAR2(1000);
    vo_dg_scg_rtn_msg         VARCHAR2(1000);
    vo_tl_scg_rtn_msg         VARCHAR2(1000);
    vo_bzc_curr_cd            VARCHAR2(3);
    vo_trsp_agmt_rt_tp_nm     VARCHAR2(50);

    vo_fuel_com_scg_knd_cd     VARCHAR2(6);
    vo_over_wgt_com_scg_knd_cd VARCHAR2(6);
    vo_hzs_com_scg_knd_cd      VARCHAR2(6);
    vo_ttl_com_scg_knd_cd      VARCHAR2(6);
    vo_fuel_com_scg_seq        NUMBER(12);
    vo_over_wgt_com_scg_seq    NUMBER(12);
    vo_hzs_com_scg_seq         NUMBER(12);
    vo_ttl_com_scg_seq         NUMBER(12);

    v_trsp_so_knd_indicator VARCHAR2(15);
    v_new_rail_svc_tp_cd    VARCHAR2(2);
    v_new_way_tp_cd         VARCHAR2(15);
    v_agmt_eq_knd_cd        VARCHAR2(1);
    v_eq_tare_wgt           NUMBER(18, 3);
    v_eq_tot_wgt            NUMBER(18, 3);
    v_link_cnt              NUMBER(1);
    v_cust_cnt_cd           TRS_AGMT_RT_TP.CUST_CNT_CD%TYPE;
    v_cust_seq              TRS_AGMT_RT_TP.CUST_SEQ%TYPE;
    v_basis_dt              DATE;
    v_eq_tp_sz_cd           VARCHAR2(4);
    v_system_indicator         VARCHAR2(3);

    po_return TRS_AGMT_RATE_CC_PKG.RAIL_TYPE1;

  BEGIN

    IF pi_debug_flg = 'Y' THEN
      DBMS_OUTPUT.ENABLE(1000000);
    END IF;

    v_link_cnt    := TRS_AGMT_RATE_CC_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd,
                                                           pi_via_nod_cd,
                                                           pi_door_nod_cd,
                                                           pi_to_nod_cd);
    v_eq_tare_wgt := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(NVL(pi_wgt_uom,
                                                                     'KGS'),
                                                                 pi_eq_tp_sz_cd);
    v_eq_tot_wgt  := NVL(v_eq_tare_wgt, 0) + NVL(pi_wgt_qty, 0);
    v_basis_dt    := TO_DATE(TO_CHAR(pi_basis_dt, 'YYYYMMDD'), 'YYYYMMDD');

    /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */
    IF pi_cgo_tp_cd = 'M'
        AND (SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'F'
                OR
             SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'A'
                OR
             SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'P') THEN
      v_agmt_eq_knd_cd := 'Z';

    ELSE

      v_agmt_eq_knd_cd := pi_eq_knd_cd;

    END IF;

    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN

      v_trsp_so_knd_indicator := 'USRAIL';
      v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd, 1, 2); /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */

      IF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'O' THEN

        v_new_way_tp_cd := 'ONE'; /* ONE    */

      ELSIF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'R' THEN

        v_new_way_tp_cd := 'RND'; /* RND */

      ELSE

        v_new_way_tp_cd := '';

      END IF;

      v_cust_cnt_cd := 'XX';
      v_cust_seq    := 0;

    ELSE

      v_trsp_so_knd_indicator := 'NONE_USRAIL';
      v_new_way_tp_cd         := '';

      /* 161019 : COA에서 호출 시 TRS Customer Code를 무시하도록 NULL 처리 */
      v_cust_cnt_cd := pi_cust_cnt_cd; -- NULL
      v_cust_seq    := pi_cust_seq; -- NULL

    END IF;

    /* COMBINED TYPE CODE CONVERSION */
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN

      v_new_way_tp_cd := pi_way_tp_cd;

    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR
          pi_cmb_tp_cd = 'FM' THEN

      v_new_way_tp_cd := C_WAY_TYPE_PRIORITY; /* roundtrip currency priority */

    ELSE

      v_new_way_tp_cd := '';

    END IF;

    /* R Type의 Container의 Special Cargo정보가 'RD'일 경우엔 D Type으로 Rate를 찾는다. */
    IF SUBSTR(pi_eq_tp_sz_cd, 1, 1) = 'R' AND pi_spcl_cgo_cd = 'RD' THEN
      v_eq_tp_sz_cd := 'D' || SUBSTR(pi_eq_tp_sz_cd, 2, 1);
    ELSE
      v_eq_tp_sz_cd := pi_eq_tp_sz_cd;
    END IF;

    /* SET   SYSTEM INDICATOR PARAMETER */
    IF pi_system_indicator = 'COA' THEN
        v_system_indicator := pi_system_indicator;
    ELSE
        v_system_indicator := C_SYSTEM_INDICATOR;
    END IF;
  
    /* BASIC RATE CALCULATION */
    GET_BASIC_RATE_CALC_PRC(       v_system_indicator,
                                   v_trsp_so_knd_indicator,
                                   pi_trsp_agmt_ofc_cty_cd,
                                   pi_trsp_agmt_seq,
                                   v_agmt_eq_knd_cd,
                                   v_link_cnt,
                                   pi_ctrl_ofc_cd,
                                   pi_vndr_seq,
                                   v_basis_dt,
                                   v_new_way_tp_cd,
                                   pi_eq_knd_cd,
                                   v_eq_tp_sz_cd,
                                   pi_cmb_tp_cd,
                                   pi_cgo_tp_cd,
                                   pi_bound_cd,
                                   pi_crr_mod_cd,
                                   pi_cost_mod_cd,
                                   v_cust_cnt_cd,
                                   v_cust_seq,
                                   v_new_rail_svc_tp_cd,
                                   pi_cmdt_cd,
                                   pi_from_nod_cd,
                                   pi_via_nod_cd,
                                   pi_door_nod_cd,
                                   pi_to_nod_cd,
                                   pi_bundle_cnt,
                                   pi_wgt_uom,
                                   v_eq_tot_wgt,
                                   pi_rcv_term,
                                   pi_de_term,
                                   'N',
                                   pi_spcl_cgo_cd,
                                   pi_debug_flg,

                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   vo_trsp_agmt_rt_tp_ser_no,
                                   vo_vndr_seq,
                                   vo_cust_nomi_trkr_flg,
                                   vo_cust_cnt_cd,
                                   vo_cust_seq,
                                   vo_trsp_agmt_rt_tp_cd,
                                   vo_way_type,
                                   vo_bzc_curr_cd,
                                   vo_wtr_rcv_term_cd,
                                   vo_wtr_de_term_cd,
                                   vo_bzc_rt,
                                   vo_trsp_agmt_rt_tp_nm,
                                   vo_bzc_rtn_cd,
                                   vo_bzc_rtn_msg);

    IF vo_bzc_rtn_cd = 0 THEN
      IF v_trsp_so_knd_indicator = 'USRAIL' THEN
        -- FUEL SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'FSG',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_fu_scg_curr_cd,
                                   vo_fu_scg_rt,
                                   vo_fu_scg_rtn_cd,
                                   vo_fu_scg_rtn_msg,
                                   po_return);
        -- OVER WEIGHT SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'OWS',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   pi_wgt_uom,
                                   pi_wgt_qty,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_ow_scg_curr_cd,
                                   vo_ow_scg_rt,
                                   vo_ow_scg_rtn_cd,
                                   vo_ow_scg_rtn_msg,
                                   po_return);
        -- HAZMAT SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'HZS',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   pi_spcl_cgo_cd,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_dg_scg_curr_cd,
                                   vo_dg_scg_rt,
                                   vo_dg_scg_rtn_cd,
                                   vo_dg_scg_rtn_msg,
                                   po_return);
        -- ETC TOTAL SURCHARGE
        GET_RAIL_SCG_RATE_CALC_PRC(v_system_indicator,
                                   v_eq_tp_sz_cd,
                                   pi_vndr_seq,
                                   vo_trsp_agmt_ofc_cty_cd,
                                   vo_trsp_agmt_seq,
                                   'TTL',
                                   pi_cgo_tp_cd,
                                   pi_from_nod_cd,
                                   pi_to_nod_cd,
                                   NULL,
                                   NULL,
                                   v_basis_dt,
                                   NULL,
                                   vo_bzc_curr_cd,
                                   vo_bzc_rt,
                                   pi_bound_cd,
                                   pi_debug_flg,

                                   vo_tl_scg_curr_cd,
                                   vo_tl_scg_rt,
                                   vo_tl_scg_rtn_cd,
                                   vo_tl_scg_rtn_msg,
                                   po_return);
      ELSE
        /* SURCHARGE RATE CALCULATION */
        GET_SCG_RATE_CALC_PRC(       v_system_indicator,
                                     v_trsp_so_knd_indicator,
                                     pi_coa_cost_src_cd,
                                     vo_way_type,
                                     vo_trsp_agmt_ofc_cty_cd,
                                     vo_trsp_agmt_seq,
                                     vo_trsp_agmt_rt_tp_ser_no,
                                     pi_vndr_seq,
                                     v_basis_dt,
                                     pi_eq_knd_cd,
                                     v_eq_tp_sz_cd,
                                     pi_cgo_tp_cd,
                                     pi_bound_cd,
                                     pi_crr_mod_cd,
                                     pi_cost_mod_cd,
                                     pi_from_nod_cd,
                                     pi_via_nod_cd,
                                     pi_door_nod_cd,
                                     pi_to_nod_cd,
                                     pi_bundle_cnt,
                                     NULL,
                                     NULL,
                                     vo_bzc_rt,
                                     vo_bzc_curr_cd,
                                     pi_spcl_cgo_cd,
                                     pi_debug_flg,

                                     vo_scg_union_exp,
                                     vo_trsp_scg_cd,
                                     vo_trsp_agmt_scg_nod_seq,
                                     vo_trsp_agmt_scg_rt_seq,
                                     vo_fu_scg_curr_cd,
                                     vo_fu_scg_rt,
                                     vo_fu_scg_rtn_cd,
                                     vo_fu_scg_rtn_msg);
      END IF;
--    IF vo_fu_scg_rtn_cd != 0 THEN
--      po_rtn_cd  := 1;
--      po_rtn_msg := 'NO RATE';
--      ELSE 
      po_rtn_cd  := 0;
      po_rtn_msg := 'SUCCESS';
--    END IF;
    
    ELSE
      po_rtn_cd  := vo_bzc_rtn_cd;
      po_rtn_msg := vo_bzc_rtn_msg || ' ________ ' || vo_fu_scg_rtn_msg || ' ________ ' || vo_ow_scg_rtn_msg;
    END IF;

    /* DIFFERENT CURRENCY */
    IF vo_fu_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_fu_scg_rtn_cd;
      po_rtn_msg := vo_fu_scg_rtn_msg;
    END IF;
    IF vo_ow_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_ow_scg_rtn_cd;
      po_rtn_msg := vo_ow_scg_rtn_msg;
    END IF;
    IF vo_dg_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_dg_scg_rtn_cd;
      po_rtn_msg := vo_dg_scg_rtn_msg;
    END IF;
    IF vo_tl_scg_rtn_cd < -100 THEN
      po_rtn_cd  := vo_tl_scg_rtn_cd;
      po_rtn_msg := vo_tl_scg_rtn_msg;
    END IF;

    IF po_rtn_cd = 0 THEN
      po_trsp_agmt_ofc_cty_cd := vo_trsp_agmt_ofc_cty_cd;
      po_trsp_agmt_seq        := vo_trsp_agmt_seq;
      po_local_curr_cd        := vo_bzc_curr_cd;

      IF v_trsp_so_knd_indicator = 'USRAIL' THEN
        po_bzc_rt := vo_bzc_rt;
        --po_bzc_rt := vo_bzc_rt + NVL(vo_fu_scg_rt,0) + NVL(vo_ow_scg_rt,0) + NVL(vo_dg_scg_rt,0) + NVL(vo_tl_scg_rt,0);
        po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
        po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
        po_hzs_scg_rt      := NVL(vo_dg_scg_rt, 0);
        po_ttl_scg_rt      := NVL(vo_tl_scg_rt, 0);
      ELSE
        po_bzc_rt          := vo_bzc_rt;
        po_fuel_scg_rt     := NVL(vo_fu_scg_rt, 0);
        po_over_wgt_scg_rt := NVL(vo_ow_scg_rt, 0);
      END IF;
      po_cust_nomi_trkr_flg := vo_cust_nomi_trkr_flg;
      po_way_type           := vo_way_type;
      IF vo_cust_nomi_trkr_flg = 'Y' THEN
        po_sp_type := 'CNT';
      ELSE
        /*po_sp_type := 'HJS';*/
        po_sp_type := 'NYK';
      END IF;

      po_local_curr_tot_amt := vo_bzc_rt + NVL(vo_fu_scg_rt, 0) +
                               NVL(vo_ow_scg_rt, 0) + NVL(vo_dg_scg_rt, 0) +
                               NVL(vo_tl_scg_rt, 0);
      po_cust_cnt_cd        := vo_cust_cnt_cd;
      po_cust_seq           := vo_cust_seq;
      po_trsp_agmt_rt_tp_cd := vo_trsp_agmt_rt_tp_cd;
      po_way_type           := vo_way_type;
      po_trsp_agmt_rt_tp_nm := vo_trsp_agmt_rt_tp_nm;
      po_cust_cnt_cd        := vo_cust_cnt_cd;
      po_cust_seq           := vo_cust_seq;
      po_local_curr_cd      := vo_bzc_curr_cd;
      po_wtr_rcv_term_cd    := vo_wtr_rcv_term_cd;
      po_wtr_de_term_cd     := vo_wtr_de_term_cd;

      /* TOTAL AMOUNT - USD CURRENCY   */
      IF po_local_curr_tot_amt > 0 THEN
        po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(vo_bzc_curr_cd, po_local_curr_tot_amt);
      END IF;

      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('============ Calc Parameter ===============');
        DBMS_OUTPUT.PUT_LINE('v_link_cnt :' || v_link_cnt);
        DBMS_OUTPUT.PUT_LINE('v_eq_tare_wgt :' || v_eq_tare_wgt);
        DBMS_OUTPUT.PUT_LINE('============ Retrun Parameter ===============');
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_ofc_cty_cd :' || po_trsp_agmt_ofc_cty_cd);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_seq        :' || po_trsp_agmt_seq);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_cd   :' || po_trsp_agmt_rt_tp_cd);
        DBMS_OUTPUT.PUT_LINE('po_way_type             :' || po_way_type);
        DBMS_OUTPUT.PUT_LINE('po_trsp_agmt_rt_tp_nm   :' || po_trsp_agmt_rt_tp_nm);
        DBMS_OUTPUT.PUT_LINE('po_sp_type              :' || po_sp_type);
        DBMS_OUTPUT.PUT_LINE('po_cust_nomi_trkr_flg   :' || po_cust_nomi_trkr_flg);
        DBMS_OUTPUT.PUT_LINE('po_cust_cnt_cd          :' || po_cust_cnt_cd);
        DBMS_OUTPUT.PUT_LINE('po_cust_seq             :' || po_cust_seq);
        DBMS_OUTPUT.PUT_LINE('po_local_curr_cd        :' || po_local_curr_cd);
        DBMS_OUTPUT.PUT_LINE('po_bzc_rt               :' || po_bzc_rt);
        DBMS_OUTPUT.PUT_LINE('po_fuel_scg_rt          :' || po_fuel_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_over_wgt_scg_rt      :' || po_over_wgt_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_hzs_scg_rt           :' || po_hzs_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_ttl_scg_rt           :' || po_ttl_scg_rt);
        DBMS_OUTPUT.PUT_LINE('po_local_curr_tot_amt   :' || po_local_curr_tot_amt);
        DBMS_OUTPUT.PUT_LINE('po_usd_curr_tot_amt     :' || po_usd_curr_tot_amt);
        DBMS_OUTPUT.PUT_LINE('po_wtr_rcv_term_cd      :' || po_wtr_rcv_term_cd);
        DBMS_OUTPUT.PUT_LINE('po_wtr_de_term_cd       :' || po_wtr_de_term_cd);
      END IF;

    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      po_rtn_cd := -1;
      IF pi_debug_flg = 'Y' THEN
        DBMS_OUTPUT.PUT_LINE('GET_RATE_FOR_COA_PRC <OTHERS> ERROR MSG = [' || SQLERRM || ']');
      END IF;
  END GET_RATE_FOR_COA_PRC;

END TRS_AGMT_RATE_CC_PKG;
/

