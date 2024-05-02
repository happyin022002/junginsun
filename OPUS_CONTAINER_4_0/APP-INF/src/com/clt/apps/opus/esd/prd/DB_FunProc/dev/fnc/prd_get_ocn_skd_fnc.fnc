CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_OCN_SKD_FNC

/* ========================================================
   1. Object Name      : PRD_GET_OCN_SKD_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.08.24
   4. Sub System       : Product Catalog
   5. Author           :
   6. Description      : 해상 운송 구간에 대한 Detail Route 정보 생성
   7. Revision History : 최초 생성
   HISTORY :
   T_LAN_ORD 를 가져오는 SQL 수정
   calling port seq 로직 반영
   SKD STS_CD 가 CLOSE 되도 최종 POD 의 DATE 보다 현재일이 작으면 허용
   SKD 조회시 앞/뒤 TS Yard 정보를 비교하여 동일한 Yard에서 TS되도록 수정
   FDR VVD를 BKG MAIN상 T.VVD에 입력한 경우 적용하도록(T_LAN_ORD) 수정
   FDR에 대해 VVD SKD조회 후 RHQ LINK 조회하도록 수정. 단 FDR DIRECT는 RHQ LINK조회 안함
   RHQ LINK로 첫 FDR읽었을 경우 VVD1이 없는 것을 이용해서, 첫 RHQ 재처리가 되도록 변경
======================================================== */

(
    ----------------------------------------PARAMETERS----------------------------------------
    V_D_PARA        IN VARCHAR2,   -- Loading Due Time ('20061115123000') / VVD (HNPT0040E)
    V_RET_DIV       IN VARCHAR2,   -- Loading Due Date (L) / VVD (V)
    V_POL           IN VARCHAR2,
    V_POD           IN VARCHAR2,

    V_POL1          IN VARCHAR2,
    V_POL1_S        IN VARCHAR2,
    V_POD1          IN VARCHAR2,
    V_POD1_S        IN VARCHAR2,
    V_LANE1         IN VARCHAR2,
    V_DIR1          IN VARCHAR2,
    V_SVC_TP1       IN VARCHAR2,
    V_VVD1          IN VARCHAR2,

    V_POL2          IN VARCHAR2,
    V_POL2_S        IN VARCHAR2,
    V_POD2          IN VARCHAR2,
    V_POD2_S        IN VARCHAR2,
    V_LANE2         IN VARCHAR2,
    V_DIR2          IN VARCHAR2,
    V_SVC_TP2       IN VARCHAR2,
    V_VVD2          IN VARCHAR2,

    V_POL3          IN VARCHAR2,
    V_POL3_S        IN VARCHAR2,
    V_POD3          IN VARCHAR2,
    V_POD3_S        IN VARCHAR2,
    V_LANE3         IN VARCHAR2,
    V_DIR3          IN VARCHAR2,
    V_SVC_TP3       IN VARCHAR2,
    V_VVD3          IN VARCHAR2,

    V_POL4          IN VARCHAR2,
    V_POL4_S        IN VARCHAR2,
    V_POD4          IN VARCHAR2,
    V_POD4_S        IN VARCHAR2,
    V_LANE4         IN VARCHAR2,
    V_DIR4          IN VARCHAR2,
    V_SVC_TP4       IN VARCHAR2,
    V_VVD4          IN VARCHAR2,

    V_CGO_TP        IN VARCHAR2,   --Special Cargo Type String : DG>RF>AK>BB>DRY 순으로 Y or N을 Concat 함. i.e. DG+DRY >> 'YNNNY', Only Dry >> 'NNNNY', RF+AK >> 'NYYNN'

    V_APL_GMT       IN VARCHAR2--,    -- Apply or not GMT('Y'/'N')

--    V_DEBUG_MODE    IN NUMBER := 0  ---- 항상 맨 마지막 Argument로 처리하도록 한다. 0 = non debug, 0 >= debug mode

    -------------------------------------------------------------------------------------------
)

RETURN VARCHAR2                 -- String of milestone Information
authid current_user
IS

    rtStr       VARCHAR2(1600)   := NULL;
    rtStr1      VARCHAR2(400)   := NULL;
    rtStr2      VARCHAR2(400)   := NULL;
    rtStr3      VARCHAR2(400)   := NULL;
    rtStr4      VARCHAR2(400)   := NULL;
    S_DATE      VARCHAR2(70)    := NULL;
    T_LAN_CD    VARCHAR2(4)     := NULL;
    T_LAN_ORD   VARCHAR2(4)     := NULL;
    LAN_CNT     VARCHAR2(4)     := NULL;
    replaceStr  VARCHAR2(800)   := NULL;

    TS1_BUF_HR  NUMBER := NULL ;
    TS2_BUF_HR  NUMBER := NULL ;
    TS3_BUF_HR  NUMBER := NULL ;

    RT_VVD1 VARCHAR2(9)     := NULL;
    RT_VVD2 VARCHAR2(9)     := NULL;
    RT_VVD3 VARCHAR2(9)     := NULL;
    RT_VVD4 VARCHAR2(9)     := NULL;

    RT_VVD1_SKD_STS_CD VARCHAR2(3)     := NULL;
    RT_VVD2_SKD_STS_CD VARCHAR2(3)     := NULL;
    RT_VVD3_SKD_STS_CD VARCHAR2(3)     := NULL;
    RT_VVD4_SKD_STS_CD VARCHAR2(3)     := NULL;


    POL1  VARCHAR2(7)     := NULL;
    POLN1 VARCHAR2(7)     := NULL;
    POD1  VARCHAR2(7)     := NULL;
    PODN1 VARCHAR2(7)     := NULL;
    POL2  VARCHAR2(7)     := NULL;
    POLN2 VARCHAR2(7)     := NULL;
    POD2  VARCHAR2(7)     := NULL;
    PODN2 VARCHAR2(7)     := NULL;
    POL3  VARCHAR2(7)     := NULL;
    POLN3 VARCHAR2(7)     := NULL;
    POD3  VARCHAR2(7)     := NULL;
    PODN3 VARCHAR2(7)     := NULL;
    POL4  VARCHAR2(7)     := NULL;
    POLN4 VARCHAR2(7)     := NULL;
    POD4  VARCHAR2(7)     := NULL;
    PODN4 VARCHAR2(7)     := NULL;
    rtPol1      VARCHAR2(400)   := NULL;
    rtPol2      VARCHAR2(400)   := NULL;
    rtPol3      VARCHAR2(400)   := NULL;
    rtPol4      VARCHAR2(400)   := NULL;
    rtPod1      VARCHAR2(400)   := NULL;
    rtPod2      VARCHAR2(400)   := NULL;
    rtPod3      VARCHAR2(400)   := NULL;
    rtPod4      VARCHAR2(400)   := NULL;


    NV_LANE1  VARCHAR2(4)     := NULL;
    NV_LANE2  VARCHAR2(4)     := NULL;
    NV_LANE3  VARCHAR2(4)     := NULL;
    NV_LANE4  VARCHAR2(4)     := NULL;




