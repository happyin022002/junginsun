CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_INLND_RATE_FNC
(
       i_rout_org_nod_cd  IN VARCHAR,
       i_rout_dest_nod_cd IN VARCHAR,
			 i_rout_seq         IN NUMBER
) RETURN VARCHAR 
 authid current_user
IS
	O_RESULT  VARCHAR(50);
	V_CURR_CD VARCHAR2(3) := 'NF';
	V_RATE    NUMBER(9, 2) := 0;
	V_DIFF    VARCHAR(1) := 'Y';
	CURSOR T1 IS
		SELECT X1.ROUT_ORG_NOD_CD
					,X1.ROUT_DEST_NOD_CD
					,X1.ROUT_SEQ
					,X1.PRIO_SEQ
					,X1.LNK_ORG_NOD_CD
					,X1.LNK_DEST_NOD_CD
					,X1.ROUT_DTL_SEQ
					,X1.TRSP_MOD_CD
					,X1.LNK_ORG_LOC
					,X1.LNK_ORG_TYPE
					,X1.LNK_DEST_LOC
					,X1.LNK_DEST_TYPE
					,X1.CNT
					,X1.SUM_TT_TIME
					,X1.VNDR_SEQ
					,X1.LNK_DIST
					,X1.DIST_UT_CD
					,X1.CRE_OFC_CD
					,X1.RAIL_CRR_TP_CD
					,X1.INLND_ROUT_INV_BIL_PATT_CD
					,X1.ROUT_PLN_CD
					,X1.MCNTR_ROUT_FLG
					,X1.TZTM_HRS
					,X1.INLND_ROUT_RMK
					,X1.INLND_ROUT_CMB_FLG
					,X1.VNDR_ABBR_NM
					,X1.INLND_ROUT_JUNC_NM
					,X1.FMT_TZTM_HRS
					,X1.FC
					,X1.CC
					,X1.INLND_ROUT_BKG_FLG
					,X1.TRSP_AGMT_OFC_CTY_CD
					,X1.TRSP_AGMT_SEQ
					,X1.AGMT_NO
					,X1.AGMT_REF_NO
					,X1.R
					,NVL(regexp_substr(x1.r, '[^ |]+', 1, 1), 'NF') CURR_CD
					,NVL(regexp_substr(x1.r, '[^ |]+', 1, 2), 0) RATE
					,regexp_substr(x1.r, '[^ |]+', 1, 3) EXP_DT
			FROM (SELECT A.ROUT_ORG_NOD_CD
									,A.ROUT_DEST_NOD_CD
									,A.ROUT_SEQ
									,A.PRIO_SEQ
									,A.LNK_ORG_NOD_CD
									,A.LNK_DEST_NOD_CD
									,A.ROUT_DTL_SEQ
									,A.TRSP_MOD_CD
									,A.LNK_ORG_LOC
									,A.LNK_ORG_TYPE
									,A.LNK_DEST_LOC
									,A.LNK_DEST_TYPE
									,A.CNT
									,A.SUM_TT_TIME
									,A.VNDR_SEQ
									,A.LNK_DIST
									,A.DIST_UT_CD
									,A.CRE_OFC_CD
									,A.RAIL_CRR_TP_CD
									,A.INLND_ROUT_INV_BIL_PATT_CD
									,A.ROUT_PLN_CD
									,A.MCNTR_ROUT_FLG
									,A.TZTM_HRS
									,A.INLND_ROUT_RMK
									,A.INLND_ROUT_CMB_FLG
									,A.VNDR_ABBR_NM
									,A.INLND_ROUT_JUNC_NM
									,A.FMT_TZTM_HRS
									,A.FC
									,A.CC
									,A.INLND_ROUT_BKG_FLG
									,A.TRSP_AGMT_OFC_CTY_CD
									,A.TRSP_AGMT_SEQ
									,A.AGMT_NO
									,A.AGMT_REF_NO
									,PRD_GET_INLND_DTL_RATE_FNC(a.trsp_mod_cd, a.vndr_seq, a.rail_crr_tp_cd, a.pctl_io_bnd_cd, a.lnk_org_nod_cd, a.lnk_dest_nod_cd) r
							FROM (SELECT m.rout_org_nod_cd
													,m.rout_dest_nod_cd
													,m.rout_seq
													,m.prio_seq
													,m.pctl_io_bnd_cd
													,d.lnk_org_nod_cd
													,d.lnk_dest_nod_cd
													,d.rout_dtl_seq
													,d.trsp_mod_cd
													,substr(d.lnk_org_nod_cd, 1, 5) lnk_org_loc
													,substr(d.lnk_org_nod_cd, 6) lnk_org_type
													,substr(d.lnk_dest_nod_cd, 1, 5) lnk_dest_loc
													,substr(d.lnk_dest_nod_cd, 6) lnk_dest_type
													,COUNT(*) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt
													,SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time
													,d.vndr_seq
													,l.lnk_dist
													,l.dist_ut_cd
													,l.cre_ofc_cd
													,d.rail_crr_tp_cd
													,m.inlnd_rout_inv_bil_patt_cd
													,DECODE(m.rout_pln_cd, 'N', '', m.rout_pln_cd) rout_pln_cd
													,m.mcntr_rout_flg
													,l.tztm_hrs
													,m.inlnd_rout_rmk
													,d.inlnd_rout_cmb_flg
													,v.vndr_lgl_eng_nm vndr_abbr_nm
													,d.inlnd_rout_junc_nm
													,ltrim(to_char(trunc(l.tztm_hrs / 24, 0), '00')) || ltrim(to_char(mod(l.tztm_hrs, 24), '00')) fmt_tztm_hrs
													,CASE
														 WHEN SUBSTR(d.lnk_org_nod_cd, 1, 2) IN ('US', 'CA') AND SUBSTR(d.lnk_dest_nod_cd, 1, 2) IN ('US', 'CA') AND	d.trsp_mod_cd = 'RD' THEN 'T'
														 ELSE 'F'
													 END fc
													,CASE
														 WHEN SUBSTR(i_rout_org_nod_cd, 1, 5) = SUBSTR(i_rout_dest_nod_cd, 1, 5) AND
																	NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD IN (i_rout_org_nod_cd, i_rout_dest_nod_cd) AND NOD_TP_CD = 'Z'),'X') <> 'Z' 
                                  THEN 'F'
														 ELSE 'T'
													 END CC
													,m.inlnd_rout_bkg_flg
													,a.trsp_agmt_ofc_cty_cd
													,a.trsp_agmt_seq
													,a.trsp_agmt_ofc_cty_cd || lpad(a.trsp_agmt_seq, 6, '0') agmt_no
													,a.agmt_ref_no
											FROM prd_inlnd_rout_mst m
													,prd_inlnd_rout_dtl d
													,prd_inlnd_each_lnk l
													,mdm_vendor         v
													,TRS_AGMT_HDR       a
										 WHERE m.rout_org_nod_cd = i_rout_org_nod_cd
											 AND m.rout_dest_nod_cd = i_rout_dest_nod_cd
											 AND m.rout_seq = i_rout_seq
											 AND m.rout_org_nod_cd = d.rout_org_nod_cd
											 AND m.rout_dest_nod_cd = d.rout_dest_nod_cd
											 AND m.rout_seq = d.rout_seq
											 AND d.lnk_org_nod_cd = l.lnk_org_nod_cd
											 AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd
											 AND d.trsp_mod_cd = l.trsp_mod_cd
											 and d.trsp_agmt_ofc_cty_cd = a.trsp_agmt_ofc_cty_cd(+)
											 and d.trsp_agmt_seq = a.trsp_agmt_seq(+)
													--AND   NVL(a.DELT_FLG, 'N') = 'N'
											 AND d.vndr_seq = v.vndr_seq(+)) A) X1;

