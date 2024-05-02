CREATE OR REPLACE PACKAGE OPUSADM.PRD_COMMON_PKG
AUTHID CURRENT_USER
AS
/*******************************************************************************
   1. Object Name      : PRD_COMMON_PKG
   2. Version          : 1.0
   3. Create Date      : 2016-09-09
   4. Sub System       : PRD
   5.Revision History
       2016.09.09 Initial Created

*******************************************************************************/
   
    /*###################################################################   
   # -- Type    : FUNCTION    
   # -- Author  : JEONG SANG-KI   
   # -- Created : SEP 9th, 2016   
   # -- Table   : 
   # -- Purpose : GET PORT CUT OFF TIME BY BOOKING NUMBER   
   #####################################################################*/
   FUNCTION PRD_GET_CCT_BY_BKG_FNC(
      pi_bkg_no             IN   VARCHAR2
   )
   RETURN DATE
   ;
   
    /*###################################################################   
   # -- Type    : FUNCTION    
   # -- Author  : JEONG SANG-KI   
   # -- Created : SEP 9th, 2016   
   # -- Table   : 
   # -- Purpose : GET PORT CUT OFF TIME BY P/C NUMBER   
   #####################################################################*/
   FUNCTION PRD_GET_CCT_BY_PC_FNC(
      pi_pctl_no         IN   VARCHAR2
   )
   RETURN DATE
   ; 
   
    /*###################################################################   
   # -- Type    : FUNCTION    
   # -- Author  : JEONG SANG-KI   
   # -- Created : OCT 10th, 2016   
   # -- Table   : 
   # -- Purpose : GET PORT CUT OFF TIME WITHOUT BKG NUMBER   
   #####################################################################*/
   FUNCTION PRD_GET_CCT_BY_BKG_INFO_FNC(
      pi_vsl_cd           IN VARCHAR2
    , pi_skd_voy_no       IN VARCHAR2
    , pi_skd_dir_cd       IN VARCHAR2
    , pi_vps_port_cd      IN VARCHAR2
    , pi_clpt_ind_seq     IN VARCHAR2
    , pi_yd_cd            IN VARCHAR2   
    , pi_cgo_type_str     IN VARCHAR2   
   )
   RETURN DATE
   ;    
      
END PRD_COMMON_PKG
;
/

CREATE OR REPLACE PACKAGE BODY OPUSADM.PRD_COMMON_PKG
AS

FUNCTION PRD_GET_CCT_BY_CGO_TP_FNC(
    I_YD_CD             IN VARCHAR2  
  , I_VSL_SLAN_CD       IN VARCHAR2  
  , I_VSL_SLAN_DIR_CD   IN VARCHAR2  
  , I_SPCL_CGO_TP_CD    IN VARCHAR2   
  , I_ETB_DT            IN DATE      
  , I_ETD_DT            IN DATE      
)
RETURN DATE
IS

/* ========================================================
   1. Object Name      : PRD_COMMON_PKG.PRD_GET_CCT_BY_CGO_TP_FNC
   2. Version          : 1.0
   3. Create Date      : 2016.09.xx
   4. Sub System       : Product Catalog
   5. Author           : SANG-KI JEONG
   6. Description      : CCT by Cargo Nature
   7. Revision History : 2016.09.xx Initial Creation
                       : 2016.10.11 Remove and Return to original Source 
                         - V_CCT_HR + V_CCT_HRMNT NVL 처리제거
                         - LPAD(V_CCT_HRMNT) 처리제거
                         2016.10.18 Add additional priority regarding Bound(Direction)

======================================================== */

  V_CCT                 DATE            ;
  IS_LOOP               BOOLEAN         := TRUE;
  CNT                   NUMBER          :=0 ;
  I_ETB                 DATE            ; 
  I_ETD                 DATE            ; 
  V_BASE_DT             DATE            ;
  V_BASE_CCT            DATE            ;
  
  V_CCT_TRUNC_FLG       VARCHAR2(1) :='';
  V_MDA_YD_BSE_CALC_FLG VARCHAR2(1) :='';
  V_CCT_TP_CD           VARCHAR2(3) :=''; 
  V_CCT_HR              VARCHAR2(2) :=''; 
  V_CCT_DY_CD           VARCHAR2(3) :='';
  V_CCT_HRMNT           VARCHAR2(4) :='';
  V_XCLD_HOL_FRI_FLG    VARCHAR2(1) :='';
  V_XCLD_HOL_SAT_FLG    VARCHAR2(1) :='';
  V_XCLD_HOL_SUN_FLG    VARCHAR2(1) :='';
  V_XCLD_HOL_HOL_FLG    VARCHAR2(1) :='';  
  
  V_GATE_OPN_HRMNT      VARCHAR2(4) :='';
  V_GATE_CLZ_HRMNT      VARCHAR2(4) :='';
  V_HOL_GATE_OPN_HRMNT  VARCHAR2(4) :='';
  V_HOL_GATE_CLZ_HRMNT  VARCHAR2(4) :='';
  V_SUN_GATE_OPN_HRMNT  VARCHAR2(4) :='';
  V_SUN_GATE_CLZ_HRMNT  VARCHAR2(4) :='';
  V_SAT_GATE_OPN_HRMNT  VARCHAR2(4) :='';
  V_SAT_GATE_CLZ_HRMNT  VARCHAR2(4) :='';
  V_GATE_FROM_HRMNT     VARCHAR2(4) :='';
  V_GATE_TO_HRMNT       VARCHAR2(4) :='';
  