BEGIN
    DBMS_OUTPUT.ENABLE ;

    BEGIN

     DBMS_OUTPUT.ENABLE ;

        IF V_POL4 IS NOT NULL
            THEN LAN_CNT:= 4 ;
        ELSIF V_POL3 IS NOT NULL
            THEN LAN_CNT:= 3 ;
        ELSIF V_POL2 IS NOT NULL
            THEN LAN_CNT:= 2 ;
        ELSE
            LAN_CNT:= 1 ;
        END IF ;

        DBMS_OUTPUT.PUT_LINE('11111') ;

       IF V_LANE1 IS NOT NULL THEN
       SELECT DECODE(VSL_SVC_TP_CD, 'O','FDR',  V_LANE1)
       INTO  NV_LANE1
       FROM  MDM_VSL_SVC_LANE
       WHERE VSL_SLAN_CD  = NVL(V_LANE1,'X')
       AND ROWNUM = 1
       ;
       END IF;

        IF NV_LANE1 = NULL THEN
            NV_LANE1 := '' ;
        END IF ;

       DBMS_OUTPUT.PUT_LINE('NV_LANE1'||NV_LANE1) ;

       IF V_LANE2 IS NOT NULL THEN
       SELECT DECODE(VSL_SVC_TP_CD, 'O','FDR',  V_LANE2)
       INTO  NV_LANE2
       FROM  MDM_VSL_SVC_LANE
       WHERE VSL_SLAN_CD  = NVL(V_LANE2,'X')
       AND ROWNUM = 1
       ;
       END IF;

        IF NV_LANE2 = NULL THEN
            NV_LANE2 := '' ;
        END IF ;

      DBMS_OUTPUT.PUT_LINE('NV_LANE2'||NV_LANE2) ;

       IF V_LANE3 IS NOT NULL THEN
       SELECT DECODE(VSL_SVC_TP_CD, 'O','FDR',  V_LANE3)
       INTO  NV_LANE3
       FROM  MDM_VSL_SVC_LANE
       WHERE VSL_SLAN_CD  = NVL(V_LANE3,'X')
       AND ROWNUM = 1
       ;
       END IF;

       IF NV_LANE3 = NULL THEN
            NV_LANE3 := '' ;
        END IF ;


       DBMS_OUTPUT.PUT_LINE('NV_LANE3'||NV_LANE3) ;

       IF V_LANE4 IS NOT NULL THEN
       SELECT DECODE(VSL_SVC_TP_CD, 'O','FDR',  V_LANE4)
       INTO  NV_LANE4
       FROM  MDM_VSL_SVC_LANE
       WHERE VSL_SLAN_CD  = NVL(V_LANE4,'X')
       AND ROWNUM = 1
       ;
        END IF ;

      IF NV_LANE4 = NULL THEN
            NV_LANE4 := '' ;
        END IF ;


       DBMS_OUTPUT.PUT_LINE('NV_LANE4'||NV_LANE4) ;


       SELECT  CNN_BUF_HRS/24
         INTO  TS1_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(V_POD1,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD1,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL', NV_LANE1 )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL2,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL2,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE2 )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE 	V2.DCHG_CNT_CD 							=  V.DCHG_CNT_CD
                     AND  	SUBSTR(V2.DCHG_TML_CD,1,5) 				=  DECODE(V2.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD1,1,5))
                     AND  	V2.DCHG_SLAN_CD 						=  DECODE(V2.DCHG_SLAN_CD,'ALL','ALL',NV_LANE1 )
                     AND  	NVL(V2.LOD_CNT_CD,'AL')   				=  DECODE(NVL(V2.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL2,1,2))
                     AND  	SUBSTR(NVL(V2.LOD_TML_CD,'ALL'),1,5)   	=  DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL2,1,5))
                     AND  	NVL(V2.LOD_SLAN_CD,'ALL')  				=  DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE2 )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

          DBMS_OUTPUT.PUT_LINE('TS1_BUF_HR'||TS1_BUF_HR) ;

       SELECT  CNN_BUF_HRS/24
         INTO  TS2_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(V_POD2,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD2,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NV_LANE2 )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL3,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL3,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE3 )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE  V2.DCHG_CNT_CD 						=  V.DCHG_CNT_CD
                     AND  SUBSTR(V2.DCHG_TML_CD,1,5) 			=  DECODE(V2.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD2,1,5))
                     AND  V2.DCHG_SLAN_CD 						=  DECODE(V2.DCHG_SLAN_CD,'ALL','ALL',NV_LANE2 )
                     AND  NVL(V2.LOD_CNT_CD,'AL')   			=  DECODE(NVL(V2.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL3,1,2))
                     AND  SUBSTR(NVL(V2.LOD_TML_CD,'ALL'),1,5)  =  DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL3,1,5))
                     AND  NVL(V2.LOD_SLAN_CD,'ALL')  			=  DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE3 )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

          DBMS_OUTPUT.PUT_LINE('3333') ;

       SELECT  CNN_BUF_HRS/24
         INTO  TS3_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(V_POD3,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD3,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NV_LANE3 )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL4,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL4,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE4 )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE  V2.DCHG_CNT_CD 							=  V.DCHG_CNT_CD
                     AND  SUBSTR(V2.DCHG_TML_CD,1,5) 				=  DECODE(V2.DCHG_TML_CD,'ALL','ALL',SUBSTR(V_POD3,1,5))
                     AND  V2.DCHG_SLAN_CD 							=  DECODE(V2.DCHG_SLAN_CD,'ALL','ALL',NV_LANE3 )
                     AND  NVL(V2.LOD_CNT_CD,'AL')   			 	=  DECODE(NVL(V2.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(V_POL4,1,2))
                     AND  SUBSTR(NVL(V2.LOD_TML_CD,'ALL'),1,5)   	=  DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(V_POL4,1,5))
                     AND  NVL(V2.LOD_SLAN_CD,'ALL')  				=  DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL','ALL',NV_LANE4 )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

          DBMS_OUTPUT.PUT_LINE('444444') ;

        IF TS1_BUF_HR = NULL THEN
            TS1_BUF_HR := 12 ;
        END IF ;

        IF TS2_BUF_HR = NULL THEN
            TS2_BUF_HR := 12 ;
        END IF ;

        IF TS3_BUF_HR = NULL THEN
            TS3_BUF_HR := 12 ;
        END IF ;

        DBMS_OUTPUT.PUT_LINE('--------------1') ;

        IF V_RET_DIV = 'V' AND LENGTH(V_D_PARA) = 9 THEN -- VVD

        DBMS_OUTPUT.PUT_LINE('TEST1') ;

            -- FDR Link 1개로 만들어진 Ocean Route(V_LANE_CD : 1, V_LANE2~4 : NULL)에 한해
            -- T.VVD에 FDR VVD를 입력한 값을 받아 T_LAN_ORD_를 찾는다.
            -- FDR 2개 이상인경우 (ex.FDR+FDR+TRNK) FDR를 T.VVD로 입력할 경우 잘못된 T_LAN_ORD 가져올 수 있음.
            SELECT V.SLAN_CD, -- DECODE(SLAN_CD,V_LANE1,'1',V_LANE2,'2',V_LANE3,'3','4')
                  CASE WHEN V_LANE1 IN (V.SLAN_CD, DECODE(L.VSL_SVC_TP_CD,'O',DECODE(V_LANE2,NULL,'FDR','FDR','FDR',L.VSL_SLAN_CD)))
                            AND V_D_PARA = NVL(V_VVD1,V_D_PARA) THEN '1'
                       WHEN V.SLAN_CD = V_LANE2 AND V_D_PARA = NVL(V_VVD2,V_D_PARA) THEN '2'
                       WHEN V.SLAN_CD = V_LANE3 AND V_D_PARA = NVL(V_VVD3,V_D_PARA) THEN '3'
                       ELSE '4'
                  END ORD
            INTO T_LAN_CD, T_LAN_ORD
            FROM VSK_VSL_PORT_SKD V, MDM_VSL_SVC_LANE L
            WHERE V.VSL_CD = SUBSTR(V_D_PARA,1,4)
              AND V.SKD_VOY_NO = SUBSTR(V_D_PARA,5,4)
              AND V.SKD_DIR_CD = SUBSTR(V_D_PARA,9,1)
              AND L.VSL_SLAN_CD = V.SLAN_CD
              AND ROWNUM = 1 ;

            DBMS_OUTPUT.PUT_LINE('T_LAN_ORD:'||T_LAN_ORD) ;

            IF T_LAN_ORD = '4' THEN
                DBMS_OUTPUT.PUT_LINE('T_LAN_ORD:'||T_LAN_ORD);
                rtStr := NULL;

                -- 무조건 VVD가 있는 경우이며 FDR라 하더라도 VVD가 있으면 VESSEL SKD로 찾는다.
                rtStr4 := PRD_GET_VESSEL_SKD_FNC(V_D_PARA,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'V','4',V_CGO_TP,V_APL_GMT);
                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr4,INSTR(rtStr4,'ORG_ETA4')+8,14),'YYYYMMDDHH24MISS') - TS3_BUF_HR,'YYYYMMDDHH24MISS') ;--2015-05-20 BY MR JO.

                IF V_VVD3 IS NOT NULL THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(V_VVD3,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'V','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'ORG_ETA3')+8,14),'YYYYMMDDHH24MISS') - TS2_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                ELSIF V_VVD3 IS NULL AND V_SVC_TP3 <> 'O' THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'Y','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'ORG_ETA3')+8,14),'YYYYMMDDHH24MISS') - TS2_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                ELSE
                    rtStr3 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'Y','3',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr4,INSTR(rtStr4,'POL4')+4,7)),    --4th POL1 / 3rd DST_YD1
                              TRIM(SUBSTR(rtStr4,INSTR(rtStr4,'POLN4')+5,7)),   --4th POL2 / 3rd DST_YD2
                              V_APL_GMT);
                    S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'POLT3')+5,14);
                END IF ;



                IF V_VVD2 IS NOT NULL THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(V_VVD2,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'V','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETA2')+8,14),'YYYYMMDDHH24MISS') - TS1_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD2 IS NULL AND V_SVC_TP2 <> 'O' THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'Y','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETA2')+8,14),'YYYYMMDDHH24MISS') - TS1_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr2 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'Y','2',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POL3')+4,7)),    --3rd POL1 / 2nd DST_YD1
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POLN3')+5,7)),   --3rd POL2 / 2nd DST_YD2
                              V_APL_GMT);
                    S_DATE := SUBSTR(rtStr2,INSTR(rtStr2,'POLT2')+5,14);
                END IF ;

                IF V_VVD1 IS NOT NULL THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(V_VVD1,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'V','1',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD1 IS NULL AND V_SVC_TP1 <> 'O' THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr1 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7)),    --2nd POL1 / 1st DST_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7)),   --2nd POL2 / 1st DST_YD2
                              V_APL_GMT);
                END IF ;

             ELSIF T_LAN_ORD = '3' THEN
                DBMS_OUTPUT.PUT_LINE('T_LAN_ORD:'||T_LAN_ORD);
                rtStr3 := PRD_GET_VESSEL_SKD_FNC(V_D_PARA,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'V','3',V_CGO_TP,V_APL_GMT);

                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                IF V_VVD4 IS NOT NULL THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(V_VVD4,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'V','4',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD4 IS NULL AND V_SVC_TP4 <> 'O' THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr4 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7)),    -- 3rd POD1 / 4th ORG_YD1
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7)),   -- 3rd POD2 / 4th ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 4TH 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if length(V_POD4) = 7 then
                        select REGEXP_REPLACE (rtStr4, 'POD4'||substr(V_POD4,1,5)||'..','POD4'||V_POD4  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr4:['||rtStr4||'],replaceStr:'||replaceStr);
                        rtStr4 := replaceStr;
                    end if;

                END IF ;

                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'ORG_ETA3')+8,14),'YYYYMMDDHH24MISS') - TS2_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                IF V_VVD2 IS NOT NULL THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(V_VVD2,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'V','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETA2')+8,14),'YYYYMMDDHH24MISS') - TS1_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                ELSIF V_VVD2 IS NULL AND V_SVC_TP2 <> 'O' THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'Y','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETA2')+8,14),'YYYYMMDDHH24MISS') - TS1_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.

                ELSE
                    rtStr2 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'Y','2',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POL3')+4,7)),    --3rd POL1 / 2nd DST_YD1
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POLN3')+5,7)),   --3rd POL2 / 2nd DST_YD2
                              V_APL_GMT);
                    S_DATE := SUBSTR(rtStr2,INSTR(rtStr2,'POLT2')+5,14);
                END IF ;

                IF V_VVD1 IS NOT NULL THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(V_VVD1,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'V','1',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD1 IS NULL AND V_SVC_TP1 <> 'O' THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr1 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7)),    --2nd POL1 / 1st DST_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7)),   --2nd POL2 / 1st DST_YD2
                              V_APL_GMT);
                END IF ;

             ELSIF T_LAN_ORD = '2' THEN
                DBMS_OUTPUT.PUT_LINE('T_LAN_ORD:'||T_LAN_ORD);
                rtStr2 := PRD_GET_VESSEL_SKD_FNC(V_D_PARA,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'V','2',V_CGO_TP,V_APL_GMT);

                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETA2')+8,14),'YYYYMMDDHH24MISS') - TS1_BUF_HR,'YYYYMMDDHH24MISS');

                IF V_VVD1 IS NOT NULL THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(V_VVD1,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'V','1',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD1 IS NULL AND V_SVC_TP1 <> 'O' THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr1 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'Y','1',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7)),    --2nd POL1 / 1st DST_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7)),   --2nd POL2 / 1st DST_YD2
                              V_APL_GMT);
                END IF ;

                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');

                IF V_VVD3 IS NOT NULL THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(V_VVD3,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'V','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD3 IS NULL AND V_SVC_TP3 <> 'O' THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr3 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POD2')+4,7)),    --2nd POD1 / 3rd ORG_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'PODN2')+5,7)),   --2nd POD2 / 3rd ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 3rd 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if (length(V_POD3) = 7) and (LAN_CNT = 3) then
                        select REGEXP_REPLACE (rtStr3, 'POD3'||substr(V_POD3,1,5)||'..','POD3'||V_POD3  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr3:['||rtStr3||'],replaceStr:'||replaceStr);
                        rtStr3 := replaceStr;
                    end if;
                    S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14);
                END IF ;


                IF V_VVD4 IS NOT NULL THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(V_VVD4,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'V','4',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD4 IS NULL AND V_SVC_TP4 <> 'O' THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr4 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7)),    --3rd POD1 / 4th ORG_YD1
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7)),   --3rd POD2 / 4th ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 4th 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if (length(V_POD4) = 7) and (LAN_CNT = 4) then
                        select REGEXP_REPLACE (rtStr4, 'POD4'||substr(V_POD4,1,5)||'..', 'POD4'||V_POD4  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr4:['||rtStr4||'],replaceStr:'||replaceStr);
                        rtStr4 := replaceStr;
                    end if;
                END IF ;

             ELSIF T_LAN_ORD = '1' THEN
                DBMS_OUTPUT.PUT_LINE('T_LAN_ORD:'||T_LAN_ORD);
    --
                rtStr1 := PRD_GET_VESSEL_SKD_FNC(V_D_PARA,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'V','1',V_CGO_TP,V_APL_GMT);

                S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14),'YYYYMMDDHH24MISS') + TS1_BUF_HR,'YYYYMMDDHH24MISS');--2015-05-20 BY MR JO.


                IF V_VVD2 IS NOT NULL THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(V_VVD2,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'V','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD2 IS NULL AND V_SVC_TP2 <> 'O' THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'N','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr2 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'N','2',V_CGO_TP,
                              TRIM(SUBSTR(rtStr1,INSTR(rtStr1,'POD1')+4,7)),    --1st POD1 / 2nd ORG_YD1
                              TRIM(SUBSTR(rtStr1,INSTR(rtStr1,'PODN1')+5,7)),   --1st POD2 / 2nd ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 2nd 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if (length(V_POD2) = 7) and (LAN_CNT = 2) then
                        select REGEXP_REPLACE (rtStr2, 'POD2'||substr(V_POD2,1,5)||'..', 'POD2'||V_POD2  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr2:['||rtStr2||'],replaceStr:'||replaceStr);
                        rtStr2 := replaceStr;
                    end if;
                    S_DATE := SUBSTR(rtStr2,INSTR(rtStr2,'PODT2')+5,14);
                END IF ;

                IF V_VVD3 IS NOT NULL THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(V_VVD3,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'V','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD3 IS NULL AND V_SVC_TP3 <> 'O' THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr3 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POD2')+4,7)),    --2nd POD1 / 3rd ORG_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'PODN2')+5,7)),   --2nd POD2 / 3rd ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 3rd 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if (length(V_POD3) = 7) and (LAN_CNT = 3) then
                        select REGEXP_REPLACE (rtStr3, 'POD3'||substr(V_POD3,1,5)||'..', 'POD3'||V_POD3  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr3:['||rtStr3||'],replaceStr:'||replaceStr);
                        rtStr3 := replaceStr;
                    end if;
                    S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14);
                END IF ;

