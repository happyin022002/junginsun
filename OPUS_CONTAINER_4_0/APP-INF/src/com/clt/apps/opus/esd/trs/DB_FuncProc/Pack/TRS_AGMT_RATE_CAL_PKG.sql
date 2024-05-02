/*******************************************************************************
   1. Object Name      : TRS_AGMT_RATE_CAL_PKG
   2. Version          : 1.0
   3. Create Date      : FEB 1, 2007
   4. Sub System       : TRS
   5. Author           : JEONG SANG-KI
   6. Description      : Agreement Rate Calculation
   7. Revision History : 
*******************************************************************************/

CREATE OR REPLACE PACKAGE TRS_AGMT_RATE_CAL_PKG 
AUTHID CURRENT_USER
IS
 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 22, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET NODE COUNT 
 #####################################################################*/
  FUNCTION GET_LINK_CNT_FNC 
  (
           pi_from_nod_cd       VARCHAR2
      ,    pi_via_nod_cd        VARCHAR2  
      ,    pi_door_nod_cd       VARCHAR2        
      ,    pi_to_nod_cd         VARCHAR2 
  ) RETURN NUMBER;
  
 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 26, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET NODE COUNT 
 #####################################################################*/
  FUNCTION GET_CST_CD_4_PAIR_DIST_TP_FNC 
  (
           pi_agmt_rate_tp        VARCHAR2   /* P : PAIR, D : DISTANCE */
         , pi_eq_knd_cd            VARCHAR2   /* U : Container, Z : CHassis, G : Genset */
         , pi_cgo_tp_cd           VARCHAR2   /* F : Full, M : EMpty    */
         , pi_eq_tpsz_cd          VARCHAR2   /* D2, R2, F?, ...        */
         , pi_cmb_tp_cd           VARCHAR2   /* BD : Bundle, CF : Combined Case One, FF : Full+Full, FM : Full_Empty */
         , pi_cost_mod_cd         VARCHAR2   /* DR : Door              */
  ) RETURN VARCHAR2
;
  
  /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 16, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM KILOMETER BETWEEN TWO NODES
 #####################################################################*/
  FUNCTION GET_CAL_DIST_2_NOD_FNC 
  (    
          pi_dist_uom          VARCHAR2
      ,   pi_start_nod_cd      VARCHAR2
      ,   pi_end_nod_cd        VARCHAR2    
  ) RETURN NUMBER;

  /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 16, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM BETWEEN TWO NODES
 #####################################################################*/
  FUNCTION GET_CAL_DIST_BTWN_NOD_FNC 
  (    
          pi_dist_uom          VARCHAR2
      ,   pi_agmt_rt_tp        VARCHAR2           /* P, PD, DP, D */
      ,   pi_cost_mod_cd       VARCHAR2           /* DR, Non-DR   */
      ,   pi_bound_cd          VARCHAR2           /* I, O         */
      ,   pi_from_nod_cd       VARCHAR2
      ,   pi_via_nod_cd        VARCHAR2    
      ,   pi_door_nod_cd       VARCHAR2    
      ,   pi_to_nod_cd         VARCHAR2    
  ) RETURN NUMBER;
  
 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 03, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET CONVERSION COMMODITY GROUP CODE FROM COMMODITY CODE
 #####################################################################*/
  FUNCTION GET_CONV_CMDT_GRP_CD_FNC 
  (
           pi_vndr_seq          NUMBER
      ,    pi_cmdt_cd           VARCHAR2
  ) RETURN VARCHAR2;  

  
/* ===============================================================================================
 *  SUPPLY COA  TO TRS AGREEMENT RATE CALCULATION RESULT
   =============================================================================================== */
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 1, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : BASIC RATE CALCULATION MODULE
 #####################################################################*/   
 PROCEDURE GET_BASIC_RATE_CALCULATION_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* TRS, COA */
          
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
      ,   pi_trsp_so_knd_cd            IN  VARCHAR2    /* NONE US RAIL, USRAIL */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
      ----,   pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */          
          
      ,   pi_agmt_eq_knd              IN  VARCHAR2    /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
      ,   pi_agmt_rt_knd              IN  VARCHAR2    /* P, PD, DP, D */
      ,   pi_agmt_rt_dtl_knd          IN  VARCHAR2    /* P(pair rate), D(Distance rate)      */  
      ,   pi_link_cnt                 IN  NUMBER      /* COUNT OF LINK FORM TRANSPORTATION   */
                                               
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONEWAY or ROUNDTRIP      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER 
            ,       pi_rcv_term                 IN  VARCHAR2    
            ,       pi_de_term                  IN  VARCHAR2
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE      
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE               
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE
      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_local_curr_cd            OUT VARCHAR2
      
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE      
      
      ,   po_basic_rt                 OUT NUMBER
      ,   po_rtn_cd                   OUT NUMBER       
  );   
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 5, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA/TRS
 #####################################################################*/   
PROCEDURE GET_SCG_RATE_CALCULATION_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* TRS, COA */
      ,   pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */          
      ,   pi_scg_knd_indicator        IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
      ,   pi_way_type                 IN  VARCHAR2      
      
      /* KEY - INPUT */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   pi_trsp_agmt_rt_tp          IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER               
         
      /* OUTPUT ADDITIONAL REF. */
      ,   po_scg_union_exp                OUT VARCHAR2
      /* OUTPUT ADDITIONAL REF. */
               
      /* SCG_RT PK - OUTPUT */
      ,   po_scg_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_scg_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_scg_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      ,   po_trsp_scg_cd                  OUT TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE
      ,   po_trsp_agmt_scg_seq            OUT TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE
      /* SCG_RT PK - OUTPUT */
      
      ,   po_local_curr_cd_or_pct         OUT VARCHAR2
      ,   po_scg_rate_or_pct              OUT NUMBER
      ,   po_rtn_cd                       OUT NUMBER  
      ,   po_process_rslt_msg             OUT VARCHAR2            
  ) ;    
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 1, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : BASIC RATE CALCULATION FOR COA/TRS
 #####################################################################*/   
PROCEDURE GET_NONE_USRAIL_BASIC_RATE_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* SYSTEM INDICATOR - COA/TRS      */
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONEWAY or ROUNDTRIP      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER  
            ,       pi_rcv_term                 IN  VARCHAR2    
            ,       pi_de_term                  IN  VARCHAR2
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE          
            
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE      
              
      ,   po_way_type                 OUT VARCHAR2              
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE
      
      ,   po_rtn_cd                   OUT NUMBER  
      ,   po_process_rslt_msg         OUT VARCHAR2        
  );
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 1, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : ALL RATE COMBINATION FOR TRS NONE US RAIL S/O
 #####################################################################*/
  PROCEDURE GET_TRS_ALL_RATE_PRC 
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONEWAY' or 'ROUNDTRIP'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER    
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */
      
      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
                   
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2      
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER        
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  );
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : APRIL 24, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : BASIC RATE CALCULATION FOR COA/TRS US RAIL
 #####################################################################*/   
PROCEDURE GET_USRAIL_BASIC_RATE_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* SYSTEM INDICATOR - COA/TRS      */
          
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
      ----,   pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONEWAY or ROUNDTRIP      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER  
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE          
            
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE      
              
      ,   po_way_type                 OUT VARCHAR2              
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE
      
      ,   po_rtn_cd                   OUT NUMBER  
      ,   po_process_rslt_msg         OUT VARCHAR2        
  );   
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : APRIL 24, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : ALL RATE COMBINATION FOR TRS US RAIL S/O
 #####################################################################*/
  PROCEDURE GET_TRS_USRAIL_ALL_RATE_PRC 
  (
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
          pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
      ----    pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
          
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONEWAY' or 'ROUNDTRIP'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER    
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */
      
      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
                   
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2      
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER        
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  );   
   
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : PARK JUN-YONG
 # -- Created : MARCH 26, 2008
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : SOME RATE COMBINATION FOR TRS US RAIL S/O
 #####################################################################*/   
  PROCEDURE GET_USRAIL_CONV_AGMT_NO_PRC 
  (          
      pi_vndr_seq                     IN  VARCHAR2   
      ,  pi_cmdt_cd                   IN  VARCHAR2    /* OPTIONAL */      
      ,  po_rtn_cd                    OUT NUMBER
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */
  );    
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : PARK JUN-YONG
 # -- Created : MARCH 28, 2008
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : RATE CALCULATION FOR TRS SP SELECT POPUP
 #####################################################################*/
  PROCEDURE GET_TRS_SP_RATE_PRC 
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  VARCHAR2
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONEWAY' or 'ROUNDTRIP'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER    
            ,       pi_rcv_term                 IN  VARCHAR2    
            ,       pi_de_term                  IN  VARCHAR2    
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */
      
      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
                   
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2      
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER        
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  );
   
END TRS_AGMT_RATE_CAL_PKG;


-- DDL Script for PACKAGE BODY TRS_AGMT_RATE_CAL_PKG. Orange for ORACLE.
-- Generated on 2009/07/03 13:10:49 by ENISADM@HJSENIS1

