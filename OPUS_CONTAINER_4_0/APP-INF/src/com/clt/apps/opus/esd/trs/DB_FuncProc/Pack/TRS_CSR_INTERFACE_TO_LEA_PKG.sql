CREATE OR REPLACE PACKAGE TRS_CSR_INTERFACE_TO_LEA_PKG 
AUTHID CURRENT_USER
IS
 /*  사용하지 않고 있음.. NOT USED!! */
 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAR 22, 2007
 # -- Table   : AP_INV_IF, LEA_ACT_COST_IF
 # -- Purpose : A/P Approval Request Success -->> LEA Data Input (Plus)
 #####################################################################*/
  FUNCTION SET_APRL_REQ_SUCCESS_FNC ( p_csr_no  VARCHAR2 ) RETURN NUMBER;
  
 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAR 22, 2007
 # -- Table   : AP_INV_IF, LEA_ACT_COST_IF
 # -- Purpose : A/P Approval Request Cancel -->> LEA Data Input (Minus)
 #####################################################################*/
  FUNCTION SET_APRL_CANCEL_FNC      ( p_csr_no  VARCHAR2 ) RETURN NUMBER;

END TRS_CSR_INTERFACE_TO_LEA_PKG;
/

-- DDL Script for PACKAGE BODY TRS_CSR_INTERFACE_TO_LEA_PKG. Orange for ORACLE.
-- Generated on 2009/07/03 13:16:31 by ENISADM@HJSENIS1

