CREATE OR REPLACE PACKAGE OPUSADM.TRS_COMMON_PKG
AUTHID CURRENT_USER  
IS   
  
/*******************************************************************************  
   1. Object Name      : TRS_COMMON_PKG  
   2. Version          : 1.0  
   3. Create Date      : DEC 13, 2006  
   4. Sub System       : ALPS/TRS  
   5. Author           : 정상기  
   6. Description      : TRS 공통 Package  
   7. Revision History : 2006.11.13 정상기 최초생성  
*******************************************************************************/  
  
/*################################################################### X  
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAR 09, 2007   
 # -- Table   : MDM_CNTR_TP_SZ   
 # -- Purpose : GET CONTAINER TARE WEIGHT(default KG)   
 #####################################################################*/   
  FUNCTION GET_CNTR_TARE_WGT_TO_UOM_FNC    
  (   
           pi_to_wgt_uom       VARCHAR2   
      ,    pi_cntr_tp_sz       VARCHAR2   
  ) RETURN NUMBER;    
  
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : DEC 13, 2006   
 # -- Table   : GL_MON_XCH_RT   
 # -- Purpose : LOCAL CURRENCY >> USD    
 #####################################################################*/   
  FUNCTION GET_CONVERSION_USD_AMT_FNC    
  (   
           p_local_curr_cd  IN VARCHAR2   
      ,    p_local_amt      IN NUMBER   
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')   
  ) RETURN NUMBER;   
  
  /*###################################################################   
 # -- Type    : FUNCTION    
 # -- Author  : JEONG SANG-KI   
 # -- Created : JAN 03, 2007   
 # -- Table   : TRS_TRSP_AGMT_*   
 # -- Purpose : GET WEIGHT CONVERSION TO KILOGRAM   
 #####################################################################*/   
  FUNCTION GET_CONV_WGT_TO_KG_FNC    
  (   
           pi_wgt_uom          VARCHAR2   
      ,    pi_wgt_qty          NUMBER   
  ) RETURN NUMBER;   
  
/*###################################################################   
# PRS BATCH COMPILE CONDITION  
# Description : PRS 에서 사용하는 OLTP PROCEDURE 가 BATCH 에서 OBJECT 차이로 COMPILE 이 안되는 문제를 해결하기 위하여 생성함.  
                CC_CTRL_FLG  값이 OLTP DB 에서는 1, BATCH DB 에서는 2 를 갖는다.  
###################################################################*/  
$IF PRI_PRS_CC_CTRL_PKG.CC_CTRL_FLG = 1 $THEN  
  
  
  
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JAN 14, 2008   
 # -- Table   : GL_MON_XCH_RT   
 # -- Purpose : 평균환율    
 #####################################################################*/   
  FUNCTION GET_CONVERSION_AVG_USD_AMT_FNC    
  (   
           p_local_curr_cd  IN VARCHAR2   
      ,    p_local_amt      IN NUMBER   
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')   
  ) RETURN NUMBER;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : DEC 13, 2006   
 # -- Table   : GL_MON_XCH_RT   
 # -- Purpose : LOCAL CURRENCY >> USD    
 #####################################################################*/   
  FUNCTION GET_CONVERSION_EUR_AMT_FNC    
  (   
           p_local_curr_cd  IN VARCHAR2   
      ,    p_local_amt      IN NUMBER   
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')      
  ) RETURN NUMBER;     
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAR 09, 2007   
 # -- Table   : GL_MON_XCH_RT   
 # -- Purpose : FROM ORIGINAL CURRENCY TO DISTINATION CURRENCY    
 #####################################################################*/   
  FUNCTION GET_CONVERSION_TO_CURR_AMT_FNC    
  (   
           p_from_curr_cd  IN VARCHAR2     /* Original Currency Code */   
      ,    p_to_curr_cd    IN VARCHAR2     /* Conversion Destination Currency Code */   
      ,    p_basis_ym      IN VARCHAR2     /* 기준연월('YYYYMM')     */   
      ,    p_original_amt  IN NUMBER       /* Original Amount        */   
  ) RETURN NUMBER;                         /* Conversion Amount */   
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JAN 18, 2007   
 # -- Table   : GL_MON_XCH_RT   
 # -- Purpose : Kilometers, Miles >> Kilometers    
 #####################################################################*/   
  FUNCTION GET_CONV_DIST_TO_KM_FNC    
  (   
           p_dist_uom_cd  IN VARCHAR2   
      ,    p_dist_qty     IN NUMBER   
  ) RETURN NUMBER;     
   
   
  /*###################################################################   
 # -- Type    : FUNCTION    
 # -- Author  : JEONG SANG-KI   
 # -- Created : SEP 13, 2007   
 # -- Table   : BKG_BKG_CNTR   
 # -- Purpose : GET CONTAINER WEIGHT CONVERSION TO KILOGRAM   
 #####################################################################*/   
  FUNCTION GET_CONV_WGT_TO_KGS_FNC    
  (   
           pi_cntr_wgt_uom          VARCHAR2   
      ,    pi_cntr_wgt_qty          NUMBER   
  ) RETURN NUMBER;     
     
  /*###################################################################   
 # -- Type    : FUNCTION    
 # -- Author  : JEONG SANG-KI   
 # -- Created : SEP 13, 2007   
 # -- Table   : BKG_BKG_CNTR   
 # -- Purpose : GET CONTAINER WEIGHT CONVERSION TO POUND   
 #####################################################################*/   
  FUNCTION GET_CONV_WGT_TO_LBS_FNC    
  (   
           pi_cntr_wgt_uom          VARCHAR2   
      ,    pi_cntr_wgt_qty          NUMBER   
  ) RETURN NUMBER;       
     
   
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : FEB 12, 2007   
 # -- Table   :    
 # -- Purpose : GET SERVICE PROVIDER ABBR_NM   
 #####################################################################*/   
  FUNCTION GET_VNDR_ABBR_NM_FNC    
  (   
           pi_vndr_seq          NUMBER   
  ) RETURN VARCHAR2;     
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : FEB 12, 2007   
 # -- Table   :    
 # -- Purpose : GET SERVICE PROVIDER ABBR_NM   
 #####################################################################*/   
  FUNCTION GET_VNDR_FULL_NM_FNC    
  (   
           pi_vndr_seq          NUMBER   
         , pi_local_cnt_cd      VARCHAR2 DEFAULT 'ENG'  /* DEFAULT+ENG : ENGLISH NAME, OTHERS : LOCAL NAME */   
  ) RETURN VARCHAR2;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : FEB 15, 2007   
 # -- Table   :    
 # -- Purpose : GET SERVICE PROVIDER W/O REJECTED HISTORY   
 #####################################################################*/   
  FUNCTION GET_VNDR_WO_RJCT_HIS_FNC    
  (   
           pi_trsp_so_ofc_cty_cd    TRS_TRSP_SVC_ORD.TRSP_SO_OFC_CTY_CD%TYPE   
       ,   pi_trsp_so_seq           TRS_TRSP_SVC_ORD.TRSP_SO_SEQ%TYPE   
       ,   pi_vndr_seq              MDM_VENDOR.VNDR_SEQ%TYPE   
  ) RETURN VARCHAR2;      
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JUNE 15, 2007   
 # -- Table   :    
 # -- Purpose : GET CONVERSION ACTIVITY GROUP CODE   
 #####################################################################*/   
  FUNCTION GET_CONV_ACT_GRP_CD_FNC    
  (   
           pi_so_tp_cd    VARCHAR2   
       ,   pi_act_grp_cd  VARCHAR2              
  ) RETURN VARCHAR2;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 23, 2007   
 # -- Table   :    
 # -- Purpose : GET LOGISTIC COST CODE   
 #####################################################################*/   
  FUNCTION GET_LGS_COST_CD_FNC    
  (   
           pi_act_grp_cd       VARCHAR2     
       ,   pi_so_tp_cd         VARCHAR2   
       ,   pi_eq_knd_cd         VARCHAR2   
       ,   pi_cost_mod_cd      VARCHAR2              
       ,   pi_crr_mod_cd       VARCHAR2   
       ,   pi_cgo_tp_cd        VARCHAR2     
       ,   pi_from_nod_cd      VARCHAR2   
       ,   pi_to_nod_cd        VARCHAR2       
       ,   pi_rail_com_ind_cd  VARCHAR2                  
  ) RETURN VARCHAR2;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 23, 2007   
 # -- Table   :    
 # -- Purpose : GET LOGISTIC COST CODE   
 #####################################################################*/   
  FUNCTION GET_RAIL_LGS_COST_CD_FNC    
  (   
           pi_rail_com_ind_cd    VARCHAR2           -- 'HJS' 'DOM' 'NIS' NULL      
       ,   pi_trsp_so_ofc_cty_cd VARCHAR2     
       ,   pi_cgo_tp_cd          VARCHAR2     
       ,   pi_from_nod_cd        VARCHAR2   
       ,   pi_to_nod_cd          VARCHAR2       
       
  ) RETURN VARCHAR2;       
   
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 23, 2007   
 # -- Table   :    
 # -- Purpose : GET ACCOUNT CODE   
 #####################################################################*/   
  FUNCTION GET_ACCT_CD_FROM_TES_FNC    
  (   
           pi_lgs_cost_cd    VARCHAR2   
  ) RETURN NUMBER;      
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 23, 2007   
 # -- Table   :    
 # -- Purpose : GET ACCOUNT CODE   
 #####################################################################*/   
  FUNCTION GET_ACCT_CD_FNC    
  (   
           pi_act_grp_cd       VARCHAR2     
       ,   pi_so_tp_cd         VARCHAR2   
       ,   pi_eq_knd_cd         VARCHAR2   
       ,   pi_cost_mod_cd      VARCHAR2              
       ,   pi_crr_mod_cd       VARCHAR2   
       ,   pi_cgo_tp_cd        VARCHAR2     
       ,   pi_from_nod_cd      VARCHAR2   
       ,   pi_to_nod_cd        VARCHAR2       
       ,   pi_rail_com_ind_cd  VARCHAR2                    
  ) RETURN NUMBER;      
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 23, 2007   
 # -- Table   :    
 # -- Purpose : GET ACCOUNT CODE   
 #####################################################################*/   
  FUNCTION GET_RAIL_ACCT_CD_FNC    
  (   
           pi_rail_com_ind_cd    VARCHAR2           -- 'HJS' 'DOM' 'NIS' NULL      
       ,   pi_trsp_so_ofc_cty_cd VARCHAR2     
       ,   pi_cgo_tp_cd          VARCHAR2     
       ,   pi_from_nod_cd        VARCHAR2   
       ,   pi_to_nod_cd          VARCHAR2                    
  ) RETURN NUMBER;     
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JUL 30, 2007   
 # -- Table   :    
 # -- Purpose : GET SURCHARGE ACCOUNT CODE   
 #####################################################################*/   
  FUNCTION GET_SCG_ACCT_CD_FNC    
  (   
           pi_scg_lgs_cost_cd       VARCHAR2     
  ) RETURN NUMBER;      
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JUNE 25, 2007   
 # -- Table   :    
 # -- Purpose : GET SURCHARGE SUM AMOUNT   
 #####################################################################*/   
  FUNCTION GET_SCG_DTL_SUM_AMT_FNC    
  (   
           pi_trsp_so_ofc_cty_cd    VARCHAR2           
       ,   pi_trsp_so_seq           NUMBER   
       ,   pi_scg_knd_cd            VARCHAR2  DEFAULT 'WO'   
  ) RETURN NUMBER;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JUNE 25, 2007   
 # -- Table   :    
 # -- Purpose : GET SURCHARGE SUM AMOUNT   
 #####################################################################*/   
  FUNCTION GET_SCG_DTL_XCH_RT_AMT_FNC    
  (   
           pi_trsp_so_ofc_cty_cd    VARCHAR2           
       ,   pi_trsp_so_seq           NUMBER   
       ,   pi_inv_curr_cd           VARCHAR2   
       ,   pi_trsp_inv_calc_lgc_tp_cd       VARCHAR2          
       ,   pi_scg_knd_cd            VARCHAR2  DEFAULT 'WO'   
  ) RETURN NUMBER;       
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 11, 2007   
 # -- Table   : *.*   
 # -- Purpose : FIND BOOKING REVENUE VVD   
 #####################################################################*/   
  FUNCTION GET_BKG_REV_VVD_FNC(   
           in_bkg_no            IN       VARCHAR2   
    ,      in_us_rail_yn        IN       VARCHAR2 -- US RAIL 여부 (Y : US RAIL, 나머지 : N)   
  )   
  RETURN VARCHAR2;     
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 11, 2007   
 # -- Table   : *.*   
 # -- Purpose : FIND BOOKING REVENUE VVD   
 #####################################################################*/   
  FUNCTION GET_RVIS_BKG_REV_VVD_FNC(   
           pi_bkg_no            IN       VARCHAR2  
    ,      pi_rvis_bkg_no       IN       VARCHAR2   
    ,      pi_wrk_cre_dt        IN       DATE   
  )   
  RETURN VARCHAR2   
  ;     
          
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : MAY 13, 2008   
 # -- Table   : *.*   
 # -- Purpose : FIND BOOKING REVENUE VVD (Considering CFDR)   
 #####################################################################*/   
  FUNCTION GET_BKG_REV_VVD2_FNC(   
           pi_ap_ofc_cd             IN      VARCHAR2  
     ,     pi_inv_dt                IN      VARCHAR2  
     ,     pi_bkg_no                IN      VARCHAR2  
       
  )   
  RETURN VARCHAR2;         
       
       
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : JUNE 6, 2008   
 # -- Table   : *.*   
 # -- Purpose : Other S/O Generating R.VVD (Full Contaienr Only)   
 #####################################################################*/   
  FUNCTION GET_BKG_REV_VVD3_FNC(  
           pi_ap_ofc_cd             IN       VARCHAR2  
    ,      pi_inv_dt                IN       VARCHAR2   
    ,      pi_trsp_so_tp_cd         IN       VARCHAR2   
    ,      pi_trsp_so_ofc_cty_cd    IN       VARCHAR2   
    ,      pi_trsp_so_seq           IN       NUMBER   
    ,      pi_eq_knd_cd             IN       VARCHAR2   
    ,      pi_cgo_tp_cd             IN       VARCHAR2      
    ,      pi_bkg_no                IN       VARCHAR2   
    ,      pi_ref_bkg_no            IN       VARCHAR2   
    ,      pi_vsl_cd                IN       VARCHAR2   
    ,      pi_skd_voy_no            IN       VARCHAR2   
    ,      pi_skd_dir_cd            IN       VARCHAR2   
    ,      pi_trsp_otr_cost_mon_dt  IN       VARCHAR2  
  )   
  RETURN VARCHAR2;        
     
 /*###################################################################   
 # -- Author  : JEONG SANG-KI   
 # -- Created : SEP 18, 2007   
 # -- Table   : COP_COST_ACT_GRP_SEQ   
 # -- Purpose : TRS CONTROL OFFICE EXCEPTION RULE APPLY TO COP   
 #####################################################################*/   
  PROCEDURE SET_CTRLOFC_EXPRULE_TO_COP_PRC    
  (   
           p_cop_no         IN  SCE_COP_HDR.COP_NO%TYPE   
      ,    p_rtn_value      OUT NUMBER   
  )   
  ;   
     
