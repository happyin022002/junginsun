CREATE OR REPLACE PROCEDURE SCE_EXCEPTION_RESIST_ACT_PRC
(
     in_cop_no          IN  VARCHAR2
    --,in_cop_grp_seq     IN  NUMBER
    ,in_cop_dtl_seq     IN  NUMBER
    ,in_act_dt          IN  VARCHAR2
    ,in_usr_id          IN  VARCHAR2
    ,in_prc_flg         IN  VARCHAR2 
)
AUTHID CURRENT_USER
IS
/**********************************************************************************************************
  1.Name       : JSAN(SCEM)
  2.Create Date: 2008-05-07
  3.Description: ActualData발생에 의한 COP Exception발생 여부 판단하여 
                 SCE_EXPT_MST/SCE_EXPT_NTFY_RPT테이블 데이터 생성.
  4.Related    : SCE_ACT_RCV_MVMT_PRC, SCE_ACT_RCV_MVMT_OL_PRC               
  5.Revision History
    2008-05-07 : JSAN. 등록
    2008-05-22 : JSAN. New Exception Code 체계 적용 및 재차 수신 Actual 적용 및 보완
    2008-06-03 : JSAN. COMMIT 반영여부 파라미터 추가(in_prc_flg)
    2008-06-10 : JSAN. 가장 최근의 FromActivity정보 찾기(SEARCH_COP_EXPT_INFO커서 쿼리 수정)
    2008-06-10 : JSAN. 가장 최근의 FromActivity정보 찾기<--ActivityMapping오류로 인한 재보완
                       OCCR_DT의 로컬타임 적용 
    2008-06-11 : JSAN. ActualException이 자동판별보다 선행될 경우 Resolved 상태로 발생시킬 것.
                       (모니터링 결과, 유저 요청에 의해) 
    2008-06-16 : JSAN. 중복 ActivityMapping오류 3차 보완, Notification Email이 없는 경우 SKIP,
                       Actual판별이 자동판별보다 선행되더라도 Resolved로 발생 시킬것.(재보완)
    2008-06-24 : JSAN. ActivityMapping오류 4차 보완
    2008-07-29 : JSAN. REPLAN처리에서 Exception처리시 OccurredDate보완
                       (in_usr_id파라미터 'expt%'로 REPLAN에서 호출되는것 체크)
    2008-07-29 : JSAN. REPLAN처리에서 Exception처리시 OccurredDate 재보완              
    2008-07-30 : JSAN. Reefer Longstaying Exception Type 추가 보완 요청
               (Container Reefer Tp/Sz의 Longstaying 집중 관리를 위해, 기존 
                Actual Exception Type에서 Reefer Tp/Sz를 분리하여, 별도의
                Tolerance와 Exception Type Detail로 Exception 관리)         
    2008-08-21 : JSAN. Container Attach된 COP만 Exception 대상으로 판별하도록 수정                    
    2008-09-11 : JSAN. Exception Resolved 처리 보완. 
    2008-09-11 : 2차 jsan. 불필요한 CHK_OCCR_EXPT커서문 삭제하고 
                 Actual Data가 수신되면 무조건 Exception Resolve 업데이트 하도록 수정.
    2008-11-06 : JSAN. Booking Customer 관리 포인트 변경에 따른 참조 테이블 변경(SCE_COP_HDR-->BKG_BKG_CUST)             
***********************************************************************************************************/
----2008-09-11 2차-----------------------------------------
--CURSOR CHK_OCCR_EXPT(p_cop_no      VARCHAR2
--                    ,p_cop_grp_seq VARCHAR2
--                    ,p_cop_dtl_seq VARCHAR2)IS
--SELECT M.COP_EXPT_STS_CD, D.ACT_DT
--FROM   SCE_EXPT_MST M, SCE_COP_DTL D
--WHERE  D.COP_NO      = p_cop_no
--AND    D.COP_GRP_SEQ = p_cop_grp_seq
--AND    D.COP_DTL_SEQ = p_cop_dtl_seq 
--AND    M.COP_NO      = D.COP_NO
--;                    
----2008-09-11 2차-----------------------------------------

CURSOR SEARCH_COP_EXPT_INFO (p_cop_no      VARCHAR2
                            --,p_cop_grp_seq VARCHAR2
                            ,p_cop_dtl_seq VARCHAR2
                            ,p_act_dt      VARCHAR2
                            ,p_usr_id      VARCHAR2)IS
SELECT   --Activity(1):From
         D.FM_COP,D.FM_ACT_CD,D.FM_ESTM_DT,D.FM_ACT_DT,D.FM_UPD_DT
         --Activity(2):To
         ,D.COP_NO, D.COP_DTL_SEQ, D.ACT_CD, D.NOD_CD, D.ACT_DT
         ,D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.VPS_PORT_CD, D.ACT_STS_MAPG_CD, D.CLPT_IND_SEQ
         ,D.TO_ACT_CD, D.TO_ESTM_DT, D.TO_ACT_DT, D.TO_UPD_DT, D.COP_EXPT_FLG
         --EXPT
         ,D.OCCR_DT, D.Activity, D.GAP
         ----, D.COP_EXPT_TP_CD, D.COP_EXPT_TP_DTL_CD
         ,D.EXPT_TP_CD, D.EXPT_TP_DTL_CD, D.TO_EXPT_CD
         , D.TOL, D.SYS_DT
         --HDR:BKG INFO
         ,D.BKG_NO,D.CNTR_NO,D.RCV_TERM_CD,D.DE_TERM_CD,D.SHPR_CNT_CD
         ,D.SHPR_SEQ,D.CNEE_CNT_CD,D.CNEE_SEQ,D.NTFY_CNT_CD,D.NTFY_SEQ,D.POR_CD,D.POL_CD
         ,D.POD_CD,D.DEL_CD,D.TRNK_VVD_CD,D.LODG_PORT_CD,D.LST_BKG_DT,D.BL_MST_NO,D.SC_NO,D.BKG_OFC_CD
