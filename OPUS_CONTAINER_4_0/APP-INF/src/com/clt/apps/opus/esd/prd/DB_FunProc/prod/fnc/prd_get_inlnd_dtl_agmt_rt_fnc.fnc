CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_INLND_DTL_AGMT_RT_FNC
(
  i_crr_mod_cd        IN VARCHAR2
 ,i_vndr_seq          IN NUMBER
 ,i_rail_svc_tp_cd    IN VARCHAR2
 ,pi_io_bnd           IN VARCHAR2
 ,i_from_nod_cd       IN VARCHAR2
 ,i_to_nod_cd         IN VARCHAR2
 ,pi_agmt_ofc_cty_cd  IN VARCHAR2
 ,pi_agmt_seq         IN NUMBER
 ,pi_cmb_yn           IN VARCHAR2 DEFAULT 'N'
 ,pi_bf_cmb_yn        IN VARCHAR2 DEFAULT 'N'
 ,pi_rout_org_nod_cd  IN VARCHAR2 DEFAULT 'XX'
 ,pi_rout_dest_nod_cd IN VARCHAR2 DEFAULT 'XX'
 ,pi_rout_seq         IN NUMBER DEFAULT 0
 ,pi_rout_dtl_seq     IN NUMBER DEFAULT 0
)
RETURN VARCHAR
AUTHID CURRENT_USER IS
  v_new_rail_svc_tp_cd VARCHAR(2);
  v_cost_mod_cd        VARCHAR(2);
  o_result             VARCHAR(50);
  v_skp_flag           VARCHAR(1) := 'Y';
  pi_from_nod_cd       VARCHAR(10) := i_from_nod_cd;
  pi_to_nod_cd         VARCHAR(10) := i_to_nod_cd;
  pi_crr_mod_cd        VARCHAR(10) := i_crr_mod_cd;
  pi_vndr_seq          NUMBER := i_vndr_seq;
  pi_rail_svc_tp_cd    VARCHAR(10) := i_rail_svc_tp_cd;
