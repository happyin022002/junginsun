CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_CCT_FNC
/* ========================================================
   1. Object Name      : PRD_GET_CCT_FNC
   2. Version          : 1.0
   3. Create Date      : 2010.05.06
   4. Sub System       : Product Catalog
   5. Author           : 조용인
   6. Description      : CCT 산출
   7. Revision History : 2010.05.06 조용인 최초 생성
                       : 2010.08.23 - Day Type에 적용하는 -1일 Buffer 삭제
                                    - Exclude Day 적용시 토요일 2일, 일요일1일 적용
                                    - DIR(Bound) column이 삭제됨 추후 생성되는 값은 무조건 A로 Insert
                                      Rank시 Dir Column 삭제.
                                    - ETB/ETD Type에 CCT Hour 적용(등록된값 없는 경우 계산결과 그대로)
                         2010.09.16 기존에는 CCT 최종결과에 Excl.Day 적용하였으나
                                    ETB/ETD ~ CCT 사이에 Excl.Day가 포함된 경우 해당일수 제외하도록 변경
======================================================== */
(
    I_YD_CD             IN VARCHAR2,  -- CCT YARD (KRPUSHN)
    I_VSL_SLAN_CD       IN VARCHAR2,  -- CCT VSL_SLAN_CD (KJS)
    I_VSL_SLAN_DIR_CD   IN VARCHAR2,  -- CCT VSL_SLAN_DIR_CD (W)
    I_CGO_TP_CD         IN VARCHAR2,  -- CCCT CGO_TP_CD (DG,DR,RF,AL)  
    I_VVD               IN VARCHAR2,
    I_CLPT_IND_SEQ      IN VARCHAR2,  -- CCT VSL_SLAN_DIR_CD (W)
    I_ETB_DT            IN DATE,   -- VVD ETB
    I_ETD_DT            IN DATE    -- VVD ETD
) 
return DATE
authid current_user
IS
  V_CCT                 DATE;
  IS_LOOP               BOOLEAN :=TRUE;
  CNT                   NUMBER:=0;
  I_ETB                 DATE; 
  I_ETD                 DATE; 
  V_BASE_DT             DATE;
  V_BASE_CCT            DATE;
  
  V_CCT_TRUNC_FLG       VARCHAR2(1) :='';
  V_YD_BSE_CALC_FLG     VARCHAR2(1) :='';
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
  V_CGO_TP_CD           VARCHAR2(6) := '';
 
