CREATE OR REPLACE PACKAGE TRS_AGMT_RATE_MORE_PKG   
AUTHID CURRENT_USER   
IS   
   
-- Return Type   
TYPE PG_TYPE_MASTER1 IS RECORD   
(   
  TRSP_AGMT_OFC_CTY_CD VARCHAR2(10)   
, TRSP_AGMT_SEQ        NUMBER(10)   
, WAY_TYPE             VARCHAR2(10)   
, VNDR_TP_CD           VARCHAR2(10)   
, VNDR_SEQ             NUMBER(10)   
, VNDR_NM              VARCHAR2(100)   
, RJT_HIST             VARCHAR2(10)   
, CURR_CD              VARCHAR2(10)   
, BASIC_RATE           NUMBER(18,3)   
, WTR_RCV_TERM_CD      VARCHAR2(10)   
, WTR_DE_TERM_CD       VARCHAR2(10)   
, TRSP_AGMT_RT_TP_CD   VARCHAR2(10)   
, TRSP_AGMT_RT_TP_NM   VARCHAR2(100)   
, CUST_NOMI_TRKR_FLG   VARCHAR2(1)   
, CUST_CD              VARCHAR2(10)   
, FUEL_SCG_RT          NUMBER(18,3)   
, VAT_SCG_RT           NUMBER(18,3)   
, TOLL_FEE_RT          NUMBER(18,3)   
, TRSP_AGMT_RT_SEQ     NUMBER(12)   
, CFM_FLG              VARCHAR2(1)   
, TRSP_AGMT_UPD_DT     VARCHAR2(14)   
, TRSP_AGMT_UPD_USR_ID VARCHAR2(20)   
, EFF_FM_DT            VARCHAR2(8)   
, EFF_TO_DT            VARCHAR2(8)   
, RANK_ORDER           NUMBER(12)   
, AGMT_REF_NO          VARCHAR2(20)   
);   
   
-- Return Type Instance   
TYPE SET_TYPE1 IS TABLE OF PG_TYPE_MASTER1;   
   
/*###################################################################   
 # -- Type    : FUNCTION   
 # -- Author  : JONG HYEK CHOI   
 # -- Created : AUG 05, 2010   
 # -- Table   : TRS_AGMT_*   
 # -- Purpose : GET MORE-CANDIDATES LIST   
 #####################################################################*/   
FUNCTION GET_MORE_CANDIDATES_LIST_FNC   
(   
    pi_trsp_so_ofc_cty_cd   IN VARCHAR2   
   ,pi_trsp_so_seq          IN NUMBER   
   ,pi_ctrt_ofc_cd          IN VARCHAR2    /* Pair - X , Distance - Mandatory */   
   ,pi_vndr_seq             IN NUMBER   
   ,pi_basis_dt             IN VARCHAR2   
   ,pi_way_tp_cd            IN VARCHAR2    /* 'ONEWAY' or 'ROUNDTRIP'      */   
   ,pi_eq_knd_cd            IN VARCHAR2   
   ,pi_eq_tp_sz_cd          IN VARCHAR2   
   ,pi_cmb_tp_cd            IN VARCHAR2   
   ,pi_cgo_tp_cd            IN VARCHAR2   
   ,pi_bound_cd             IN VARCHAR2    /* OPTIONAL - /OUT BOUND */   
   ,pi_crr_mod_cd           IN VARCHAR2   
   ,pi_cost_mod_cd          IN VARCHAR2   
   ,pi_rail_svc_tp_cd       IN VARCHAR2    /* OPTIONAL */   
   ,pi_cmdt_cd              IN VARCHAR2    /* OPTIONAL */   
   ,pi_from_nod_cd          IN VARCHAR2   
   ,pi_via_nod_cd           IN VARCHAR2   
   ,pi_door_nod_cd          IN VARCHAR2   
   ,pi_to_nod_cd            IN VARCHAR2   
   ,pi_bundle_cnt           IN NUMBER   
   ,pi_wgt_uom              IN VARCHAR2    /* L-LBS, K-KGS */   
   ,pi_wgt_qty              IN NUMBER   
   ,pi_cust_seq             IN VARCHAR2  
   ,pi_debug_flg            IN VARCHAR2   
)  RETURN  SET_TYPE1 PIPELINED;   
   
