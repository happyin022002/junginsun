CREATE OR REPLACE PROCEDURE NISADM.TPB_RLBCK_ROC_REQ_PRC

/*********************************************************************************************************************************************************************
   1. Object Name      : TPB_RLBCK_TO_CANDI_PRC
   2. Version          : 1.0
   3. Create Date      : 2014.11.28
   4. Sub System       : Third Party Billing
   5. Author           : JS, AN
   6. Description      : APPROVAL ROC TPB ROLLBACK TO REQUESTED ROC STATUS
                        ---------------------------------------------------------------------------------------------------------------------------------------------
                        [TPB] Rollback Requested ROC 2 - 본사 처리용 : 2014년도 능동적 개선제언
                        [배경]
                        지역(본부) 담당자의 실수로 인해 TPB가 잘못처리되어 해당 TPB의 Status를 ROC requested상태로 요청하는 case
                        [작업내용]
                        ROC화면에서 SELCON user가 ROC request상태로 Status를 되돌리는 작업을 자동 처리하는 기능으로 Data 수작업을 제거함
                        [기능화면]
                        TPB Handling ESD_TPB_0106 화면 
                        [이벤트]
                        화면에서 해당 TPB 조회 후 체크할 때 ROCROLLBACK_ABLE='Y'이고 Log-in User의 Office가 SELCON이면 [RollbackROC]버튼 표시 활성화
                        [RollbackROC]버튼 기능
                        CALL PROCEDURE TPB_RLBCK_ROC_REQ_PRC(?,?,?) 호출
                        [DATA]
                        TPB_ADJ_STS 테이블에 ROC requested상태로 업데이트 & 처리 이력 삭제
                        TPB_ADJ_N2ND_RVW_HIS 테이블에 ROC Process Backward 처리이력 추가 
                        ----------------------------------------------------------------------------------------------------------------------------------------------
   7. Revision History : 2014.11.28  JS.AN  1.0  Created
**************************************************************************************************************************************************************************/

-- ===== Arguments ========================================================================================
(
     in_n3pty_no             IN VARCHAR2
    ,in_usr_ofc_cd           IN VARCHAR2
    ,in_usr_id               IN VARCHAR2
)

AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================================================================
     v_n3pty_no                 VARCHAR2(14);
     v_usr_ofc_cd               VARCHAR2(6);
     v_usr_id                   VARCHAR2(20);
  
     v_roc_bak_chk              VARCHAR2(1);  	
     v_stl_rqst_ofc_cd          VARCHAR2(6);
     v_stl_to_clt_cng_ofc_cd    VARCHAR2(6);
     v_curr_chk             VARCHAR2(1);
     
     

-- ===== BEGIN, EXCEPTION and END =========================================================================
BEGIN

-----------------------------------------------------------------------------------------------------------
--  0. Validation check : ROLLBACK ROC 처리 가능 여부
-----------------------------------------------------------------------------------------------------------

    --ROLLBACK ROC available   
    SELECT DECODE((SELECT ADJ_STS_SEQ
                   FROM TPB_ADJ_STS 
                   WHERE N3PTY_NO = in_n3pty_no 
                   AND STL_STS_LST_FLG = 'Y' 
                   AND N3PTY_STL_TP_CD = 'O' 
                   AND STL_APRO_OFC_CD = STL_TO_CLT_CNG_OFC_CD),1,'Y','N') AS ROCROLLBACK_FLAG into v_roc_bak_chk
    FROM DUAL;                    
    
    --check : ROC REQ-ststus & same currency
    SELECT STL_RQST_OFC_CD, STL_TO_CLT_CNG_OFC_CD
           ,CASE WHEN (SELECT COUNT(DISTINCT BIL_CURR_CD) FROM MDM_ORGANIZATION WHERE OFC_CD IN (STL_RQST_OFC_CD, STL_TO_CLT_CNG_OFC_CD)) > 1 THEN 'N' ELSE 'Y' END CURR_CHK 
      into v_stl_rqst_ofc_cd, v_stl_to_clt_cng_ofc_cd, v_curr_chk
    FROM   TPB_ADJ_STS
    WHERE  n3pty_no = in_n3pty_no   
    ;
    
    
    --ROLLBACK ROC OK!
    IF v_roc_bak_chk = 'Y' THEN ----------------------     
    
    
-----------------------------------------------------------------------------------------------------------
--  1. ROLLBACK  TPB_ADJ_STS  ----- Update  Current Outstanding Adjustment -----
-----------------------------------------------------------------------------------------------------------
         
        -- Return to Req. satatus  
        UPDATE TPB_ADJ_STS c   
           SET STL_APRO_OFC_CD = null, 
               STL_APRO_DT     = null,
               STL_APRO_USR_ID = null,
               STL_APRO_RMK    = null,
               UPD_USR_ID      = CRE_USR_ID,
               UPD_DT          = SYSDATE,
               STL_RQST_DT     = SYSDATE
         WHERE n3pty_no        = in_n3pty_no   