BEGIN
  DBMS_OUTPUT.disable;

  IF pi_cmb_yn = 'Y' AND pi_bf_cmb_yn = 'Y' THEN
    goto end_function;
  ELSIF pi_cmb_yn = 'Y' AND pi_bf_cmb_yn = 'N' THEN
    for v1 in (select ROUT_ORG_NOD_CD
                     ,ROUT_DEST_NOD_CD
                     ,ROUT_SEQ
                     ,LNK_ORG_NOD_CD
                     ,LNK_DEST_NOD_CD
                     ,ROUT_DTL_SEQ
                     ,TRSP_MOD_CD
                     ,VNDR_SEQ
                     ,INLND_ROUT_CMB_FLG
                     ,INLND_ROUT_JUNC_NM
                     ,CRE_OFC_CD
                     ,RAIL_CRR_TP_CD
                     ,TRSP_AGMT_OFC_CTY_CD
                     ,TRSP_AGMT_SEQ
                     ,AGMT_REF_NO
                 from prd_inlnd_rout_dtl d
                where d.rout_org_nod_cd = pi_rout_org_nod_cd
                  AND d.rout_dest_nod_cd = pi_rout_dest_nod_cd
                  AND d.rout_seq = pi_rout_seq
                  and d.rout_dtl_seq >= pi_rout_dtl_seq
                order by ROUT_DTL_SEQ)
    loop
      if v1.inlnd_rout_cmb_flg = 'Y' THEN
        if v1.rout_dtl_seq = pi_rout_dtl_seq then
          pi_from_nod_cd := v1.lnk_org_nod_cd;
          pi_to_nod_cd   := v1.lnk_dest_nod_cd;
          pi_vndr_seq    := v1.vndr_seq;
          pi_crr_mod_cd  := v1.trsp_mod_cd;
        else
          pi_to_nod_cd := v1.lnk_dest_nod_cd;
          if pi_crr_mod_cd <> v1. trsp_mod_cd then
            pi_crr_mod_cd := substr(pi_crr_mod_cd, 1, 1) || substr(v1.trsp_mod_cd, 1, 1);
          end if;
        end if;
      else
        goto end_loop;
      END IF;
      <<end_loop>>
      null;
    end loop;
  END IF;

  SELECT DECODE(COUNT(ZN_CD), 0, 'CY', 'DR')
    INTO v_cost_mod_cd
    FROM MDM_ZONE
   WHERE ZN_CD IN (pi_from_nod_cd, pi_to_nod_cd)
     AND DELT_FLG = 'N';
  v_new_rail_svc_tp_cd := SUBSTR(pi_rail_svc_tp_cd, 1, 2);
  IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
    v_new_rail_svc_tp_cd := SUBSTR(pi_rail_svc_tp_cd, 1, 2);
    IF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'O' THEN
      v_cost_mod_cd := 'CY'; /* ONE    */
    ELSIF SUBSTR(pi_rail_svc_tp_cd, 2, 1) = 'R' THEN
      v_cost_mod_cd := 'DR'; /* RND */
    END IF;
  END IF;

  IF SUBSTR(pi_from_nod_cd, 1, 2) IN ('US', 'CA') OR SUBSTR(pi_to_nod_cd, 1, 2) IN ('US', 'CA') THEN
    v_skp_flag := 'N';
  END IF;

  IF v_cost_mod_cd = 'DR' THEN
    SELECT CURR_CD || '|' || EQUIPMENT_RATE || '|' || TO_CHAR(EFF_TO_DT, 'YYYY-MM-DD HH24:MI:SS')
      INTO o_result
      FROM (SELECT TRSP_AGMT_OFC_CTY_CD
                  ,TRSP_AGMT_SEQ
                  ,VNDR_SEQ
                  ,EFF_FM_DT
                  ,EFF_TO_DT
                  ,CURR_CD
                  ,EQUIPMENT_RATE
              FROM (SELECT C.TRSP_AGMT_OFC_CTY_CD
                          ,C.TRSP_AGMT_SEQ
                          ,B.VNDR_SEQ
                          ,E.EFF_FM_DT
                          ,E.EFF_TO_DT
                          ,NVL(E.CURR_CD, 'NF') CURR_CD
                          ,NVL(E.TRSP_RND_RT, 0) AS EQUIPMENT_RATE
                      FROM TRS_AGMT_HDR       A
                          ,TRS_AGMT_APLY_VNDR B
                          ,TRS_AGMT_RT_TP     C
                          ,TRS_AGMT_NOD       D
                          ,TRS_AGMT_EQ_RT     E
                     WHERE A.TRSP_AGMT_OFC_CTY_CD = NVL(pi_agmt_ofc_cty_cd, A.TRSP_AGMT_OFC_CTY_CD)
                       AND A.TRSP_AGMT_SEQ = CASE WHEN NVL(pi_agmt_ofc_cty_cd, 'X') <> 'X' AND  NVL(pi_agmt_seq, 0) <> 0 THEN pi_agmt_seq
                                                  ELSE A.TRSP_AGMT_SEQ
                                             END
                       AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
                       AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
                       AND A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD
                       AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ
                       AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD
                       AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ
                       AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO
                       AND D.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
                       AND D.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
                       AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
                       AND D.TRSP_AGMT_NOD_SEQ = E.TRSP_AGMT_NOD_SEQ
                       AND E.EQ_KND_CD = 'U'
                       AND E.TRSP_AGMT_EQ_TP_SZ_CD IN ('D4', 'DAL', 'AL4', 'ALAL')
                       AND C.CGO_TP_CD = 'F'
                       AND B.VNDR_SEQ = TO_NUMBER(pi_vndr_seq)
                       AND C.TRSP_COST_MOD_CD = 'DR'
                       AND C.AGMT_TRSP_TP_CD = pi_crr_mod_cd -- Trans Mode
                       AND DECODE(v_skp_flag, 'Y', '000', C.RAIL_SVC_TP_CD) = DECODE(v_skp_flag, 'Y', '000', NVL(v_new_rail_svc_tp_cd, '00'))
                       AND C.CUST_NOMI_TRKR_FLG = 'N'
                       AND (
                        (
                           (DECODE(pi_io_bnd, 'I', D.FM_NOD_CD, '0') = DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000'), '0'))
                           AND (D.DOR_NOD_CD =  DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), 'O', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')))
                           AND (DECODE(pi_io_bnd, 'O', D.TO_NOD_CD, '0') = DECODE(pi_io_bnd, 'O', DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), '0'))
                        )
                        OR
                        (
                               NVL(E.TRSP_RVS_APLY_FLG, 'N') = 'Y'
                           AND (DECODE(pi_io_bnd, 'I', D.TO_NOD_CD, '0') = DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000'), '0'))
                           AND (D.DOR_NOD_CD =  DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), 'O', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')))
                           AND (DECODE(pi_io_bnd, 'O', D.FM_NOD_CD, '0') = DECODE(pi_io_bnd, 'O', DECODE(LENGTH(D.FM_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), '0'))

                        )
                       )
                       AND SYSDATE BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT
                     ORDER BY
                             CASE E.TRSP_AGMT_EQ_TP_SZ_CD WHEN 'D4' THEN 1
                                                          WHEN 'DAL' THEN 2
                                                          WHEN 'AL4' THEN 3
                                                          WHEN 'ALAL' THEN 4
                              END 
                             ,C.CMDT_GRP_CD ASC                              
                             ,LENGTH(DECODE(D.FM_NOD_CD, '0000000', 'N/A', D.FM_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.VIA_NOD_CD, '0000000', 'N/A', D.VIA_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.DOR_NOD_CD, '0000000', 'N/A', D.DOR_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.TO_NOD_CD, '0000000', 'N/A', D.TO_NOD_CD)) DESC                             
                             ,E.TO_WGT ASC
                             ,E.TRSP_RVS_APLY_FLG DESC
                             ,E.TRSP_RND_RT
                             )
             WHERE ROWNUM = 1);
  ELSIF v_cost_mod_cd = 'CY' THEN
    SELECT CURR_CD || '|' || EQUIPMENT_RATE || '|' || TO_CHAR(EFF_TO_DT, 'YYYY-MM-DD HH24:MI:SS')
      INTO o_result
      FROM (SELECT TRSP_AGMT_OFC_CTY_CD
                  ,TRSP_AGMT_SEQ
                  ,VNDR_SEQ
                  ,EFF_FM_DT
                  ,EFF_TO_DT
                  ,CURR_CD
                  ,EQUIPMENT_RATE
              FROM (SELECT C.TRSP_AGMT_OFC_CTY_CD
                          ,C.TRSP_AGMT_SEQ
                          ,B.VNDR_SEQ
                          ,E.EFF_FM_DT
                          ,E.EFF_TO_DT
                          ,NVL(E.CURR_CD, 'NF') CURR_CD
                          ,NVL(E.TRSP_ONE_WY_RT, 0) AS EQUIPMENT_RATE
                      FROM TRS_AGMT_HDR       A
                          ,TRS_AGMT_APLY_VNDR B
                          ,TRS_AGMT_RT_TP     C
                          ,TRS_AGMT_NOD       D
                          ,TRS_AGMT_EQ_RT     E
                     WHERE A.TRSP_AGMT_OFC_CTY_CD = NVL(pi_agmt_ofc_cty_cd, A.TRSP_AGMT_OFC_CTY_CD)
                       AND A.TRSP_AGMT_SEQ = CASE WHEN NVL(pi_agmt_ofc_cty_cd, 'X') <> 'X' AND  NVL(pi_agmt_seq, 0) <> 0 THEN pi_agmt_seq
                                                  ELSE A.TRSP_AGMT_SEQ
                                             END
                       AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
                       AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ
                       AND A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD
                       AND A.TRSP_AGMT_SEQ = C.TRSP_AGMT_SEQ
                       AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD
                       AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ
                       AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO
                       AND D.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD
                       AND D.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ
                       AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
                       AND D.TRSP_AGMT_NOD_SEQ = E.TRSP_AGMT_NOD_SEQ
                       AND E.EQ_KND_CD = 'U'
                       AND E.TRSP_AGMT_EQ_TP_SZ_CD IN ('D4', 'DAL', 'AL4', 'ALAL')
                       AND C.CGO_TP_CD = 'F'
                       AND B.VNDR_SEQ = TO_NUMBER(pi_vndr_seq)
                       AND C.TRSP_COST_MOD_CD = 'CY'
                       AND C.AGMT_TRSP_TP_CD = pi_crr_mod_cd -- Trans Mode
                       AND DECODE(v_skp_flag, 'Y', '000', C.RAIL_SVC_TP_CD) = DECODE(v_skp_flag, 'Y', '000', NVL(v_new_rail_svc_tp_cd, '00'))
                       AND C.CUST_NOMI_TRKR_FLG = 'N'
                       AND (   (    D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')
                                AND D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
                               )
                            OR (    D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000')
                                AND D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')
                                AND NVL(E.TRSP_RVS_APLY_FLG, 'N') = 'Y'
                               )
                           )
                       AND SYSDATE BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT
                     ORDER BY 
                           CASE E.TRSP_AGMT_EQ_TP_SZ_CD WHEN 'D4' THEN 1
                                                        WHEN 'DAL' THEN 2
                                                        WHEN 'AL4' THEN 3
                                                        WHEN 'ALAL' THEN 4
                            END 
                             ,C.CMDT_GRP_CD ASC   
                             ,LENGTH(DECODE(D.FM_NOD_CD, '0000000', 'N/A', D.FM_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.VIA_NOD_CD, '0000000', 'N/A', D.VIA_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.DOR_NOD_CD, '0000000', 'N/A', D.DOR_NOD_CD)) DESC
                             ,LENGTH(DECODE(D.TO_NOD_CD, '0000000', 'N/A', D.TO_NOD_CD)) DESC
                             ,E.TO_WGT ASC
                             ,E.TRSP_RVS_APLY_FLG DESC
                             ,E.TRSP_ONE_WY_RT
                             )
             WHERE ROWNUM = 1);
  END IF;
  <<end_function>>
  null;
  RETURN o_result;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    BEGIN
      o_result := NULL;
      RETURN o_result;
    END;

END PRD_GET_INLND_DTL_AGMT_RT_FNC;
/