END TRS_AGMT_RATE_MORE_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_AGMT_RATE_MORE_PKG IS       
        
/*###################################################################        
 # -- Type    : FUNCTION        
 # -- Author  : JONG HYEK CHOI        
 # -- Created : AUG 05, 2010        
 # -- Table   : TRS_AGMT_*        
 # -- Purpose : GET MORE-CANDIDATES LIST        
 #####################################################################*/        
FUNCTION GET_MORE_CANDIDATES_LIST_FNC        
(        
    pi_trsp_so_ofc_cty_cd         IN VARCHAR2        
   ,pi_trsp_so_seq                IN NUMBER        
   ,pi_ctrt_ofc_cd                IN VARCHAR2    /* Pair - X , Distance - Mandatory */        
   ,pi_vndr_seq                   IN NUMBER        
   ,pi_basis_dt                   IN VARCHAR2        
   ,pi_way_tp_cd                  IN VARCHAR2    /* WAY TYPE을 구분하지 않으므로 항상 NULL로 값을 받는다 */        
   ,pi_eq_knd_cd                  IN VARCHAR2        
   ,pi_eq_tp_sz_cd                IN VARCHAR2        
   ,pi_cmb_tp_cd                  IN VARCHAR2        
   ,pi_cgo_tp_cd                  IN VARCHAR2        
   ,pi_bound_cd                   IN VARCHAR2    /* OPTIONAL - /OUT BOUND */        
   ,pi_crr_mod_cd                 IN VARCHAR2        
   ,pi_cost_mod_cd                IN VARCHAR2        
   ,pi_rail_svc_tp_cd             IN VARCHAR2    /* US RAIL에서는 사용하지 않으므로 항상 NULL로 값을 받는다 */        
   ,pi_cmdt_cd                    IN VARCHAR2    /* OPTIONAL */        
   ,pi_from_nod_cd                IN VARCHAR2        
   ,pi_via_nod_cd                 IN VARCHAR2        
   ,pi_door_nod_cd                IN VARCHAR2        
   ,pi_to_nod_cd                  IN VARCHAR2        
   ,pi_bundle_cnt                 IN NUMBER        
   ,pi_wgt_uom                    IN VARCHAR2    /* L-LBS, K-KGS */        
   ,pi_wgt_qty                    IN NUMBER        
   ,pi_cust_seq                   IN VARCHAR2  
   ,pi_debug_flg                  IN VARCHAR2        
)  RETURN  SET_TYPE1 PIPELINED        
IS        
    C_SYSTEM_INDICATOR           CONSTANT VARCHAR2(3)     := 'TRS';        
    C_WAY_TYPE_PRIORITY          CONSTANT VARCHAR2(15)    := 'RND_PRIORITY';        
    C_CONV_KG_FROM_LBS           CONSTANT NUMBER(10,6)    := 2.204;        
    v_trsp_so_knd_indicator      VARCHAR2(15);        
    v_new_rail_svc_tp_cd         VARCHAR2(2);        
    v_agmt_eq_knd_cd             VARCHAR2(1);        
    v_eq_tare_wgt                NUMBER(18,3);        
    v_eq_tot_wgt                 NUMBER(18,3);        
    v_link_cnt                   NUMBER(1);        
    v_basis_dt                   DATE;        
    v_eq_tp_all                  VARCHAR2(4);        
    v_eq_sz_all                  VARCHAR2(4);  
    v_cust_cnt_cd                VARCHAR2(2);  
    v_cust_seq                   NUMBER(10);  
        