--           Active  Adjustment + Only R.O.C  
--           AND stl_sts_lst_flg = 'Y'  
--           AND n3pty_stl_tp_cd = 'O'  
--           AND ROWNUM = 1  
        ; 

-----------------------------------------------------------------------------------------------------------
--  2. ROLLBACK  TPB_OTS_DTL
-----------------------------------------------------------------------------------------------------------

          --backup TPB_OTS_DTL
          INSERT INTO TPB_OTS_DTL
                (OTS_DTL_SEQ
                ,N3PTY_NO
                ,N3PTY_NO_DP_SEQ
                ,N3PTY_BIL_TP_CD
                ,N3PTY_EXPN_TP_CD
                ,IF_RHQ_CD
                ,IF_OFC_CD
                ,OFC_CD
                ,N3PTY_SRC_SUB_SYS_CD
                ,N3PTY_SRC_NO
                ,SO_NO
                ,CSR_NO
                ,GL_DT
                ,VVD_CD
                ,TML_INV_TP_CD
                ,SRC_VNDR_CNT_CD
                ,SRC_VNDR_SEQ
                ,EAC_TP_CD
                ,BKG_NO
                ,BL_NO
                ,VSL_CD
                ,SKD_VOY_NO
                ,SKD_DIR_CD
                ,FINC_DIR_CD
                ,YD_CD
                ,FM_NOD_CD
                ,TO_NOD_CD
                ,VIA_NOD_CD
                ,DOR_NOD_CD
                ,EQ_TPSZ_CD
                ,EQ_NO
                ,VNDR_CUST_DIV_CD
                ,VNDR_CNT_CD
                ,VNDR_SEQ
                ,VNDR_LGL_ENG_NM
                ,CUST_CNT_CD
                ,CUST_SEQ
                ,CUST_LGL_ENG_NM
                ,N3PTY_OFC_CD
                ,IF_CURR_CD
                ,IF_AMT
                ,IF_RMK
                ,CFM_CURR_CD
                ,CFM_AMT
                ,CFM_RMK
                ,OTS_AMT
                ,INV_AMT
                ,CLT_AMT
                ,ADJ_AMT
                ,BAL_AMT
                ,REV_AMT
                ,ACCT_CD
                ,N3PTY_DELT_TP_CD
                ,LGS_COST_CD
                ,LGS_COST_CD_SEQ
                ,FILE_NO
                ,COST_EXPT_FLG
                ,CFM_DT
                ,ESTM_SEQ_NO
                ,ESTM_RVIS_NO
                ,ESTM_DTL_SEQ_NO
                ,N3PTY_NON_CFM_RSN_CD
                ,N3PTY_IF_TP_CD
                ,IF_USR_ID
                ,IF_DT
                ,N3PTY_CFM_CD
                ,CFM_OFC_CD
                ,CFM_USR_ID
                ,FM_CLT_CNG_OFC_N3PTY_NO
                ,RVW_OFC_CD
                ,RVW_USR_ID
                ,RVW_DT
                ,ESTM_SYS_AREA_GRP_ID
                ,SRC_IF_SEQ_NO
                ,MNL_INP_TP_CD
                ,EQ_KND_CD
                ,CXL_FLG
                ,CRE_USR_ID
                ,CRE_DT
                ,UPD_USR_ID
                ,UPD_DT
                ,COST_OFC_CD
                ,CSR_NO_CXL_FLG
                ,BKG_IO_BND_CD
                ,ACT_ATD_INP_DT
                ,TML_NM
                ,ACCT_NM
                ,SO_DTL_SEQ
                ,PSO_IF_SEQ)                
          SELECT TPB_OTS_DTL_SEQ1.NEXTVAL OTS_DTL_SEQ
                ,REPLACE(N3PTY_NO,'TPB','RCK') N3PTY_NO
                ,N3PTY_NO_DP_SEQ
                ,N3PTY_BIL_TP_CD
                ,N3PTY_EXPN_TP_CD
                ,IF_RHQ_CD
                ,IF_OFC_CD
                ,OFC_CD
                ,N3PTY_SRC_SUB_SYS_CD
                ,N3PTY_SRC_NO
                ,SO_NO
                ,CSR_NO
                ,GL_DT
                ,VVD_CD
                ,TML_INV_TP_CD
                ,SRC_VNDR_CNT_CD
                ,SRC_VNDR_SEQ
                ,EAC_TP_CD
                ,BKG_NO
                ,BL_NO
                ,VSL_CD
                ,SKD_VOY_NO
                ,SKD_DIR_CD
                ,FINC_DIR_CD
                ,YD_CD
                ,FM_NOD_CD
                ,TO_NOD_CD
                ,VIA_NOD_CD
                ,DOR_NOD_CD
                ,EQ_TPSZ_CD
                ,EQ_NO
                ,VNDR_CUST_DIV_CD
                ,VNDR_CNT_CD
                ,VNDR_SEQ
                ,VNDR_LGL_ENG_NM
                ,CUST_CNT_CD
                ,CUST_SEQ
                ,CUST_LGL_ENG_NM
                ,N3PTY_OFC_CD
                ,IF_CURR_CD
                ,IF_AMT
                ,IF_RMK
                ,CFM_CURR_CD
                ,CFM_AMT
                ,CFM_RMK
                ,OTS_AMT
                ,INV_AMT
                ,CLT_AMT
                ,ADJ_AMT
                ,BAL_AMT
                ,REV_AMT
                ,ACCT_CD
                ,N3PTY_DELT_TP_CD
                ,LGS_COST_CD
                ,LGS_COST_CD_SEQ
                ,FILE_NO
                ,COST_EXPT_FLG
                ,CFM_DT
                ,ESTM_SEQ_NO
                ,ESTM_RVIS_NO
                ,ESTM_DTL_SEQ_NO
                ,N3PTY_NON_CFM_RSN_CD
                ,N3PTY_IF_TP_CD
                ,IF_USR_ID
                ,IF_DT
                ,N3PTY_CFM_CD
                ,CFM_OFC_CD
                ,CFM_USR_ID
                ,FM_CLT_CNG_OFC_N3PTY_NO
                ,RVW_OFC_CD
                ,RVW_USR_ID
                ,RVW_DT
                ,ESTM_SYS_AREA_GRP_ID
                ,SRC_IF_SEQ_NO
                ,MNL_INP_TP_CD
                ,EQ_KND_CD
                ,CXL_FLG
                ,CRE_USR_ID
                ,CRE_DT
                ,UPD_USR_ID
                ,UPD_DT
                ,COST_OFC_CD
                ,CSR_NO_CXL_FLG
                ,BKG_IO_BND_CD
                ,ACT_ATD_INP_DT
                ,TML_NM
                ,ACCT_NM
                ,SO_DTL_SEQ
                ,PSO_IF_SEQ                
            FROM TPB_OTS_DTL
           WHERE n3pty_no = in_n3pty_no ;
          

          --same currency 
          IF v_curr_chk = 'Y' THEN     
            
                      
                    UPDATE TPB_OTS_DTL A  
                       SET OFC_CD = v_stl_rqst_ofc_cd,
                           UPD_USR_ID = CRE_USR_ID,
            	           UPD_DT = SYSDATE
                     WHERE n3pty_no = in_n3pty_no   
                    ; 
               
          --each other currency          
          ELSE                             
                    
                    UPDATE TPB_OTS_DTL A  
                       SET ofc_cd = v_stl_rqst_ofc_cd,  
                           cfm_curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'),  
                           cfm_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                           ots_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                           bal_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                           rev_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt) 
                                   - TPB_GET_INV_CURR_CHG_ROC_FNC(A.if_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'), A.if_amt, A.cfm_dt),  
                           adj_amt = NULL,
                           UPD_USR_ID = CRE_USR_ID,
            	           UPD_DT = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ;         
              
          END IF;        


-----------------------------------------------------------------------------------------------------------
--  3. ROLLBACK  TPB_OTS_DTL_STS
-----------------------------------------------------------------------------------------------------------

         --delete detail status : Req-To status 
         DELETE FROM TPB_OTS_DTL_STS 
         WHERE OTS_DTL_SEQ  IN  (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no) 
         AND OTS_DTL_STS_SEQ >  (SELECT MAX(OTS_DTL_STS_SEQ) 
                                 FROM  TPB_OTS_DTL_STS 
                                 WHERE OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no)
                                 AND  OTS_STS_CD = 'E' );
                                 
         --update detail status : last status flag of Req-from Office 
         UPDATE TPB_OTS_DTL_STS
         SET    OTS_STS_LST_FLG = 'Y'
               ,UPD_DT = SYSDATE 
         WHERE  OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no)   
         AND    OTS_STS_CD   = 'E'
         AND OTS_DTL_STS_SEQ = (SELECT MAX(OTS_DTL_STS_SEQ) 
                                FROM  TPB_OTS_DTL_STS 
                                WHERE OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no)
                                AND  OTS_STS_CD = 'E' );


