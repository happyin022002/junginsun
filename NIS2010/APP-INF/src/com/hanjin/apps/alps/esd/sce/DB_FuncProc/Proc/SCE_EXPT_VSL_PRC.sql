CREATE OR REPLACE PROCEDURE SCE_EXPT_VSL_PRC
(
       IN_COP_NO              IN  VARCHAR2
      --,IN_COP_GRP_SEQ         IN  VARCHAR2
      ,IN_COP_DTL_SEQ         IN  VARCHAR2
      ,IN_ESTM_GAP            IN  NUMBER
      ,IN_ACT_DT              IN  VARCHAR2 
)
authid current_user 
IS
/****************************************************************************************************************************
   Name     :   SCE_EXPT_VSL_PRC (2008년도 COP Exception:2008/04~2008/05)
   Purpose  :   Estimated Vessel Schedule Delay Exception 판별
                (ETA/ETB/ETD 재 Update 시, Update전 Date/Time과 비교 Tolerance 초과시 Vessel Estimate Delay Exception 판별)
   Ver      :   1.0
   Author   :   JSAN
   Date     :   2008.04.28
   Related  :   1.SCE_EST_RCV_VSL_PRC
   Update   :   2008.05.22 JSAN. New Exception Code 체계 적용 및 재차 수신 Actual 적용 및 보완
                2008.06.16 JSAN. 같은 COP Detail에 기발생건이 있다면 무조건 'R'+Update, Notification Email이 없는 경우 SKIP
                2008.08.21 JSAN. Container Attach된 COP만 Exception 대상으로 판별하도록 수정
                2008.11.06 JSAN. Booking Customer 관리 포인트 변경에 따른 참조 테이블 변경(SCE_COP_HDR-->BKG_BKG_CUST)
****************************************************************************************************************************/
CURSOR CHK_OCCR_EXPT(p_cop_no      VARCHAR2
                    --,p_cop_grp_seq VARCHAR2
                    ,p_cop_dtl_seq VARCHAR2)IS
SELECT M.COP_EXPT_STS_CD, D.ACT_DT
FROM   SCE_EXPT_MST M, SCE_COP_DTL D
WHERE  D.COP_NO      = p_cop_no
--AND    D.COP_GRP_SEQ = p_cop_grp_seq
AND    D.COP_DTL_SEQ = p_cop_dtl_seq 
AND    M.COP_NO      = D.COP_NO
;    

CURSOR SEARCH_VPS_EXPT_INFO(P_COP_NO          VARCHAR2
                           --,P_COP_GRP_SEQ      VARCHAR2
                           ,P_COP_DTL_SEQ      VARCHAR2
                           ,P_ESTM_GAP         NUMBER) IS
SELECT   --Activity
          B.COP_NO, B.COP_DTL_SEQ, B.ACT_CD, B.NOD_CD, B.ACT_DT
         ,B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.VPS_PORT_CD, B.ACT_STS_MAPG_CD, B.CLPT_IND_SEQ
         ,B.FM_ACT_CD, B.FM_ESTM_DT, B.FM_ACT_DT, B.FM_UPD_DT
         --EXPT
         ,B.OCCR_DT
         --,A.Activity,NUMTODSINTERVAL((A.OCCR_DT-A.TO_ACT_DT),'DAY') GAP
         ,B.GAP
         --,B.COP_EXPT_TP_CD, B.COP_EXPT_TP_DTL_CD
         ,B.EXPT_TP_CD, B.EXPT_TP_DTL_CD, B.FM_EXPT_CD
         ,B.TOL,B.SYS_DT
         --HDR:BKG INFO
         ,B.BKG_NO,B.CNTR_NO,B.RCV_TERM_CD,B.DE_TERM_CD,B.SHPR_CNT_CD
         ,B.SHPR_SEQ,B.CNEE_CNT_CD,B.CNEE_SEQ,B.NTFY_CNT_CD,B.NTFY_SEQ,B.POR_CD,B.POL_CD
         ,B.POD_CD,B.DEL_CD,B.TRNK_VVD_CD,B.LODG_PORT_CD,B.LST_BKG_DT,B.BL_MST_NO,B.SC_NO,B.BKG_OFC_CD