BEGIN
	--DBMS_OUTPUT.PUT_LINE('start');
	FOR T IN T1 LOOP
	--	DBMS_OUTPUT.PUT_LINE('R : ' || T.R);
		IF V_CURR_CD <> 'NF' AND V_CURR_CD <> TRIM(T.CURR_CD) THEN
			IF T.CURR_CD <> 'NF' THEN V_DIFF := 'N';EXIT;
			END IF;
		ELSIF V_CURR_CD = 'NF' AND V_CURR_CD <> T.CURR_CD THEN V_CURR_CD := T.CURR_CD;
		ELSE V_CURR_CD := 'NF';
		END IF;
	END LOOP;
	FOR T IN T1 LOOP
		IF V_DIFF = 'Y' AND NVL(T.CURR_CD, 'NF') <> 'NF' THEN
			V_CURR_CD := T.CURR_CD;
			V_RATE    := V_RATE + T.RATE;
		ELSIF V_DIFF = 'N' AND NVL(T.CURR_CD, 'NF') <> 'NF' THEN V_CURR_CD := 'M/C';
			IF T.CURR_CD = 'USD' THEN V_RATE := V_RATE + T.RATE;
			ELSE V_RATE := V_RATE + TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(T.CURR_CD, T.RATE, TO_CHAR(SYSDATE, 'YYYYMM'));
			END IF;
		END IF;
	END LOOP;

	IF V_CURR_CD = 'NF' THEN O_RESULT := 'N/F|';
	ELSE O_RESULT := V_CURR_CD || '|' || V_RATE;
	END IF;
--	DBMS_OUTPUT.PUT_LINE('END');
	RETURN(O_RESULT);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN NULL;
END PRD_GET_INLND_RATE_FNC;
/