--                S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14);
--                S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14);--2015-05-20 BY MR JO.

                IF V_VVD4 IS NOT NULL THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(V_VVD4,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'V','4',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD4 IS NULL AND V_SVC_TP4 <> 'O' THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr4 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7)),    --3rd POD1 / 4th ORG_YD1
                              TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7)),   --3rd POD2 / 4th ORG_YD2
                              '','',
                              V_APL_GMT);

                    -- 4th 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                    if (length(V_POD4) = 7) and (LAN_CNT = 4) then
                        select REGEXP_REPLACE (rtStr4, 'POD4'||substr(V_POD4,1,5)||'..', 'POD4'||V_POD4  ) INTO replaceStr from dual;
                        DBMS_OUTPUT.PUT_LINE('rtStr4:['||rtStr4||'],replaceStr:'||replaceStr);
                        rtStr4 := replaceStr;
                    end if;
                END IF ;
             END IF ;

        ELSE
        DBMS_OUTPUT.PUT_LINE('TEST2') ;
        DBMS_OUTPUT.PUT_LINE(V_VVD1||'-'||V_SVC_TP1||'-'||LAN_CNT) ;
            S_DATE := V_D_PARA;

                IF V_VVD1 IS NOT NULL THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(V_VVD1,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'V','1',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14),'YYYYMMDDHH24MISS') + TS1_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD1 IS NULL AND V_SVC_TP1 <> 'O' THEN
                    rtStr1 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'L','1',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14),'YYYYMMDDHH24MISS') + TS1_BUF_HR,'YYYYMMDDHH24MISS');

                ELSE
                    rtStr1 := PRD_GET_FEEDER_VVD_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'L','1',V_CGO_TP,V_APL_GMT);