-- /*###################################################################   
-- # -- Author  : JEONG SANG-KI   
-- # -- Created : NOV 27, 2007   
-- # -- Table   : TRS_TRSP_USA_ACT_CUST + TRS_TRSP_USA_ACT_CUST_DTL   
-- # -- Purpose : TRS CONTROL OFFICE EXCEPTION RULE APPLY TO EQR   
-- #####################################################################*/   
--  PROCEDURE GET_ACTUAL_CUSTOMER_INFO_PRC    
--  (   
--           pi_conti_cd                   IN  TRS_TRSP_SVC_ORD.CONTI_CD%TYPE   
--      ,    pi_bound_cd                   IN  TRS_TRSP_SVC_ORD.TRSP_BND_CD%TYPE   
--      ,    pi_cnee_cnt_cd                IN  TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE   
--      ,    pi_cnee_seq                   IN  TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE   
--      ,    pi_shpr_cnt_cd                IN  TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE   
--      ,    pi_shpr_seq                   IN  TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE         
--      ,    pi_door_nod_cd                IN  TRS_TRSP_SVC_ORD.DOR_NOD_CD%TYPE   
--         
--      ,    po_rtn_value                  OUT NUMBER           
--   
--      ,    po_act_cust_cnt_cd            OUT TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE   
--      ,    po_act_cust_seq               OUT TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE   
--      ,    po_act_cust_addr_seq          OUT TRS_TRSP_SVC_ORD.ACT_CUST_ADDR_SEQ%TYPE   
--   
--      ,    po_act_cust_fctry_pst_cd      OUT TRS_TRSP_SVC_ORD.DOR_PST_CD%TYPE   
--      ,    po_act_cust_fctry_nm          OUT TRS_TRSP_SVC_ORD.FCTRY_NM%TYPE   
--      ,    po_act_cust_fctry_addr        OUT TRS_TRSP_SVC_ORD.DOR_DE_ADDR%TYPE   
--      ,    po_act_cust_fctry_phn_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_PHN_NO%TYPE   
--      ,    po_act_cust_fctry_fax_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_FAX_NO%TYPE   
--      ,    po_act_cust_fctry_pic_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_NM%TYPE   
--   
--      ,    po_act_cust_eml               OUT TRS_TRSP_USA_ACT_CUST_DTL.ACT_CUST_EML%TYPE   
--      ,    po_act_cust_rmk               OUT TRS_TRSP_USA_ACT_CUST_DTL.ACT_CUST_RMK%TYPE         
--  )   
--  ;      
     
 /*###################################################################   
 # -- Author  : PARK JUN-YONG   
 # -- Created : JUL 21, 2008   
 # -- Table   : TRS_TRSP_SVC_ORD   
 # -- Purpose : GET YARD NAME FROM YARD NODE    
 #####################################################################*/   
  FUNCTION GET_YD_CD_NM_FNC    
  (   
           pi_yd_cd            IN       VARCHAR2   
  )    
  RETURN VARCHAR2     
  ;     
  
$END  
END TRS_COMMON_PKG;
/

CREATE OR REPLACE PACKAGE BODY OPUSADM.TRS_COMMON_PKG IS
  
  /*###################################################################  
 # -- Type    : FUNCTION   
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAR 09, 2007  
 # -- Table   : MDM_CNTR_TP_SZ  
 # -- Purpose : GET CONTAINER TARE WEIGHT(default KG)  
 #####################################################################*/  
  FUNCTION GET_CNTR_TARE_WGT_TO_UOM_FNC   
  (  
           pi_to_wgt_uom       VARCHAR2  
      ,    pi_cntr_tp_sz       VARCHAR2  
  ) RETURN NUMBER  
 
  IS  
      
    v_wgt_value MDM_CNTR_TP_SZ.CNTR_TPSZ_TARE_WGT%TYPE ;  
      
    C_KG                       CONSTANT VARCHAR(3)   := 'KG'     ;  
    C_LBS                      CONSTANT VARCHAR(3)   := 'LBS'    ;  
    C_CONV_KG_FROM_LBS         CONSTANT NUMBER(10,6) := 0.453599 ;      
  
  BEGIN   
      
    /* 1 lbs = 0.453599kg */  
          
    SELECT X.CNTR_TPSZ_TARE_WGT  
    INTO   v_wgt_value  
    FROM   MDM_CNTR_TP_SZ X  
    WHERE  X.CNTR_TPSZ_CD = pi_cntr_tp_sz   
    ;  
      
    IF SUBSTR(UPPER(pi_to_wgt_uom),1,2) = C_KG THEN  
        v_wgt_value := v_wgt_value;  
    ELSIF UPPER(pi_to_wgt_uom) = C_LBS THEN  
        v_wgt_value := ROUND(v_wgt_value / C_CONV_KG_FROM_LBS, 3);  
    ELSE  
        v_wgt_value := -1;  
    END IF;  
      
    RETURN v_wgt_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CNTR_TARE_WGT_TO_UOM_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CNTR_TARE_WGT_TO_UOM_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END GET_CNTR_TARE_WGT_TO_UOM_FNC;    
 
  /*###################################################################  
 # -- Type    : FUNCTION   
 # -- Author  : JEONG SANG-KI  
 # -- Created : JAN 03, 2007  
 # -- Table   : TRS_TRSP_AGMT_*  
 # -- Purpose : GET WEIGHT CONVERSION TO KILOGRAM  
 #####################################################################*/  
  FUNCTION GET_CONV_WGT_TO_KG_FNC   
  (  
           pi_wgt_uom          VARCHAR2  
      ,    pi_wgt_qty          NUMBER  
  ) RETURN NUMBER  
 
  IS  
      
    C_KG                       CONSTANT VARCHAR(3)   := 'KG'     ;  
    C_LBS                      CONSTANT VARCHAR(3)   := 'LBS'    ;  
    C_CONV_KG_FROM_LBS         CONSTANT NUMBER(10,6) := 0.453599 ;  
      
    v_wgt_value NUMBER (18,3) := 0;  
  
  BEGIN    
    
    /* 1 lbs = 0.453599kg */  
      
    IF SUBSTR(UPPER(pi_wgt_uom),1,2) = C_KG THEN  
        v_wgt_value := pi_wgt_qty;  
    ELSIF UPPER(pi_wgt_uom) = C_LBS THEN  
        v_wgt_value := ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3);  
    ELSE  
        v_wgt_value := -1;  
    END IF;  
      
    RETURN v_wgt_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_KG_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_KG_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END;  
 
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : DEC 13, 2006  
 # -- Table   : GL_MON_XCH_RT  
 # -- Purpose : LOCAL CURRENCY >> USD   
 #####################################################################*/  
  FUNCTION GET_CONVERSION_USD_AMT_FNC   
  (  
           p_local_curr_cd  IN VARCHAR2  
      ,    p_local_amt      IN NUMBER  
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')  
  ) RETURN NUMBER  
 
  IS  
    v_conv_amt NUMBER  (18,3) := 0 ;  
    v_basis_ym VARCHAR2(6)    := '';  
  BEGIN    
  
    IF p_basis_dt IS NULL OR NVL(LENGTH(p_basis_dt),0) < 6 THEN  
        v_basis_ym := TO_CHAR(SYSDATE, 'YYYYMM');  
    ELSE  
        v_basis_ym := SUBSTR(p_basis_dt, 1, 6)  ;  
    END IF;  
    
    IF p_local_amt = 0 THEN  
        v_conv_amt := 0;        
    ELSE  
      
        /* Local Currency -->> USD Currency */      
        SELECT ROUND((p_local_amt / RAT.USD_LOCL_XCH_RT), 3)  
        INTO   v_conv_amt  
        FROM   GL_MON_XCH_RT RAT  
        WHERE  RAT.CURR_CD              = UPPER(p_local_curr_cd)  
        AND    RAT.ACCT_XCH_RT_LVL      = '1'  
        AND    RAT.ACCT_XCH_RT_YRMON    = v_basis_ym  
        ;       
      
    END IF;  
    
    RETURN v_conv_amt;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_USD_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_USD_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
    
  END;  
 
/*###################################################################  
# PRS BATCH COMPILE CONDITION 
# Description : PRS 에서 사용하는 OLTP PROCEDURE 가 BATCH 에서 OBJECT 차이로 COMPILE 이 안되는 문제를 해결하기 위하여 생성함. 
                CC_CTRL_FLG  값이 OLTP DB 에서는 1, BATCH DB 에서는 2 를 갖는다. 
###################################################################*/ 
$IF PRI_PRS_CC_CTRL_PKG.CC_CTRL_FLG = 1 $THEN 
 
 
 
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JAN 14, 2008  
 # -- Table   : GL_MON_XCH_RT  
 # -- Purpose : 평균환율   
 #####################################################################*/    
  FUNCTION GET_CONVERSION_AVG_USD_AMT_FNC   
  (  
           p_local_curr_cd  IN VARCHAR2  
      ,    p_local_amt      IN NUMBER  
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')  
  ) RETURN NUMBER  
 
  IS  
    v_conv_amt NUMBER  (18,3) := 0 ;  
    v_basis_ym VARCHAR2(6)    := '';  
  BEGIN    
  
    IF p_basis_dt IS NULL OR NVL(LENGTH(p_basis_dt),0) < 6 THEN  
        v_basis_ym := TO_CHAR(SYSDATE, 'YYYYMM');  
    ELSE  
        v_basis_ym := SUBSTR(p_basis_dt, 1, 6)  ;  
    END IF;  
    
    IF p_local_amt = 0 THEN  
        v_conv_amt := 0;        
    ELSE  
      
        /* Local Currency -->> USD Currency */      
        SELECT ROUND((p_local_amt / RAT.USD_LOCL_XCH_RT), 3)  
        INTO   v_conv_amt  
        FROM   GL_MON_XCH_RT RAT  
        WHERE  RAT.CURR_CD              = UPPER(p_local_curr_cd)  
        AND    RAT.ACCT_XCH_RT_LVL      = '3'  
        AND    RAT.ACCT_XCH_RT_YRMON    = v_basis_ym  
        ;       
      
    END IF;  
    
    RETURN v_conv_amt;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_AVG_USD_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_AVG_USD_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
    
  END;      
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUNE 13, 2007  
 # -- Table   : GL_MON_XCH_RT  
 # -- Purpose : LOCAL CURRENCY >> USD   
 #####################################################################*/  
  FUNCTION GET_CONVERSION_EUR_AMT_FNC   
  (  
           p_local_curr_cd  IN VARCHAR2  
      ,    p_local_amt      IN NUMBER  
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')  
  ) RETURN NUMBER  
 
  IS  
    v_conv_amt NUMBER  (18,3) := 0 ;  
    v_basis_ym VARCHAR2(6)    := '';  
  BEGIN    
  
    IF p_basis_dt IS NULL OR NVL(LENGTH(p_basis_dt),0) < 6 THEN  
        v_basis_ym := TO_CHAR(SYSDATE, 'YYYYMM');  
    ELSE  
        v_basis_ym := SUBSTR(p_basis_dt, 1, 6)  ;  
    END IF;    
    
    IF p_local_amt = 0 THEN  
        v_conv_amt := 0;        
    ELSE  
      
        /* Local Currency -->> EUR Currency */      
        SELECT ROUND( (p_local_amt/USD.USD_LOCL_XCH_RT) * EUR.USD_LOCL_XCH_RT, 3)         
        INTO   v_conv_amt          
        FROM   GL_MON_XCH_RT USD, GL_MON_XCH_RT EUR                                       
        WHERE  USD.CURR_CD                              = UPPER(p_local_curr_cd)                                  
        AND    EUR.CURR_CD                              = 'EUR'                           
        AND    USD.ACCT_XCH_RT_LVL              = '1'                             
        AND    USD.ACCT_XCH_RT_LVL              = EUR.ACCT_XCH_RT_LVL             
        AND    USD.ACCT_XCH_RT_YRMON            = EUR.ACCT_XCH_RT_YRMON          
        AND    USD.ACCT_XCH_RT_YRMON            = v_basis_ym  
        ;     
    
    END IF;  
    
    RETURN v_conv_amt;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_EUR_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_EUR_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
    
  END;    
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAR 09, 2007  
 # -- Table   : GL_MON_XCH_RT  
 # -- Purpose : FROM ORIGINAL CURRENCY TO DISTINATION CURRENCY   
 #####################################################################*/  
  FUNCTION GET_CONVERSION_TO_CURR_AMT_FNC   
  (  
           p_from_curr_cd  IN VARCHAR2     /* Original Currency Code */  
      ,    p_to_curr_cd    IN VARCHAR2     /* Conversion Destination Currency Code */  
      ,    p_basis_ym      IN VARCHAR2     /* ????('YYYYMM')     */  
      ,    p_original_amt  IN NUMBER       /* Original Amount        */  
  ) RETURN NUMBER      
 
                     /* Conversion Amount */  
  IS  
    v_conv_amt NUMBER (18,3) := 0;  
      
    USER_DEFINE_ERROR   EXCEPTION;  
  BEGIN    
  