-----------------------------------------------------------------------------------------------------------
--  4. ROLLBACK  TPB_OTS_DTL_RCVR_ACT
-----------------------------------------------------------------------------------------------------------

        --delete detail recovery activity : Req-To Office 
        DELETE FROM TPB_OTS_DTL_RCVR_ACT 
        WHERE OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no) 
        AND RCVR_ACT_CRE_OFC_CD = v_stl_to_clt_cng_ofc_cd;
        
        --update detail recovery activity : last update of Req-from Office 
        UPDATE TPB_OTS_DTL_RCVR_ACT
        SET    UPD_DT = SYSDATE 
        WHERE  OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no)
        AND    OTS_DTL_SEQ = (SELECT MAX(OTS_DTL_SEQ)
                                      FROM   TPB_OTS_DTL 
                                      WHERE  OTS_DTL_SEQ IN (SELECT OTS_DTL_SEQ FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no) 
                                      AND    RCVR_ACT_CRE_OFC_CD = v_stl_rqst_ofc_cd);


-----------------------------------------------------------------------------------------------------------
--  5. ROLLBACK  TPB_OTS_GRP  ----- Update Outstanding Group -----
-----------------------------------------------------------------------------------------------------------

          --same currency 
          IF v_curr_chk = 'Y' THEN     
            
                      
                    UPDATE TPB_OTS_GRP A  
                       SET OFC_CD = v_stl_rqst_ofc_cd,
                       	   OTS_STS_CD = 'R',
                       	   OTS_STS_DTL_CD = 'R5',
                           UPD_USR_ID = CRE_USR_ID,
            	           UPD_DT = SYSDATE
                     WHERE n3pty_no = in_n3pty_no   
                    ; 
               
          --each other currency          
          ELSE                             
                    
                    UPDATE TPB_OTS_GRP A  
                       SET ofc_cd = v_stl_rqst_ofc_cd,  
                           curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_stl_rqst_ofc_cd),'USD'),  
                           ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),
                           OTS_STS_CD = 'R',
                       	   OTS_STS_DTL_CD = 'R5',
                           UPD_USR_ID = CRE_USR_ID,
            	           UPD_DT = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ;         
              
          END IF;              
                                                