BEGIN

    BEGIN   
    
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.DISABLE;
        
    DBMS_OUTPUT.PUT_LINE('');  
    DBMS_OUTPUT.PUT_LINE('::: Started PRD_GET_CCT_BY_CGO_TP_FNC :::::::::::::::::::::::::::::::::::');    
    
    SELECT  CCT_FILE_FLG   
          , YD_BSE_CALC_FLG
          , CCT_TP_CD
          , CCT_HR
          , CCT_DY_CD
          , CCT_HRMNT
          , XCLD_HOL_FRI_FLG
          , XCLD_HOL_SAT_FLG
          , XCLD_HOL_SUN_FLG
          , XCLD_HOL_HOL_FLG  
    INTO    V_CCT_TRUNC_FLG
          , V_MDA_YD_BSE_CALC_FLG
          , V_CCT_TP_CD
          , V_CCT_HR
          , V_CCT_DY_CD
          , V_CCT_HRMNT
          , V_XCLD_HOL_FRI_FLG
          , V_XCLD_HOL_SAT_FLG
          , V_XCLD_HOL_SUN_FLG
          , V_XCLD_HOL_HOL_FLG
    FROM    (
            SELECT NVL(CCT_FILE_FLG   ,'0') AS CCT_FILE_FLG
                 , NVL(YD_BSE_CALC_FLG,'0') AS YD_BSE_CALC_FLG
                 , CCT_TP_CD
                 , CCT_HR
                 , CCT_DY_CD
                 , CCT_HRMNT         
                 , XCLD_HOL_FRI_FLG
                 , XCLD_HOL_SAT_FLG
                 , XCLD_HOL_SUN_FLG
                 , XCLD_HOL_HOL_FLG
                 , RANK() OVER (PARTITION BY YD_CD ORDER BY DECODE(I_SPCL_CGO_TP_CD,I_SPCL_CGO_TP_CD,1,2)) RNK
            FROM   PRD_TML_CCT_MGMT              X
            WHERE  1 = 1
            AND    NVL(X.DELT_FLG,'N')           = 'N'
            AND    X.YD_CD                       = I_YD_CD
            AND    X.VSL_SLAN_CD                 IN ('ALL', I_VSL_SLAN_CD    )
            AND    X.VSL_SLAN_DIR_CD             IN ('A'  , I_VSL_SLAN_DIR_CD)
            AND    X.CGO_TP_CD                   = I_SPCL_CGO_TP_CD
            AND    DECODE(X.VSL_SLAN_CD,'ALL',100,0) + DECODE(X.VSL_SLAN_DIR_CD,'A',10,0) + DECODE(X.CGO_TP_CD,'AL',1,0)
                   =
                  (SELECT MIN (DECODE(Y.VSL_SLAN_CD,'ALL',100,0) + DECODE(Y.VSL_SLAN_DIR_CD,'A',10,0) + DECODE(Y.CGO_TP_CD,'AL',1,0))
                   FROM   PRD_TML_CCT_MGMT       Y
                   WHERE  Y.YD_CD                = I_YD_CD
                   AND    NVL(Y.DELT_FLG,'N')    = 'N'
                   AND    Y.VSL_SLAN_CD          IN ('ALL', I_VSL_SLAN_CD    )
                   AND    Y.VSL_SLAN_DIR_CD      IN ('A'  , I_VSL_SLAN_DIR_CD)
                   AND    Y.CGO_TP_CD            = I_SPCL_CGO_TP_CD
                   )                
            )
    WHERE   RNK = 1 
    ;
    
    DBMS_OUTPUT.PUT_LINE('Yard based on MDA                        ['||V_MDA_YD_BSE_CALC_FLG||']');    
    DBMS_OUTPUT.PUT_LINE('CCT Type                                 ['||V_CCT_TP_CD||']');
    DBMS_OUTPUT.PUT_LINE('CCT Trunc or Not (1:Truncated)           ['||V_CCT_TRUNC_FLG||']');
    DBMS_OUTPUT.PUT_LINE('CCT Time(HH:MM)                          ['||V_CCT_HRMNT||']');
    DBMS_OUTPUT.PUT_LINE('---------------- The End of Basic Information -----------------');
    DBMS_OUTPUT.PUT_LINE('');
        
       
   SELECT  NVL(GATE_OPN_HRMNT    ,'0000')
         , NVL(GATE_CLZ_HRMNT    ,'2359')
         , NVL(HOL_GATE_OPN_HRMNT,'0000')
         , NVL(HOL_GATE_CLZ_HRMNT,'2359')
         , NVL(SUN_GATE_OPN_HRMNT,'0000')
         , NVL(SUN_GATE_CLZ_HRMNT,'2359')
         , NVL(SAT_GATE_OPN_HRMNT,'0000')
         , NVL(SAT_GATE_CLZ_HRMNT,'2359')
   INTO    V_GATE_OPN_HRMNT
         , V_GATE_CLZ_HRMNT
         , V_HOL_GATE_OPN_HRMNT
         , V_HOL_GATE_CLZ_HRMNT
         , V_SUN_GATE_OPN_HRMNT
         , V_SUN_GATE_CLZ_HRMNT
         , V_SAT_GATE_OPN_HRMNT
         , V_SAT_GATE_CLZ_HRMNT  
    FROM   MDM_YARD
    WHERE  YD_CD                 = I_YD_CD 
    ; 
    
    DBMS_OUTPUT.PUT_LINE('Gate Open    Time of terminal in MDA     ['||V_GATE_OPN_HRMNT||']');
    DBMS_OUTPUT.PUT_LINE('Gate Closing Time of terminal in MDA     ['||V_GATE_CLZ_HRMNT||']');
    
    IF V_CCT_TRUNC_FLG = '1' THEN 
        I_ETB := TRUNC(I_ETB_DT);
        I_ETD := TRUNC(I_ETD_DT);
    ELSE
        I_ETB := I_ETB_DT;
        I_ETD := I_ETD_DT;
    END IF;
    
        
    IF V_CCT_TP_CD IN ('ETB','ETD') AND V_MDA_YD_BSE_CALC_FLG = '1' THEN
        V_CCT_HRMNT := NULL;
    END IF;
        
    DBMS_OUTPUT.PUT_LINE(' <<< V_CCT_HRMNT ['||V_CCT_HRMNT||'] I_ETB ['||TO_CHAR(I_ETB,'YYYY/MM/DD HH24:MI')||'] V_CCT_HR ['||V_CCT_HR||'] >>> ' );
    DBMS_OUTPUT.PUT_LINE(' <<< Final CCT is ['||TO_CHAR(TO_DATE(TO_CHAR(TRUNC(I_ETB - NVL(V_CCT_HR,0)/24), 'YYYY/MM/DD')||NVL(LPAD(V_CCT_HRMNT,4,'0'),TO_CHAR(I_ETB - NVL(V_CCT_HR,0)/24,'HH24MI')), 'YYYY/MM/DD HH24MI'),'YYYY/MM/DD HH24:MI') ||'] >>> ' );
        
    V_CCT :=  CASE  
                WHEN V_CCT_TP_CD = 'ETB' THEN TO_DATE(TO_CHAR(TRUNC(I_ETB - V_CCT_HR/24), 'YYYY/MM/DD') 
                                                    ||NVL(V_CCT_HRMNT,TO_CHAR(I_ETB - V_CCT_HR/24,'HH24MI')), 'YYYY/MM/DD HH24MI') 
                WHEN V_CCT_TP_CD = 'ETD' THEN TO_DATE(TO_CHAR(TRUNC(I_ETD - V_CCT_HR/24), 'YYYY/MM/DD') 
                                                    ||NVL(V_CCT_HRMNT,TO_CHAR(I_ETD - V_CCT_HR/24,'HH24MI')), 'YYYY/MM/DD HH24MI') 
                -- DAY ( 해당 요일의 시간보다 ETB 가 작으면 안되게)  
                WHEN V_CCT_TP_CD = 'Day' THEN 
                      CASE WHEN TRUNC(I_ETB)  >
                           TO_DATE(TO_CHAR(TRUNC(I_ETB ,'d') +
                           (
                           CASE  WHEN V_CCT_DY_CD = 'SUN' THEN 0
                                 WHEN V_CCT_DY_CD = 'MON' THEN 1
                                 WHEN V_CCT_DY_CD = 'TUE' THEN 2
                                 WHEN V_CCT_DY_CD = 'WED' THEN 3
                                 WHEN V_CCT_DY_CD = 'THU' THEN 4
                                 WHEN V_CCT_DY_CD = 'FRI' THEN 5
                                 WHEN V_CCT_DY_CD = 'SAT' THEN 6
                           END
                           ),'YYYY/MM/DD')||V_CCT_HRMNT,'YYYY/MM/DD HH24MI')
                           THEN 
                           TO_DATE(TO_CHAR(TRUNC(I_ETB,'d') + 
                           (
                           CASE  WHEN V_CCT_DY_CD = 'SUN' THEN 0
                                 WHEN V_CCT_DY_CD = 'MON' THEN 1
                                 WHEN V_CCT_DY_CD = 'TUE' THEN 2
                                 WHEN V_CCT_DY_CD = 'WED' THEN 3
                                 WHEN V_CCT_DY_CD = 'THU' THEN 4
                                 WHEN V_CCT_DY_CD = 'FRI' THEN 5
                                 WHEN V_CCT_DY_CD = 'SAT' THEN 6
                           END
                           ),'YYYY/MM/DD')||V_CCT_HRMNT,'YYYY/MM/DD HH24MI')
                      ELSE TO_DATE(TO_CHAR(TRUNC(I_ETB - 7,'d') + 
                           (
                           CASE  WHEN V_CCT_DY_CD = 'SUN' THEN 0
                                 WHEN V_CCT_DY_CD = 'MON' THEN 1
                                 WHEN V_CCT_DY_CD = 'TUE' THEN 2
                                 WHEN V_CCT_DY_CD = 'WED' THEN 3
                                 WHEN V_CCT_DY_CD = 'THU' THEN 4
                                 WHEN V_CCT_DY_CD = 'FRI' THEN 5
                                 WHEN V_CCT_DY_CD = 'SAT' THEN 6
                           END
                           ),'YYYY/MM/DD')||V_CCT_HRMNT,'YYYY/MM/DD HH24MI')
                      END      
                 -- CMN : ETB 하루전 특정시간 
                 WHEN V_CCT_TP_CD ='CMN' THEN TO_DATE(TO_CHAR(I_ETB - 1,'YYYY/MM/DD')||V_CCT_HRMNT,'YYYY/MM/DD HH24MI')
             END ;
         
                       
    V_BASE_DT := V_CCT;                       
                      
    DBMS_OUTPUT.PUT_LINE('');          
    DBMS_OUTPUT.PUT_LINE('CCT based on ETB/ETD   -- '||I_SPCL_CGO_TP_CD||' -- ['||TO_CHAR(V_CCT,'YYYY-MM-DD HH24:MI')||']');

    WHILE IS_LOOP AND CNT <30 AND V_MDA_YD_BSE_CALC_FLG = '0' LOOP
            
        IF ( V_XCLD_HOL_HOL_FLG ='1' AND PRD_GET_HOL_DAY( SUBSTR(I_YD_CD,1,5), V_BASE_DT  ) ='Y' ) OR 
           ( V_XCLD_HOL_FRI_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 6 ) OR
           ( V_XCLD_HOL_SAT_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 7 ) OR
           ( V_XCLD_HOL_SUN_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 1 )             
          THEN             
            V_CCT := V_CCT-1; 
                 
        ELSIF TRUNC(V_CCT) >= TRUNC(V_BASE_DT) 
                AND NOT ( V_XCLD_HOL_HOL_FLG ='1' AND PRD_GET_HOL_DAY( SUBSTR(I_YD_CD,1,5), V_BASE_DT ) ='Y' ) 
                AND NOT ( V_XCLD_HOL_FRI_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 6 )  
                AND NOT ( V_XCLD_HOL_SAT_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 7 ) 
                AND NOT ( V_XCLD_HOL_SUN_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 1 ) 
          THEN 
             IS_LOOP := FALSE;   
        END IF;         
           
        CNT := CNT+1;
        V_BASE_DT := V_BASE_DT - 1;
            
    END LOOP
    ;
        
    V_BASE_CCT := V_CCT;
        
    DBMS_OUTPUT.PUT_LINE('');          
    DBMS_OUTPUT.PUT_LINE('CCT based on ETB/ETD adjusted Holiday -- '||I_SPCL_CGO_TP_CD||' -- ['||TO_CHAR(V_CCT,'YYYY-MM-DD HH24:MI')||']');        
       
    WHILE  IS_LOOP AND CNT <30 AND V_MDA_YD_BSE_CALC_FLG = '1' LOOP
        
        IF      TO_CHAR(V_CCT,'d') = 7  THEN 
            V_GATE_FROM_HRMNT  := V_SAT_GATE_OPN_HRMNT;
            V_GATE_TO_HRMNT    := V_SAT_GATE_CLZ_HRMNT; 
        ELSIF   TO_CHAR(V_CCT,'d') = 1  THEN             
            V_GATE_FROM_HRMNT  := V_SUN_GATE_OPN_HRMNT;
            V_GATE_TO_HRMNT    := V_SUN_GATE_CLZ_HRMNT; 
        ELSIF   PRD_GET_HOL_DAY( SUBSTR(I_YD_CD,1,5), V_CCT  ) ='Y'  THEN 
            V_GATE_FROM_HRMNT  := V_HOL_GATE_OPN_HRMNT;
            V_GATE_TO_HRMNT    := V_HOL_GATE_CLZ_HRMNT; 
        ELSE    
            V_GATE_FROM_HRMNT  := V_GATE_OPN_HRMNT;
            V_GATE_TO_HRMNT    := V_GATE_CLZ_HRMNT;  
        END IF;  
            
        IF V_GATE_TO_HRMNT = '0000' THEN   -- 노는 날      
            V_CCT := V_CCT -1;   
                
        ELSIF  TO_CHAR(V_CCT,'HH24MI') > V_GATE_CLZ_HRMNT OR V_BASE_CCT > V_CCT THEN 
            V_CCT := TO_DATE(TO_CHAR(V_CCT,'YYYYMMDD') ||V_GATE_CLZ_HRMNT,'YYYYMMDDHH24MI');          
            IS_LOOP := FALSE;
        ELSE 
            IS_LOOP := FALSE;
        END IF;            
                
        CNT := CNT+1;
            
    END LOOP;
        

    DBMS_OUTPUT.PUT_LINE('::: Finished PRD_GET_CCT_BY_CGO_TP_FNC : final CCT -- '||I_SPCL_CGO_TP_CD||' -- ['||TO_CHAR(V_CCT,'YYYY-MM-DD HH24:MI')||'] :::');

    EXCEPTION
      
          WHEN NO_DATA_FOUND THEN    
              -- Default etb 전날 17:00
              --:2016-10-04:--V_CCT := TRUNC(I_ETB_DT) - 7/24;
              
              --IF I_ETB_DT IS NOT NULL THEN
              --    V_CCT := TRUNC(I_ETB_DT) - 7/24;
              --ELSE
              --    V_CCT := C_TMP_GREATEST_DT;
              --END IF
              --;

              --DBMS_OUTPUT.PUT_LINE('::: Exceptional(NO_DATA_FOUND) temporary CCT -- ['||TO_CHAR(V_CCT,'YYYY-MM-DD HH24:MI')||'] :::');

              RETURN NULL; 
                  
          WHEN OTHERS
          THEN
              -- Default etb 전날 17:00
              --:2016-10-04:--V_CCT := TRUNC(I_ETB_DT) - 7/24;
              --V_CCT := C_TMP_GREATEST_DT;

              --DBMS_OUTPUT.PUT_LINE('::: Exceptional(OTHERS) temporary CCT -- ['||TO_CHAR(V_CCT,'YYYY-MM-DD HH24:MI')||'] :::');

              RETURN NULL;   
    END;

    DBMS_OUTPUT.PUT_LINE('');  
    RETURN V_CCT;   