/*---------------------------------------  
LOCAL CURRENCY >> USD  
  
SELECT ROUND((TSO.BZC_AMT / RAT.USD_LOCL_XCH_RT),2)  
FROM   TRS_TRSP_SVC_ORD TSO, GL_MON_XCH_RT RAT  
WHERE  TSO.CURR_CD              = RAT.CURR_CD  
AND    RAT.ACCT_XCH_RT_LVL      = '1'  
AND    RAT.ACCT_XCH_RT_YRMON    = TO_CHAR(TSO.CRE_DT,'YYYYMM')  
AND    TSO.TRSP_SO_OFC_CTY_CD   = ?  
AND    TSO.TRSP_SO_SEQ          = ?   
  
========================================================================================  
              
LOCAL CURRENCY >> EUR  
  
SELECT ROUND((SO.BZC_AMT / USD.USD_LOCL_XCH_RT)*EUR.USD_LOCL_XCH_RT,2)  
FROM   TRS_TRSP_SVC_ORD SO, GL_MON_XCH_RT USD, GL_MON_XCH_RT EUR  
WHERE  SO.CURR_CD              = USD.CURR_CD  
AND    EUR.CURR_CD             = 'EUR'  
AND    USD.ACCT_XCH_RT_LVL      = '1'  
AND    USD.ACCT_XCH_RT_LVL      = EUR.ACCT_XCH_RT_LVL  
AND    USD.ACCT_XCH_RT_YRMON    = TO_CHAR(SO.CRE_DT,'YYYYMM')  
AND    USD.ACCT_XCH_RT_YRMON    = EUR.ACCT_XCH_RT_YRMON               
---------------------------------------*/  
    
    IF LENGTH(p_basis_ym) != 6 AND p_basis_ym <= 0 THEN  
        RAISE USER_DEFINE_ERROR;  
    END IF;  
    
    IF p_original_amt = 0 THEN  
      
        v_conv_amt := 0;        
      
    ELSIF p_to_curr_cd = 'USD' THEN  
          
        /* Local Currency -->> USD Currency */  
        SELECT ROUND((p_original_amt / RAT.USD_LOCL_XCH_RT), 3)  
        INTO   v_conv_amt  
        FROM   GL_MON_XCH_RT RAT  
        WHERE  RAT.CURR_CD              = UPPER(p_from_curr_cd)  
        AND    RAT.ACCT_XCH_RT_LVL      = '1'  
        AND    RAT.ACCT_XCH_RT_YRMON    = p_basis_ym   
        ;  
          
    ELSIF p_to_curr_cd = 'EUR' THEN  
          
        /* Local Currency -->> EUR Currency */      
        SELECT ROUND( (p_original_amt/USD.USD_LOCL_XCH_RT) * EUR.USD_LOCL_XCH_RT, 3)          
        INTO   v_conv_amt          
        FROM   GL_MON_XCH_RT USD, GL_MON_XCH_RT EUR                                       
        WHERE  USD.CURR_CD                              = UPPER(p_to_curr_cd)                                 
        AND    EUR.CURR_CD                              = 'EUR'                           
        AND    USD.ACCT_XCH_RT_LVL              = '1'                             
        AND    USD.ACCT_XCH_RT_LVL              = EUR.ACCT_XCH_RT_LVL             
        AND    USD.ACCT_XCH_RT_YRMON            = EUR.ACCT_XCH_RT_YRMON          
        AND    USD.ACCT_XCH_RT_YRMON            = p_basis_ym  
        ;       
          
    ELSE  
              
        RAISE USER_DEFINE_ERROR;  
          
    END IF;  
    
    RETURN v_conv_amt;  
    
  EXCEPTION  
      WHEN USER_DEFINE_ERROR THEN   
          RETURN -9;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_CURR_AMT_FNC%% <USER_DEFINE_ERROR> ERROR MSG = ['||SQLERRM||']');    
      WHEN NO_DATA_FOUND THEN   
          RETURN -2;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_CURR_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN TOO_MANY_ROWS THEN   
          RETURN -3;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_CURR_AMT_FNC%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_CURR_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
    
  END GET_CONVERSION_TO_CURR_AMT_FNC;    
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JAN 18, 2007  
 # -- Table   : GL_MON_XCH_RT  
 # -- Purpose : Kilometers, Miles >> Kilometers   
 #####################################################################*/  
  FUNCTION GET_CONV_DIST_TO_KM_FNC   
  (  
           p_dist_uom_cd  IN VARCHAR2  
      ,    p_dist_qty     IN NUMBER  
  ) RETURN NUMBER  
 
  IS  
    C_KM CONSTANT VARCHAR2(2) := 'KM';  
    C_ML CONSTANT VARCHAR2(2) := 'ML';  
    C_KM_FROM_ML_RATE CONSTANT NUMBER(10,6) := '1.609347';  
    
    v_rtn_value NUMBER (18,3) := 0;  
  BEGIN    
  
    IF UPPER(p_dist_uom_cd) = C_KM THEN  
       v_rtn_value := p_dist_qty;  
    ELSIF UPPER(p_dist_uom_cd) = C_ML THEN  
       v_rtn_value := ROUND(p_dist_qty * C_KM_FROM_ML_RATE, 3);  
    ELSE  
        v_rtn_value := 0;        
    END IF;  
    
    RETURN v_rtn_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_DIST_TO_KM_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_DIST_TO_KM_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');            
            
  END;       
    
 
    
  /*###################################################################  
 # -- Type    : FUNCTION   
 # -- Author  : JEONG SANG-KI  
 # -- Created : SEP 13, 2007  
 # -- Table   : BKG_BKG_CNTR  
 # -- Purpose : GET CONTAINER WEIGHT CONVERSION TO KILOGRAM  
 #####################################################################*/  
  FUNCTION GET_CONV_WGT_TO_KGS_FNC   
  (  
           pi_cntr_wgt_uom          VARCHAR2  
      ,    pi_cntr_wgt_qty          NUMBER  
  ) RETURN NUMBER  
 
  IS  
      
    C_KGS                      CONSTANT VARCHAR(3)   := 'K'      ;  
    C_LBS                      CONSTANT VARCHAR(3)   := 'L'      ;  
    C_CONV_KG_FROM_LBS         CONSTANT NUMBER(10,6) := 0.453599 ;  
      
    v_wgt_value NUMBER (18,3) := 0;  
  
  BEGIN    
    
    /* 1 lbs = 0.453599kg */  
      
    IF SUBSTR(UPPER(pi_cntr_wgt_uom),1,1) = C_KGS THEN  
        v_wgt_value := pi_cntr_wgt_qty;  
    ELSIF SUBSTR(UPPER(pi_cntr_wgt_uom),1,1) = C_LBS THEN  
        v_wgt_value := ROUND(pi_cntr_wgt_qty * C_CONV_KG_FROM_LBS, 3);  
    ELSE  
        v_wgt_value := 0.000;  
    END IF;  
      
    RETURN v_wgt_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_KGS_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_KGS_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END;  
    
  /*###################################################################  
 # -- Type    : FUNCTION   
 # -- Author  : JEONG SANG-KI  
 # -- Created : SEP 13, 2007  
 # -- Table   : BKG_BKG_CNTR  
 # -- Purpose : GET CONTAINER WEIGHT CONVERSION TO POUND  
 #####################################################################*/  
  FUNCTION GET_CONV_WGT_TO_LBS_FNC   
  (  
           pi_cntr_wgt_uom          VARCHAR2  
      ,    pi_cntr_wgt_qty          NUMBER  
  ) RETURN NUMBER  
 
  IS  
      
    C_KGS                      CONSTANT VARCHAR(3)   := 'K'      ;  
    C_LBS                      CONSTANT VARCHAR(3)   := 'L'      ;  
    C_CONV_KG_FROM_LBS         CONSTANT NUMBER(10,6) := 0.453599 ;  
      
    v_wgt_value NUMBER (18,3) := 0;  
  
  BEGIN    
    
    /* 1 lbs = 0.453599kg */  
      
    IF SUBSTR(UPPER(pi_cntr_wgt_uom),1,1) = C_LBS THEN     
        v_wgt_value := pi_cntr_wgt_qty;   
    ELSIF SUBSTR(UPPER(pi_cntr_wgt_uom),1,1) = C_KGS THEN  
        v_wgt_value := ROUND(pi_cntr_wgt_qty / C_CONV_KG_FROM_LBS, 3);  
    ELSE  
        v_wgt_value := 0.000;  
    END IF;  
      
    RETURN v_wgt_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_LBS_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN -1;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_WGT_TO_LBS_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END;      
    
  
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : NOV 03, 2006  
 # -- Table   :   
 # -- Purpose : GET SERVICE PROVIDER ABBR_NM  
 #####################################################################*/  
  FUNCTION GET_VNDR_ABBR_NM_FNC   
  (  
           pi_vndr_seq          NUMBER  
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value MDM_VENDOR.VNDR_ABBR_NM%TYPE;  
    
  BEGIN  
        
      SELECT X.VNDR_ABBR_NM  
      INTO   v_rtn_value  
      FROM   MDM_VENDOR X  
      WHERE  X.VNDR_SEQ = pi_vndr_seq  
      ;  
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_ABBR_NM_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_ABBR_NM_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END;       
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : NOV 03, 2006  
 # -- Table   :   
 # -- Purpose : GET SERVICE PROVIDER ABBR_NM  
 #####################################################################*/  
  FUNCTION GET_VNDR_FULL_NM_FNC   
  (  
           pi_vndr_seq          NUMBER  
         , pi_local_cnt_cd      VARCHAR2 DEFAULT 'ENG'  /* DEFAULT+ENG : ENGLISH NAME, OTHERS : LOCAL NAME */             
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value MDM_VENDOR.VNDR_LGL_ENG_NM%TYPE;  
    
  BEGIN  
        
      /* ENGLISH FULL NAME */  
      IF pi_local_cnt_cd = 'ENG' THEN  
          SELECT X.VNDR_LGL_ENG_NM  
          INTO   v_rtn_value  
          FROM   MDM_VENDOR X  
          WHERE  X.VNDR_SEQ = pi_vndr_seq  
          ;  
            
      /* LOCAL FULL NAME */  
      ELSE  
          SELECT X.VNDR_LOCL_LANG_NM  
          INTO   v_rtn_value  
          FROM   MDM_VENDOR X  
          WHERE  X.VNDR_SEQ = pi_vndr_seq  
          ;  
      END IF;  
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_FULL_NM_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN TOO_MANY_ROWS THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_FULL_NM_FNC%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');            
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_FULL_NM_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');             
    
  END;      
       
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : FEB 15, 2007  
 # -- Table   :   
 # -- Purpose : GET SERVICE PROVIDER W/O REJECTED HISTORY  
 #####################################################################*/  
  FUNCTION GET_VNDR_WO_RJCT_HIS_FNC   
  (  
           pi_trsp_so_ofc_cty_cd    TRS_TRSP_SVC_ORD.TRSP_SO_OFC_CTY_CD%TYPE  
       ,   pi_trsp_so_seq           TRS_TRSP_SVC_ORD.TRSP_SO_SEQ%TYPE  
       ,   pi_vndr_seq              MDM_VENDOR.VNDR_SEQ%TYPE  
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value VARCHAR2(1);  
    
  BEGIN  
        
      SELECT NVL(MAX(CASE WHEN X.WO_RJCT_DT IS NOT NULL THEN 'Y' ELSE 'N' END), 'N')  
      INTO   v_rtn_value  
      FROM   TRS_TRSP_WRK_ORD_RJCT_HIS X   
      WHERE  X.WO_RJCT_DT IS NOT NULL   
      AND    X.TRSP_SO_OFC_CTY_CD  = pi_trsp_so_ofc_cty_cd  
      AND    X.TRSP_SO_SEQ         = pi_trsp_so_seq   
      AND    X.WO_VNDR_SEQ         = pi_vndr_seq  
      ;  
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_WO_RJCT_HIS_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_VNDR_WO_RJCT_HIS_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;  
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUNE 15, 2007  
 # -- Table   :   
 # -- Purpose : GET CONVERSION ACTIVITY GROUP CODE  
 #####################################################################*/  
  FUNCTION GET_CONV_ACT_GRP_CD_FNC   
  (  
           pi_so_tp_cd    VARCHAR2  
       ,   pi_act_grp_cd  VARCHAR2    
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value                  VARCHAR2(4)        ;  
    v_trs_lgs_cost_cd_exist_flag VARCHAR2(1)        ;  
      
    USER_DEFINE_ERROR            EXCEPTION          ;      
    
  BEGIN  
        
  /******************************  
  * S/O TYPE CODE  
  * ----------------------------  
  * Y   : CY/DOOR  
  * H   : CHASSIS/GENSET  
  * M   : MT REPO  
  * O   : OTHER  
  * S   : SUPPLEMENT  
  * R   : RAIL BILLING  
  *******************************/  
    
  DBMS_OUTPUT.enable;  
    
  IF    pi_so_tp_cd = 'Y' THEN  
      IF    pi_act_grp_cd = 'NTST' THEN  
          v_rtn_value := 'TYTD';  
            
      ELSIF pi_act_grp_cd = 'NOBY' OR pi_act_grp_cd = 'NOBT' OR pi_act_grp_cd = 'DMLK' THEN  
          v_rtn_value := 'OYTD';  
            
      ELSIF pi_act_grp_cd = 'NIBT' THEN  
          v_rtn_value := 'IYTD';  
            
      ELSIF pi_act_grp_cd = 'VSSL' THEN  
          v_rtn_value := 'POWD';  
            
      ELSE  
          v_rtn_value := pi_act_grp_cd;  
      END IF;            
                  
  ELSE  
    
      RAISE USER_DEFINE_ERROR;  
    
  END IF;  
    
  SELECT NVL2(MAX(X.LGS_COST_CD), 'Y', 'N')  
  INTO   v_trs_lgs_cost_cd_exist_flag  
  FROM   TRS_LGS_COST_CD_CONV_RULE X  
  WHERE  X.COST_ACT_GRP_CD              = v_rtn_value  
  ;  
    
  IF v_trs_lgs_cost_cd_exist_flag != 'Y' THEN  
      RAISE USER_DEFINE_ERROR;  
  END IF;  
    
  DBMS_OUTPUT.PUT_LINE('CONVERSION TRS LGS COST CD = ['||v_rtn_value||']');     
        
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN USER_DEFINE_ERROR THEN   
          RETURN -9;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_ACT_GRP_CD_FNC%% <USER_DEFINE_ERROR> ERROR MSG = ['||SQLERRM||']');     
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_ACT_GRP_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_CONV_ACT_GRP_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;      
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 23, 2007  
 # -- Table   :   
 # -- Purpose : GET LOGISTIC COST CODE  
 #####################################################################*/  
  FUNCTION GET_LGS_COST_CD_FNC   
  (  
           pi_act_grp_cd       VARCHAR2    
       ,   pi_so_tp_cd         VARCHAR2  
       ,   pi_eq_knd_cd         VARCHAR2  
       ,   pi_cost_mod_cd      VARCHAR2             
       ,   pi_crr_mod_cd       VARCHAR2  
       ,   pi_cgo_tp_cd        VARCHAR2    
       ,   pi_from_nod_cd      VARCHAR2  
       ,   pi_to_nod_cd        VARCHAR2      
       ,   pi_rail_com_ind_cd  VARCHAR2           -- 'HJS' 'DOM' 'SEN'    
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value              VARCHAR2(6)        ;  
  
    v_conv_cost_mod_cd       VARCHAR2(2)        ;  
    v_conv_crr_mod_cd        VARCHAR2(2)        ;  
      
    USER_DEFINE_ERROR        EXCEPTION          ;      
    
  BEGIN  
        
  /******************************  
  * S/O TYPE CODE  
  * ----------------------------  
  * Y   : CY/DOOR  
  * H   : CHASSIS/GENSET  
  * M   : MT REPO  
  * O   : OTHER  
  * S   : SUPPLEMENT  
  * R   : RAIL BILLING  
  *******************************/  
    
  DBMS_OUTPUT.enable;  
    
    
  IF    pi_crr_mod_cd = 'TR' THEN  
      v_conv_crr_mod_cd := 'RT';  
  ELSIF pi_crr_mod_cd = 'RW' THEN  
      v_conv_crr_mod_cd := 'WR';  
  ELSIF pi_crr_mod_cd = 'TW' THEN  
      v_conv_crr_mod_cd := 'WT';  
  ELSE  
      v_conv_crr_mod_cd := pi_crr_mod_cd;    
  END IF  
  ;    
  
  IF    pi_so_tp_cd = 'Y' THEN  
    
      IF pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN  
        
          SELECT        X.LGS_COST_CD  
          INTO          v_rtn_value  
          FROM          TRS_LGS_COST_CD_CONV_RULE X  
          WHERE         X.COST_ACT_GRP_CD              = pi_act_grp_cd  
          AND           X.LGS_COST_CD_CHK_FLG     = DECODE(   SUBSTR(pi_from_nod_cd,1,5)  
                                                            , SUBSTR(pi_to_nod_cd  ,1,5)  
                                                            , 'Y'  
                                                            , 'N'  
                                                          )  
          ;        
        
      ELSE  
          RAISE USER_DEFINE_ERROR;  
      END IF;    
        
  ELSIF pi_so_tp_cd = 'H' OR pi_so_tp_cd = 'G' THEN  
    
      /* GD, GN, GF, HD(-> CD), HN(-> CN), HF(-> CF) */  
      IF pi_cost_mod_cd = 'HD' OR pi_cost_mod_cd = 'HN' OR pi_cost_mod_cd = 'HF' THEN  
          v_conv_cost_mod_cd := 'C'||SUBSTR(pi_cost_mod_cd,2,1);  
      ELSE  
          v_conv_cost_mod_cd := pi_cost_mod_cd;  
      END IF;   
        
      v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
        
  ELSIF pi_so_tp_cd = 'O' THEN  
    
      IF pi_eq_knd_cd = 'U' THEN  
        
          /* OT(Full), MO(Empty) */  
          IF    pi_cgo_tp_cd = 'F' THEN  
              v_conv_cost_mod_cd := 'OT';  /* Other S/O Full Container  */  
          ELSIF pi_cgo_tp_cd = 'M' THEN    /* Other S/O Empty Container */  
              v_conv_cost_mod_cd := 'MO';  
          ELSE  
              v_conv_cost_mod_cd := '';  
          END IF;        
        
      /* HD -> CD, HN   -> CN, HF   -> CF */  
      ELSIF pi_eq_knd_cd = 'Z' THEN    
          v_conv_cost_mod_cd := 'C'||SUBSTR(pi_cost_mod_cd,2,1);  
        
      /* GD -> GD, GN   -> GN, GF   -> GF */  
      ELSIF pi_eq_knd_cd = 'G' THEN  
          v_conv_cost_mod_cd := pi_cost_mod_cd;  
      ELSE  
          RAISE USER_DEFINE_ERROR;  
      END IF;  
        
      v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
    
  -- Supplement S/O implements from Parent S/O  
  --ELSIF pi_so_tp_cd = 'S' THEN  
  --    v_conv_cost_mod_cd := 'OT';  
  --    v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
        
  ELSIF pi_so_tp_cd = 'M' AND pi_cgo_tp_cd = 'M' THEN  
    
      /* 'TRMTRD' 'TRMTTD' 'TRMTWD' */  
      --v_rtn_value := 'TR'||'MT'||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
        
      IF pi_cost_mod_cd = 'CF' THEN      -- MTY CONTAINER > SHORT TERM OFF-HIRE  
          v_conv_cost_mod_cd := 'OF';  
      ELSIF pi_cost_mod_cd = 'CN' THEN   -- MTY CONTAINER > SHORT TERM ON-HIRE  
          v_conv_cost_mod_cd := 'ON';  
      ELSE                               -- MTY CONTAINER > EMPTY-REPO  
          v_conv_cost_mod_cd := 'MT';  
      END IF  
      ;  
        
      v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
        
      IF SUBSTR(v_rtn_value,5,2) NOT IN ('RD', 'TD', 'WD') THEN  
          RAISE USER_DEFINE_ERROR;  
      END IF;  
        
  /*===============================  
  * 'HJS' - 'F' ACT_GRP_CD  
  *       - 'M' 'TRMTRD'  
  * -------------------------------  
  * 'DOM' - 'TRDMRD'  
  * -------------------------------  
  * ??  - 'TRLCRD'  
  *================================*/  
    
  ELSIF pi_so_tp_cd = 'R' THEN  
        
     IF pi_rail_com_ind_cd = 'HJS' THEN  
         IF pi_cgo_tp_cd = 'F' THEN  
            SELECT        DISTINCT  SUBSTR(X.LGS_COST_CD,3,2)  
            INTO          v_conv_cost_mod_cd  
            FROM          TRS_LGS_COST_CD_CONV_RULE X  
            WHERE         X.COST_ACT_GRP_CD              = 'IYRD'  
            AND           X.LGS_COST_CD_CHK_FLG     = DECODE(   SUBSTR(pi_from_nod_cd,1,5)  
                                                              , SUBSTR(pi_to_nod_cd  ,1,5)  
                                                              , 'Y'  
                                                              , 'N'  
                                                            )  
            ;             
         ELSIF pi_cgo_tp_cd = 'M' THEN  
             v_conv_cost_mod_cd := 'MT';  
         ELSE  
             RAISE USER_DEFINE_ERROR;  
         END IF;  
            
     ELSIF pi_rail_com_ind_cd = 'DOM' THEN  
         v_conv_cost_mod_cd := 'DM';  
     ELSE  
         v_conv_cost_mod_cd := 'LC';  
     END IF;  
        
     v_rtn_value := 'TR'||v_conv_cost_mod_cd||'RD';     
    
  ELSE  
      RAISE USER_DEFINE_ERROR;  
  END IF;    
        
       
  DBMS_OUTPUT.PUT_LINE('COST MODE CD = ['||v_conv_cost_mod_cd||'] --> CRR MODE CD = ['||v_conv_crr_mod_cd||']');     
        
  --v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
    
  DBMS_OUTPUT.PUT_LINE('LGS COST MODE CD = ['||v_rtn_value||']');     
    
/*  IF LENGTH(v_rtn_value) <> 6 THEN  
      RAISE USER_DEFINE_ERROR;  
  END IF;*/  
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN USER_DEFINE_ERROR THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <USER_DEFINE_ERROR> ERROR MSG = ['||SQLERRM||']');     
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;    
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 23, 2007  
 # -- Table   :   
 # -- Purpose : GET LOGISTIC COST CODE  
 #####################################################################*/  
  FUNCTION GET_RAIL_LGS_COST_CD_FNC   
  (  
           pi_rail_com_ind_cd    VARCHAR2           -- 'HJS' 'DOM' 'NIS' NULL     
       ,   pi_trsp_so_ofc_cty_cd VARCHAR2    
       ,   pi_cgo_tp_cd          VARCHAR2    
       ,   pi_from_nod_cd        VARCHAR2  
       ,   pi_to_nod_cd          VARCHAR2   
  ) RETURN VARCHAR2  
 
  IS  
    
    v_rtn_value              VARCHAR2(6)        ;  
  
    v_conv_cost_mod_cd       VARCHAR2(2)        ;  
    v_conv_crr_mod_cd        VARCHAR2(2)        ;  
      
    USER_DEFINE_ERROR        EXCEPTION          ;      
    
  BEGIN  
        
  /******************************  
  * S/O TYPE CODE  
  * ----------------------------  
  * Y   : CY/DOOR  
  * H   : CHASSIS/GENSET  
  * M   : MT REPO  
  * O   : OTHER  
  * S   : SUPPLEMENT  
  * R   : RAIL BILLING  
  *******************************/  
    
  DBMS_OUTPUT.enable;  
    
   IF pi_rail_com_ind_cd = 'HJS' AND pi_trsp_so_ofc_cty_cd IS NOT NULL THEN  
       IF pi_cgo_tp_cd = 'F' THEN  
          SELECT        DISTINCT  SUBSTR(X.LGS_COST_CD,3,2)  
          INTO          v_conv_cost_mod_cd  
          FROM          TRS_LGS_COST_CD_CONV_RULE X  
          WHERE         X.COST_ACT_GRP_CD              = 'IYRD'  
          AND           X.LGS_COST_CD_CHK_FLG     = DECODE(   SUBSTR(pi_from_nod_cd,1,5)  
                                                            , SUBSTR(pi_to_nod_cd  ,1,5)  
                                                            , 'Y'  
                                                            , 'N'  
                                                          )  
          ;             
       ELSIF pi_cgo_tp_cd = 'M' THEN  
           v_conv_cost_mod_cd := 'MT';  
       ELSE  
           RAISE USER_DEFINE_ERROR;  
       END IF;  
          
   ELSIF pi_rail_com_ind_cd = 'DOM' THEN  
       v_conv_cost_mod_cd := 'DM';  
   ELSE  
       IF pi_cgo_tp_cd = 'M' THEN  
           v_conv_cost_mod_cd := 'MT';  
       ELSE  
           v_conv_cost_mod_cd := 'LC';  
       END IF;     
   END IF;  
      
   v_rtn_value := 'TR'||v_conv_cost_mod_cd||'RD';      
        
       
  DBMS_OUTPUT.PUT_LINE('COST MODE CD = ['||v_conv_cost_mod_cd||'] --> CRR MODE CD = ['||v_conv_crr_mod_cd||']');     
        
  --v_rtn_value := 'TR'||v_conv_cost_mod_cd||v_conv_crr_mod_cd;         /* ex... 'TROTWT' */  
    
  DBMS_OUTPUT.PUT_LINE('LGS COST MODE CD = ['||v_rtn_value||']');     
    
/*  IF LENGTH(v_rtn_value) <> 6 THEN  
      RAISE USER_DEFINE_ERROR;  
  END IF;*/  
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN USER_DEFINE_ERROR THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <USER_DEFINE_ERROR> ERROR MSG = ['||SQLERRM||']');     
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_LGS_COST_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;      
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 23, 2007  
 # -- Table   :   
 # -- Purpose : GET ACCOUNT CODE  
 #####################################################################*/  
  FUNCTION GET_ACCT_CD_FROM_TES_FNC   
  (  
           pi_lgs_cost_cd    VARCHAR2  
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value NUMBER;  
    
  BEGIN  
        
      SELECT X.ACCT_CD  
      INTO   v_rtn_value  
      FROM   TES_LGS_COST X  
      WHERE  X.LGS_COST_CD = pi_lgs_cost_cd  
      ;  
    
  RETURN v_rtn_value;    
    
  EXCEPTION    
      WHEN NO_DATA_FOUND THEN   
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN 0;  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;    
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 23, 2007  
 # -- Table   :   
 # -- Purpose : GET ACCOUNT CODE  
 #####################################################################*/  
  FUNCTION GET_ACCT_CD_FNC   
  (  
           pi_act_grp_cd       VARCHAR2    
       ,   pi_so_tp_cd         VARCHAR2  
       ,   pi_eq_knd_cd         VARCHAR2  
       ,   pi_cost_mod_cd      VARCHAR2             
       ,   pi_crr_mod_cd       VARCHAR2  
       ,   pi_cgo_tp_cd        VARCHAR2    
       ,   pi_from_nod_cd      VARCHAR2  
       ,   pi_to_nod_cd        VARCHAR2      
       ,   pi_rail_com_ind_cd  VARCHAR2           -- 'HJS' 'DOM' 'SEN'                
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value    NUMBER;  
      
    vo_lgs_cost_cd VARCHAR2(6);  
    
  BEGIN  
    
  DBMS_OUTPUT.enable;    
        
      vo_lgs_cost_cd := GET_LGS_COST_CD_FNC(pi_act_grp_cd, pi_so_tp_cd, pi_eq_knd_cd, pi_cost_mod_cd, pi_crr_mod_cd, pi_cgo_tp_cd, pi_from_nod_cd, pi_to_nod_cd, pi_rail_com_ind_cd);  
        
DBMS_OUTPUT.PUT_LINE('vo_lgs_cost_cd = ['||vo_lgs_cost_cd||']');           
  
      v_rtn_value    := GET_ACCT_CD_FROM_TES_FNC(vo_lgs_cost_cd)                              ;  
        
DBMS_OUTPUT.PUT_LINE('acct_cd = ['||v_rtn_value||']');           
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;      
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 23, 2007  
 # -- Table   :   
 # -- Purpose : GET ACCOUNT CODE  
 #####################################################################*/  
  FUNCTION GET_RAIL_ACCT_CD_FNC   
  (  
           pi_rail_com_ind_cd    VARCHAR2           -- 'HJS' 'DOM' 'NIS' NULL     
       ,   pi_trsp_so_ofc_cty_cd VARCHAR2    
       ,   pi_cgo_tp_cd          VARCHAR2    
       ,   pi_from_nod_cd        VARCHAR2  
       ,   pi_to_nod_cd          VARCHAR2                  
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value    NUMBER;  
      
    vo_lgs_cost_cd VARCHAR2(6);  
    
  BEGIN  
    
  DBMS_OUTPUT.enable;    
        
      vo_lgs_cost_cd := GET_RAIL_LGS_COST_CD_FNC(pi_rail_com_ind_cd, pi_trsp_so_ofc_cty_cd, pi_cgo_tp_cd, pi_from_nod_cd, pi_to_nod_cd);  
        
DBMS_OUTPUT.PUT_LINE('vo_lgs_cost_cd = ['||vo_lgs_cost_cd||']');           
  
      v_rtn_value    := GET_ACCT_CD_FROM_TES_FNC(vo_lgs_cost_cd)                              ;  
        
DBMS_OUTPUT.PUT_LINE('acct_cd = ['||v_rtn_value||']');           
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_ACCT_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;        
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUL 30, 2007  
 # -- Table   :   
 # -- Purpose : GET SURCHARGE ACCOUNT CODE  
 #####################################################################*/  
  FUNCTION GET_SCG_ACCT_CD_FNC   
  (  
           pi_scg_lgs_cost_cd       VARCHAR2                
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value    NUMBER;  
      
  BEGIN  
    
      DBMS_OUTPUT.enable;    
        
      v_rtn_value    := GET_ACCT_CD_FROM_TES_FNC(pi_scg_lgs_cost_cd)    ;  
        
      DBMS_OUTPUT.PUT_LINE('acct_cd = ['||v_rtn_value||']');           
    
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_ACCT_CD_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_ACCT_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;       
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUNE 25, 2007  
 # -- Table   :   
 # -- Purpose : GET SURCHARGE SUM AMOUNT  
 #####################################################################*/  
  FUNCTION GET_SCG_DTL_SUM_AMT_FNC   
  (  
           pi_trsp_so_ofc_cty_cd    VARCHAR2          
       ,   pi_trsp_so_seq           NUMBER      
       ,   pi_scg_knd_cd            VARCHAR2  DEFAULT 'WO'          
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value    NUMBER;  
    
  BEGIN  
    
  IF    pi_scg_knd_cd = 'WO' THEN  
    
      SELECT  SUM(NVL(D.SCG_AMT,0))  
      INTO    v_rtn_value  
      FROM    TRS_TRSP_SCG_DTL D  
      WHERE   D.TRSP_SO_OFC_CTY_CD      = pi_trsp_so_ofc_cty_cd  
      AND     D.TRSP_SO_SEQ             = pi_trsp_so_seq   
      AND     NVL(D.SCG_AMT,0)          <> 0  
      ;  
  ELSIF pi_scg_knd_cd = 'IV' THEN  
    
      SELECT  SUM(NVL(D.INV_SCG_AMT,0))  
      INTO    v_rtn_value  
      FROM    TRS_TRSP_SCG_DTL D  
      WHERE   D.TRSP_SO_OFC_CTY_CD      = pi_trsp_so_ofc_cty_cd  
      AND     D.TRSP_SO_SEQ             = pi_trsp_so_seq   
      AND     NVL(D.SCG_AMT,0)          <> 0        
      ;    
  ELSE  
      v_rtn_value := 0;  
  END IF;  
     
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_DTL_SUM_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_DTL_SUM_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;       
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUNE 25, 2007  
 # -- Table   :   
 # -- Purpose : GET SURCHARGE SUM AMOUNT  
 #####################################################################*/  
  FUNCTION GET_SCG_DTL_XCH_RT_AMT_FNC   
  (  
           pi_trsp_so_ofc_cty_cd    VARCHAR2          
       ,   pi_trsp_so_seq           NUMBER      
       ,   pi_inv_curr_cd           VARCHAR2  
       ,   pi_trsp_inv_calc_lgc_tp_cd       VARCHAR2  
       ,   pi_scg_knd_cd            VARCHAR2  DEFAULT 'WO'          
  ) RETURN NUMBER  
 
  IS  
    
    v_rtn_value    NUMBER;  
    
  BEGIN  
    
  IF    pi_scg_knd_cd = 'WO' THEN  
    
      SELECT      CASE WHEN S.INV_CURR_CD IN ('KRW', 'JPY') THEN  
                            CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 0) )  
                                                           ELSE           SUM( ROUND( NVL(D.SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 0) )  
                            END       
                       ELSE  
                            CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 2) )  
                                                           ELSE           SUM( ROUND( NVL(D.SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 2) )  
                            END   
                  END  
      INTO        v_rtn_value  
      FROM        TRS_TRSP_SVC_ORD     S  
      ,           TRS_TRSP_SCG_DTL     D  
      WHERE       S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD  
      AND         S.TRSP_SO_SEQ        = D.TRSP_SO_SEQ  
      AND         S.TRSP_SO_OFC_CTY_CD = pi_trsp_so_ofc_cty_cd  
      AND         S.TRSP_SO_SEQ        = pi_trsp_so_seq  
      AND         S.INV_CURR_CD        = pi_inv_curr_cd  
      AND         S.TRSP_INV_CALC_LGC_TP_CD = pi_trsp_inv_calc_lgc_tp_cd   
      ----AND         NVL(D.SCG_AMT,0)    <> 0  
      --GROUP BY    S.TRSP_SO_OFC_CTY_CD  
      --,           S.TRSP_SO_SEQ  
      --,           S.INV_CURR_CD  
      --,           S.TRSP_INV_CALC_LGC_TP_CD        
      ;  
        
  ELSIF pi_scg_knd_cd = 'IV' THEN  
    
      SELECT      CASE WHEN S.INV_CURR_CD IN ('KRW', 'JPY') THEN  
                            CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.INV_SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 0) )  
                                                           ELSE           SUM( ROUND( NVL(D.INV_SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 0) )  
                            END       
                       ELSE  
                            CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( NVL(D.INV_SCG_AMT,0)*NVL(S.INV_XCH_RT,1), 2) )  
                                                           ELSE           SUM( ROUND( NVL(D.INV_SCG_AMT,0)/NVL(S.INV_XCH_RT,1), 2) )  
                            END   
                  END  
      INTO        v_rtn_value  
      FROM        TRS_TRSP_SVC_ORD     S  
      ,           TRS_TRSP_SCG_DTL     D  
      WHERE       S.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD  
      AND         S.TRSP_SO_SEQ        = D.TRSP_SO_SEQ  
      AND         S.TRSP_SO_OFC_CTY_CD = pi_trsp_so_ofc_cty_cd  
      AND         S.TRSP_SO_SEQ        = pi_trsp_so_seq   
      ----AND         NVL(D.SCG_AMT,0)    <> 0  
      GROUP BY    S.TRSP_SO_OFC_CTY_CD  
      ,           S.TRSP_SO_SEQ  
      ,           S.INV_CURR_CD  
      ,           S.TRSP_INV_CALC_LGC_TP_CD        
      ;        
        
  ELSE  
      v_rtn_value := 0;  
  END IF;  
     
  RETURN v_rtn_value;    
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_DTL_SUM_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN '';  
          DBMS_OUTPUT.PUT_LINE('%%GET_SCG_DTL_SUM_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
    
  END;  
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 11, 2007  
 # -- Table   : *.*  
 # -- Purpose : FIND BOOKING REVENUE VVD  
 #####################################################################*/  
  FUNCTION GET_BKG_REV_VVD_FNC(  
           in_bkg_no            IN       VARCHAR2  
    ,      in_us_rail_yn        IN       VARCHAR2 -- US RAIL 여부 (Y : US RAIL, 나머지 : N)  
  )  
  RETURN VARCHAR2  
    
  IS  
    
  ------------------------------[변수선언부 ]-----------------------  
    
      v_bkg_count           number(2)                           ;  
      v_route_cout          number(2)                           ;  
      v_route_count         number(1)                           ;  
      v_rank                number(1)                           ;  
      v_route_no            varchar(12)                         ;  
      v_vsl_cd              BKG_BOOKING.vsl_cd%TYPE             ;  
      v_skd_voy_no          BKG_BOOKING.skd_voy_no%TYPE         ;  
      v_rev_dir_cd          BKG_BOOKING.rev_dir_cd%TYPE         ;  
      v_bkg_por_cd          BKG_BOOKING.por_cd%TYPE             ;  
      v_bkg_pol_cd          BKG_BOOKING.pol_cd%TYPE             ;  
      v_bkg_pod_cd          BKG_BOOKING.pod_cd%TYPE             ;  
      v_bkg_del_cd          BKG_BOOKING.del_cd%TYPE             ;  
      v_bkg_rcv_term_cd     BKG_BOOKING.rcv_term_cd%TYPE        ;  
      v_bkg_de_term_cd      BKG_BOOKING.de_term_cd%TYPE         ;  
      v_n1st_rlane_cd       MDM_REV_LANE.RLANE_CD%TYPE          ;  
      v_n2nd_rlane_cd       MDM_REV_LANE.RLANE_CD%TYPE          ;  
      v_n3rd_rlane_cd       MDM_REV_LANE.RLANE_CD%TYPE          ;  
      v_n4th_rlane_cd       MDM_REV_LANE.RLANE_CD%TYPE          ;  
      v_n1st_ioc_cd         varchar(2)                          ;  
      v_n2nd_ioc_cd         varchar(2)                          ;  
      v_n3rd_ioc_cd         varchar(2)                          ;  
      v_n4th_ioc_cd         varchar(2)                          ;   
      v_pol1_conti          varchar(1)                          ;  
      v_pol2_conti          varchar(1)                          ;  
      v_pol3_conti          varchar(1)                          ;  
      v_pol4_conti          varchar(1)                          ;  
      v_pod1_conti          varchar(1)                          ;  
      v_pod2_conti          varchar(1)                          ;  
      v_pod3_conti          varchar(1)                          ;  
      v_pod4_conti          varchar(1)                          ;  
      v_trade1_cd           varchar(3)                          ;  
      v_trade2_cd           varchar(3)                          ;  
      v_trade3_cd           varchar(3)                          ;  
      v_trade4_cd           varchar(3)                          ;  
      v_svc_mode_cd         varchar(5)                          ;  
      v_n1st_vvd_cd         varchar(10)                         ;  
      v_n2nd_vvd_cd         varchar(10)                         ;  
      v_n3rd_vvd_cd         varchar(10)                         ;  
      v_n4th_vvd_cd         varchar(10)                         ;   
      v_n1st_conti          varchar(2)                          ;  
      v_n2nd_conti          varchar(2)                          ;  
      v_n3rd_conti          varchar(2)                          ;  
      v_n4th_conti          varchar(2)                          ;   
      v_row_cnt             number                              ; 
      v_rev_vvd_cd          varchar(10)                         ;  
  -- ===== BEGIN, EXCEPTION & END ======================================  
      v_return              NUMBER                              ;  
       
  BEGIN  
    
          /** 초기값 설정 **/  
          v_bkg_count := 0 ;  
          v_route_count :=0 ;  
--     -------------------------------[  항로우선순위/Reveneu conversion  작업 처리         ]----------------------- 
-- 
--SELECT NVL(TRS_GET_RLANE_FNC(first_lane_cd, first_pol_cd, first_pod_cd), 'RBCCO'), 
--  decode(second_lane_cd, '', null, TRS_GET_RLANE_FNC(second_lane_cd, second_pol_cd, second_pod_cd)), 
--  decode(third_lane_cd, '', null, TRS_GET_RLANE_FNC(third_lane_cd, third_pol_cd, third_pod_cd)), 
--  decode(fourth_lane_cd, '', null, TRS_GET_RLANE_FNC(fourth_lane_cd, fourth_pol_cd, fourth_pod_cd)), 
--  decode(X_1_POL_CONTI, X_1_POD_CONTI, 'I', 'O'), 
--  decode(X_2_POL_CONTI, X_2_POD_CONTI, 'I', 'O'), 
--  decode(X_3_POL_CONTI, X_3_POD_CONTI, 'I', 'O'), 
--  decode(X_4_POL_CONTI, X_4_POD_CONTI, 'I', 'O'), 
--  rcv_term_cd, 
--  dlv_term_cd, 
--  bkg_por_cd, 
--  bkg_pol_cd, 
--  bkg_pod_cd, 
--  bkg_del_cd, 
--  TRS_GET_TRD_FNC(TRS_GET_RLANE_FNC(first_lane_cd, first_pol_cd, first_pod_cd), first_pol_cd, first_pod_cd), 
--  decode(second_lane_cd, '', null, TRS_GET_TRD_FNC(TRS_GET_RLANE_FNC(second_lane_cd, second_pol_cd, second_pod_cd), second_pol_cd, second_pod_cd)), 
--  decode(third_lane_cd, '', null, TRS_GET_TRD_FNC(TRS_GET_RLANE_FNC(third_lane_cd, third_pol_cd, third_pod_cd), third_pol_cd, third_pod_cd)), 
--  decode(fourth_lane_cd, '', null, TRS_GET_TRD_FNC(TRS_GET_RLANE_FNC(fourth_lane_cd, fourth_pol_cd, fourth_pod_cd), fourth_pol_cd, fourth_pod_cd)), 
--  x_first_vvd||nvl(coa_rev_dir_conv_fnc(first_lane_cd, first_pol_cd, substr(x_first_vvd, 9, 1)), substr(x_first_vvd, 9, 1)), 
--  x_second_vvd||nvl(decode(second_lane_cd, '', null, coa_rev_dir_conv_fnc(second_lane_cd, second_pol_cd, substr(x_second_vvd, 9, 1))), substr(x_second_vvd, 9, 1)), 
--  x_third_vvd||nvl(decode(third_lane_cd, '', null, coa_rev_dir_conv_fnc(third_lane_cd, third_pol_cd, substr(x_third_vvd, 9, 1))), substr(x_third_vvd, 9, 1)), 
--  x_fourth_vvd||nvl(decode(fourth_lane_cd, '', null, coa_rev_dir_conv_fnc(fourth_lane_cd, fourth_pol_cd, substr(x_fourth_vvd, 9, 1))), substr(x_fourth_vvd, 9, 1)), 
--  decode(X_1_POL_CONTI, X_1_POD_CONTI, 'I'||X_1_POD_CONTI, 'OO'), 
--  decode(X_2_POL_CONTI, X_2_POD_CONTI, 'I'||X_2_POD_CONTI, 'OO'), 
--  decode(X_3_POL_CONTI, X_3_POD_CONTI, 'I'||X_3_POD_CONTI, 'OO'), 
--  decode(X_4_POL_CONTI, X_4_POD_CONTI, 'I'||X_4_POD_CONTI, 'OO') 
--INTO v_n1st_rlane_cd , 
--  v_n2nd_rlane_cd , 
--  v_n3rd_rlane_cd , 
--  v_n4th_rlane_cd , 
--  v_n1st_ioc_cd , 
--  v_n2nd_ioc_cd , 
--  v_n3rd_ioc_cd , 
--  v_n4th_ioc_cd , 
--  v_bkg_rcv_term_cd , 
--  v_bkg_de_term_cd , 
--  v_bkg_por_cd , 
--  v_bkg_pol_cd , 
--  v_bkg_pod_cd , 
--  v_bkg_del_cd , 
--  v_trade1_cd , 
--  v_trade2_cd , 
--  v_trade3_cd , 
--  v_trade4_cd , 
--  v_n1st_vvd_cd , 
--  v_n2nd_vvd_cd , 
--  v_n3rd_vvd_cd , 
--  v_n4th_vvd_cd , 
--  v_n1st_conti , 
--  v_n2nd_conti, 
--  v_n3rd_conti, 
--  v_n4th_conti 
--FROM AGT_BOOKING_V 
--WHERE key_bkg_no = in_bkg_no 
--  AND rownum = 1 ; 
--    
--                          
--      v_rank :=coa_rank_info_fnc(v_n1st_rlane_cd,v_n2nd_rlane_cd,v_n3rd_rlane_cd,v_n4th_rlane_cd,v_n1st_conti ,v_n2nd_conti,v_n3rd_conti,v_n4th_conti);    
--        
--       SELECT DECODE(DECODE(v_rank, 1, v_n1st_rlane_cd, 2, v_n2nd_rlane_cd,3, v_n3rd_rlane_cd, v_n4th_rlane_cd), 'RBCCO',  
--                NVL('CFDR'||( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                              FROM  bkg_rate  
--                              WHERE bkg_no = in_bkg_no  
--                              )||'EE', 
--                DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),  
--                     'RBC',  
--                     DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', ( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                                                                                                                     FROM  bkg_rate  
--                                                                                                                     WHERE bkg_no = in_bkg_no  
--                                                                                                                   ), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd),   
--                     DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))), DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),  
--                     'RBC',  
--                     DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', ( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                                                                                                                     FROM  bkg_rate  
--                                                                                                                     WHERE bkg_no = in_bkg_no  
--                                                                                                                   ), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd),   
--                     DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))) REV_VVD_CD  
--       INTO v_rev_vvd_cd  
--       FROM  agt_booking_v  
--       WHERE  key_bkg_no = in_bkg_no  
--       AND  rownum = 1;  
--         
--       -- Second VVD가 입력되어 있지 않을 경우 Trunk VVD로 다시 조회한다.  
--       -- 미주 Rail일 경우만 해당된다.  
--       IF v_rev_vvd_cd IS NULL AND in_us_rail_yn = 'Y' THEN  
--           v_rank := 1;  
--           SELECT DECODE(DECODE(v_rank, 1, v_n1st_rlane_cd, 2, v_n2nd_rlane_cd,3, v_n3rd_rlane_cd, v_n4th_rlane_cd), 'RBCCO',  
--                    NVL('CFDR'||( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                                  FROM  bkg_rate  
--                                  WHERE bkg_no = in_bkg_no  
--                                 )||'EE',  
--                    DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),  
--                         'RBC',  
--                         DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', ( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                                                                                                                         FROM  bkg_rate  
--                                                                                                                         WHERE bkg_no = in_bkg_no  
--                                                                                                                        ), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd),   
--                         DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))), DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),  
--                         'RBC',  
--                         DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', ( SELECT DECODE(TO_CHAR(MAX(cre_dt), 'YYMM'),'7705', TO_CHAR(SYSDATE, 'YYMM'),NULL,TO_CHAR(SYSDATE, 'YYMM'), TO_CHAR(MAX(cre_dt), 'YYMM')) 
--                                                                                                                         FROM  bkg_rate  
--                                                                                                                         WHERE bkg_no = in_bkg_no  
--                                                                                                                        ), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd),   
--                         DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))) REV_VVD_CD  
--           INTO v_rev_vvd_cd  
--           FROM  agt_booking_v  
--           WHERE  key_bkg_no = in_bkg_no  
--           AND  rownum = 1;  
--      END IF;   
       
      RETURN v_rev_vvd_cd;     
             
      EXCEPTION  
         WHEN OTHERS THEN  
           RETURN NULL; 
          
  END;  
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 11, 2007  
 # -- Table   : *.*  
 # -- Purpose : FIND BOOKING REVENUE VVD  
 #####################################################################*/  
  FUNCTION GET_RVIS_BKG_REV_VVD_FNC(  
           pi_bkg_no            IN       VARCHAR2  
    ,      pi_rvis_bkg_no       IN       VARCHAR2  
    ,      pi_wrk_cre_dt        IN       DATE      
  )  
  RETURN VARCHAR2  
    
  IS  
    
     v_rev_vvd_cd           VARCHAR2(10)                      ;  
     vo_bkg_sts_cd          BKG_BOOKING.BKG_STS_CD%TYPE       ;  
     vo_rvis_bkg_sts_cd     BKG_BOOKING.BKG_STS_CD%TYPE       ;     
       
     USER_DEFINE_ERROR      EXCEPTION                         ;    
       
  BEGIN  
    
    /*-------------- ?? 20070712 (Requested by Ji, Yeon) ------------------------------------------------------  
     * Revenue VVD ???  
     * Booking Status Code         (???? : CD00769)  
     * 'F'     : Firm Booking  
     * 'S'     : Waiting Booking  
     * 'A'     : Split booking  
     * 'X'     : Cancelled Booking  
     * ------------------------------------  
     * 1. BKG_BOOKING.BKG_STS_CD = 'X' ('W', 'X', 'A', 'F', 'S') ??? Revised BKG ??  
     * 2. Revised BKG Exist     -> Revised BKG ==> R.VVD   
     * 2. Revised BKG Not Exist -> ???? ('CNTCYYYYMM')  
     *-----------------------------------------------------------------------------------------------------------*/  
  
      /* COMMON REVENUE VVD */  
      IF pi_bkg_no IS NULL THEN  
        
          /* EXCEPTION HANDLING */  
          IF pi_wrk_cre_dt IS NULL THEN  
              RAISE USER_DEFINE_ERROR;  
          END IF;  
        
          v_rev_vvd_cd := 'CNTC'||TO_CHAR(pi_wrk_cre_dt, 'YYMM')||'MM';  
            
      ELSE  
        
      /* GET REVENUE VVD */  
        
          SELECT  BKG.BKG_STS_CD  
          INTO    vo_bkg_sts_cd  
          FROM    BKG_BOOKING BKG  
          WHERE   BKG.BKG_NO        = pi_bkg_no  
          ;  
            
          /* BOOKING NUMBER IS ALIVE */  
          IF vo_bkg_sts_cd <> 'X' THEN  
            
              v_rev_vvd_cd := GET_BKG_REV_VVD_FNC(pi_bkg_no, 'N');  
            
          /* BOOKING NUMBER IS CLOSED */  
          ELSE  
            
              IF pi_rvis_bkg_no IS NOT NULL THEN  
                
                  SELECT  BKG.BKG_STS_CD  
                  INTO    vo_rvis_bkg_sts_cd  
                  FROM    BKG_BOOKING BKG  
                  WHERE   BKG.BKG_NO        = pi_rvis_bkg_no  
                  ;  
                    
                  IF vo_rvis_bkg_sts_cd <> 'X' THEN  
                    
                      v_rev_vvd_cd := GET_BKG_REV_VVD_FNC(pi_rvis_bkg_no, 'N');  
                        
                  ELSE  
                    
                      /* EXCEPTION HANDLING */  
                      IF pi_wrk_cre_dt IS NULL THEN  
                          RAISE USER_DEFINE_ERROR;  
                      END IF;  
                        
                      v_rev_vvd_cd := 'CNTC'||TO_CHAR(pi_wrk_cre_dt, 'YYMM')||'MM';  
                  END IF;  
                    
              ELSE  
                
                  /* EXCEPTION HANDLING */  
                  IF pi_wrk_cre_dt IS NULL THEN  
                      RAISE USER_DEFINE_ERROR;  
                  END IF;  
            
                  v_rev_vvd_cd := 'CNTC'||TO_CHAR(pi_wrk_cre_dt, 'YYMM')||'MM';  
              END IF;  
            
          END IF;        
        
      END IF;  
                                                                                                       
      RETURN v_rev_vvd_cd;     
             