FROM (            
SELECT   --Activity(1):From
         C.FM_COP,C.FM_ACT_CD,C.FM_ESTM_DT,C.FM_ACT_DT,C.FM_UPD_DT
         --Activity(2):To
         ,C.COP_NO, C.COP_DTL_SEQ, C.ACT_CD, C.NOD_CD, C.ACT_DT
         ,C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.VPS_PORT_CD, C.ACT_STS_MAPG_CD, C.CLPT_IND_SEQ
         ,C.TO_ACT_CD, C.TO_ESTM_DT, C.TO_ACT_DT, C.TO_UPD_DT, C.COP_EXPT_FLG
         --EXPT
         ,C.OCCR_DT, C.Activity, C.GAP
         ----, C.COP_EXPT_TP_CD, C.COP_EXPT_TP_DTL_CD
         ,C.EXPT_TP_CD, C.EXPT_TP_DTL_CD, C.TO_EXPT_CD
         , C.TOL, C.SYS_DT
         --HDR:BKG INFO
         ,C.BKG_NO,C.CNTR_NO,C.RCV_TERM_CD,C.DE_TERM_CD,C.SHPR_CNT_CD
         ,C.SHPR_SEQ,C.CNEE_CNT_CD,C.CNEE_SEQ,C.NTFY_CNT_CD,C.NTFY_SEQ,C.POR_CD,C.POL_CD
         ,C.POD_CD,C.DEL_CD,C.TRNK_VVD_CD,C.LODG_PORT_CD,C.LST_BKG_DT,C.BL_MST_NO,C.SC_NO,C.BKG_OFC_CD
         --CHK:MINFROMCOPDetail INFO
         ,RANK() OVER (PARTITION BY C.COP_NO ORDER BY C.COP_DTL_SEQ) TO_RANK      
FROM (            
SELECT   --Activity(1):From
         B.FM_COP,B.FM_ACT_CD,B.FM_ESTM_DT,B.FM_ACT_DT,B.FM_UPD_DT
         --Activity(2):To
         ,B.COP_NO, B.COP_DTL_SEQ, B.ACT_CD, B.NOD_CD, B.ACT_DT
         ,B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.VPS_PORT_CD, B.ACT_STS_MAPG_CD, B.CLPT_IND_SEQ
         ,B.TO_ACT_CD, B.TO_ESTM_DT, B.TO_ACT_DT, B.TO_UPD_DT, B.COP_EXPT_FLG
         --EXPT
         ,B.OCCR_DT, B.Activity, B.GAP
         ----, B.COP_EXPT_TP_CD, B.COP_EXPT_TP_DTL_CD
         ,B.EXPT_TP_CD, B.EXPT_TP_DTL_CD, B.TO_EXPT_CD
         , B.TOL, B.SYS_DT
         --HDR:BKG INFO
         ,B.BKG_NO,B.CNTR_NO,B.RCV_TERM_CD,B.DE_TERM_CD,B.SHPR_CNT_CD
         ,B.SHPR_SEQ,B.CNEE_CNT_CD,B.CNEE_SEQ,B.NTFY_CNT_CD,B.NTFY_SEQ,B.POR_CD,B.POL_CD
         ,B.POD_CD,B.DEL_CD,B.TRNK_VVD_CD,B.LODG_PORT_CD,B.LST_BKG_DT,B.BL_MST_NO,B.SC_NO,B.BKG_OFC_CD
         --CHK:MaxFROMCOPDetail INFO
         ,RANK() OVER (PARTITION BY B.COP_NO ORDER BY B.FM_COP DESC) FM_RANK         
FROM (  SELECT       --Activity(1):From
                     A.FM_COP,  
                     A.FM_ACT_CD,A.FM_ESTM_DT,A.FM_ACT_DT,A.FM_UPD_DT
                     --Activity(2):To
                     ,A.COP_NO, A.COP_DTL_SEQ, A.ACT_CD, A.NOD_CD, A.ACT_DT
                     ,A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD, A.ACT_STS_MAPG_CD, A.CLPT_IND_SEQ
                     ,A.TO_ACT_CD, A.TO_ESTM_DT, A.TO_ACT_DT, A.TO_UPD_DT, A.COP_EXPT_FLG
                     --EXPT
                     ,A.OCCR_DT
                     ,A.Activity,NUMTODSINTERVAL((A.OCCR_DT-A.FM_ACT_DT),'DAY') GAP
                     -----,A.COP_EXPT_TP_CD, A.COP_EXPT_TP_DTL_CD
                     ,A.EXPT_TP_CD, A.EXPT_TP_DTL_CD, A.TO_EXPT_CD
                     ,NUMTODSINTERVAL(SCE_EXPT_TOL_ACT_CAL_FNC(A.ACTIVITY, A.NOD_CD, A.COP_NO, A.EXPT_TP_CD) ,'MINUTE') TOL
                     ,SYSDATE SYS_DT
                     --HDR:BKG INFO
                     ,A.BKG_NO,A.CNTR_NO,A.RCV_TERM_CD,A.DE_TERM_CD,A.SHPR_CNT_CD
                     ,A.SHPR_SEQ,A.CNEE_CNT_CD,A.CNEE_SEQ,A.NTFY_CNT_CD,A.NTFY_SEQ,A.POR_CD,A.POL_CD
                     ,A.POD_CD,A.DEL_CD,A.TRNK_VVD_CD,A.LODG_PORT_CD,A.LST_BKG_DT,A.BL_MST_NO,A.SC_NO,A.BKG_OFC_CD
        FROM (  SELECT 
                     --Activity(1):From
                     FD.COP_NO||FD.COP_DTL_SEQ FM_COP,
                     FD.ACT_CD FM_ACT_CD,FD.ESTM_DT FM_ESTM_DT,FD.ACT_DT FM_ACT_DT,FD.UPD_DT FM_UPD_DT
                     --Activity(2):To
                     ,TD.COP_NO, TD.COP_DTL_SEQ, TD.ACT_CD, TD.NOD_CD, TD.ACT_DT
                     ----,TO_DATE(p_act_dt,'YYYY/MM/DD HH24:MI:SS') OCCR_DT
                     ,DECODE(p_usr_id,'expt',TO_DATE(p_act_dt,'YYYY/MM/DD HH24:MI:SS'),GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(TD.NOD_CD,1,5))) OCCR_DT
                     ,TD.VSL_CD, TD.SKD_VOY_NO, TD.SKD_DIR_CD, TD.VPS_PORT_CD, TD.ACT_STS_MAPG_CD, TD.CLPT_IND_SEQ
                     ,TD.ACT_CD TO_ACT_CD, TD.ESTM_DT TO_ESTM_DT, TD.ACT_DT TO_ACT_DT, TD.UPD_DT TO_UPD_DT,TD.COP_EXPT_FLG
                     --EXPT
                     ,(FD.ACT_CD||TD.ACT_CD) Activity
                     ----     ,(TD.OCCR_DT-FD.ACT_DT) GAP
                     ----,T.COP_EXPT_TP_CD,T.COP_EXPT_TP_DTL_CD
                     ,TOA.EXPT_TP_CD, TOA.EXPT_TP_DTL_CD, TOA.TO_EXPT_CD
                     --HDR:BKG INFO
                     ,H.BKG_NO,H.CNTR_NO,BB.RCV_TERM_CD,BB.DE_TERM_CD
                     ----,H.SHPR_CNT_CD,H.SHPR_SEQ,H.CNEE_CNT_CD,H.CNEE_SEQ,H.NTFY_CNT_CD,H.NTFY_SEQ                                --20081105
                     ,SBC.CUST_CNT_CD SHPR_CNT_CD, SBC.CUST_SEQ SHPR_SEQ, CBC.CUST_CNT_CD CNEE_CNT_CD, CBC.CUST_SEQ CNEE_SEQ        --20081105
                     ,NBC.CUST_CNT_CD NTFY_CNT_CD, NBC.CUST_SEQ NTFY_SEQ                                                            --20081105                      
                     ,BB.POR_CD,BB.POL_CD,BB.POD_CD,BB.DEL_CD
                     ,(H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD) TRNK_VVD_CD
                     ,BB.POL_CD LODG_PORT_CD,BB.BKG_CRE_DT LST_BKG_DT,BB.BL_NO BL_MST_NO, BB.SC_NO, BB.BKG_OFC_CD
                FROM  (SELECT SUBSTR(TOP.EXPT_CD, 1, 1) EXPT_TP_CD,SUBSTR(TOP.EXPT_CD, 1, 3) EXPT_TP_DTL_CD
                            ,TOP.COP_EXPT_TP_DTL_DESC EXPT_TP_DTL_DESC,SUBSTR(TOP.EXPT_CD, 5, 2) FM_ACT_EXPT_CD
                            ,SUBSTR(TOP.EXPT_CD, 7, 2) TO_ACT_EXPT_CD,TOP.EXPT_CD TO_EXPT_CD,TOP.EXPT_CD_NM TO_ACT_CD
                            ,TOP.EXPT_CD_DESC TO_ACT_NM,TOP.UPD_USR_ID,TOP.UPD_DT,TOP.ACT_FLG
                      FROM SCE_EXPT_CD TOP
                      WHERE TOP.EXPT_CD NOT LIKE '%00000' AND TOP.EXPT_CD LIKE '1%' AND SUBSTR(TOP.EXPT_CD, 4, 1) = '2' AND TOP.ACT_FLG = 'Y' ) TOA
                    ,(SELECT SUBSTR(FMP.EXPT_CD, 1, 1) EXPT_TP_CD,SUBSTR(FMP.EXPT_CD, 1, 3) EXPT_TP_DTL_CD,SUBSTR(FMP.EXPT_CD, 5, 2) FM_ACT_EXPT_CD
                            ,FMP.EXPT_CD FM_EXPT_CD,FMP.EXPT_CD_NM FM_ACT_CD,FMP.EXPT_CD_DESC FM_ACT_NM
                      FROM SCE_EXPT_CD FMP
                      WHERE FMP.EXPT_CD NOT LIKE '%00000' AND FMP.EXPT_CD LIKE '1%' AND SUBSTR(FMP.EXPT_CD, 4, 1) = '1' AND FMP.ACT_FLG = 'Y' ) FMA
                    ,SCE_COP_DTL TD, SCE_COP_HDR H, SCE_COP_DTL FD, BKG_BOOKING BB
                    --,BKG_CUSTOMER SBC, BKG_CUSTOMER CBC, BKG_CUSTOMER NBC                                                           --20081105
                    ,BKG_CUSTOMER SBC, BKG_CUSTOMER CBC, BKG_CUSTOMER NBC, BKG_CONTAINER CNTR   -- 2010.01.14 추가 (BKG_CONTAINER CNTR)
                WHERE TD.ACT_CD        =  TOA.TO_ACT_CD
                AND   TD.COP_NO        =  p_cop_no
                --AND   TD.COP_GRP_SEQ   =  p_cop_grp_seq
                AND   TD.COP_DTL_SEQ   =  p_cop_dtl_seq
                AND   H.COP_NO         =  TD.COP_NO
                AND   H.COP_STS_CD     IN ('C','T')
                AND   H.CNTR_NO        <> 'HJCU0000000'
                
                -- 2010.01.14 추가 begin 
                -- bkg_no, cntr_no를 걸어주지 않으면 expt이 cntr갯수만큼 중복..
                AND H.BKG_NO = CNTR.BKG_NO
                AND H.CNTR_NO = CNTR.CNTR_NO
                -- 2010.01.14 추가 end 
                        
                --AND   H.RF_SPCL_FLG    <> 'Y'
                
                -- 2010.01.14 추가 begin
                -- Reefer Cntr 아니면
                AND   CNTR.RC_FLG    <> 'Y'
                -- 2010.01.14 추가 end
                        
                        
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
                AND   FD.COP_NO        =  TD.COP_NO
                --AND   FD.COP_GRP_SEQ   <= TD.COP_GRP_SEQ
--                AND   FD.COP_DTL_SEQ   <= TD.COP_DTL_SEQ
                AND   FD.ACT_CD        =   FMA.FM_ACT_CD
                AND   FD.ACT_STS_CD    =  'F'     
                AND   FD.ACT_DT        >  TO_DATE('2008/01/01 00:00:00','YYYY/MM/DD HH24:MI:SS')
                AND   FMA.EXPT_TP_CD   = TOA.EXPT_TP_CD
                AND   FMA.EXPT_TP_DTL_CD = TOA.EXPT_TP_DTL_CD
                AND   FMA.FM_ACT_EXPT_CD = TOA.FM_ACT_EXPT_CD                
      ) A  ) B
) C
WHERE C.FM_RANK = 1 ) D
WHERE D.TO_RANK = 1
AND   D.GAP > D.TOL
AND TO_NUMBER(SUBSTR(D.FM_COP,15,3)) BETWEEN TO_NUMBER(SUBSTR(D.FM_COP,15,3))-1 AND TO_NUMBER(SUBSTR(D.FM_COP,15,3))
--AND   TO_NUMBER(SUBSTR(D.FM_COP,15,3)) BETWEEN TO_NUMBER(D.COP_GRP_SEQ)-1 AND D.COP_GRP_SEQ
;
 