END PRD_GET_CCT_BY_CGO_TP_FNC
;


/*###################################################################   
# -- Type    : FUNCTION    
# -- Author  : JEONG SANG-KI   
# -- Created : SEP 9th, 2016   
# -- Table   : 
# -- Purpose : GET PORT CUT OFF TIME BY BOOKING NUMBER   
#####################################################################*/
FUNCTION PRD_GET_CCT_BY_BKG_FNC(
pi_bkg_no             IN   VARCHAR2   
)
RETURN DATE
IS

    tmp_vvd_clz_dt DATE        := '';

    tmp_yd_cd      VARCHAR2(7) := '';    
    tmp_slan_cd    VARCHAR2(3) := '';
    tmp_skd_dir_cd VARCHAR2(1) := '';
    tmp_dg_flg     VARCHAR2(1) := '';
    tmp_rf_flg     VARCHAR2(1) := '';
    tmp_ak_flg     VARCHAR2(1) := '';
    tmp_bb_flg     VARCHAR2(1) := '';
    tmp_dry_flg    VARCHAR2(1) := '';
    
    tmp_etb_dt     DATE        := '';  
    tmp_etd_dt     DATE        := '';
    
    tmp_dg_clz_dt  DATE        := '';
    tmp_rf_clz_dt  DATE        := '';
    tmp_ak_clz_dt  DATE        := '';
    tmp_bb_clz_dt  DATE        := '';
    tmp_dry_clz_dt DATE        := '';
    
    tmp_general_clz_dt DATE    := '';
    
    C_TMP_GREATEST_DT CONSTANT DATE:=  TO_DATE('99991231235959','YYYYMMDDHH24MISS');
    
    po_rtn_value   DATE        := '';
      