EXCEPTION  
  
      WHEN USER_DEFINE_ERROR THEN   
          RETURN NULL;  
      WHEN OTHERS THEN  
          RETURN NULL;  
          
END;  
     
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : MAY 13, 2008  
 # -- Table   : *.*  
 # -- Purpose : FIND BOOKING REVENUE VVD (Considering CFDR)  
 #####################################################################*/  
  FUNCTION GET_BKG_REV_VVD2_FNC(  
           pi_ap_ofc_cd             IN      VARCHAR2 
     ,     pi_inv_dt                IN      VARCHAR2 
     ,     pi_bkg_no                IN      VARCHAR2 
      
  )  
  RETURN VARCHAR2  
    
  IS  
    
  v_rev_vvd_cd                  VARCHAR2(10)          ;  
  REVENUE_VVD_CFDR     CONSTANT VARCHAR2(4) := 'CFDR' ;  
   
  BEGIN  
 
--    SELECT FINC_VVD_CD  
--    INTO v_rev_vvd_cd 
--    FROM (  
--        SELECT FINC_VVD_CD 
--        FROM TRS_EXPT_BKG_REV_VVD 
--        WHERE BKG_NO = pi_bkg_no 
--        AND TRSP_RAIL_ORD_FLG = 'Y' 
--        UNION 
--        SELECT NULL FROM DUAL 
--    )  
--    WHERE 
--    ROWNUM = 1; 
 
    IF v_rev_vvd_cd IS NULL THEN 
     
        v_rev_vvd_cd := GET_BKG_REV_VVD_FNC(pi_bkg_no, 'Y'); 
         
    END IF;     
     
    IF SUBSTR(v_rev_vvd_cd,1,4) IN ('HJXX', 'HJYY', 'HJZZ') THEN 
 
    SELECT       'CNTC'||SUBSTR(TRS_GET_GL_DT_FNC( '', pi_ap_ofc_cd, pi_inv_dt, '15'),3,4)||'MM' 
    INTO         v_rev_vvd_cd  
    FROM         DUAL 
    ; 
 
    END IF; 
     
    RETURN v_rev_vvd_cd; 
     
    EXCEPTION  
     WHEN OTHERS THEN  
       RETURN v_rev_vvd_cd;    
  END;       
    
    
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : JUNE 6, 2008  
 # -- Table   : *.*  
 # -- Purpose : Other S/O Generating R.VVD (Full Contaienr Only)  
 #####################################################################*/  
  FUNCTION GET_BKG_REV_VVD3_FNC( 
           pi_ap_ofc_cd             IN       VARCHAR2 
    ,      pi_inv_dt                IN       VARCHAR2  
    ,      pi_trsp_so_tp_cd         IN       VARCHAR2  
    ,      pi_trsp_so_ofc_cty_cd    IN       VARCHAR2  
    ,      pi_trsp_so_seq           IN       NUMBER  
    ,      pi_eq_knd_cd             IN       VARCHAR2  
    ,      pi_cgo_tp_cd             IN       VARCHAR2     
    ,      pi_bkg_no                IN       VARCHAR2  
    ,      pi_ref_bkg_no            IN       VARCHAR2  
    ,      pi_vsl_cd                IN       VARCHAR2  
    ,      pi_skd_voy_no            IN       VARCHAR2  
    ,      pi_skd_dir_cd            IN       VARCHAR2  
    ,      pi_trsp_otr_cost_mon_dt  IN       VARCHAR2  
  )  
  RETURN VARCHAR2  
    
  IS  
    
  v_rev_vvd_cd                  VARCHAR2(10)          ;  
  v_bkg_sts_cd                  VARCHAR2(1)           ;  
    
  REVENUE_VVD_CFDR     CONSTANT VARCHAR2(4) := 'CFDR' ;  
  OTHER_SO_TP_CD       CONSTANT VARCHAR2(4) := 'O'    ;  
        
  BEGIN  
  