BEGIN
  	DBMS_OUTPUT.disable;
    IF I_CGO_TP_CD IS NULL THEN V_CGO_TP_CD := 'DR';
    ELSIF LENGTH(I_CGO_TP_CD) = 5 THEN 
         IF  INSTR(I_CGO_TP_CD, 'Y') =  0 THEN V_CGO_TP_CD := 'AL';
         ELSIF  INSTR(I_CGO_TP_CD, 'Y') = 1 THEN V_CGO_TP_CD := 'DR';
         ELSIF  INSTR(I_CGO_TP_CD, 'Y') = 2 THEN V_CGO_TP_CD := 'RF';
         ELSIF  INSTR(I_CGO_TP_CD, 'Y') = 3 THEN V_CGO_TP_CD := 'AK';
         ELSIF  INSTR(I_CGO_TP_CD, 'Y') = 4 THEN V_CGO_TP_CD := 'BB';
         ELSIF  INSTR(I_CGO_TP_CD, 'Y') = 5 THEN V_CGO_TP_CD := 'DR';
         ELSE V_CGO_TP_CD := 'DR';
         END IF;
    ELSE V_CGO_TP_CD :=  I_CGO_TP_CD;
    END IF;
    BEGIN 
      IF I_VVD IS NOT NULL THEN
           SELECT 
              (CASE WHEN V_CGO_TP_CD  ='DG' THEN NVL(DCGO_CLZ_DT, CGO_CLZ_DT)
                    WHEN V_CGO_TP_CD  ='RF' THEN NVL(RC_CLZ_DT, CGO_CLZ_DT)
                    WHEN V_CGO_TP_CD = 'AK' THEN NVL(AWK_CGO_CLZ_DT, CGO_CLZ_DT)
                    WHEN V_CGO_TP_CD = 'BB' THEN NVL(BB_CGO_CLZ_DT, CGO_CLZ_DT)                        
                    ELSE CGO_CLZ_DT 
               END )
           INTO V_CCT
           FROM VSK_VSL_PORT_SKD
           WHERE VSL_CD   = SUBSTR(I_VVD,1,4)
           AND SKD_VOY_NO = SUBSTR(I_VVD,5,4) 
           AND SKD_DIR_CD = SUBSTR(I_VVD,9,1) 
           AND VPS_PORT_CD= SUBSTR(I_YD_CD,1,5)
           AND CLPT_IND_SEQ = NVL(I_CLPT_IND_SEQ, CLPT_IND_SEQ) 
           AND ROWNUM = 1;
      END IF ;        
      IF V_CCT IS NOT NULL THEN 
          DBMS_OUTPUT.PUT_LINE('V_CCT VVD :  ' ||V_CCT) ;        
          RETURN V_CCT ;  
      END IF ;

      EXCEPTION WHEN OTHERS THEN 
                DBMS_OUTPUT.PUT_LINE('V_CCT1 :  ' ||V_CCT) ;
                NULL ;
    END  ;
    BEGIN   
      SELECT NVL(CCT_FILE_FLG, '0')
            ,NVL(YD_BSE_CALC_FLG, '0')
            ,CCT_TP_CD
            ,CCT_HR
            ,CCT_DY_CD
            ,CCT_HRMNT
            ,XCLD_HOL_FRI_FLG
            ,XCLD_HOL_SAT_FLG
            ,XCLD_HOL_SUN_FLG
            ,XCLD_HOL_HOL_FLG
        INTO V_CCT_TRUNC_FLG
            ,V_YD_BSE_CALC_FLG
            ,V_CCT_TP_CD
            ,V_CCT_HR
            ,V_CCT_DY_CD
            ,V_CCT_HRMNT
            ,V_XCLD_HOL_FRI_FLG
            ,V_XCLD_HOL_SAT_FLG
            ,V_XCLD_HOL_SUN_FLG
            ,V_XCLD_HOL_HOL_FLG
        FROM (SELECT CCT_FILE_FLG
                    ,YD_BSE_CALC_FLG
                    ,CCT_TP_CD
                    ,CCT_HR
                    ,CCT_DY_CD
                    ,CCT_HRMNT
                    ,XCLD_HOL_FRI_FLG
                    ,XCLD_HOL_SAT_FLG
                    ,XCLD_HOL_SUN_FLG
                    ,XCLD_HOL_HOL_FLG
                    ,RANK() OVER(PARTITION BY YD_CD ORDER BY DECODE(CGO_TP_CD, V_CGO_TP_CD, 1, 2)) RNK
                FROM PRD_TML_CCT_MGMT X
               WHERE YD_CD = I_YD_CD
                 AND VSL_SLAN_CD IN (NVL(I_VSL_SLAN_CD, 'ALL'), 'ALL')
                 AND NVL(DELT_FLG, 'N') <> 'Y'
                 AND VSL_SLAN_DIR_CD IN (I_VSL_SLAN_DIR_CD, 'A')
                 AND CGO_TP_CD IN (V_CGO_TP_CD, 'AL')
                 AND DECODE(VSL_SLAN_CD, 'ALL', 20, 0) + DECODE(VSL_SLAN_DIR_CD, 'A', 10, 0) + DECODE(CGO_TP_CD, 'AL', 1, 0) =
                     (SELECT MIN(DECODE(Y.VSL_SLAN_CD, 'ALL', 20, 0) + DECODE(Y.VSL_SLAN_DIR_CD, 'A', 10, 0) + DECODE(Y.CGO_TP_CD, 'AL', 1, 0))
                        FROM PRD_TML_CCT_MGMT Y
                       WHERE X.YD_CD = Y.YD_CD
                         AND NVL(Y.DELT_FLG, 'N') <> 'Y'
                         AND Y.VSL_SLAN_CD IN (NVL(I_VSL_SLAN_CD, 'ALL'), 'ALL')
                         AND Y.VSL_SLAN_DIR_CD IN (NVL(I_VSL_SLAN_DIR_CD, 'A'), 'A')
                         AND Y.CGO_TP_CD IN (NVL(V_CGO_TP_CD, 'AL'), 'AL')))
       WHERE RNK = 1;
      
       SELECT  NVL(GATE_OPN_HRMNT,'0000'), NVL(GATE_CLZ_HRMNT,'2359'),
               NVL(HOL_GATE_OPN_HRMNT,'0000'),NVL(HOL_GATE_CLZ_HRMNT,'2359'),
               NVL(SUN_GATE_OPN_HRMNT,'0000'),NVL(SUN_GATE_CLZ_HRMNT,'2359'),
               NVL(SAT_GATE_OPN_HRMNT,'0000'),NVL(SAT_GATE_CLZ_HRMNT,'2359')
         INTO  V_GATE_OPN_HRMNT,V_GATE_CLZ_HRMNT,   
               V_HOL_GATE_OPN_HRMNT,V_HOL_GATE_CLZ_HRMNT, 
               V_SUN_GATE_OPN_HRMNT,V_SUN_GATE_CLZ_HRMNT, 
               V_SAT_GATE_OPN_HRMNT,V_SAT_GATE_CLZ_HRMNT  
         FROM  MDM_YARD
        WHERE  YD_CD = I_YD_CD ; 
    
    DBMS_OUTPUT.PUT_LINE('V_CCT_TRUNC_FLG :  ' || V_CCT_TRUNC_FLG);
    
    IF V_CCT_TRUNC_FLG = '1' THEN 
        I_ETB := TRUNC(I_ETB_DT) ;
        I_ETD := TRUNC(I_ETD_DT) ;
    ELSE
        I_ETB := I_ETB_DT ;
        I_ETD := I_ETD_DT ;
    END IF ;

    IF V_CCT_TP_CD IN ('ETB','ETD') AND V_YD_BSE_CALC_FLG = '1' THEN
        V_CCT_HRMNT := NULL ;
    END IF ;
    V_CCT :=  CASE  
                WHEN V_CCT_TP_CD = 'ETB' THEN TO_DATE(TO_CHAR(TRUNC(I_ETB - V_CCT_HR /24), 'YYYY/MM/DD') ||NVL(V_CCT_HRMNT,TO_CHAR(I_ETB - V_CCT_HR /24,'HH24MI')), 'YYYY/MM/DD HH24MI') 
                WHEN V_CCT_TP_CD = 'ETD' THEN TO_DATE(TO_CHAR(TRUNC(I_ETD - V_CCT_HR /24), 'YYYY/MM/DD') ||NVL(V_CCT_HRMNT,TO_CHAR(I_ETD - V_CCT_HR /24,'HH24MI')), 'YYYY/MM/DD HH24MI') 
                                                    
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
                           ) , 'YYYY/MM/DD') ||V_CCT_HRMNT, 'YYYY/MM/DD HH24MI')
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
                            ) , 'YYYY/MM/DD') ||V_CCT_HRMNT, 'YYYY/MM/DD HH24MI')
                      ELSE  TO_DATE(TO_CHAR(TRUNC(I_ETB - 7,'d') + 
                            (
                            CASE  WHEN V_CCT_DY_CD = 'SUN' THEN 0
                                  WHEN V_CCT_DY_CD = 'MON' THEN 1
                                  WHEN V_CCT_DY_CD = 'TUE' THEN 2
                                  WHEN V_CCT_DY_CD = 'WED' THEN 3
                                  WHEN V_CCT_DY_CD = 'THU' THEN 4
                                  WHEN V_CCT_DY_CD = 'FRI' THEN 5
                                  WHEN V_CCT_DY_CD = 'SAT' THEN 6
                            END
                            ) , 'YYYY/MM/DD') ||V_CCT_HRMNT, 'YYYY/MM/DD HH24MI')
                      END      
                 -- CMN : ETB 하루전 특정시간
                 WHEN V_CCT_TP_CD ='CMN' THEN TO_DATE(TO_CHAR(I_ETB - 1  , 'YYYY/MM/DD') || V_CCT_HRMNT, 'YYYY/MM/DD HH24MI')
             END ;
    V_BASE_DT := CASE WHEN V_CCT_TP_CD = 'ETD' THEN I_ETD 
                      ELSE I_ETB 
                  END ;

    WHILE IS_LOOP AND CNT <30 AND V_YD_BSE_CALC_FLG = '0' LOOP
        IF ( V_XCLD_HOL_HOL_FLG ='1' AND PRD_GET_HOL_DAY( SUBSTR(I_YD_CD,1,5), V_BASE_DT  ) ='Y' ) OR 
           ( V_XCLD_HOL_FRI_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 6 ) OR
           ( V_XCLD_HOL_SAT_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 7 ) OR
           ( V_XCLD_HOL_SUN_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 1 )             
          THEN             
            V_CCT := V_CCT-1;  
        ELSIF TRUNC(V_CCT) >= TRUNC(V_BASE_DT) 
                AND NOT ( V_XCLD_HOL_HOL_FLG ='1' AND PRD_GET_HOL_DAY( SUBSTR(I_YD_CD,1,5), V_BASE_DT  ) ='Y' ) 
                AND NOT ( V_XCLD_HOL_FRI_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 6 )  
                AND NOT ( V_XCLD_HOL_SAT_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 7 ) 
                AND NOT ( V_XCLD_HOL_SUN_FLG ='1' AND TO_CHAR(V_BASE_DT,'d') = 1 ) 
          THEN 
             IS_LOOP:=FALSE ;   
        END IF;         
       
        CNT:=CNT+1;
        V_BASE_DT := V_BASE_DT - 1 ;
        
    END LOOP;
    V_BASE_CCT := V_CCT ;
    WHILE  IS_LOOP AND CNT <30 AND V_YD_BSE_CALC_FLG = '1' LOOP
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
        END IF ;  
        
        
        IF V_GATE_TO_HRMNT = '0000' THEN V_CCT := V_CCT -1 ;   -- 노는 날
        ELSIF  TO_CHAR(V_CCT,'HH24MI') > V_GATE_CLZ_HRMNT OR V_BASE_CCT > V_CCT THEN 
            V_CCT := TO_DATE(TO_CHAR(V_CCT,'YYYYMMDD') ||V_GATE_CLZ_HRMNT,'YYYYMMDDHH24MI') ;          
            IS_LOOP := FALSE ;
        ELSE 
            IS_LOOP := FALSE ;
        END IF ;            
            
        CNT:=CNT+1;
        
    END LOOP;
    EXCEPTION
          WHEN OTHERS
          THEN V_CCT := TRUNC(I_ETB_DT) - 7 /24 ; -- Default etb 전날 17:00              
              dbms_output.put_line('V_CCT-Exce ;;; ' || V_CCT);
              RETURN V_CCT;   
    END ;
    dbms_output.put_line('V_CCT ;;; ' || V_CCT);
    RETURN V_CCT;  
END ;
/