--                    S_DATE := SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14);
                    IF TRIM(SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14)) IS NULL AND LAN_CNT > 1 then
                        -- FEEDER DIRECT인 경우에는 반드시 VSK VVD가 있어야만 한다.
                        -- 따라서, VSK가 없는 FEEDER인 경우는, LANE이 2개 이상인 경우에만 처리한다.
                        DBMS_OUTPUT.PUT_LINE('TEST4') ;
                        rtStr1 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'N','1',V_CGO_TP,'','','','',V_APL_GMT);
                            DBMS_OUTPUT.PUT_LINE('rtStr1TT:['||rtStr1||'],replaceStr:'||replaceStr);
                        -- 1st 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                        IF (LENGTH(V_POD1) = 7) and (LAN_CNT = 1) then
                            select REGEXP_REPLACE (rtStr1, 'POD1'||substr(V_POD1,1,5)||'..', 'POD1'||V_POD1  ) INTO replaceStr from dual;
                            DBMS_OUTPUT.PUT_LINE('rtStr1:['||rtStr1||'],replaceStr:'||replaceStr);
                            rtStr1 := replaceStr;
                        END IF;
                        S_DATE := SUBSTR(rtStr1,INSTR(rtStr1,'PODT1')+5,14);
                     ELSE
                        S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14),'YYYYMMDDHH24MISS') + TS1_BUF_HR,'YYYYMMDDHH24MISS');
                    END IF;

                END IF;