--    SELECT FINC_VVD_CD  
--    INTO v_rev_vvd_cd 
--    FROM (  
--    SELECT FINC_VVD_CD 
--    FROM TRS_EXPT_BKG_REV_VVD 
--    WHERE BKG_NO = pi_bkg_no 
--    AND TRSP_RAIL_ORD_FLG = 'N' 
--    UNION 
--    SELECT NULL FROM DUAL 
--    )  
--    WHERE 
--    ROWNUM = 1;  
 
  /* OTHER S/O ONLY */  
   
  IF pi_trsp_so_tp_cd = OTHER_SO_TP_CD THEN   
       
      IF v_rev_vvd_cd IS NULL THEN 
 
          SELECT NVL(MAX(B.BKG_STS_CD), 'X')  
          INTO   v_bkg_sts_cd  
          FROM   BKG_BOOKING            B  
          WHERE  B.BKG_NO               = pi_ref_bkg_no  
          ; 
          IF pi_eq_knd_cd = 'U' AND pi_ref_bkg_no IS NOT NULL AND NVL(pi_cgo_tp_cd, 'M') = 'F' AND v_bkg_sts_cd <> 'X' THEN 
            
              v_rev_vvd_cd := GET_BKG_REV_VVD_FNC(pi_ref_bkg_no, 'N'); 