BEGIN        
    v_link_cnt        := TRS_AGMT_RATE_CC_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);        
    v_eq_tare_wgt     := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(NVL(pi_wgt_uom, 'KGS'), pi_eq_tp_sz_cd) ;        
    v_eq_tot_wgt      := NVL(v_eq_tare_wgt,0) + NVL(pi_wgt_qty,0);        
    v_basis_dt        := TO_DATE(pi_basis_dt,'YYYYMMDD');  
    v_cust_cnt_cd     := SUBSTR(pi_cust_seq, 1,2);  
    v_cust_seq        := TO_NUMBER(SUBSTR(pi_cust_seq, 3));  
        
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
        
    FOR RET_DATA IN        
        (        
       
SELECT        
      TRSP_AGMT_OFC_CTY_CD       
    , TRSP_AGMT_SEQ       
    , WAY_TYPE       
    , VNDR_TP_CD       
    , VNDR_SEQ       
    , VNDR_NM       
    , RJT_HIST       
    , CURR_CD       
    , BASIC_RATE       
    , WTR_RCV_TERM_CD       
    , WTR_DE_TERM_CD       
    , TRSP_AGMT_RT_TP_CD       
    , TRSP_AGMT_RT_TP_NM       
    , CUST_NOMI_TRKR_FLG       
    , CUST_CD       
    , FUEL_SCG_RT       
    , TO_NUMBER(TRS_GET_JSON_TOKEN_FNC(VAT_SCG_INFO, 'SCG_RT')) VAT_SCG_RT       
    , TO_NUMBER(TRS_GET_JSON_TOKEN_FNC(TOLL_FEE_INFO, 'SCG_RT')) TOLL_FEE_RT       
    , TRSP_AGMT_RT_SEQ       
    , (CASE WHEN NVL(FUEL_SCG_FLG, 'Y') = 'N' THEN 'N'        
            WHEN NVL(TRS_GET_JSON_TOKEN_FNC(VAT_SCG_INFO, 'CFM_FLG'), 'Y') = 'N' THEN 'N'        
            WHEN NVL(TRS_GET_JSON_TOKEN_FNC(TOLL_FEE_INFO, 'CFM_FLG'), 'Y') = 'N' THEN 'N'        
            ELSE NVL(CFM_FLG, 'Y')        
       END) CFM_FLG       
    , TRSP_AGMT_UPD_DT       
    , TRSP_AGMT_UPD_USR_ID       
    , EFF_FM_DT       
    , EFF_TO_DT       
    , RANK_ORDER      
    , AGMT_REF_NO   
  FROM (       
               
        SELECT TRSP_AGMT_OFC_CTY_CD        
              ,TRSP_AGMT_SEQ        
              ,WAY_TYPE        
              ,CUST_NOMI_TRKR_IND_CD                                   VNDR_TP_CD        
              ,NVL(VNDR_SEQ, pi_vndr_seq)                              VNDR_SEQ        
              ,(SELECT NVL(TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ), TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(pi_vndr_seq)) FROM DUAL) VNDR_NM        
              ,(SELECT NVL2(VNDR_SEQ, TRS_COMMON_PKG.GET_VNDR_WO_RJCT_HIS_FNC(pi_trsp_so_ofc_cty_cd, pi_trsp_so_seq, VNDR_SEQ), TRS_COMMON_PKG.GET_VNDR_WO_RJCT_HIS_FNC(pi_trsp_so_ofc_cty_cd, pi_trsp_so_seq, pi_vndr_seq)) FROM DUAL) RJT_HIST        
              ,CURR_CD        
              ,BASIC_RATE        
              ,DECODE(WTR_RCV_TERM_CD, '0', '', WTR_RCV_TERM_CD) WTR_RCV_TERM_CD       
              ,DECODE(WTR_DE_TERM_CD, '0', '', WTR_DE_TERM_CD) WTR_DE_TERM_CD       
              ,TRSP_AGMT_RT_TP_CD        
              ,TRSP_AGMT_RT_TP_NM        
              ,CUST_NOMI_TRKR_FLG        
              ,DECODE(CUST_CNT_CD||CUST_SEQ, 'XX0', NULL,CUST_CNT_CD||CUST_SEQ)  CUST_CD        
              ,TO_NUMBER(TRS_GET_JSON_TOKEN_FNC(FUEL_SCG_INFO, 'SCG_RT')) FUEL_SCG_RT       
              ,TRS_GET_JSON_TOKEN_FNC(FUEL_SCG_INFO, 'CFM_FLG') FUEL_SCG_FLG       
              ,TRS_GET_AGMT_SCG_INFO_FNC (       
                  pi_rail_svc_tp_cd ,'VT' ,WAY_TYPE,pi_crr_mod_cd , TRSP_AGMT_OFC_CTY_CD       
                 ,TRSP_AGMT_SEQ  ,TRSP_AGMT_RT_TP_SER_NO, VNDR_SEQ ,v_basis_dt ,pi_eq_knd_cd       
                 ,pi_eq_tp_sz_cd ,pi_cgo_tp_cd ,pi_from_nod_cd ,pi_via_nod_cd ,pi_door_nod_cd       
                 ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL ,NULL, (BASIC_RATE+NVL(TO_NUMBER(TRS_GET_JSON_TOKEN_FNC(FUEL_SCG_INFO, 'SCG_RT')),0))       
                 ,CURR_CD ,NULL,pi_debug_flg       
               ) VAT_SCG_INFO       
              ,TRS_GET_AGMT_SCG_INFO_FNC (       
                  pi_rail_svc_tp_cd ,'TF' ,WAY_TYPE,pi_crr_mod_cd , TRSP_AGMT_OFC_CTY_CD       
                 ,TRSP_AGMT_SEQ  ,TRSP_AGMT_RT_TP_SER_NO, VNDR_SEQ ,v_basis_dt ,pi_eq_knd_cd       
                 ,pi_eq_tp_sz_cd ,pi_cgo_tp_cd ,pi_from_nod_cd ,pi_via_nod_cd ,pi_door_nod_cd       
                 ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL ,NULL, (BASIC_RATE+NVL(TO_NUMBER(TRS_GET_JSON_TOKEN_FNC(FUEL_SCG_INFO, 'SCG_RT')),0))       
                 ,CURR_CD ,NULL,pi_debug_flg       
               ) TOLL_FEE_INFO       
              ,TRSP_AGMT_RT_SEQ        
              ,CFM_FLG        
              ,TRSP_AGMT_UPD_DT       
              ,TRSP_AGMT_UPD_USR_ID       
              ,TO_CHAR(EFF_FM_DT, 'YYYYMMDD') EFF_FM_DT        
              ,TO_CHAR(EFF_TO_DT, 'YYYYMMDD') EFF_TO_DT      
              ,AGMT_REF_NO   
              ,RANK() OVER(PARTITION BY TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, VNDR_SEQ, CUST_NOMI_TRKR_IND_CD, CUST_CNT_CD, CUST_SEQ       
                               ORDER BY EQ_TPSZ_PRIOR_ORDER, FM_LEN DESC, VIA_LEN DESC, DOR_LEN DESC, TO_LEN DESC, TRSP_RVS_APLY_FLG ASC, TRSP_AGMT_UPD_DT DESC       
                          ) RANK_ORDER     
          FROM (        
               SELECT /*+ INDEX (D XAK1TRS_AGMT_NOD) */ C.TRSP_AGMT_OFC_CTY_CD        
                     ,C.TRSP_AGMT_SEQ        
                     ,C.TRSP_AGMT_RT_TP_SER_NO        
                     ,B.VNDR_SEQ        
                     ,E.EFF_FM_DT        
                     ,E.EFF_TO_DT        
                     ,C.TRSP_AGMT_RT_TP_CD        
                     ,C.CUST_NOMI_TRKR_FLG        
                     ,C.CUST_NOMI_TRKR_IND_CD        
                     ,C.CUST_CNT_CD        
                     ,C.CUST_SEQ        
                     ,CASE WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  IS NULL          THEN 9        
                           WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  = 'ALAL'         THEN 4        
                           WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd  THEN 1        
                           ELSE 3        
                      END  EQ_TPSZ_PRIOR_ORDER        
                     ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN 'ONE'        
                           WHEN pi_way_tp_cd = 'RND'                                         THEN 'RND'        
                           WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL2(E.TRSP_RND_RT   , 'RND', 'ONE')        
                           ELSE                                                              NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')        
                      END  WAY_TYPE        
                     ,E.CURR_CD        
                     ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN E.TRSP_ONE_WY_RT        
                           WHEN pi_way_tp_cd = 'RND'                                         THEN E.TRSP_RND_RT        
                           WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)        
                           ELSE                                                              NVL(E.TRSP_ONE_WY_RT    , E.TRSP_RND_RT)        
                      END AS BASIC_RATE        
                     ,E.WTR_RCV_TERM_CD        
                     ,E.WTR_DE_TERM_CD        
                     ,DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', 1, 'PD', 2, 'DP', 3, 'D', 4) RT_TP_ORDER        
                     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954',C.TRSP_AGMT_RT_TP_CD) TRSP_AGMT_RT_TP_NM        
                     ,A.CTRT_OFC_CD        
                     ,E.EQ_KND_CD        
                     ,TRS_GET_AGMT_SCG_INFO_FNC (       
                          pi_rail_svc_tp_cd ,'FU'       
                         ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN 'ONE'       
                               WHEN pi_way_tp_cd = 'RND'                                         THEN 'RND'       
                               WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL2(E.TRSP_RND_RT   , 'RND', 'ONE')       
                               ELSE                                                              NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')       
                          END       
                         ,pi_crr_mod_cd , C.TRSP_AGMT_OFC_CTY_CD       
                         ,C.TRSP_AGMT_SEQ  ,C.TRSP_AGMT_RT_TP_SER_NO, B.VNDR_SEQ ,v_basis_dt ,pi_eq_knd_cd       
                         ,pi_eq_tp_sz_cd ,pi_cgo_tp_cd ,pi_from_nod_cd ,pi_via_nod_cd ,pi_door_nod_cd       
                         ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL ,NULL       
                         ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN E.TRSP_ONE_WY_RT       
                               WHEN pi_way_tp_cd = 'RND'                                         THEN E.TRSP_RND_RT       
                               WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)       
                               ELSE                                                              NVL(E.TRSP_ONE_WY_RT    , E.TRSP_RND_RT)       
                          END       
                         ,E.CURR_CD ,NULL,pi_debug_flg       
                      ) FUEL_SCG_INFO       
                     ,E.TRSP_AGMT_RT_SEQ        
                     ,NVL(E.CFM_FLG, 'Y') CFM_FLG        
                     ,TO_CHAR(E.UPD_DT, 'YYYYMMDDHH24MISS') TRSP_AGMT_UPD_DT       
                     ,E.UPD_USR_ID TRSP_AGMT_UPD_USR_ID       
                     ,LENGTH(DECODE(D.FM_NOD_CD,'0000000' ,'N/A', D.FM_NOD_CD)) FM_LEN       
                     ,LENGTH(DECODE(D.VIA_NOD_CD,'0000000' ,'N/A', D.VIA_NOD_CD)) VIA_LEN       
                     ,LENGTH(DECODE(D.DOR_NOD_CD,'0000000' ,'N/A', D.DOR_NOD_CD)) DOR_LEN       
                     ,LENGTH(DECODE(D.TO_NOD_CD,'0000000' ,'N/A', D.TO_NOD_CD)) TO_LEN       
                     ,E.TO_WGT       
                     ,'N' TRSP_RVS_APLY_FLG -- Forward에서는 reverse 요율을 조회 할일이 없으므로..N으로 처리      
                     ,A.AGMT_REF_NO   
                FROM  TRS_AGMT_HDR   A        
                     ,TRS_AGMT_APLY_VNDR B        
                     ,TRS_AGMT_RT_TP C        
                     ,TRS_AGMT_NOD D        
                     ,TRS_AGMT_EQ_RT E        
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
                 AND  A.CTRT_OFC_CD            = DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', A.CTRT_OFC_CD, pi_ctrt_ofc_cd)        
                 AND  E.EQ_KND_CD              = pi_eq_knd_cd        
                 AND  C.CGO_TP_CD              = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE '0' END        
                 AND  C.TRSP_COST_MOD_CD  = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))        
                                                 WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))        
                                                 WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'        
                                                 WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'        
                                                 ELSE ''        
                                            END        
                 AND C.AGMT_TRSP_TP_CD   = pi_crr_mod_cd        
                 AND C.RAIL_SVC_TP_CD    = NVL(pi_rail_svc_tp_cd, '00')        
                 AND D.FM_NOD_CD LIKE SUBSTR(pi_from_nod_cd,1,5)||'%'       
                 AND D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000')       
                 AND D.TO_NOD_CD LIKE SUBSTR(pi_to_nod_cd,1,5)||'%'       
                 AND D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000')       
                 AND D.VIA_NOD_CD LIKE SUBSTR(NVL(pi_via_nod_cd, '0000000'),1,5)||'%'       
                 AND D.DOR_NOD_CD LIKE SUBSTR(NVL(pi_door_nod_cd, '0000000'),1,5)||'%'       
                 AND D.VIA_NOD_CD = CASE v_link_cnt WHEN 1 THEN '0000000'        
                                                    WHEN 2 THEN        
                                                            CASE pi_cost_mod_cd WHEN 'DR' THEN '0000000'        
                                                                                ELSE DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))        
                                                            END        
                                                    WHEN 3 THEN DECODE(LENGTH(D.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))        
                                                    ELSE '0000000'        
                                    END        
                 AND D.DOR_NOD_CD = CASE v_link_cnt WHEN 1 THEN '0000000'        
                                                    WHEN 2 THEN        
                                                           CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))        
                                                                               ELSE '0000000'        
                                                           END        
                                                    WHEN 3 THEN DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))        
                                                    ELSE '0000000'        
                                    END       
                 AND  E.EFF_FM_DT  <= v_basis_dt        
                 AND  E.EFF_TO_DT  >= v_basis_dt        
                 AND  NVL(E.AGMT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= v_basis_dt        
        
                 /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */        
                 AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (PI_EQ_TP_SZ_CD, V_EQ_TP_ALL, V_EQ_SZ_ALL, 'ALAL')        
                 /* ONLY CONTAINER-WEIGHT */        
                 AND CASE WHEN v_agmt_eq_knd_cd = 'U' THEN        
                          CASE WHEN SUBSTR( DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD) ,1,1) = 'K' THEN E.TO_WGT        
                               ELSE ROUND(E.TO_WGT / C_CONV_KG_FROM_LBS, 3)        
                          END        
                          ELSE 1        
                     END        
                     >=        
                     CASE WHEN v_agmt_eq_knd_cd = 'U' THEN        
                          CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN v_eq_tot_wgt        
                               ELSE ROUND(v_eq_tot_wgt / C_CONV_KG_FROM_LBS, 3)        
                          END        
                          ELSE 1        
                     END        
                 /* ONLY Chassis + Empty Flatrack Container */        
                 AND CASE WHEN v_agmt_eq_knd_cd = 'Z' THEN DECODE(E.TRSP_AGMT_BDL_QTY, 0, 1, E.TRSP_AGMT_BDL_QTY)        
                          ELSE 1        
                     END        
                     =        
                     CASE WHEN v_agmt_eq_knd_cd = 'Z' THEN NVL(pi_bundle_cnt,1)        
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
                 AND (C.CUST_CNT_CD, C.CUST_SEQ) IN (('XX', 0), (v_cust_cnt_cd, v_cust_seq))  
       
                 UNION -- REVERSE ROUTE 요율 조회       
       
                 SELECT /*+ INDEX (D XAK1TRS_AGMT_NOD) */ C.TRSP_AGMT_OFC_CTY_CD        
                     ,C.TRSP_AGMT_SEQ        
                     ,C.TRSP_AGMT_RT_TP_SER_NO        
                     ,B.VNDR_SEQ        
                     ,E.EFF_FM_DT        
                     ,E.EFF_TO_DT        
                     ,C.TRSP_AGMT_RT_TP_CD        
                     ,C.CUST_NOMI_TRKR_FLG        
                     ,C.CUST_NOMI_TRKR_IND_CD        
                     ,C.CUST_CNT_CD        
                     ,C.CUST_SEQ        
                     ,CASE WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  IS NULL          THEN 9        
                           WHEN E.TRSP_AGMT_EQ_TP_SZ_CD  = 'ALAL'         THEN 4        
                           WHEN E.TRSP_AGMT_EQ_TP_SZ_CD = pi_eq_tp_sz_cd  THEN 1        
                           ELSE 3        
                      END  EQ_TPSZ_PRIOR_ORDER        
                     ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN 'ONE'        
                           WHEN pi_way_tp_cd = 'RND'                                         THEN 'RND'        
                           WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL2(E.TRSP_RND_RT   , 'RND', 'ONE')        
                           ELSE                                                              NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')        
                      END  WAY_TYPE       
                     ,E.CURR_CD        
                     ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN E.TRSP_ONE_WY_RT        
                           WHEN pi_way_tp_cd = 'RND'                                         THEN E.TRSP_RND_RT        
                           WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)        
                           ELSE                                                              NVL(E.TRSP_ONE_WY_RT    , E.TRSP_RND_RT)        
                       END AS BASIC_RATE        
                     ,E.WTR_RCV_TERM_CD        
                     ,E.WTR_DE_TERM_CD        
                     ,DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', 1, 'PD', 2, 'DP', 3, 'D', 4) RT_TP_ORDER        
                     ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954',C.TRSP_AGMT_RT_TP_CD) TRSP_AGMT_RT_TP_NM        
                     ,A.CTRT_OFC_CD        
                     ,E.EQ_KND_CD        
                     ,TRS_GET_AGMT_SCG_INFO_FNC (       
                          pi_rail_svc_tp_cd ,'FU'       
                         ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN 'ONE'       
                               WHEN pi_way_tp_cd = 'RND'                                         THEN 'RND'       
                               WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL2(E.TRSP_RND_RT   , 'RND', 'ONE')       
                               ELSE                                                              NVL2(E.TRSP_ONE_WY_RT, 'ONE', 'RND')       
                          END       
                         ,pi_crr_mod_cd , C.TRSP_AGMT_OFC_CTY_CD       
                         ,C.TRSP_AGMT_SEQ  ,C.TRSP_AGMT_RT_TP_SER_NO, B.VNDR_SEQ ,v_basis_dt ,pi_eq_knd_cd       
                         ,pi_eq_tp_sz_cd ,pi_cgo_tp_cd ,pi_from_nod_cd ,pi_via_nod_cd ,pi_door_nod_cd       
                         ,pi_to_nod_cd   ,pi_bundle_cnt ,NULL ,NULL       
                         ,CASE WHEN pi_way_tp_cd = 'ONE'                                         THEN E.TRSP_ONE_WY_RT       
                               WHEN pi_way_tp_cd = 'RND'                                         THEN E.TRSP_RND_RT       
                               WHEN pi_way_tp_cd = C_WAY_TYPE_PRIORITY OR pi_cost_mod_cd = 'DR'  THEN NVL(E.TRSP_RND_RT, E.TRSP_ONE_WY_RT)       
                               ELSE                                                              NVL(E.TRSP_ONE_WY_RT    , E.TRSP_RND_RT)       
                          END       
                         ,E.CURR_CD ,NULL,pi_debug_flg       
                      ) FUEL_SCG_INFO       
                     ,E.TRSP_AGMT_RT_SEQ        
                     ,NVL(E.CFM_FLG, 'Y') CFM_FLG        
                     ,TO_CHAR(E.UPD_DT, 'YYYYMMDDHH24MISS') TRSP_AGMT_UPD_DT       
                     ,E.UPD_USR_ID TRSP_AGMT_UPD_USR_ID       
                     ,LENGTH(DECODE(D.FM_NOD_CD,'0000000' ,'N/A', D.FM_NOD_CD)) FM_LEN       
                     ,LENGTH(DECODE(D.VIA_NOD_CD,'0000000' ,'N/A', D.VIA_NOD_CD)) VIA_LEN       
                     ,LENGTH(DECODE(D.DOR_NOD_CD,'0000000' ,'N/A', D.DOR_NOD_CD)) DOR_LEN       
                     ,LENGTH(DECODE(D.TO_NOD_CD,'0000000' ,'N/A', D.TO_NOD_CD)) TO_LEN       
                     ,E.TO_WGT       
                     ,NVL(E.TRSP_RVS_APLY_FLG, 'N') TRSP_RVS_APLY_FLG   
                     ,A.AGMT_REF_NO   
                FROM  TRS_AGMT_HDR   A        
                     ,TRS_AGMT_APLY_VNDR B        
                     ,TRS_AGMT_RT_TP C        
                     ,TRS_AGMT_NOD D        
                     ,TRS_AGMT_EQ_RT E        
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
                 AND  A.CTRT_OFC_CD            = DECODE(C.TRSP_AGMT_RT_TP_CD, 'P', A.CTRT_OFC_CD, pi_ctrt_ofc_cd)        
                 AND  E.EQ_KND_CD              = pi_eq_knd_cd        
                 AND  C.CGO_TP_CD              = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE '0' END        
                 AND  C.TRSP_COST_MOD_CD  = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))        
                                                 WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))        
                                                 WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'        
                                                 WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'        
                                                 ELSE ''        
                                            END        
                 AND  C.AGMT_TRSP_TP_CD   = pi_crr_mod_cd        
                 AND  C.RAIL_SVC_TP_CD    = NVL(pi_rail_svc_tp_cd, '00')        
                        
                 AND E.TRSP_RVS_APLY_FLG = 'Y'       
                 AND D.FM_NOD_CD LIKE SUBSTR(pi_to_nod_cd,1,5)||'%'       
                 AND D.FM_NOD_CD  = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5), '0000000')       
                 AND D.TO_NOD_CD LIKE SUBSTR(pi_from_nod_cd,1,5)||'%'       
                 AND D.TO_NOD_CD  = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5), '0000000')       
                 AND D.VIA_NOD_CD = '0000000'       
                 AND D.DOR_NOD_CD = '0000000'       
                 AND E.EFF_FM_DT  <= v_basis_dt        
                 AND E.EFF_TO_DT  >= v_basis_dt        
                 AND NVL(E.AGMT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= v_basis_dt        
        
                 /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */        
                 AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (PI_EQ_TP_SZ_CD, V_EQ_TP_ALL, V_EQ_SZ_ALL, 'ALAL')        
                 /* ONLY CONTAINER-WEIGHT */        
                 AND CASE WHEN v_agmt_eq_knd_cd = 'U' THEN        
                          CASE WHEN SUBSTR( DECODE(E.WGT_MEAS_UT_CD, 'XXX', 'KGS', E.WGT_MEAS_UT_CD) ,1,1) = 'K' THEN E.TO_WGT        
                               ELSE ROUND(E.TO_WGT / C_CONV_KG_FROM_LBS, 3)        
                          END        
                          ELSE 1        
                     END        
                     >=        
                     CASE WHEN v_agmt_eq_knd_cd = 'U' THEN        
                          CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN v_eq_tot_wgt        
                               ELSE ROUND(v_eq_tot_wgt / C_CONV_KG_FROM_LBS, 3)        
                          END        
                          ELSE 1        
                     END        
                 /* ONLY Chassis + Empty Flatrack Container */        
                 AND CASE WHEN v_agmt_eq_knd_cd = 'Z' THEN DECODE(E.TRSP_AGMT_BDL_QTY, 0, 1, E.TRSP_AGMT_BDL_QTY)        
                          ELSE 1        
                     END        
                     =        
                     CASE WHEN v_agmt_eq_knd_cd = 'Z' THEN NVL(pi_bundle_cnt,1)        
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
                 AND (C.CUST_CNT_CD, C.CUST_SEQ) IN (('XX', 0), (v_cust_cnt_cd, v_cust_seq))  
               )  
            )  
            WHERE 1=1       
              AND RANK_ORDER = 1       
        )        
    LOOP        
        PIPE ROW(RET_DATA);        
    END LOOP;        
        
    RETURN;        
    END;        
END TRS_AGMT_RATE_MORE_PKG;