CREATE OR REPLACE FUNCTION SCE_COP_GET_ROUTE_FNC
(
    IN_COP_PRD_NO  IN VARCHAR2, 
    IN_BOUND       IN VARCHAR2, -- A/O/T/I
    IN_COP_PRD     IN VARCHAR2  --C: COP / P: PRD / S: SO
)
/*******************************************************************************
   1. Object Name      : SCE_COP_GET_ROUTE_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.02.26
   4. Sub System       : SCE
   5. Author           : 강성덕
   6. Description      : PC/COP 를 인자로 BOUND 별 node/link/transmode 정보를 return 한다.
   7. Revision History : NIS2010 에 맞춰 query 수정
*******************************************************************************/
RETURN VARCHAR2

authid current_user 

IS

    RET_VAL VARCHAR2(500) := NULL;

BEGIN
    
    IF IN_COP_PRD = 'P' THEN    --PC
    
        FOR V_AA IN
        (
            SELECT
            MAX(DECODE(RNK,1,ORG_NOD_CD||'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,2,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,3,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,4,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,5,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,6,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,7,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))
            ROUTE
            FROM
            (
                SELECT
                ORG_NOD_CD,DEST_NOD_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,
                RANK() OVER(ORDER BY PCTL_NO,PCTL_SEQ) RNK
                FROM PRD_PROD_CTL_ROUT_DTL D
                WHERE   PCTL_NO = IN_COP_PRD_NO
                AND     PCTL_IO_BND_CD = DECODE(IN_BOUND,'',PCTL_IO_BND_CD,'A',PCTL_IO_BND_CD,IN_BOUND)
                AND     NOD_LNK_DIV_CD = 'L'
            )        
        )       
        LOOP
            RET_VAL := V_AA.ROUTE;    
        END LOOP;
    
    ELSIF IN_COP_PRD = 'C' THEN --COP

        FOR V_AA IN
        (
            SELECT
            MAX(DECODE(RNK,1,ORG_NOD_CD||'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,2,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,3,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,4,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,5,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,6,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,7,'-('||DECODE(PCTL_IO_BND_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))
            ROUTE
            FROM
            (
                SELECT
                ORG_NOD_CD,DEST_NOD_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,
                RANK() OVER(ORDER BY PCTL_NO,PCTL_SEQ) RNK
                FROM PRD_PROD_CTL_ROUT_DTL D
                WHERE   PCTL_NO = IN_COP_PRD_NO  -- SCE_COP_HDR  PCTL_NO
                AND     PCTL_IO_BND_CD = DECODE(IN_BOUND,'',PCTL_IO_BND_CD,'A',PCTL_IO_BND_CD,IN_BOUND)
                AND     NOD_LNK_DIV_CD = 'L'
            )           
        /*
            SELECT
            MAX(DECODE(RNK,1,ORG_NOD_CD||'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,2,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,3,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,4,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,5,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,6,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))||
            MAX(DECODE(RNK,7,'-('||DECODE(BND_VSKD_SEQ_CD,'T',
                            DECODE(VSL_CD,'',TRSP_MOD_CD,VSL_CD||SKD_VOY_NO||SKD_DIR_CD),TRSP_MOD_CD)||')-'||DEST_NOD_CD))
            ROUTE
            FROM
            (
                SELECT 
                ORG_NOD_CD,DEST_NOD_CD,BND_VSKD_SEQ_CD,TRSP_MOD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,
                RANK() OVER(ORDER BY COP_NO,COP_GRP_SEQ) RNK
                FROM SCE_COP_GRP
                WHERE   COP_NO = IN_COP_PRD_NO
                AND     BND_VSKD_SEQ_CD = DECODE(IN_BOUND,'',BND_VSKD_SEQ_CD,'A',BND_VSKD_SEQ_CD,IN_BOUND)
                AND     NOD_LNK_IND_CD = 'L'
            )  
            */     
        )       
        LOOP
            RET_VAL := V_AA.ROUTE;    
        END LOOP;
    
    ELSIF IN_COP_PRD = 'S' THEN --SO

        FOR V_AA IN
        (
            SELECT
            MAX(DECODE(BND_SEQ,1,'[O/B:'||SO_ROUTE||']'))||
            MAX(DECODE(BND_SEQ,2,' [T/S:'||SO_ROUTE||']'))||
            MAX(DECODE(BND_SEQ,3,' [I/B:'||SO_ROUTE||']')) ROUTE
            FROM
            (
                SELECT
                COP_NO,TRSP_BND_CD,DECODE(TRSP_BND_CD,'O',1,'T',2,'I',3) BND_SEQ,
                MAX(DECODE(RK,1,'('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,2,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,3,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,4,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,5,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,6,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))||
                MAX(DECODE(RK,7,',('||SO_OFC||SO_SEQ||')'||N1ST_NOD||'-'||N2ND_NOD||DECODE(N3RD_NOD,'','','-'||N3RD_NOD)||DECODE(N4TH_NOD,'','','-'||N4TH_NOD)||'('||TR_MOD||')'))
                SO_ROUTE
                FROM
                (
                    SELECT
                    COP_NO,TRSP_SO_OFC_CTY_CD SO_OFC,TRSP_SO_SEQ SO_SEQ,TRSP_BND_CD
                    --,ACT_GRP_CD
                    ,N1ST_NOD,N2ND_NOD,N3RD_NOD,N4TH_NOD,TRSP_CRR_MOD_CD TR_MOD,COST_ACT_GRP_SEQ,BND_SEQ,
                    RANK() OVER (PARTITION BY COP_NO,TRSP_BND_CD
                                 ORDER BY COP_NO,BND_SEQ,COST_ACT_GRP_SEQ) RK
                    FROM
                    (
                        --1. TRS_TRSP_SVC_ORD
                        SELECT 
                        COP_NO,TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ,
                        TRSP_BND_CD, DECODE(TRSP_BND_CD,'O',1,'T',2,'I',3) BND_SEQ,
                        --ACT_GRP_CD,
                        FM_NOD_CD N1ST_NOD,
                        (CASE
                            WHEN VIA_NOD_CD IS NULL AND DOR_NOD_CD IS NULL THEN TO_NOD_CD
                            WHEN VIA_NOD_CD IS NOT NULL AND DOR_NOD_CD IS NULL THEN VIA_NOD_CD
                            WHEN VIA_NOD_CD IS NULL AND DOR_NOD_CD IS NOT NULL THEN DOR_NOD_CD
                            WHEN VIA_NOD_CD IS NOT NULL AND DOR_NOD_CD IS NOT NULL THEN DECODE(TRSP_BND_CD,'O',DOR_NOD_CD,VIA_NOD_CD)
                        END) N2ND_NOD,
                        (CASE
                            WHEN VIA_NOD_CD IS NOT NULL AND DOR_NOD_CD IS NULL THEN TO_NOD_CD
                            WHEN VIA_NOD_CD IS NULL AND DOR_NOD_CD IS NOT NULL THEN TO_NOD_CD
                            WHEN VIA_NOD_CD IS NOT NULL AND DOR_NOD_CD IS NOT NULL THEN DECODE(TRSP_BND_CD,'I',DOR_NOD_CD,VIA_NOD_CD)
                            ELSE ''
                        END) N3RD_NOD,
                        (CASE
                            WHEN VIA_NOD_CD IS NULL OR DOR_NOD_CD IS NULL THEN ''
                            ELSE TO_NOD_CD
                        END) N4TH_NOD,
                        TRSP_CRR_MOD_CD,COST_ACT_GRP_SEQ
                        FROM TRS_TRSP_SVC_ORD 
                        WHERE COP_NO = IN_COP_PRD_NO AND TRSP_BND_CD = DECODE(IN_BOUND,'',TRSP_BND_CD,'A',TRSP_BND_CD,IN_BOUND)
                        AND NVL(DELT_FLG,'N') <> 'Y'
                        AND NVL(TRSP_FRST_FLG,'N') <> 'Y'
                        UNION ALL
                        --2. TRS_TRSP_RAIL_BIL_ORD + TRS_TRSP_RAIL_BIL_VNDR_SET
                        SELECT
                        MAX(COP_NO) COP_NO,
                        TRSP_SO_OFC_CTY_CD,
                        TRSP_SO_SEQ,
                        MAX(TRSP_BND_CD) TRSP_BND_CD,
                        MAX(DECODE(TRSP_BND_CD,'O',1,'T',2,'I',3)) BND_SEQ,
                       -- MAX(ACT_GRP_CD) ACT_GRP_CD,
                        MAX(DECODE(SUB_RAIL_SEQ,1,FM_NOD_CD)) N1ST_NOD,
                        MAX(DECODE(SUB_RAIL_SEQ,1,TO_NOD_CD)) N2ND_NOD,
                        MAX(DECODE(SUB_RAIL_SEQ,2,TO_NOD_CD)) N3RD_NOD,
                        MAX(DECODE(SUB_RAIL_SEQ,3,TO_NOD_CD)) N4TH_NOD,
                        'RD' TRSP_CRR_MOD_CD,
                        MAX(COST_ACT_GRP_SEQ) COST_ACT_GRP_SEQ
                        FROM
                        (
                            SELECT 
                            A.COP_NO,A.TRSP_BND_CD,A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,--A.ACT_GRP_CD,
                            A.COST_ACT_GRP_SEQ,
                            B.FM_NOD_CD,B.TO_NOD_CD,B.SUB_RAIL_SEQ
                            FROM 
                            TRS_TRSP_RAIL_BIL_ORD A, TRS_TRSP_RAIL_BIL_VNDR_SET B
                            WHERE A.COP_NO = IN_COP_PRD_NO AND A.TRSP_BND_CD = DECODE(IN_BOUND,'',TRSP_BND_CD,'A',TRSP_BND_CD,IN_BOUND)
                            AND NVL(A.DELT_FLG,'N') <> 'Y'
                            AND NVL(TRSP_FRST_FLG,'N') <> 'Y'
                            AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD
                            AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ
                            ORDER BY A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ,B.SUB_RAIL_SEQ
                        ) 
                        GROUP BY TRSP_SO_OFC_CTY_CD,TRSP_SO_SEQ
                    )
                    ORDER BY COP_NO,COST_ACT_GRP_SEQ
                ) A
                GROUP BY COP_NO,TRSP_BND_CD
            ) B      
        )       
        LOOP
            RET_VAL := V_AA.ROUTE;    
        END LOOP;               
    END IF;
    
    RETURN RET_VAL;
END ;
/