CURSOR SEARCH_REEF_EXPT_INFO (p_cop_no      VARCHAR2
                            --,p_cop_grp_seq VARCHAR2
                            ,p_cop_dtl_seq VARCHAR2
                            ,p_act_dt      VARCHAR2
                            ,p_usr_id      VARCHAR2)IS
SELECT   --Activity(1):From
         D.FM_COP,D.FM_ACT_CD,D.FM_ESTM_DT,D.FM_ACT_DT,D.FM_UPD_DT
         --Activity(2):To
         ,D.COP_NO, D.COP_DTL_SEQ, D.ACT_CD, D.NOD_CD, D.ACT_DT
         ,D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.VPS_PORT_CD, D.ACT_STS_MAPG_CD, D.CLPT_IND_SEQ
         ,D.TO_ACT_CD, D.TO_ESTM_DT, D.TO_ACT_DT, D.TO_UPD_DT, D.COP_EXPT_FLG
         --EXPT
         ,D.OCCR_DT, D.Activity, D.GAP
         ----, D.COP_EXPT_TP_CD, D.COP_EXPT_TP_DTL_CD
         ,D.EXPT_TP_CD, D.EXPT_TP_DTL_CD, D.TO_EXPT_CD
         , D.TOL, D.SYS_DT
         --HDR:BKG INFO
         ,D.BKG_NO,D.CNTR_NO,D.RCV_TERM_CD,D.DE_TERM_CD,D.SHPR_CNT_CD
         ,D.SHPR_SEQ,D.CNEE_CNT_CD,D.CNEE_SEQ,D.NTFY_CNT_CD,D.NTFY_SEQ,D.POR_CD,D.POL_CD
         ,D.POD_CD,D.DEL_CD,D.TRNK_VVD_CD,D.LODG_PORT_CD,D.LST_BKG_DT,D.BL_MST_NO,D.SC_NO,D.BKG_OFC_CD
