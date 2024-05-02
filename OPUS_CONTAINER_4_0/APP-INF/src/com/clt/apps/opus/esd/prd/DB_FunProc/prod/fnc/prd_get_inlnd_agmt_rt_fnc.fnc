CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_INLND_AGMT_RT_FNC
( 
  i_rout_org_nod_cd  IN VARCHAR 
 ,i_rout_dest_nod_cd IN VARCHAR 
 ,i_rout_seq         IN NUMBER 
 ,i_conti_cd         IN VARCHAR DEFAULT 'M' 
) RETURN VARCHAR authid current_user IS 
  O_RESULT  VARCHAR(50); 
  V_CURR_CD VARCHAR2(3) := 'NF'; 
  V_RATE    NUMBER(9, 2) := 0; 
  V_DIFF    VARCHAR(1) := 'Y'; 
 
  CURSOR T1 IS 
    SELECT regexp_substr(x1.r, '[^ |]+', 1, 1) curr_cd 
          ,regexp_substr(x1.r, '[^ |]+', 1, 2) rate 
          ,regexp_substr(x1.r, '[^ |]+', 1, 3) exp_to_dt 
      FROM (SELECT PRD_GET_INLND_DTL_AGMT_RT_FNC(d.trsp_mod_cd, d.vndr_seq, d.rail_crr_tp_cd, m.pctl_io_bnd_cd, d.lnk_org_nod_cd, d.lnk_dest_nod_cd, 
                                                 d.trsp_agmt_ofc_cty_cd, d.trsp_agmt_seq, 
                                                 DECODE(i_conti_cd, 'M', 'N', NVL(d.inlnd_rout_cmb_flg, 'N')), 
                                                 DECODE(i_conti_cd, 'M', 'N', NVL(LAG(d.inlnd_rout_cmb_flg) OVER(ORDER BY d.rout_org_nod_cd, d.rout_dest_nod_cd, d.rout_seq, d.rout_dtl_seq), 'N')), 
                                                 d.rout_org_nod_cd, d.rout_dest_nod_cd, d.rout_seq, d.rout_dtl_seq) r 
              FROM prd_inlnd_rout_mst m 
                  ,prd_inlnd_rout_dtl d 
             WHERE m.rout_org_nod_cd = i_rout_org_nod_cd 
               AND m.rout_dest_nod_cd = i_rout_dest_nod_cd 
               AND m.rout_seq = i_rout_seq 
               AND m.rout_org_nod_cd = d.rout_org_nod_cd 
               AND m.rout_dest_nod_cd = d.rout_dest_nod_cd 
               AND m.rout_seq = d.rout_seq 
             ORDER BY d.rout_org_nod_cd 
                     ,d.rout_dest_nod_cd 
                     ,d.rout_seq 
                     ,d.rout_dtl_seq) x1; 
 
BEGIN 
  FOR T IN T1 
  LOOP 
    IF V_CURR_CD <> 'NF' AND V_CURR_CD <> TRIM(T.CURR_CD) THEN 
      IF T.CURR_CD <> 'NF' THEN 
        V_DIFF := 'N'; 
        EXIT; 
      END IF; 
    ELSIF V_CURR_CD = 'NF' AND V_CURR_CD <> T.CURR_CD THEN 
      V_CURR_CD := T.CURR_CD; 
    ELSE 
      V_CURR_CD := 'NF'; 
    END IF; 
  END LOOP; 
 
  FOR T IN T1 
  LOOP 
    IF V_DIFF = 'Y' AND NVL(T.CURR_CD, 'NF') <> 'NF' THEN 
      V_CURR_CD := T.CURR_CD; 
      V_RATE    := V_RATE + T.RATE; 
    ELSIF V_DIFF = 'N' AND NVL(T.CURR_CD, 'NF') <> 'NF' THEN 
      V_CURR_CD := 'M/C'; 
      IF T.CURR_CD = 'USD' THEN 
        V_RATE := V_RATE + T.RATE; 
      ELSE 
        V_RATE := V_RATE + TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(T.CURR_CD, T.RATE, TO_CHAR(SYSDATE, 'YYYYMM')); 
      END IF; 
    END IF; 
  END LOOP; 
 
  IF V_CURR_CD = 'NF' THEN 
    O_RESULT := 'N/F|'; 
  ELSE 
    O_RESULT := V_CURR_CD || '|' || V_RATE; 
  END IF; 
  RETURN(O_RESULT); 
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
    RETURN NULL; 
END PRD_GET_INLND_AGMT_RT_FNC;
/