FROM   ( SELECT       --Activity
                      A.COP_NO, A.COP_DTL_SEQ, A.ACT_CD, A.NOD_CD, A.ACT_DT
                     ,A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD, A.ACT_STS_MAPG_CD, A.CLPT_IND_SEQ
                     ,A.FM_ACT_CD, A.FM_ESTM_DT, A.FM_ACT_DT, A.FM_UPD_DT
                     --EXPT
                     ,A.OCCR_DT
                     --,A.Activity,NUMTODSINTERVAL((A.OCCR_DT-A.TO_ACT_DT),'DAY') GAP
                     ,NUMTODSINTERVAL(P_ESTM_GAP ,'DAY') GAP
                     --,A.COP_EXPT_TP_CD, A.COP_EXPT_TP_DTL_CD
                     ,A.EXPT_TP_CD, A.EXPT_TP_DTL_CD, A.FM_EXPT_CD
                     ,NUMTODSINTERVAL(SCE_EXPT_TOL_ACT_CAL_FNC(A.ACTIVITY, A.NOD_CD, A.COP_NO, A.EXPT_TP_CD) ,'MINUTE') TOL
                     ,SYSDATE SYS_DT
                     --HDR:BKG INFO
                     ,A.BKG_NO,A.CNTR_NO,A.RCV_TERM_CD,A.DE_TERM_CD,A.SHPR_CNT_CD
                     ,A.SHPR_SEQ,A.CNEE_CNT_CD,A.CNEE_SEQ,A.NTFY_CNT_CD,A.NTFY_SEQ,A.POR_CD,A.POL_CD
                     ,A.POD_CD,A.DEL_CD,A.TRNK_VVD_CD,A.LODG_PORT_CD,A.LST_BKG_DT,A.BL_MST_NO,A.SC_NO,A.BKG_OFC_CD
        FROM (  SELECT 
                     --Activity:
                      FD.COP_NO, FD.COP_DTL_SEQ, FD.ACT_CD, FD.NOD_CD, FD.ACT_DT
                     ,GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(FD.NOD_CD,1,5)) OCCR_DT
                     ,FD.VSL_CD, FD.SKD_VOY_NO, FD.SKD_DIR_CD, FD.VPS_PORT_CD, FD.ACT_STS_MAPG_CD, FD.CLPT_IND_SEQ
                     ,FD.ACT_CD FM_ACT_CD, FD.ESTM_DT FM_ESTM_DT, FD.ACT_DT FM_ACT_DT, FD.UPD_DT FM_UPD_DT
                     --EXPT
                     ,FD.ACT_CD Activity
                     --,T.COP_EXPT_TP_CD,T.COP_EXPT_TP_DTL_CD
                     ,FMA.EXPT_TP_CD, FMA.EXPT_TP_DTL_CD, FMA.FM_EXPT_CD
                     --HDR:BKG INFO
                     ,H.BKG_NO,H.CNTR_NO,BB.RCV_TERM_CD,BB.DE_TERM_CD
                     ----,H.SHPR_CNT_CD,H.SHPR_SEQ,H.CNEE_CNT_CD,H.CNEE_SEQ,H.NTFY_CNT_CD,H.NTFY_SEQ                                --20081105
                     ,SBC.CUST_CNT_CD SHPR_CNT_CD, SBC.CUST_SEQ SHPR_SEQ, CBC.CUST_CNT_CD CNEE_CNT_CD, CBC.CUST_SEQ CNEE_SEQ        --20081105
                     ,NBC.CUST_CNT_CD NTFY_CNT_CD, NBC.CUST_SEQ NTFY_SEQ                                                            --20081105                      
                     ,BB.POR_CD,BB.POL_CD,BB.POD_CD,BB.DEL_CD
                     ,(H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD) TRNK_VVD_CD
                     ,BB.POL_CD LODG_PORT_CD,BB.BKG_CRE_DT LST_BKG_DT,BB.BL_NO BL_MST_NO, BB.SC_NO, BB.BKG_OFC_CD
                FROM  (SELECT SUBSTR(FMP.EXPT_CD,1,1) EXPT_TP_CD, SUBSTR(FMP.EXPT_CD,1,3) EXPT_TP_DTL_CD
                        ,SUBSTR(FMP.EXPT_CD,5,2) FM_ACT_EXPT_CD, FMP.EXPT_CD FM_EXPT_CD 
                        ,FMP.EXPT_CD_NM FM_ACT_CD, FMP.EXPT_CD_DESC FM_ACT_NM
                        FROM   SCE_EXPT_CD FMP
                        WHERE  FMP.EXPT_CD NOT LIKE '%00000'
                        AND    SUBSTR(FMP.EXPT_CD,4,1) = '1' AND FMP.ACT_FLG = 'Y' ) FMA
                ,  SCE_COP_DTL FD, SCE_COP_HDR H, BKG_BOOKING BB
                ,BKG_CUSTOMER SBC, BKG_CUSTOMER CBC, BKG_CUSTOMER NBC                                                          --20081105                
                WHERE FMA.EXPT_TP_CD   =  '2'   
                AND   FD.ACT_CD        =  FMA.FM_ACT_CD
                AND   FD.COP_NO        =  P_COP_NO
                --AND   FD.COP_GRP_SEQ   =  P_COP_GRP_SEQ
                AND   FD.COP_DTL_SEQ   =  P_COP_DTL_SEQ
--                AND   NVL(FD.COP_EXPT_FLG,'N')  =  'N'
                AND   H.COP_NO         =  FD.COP_NO
                AND   H.COP_STS_CD     IN ('C','T')
                AND   H.CNTR_NO        <> 'HJCU0000000'
                AND   BB.BKG_NO        =  H.BKG_NO
                --AND   BB.BKG_NO_SPLIT  =  H.BKG_NO_SPLIT
                    AND   SBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   SBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   SBC.BKG_CUST_TP_CD(+) =  'S'                                                                              --20081105
                    AND   CBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   CBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   CBC.BKG_CUST_TP_CD(+) =  'C'                                                                              --20081105
                    AND   NBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   NBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   NBC.BKG_CUST_TP_CD(+) =  'N'                                                                              --20081105 
                  ) A  ) B
