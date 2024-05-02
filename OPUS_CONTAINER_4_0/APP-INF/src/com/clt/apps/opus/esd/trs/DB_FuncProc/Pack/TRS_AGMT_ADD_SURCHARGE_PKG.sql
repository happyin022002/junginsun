CREATE OR REPLACE PACKAGE TRS_AGMT_ADD_SURCHARGE_PKG 
AUTHID CURRENT_USER
IS

/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 27, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET AGREEMENT SURCHARGE RATE
 #####################################################################*/
  PROCEDURE GET_TRS_ADD_SURCHARGE_RATE_PRC 
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* NULL/'' or 'ONE' or 'RND'       */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND         */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2      
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* RAIL ONLY                       */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* COMBINATION TRANSPORTATION ONLY */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KGS                    */  
            ,       pi_wgt_qty                  IN  NUMBER     

      /****** 1.'HZ', 2.'LF', 3.'OW', 4.'SS', 5.'SR', 6.'SN', 7.'TD', 8.'WT' *************/
      ,   po_hz_rt                    OUT NUMBER /* HAZMAT                       */
      ,   po_lf_rt                    OUT NUMBER /* LIFTING CHARGE(PER LIFT)     */
      ,   po_ow_rt                    OUT NUMBER /* OVER-WEIGHT                  */
      ,   po_ss_rt                    OUT NUMBER /* SCALE STOP                   */
      ,   po_sr_rt                    OUT NUMBER /* STORAGE(PER DAY)             */
      ,   po_sn_rt                    OUT NUMBER /* SUNDAY RUNNING               */
      ,   po_td_rt                    OUT NUMBER /* T-DOC FEE                    */
      ,   po_wt_rt                    OUT NUMBER /* WAITING CHARGE(PER HOUR)     */
  );

END TRS_AGMT_ADD_SURCHARGE_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_AGMT_ADD_SURCHARGE_PKG IS
 
/*###################################################################
 # -- Type    : FUNCTION
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 13, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : SURCHARGE RATE CALCULATION FOR TRS MORE-CANDIDATES
 #####################################################################*/   