FROM (            
SELECT   --Activity(1):From
         C.FM_COP,C.FM_ACT_CD,C.FM_ESTM_DT,C.FM_ACT_DT,C.FM_UPD_DT
         --Activity(2):To
         ,C.COP_NO, C.COP_DTL_SEQ, C.ACT_CD, C.NOD_CD, C.ACT_DT
         ,C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.VPS_PORT_CD, C.ACT_STS_MAPG_CD, C.CLPT_IND_SEQ
         ,C.TO_ACT_CD, C.TO_ESTM_DT, C.TO_ACT_DT, C.TO_UPD_DT, C.COP_EXPT_FLG
         --EXPT
         ,C.OCCR_DT, C.Activity, C.GAP
         ----, C.COP_EXPT_TP_CD, C.COP_EXPT_TP_DTL_CD
         ,C.EXPT_TP_CD, C.EXPT_TP_DTL_CD, C.TO_EXPT_CD
         , C.TOL, C.SYS_DT
         --HDR:BKG INFO
         ,C.BKG_NO,C.CNTR_NO,C.RCV_TERM_CD,C.DE_TERM_CD,C.SHPR_CNT_CD
         ,C.SHPR_SEQ,C.CNEE_CNT_CD,C.CNEE_SEQ,C.NTFY_CNT_CD,C.NTFY_SEQ,C.POR_CD,C.POL_CD
         ,C.POD_CD,C.DEL_CD,C.TRNK_VVD_CD,C.LODG_PORT_CD,C.LST_BKG_DT,C.BL_MST_NO,C.SC_NO,C.BKG_OFC_CD
         --CHK:MINFROMCOPDetail INFO
         ,RANK() OVER (PARTITION BY C.COP_NO ORDER BY C.COP_DTL_SEQ) TO_RANK      
FROM (            
SELECT   --Activity(1):From
         B.FM_COP,B.FM_ACT_CD,B.FM_ESTM_DT,B.FM_ACT_DT,B.FM_UPD_DT
         --Activity(2):To
         ,B.COP_NO, B.COP_DTL_SEQ, B.ACT_CD, B.NOD_CD, B.ACT_DT
         ,B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.VPS_PORT_CD, B.ACT_STS_MAPG_CD, B.CLPT_IND_SEQ
         ,B.TO_ACT_CD, B.TO_ESTM_DT, B.TO_ACT_DT, B.TO_UPD_DT, B.COP_EXPT_FLG
         --EXPT
         ,B.OCCR_DT, B.Activity, B.GAP
         ----, B.COP_EXPT_TP_CD, B.COP_EXPT_TP_DTL_CD
         ,B.EXPT_TP_CD, B.EXPT_TP_DTL_CD, B.TO_EXPT_CD
         , B.TOL, B.SYS_DT
         --HDR:BKG INFO
         ,B.BKG_NO,B.CNTR_NO,B.RCV_TERM_CD,B.DE_TERM_CD,B.SHPR_CNT_CD
         ,B.SHPR_SEQ,B.CNEE_CNT_CD,B.CNEE_SEQ,B.NTFY_CNT_CD,B.NTFY_SEQ,B.POR_CD,B.POL_CD
         ,B.POD_CD,B.DEL_CD,B.TRNK_VVD_CD,B.LODG_PORT_CD,B.LST_BKG_DT,B.BL_MST_NO,B.SC_NO,B.BKG_OFC_CD
         --CHK:MaxFROMCOPDetail INFO
         ,RANK() OVER (PARTITION BY B.COP_NO ORDER BY B.FM_COP DESC) FM_RANK         
FROM (  SELECT       --Activity(1):From
                     A.FM_COP,  
                     A.FM_ACT_CD,A.FM_ESTM_DT,A.FM_ACT_DT,A.FM_UPD_DT
                     --Activity(2):To
                     ,A.COP_NO, A.COP_DTL_SEQ, A.ACT_CD, A.NOD_CD, A.ACT_DT
                     ,A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD, A.ACT_STS_MAPG_CD, A.CLPT_IND_SEQ
                     ,A.TO_ACT_CD, A.TO_ESTM_DT, A.TO_ACT_DT, A.TO_UPD_DT, A.COP_EXPT_FLG
                     --EXPT
                     ,A.OCCR_DT
                     ,A.Activity,NUMTODSINTERVAL((A.OCCR_DT-A.FM_ACT_DT),'DAY') GAP
                     -----,A.COP_EXPT_TP_CD, A.COP_EXPT_TP_DTL_CD
                     ,A.EXPT_TP_CD, A.EXPT_TP_DTL_CD, A.TO_EXPT_CD
                     ,NUMTODSINTERVAL(SCE_EXPT_TOL_ACT_CAL_FNC(A.ACTIVITY, A.NOD_CD, A.COP_NO, A.EXPT_TP_CD) ,'MINUTE') TOL
                     ,SYSDATE SYS_DT
                     --HDR:BKG INFO
                     ,A.BKG_NO,A.CNTR_NO,A.RCV_TERM_CD,A.DE_TERM_CD,A.SHPR_CNT_CD
                     ,A.SHPR_SEQ,A.CNEE_CNT_CD,A.CNEE_SEQ,A.NTFY_CNT_CD,A.NTFY_SEQ,A.POR_CD,A.POL_CD
                     ,A.POD_CD,A.DEL_CD,A.TRNK_VVD_CD,A.LODG_PORT_CD,A.LST_BKG_DT,A.BL_MST_NO,A.SC_NO,A.BKG_OFC_CD
        FROM (  SELECT /*+ ORDERED */
                     --Activity(1):From
                     FD.COP_NO||FD.COP_DTL_SEQ FM_COP,
                     FD.ACT_CD FM_ACT_CD,FD.ESTM_DT FM_ESTM_DT,FD.ACT_DT FM_ACT_DT,FD.UPD_DT FM_UPD_DT
                     --Activity(2):To
                     ,TD.COP_NO, TD.COP_DTL_SEQ, TD.ACT_CD, TD.NOD_CD, TD.ACT_DT
                     ----,TO_DATE(p_act_dt,'YYYY/MM/DD HH24:MI:SS') OCCR_DT
                     ,DECODE(p_usr_id,'expt',TO_DATE(p_act_dt,'YYYY/MM/DD HH24:MI:SS'),GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(TD.NOD_CD,1,5))) OCCR_DT
                     ,TD.VSL_CD, TD.SKD_VOY_NO, TD.SKD_DIR_CD, TD.VPS_PORT_CD, TD.ACT_STS_MAPG_CD, TD.CLPT_IND_SEQ
                     ,TD.ACT_CD TO_ACT_CD, TD.ESTM_DT TO_ESTM_DT, TD.ACT_DT TO_ACT_DT, TD.UPD_DT TO_UPD_DT,TD.COP_EXPT_FLG
                     --EXPT
                     ,(FD.ACT_CD||TD.ACT_CD) Activity
                     ----     ,(TD.OCCR_DT-FD.ACT_DT) GAP
                     ----,T.COP_EXPT_TP_CD,T.COP_EXPT_TP_DTL_CD
                     ,TOA.EXPT_TP_CD, TOA.EXPT_TP_DTL_CD, TOA.TO_EXPT_CD
                     --HDR:BKG INFO
                     ,H.BKG_NO,H.CNTR_NO,BB.RCV_TERM_CD,BB.DE_TERM_CD
                     ----,H.SHPR_CNT_CD,H.SHPR_SEQ,H.CNEE_CNT_CD,H.CNEE_SEQ,H.NTFY_CNT_CD,H.NTFY_SEQ                                --20081105
                     ,SBC.CUST_CNT_CD SHPR_CNT_CD, SBC.CUST_SEQ SHPR_SEQ, CBC.CUST_CNT_CD CNEE_CNT_CD, CBC.CUST_SEQ CNEE_SEQ        --20081105
                     ,NBC.CUST_CNT_CD NTFY_CNT_CD, NBC.CUST_SEQ NTFY_SEQ                                                            --20081105                          
                     ,BB.POR_CD,BB.POL_CD,BB.POD_CD,BB.DEL_CD
                     ,(H.TRNK_VSL_CD||H.TRNK_SKD_VOY_NO||H.TRNK_SKD_DIR_CD) TRNK_VVD_CD
                     ,BB.POL_CD LODG_PORT_CD,BB.BKG_CRE_DT LST_BKG_DT,BB.BL_NO BL_MST_NO, BB.SC_NO, BB.BKG_OFC_CD
                FROM SCE_COP_HDR H,BKG_BOOKING BB,SCE_COP_DTL TD,SCE_COP_DTL FD
                    ,(SELECT SUBSTR(TOP.EXPT_CD, 1, 1) EXPT_TP_CD,SUBSTR(TOP.EXPT_CD, 1, 3) EXPT_TP_DTL_CD
                            ,TOP.COP_EXPT_TP_DTL_DESC EXPT_TP_DTL_DESC,SUBSTR(TOP.EXPT_CD, 5, 2) FM_ACT_EXPT_CD
                            ,SUBSTR(TOP.EXPT_CD, 7, 2) TO_ACT_EXPT_CD,TOP.EXPT_CD TO_EXPT_CD,TOP.EXPT_CD_NM TO_ACT_CD
                            ,TOP.EXPT_CD_DESC TO_ACT_NM,TOP.UPD_USR_ID,TOP.UPD_DT,TOP.ACT_FLG
                      FROM SCE_EXPT_CD TOP
                      WHERE TOP.EXPT_CD NOT LIKE '%00000' AND TOP.EXPT_CD LIKE '4%' AND SUBSTR(TOP.EXPT_CD, 4, 1) = '2' AND TOP.ACT_FLG = 'Y' ) TOA
                    ,(SELECT SUBSTR(FMP.EXPT_CD, 1, 1) EXPT_TP_CD,SUBSTR(FMP.EXPT_CD, 1, 3) EXPT_TP_DTL_CD,SUBSTR(FMP.EXPT_CD, 5, 2) FM_ACT_EXPT_CD
                            ,FMP.EXPT_CD FM_EXPT_CD,FMP.EXPT_CD_NM FM_ACT_CD,FMP.EXPT_CD_DESC FM_ACT_NM
                      FROM SCE_EXPT_CD FMP
                      WHERE FMP.EXPT_CD NOT LIKE '%00000' AND FMP.EXPT_CD LIKE '4%' AND SUBSTR(FMP.EXPT_CD, 4, 1) = '1' AND FMP.ACT_FLG = 'Y' ) FMA
                    --,BKG_CUSTOMER SBC, BKG_CUSTOMER CBC, BKG_CUSTOMER NBC                                                           --20081105 
                    ,BKG_CUSTOMER SBC, BKG_CUSTOMER CBC, BKG_CUSTOMER NBC, BKG_CONTAINER CNTR 
                WHERE TD.ACT_CD = TOA.TO_ACT_CD 
                AND TD.COP_NO        =  p_cop_no
                --AND TD.COP_GRP_SEQ   =  p_cop_grp_seq
                AND TD.COP_DTL_SEQ   =  p_cop_dtl_seq               
                AND H.COP_NO         = TD.COP_NO
                AND H.COP_STS_CD     IN ('C','T')
                AND H.CNTR_NO        <> 'HJCU0000000'
                
                -- 2010.01.14 추가 begin 
                -- bkg_no, cntr_no를 걸어주지 않으면 expt이 cntr갯수만큼 중복..
                AND H.BKG_NO = CNTR.BKG_NO
                AND H.CNTR_NO = CNTR.CNTR_NO
                -- 2010.01.14 추가 end 
                        
                --AND   H.RF_SPCL_FLG    <> 'Y'
                
                -- 2010.01.14 추가 begin
                -- Reefer Cntr 이므로 'Y'
                AND   CNTR.RC_FLG   = 'Y'
                -- 2010.01.14 추가 end
                
                AND H.CNTR_TPSZ_CD   LIKE 'R%'
                --AND H.RF_SPCL_FLG    = 'Y'
                AND BB.BKG_NO        = H.BKG_NO
                --AND BB.BKG_NO_SPLIT  = H.BKG_NO_SPLIT
                    AND   SBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   SBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   SBC.BKG_CUST_TP_CD(+) =  'S'                                                                              --20081105
                    AND   CBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   CBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   CBC.BKG_CUST_TP_CD(+) =  'C'                                                                              --20081105
                    AND   NBC.BKG_NO(+)    =  H.BKG_NO                                                                              --20081105
                    --AND   NBC.BKG_NO_SPLIT(+)   =  H.BKG_NO_SPLIT                                                                   --20081105
                    AND   NBC.BKG_CUST_TP_CD(+) =  'N'                                                                              --20081105                 
                AND FD.COP_NO        = TD.COP_NO
                --AND FD.COP_GRP_SEQ   <= TD.COP_GRP_SEQ
--                      AND FD.COP_DTL_SEQ   <= TD.COP_DTL_SEQ                        
                AND FD.ACT_CD = FMA.FM_ACT_CD
                AND FD.ACT_STS_CD    = 'F'
                AND FD.ACT_DT        > TO_DATE('2008/04/01 00:00:00', 'YYYY/MM/DD HH24:MI:SS')
                AND FMA.EXPT_TP_CD   = TOA.EXPT_TP_CD
                AND FMA.EXPT_TP_DTL_CD = TOA.EXPT_TP_DTL_CD
                AND FMA.FM_ACT_EXPT_CD = TOA.FM_ACT_EXPT_CD                     
      ) A  ) B
) C
WHERE C.FM_RANK = 1 ) D
WHERE D.TO_RANK = 1
AND   D.GAP > D.TOL
AND TO_NUMBER(SUBSTR(D.FM_COP,15,3)) BETWEEN TO_NUMBER(SUBSTR(D.FM_COP,15,3))-1 AND TO_NUMBER(SUBSTR(D.FM_COP,15,3))
--AND   TO_NUMBER(SUBSTR(D.FM_COP,15,3)) BETWEEN TO_NUMBER(D.COP_GRP_SEQ)-1 AND D.COP_GRP_SEQ
; 