WHERE B.GAP > B.TOL ;

CURSOR SEARCH_EXPT_NOTI_INFO (p_eq_ctrl_ofc_cd      VARCHAR2
                             ,p_fm_expt_cd          VARCHAR2
                             ,p_bkg_cre_ofc_cd      VARCHAR2
                             ,p_por_cd              VARCHAR2
                             ,p_pol_cd              VARCHAR2
                             ,p_pod_cd              VARCHAR2
                             ,p_del_cd              VARCHAR2
                             ,p_expt_no             VARCHAR2)IS
SELECT NTFD_SUBSC_ID 
      ,NTFD_SUBSC_NM 
      ,NTFD_SUBSC_USR_EML 
      ,ACT_FLG
      ,COP_EXPT_SUBSC_GRP_CD
      ,SUBSC_GRP_NTFD_PTY_CD
      ,NTFD_OFC_CD
      ,CTRL_OFC_CD
      ,COP_EXPT_SUBSC_CS_SEQ   
FROM SCE_EXPT_SUBSC_MST
WHERE (NTFD_OFC_CD,COP_EXPT_SUBSC_GRP_CD) IN 
(SELECT (CASE WHEN G.SUBSC_GRP_NTFD_PTY_CD = '1' THEN p_bkg_cre_ofc_cd
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '2' THEN (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = p_por_cd)
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '3' THEN (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = p_pol_cd)
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '4' THEN (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = p_pod_cd)
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '5' THEN (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = p_del_cd)
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '6' THEN p_eq_ctrl_ofc_cd
             WHEN G.SUBSC_GRP_NTFD_PTY_CD = '7' THEN 'PHXSC' END) NTFD_OFC_CD
       ,COP_EXPT_SUBSC_GRP_CD      
FROM   SCE_EXPT_SUBSC_MST_GRP G
WHERE  G.EXPT_CD    = p_fm_expt_cd
AND    G.COP_EXPT_SUBSC_GRP_CD IN (SELECT COP_EXPT_SUBSC_GRP_CD      
                                   FROM   SCE_EXPT_SUBSC_MST
                                   WHERE  NTFD_OFC_CD = p_eq_ctrl_ofc_cd
                                   AND    CTRL_OFC_CD IS NULL
                                   AND    ACT_FLG     = 'Y'
                                   GROUP BY COP_EXPT_SUBSC_GRP_CD)
AND    G.ACT_FLG               = 'Y'
UNION 
SELECT distinct m.NTFD_OFC_CD, m.COP_EXPT_SUBSC_GRP_CD
FROM  SCE_EXPT_SUBSC_MST m, SCE_EXPT_SUBSC_MST_GRP g
WHERE m.NTFD_OFC_CD IN (SELECT CTRL_OFC_CD
                      FROM   SCE_EXPT_SUBSC_MST 
                      WHERE  NTFD_OFC_CD = p_eq_ctrl_ofc_cd
                      AND    CTRL_OFC_CD IS NOT NULL
                      AND    ACT_FLG     = 'Y')
AND   m.ACT_FLG     = 'Y'
and m.COP_EXPT_SUBSC_GRP_CD = g.COP_EXPT_SUBSC_GRP_CD
and g.expt_cd = p_expt_no
and g.ACT_FLG     = 'Y' )
AND   ACT_FLG     = 'Y'
AND   NTFD_SUBSC_USR_EML IS NOT NULL;
                           