CREATE OR REPLACE PACKAGE BODY TRS_CSR_INTERFACE_TO_LEA_PKG IS

 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAR 26, 2007
 # -- Table   : AP_INV_IF, LEA_ACT_COST_IF
 # -- Purpose : A/P Approval Request Success or Cancel -->> LEA Data Input (Plus)
 #####################################################################*/
  FUNCTION SET_APRL_REQ_PROCESS_FNC ( 
                                       p_csr_no         VARCHAR2 
                                     , p_proc_indicator VARCHAR2 DEFAULT 'SUCCESS'
                                    )
  RETURN NUMBER  
  IS

  BEGIN  

  /*===================================================================================
  * BILLING PATTERN CODE (COMBINED THROUGH TYPE CODE)
  * ----------- [W/O ISSUED TO] ---- [INVOICE RECEIVED FROM] --- [Invoice S/P Count]
  * C1T     :   A                    A                                    1
  * C2T     :   A                    A                                    1
  * C3T     :   A                    A                                    1
  * C2R     :   A                    A,B                                  2
  * C3R     :   A                    A,B,C                                3
  * S2R     :   A,B                  A,B                                  2
  * S3R     :   A,B,C                A,B,C                                3
  * C2C     :   A                    B(+A)                                1
  * C3S     :   A                    B(+A),C                              2
  -------------------------------------------------------------------------------------
  * NONE US RAIL   :   1
  *====================================================================================*/

  INSERT INTO LEA_ACT_COST_IF (  EXE_YRMON
                               , INV_SYS_ID
                               , IF_SEQ
                               , GL_DT
                               , BKG_NO
                               , COP_NO                             
                               , VSL_CD
                               , SKD_VOY_NO
                               , SKD_DIR_CD
                               , REV_DIR_CD
                               , ACT_VVD_CD
                               , CNTR_NO
                               , CNTR_TPSZ_CD
                               , COST_ACT_GRP_CD
                               , COST_ACT_GRP_SEQ
                               , COA_COST_SRC_CD         /* NEW : COA_COST_SRC_CD ; OLD : 20070418 - LGS_COST_CD         */
                               , LOCL_CURR_CD
                               , LOCL_COST_AMT
                               , ACCT_CD
                               , CSR_NO
                               , CSR_TP_CD
                               , INV_NO
                               , INV_VNDR_SEQ
                               , TTL_INV_KNT                             
                               , INV_CXL_FLG             /* INVOICE CANCEL FLAG */
                               , INV_CXL_DT              /* INVOICE CANCEL DATE */
                               , COST_ACT_GRP_TP_CD
                               , N1ST_NOD_CD
                               , N2ND_NOD_CD
                               , N3RD_NOD_CD
                               , N4TH_NOD_CD
                               , CRE_DT
                              )
  SELECT   NVL2(GL_DT, SUBSTR(GL_DT,1,6), TO_CHAR(SYSDATE, 'YYYYMM')) 	                           /* LEA.EXE_YRMON          */  
         , 'TRS'                                                                                   /* LEA.INV_SYS_ID         */
         , LEA_ACT_COST_IF_SEQ.NEXTVAL                                                             /* LEA.IF_SEQ           	 */
         , GL_DT                                                                                   /* LEA.GL_DT              */
         , BKG_NO                                                                                  /* LEA.BKG_NO             */
         , COP_NO                                                                                  /* LEA.COP_NO             */
         , VSL_CD                                                                                  /* LEA.VSL_CD             */
         , SKD_VOY_NO     					                                                               /* LEA.SKD_VOY_NO         */ 
         , SKD_DIR_CD     					                                                               /* LEA.SKD_DIR_CD         */
         , FINC_SKD_DIR_CD							                                                           /* LEA.REV_DIR_CD         */
         , ACT_VVD_CD													                                                     /* LEA.ACT_VVD_CD				 */
         , EQ_NO                                                                                   /* LEA.CNTR_NO				     */
         , EQ_TPSZ_CD                                                                              /* LEA.CNTR_TPSZ_CD			 */
         , COST_ACT_GRP_CD                                                                         /* LEA.COST_ACT_GRP_CD		 */
         , COST_ACT_GRP_SEQ                                                                        /* LEA.COST_ACT_GRP_SEQ	 */
         , LGS_COST_CD                                                                             /* LEA.LGS_COST_CD				 */
         , INV_CURR_CD                                                                             /* LEA.LOCL_CURR_CD			 */
         , DECODE(p_proc_indicator, 'SUCCESS', LOCL_COST_AMT, 'CANCEL', -LOCL_COST_AMT, NULL)     /* LEA.LOCL_COST_AMT			 */ /* INVOICE TOTAL AMOUNT */
         , ACCT_CD														                                                     /* LEA.ACCT_CD				     */
         , CSR_NO                                                                                  /* LEA.CSR_NO				     */
         , CSR_TP_CD                                                                               /* LEA.CSR_TP_CD				   */
         , INV_NO                                                                                  /* LEA.INV_NO				     */
         , INV_VNDR_SEQ                                                                            /* LEA.INV_VNDR_SEQ			 */
         , DECODE(p_proc_indicator, 'SUCCESS', TRANS_VNDR_KNT, 'CANCEL', -TRANS_VNDR_KNT, NULL)   /* LEA.TTL_INV_KNT				 */ /* CANCEL�ÿ��� MINUS ��8�� �ִ´�. */                          
         , DECODE(p_proc_indicator, 'SUCCESS', 'N' , 'CANCEL', 'Y'    , '')                       /* LEA.INV_CXL_FLG				 */ /* INVOICE CANCEL FLAG */
         , DECODE(p_proc_indicator, 'SUCCESS', NULL, 'CANCEL', SYSDATE, '')                       /* LEA.INV_CXL_DT				 */ /* INVOICE CANCEL DATE */
         , 'L'																					                                           /* LEA.COST_ACT_GRP_TP_CD */		
         , N1ST_NOD_CD                                                                             /* LEA.N1ST_NOD_CD				 */
         , N2ND_NOD_CD                                                                             /* LEA.N2ND_NOD_CD				 */
         , N3RD_NOD_CD                                                                             /* LEA.N3RD_NOD_CD				 */
         , N4TH_NOD_CD                                                                             /* LEA.N4TH_NOD_CD				 */
         , SYSDATE                                                                                 /* LEA.CRE_DT					   */
  FROM    (    
          /******************** NONE US RAIL INVOICE *********************/
          SELECT      Y.GL_DT                                                        /* LEA.GL_DT                  */
               	  ,		X.BKG_NO                                                       /* LEA.BKG_NO                 */
               	  ,		X.COP_NO                                                       /* LEA.COP_NO                 */
               	  ,		NVL(X.VSL_CD    , 'CNTC'                  )   VSL_CD           /* LEA.VSL_CD                 */
               	  ,		NVL(X.SKD_VOY_NO, TO_CHAR(Y.CRE_DT,'YYMM'))   SKD_VOY_NO       /* LEA.SKD_VOY_NO             */
               	  ,		NVL(X.SKD_DIR_CD, 'M'                     )   SKD_DIR_CD       /* LEA.SKD_DIR_CD             */
               	  ,		NVL(X.FINC_SKD_DIR_CD, 'M'                )   FINC_SKD_DIR_CD  /* LEA.REV_DIR_CD             */
                      /* LEA.ACT_VVD_CD             */
                  ,   DECODE(X.BKG_NO, NULL,'CNTC'||TO_CHAR(Y.CRE_DT,'YYMM')||'MM', X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD)          ACT_VVD_CD       
               	  ,		X.EQ_NO                                                        /* LEA.CNTR_NO                */
               	  ,		X.EQ_TPSZ_CD                                                   /* LEA.CNTR_TPSZ_CD           */
               	  ,   X.COST_ACT_GRP_CD                                                /* LEA.COST_ACT_GRP_CD        */
               	  ,		X.COST_ACT_GRP_SEQ                                             /* LEA.COST_ACT_GRP_SEQ       */
               	  ,		X.LGS_COST_CD                                                  /* LEA.LGS_COST_CD            */
               	  ,		Y.INV_CURR_CD                                                  /* LEA.LOCL_CURR_CD           */
               	  ,		NVL(X.INV_BZC_AMT,0)+NVL(X.INV_ETC_ADD_AMT,0) LOCL_COST_AMT    /* LEA.LOCL_COST_AMT          */
                  ,   X.ACCT_CD                                                      /* LEA.ACCT_CD                */
               	  ,		Y.CSR_NO                                                       /* LEA.CSR_NO                 */
                  ,   AP.CSR_TP_CD                                                   /* LEA.CSR_TP_CD              */
               	  ,		Y.INV_NO                                                       /* LEA.INV_NO                 */
               	  ,		Y.INV_VNDR_SEQ                                                 /* LEA.INV_VNDR_SEQ           */
                  ,   1                                             TRANS_VNDR_KNT   /* LEA.TTL_INV_KNT            */
                  ,   X.FM_NOD_CD                                   N1ST_NOD_CD      /* LEA.N1ST_NOD_CD            */ 
                  ,   CASE TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(X.FM_NOD_CD,X.VIA_NOD_CD,X.DOR_NOD_CD,X.TO_NOD_CD) 
                           WHEN 3 THEN 
                                       CASE WHEN X.TRSP_BND_CD = 'I' THEN X.VIA_NOD_CD
                                            WHEN X.TRSP_BND_CD = 'O' THEN X.DOR_NOD_CD
                                       END
                           WHEN 2 THEN NVL(X.VIA_NOD_CD,X.DOR_NOD_CD)
                           WHEN 1 THEN X.TO_NOD_CD
                      END                                           N2ND_NOD_CD      /* LEA.N2ND_NOD_CD            */ 
                  ,   CASE TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(X.FM_NOD_CD,X.VIA_NOD_CD,X.DOR_NOD_CD,X.TO_NOD_CD) 
                           WHEN 3 THEN 
                                       CASE WHEN X.TRSP_BND_CD = 'I' THEN X.DOR_NOD_CD
                                            WHEN X.TRSP_BND_CD = 'O' THEN X.VIA_NOD_CD
                                       END
                           WHEN 2 THEN X.TO_NOD_CD
                      END                                           N3RD_NOD_CD      /* LEA.N3RD_NOD_CD            */ 
                  ,   CASE TRS_AGMT_RATE_CAL_PKG.GET_LINK_CNT_FNC(X.FM_NOD_CD,X.VIA_NOD_CD,X.DOR_NOD_CD,X.TO_NOD_CD) 
                           WHEN 3 THEN X.TO_NOD_CD
                      END                                           N4TH_NOD_CD      /* LEA.N4TH_NOD_CD            */ 
          FROM        TRS_TRSP_SVC_ORD             X
                  ,   TRS_TRSP_INV_WRK             Y
                  ,   AP_INV_HDR                   AP        
          WHERE       X.INV_NO                     = Y.INV_NO
          AND         X.INV_VNDR_SEQ               = Y.INV_VNDR_SEQ
          ----AND         X.EQ_TP_CD                   = 'C'                             /* CONTAINER ONLY */
          AND         X.EQ_NO                      IS NOT NULL
          AND         Y.GL_DT                      IS NOT NULL
          AND         Y.INV_CURR_CD                IS NOT NULL                           -- �߰� 2007-04-30
          AND         Y.CSR_NO                     = AP.CSR_NO
          AND         Y.CSR_NO                     = p_csr_no
          
          UNION ALL
                    
          /******************** US RAIL INVOICE *********************/                           
          SELECT      Y.GL_DT                                                             /* LEA.GL_DT                  */
               	  ,		X.BKG_NO                                                            /* LEA.BKG_NO                 */
               	  ,		X.COP_NO                                                            /* LEA.COP_NO                 */
               	  ,		NVL(X.VSL_CD         , 'CNTC'                    )  VSL_CD          /* LEA.VSL_CD                 */
               	  ,		NVL(X.SKD_VOY_NO     , TO_CHAR(DTL.CRE_DT,'YYMM'))  SKD_VOY_NO      /* LEA.SKD_VOY_NO             */
               	  ,		NVL(X.SKD_DIR_CD     , 'M'                       )  SKD_DIR_CD      /* LEA.SKD_DIR_CD             */
               	  ,		NVL(X.FINC_SKD_DIR_CD, 'M'                       )  FINC_SKD_DIR_CD /* LEA.REV_DIR_CD             */
                      /* LEA.ACT_VVD_CD             */
                  ,   DECODE(X.BKG_NO, NULL,'CNTC'||TO_CHAR(DTL.CRE_DT,'YYMM')||'MM', X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD) ACT_VVD_CD
               	  ,		NVL(X.EQ_NO, DTL.EQ_NO)                             EQ_NO           /* LEA.CNTR_NO                */
               	  ,		NVL(X.EQ_TPSZ_CD, DTL.EQ_TPSZ_CD)                   EQ_TPSZ_CD      /* LEA.CNTR_TPSZ_CD           */
               	  ,   X.COST_ACT_GRP_CD                                                     /* LEA.COST_ACT_GRP_CD        */
               	  ,		X.COST_ACT_GRP_SEQ                                                  /* LEA.COST_ACT_GRP_SEQ       */                                                       
               	  ,		DTL.LGS_COST_CD                                                     /* LEA.LGS_COST_CD            */
               	  ,		DTL.INV_CURR_CD                                                     /* LEA.LOCL_CURR_CD           */
               	  ,		NVL(DTL.INV_BZC_AMT,0)+NVL(DTL.INV_ETC_ADD_AMT,0)  LOCL_COST_AMT    /* LEA.LOCL_COST_AMT          */
                  ,   DTL.ACCT_CD                                                         /* LEA.ACCT_CD                */
               	  ,		Y.CSR_NO                                                            /* LEA.CSR_NO                 */
                  ,   AP.CSR_TP_CD                                                        /* LEA.CSR_TP_CD              */
               	  ,		Y.INV_NO                                                            /* LEA.INV_NO                 */
               	  ,		Y.INV_VNDR_SEQ                                                      /* LEA.INV_VNDR_SEQ           */
                  ,   CASE WHEN X.RAIL_CMB_THRU_TP_CD IS NULL THEN 1
                           WHEN X.RAIL_CMB_THRU_TP_CD = 'C1T' OR X.RAIL_CMB_THRU_TP_CD = 'C2T' OR X.RAIL_CMB_THRU_TP_CD = 'C3T' OR X.RAIL_CMB_THRU_TP_CD = 'C2C' THEN 1
                           WHEN X.RAIL_CMB_THRU_TP_CD = 'C2R' OR X.RAIL_CMB_THRU_TP_CD = 'S2R' OR X.RAIL_CMB_THRU_TP_CD = 'C3S'                                  THEN 2
                           WHEN X.RAIL_CMB_THRU_TP_CD = 'C3R' OR X.RAIL_CMB_THRU_TP_CD = 'S3R'                                                                   THEN 3
                           ELSE NULL
                      END  TRANS_VNDR_KNT                                                /* LEA.TTL_INV_KNT             */
                  ,   NVL(SCE.N1ST_NOD_CD, DTL.FM_NOD_CD)                N1ST_NOD_CD     /* LEA.N1ST_NOD_CD             */                     
                  ,   NVL(SCE.N2ND_NOD_CD, DTL.TO_NOD_CD)                N2ND_NOD_CD     /* LEA.N2ND_NOD_CD             */                     
                  ,   SCE.N3RD_NOD_CD                                    N3RD_NOD_CD     /* LEA.N3RD_NOD_CD             */ 
                  ,   SCE.N4TH_NOD_CD                                    N4TH_NOD_CD     /* LEA.N4TH_NOD_CD             */ 
          FROM        (SELECT    A.TRSP_SO_OFC_CTY_CD
                              ,  A.TRSP_SO_SEQ
                              ,  B.INV_NO
                              ,  B.INV_VNDR_SEQ
                              ,  A.VSL_CD
                              ,  A.SKD_VOY_NO
                              ,  A.SKD_DIR_CD
                              ,  A.FINC_SKD_DIR_CD
                              ,  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD
                              ,  A.BKG_NO
                              ,  A.EQ_NO
                              ,  A.EQ_TPSZ_CD
                              ,  A.COST_ACT_GRP_CD
                              ,  A.COST_ACT_GRP_SEQ
                              ,  A.COP_NO
                              ,  A.RAIL_CMB_THRU_TP_CD
                              ,  B.SUB_RAIL_SEQ
                              ,  B.VNDR_SEQ
                       FROM      TRS_TRSP_RAIL_BIL_ORD       A
                              ,  TRS_TRSP_RAIL_BIL_VNDR_SET  B                   
                       WHERE     A.TRSP_SO_OFC_CTY_CD        = B.TRSP_SO_OFC_CTY_CD
                       AND       A.TRSP_SO_SEQ               = B.TRSP_SO_SEQ
                       ) X
                  ,   TRS_TRSP_RAIL_INV_WRK        Y
                  ,   TRS_TRSP_RAIL_INV_DTL        DTL
                  ,   SCE_COST_ACT_GRP             SCE
                  ,   AP_INV_HDR                   AP
          WHERE       Y.INV_NO                     = DTL.INV_NO
          AND         Y.INV_VNDR_SEQ               = DTL.INV_VNDR_SEQ
          AND         DTL.PAY_FLG                  = 'Y'
          AND         DTL.TRSP_SO_OFC_CTY_CD       = X.TRSP_SO_OFC_CTY_CD(+)
          AND         DTL.TRSP_SO_SEQ              = X.TRSP_SO_SEQ       (+)
          AND         DTL.INV_NO                   = X.INV_NO            (+)
          AND         DTL.INV_VNDR_SEQ             = X.INV_VNDR_SEQ      (+)  
          AND         X.COP_NO                     = SCE.COP_NO          (+)   
          AND         X.COST_ACT_GRP_SEQ           = SCE.COST_ACT_GRP_SEQ(+)                   
          AND         (X.EQ_NO IS NOT NULL         OR DTL.EQ_NO IS NOT NULL)
          AND         Y.GL_DT                      IS NOT NULL
          AND         Y.INV_CURR_CD                IS NOT NULL     -- �߰� 2007-04-30
          AND         Y.CSR_NO                     = AP.CSR_NO                             
          AND         Y.CSR_NO                     = p_csr_no
          )
    ;
  
    RETURN 0;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN -1;
          DBMS_OUTPUT.PUT_LINE('%%SET_APRL_REQ_PROCESS_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
      WHEN OTHERS THEN
      	  RETURN -1;
      	  DBMS_OUTPUT.PUT_LINE('%%SET_APRL_REQ_PROCESS_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END SET_APRL_REQ_PROCESS_FNC;

 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAR 22, 2007
 # -- Table   : AP_INV_IF, LEA_ACT_COST_IF
 # -- Purpose : A/P Approval Request Success -->> LEA Data Input (Plus)
 #####################################################################*/
  FUNCTION SET_APRL_REQ_SUCCESS_FNC ( p_csr_no  VARCHAR2 )
  RETURN NUMBER  
  IS

  v_rtn_value    NUMBER ;
  
  BEGIN  

    v_rtn_value := SET_APRL_REQ_PROCESS_FNC(p_csr_no, 'SUCCESS');
  
    RETURN v_rtn_value;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN -1;
          DBMS_OUTPUT.PUT_LINE('%%SET_APRL_REQ_SUCCESS_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
      WHEN OTHERS THEN
      	  RETURN -1;
      	  DBMS_OUTPUT.PUT_LINE('%%SET_APRL_REQ_SUCCESS_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END SET_APRL_REQ_SUCCESS_FNC;
  
 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAR 22, 2007
 # -- Table   : AP_INV_IF, LEA_ACT_COST_IF
 # -- Purpose : A/P Approval Request Cancel -->> LEA Data Input (Minus)
 #####################################################################*/
  FUNCTION SET_APRL_CANCEL_FNC ( p_csr_no  VARCHAR2 )
  RETURN NUMBER  
  IS

  v_rtn_value    NUMBER ;
    
  BEGIN  

    v_rtn_value := SET_APRL_REQ_PROCESS_FNC(p_csr_no, 'CANCEL');
  
    RETURN v_rtn_value;
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN 
          RETURN -1;
          DBMS_OUTPUT.PUT_LINE('%%SET_APRL_CANCEL_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');
      WHEN OTHERS THEN
      	  RETURN -1;
      	  DBMS_OUTPUT.PUT_LINE('%%SET_APRL_CANCEL_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
  
  END SET_APRL_CANCEL_FNC;
  
END TRS_CSR_INTERFACE_TO_LEA_PKG;
/
