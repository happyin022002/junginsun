CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_INLND_DTL_RATE_FNC(pi_crr_mod_cd     IN VARCHAR2, -- TRSP_MOD_CD
																											pi_vndr_seq       IN NUMBER,
																											pi_rail_svc_tp_cd IN VARCHAR2, -- RAIL_CRR_TP_CD
																											pi_io_bnd         IN VARCHAR2,
																											pi_from_nod_cd    IN VARCHAR2,
																											pi_to_nod_cd      IN VARCHAR2) RETURN VARCHAR AUTHID CURRENT_USER IS
	v_new_rail_svc_tp_cd VARCHAR(2);
	v_cost_mod_cd        VARCHAR(2);
	o_result             VARCHAR(50);
	v_skp_flag           VARCHAR(1) := 'Y';
BEGIN
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
  
	--DBMS_OUTPUT.PUT_LINE('v_cost_mod_cd : ' || v_cost_mod_cd);
	--DBMS_OUTPUT.PUT_LINE('v_new_rail_svc_tp_cd : ' || v_new_rail_svc_tp_cd);
	--DBMS_OUTPUT.PUT_LINE('pi_crr_mod_cd : ' || pi_crr_mod_cd);
	--DBMS_OUTPUT.PUT_LINE('pi_from_nod_cd : ' || pi_from_nod_cd);
	--DBMS_OUTPUT.PUT_LINE('pi_to_nod_cd : ' || pi_to_nod_cd);
	--DBMS_OUTPUT.PUT_LINE('v_skp_flag : ' || v_skp_flag);

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
										 WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
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
											 AND (DECODE(pi_io_bnd, 'I', D.FM_NOD_CD, '0') = DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000'), '0'))
											 AND (D.DOR_NOD_CD = DECODE(pi_io_bnd, 'I', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), 'O', DECODE(LENGTH(D.DOR_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000')))
											 AND (DECODE(pi_io_bnd, 'O', D.TO_NOD_CD, '0') = DECODE(pi_io_bnd, 'O', DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'), '0'))
											 AND SYSDATE BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT
										 ORDER BY E.EFF_TO_DT DESC
														 ,LENGTH(DECODE(D.FM_NOD_CD, '0000000', 'N/A', D.FM_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.VIA_NOD_CD, '0000000', 'N/A', D.VIA_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.DOR_NOD_CD, '0000000', 'N/A', D.DOR_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.TO_NOD_CD, '0000000', 'N/A', D.TO_NOD_CD)) DESC
														 ,E.TO_WGT ASC)
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
										 WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD
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
											 AND (D.FM_NOD_CD = DECODE(LENGTH(D.FM_NOD_CD), 7, pi_from_nod_cd, 5, SUBSTR(pi_from_nod_cd, 1, 5), '0000000'))
											 AND (D.TO_NOD_CD = DECODE(LENGTH(D.TO_NOD_CD), 7, pi_to_nod_cd, 5, SUBSTR(pi_to_nod_cd, 1, 5), '0000000'))
											 AND SYSDATE BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT
										 ORDER BY E.EFF_TO_DT DESC
														 ,LENGTH(DECODE(D.FM_NOD_CD, '0000000', 'N/A', D.FM_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.VIA_NOD_CD, '0000000', 'N/A', D.VIA_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.DOR_NOD_CD, '0000000', 'N/A', D.DOR_NOD_CD)) DESC
														 ,LENGTH(DECODE(D.TO_NOD_CD, '0000000', 'N/A', D.TO_NOD_CD)) DESC
														 ,E.TO_WGT ASC)
						 WHERE ROWNUM = 1);
	END IF;
	RETURN o_result;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		BEGIN
			o_result := NULL;
			RETURN o_result;
		END;
	
END PRD_GET_INLND_DTL_RATE_FNC;
/