v_err_cd              VARCHAR2(10) := '000000';
v_err_cd_1            VARCHAR2(02) := '00';
v_err_cd_2            VARCHAR2(02) := '00';
v_message             VARCHAR2(500);


--out_result_cd         VARCHAR2(500);
V_EQ_CTRL_OFC_CD      VARCHAR2(6);
v_insert_row_1        NUMBER;
v_insert_row_2        NUMBER;
v_cnt                 NUMBER(5) :=0;
v_cnt2                NUMBER(5) :=0;
v_cop_expt_no         VARCHAR2(14);
v_ctr_ofc_cnt         NUMBER(5) :=0;
v_chk_expt            VARCHAR2(2);
v_chk_act             VARCHAR2(1);
v_update_row          NUMBER;
v_ntfd_flg            VARCHAR2(1):='N';
v_upd_flg             VARCHAR2(1):='N';


BEGIN
       --DBMS_OUTPUT.ENABLE;
       DBMS_OUTPUT.DISABLE;

       --Resolved대상 아님.
       v_chk_expt := 'R0';
       
       
       /* Check Occurred Exception */
       FOR CHK_EXPT IN  CHK_OCCR_EXPT(in_cop_no,in_cop_dtl_seq)
       --FOR CHK_EXPT IN  CHK_OCCR_EXPT(in_cop_no,in_cop_grp_seq,in_cop_dtl_seq)
            LOOP
                --기발생 Exception체크
                IF(CHK_EXPT.COP_EXPT_STS_CD='O') THEN
                    --Resolved 처리 
                    v_chk_expt := 'R1'; 
                ELSIF(CHK_EXPT.COP_EXPT_STS_CD='R') THEN             
                    --Resolved 재처리
                    v_chk_expt := 'R2'; 
                END IF;
                
                
                --Actual 재수신 여부 체크
                IF(CHK_EXPT.ACT_DT IS NULL) THEN
                    --Actual 최초 수신
                    v_chk_act := '1';
                ELSE
                    --Actual 재수신 
                    v_chk_act := '2';
                END IF;        
            
       END LOOP;
       
        v_upd_flg := 'N';
        
        --기발생 Exception Resolve처리
        IF(v_chk_expt = 'R1' OR v_chk_expt = 'R2') THEN 
        
                
            /* ACTUAL DATA의 DTL보다 작은 값 EXPT RESOLVE */
            
            UPDATE SCE_EXPT_MST
            SET    COP_EXPT_STS_CD = 'R'
                  ,EXPT_CLR_TP_CD  = '2'
                  ,EXPT_RSOLV_DT   = SYSDATE
                  ,UPD_USR_ID      = 'EXPT_VPS'
                  ,UPD_DT          = SYSDATE
            WHERE  COP_NO          = in_cop_no
            AND    TRIM(TO_CHAR(COP_DTL_SEQ,'0000')) < TRIM(TO_CHAR(in_cop_dtl_seq,'0000'))     
            --AND    TRIM(TO_CHAR(COP_GRP_SEQ,'0000')) || TRIM(TO_CHAR(COP_DTL_SEQ,'0000')) < TRIM(TO_CHAR(in_cop_grp_seq,'0000')) || TRIM(TO_CHAR(in_cop_dtl_seq,'0000'))     
            AND    COP_EXPT_STS_CD = 'O';
            
            v_update_row := SQL%ROWCOUNT;
            
            DBMS_OUTPUT.PUT_LINE('기발생 Exception:'||v_chk_expt||'  이전 EXPT RESOLVE 처리건수 : '|| V_UPDATE_ROW||']');
            
            commit;
            
            
            /* 기 발생 건의 업데이트 */           
            UPDATE SCE_EXPT_MST
            SET COP_EXPT_STS_CD = 'R'
               ,EXPT_CLR_TP_CD  = '1' 
               ,EXPT_RSOLV_DT   = SYSDATE
               ,TO_ACT_CD       = FM_ACT_CD
               ,TO_ESTM_DT      = TO_DATE(IN_ACT_DT,'YYYY/MM/DD HH24:MI:SS')
               ,TO_UPD_DT       = SYSDATE
               ,upd_usr_id      = 'EXPT_VPS'
               ,upd_dt          = SYSDATE
            WHERE  COP_NO      = in_cop_no
            --AND    COP_GRP_SEQ = in_cop_grp_seq
            AND    COP_DTL_SEQ = in_cop_dtl_seq
            AND    COP_EXPT_STS_CD IN ('O','R');
                      
                      
            DBMS_OUTPUT.PUT_LINE('현재 EXPT RESOLVE 처리건수 : '|| SQL%ROWCOUNT||']');
            
            if SQL%ROWCOUNT > 0 then
                commit;
                v_upd_flg := 'Y';
            end if;            
    
        
        END IF;
    

       IF v_upd_flg = 'N' THEN 
       
       /* Actual Delay Exception 등록 대상 */
       FOR CUR_EXPT IN  SEARCH_VPS_EXPT_INFO(IN_COP_NO,IN_COP_DTL_SEQ,IN_ESTM_GAP)
       --FOR CUR_EXPT IN  SEARCH_VPS_EXPT_INFO(IN_COP_NO,IN_COP_GRP_SEQ,IN_COP_DTL_SEQ,IN_ESTM_GAP)
            LOOP



                        DBMS_OUTPUT.PUT_LINE('Exception대상 체크 OK');

                       /* Get ExceptonNO */
                       SELECT 'E'|| SUBSTR(CUR_EXPT.NOD_CD,3,3) || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) 
                              || (CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'          
                                       ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1) END )
                              || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) || TRIM(TO_CHAR(SCE_COP_EXPT_SEQ1.NEXTVAL,'000000')) EXPT_NO INTO V_COP_EXPT_NO  
                       FROM DUAL;
                       
                       /* Get ControlOffice */
                       --V_EQ_CTRL_OFC_CD := 'XXXXXX';
                       SELECT NVL((select EQ_CTRL_OFC_CD from mdm_location where LOC_CD = SUBSTR(CUR_EXPT.NOD_CD,1,5) ),' ') INTO V_EQ_CTRL_OFC_CD 
                       FROM DUAL;
                       
                    
                       /* EXCEPTION 생성 */
                       INSERT INTO SCE_EXPT_MST 
                                    (COP_EXPT_NO
                                    ,COP_EXPT_TP_CD
                                    ,COP_EXPT_TP_DTL_CD
                                    ,EXPT_CD
                                    ,OCCR_DT
                                    ,OCCR_NOD_CD
                                    ,CRE_OFC_CD
                                    ,CRE_USR_ID
                                    ,CRE_DT
                                    ,UPD_OFC_CD
                                    ,UPD_USR_ID
                                    ,UPD_DT
                                    ,COP_EXPT_STS_CD
                                    ,VSL_CD
                                    ,SKD_VOY_NO
                                    ,SKD_DIR_CD
                                    ,VPS_PORT_CD
                                    ,ACT_STS_MAPG_CD
                                    ,CLPT_IND_SEQ
                                    ,EXPT_RSOLV_DT
                                    ,EXPT_CLR_TP_CD
                                    ,COP_EXPT_RSN_CD
                                    ,COP_EXPT_CFM_FLG
                                    ,COP_EXPT_CFM_USR_ID
                                    ,COP_EXPT_CFM_DT
                                    ,COP_NO
                                    --,COP_GRP_SEQ
                                    ,COP_DTL_SEQ
                                    ,BKG_NO
                                    --,BKG_NO_SPLIT
                                    ,CNTR_NO
                                    ,BKG_RCV_TERM_CD
                                    ,BKG_DE_TERM_CD
                                    ,SHPR_CNT_CD
                                    ,SHPR_SEQ
                                    ,CNEE_CNT_CD
                                    ,CNEE_SEQ
                                    ,NTFY_CNT_CD
                                    ,NTFY_SEQ
                                    ,POR_CD
                                    ,POL_CD
                                    ,POD_CD
                                    ,DEL_CD
                                    ,TRNK_VVD_CD
                                    ,LODG_PORT_CD
                                    ,LST_BKG_DT
                                    ,FM_ACT_CD
                                    ,FM_ESTM_DT
                                    ,FM_ACT_DT
                                    ,FM_UPD_DT
                                    ,TO_ACT_CD
                                    ,TO_ESTM_DT
                                    ,TO_ACT_DT
                                    ,TO_UPD_DT
                                    ,MST_BL_NO
                                    --,BL_MST_NO
                                    ,SC_NO)       
                       VALUES (V_COP_EXPT_NO
                             ,CUR_EXPT.EXPT_TP_CD
                             ,CUR_EXPT.EXPT_TP_DTL_CD
                             ,CUR_EXPT.FM_EXPT_CD
                             ,CUR_EXPT.OCCR_DT
                             ,CUR_EXPT.NOD_CD
                             ,V_EQ_CTRL_OFC_CD
                             ,'EXPT_VPS'
                             ,CUR_EXPT.SYS_DT
                             --,''
                             --,''
                             --,''
                             ,V_EQ_CTRL_OFC_CD
                             ,'EXPT_VPS'
                             ,CUR_EXPT.SYS_DT
                             ,'O'
                             ,CUR_EXPT.VSL_CD
                             ,CUR_EXPT.SKD_VOY_NO
                             ,CUR_EXPT.SKD_DIR_CD
                             ,CUR_EXPT.VPS_PORT_CD
                             ,CUR_EXPT.ACT_STS_MAPG_CD
                             ,CUR_EXPT.CLPT_IND_SEQ
                             ,''
                             ,''
                             ,''
                             ,''
                             ,''
                             ,''
                             ,CUR_EXPT.COP_NO
                             --,CUR_EXPT.COP_GRP_SEQ
                             ,CUR_EXPT.COP_DTL_SEQ
                             ,CUR_EXPT.BKG_NO
                             --,CUR_EXPT.BKG_NO_SPLIT
                             ,CUR_EXPT.CNTR_NO
                             ,CUR_EXPT.RCV_TERM_CD
                             ,CUR_EXPT.DE_TERM_CD
                            -- ,CUR_EXPT.BKG_RCV_TERM_CD
                            -- ,CUR_EXPT.BKG_DE_TERM_CD
                             ,CUR_EXPT.SHPR_CNT_CD
                             ,CUR_EXPT.SHPR_SEQ
                             ,CUR_EXPT.CNEE_CNT_CD
                             ,CUR_EXPT.CNEE_SEQ
                             ,CUR_EXPT.NTFY_CNT_CD
                             ,CUR_EXPT.NTFY_SEQ
                             ,CUR_EXPT.POR_CD
                             ,CUR_EXPT.POL_CD
                             ,CUR_EXPT.POD_CD
                             ,CUR_EXPT.DEL_CD
                             ,CUR_EXPT.TRNK_VVD_CD
                             ,CUR_EXPT.LODG_PORT_CD
                             ,CUR_EXPT.LST_BKG_DT
                             ,CUR_EXPT.FM_ACT_CD
                             ,CUR_EXPT.FM_ESTM_DT
                             ,CUR_EXPT.FM_ACT_DT
                             ,CUR_EXPT.FM_UPD_DT
                             ,CUR_EXPT.FM_ACT_CD
                             ,TO_DATE(IN_ACT_DT,'YYYY/MM/DD HH24:MI:SS')
                             ,''
                             ,SYSDATE
                             ,CUR_EXPT.BL_MST_NO
                             ,CUR_EXPT.SC_NO
                             );
                             
                             
                       v_insert_row_1 := SQL%ROWCOUNT;
                
                       IF v_insert_row_1 = 0  THEN
                              v_message    := 'EXCEPTION 등록건이 없습니다.';
                              v_err_cd_1   := '02';
                       ELSE
                              v_cnt := v_cnt + 1;     
                              COMMIT;
                              
                              UPDATE SCE_COP_DTL
                              SET   COP_EXPT_FLG =  'Y'
                              WHERE COP_NO       = CUR_EXPT.COP_NO
                              --AND   COP_GRP_SEQ  = CUR_EXPT.COP_GRP_SEQ
                              AND   COP_DTL_SEQ  = CUR_EXPT.COP_DTL_SEQ;
                              COMMIT;
                              
                              
                              /* Notification Subscriber 등록 */
                              IF V_EQ_CTRL_OFC_CD <> ' ' THEN
                              
                                    v_ctr_ofc_cnt := 0; 
                                    v_ntfd_flg    :='N';
                                   
                                   /* Notification Office 찾기 */
                                   FOR NOTI IN  SEARCH_EXPT_NOTI_INFO (V_EQ_CTRL_OFC_CD,CUR_EXPT.FM_EXPT_CD,CUR_EXPT.BKG_OFC_CD
                                                                      ,CUR_EXPT.POR_CD,CUR_EXPT.POL_CD,CUR_EXPT.POD_CD,CUR_EXPT.DEL_CD, CUR_EXPT.FM_EXPT_CD)
                                      LOOP
                                      
                                      INSERT INTO SCE_EXPT_NTFY_RPT 
                                                                    (ACT_RCV_DT
                                                                    ,ACT_RCV_NO
                                                                    ,COP_EXPT_NO
                                                                    ,COP_EXPT_TP_CD
                                                                    ,COP_EXPT_TP_DTL_CD
                                                                    ,EXPT_CD
                                                                    ,COP_NO
                                                                    --,COP_GRP_SEQ
                                                                    ,COP_DTL_SEQ
                                                                    ,NTFD_SUBSC_ID
                                                                    ,USR_NM
                                                                    ,USR_EML
                                                                    ,ACT_FLG
                                                                    ,CRE_USR_ID
                                                                    ,CRE_DT
                                                                    ,UPD_USR_ID
                                                                    ,UPD_DT
                                                                    ,EML_SND_RSLT_CD
                                                                    ,OCCR_DT
                                                                    ,OCCR_NOD_CD
                                                                    ,CRE_OFC_CD
                                                                    ,SC_NO
                                                                    ,MST_BL_NO
                                                                    --,BL_MST_NO
                                                                    ,CNTR_NO
                                                                    ,VSL_CD
                                                                    ,SKD_VOY_NO
                                                                    ,SKD_DIR_CD
                                                                    ,POR_CD
                                                                    ,POL_CD
                                                                    ,POD_CD
                                                                    ,DEL_CD
                                                                    ,SHPR_CNT_CD
                                                                    ,SHPR_SEQ
                                                                    ,CNEE_CNT_CD
                                                                    ,CNEE_SEQ
                                                                    ,NTFY_CNT_CD
                                                                    ,NTFY_SEQ
                                                                    ,DLAY_DT
                                                                    ,FM_ACT_CD
                                                                    ,FM_ACT_DT
                                                                    ,TO_ACT_CD
                                                                    ,TO_ACT_DT
                                                                    ,COP_EXPT_SUBSC_GRP_CD
                                                                    ,SUBSC_GRP_NTFD_PTY_CD
                                                                    ,NTFD_OFC_CD
                                                                    ,SUBJ_NM
                                                                    ,MNL_NTFY_DT
                                                                    ,COP_EXPT_RSN
                                                                    ,CTRL_OFC_CD
                                                                    ,COP_EXPT_SUBSC_CS_SEQ )
                                                           VALUES(TO_CHAR(SYSDATE, 'YYYYMMDD')
                                                                    ,SCE_COP_EXPT_SUBSC_SEQ1.NEXTVAL
                                                                    ,V_COP_EXPT_NO
                                                                    ,CUR_EXPT.EXPT_TP_CD
                                                                    ,CUR_EXPT.EXPT_TP_DTL_CD
                                                                    ,CUR_EXPT.FM_EXPT_CD
                                                                    ,CUR_EXPT.COP_NO
                                                                    --,CUR_EXPT.COP_GRP_SEQ
                                                                    ,CUR_EXPT.COP_DTL_SEQ
                                                                    ,NOTI.NTFD_SUBSC_ID 
                                                                    ,SUBSTR(NOTI.NTFD_SUBSC_NM,1,20)
                                                                    ,NOTI.NTFD_SUBSC_USR_EML 
                                                                    ,NOTI.ACT_FLG
                                                                    ,'EXPT_VSL'
                                                                    ,SYSDATE
                                                                    --,''
                                                                    --,''
                                                                    ,'EXPT_VSL'
                                                                    ,SYSDATE
                                                                    ,'00'
                                                                    ,CUR_EXPT.OCCR_DT
                                                                    ,CUR_EXPT.NOD_CD
                                                                    ,V_EQ_CTRL_OFC_CD
                                                                    ,CUR_EXPT.SC_NO
                                                                    ,CUR_EXPT.BL_MST_NO
                                                                    ,CUR_EXPT.CNTR_NO
                                                                    ,CUR_EXPT.VSL_CD
                                                                    ,CUR_EXPT.SKD_VOY_NO
                                                                    ,CUR_EXPT.SKD_DIR_CD
                                                                    ,CUR_EXPT.POR_CD
                                                                    ,CUR_EXPT.POL_CD
                                                                    ,CUR_EXPT.POD_CD
                                                                    ,CUR_EXPT.DEL_CD
                                                                    ,CUR_EXPT.SHPR_CNT_CD
                                                                    ,CUR_EXPT.SHPR_SEQ
                                                                    ,CUR_EXPT.CNEE_CNT_CD
                                                                    ,CUR_EXPT.CNEE_SEQ
                                                                    ,CUR_EXPT.NTFY_CNT_CD
                                                                    ,CUR_EXPT.NTFY_SEQ
                                                                    ,''
                                                                    ,CUR_EXPT.FM_ACT_CD
                                                                    ,CUR_EXPT.FM_ACT_DT
                                                                    ,CUR_EXPT.FM_ACT_CD
                                                                    ,TO_DATE(IN_ACT_DT,'YYYY/MM/DD HH24:MI:SS')                                                             
                                                                    ,NOTI.COP_EXPT_SUBSC_GRP_CD
                                                                    ,NOTI.SUBSC_GRP_NTFD_PTY_CD
                                                                    ,NOTI.NTFD_OFC_CD
                                                                    ,''
                                                                    ,''
                                                                    ,''
                                                                    ,NOTI.CTRL_OFC_CD
                                                                    ,NOTI.COP_EXPT_SUBSC_CS_SEQ );    
                                                                    
                                               v_insert_row_2 := SQL%ROWCOUNT;
                                        
                                               IF v_insert_row_2 = 0  THEN
                                                      v_message    := 'NO Notification Subscriber';
                                                      DBMS_OUTPUT.PUT_LINE(v_message);
                                               ELSE
                                                      v_ctr_ofc_cnt := v_ctr_ofc_cnt + 1;
                                                      v_ntfd_flg := 'Y';
                                                        
                                                      COMMIT;   
                                                      
                                               END IF;                                                                        
                                                                                                         
                                      
                                   END LOOP;
                                   
                                   
                                  /* Finded Flag of Notification Info */
                                  UPDATE SCE_EXPT_MST
                                  SET    NTFD_FLG    = v_ntfd_flg
                                  WHERE  COP_EXPT_NO = V_COP_EXPT_NO;
                              
                                  COMMIT; 
                                   
                              END IF;                                                               
                       END IF;
                             
                             
            END LOOP;
            
            END IF;

       v_err_cd := v_err_cd_1 || v_err_cd_2  ;
       
--       out_result_cd := ' [' || v_cnt || '] [err : ' || v_err_cd ||  '] '  ;

       DBMS_OUTPUT.PUT_LINE('Exception 등록 건수[' || v_cnt || '] [err건수 : ' || v_err_cd ||  '] ');      
       DBMS_OUTPUT.PUT_LINE('처리종료-'||v_err_cd||'-'||v_message);

       EXCEPTION

              WHEN NO_DATA_FOUND THEN
              v_err_cd := '14';
--              out_result_cd := v_err_cd;
              DBMS_OUTPUT.PUT_LINE(' NO_DATA_FOUND EXCEPTION- '|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
              ROLLBACK;

              WHEN OTHERS THEN
              v_err_cd := '99';
--              out_result_cd := v_err_cd;
              DBMS_OUTPUT.PUT_LINE('WHEN OTHERS EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
              ROLLBACK;

END SCE_EXPT_VSL_PRC;
/