-----------------------------------------------------------------------------------------------------------
--  6. ROLLBACK  TPB_OTS_GRP_STS
-----------------------------------------------------------------------------------------------------------

         --delete group status : Req-To Office 
         DELETE FROM TPB_OTS_GRP_STS 
         WHERE N3PTY_NO = in_n3pty_no 
         AND OTS_STS_SEQ > (SELECT MAX(OTS_STS_SEQ) 
                            FROM   TPB_OTS_GRP_STS 
                            WHERE  N3PTY_NO = in_n3pty_no 
                            AND    OTS_STS_CD='R')
         ;                                           
         
         --update group status : last status flag of Req-from Office 
         UPDATE TPB_OTS_GRP_STS
         SET    OTS_STS_LST_FLG = 'Y' 
               ,UPD_USR_ID = CRE_USR_ID
               ,UPD_DT = SYSDATE
         WHERE N3PTY_NO = in_n3pty_no 
         AND   OTS_STS_CD='R' ;


-----------------------------------------------------------------------------------------------------------
--  7. ROLLBACK  TPB_OTS_GRP_RCVR_ACT
-----------------------------------------------------------------------------------------------------------

         --delete group recovery activity : Req-To Office 
         DELETE FROM TPB_OTS_GRP_RCVR_ACT 
         WHERE N3PTY_NO = in_n3pty_no 
         AND CLT_ACT_CRE_OFC_CD = v_stl_to_clt_cng_ofc_cd
         ;

         --update group recovery activity : last update of Req-from Office 
         UPDATE TPB_OTS_GRP_RCVR_ACT 
         SET UPD_DT = SYSDATE
         WHERE N3PTY_NO = in_n3pty_no 
         AND OTS_GRP_RCVR_ACT_SEQ = (SELECT MAX(OTS_GRP_RCVR_ACT_SEQ) 
                                     FROM TPB_OTS_GRP_RCVR_ACT
                                     WHERE N3PTY_NO = in_n3pty_no 
                                     AND CLT_ACT_CRE_OFC_CD = v_stl_rqst_ofc_cd)
         ;                            


    
    END IF; ------------------------------------------- 
    
    
    
--EXCEPTION
--    WHEN OTHERS THEN
--        v_n3pty_no := NULL;
--        v_ots_dtl_seq := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  

END

-- ===== End of Procedure ==================================
;