--                S_DATE := SUBSTR(rtStr1,INSTR(rtStr1,'PODT1')+5,14);
--                S_DATE := SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14);--2015-05-20 BY MR JO.
                DBMS_OUTPUT.PUT_LINE('rtStr1---' ||rtStr1) ;
                DBMS_OUTPUT.PUT_LINE('sdate-----' ||SUBSTR(rtStr1,INSTR(rtStr1,'DST_ETD1')+8,14)) ;
                DBMS_OUTPUT.PUT_LINE('NEWsdate--' ||S_DATE) ;

                IF V_VVD2 IS NOT NULL THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(V_VVD2,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'V','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD2 IS NULL AND V_SVC_TP2 <> 'O' THEN
                    rtStr2 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'N','2',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr2 := PRD_GET_FEEDER_VVD_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'L','2',V_CGO_TP,V_APL_GMT);
                    IF TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14)) IS NULL THEN
                        rtStr2 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL2,V_POL2_S,V_POD2,V_POD2_S,V_LANE2,V_DIR2,'N','2',V_CGO_TP,
                                  TRIM(SUBSTR(rtStr1,INSTR(rtStr1,'POD1')+4,7)),    --1st POD1 / 2nd ORG_YD1
                                  TRIM(SUBSTR(rtStr1,INSTR(rtStr1,'PODN1')+5,7)),   --1st POD2 / 2nd ORG_YD2
                                  '','',
                                  V_APL_GMT);

                        -- 2nd 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                        IF (length(V_POD2) = 7) AND (LAN_CNT = 2) then
                            select REGEXP_REPLACE (rtStr2, 'POD2'|| substr(V_POD2,1,5)||'..', 'POD2'||V_POD2  ) INTO replaceStr from dual;
                            DBMS_OUTPUT.PUT_LINE('rtStr2:['||rtStr2||'],replaceStr:'||replaceStr);
                            rtStr2 := replaceStr;
                        END IF;
                        S_DATE := SUBSTR(rtStr2,INSTR(rtStr2,'PODT2')+5,14);
                    ELSE
                        S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr2,INSTR(rtStr2,'DST_ETD2')+8,14),'YYYYMMDDHH24MISS') + TS2_BUF_HR,'YYYYMMDDHH24MISS');
                    END IF;
                END IF ;

                IF V_VVD3 IS NOT NULL THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(V_VVD3,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'V','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSIF V_VVD3 IS NULL AND V_SVC_TP3 <> 'O' THEN
                    rtStr3 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,V_APL_GMT);
                    S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                ELSE
                    rtStr3 := PRD_GET_FEEDER_VVD_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'L','3',V_CGO_TP,V_APL_GMT);