BEGIN
   
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.DISABLE;
    
    DBMS_OUTPUT.PUT_LINE('::: Started PRD_GET_CCT_BY_BKG_FNC :::::::::::::::::::::::::::::::::::');   
  
    SELECT   LEAST(NVL(X.DCGO_CLZ_DT   ,C_TMP_GREATEST_DT)
                  ,NVL(X.RC_CLZ_DT     ,C_TMP_GREATEST_DT)
                  ,NVL(X.AWK_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ,NVL(X.BB_CGO_CLZ_DT ,C_TMP_GREATEST_DT)
                  ,NVL(X.DRY_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ) AS VVD_CLZ_DT

          ,  X.YD_CD                  
          ,  X.SLAN_CD
          ,  X.SKD_DIR_CD
          ,  X.DCGO_FLG     
          ,  X.RC_FLG     
          ,  X.AWK_CGO_FLG
          ,  X.BB_CGO_FLG 
          ,  X.DRY_CGO_FLG    
          ,  X.VPS_ETB_DT
          ,  X.VPS_ETD_DT
    INTO     tmp_vvd_clz_dt,tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,tmp_dg_flg,tmp_rf_flg,tmp_ak_flg,tmp_bb_flg,tmp_dry_flg,tmp_etb_dt,tmp_etd_dt
    FROM     (
             ---------------------------------------------------------------------------
            SELECT   BK.BKG_NO
                    
                  ,  CASE WHEN BK.DCGO_FLG    = 'Y' AND PS.DCGO_CLZ_DT    IS NOT NULL THEN PS.DCGO_CLZ_DT    --NVL(PS.DCGO_CLZ_DT   ,PS.CGO_CLZ_DT)
                     END  DCGO_CLZ_DT
                  ,  CASE WHEN BK.RC_FLG      = 'Y' AND PS.RC_CLZ_DT      IS NOT NULL THEN PS.RC_CLZ_DT      --NVL(PS.RC_CLZ_DT     ,PS.CGO_CLZ_DT)     
                     END  RC_CLZ_DT
                  ,  CASE WHEN BK.AWK_CGO_FLG = 'Y' AND PS.AWK_CGO_CLZ_DT IS NOT NULL THEN PS.AWK_CGO_CLZ_DT --NVL(PS.AWK_CGO_CLZ_DT,PS.CGO_CLZ_DT)
                     END  AWK_CGO_CLZ_DT
                  ,  CASE WHEN BK.BB_CGO_FLG  = 'Y' AND PS.BB_CGO_CLZ_DT  IS NOT NULL THEN PS.BB_CGO_CLZ_DT  --NVL(PS.BB_CGO_CLZ_DT ,PS.CGO_CLZ_DT) 
                     END  BB_CGO_CLZ_DT
                  ,  CASE WHEN (SELECT COUNT(1) FROM BKG_QTY_DTL QTY WHERE QTY.BKG_NO = BK.BKG_NO AND QTY.DRY_CGO_FLG = 'Y')>0 THEN PS.CGO_CLZ_DT
                     END                      AS DRY_CGO_CLZ_DT
                  --,  CASE WHEN BK.DCGO_FLG    = 'N' AND BK.RC_FLG = 'N' AND BK.AWK_CGO_FLG = 'N' AND BK.BB_CGO_FLG = 'N' THEN PS.CGO_CLZ_DT
                  --   END  DRY_CGO_CLZ_DT

                  ,  BV.POL_YD_CD             AS YD_CD                  
                  ,  BV.SLAN_CD               
                  ,  BV.SKD_DIR_CD                  
                  ,  NVL(BK.DCGO_FLG   ,'N')  AS DCGO_FLG
                  ,  NVL(BK.RC_FLG     ,'N')  AS RC_FLG
                  ,  NVL(BK.AWK_CGO_FLG,'N')  AS AWK_CGO_FLG
                  ,  NVL(BK.BB_CGO_FLG ,'N')  AS BB_CGO_FLG
                  
                  ,  CASE WHEN (SELECT COUNT(1) FROM BKG_QTY_DTL QTY WHERE QTY.BKG_NO = BK.BKG_NO AND QTY.DRY_CGO_FLG = 'Y')>0 THEN 'Y'
                          ELSE 'N'
                     END                      AS DRY_CGO_FLG
                  
                  ,  PS.VPS_ETB_DT
                  ,  PS.VPS_ETD_DT
            FROM     BKG_BOOKING              BK
                  ,  BKG_VVD                  BV
                  ,  VSK_VSL_PORT_SKD         PS
            WHERE    1 = 1
            AND      BK.BKG_NO                = BV.BKG_NO
            AND      BV.VSL_PRE_PST_CD        IN ('S','T')
            AND      BK.BKG_NO                = pi_bkg_no
            AND      (BV.VSL_PRE_PST_CD
                     ,BV.VSL_SEQ)             IN   (
                                                   SELECT   VSL_PRE_PST_CD,VSL_SEQ
                                                   FROM     (
                                                            SELECT   BVV.BKG_NO
                                                                   , BVV.VSL_PRE_PST_CD
                                                                   , BVV.VSL_SEQ
                                                                   , RANK() OVER (PARTITION BY BVV.BKG_NO ORDER BY BVV.VSL_PRE_PST_CD ASC, BVV.VSL_SEQ ASC) RNK
                                                            FROM     BKG_VVD                BVV
                                                            WHERE    BVV.VSL_PRE_PST_CD     IN ('S','T')
                                                            AND      BVV.BKG_NO             = pi_bkg_no
                                                            )
                                                   WHERE     RNK = 1      
                                                   )
            AND      BV.VSL_CD                 = PS.VSL_CD       (+)
            AND      BV.SKD_VOY_NO             = PS.SKD_VOY_NO   (+)
            AND      BV.SKD_DIR_CD             = PS.SKD_DIR_CD   (+)
            AND      BV.POL_CD                 = PS.VPS_PORT_CD  (+)
            AND      BV.POL_CLPT_IND_SEQ       = PS.CLPT_IND_SEQ (+)
             ---------------------------------------------------------------------------
             ) X     
    ; 
    
    
    IF tmp_vvd_clz_dt < C_TMP_GREATEST_DT THEN
      
        po_rtn_value := tmp_vvd_clz_dt;
        
        DBMS_OUTPUT.PUT_LINE('::::::: FINAL(BKG#) CCT by VVD in VSK_VSL_PORT_SKD           ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||']  :::::::');        
    
    ELSE
      
      DBMS_OUTPUT.PUT_LINE('Cannot find CCT in VSK_VSL_PORT_SKD      >>>>>>>>>>    SPECIAL CARGO TYPE');
      
      IF tmp_dg_flg = 'Y' THEN
        tmp_dg_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'DG',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by DG           ['||TO_CHAR(tmp_dg_clz_dt,'YYYY-MM-DD HH24:MI')||']');    
      END IF
      ;
      
      IF tmp_rf_flg = 'Y' THEN
        tmp_rf_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'RF',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by RF           ['||TO_CHAR(tmp_rf_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      IF tmp_ak_flg = 'Y' THEN
        tmp_ak_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'AK',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by AK           ['||TO_CHAR(tmp_ak_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      IF tmp_bb_flg = 'Y' THEN
        tmp_bb_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'BB',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by BB           ['||TO_CHAR(tmp_bb_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;   
      
      IF tmp_dry_flg = 'Y' THEN
        tmp_dry_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'DR',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by DRY          ['||TO_CHAR(tmp_dry_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      
      SELECT LEAST(NVL(tmp_dg_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_rf_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_ak_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_bb_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_dry_clz_dt,C_TMP_GREATEST_DT)
                  ) 
      INTO   po_rtn_value
      FROM   DUAL
      ;
      
      IF po_rtn_value = C_TMP_GREATEST_DT THEN
          tmp_general_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'AL',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT(BKG#) by General ['||TO_CHAR(tmp_general_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
          
          po_rtn_value := NVL(tmp_general_clz_dt,C_TMP_GREATEST_DT);
          
          IF po_rtn_value = C_TMP_GREATEST_DT AND tmp_etb_dt IS NOT NULL THEN
              po_rtn_value  := TRUNC(tmp_etb_dt) - 7/24;
          ELSIF po_rtn_value = C_TMP_GREATEST_DT THEN
              po_rtn_value  := NULL;              
          END IF
          ;   
          
      END IF
      ; 
      
    END IF
    ;
    
    DBMS_OUTPUT.PUT_LINE('::::::: FINAL(BKG#) CCT by Each Special Cargo   ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||'] :::::::');   

    RETURN po_rtn_value;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
        
    WHEN OTHERS THEN
        RETURN NULL;
   
END PRD_GET_CCT_BY_BKG_FNC
;


/*###################################################################   
# -- Type    : FUNCTION    
# -- Author  : JEONG SANG-KI   
# -- Created : SEP 9th, 2016   
# -- Table   : 
# -- Purpose : GET PORT CUT OFF TIME BY P/C NUMBER   
#####################################################################*/
FUNCTION PRD_GET_CCT_BY_PC_FNC(
pi_pctl_no         IN   VARCHAR2    
)
RETURN DATE
IS
    
    tmp_vvd_clz_dt DATE        := '';

    tmp_yd_cd      VARCHAR2(7) := '';    
    tmp_slan_cd    VARCHAR2(3) := '';
    tmp_skd_dir_cd VARCHAR2(1) := '';
    tmp_dg_flg     VARCHAR2(1) := '';
    tmp_rf_flg     VARCHAR2(1) := '';
    tmp_ak_flg     VARCHAR2(1) := '';
    tmp_bb_flg     VARCHAR2(1) := '';
    tmp_dry_flg    VARCHAR2(1) := '';
    
    tmp_etb_dt     DATE        := '';  
    tmp_etd_dt     DATE        := '';
    
    tmp_dg_clz_dt  DATE        := '';
    tmp_rf_clz_dt  DATE        := '';
    tmp_ak_clz_dt  DATE        := '';
    tmp_bb_clz_dt  DATE        := '';
    tmp_dry_clz_dt DATE        := '';
    
    tmp_general_clz_dt DATE    := '';    
    
    C_TMP_GREATEST_DT CONSTANT DATE:=  TO_DATE('99991231235959','YYYYMMDDHH24MISS');
    
    po_rtn_value   DATE        := '';
      
BEGIN
  
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.DISABLE;
    
    DBMS_OUTPUT.PUT_LINE('::: Started PRD_GET_CCT_BY_PC_FNC :::::::::::::::::::::::::::::::::::');   
  
    SELECT   LEAST(NVL(X.DCGO_CLZ_DT   ,C_TMP_GREATEST_DT)
                  ,NVL(X.RC_CLZ_DT     ,C_TMP_GREATEST_DT)
                  ,NVL(X.AWK_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ,NVL(X.BB_CGO_CLZ_DT ,C_TMP_GREATEST_DT)
                  ,NVL(X.DRY_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ) AS VVD_CLZ_DT

          ,  X.YD_CD                  
          ,  X.SLAN_CD
          ,  X.SKD_DIR_CD
          ,  X.DG_SPCL_FLG     
          ,  X.RF_SPCL_FLG     
          ,  X.SPCL_AWK_CGO_FLG
          ,  X.BB_SPCL_FLG     
          ,  X.DRY_CGO_FLG 
          ,  X.VPS_ETB_DT
          ,  X.VPS_ETD_DT
    INTO     tmp_vvd_clz_dt,tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,tmp_dg_flg,tmp_rf_flg,tmp_ak_flg,tmp_bb_flg,tmp_dry_flg,tmp_etb_dt,tmp_etd_dt
    FROM     (
             ---------------------------------------------------------------------------
            SELECT   X.PCTL_NO
                    
                  ,  CASE WHEN NVL(X.DG_SPCL_FLG,'N')      = 'Y' AND PS.DCGO_CLZ_DT    IS NOT NULL THEN PS.DCGO_CLZ_DT    --NVL(PS.DCGO_CLZ_DT   ,PS.CGO_CLZ_DT)   
                     END  DCGO_CLZ_DT
                  ,  CASE WHEN NVL(X.RF_SPCL_FLG,'N')      = 'Y' AND PS.RC_CLZ_DT      IS NOT NULL THEN PS.RC_CLZ_DT      --NVL(PS.RC_CLZ_DT     ,PS.CGO_CLZ_DT)   
                     END  RC_CLZ_DT
                  ,  CASE WHEN NVL(X.SPCL_AWK_CGO_FLG,'N') = 'Y' AND PS.AWK_CGO_CLZ_DT IS NOT NULL THEN PS.AWK_CGO_CLZ_DT --NVL(PS.AWK_CGO_CLZ_DT,PS.CGO_CLZ_DT)
                     END  AWK_CGO_CLZ_DT
                  ,  CASE WHEN NVL(X.BB_SPCL_FLG,'N')      = 'Y' AND PS.BB_CGO_CLZ_DT  IS NOT NULL THEN PS.BB_CGO_CLZ_DT  --NVL(PS.BB_CGO_CLZ_DT ,PS.CGO_CLZ_DT) 
                     END  BB_CGO_CLZ_DT
                  ,  CASE WHEN NVL(X.DG_SPCL_FLG,'N')      = 'N' AND NVL(X.RF_SPCL_FLG,'N') = 'N' AND NVL(X.SPCL_AWK_CGO_FLG,'N') = 'N' AND NVL(X.BB_SPCL_FLG,'N') = 'N' THEN PS.CGO_CLZ_DT
                     END  DRY_CGO_CLZ_DT

                  ,  Y.ORG_NOD_CD                          AS YD_CD                  
                  ,  Y.VSL_SLAN_CD                         AS SLAN_CD
                  ,  Y.SKD_DIR_CD                  
                  ,  NVL(X.DG_SPCL_FLG     ,'N')           AS DG_SPCL_FLG
                  ,  NVL(X.RF_SPCL_FLG     ,'N')           AS RF_SPCL_FLG
                  ,  NVL(X.SPCL_AWK_CGO_FLG,'N')           AS SPCL_AWK_CGO_FLG
                  ,  NVL(X.BB_SPCL_FLG     ,'N')           AS BB_SPCL_FLG
                  ,  CASE WHEN NVL(X.DG_SPCL_FLG,'N')      = 'N' AND NVL(X.RF_SPCL_FLG,'N') = 'N' AND NVL(X.SPCL_AWK_CGO_FLG,'N') = 'N' AND NVL(X.BB_SPCL_FLG,'N') = 'N' THEN 'Y'
                          ELSE 'N'
                     END                                   AS DRY_CGO_FLG     
                  ,  NVL(PS.VPS_ETB_DT,Y.ARR_ST_DT)        AS VPS_ETB_DT
                  ,  NVL(PS.VPS_ETD_DT,Y.ARR_ST_DT)        AS VPS_ETD_DT
            FROM     PRD_PROD_CTL_MST                      X
                  ,  PRD_PROD_CTL_ROUT_DTL                 Y
                  ,  VSK_VSL_PORT_SKD                      PS
            WHERE    1 = 1
            AND      X.PCTL_NO                             = Y.PCTL_NO
            AND      X.PCTL_NO                             = pi_pctl_no
            AND      Y.PCTL_SEQ                            = (SELECT   MIN(YY.PCTL_SEQ)
                                                              FROM     PRD_PROD_CTL_ROUT_DTL YY
                                                              WHERE    YY.PCTL_NO            = Y.PCTL_NO
                                                              AND      YY.PCTL_IO_BND_CD     = 'T'
                                                              AND      YY.TRSP_MOD_CD        IN ('VD','WD')
                                                              AND      YY.VSL_SLAN_CD        IS NOT NULL
                                                              ----:2016/09/14:----AND      YY.VSL_CD             IS NOT NULL
                                                             )
            AND      Y.VSL_CD                              = PS.VSL_CD       (+)
            AND      Y.SKD_VOY_NO                          = PS.SKD_VOY_NO   (+)
            AND      Y.SKD_DIR_CD                          = PS.SKD_DIR_CD   (+)
            AND      SUBSTR(Y.ORG_NOD_CD,1,5)              = PS.VPS_PORT_CD  (+)
            AND      Y.ORG_CLPT_IND_SEQ                    = PS.CLPT_IND_SEQ (+)
             ---------------------------------------------------------------------------
             ) X     
    ; 
    
    IF tmp_vvd_clz_dt < C_TMP_GREATEST_DT THEN
      
        po_rtn_value := tmp_vvd_clz_dt;
        
        DBMS_OUTPUT.PUT_LINE('::::::: FINAL(P/C#) CCT by VVD in VSK_VSL_PORT_SKD           ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||']  :::::::');        
    
    ELSE
      
      DBMS_OUTPUT.PUT_LINE('Cannot find CCT in VSK_VSL_PORT_SKD      >>>>>>>>>>    SPECIAL CARGO TYPE');
      
      IF tmp_dg_flg = 'Y' THEN
        tmp_dg_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'DG',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by DG           ['||TO_CHAR(tmp_dg_clz_dt,'YYYY-MM-DD HH24:MI')||']');    
      END IF
      ;
      
      IF tmp_rf_flg = 'Y' THEN
        tmp_rf_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'RF',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by RF           ['||TO_CHAR(tmp_rf_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      IF tmp_ak_flg = 'Y' THEN
        tmp_ak_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'AK',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by AK           ['||TO_CHAR(tmp_ak_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      IF tmp_bb_flg = 'Y' THEN
        tmp_bb_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'BB',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by BB           ['||TO_CHAR(tmp_bb_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;   
      
      IF tmp_dg_flg = 'N' AND tmp_rf_flg = 'N' AND tmp_ak_flg = 'N' AND tmp_bb_flg = 'N' THEN
        tmp_dry_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'DR',tmp_etb_dt,tmp_etd_dt);
        DBMS_OUTPUT.PUT_LINE('CCT by DRY      ['||TO_CHAR(tmp_dry_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
      END IF
      ;
      
      
      SELECT LEAST(NVL(tmp_dg_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_rf_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_ak_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_bb_clz_dt ,C_TMP_GREATEST_DT)
                  ,NVL(tmp_dry_clz_dt,C_TMP_GREATEST_DT)
                  ) 
      INTO   po_rtn_value
      FROM   DUAL
      ;
      
     
      IF po_rtn_value = C_TMP_GREATEST_DT THEN
          tmp_general_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(tmp_yd_cd,tmp_slan_cd,tmp_skd_dir_cd,'AL',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT(BKG#) by General ['||TO_CHAR(tmp_general_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
          
          po_rtn_value := NVL(tmp_general_clz_dt,C_TMP_GREATEST_DT);
          
          IF po_rtn_value = C_TMP_GREATEST_DT AND tmp_etb_dt IS NOT NULL THEN
              po_rtn_value  := TRUNC(tmp_etb_dt) - 7/24;
          ELSIF po_rtn_value = C_TMP_GREATEST_DT THEN
              po_rtn_value  := NULL;              
          END IF
          ;   
          
      END IF
      ; 
            
            
      DBMS_OUTPUT.PUT_LINE('::::::: FINAL(P/C#) CCT by Each Special Cargo   ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||'] :::::::');   

    END IF
    ;

    RETURN po_rtn_value;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
        
    WHEN OTHERS THEN
        RETURN NULL;
   
END PRD_GET_CCT_BY_PC_FNC
;



/*###################################################################   
# -- Type    : FUNCTION    
# -- Author  : JEONG SANG-KI   
# -- Created : OCT 10th, 2016   
# -- Table   : 
# -- Purpose : GET PORT CUT OFF TIME WITHOUT BKG NUMBER   
#####################################################################*/
FUNCTION PRD_GET_CCT_BY_BKG_INFO_FNC(
    pi_vsl_cd           IN VARCHAR2
  , pi_skd_voy_no       IN VARCHAR2
  , pi_skd_dir_cd       IN VARCHAR2
  , pi_vps_port_cd      IN VARCHAR2
  , pi_clpt_ind_seq     IN VARCHAR2  
  , pi_yd_cd            IN VARCHAR2   
  , pi_cgo_type_str     IN VARCHAR2          /* Special Cargo Type String : DG>RF>AK>BB>DRY i.e. "NNNNY", "YNNYN" */
)   
RETURN DATE
IS
    
    tmp_vvd_clz_dt DATE        := '';

    tmp_slan_cd    VARCHAR2(3) := '';

    tmp_cgo_type_str VARCHAR2(5):='';
    tmp_dg_flg     VARCHAR2(1) := '';
    tmp_rf_flg     VARCHAR2(1) := '';
    tmp_ak_flg     VARCHAR2(1) := '';
    tmp_bb_flg     VARCHAR2(1) := '';
    tmp_dry_flg    VARCHAR2(1) := '';
    
    tmp_etb_dt     DATE        := '';  
    tmp_etd_dt     DATE        := '';
    
    tmp_dg_clz_dt  DATE        := '';
    tmp_rf_clz_dt  DATE        := '';
    tmp_ak_clz_dt  DATE        := '';
    tmp_bb_clz_dt  DATE        := '';
    tmp_dry_clz_dt DATE        := '';
    
    tmp_general_clz_dt DATE    := '';    
    
    C_TMP_GREATEST_DT CONSTANT DATE:=  TO_DATE('99991231235959','YYYYMMDDHH24MISS');
    
    po_rtn_value   DATE        := '';
      
BEGIN
  
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.DISABLE;
    
    DBMS_OUTPUT.PUT_LINE('::: Started PRD_GET_CCT_BY_BKG_INFO_FNC :::::::::::::::::::::::::::::::::::'); 
    
    
    IF LENGTH(pi_cgo_type_str) <> 5 THEN
        tmp_cgo_type_str := 'NNNNY'; -- ONLY DRY Booking --
    ELSE
        tmp_cgo_type_str := pi_cgo_type_str;
    END IF
    ;
    
    tmp_dg_flg  := SUBSTR(tmp_cgo_type_str,1,1);
    tmp_rf_flg  := SUBSTR(tmp_cgo_type_str,2,1);
    tmp_ak_flg  := SUBSTR(tmp_cgo_type_str,3,1);
    tmp_bb_flg  := SUBSTR(tmp_cgo_type_str,4,1);
    tmp_dry_flg := SUBSTR(tmp_cgo_type_str,5,1);
    
    DBMS_OUTPUT.PUT_LINE('::: DG ['||tmp_dg_flg||'] -- RF ['||tmp_rf_flg||'] -- AK ['||tmp_ak_flg||'] -- BB ['||tmp_bb_flg||'] -- DRY ['||tmp_dry_flg||']'); 
    
    SELECT   LEAST(NVL(X.DCGO_CLZ_DT   ,C_TMP_GREATEST_DT)
                  ,NVL(X.RC_CLZ_DT     ,C_TMP_GREATEST_DT)
                  ,NVL(X.AWK_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ,NVL(X.BB_CGO_CLZ_DT ,C_TMP_GREATEST_DT)
                  ,NVL(X.DRY_CGO_CLZ_DT,C_TMP_GREATEST_DT)
                  ) AS VVD_CLZ_DT

          ,  X.SLAN_CD
          ,  X.VPS_ETB_DT
          ,  X.VPS_ETD_DT
    INTO     tmp_vvd_clz_dt,tmp_slan_cd,tmp_etb_dt,tmp_etd_dt
    FROM     (
             ---------------------------------------------------------------------------
            SELECT   CASE WHEN NVL(tmp_dg_flg ,'N')     = 'Y' AND PS.DCGO_CLZ_DT    IS NOT NULL THEN PS.DCGO_CLZ_DT     
                     END  DCGO_CLZ_DT
                  ,  CASE WHEN NVL(tmp_rf_flg ,'N')     = 'Y' AND PS.RC_CLZ_DT      IS NOT NULL THEN PS.RC_CLZ_DT      
                     END  RC_CLZ_DT
                  ,  CASE WHEN NVL(tmp_ak_flg ,'N')     = 'Y' AND PS.AWK_CGO_CLZ_DT IS NOT NULL THEN PS.AWK_CGO_CLZ_DT 
                     END  AWK_CGO_CLZ_DT
                  ,  CASE WHEN NVL(tmp_bb_flg ,'N')     = 'Y' AND PS.BB_CGO_CLZ_DT  IS NOT NULL THEN PS.BB_CGO_CLZ_DT   
                     END  BB_CGO_CLZ_DT
                  ,  CASE WHEN NVL(tmp_dry_flg,'N')     = 'Y' AND PS.CGO_CLZ_DT     IS NOT NULL THEN PS.CGO_CLZ_DT
                     END  DRY_CGO_CLZ_DT

                  ,  PS.SLAN_CD                
                  ,  PS.VPS_ETB_DT
                  ,  PS.VPS_ETD_DT
            FROM     VSK_VSL_PORT_SKD             PS
            WHERE    1 = 1
            AND      PS.VSL_CD                    = pi_vsl_cd
            AND      PS.SKD_VOY_NO                = pi_skd_voy_no
            AND      PS.SKD_DIR_CD                = pi_skd_dir_cd
            AND      PS.VPS_PORT_CD               = pi_vps_port_cd
            AND      PS.CLPT_IND_SEQ              = pi_clpt_ind_seq
             ---------------------------------------------------------------------------
             ) X     
    ; 
    
    IF tmp_vvd_clz_dt < C_TMP_GREATEST_DT THEN
      
        po_rtn_value := tmp_vvd_clz_dt;
        
        DBMS_OUTPUT.PUT_LINE('::::::: FINAL(from BKG INFO) CCT by VVD in VSK_VSL_PORT_SKD           ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||']  :::::::');        
    
    ELSE
      
        DBMS_OUTPUT.PUT_LINE('Cannot find CCT in VSK_VSL_PORT_SKD      >>>>>>>>>>    SPECIAL CARGO TYPE');
        
        IF tmp_dg_flg = 'Y' THEN
          tmp_dg_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'DG',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT by DG           ['||TO_CHAR(tmp_dg_clz_dt,'YYYY-MM-DD HH24:MI')||']');    
        END IF
        ;
        
        IF tmp_rf_flg = 'Y' THEN
          tmp_rf_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'RF',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT by RF           ['||TO_CHAR(tmp_rf_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
        END IF
        ;
        
        IF tmp_ak_flg = 'Y' THEN
          tmp_ak_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'AK',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT by AK           ['||TO_CHAR(tmp_ak_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
        END IF
        ;
        
        IF tmp_bb_flg = 'Y' THEN
          tmp_bb_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'BB',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT by BB           ['||TO_CHAR(tmp_bb_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
        END IF
        ;   
        
        IF tmp_dry_flg = 'Y' THEN
          tmp_dry_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'DR',tmp_etb_dt,tmp_etd_dt);
          DBMS_OUTPUT.PUT_LINE('CCT by DRY      ['||TO_CHAR(tmp_dry_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
        END IF
        ;
        
        
        SELECT LEAST(NVL(tmp_dg_clz_dt ,C_TMP_GREATEST_DT)
                    ,NVL(tmp_rf_clz_dt ,C_TMP_GREATEST_DT)
                    ,NVL(tmp_ak_clz_dt ,C_TMP_GREATEST_DT)
                    ,NVL(tmp_bb_clz_dt ,C_TMP_GREATEST_DT)
                    ,NVL(tmp_dry_clz_dt,C_TMP_GREATEST_DT)
                    ) 
        INTO   po_rtn_value
        FROM   DUAL
        ;
        
       
        IF po_rtn_value = C_TMP_GREATEST_DT THEN
            tmp_general_clz_dt := PRD_GET_CCT_BY_CGO_TP_FNC(pi_yd_cd,tmp_slan_cd,pi_skd_dir_cd,'AL',tmp_etb_dt,tmp_etd_dt);
            DBMS_OUTPUT.PUT_LINE('CCT(from BKG INFO) by General ['||TO_CHAR(tmp_general_clz_dt,'YYYY-MM-DD HH24:MI')||']'); 
            
            po_rtn_value := NVL(tmp_general_clz_dt,C_TMP_GREATEST_DT);
            
            IF po_rtn_value = C_TMP_GREATEST_DT AND tmp_etb_dt IS NOT NULL THEN
                po_rtn_value  := TRUNC(tmp_etb_dt) - 7/24;
            ELSIF po_rtn_value = C_TMP_GREATEST_DT THEN
                po_rtn_value  := NULL;              
            END IF
            ;   
            
        END IF
        ; 
              
              
        DBMS_OUTPUT.PUT_LINE('::::::: FINAL(from BKG INFO) CCT by Each Special Cargo   ['||TO_CHAR(po_rtn_value,'YYYY-MM-DD HH24:MI')||'] :::::::');   

    END IF
    ;

    RETURN po_rtn_value;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
        
    WHEN OTHERS THEN
        RETURN NULL;
   
END PRD_GET_CCT_BY_BKG_INFO_FNC
;

END PRD_COMMON_PKG
;
/