FUNCTION GET_ADD_SCG_RATE_CALCULATE_FNC 
  (      
          pi_system_indicator         IN  VARCHAR2    /* TRS, COA */
      ,   pi_scg_knd_indicator        IN  VARCHAR2    /* 'HZ', 'LF', 'OW', 'SS', 'SR', 'SN', 'TD', 'WT' */
      
      /* KEY - INPUT */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   pi_trsp_agmt_rt_tp          IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE
      ,   pi_way_type                 IN  VARCHAR2    /* 'ONE' 'RND'                     */
      ,   pi_bzc_curr_cd              IN  VARCHAR2    /* BASIC CURRENCY CODE             */
      ,   pi_bzc_rt                   IN  NUMBER      /* BASIC RATE                      */
      /* KEY - INPUT */      
            
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KGS */  
            ,       pi_wgt_qty                  IN  NUMBER
  )  RETURN NUMBER
  IS
  
    C_SYSTEM_INDICATOR CONSTANT VARCHAR2(3)  := 'TRS';
    
    v_rtn_value                 NUMBER(18,3) := 0.0  ;
    
    /* TEMPORARY OUTPUT VARIABLES */
    vo_scg_union_exp              VARCHAR2(50)                                       ;
    vo_trsp_agmt_ofc_cty_cd       TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
    vo_trsp_agmt_seq              TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
    vo_trsp_agmt_rt_tp_ser_no     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;
    vo_trsp_scg_cd                TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE              ;
    vo_trsp_agmt_scg_seq          TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE        ;
    vo_local_curr_cd_or_pct       VARCHAR2(3)                                        ;    
    vo_add_scg_rate_or_pct        NUMBER(18,2)                                       ;        
    vo_rtn_cd                     NUMBER                                             ;
    vo_process_rslt_msg           VARCHAR2(1000)                                     ;
  
  BEGIN
  
        /****** 1.'HZ', 2.'LF', 3.'OW', 4.'SS', 5.'SR', 6.'SN', 7.'TD', 8.'WT' *************/
    IF pi_scg_knd_indicator = 'OW' THEN
        
        /* CALL --> OVER WEIGHT SURCHARGE RATE CALCULATION */    
        TRS_AGMT_RATE_CAL_PKG.GET_SCG_RATE_CALCULATION_PRC (
                                          C_SYSTEM_INDICATOR        /* TRS, COA */
                                      ,   'NONE_USRAIL'
                                      ,   'OW'                      /* OW : OVER WEIGHT SURCHARGE */
                                      ,     pi_way_type               /* ONE or RND      */
                                      ,   pi_trsp_agmt_ofc_cty_cd
                                      ,   pi_trsp_agmt_seq
                                      ,   pi_trsp_agmt_rt_tp
                                            ,       pi_ctrl_ofc_cd            /* Pair - X , Distance - Mandatory */
                                            ,       pi_vndr_seq               
                                            ,       pi_basis_dt               
                                            ,       pi_eq_knd_cd                    
                                            ,       pi_eq_tp_sz_cd            
                                            ,       pi_cmb_tp_cd              
                                            ,       pi_cgo_tp_cd                
                                            ,       pi_bound_cd               /* OPTIONAL - IN/OUT BOUND */
                                            ,       pi_crr_mod_cd             
                                            ,       pi_cost_mod_cd            
                                            ,       pi_cust_cnt_cd            
                                            ,       pi_cust_seq               
                                            ,       pi_rail_svc_tp_cd         /* OPTIONAL */
                                            ,       pi_cmdt_cd                /* OPTIONAL */
                                            ,       pi_from_nod_cd            
                                            ,       pi_via_nod_cd             
                                            ,       pi_door_nod_cd            
                                            ,       pi_to_nod_cd              
                                            ,       pi_bundle_cnt                       
                                            ,       pi_wgt_uom                /* L-LBS, K-KG */  
                                            ,       pi_wgt_qty     
                                       
                                      /* OUTPUT ADDITIONAL REF. */
                                      ,   vo_scg_union_exp
                                      /* OUTPUT ADDITIONAL REF. */                                              
                                      /* SCG_RT PK - OUTPUT */
                                      ,   vo_trsp_agmt_ofc_cty_cd  
                                      ,   vo_trsp_agmt_seq         
                                      ,   vo_trsp_agmt_rt_tp_ser_no
                                      ,   vo_trsp_scg_cd
                                      ,   vo_trsp_agmt_scg_seq
                                      /* SCG_RT PK - OUTPUT */
                                      ,   vo_local_curr_cd_or_pct         
                                      ,   vo_add_scg_rate_or_pct              
                                      ,   vo_rtn_cd                
                                      ,   vo_process_rslt_msg      
                                      );  

    ELSE
        
        SELECT    SURCHARGE_UNION_EXP, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, TRSP_SCG_CD, TRSP_AGMT_SCG_SEQ, LOCAL_SCG_CURR_CD_OR_PERCENT, ADD_SURCHARGE_RATE_OR_PERCENT
        INTO      vo_scg_union_exp, vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_ser_no, vo_trsp_scg_cd, vo_trsp_agmt_scg_seq, vo_local_curr_cd_or_pct, vo_add_scg_rate_or_pct
        FROM      ( 
                  SELECT   'EQ_TPSZ>SAME>NULL/CMDT_CD>SAME>NULL'    SURCHARGE_UNION_EXP
                          , E.TRSP_AGMT_OFC_CTY_CD
                          , E.TRSP_AGMT_SEQ
                          , E.TRSP_AGMT_RT_TP_SER_NO
                          , E.TRSP_SCG_CD
                          , E.TRSP_AGMT_SCG_SEQ
                          , CASE WHEN E.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN E.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN E.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER                          
                          , CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                             WHEN 'RND' THEN E.RND_CURR_CD
                            END LOCAL_SCG_CURR_CD_OR_PERCENT                     /* OUTPUT VALUE CURRENCY CODE OR % */
                          , CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
                                             WHEN 'RND' THEN E.TRSP_RND_RT
                            END ADD_SURCHARGE_RATE_OR_PERCENT                                  
                  FROM      TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_SCG_RT            E
                  WHERE     A.DELT_FLG                      = 'N'
                  AND       A.DELT_FLG                      = B.DELT_FLG
                  AND       A.DELT_FLG                      = E.DELT_FLG
                  AND       A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                  AND       A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                  AND       B.TRSP_AGMT_OFC_CTY_CD          = E.TRSP_AGMT_OFC_CTY_CD
                  AND       B.TRSP_AGMT_SEQ                 = E.TRSP_AGMT_SEQ
                  AND       B.TRSP_AGMT_RT_TP_SER_NO        = E.TRSP_AGMT_RT_TP_SER_NO
                  AND       B.TRSP_AGMT_OFC_CTY_CD          = pi_trsp_agmt_ofc_cty_cd
                  AND       B.TRSP_AGMT_SEQ                 = pi_trsp_agmt_seq
                  AND       B.TRSP_AGMT_RT_TP_CD            = pi_trsp_agmt_rt_tp
                  AND       E.TRSP_SCG_CD                   = pi_scg_knd_indicator
                  AND       B.EQ_KND_CD                     = pi_eq_knd_cd
                  AND       A.VNDR_SEQ                      = pi_vndr_seq
                  AND       NVL(B.CGO_TP_CD, 'N/A')         = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE 'N/A' END
                  AND       B.TRSP_COST_MOD_CD              = TRS_AGMT_RATE_CAL_PKG.GET_CST_CD_4_PAIR_DIST_TP_FNC('P', B.EQ_KND_CD, B.CGO_TP_CD, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cost_mod_cd)
                  AND       B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                  AND       NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                  AND       NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                  AND       NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                  AND       NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                  AND       E.FM_NOD_CD                     IS NULL
                  AND       E.VIA_NOD_CD                    IS NULL
                  AND       E.DOR_NOD_CD                    IS NULL
                  AND       E.TO_NOD_CD                     IS NULL
                  AND       E.EFF_FM_DT                    <= pi_basis_dt
                  AND       E.EFF_TO_DT                    >= pi_basis_dt
                  
                  /* BASIC RATE WAY TYPE에 따라서 SURCHAGE WAY TYPE 결정 */
                  AND       CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                             WHEN 'RND' THEN E.RND_CURR_CD
                            END                             IS NOT NULL
                  /*_____________________________________________________*/
                  
                  /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                  AND    (E.AGMT_TPSZ_STS_CD             = pi_eq_tp_sz_cd
                          OR 
                          E.AGMT_TPSZ_STS_CD          LIKE '%AL%'
                          OR
                          E.AGMT_TPSZ_STS_CD             IS NULL                                
                         )
                     
                  AND    (B.CMDT_GRP_CD                  = TRS_AGMT_RATE_CAL_PKG.GET_CONV_CMDT_GRP_CD_FNC(A.VNDR_SEQ, pi_cmdt_cd)
                          OR
                          B.CMDT_GRP_CD                  IS NULL
                         )                          
                  
                  /* 1:EFF_FM_DT, 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL) */
                  ORDER BY   TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')  DESC
                           , EQ_TPSZ_PRIOR_ORDER              ASC                              
                           , B.CMDT_GRP_CD                    ASC
                  )
        WHERE     ROWNUM < 2          
        ;
                                                                                    
    END IF;  
    
    IF vo_local_curr_cd_or_pct = '%' THEN
        v_rtn_value := ROUND( (vo_local_curr_cd_or_pct * pi_bzc_rt), 3);
    ELSIF vo_local_curr_cd_or_pct != '%' AND pi_bzc_curr_cd = vo_local_curr_cd_or_pct THEN
        v_rtn_value := vo_add_scg_rate_or_pct;
    ELSE
        v_rtn_value := 0.0;
    END IF;
    
    RETURN v_rtn_value;
    
  EXCEPTION
        WHEN NO_DATA_FOUND THEN     
            DBMS_OUTPUT.PUT_LINE('%%GET_ADD_SCG_RATE_CALCULATE_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
              WHEN TOO_MANY_ROWS THEN
                  DBMS_OUTPUT.PUT_LINE('%%GET_ADD_SCG_RATE_CALCULATE_FNC%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');         
              WHEN OTHERS THEN
                  DBMS_OUTPUT.PUT_LINE('%%GET_ADD_SCG_RATE_CALCULATE_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END GET_ADD_SCG_RATE_CALCULATE_FNC;
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 27, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET AGREEMENT SURCHARGE RATE
 #####################################################################*/
  PROCEDURE GET_TRS_ADD_SURCHARGE_RATE_PRC  
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* NULL/'' or 'ONE' or 'RND'       */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND         */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2      
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* RAIL ONLY                       */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* COMBINATION TRANSPORTATION ONLY */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KGS                    */  
            ,       pi_wgt_qty                  IN  NUMBER     

      /****** 1.'HZ', 2.'LF', 3.'OW', 4.'SS', 5.'SR', 6.'SN', 7.'TD', 8.'WT' *************/
      ,   po_hz_rt                    OUT NUMBER /* HAZMAT                       */
      ,   po_lf_rt                    OUT NUMBER /* LIFTING CHARGE(PER LIFT)     */
      ,   po_ow_rt                    OUT NUMBER /* OVER-WEIGHT                  */
      ,   po_ss_rt                    OUT NUMBER /* SCALE STOP                   */
      ,   po_sr_rt                    OUT NUMBER /* STORAGE(PER DAY)             */
      ,   po_sn_rt                    OUT NUMBER /* SUNDAY RUNNING               */
      ,   po_td_rt                    OUT NUMBER /* T-DOC FEE                    */
      ,   po_wt_rt                    OUT NUMBER /* WAITING CHARGE(PER HOUR)     */
  )
  IS
  
  C_SYSTEM_INDICATOR CONSTANT VARCHAR2(3) := 'TRS';    
  USER_DEFINE_ERROR           EXCEPTION           ;  
   
  vo_trsp_agmt_ofc_cty_cd     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE          ;
  vo_trsp_agmt_seq            TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE                 ;
  vo_trsp_agmt_rt_tp_ser_no   TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE        ;
  vo_vndr_seq                     TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE              ;
  vo_cust_nomi_trkr_flg           TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE        ;
  vo_cust_cnt_cd                  TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vo_cust_seq                     TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;
  vo_trsp_agmt_rt_tp_cd           TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE        ;
  
  v_way_type                      VARCHAR2(3)  := '';
  v_bzc_curr_cd                   VARCHAR2(3)  := '';
  v_bzc_rt                        NUMBER(18,3)      ;  
  v_bzc_rtn_cd                    NUMBER(5)         ;
  v_bzc_rtn_msg                   VARCHAR2(1000)    ;
  
  /* TRUCK SO, US RAIL SO 판단결과저장변수 */
  v_trsp_so_knd_indicator         VARCHAR2(10)  ;
  v_new_rail_svc_tp_cd            VARCHAR2(2)   ;
  v_new_way_tp_cd                 VARCHAR2(10)  ;
  
  v_wtr_rcv_term_cd               TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE ;
  v_wtr_de_term_cd                TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE  ;
  
  vi_conv_cust_cnt_cd             TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vi_conv_cust_seq                TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;    
  
  BEGIN
    
    /* LOG */
    enis_log_prc (SYSDATE, 'TRS_AGMT_ADD_SURCHARGE_PKG*END', 'GET_TRS_ADD_SURCHARGE_RATE_PRC Starting, SQL_CODE = [' || SQLCODE || '], ' || SYSTIMESTAMP );              
    
    /* TRUCK SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
    
        v_trsp_so_knd_indicator := 'USRAIL';
        
        /* US RAIL S/O NONE-CNT */
        vi_conv_cust_cnt_cd     := '';
        vi_conv_cust_seq        := 0 ;
        
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd,1,2) ;   /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */
        IF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'O' THEN
            v_new_way_tp_cd := 'ONE' ;  /* ONEWAY    */
        ELSIF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'R' THEN
            v_new_way_tp_cd := 'RND' ;     /* ROUNDTRIP */
        ELSE
            v_new_way_tp_cd := ''    ;
        END IF;
        
    ELSE
    
        v_trsp_so_knd_indicator := 'TRUCK' ;
        
        /* TRUCK S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
        IF pi_cust_nomi_trkr_flg = 'Y' THEN
            vi_conv_cust_cnt_cd     := pi_cust_cnt_cd;
            vi_conv_cust_seq        := pi_cust_seq   ; 
        ELSE
            vi_conv_cust_cnt_cd     := '';
            vi_conv_cust_seq        := 0 ;         
        END IF; 
        
        IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN
            v_new_way_tp_cd := pi_way_tp_cd ;
        ELSE
            v_new_way_tp_cd := ''           ;
        END IF;

    END IF;
    /* TRUCK SO, US RAIL SO 판단 FINISHED */  
  
    /* CALL --> BASIC RATE CALCULATION */
    TRS_AGMT_RATE_CAL_PKG.GET_NONE_USRAIL_BASIC_RATE_PRC (         
                              C_SYSTEM_INDICATOR   
                                ,     pi_ctrl_ofc_cd    
                                ,       pi_vndr_seq       
                                ,       pi_basis_dt       
                                ,       v_new_way_tp_cd      
                                ,       pi_eq_knd_cd            
                                ,       pi_eq_tp_sz_cd    
                                ,       pi_cmb_tp_cd      
                                ,       pi_cgo_tp_cd        
                                ,       pi_bound_cd       
                                ,       pi_crr_mod_cd     
                                ,       pi_cost_mod_cd    
                                ,       vi_conv_cust_cnt_cd    
                                ,       vi_conv_cust_seq       
                                ,       v_new_rail_svc_tp_cd 
                                ,       pi_cmdt_cd        
                                ,       pi_from_nod_cd    
                                ,       pi_via_nod_cd     
                                ,       pi_door_nod_cd    
                                ,       pi_to_nod_cd      
                                ,       pi_bundle_cnt       
                                ,       pi_wgt_uom        
                                ,       pi_wgt_qty        
                          
                          ,   ''
                          ,   ''
                          ,   vo_trsp_agmt_ofc_cty_cd     
                          ,   vo_trsp_agmt_seq            
                          ,   vo_trsp_agmt_rt_tp_ser_no 
                          ,   vo_vndr_seq                
                          ,   vo_cust_nomi_trkr_flg  
                          ,   vo_cust_cnt_cd
                          ,   vo_cust_seq    
                          ,   vo_trsp_agmt_rt_tp_cd      
                          ,   v_way_type
                          ,   v_bzc_curr_cd            
                          ,   v_bzc_rt      
                          ,   v_wtr_rcv_term_cd
                          ,   v_wtr_de_term_cd           
                          ,   v_bzc_rtn_cd                   
                          ,   v_bzc_rtn_msg         
                          );
                          
    DBMS_OUTPUT.PUT_LINE(' ['||v_trsp_so_knd_indicator||'] S/O  BASIC RATE CAL. PROCESSING RESULT >>> RETURN CODE = ['||v_bzc_rtn_cd||'],  WAY-TYPE = ['||v_way_type||'], BASIC CURR = ['||v_bzc_curr_cd||'], BASIC RATE = ['||v_bzc_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    
      
    IF v_bzc_rtn_cd = 0 THEN
    
        /****** 1.'HZ', 2.'LF', 3.'OW', 4.'SS', 5.'SR', 6.'SN', 7.'TD', 8.'WT' *************/
        po_hz_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'HZ', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_lf_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'LF', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_ow_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'OW', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_ss_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'SS', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_sr_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'SR', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_sn_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'SN', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_td_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'TD', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
        po_wt_rt := GET_ADD_SCG_RATE_CALCULATE_FNC (C_SYSTEM_INDICATOR, 'WT', vo_trsp_agmt_ofc_cty_cd, vo_trsp_agmt_seq, vo_trsp_agmt_rt_tp_cd, v_way_type, v_bzc_curr_cd, v_bzc_rt, pi_ctrl_ofc_cd, pi_vndr_seq, pi_basis_dt, pi_eq_knd_cd, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cgo_tp_cd, pi_bound_cd, pi_crr_mod_cd, pi_cost_mod_cd, pi_cust_cnt_cd, pi_cust_seq, v_new_rail_svc_tp_cd, pi_cmdt_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd, pi_bundle_cnt, pi_wgt_uom, pi_wgt_qty);  
                
    ELSE     
    
        po_hz_rt    := 0.0; /* HAZMAT                       */
        po_lf_rt    := 0.0; /* LIFTING CHARGE(PER LIFT)     */
        po_ow_rt    := 0.0; /* OVER-WEIGHT                  */
        po_ss_rt    := 0.0; /* SCALE STOP                   */
        po_sr_rt    := 0.0; /* STORAGE(PER DAY)             */
        po_sn_rt    := 0.0; /* SUNDAY RUNNING               */
        po_td_rt    := 0.0; /* T-DOC FEE                    */
        po_wt_rt    := 0.0; /* WAITING CHARGE(PER HOUR)     */  
                            
    END IF;

    /* LOG */
    enis_log_prc (SYSDATE, 'TRS_AGMT_ADD_SURCHARGE_PKG*END', 'GET_TRS_ADD_SURCHARGE_RATE_PRC Finished, SQL_CODE = [' || SQLCODE || '], ' || SYSTIMESTAMP );              
  
  EXCEPTION
      WHEN USER_DEFINE_ERROR THEN
          enis_log_prc (SYSDATE, 'TRS_AGMT_ADD_SURCHARGE_PKG*END', 'GET_TRS_ADD_SURCHARGE_RATE_PRC USER_DEFINE_ERROR Occurred, SQL_CODE = [' || SQLCODE || '], ' || SYSTIMESTAMP );              
      WHEN OTHERS THEN 
          enis_log_prc (SYSDATE, 'TRS_AGMT_ADD_SURCHARGE_PKG*END', 'GET_TRS_ADD_SURCHARGE_RATE_PRC OTHER_ERROR Occurred, SQL_CODE = [' || SQLCODE || '], ' || SYSTIMESTAMP );              
  
  END GET_TRS_ADD_SURCHARGE_RATE_PRC;

END TRS_AGMT_ADD_SURCHARGE_PKG;
/