--                    S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14);
                    IF TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14)) IS NULL THEN
                        rtStr3 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL3,V_POL3_S,V_POD3,V_POD3_S,V_LANE3,V_DIR3,'N','3',V_CGO_TP,
                                  TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POD2')+4,7)),    --2nd POD1 / 3rd ORG_YD1
                                  TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'PODN2')+5,7)),   --2nd POD2 / 3rd ORG_YD2
                                  '','',
                                  V_APL_GMT);

                        -- 3rd 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                        if (length(V_POD3) = 7) and (LAN_CNT = 3) then
                            select REGEXP_REPLACE (rtStr3, 'POD3'||substr(V_POD3,1,5)||'..', 'POD3'||V_POD3  ) INTO replaceStr from dual;
                            DBMS_OUTPUT.PUT_LINE('rtStr3:['||rtStr3||'],replaceStr:'||replaceStr);
                            rtStr3 := replaceStr;
                        end if;
                        S_DATE := SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14);
                    ELSE
                        S_DATE := TO_CHAR(TO_DATE(SUBSTR(rtStr3,INSTR(rtStr3,'DST_ETD3')+8,14),'YYYYMMDDHH24MISS') + TS3_BUF_HR,'YYYYMMDDHH24MISS');
                    END IF;
                END IF ;



                IF V_VVD4 IS NOT NULL THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(V_VVD4,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'V','4',V_CGO_TP,V_APL_GMT);
                ELSIF V_VVD4 IS NULL AND V_SVC_TP4 <> 'O' THEN
                    rtStr4 := PRD_GET_VESSEL_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,V_APL_GMT);
                ELSE
                    rtStr4 := PRD_GET_FEEDER_VVD_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'L','4',V_CGO_TP,V_APL_GMT);
                    IF TRIM(SUBSTR(rtStr4,INSTR(rtStr4,'PODT4')+5,14)) IS NULL THEN
                        rtStr4 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL4,V_POL4_S,V_POD4,V_POD4_S,V_LANE4,V_DIR4,'N','4',V_CGO_TP,
                                  TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7)),    --3rd POD1 / 4th ORG_YD1
                                  TRIM(SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7)),   --3rd POD2 / 4th ORG_YD2
                                  '','',
                                  V_APL_GMT);

                        -- 4th 가 FDR 일때 VVD없이 들어온경우 POD_N이 들어오면 무조건 반영
                        if (length(V_POD4) = 7) and (LAN_CNT = 4) then
                            select REGEXP_REPLACE (rtStr4, 'POD4'||substr(V_POD4,1,5)||'..', 'POD4'||V_POD4  ) INTO replaceStr from dual;
                            DBMS_OUTPUT.PUT_LINE('rtStr4:['||rtStr4||'],replaceStr:'||replaceStr);
                            rtStr4 := replaceStr;
                        end if;
                    END IF;
                END IF ;

                -- Loading Date를 기준으로 구하고, 첫 Vessel이 Feeder 이면서 2회 이상 TS하는 경우에만
                -- 1st POD Yard vs 2nd POL Yard 비교를 위해 2nd POL Yard를 기준으로 1st rtStr을 다시 구한다.
                -- COP Change에서 호출한 경우 V_D_PARA = NULL
                -- LINK로 찾은 경우 VVD1이 없다. 이 경우만 TERMINAL 다시 읽는다.
                IF V_SVC_TP1 = 'O' AND LAN_CNT <> 1 AND V_D_PARA IS NOT NULL AND V_VVD1 IS NULL
                   AND NVL(INSTR(rtStr1,'VVD1'),0) = 0 THEN
                    S_DATE := V_D_PARA;
                    rtStr1 := PRD_GET_FEEDER_SKD_FNC(S_DATE,V_POL1,V_POL1_S,V_POD1,V_POD1_S,V_LANE1,V_DIR1,'N','1',V_CGO_TP,
                              '','',
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7)),    --2nd POL1 / 1st DST_YD1
                              TRIM(SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7)),   --2nd POL2 / 1st DST_YD2
                              V_APL_GMT);
                END IF;
    --
        END IF;

    END;

    BEGIN

        SELECT TRIM(DECODE(INSTR(rtStr4,'VVD4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'VVD4')+4,9))) VVD4 INTO RT_VVD4
        FROM DUAL;
        DBMS_OUTPUT.PUT_LINE('RT_VVD4-:'||RT_VVD4) ;

        IF LENGTH(RT_VVD4) =9 THEN
            SELECT SKD_STS_CD INTO RT_VVD4_SKD_STS_CD
            FROM VSK_VSL_SKD V
            WHERE V.VSL_CD= SUBSTR(RT_VVD4,1,4) AND V.SKD_VOY_NO= SUBSTR(RT_VVD4,5,4) AND V.SKD_DIR_CD = SUBSTR(RT_VVD4,9,1);
        END IF;

        DBMS_OUTPUT.PUT_LINE('RT_VVD4-1' ) ;

        SELECT TRIM(DECODE(INSTR(rtStr3,'VVD3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'VVD3')+4,9))) VVD3 INTO RT_VVD3
        FROM DUAL;

        DBMS_OUTPUT.PUT_LINE('RT_VVD4-2' ) ;

        IF LENGTH(RT_VVD3) =9 THEN

            SELECT SKD_STS_CD INTO RT_VVD3_SKD_STS_CD
            FROM VSK_VSL_SKD V
            WHERE V.VSL_CD= SUBSTR(RT_VVD3,1,4) AND V.SKD_VOY_NO= SUBSTR(RT_VVD3,5,4) AND V.SKD_DIR_CD = SUBSTR(RT_VVD3,9,1);
        END IF;

        DBMS_OUTPUT.PUT_LINE('rtStr2---'||rtStr2) ;
        SELECT TRIM(DECODE(INSTR(rtStr2,'VVD2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'VVD2')+4,9))) VVD2 INTO RT_VVD2
        FROM DUAL;
        DBMS_OUTPUT.PUT_LINE('RT_VVD2---'||RT_VVD2) ;

        IF LENGTH(RT_VVD2) =9 THEN
            SELECT SKD_STS_CD INTO RT_VVD2_SKD_STS_CD
            FROM VSK_VSL_SKD V
            WHERE V.VSL_CD= SUBSTR(RT_VVD2,1,4) AND V.SKD_VOY_NO= SUBSTR(RT_VVD2,5,4) AND V.SKD_DIR_CD = SUBSTR(RT_VVD2,9,1);
        END IF;

        SELECT TRIM(DECODE(INSTR(rtStr1,'VVD1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'VVD1')+4,9))) VVD1 INTO RT_VVD1
        FROM DUAL;
        DBMS_OUTPUT.PUT_LINE('RT_VVD1---'||RT_VVD1) ;

        IF LENGTH(RT_VVD1) =9 THEN

            SELECT SKD_STS_CD INTO RT_VVD1_SKD_STS_CD
            FROM VSK_VSL_SKD V
            WHERE V.VSL_CD= SUBSTR(RT_VVD1,1,4) AND V.SKD_VOY_NO= SUBSTR(RT_VVD1,5,4) AND V.SKD_DIR_CD = SUBSTR(RT_VVD1,9,1);
        END IF;

        DBMS_OUTPUT.PUT_LINE('RT_VVD1_SKD_STS_CD------:'||RT_VVD1_SKD_STS_CD ) ;
        DBMS_OUTPUT.PUT_LINE('RT_VVD2_SKD_STS_CD------:'||RT_VVD2_SKD_STS_CD ) ;
        DBMS_OUTPUT.PUT_LINE('RT_VVD3_SKD_STS_CD------:'||RT_VVD3_SKD_STS_CD ) ;
        DBMS_OUTPUT.PUT_LINE('RT_VVD4_SKD_STS_CD------:'||RT_VVD4_SKD_STS_CD ) ;

        IF NVL(RT_VVD4_SKD_STS_CD,'X') = 'CLO' OR
           NVL(RT_VVD3_SKD_STS_CD,'X') = 'CLO' OR
           NVL(RT_VVD2_SKD_STS_CD,'X') = 'CLO' OR
           NVL(RT_VVD1_SKD_STS_CD,'X') = 'CLO'
        THEN

           IF LAN_CNT = 4 THEN
                SELECT
                    CASE WHEN
                            TO_DATE(TRIM(DECODE(INSTR(rtStr4,'PODT4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'PODT4')+5,14))),'YYYYMMDDHH24MISS') < SYSDATE
                         THEN  ''
                         ELSE rtStr4
                    END
                INTO rtStr4
                FROM DUAL;

           ELSIF LAN_CNT = 3 THEN
                SELECT
                    CASE WHEN
                            TO_DATE(TRIM(DECODE(INSTR(rtStr3,'PODT3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14))),'YYYYMMDDHH24MISS') < SYSDATE
                         THEN  ''
                         ELSE rtStr3
                    END
                INTO rtStr3
                FROM DUAL;

            ELSIF LAN_CNT = 2 THEN
                DBMS_OUTPUT.PUT_LINE('BEFORE ---rtStr2---' ||rtStr2) ;
                DBMS_OUTPUT.PUT_LINE('1111 ---rtStr2 POD2T:' ||TO_DATE( SUBSTR(rtStr2,INSTR(rtStr2,'PODT2')+5,14  ),'YYYYMMDDHH24MISS')) ;
                SELECT
                    CASE WHEN
                            TO_DATE(TRIM(DECODE(INSTR(rtStr2,'PODT2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'PODT2')+5,14))),'YYYYMMDDHH24MISS') < SYSDATE
                         THEN  ''
                         ELSE rtStr2
                    END
                INTO rtStr2
                FROM DUAL;
                DBMS_OUTPUT.PUT_LINE('AFTER ---rtStr2---' ||rtStr2) ;

            ELSE
                SELECT
                    CASE WHEN
                            TO_DATE(TRIM(DECODE(INSTR(rtStr1,'PODT1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'PODT1')+5,14))),'YYYYMMDDHH24MISS') < SYSDATE
                         THEN  ''
                         ELSE rtStr1
                    END
                INTO rtStr1
                FROM DUAL;
            END IF;
        END IF;

        SELECT
            TRIM(DECODE(INSTR(rtStr1,'POL1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POL1')+4,7))),
            TRIM(DECODE(INSTR(rtStr1,'POLN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POLN1')+5,7))),
            TRIM(DECODE(INSTR(rtStr1,'POD1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POD1')+4,7))),
            TRIM(DECODE(INSTR(rtStr1,'PODN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'PODN1')+5,7))),
            TRIM(DECODE(INSTR(rtStr2,'POL2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7))),
            TRIM(DECODE(INSTR(rtStr2,'POLN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7))),
            TRIM(DECODE(INSTR(rtStr2,'POD2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POD2')+4,7))),
            TRIM(DECODE(INSTR(rtStr2,'PODN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'PODN2')+5,7))),
            TRIM(DECODE(INSTR(rtStr3,'POL3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POL3')+4,7))),
            TRIM(DECODE(INSTR(rtStr3,'POLN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POLN3')+5,7))),
            TRIM(DECODE(INSTR(rtStr3,'POD3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7))),
            TRIM(DECODE(INSTR(rtStr3,'PODN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7))),
            TRIM(DECODE(INSTR(rtStr4,'POL4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POL4')+4,7))),
            TRIM(DECODE(INSTR(rtStr4,'POLN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POLN4')+5,7))),
            TRIM(DECODE(INSTR(rtStr4,'POD4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POD4')+4,7))),
            TRIM(DECODE(INSTR(rtStr4,'PODN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'PODN4')+5,7)))
        INTO POL1 ,POLN1, POD1 ,PODN1, POL2 , POLN2, POD2 ,PODN2,
             POL3 ,POLN3, POD3 ,PODN3, POL4 , POLN4, POD4 ,PODN4
        FROM DUAL;

    /*****************************************          1st VESSEL  POL        *************************************/
        IF POLN1 IS NOT NULL THEN
            SELECT RPAD('VVD1'||TRIM(DECODE(INSTR(rtStr1,'VVD1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'VVD1')+4,9))),13,' ')||
                   RPAD('CRR1'||TRIM(DECODE(INSTR(rtStr1,'CRR1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'CRR1')+4,4))),8,' ')||
                   RPAD('CCC'||TRIM(DECODE(INSTR(rtStr1,'CCNC'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'CCNC')+4,14))),19,' ')||
                   RPAD('ORG_ETB1'||TRIM(DECODE(INSTR(rtStr1,'ORG_ETBN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'ORG_ETBN1')+9,14))),22, ' ')||
                   RPAD('POLT1'||TRIM(DECODE(INSTR(rtStr1,'POLTN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POLTN1')+6,14))),19,' ')||
                   RPAD('POL1'||TRIM(DECODE(INSTR(rtStr1,'POLN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POLN1')+5,7))),11,' ')||
                   RPAD('POL_SEQ1'||TRIM(DECODE(INSTR(rtStr1,'POL_SEQN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POL_SEQN1')+9,2))),10,' ')
            INTO rtPol1
            FROM DUAL;
        ELSE
            SELECT RPAD('VVD1'||TRIM(DECODE(INSTR(rtStr1,'VVD1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'VVD1')+4,9))),13,' ')||
                   RPAD('CRR1'||TRIM(DECODE(INSTR(rtStr1,'CRR1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'CRR1')+4,4))),8,' ')||
                   RPAD('CCC'||TRIM(DECODE(INSTR(rtStr1,'CCC'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'CCC')+3,14))),19,' ')||
                   RPAD('ORG_ETB1'||TRIM(DECODE(INSTR(rtStr1,'ORG_ETB1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'ORG_ETB1')+8,14))),22, ' ')||
                   RPAD('POLT1'||TRIM(DECODE(INSTR(rtStr1,'POLT1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POLT1')+5,14))),19,' ')||
                   RPAD('POL1'||TRIM(DECODE(INSTR(rtStr1,'POL1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POL1')+4,7))),11,' ')||
                   RPAD('POL_SEQ1'||TRIM(DECODE(INSTR(rtStr1,'POL_SEQ1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POL_SEQ1')+8,2))),10,' ')
            INTO rtPol1
            FROM DUAL;
        END IF;
DBMS_OUTPUT.PUT_LINE('rtPol1---' ||rtPol1) ;
    /*****************************************          1st  POD            *************************************/
        select case   case when pod1 = poln2 then 1
                           when pod1 = pol2 then 1
                           when podn1 = poln2 then 2
                           when podn1 = pol2 then 2
                           else 1
                      end
               when 2 then
                    RPAD('PODT1'||TRIM(DECODE(INSTR(rtStr1,'PODTN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'PODTN1')+6,14))),19,' ')||
                    RPAD('POD1'||TRIM(DECODE(INSTR(rtStr1,'PODN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'PODN1')+5,7))),11,' ')||
                    RPAD('POD_SEQ1'||TRIM(DECODE(INSTR(rtStr1,'POD_SEQN1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POD_SEQN1')+9,2))),10,' ')
               else RPAD('PODT1'||TRIM(DECODE(INSTR(rtStr1,'PODT1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'PODT1')+5,14))),19,' ')||
                    RPAD('POD1'||TRIM(DECODE(INSTR(rtStr1,'POD1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POD1')+4,7))),11,' ')||
                    RPAD('POD_SEQ1'||TRIM(DECODE(INSTR(rtStr1,'POD_SEQ1'),0,NULL,SUBSTR(rtStr1,INSTR(rtStr1,'POD_SEQ1')+8,2))),10,' ')
               end
         into rtPod1
         from dual;
DBMS_OUTPUT.PUT_LINE('rtPod1---' ||rtPod1) ;
    /*****************************************          2nd  POL            *************************************/
        select case
                     case    case when pod1 = poln2 then pod1
                                  when pod1 = pol2 then pod1
                                  when podn1 = poln2 then podn1
                                  when podn1 = pol2 then podn1
                                  else pod1
                             end
                         when poln2 then poln2
                         when pol2 then pol2
                         else nvl(poln2, pol2)
                     end
              when poln2 then
                   RPAD('VVD2'||TRIM(DECODE(INSTR(rtStr2,'VVD2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'VVD2')+4,9))),13,' ')||
                   RPAD('CRR2'||TRIM(DECODE(INSTR(rtStr2,'CRR2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'CRR2')+4,4))),8,' ')||
                   RPAD('ORG_ETB2'||TRIM(DECODE(INSTR(rtStr2,'ORG_ETBN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETBN2')+9,14))),22, ' ')||
                   RPAD('POLT2'||TRIM(DECODE(INSTR(rtStr2,'POLTN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POLTN2')+6,14))),19,' ')||
                   RPAD('POL2'||TRIM(DECODE(INSTR(rtStr2,'POLN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POLN2')+5,7))),11,' ')||
                   RPAD('POL_SEQ2'||TRIM(DECODE(INSTR(rtStr2,'POL_SEQN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POL_SEQN2')+9,2))),10,' ')

              else RPAD('VVD2'||TRIM(DECODE(INSTR(rtStr2,'VVD2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'VVD2')+4,9))),13,' ')||
                   RPAD('CRR2'||TRIM(DECODE(INSTR(rtStr2,'CRR2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'CRR2')+4,4))),8,' ')||
                   RPAD('ORG_ETB2'||TRIM(DECODE(INSTR(rtStr2,'ORG_ETB2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'ORG_ETB2')+8,14))),22, ' ')||
                   RPAD('POLT2'||TRIM(DECODE(INSTR(rtStr2,'POLT2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POLT2')+5,14))),19,' ')||
                   RPAD('POL2'||TRIM(DECODE(INSTR(rtStr2,'POL2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POL2')+4,7))),11,' ')||
                   RPAD('POL_SEQ2'||TRIM(DECODE(INSTR(rtStr2,'POL_SEQ2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POL_SEQ2')+8,2))),10,' ')

              end
        into rtPol2
        from dual;

    /*****************************************          2nd  POD            *************************************/
        select case
                     case when pod2 = poln3  then 1
                          when pod2 = pol3 then 1
                          when podn2 = poln3 then 2
                          when podn2 = pol3 then 2
                          else 1
                     end
               when 2 then
                    RPAD('PODT2'||TRIM(DECODE(INSTR(rtStr2,'PODTN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'PODTN2')+6,14))),19,' ')||
                    RPAD('POD2'||TRIM(DECODE(INSTR(rtStr2,'PODN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'PODN2')+5,7))),11,' ')||
                    RPAD('POD_SEQ2'||TRIM(DECODE(INSTR(rtStr2,'POD_SEQN2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POD_SEQN2')+9,2))),10,' ')
               else
                    RPAD('PODT2'||TRIM(DECODE(INSTR(rtStr2,'PODT2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'PODT2')+5,14))),19,' ')||
                    RPAD('POD2'||TRIM(DECODE(INSTR(rtStr2,'POD2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POD2')+4,7))),11,' ')||
                    RPAD('POD_SEQ2'||TRIM(DECODE(INSTR(rtStr2,'POD_SEQ2'),0,NULL,SUBSTR(rtStr2,INSTR(rtStr2,'POD_SEQ2')+8,2))),10,' ')
               end
        into rtPod2
        from dual;


    /*****************************************          3rd  POL            *************************************/
        select case
                 case    case when pod2 = poln3  then pod2
                              when pod2 = pol3 then pod2
                              when podn2 = poln3 then podn2
                              when podn2 = pol3 then podn2
                              else pod2
                         end
                     when poln3 then poln3
                     when pol3 then pol3
                     else nvl(poln3, pol3)
                 end
               when poln3 then
                    RPAD('VVD3'||TRIM(DECODE(INSTR(rtStr3,'VVD3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'VVD3')+4,9))),13,' ')||
                    RPAD('CRR3'||TRIM(DECODE(INSTR(rtStr3,'CRR3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'CRR3')+4,4))),8,' ')||
                    RPAD('ORG_ETB3'||TRIM(DECODE(INSTR(rtStr3,'ORG_ETBN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'ORG_ETBN3')+9,14))),22, ' ')||
                    RPAD('POLT3'||TRIM(DECODE(INSTR(rtStr3,'POLTN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POLTN3')+6,14))),19,' ')||
                    RPAD('POL3'||TRIM(DECODE(INSTR(rtStr3,'POLN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POLN3')+5,7))),11,' ')||
                    RPAD('POL_SEQ3'||TRIM(DECODE(INSTR(rtStr3,'POL_SEQN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POL_SEQN3')+9,2))),10,' ')
               else RPAD('VVD3'||TRIM(DECODE(INSTR(rtStr3,'VVD3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'VVD3')+4,9))),13,' ')||
                    RPAD('CRR3'||TRIM(DECODE(INSTR(rtStr3,'CRR3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'CRR3')+4,4))),8,' ')||
                    RPAD('ORG_ETB3'||TRIM(DECODE(INSTR(rtStr3,'ORG_ETB3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'ORG_ETB3')+8,14))),22, ' ')||
                    RPAD('POLT3'||TRIM(DECODE(INSTR(rtStr3,'POLT3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POLT3')+5,14))),19,' ')||
                    RPAD('POL3'||TRIM(DECODE(INSTR(rtStr3,'POL3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POL3')+4,7))),11,' ')||
                    RPAD('POL_SEQ3'||TRIM(DECODE(INSTR(rtStr3,'POL_SEQ3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POL_SEQ3')+8,2))),10,' ')
               end
        into rtPol3
        from dual;

    /*****************************************          3rd  POD            *************************************/
        select case
                 case when pod3 = poln4  then 1
                      when pod3 = pol4 then 1
                      when podn3 = poln4 then 2
                      when podn3 = pol4 then 2
                      else 1
                 end
               when 2 then
                   RPAD('PODT3'||TRIM(DECODE(INSTR(rtStr3,'PODTN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'PODTN3')+6,14))),19,' ')||
                   RPAD('POD3'||TRIM(DECODE(INSTR(rtStr3,'PODN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'PODN3')+5,7))),11,' ')||
                   RPAD('POD_SEQ3'||TRIM(DECODE(INSTR(rtStr3,'POD_SEQN3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POD_SEQN3')+9,2))),10,' ')
               else
                   RPAD('PODT3'||TRIM(DECODE(INSTR(rtStr3,'PODT3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'PODT3')+5,14))),19,' ')||
                   RPAD('POD3'||TRIM(DECODE(INSTR(rtStr3,'POD3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POD3')+4,7))),11,' ')||
                   RPAD('POD_SEQ3'||TRIM(DECODE(INSTR(rtStr3,'POD_SEQ3'),0,NULL,SUBSTR(rtStr3,INSTR(rtStr3,'POD_SEQ3')+8,2))),10,' ')
               end
        into rtPod3
        from dual;


    /*****************************************          4th  POL            *************************************/
        select case
                 case    case when pod3 = poln4  then pod3
                              when pod3 = pol4 then pod3
                              when podn3 = poln4 then podn3
                              when podn3 = pol4 then podn3
                              else pod3
                         end
                     when poln4 then poln4
                     when pol4 then pol4
                     else nvl(poln4, pol4)
                 end
               when poln4 then
                    RPAD('VVD4'||TRIM(DECODE(INSTR(rtStr4,'VVD4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'VVD4')+4,9))),13,' ')||
                    RPAD('CRR4'||TRIM(DECODE(INSTR(rtStr4,'CRR4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'CRR4')+4,4))),8,' ')||
                    RPAD('ORG_ETB4'||TRIM(DECODE(INSTR(rtStr4,'ORG_ETBN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'ORG_ETBN4')+9,14))),22, ' ')||
                    RPAD('POLT4'||TRIM(DECODE(INSTR(rtStr4,'POLTN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POLTN4')+6,14))),19,' ')||
                    RPAD('POL4'||TRIM(DECODE(INSTR(rtStr4,'POLN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POLN4')+5,7))),11,' ')||
                    RPAD('POL_SEQ4'||TRIM(DECODE(INSTR(rtStr4,'POL_SEQN4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POL_SEQN4')+9,2))),10,' ')
               else
                    RPAD('VVD4'||TRIM(DECODE(INSTR(rtStr4,'VVD4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'VVD4')+4,9))),13,' ')||
                    RPAD('CRR4'||TRIM(DECODE(INSTR(rtStr4,'CRR4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'CRR4')+4,4))),8,' ')||
                    RPAD('ORG_ETB4'||TRIM(DECODE(INSTR(rtStr4,'ORG_ETB4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'ORG_ETB4')+8,14))),22, ' ')||
                    RPAD('POLT4'||TRIM(DECODE(INSTR(rtStr4,'POLT4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POLT4')+5,14))),19,' ')||
                    RPAD('POL4'||TRIM(DECODE(INSTR(rtStr4,'POL4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POL4')+4,7))),11,' ')||
                    RPAD('POL_SEQ4'||TRIM(DECODE(INSTR(rtStr4,'POL_SEQ4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POL_SEQ4')+8,2))),10,' ')
               end
        into rtPol4
        from dual;

    /*****************************************          4th  POD            *************************************/

        SELECT  RPAD('PODT4'||TRIM(DECODE(INSTR(rtStr4,'PODT4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'PODT4')+5,14))),19,' ')||
                RPAD('POD4'||TRIM(DECODE(INSTR(rtStr4,'POD4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POD4')+4,7))),11,' ')||
                RPAD('POD_SEQ4'||TRIM(DECODE(INSTR(rtStr4,'POD_SEQ4'),0,NULL,SUBSTR(rtStr4,INSTR(rtStr4,'POD_SEQ4')+8,2))),10,' ')
        INTO rtPod4
        FROM DUAL;



    EXCEPTION
          WHEN OTHERS
          THEN NULL;
    END;
    rtStr := rtPol1||rtPod1||rtPol2||rtPod2||rtPol3||rtPod3||rtPol4||rtPod4;
DBMS_OUTPUT.PUT_LINE('rtStr---' ||rtStr) ;

    RETURN rtStr;

END;
/