CREATE OR REPLACE PACKAGE BODY TRS_AGMT_RATE_CAL_PKG IS

 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 26, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : Pair type, Distance Type용 Cost Code 조회
 #####################################################################*/
  FUNCTION GET_CST_CD_4_PAIR_DIST_TP_FNC 
  (
           pi_agmt_rate_tp        VARCHAR2   /* P : PAIR, D : DISTANCE */
         , pi_eq_knd_cd            VARCHAR2   /* U : Container, Z : CHassis, G : Genset */
         , pi_cgo_tp_cd           VARCHAR2   /* F : Full, M : EMpty    */
         , pi_eq_tpsz_cd          VARCHAR2   /* D2, R2, F?, ...        */
         , pi_cmb_tp_cd           VARCHAR2   /* BD : Bundle, CF : Combined Case One, FF : Full+Full, FM : Full_Empty */
         , pi_cost_mod_cd         VARCHAR2   /* DR : Door              */
  ) RETURN VARCHAR2
   IS
     
      v_rtn_value TRS_TRSP_AGMT_RT_TP.TRSP_COST_MOD_CD%TYPE := '';
      
  BEGIN  
  
      /****** AGREEMENT PAIR TYPE COST MODE CODE *********
      * DR  DOOR                 : 
      * CY  CY(SINGLE)           : 
      * BS  BARE CHASSIS(STACK)  : 
      * BF  BARE CHASSIS(FLATBED): 
      * MF  EMPTY FLATRACK       : 
      * MM  MATCHMAKING ONE      : 
      ****************************************************/
      IF pi_agmt_rate_tp = 'P' THEN
      
          IF pi_eq_knd_cd = 'U' THEN
              IF pi_cgo_tp_cd = 'F' THEN   
                  IF pi_cost_mod_cd = 'DR' THEN
                      v_rtn_value := 'DR';               /* PAIR + Container + Full + Door                      */
                  ELSE
                      v_rtn_value := 'CY';               /* PAIR + Container + Full + CY                        */
                  END IF;
              ELSIF pi_cgo_tp_cd = 'M' THEN
                  IF pi_cmb_tp_cd = 'CF' THEN
                      v_rtn_value := 'MM';                   /* PAIR + Container + Empty + Matchmaking Case 1.(2M)  */
                  ELSE
                      IF SUBSTR(pi_eq_tpsz_cd,1,1) = 'F' OR SUBSTR(pi_eq_tpsz_cd,1,1) = 'A' OR SUBSTR(pi_eq_tpsz_cd,1,1) = 'P' THEN
                          v_rtn_value := 'MF';               /* PAIR + Container + Empty + EQ Type = 'F'            */
                      ELSE
                          v_rtn_value := 'CY';               /* PAIR + Container + Empty + EQ Type except 'F'       */
                      END IF;
                  END IF;
              END IF;
          ELSIF pi_eq_knd_cd = 'Z' THEN
              v_rtn_value := 'BS';                           /* PAIR + ALL CHassis */
          ELSIF pi_eq_knd_cd = 'G' THEN
              v_rtn_value := 'CY';                           /* PAIR + ALL Genset  */
          END IF;          
      
      /****** AGREEMENT DISTANCE TYPE COST MODE CODE *****      
      * DC  DR or CY(Single)     :
      * BS  Bare CHZ(Stack)      : 
      * BF  Bare CHZ(Flatbed)    : 
      * MF  Empty Flatrack       : 
      * MM  Matchmaking (One)    : 
      ****************************************************/      
      ELSIF pi_agmt_rate_tp = 'D' THEN
      
          IF pi_eq_knd_cd = 'U' THEN
              IF pi_cgo_tp_cd = 'F' THEN
                  v_rtn_value := 'DC';                   /* DISTANCE + Container + Full + Single Trans. CY + Door   */
              ELSIF pi_cgo_tp_cd = 'M' THEN
                  IF pi_cmb_tp_cd = 'CF' THEN
                      v_rtn_value := 'MM';                   /* DISTANCE + Container + Empty + Matchmaking Case 1.(2M)  */
                  ELSE
                      IF SUBSTR(pi_eq_tpsz_cd,1,1) = 'F' OR SUBSTR(pi_eq_tpsz_cd,1,1) = 'A' OR SUBSTR(pi_eq_tpsz_cd,1,1) = 'P' THEN
                          v_rtn_value := 'MF';               /* DISTANCE + Container + Empty + EQ Type = 'F'            */
                      ELSE
                          v_rtn_value := 'DC';               /* DISTANCE + Container + Empty + EQ Type except 'F'       */
                      END IF;
                  END IF;
              END IF;
          ELSIF pi_eq_knd_cd = 'Z' THEN
              v_rtn_value := 'BS';                           /* DISTANCE + ALL CHassis 현재 BF를 구분할수 없음 */
          ELSIF pi_eq_knd_cd = 'G' THEN
              v_rtn_value := 'DC';                           /* DISTANCE + ALL Genset */
          END IF;          
      
      END IF;
      
      RETURN v_rtn_value;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN '';
          DBMS_OUTPUT.PUT_LINE('%%%GET_CST_CD_4_PAIR_DIST_TP_FNC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END;

 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 22, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : 전체 NOD의 링크 갯수 구하기
 #####################################################################*/
  FUNCTION GET_LINK_CNT_FNC 
  (
           pi_from_nod_cd       VARCHAR2
      ,    pi_via_nod_cd        VARCHAR2  
      ,    pi_door_nod_cd       VARCHAR2        
      ,    pi_to_nod_cd         VARCHAR2
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
          DBMS_OUTPUT.PUT_LINE('%%%GET_LINK_CNT_FNC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END;

  /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 16, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM KILOMETER BETWEEN TWO NODES
 #####################################################################*/
  FUNCTION GET_CAL_DIST_2_NOD_FNC 
  (    
          pi_dist_uom          VARCHAR2
      ,   pi_start_nod_cd      VARCHAR2
      ,   pi_end_nod_cd        VARCHAR2    
  ) RETURN NUMBER
  IS
    v_rtn_value NUMBER (15,6) := 0;

  BEGIN  
  
    SELECT  
            MAX(CASE UPPER(SUBSTR(pi_dist_uom,1,1)) WHEN 'K' THEN 
                                                               CASE UPPER(X.DIST_MEAS_UT_CD) WHEN 'KM' THEN X.BZC_DIST
                                                                                             WHEN 'ML' THEN X.CONV_DIST
                                                                                             ELSE 0
                                                               END
                                                 WHEN 'M' THEN 
                                                               CASE UPPER(X.DIST_MEAS_UT_CD) WHEN 'ML' THEN X.BZC_DIST
                                                                                             WHEN 'KM' THEN X.CONV_DIST
                                                                                             ELSE 0
                                                               END                                                 
                                                 ELSE 0
            END)
    INTO    v_rtn_value
    FROM    TRS_AGMT_DIST X
    WHERE   X.FM_NOD_CD   = pi_start_nod_cd
    AND     X.TO_NOD_CD   = pi_end_nod_cd
    ;
    
    IF NVL(v_rtn_value, 0) = 0 THEN
    
      SELECT  
              MAX(CASE UPPER(SUBSTR(pi_dist_uom,1,1)) WHEN 'K' THEN 
                                                                 CASE UPPER(X.DIST_MEAS_UT_CD) WHEN 'KM' THEN X.BZC_DIST
                                                                                               WHEN 'ML' THEN X.CONV_DIST
                                                                                               ELSE 0
                                                                 END
                                                   WHEN 'M' THEN 
                                                                 CASE UPPER(X.DIST_MEAS_UT_CD) WHEN 'ML' THEN X.BZC_DIST
                                                                                               WHEN 'KM' THEN X.CONV_DIST
                                                                                               ELSE 0
                                                                 END                                                 
                                                   ELSE 0
              END)
      INTO    v_rtn_value
      FROM    TRS_AGMT_DIST X
      WHERE   X.FM_NOD_CD   = pi_end_nod_cd
      AND     X.TO_NOD_CD   = pi_start_nod_cd
      ;
    
    END IF;
    
    RETURN v_rtn_value;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN 0;
          DBMS_OUTPUT.PUT_LINE('%%%GET_CAL_DIST_2_NOD_FNC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END;   
  
 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 16, 2007
 # -- Updated : AUG 27, 2009, POONG YEON CHO
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : CALCULATE DISTANCE TO INPUT DISTANCE UOM BETWEEN SEVERAL NODES
 #####################################################################*/
  FUNCTION GET_CAL_DIST_BTWN_NOD_FNC 
  (    
          pi_dist_uom          VARCHAR2
      ,   pi_agmt_rt_tp        VARCHAR2           /* PD, DP, D  except P */
      ,   pi_cost_mod_cd       VARCHAR2           /* DR, Non-DR          */
      ,   pi_bound_cd          VARCHAR2           /* I, O                */
      ,   pi_from_nod_cd       VARCHAR2
      ,   pi_via_nod_cd        VARCHAR2    
      ,   pi_door_nod_cd       VARCHAR2    
      ,   pi_to_nod_cd         VARCHAR2    
  ) RETURN NUMBER
  IS
  
    v_link_cnt  NUMBER(1)     := 0;
    v_rtn_value NUMBER (15,6) := 0;

  BEGIN  
 
    DBMS_OUTPUT.enable;
 
    v_link_cnt := TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);
 
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
          DBMS_OUTPUT.PUT_LINE('%%%GET_CAL_DIST_BTWN_NOD_FNC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END;

 /*###################################################################
 # -- Type    : PROCEDURE 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 03, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : PARAMETER VALIDATION CHECK
 #####################################################################*/
  PROCEDURE GET_PARAM_VALID_CHK_PRC 
  (
          pi_so_kind_indicator        IN  VARCHAR2    /* NONE US RAIL, USRAIL    */
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONE' or 'RND'      */
            ,       pi_eq_knd_cd                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                IN  VARCHAR2
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
            ,       pi_bundle_cnt               IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER   
      
      ,   po_rtn_cd                   OUT NUMBER      /* 0 : SUCCESS */
      ,   po_rtn_msg                  OUT VARCHAR2
  )
  IS
  
  USER_DEFINE_ERROR    EXCEPTION      ;
  
  v_err_cnt            NUMBER(2) := 0 ;
  
  BEGIN  

    DBMS_OUTPUT.enable;
    
    IF pi_so_kind_indicator = 'NONE_USRAIL' THEN
    
        /* CONTROL OFFICE                         */
        
        
        /* VENDOR SEQUENCE                        */
        
        /* WAY TYPE : RND/ONE            */
        IF pi_way_tp_cd != 'ONE' AND pi_way_tp_cd != 'RND' THEN
            po_rtn_cd   := -100;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID WAY TYPE CODE ['||pi_way_tp_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;
        
        /* TRANSPORTATION CARRIOR MODE            */
        IF pi_crr_mod_cd != 'TD' AND pi_crr_mod_cd != 'WD' AND pi_crr_mod_cd != 'RD' AND pi_crr_mod_cd != 'WT' AND pi_crr_mod_cd != 'TW' AND pi_crr_mod_cd != 'RT' AND pi_crr_mod_cd != 'TR' AND pi_crr_mod_cd != 'WR' AND pi_crr_mod_cd != 'RW' THEN
            po_rtn_cd   := -110;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID TRANSPORTATION CARRIOR MODE ['||pi_crr_mod_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;
            
        /* TRANSPORTATION COST MODE               */
        
        /* BOUND CODE                             */
        IF pi_bound_cd != 'I' AND pi_bound_cd != 'O' THEN
            po_rtn_cd   := -130;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID BOUND CODE ['||pi_bound_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;
            
        /* EQ TYPE SIZE                           */
        IF pi_eq_knd_cd != 'U' AND pi_eq_knd_cd != 'Z' AND pi_eq_knd_cd != 'G' THEN
            po_rtn_cd   := -140;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID EQ TYPE ['||pi_eq_knd_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;    
        
        /* CARGO TYPE : F/M                       */
        IF pi_cgo_tp_cd != 'F' AND pi_cgo_tp_cd != 'M' THEN
            po_rtn_cd   := -150;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID CARGO TYPE ['||pi_cgo_tp_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;   
            
        /* NODE 유효성 체크 : 자리수(7), 유효코드 */
        IF LENGTH(pi_from_nod_cd) != 7 AND LENGTH(pi_to_nod_cd) != 7 AND (NVL(LENGTH(pi_via_nod_cd),0) = 0 OR NVL(LENGTH(pi_via_nod_cd),0) = 7) AND (NVL(LENGTH(pi_door_nod_cd),0) = 0 OR NVL(LENGTH(pi_door_nod_cd),0) = 7) THEN
            po_rtn_cd   := -160;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID NODE ['||pi_from_nod_cd||']~['||pi_via_nod_cd||']~['||pi_door_nod_cd||']~['||pi_to_nod_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;
            
        /* CUSTOMER COUNTRY/SEQUENCE              */
        IF NVL(LENGTH(pi_cust_cnt_cd),0) = 0 AND (NVL(LENGTH(pi_cust_seq),0) = 0 OR pi_cust_seq = 0) THEN
            NULL;
        ELSIF NVL(LENGTH(pi_cust_cnt_cd),0) > 0 AND pi_cust_seq > 0 THEN
            NULL;
        ELSE
            po_rtn_cd   := -170;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID CUSTOMER COUNTRY CODE or CUSTOMER SEQUENCE ['||pi_cust_cnt_cd||']+['||pi_cust_seq||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;    
        
        /* COMBINED TYPE                          */
        IF NVL(LENGTH(pi_cmb_tp_cd),0) != 0 AND pi_cmb_tp_cd != 'NR' AND pi_cmb_tp_cd != 'CF' AND pi_cmb_tp_cd != 'FF' AND pi_cmb_tp_cd != 'FM' THEN
            po_rtn_cd   := -180;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID COMBINATION CODE ['||pi_cmb_tp_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;     
        
        /* NUMBER OF BUNDLING (CHASSIS/EMPTY FLATRACK CONTAINER) */
        IF pi_bundle_cnt < 0 THEN
            po_rtn_cd   := -190;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID NUMBER OF BUNDLING ['||pi_bundle_cnt||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;    
        
        /* RAIL SERVICE TYPE                      */
        IF NVL(LENGTH(pi_rail_svc_tp_cd),0) != 0 AND pi_rail_svc_tp_cd != 'CO' AND pi_rail_svc_tp_cd != 'CR' AND pi_rail_svc_tp_cd != 'TO' AND pi_rail_svc_tp_cd != 'TR' THEN
            po_rtn_cd   := -200;
            po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID RAIL SERVICE TYPE CODE ['||pi_rail_svc_tp_cd||']';
            v_err_cnt   := v_err_cnt + 1;
            --RAISE USER_DEFINE_ERROR;
        END IF;    
            
        /* COMMODITY CODE                         */
        
        /* WEIGHT UOM : KG/LBS                    */ 
            
        /* BASIS DATE                             */ 
      
        /* INPUT PARAMETER COMBINATION CHECK START */
        
            /* RAIL SERVICE TYPE + TRNASPORTATION MODE IS ONLY 'RD' -500 */
            IF LENGTH(pi_rail_svc_tp_cd) > 0 THEN
                IF pi_crr_mod_cd != 'RD' THEN
                    po_rtn_cd   := -500;
                    po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID RAIL SERVICE TYPE + TRANS. MODE ['||pi_rail_svc_tp_cd||']+['||pi_crr_mod_cd||']';
                    v_err_cnt   := v_err_cnt + 1;
                    --RAISE USER_DEFINE_ERROR;
                END IF;
            END IF;        
            
            /* EQ TYPE = CONTAINER + WEIGHT UOM/WEIGHT QUANTITY -600 */
            IF pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN   -- EMPTY FLATRACK 제외.
                IF UPPER(pi_wgt_uom) != 'KG' AND UPPER(pi_wgt_uom) != 'KGS' AND UPPER(pi_wgt_uom) != 'LBS' THEN
                    po_rtn_cd   := -601;
                    po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID CONTAINER WEIGHT UOM ['||pi_wgt_uom||']';
                    v_err_cnt   := v_err_cnt + 1;
                    --RAISE USER_DEFINE_ERROR;   
                ELSIF pi_wgt_qty = 0 THEN
                    po_rtn_cd   := -602;
                    po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID CONTAINER WEIGHT QUANTITY ['||pi_wgt_qty||']';
                    v_err_cnt   := v_err_cnt + 1;     
                END IF;
            ELSE    -- CHASSIS/GENSET
                IF NVL(LENGTH(pi_wgt_uom),0) > 0 THEN
                    po_rtn_cd   := -603;
                    po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID CHASSIS/GENSET WEIGHT UOM ['||pi_wgt_uom||']';
                    v_err_cnt   := v_err_cnt + 1;
                    --RAISE USER_DEFINE_ERROR;                
                END IF;
            END IF; 
                    
        /* INPUT PARAMETER COMBINATION CHECK END   */   
        
   ELSIF pi_so_kind_indicator = 'USRAIL' THEN
   
      IF pi_rail_svc_tp_cd != 'CO' AND pi_rail_svc_tp_cd != 'CR' AND pi_rail_svc_tp_cd != 'TO' AND pi_rail_svc_tp_cd != 'TR' THEN
          po_rtn_cd   := -700;
          po_rtn_msg  := po_rtn_msg||' ___ '||'INVALID RAIL SERVICE TYPE + TRANS. MODE ['||pi_rail_svc_tp_cd||']';
          v_err_cnt   := v_err_cnt + 1;
      END IF; 
      
   ELSE
       po_rtn_cd := -1;
       po_rtn_msg:= 'INVALID S/O INDICATOR';   
   END IF; 
  
   IF v_err_cnt > 0 THEN
       RAISE USER_DEFINE_ERROR;
   END IF;
  
    /* INITIAL RETRURN CODE SETTING */
    po_rtn_cd  := 0;
    po_rtn_msg := 'PARAMETER VALIDATION CHECK OKAY!!!';
  
    DBMS_OUTPUT.put_line('INPUT PARAMETER CHECK RESULT CODE = ['||po_rtn_cd||'] ; MESSAGE = ['||po_rtn_msg||']');  
  
  EXCEPTION
      WHEN USER_DEFINE_ERROR THEN
          DBMS_OUTPUT.put_line('%%%GET_PARAM_VALID_CHK_PRC%%% <USER_DEFINE_ERROR> COUNT OF ERROR = ['||v_err_cnt||'], INPUT PARAMETER CHECK RESULT CODE = ['||po_rtn_cd||'] ; MESSAGE = ['||po_rtn_msg||']'); 
      WHEN NO_DATA_FOUND THEN 
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_PARAM_VALID_CHK_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
      WHEN OTHERS THEN
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_PARAM_VALID_CHK_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END;
  
 /*###################################################################
 # -- Type    : FUNCTION 
 # -- Author  : JEONG SANG-KI
 # -- Created : JAN 03, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : GET CONVERSION COMMODITY GROUP CODE FROM COMMODITY CODE
 #####################################################################*/
  FUNCTION GET_CONV_CMDT_GRP_CD_FNC 
  (
           pi_vndr_seq          NUMBER
      ,    pi_cmdt_cd           VARCHAR2
  ) RETURN VARCHAR2
    IS
  
    v_rtn_value TRS_TRSP_CMDT_GRP.TRSP_GRP_CMDT_CD%TYPE := '';

  BEGIN  
  
    SELECT    A.TRSP_GRP_CMDT_CD
    INTO      v_rtn_value
    FROM      TRS_TRSP_CMDT_GRP A
            , TRS_CMDT_GRP_CZ   B 
    WHERE     A.DELT_FLG          = 'N'
    AND       A.DELT_FLG          = B.DELT_FLG
    AND       A.TRSP_GRP_CMDT_CD  = B.TRSP_GRP_CMDT_CD
    AND       A.VNDR_SEQ          = pi_vndr_seq   
    AND       B.CMDT_CD           = pi_cmdt_cd; 
    
    RETURN v_rtn_value;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN '';
          DBMS_OUTPUT.PUT_LINE('%%%GET_CONV_CMDT_GRP_CD_FNC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END;
  
  
/* ===============================================================================================
 *  SUPPLY COA TO TRS AGREEMENT RATE CALCULATION RESULT
   =============================================================================================== */
  
/*###############################################################################################
  # -- Type    : PROCEDURE
  # -- Author  : JEONG SANG-KI
  # -- Created : FEB 1, 2007
  # -- Table   : TRS_TRSP_AGMT_*
  # -- Purpose : BASIC RATE CALCULATION MODULE
  # ----------------------------------------------------------------------------------------------
  # 1. Service Provider's Agreement 유효성 체크
  # 2. Agreement Type(PAIR/DISTANCE)  Data 유효성 체크
  # 3. Node Check : From, Via, Door, To - 2 Nodes | 3 Nodes | 4 Nodes
  #    3.1 (From - To) : In/Out Bound Single Trans. Mode
  #    3.2 (From - Via - To) : In/Out Bound Combined Trans. Mode
  #    3.3 (From - Door - Via - To) : Out Bound Combined Trans. Mode
  #    3.4 (From - Via - Door - To) : In Bound Combined Trans. Mode
  # ----------------------------------------------------------------------------------------------
  # RATE TYPE    : P/PD/DP/D
  # BOUND CODE   : I/O
  # RATE KIND    : PAIR/DISTANCE
  # EQ KIND TYPE : C-ontainer/c-H-assis/G-enset 
  # ####################################################

  AGREEMENT RATE CALCULATION PARAMETERS
  ==========================================================================================================================================================
  01    :   pi_ctrl_ofc_cd              IN  VARCHAR2    - Control Office Code                           - TRS_TRSP_SVC_ORD.CRE_OFC_CD                   
  02    :   pi_vndr_seq                 IN  VARCHAR2        - Service Provicer                                - TRS_TRSP_SVC_ORD.VNDR_SEQ                       
  03    :   pi_basis_dt                 IN  DATE        - Rate Calculation 기준일자                 - TRS_TRSP_SVC_ORD.CRE_DT                       
  04    :   pi_way_tp_cd                IN  VARCHAR2    - 'ONE', 'RND'                      - COA:'ONE', TRS:US RAIL:'ONE','RND', NONE_USRAIL S/O:'ONE'
  05    :   pi_eq_knd_cd                            IN  VARCHAR2        - U:Container, Z:Chassis, G:Genset  - TRS_TRSP_SVC_ORD.EQ_KND_CD                        
  06    :   pi_eq_tp_sz_cd              IN  VARCHAR2        - EQ TYPE SIZE                                      - TRS_TRSP_SVC_ORD.EQ_TPSZ_CD                   
  07    :   pi_cmb_tp_cd                IN  VARCHAR2    - MATCHMAKING TYPE CODE                 - TRS_TRSP_SVC_ORD.TRSP_SO_CMB_TP_CD            
  08    :   pi_cgo_tp_cd                  IN  VARCHAR2    - F:Full, M:Empty                         - TRS_TRSP_SVC_ORD.CGO_TP_CD                    
  09    :   pi_bound_cd                 IN  VARCHAR2    - I:IN BOUND, O:OUT BOUND                   - TRS_TRSP_SVC_ORD.TRSP_BND_CD                  
  10    :   pi_crr_mod_cd               IN  VARCHAR2        - TD,RD,WD,TR,RT,RW,WR,TW,WT                - TRS_TRSP_SVC_ORD.TRSP_CRR_MOD_CD              
  11    :   pi_cost_mod_cd              IN  VARCHAR2    - CY,DOOR,...                                   - TRS_TRSP_SVC_ORD.TRSP_COST_DTL_MOD_CD         
  12    :   pi_cust_cnt_cd              IN  VARCHAR2    - 고객국가코드                                    - TRS_TRSP_SVC_ORD.CUST_CNT_CD                  
  13    :   pi_cust_seq                 IN  NUMBER      - 고객고유번호                                  - TRS_TRSP_SVC_ORD.CUST_SEQ                       
  14    :   pi_rail_svc_tp_cd           IN  VARCHAR2    - ONLY RAIL BILLING ORDE                        - TRS_TRSP_RAIL_ORD.RAIL_SVC_TP_CD
  15    :   pi_cmdt_cd                  IN  VARCHAR2    - COMMODITY CODE                                    - TRS_TRSP_SVC_ORD.CMDT_CD                      
  16    :   pi_from_nod_cd              IN  VARCHAR2        - FROM NODE                                         - TRS_TRSP_SVC_ORD.FM_NOD_CD                    
  17    :   pi_via_nod_cd               IN  VARCHAR2    - VIA NODE                                          - TRS_TRSP_SVC_ORD.VIA_NOD_CD                   
  18    :   pi_door_nod_cd              IN  VARCHAR2    - DOOR NODE                                         - TRS_TRSP_SVC_ORD.DOR_NOD_CD                   
  19    :   pi_to_nod_cd                IN  VARCHAR2    - TO NODE                                             - TRS_TRSP_SVC_ORD.TO_NOD_CD                  
  20    :   pi_bundle_no                        IN  NUMBER      - BUNDLING NUMBER OF CHASSIS/Empty Flatrack     - Bundling된 Chassis/MT Flatrack수(계산해야함) 
  21    :   pi_wgt_uom                  IN  VARCHAR2    - L-LBS, K-KG[S]                                    - TRS_TRSP_SVC_ORD.WGT_MEAS_UT_CD               
  22    :   pi_wgt_qty                  IN  NUMBER          - CARGO 중량                                        - TRS_TRSP_SVC_ORD.CNTR_WGT                       
  ==========================================================================================================================================================
  #
  #####################################################################*/
  PROCEDURE GET_BASIC_RATE_CALCULATION_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* TRS, COA */
          
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
      ,   pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE_USRAIL, USRAIL */          
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
      ----,   pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */          
          
      ,   pi_agmt_eq_knd              IN  VARCHAR2    /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
      ,   pi_agmt_rt_knd              IN  VARCHAR2    /* P, PD, DP, D */
      ,   pi_agmt_rt_dtl_knd          IN  VARCHAR2    /* P(pair rate), D(Distance rate)      */  
      ,   pi_link_cnt                 IN  NUMBER      /* COUNT OF LINK FORM TRANSPORTATION   */
                                               
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONE or RND      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER 
            ,       pi_rcv_term                 IN  VARCHAR2    
            ,       pi_de_term                  IN  VARCHAR2  
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE          
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE
      ,   po_way_type                 OUT VARCHAR2
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE      
      ,   po_basic_rt                 OUT NUMBER
      ,   po_rtn_cd                   OUT NUMBER       
  )
  IS
  
  c_way_type_priority                 VARCHAR2(15)    := 'RND_PRIORITY'                  ;
  
  v_trsp_agmt_ofc_cty_cd              TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  v_trsp_agmt_seq                     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  v_trsp_agmt_rt_tp_ser_no            TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;
  
  v_vndr_seq                          TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE              ;
  v_cust_nomi_trkr_flg                TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE        ;
  v_cust_cnt_cd                       TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  v_cust_seq                          TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;
  v_trsp_agmt_rt_tp_cd                TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE        ;
  
  v_way_type                          VARCHAR2(3)                                        ;
  v_local_curr_cd                     VARCHAR2(3)                                        ;
  v_container_rate                    NUMBER(18,3)                                       ;
  v_chassis_mtflatrack_rate           NUMBER(18,3)                                       ;
  v_genset_rate                       NUMBER(18,3)                                       ;   
  
  v_wtr_rcv_term_cd                   TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE            ;
  v_wtr_de_term_cd                    TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE             ;   
  

  C_CONV_KG_FROM_LBS                  CONSTANT NUMBER(10,6)                  := 0.453599 ;          
  
  BEGIN
  
     /* P --> OK  -->                Success
        P --> N/A --> D --> OK  -->  Success 
        P --> N/A --> D --> N/A -->  Error
     */  
     
     /* P --> OK  -->                                                                   Success
        P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success
        P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> N/A -->                     Error       
        P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> OK -->  Success    
        P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> N/A --> Error              
        P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> OK -->            Success                      
        P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> N/A -->           Error        
     */
     
     /* RATE CALCULATION PRIORITY - 2007.03.13 BY CHOI YOUNG-HA
     * 1. ROUTE     (7>5)
     * 2. EQ        (SAME, AL**, **AL, ALAL) TYPE+SIZE, AL** = TYPE ALL, **AL = SIZE ALL 
     * 3. CMDT_GRP  (SAME, NULL)
     * 4. CRE_DT    (LAST, MIN(TO_WGT))
     */
     
     /****************************************************************** 
     * RATE CALCULATION PRIORITY - WAYTYPE('ONE','RND')
     *  COA 
     *  1.  DOOR TERM     : 'RND' >> 'ONE'
     *  2.  YARD TERM     : 'ONE' >> 'RND'
     ___________________________________________________________________
     ___________________________________________________________________
     *
     *  TRS 
     *  --- << US RAIL >> ----------------------------------------------
     *  1-1.  'CO'+'TO'     : 'ONE'
     *  1-2.  'CR'+'TR'     : 'RND'  
     *  --- << except US RAIL >> *--------------------------------------
     *  2-1.  COMBINED CASE : 'RND' >> 'ONE'  << 'BD' 'CF' 'FF' 'FM'
     *  2-2.  DOOR TERM     : 'RND' >> 'ONE'
     *  2-3.  YARD TERM     : 'ONE' >> 'RND'
     *******************************************************************/
     
  /* OUTPUT RETRUN CODE ZERO SETTING (SUCCESS) */
  po_rtn_cd := 0;
       
  /* All Container except Empty Flatrack */
  IF pi_agmt_eq_knd = 'U' THEN
     
     IF pi_agmt_rt_knd = 'P' THEN        /* Container + P */
     
          SELECT    TRSP_AGMT_OFC_CTY_CD  , TRSP_AGMT_SEQ  , TRSP_AGMT_RT_TP_SER_NO  , LOCAL_CURR_CD  , CONTAINER_RATE  , WAY_TYPE  , VNDR_SEQ  , CUST_NOMI_TRKR_FLG  , CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_local_curr_cd, v_container_rate, v_way_type, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd
          FROM      (
          
                    --select  * from (
          
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              
                          , AA.EFF_TO_DT              
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT
                            
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER

                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                 WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                 ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                            END  CONTAINER_RATE                                                        
                              
                          , C.TRSP_AGMT_PAIR_SEQ  
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                      
                      /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'P'
                    AND     B.EQ_KND_CD                  = 'U'
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd
                    ----AND     B.TRSP_COST_MOD_CD              = TRS_AGMT_RATE_CAL_PKG.GET_CST_CD_4_PAIR_DIST_TP_FNC('P', B.EQ_KND_CD, B.CGO_TP_CD, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cost_mod_cd)
                    
                    /* RATE TYPE : PAIR */
                    /* EQ TYPE
                        A : ADJUSTABLE FLATRACK
                        F : FLAT RACK CONTAINER
                        P : PLATFORM CNTR
                    */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END                    
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND    NVL(C.VIA_NOD_CD, 'N/A')          = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                 WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                 WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                 ELSE '' 
                                                                END  
                    AND    NVL(C.DOR_NOD_CD, 'N/A')          = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                 WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                 WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                 ELSE '' 
                                                               END  
                    AND    C.TO_NOD_CD                       = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         
  
                    AND     AA.EFF_FM_DT                    <= pi_basis_dt
                    AND     AA.EFF_TO_DT                    >= pi_basis_dt
  
                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END
                      
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')
                                                          
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    ----AND     (B.CMDT_GRP_CD                  = TRS_AGMT_RATE_CAL_PKG.GET_CONV_CMDT_GRP_CD_FNC(A.VNDR_SEQ, pi_cmdt_cd)
                    ----         OR
                    ----         B.CMDT_GRP_CD                  IS NULL
                    ----        ) 
                            
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            )                             
                            
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                    
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */  
                                      
                    --)
                    
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC                             
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             
                             , CC.TO_WGT                          ASC
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC
                    
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    --ORDER BY   LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                    --         , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                    --         , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                    --         , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             ----, EQ_TPSZ_PRIOR_ORDER                ASC                              
                    --         , B.CMDT_GRP_CD                      ASC
                    --         , AA.TRSP_AGMT_EQ_SEQ                DESC
                             --, AA.CRE_DT                          DESC
                             --, CC.TO_WGT                          ASC
                      )
          WHERE   ROWNUM < 2                           
          ;            
                      
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Container + PD */ -- Pair Rate 
     
          SELECT    TRSP_AGMT_OFC_CTY_CD  , TRSP_AGMT_SEQ  , TRSP_AGMT_RT_TP_SER_NO  , LOCAL_CURR_CD  , CONTAINER_RATE  , WAY_TYPE  , VNDR_SEQ  , CUST_NOMI_TRKR_FLG  , CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_local_curr_cd, v_container_rate, v_way_type, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT   

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                      
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                 WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                 ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                            END  CONTAINER_RATE                                                        
                                                    
                          , C.TRSP_AGMT_PAIR_SEQ   
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                          
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'
                    AND     B.EQ_KND_CD                  = 'U'
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND     NVL(C.VIA_NOD_CD, 'N/A')         = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                 WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                 WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                 ELSE '' 
                                                               END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')         = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     IS NULL
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                             
                      
                    /* ROUTE CHECK LOGIC END */
  
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt
  
                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END
  
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')

                                                          
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                            
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                            
                            
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */ 
                                                                    
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             
                             , CC.TO_WGT                          ASC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC                            
                      )
          WHERE   ROWNUM < 2                   
          ;
                                              
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Container + PD */-- Distance Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CONTAINER_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ,   TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_container_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT  
                          
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                           WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(CC.TRSP_AGMT_WGT_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, NVL(CC.TRSP_AGMT_WGT_RT    , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , NVL(CC.TRSP_AGMT_RND_WGT_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CONTAINER_RATE                              
                              
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'U'           /* ONLY CONTAINER RATE             */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd
                    ----AND     B.TRSP_COST_MOD_CD              = TRS_AGMT_RATE_CAL_PKG.GET_CST_CD_4_PAIR_DIST_TP_FNC('D', B.EQ_KND_CD, B.CGO_TP_CD, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cost_mod_cd)
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */

                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                      /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END
                                              
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')

                                                                                 
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                             
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                                              
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                             
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , CC.TO_WGT                    ASC 
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC                            
                    )
          WHERE   ROWNUM < 2                                          
          ;
    
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Container + DP */-- Pair Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD  , TRSP_AGMT_SEQ  , TRSP_AGMT_RT_TP_SER_NO  , LOCAL_CURR_CD  , CONTAINER_RATE  , WAY_TYPE  , VNDR_SEQ  , CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ    , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_local_curr_cd, v_container_rate, v_way_type, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT    
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                 WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                 ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                            END  CONTAINER_RATE  
                                                              
                          , C.TRSP_AGMT_PAIR_SEQ 
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                           
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'
                    AND     B.EQ_KND_CD                  = 'U'
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                                                                                                  
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       IS NULL
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')

                                                          
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                            
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            

                            
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */ 
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */     
                                                
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             
                             , CC.TO_WGT                          ASC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC                            
                    )
          WHERE   ROWNUM < 2
          ;                                                            
 
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Container + DP */-- Distance Rate    

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CONTAINER_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_container_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT 

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                           WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(CC.TRSP_AGMT_WGT_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, NVL(CC.TRSP_AGMT_WGT_RT    , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , NVL(CC.TRSP_AGMT_RND_WGT_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CONTAINER_RATE
                            
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ                          
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'U'           /* ONLY CONTAINER RATE             */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                      /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END
                                                                                       
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')

                                                                                 
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                            
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                             
                            
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                           
                                                
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , CC.TO_WGT                    ASC 
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC                             
                    )
          WHERE   ROWNUM < 2  
          ;                     
     
     ELSIF pi_agmt_rt_knd = 'D' THEN /* Container + D */

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CONTAINER_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_container_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , CC.WGT_MEAS_UT_CD
                          , CC.TO_WGT  
                                
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN CC.TRSP_AGMT_WGT_RT 
                                           WHEN v_way_type = 'RND'                                             THEN CC.TRSP_AGMT_RND_WGT_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, CC.TRSP_AGMT_WGT_RT)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , CC.TRSP_AGMT_RND_WGT_RT) 
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(CC.TRSP_AGMT_WGT_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(CC.TRSP_AGMT_RND_WGT_RT, NVL(CC.TRSP_AGMT_WGT_RT    , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(CC.TRSP_AGMT_WGT_RT    , NVL(CC.TRSP_AGMT_RND_WGT_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CONTAINER_RATE
                            
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_WGT_RT            CC
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG                              
                    AND     A.DELT_FLG                      = CC.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ                          
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = CC.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = CC.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = CC.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = CC.TRSP_AGMT_EQ_SEQ                          
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'D'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'U'
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     = pi_cgo_tp_cd
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                      /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* ONLY CONTAINER-WEIGHT */
                    AND     CASE WHEN SUBSTR(NVL(CC.WGT_MEAS_UT_CD, 'KGS'),1,1) = 'K' THEN CC.TO_WGT
                                 ELSE ROUND(CC.TO_WGT * C_CONV_KG_FROM_LBS, 3)
                            END
                                                            >= CASE WHEN SUBSTR(NVL(pi_wgt_uom, 'KGS'),1,1) = 'K' THEN pi_wgt_qty
                                                                    ELSE ROUND(pi_wgt_qty * C_CONV_KG_FROM_LBS, 3)
                                                               END
                                                                                       
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')

                                                                                 
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                     
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                      
                                     
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                                    
                                                
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , CC.TO_WGT                    ASC
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , CC.TRSP_AGMT_WGT_SEQ               DESC                            
                    )
          WHERE   ROWNUM < 2 
          ;                       
     
     ELSE
         po_rtn_cd := -1;
     END IF;
     
     /* OUTPUT PARAMETER SETTING FOR CONTAINER START */
     --po_local_curr_cd  := v_local_curr_cd      ;
     po_basic_rt       := v_container_rate     ;
     
     ----DBMS_OUTPUT.PUT_LINE('BAISC =========='||v_container_rate);
     /* OUTPUT PARAMETER SETTING FOR CONTAINER END */
     

  /* All Chassis  Empty Flatrack Container */
  ELSIF pi_agmt_eq_knd = 'Z' THEN
  
     IF pi_agmt_rt_knd = 'P' THEN           /* Chassis  Empty Flatrack Container + P */

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd                  
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY  
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                 WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                 ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                            END  CHASSIS_MTFLATRACK_RATE                            
                            
                          , C.TRSP_AGMT_PAIR_SEQ
                          , BB.TRSP_AGMT_BDL_SEQ     
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                        
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ                          
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'P'
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         

                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    
                    
                           
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            )                          
                                                      
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)     = NVL(pi_bundle_cnt, 1)
                    
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                     
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                  
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */ 
                                                                  
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC 
                             
                             , BB.TRSP_AGMT_BDL_SEQ               DESC                            
                                                       
                    )
          WHERE   ROWNUM < 2
          ;
     
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Chassis  Empty Flatrack Container + PD */      -- Pair Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd                  
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                 WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                 ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                            END  CHASSIS_MTFLATRACK_RATE   
                            
                          , C.TRSP_AGMT_PAIR_SEQ
                          , BB.TRSP_AGMT_BDL_SEQ    
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                        
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ                          
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                      --==============================================================================================================================                            
                      /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                      --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     IS NULL
                      --==============================================================================================================================
                      /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                      --==============================================================================================================================                                                         

                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    

                           
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            )                          
                                                    
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)            = NVL(pi_bundle_cnt, 1)
                    
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                     
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                   
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */ 
                                              
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                             
                             , BB.TRSP_AGMT_BDL_SEQ               DESC
                    )
          WHERE   ROWNUM < 2
          ;
    
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Chassis  Empty Flatrack Container + PD */      -- Distance Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                    
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY   
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                   
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                           WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(BB.TRSP_AGMT_BDL_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, NVL(BB.TRSP_AGMT_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT    , NVL(BB.TRSP_AGMT_RND_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CHASSIS_MTFLATRACK_RATE                                                                               
                            
                          , D.TRSP_DIST_TP_CD                             
                          , BB.TRSP_AGMT_BDL_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ    
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ
                                                                      
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)                          
                          
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    

                           
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            )                           
                                                                                 
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)            = NVL(pi_bundle_cnt, 1) 
                    
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                     
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                   
                             
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC    
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , BB.TRSP_AGMT_BDL_SEQ               DESC                         
                    )
          WHERE   ROWNUM < 2
          ;
      
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Chassis  Empty Flatrack Container + DP */      -- Pair Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd                  
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                 WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                 ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                            END  CHASSIS_MTFLATRACK_RATE 
           
                          , C.TRSP_AGMT_PAIR_SEQ
                          , BB.TRSP_AGMT_BDL_SEQ    
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                         
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ                          
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       IS NULL
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         

                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    

                                                          
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)            = NVL(pi_bundle_cnt, 1)
                                      
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                            
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                             
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */    
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */ 
                                                                                                
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                             
                             , BB.TRSP_AGMT_BDL_SEQ               DESC
                    )
          WHERE   ROWNUM < 2
          ;
    
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Chassis  Empty Flatrack Container + DP */      -- Distance Rate    

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                    
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY            
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                           WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(BB.TRSP_AGMT_BDL_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, NVL(BB.TRSP_AGMT_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT    , NVL(BB.TRSP_AGMT_RND_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CHASSIS_MTFLATRACK_RATE       
                          
                          , D.TRSP_DIST_TP_CD                             
                          , BB.TRSP_AGMT_BDL_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ
                                                
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                      
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    

                                  
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                                                                                             
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)            = NVL(pi_bundle_cnt, 1) 
                    
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                     
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                   
                                                
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC 
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , BB.TRSP_AGMT_BDL_SEQ               DESC
                    )
          WHERE   ROWNUM < 2
          ;     

     ELSIF pi_agmt_rt_knd = 'D' THEN        /* Chassis  Empty Flatrack Container + D */           

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, CHASSIS_MTFLATRACK_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_chassis_mtflatrack_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                    
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ
                          , BB.TRSP_AGMT_BDL_QTY       
                                    
                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN BB.TRSP_AGMT_BDL_RT 
                                           WHEN v_way_type = 'RND'                                             THEN BB.TRSP_AGMT_RND_BDL_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, BB.TRSP_AGMT_BDL_RT)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT, BB.TRSP_AGMT_RND_BDL_RT)  
                                      END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                        CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(BB.TRSP_AGMT_BDL_RT    , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(BB.TRSP_AGMT_RND_BDL_RT, NVL(BB.TRSP_AGMT_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(BB.TRSP_AGMT_BDL_RT    , NVL(BB.TRSP_AGMT_RND_BDL_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                      END
                            END CHASSIS_MTFLATRACK_RATE       
                          
                          , D.TRSP_DIST_TP_CD                             
                          , BB.TRSP_AGMT_BDL_SEQ 
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                          , TRS_TRSP_AGMT_BDL_RT            BB
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.DELT_FLG                      = BB.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ
                    AND     AA.TRSP_AGMT_OFC_CTY_CD         = BB.TRSP_AGMT_OFC_CTY_CD
                    AND     AA.TRSP_AGMT_SEQ                = BB.TRSP_AGMT_SEQ
                    AND     AA.TRSP_AGMT_RT_TP_SER_NO       = BB.TRSP_AGMT_RT_TP_SER_NO
                    AND     AA.TRSP_AGMT_EQ_SEQ             = BB.TRSP_AGMT_EQ_SEQ    
                                            
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'D'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = pi_eq_knd_cd     /* CHassis + Empty Flatrack Container */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     NVL(B.CGO_TP_CD,'N/A')          = DECODE(pi_eq_knd_cd,'Z','N/A','M')
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                      
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,1,1), 3,SUBSTR(pi_eq_tp_sz_cd,1,2) )||'AL', 'AL'||DECODE( LENGTH(pi_eq_tp_sz_cd), 2,SUBSTR(pi_eq_tp_sz_cd,2,1), 3,SUBSTR(pi_eq_tp_sz_cd,3,1) ), 'ALAL')                    

                                                                                 
                    /* ONLY Chassis + Empty Flatrack Container */
                    AND     NVL(BB.TRSP_AGMT_BDL_QTY,1)            = NVL(pi_bundle_cnt, 1) 
                                   
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                                  
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                                   
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                                                  
                                                                            
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                             , BB.TRSP_AGMT_BDL_SEQ               DESC
                    )
          WHERE   ROWNUM < 2
          ;
     
     ELSE
         po_rtn_cd := -1;
     END IF;
     
     /* OUTPUT PARAMETER SETTING FOR CHASSIS  EMPTY FLATRACK CONTAINER START */
     --po_local_curr_cd  := v_local_curr_cd      ;
     po_basic_rt       := v_chassis_mtflatrack_rate     ;
     /* OUTPUT PARAMETER SETTING FOR CHASSIS  EMPTY FLATRACK CONTAINER END */
          
     
  /* All Genset */
  ELSIF pi_agmt_eq_knd = 'G' THEN
  
     IF pi_agmt_rt_knd = 'P' THEN            /* Genset + P */

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_trsp_agmt_rt_tp_cd, v_cust_cnt_cd, v_cust_seq, v_wtr_rcv_term_cd, v_wtr_de_term_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                          
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                 WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                 ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                            END  GENSET_RATE
        
                          , C.TRSP_AGMT_PAIR_SEQ 
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                            
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                                                    
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'P'
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')
                                  
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                              
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                               
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */   
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */               
                                                                            
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC                            
                    )
          WHERE   ROWNUM < 2
          ;
     
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Genset + PD */      -- Pair Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_trsp_agmt_rt_tp_cd, v_cust_cnt_cd, v_cust_seq, v_wtr_rcv_term_cd, v_wtr_de_term_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                 WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                 ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                            END  GENSET_RATE 
        
                          , C.TRSP_AGMT_PAIR_SEQ 
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                            
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                                                  
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       = DECODE(LENGTH(C.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     IS NULL
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')

                                     
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                               
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */       
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */                
                                                                            
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                    )
          WHERE   ROWNUM < 2      
          ;
     
     ELSIF pi_agmt_rt_knd = 'PD' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Genset + PD */      -- Distance Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                             
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                           WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                                       END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(AA.TRSP_ONE_WY_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(AA.TRSP_RND_RT   , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , NVL(AA.TRSP_ONE_WY_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, NVL(AA.TRSP_RND_RT   , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                       END
                            END GENSET_RATE                                             
                                             
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ                         
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'PD'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                      /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                      /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')

                               
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                               
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                               
                                                                            
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                    )
          WHERE   ROWNUM < 2         
          ;
     
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'P' THEN    /* Genset + DP */      -- Pair Rate

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD, WTR_RCV_TERM_CD, WTR_DE_TERM_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd, v_wtr_rcv_term_cd, v_wtr_de_term_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , C.FM_NOD_CD
                          , C.VIA_NOD_CD
                          , C.DOR_NOD_CD
                          , C.TO_NOD_CD
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                 WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                 ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                            END  GENSET_RATE 

                          , C.TRSP_AGMT_PAIR_SEQ
                          , C.WTR_RCV_TERM_CD
                          , C.WTR_DE_TERM_CD                                                             
                    FROM    TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_PAIR              C
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = C.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = C.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = C.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = C.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     C.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     C.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     C.TRSP_AGMT_PAIR_SEQ            = AA.TRSP_AGMT_PAIR_SEQ                          
                     
                      
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL

                    /* RATE TYPE : PAIR */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(pi_cost_mod_cd, 'DR', 'DR', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'CY'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'CY'
                                                                   ELSE ''
                                                              END
                                                              
                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                    
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* ROUTE CHECK LOGIC START  - LINK CNT 미리계산해서 변수에 대입시킨다. */
                      
                    /* FOR FROM NODE CODE : DP - Pair Rate FROM NODE CODE IS NULL */
                    --==============================================================================================================================                            
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 STARTING */
                    --==============================================================================================================================
                    AND    C.FM_NOD_CD                       IS NULL
                    AND     NVL(C.VIA_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN 'N/A'    
                                                                                                                 ELSE DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))    
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.VIA_NOD_CD), 7, pi_via_nod_cd, 5, SUBSTR(pi_via_nod_cd,1,5))   
                                                                                  ELSE '' 
                                                                END  
                    AND     NVL(C.DOR_NOD_CD, 'N/A')        = CASE pi_link_cnt  WHEN 1 THEN 'N/A' 
                                                                                  WHEN 2 THEN
                                                                                             CASE pi_cost_mod_cd WHEN 'DR' THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                                                 ELSE 'N/A'                  
                                                                                             END
                                                                                  WHEN 3 THEN DECODE(LENGTH(C.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5))
                                                                                  ELSE '' 
                                                                END  
                    AND     C.TO_NOD_CD                     = DECODE(LENGTH(C.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd,1,5))
                    --==============================================================================================================================
                    /* APPENDING ROUTE FIND LOGIC : 2007/02/16 FINISHED */
                    --==============================================================================================================================                                                         
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt
                          
                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')

                                           
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                        
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                         
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */    
                    
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN C.WTR_RCV_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_rcv_term IS NOT NULL THEN pi_rcv_term
                               ELSE '1'
                          END 
                        
                    AND CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN C.WTR_DE_TERM_CD
                             ELSE '1'
                        END 
                        = CASE WHEN  pi_crr_mod_cd IN ('WD', 'WT', 'TW', 'WR', 'RW') AND pi_de_term IS NOT NULL THEN pi_de_term
                               ELSE '1'
                          END
                    /* FEEDER TERM 변경에 따른 추가 - 2008/03/31                  */                      
                                                                            
                    /* PAIR ___ 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER                ASC
                             , B.CMDT_GRP_CD                      ASC                             
                             , LENGTH(NVL(C.FM_NOD_CD ,'N/A'))    DESC   
                             , LENGTH(NVL(C.VIA_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.DOR_NOD_CD,'N/A'))    DESC
                             , LENGTH(NVL(C.TO_NOD_CD ,'N/A'))    DESC 
                             , AA.TRSP_AGMT_EQ_SEQ                DESC
                    )
          WHERE   ROWNUM < 2                              
          ;
     
     ELSIF pi_agmt_rt_knd = 'DP' AND pi_agmt_rt_dtl_knd = 'D' THEN    /* Genset + DP */      -- Distance Rate    

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                           WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                                       END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(AA.TRSP_ONE_WY_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(AA.TRSP_RND_RT   , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , NVL(AA.TRSP_ONE_WY_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, NVL(AA.TRSP_RND_RT   , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                       END
                            END GENSET_RATE       
                                       
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ                         
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'DP'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')

                                        
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 
                                  
                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                                   
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                                  
                                                                            
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                    )
          WHERE   ROWNUM < 2                       
          ;
     
     ELSIF pi_agmt_rt_knd = 'D' THEN         /* Genset + D */                 

          SELECT    TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, WAY_TYPE, LOCAL_CURR_CD, GENSET_RATE, VNDR_SEQ, CUST_NOMI_TRKR_FLG, CUST_CNT_CD  , CUST_SEQ  , TRSP_AGMT_RT_TP_CD
          INTO      v_trsp_agmt_ofc_cty_cd, v_trsp_agmt_seq, v_trsp_agmt_rt_tp_ser_no, v_way_type, v_local_curr_cd, v_genset_rate, v_vndr_seq, v_cust_nomi_trkr_flg, v_cust_cnt_cd, v_cust_seq, v_trsp_agmt_rt_tp_cd                                       
          FROM      (
                    SELECT
                            B.TRSP_AGMT_OFC_CTY_CD
                          , B.TRSP_AGMT_SEQ 
                          , B.TRSP_AGMT_RT_TP_SER_NO                                                                                   
                          , A.VNDR_SEQ
                          , AA.EFF_FM_DT              /* MAX(AA.CRE_DT) */
                          , AA.EFF_TO_DT              /* MAX(AA.CRE_DT) */
                          , B.TRSP_AGMT_RT_TP_CD 
                          , B.EQ_KND_CD  
                          , AA.AGMT_TPSZ_STS_CD     EQ_TP_SZ_CD                                
                          , B.CGO_TP_CD
                          , B.AGMT_TRSP_TP_CD       TRSP_CRR_MOD_CD
                          , B.TRSP_COST_MOD_CD
                          , B.RAIL_SVC_TP_CD    
                          , B.CMDT_GRP_CD                                                            
                          , B.CUST_NOMI_TRKR_FLG
                          , B.CUST_CNT_CD
                          , B.CUST_SEQ
                          , AA.TRSP_AGMT_EQ_SEQ

                          , CASE WHEN AA.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN AA.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN AA.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                                
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN 'ONE'
                                 WHEN v_way_type = 'RND'                                             THEN 'RND'
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL2(AA.RND_CURR_CD   , 'RND', 'ONE') 
                                 ELSE                                                                     NVL2(AA.ONE_WY_CURR_CD, 'ONE', 'RND')
                            END  WAY_TYPE
                            
                          , CASE 
                                 WHEN v_way_type = 'ONE'                                             THEN AA.ONE_WY_CURR_CD
                                 WHEN v_way_type = 'RND'                                             THEN AA.RND_CURR_CD
                                 WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.RND_CURR_CD   , AA.ONE_WY_CURR_CD)
                                 ELSE                                                                     NVL(AA.ONE_WY_CURR_CD, AA.RND_CURR_CD)
                            END  LOCAL_CURR_CD
                                              
                          , CASE WHEN D.TRSP_DIST_TP_CD = 'F' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN AA.TRSP_ONE_WY_RT
                                           WHEN v_way_type = 'RND'                                             THEN AA.TRSP_RND_RT
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , AA.TRSP_ONE_WY_RT)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, AA.TRSP_RND_RT)  
                                       END 
                                   WHEN D.TRSP_DIST_TP_CD = 'P' THEN  
                                       CASE 
                                           WHEN v_way_type = 'ONE'                                             THEN NVL(AA.TRSP_ONE_WY_RT, 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           WHEN v_way_type = 'RND'                                             THEN NVL(AA.TRSP_RND_RT   , 0)*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd) 
                                           WHEN v_way_type = c_way_type_priority OR pi_cost_mod_cd = 'DR'      THEN NVL(AA.TRSP_RND_RT   , NVL(AA.TRSP_ONE_WY_RT, 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                           ELSE                                                                     NVL(AA.TRSP_ONE_WY_RT, NVL(AA.TRSP_RND_RT   , 0))*TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)
                                       END
                            END GENSET_RATE       
                                       
                          , D.TRSP_DIST_TP_CD                             
                          , D.TRSP_AGMT_DIST_SEQ
                    FROM    TRS_TRSP_AGMT_HDR               H
                          , TRS_TRSP_AGMT_APLY_VNDR         A
                          , TRS_TRSP_AGMT_RT_TP             B
                          , TRS_TRSP_AGMT_DIST              D
                          , TRS_TRSP_AGMT_EQ_RT             AA
                    WHERE   A.DELT_FLG                      = 'N'
                    AND     A.DELT_FLG                      = B.DELT_FLG
                    AND     B.DELT_FLG                      = D.DELT_FLG
                    AND     A.DELT_FLG                      = H.DELT_FLG
                    AND     A.DELT_FLG                      = AA.DELT_FLG
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = H.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = H.TRSP_AGMT_SEQ
                    AND     A.TRSP_AGMT_OFC_CTY_CD          = B.TRSP_AGMT_OFC_CTY_CD
                    AND     A.TRSP_AGMT_SEQ                 = B.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_OFC_CTY_CD          = D.TRSP_AGMT_OFC_CTY_CD
                    AND     B.TRSP_AGMT_SEQ                 = D.TRSP_AGMT_SEQ
                    AND     B.TRSP_AGMT_RT_TP_SER_NO        = D.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_OFC_CTY_CD          = AA.TRSP_AGMT_OFC_CTY_CD
                    AND     D.TRSP_AGMT_SEQ                 = AA.TRSP_AGMT_SEQ
                    AND     D.TRSP_AGMT_RT_TP_SER_NO        = AA.TRSP_AGMT_RT_TP_SER_NO
                    AND     D.TRSP_AGMT_DIST_SEQ            = AA.TRSP_AGMT_DIST_SEQ                          
                    AND     H.CTRT_OFC_CD                   = pi_ctrl_ofc_cd                          
                    /* PAIR TYPE에 대한 RATE 구하기 */
                    AND     B.TRSP_AGMT_RT_TP_CD            = 'D'          /* AGREEMENT RATE TYPE : PD, DP, D */
                    AND     B.EQ_KND_CD                  = 'G'         /* All Genset */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ) 
                                                            = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                    AND     B.CGO_TP_CD                     IS NULL
                    
                    /* RATE TYPE : DISTANCE */
                    AND     B.TRSP_COST_MOD_CD              = CASE WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'F' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', 'DC')
                                                                   WHEN pi_eq_knd_cd = 'U' AND pi_cgo_tp_cd = 'M' THEN DECODE(pi_cmb_tp_cd  , 'CF', 'MM', DECODE(SUBSTR(pi_eq_tp_sz_cd,1,1), 'F', 'MF', 'A', 'MF', 'P', 'MF', 'DC'))
                                                                   WHEN pi_eq_knd_cd = 'Z'                        THEN 'BS'
                                                                   WHEN pi_eq_knd_cd = 'G'                        THEN 'DC'
                                                                   ELSE ''
                                                              END

                    AND     B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                    AND     NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                      
                    AND     NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                    AND     NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                    AND     NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    
                                   
                    /* SAME VENDOR + SAME CONTROL OFFICE + DISTANCE TYPE  One of the Two (PER, FIX) */
                      
                    AND     AA.EFF_FM_DT                   <= pi_basis_dt
                    AND     AA.EFF_TO_DT                   >= pi_basis_dt

                    /* ONLY CONTAINER */
                    AND     D.TO_DIST                      >= TRS_AGMT_RATE_CAL_PKG.GET_CAL_DIST_BTWN_NOD_FNC(D.DIST_MEAS_UT_CD, B.TRSP_AGMT_RT_TP_CD, pi_cost_mod_cd, pi_bound_cd, pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd)

                    /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                    AND    AA.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, 'ALAL')

                                    
                    /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                    AND     (B.CMDT_GRP_CD                  = ( SELECT    X.TRSP_GRP_CMDT_CD
                                                                FROM      TRS_TRSP_CMDT_GRP X
                                                                        , TRS_CMDT_GRP_CZ   Y
                                                                WHERE     X.DELT_FLG          = 'N'
                                                                AND       X.DELT_FLG          = Y.DELT_FLG
                                                                AND       X.TRSP_GRP_CMDT_CD  = Y.TRSP_GRP_CMDT_CD
                                                                AND       X.VNDR_SEQ          = pi_vndr_seq   
                                                                AND       Y.CMDT_CD           = pi_cmdt_cd                                                                         
                                                              )
                             OR
                             B.CMDT_GRP_CD                  IS NULL
                            ) 

                    /* 'ONEWAY' 또는 'ROUNDTRIP'만 RATE로 가져오는 경우 FILTERING */
                    AND     DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')
                                                            = DECODE(v_way_type, 'ONE', AA.ONE_WY_CURR_CD, 'RND', AA.RND_CURR_CD, '0')                            
                             
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_ofc_cty_cd, 'N/A') = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_OFC_CTY_CD, 'N/A')
                    AND     DECODE(pi_trsp_so_knd_cd, 'USRAIL', pi_trsp_agmt_seq       , 1)     = DECODE(pi_trsp_so_knd_cd, 'USRAIL', H.TRSP_AGMT_SEQ       , 1)
                    /* US IRG 변경에 따른 추가 - 2007/04/24                       */                           
                            
                    /* DISTANCE ___ 1:EQ(SAME,AL**,**AL,ALAL), 2:CMDT_GRP(SAME>NULL), 3:CRE_DT(LAST+MIN TO DIST+MIN TO_WGT) */
                    ORDER BY   EQ_TPSZ_PRIOR_ORDER          ASC                              
                             , B.CMDT_GRP_CD                ASC

                             
                             , D.TO_DIST                    ASC   
                             , AA.TRSP_AGMT_EQ_SEQ          DESC
                    )
          WHERE   ROWNUM < 2    
          ;
     
     ELSE
         po_rtn_cd := -1;
     END IF;
     
     /* OUTPUT PARAMETER SETTING FOR GENSET START */
     --po_local_curr_cd  := v_local_curr_cd      ;
     po_basic_rt       := v_genset_rate     ;
     /* OUTPUT PARAMETER SETTING FOR GENSET END */  
     
  END IF;
  
     ----DBMS_OUTPUT.put_line(' ======================= END OF CONTROL STATEMENT ============================== ');
  
     po_way_type                 := v_way_type               ;
     po_local_curr_cd            := v_local_curr_cd          ;
  
     po_trsp_agmt_ofc_cty_cd     := v_trsp_agmt_ofc_cty_cd   ;
     po_trsp_agmt_seq            := v_trsp_agmt_seq          ;
     po_trsp_agmt_rt_tp_ser_no   := v_trsp_agmt_rt_tp_ser_no ;
     
     po_vndr_seq                 := v_vndr_seq               ;
     po_cust_nomi_trkr_flg       := v_cust_nomi_trkr_flg     ;
     po_trsp_agmt_rt_tp_cd       := v_trsp_agmt_rt_tp_cd     ;
     
     po_wtr_rcv_term_cd          := v_wtr_rcv_term_cd        ;
     po_wtr_de_term_cd           := v_wtr_de_term_cd         ;     
  
     IF LENGTH(NVL(v_local_curr_cd, 0)) = 0 THEN
         po_rtn_cd := 99;           /* CURRENCY IS NULL */
     ELSIF po_basic_rt = 0 THEN
         po_rtn_cd := 100;          /* RATE IS ZERO     */
     END IF;
  
  EXCEPTION
        WHEN NO_DATA_FOUND THEN     
            po_rtn_cd := -99; 
            DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_CALCULATION_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
              WHEN TOO_MANY_ROWS THEN
                  po_rtn_cd := -2;  
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_CALCULATION_PRC%%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');       
              WHEN OTHERS THEN
                  po_rtn_cd := -1;
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_CALCULATION_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END GET_BASIC_RATE_CALCULATION_PRC;     
  
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 5, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : SURCHARGE RATE CALCULATION FOR COA  TRS
 #####################################################################*/   
PROCEDURE GET_SCG_RATE_CALCULATION_PRC 
  (     
          pi_system_indicator         IN  VARCHAR2    /* TRS, COA */
      ,   pi_trsp_so_knd_cd           IN  VARCHAR2    /* NONE US RAIL, USRAIL */          
      ,   pi_scg_knd_indicator        IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
      ,   pi_way_type                 IN  VARCHAR2    /* ONE or RND      */   
      
      /* KEY - INPUT */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   pi_trsp_agmt_rt_tp          IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER               
         
      /* OUTPUT ADDITIONAL REF. */
      ,   po_scg_union_exp                OUT VARCHAR2
      /* OUTPUT ADDITIONAL REF. */
               
      /* SCG_RT PK - OUTPUT */
      ,   po_scg_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_scg_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_scg_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      ,   po_trsp_scg_cd                  OUT TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE
      ,   po_trsp_agmt_scg_seq            OUT TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE
      /* SCG_RT PK - OUTPUT */
      
      ,   po_local_curr_cd_or_pct         OUT VARCHAR2
      ,   po_scg_rate_or_pct              OUT NUMBER
      ,   po_rtn_cd                       OUT NUMBER  
      ,   po_process_rslt_msg             OUT VARCHAR2 
  )  
  IS
        
    --FUEL_SCG     CONSTANT VARCHAR2(5) := 'FU';
    --OVER_WGT_SCG CONSTANT VARCHAR2(5) := 'OW';
  
  BEGIN
  
  po_rtn_cd := 0;  /* INITIAL SETTING AS SUCCESS */
  
  DBMS_OUTPUT.ENABLE;
  DBMS_OUTPUT.PUT_LINE('');
  
  IF pi_scg_knd_indicator = 'FU' THEN
  
      DBMS_OUTPUT.PUT_LINE('----------------------------- Fuel Surcharge Rate Calculation Start  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');          
  
      SELECT    SURCHARGE_UNION_EXP, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, TRSP_SCG_CD, TRSP_AGMT_SCG_SEQ, LOCAL_SCG_CURR_CD_OR_PERCENT, FUEL_SURCHARGE_RATE_OR_PERCENT
      INTO      po_scg_union_exp, po_scg_trsp_agmt_ofc_cty_cd, po_scg_trsp_agmt_seq, po_scg_trsp_agmt_rt_tp_ser_no, po_trsp_scg_cd, po_trsp_agmt_scg_seq, po_local_curr_cd_or_pct, po_scg_rate_or_pct
      FROM      ( 
                SELECT   'Fuel Surcharge = ['||E.TRSP_SCG_CD||']->['||E.AGMT_TPSZ_STS_CD||']->['||B.CMDT_GRP_CD||']->['||E.CRE_DT||']'  SURCHARGE_UNION_EXP
                        , E.TRSP_AGMT_OFC_CTY_CD
                        , E.TRSP_AGMT_SEQ
                        , E.TRSP_AGMT_RT_TP_SER_NO
                        , E.TRSP_SCG_CD
                        , E.TRSP_AGMT_SCG_SEQ
                        
                          , CASE WHEN E.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN E.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN E.AGMT_TPSZ_STS_CD  LIKE '%AL%'      THEN 2
                                 WHEN E.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                    
                        , CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                           WHEN 'RND' THEN E.RND_CURR_CD
                          END LOCAL_SCG_CURR_CD_OR_PERCENT     /* OUTPUT VALUE CURRENCY CODE OR % */
                        , CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
                                           WHEN 'RND' THEN E.TRSP_RND_RT
                          END FUEL_SURCHARGE_RATE_OR_PERCENT
                                                        
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
                AND       (E.TRSP_SCG_CD                  = 'FUE'
                           OR
                           E.TRSP_SCG_CD                  = 'FUA'
                          )
                AND       B.EQ_KND_CD                  = pi_eq_knd_cd
                AND       DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ)
                                                          = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                AND       NVL(B.CGO_TP_CD, 'N/A')         = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE 'N/A' END
                
                AND       B.TRSP_COST_MOD_CD              = TRS_AGMT_RATE_CAL_PKG.GET_CST_CD_4_PAIR_DIST_TP_FNC('P', B.EQ_KND_CD, B.CGO_TP_CD, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cost_mod_cd)
                
                AND       B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                AND       NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                
                AND       NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'             ELSE  'Y'  END    
                AND       NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd  ELSE 'N/A' END    
                AND       NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq     ELSE 0     END    
                
                AND       NVL(E.FM_NOD_CD , 'N/A')        = CASE WHEN E.TRSP_SCG_CD = 'FUE' THEN DECODE(LENGTH(E.FM_NOD_CD ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                                                                 WHEN E.TRSP_SCG_CD = 'FUA' THEN 'N/A'
                                                            END
                AND       NVL(E.VIA_NOD_CD, 'N/A')        = CASE WHEN E.TRSP_SCG_CD = 'FUE' THEN NVL(DECODE(LENGTH(E.VIA_NOD_CD), 7, pi_via_nod_cd , 5, SUBSTR(pi_via_nod_cd ,1,5)), 'N/A')
                                                                 WHEN E.TRSP_SCG_CD = 'FUA' THEN 'N/A'
                                                            END
                AND       NVL(E.DOR_NOD_CD, 'N/A')        = CASE WHEN E.TRSP_SCG_CD = 'FUE' THEN NVL(DECODE(LENGTH(E.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5)), 'N/A')
                                                                 WHEN E.TRSP_SCG_CD = 'FUA' THEN 'N/A'
                                                            END
                AND       NVL(E.TO_NOD_CD , 'N/A')        = CASE WHEN E.TRSP_SCG_CD = 'FUE' THEN DECODE(LENGTH(E.TO_NOD_CD ), 7, pi_to_nod_cd  , 5, SUBSTR(pi_to_nod_cd  ,1,5))
                                                                 WHEN E.TRSP_SCG_CD = 'FUA' THEN 'N/A'
                                                            END
                AND       E.EFF_FM_DT                    <= pi_basis_dt
                AND       E.EFF_TO_DT                    >= pi_basis_dt
                
                /* BASIC RATE WAY TYPE에 따라서 SURCHAGE WAY TYPE 결정 */
                AND       CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                           WHEN 'RND' THEN E.RND_CURR_CD
                          END                             IS NOT NULL
                /*_____________________________________________________*/
                
                /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                AND    E.AGMT_TPSZ_STS_CD                 IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')                
                       
                /* INPUT COMMODITY CODE : INPUT NULL EQUALS AGMT NULL, INPUT NOT NULL -> 1. AGMT CMDT_CD SAME, 2. AGMT CMDT_CD NULL*/
                AND     (B.CMDT_GRP_CD                 = TRS_AGMT_RATE_CAL_PKG.GET_CONV_CMDT_GRP_CD_FNC(A.VNDR_SEQ, pi_cmdt_cd)
                         OR
                         B.CMDT_GRP_CD                 IS NULL
                        )
                        
                /* 0:FUE >> FUA, 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST) */
                ORDER BY E.TRSP_SCG_CD                      DESC                        /* */
                       , EQ_TPSZ_PRIOR_ORDER                ASC
                       , B.CMDT_GRP_CD                      ASC
                       , LENGTH(NVL(E.FM_NOD_CD ,'N/A'))    DESC   
                       , LENGTH(NVL(E.VIA_NOD_CD,'N/A'))    DESC
                       , LENGTH(NVL(E.DOR_NOD_CD,'N/A'))    DESC
                       , LENGTH(NVL(E.TO_NOD_CD ,'N/A'))    DESC 
                       , E.TRSP_AGMT_SCG_SEQ                DESC

                                             
      )
      WHERE   ROWNUM < 2       
      ;       
  
      DBMS_OUTPUT.PUT_LINE('----------------------------- Fuel Surcharge Rate Calculation Finished  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');            
  
  ELSIF pi_scg_knd_indicator = 'OW' THEN
  
      DBMS_OUTPUT.PUT_LINE('----------------------------- Over-Weight Surcharge Rate Calculation Start  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');            
  
      /* OW AND (EQ TYPE SIZE > EQ TYPE SIZE EMPTY) AND (CMDT > CMDT EMPTY)               */
      
      SELECT  SURCHARGE_UNION_EXP, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, TRSP_AGMT_RT_TP_SER_NO, TRSP_SCG_CD, TRSP_AGMT_SCG_SEQ, LOCAL_SCG_CURR_CD_OR_PERCENT, FUEL_SURCHARGE_RATE_OR_PERCENT
      INTO      po_scg_union_exp, po_scg_trsp_agmt_ofc_cty_cd, po_scg_trsp_agmt_seq, po_scg_trsp_agmt_rt_tp_ser_no, po_trsp_scg_cd, po_trsp_agmt_scg_seq, po_local_curr_cd_or_pct, po_scg_rate_or_pct
      FROM      ( 
                /* OVER-WEIGHT SURCHARGE : OW(ROUTE) + EQ TYPE SIZE IS NOT NULL + INPUT COMMODITY CODE IS NOT NULL */
                SELECT   
                          'OverWeight Surcharge = ['||E.TRSP_SCG_CD||']->['||E.AGMT_TPSZ_STS_CD||']->['||B.CMDT_GRP_CD||']->['||E.CRE_DT||']'  SURCHARGE_UNION_EXP
                        , E.TRSP_AGMT_OFC_CTY_CD
                        , E.TRSP_AGMT_SEQ
                        , E.TRSP_AGMT_RT_TP_SER_NO
                        , E.TRSP_SCG_CD
                        , E.TRSP_AGMT_SCG_SEQ
                        
                          , CASE WHEN E.AGMT_TPSZ_STS_CD  IS NULL          THEN 9
                                 WHEN E.AGMT_TPSZ_STS_CD  = 'ALAL'         THEN 4
                                 WHEN E.AGMT_TPSZ_STS_CD  LIKE '%AL%'      THEN 2
                                 WHEN E.AGMT_TPSZ_STS_CD = pi_eq_tp_sz_cd  THEN 1
                                 ELSE 3
                            END  EQ_TPSZ_PRIOR_ORDER
                                                          
                        , CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                           WHEN 'RND' THEN E.RND_CURR_CD
                          END LOCAL_SCG_CURR_CD_OR_PERCENT     /* OUTPUT VALUE CURRENCY CODE OR % */
                        , CASE pi_way_type WHEN 'ONE' THEN E.TRSP_ONE_WY_RT
                                           WHEN 'RND' THEN E.TRSP_RND_RT
                          END FUEL_SURCHARGE_RATE_OR_PERCENT
                                                          
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
                AND       E.TRSP_SCG_CD                   = 'OW'
                AND       B.EQ_KND_CD                  = pi_eq_knd_cd
                AND       DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', A.VNDR_SEQ)
                                                          = DECODE(pi_trsp_so_knd_cd, 'USRAIL', '0', TO_NUMBER(pi_vndr_seq))
                AND       NVL(B.CGO_TP_CD, 'N/A')         = CASE WHEN pi_eq_knd_cd = 'U' THEN pi_cgo_tp_cd ELSE 'N/A' END
                AND       B.TRSP_COST_MOD_CD              = TRS_AGMT_RATE_CAL_PKG.GET_CST_CD_4_PAIR_DIST_TP_FNC('P', B.EQ_KND_CD, B.CGO_TP_CD, pi_eq_tp_sz_cd, pi_cmb_tp_cd, pi_cost_mod_cd)
                AND       B.AGMT_TRSP_TP_CD               = pi_crr_mod_cd
                AND       NVL(B.RAIL_SVC_TP_CD, 'N/A')    = NVL(pi_rail_svc_tp_cd, 'N/A') 
                
                AND       NVL(B.CUST_NOMI_TRKR_FLG, 'N')  = CASE NVL(LENGTH(pi_cust_cnt_cd), 0) WHEN 0   THEN 'N'                 ELSE  'Y'  END    
                AND       NVL(B.CUST_CNT_CD, 'N/A')       = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_cnt_cd      ELSE 'N/A' END    
                AND       NVL(B.CUST_SEQ, 0)              = CASE B.CUST_NOMI_TRKR_FLG           WHEN 'Y' THEN pi_cust_seq ELSE 0             END    

                AND       E.FM_NOD_CD                     =     DECODE(LENGTH(E.FM_NOD_CD ), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd,1,5))
                AND       NVL(E.VIA_NOD_CD, 'N/A')        = NVL(DECODE(LENGTH(E.VIA_NOD_CD), 7, pi_via_nod_cd , 5, SUBSTR(pi_via_nod_cd ,1,5)), 'N/A')
                AND       NVL(E.DOR_NOD_CD, 'N/A')        = NVL(DECODE(LENGTH(E.DOR_NOD_CD), 7, pi_door_nod_cd, 5, SUBSTR(pi_door_nod_cd,1,5)), 'N/A')
                AND       E.TO_NOD_CD                     =     DECODE(LENGTH(E.TO_NOD_CD ), 7, pi_to_nod_cd  , 5, SUBSTR(pi_to_nod_cd  ,1,5))                        

                AND       E.EFF_FM_DT                    <= pi_basis_dt
                AND       E.EFF_TO_DT                    >= pi_basis_dt
                AND       TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(NVL(E.WGT_MEAS_UT_CD, 'KG'), E.TO_WGT)
                                                          > TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(pi_wgt_uom, pi_wgt_qty)                  
                
                /* EQ TYPE/SIZE FIND LOGIC : 1st:COMPACT, 2nd:ONE ALL, 3rd:BOTH ALL */
                AND       E.AGMT_TPSZ_STS_CD             IN (pi_eq_tp_sz_cd, SUBSTR(pi_eq_tp_sz_cd,1,1)||'AL', 'AL'||SUBSTR(pi_eq_tp_sz_cd,2,1), 'ALAL')
                   
                AND      (B.CMDT_GRP_CD                  = TRS_AGMT_RATE_CAL_PKG.GET_CONV_CMDT_GRP_CD_FNC(A.VNDR_SEQ, pi_cmdt_cd)
                          OR
                          B.CMDT_GRP_CD                  IS NULL
                         )  
                                                
                /* BASIC RATE WAY TYPE에 따라서 SURCHAGE WAY TYPE 결정 */
                AND       CASE pi_way_type WHEN 'ONE' THEN E.ONE_WY_CURR_CD
                                           WHEN 'RND' THEN E.RND_CURR_CD
                          END                             IS NOT NULL
                /*_____________________________________________________*/  
                                        
                /* 0:FUE >> FUA, 1:ROUTE(SAME>7>5), 2:EQ(SAME,AL**,**AL,ALAL), 3:CMDT_GRP(SAME>NULL), 4:CRE_DT(LAST) */
                ORDER BY EQ_TPSZ_PRIOR_ORDER                ASC
                       , B.CMDT_GRP_CD                      ASC
                       , LENGTH(NVL(E.FM_NOD_CD ,'N/A'))    DESC   
                       , LENGTH(NVL(E.VIA_NOD_CD,'N/A'))    DESC
                       , LENGTH(NVL(E.DOR_NOD_CD,'N/A'))    DESC
                       , LENGTH(NVL(E.TO_NOD_CD ,'N/A'))    DESC 
                       , E.TRSP_AGMT_SCG_SEQ                DESC                         
                )
        WHERE   ROWNUM < 2         
      ;
          
    DBMS_OUTPUT.PUT_LINE('----------------------------- Over-Weight Surcharge Rate Calculation Finished  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');                      
  
  ELSE
  
      po_rtn_cd            := -1;
      po_process_rslt_msg  := 'SURCHARGE CODE IS INVALID!';
  
  END IF;
  
  EXCEPTION
        WHEN NO_DATA_FOUND THEN     
            po_rtn_cd := -99; 
            DBMS_OUTPUT.PUT_LINE('%%%GET_SCG_RATE_CALCULATION_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
              WHEN TOO_MANY_ROWS THEN
                  po_rtn_cd := -2;      
                  DBMS_OUTPUT.PUT_LINE('%%%GET_SCG_RATE_CALCULATION_PRC%%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');     
              WHEN OTHERS THEN
                  po_rtn_cd := -1;
                  DBMS_OUTPUT.PUT_LINE('%%%GET_SCG_RATE_CALCULATION_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END GET_SCG_RATE_CALCULATION_PRC;  
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 1, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : BASIC RATE CALCULATION FOR COA
 #####################################################################*/   
PROCEDURE GET_NONE_USRAIL_BASIC_RATE_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* SYSTEM INDICATOR - COA/TRS      */
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONE or RND      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER  
            ,       pi_rcv_term                 IN  VARCHAR2
            ,       pi_de_term                  IN  VARCHAR2
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE          
      
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE      
              
      ,   po_way_type                 OUT VARCHAR2
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE      
      
      ,   po_rtn_cd                   OUT NUMBER  
      ,   po_process_rslt_msg         OUT VARCHAR2       
  )
  IS
  
  C_ZERO_RATE     CONSTANT NUMBER           := 100   ;  
  C_CURR_ISNULLL  CONSTANT NUMBER           := 99    ; 
   
  C_NO_DATA_FOUND CONSTANT NUMBER           := -99   ;
  C_TOO_MANY_ROWS CONSTANT NUMBER           := -2    ;
  C_OTHER_ERROR   CONSTANT NUMBER           := -1    ;
  
  C_SUCCESS       CONSTANT NUMBER           := 0     ;
  
  v_link_cnt            NUMBER(1)                    ;
  
  v_tmp_agmt_rate_tp    VARCHAR2(2)                  ;  /* temporary P, PD, DP, D */
  v_tmp_agmt_pd_flag    VARCHAR2(1)                  ;  /* temporary P, D Rate    */
  
  v_agmt_eq_knd_cd       VARCHAR2(1)                  ;
  v_tmp_rtn_cd          NUMBER                       ; 
  
  v_tmp_basic_rate      NUMBER(18,3)                 ; 
  v_tmp_tot_basic_rate  NUMBER(18,3)                 ; 
  
  v_wtr_rcv_term_cd     TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE ;
  v_wtr_de_term_cd      TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE  ;  
  
  v_conv_wgt_uom                VARCHAR2(3)                  ;
  v_eq_tare_wgt_qty     NUMBER(18,3)                 ;  
  v_eq_tot_wgt_qty      NUMBER(18,3)                 ;   
  
  BEGIN
  
  /** 초기값 설정 **/
  DBMS_OUTPUT.ENABLE; 
  
  v_link_cnt        := TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);         
  
  v_conv_wgt_uom    := NVL(pi_wgt_uom, 'KGS')                                                  ;
  
  v_eq_tare_wgt_qty := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(v_conv_wgt_uom, pi_eq_tp_sz_cd) ;
  v_eq_tot_wgt_qty  := NVL(v_eq_tare_wgt_qty,0) + NVL(pi_wgt_qty,0)                                ;  
  
  /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */
  IF pi_cgo_tp_cd = 'M' AND (SUBSTR(pi_eq_tp_sz_cd,1,1) = 'F' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'A' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'P') THEN
      v_agmt_eq_knd_cd := 'Z';
  ELSE
      v_agmt_eq_knd_cd := pi_eq_knd_cd;
  END IF;
  
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('----------------------------- Basic Rate Calculation Start  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');        
  DBMS_OUTPUT.PUT_LINE('COUNT OF LINK = ['||v_link_cnt||'], Classified AGREEMENT EQ TYPE CODE = ['||v_agmt_eq_knd_cd||'] ---- PROCESSING STARTING TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
  
  /* All Container except Empty Flatrack */

  /* P --> OK  -->                Success
    P --> N/A --> D --> OK  -->  Success 
    P --> N/A --> D --> N/A -->  Error
  */
  
  IF v_link_cnt = 1 THEN
  
    /* temporary variables setting */
    v_tmp_agmt_rate_tp     := 'P';
    v_tmp_agmt_pd_flag     := 'P';
    
    po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
  
     GET_BASIC_RATE_CALCULATION_PRC   (
                                        pi_system_indicator          /* TRS, COA */
                                        
                                        /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                    ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                    ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                    ----,   ''         /* AGREEMENT REF. NUMBER             */
                                        /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                    
                                    ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                    ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                    ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                    ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                             
                                        ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                        ,       pi_vndr_seq                 
                                        ,       pi_basis_dt                 
                                        ,       pi_way_tp_cd                /* ONE or RND      */
                                        ,       pi_eq_knd_cd                    
                                        ,       pi_eq_tp_sz_cd              
                                        ,       pi_cmb_tp_cd                
                                        ,       pi_cgo_tp_cd                
                                        ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                        ,       pi_crr_mod_cd               
                                        ,       pi_cost_mod_cd              
                                        ,       pi_cust_cnt_cd              
                                        ,       pi_cust_seq                 
                                        ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                        ,       pi_cmdt_cd                  /* OPTIONAL */
                                        ,       pi_from_nod_cd              
                                        ,       pi_via_nod_cd               
                                        ,       pi_door_nod_cd              
                                        ,       pi_to_nod_cd                
                                        ,       pi_bundle_cnt                       
                                        ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                        ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */        
                                        ,       pi_rcv_term                 
                                        ,       pi_de_term
                                    
                                    ,   po_trsp_agmt_ofc_cty_cd      
                                    ,   po_trsp_agmt_seq            
                                    ,   po_trsp_agmt_rt_tp_ser_no   
                                
                                    ,   po_vndr_seq                 
                                    ,   po_cust_nomi_trkr_flg 
                                    ,   po_cust_cnt_cd
                                    ,   po_cust_seq
                                          
                                    ,   po_trsp_agmt_rt_tp_cd       

                                    ,   po_way_type                       
                                    ,   po_local_curr_cd    
                                    
                                    ,   v_wtr_rcv_term_cd          
                                    ,   v_wtr_de_term_cd           
                                            
                                    ,   v_tmp_tot_basic_rate                 
                                    ,   po_rtn_cd                   
                                    ); 
                                    
        po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
        po_wtr_de_term_cd  := v_wtr_de_term_cd  ;
                                    
        DBMS_OUTPUT.PUT_LINE('+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++');
                                    
    IF po_rtn_cd = C_NO_DATA_FOUND THEN
        
       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
       po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ; ';
        
      /* temporary variables setting */
      v_tmp_agmt_rate_tp     := 'D';
      v_tmp_agmt_pd_flag     := 'D';            
  
      po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
        
       GET_BASIC_RATE_CALCULATION_PRC   (
                                          pi_system_indicator          /* TRS, COA */
                                          
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                      ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                      ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                      ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                      ----,   ''         /* AGREEMENT REF. NUMBER             */
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                          
                                          
                                      ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                      ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                      ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                      ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                               
                                            ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                            ,       pi_vndr_seq                 
                                            ,       pi_basis_dt                 
                                            ,       pi_way_tp_cd                /* ONE or RND      */
                                            ,       pi_eq_knd_cd                    
                                            ,       pi_eq_tp_sz_cd              
                                            ,       pi_cmb_tp_cd                
                                            ,       pi_cgo_tp_cd                
                                            ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                            ,       pi_crr_mod_cd               
                                            ,       pi_cost_mod_cd              
                                            ,       pi_cust_cnt_cd              
                                            ,       pi_cust_seq                 
                                            ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                            ,       pi_cmdt_cd                  /* OPTIONAL */
                                            ,       pi_from_nod_cd              
                                            ,       pi_via_nod_cd               
                                            ,       pi_door_nod_cd              
                                            ,       pi_to_nod_cd                
                                            ,       pi_bundle_cnt                       
                                            ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                            ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */ 
                                            ,       ''                  
                                            ,       ''
                                      
                                      ,   po_trsp_agmt_ofc_cty_cd      
                                      ,   po_trsp_agmt_seq            
                                      ,   po_trsp_agmt_rt_tp_ser_no 
                                      
                                      ,   po_vndr_seq                 
                                      ,   po_cust_nomi_trkr_flg 
                                      ,   po_cust_cnt_cd
                                      ,   po_cust_seq
                                            
                                      ,   po_trsp_agmt_rt_tp_cd                                              
                                  
                                      ,   po_way_type 
                                      ,   po_local_curr_cd          
                                      
                                      ,   v_wtr_rcv_term_cd          
                                      ,   v_wtr_de_term_cd            
                                                                             
                                      ,   v_tmp_tot_basic_rate                 
                                      ,   po_rtn_cd                   
                                      );  
                                                 
        
       IF po_rtn_cd = C_NO_DATA_FOUND THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END.---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
            po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
            po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULL  ';   
       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
            po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
            po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
           IF po_rtn_cd = C_ZERO_RATE THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
           ELSIF po_rtn_cd = C_SUCCESS THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], BASIC AMOUT IS = ['||v_tmp_tot_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
           END IF;
           
           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
           
       END IF;   

                    
    ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
        po_process_rslt_msg := po_process_rslt_msg || ' --> CURR_ISNULLL ';          
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
    ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
        po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
    ELSIF po_rtn_cd = C_OTHER_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
        po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
   ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
       IF po_rtn_cd = C_ZERO_RATE THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
           po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
       ELSIF po_rtn_cd = C_SUCCESS THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_tot_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
           po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
       END IF;
       
       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
       
    END IF;
  
    
  ELSIF v_link_cnt = 2 OR v_link_cnt = 3 THEN
  /* P --> OK  -->                                                                   Success
    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success
    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> N/A -->                     Error       
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> OK -->  Success    
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> N/A --> Error              
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> OK -->            Success                      
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> N/A -->           Error        
  */     
  
       -- DEPTH 1 START -------------------------------------------------------------------------------------------------------------------------------------     
       /* 1. P (Pair Rate) */
       
        /* temporary variables setting */
        v_tmp_agmt_rate_tp     := 'P';
        v_tmp_agmt_pd_flag     := 'P';
        
        po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
      
       GET_BASIC_RATE_CALCULATION_PRC   (
                                          pi_system_indicator          /* TRS, COA */
                                          
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                      ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                      ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                      ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                      ----,   ''         /* AGREEMENT REF. NUMBER             */
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                          
                                          
                                      ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                      ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                      ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                      ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                               
                                            ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                            ,       pi_vndr_seq                 
                                            ,       pi_basis_dt                 
                                            ,       pi_way_tp_cd                /* ONE or RND      */
                                            ,       pi_eq_knd_cd                    
                                            ,       pi_eq_tp_sz_cd              
                                            ,       pi_cmb_tp_cd                
                                            ,       pi_cgo_tp_cd                
                                            ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                            ,       pi_crr_mod_cd               
                                            ,       pi_cost_mod_cd              
                                            ,       pi_cust_cnt_cd              
                                            ,       pi_cust_seq                 
                                            ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                            ,       pi_cmdt_cd                  /* OPTIONAL */
                                            ,       pi_from_nod_cd              
                                            ,       pi_via_nod_cd               
                                            ,       pi_door_nod_cd              
                                            ,       pi_to_nod_cd                
                                            ,       pi_bundle_cnt                       
                                            ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                            ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */ 
                                            ,       pi_rcv_term                 
                                            ,       pi_de_term
                                      
                                      ,   po_trsp_agmt_ofc_cty_cd      
                                      ,   po_trsp_agmt_seq            
                                      ,   po_trsp_agmt_rt_tp_ser_no  
                                      
                                      ,   po_vndr_seq                 
                                      ,   po_cust_nomi_trkr_flg   
                                      ,   po_cust_cnt_cd
                                      ,   po_cust_seq
                                          
                                      ,   po_trsp_agmt_rt_tp_cd                                              
                                  
                                      ,   po_way_type 
                                      ,   po_local_curr_cd    
                                      
                                      ,   v_wtr_rcv_term_cd          
                                      ,   v_wtr_de_term_cd            
                                              
                                      ,   v_tmp_basic_rate                 
                                      ,   po_rtn_cd                   
                                      ); 
                                      
        po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
        po_wtr_de_term_cd  := v_wtr_de_term_cd  ;
       
       /* 1. P (Pair Rate) */
       IF po_rtn_cd = C_NO_DATA_FOUND THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
           po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';

            /* 2. PD + P(Pair Rate) */
            /* temporary variables setting */
            v_tmp_agmt_rate_tp     := 'PD';
            v_tmp_agmt_pd_flag     := 'P';
            
            po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
      
           GET_BASIC_RATE_CALCULATION_PRC   (
                                              pi_system_indicator          /* TRS, COA */
                                              
                                              /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                          ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                          ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                          ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                          ----,   ''         /* AGREEMENT REF. NUMBER             */
                                              /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                               
                                              
                                          ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                          ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                          ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                          ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                   
                                                ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                ,       pi_vndr_seq                 
                                                ,       pi_basis_dt                 
                                                ,       pi_way_tp_cd                /* ONE or RND      */
                                                ,       pi_eq_knd_cd                    
                                                ,       pi_eq_tp_sz_cd              
                                                ,       pi_cmb_tp_cd                
                                                ,       pi_cgo_tp_cd                
                                                ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                ,       pi_crr_mod_cd               
                                                ,       pi_cost_mod_cd              
                                                ,       pi_cust_cnt_cd              
                                                ,       pi_cust_seq                 
                                                ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                ,       pi_cmdt_cd                  /* OPTIONAL */
                                                ,       pi_from_nod_cd              
                                                ,       pi_via_nod_cd               
                                                ,       pi_door_nod_cd              
                                                ,       pi_to_nod_cd                
                                                ,       pi_bundle_cnt                       
                                                ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */ 
                                                ,       pi_rcv_term                 
                                                ,       pi_de_term
                                          
                                          ,   po_trsp_agmt_ofc_cty_cd      
                                          ,   po_trsp_agmt_seq            
                                          ,   po_trsp_agmt_rt_tp_ser_no  
                                          
                                          ,   po_vndr_seq                 
                                          ,   po_cust_nomi_trkr_flg  
                                          ,   po_cust_cnt_cd
                                          ,   po_cust_seq
                                               
                                          ,   po_trsp_agmt_rt_tp_cd                                                  
                                      
                                          ,   po_way_type 
                                          ,   po_local_curr_cd     
                                          
                                          ,   v_wtr_rcv_term_cd          
                                          ,   v_wtr_de_term_cd            
                                                 
                                          ,   v_tmp_basic_rate                 
                                          ,   po_rtn_cd                   
                                          ); 
                                          
            po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
            po_wtr_de_term_cd  := v_wtr_de_term_cd  ;                                          
                 
           /* 2. PD + P(Pair Rate) */
           IF po_rtn_cd = C_NO_DATA_FOUND THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND'||' +++ '||'Agmt Rate Type = PD, Pair/Distance Rate = D IS PASSED');
               po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';               
               po_process_rslt_msg    := po_process_rslt_msg || '++ PD+D IS PASSED ';
               
               
                /* 4. DP + P(Pair Rate) */
                /* temporary variables setting */
                v_tmp_agmt_rate_tp     := 'DP';
                v_tmp_agmt_pd_flag     := 'P';
                
                po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
        
               GET_BASIC_RATE_CALCULATION_PRC   (
                                                  pi_system_indicator          /* TRS, COA */
                                                  
                                                  /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                              ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                              ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                              ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                              ----,   ''         /* AGREEMENT REF. NUMBER             */
                                                  /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                                   
                                                  
                                              ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                              ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                              ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                              ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                       
                                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                    ,       pi_vndr_seq                 
                                                    ,       pi_basis_dt                 
                                                    ,       pi_way_tp_cd                /* ONE or RND      */
                                                    ,       pi_eq_knd_cd                    
                                                    ,       pi_eq_tp_sz_cd              
                                                    ,       pi_cmb_tp_cd                
                                                    ,       pi_cgo_tp_cd                
                                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                    ,       pi_crr_mod_cd               
                                                    ,       pi_cost_mod_cd              
                                                    ,       pi_cust_cnt_cd              
                                                    ,       pi_cust_seq                 
                                                    ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                                    ,       pi_from_nod_cd              
                                                    ,       pi_via_nod_cd               
                                                    ,       pi_door_nod_cd              
                                                    ,       pi_to_nod_cd                
                                                    ,       pi_bundle_cnt                       
                                                    ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                    ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                    ,       pi_rcv_term                 
                                                    ,       pi_de_term
                                              
                                              ,   po_trsp_agmt_ofc_cty_cd      
                                              ,   po_trsp_agmt_seq            
                                              ,   po_trsp_agmt_rt_tp_ser_no   
                                              
                                              ,   po_vndr_seq                 
                                              ,   po_cust_nomi_trkr_flg   
                                              ,   po_cust_cnt_cd
                                              ,   po_cust_seq
                                                  
                                              ,   po_trsp_agmt_rt_tp_cd                                                     
                                          
                                              ,   po_way_type 
                                              ,   po_local_curr_cd   
                                              
                                              ,   v_wtr_rcv_term_cd          
                                              ,   v_wtr_de_term_cd            
                                                       
                                              ,   v_tmp_basic_rate                 
                                              ,   po_rtn_cd                   
                                              ); 
               
                po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
                po_wtr_de_term_cd  := v_wtr_de_term_cd  ;               
               
               /* 4. DP + P(Pair Rate) */
               IF po_rtn_cd = C_NO_DATA_FOUND THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND'||' +++ '||'Agmt Rate Type = DP, Pair/Distance Rate = D IS PASSED');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                   po_process_rslt_msg    := po_process_rslt_msg || '++ DP+D IS PASSED ';                   
                   
                    /* 6. D + D(Distance Rate) */
                    /* temporary variables setting */
                    v_tmp_agmt_rate_tp     := 'D';
                    v_tmp_agmt_pd_flag     := 'D';
                    
                    po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
                          
                   GET_BASIC_RATE_CALCULATION_PRC   (
                                                      pi_system_indicator          /* TRS, COA */
                                                      
                                                      /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                                  ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                  ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                  ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                                  ----,   ''         /* AGREEMENT REF. NUMBER             */
                                                      /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                                       
                                                      
                                                  ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                  ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                  ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                  ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                           
                                                        ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                        ,       pi_vndr_seq                 
                                                        ,       pi_basis_dt                 
                                                        ,       pi_way_tp_cd                /* ONE or RND      */
                                                        ,       pi_eq_knd_cd                    
                                                        ,       pi_eq_tp_sz_cd              
                                                        ,       pi_cmb_tp_cd                
                                                        ,       pi_cgo_tp_cd                
                                                        ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                        ,       pi_crr_mod_cd               
                                                        ,       pi_cost_mod_cd              
                                                        ,       pi_cust_cnt_cd              
                                                        ,       pi_cust_seq                 
                                                        ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                        ,       pi_cmdt_cd                  /* OPTIONAL */
                                                        ,       pi_from_nod_cd              
                                                        ,       pi_via_nod_cd               
                                                        ,       pi_door_nod_cd              
                                                        ,       pi_to_nod_cd                
                                                        ,       pi_bundle_cnt                       
                                                        ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                        ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */ 
                                                        ,       ''                  
                                                        ,       ''
                                                  
                                                  ,   po_trsp_agmt_ofc_cty_cd      
                                                  ,   po_trsp_agmt_seq            
                                                  ,   po_trsp_agmt_rt_tp_ser_no  
                                                  
                                                  ,   po_vndr_seq                 
                                                  ,   po_cust_nomi_trkr_flg   
                                                  ,   po_cust_cnt_cd
                                                  ,   po_cust_seq
                                                      
                                                  ,   po_trsp_agmt_rt_tp_cd                                                          
                                              
                                                  ,   po_way_type 
                                                  ,   po_local_curr_cd   
                                                  
                                                  ,   v_wtr_rcv_term_cd          
                                                  ,   v_wtr_de_term_cd            
                                                           
                                                  ,   v_tmp_basic_rate                 
                                                  ,   po_rtn_cd                   
                                                  ); 
                   
                   
                   /* 6. D + D(Distance Rate) */               
                   IF po_rtn_cd = C_NO_DATA_FOUND THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                       po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                       /* 1-2-3-4-1.P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> OK -->            Success                      */
                       IF po_rtn_cd = C_ZERO_RATE THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                           po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                           v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                       ELSIF po_rtn_cd = C_SUCCESS THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                           v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                       END IF;
                       
                       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                       
                   END IF;          
                   /* 6. D + D(Distance Rate) END */
    
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                   po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                   IF po_rtn_cd = C_ZERO_RATE THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                       po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                       v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                   ELSIF po_rtn_cd = C_SUCCESS THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                       v_tmp_tot_basic_rate := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                       
                       
                       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                       
                        /* 5. DP + D(Distance Rate) */
                        /* temporary variables setting */
                        v_tmp_agmt_rate_tp     := 'DP';
                        v_tmp_agmt_pd_flag     := 'D';
                        
                        po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
                
                       GET_BASIC_RATE_CALCULATION_PRC   (
                                                          pi_system_indicator          /* TRS, COA */
                                                          
                                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                                      ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                      ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                      ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                                      ----,   ''         /* AGREEMENT REF. NUMBER             */
                                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                                           
                                                          
                                                      ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                      ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                      ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                      ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                               
                                                            ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                            ,       pi_vndr_seq                 
                                                            ,       pi_basis_dt                 
                                                            ,       pi_way_tp_cd                /* ONE or RND      */
                                                            ,       pi_eq_knd_cd                    
                                                            ,       pi_eq_tp_sz_cd              
                                                            ,       pi_cmb_tp_cd                
                                                            ,       pi_cgo_tp_cd                
                                                            ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                            ,       pi_crr_mod_cd               
                                                            ,       pi_cost_mod_cd              
                                                            ,       pi_cust_cnt_cd              
                                                            ,       pi_cust_seq                 
                                                            ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                            ,       pi_cmdt_cd                  /* OPTIONAL */
                                                            ,       pi_from_nod_cd              
                                                            ,       pi_via_nod_cd               
                                                            ,       pi_door_nod_cd              
                                                            ,       pi_to_nod_cd                
                                                            ,       pi_bundle_cnt                       
                                                            ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                            ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */
                                                            ,       ''                  
                                                            ,       ''
                                                      
                                                      ,   po_trsp_agmt_ofc_cty_cd      
                                                      ,   po_trsp_agmt_seq            
                                                      ,   po_trsp_agmt_rt_tp_ser_no   
                                                      
                                                      ,   po_vndr_seq                 
                                                      ,   po_cust_nomi_trkr_flg  
                                                      ,   po_cust_cnt_cd
                                                      ,   po_cust_seq
                                                           
                                                      ,   po_trsp_agmt_rt_tp_cd                                                             
                                                  
                                                      ,   po_way_type 
                                                      ,   po_local_curr_cd  
                                                      
                                                      ,   v_wtr_rcv_term_cd          
                                                      ,   v_wtr_de_term_cd            
                                                                
                                                      ,   v_tmp_basic_rate                 
                                                      ,   po_rtn_cd                   
                                                      ); 
                       
                       /* 5. DP + D(Distance Rate) */
                       IF po_rtn_cd = C_NO_DATA_FOUND THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
                           po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                           po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                           /* 1-2-3-1.  P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> OK -->  Success */
                           IF po_rtn_cd = C_ZERO_RATE THEN
                               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                           ELSIF po_rtn_cd = C_SUCCESS THEN
                               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                           END IF;
                           
                           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                           
                       END IF;          
                       /* 5. DP + D(Distance Rate) END */
                       
                       
                   END IF;
                   -- DEPTH 1 >> 1-2-1 >> 1-2-3-1 END -------------------------------------------------------------------------------------------------------------------------------------     

                   
               END IF;          
               /* 4. DP + P(Pair Rate) END */
               
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
               po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_OTHER_ERROR THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
               po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
               /*  */
               IF po_rtn_cd = C_ZERO_RATE THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                   po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                   v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
               ELSIF po_rtn_cd = C_SUCCESS THEN             
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                   v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                    
               END IF;
               
               DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                          
               
                 -- DEPTH 1 >> 1-2-1 SUCCESS >> 1-2-1 START -------------------------------------------------------------------------------------------------------------------------------------     
                 /*
                  1-2-1.    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success
                  1-2-0.    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> N/A -->                     Error                      
                 */
                  /* temporary variables setting */
                  v_tmp_agmt_rate_tp     := 'PD';
                  v_tmp_agmt_pd_flag     := 'D';
                  
                  po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
          
                 GET_BASIC_RATE_CALCULATION_PRC   (
                                                    pi_system_indicator          /* TRS, COA */
                                                    
                                                    /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */
                                                ,   'NONE_USRAIL'    /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                ,   ''         /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                ,   ''         /* AGREEMENT NUMBER #2 (SEQ)         */
                                                ----,   ''         /* AGREEMENT REF. NUMBER             */
                                                    /* US RAIL IRG 변경에 따른 추가 : 2007/04/24    */                                                     
                                                    
                                                ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                         
                                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                    ,       pi_vndr_seq                 
                                                    ,       pi_basis_dt                 
                                                    ,       pi_way_tp_cd                /* ONE or RND      */
                                                    ,       pi_eq_knd_cd                    
                                                    ,       pi_eq_tp_sz_cd              
                                                    ,       pi_cmb_tp_cd                
                                                    ,       pi_cgo_tp_cd                
                                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                    ,       pi_crr_mod_cd               
                                                    ,       pi_cost_mod_cd              
                                                    ,       pi_cust_cnt_cd              
                                                    ,       pi_cust_seq                 
                                                    ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                                    ,       pi_from_nod_cd              
                                                    ,       pi_via_nod_cd               
                                                    ,       pi_door_nod_cd              
                                                    ,       pi_to_nod_cd                
                                                    ,       pi_bundle_cnt                       
                                                    ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                    ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                    ,       ''                  
                                                    ,       ''
                                                
                                                ,   po_trsp_agmt_ofc_cty_cd      
                                                ,   po_trsp_agmt_seq            
                                                ,   po_trsp_agmt_rt_tp_ser_no 
                                                
                                                ,   po_vndr_seq                 
                                                ,   po_cust_nomi_trkr_flg  
                                                ,   po_cust_cnt_cd
                                                ,   po_cust_seq
                                                     
                                                ,   po_trsp_agmt_rt_tp_cd                                                        
                                            
                                                ,   po_way_type 
                                                ,   po_local_curr_cd  
                                                
                                                ,   v_wtr_rcv_term_cd          
                                                ,   v_wtr_de_term_cd            
                                                          
                                                ,   v_tmp_basic_rate                 
                                                ,   po_rtn_cd                   
                                                ); 
                 
                 /* 3. PD + D(Distance Rate) */
                 IF po_rtn_cd = C_NO_DATA_FOUND THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
                     po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                     po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';  
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN     
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                     po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                     po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                     /* 1-2-1.  P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success */
                     IF po_rtn_cd = C_ZERO_RATE THEN
                         DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                         po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                         v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                     ELSIF po_rtn_cd = C_SUCCESS THEN
                         DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                         po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                         v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                     END IF;
                     
                     DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                     
                 END IF;          
                 -- DEPTH 1 >> 1-2-1 SUCCESS >> 1-2-1 END  -------------------------------------------------------------------------------------------------------------------------------------                                    
               
           END IF;          
           /* 2. PD + P(Pair Rate) END */
           
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
           po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
           po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
           po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
            /* 1.        P --> OK  -->                                                                   Success */
           IF po_rtn_cd = C_ZERO_RATE THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
           ELSIF po_rtn_cd = C_SUCCESS THEN        
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                  
           END IF;
           
           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
           
       END IF; 
       /* 1. P (Pair Rate) END */         
       
   END IF;
  
  /* Basic Rate */
  po_basic_rt   := v_tmp_tot_basic_rate;
  
  DBMS_OUTPUT.put_line('VENDOR SEQ = ['||po_vndr_seq||'], CNT FLAG = ['||po_cust_nomi_trkr_flg||'], AGREEMENT RATE TYPE = ['||po_trsp_agmt_rt_tp_cd||']');
  DBMS_OUTPUT.PUT_LINE('----------------------------- Basic Rate Calculation Finished  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');        
  
  IF po_basic_rt = 0 THEN
      po_rtn_cd := C_ZERO_RATE;
  END IF;
  
  EXCEPTION
        WHEN NO_DATA_FOUND THEN     
            po_rtn_cd := -99; 
            DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
              WHEN TOO_MANY_ROWS THEN
                  po_rtn_cd := -2;  
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');       
              WHEN OTHERS THEN
                  po_rtn_cd := -1;  
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
  
  END GET_NONE_USRAIL_BASIC_RATE_PRC;
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : FEB 1, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : ALL RATE COMBINATION FOR COA
 #####################################################################*/
  PROCEDURE GET_TRS_ALL_RATE_PRC  
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONE' or 'RND'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2      
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER   
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */       

      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
            
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2        
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER         
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  )
  IS
  
  C_PERCENT_SYMBOL                VARCHAR2(2)         := '%'                         ; 
  
  C_SYSTEM_INDICATOR     CONSTANT VARCHAR2(3)         := 'TRS'                       ;
  c_way_type_priority             VARCHAR2(15)        := 'RND_PRIORITY'              ;  
    
  vo_trsp_agmt_ofc_cty_cd         TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_trsp_agmt_seq                TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_trsp_agmt_rt_tp_ser_no       TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;
  
  vo_scg_trsp_agmt_ofc_cty_cd     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_scg_trsp_agmt_seq            TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_scg_trsp_agmt_rt_tp_ser_no   TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;  
  
  vo_trsp_scg_cd                  TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE              ;
  vo_trsp_agmt_scg_seq            TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE        ;
  
  vo_scg_union_exp                VARCHAR2(50)                                       ;
  
  vo_vndr_seq                     TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE              ;
  vo_cust_nomi_trkr_flg           TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE        ;
  vo_cust_cnt_cd                  TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vo_cust_seq                     TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;
  vo_trsp_agmt_rt_tp_cd           TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE        ;

  v_bzc_way_type                  VARCHAR2(3)  := ''                                 ;
  
  vi_conv_cust_cnt_cd             TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vi_conv_cust_seq                TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;  
  
  v_fu_scg_cd                     VARCHAR2(3)  := ''                                 ;
  v_ow_scg_cd                     VARCHAR2(3)  := ''                                 ;
  
  v_bzc_curr_cd                   VARCHAR2(3)  := ''                                 ;
  v_fu_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  v_ow_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  
  v_bzc_rt                        NUMBER(18,3)                                       ;  
  v_fu_scg_rt                     NUMBER(18,3)                                       ;  
  v_ow_scg_rt                     NUMBER(18,3)                                       ;  
  
  v_wtr_rcv_term_cd               TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE            ;
  v_wtr_de_term_cd                TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE             ;
  
  v_bzc_rtn_cd                    NUMBER(5)                                          ;
  v_fu_scg_rtn_cd                 NUMBER(5)                                          ;
  v_ow_scg_rtn_cd                 NUMBER(5)                                          ;
  
  v_bzc_rtn_msg                   VARCHAR2(1000)                                     ;
  v_fu_scg_rtn_msg                VARCHAR2(1000)                                     ;
  v_ow_scg_rtn_msg                VARCHAR2(1000)                                     ;
  
  /* NONE_USRAIL SO, US RAIL SO 판단결과저장변수 */
  v_trsp_so_knd_indicator         VARCHAR2(15)                                       ;
  v_new_rail_svc_tp_cd            VARCHAR2(2)                                        ;
  v_new_way_tp_cd                 VARCHAR2(15)                                       ;

  v_new_wgt_uom                   VARCHAR2(3)                                        ;
  v_new_wgt_qty                   NUMBER(9,3)                                        ;  
  
  /* PARAMETER CHECK VARIABLES */
  v_param_chk_rtn_cd              NUMBER                                             ;
  v_param_chk_rtn_msg             VARCHAR2(1000):= ''                                ;
  
  v_eff_curr_indicator            VARCHAR2(1) := ''                                  ;
  
  BEGIN
    
    /** 초기값 설정 **/
    DBMS_OUTPUT.ENABLE;          
    DBMS_OUTPUT.PUT_LINE('______________'||'TRS ALL RATE CALCULATION PROCESSING STARTING TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________ ______________________________');        
    
    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
        v_trsp_so_knd_indicator := 'USRAIL';
        
        /* US RAIL S/O NONE-CNT */
        vi_conv_cust_cnt_cd     := '';
        vi_conv_cust_seq        := 0;
        
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd,1,2) ;   /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */
        IF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'O' THEN
            v_new_way_tp_cd := 'ONE' ;  /* ONE    */
        ELSIF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'R' THEN
            v_new_way_tp_cd := 'RND' ;     /* RND */
        ELSE
            v_new_way_tp_cd := ''    ;
        END IF;
    ELSE
        v_trsp_so_knd_indicator := 'NONE_USRAIL' ;
        
        /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
        IF pi_cust_nomi_trkr_flg = 'Y' THEN
            vi_conv_cust_cnt_cd     := pi_cust_cnt_cd;
            vi_conv_cust_seq        := pi_cust_seq   ; 
        ELSE
            vi_conv_cust_cnt_cd     := '';
            vi_conv_cust_seq        := 0;         
        END IF; 
        
        ---- jsk v_new_way_tp_cd := ''    ;
        
        v_new_way_tp_cd := pi_way_tp_cd;

    END IF;
    
    /* COMBINED TYPE CODE CONVERSION */
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN
        v_new_way_tp_cd := pi_way_tp_cd        ;
    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR pi_cmb_tp_cd = 'FM' THEN
        v_new_way_tp_cd := c_way_type_priority ;   /* roundtrip currency priority */
    ELSE
        v_new_way_tp_cd := ''                  ;
    END IF;
    
    IF pi_wgt_uom IS NULL OR NVL(LENGTH(pi_wgt_uom),0) = 0 THEN
        v_new_wgt_uom     := 'KGS'      ;
    ELSE
        v_new_wgt_uom     := pi_wgt_uom ;
    END IF;
    
    IF pi_wgt_qty IS NULL OR NVL(LENGTH(pi_wgt_qty),0) = 0 THEN
        v_new_wgt_qty     := 0          ;
    ELSE
        v_new_wgt_qty     := pi_wgt_qty ;
    END IF;
    /* NONE_USRAIL SO, US RAIL SO 판단 FINISHED */  
  
    /* INPUT PARAMETER VALIDATION CHECK START */
    GET_PARAM_VALID_CHK_PRC (
                                    v_trsp_so_knd_indicator     /* NONE_USRAIL, USRAIL      */
                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                    ,       pi_vndr_seq                 
                                    ,       pi_basis_dt                 
                                    ,       v_new_way_tp_cd             /* 'ONE' or 'RND'      */
                                    ,       pi_eq_knd_cd                    
                                    ,       pi_eq_tp_sz_cd              
                                    ,       pi_cmb_tp_cd                
                                    ,       pi_cgo_tp_cd                
                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                    ,       pi_crr_mod_cd               
                                    ,       pi_cost_mod_cd              
                                    ,       pi_cust_cnt_cd              
                                    ,       pi_cust_seq                 
                                    ,       v_new_rail_svc_tp_cd        /* OPTIONAL */
                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                    ,       pi_from_nod_cd              
                                    ,       pi_via_nod_cd               
                                    ,       pi_door_nod_cd              
                                    ,       pi_to_nod_cd                
                                    ,       pi_bundle_cnt                       
                                    ,       pi_wgt_uom                  /* L-LBS, K-KG */  
                                    ,       pi_wgt_qty                  
                                
                                ,   v_param_chk_rtn_cd          /* 0 : SUCCESS */
                                ,   v_param_chk_rtn_msg    
                            );
        
   ----po_rtn_cd     := v_param_chk_rtn_cd  ;
   ----po_rtn_msg    := v_param_chk_rtn_msg ;
        
    /* INPUT PARAMETER VALIDATION CHECK END   */    
  
    /* CALL --> BASIC RATE CALCULATION */
    GET_NONE_USRAIL_BASIC_RATE_PRC (         
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
                                ,       v_new_wgt_uom        
                                ,       v_new_wgt_qty        
                                ,       ''        
                                ,       ''
                          
                          ,   vo_trsp_agmt_ofc_cty_cd     
                          ,   vo_trsp_agmt_seq            
                          ,   vo_trsp_agmt_rt_tp_ser_no 
                          
                          ,   vo_vndr_seq                
                          ,   vo_cust_nomi_trkr_flg 
                          ,   vo_cust_cnt_cd
                          ,   vo_cust_seq     
                          
                          ,   vo_trsp_agmt_rt_tp_cd      
                          
                          ,   v_bzc_way_type                                  
                          ,   v_bzc_curr_cd            
                          ,   v_bzc_rt       
                          
                          ,   v_wtr_rcv_term_cd
                          ,   v_wtr_de_term_cd 
                                    
                          ,   v_bzc_rtn_cd                   
                          ,   v_bzc_rtn_msg         
                          );
                          
    DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  BASIC RATE CAL. PROCESSING RESULT >>> RETURN CODE = ['||v_bzc_rtn_cd||'],  WAY-TYPE IS = ['||v_bzc_way_type||'], BASIC CURR = ['||v_bzc_curr_cd||'], BASIC RATE = ['||v_bzc_rt||'] Water-Rcv/De Term = ['||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    

      
    IF v_bzc_rtn_cd = 0 THEN
    
    
    
      /* CALL --> FUEL SURCHARGE RATE CALCULATION */
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'NONE_USRAIL'             /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'FU'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                                                        
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
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
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                  
                                    ,   v_fu_scg_curr_cd         
                                    ,   v_fu_scg_rt              
                                    ,   v_fu_scg_rtn_cd                
                                    ,   v_fu_scg_rtn_msg      
                                    );   
                                  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  FUEL SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_fu_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR/PCT = ['||v_fu_scg_curr_cd||'], RATE/RATIO = ['||v_fu_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd = '%' AND v_fu_scg_rt != 0 THEN
              v_fu_scg_rt := ROUND( (v_fu_scg_rt * v_bzc_rt/100), 3);
          END IF;
  
      /* CALL --> OVER WEIGHT SURCHARGE RATE CALCULATION */    
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'NONE_USRAIL'             /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'OW'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                    
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
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
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                
                                    ,   v_ow_scg_curr_cd         
                                    ,   v_ow_scg_rt              
                                    ,   v_ow_scg_rtn_cd                
                                    ,   v_ow_scg_rtn_msg      
                                    );  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  OVER-WEIGHT SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_ow_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR = ['||v_ow_scg_curr_cd||'], RATE = ['||v_ow_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd = '%' AND v_ow_scg_rt != 0 THEN
              v_ow_scg_rt := ROUND( (v_ow_scg_rt * v_bzc_rt/100), 3);
          END IF;                                       
    
          po_local_curr_cd           := v_bzc_curr_cd        ;    /* rate type별 currency code 비교 */
          po_basic_rt                := v_bzc_rt             ;
          po_fuel_scg_rt             := v_fu_scg_rt          ;    
          po_over_wgt_scg_rt         := v_ow_scg_rt          ;

          po_rtn_cd                  := 0                    ;  
          po_rtn_msg                 := 'SUCCESS'            ; 
    
    ELSE 
    
        --po_rtn_cd := -1;
        po_rtn_cd   := v_bzc_rtn_cd;   /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */
        po_rtn_msg  := v_bzc_rtn_msg || ' ________ ' || v_fu_scg_rtn_msg || ' ________ ' || v_ow_scg_rtn_msg;
        
    END IF;
    
    /* ERROR CODE FOR DIFFERENT CURRENCY IS -101/-102/-103 */
    IF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' AND v_ow_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd OR v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -101;
            po_rtn_msg  := 'BASIC/FUEL_SCG/OVER_WGT CURRECY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd THEN
            po_rtn_cd   := -102;
            po_rtn_msg  := 'BASIC/FUEL_SCG CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd != '%' THEN        
        IF v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -103;
            po_rtn_msg  := 'BASIC/OVER_WGT CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;    
    ELSE
        v_eff_curr_indicator := 'Y';   
    END IF;
    
    DBMS_OUTPUT.put_line('_______________________ v_eff_curr_indicator =============== <<< '||v_eff_curr_indicator||' >>> =================');
    
    IF v_eff_curr_indicator = 'Y' THEN
    
        /* Agreement Number */
        po_trsp_agmt_ofc_cty_cd     := vo_trsp_agmt_ofc_cty_cd ;
        po_trsp_agmt_seq            := vo_trsp_agmt_seq        ;
        /* Agreement Number */       
    
        IF v_bzc_rtn_cd = 0 THEN
        
            po_basic_rt := v_bzc_rt;
            
       
            /* CNT FLAG */
            IF vo_cust_nomi_trkr_flg = 'Y' THEN
                po_sp_type           := 'CNT';
                po_cust_nomi_trkr_flg:= 'Y'  ;
            ELSE 
                po_sp_type           := 'HJS';                
                po_cust_nomi_trkr_flg:= 'N'  ;                
            END IF;
            
            IF v_fu_scg_rtn_cd = -99 THEN
                po_fuel_scg_rt             := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */
            END IF;
            
            IF v_ow_scg_rtn_cd = -99 THEN
                po_over_wgt_scg_rt         := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */    
            END IF;
            
        END IF;
        
        /* AGREEMENT RATE TYPE */
        IF vo_trsp_agmt_rt_tp_cd = 'P' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'PD' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair/Distance';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'DP' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance/Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'D' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance';
        ELSE
            po_trsp_agmt_rt_tp_nm := '';
        END IF;
        
        /* TOTAL AMOUNT - LOCAL CURRENCY */
        IF v_bzc_rtn_cd = 0 THEN
            po_local_curr_tot_amt   := po_basic_rt + po_fuel_scg_rt + po_over_wgt_scg_rt  ;
            
            po_way_type             := v_bzc_way_type                                     ;
            
            po_cust_cnt_cd          := vo_cust_cnt_cd                                     ;
            po_cust_seq             := vo_cust_seq                                        ;
            po_trsp_agmt_rt_tp_cd   := vo_trsp_agmt_rt_tp_cd                              ;
        END IF;
        
        /* TOTAL AMOUNT - USD CURRENCY   */
        IF po_local_curr_tot_amt > 0 THEN
            po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(v_bzc_curr_cd, po_local_curr_tot_amt);
        END IF;

    END IF;
    
    /* input Vendor Sequence를 output으로 넘겨준다. */
    ---- po_vndr_seq := pi_vndr_seq ;
      
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('■■■■■ <<'||po_trsp_agmt_rt_tp_nm||'>> ; <<'||po_sp_type||'>> ; BASIC RTN_CD = ['||v_bzc_rtn_cd||'], LOCAL BASIC CURR-CD = ['||v_bzc_curr_cd||'], WAY-TP/W-RCV/W-DE = ['||po_way_type||'/'||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'], BASIC AMT = ['||po_basic_rt||'] ; FU RTN_CD = ['||v_fu_scg_rtn_cd||'], FU CURR = ['||v_fu_scg_curr_cd||'], FU AMOUT = ['||po_fuel_scg_rt||'] ; OW RTN_CD = ['||v_ow_scg_rtn_cd||'], OW CURR = ['||v_ow_scg_curr_cd||'], OW AMT = ['||po_over_wgt_scg_rt||'] ;; LOCAL CURR AMT = ['||po_local_curr_tot_amt||'] ; USD CONV AMT = ['||po_usd_curr_tot_amt||'] ■■■■■');
    DBMS_OUTPUT.PUT_LINE('□□□□□____TRS ALL RATE CALCULATION RESULT MESSAGE IS === Agreement Number is ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']   <<< '||po_rtn_msg||' >>> ____ □□□□□');
    DBMS_OUTPUT.PUT_LINE('______________'||'['||v_trsp_so_knd_indicator||'] S/O  TRS ALL RATE CALCULATION PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________');              
    
    
    /* 2007-04-20 supplement 테스트 임시설정 */
    /*  po_trsp_agmt_ofc_cty_cd     := 'HJS';
      po_trsp_agmt_seq            := 99999;
      po_trsp_agmt_rt_tp_cd       := 'P';
      po_way_type                 := 'ONE';    
      po_trsp_agmt_rt_tp_nm       := 'Pair';    
      po_sp_type                  := 'CNT';    
      po_cust_nomi_trkr_flg       := 'Y';      
      po_cust_cnt_cd              := 'US';    
      po_cust_seq                 := 999;     
      po_local_curr_cd            := 'USD';
      po_basic_rt                 := 12345;
      po_fuel_scg_rt              := 345;
      po_over_wgt_scg_rt          := 000;
      po_local_curr_tot_amt       := 12690;
      po_usd_curr_tot_amt         := 12690;  */
    /*****************************************/
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_TRS_ALL_RATE_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END GET_TRS_ALL_RATE_PRC;
    
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : APRIL 24, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : BASIC RATE CALCULATION FOR COA/TRS US RAIL
 #####################################################################*/   
PROCEDURE GET_USRAIL_BASIC_RATE_PRC 
  (
          pi_system_indicator         IN  VARCHAR2    /* SYSTEM INDICATOR - COA/TRS      */
          
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
      ,   pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
      ----,   pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */          
          
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* ONE or RND      */
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
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER  
      
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      ,   po_trsp_agmt_rt_tp_ser_no   OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE
      
      ,   po_vndr_seq                 OUT TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE
      ,   po_cust_nomi_trkr_flg       OUT TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE
      ,   po_cust_cnt_cd              OUT TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE       
      ,   po_cust_seq                 OUT TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE          
      
      ,   po_trsp_agmt_rt_tp_cd       OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE      
              
      ,   po_way_type                 OUT VARCHAR2
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      
      ,   po_wtr_rcv_term_cd          OUT TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE
      ,   po_wtr_de_term_cd           OUT TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE      
      
      ,   po_rtn_cd                   OUT NUMBER  
      ,   po_process_rslt_msg         OUT VARCHAR2       
  )
  IS
  
  C_ZERO_RATE     CONSTANT NUMBER           := 100   ;  
  C_CURR_ISNULLL  CONSTANT NUMBER           := 99    ; 
   
  C_NO_DATA_FOUND CONSTANT NUMBER           := -99   ;
  C_TOO_MANY_ROWS CONSTANT NUMBER           := -2    ;
  C_OTHER_ERROR   CONSTANT NUMBER           := -1    ;
  
  C_SUCCESS       CONSTANT NUMBER           := 0     ;
  
  v_link_cnt            NUMBER(1)                    ;
  
  v_tmp_agmt_rate_tp    VARCHAR2(2)                  ;  /* temporary P, PD, DP, D */
  v_tmp_agmt_pd_flag    VARCHAR2(1)                  ;  /* temporary P, D Rate    */
  
  v_agmt_eq_knd_cd       VARCHAR2(1)                  ;
  v_tmp_rtn_cd          NUMBER                       ; 
  
  v_tmp_basic_rate      NUMBER(18,3)                 ; 
  v_tmp_tot_basic_rate  NUMBER(18,3)                 ; 
  
  v_wtr_rcv_term_cd     TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE ;
  v_wtr_de_term_cd      TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE  ;  
  
  v_conv_wgt_uom                VARCHAR2(3)                  ;
  v_eq_tare_wgt_qty     NUMBER(18,3)                 ;  
  v_eq_tot_wgt_qty      NUMBER(18,3)                 ;   
  
  BEGIN
  
  /** 초기값 설정 **/
  DBMS_OUTPUT.ENABLE; 
  
  v_link_cnt        := TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(pi_from_nod_cd, pi_via_nod_cd, pi_door_nod_cd, pi_to_nod_cd);         
  
  v_conv_wgt_uom    := NVL(pi_wgt_uom, 'KGS')                                                  ;
  
  v_eq_tare_wgt_qty := TRS_COMMON_PKG.GET_CNTR_TARE_WGT_TO_UOM_FNC(v_conv_wgt_uom, pi_eq_tp_sz_cd) ;
  v_eq_tot_wgt_qty  := NVL(v_eq_tare_wgt_qty,0) + NVL(pi_wgt_qty,0)                                ;  
  
  /* Empty Flatrack Container : CARGO TYPE = 'M' + EQ TYPE = 'F'/'A'/'P' */
  IF pi_cgo_tp_cd = 'M' AND (SUBSTR(pi_eq_tp_sz_cd,1,1) = 'F' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'A' OR SUBSTR(pi_eq_tp_sz_cd,1,1) = 'P') THEN
      v_agmt_eq_knd_cd := 'Z';
  ELSE
      v_agmt_eq_knd_cd := pi_eq_knd_cd;
  END IF;
  
  DBMS_OUTPUT.PUT_LINE('');
  DBMS_OUTPUT.PUT_LINE('----------------------------- Basic Rate Calculation Start  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');        
  DBMS_OUTPUT.PUT_LINE('COUNT OF LINK = ['||v_link_cnt||'], Classified AGREEMENT EQ TYPE CODE = ['||v_agmt_eq_knd_cd||'] ---- PROCESSING STARTING TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
  
  /* All Container except Empty Flatrack */

  /* P --> OK  -->                Success
    P --> N/A --> D --> OK  -->  Success 
    P --> N/A --> D --> N/A -->  Error
    
    US RAIL : 1 LINK AND PAIR ONLY
  */
  
  IF v_link_cnt = 1 THEN
  
    /* temporary variables setting */
    v_tmp_agmt_rate_tp     := 'P';
    v_tmp_agmt_pd_flag     := 'P';
    
    po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
  
     GET_BASIC_RATE_CALCULATION_PRC   (
                                        pi_system_indicator          /* TRS, COA */
                                        
                                        /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                    ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                    ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                    ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                        /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                         
                                        
                                    ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                    ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                    ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                    ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                             
                                        ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                        ,       pi_vndr_seq                 
                                        ,       pi_basis_dt                 
                                        ,       pi_way_tp_cd                /* ONE or RND      */
                                        ,       pi_eq_knd_cd                    
                                        ,       pi_eq_tp_sz_cd              
                                        ,       pi_cmb_tp_cd                
                                        ,       pi_cgo_tp_cd                
                                        ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                        ,       pi_crr_mod_cd               
                                        ,       pi_cost_mod_cd              
                                        ,       pi_cust_cnt_cd              
                                        ,       pi_cust_seq                 
                                        ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                        ,       pi_cmdt_cd                  /* OPTIONAL */
                                        ,       pi_from_nod_cd              
                                        ,       pi_via_nod_cd               
                                        ,       pi_door_nod_cd              
                                        ,       pi_to_nod_cd                
                                        ,       pi_bundle_cnt                       
                                        ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                        ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */        
                                        ,       ''
                                        ,       ''
                                    
                                    ,   po_trsp_agmt_ofc_cty_cd      
                                    ,   po_trsp_agmt_seq            
                                    ,   po_trsp_agmt_rt_tp_ser_no   
                                
                                    ,   po_vndr_seq                 
                                    ,   po_cust_nomi_trkr_flg 
                                    ,   po_cust_cnt_cd
                                    ,   po_cust_seq
                                          
                                    ,   po_trsp_agmt_rt_tp_cd       

                                    ,   po_way_type                       
                                    ,   po_local_curr_cd    
                                    
                                    ,   v_wtr_rcv_term_cd          
                                    ,   v_wtr_de_term_cd           
                                            
                                    ,   v_tmp_tot_basic_rate                 
                                    ,   po_rtn_cd                   
                                    ); 
                                    
        po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
        po_wtr_de_term_cd  := v_wtr_de_term_cd  ;
                                    
        DBMS_OUTPUT.PUT_LINE('+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++');
                                    
    IF po_rtn_cd = C_NO_DATA_FOUND THEN
        
       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
       po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ; ';
        
/*        
        
      \* temporary variables setting *\
      v_tmp_agmt_rate_tp     := 'D';
      v_tmp_agmt_pd_flag     := 'D';            
  
      po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
        
       GET_BASIC_RATE_CALCULATION_PRC   (
                                          pi_system_indicator          \* TRS, COA *\
                                          
                                          \* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    *\
                                      ,   'USRAIL'                   \* 'NONE_USRAIL', 'US RAIL' 구분자         *\
                                      ,   pi_trsp_agmt_ofc_cty_cd    \* AGREEMENT NUMBER #1 (OFC_CTY_CD)  *\
                                      ,   pi_trsp_agmt_seq           \* AGREEMENT NUMBER #2 (SEQ)         *\
                                      ----,   pi_agmt_ref_no             \* AGREEMENT REF. NUMBER             *\
                                          \* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    *\                                           
                                          
                                      ,   v_agmt_eq_knd_cd             \* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) *\
                                      ,   v_tmp_agmt_rate_tp          \* P, PD, DP, D *\
                                      ,   v_tmp_agmt_pd_flag          \* P(pair rate), D(Distance rate)      *\  
                                      ,   v_link_cnt                 \* COUNT OF LINK FORM TRANSPORTATION   *\
                                                                               
                                            ,       pi_ctrl_ofc_cd              \* Pair - X , Distance - Mandatory *\
                                            ,       pi_vndr_seq                 
                                            ,       pi_basis_dt                 
                                            ,       pi_way_tp_cd                \* ONE or RND      *\
                                            ,       pi_eq_knd_cd                    
                                            ,       pi_eq_tp_sz_cd              
                                            ,       pi_cmb_tp_cd                
                                            ,       pi_cgo_tp_cd                
                                            ,       pi_bound_cd                 \* OPTIONAL - IN/OUT BOUND *\
                                            ,       pi_crr_mod_cd               
                                            ,       pi_cost_mod_cd              
                                            ,       pi_cust_cnt_cd              
                                            ,       pi_cust_seq                 
                                            ,       pi_rail_svc_tp_cd           \* OPTIONAL *\
                                            ,       pi_cmdt_cd                  \* OPTIONAL *\
                                            ,       pi_from_nod_cd              
                                            ,       pi_via_nod_cd               
                                            ,       pi_door_nod_cd              
                                            ,       pi_to_nod_cd                
                                            ,       pi_bundle_cnt                       
                                            ,       v_conv_wgt_uom              \* L-LBS, K-KG *\  
                                            ,       v_eq_tot_wgt_qty            \* Tare Weight + Cargo Weight *\                
                                      
                                      ,   po_trsp_agmt_ofc_cty_cd      
                                      ,   po_trsp_agmt_seq            
                                      ,   po_trsp_agmt_rt_tp_ser_no 
                                      
                                      ,   po_vndr_seq                 
                                      ,   po_cust_nomi_trkr_flg 
                                      ,   po_cust_cnt_cd
                                      ,   po_cust_seq
                                            
                                      ,   po_trsp_agmt_rt_tp_cd                                              
                                  
                                      ,   po_way_type 
                                      ,   po_local_curr_cd          
                                      
                                      ,   v_wtr_rcv_term_cd          
                                      ,   v_wtr_de_term_cd            
                                                                             
                                      ,   v_tmp_tot_basic_rate                 
                                      ,   po_rtn_cd                   
                                      );  
                                                 
        
       IF po_rtn_cd = C_NO_DATA_FOUND THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END.---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
            po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
            po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULL  ';   
       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
            po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
            po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
           IF po_rtn_cd = C_ZERO_RATE THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  \* SUCCESS *\
           ELSIF po_rtn_cd = C_SUCCESS THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], BASIC AMOUT IS = ['||v_tmp_tot_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   \* SUCCESS *\                   
           END IF;
           
           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
           
       END IF;   */

                    
    ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
        po_process_rslt_msg := po_process_rslt_msg || ' --> CURR_ISNULLL ';          
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
    ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
        po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
    ELSIF po_rtn_cd = C_OTHER_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
        po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
   ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
       IF po_rtn_cd = C_ZERO_RATE THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
           po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
       ELSIF po_rtn_cd = C_SUCCESS THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_tot_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
           po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
       END IF;
       
       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
       
    END IF;
  
    
  ELSIF v_link_cnt = 2 OR v_link_cnt = 3 THEN
  /* P --> OK  -->                                                                   Success
    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success
    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> N/A -->                     Error       
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> OK -->  Success    
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> N/A --> Error              
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> OK -->            Success                      
    P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> N/A -->           Error        
  */     
  
       -- DEPTH 1 START -------------------------------------------------------------------------------------------------------------------------------------     
       /* 1. P (Pair Rate) */
       
        /* temporary variables setting */
        v_tmp_agmt_rate_tp     := 'P';
        v_tmp_agmt_pd_flag     := 'P';
        
        po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
      
       GET_BASIC_RATE_CALCULATION_PRC   (
                                          pi_system_indicator          /* TRS, COA */
                                          
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                      ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                      ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                      ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                      ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                           
                                          
                                      ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                      ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                      ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                      ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                               
                                            ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                            ,       pi_vndr_seq                 
                                            ,       pi_basis_dt                 
                                            ,       pi_way_tp_cd                /* ONE or RND      */
                                            ,       pi_eq_knd_cd                    
                                            ,       pi_eq_tp_sz_cd              
                                            ,       pi_cmb_tp_cd                
                                            ,       pi_cgo_tp_cd                
                                            ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                            ,       pi_crr_mod_cd               
                                            ,       pi_cost_mod_cd              
                                            ,       pi_cust_cnt_cd              
                                            ,       pi_cust_seq                 
                                            ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                            ,       pi_cmdt_cd                  /* OPTIONAL */
                                            ,       pi_from_nod_cd              
                                            ,       pi_via_nod_cd               
                                            ,       pi_door_nod_cd              
                                            ,       pi_to_nod_cd                
                                            ,       pi_bundle_cnt                       
                                            ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                            ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */                
                                            ,       ''
                                            ,       ''
                                      
                                      ,   po_trsp_agmt_ofc_cty_cd      
                                      ,   po_trsp_agmt_seq            
                                      ,   po_trsp_agmt_rt_tp_ser_no  
                                      
                                      ,   po_vndr_seq                 
                                      ,   po_cust_nomi_trkr_flg   
                                      ,   po_cust_cnt_cd
                                      ,   po_cust_seq
                                          
                                      ,   po_trsp_agmt_rt_tp_cd                                              
                                  
                                      ,   po_way_type 
                                      ,   po_local_curr_cd    
                                      
                                      ,   v_wtr_rcv_term_cd          
                                      ,   v_wtr_de_term_cd            
                                              
                                      ,   v_tmp_basic_rate                 
                                      ,   po_rtn_cd                   
                                      ); 
                                      
        po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
        po_wtr_de_term_cd  := v_wtr_de_term_cd  ;
       
       /* 1. P (Pair Rate) */
       IF po_rtn_cd = C_NO_DATA_FOUND THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
           po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';

            /* 2. PD + P(Pair Rate) */
            /* temporary variables setting */
            v_tmp_agmt_rate_tp     := 'PD';
            v_tmp_agmt_pd_flag     := 'P';
            
            po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
      
           GET_BASIC_RATE_CALCULATION_PRC   (
                                              pi_system_indicator          /* TRS, COA */
                                              
                                              /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                          ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                          ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                          ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                          ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                              /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                               
                                              
                                          ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                          ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                          ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                          ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                   
                                                ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                ,       pi_vndr_seq                 
                                                ,       pi_basis_dt                 
                                                ,       pi_way_tp_cd                /* ONE or RND      */
                                                ,       pi_eq_knd_cd                    
                                                ,       pi_eq_tp_sz_cd              
                                                ,       pi_cmb_tp_cd                
                                                ,       pi_cgo_tp_cd                
                                                ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                ,       pi_crr_mod_cd               
                                                ,       pi_cost_mod_cd              
                                                ,       pi_cust_cnt_cd              
                                                ,       pi_cust_seq                 
                                                ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                ,       pi_cmdt_cd                  /* OPTIONAL */
                                                ,       pi_from_nod_cd              
                                                ,       pi_via_nod_cd               
                                                ,       pi_door_nod_cd              
                                                ,       pi_to_nod_cd                
                                                ,       pi_bundle_cnt                       
                                                ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                ,       ''
                                                ,       ''
                                          
                                          ,   po_trsp_agmt_ofc_cty_cd      
                                          ,   po_trsp_agmt_seq            
                                          ,   po_trsp_agmt_rt_tp_ser_no  
                                          
                                          ,   po_vndr_seq                 
                                          ,   po_cust_nomi_trkr_flg  
                                          ,   po_cust_cnt_cd
                                          ,   po_cust_seq
                                               
                                          ,   po_trsp_agmt_rt_tp_cd                                                  
                                      
                                          ,   po_way_type 
                                          ,   po_local_curr_cd     
                                          
                                          ,   v_wtr_rcv_term_cd          
                                          ,   v_wtr_de_term_cd            
                                                 
                                          ,   v_tmp_basic_rate                 
                                          ,   po_rtn_cd                   
                                          ); 
                                          
            po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
            po_wtr_de_term_cd  := v_wtr_de_term_cd  ;                                          
                 
           /* 2. PD + P(Pair Rate) */
           IF po_rtn_cd = C_NO_DATA_FOUND THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND'||' +++ '||'Agmt Rate Type = PD, Pair/Distance Rate = D IS PASSED');
               po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';               
               po_process_rslt_msg    := po_process_rslt_msg || '++ PD+D IS PASSED ';
               
               
                /* 4. DP + P(Pair Rate) */
                /* temporary variables setting */
                v_tmp_agmt_rate_tp     := 'DP';
                v_tmp_agmt_pd_flag     := 'P';
                
                po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
        
               GET_BASIC_RATE_CALCULATION_PRC   (
                                                  pi_system_indicator          /* TRS, COA */
                                                  
                                                  /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                              ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                              ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                              ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                              ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                                  /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                                    
                                                  
                                              ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                              ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                              ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                              ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                       
                                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                    ,       pi_vndr_seq                 
                                                    ,       pi_basis_dt                 
                                                    ,       pi_way_tp_cd                /* ONE or RND      */
                                                    ,       pi_eq_knd_cd                    
                                                    ,       pi_eq_tp_sz_cd              
                                                    ,       pi_cmb_tp_cd                
                                                    ,       pi_cgo_tp_cd                
                                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                    ,       pi_crr_mod_cd               
                                                    ,       pi_cost_mod_cd              
                                                    ,       pi_cust_cnt_cd              
                                                    ,       pi_cust_seq                 
                                                    ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                                    ,       pi_from_nod_cd              
                                                    ,       pi_via_nod_cd               
                                                    ,       pi_door_nod_cd              
                                                    ,       pi_to_nod_cd                
                                                    ,       pi_bundle_cnt                       
                                                    ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                    ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                    ,       ''
                                                    ,       ''
                                              
                                              ,   po_trsp_agmt_ofc_cty_cd      
                                              ,   po_trsp_agmt_seq            
                                              ,   po_trsp_agmt_rt_tp_ser_no   
                                              
                                              ,   po_vndr_seq                 
                                              ,   po_cust_nomi_trkr_flg   
                                              ,   po_cust_cnt_cd
                                              ,   po_cust_seq
                                                  
                                              ,   po_trsp_agmt_rt_tp_cd                                                     
                                          
                                              ,   po_way_type 
                                              ,   po_local_curr_cd   
                                              
                                              ,   v_wtr_rcv_term_cd          
                                              ,   v_wtr_de_term_cd            
                                                       
                                              ,   v_tmp_basic_rate                 
                                              ,   po_rtn_cd                   
                                              ); 
               
                po_wtr_rcv_term_cd := v_wtr_rcv_term_cd ;
                po_wtr_de_term_cd  := v_wtr_de_term_cd  ;               
               
               /* 4. DP + P(Pair Rate) */
               IF po_rtn_cd = C_NO_DATA_FOUND THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND'||' +++ '||'Agmt Rate Type = DP, Pair/Distance Rate = D IS PASSED');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                   po_process_rslt_msg    := po_process_rslt_msg || '++ DP+D IS PASSED ';                   
                   
                    /* 6. D + D(Distance Rate) */
                    /* temporary variables setting */
                    v_tmp_agmt_rate_tp     := 'D';
                    v_tmp_agmt_pd_flag     := 'D';
                    
                    po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
                          
                   GET_BASIC_RATE_CALCULATION_PRC   (
                                                      pi_system_indicator          /* TRS, COA */
                                                      
                                                      /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                                  ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                  ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                  ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                                  ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                                      /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                                        
                                                      
                                                  ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                  ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                  ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                  ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                           
                                                        ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                        ,       pi_vndr_seq                 
                                                        ,       pi_basis_dt                 
                                                        ,       pi_way_tp_cd                /* ONE or RND      */
                                                        ,       pi_eq_knd_cd                    
                                                        ,       pi_eq_tp_sz_cd              
                                                        ,       pi_cmb_tp_cd                
                                                        ,       pi_cgo_tp_cd                
                                                        ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                        ,       pi_crr_mod_cd               
                                                        ,       pi_cost_mod_cd              
                                                        ,       pi_cust_cnt_cd              
                                                        ,       pi_cust_seq                 
                                                        ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                        ,       pi_cmdt_cd                  /* OPTIONAL */
                                                        ,       pi_from_nod_cd              
                                                        ,       pi_via_nod_cd               
                                                        ,       pi_door_nod_cd              
                                                        ,       pi_to_nod_cd                
                                                        ,       pi_bundle_cnt                       
                                                        ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                        ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                        ,       ''
                                                        ,       ''
                                                  
                                                  ,   po_trsp_agmt_ofc_cty_cd      
                                                  ,   po_trsp_agmt_seq            
                                                  ,   po_trsp_agmt_rt_tp_ser_no  
                                                  
                                                  ,   po_vndr_seq                 
                                                  ,   po_cust_nomi_trkr_flg   
                                                  ,   po_cust_cnt_cd
                                                  ,   po_cust_seq
                                                      
                                                  ,   po_trsp_agmt_rt_tp_cd                                                          
                                              
                                                  ,   po_way_type 
                                                  ,   po_local_curr_cd   
                                                  
                                                  ,   v_wtr_rcv_term_cd          
                                                  ,   v_wtr_de_term_cd            
                                                           
                                                  ,   v_tmp_basic_rate                 
                                                  ,   po_rtn_cd                   
                                                  ); 
                   
                   
                   /* 6. D + D(Distance Rate) */               
                   IF po_rtn_cd = C_NO_DATA_FOUND THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                       po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                   /* 6. D + D(Distance Rate) */
                   ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                       /* 1-2-3-4-1.P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> N/A --> D --> OK -->            Success                      */
                       IF po_rtn_cd = C_ZERO_RATE THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                           po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                           v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                       ELSIF po_rtn_cd = C_SUCCESS THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                           v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                       END IF;
                       
                       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                       
                   END IF;          
                   /* 6. D + D(Distance Rate) END */
    
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                   po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
               /* 4. DP + P(Pair Rate) */
               ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                   IF po_rtn_cd = C_ZERO_RATE THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                       po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                       v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                   ELSIF po_rtn_cd = C_SUCCESS THEN
                       DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                       po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                       v_tmp_tot_basic_rate := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                       
                       
                       DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                       
                        /* 5. DP + D(Distance Rate) */
                        /* temporary variables setting */
                        v_tmp_agmt_rate_tp     := 'DP';
                        v_tmp_agmt_pd_flag     := 'D';
                        
                        po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
                
                       GET_BASIC_RATE_CALCULATION_PRC   (
                                                          pi_system_indicator          /* TRS, COA */
                                                          
                                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                                      ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                      ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                      ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                                      ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                                          /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                                            
                                                          
                                                      ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                      ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                      ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                      ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                               
                                                            ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                            ,       pi_vndr_seq                 
                                                            ,       pi_basis_dt                 
                                                            ,       pi_way_tp_cd                /* ONE or RND      */
                                                            ,       pi_eq_knd_cd                    
                                                            ,       pi_eq_tp_sz_cd              
                                                            ,       pi_cmb_tp_cd                
                                                            ,       pi_cgo_tp_cd                
                                                            ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                            ,       pi_crr_mod_cd               
                                                            ,       pi_cost_mod_cd              
                                                            ,       pi_cust_cnt_cd              
                                                            ,       pi_cust_seq                 
                                                            ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                            ,       pi_cmdt_cd                  /* OPTIONAL */
                                                            ,       pi_from_nod_cd              
                                                            ,       pi_via_nod_cd               
                                                            ,       pi_door_nod_cd              
                                                            ,       pi_to_nod_cd                
                                                            ,       pi_bundle_cnt                       
                                                            ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                            ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */            
                                                            ,       ''
                                                            ,       ''
                                                      
                                                      ,   po_trsp_agmt_ofc_cty_cd      
                                                      ,   po_trsp_agmt_seq            
                                                      ,   po_trsp_agmt_rt_tp_ser_no   
                                                      
                                                      ,   po_vndr_seq                 
                                                      ,   po_cust_nomi_trkr_flg  
                                                      ,   po_cust_cnt_cd
                                                      ,   po_cust_seq
                                                           
                                                      ,   po_trsp_agmt_rt_tp_cd                                                             
                                                  
                                                      ,   po_way_type 
                                                      ,   po_local_curr_cd  
                                                      
                                                      ,   v_wtr_rcv_term_cd          
                                                      ,   v_wtr_de_term_cd            
                                                                
                                                      ,   v_tmp_basic_rate                 
                                                      ,   po_rtn_cd                   
                                                      ); 
                       
                       /* 5. DP + D(Distance Rate) */
                       IF po_rtn_cd = C_NO_DATA_FOUND THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
                           po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                           po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                           po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                       /* 5. DP + D(Distance Rate) */
                       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                           /* 1-2-3-1.  P --> N/A --> PD(Pair) --> N/A --> DP(Pair) --> OK --> DP(Distance) --> OK -->  Success */
                           IF po_rtn_cd = C_ZERO_RATE THEN
                               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                           ELSIF po_rtn_cd = C_SUCCESS THEN
                               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                           END IF;
                           
                           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                           
                       END IF;          
                       /* 5. DP + D(Distance Rate) END */
                       
                       
                   END IF;
                   -- DEPTH 1 >> 1-2-1 >> 1-2-3-1 END -------------------------------------------------------------------------------------------------------------------------------------     

                   
               END IF;          
               /* 4. DP + P(Pair Rate) END */
               
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
               po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_OTHER_ERROR THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
               po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
           /* 2. PD + P(Pair Rate) */
           ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
               /*  */
               IF po_rtn_cd = C_ZERO_RATE THEN
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                   po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                   v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
               ELSIF po_rtn_cd = C_SUCCESS THEN             
                   DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                   po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                   v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                    
               END IF;
               
               DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                          
               
                 -- DEPTH 1 >> 1-2-1 SUCCESS >> 1-2-1 START -------------------------------------------------------------------------------------------------------------------------------------     
                 /*
                  1-2-1.    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success
                  1-2-0.    P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> N/A -->                     Error                      
                 */
                  /* temporary variables setting */
                  v_tmp_agmt_rate_tp     := 'PD';
                  v_tmp_agmt_pd_flag     := 'D';
                  
                  po_process_rslt_msg    := po_process_rslt_msg || 'Agmt-Rate-Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], ';
          
                 GET_BASIC_RATE_CALCULATION_PRC   (
                                                    pi_system_indicator          /* TRS, COA */
                                                    
                                                    /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */
                                                ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                                ,   pi_trsp_agmt_ofc_cty_cd    /* AGREEMENT NUMBER #1 (OFC_CTY_CD)  */
                                                ,   pi_trsp_agmt_seq           /* AGREEMENT NUMBER #2 (SEQ)         */
                                                ----,   pi_agmt_ref_no             /* AGREEMENT REF. NUMBER             */
                                                    /* US RAIL IRG 변경에 따른 추가 : 2007/04/24                    */                                                      
                                                    
                                                ,   v_agmt_eq_knd_cd             /* U(except empty flatrack container), Z(include empty flatrack container), G(all genset) */
                                                ,   v_tmp_agmt_rate_tp          /* P, PD, DP, D */
                                                ,   v_tmp_agmt_pd_flag          /* P(pair rate), D(Distance rate)      */  
                                                ,   v_link_cnt                 /* COUNT OF LINK FORM TRANSPORTATION   */
                                                                                         
                                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                                    ,       pi_vndr_seq                 
                                                    ,       pi_basis_dt                 
                                                    ,       pi_way_tp_cd                /* ONE or RND      */
                                                    ,       pi_eq_knd_cd                    
                                                    ,       pi_eq_tp_sz_cd              
                                                    ,       pi_cmb_tp_cd                
                                                    ,       pi_cgo_tp_cd                
                                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                                    ,       pi_crr_mod_cd               
                                                    ,       pi_cost_mod_cd              
                                                    ,       pi_cust_cnt_cd              
                                                    ,       pi_cust_seq                 
                                                    ,       pi_rail_svc_tp_cd           /* OPTIONAL */
                                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                                    ,       pi_from_nod_cd              
                                                    ,       pi_via_nod_cd               
                                                    ,       pi_door_nod_cd              
                                                    ,       pi_to_nod_cd                
                                                    ,       pi_bundle_cnt                       
                                                    ,       v_conv_wgt_uom              /* L-LBS, K-KG */  
                                                    ,       v_eq_tot_wgt_qty            /* Tare Weight + Cargo Weight */  
                                                    ,       ''
                                                    ,       ''
                                                
                                                ,   po_trsp_agmt_ofc_cty_cd      
                                                ,   po_trsp_agmt_seq            
                                                ,   po_trsp_agmt_rt_tp_ser_no 
                                                
                                                ,   po_vndr_seq                 
                                                ,   po_cust_nomi_trkr_flg  
                                                ,   po_cust_cnt_cd
                                                ,   po_cust_seq
                                                     
                                                ,   po_trsp_agmt_rt_tp_cd                                                        
                                            
                                                ,   po_way_type 
                                                ,   po_local_curr_cd  
                                                
                                                ,   v_wtr_rcv_term_cd          
                                                ,   v_wtr_de_term_cd            
                                                          
                                                ,   v_tmp_basic_rate                 
                                                ,   po_rtn_cd                   
                                                ); 
                 
                 /* 3. PD + D(Distance Rate) */
                 IF po_rtn_cd = C_NO_DATA_FOUND THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = NO_DATA_FOUND the END ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));
                     po_process_rslt_msg    := po_process_rslt_msg || '--> NO_DATA_FOUND ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
                     po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';  
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN     
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
                     po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_OTHER_ERROR THEN
                     DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
                     po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
                 /* 3. PD + D(Distance Rate) */
                 ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
                     /* 1-2-1.  P --> N/A --> PD(Pair) --> OK  --> PD(Distance) --> OK -->                      Success */
                     IF po_rtn_cd = C_ZERO_RATE THEN
                         DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
                         po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
                         v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
                     ELSIF po_rtn_cd = C_SUCCESS THEN
                         DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
                         po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
                         v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                          
                     END IF;
                     
                     DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
                     
                 END IF;          
                 -- DEPTH 1 >> 1-2-1 SUCCESS >> 1-2-1 END  -------------------------------------------------------------------------------------------------------------------------------------                                    
               
           END IF;          
           /* 2. PD + P(Pair Rate) END */
           
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_CURR_ISNULLL THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = CURR_ISNULLL'); 
           po_process_rslt_msg    := po_process_rslt_msg || '--> CURR_ISNULLL ';    
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_TOO_MANY_ROWS THEN   
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = TOO_MANY_ROWS');
           po_process_rslt_msg    := po_process_rslt_msg || '--> TOO_MANY_ROWS ';
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_OTHER_ERROR THEN
           DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = OTHER_ERROR');
           po_process_rslt_msg    := po_process_rslt_msg || '--> OTHER_ERROR ';
       /* 1. P (Pair Rate) */
       ELSIF po_rtn_cd = C_SUCCESS OR po_rtn_cd = C_ZERO_RATE THEN
            /* 1.        P --> OK  -->                                                                   Success */
           IF po_rtn_cd = C_ZERO_RATE THEN
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], Result = ZERO_RATE'); 
               po_process_rslt_msg    := po_process_rslt_msg || '--> ZERO_RATE ';  /* SUCCESS */
               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE ZERO */  
           ELSIF po_rtn_cd = C_SUCCESS THEN        
               DBMS_OUTPUT.PUT_LINE('Agmt Rate Type = ['||v_tmp_agmt_rate_tp||'], Pair/Distance Rate = ['||v_tmp_agmt_pd_flag||'], WAY-TYPE IS = ['||po_way_type||'], RCV/DE-TERM IS = ['||po_wtr_rcv_term_cd||' / '||po_wtr_de_term_cd||'], BASIC AMOUT IS = ['||v_tmp_basic_rate||'], Result = SUCCESS, and Agreement Rate is more than ZERO.');
               po_process_rslt_msg    := po_process_rslt_msg || '--> SUCCESS ';   /* SUCCESS */                   
               v_tmp_tot_basic_rate   := NVL(v_tmp_tot_basic_rate,0) + v_tmp_basic_rate;            /* BASIC RATE SUMMERIZE */                  
           END IF;
           
           DBMS_OUTPUT.PUT_LINE('AGREEMENT NUMBER IS ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']---['||po_trsp_agmt_rt_tp_ser_no||']');
           
       END IF; 
       /* 1. P (Pair Rate) END */         
       
   END IF;
  
  /* Basic Rate */
  po_basic_rt   := v_tmp_tot_basic_rate;
  
  DBMS_OUTPUT.put_line('VENDOR SEQ = ['||po_vndr_seq||'], CNT FLAG = ['||po_cust_nomi_trkr_flg||'], AGREEMENT RATE TYPE = ['||po_trsp_agmt_rt_tp_cd||']');
  DBMS_OUTPUT.PUT_LINE('----------------------------- Basic Rate Calculation Finished  Created by Jeong Sang-Ki AS TOPMAN  --------------------------------------------');        
  
  IF po_basic_rt = 0 THEN
      po_rtn_cd := C_ZERO_RATE;
  END IF;
  
  EXCEPTION
        WHEN NO_DATA_FOUND THEN     
            po_rtn_cd := -99; 
            DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
              WHEN TOO_MANY_ROWS THEN
                  po_rtn_cd := -2;  
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <TOO_MANY_ROWS> ERROR MSG = ['||SQLERRM||']');       
              WHEN OTHERS THEN
                  po_rtn_cd := -1;  
                  DBMS_OUTPUT.PUT_LINE('%%%GET_BASIC_RATE_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');  
  
  END GET_USRAIL_BASIC_RATE_PRC;    
    
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : JEONG SANG-KI
 # -- Created : APRIL 24, 2007
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : ALL RATE COMBINATION FOR TRS US RAIL S/O
 #####################################################################*/
  PROCEDURE GET_TRS_USRAIL_ALL_RATE_PRC  
  (
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
          pi_trsp_agmt_ofc_cty_cd     IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   pi_trsp_agmt_seq            IN  TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE  
          ----pi_agmt_ref_no              IN  TRS_TRSP_AGMT_HDR.AGMT_REF_NO%TYPE
          /* US IRG 변경에 따른 추가 - 2007/04/24                       */
          
            ,       pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  DATE    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONE' or 'RND'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2      
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER   
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */       

      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
            
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2        
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER         
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  )
  IS
  
  C_PERCENT_SYMBOL                VARCHAR2(2)         := '%'                         ; 
  
  C_SYSTEM_INDICATOR     CONSTANT VARCHAR2(3)         := 'TRS'                       ;
    
  vo_trsp_agmt_ofc_cty_cd         TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_trsp_agmt_seq                TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_trsp_agmt_rt_tp_ser_no       TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;
  
  vo_scg_trsp_agmt_ofc_cty_cd     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_scg_trsp_agmt_seq            TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_scg_trsp_agmt_rt_tp_ser_no   TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;  
  
  vo_trsp_scg_cd                  TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE              ;
  vo_trsp_agmt_scg_seq            TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE        ;
  
  vo_scg_union_exp                VARCHAR2(50)                                       ;
  
  vo_vndr_seq                     TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE              ;
  vo_cust_nomi_trkr_flg           TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE        ;
  vo_cust_cnt_cd                  TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vo_cust_seq                     TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;
  vo_trsp_agmt_rt_tp_cd           TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE        ;

  v_bzc_way_type                  VARCHAR2(3)  := ''                                 ;
  
  vi_conv_cust_cnt_cd             TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vi_conv_cust_seq                TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;  
  
  v_fu_scg_cd                     VARCHAR2(3)  := ''                                 ;
  v_ow_scg_cd                     VARCHAR2(3)  := ''                                 ;
  
  v_bzc_curr_cd                   VARCHAR2(3)  := ''                                 ;
  v_fu_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  v_ow_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  
  v_bzc_rt                        NUMBER(18,3)                                       ;  
  v_fu_scg_rt                     NUMBER(18,3)                                       ;  
  v_ow_scg_rt                     NUMBER(18,3)                                       ;  
  
  v_wtr_rcv_term_cd               TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE            ;
  v_wtr_de_term_cd                TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE             ;
  
  v_bzc_rtn_cd                    NUMBER(5)                                          ;
  v_fu_scg_rtn_cd                 NUMBER(5)                                          ;
  v_ow_scg_rtn_cd                 NUMBER(5)                                          ;
  
  v_bzc_rtn_msg                   VARCHAR2(1000)                                     ;
  v_fu_scg_rtn_msg                VARCHAR2(1000)                                     ;
  v_ow_scg_rtn_msg                VARCHAR2(1000)                                     ;
  
  /* NONE_USRAIL SO, US RAIL SO 판단결과저장변수 */
  v_trsp_so_knd_indicator         VARCHAR2(15)                                       ;
  v_new_rail_svc_tp_cd            VARCHAR2(2)                                        ;
  v_new_way_tp_cd                 VARCHAR2(10)                                       ;
  
  v_new_wgt_uom                   VARCHAR2(3)                                        ;
  v_new_wgt_qty                   NUMBER(9,3)                                        ;  
  
  /* PARAMETER CHECK VARIABLES */
  v_param_chk_rtn_cd              NUMBER                                             ;
  v_param_chk_rtn_msg             VARCHAR2(1000):= ''                                ;
  
  v_eff_curr_indicator            VARCHAR2(1) := ''                                  ;
  
  USER_DEFINE_ERROR               EXCEPTION                                          ;
  
  BEGIN
    
    /** 초기값 설정 **/
    DBMS_OUTPUT.ENABLE;          
    DBMS_OUTPUT.PUT_LINE('______________'||'TRS ALL RATE CALCULATION PROCESSING STARTING TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________ ______________________________');        
    
    /* USRAIL 필수항목 RAIL SERVICE TYPE/TRANSPORTATION MODE가 해당값이 아닐때 RAISE EXCEPTION */
    IF (SUBSTR(pi_rail_svc_tp_cd,1,2) <> 'CO' AND SUBSTR(pi_rail_svc_tp_cd,1,2) <> 'CR' AND SUBSTR(pi_rail_svc_tp_cd,1,2) <> 'TO' AND SUBSTR(pi_rail_svc_tp_cd,1,2) <> 'TR') OR pi_crr_mod_cd <> 'RD' THEN
        RAISE USER_DEFINE_ERROR;
    END IF;
    
    
    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
        v_trsp_so_knd_indicator := 'USRAIL';
        
        /* US RAIL S/O NONE-CNT */
        vi_conv_cust_cnt_cd     := '';
        vi_conv_cust_seq        := 0;
        
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd,1,2) ;   /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */
        IF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'O' THEN
            v_new_way_tp_cd := 'ONE' ;  /* ONE    */
        ELSIF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'R' THEN
            v_new_way_tp_cd := 'RND' ;     /* RND */
        ELSE
            v_new_way_tp_cd := ''    ;
        END IF;
    ELSE
        v_trsp_so_knd_indicator := 'NONE_USRAIL' ;
        
        /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
        IF pi_cust_nomi_trkr_flg = 'Y' THEN
            vi_conv_cust_cnt_cd     := pi_cust_cnt_cd;
            vi_conv_cust_seq        := pi_cust_seq   ; 
        ELSE
            vi_conv_cust_cnt_cd     := '';
            vi_conv_cust_seq        := 0;         
        END IF; 
        
        v_new_way_tp_cd := ''    ;

    END IF;
    
    IF pi_wgt_uom IS NULL OR NVL(LENGTH(pi_wgt_uom),0) = 0 THEN
        v_new_wgt_uom     := 'KGS'      ;
    ELSE
        v_new_wgt_uom     := pi_wgt_uom ;
    END IF;
    
    IF pi_wgt_qty IS NULL OR NVL(LENGTH(pi_wgt_qty),0) = 0 THEN
        v_new_wgt_qty     := 0          ;
    ELSE
        v_new_wgt_qty     := pi_wgt_qty ;
    END IF;
    /* NONE_USRAIL SO, US RAIL SO 판단 FINISHED */  
  
    /* INPUT PARAMETER VALIDATION CHECK START */
    GET_PARAM_VALID_CHK_PRC (
                                    v_trsp_so_knd_indicator     /* NONE_USRAIL, USRAIL      */
                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                    ,       pi_vndr_seq                 
                                    ,       pi_basis_dt                 
                                    ,       v_new_way_tp_cd             /* 'ONE' or 'RND'      */
                                    ,       pi_eq_knd_cd                    
                                    ,       pi_eq_tp_sz_cd              
                                    ,       pi_cmb_tp_cd                
                                    ,       pi_cgo_tp_cd                
                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                    ,       pi_crr_mod_cd               
                                    ,       pi_cost_mod_cd              
                                    ,       pi_cust_cnt_cd              
                                    ,       pi_cust_seq                 
                                    ,       v_new_rail_svc_tp_cd        /* OPTIONAL */
                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                    ,       pi_from_nod_cd              
                                    ,       pi_via_nod_cd               
                                    ,       pi_door_nod_cd              
                                    ,       pi_to_nod_cd                
                                    ,       pi_bundle_cnt                       
                                    ,       pi_wgt_uom                  /* L-LBS, K-KG */  
                                    ,       pi_wgt_qty                  
                                
                                ,   v_param_chk_rtn_cd          /* 0 : SUCCESS */
                                ,   v_param_chk_rtn_msg    
                            );
        
   ----po_rtn_cd     := v_param_chk_rtn_cd  ;
   ----po_rtn_msg    := v_param_chk_rtn_msg ;
        
    /* INPUT PARAMETER VALIDATION CHECK END   */    
  
    /* CALL --> BASIC RATE CALCULATION */
    GET_USRAIL_BASIC_RATE_PRC (         
                              C_SYSTEM_INDICATOR  
                              
                              /* US IRG 변경에 따른 추가 - 2007/04/24                       */
                          ,   pi_trsp_agmt_ofc_cty_cd
                          ,   pi_trsp_agmt_seq       
                          ----,   pi_agmt_ref_no         
                              /* US IRG 변경에 따른 추가 - 2007/04/24                       */  
                                         
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
                                ,       v_new_wgt_uom        
                                ,       v_new_wgt_qty        
                          
                          ,   vo_trsp_agmt_ofc_cty_cd     
                          ,   vo_trsp_agmt_seq            
                          ,   vo_trsp_agmt_rt_tp_ser_no 
                          
                          ,   vo_vndr_seq                
                          ,   vo_cust_nomi_trkr_flg 
                          ,   vo_cust_cnt_cd
                          ,   vo_cust_seq     
                          
                          ,   vo_trsp_agmt_rt_tp_cd      
                          
                          ,   v_bzc_way_type                                  
                          ,   v_bzc_curr_cd            
                          ,   v_bzc_rt       
                          
                          ,   v_wtr_rcv_term_cd
                          ,   v_wtr_de_term_cd 
                                    
                          ,   v_bzc_rtn_cd                   
                          ,   v_bzc_rtn_msg         
                          );
                          
    DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  BASIC RATE CAL. PROCESSING RESULT >>> RETURN CODE = ['||v_bzc_rtn_cd||'],  WAY-TYPE IS = ['||v_bzc_way_type||'], BASIC CURR = ['||v_bzc_curr_cd||'], BASIC RATE = ['||v_bzc_rt||'] Water-Rcv/De Term = ['||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    

      
    IF v_bzc_rtn_cd = 0 THEN
    
    
    
      /* CALL --> FUEL SURCHARGE RATE CALCULATION */
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'FU'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                                                        
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
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
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                  
                                    ,   v_fu_scg_curr_cd         
                                    ,   v_fu_scg_rt              
                                    ,   v_fu_scg_rtn_cd                
                                    ,   v_fu_scg_rtn_msg      
                                    );   
                                  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  FUEL SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_fu_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR/PCT = ['||v_fu_scg_curr_cd||'], RATE/RATIO = ['||v_fu_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd = '%' AND v_fu_scg_rt != 0 THEN
              v_fu_scg_rt := ROUND( (v_fu_scg_rt * v_bzc_rt/100), 3);
          END IF;
  
      /* CALL --> OVER WEIGHT SURCHARGE RATE CALCULATION */    
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'USRAIL'                   /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'OW'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                    
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
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
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                
                                    ,   v_ow_scg_curr_cd         
                                    ,   v_ow_scg_rt              
                                    ,   v_ow_scg_rtn_cd                
                                    ,   v_ow_scg_rtn_msg      
                                    );  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  OVER-WEIGHT SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_ow_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR = ['||v_ow_scg_curr_cd||'], RATE = ['||v_ow_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd = '%' AND v_ow_scg_rt != 0 THEN
              v_ow_scg_rt := ROUND( (v_ow_scg_rt * v_bzc_rt/100), 3);
          END IF;                                       
    
          po_local_curr_cd           := v_bzc_curr_cd        ;    /* rate type별 currency code 비교 */
          po_basic_rt                := v_bzc_rt             ;
          po_fuel_scg_rt             := v_fu_scg_rt          ;    
          po_over_wgt_scg_rt         := v_ow_scg_rt          ;

          po_rtn_cd                  := 0                    ;  
          po_rtn_msg                 := 'SUCCESS'            ; 
    
    ELSE 
    
        --po_rtn_cd := -1;
        po_rtn_cd   := v_bzc_rtn_cd;   /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */
        po_rtn_msg  := v_bzc_rtn_msg || ' ________ ' || v_fu_scg_rtn_msg || ' ________ ' || v_ow_scg_rtn_msg;
        
    END IF;
    
    /* ERROR CODE FOR DIFFERENT CURRENCY IS -101/-102/-103 */
    IF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' AND v_ow_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd OR v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -101;
            po_rtn_msg  := 'BASIC/FUEL_SCG/OVER_WGT CURRECY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd THEN
            po_rtn_cd   := -102;
            po_rtn_msg  := 'BASIC/FUEL_SCG CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd != '%' THEN        
        IF v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -103;
            po_rtn_msg  := 'BASIC/OVER_WGT CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;    
    ELSE
        v_eff_curr_indicator := 'Y';   
    END IF;
    
    DBMS_OUTPUT.put_line('_______________________ v_eff_curr_indicator =============== <<< '||v_eff_curr_indicator||' >>> =================');
    
    IF v_eff_curr_indicator = 'Y' THEN
    
        /* Agreement Number */
        po_trsp_agmt_ofc_cty_cd     := vo_trsp_agmt_ofc_cty_cd ;
        po_trsp_agmt_seq            := vo_trsp_agmt_seq        ;
        /* Agreement Number */       
    
        IF v_bzc_rtn_cd = 0 THEN
        
            po_basic_rt := v_bzc_rt;
            
       
            /* CNT FLAG */
            IF vo_cust_nomi_trkr_flg = 'Y' THEN
                po_sp_type           := 'CNT';
                po_cust_nomi_trkr_flg:= 'Y'  ;
            ELSE 
                po_sp_type           := 'HJS';                
                po_cust_nomi_trkr_flg:= 'N'  ;                
            END IF;
            
            IF v_fu_scg_rtn_cd = -99 THEN
                po_fuel_scg_rt             := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */
            END IF;
            
            IF v_ow_scg_rtn_cd = -99 THEN
                po_over_wgt_scg_rt         := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */    
            END IF;
            
        END IF;
        
        /* AGREEMENT RATE TYPE */
        IF vo_trsp_agmt_rt_tp_cd = 'P' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'PD' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair/Distance';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'DP' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance/Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'D' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance';
        ELSE
            po_trsp_agmt_rt_tp_nm := '';
        END IF;
        
        /* TOTAL AMOUNT - LOCAL CURRENCY */
        IF v_bzc_rtn_cd = 0 THEN
            po_local_curr_tot_amt   := po_basic_rt + po_fuel_scg_rt + po_over_wgt_scg_rt  ;
            
            po_way_type             := v_bzc_way_type                                     ;
            
            po_cust_cnt_cd          := vo_cust_cnt_cd                                     ;
            po_cust_seq             := vo_cust_seq                                        ;
            po_trsp_agmt_rt_tp_cd   := vo_trsp_agmt_rt_tp_cd                              ;
        END IF;
        
        /* TOTAL AMOUNT - USD CURRENCY   */
        IF po_local_curr_tot_amt > 0 THEN
            po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(v_bzc_curr_cd, po_local_curr_tot_amt);
        END IF;

    END IF;
    
    /* input Vendor Sequence를 output으로 넘겨준다. */
    ---- po_vndr_seq := pi_vndr_seq ;
      
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('■■■■■ <<'||po_trsp_agmt_rt_tp_nm||'>> ; <<'||po_sp_type||'>> ; BASIC RTN_CD = ['||v_bzc_rtn_cd||'], LOCAL BASIC CURR-CD = ['||v_bzc_curr_cd||'], WAY-TP/W-RCV/W-DE = ['||po_way_type||'/'||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'], BASIC AMT = ['||po_basic_rt||'] ; FU RTN_CD = ['||v_fu_scg_rtn_cd||'], FU CURR = ['||v_fu_scg_curr_cd||'], FU AMOUT = ['||po_fuel_scg_rt||'] ; OW RTN_CD = ['||v_ow_scg_rtn_cd||'], OW CURR = ['||v_ow_scg_curr_cd||'], OW AMT = ['||po_over_wgt_scg_rt||'] ;; LOCAL CURR AMT = ['||po_local_curr_tot_amt||'] ; USD CONV AMT = ['||po_usd_curr_tot_amt||'] ■■■■■');
    DBMS_OUTPUT.PUT_LINE('□□□□□____TRS ALL RATE CALCULATION RESULT MESSAGE IS === Agreement Number is ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']   <<< '||po_rtn_msg||' >>> ____ □□□□□');
    DBMS_OUTPUT.PUT_LINE('______________'||'['||v_trsp_so_knd_indicator||'] S/O  TRS ALL RATE CALCULATION PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________');              
    
  EXCEPTION
      WHEN USER_DEFINE_ERROR THEN
          po_rtn_cd := -8;
          DBMS_OUTPUT.PUT_LINE('%%%GET_TRS_USRAIL_ALL_RATE_PRC%%% <USER_DEFINE_ERROR> ERROR MSG = ['||SQLERRM||']');
      WHEN NO_DATA_FOUND THEN 
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_TRS_USRAIL_ALL_RATE_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
      WHEN OTHERS THEN
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_TRS_USRAIL_ALL_RATE_PRC%%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END GET_TRS_USRAIL_ALL_RATE_PRC;    
  
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : PARK JUN-YONG
 # -- Created : MARCH 26, 2008
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : SOME RATE COMBINATION FOR TRS US RAIL S/O
 #####################################################################*/   
PROCEDURE GET_USRAIL_CONV_AGMT_NO_PRC 
  (
       pi_vndr_seq                    IN  VARCHAR2   
      ,   pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
      ,  po_rtn_cd                    OUT NUMBER
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */
  )
  IS
  BEGIN
  
  IF pi_vndr_seq = '119993' AND pi_cmdt_cd = '810001' THEN
    
    po_trsp_agmt_ofc_cty_cd := 'NYC';
    po_trsp_agmt_seq := 1047;
    
    po_rtn_cd := 0;
    
  ELSIF pi_vndr_seq = '119993' AND (pi_cmdt_cd = '70002' OR pi_cmdt_cd = '70005' OR pi_cmdt_cd = '110001' OR 
                                      pi_cmdt_cd = '110002' OR pi_cmdt_cd = '120101' OR pi_cmdt_cd = '230002' OR
                                      pi_cmdt_cd = '410100' OR pi_cmdt_cd = '980031' OR pi_cmdt_cd = '980034' OR
                                      pi_cmdt_cd = '980035' OR pi_cmdt_cd = '980039') THEN
                                      
    po_trsp_agmt_ofc_cty_cd := 'NYC';
    po_trsp_agmt_seq := 1049;
    
    po_rtn_cd := 0;
    
  ELSIF pi_vndr_seq = '119993' AND (pi_cmdt_cd = '410001' OR pi_cmdt_cd = '410007' OR pi_cmdt_cd = '410009' OR 
                                      pi_cmdt_cd = '410100' OR pi_cmdt_cd = '410102') THEN
                                      
    po_trsp_agmt_ofc_cty_cd := 'NYC';
    po_trsp_agmt_seq := 1051;
    
    po_rtn_cd := 0;
    
  ELSE
    po_rtn_cd := 1;
    
  END IF;  
  
 END GET_USRAIL_CONV_AGMT_NO_PRC;
 
/*###################################################################
 # -- Type    : PROCEDURE
 # -- Author  : PARK JUN-YONG
 # -- Created : MARCH 28, 2008
 # -- Table   : TRS_TRSP_AGMT_*
 # -- Purpose : RATE CALCULATION FOR TRS SP SELECT POPUP
 #####################################################################*/
  PROCEDURE GET_TRS_SP_RATE_PRC  
  (
                    pi_ctrl_ofc_cd              IN  VARCHAR2    /* Pair - X , Distance - Mandatory */
            ,       pi_vndr_seq                 IN  VARCHAR2
            ,       pi_basis_dt                 IN  VARCHAR2    
            ,       pi_way_tp_cd                IN  VARCHAR2    /* 'ONE' or 'RND'      */
            ,       pi_eq_knd_cd                                    IN  VARCHAR2
            ,       pi_eq_tp_sz_cd              IN  VARCHAR2
            ,       pi_cmb_tp_cd                IN  VARCHAR2
            ,       pi_cgo_tp_cd                  IN  VARCHAR2
            ,       pi_bound_cd                 IN  VARCHAR2    /* OPTIONAL - IN/OUT BOUND */
            ,       pi_crr_mod_cd               IN  VARCHAR2
            ,       pi_cost_mod_cd              IN  VARCHAR2
      ,   pi_cust_nomi_trkr_flg       IN  VARCHAR2      
            ,       pi_cust_cnt_cd              IN  VARCHAR2
            ,       pi_cust_seq                 IN  NUMBER  
            ,       pi_rail_svc_tp_cd           IN  VARCHAR2    /* OPTIONAL */
            ,       pi_cmdt_cd                  IN  VARCHAR2    /* OPTIONAL */
            ,       pi_from_nod_cd              IN  VARCHAR2
            ,       pi_via_nod_cd               IN  VARCHAR2
            ,       pi_door_nod_cd              IN  VARCHAR2
            ,       pi_to_nod_cd                IN  VARCHAR2
            ,       pi_bundle_cnt                           IN  NUMBER          
            ,       pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */  
            ,       pi_wgt_qty                  IN  NUMBER   
            ,       pi_rcv_term                 IN  VARCHAR2    
            ,       pi_de_term                  IN  VARCHAR2  
      
      /* Agreement Number */
      ,   po_trsp_agmt_ofc_cty_cd     OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE
      ,   po_trsp_agmt_seq            OUT TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE
      /* Agreement Number */       

      ,   po_trsp_agmt_rt_tp_cd       OUT VARCHAR2      
      ,   po_way_type                 OUT VARCHAR2      
      ,   po_trsp_agmt_rt_tp_nm       OUT VARCHAR2      
            
      ,   po_sp_type                  OUT VARCHAR2      
      ,   po_cust_nomi_trkr_flg       OUT VARCHAR2        
      ,   po_cust_cnt_cd              OUT VARCHAR2      
      ,   po_cust_seq                 OUT NUMBER         
      
      ,   po_local_curr_cd            OUT VARCHAR2
      ,   po_basic_rt                 OUT NUMBER
      ,   po_fuel_scg_rt              OUT NUMBER   
      ,   po_over_wgt_scg_rt          OUT NUMBER

      ,   po_local_curr_tot_amt       OUT NUMBER
      ,   po_usd_curr_tot_amt         OUT NUMBER
      
      ,   po_rtn_cd                   OUT NUMBER      
      ,   po_rtn_msg                  OUT VARCHAR2
  )
  IS
  
  C_PERCENT_SYMBOL                VARCHAR2(2)         := '%'                         ; 
  
  C_SYSTEM_INDICATOR     CONSTANT VARCHAR2(3)         := 'TRS'                       ;
  c_way_type_priority             VARCHAR2(15)        := 'RND_PRIORITY'              ;  
    
  vo_trsp_agmt_ofc_cty_cd         TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_trsp_agmt_seq                TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_trsp_agmt_rt_tp_ser_no       TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;
  
  vo_scg_trsp_agmt_ofc_cty_cd     TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_OFC_CTY_CD%TYPE      ;
  vo_scg_trsp_agmt_seq            TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_SEQ%TYPE             ;
  vo_scg_trsp_agmt_rt_tp_ser_no   TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_SER_NO%TYPE    ;  
  
  vo_trsp_scg_cd                  TRS_TRSP_AGMT_SCG_RT.TRSP_SCG_CD%TYPE              ;
  vo_trsp_agmt_scg_seq            TRS_TRSP_AGMT_SCG_RT.TRSP_AGMT_SCG_SEQ%TYPE        ;
  
  vo_scg_union_exp                VARCHAR2(50)                                       ;
  
  vo_vndr_seq                     TRS_TRSP_AGMT_APLY_VNDR.VNDR_SEQ%TYPE              ;
  vo_cust_nomi_trkr_flg           TRS_TRSP_AGMT_RT_TP.CUST_NOMI_TRKR_FLG%TYPE        ;
  vo_cust_cnt_cd                  TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vo_cust_seq                     TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;
  vo_trsp_agmt_rt_tp_cd           TRS_TRSP_AGMT_RT_TP.TRSP_AGMT_RT_TP_CD%TYPE        ;

  v_bzc_way_type                  VARCHAR2(3)  := ''                                 ;
  
  vi_conv_cust_cnt_cd             TRS_TRSP_AGMT_RT_TP.CUST_CNT_CD%TYPE               ;
  vi_conv_cust_seq                TRS_TRSP_AGMT_RT_TP.CUST_SEQ%TYPE                  ;  
  
  v_fu_scg_cd                     VARCHAR2(3)  := ''                                 ;
  v_ow_scg_cd                     VARCHAR2(3)  := ''                                 ;
  
  v_bzc_curr_cd                   VARCHAR2(3)  := ''                                 ;
  v_fu_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  v_ow_scg_curr_cd                VARCHAR2(3)  := ''                                 ;
  
  v_bzc_rt                        NUMBER(18,3)                                       ;  
  v_fu_scg_rt                     NUMBER(18,3)                                       ;  
  v_ow_scg_rt                     NUMBER(18,3)                                       ;  
  
  v_wtr_rcv_term_cd               TRS_TRSP_AGMT_PAIR.WTR_RCV_TERM_CD%TYPE            ;
  v_wtr_de_term_cd                TRS_TRSP_AGMT_PAIR.Wtr_De_Term_Cd%TYPE             ;
  
  v_bzc_rtn_cd                    NUMBER(5)                                          ;
  v_fu_scg_rtn_cd                 NUMBER(5)                                          ;
  v_ow_scg_rtn_cd                 NUMBER(5)                                          ;
  
  v_bzc_rtn_msg                   VARCHAR2(1000)                                     ;
  v_fu_scg_rtn_msg                VARCHAR2(1000)                                     ;
  v_ow_scg_rtn_msg                VARCHAR2(1000)                                     ;
  
  /* NONE_USRAIL SO, US RAIL SO 판단결과저장변수 */
  v_trsp_so_knd_indicator         VARCHAR2(15)                                       ;
  v_new_rail_svc_tp_cd            VARCHAR2(2)                                        ;
  v_new_way_tp_cd                 VARCHAR2(15)                                       ;

  v_new_wgt_uom                   VARCHAR2(3)                                        ;
  v_new_wgt_qty                   NUMBER(9,3)                                        ;  
  
  /* PARAMETER CHECK VARIABLES */
  v_param_chk_rtn_cd              NUMBER                                             ;
  v_param_chk_rtn_msg             VARCHAR2(1000):= ''                                ;
  
  v_eff_curr_indicator            VARCHAR2(1) := ''                                  ;
  
  BEGIN
    
    /** 초기값 설정 **/
    DBMS_OUTPUT.ENABLE;          
    DBMS_OUTPUT.PUT_LINE('______________'||'TRS ALL RATE CALCULATION PROCESSING STARTING TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________ ______________________________');        
    
    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
        v_trsp_so_knd_indicator := 'USRAIL';
        
        /* US RAIL S/O NONE-CNT */
        vi_conv_cust_cnt_cd     := '';
        vi_conv_cust_seq        := 0;
        
        v_new_rail_svc_tp_cd    := SUBSTR(pi_rail_svc_tp_cd,1,2) ;   /* 앞자리2개 자르기 - COI,CRI,TOI,TRI,COD,CRD,TOD,TRD  */
        IF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'O' THEN
            v_new_way_tp_cd := 'ONE' ;  /* ONE    */
        ELSIF SUBSTR(pi_rail_svc_tp_cd,2,1) = 'R' THEN
            v_new_way_tp_cd := 'RND' ;     /* RND */
        ELSE
            v_new_way_tp_cd := ''    ;
        END IF;
    ELSE
        v_trsp_so_knd_indicator := 'NONE_USRAIL' ;
        
        /* NONE_USRAIL S/O pi_cust_nomi_trkr_flg = 'Y' << CNT */
        IF pi_cust_nomi_trkr_flg = 'Y' THEN
            vi_conv_cust_cnt_cd     := pi_cust_cnt_cd;
            vi_conv_cust_seq        := pi_cust_seq   ; 
        ELSE
            vi_conv_cust_cnt_cd     := '';
            vi_conv_cust_seq        := 0;         
        END IF; 
        
        ---- jsk v_new_way_tp_cd := ''    ;
        
        v_new_way_tp_cd := pi_way_tp_cd;

    END IF;
    
    /* COMBINED TYPE CODE CONVERSION */
    IF pi_way_tp_cd = 'ONE' OR pi_way_tp_cd = 'RND' THEN
        v_new_way_tp_cd := pi_way_tp_cd        ;
    ELSIF pi_cmb_tp_cd = 'BD' OR pi_cmb_tp_cd = 'CF' OR pi_cmb_tp_cd = 'FF' OR pi_cmb_tp_cd = 'FM' THEN
        v_new_way_tp_cd := c_way_type_priority ;   /* roundtrip currency priority */
    ELSE
        v_new_way_tp_cd := ''                  ;
    END IF;
    
    IF pi_wgt_uom IS NULL OR NVL(LENGTH(pi_wgt_uom),0) = 0 THEN
        v_new_wgt_uom     := 'KGS'      ;
    ELSE
        v_new_wgt_uom     := pi_wgt_uom ;
    END IF;
    
    IF pi_wgt_qty IS NULL OR NVL(LENGTH(pi_wgt_qty),0) = 0 THEN
        v_new_wgt_qty     := 0          ;
    ELSE
        v_new_wgt_qty     := pi_wgt_qty ;
    END IF;
    /* NONE_USRAIL SO, US RAIL SO 판단 FINISHED */  
  
    /* INPUT PARAMETER VALIDATION CHECK START */
    GET_PARAM_VALID_CHK_PRC (
                                    v_trsp_so_knd_indicator     /* NONE_USRAIL, USRAIL      */
                                    ,       pi_ctrl_ofc_cd              /* Pair - X , Distance - Mandatory */
                                    ,       pi_vndr_seq                 
                                    ,       TO_DATE(pi_basis_dt, 'YYYYMMDD')                
                                    ,       v_new_way_tp_cd             /* 'ONE' or 'RND'      */
                                    ,       pi_eq_knd_cd                    
                                    ,       pi_eq_tp_sz_cd              
                                    ,       pi_cmb_tp_cd                
                                    ,       pi_cgo_tp_cd                
                                    ,       pi_bound_cd                 /* OPTIONAL - IN/OUT BOUND */
                                    ,       pi_crr_mod_cd               
                                    ,       pi_cost_mod_cd              
                                    ,       pi_cust_cnt_cd              
                                    ,       pi_cust_seq                 
                                    ,       v_new_rail_svc_tp_cd        /* OPTIONAL */
                                    ,       pi_cmdt_cd                  /* OPTIONAL */
                                    ,       pi_from_nod_cd              
                                    ,       pi_via_nod_cd               
                                    ,       pi_door_nod_cd              
                                    ,       pi_to_nod_cd                
                                    ,       pi_bundle_cnt                       
                                    ,       pi_wgt_uom                  /* L-LBS, K-KG */  
                                    ,       pi_wgt_qty                  
                                
                                ,   v_param_chk_rtn_cd          /* 0 : SUCCESS */
                                ,   v_param_chk_rtn_msg    
                            );
        
   ----po_rtn_cd     := v_param_chk_rtn_cd  ;
   ----po_rtn_msg    := v_param_chk_rtn_msg ;
        
    /* INPUT PARAMETER VALIDATION CHECK END   */    
  
    /* CALL --> BASIC RATE CALCULATION */
    GET_NONE_USRAIL_BASIC_RATE_PRC (         
                              C_SYSTEM_INDICATOR   
                                ,     pi_ctrl_ofc_cd    
                                ,       pi_vndr_seq       
                                ,       TO_DATE(pi_basis_dt, 'YYYYMMDD')                      
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
                                ,       v_new_wgt_uom        
                                ,       v_new_wgt_qty        
                                ,       pi_rcv_term        
                                ,       pi_de_term        
                          
                          ,   vo_trsp_agmt_ofc_cty_cd     
                          ,   vo_trsp_agmt_seq            
                          ,   vo_trsp_agmt_rt_tp_ser_no 
                          
                          ,   vo_vndr_seq                
                          ,   vo_cust_nomi_trkr_flg 
                          ,   vo_cust_cnt_cd
                          ,   vo_cust_seq     
                          
                          ,   vo_trsp_agmt_rt_tp_cd      
                          
                          ,   v_bzc_way_type                                  
                          ,   v_bzc_curr_cd            
                          ,   v_bzc_rt       
                          
                          ,   v_wtr_rcv_term_cd
                          ,   v_wtr_de_term_cd 
                                    
                          ,   v_bzc_rtn_cd                   
                          ,   v_bzc_rtn_msg         
                          );
                          
    DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  BASIC RATE CAL. PROCESSING RESULT >>> RETURN CODE = ['||v_bzc_rtn_cd||'],  WAY-TYPE IS = ['||v_bzc_way_type||'], BASIC CURR = ['||v_bzc_curr_cd||'], BASIC RATE = ['||v_bzc_rt||'] Water-Rcv/De Term = ['||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    

      
    IF v_bzc_rtn_cd = 0 THEN
    
    
    
      /* CALL --> FUEL SURCHARGE RATE CALCULATION */
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'NONE_USRAIL'             /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'FU'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                                                        
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
                                        ,       pi_ctrl_ofc_cd            /* Pair - X , Distance - Mandatory */
                                        ,       pi_vndr_seq               
                                        ,       TO_DATE(pi_basis_dt, 'YYYYMMDD')                      
                                        ,       pi_eq_knd_cd                    
                                        ,       pi_eq_tp_sz_cd            
                                        ,       pi_cmb_tp_cd              
                                        ,       pi_cgo_tp_cd                
                                        ,       pi_bound_cd               /* OPTIONAL - IN/OUT BOUND */
                                        ,       pi_crr_mod_cd             
                                        ,       pi_cost_mod_cd            
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                  
                                    ,   v_fu_scg_curr_cd         
                                    ,   v_fu_scg_rt              
                                    ,   v_fu_scg_rtn_cd                
                                    ,   v_fu_scg_rtn_msg      
                                    );   
                                  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  FUEL SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_fu_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR/PCT = ['||v_fu_scg_curr_cd||'], RATE/RATIO = ['||v_fu_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd = '%' AND v_fu_scg_rt != 0 THEN
              v_fu_scg_rt := ROUND( (v_fu_scg_rt * v_bzc_rt/100), 3);
          END IF;
  
      /* CALL --> OVER WEIGHT SURCHARGE RATE CALCULATION */    
      GET_SCG_RATE_CALCULATION_PRC (
                                        C_SYSTEM_INDICATOR        /* TRS, COA */
                                    ,   'NONE_USRAIL'             /* 'NONE_USRAIL', 'US RAIL' 구분자         */
                                    ,   'OW'                      /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
                                    ,   v_bzc_way_type
                                    
                                    ,   vo_trsp_agmt_ofc_cty_cd
                                    ,   vo_trsp_agmt_seq
                                    ,   vo_trsp_agmt_rt_tp_cd
                                    
                                        ,       pi_ctrl_ofc_cd            /* Pair - X , Distance - Mandatory */
                                        ,       pi_vndr_seq               
                                        ,       TO_DATE(pi_basis_dt, 'YYYYMMDD')                     
                                        ,       pi_eq_knd_cd                    
                                        ,       pi_eq_tp_sz_cd            
                                        ,       pi_cmb_tp_cd              
                                        ,       pi_cgo_tp_cd                
                                        ,       pi_bound_cd               /* OPTIONAL - IN/OUT BOUND */
                                        ,       pi_crr_mod_cd             
                                        ,       pi_cost_mod_cd            
                                        ,       vi_conv_cust_cnt_cd    
                                        ,       vi_conv_cust_seq                
                                        ,       v_new_rail_svc_tp_cd      /* OPTIONAL */
                                        ,       pi_cmdt_cd                /* OPTIONAL */
                                        ,       pi_from_nod_cd            
                                        ,       pi_via_nod_cd             
                                        ,       pi_door_nod_cd            
                                        ,       pi_to_nod_cd              
                                        ,       pi_bundle_cnt                       
                                        ,       v_new_wgt_uom             /* L-LBS, K-KG */  
                                        ,       v_new_wgt_qty      
                                    
                                    /* OUTPUT ADDITIONAL REF. */
                                    ,   vo_scg_union_exp
                                    /* OUTPUT ADDITIONAL REF. */                                              
                                       
                                    /* SCG_RT PK - OUTPUT */
                                    ,   vo_scg_trsp_agmt_ofc_cty_cd  
                                    ,   vo_scg_trsp_agmt_seq         
                                    ,   vo_scg_trsp_agmt_rt_tp_ser_no
                                    ,   vo_trsp_scg_cd
                                    ,   vo_trsp_agmt_scg_seq
                                    /* SCG_RT PK - OUTPUT */
                                                
                                    ,   v_ow_scg_curr_cd         
                                    ,   v_ow_scg_rt              
                                    ,   v_ow_scg_rtn_cd                
                                    ,   v_ow_scg_rtn_msg      
                                    );  
                                    
          DBMS_OUTPUT.PUT_LINE('★★★ ['||v_trsp_so_knd_indicator||'] S/O  OVER-WEIGHT SURCHARGE PROCESSING RESULT >>> RETURN CODE = ['||v_ow_scg_rtn_cd||'],  EXP = < '||vo_scg_union_exp||' > ; CURR = ['||v_ow_scg_curr_cd||'], RATE = ['||v_ow_scg_rt||'] ---- PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||' ★★★');                                    
          DBMS_OUTPUT.PUT_LINE('★ PRIMARY KEY SET AGREEMENT NO = ['||vo_trsp_agmt_ofc_cty_cd||vo_trsp_agmt_seq||'] __ SER_NO = ['||vo_trsp_agmt_rt_tp_ser_no||'] __ SCG_CD = ['||vo_trsp_scg_cd||'], SCG_SEQ = ['||vo_trsp_agmt_scg_seq||'] ★');
                                    
          IF v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd = '%' AND v_ow_scg_rt != 0 THEN
              v_ow_scg_rt := ROUND( (v_ow_scg_rt * v_bzc_rt/100), 3);
          END IF;                                       
    
          po_local_curr_cd           := v_bzc_curr_cd        ;    /* rate type별 currency code 비교 */
          po_basic_rt                := v_bzc_rt             ;
          po_fuel_scg_rt             := v_fu_scg_rt          ;    
          po_over_wgt_scg_rt         := v_ow_scg_rt          ;

          po_rtn_cd                  := 0                    ;  
          po_rtn_msg                 := 'SUCCESS'            ; 
    
    ELSE 
    
        --po_rtn_cd := -1;
        po_rtn_cd   := v_bzc_rtn_cd;   /* SURCHARGE는 RATE가 없으면 0으로 계산하므로, BASIC RATE결과코드에 따라 ALL_RATE 결과를 RETURN 한다. */
        po_rtn_msg  := v_bzc_rtn_msg || ' ________ ' || v_fu_scg_rtn_msg || ' ________ ' || v_ow_scg_rtn_msg;
        
    END IF;
    
    /* ERROR CODE FOR DIFFERENT CURRENCY IS -101/-102/-103 */
    IF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' AND v_ow_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd OR v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -101;
            po_rtn_msg  := 'BASIC/FUEL_SCG/OVER_WGT CURRECY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_fu_scg_rtn_cd = 0 AND v_fu_scg_curr_cd != '%' THEN
        IF v_bzc_curr_cd != v_fu_scg_curr_cd THEN
            po_rtn_cd   := -102;
            po_rtn_msg  := 'BASIC/FUEL_SCG CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;
    ELSIF v_bzc_rtn_cd = 0 AND v_ow_scg_rtn_cd = 0 AND v_ow_scg_curr_cd != '%' THEN        
        IF v_bzc_curr_cd != v_ow_scg_curr_cd THEN
            po_rtn_cd   := -103;
            po_rtn_msg  := 'BASIC/OVER_WGT CURRENCY CODE IS DIFFERENCT ';
            v_eff_curr_indicator := 'N';
        ELSE
            v_eff_curr_indicator := 'Y';
        END IF;    
    ELSE
        v_eff_curr_indicator := 'Y';   
    END IF;
    
    DBMS_OUTPUT.put_line('_______________________ v_eff_curr_indicator =============== <<< '||v_eff_curr_indicator||' >>> =================');
    
    IF v_eff_curr_indicator = 'Y' THEN
    
        /* Agreement Number */
        po_trsp_agmt_ofc_cty_cd     := vo_trsp_agmt_ofc_cty_cd ;
        po_trsp_agmt_seq            := vo_trsp_agmt_seq        ;
        /* Agreement Number */       
    
        IF v_bzc_rtn_cd = 0 THEN
        
            po_basic_rt := v_bzc_rt;
            
       
            /* CNT FLAG */
            IF vo_cust_nomi_trkr_flg = 'Y' THEN
                po_sp_type           := 'CNT';
                po_cust_nomi_trkr_flg:= 'Y'  ;
            ELSE 
                po_sp_type           := 'HJS';                
                po_cust_nomi_trkr_flg:= 'N'  ;                
            END IF;
            
            IF v_fu_scg_rtn_cd = -99 THEN
                po_fuel_scg_rt             := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */
            END IF;
            
            IF v_ow_scg_rtn_cd = -99 THEN
                po_over_wgt_scg_rt         := 0;    /* SURCHARGE NO_DATA_FOUND 이면 0으로 세팅함 */    
            END IF;
            
        END IF;
        
        /* AGREEMENT RATE TYPE */
        IF vo_trsp_agmt_rt_tp_cd = 'P' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'PD' THEN
            po_trsp_agmt_rt_tp_nm  := 'Pair/Distance';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'DP' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance/Pair';
        ELSIF vo_trsp_agmt_rt_tp_cd = 'D' THEN
            po_trsp_agmt_rt_tp_nm  := 'Distance';
        ELSE
            po_trsp_agmt_rt_tp_nm := '';
        END IF;
        
        /* TOTAL AMOUNT - LOCAL CURRENCY */
        IF v_bzc_rtn_cd = 0 THEN
            po_local_curr_tot_amt   := po_basic_rt + po_fuel_scg_rt + po_over_wgt_scg_rt  ;
            
            po_way_type             := v_bzc_way_type                                     ;
            
            po_cust_cnt_cd          := vo_cust_cnt_cd                                     ;
            po_cust_seq             := vo_cust_seq                                        ;
            po_trsp_agmt_rt_tp_cd   := vo_trsp_agmt_rt_tp_cd                              ;
        END IF;
        
        /* TOTAL AMOUNT - USD CURRENCY   */
        IF po_local_curr_tot_amt > 0 THEN
            po_usd_curr_tot_amt := TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(v_bzc_curr_cd, po_local_curr_tot_amt);
        END IF;

    END IF;
    
    /* input Vendor Sequence를 output으로 넘겨준다. */
    ---- po_vndr_seq := pi_vndr_seq ;
      
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('■■■■■ <<'||po_trsp_agmt_rt_tp_nm||'>> ; <<'||po_sp_type||'>> ; BASIC RTN_CD = ['||v_bzc_rtn_cd||'], LOCAL BASIC CURR-CD = ['||v_bzc_curr_cd||'], WAY-TP/W-RCV/W-DE = ['||po_way_type||'/'||v_wtr_rcv_term_cd||'/'||v_wtr_de_term_cd||'], BASIC AMT = ['||po_basic_rt||'] ; FU RTN_CD = ['||v_fu_scg_rtn_cd||'], FU CURR = ['||v_fu_scg_curr_cd||'], FU AMOUT = ['||po_fuel_scg_rt||'] ; OW RTN_CD = ['||v_ow_scg_rtn_cd||'], OW CURR = ['||v_ow_scg_curr_cd||'], OW AMT = ['||po_over_wgt_scg_rt||'] ;; LOCAL CURR AMT = ['||po_local_curr_tot_amt||'] ; USD CONV AMT = ['||po_usd_curr_tot_amt||'] ■■■■■');
    DBMS_OUTPUT.PUT_LINE('□□□□□____TRS ALL RATE CALCULATION RESULT MESSAGE IS === Agreement Number is ['||po_trsp_agmt_ofc_cty_cd||']+['||po_trsp_agmt_seq||']   <<< '||po_rtn_msg||' >>> ____ □□□□□');
    DBMS_OUTPUT.PUT_LINE('______________'||'['||v_trsp_so_knd_indicator||'] S/O  TRS ALL RATE CALCULATION PROCESSING FINISHED TIME IS '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')||'____________________________________________________');              
    
    
    /* 2007-04-20 supplement 테스트 임시설정 */
    /*  po_trsp_agmt_ofc_cty_cd     := 'HJS';
      po_trsp_agmt_seq            := 99999;
      po_trsp_agmt_rt_tp_cd       := 'P';
      po_way_type                 := 'ONE';    
      po_trsp_agmt_rt_tp_nm       := 'Pair';    
      po_sp_type                  := 'CNT';    
      po_cust_nomi_trkr_flg       := 'Y';      
      po_cust_cnt_cd              := 'US';    
      po_cust_seq                 := 999;     
      po_local_curr_cd            := 'USD';
      po_basic_rt                 := 12345;
      po_fuel_scg_rt              := 345;
      po_over_wgt_scg_rt          := 000;
      po_local_curr_tot_amt       := 12690;
      po_usd_curr_tot_amt         := 12690;  */
    /*****************************************/
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          po_rtn_cd := -1;
          DBMS_OUTPUT.PUT_LINE('%%%GET_TRS_ALL_RATE_PRC%%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
  
  END GET_TRS_SP_RATE_PRC;   
  
  
END TRS_AGMT_RATE_CAL_PKG;
/