/* 2011.01.19 OTHER의 경우 REF_BKG_NO가 존재하지 않으면 공통항차를 따야한다.   */                
/*        ELSIF pi_eq_knd_cd = 'U' AND NVL(pi_cgo_tp_cd, 'M') = 'F' THEN */ 
          ELSE 
              SELECT       'CNTC' || pi_trsp_otr_cost_mon_dt || 'MM' AS FINC_VVD_CD   
              INTO         v_rev_vvd_cd   
              FROM         DUAL  
              ; 
         END IF; 
        
     END IF; 
    
  /* EXCEPT OTHER S/O */  
  ELSE    
 
    IF v_rev_vvd_cd IS NULL THEN 
 
    v_rev_vvd_cd := GET_BKG_REV_VVD_FNC(pi_bkg_no, 'N'); 
 
    END IF; 
         
	IF SUBSTR(v_rev_vvd_cd,1,4) IN ('HJXX', 'HJYY', 'HJZZ') THEN 
	 
    SELECT       'CNTC'||SUBSTR(TRS_GET_GL_DT_FNC( '', pi_ap_ofc_cd, pi_inv_dt, '15'),3,4)||'MM' 
    INTO         v_rev_vvd_cd  
    FROM         DUAL 
    ; 
 
    END IF; 
 
  END IF;  
         
  RETURN v_rev_vvd_cd;     
             
  EXCEPTION  
     WHEN OTHERS THEN  
       RETURN v_rev_vvd_cd;  
          
  END;       
     
     
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : SEP 19, 2007  
 # -- Table   : TRS_TRSP_OFC_EXPT_RULE  
 # -- Purpose : GET TRS CONTROL OFFICE EXCEPTION RULE APPLY  
 #####################################################################*/  
  FUNCTION GET_CTRLOFC_EXPRULE_FNC   
  (  
          p_cgo_tp_cd                TRS_TRSP_OFC_EXPT_RULE.CGO_TP_CD%TYPE  
      ,   p_cntr_tp_cd               TRS_TRSP_OFC_EXPT_RULE.CNTR_TP_CD%TYPE  
      ,   p_cntr_sz_cd               TRS_TRSP_OFC_EXPT_RULE.CNTR_SZ_CD%TYPE  
      ,   p_trsp_cost_dtl_mod_cd     TRS_TRSP_OFC_EXPT_RULE.TRSP_COST_DTL_MOD_CD%TYPE  
      ,   p_trsp_crr_mod_cd          TRS_TRSP_OFC_EXPT_RULE.TRSP_CRR_MOD_CD%TYPE  
      ,   p_fm_nod_cd                TRS_TRSP_OFC_EXPT_RULE.FM_NOD_CD%TYPE  
      ,   p_via_nod_cd               TRS_TRSP_OFC_EXPT_RULE.VIA_NOD_CD%TYPE  
      ,   p_dor_nod_cd               TRS_TRSP_OFC_EXPT_RULE.DOR_NOD_CD%TYPE  
      ,   p_to_nod_cd                TRS_TRSP_OFC_EXPT_RULE.TO_NOD_CD%TYPE  
             
  ) RETURN VARCHAR2  
 
  IS  
  
    v_rtn_value SCE_PLN_SO_LIST.CTRL_OFC_CD%TYPE := '';  
         
  BEGIN    
  
    DBMS_OUTPUT.ENABLE;  
    DBMS_OUTPUT.PUT_LINE('INPUT FULL/EMPTY = [' || p_cgo_tp_cd || '] === FULL/EMPTY = [' || p_cntr_tp_cd || '] === FULL/EMPTY = [' || p_cntr_sz_cd || '] === FULL/EMPTY = [' || p_trsp_cost_dtl_mod_cd || '] === FULL/EMPTY = [' || p_trsp_crr_mod_cd || '] === FULL/EMPTY = [' || p_fm_nod_cd || '] === FULL/EMPTY = [' || p_via_nod_cd || '] === FULL/EMPTY = [' || p_dor_nod_cd || '] === FULL/EMPTY = [' || p_to_nod_cd || ']');  
    
    SELECT    CTRL_OFC_CD  
    INTO      v_rtn_value  
    FROM      (  
              SELECT    X.CTRL_OFC_CD  
              FROM      TRS_TRSP_OFC_EXPT_RULE X  
              WHERE     1 = 1  
              AND       X.DELT_FLG             = 'N'  
              AND       X.CGO_TP_CD            = p_cgo_tp_cd  
                
              AND       CASE WHEN NVL(LENGTH(TRIM(X.CNTR_TP_CD)),0) > 0 THEN X.CNTR_TP_CD  
                             ELSE p_cntr_tp_cd  
                        END                    = p_cntr_tp_cd  
              AND       CASE WHEN NVL(LENGTH(TRIM(X.CNTR_SZ_CD)),0) > 0 THEN X.CNTR_SZ_CD   
                             ELSE p_cntr_sz_cd  
                        END                    = p_cntr_sz_cd  
                
              AND       X.TRSP_COST_DTL_MOD_CD = p_trsp_cost_dtl_mod_cd  
              AND       X.TRSP_CRR_MOD_CD      = p_trsp_crr_mod_cd  
                
              AND       CASE NVL(LENGTH(TRIM(X.FM_NOD_CD)),0)  WHEN 7 THEN p_fm_nod_cd  
                                                  WHEN 5 THEN SUBSTR(p_fm_nod_cd,1,5)  
                                                  WHEN 2 THEN SUBSTR(p_fm_nod_cd,1,2)  
                                                  WHEN 0 THEN 'N/A'  
                                                  ELSE        ''  
                        END                    = TRIM(X.FM_NOD_CD)   
              AND       CASE NVL(LENGTH(TRIM(X.VIA_NOD_CD)),0) WHEN 7 THEN p_via_nod_cd  
                                                  WHEN 5 THEN SUBSTR(p_via_nod_cd,1,5)  
                                                  WHEN 2 THEN SUBSTR(p_via_nod_cd,1,2)  
                                                  WHEN 0 THEN 'N/A'  
                                                  ELSE        ''  
                        END                    = NVL(TRIM(X.VIA_NOD_CD),'N/A')  
              AND       CASE NVL(LENGTH(TRIM(X.DOR_NOD_CD)),0) WHEN 7 THEN p_dor_nod_cd  
                                                  WHEN 5 THEN SUBSTR(p_dor_nod_cd,1,5)  
                                                  WHEN 2 THEN SUBSTR(p_dor_nod_cd,1,2)  
                                                  WHEN 0 THEN 'N/A'  
                                                  ELSE        ''  
                        END                    = NVL(TRIM(X.DOR_NOD_CD),'N/A')          
              AND       CASE NVL(LENGTH(TRIM(X.TO_NOD_CD)),0)  WHEN 7 THEN p_to_nod_cd  
                                                  WHEN 5 THEN SUBSTR(p_to_nod_cd,1,5)  
                                                  WHEN 2 THEN SUBSTR(p_to_nod_cd,1,2)  
                                                  WHEN 0 THEN 'N/A'  
                                                  ELSE        ''  
                        END                    = TRIM(X.TO_NOD_CD)     
                          
              ORDER BY  NVL(LENGTH(X.TRSP_COST_DTL_MOD_CD),0)        DESC  
                    ,   NVL(LENGTH(X.TRSP_CRR_MOD_CD),0)             DESC  
                    ,   NVL(LENGTH(TRIM(X.CNTR_TP_CD)),0)            DESC  
                    ,   NVL(LENGTH(TRIM(X.CNTR_SZ_CD)),0)            DESC  
                    ,   NVL(LENGTH(TRIM(X.FM_NOD_CD)),0)             DESC  
                    ,   NVL(LENGTH(TRIM(X.TO_NOD_CD)),0)             DESC  
                    ,   NVL(LENGTH(TRIM(X.VIA_NOD_CD)),0)            DESC  
                    ,   NVL(LENGTH(TRIM(X.DOR_NOD_CD)),0)            DESC  
              )  
    WHERE     ROWNUM = 1         
    ;  
    
    RETURN v_rtn_value;  
    
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          RETURN NULL;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CTRLOFC_EXPRULE_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          RETURN NULL;  
          DBMS_OUTPUT.PUT_LINE('%%GET_CTRLOFC_EXPRULE_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
    
  END;  
  
 /*###################################################################  
 # -- Author  : JEONG SANG-KI  
 # -- Created : SEP 18, 2007  
 # -- Table   : COP_COST_ACT_GRP_SEQ  
 # -- Purpose : TRS CONTROL OFFICE EXCEPTION RULE APPLY TO COP  
 #####################################################################*/  
  PROCEDURE SET_CTRLOFC_EXPRULE_TO_COP_PRC   
  (  
           p_cop_no         IN  SCE_COP_HDR.COP_NO%TYPE  
      ,    p_rtn_value      OUT NUMBER             
  )  
 
  IS  
      
    v_rtn_value NUMBER (1)    := 0 ;  
    v_rule_ctrl_ofc_cd         SCE_PLN_SO_LIST.CTRL_OFC_CD%TYPE                ;  
      
    v_cgo_tp_cd                TRS_TRSP_OFC_EXPT_RULE.CGO_TP_CD%TYPE                  ;  
    v_cntr_tp_cd               TRS_TRSP_OFC_EXPT_RULE.CNTR_TP_CD%TYPE           ;  
    v_cntr_sz_cd               TRS_TRSP_OFC_EXPT_RULE.CNTR_SZ_CD%TYPE           ;  
    v_trsp_cost_dtl_mod_cd     TRS_TRSP_OFC_EXPT_RULE.TRSP_COST_DTL_MOD_CD%TYPE ;  
    v_trsp_crr_mod_cd          TRS_TRSP_OFC_EXPT_RULE.TRSP_CRR_MOD_CD%TYPE      ;  
    v_fm_nod_cd                TRS_TRSP_OFC_EXPT_RULE.FM_NOD_CD%TYPE            ;  
    v_via_nod_cd               TRS_TRSP_OFC_EXPT_RULE.VIA_NOD_CD%TYPE           ;  
    v_dor_nod_cd               TRS_TRSP_OFC_EXPT_RULE.DOR_NOD_CD%TYPE           ;  
    v_to_nod_cd                TRS_TRSP_OFC_EXPT_RULE.TO_NOD_CD%TYPE            ;   
      
    v_org_ctrl_ofc_cd          SCE_PLN_SO_LIST.CTRL_OFC_CD%TYPE                ;  
    v_cop_no                   SCE_PLN_SO_LIST.COP_NO%TYPE                     ;  
    v_cost_act_grp_seq         SCE_PLN_SO_LIST.COST_ACT_GRP_SEQ%TYPE           ;  
      
    CURSOR CSR_COP_LIST IS  
      
        SELECT   
               Y.COP_NO  
            ,  Y.COST_ACT_GRP_SEQ  
            ,  'F'                        CGO_TP_CD  
            ,  SUBSTR(X.CNTR_TPSZ_CD,1,1) CNTR_TP_CD  
            ,  SUBSTR(X.CNTR_TPSZ_CD,2,1) CNTR_SZ_CD            
            ,  DECODE(Y.PCTL_COST_MOD_CD,'C','CY','Z','DR') TRSP_COST_MOD_CD  
            ,  Y.TRSP_MOD_CD                                TRSP_CRR_MOD_CD  
            ,  Y.CTRL_OFC_CD  
              
            ,  Y.COST_ACT_GRP_CD  
              /* ROUTE - FROM NODE             */  
            , Y.N1ST_NOD_CD FROM_NOD_CD           
              
              /* ROUTE - VIA NODE             */  
            , CASE LENGTH(Y.N4TH_NOD_CD) WHEN 7 THEN   
                                                CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1) WHEN 'I' THEN Y.N2ND_NOD_CD  
                                                                              WHEN 'O' THEN Y.N3RD_NOD_CD  
                                                                              ELSE ''  
                                                END  
                                         ELSE       
                                               CASE SUBSTR(Y.COST_ACT_GRP_CD,2,1)  WHEN 'D' THEN ''                              
                                                                              ELSE  
                                                                                       CASE LENGTH(Y.N3RD_NOD_CD) WHEN 7 THEN Y.N2ND_NOD_CD  
                                                                                                                         ELSE ''  
                                                                                       END  
                                               END  
              END VIA_NOD_CD  
              
              /* ROUTE - DOOR NODE             */  
            , CASE LENGTH(Y.N4TH_NOD_CD) WHEN 7 THEN  
                                                CASE SUBSTR(Y.COST_ACT_GRP_CD,1,1) WHEN 'I' THEN Y.N3RD_NOD_CD  
                                                                              WHEN 'O' THEN Y.N2ND_NOD_CD  
                                                                              ELSE ''  
                                                END  
                                         ELSE    
                                               CASE SUBSTR(Y.COST_ACT_GRP_CD,2,1)  WHEN 'D' THEN Y.N2ND_NOD_CD                              
                                                                              ELSE ''  
                                               END                                                   
              END DOOR_NOD_CD                                                           
              
              /* ROUTE - TO NODE             */  
            , CASE LENGTH(Y.N4TH_NOD_CD) WHEN 7 THEN Y.N4TH_NOD_CD  
                                         ELSE   
                                                CASE LENGTH(Y.N3RD_NOD_CD) WHEN 7 THEN Y.N3RD_NOD_CD  
                                                                           ELSE Y.N2ND_NOD_CD      
                                                END                    
              END TO_NOD_CD  
                
            ,  Y.N1ST_NOD_CD  
            ,  Y.N2ND_NOD_CD  
            ,  Y.N3RD_NOD_CD  
            ,  Y.N4TH_NOD_CD  
             
        FROM   SCE_COP_HDR           X  
            ,  SCE_PLN_SO_LIST       Y                          /* SCE Model 변경 2009.10.01 */ 
            ,  MDM_LOCATION          L 
        WHERE  X.COP_NO              = Y.COP_NO  
        AND    X.COP_NO              = p_cop_no 
        AND    Y.COST_ACT_GRP_CD     <> 'VSSL'  
        AND    Y.PCTL_COST_MOD_CD    IS NOT NULL  
        AND    Y.TRSP_MOD_CD         IS NOT NULL  
        AND    Y.CTRL_OFC_CD         IS NOT NULL     
        AND    Y.TRNS_RQST_OFC_CD    IS NULL                     /* TRNS_RQST_OFC_CD : Office Transfer Record */  
        AND    Y.INLND_ROUT_INV_BIL_PATT_CD IS NULL              /* 2008.04.02 : USRAIL 제외로직              */  
        AND    Y.TRSP_MOD_CD         <> 'RD'  
        AND    SUBSTR(Y.N1ST_NOD_CD,1,5) = L.LOC_CD 
        AND    L.CONTI_CD            <> 'M'  
        AND    L.CNT_CD              NOT IN ('CA', 'US') 
        ;  
      
  BEGIN    
  
    DBMS_OUTPUT.ENABLE;  
    DBMS_OUTPUT.PUT_LINE('=========================== COP_NO = [' || p_cop_no || '] STARTING TIME IS ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') || '===============================');  
    
    FOR COP_LIST IN CSR_COP_LIST LOOP  
      
        v_cop_no                   := COP_LIST.COP_NO           ;  
        v_cost_act_grp_seq         := COP_LIST.COST_ACT_GRP_SEQ ;  
        v_org_ctrl_ofc_cd          := COP_LIST.CTRL_OFC_CD      ;  
          
        v_cgo_tp_cd                := COP_LIST.CGO_TP_CD        ;  
        v_cntr_tp_cd               := COP_LIST.CNTR_TP_CD       ;  
        v_cntr_sz_cd               := COP_LIST.CNTR_SZ_CD       ;  
        v_trsp_cost_dtl_mod_cd     := COP_LIST.TRSP_COST_MOD_CD ;  
        v_trsp_crr_mod_cd          := COP_LIST.TRSP_CRR_MOD_CD  ;  
        v_fm_nod_cd                := COP_LIST.FROM_NOD_CD      ;  
        v_via_nod_cd               := COP_LIST.VIA_NOD_CD       ;  
        v_dor_nod_cd               := COP_LIST.DOOR_NOD_CD      ;  
        v_to_nod_cd                := COP_LIST.TO_NOD_CD        ;   
          
        DBMS_OUTPUT.PUT_LINE('INPUT SEQ = [' || v_cost_act_grp_seq || '] === FULL/EMPTY = [' || v_cgo_tp_cd || '] * CNTR/TP = [' || v_cntr_tp_cd || '] * CNTR/SZ = [' || v_cntr_sz_cd || '] * COST/MODE = [' || v_trsp_cost_dtl_mod_cd || '] * TRANS = [' || v_trsp_crr_mod_cd || '] * FROM = [' || v_fm_nod_cd || '] * VIA = [' || v_via_nod_cd || '] * DOOR = [' || v_dor_nod_cd || '] * TO = [' || v_to_nod_cd || ']');  
          
        v_rule_ctrl_ofc_cd         := GET_CTRLOFC_EXPRULE_FNC(  
                                                                    v_cgo_tp_cd                 
                                                                ,   v_cntr_tp_cd                
                                                                ,   v_cntr_sz_cd                
                                                                ,   v_trsp_cost_dtl_mod_cd      
                                                                ,   v_trsp_crr_mod_cd           
                                                                ,   v_fm_nod_cd                 
                                                                ,   v_via_nod_cd                
                                                                ,   v_dor_nod_cd                
                                                                ,   v_to_nod_cd                    
                                                              );  
  
        DBMS_OUTPUT.PUT_LINE('OUTPUT COP_NO = [' || v_cop_no || '] SEQ = [' || v_cost_act_grp_seq || '] ORG CONTROL OFFICE = [' || v_org_ctrl_ofc_cd || '] +++++++ NEW CONTROL OFFICE = [' || v_rule_ctrl_ofc_cd || ']');  
  
        IF v_rule_ctrl_ofc_cd IS NOT NULL AND LENGTH(v_rule_ctrl_ofc_cd) >= 5 THEN  
            
           UPDATE   SCE_PLN_SO_LIST      Y  
           SET      Y.CTRL_OFC_CD        = v_rule_ctrl_ofc_cd  
           WHERE    Y.COP_NO             = v_cop_no  
           AND      Y.COST_ACT_GRP_SEQ   = v_cost_act_grp_seq  
           ;  
  
           DBMS_OUTPUT.PUT_LINE('Updated Control Office Code to ' || v_rule_ctrl_ofc_cd || ' from ' || v_org_ctrl_ofc_cd || ' based on TRS Control Office Exception Rule!!!');  
            
        END IF  
        ;      
      
    END LOOP  
    ;  
      
    DBMS_OUTPUT.PUT_LINE('=========================== COP_NO = [' || v_cop_no || '] FINISHED TIME IS ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') || '===============================');  
      
    --jsk20071119:COMMIT;  
      
    v_rtn_value   := 0;    
   
  EXCEPTION  
      WHEN NO_DATA_FOUND THEN   
          --jsk20071119:ROLLBACK;  
          v_rtn_value   := -1;  
          DBMS_OUTPUT.PUT_LINE('%%SET_CTRLOFC_EXPRULE_TO_COP_PRC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
      WHEN OTHERS THEN  
          --jsk20071119:ROLLBACK;  
          v_rtn_value   := -2;            
          DBMS_OUTPUT.PUT_LINE('%%SET_CTRLOFC_EXPRULE_TO_COP_PRC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
  END;  
   
   
-- /*###################################################################  
-- # -- Author  : JEONG SANG-KI  
-- # -- Created : NOV 27, 2007  
-- # -- Table   : TRS_TRSP_USA_ACT_CUST + TRS_TRSP_USA_ACT_CUST_DTL  
-- # -- Purpose : TRS CONTROL OFFICE EXCEPTION RULE APPLY TO EQR  
-- #####################################################################*/  
--  PROCEDURE GET_ACTUAL_CUSTOMER_INFO_PRC   
--  (  
--           pi_conti_cd                   IN  TRS_TRSP_SVC_ORD.CONTI_CD%TYPE  
--      ,    pi_bound_cd                   IN  TRS_TRSP_SVC_ORD.TRSP_BND_CD%TYPE  
--      ,    pi_cnee_cnt_cd                IN  TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE  
--      ,    pi_cnee_seq                   IN  TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE  
--      ,    pi_shpr_cnt_cd                IN  TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE  
--      ,    pi_shpr_seq                   IN  TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE        
--      ,    pi_door_nod_cd                IN  TRS_TRSP_SVC_ORD.DOR_NOD_CD%TYPE  
--        
--      ,    po_rtn_value                  OUT NUMBER          
--  
--      ,    po_act_cust_cnt_cd            OUT TRS_TRSP_SVC_ORD.ACT_CUST_CNT_CD%TYPE  
--      ,    po_act_cust_seq               OUT TRS_TRSP_SVC_ORD.ACT_CUST_SEQ%TYPE  
--      ,    po_act_cust_addr_seq          OUT TRS_TRSP_SVC_ORD.ACT_CUST_ADDR_SEQ%TYPE  
--  
--      ,    po_act_cust_fctry_pst_cd      OUT TRS_TRSP_SVC_ORD.DOR_PST_CD%TYPE  
--      ,    po_act_cust_fctry_nm          OUT TRS_TRSP_SVC_ORD.FCTRY_NM%TYPE  
--      ,    po_act_cust_fctry_addr        OUT TRS_TRSP_SVC_ORD.DOR_DE_ADDR%TYPE  
--      ,    po_act_cust_fctry_phn_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_PHN_NO%TYPE  
--      ,    po_act_cust_fctry_fax_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_FAX_NO%TYPE  
--      ,    po_act_cust_fctry_pic_no      OUT TRS_TRSP_SVC_ORD.CNTC_PSON_NM%TYPE  
--  
--      ,    po_act_cust_eml               OUT TRS_TRSP_USA_ACT_CUST_DTL.ACT_CUST_EML%TYPE  
--      ,    po_act_cust_rmk               OUT TRS_TRSP_USA_ACT_CUST_DTL.ACT_CUST_RMK%TYPE          
--  )  
-- 
--  IS  
--     
--  BEGIN    
--  
--  /* 아주 + 미주 */  
--  IF pi_conti_cd = 'A' OR pi_conti_cd = 'M' OR pi_conti_cd = 'X' THEN  
--  
--      SELECT    ACT_CUST_CNT_CD  
--             ,  ACT_CUST_SEQ  
--             ,  TRSP_ACT_CUST_SEQ  
--             ,  ACT_CUST_ZIP_CD  
--             ,  ACT_CUST_NM  
--             ,  ACT_CUST_ADDR  
--             ,  ACT_CUST_PHN_NO  
--             ,  ACT_CUST_FAX_NO  
--             ,  CNTC_PSON_NM  
--             ,  ACT_CUST_EML  
--             ,  ACT_CUST_RMK  
--      INTO      po_act_cust_cnt_cd  
--             ,  po_act_cust_seq  
--             ,  po_act_cust_addr_seq  
--             ,  po_act_cust_fctry_pst_cd  
--             ,  po_act_cust_fctry_nm  
--             ,  po_act_cust_fctry_addr  
--             ,  po_act_cust_fctry_phn_no  
--             ,  po_act_cust_fctry_fax_no  
--             ,  po_act_cust_fctry_pic_no  
--             ,  po_act_cust_eml  
--             ,  po_act_cust_rmk  
--      FROM      (  
--                SELECT    X.ACT_CUST_CNT_CD  
--                       ,  X.ACT_CUST_SEQ  
--                       ,  Y.TRSP_ACT_CUST_SEQ  
--                       ,  Y.ACT_CUST_ZIP_CD  
--                       ,  Y.ACT_CUST_NM  
--                       ,  Y.ACT_CUST_ADDR  
--                       ,  Y.ACT_CUST_PHN_NO  
--                       ,  Y.ACT_CUST_FAX_NO  
--                       ,  Y.CNTC_PSON_NM  
--                       ,  Y.ACT_CUST_EML  
--                       ,  Y.ACT_CUST_RMK  
--                FROM      TRS_TRSP_USA_ACT_CUST        X  
--                       ,  TRS_TRSP_USA_ACT_CUST_DTL    Y  
--                WHERE     X.TRSP_ACT_CUST_NO           = Y.TRSP_ACT_CUST_NO  
--                AND       X.ACT_CUST_BND_CD            = pi_bound_cd  
--                AND       NVL(X.ACT_CUST_CNT_CD,'N/A') = CASE WHEN X.ACT_CUST_CNT_CD IS NULL THEN 'N/A'  
--                                                              ELSE DECODE(pi_bound_cd, 'I', pi_cnee_cnt_cd, 'O', pi_shpr_cnt_cd)  
--                                                         END  
--                                                           
--                AND       NVL(X.ACT_CUST_SEQ   ,  99 ) = CASE WHEN X.ACT_CUST_SEQ   IS NULL THEN 99  
--                                                              ELSE DECODE(pi_bound_cd, 'I', pi_cnee_seq   , 'O', pi_shpr_seq   )  
--                                                         END        
--                AND       X.DOR_NOD_CD                 = pi_door_nod_cd  
--                AND       Y.DFLT_ACT_CUST_FLG          = 'Y'  
--                AND       X.DELT_FLG                   = 'N'  
--                AND       Y.DELT_FLG                   = 'N'  
--                ORDER BY  NVL(LENGTH(X.ACT_CUST_CNT_CD),0)    DESC  
--                      ,   X.CRE_DT                            DESC                  
--                )  
--      WHERE     ROWNUM < 2  
--      ;        
--       
--  /* 구주 */  
--  ELSE  
--      NULL;   
--  END IF  
--  ;  
-- 
--  po_rtn_value := 0;      
-- 
--  EXCEPTION  
--      WHEN NO_DATA_FOUND THEN   
--          po_rtn_value   := '';  
--          --DBMS_OUTPUT.PUT_LINE('%%GET_ACTUAL_CUSTOMER_INFO_PRC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');  
--      WHEN OTHERS THEN  
--          po_rtn_value   := '';            
--          --DBMS_OUTPUT.PUT_LINE('%%GET_ACTUAL_CUSTOMER_INFO_PRC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
--    
--  END; 
 
/*###################################################################  
# -- Author  : PARK JUN-YONG  
# -- Created : JUL 21, 2008  
# -- Table   : TRS_TRSP_SVC_ORD  
# -- Purpose : GET YARD NAME FROM YARD NODE   
#####################################################################*/  
FUNCTION GET_YD_CD_NM_FNC   
(  
         pi_yd_cd            IN       VARCHAR2  
)   
RETURN VARCHAR2  
 
IS  
        
    po_rtn_value             MDM_YARD.YD_NM%TYPE         := '';  
     
BEGIN  
  
    SELECT  MAX(YD_NM)  
    INTO    po_rtn_value  
    FROM  
            (  
            SELECT YD.YD_NM             YD_NM  
            FROM   MDM_YARD             YD   
            WHERE  YD.YD_CD             = pi_yd_cd  
            AND    NVL(YD.YD_FCTY_TP_PSDO_YD_FLG, 'N') <> 'Y'  
            AND    DELT_FLG             = 'N'  
            UNION ALL  
            SELECT LSE_YD.LSE_CO_YD_NM  YD_NM  
            FROM   MDM_LSE_CO_YD      LSE_YD   
            WHERE  LSE_YD.LSE_CO_YD_CD  = pi_yd_cd  
            AND    DELT_FLG             = 'N'  
            )  
    ;  
      
    RETURN po_rtn_value;  
             
EXCEPTION  
  
      WHEN OTHERS THEN  
          RETURN NULL;  
END;  
 
 
$END 
    
END TRS_COMMON_PKG;
/

