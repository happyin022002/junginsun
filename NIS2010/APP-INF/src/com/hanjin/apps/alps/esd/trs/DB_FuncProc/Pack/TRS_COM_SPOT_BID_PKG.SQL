CREATE OR REPLACE PACKAGE TRS_COM_SPOT_BID_PKG  
AUTHID CURRENT_USER 
IS  
 /*################################################################### X 
 # -- Author  : 9014787 
 # -- Created : SEP 16, 2015  
 # -- Table   : TRS_SPOT_BID_VNDR  
 # -- Purpose :   
 #####################################################################*/  
  FUNCTION GET_SPOT_BID_VNDR_INFO   
  (  
           pi_spot_bid_no                VARCHAR2  
      ,    pi_spot_bid_vndr_sts_cd       VARCHAR2 DEFAULT 'S' 
      ,    pi_spot_bid_vndr_cnt          NUMBER   DEFAULT 3 
  ) RETURN VARCHAR2; 
   
  FUNCTION GET_MODI_SPOT_BID_VNDR_EML   
  (  
           pi_wo_prv_grp_seq                VARCHAR2  
      ,    pi_wo_iss_no                     VARCHAR2 
  ) RETURN VARCHAR2; 
 
END TRS_COM_SPOT_BID_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_COM_SPOT_BID_PKG IS
 
  /*################################################################### 
 # -- Type    : FUNCTION 
 # -- Author  : 9014787 
 # -- Created : SEP 16, 2015 
 # -- Table   : TRS_SPOT_BID_VNDR 
 # -- Purpose :  
 #####################################################################*/ 
  FUNCTION GET_SPOT_BID_VNDR_INFO 
  ( 
           pi_spot_bid_no                VARCHAR2 
      ,    pi_spot_bid_vndr_sts_cd       VARCHAR2    DEFAULT 'S' 
      ,    pi_spot_bid_vndr_cnt          NUMBER      DEFAULT 3 
  ) RETURN VARCHAR2 
 
  IS 
    v_rtn_value VARCHAR2(5000); 
 
  BEGIN 
 
    SELECT REPLACE(REPLACE(SPOT_BID_VNDR_SEQ, ',', '##'), '@@', ',') 
      INTO v_rtn_value 
      FROM(SELECT WM_CONCAT(VNDR_SEQ || '^^' || VNDR_NM || '^^' || SPOT_BID_CURR_CD || '^^' || SPOT_BID_AMT || '^^' || SPOT_BID_USD_AMT) AS SPOT_BID_VNDR_SEQ 
              FROM (SELECT VNDR_SEQ, 
                           REPLACE(TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ), ',', '@@') AS VNDR_NM, 
                           SPOT_BID_CURR_CD, 
                           SPOT_BID_AMT, 
                           TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(SPOT_BID_CURR_CD, SPOT_BID_AMT, TO_CHAR(UPD_DT, 'YYYYMMDD')) AS SPOT_BID_USD_AMT 
                      FROM TRS_SPOT_BID_VNDR 
                     WHERE 1=1 
                       AND SPOT_BID_NO = pi_spot_bid_no 
                       AND SPOT_BID_VNDR_STS_CD = pi_spot_bid_vndr_sts_cd 
                       AND SPOT_BID_AMT > 0 
                     ORDER BY TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(SPOT_BID_CURR_CD, SPOT_BID_AMT, TO_CHAR(UPD_DT, 'YYYYMMDD'))) ) WHERE ROWNUM <= pi_spot_bid_vndr_cnt; 
 
    RETURN v_rtn_value; 
 
  EXCEPTION 
            WHEN NO_DATA_FOUND THEN 
        RETURN ''; 
 
    END; 
     
     
      /*################################################################### 
 # -- Type    : FUNCTION 
 # -- Author  : 9014787 
 # -- Created : SEP 16, 2015 
 # -- Table   : TRS_SPOT_BID_VNDR 
 # -- Purpose :  
 #####################################################################*/ 
  FUNCTION GET_MODI_SPOT_BID_VNDR_EML 
  ( 
           pi_wo_prv_grp_seq                VARCHAR2 
      ,    pi_wo_iss_no                     VARCHAR2 
  ) RETURN VARCHAR2 
 
  IS 
    v_rtn_value VARCHAR2(5000); 
 
  BEGIN 
 
    SELECT REPLACE(WM_CONCAT(EML), ',', ';') EML 
      INTO v_rtn_value 
      FROM (SELECT DISTINCT(REGEXP_SUBSTR(MODI_SPOT_BID_VNDR_EML, '[^;]+', 1, LEVEL)) EML 
              FROM (SELECT MODI_SPOT_BID_VNDR_EML 
                      FROM TRS_TRSP_WRK_ORD_PRV_TMP WOPT, 
                           TRS_TRSP_SVC_ORD SO, 
                           TRS_SPOT_BID_IVT_VNDR SBIV 
                     WHERE 1=1 
                       AND WOPT.wo_prv_grp_seq = pi_wo_prv_grp_seq 
                       AND WOPT.wo_iss_no = pi_wo_iss_no 
                       AND WOPT.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD 
                       AND WOPT.TRSP_SO_SEQ = SO.TRSP_SO_SEQ 
                       AND SO.SPOT_BID_NO = SBIV.SPOT_BID_NO 
                       AND WOPT.VNDR_SEQ = SBIV.VNDR_SEQ ) CONNECT BY REGEXP_SUBSTR(MODI_SPOT_BID_VNDR_EML, '[^;]+', 1, LEVEL) IS NOT NULL); 
 
    RETURN v_rtn_value; 
 
  EXCEPTION 
            WHEN NO_DATA_FOUND THEN 
        RETURN ''; 
 
    END; 
 
END TRS_COM_SPOT_BID_PKG;
