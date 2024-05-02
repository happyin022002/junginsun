SELECT ORG_CHECK,DEST_CHECK,ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,
    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,
    N2ND_POL_CD,N3RD_POL_CD,N4TH_POL_CD,N1ST_SVC_TP,N2ND_SVC_TP,N3RD_SVC_TP,N4TH_SVC_TP,
    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,
    CCT,POL1,POL1_S,POD1,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1,
    POL2,POD2,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2,
    POL3,POD3,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3,
    POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4,
    POD_NODE,POD_NODE_S,CHECK_ROUT
FROM
   (
    SELECT
    (CASE WHEN O.ROUT_ORG_NOD_CD IS NULL
            AND :por = :pol AND :rcv_t = 'S' AND POL1_S ='Y' THEN 'Y'
          WHEN O.ROUT_ORG_NOD_CD IS NULL
            AND :por = :pol AND :rcv_t <> 'D' THEN 'Y'
          WHEN O.ROUT_ORG_NOD_CD IS NOT NULL
            AND (SELECT 'X' FROM PRD_NODE N
                 WHERE N.NOD_CD = O.ROUT_ORG_NOD_CD
                   AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(:rcv_t,'D','D',''),
                                                               DECODE(:rcv_t,'T','B','F','B','Y','B','S','B',''),
                                                               DECODE(:rcv_t,'T','M','F','M','Y','M','S','M',''),
                                                               DECODE(:rcv_t,'Y','Y','S','Y',''),
                                                               DECODE(:rcv_t,'Y','R','S','R',''),
                                                               DECODE(:rcv_t,'Y','P','') )
                 ) = 'X'
                 AND NVL(O.PCTL_IO_BND_CD,'I')  IN ('O','B')
                 AND DECODE(:rcv_t,'S','Y','X') =
                                        NVL((SELECT DECODE(:rcv_t,'S',YD_FCTY_TP_CFS_FLG,'X')
                                             FROM MDM_YARD
                                             WHERE YD_CD=O.ROUT_ORG_NOD_CD),'X')
                 AND O.ROUT_ORG_NOD_CD  LIKE DECODE(:rcv_t,'F','','T','',
                                                      DECODE(:por_n,'',
                                                           DECODE(:rcv_t,'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = :por),:por||'%')
                                                      ,:por_n)
                                               )

                 THEN 'Y'
          ELSE 'X'
     END) ORG_CHECK,
     (CASE WHEN I.ROUT_DEST_NOD_CD IS NULL
            AND :pod = :del AND :del_t = 'S' AND POD_NODE_S = 'Y' THEN 'Y'
           WHEN I.ROUT_DEST_NOD_CD IS NULL
            AND :pod = :del AND :del_t <> 'D' THEN 'Y'
           WHEN I.ROUT_DEST_NOD_CD IS NOT NULL
            AND (SELECT 'X' FROM PRD_NODE N
                 WHERE N.NOD_CD = I.ROUT_DEST_NOD_CD
                   AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(:del_t,'D','D',''),
                                                               DECODE(:del_t,'T','B','F','B','Y','B','S','B',''),
                                                               DECODE(:del_t,'T','M','F','M','Y','M','S','M',''),
                                                               DECODE(:del_t,'Y','Y','S','Y',''),
                                                               DECODE(:del_t,'Y','R','S','R',''),
                                                               DECODE(:del_t,'Y','P','') )
                 ) = 'X'
                 AND NVL(I.PCTL_IO_BND_CD,'I') IN ('I','B')
                 AND DECODE(:del_t,'S','Y','X') =
                                        NVL((SELECT DECODE(:del_t,'S',YD_FCTY_TP_CFS_FLG,'X')
                                             FROM MDM_YARD
                                             WHERE YD_CD=I.ROUT_DEST_NOD_CD),'X')
                 AND I.ROUT_DEST_NOD_CD  LIKE DECODE(:del_t,'F','','T','',
                                                      DECODE(:del_n,'',
                                                           DECODE(:del_t,'D',(SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = :del),:del||'%')
                                                      ,:del_n)
                                               )

                 THEN 'Y'
          ELSE 'X'
     END) DEST_CHECK,
     T.*
        FROM (
        SELECT ROWNUM,
        -- 여기서 OCN STRING으로 비교한다.
        -- 완벽히 맞춰 줄 수 없기에 NODE만 맞춰준다.
        -- WHERE 절에도 모든 LOCATION이 존재하는 지 파악한다.
        --DECODE(SIGN(INSTR(O.TRSP_MOD_CD,SUBSTR(:sOBTrspMode,1,1))),1,1,2)
        ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,
        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,
        N1ST_SVC_TP,N2ND_SVC_TP, N3RD_SVC_TP,N4TH_SVC_TP,
        N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT,
        DECODE(DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1),7)),NULL,POL1,
               DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1),7))) POL1,
        (SELECT YD_FCTY_TP_CFS_FLG
         FROM MDM_YARD
         WHERE YD_CD=DECODE(DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1),7)),NULL,POL1,
               DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POL1,1,5),1,1),7))) ) POL1_S,
        POD1,--:ocn_str,
        POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1,POL2,
        POD2,
        POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2,POL3,
        POD3,
        POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3,POL4,
        DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POD4,1,5),-1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POD4,1,5),-1),7),POD4) POD4,
        POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4,
        DECODE(DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1),7),POD_NODE),NULL,POD_NODE,
               DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1),7),POD_NODE)) POD_NODE,
        (SELECT YD_FCTY_TP_CFS_FLG
         FROM MDM_YARD
         WHERE YD_CD=DECODE(DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1),7),POD_NODE),NULL,POD_NODE,
               DECODE(SIGN(INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(:ocn_str,INSTR(:ocn_str,SUBSTR(POD_NODE,1,5),-1),7),POD_NODE))) POD_NODE_S,
        (CASE WHEN POD_NODE IS NULL THEN 'X'
              WHEN LNK_KNT = 4 AND ( POL4 IS NULL OR POD4 IS NULL OR POLT4 IS NULL OR PODT4 IS NULL
                                    OR ( N4TH_SVC_TP <> 'O' AND ( VVD4 IS NULL OR CRR4 IS NULL OR POL_SEQ4 IS NULL OR  POD_SEQ4 IS NULL) )
                                    OR ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL )
                                    OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )
                                    OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )
                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )
                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )
                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )
                   THEN 'X'
              WHEN LNK_KNT = 3 AND ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL
                                    OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )
                                    OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )
                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )
                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )
                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )
                   THEN 'X'
              WHEN LNK_KNT = 2 AND ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL
                                    OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )
                                    OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )
                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )
                   THEN 'X'
              WHEN LNK_KNT = 1 AND ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL
                                    OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )
                   THEN 'X'
            ELSE 'Y'
        END ) CHECK_ROUT
        FROM (
            SELECT /*+ NO_MERGE(B)  */
            ROWNUM, ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,
            N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,
            N1ST_SVC_TP,N2ND_SVC_TP, N3RD_SVC_TP,N4TH_SVC_TP,
            N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,
            TRIM(DECODE(INSTR(SKD_STR,'CCT'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CCT')+3,14))) CCT,
            TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL1')+4,7))) POL1,
            TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))) POD1,
            TRIM(DECODE(INSTR(SKD_STR,'POLT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT1')+5,14))) POLT1,
            TRIM(DECODE(INSTR(SKD_STR,'PODT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT1')+5,14))) PODT1,
            TRIM(DECODE(INSTR(SKD_STR,'VVD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD1')+4,9))) VVD1,
            TRIM(DECODE(INSTR(SKD_STR,'CRR1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR1')+4,4))) CRR1,
            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ1')+8,2))) POL_SEQ1,
            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ1')+8,2))) POD_SEQ1,
            TRIM(DECODE(INSTR(SKD_STR,'POL2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL2')+4,7))) POL2,
            TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7))) POD2,
            TRIM(DECODE(INSTR(SKD_STR,'POLT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT2')+5,14))) POLT2,
            TRIM(DECODE(INSTR(SKD_STR,'PODT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT2')+5,14))) PODT2,
            TRIM(DECODE(INSTR(SKD_STR,'VVD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD2')+4,9))) VVD2,
            TRIM(DECODE(INSTR(SKD_STR,'CRR2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR2')+4,4))) CRR2,
            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ2')+8,2))) POL_SEQ2,
            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ2')+8,2))) POD_SEQ2,
            TRIM(DECODE(INSTR(SKD_STR,'POL3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL3')+4,7))) POL3,
            TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7))) POD3,
            TRIM(DECODE(INSTR(SKD_STR,'POLT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT3')+5,14))) POLT3,
            TRIM(DECODE(INSTR(SKD_STR,'PODT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT3')+5,14))) PODT3,
            TRIM(DECODE(INSTR(SKD_STR,'VVD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD3')+4,9))) VVD3,
            TRIM(DECODE(INSTR(SKD_STR,'CRR3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR3')+4,4))) CRR3,
            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ3')+8,2))) POL_SEQ3,
            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ3')+8,2))) POD_SEQ3,
            TRIM(DECODE(INSTR(SKD_STR,'POL4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL4')+4,7))) POL4,
            TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7))) POD4,
            TRIM(DECODE(INSTR(SKD_STR,'POLT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT4')+5,14))) POLT4,
            TRIM(DECODE(INSTR(SKD_STR,'PODT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT4')+5,14))) PODT4,
            TRIM(DECODE(INSTR(SKD_STR,'VVD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD4')+4,9))) VVD4,
            TRIM(DECODE(INSTR(SKD_STR,'CRR4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR4')+4,4))) CRR4,
            TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ4')+8,2))) POL_SEQ4,
            TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ4')+8,2))) POD_SEQ4,
            TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7))),
                           3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7))),
                           2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7))),
                           TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))))) POD_NODE,
            SKD_STR
            FROM (
                SELECT --OCN 유무
                ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,
                N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,
                N1.VSL_SVC_TP_CD N1ST_SVC_TP,
                N2.VSL_SVC_TP_CD N2ND_SVC_TP,
                N3.VSL_SVC_TP_CD N3RD_SVC_TP,
                N4.VSL_SVC_TP_CD N4TH_SVC_TP,
                N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,
                PRD_GET_OCN_SKD_FNC(:skd_date,:skd_type,ORG_LOC_CD,DEST_LOC_CD,
                    N1ST_POL_CD,N1ST_POD_CD,N1ST_LANE_CD,N1ST_SKD_DIR_CD,N1.VSL_SVC_TP_CD,:vvd1,
                    N2ND_POL_CD,N2ND_POD_CD,N2ND_LANE_CD,N2ND_SKD_DIR_CD,N2.VSL_SVC_TP_CD,:vvd2,
                    N3RD_POL_CD,N3RD_POD_CD,N3RD_LANE_CD,N3RD_SKD_DIR_CD,N3.VSL_SVC_TP_CD,:vvd3,
                    N4TH_POL_CD,DEST_LOC_CD,N4TH_LANE_CD,N4TH_SKD_DIR_CD,N4.VSL_SVC_TP_CD,:vvd4,
                NVL(:cgo_tp,'AL'),'N') SKD_STR
                FROM PRD_OCN_ROUT A,MDM_VSL_SVC_LANE N1,MDM_VSL_SVC_LANE N2,MDM_VSL_SVC_LANE N3,MDM_VSL_SVC_LANE N4
                WHERE A.ORG_LOC_CD =:pol
                AND A.DEST_LOC_CD IN (SELECT DISTINCT PORT_CD FROM PRD_HUB_LOC_MTCH
                                     WHERE LOC_CD = :del AND PORT_CD = NVL(:pod,PORT_CD))
                AND NVL(A.UPD_IND_CD,'S') IN ('C','U','S','T','A','V','G')
                AND N1.VSL_SLAN_CD(+) = N1ST_LANE_CD
                AND N2.VSL_SLAN_CD(+) = N2ND_LANE_CD
                AND N3.VSL_SLAN_CD(+) = N3RD_LANE_CD
                AND N4.VSL_SLAN_CD(+) = N4TH_LANE_CD
                AND N1ST_POL_CD = NVL(:pol1,N1ST_POL_CD)
                AND N1ST_POD_CD = NVL(:pod1,N1ST_POD_CD)
                AND N1ST_LANE_CD IN ( NVL(:lane1,N1ST_LANE_CD),
                               (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE
                            WHERE VSL_SLAN_CD = :lane1) )
                AND NVL(N2ND_POL_CD,'X') = NVL(:pol2,NVL(N2ND_POL_CD,'X'))
                AND NVL(N2ND_POD_CD,'X') = NVL(:pod2,NVL(N2ND_POD_CD,'X'))
                AND NVL(N2ND_LANE_CD,'X') IN ( NVL(:lane2,NVL(N2ND_LANE_CD,'X')),
                              (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE
                           WHERE VSL_SLAN_CD = :lane2) )
                AND NVL(N3RD_POL_CD,'X') = NVL(:pol3,NVL(N3RD_POL_CD,'X'))
                AND NVL(N3RD_POD_CD,'X') = NVL(:pod3,NVL(N3RD_POD_CD,'X'))
                AND NVL(N3RD_LANE_CD,'X') IN ( NVL(:lane3,NVL(N3RD_LANE_CD,'X')),
                               (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE
                            WHERE VSL_SLAN_CD = :lane3) )
                AND NVL(N4TH_POL_CD,'X') = NVL(:pol4,NVL(N4TH_POL_CD,'X'))
                AND NVL(N4TH_POD_CD,'X') = NVL(:pod4,NVL(N4TH_POD_CD,'X'))
                AND NVL(N4TH_LANE_CD,'X') IN ( NVL(:lane4,NVL(N4TH_LANE_CD,'X')),
                               (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE
                            WHERE VSL_SLAN_CD = :lane4) )
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,1),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,2),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,3),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,4),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,5),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,6),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'-.......-|%.......-|-.......%',1,7),2,5),ORG_LOC_CD)) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,
                    DECODE(NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),18,5),'X'),ORG_LOC_CD,
                           SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),18,5))) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,
                    DECODE(NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),18,5),'X'),ORG_LOC_CD,
                           SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),18,5))) > 0
                AND INSTR(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,
                    DECODE(NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),18,5),'X'),ORG_LOC_CD,
                           SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),18,5))) > 0
                AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,1),18,5),
                                                     ORG_LOC_CD||'-'||N2ND_POL_CD,N1.VSL_SVC_TP_CD,
                                                     N2ND_POL_CD||'-'||N3RD_POL_CD,N2.VSL_SVC_TP_CD,
                                                     N3RD_POL_CD||'-'||N4TH_POL_CD,N3.VSL_SVC_TP_CD,
                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')
                AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,2),18,5),
                                                     ORG_LOC_CD||'-'||N2ND_POL_CD,N1.VSL_SVC_TP_CD,
                                                     N2ND_POL_CD||'-'||N3RD_POL_CD,N2.VSL_SVC_TP_CD,
                                                     N3RD_POL_CD||'-'||N4TH_POL_CD,N3.VSL_SVC_TP_CD,
                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')
                AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,3),18,5),
                                                     ORG_LOC_CD||'-'||N2ND_POL_CD,N1.VSL_SVC_TP_CD,
                                                     N2ND_POL_CD||'-'||N3RD_POL_CD,N2.VSL_SVC_TP_CD,
                                                     N3RD_POL_CD||'-'||N4TH_POL_CD,N3.VSL_SVC_TP_CD,
                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')
                AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,4),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(:ocn_str,'.......-WD-.-...-.......',1,4),18,5),
                                                     ORG_LOC_CD||'-'||N2ND_POL_CD,N1.VSL_SVC_TP_CD,
                                                     N2ND_POL_CD||'-'||N3RD_POL_CD,N2.VSL_SVC_TP_CD,
                                                     N3RD_POL_CD||'-'||N4TH_POL_CD,N3.VSL_SVC_TP_CD,
                                                     N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')
                AND (  (SELECT (CASE WHEN
                               (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE
                                    WHERE VSL_SLAN_CD =V.SLAN_CD ) = 'O' THEN 'FDR'
                                         ELSE V.SLAN_CD
                               END) SLAN_CD
                       FROM VSK_VSL_PORT_SKD  V,VSK_VSL_PORT_SKD  V2
                       WHERE V.VSL_CD= substr(:vvd,1,4)
                        and V.SKD_VOY_NO= substr(:vvd,5,4)
                        and V.SKD_DIR_CD = substr(:vvd,9,1)
                        and NVL(V.SKD_CNG_STS_CD,'N') <> 'S'
                        AND V2.VSL_CD= substr(:vvd,1,4)
                        and V2.SKD_VOY_NO= substr(:vvd,5,4)
                        and V2.SKD_DIR_CD = substr(:vvd,9,1)
                        and NVL(V2.SKD_CNG_STS_CD,'N') <> 'S'
                        AND V2.CLPT_SEQ > V.CLPT_SEQ
                        AND ROWNUM=1 )      IN ( N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,'FDR')
                    OR NVL(:vvd,'X') = 'X'
                )
                AND NOT EXISTS
                (
                   SELECT 'X' FROM PRD_MBGO_MGMT TT
                   WHERE SUBSTR (A.ORG_LOC_CD, 1, 2) = TT.FM_CNT_CD
                   AND A.TS_IND_CD = 'D'
                   AND SUBSTR (A.DEST_LOC_CD, 1, 2) = TT.TO_CNT_CD
                )
            ) B
        ) C
     ) T , PRD_INLND_ROUT_MST O, PRD_INLND_ROUT_MST I
    WHERE O.INLND_ROUT_BKG_FLG(+) = 'Y'
    AND O.ROUT_DEST_NOD_CD(+)= T.POL1
    AND :por = SUBSTR(O.ROUT_ORG_NOD_CD(+),1,5)
    AND DECODE(:rcv_t,'D','X','S','X',DECODE(:por_n,NULL,DECODE(NVL(:so_seq,0),0,:por,'X'),SUBSTR(:por_n,1,5))) <> SUBSTR(O.ROUT_DEST_NOD_CD(+),1,5) --:sPol
    AND DECODE(:rcv_t,'S',DECODE(T.POL1_S,'Y','Y',O.ROUT_ORG_NOD_CD(+)) ,'X') =  DECODE(:rcv_t,'S',O.ROUT_ORG_NOD_CD(+),'X')
    AND NVL(O.DELT_FLG(+),'N') <> 'Y'
    AND I.INLND_ROUT_BKG_FLG(+) = 'Y'
    AND I.ROUT_ORG_NOD_CD(+)= T.POD_NODE
    AND DECODE(:del_t,'D','X','S','X',DECODE(:pod_n,NULL,DECODE(NVL(:so_seq,0),0,nvl(nvl(:pod,SUBSTR(T.POD_NODE,1,5)),'X'),'X'),SUBSTR(:pod_n,1,5))) <> SUBSTR(I.ROUT_DEST_NOD_CD(+),1,5)
    AND DECODE(:del_t,'S',DECODE(T.POD_NODE_S,'Y','Y',I.ROUT_DEST_NOD_CD(+)) ,'X') =  DECODE(:del_t,'S',I.ROUT_DEST_NOD_CD(+),'X')
    AND NVL(I.DELT_FLG(+),'N') <> 'Y'
    AND I.ROUT_DEST_NOD_CD(+) LIKE :del||'%'
    )
WHERE (CHECK_ROUT <> 'Y'
    OR ORG_CHECK <> 'Y'
    OR DEST_CHECK <> 'Y' )
    AND ROWNUM =1