CURSOR SEARCH_EXPT_NOTI_INFO (p_eq_ctrl_ofc_cd      VARCHAR2
                             ,p_to_act_cd           VARCHAR2
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
WHERE  G.EXPT_CD        = p_to_act_cd
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
v_expt_sts_flg        VARCHAR2(1):='O';
v_upd_flg             VARCHAR2(1):='N';

BEGIN
       DBMS_OUTPUT.ENABLE;
       --DBMS_OUTPUT.DISABLE;
----2008-09-11 2차-----------------------------------------       
--       --Resolved대상 아님.
--       v_chk_expt := 'R0';
--       /* Check Occurred Exception */
--       FOR CHK_EXPT IN  CHK_OCCR_EXPT(in_cop_no,in_cop_grp_seq,in_cop_dtl_seq)
--            LOOP
--                --기발생 Exception체크
--                IF(CHK_EXPT.COP_EXPT_STS_CD='O') THEN
--                    --Resolved 처리 
--                    v_chk_expt := 'R1'; 
--                ELSIF(CHK_EXPT.COP_EXPT_STS_CD='R') THEN             
--                    --Resolved 재처리
--                    v_chk_expt := 'R2'; 
--                END IF;
--                
--                
--                --Actual 재수신 여부 체크
--                IF(CHK_EXPT.ACT_DT IS NULL) THEN
--                    --Actual 최초 수신
--                    v_chk_act := '1';
--                ELSE
--                    --Actual 재수신 
--                    v_chk_act := '2';
--                END IF;        
--            
--       END LOOP;
----2008-09-11 2차-----------------------------------------          
       
        v_upd_flg := 'N';
        
        --기발생 Exception Resolve처리
--        IF(v_chk_expt = 'R1' OR v_chk_expt = 'R2') THEN 
        
            --DBMS_OUTPUT.PUT_LINE('[기발생 Exception : '|| v_chk_expt||' Actual 재수신 여부 : '|| v_chk_act ||']'); 
            /* DTL에 있는 모든 Expt Resolve +Actual재수신 포함 */
            
            UPDATE SCE_EXPT_MST
            SET COP_EXPT_STS_CD = 'R'
               ,EXPT_CLR_TP_CD  = '1' 
               ,EXPT_RSOLV_DT   = SYSDATE
               ,TO_ACT_DT       = TO_DATE(in_act_dt,'YYYY/MM/DD HH24:MI:SS')
               ,TO_UPD_DT       = SYSDATE
               ,upd_usr_id      = in_usr_id
               ,upd_dt          = SYSDATE           
            WHERE  COP_NO      = in_cop_no
            --AND    COP_GRP_SEQ = in_cop_grp_seq
            AND    COP_DTL_SEQ = in_cop_dtl_seq
            AND    COP_EXPT_STS_CD IN ('O','R');
                      
                      
            DBMS_OUTPUT.PUT_LINE('현재 EXPT RESOLVE 처리건수 : '|| SQL%ROWCOUNT||']');
            
            --2008-09-11 jsan-----------------------------------------
            IF SQL%ROWCOUNT > 0 THEN
                if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y')) then
                    commit;
                end if;
                v_upd_flg := 'Y';
            END IF;
            --2008-09-11 jsan-----------------------------------------
            
            /* ACTUAL DATA의 DTL보다 작은 값 EXPT RESOLVE */
            
            UPDATE SCE_EXPT_MST
            SET    COP_EXPT_STS_CD = 'R'
                  ,EXPT_CLR_TP_CD  = '2'
                  ,EXPT_RSOLV_DT   = SYSDATE
                  ,UPD_USR_ID      = in_usr_id
                  ,UPD_DT          = SYSDATE
            WHERE  COP_NO          = in_cop_no
            AND    TRIM(TO_CHAR(COP_DTL_SEQ,'0000')) < TRIM(TO_CHAR(in_cop_dtl_seq,'0000'))     
            --AND    TRIM(TO_CHAR(COP_GRP_SEQ,'0000')) || TRIM(TO_CHAR(COP_DTL_SEQ,'0000')) < TRIM(TO_CHAR(in_cop_grp_seq,'0000')) || TRIM(TO_CHAR(in_cop_dtl_seq,'0000'))     
            AND    COP_EXPT_STS_CD = 'O';
            
            
            DBMS_OUTPUT.PUT_LINE('이전 EXPT RESOLVE 처리건수 : '|| SQL%ROWCOUNT||']');
            
            if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                commit;
            end if;   
            
--        END IF;
    
    
       IF v_upd_flg = 'N' THEN


       /* Actual Delay Exception 등록 대상 */
       FOR CUR_EXPT IN  SEARCH_COP_EXPT_INFO(in_cop_no,in_cop_dtl_seq,in_act_dt,SUBSTR(in_usr_id,1,4))
       --FOR CUR_EXPT IN  SEARCH_COP_EXPT_INFO(in_cop_no,in_cop_grp_seq,in_cop_dtl_seq)
            LOOP
            DBMS_OUTPUT.PUT_LINE('Actual Delay Exception ROW Fetch');
            

                       /* Get ExceptonNO */
                       SELECT 'E'|| SUBSTR(CUR_EXPT.NOD_CD,3,3) || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) 
                              || (CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'          
                                       ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1) END )
                              || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) || TRIM(TO_CHAR(SCE_COP_EXPT_SEQ1.NEXTVAL,'000000')) EXPT_NO INTO V_COP_EXPT_NO  
                       FROM DUAL;
                       
                       DBMS_OUTPUT.PUT_LINE('Get ExceptonNO'||V_COP_EXPT_NO||' NOD:'||CUR_EXPT.NOD_CD);
                       
                       /* Get ControlOffice */
                       --V_EQ_CTRL_OFC_CD := 'XXXXXX';
                       SELECT NVL((select EQ_CTRL_OFC_CD from mdm_location where LOC_CD = SUBSTR(CUR_EXPT.NOD_CD,1,5) ),' ') INTO V_EQ_CTRL_OFC_CD 
                       FROM DUAL;
                     
                       DBMS_OUTPUT.PUT_LINE('Get ControlOffice'||V_EQ_CTRL_OFC_CD||' TO-ACTUAL:'||in_act_dt);
                    
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
                                    --,BL_MST_NO
                                    ,MST_BL_NO
                                    ,SC_NO)       
                       VALUES (V_COP_EXPT_NO
                             ,CUR_EXPT.EXPT_TP_CD
                             ,CUR_EXPT.EXPT_TP_DTL_CD
                             ,CUR_EXPT.TO_EXPT_CD
                             ,CUR_EXPT.OCCR_DT
                             ,CUR_EXPT.NOD_CD
                             ,V_EQ_CTRL_OFC_CD
                             ,in_usr_id
                             ,CUR_EXPT.SYS_DT
                             --,''
                             --,''
                             --,''
                             ,V_EQ_CTRL_OFC_CD
                             ,in_usr_id
                             ,CUR_EXPT.SYS_DT
                             ,'R'           --v_expt_sts_flg,'O'
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
                             ,CUR_EXPT.TO_ACT_CD
                             ,CUR_EXPT.TO_ESTM_DT
                             ,TO_DATE(in_act_dt,'YYYY/MM/DD HH24:MI:SS')
                             ,CUR_EXPT.SYS_DT
                             ,CUR_EXPT.BL_MST_NO
                             ,CUR_EXPT.SC_NO
                             );
                             
                             
                       v_insert_row_1 := SQL%ROWCOUNT;
                
                
                       IF v_insert_row_1 = 0  THEN
                              v_message    := 'EXCEPTION 등록건이 없습니다.';
                              v_err_cd_1   := '02';
                              DBMS_OUTPUT.PUT_LINE(v_message);
                       ELSE
                              v_cnt := v_cnt + 1;     
                              if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                  commit;
                              end if;                              
                              
                              UPDATE SCE_COP_DTL
                              SET   COP_EXPT_FLG  =  'Y'  
                              WHERE COP_NO      = CUR_EXPT.COP_NO
                              --AND   COP_GRP_SEQ = CUR_EXPT.COP_GRP_SEQ
                              AND   COP_DTL_SEQ = CUR_EXPT.COP_DTL_SEQ;
                              
                              if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                  commit;
                              end if;                              
                              
                              /* Notification Subscriber 등록 */
                              IF V_EQ_CTRL_OFC_CD <> ' ' THEN
                              
                                    v_ctr_ofc_cnt := 0; 
                                    v_ntfd_flg    :='N';
                                    
                                   
                                   /* Notification Office 찾기 */
                                   FOR NOTI IN  SEARCH_EXPT_NOTI_INFO (V_EQ_CTRL_OFC_CD,CUR_EXPT.TO_EXPT_CD,CUR_EXPT.BKG_OFC_CD
                                                                      ,CUR_EXPT.POR_CD,CUR_EXPT.POL_CD,CUR_EXPT.POD_CD,CUR_EXPT.DEL_CD, CUR_EXPT.TO_EXPT_CD)
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
                                                                    ,CUR_EXPT.TO_EXPT_CD
                                                                    ,CUR_EXPT.COP_NO
                                                                    --,CUR_EXPT.COP_GRP_SEQ
                                                                    ,CUR_EXPT.COP_DTL_SEQ
                                                                    ,NOTI.NTFD_SUBSC_ID 
                                                                    ,SUBSTR(NOTI.NTFD_SUBSC_NM,1,20)
                                                                    ,NOTI.NTFD_SUBSC_USR_EML 
                                                                    ,NOTI.ACT_FLG
                                                                    ,in_usr_id
                                                                    ,SYSDATE
                                                                    --,''
                                                                    --,''
                                                                    ,in_usr_id
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
                                                                    ,CUR_EXPT.TO_ACT_CD
                                                                    ,TO_DATE(in_act_dt,'YYYY/MM/DD HH24:MI:SS')                                                                    
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
                                      
                                               if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                                   commit;
                                               end if;
                                                      
                                               END IF;                                                                        
                                                                                                         
                                      
                                   END LOOP;
                                   
                                   
                                  /* Finded Flag of Notification Info */
                                  UPDATE SCE_EXPT_MST
                                  SET    NTFD_FLG    = v_ntfd_flg
                                  WHERE  COP_EXPT_NO = V_COP_EXPT_NO;
                              
                                  if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                      commit;
                                  end if;                                   
                                   
                                   
                              END IF;                                   
                              
                                                       
                                                          
                       END IF;
                             
                             
            
            END LOOP;
            


       /* Reefer Longstaying Exception Type 등록 대상 */
       FOR REEF_EXPT IN  SEARCH_REEF_EXPT_INFO(in_cop_no,in_cop_dtl_seq,in_act_dt,SUBSTR(in_usr_id,1,4))
       --FOR REEF_EXPT IN  SEARCH_COP_EXPT_INFO(in_cop_no,in_cop_grp_seq,in_cop_dtl_seq)
            LOOP
            DBMS_OUTPUT.PUT_LINE('Actual Delay Exception ROW Fetch');
            

                       /* Get ExceptonNO */
                       SELECT 'E'|| SUBSTR(REEF_EXPT.NOD_CD,3,3) || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) 
                              || (CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'          
                                       WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'          
                                       ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1) END )
                              || SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) || TRIM(TO_CHAR(SCE_COP_EXPT_SEQ1.NEXTVAL,'000000')) EXPT_NO INTO V_COP_EXPT_NO  
                       FROM DUAL;
                       
                       DBMS_OUTPUT.PUT_LINE('Get ExceptonNO'||V_COP_EXPT_NO||' NOD:'||REEF_EXPT.NOD_CD);
                       
                       /* Get ControlOffice */
                       --V_EQ_CTRL_OFC_CD := 'XXXXXX';
                       SELECT NVL((select EQ_CTRL_OFC_CD from mdm_location where LOC_CD = SUBSTR(REEF_EXPT.NOD_CD,1,5) ),' ') INTO V_EQ_CTRL_OFC_CD 
                       FROM DUAL;
                     
                       DBMS_OUTPUT.PUT_LINE('Get ControlOffice'||V_EQ_CTRL_OFC_CD||' TO-ACTUAL:'||in_act_dt);
                    
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
                                    --,BL_MST_NO
                                    ,MST_BL_NO
                                    ,SC_NO)       
                       VALUES (V_COP_EXPT_NO
                             ,REEF_EXPT.EXPT_TP_CD
                             ,REEF_EXPT.EXPT_TP_DTL_CD
                             ,REEF_EXPT.TO_EXPT_CD
                             ,REEF_EXPT.OCCR_DT
                             ,REEF_EXPT.NOD_CD
                             ,V_EQ_CTRL_OFC_CD
                             ,in_usr_id
                             ,REEF_EXPT.SYS_DT
                             --,''
                             --,''
                             --,''
                             ,V_EQ_CTRL_OFC_CD
                             ,in_usr_id
                             ,REEF_EXPT.SYS_DT
                             ,'R'           --v_expt_sts_flg,'O'
                             ,REEF_EXPT.VSL_CD
                             ,REEF_EXPT.SKD_VOY_NO
                             ,REEF_EXPT.SKD_DIR_CD
                             ,REEF_EXPT.VPS_PORT_CD
                             ,REEF_EXPT.ACT_STS_MAPG_CD
                             ,REEF_EXPT.CLPT_IND_SEQ
                             ,''
                             ,''
                             ,''
                             ,''
                             ,''
                             ,''
                             ,REEF_EXPT.COP_NO
                             --,REEF_EXPT.COP_GRP_SEQ
                             ,REEF_EXPT.COP_DTL_SEQ
                             ,REEF_EXPT.BKG_NO
                             --,REEF_EXPT.BKG_NO_SPLIT
                             ,REEF_EXPT.CNTR_NO
                             ,REEF_EXPT.RCV_TERM_CD
                             ,REEF_EXPT.DE_TERM_CD
                             ,REEF_EXPT.SHPR_CNT_CD
                             ,REEF_EXPT.SHPR_SEQ
                             ,REEF_EXPT.CNEE_CNT_CD
                             ,REEF_EXPT.CNEE_SEQ
                             ,REEF_EXPT.NTFY_CNT_CD
                             ,REEF_EXPT.NTFY_SEQ
                             ,REEF_EXPT.POR_CD
                             ,REEF_EXPT.POL_CD
                             ,REEF_EXPT.POD_CD
                             ,REEF_EXPT.DEL_CD
                             ,REEF_EXPT.TRNK_VVD_CD
                             ,REEF_EXPT.LODG_PORT_CD
                             ,REEF_EXPT.LST_BKG_DT
                             ,REEF_EXPT.FM_ACT_CD
                             ,REEF_EXPT.FM_ESTM_DT
                             ,REEF_EXPT.FM_ACT_DT
                             ,REEF_EXPT.FM_UPD_DT
                             ,REEF_EXPT.TO_ACT_CD
                             ,REEF_EXPT.TO_ESTM_DT
                             ,TO_DATE(in_act_dt,'YYYY/MM/DD HH24:MI:SS')
                             ,REEF_EXPT.SYS_DT
                             ,REEF_EXPT.BL_MST_NO
                             ,REEF_EXPT.SC_NO
                             );
                             
                             
                       v_insert_row_1 := SQL%ROWCOUNT;
                
                       IF v_insert_row_1 = 0  THEN
                              v_message    := 'EXCEPTION 등록건이 없습니다.';
                              v_err_cd_1   := '02';
                              DBMS_OUTPUT.PUT_LINE(v_message);
                       ELSE
                              v_cnt := v_cnt + 1;     
                              if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                  commit;
                              end if;                              
                              
                              UPDATE SCE_COP_DTL
                              SET   COP_EXPT_FLG  =  'Y'  
                              WHERE COP_NO      = REEF_EXPT.COP_NO
                              --AND   COP_GRP_SEQ = REEF_EXPT.COP_GRP_SEQ
                              AND   COP_DTL_SEQ = REEF_EXPT.COP_DTL_SEQ;
                              
                              if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                  commit;
                              end if;                              
                              
                              /* Notification Subscriber 등록 */
                              IF V_EQ_CTRL_OFC_CD <> ' ' THEN
                              
                                    v_ctr_ofc_cnt := 0; 
                                    v_ntfd_flg    :='N';
                                    
                                   
                                   /* Notification Office 찾기 */
                                   FOR NOTI IN  SEARCH_EXPT_NOTI_INFO (V_EQ_CTRL_OFC_CD,REEF_EXPT.TO_EXPT_CD,REEF_EXPT.BKG_OFC_CD
                                                                      ,REEF_EXPT.POR_CD,REEF_EXPT.POL_CD,REEF_EXPT.POD_CD,REEF_EXPT.DEL_CD, REEF_EXPT.TO_EXPT_CD)
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
                                                                    ,REEF_EXPT.EXPT_TP_CD
                                                                    ,REEF_EXPT.EXPT_TP_DTL_CD
                                                                    ,REEF_EXPT.TO_EXPT_CD
                                                                    ,REEF_EXPT.COP_NO
                                                                    --,REEF_EXPT.COP_GRP_SEQ
                                                                    ,REEF_EXPT.COP_DTL_SEQ
                                                                    ,NOTI.NTFD_SUBSC_ID 
                                                                    ,SUBSTR(NOTI.NTFD_SUBSC_NM,1,20)
                                                                    ,NOTI.NTFD_SUBSC_USR_EML 
                                                                    ,NOTI.ACT_FLG
                                                                    ,in_usr_id
                                                                    ,SYSDATE
                                                                    --,''
                                                                    --,''
                                                                    ,in_usr_id
                                                                    ,SYSDATE
                                                                    ,'00'
                                                                    ,REEF_EXPT.OCCR_DT
                                                                    ,REEF_EXPT.NOD_CD
                                                                    ,V_EQ_CTRL_OFC_CD
                                                                    ,REEF_EXPT.SC_NO
                                                                    ,REEF_EXPT.BL_MST_NO
                                                                    ,REEF_EXPT.CNTR_NO
                                                                    ,REEF_EXPT.VSL_CD
                                                                    ,REEF_EXPT.SKD_VOY_NO
                                                                    ,REEF_EXPT.SKD_DIR_CD
                                                                    ,REEF_EXPT.POR_CD
                                                                    ,REEF_EXPT.POL_CD
                                                                    ,REEF_EXPT.POD_CD
                                                                    ,REEF_EXPT.DEL_CD
                                                                    ,REEF_EXPT.SHPR_CNT_CD
                                                                    ,REEF_EXPT.SHPR_SEQ
                                                                    ,REEF_EXPT.CNEE_CNT_CD
                                                                    ,REEF_EXPT.CNEE_SEQ
                                                                    ,REEF_EXPT.NTFY_CNT_CD
                                                                    ,REEF_EXPT.NTFY_SEQ
                                                                    ,''
                                                                    ,REEF_EXPT.FM_ACT_CD
                                                                    ,REEF_EXPT.FM_ACT_DT
                                                                    ,REEF_EXPT.TO_ACT_CD
                                                                    ,TO_DATE(in_act_dt,'YYYY/MM/DD HH24:MI:SS')                                                                    
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
                                      
                                               if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                                   commit;
                                               end if;
                                                      
                                               END IF;                                                                        
                                                                                                         
                                      
                                   END LOOP;
                                   
                                   
                                  /* Finded Flag of Notification Info */
                                  UPDATE SCE_EXPT_MST
                                  SET    NTFD_FLG    = v_ntfd_flg
                                  WHERE  COP_EXPT_NO = V_COP_EXPT_NO;
                              
                                  if(in_prc_flg = 'Y') OR (in_prc_flg IS NULL OR  (in_prc_flg <> 'N' AND in_prc_flg <> 'Y'))  then
                                      commit;
                                  end if;                                   
                                   
                                   
                              END IF;                                   
                              
                                                       
                                                          
                       END IF;
                             
                             
            
            END LOOP;


            END IF;
       



       v_err_cd := v_err_cd_1 || v_err_cd_2  ;
       

       DBMS_OUTPUT.PUT_LINE('Exception 등록 건수[' || v_cnt || '] [err건수 : ' || v_err_cd ||  '] ');      
       DBMS_OUTPUT.PUT_LINE('처리종료-'||v_err_cd);

       EXCEPTION

              WHEN NO_DATA_FOUND THEN
              DBMS_OUTPUT.PUT_LINE(' NO_DATA_FOUND EXCEPTION- '|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
              ROLLBACK;

              WHEN OTHERS THEN
              DBMS_OUTPUT.PUT_LINE('WHEN OTHERS EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
              ROLLBACK;

END SCE_EXCEPTION_RESIST_ACT_PRC;
/
