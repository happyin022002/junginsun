/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchPayerCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.05
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.05 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchPayerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayerCode
	  * </pre>
	  */
	public BlRatingDBDAOSearchPayerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchPayerCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN BKG_CUST_TP_CD ='S' THEN 'SHIPPER'" ).append("\n"); 
		query.append("	WHEN BKG_CUST_TP_CD ='F' THEN 'FOWARDER'" ).append("\n"); 
		query.append("    WHEN BKG_CUST_TP_CD ='C' THEN 'CONSIGNEE'" ).append("\n"); 
		query.append("    WHEN BKG_CUST_TP_CD ='N' THEN 'NOTIFY'" ).append("\n"); 
		query.append("    WHEN BKG_CUST_TP_CD ='R' THEN 'REP. CUSTOMER' " ).append("\n"); 
		query.append("END  AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("CUST_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${call_type} == 'PPD') " ).append("\n"); 
		query.append("	#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("		SELECT ROWNUM,A.* FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		--FAD" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				10 AS FLG," ).append("\n"); 
		query.append("				'F' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				BKG_OFC_CD OFC_CD," ).append("\n"); 
		query.append("				C.CUST_CNT_CD," ).append("\n"); 
		query.append("				C.CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    BKG_BKG_HIS B," ).append("\n"); 
		query.append("				BKG_CUST_HIS F," ).append("\n"); 
		query.append("				MDM_CUSTOMER C," ).append("\n"); 
		query.append("				MDM_LOCATION M" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("		AND    F.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("		AND    F.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    F.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		AND    B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    F.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    C.DELT_FLG ='N'" ).append("\n"); 
		query.append("		AND    B.POR_CD = M.LOC_CD" ).append("\n"); 
		query.append("		AND    M.CONTI_CD IN( 'F','E')" ).append("\n"); 
		query.append("		AND    M.DELT_FLG ='N'" ).append("\n"); 
		query.append("		AND    EXISTS( SELECT 'Y' FROM MDM_LOCATION L" ).append("\n"); 
		query.append("						WHERE L.CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("						  AND L.CONTI_CD ='E'" ).append("\n"); 
		query.append("						  AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION " ).append("\n"); 
		query.append("		--PPD" ).append("\n"); 
		query.append("		SELECT BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				11 AS FLG," ).append("\n"); 
		query.append("				'S' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				CR_CLT_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				BCUST.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("				BCUST.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("				BCUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("		FROM   MDM_CR_CUST CUST," ).append("\n"); 
		query.append("			   BKG_BKG_HIS BKG," ).append("\n"); 
		query.append("			   (SELECT S.CUST_CNT_CD, S.CUST_SEQ, C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			   FROM BKG_CUST_HIS S, " ).append("\n"); 
		query.append("					MDM_CUSTOMER C" ).append("\n"); 
		query.append("				WHERE  S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("				AND S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("				AND S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("				AND S.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("				) BCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    (CUST.CUST_CNT_CD, CUST.CUST_SEQ) = (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("											FROM   BKG_BKG_HIS B, BKG_CUST_HIS S" ).append("\n"); 
		query.append("											WHERE  B.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("											AND S.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("											AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("											AND B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("											AND S.CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("		AND    0 < CUST.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("		AND    CUST.CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("		AND    CUST.CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("		AND    BKG.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--PPD OFFICE CODE2" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				12 AS FLG," ).append("\n"); 
		query.append("				'S' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				BKG_OFC_CD OFC_CD," ).append("\n"); 
		query.append("				C.CUST_CNT_CD," ).append("\n"); 
		query.append("				C.CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    BKG_BKG_HIS B," ).append("\n"); 
		query.append("				BKG_CUST_HIS S," ).append("\n"); 
		query.append("				MDM_CUSTOMER C" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    S.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND    S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("		AND    S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		AND    B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    S.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		ORDER BY FLG" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		ROWNUM = 1" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT ROWNUM,A.* FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		--FAD" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				10 AS FLG," ).append("\n"); 
		query.append("				'F' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				BKG_OFC_CD OFC_CD," ).append("\n"); 
		query.append("				C.CUST_CNT_CD," ).append("\n"); 
		query.append("				C.CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    BKG_BOOKING B," ).append("\n"); 
		query.append("				BKG_CUSTOMER F," ).append("\n"); 
		query.append("				MDM_CUSTOMER C," ).append("\n"); 
		query.append("				MDM_LOCATION M" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("		AND    F.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("		AND    F.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    F.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		AND    C.DELT_FLG ='N'" ).append("\n"); 
		query.append("		AND    B.POR_CD = M.LOC_CD" ).append("\n"); 
		query.append("		AND    M.CONTI_CD IN( 'F','E')" ).append("\n"); 
		query.append("		AND    M.DELT_FLG ='N'" ).append("\n"); 
		query.append("		AND    EXISTS( SELECT 'Y' FROM MDM_LOCATION L" ).append("\n"); 
		query.append("						WHERE L.CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("						  AND L.CONTI_CD ='E'" ).append("\n"); 
		query.append("						  AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION " ).append("\n"); 
		query.append("		--PPD" ).append("\n"); 
		query.append("		SELECT BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				11 AS FLG," ).append("\n"); 
		query.append("				'S' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				CR_CLT_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				BCUST.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("				BCUST.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("				BCUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("		FROM   MDM_CR_CUST CUST," ).append("\n"); 
		query.append("			   BKG_BOOKING BKG," ).append("\n"); 
		query.append("			   (SELECT S.CUST_CNT_CD, S.CUST_SEQ, C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			   FROM BKG_CUSTOMER S, " ).append("\n"); 
		query.append("					MDM_CUSTOMER C" ).append("\n"); 
		query.append("				WHERE  S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("				AND S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("				AND S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("				) BCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    (CUST.CUST_CNT_CD, CUST.CUST_SEQ) = (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("											FROM   BKG_BOOKING B, BKG_CUSTOMER S" ).append("\n"); 
		query.append("											WHERE  B.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("											AND S.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("											AND S.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("		AND    0 < CUST.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("		AND    CUST.CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		AND    CUST.CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--PPD OFFICE CODE2" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				12 AS FLG," ).append("\n"); 
		query.append("				'S' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				BKG_OFC_CD OFC_CD," ).append("\n"); 
		query.append("				C.CUST_CNT_CD," ).append("\n"); 
		query.append("				C.CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    BKG_BOOKING B," ).append("\n"); 
		query.append("				BKG_CUSTOMER S," ).append("\n"); 
		query.append("				MDM_CUSTOMER C" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    S.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND    S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("		AND    S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		ORDER BY FLG" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("		SELECT ROWNUM,A.* FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		--CCT" ).append("\n"); 
		query.append("		SELECT  BKG.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("				21 AS FLG," ).append("\n"); 
		query.append("				'C' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				CR_CLT_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				BCUST.CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("				BCUST.CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("				MCUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    MDM_CR_CUST CUST," ).append("\n"); 
		query.append("				BKG_BKG_HIS BKG," ).append("\n"); 
		query.append("				BKG_CUST_HIS BCUST," ).append("\n"); 
		query.append("				MDM_CUSTOMER MCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    BKG.BKG_NO = BCUST.BKG_NO" ).append("\n"); 
		query.append("		AND    BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND    CUST.CUST_CNT_CD = BCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    CUST.CUST_SEQ = BCUST.CUST_SEQ" ).append("\n"); 
		query.append("		AND    BCUST.CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    BCUST.CUST_SEQ = MCUST.CUST_SEQ    " ).append("\n"); 
		query.append("		AND    IB_CR_TERM_DYS > 0" ).append("\n"); 
		query.append("		AND    BKG.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("		AND    CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--CCT OFFICE CODE2" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				22 AS FLG," ).append("\n"); 
		query.append("				'C' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				FINC_CTRL_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				S.CUST_CNT_CD  AS CUST_CNT_CD," ).append("\n"); 
		query.append("				NVL(S.CUST_SEQ,'1') AS CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    MDM_LOCATION M, " ).append("\n"); 
		query.append("				BKG_BKG_HIS B, " ).append("\n"); 
		query.append("				BKG_CUST_HIS S," ).append("\n"); 
		query.append("				MDM_CUSTOMER C" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    S.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND    S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND    S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		AND    B.DEL_CD = M.LOC_CD" ).append("\n"); 
		query.append("		AND    M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND    B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    S.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--REP CUSTOMER" ).append("\n"); 
		query.append("		SELECT BKG_NO," ).append("\n"); 
		query.append("				31 AS FLG," ).append("\n"); 
		query.append("				'R'AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				(SELECT  FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("					FROM MDM_LOCATION" ).append("\n"); 
		query.append("					WHERE LOC_CD = (SELECT DEL_CD" ).append("\n"); 
		query.append("									FROM  BKG_BKG_HIS" ).append("\n"); 
		query.append("									WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("									AND CORR_NO='TMP0000001')) AS OFC_CD," ).append("\n"); 
		query.append("				REP_CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("				REP_CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("				MCUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM   MDM_ORGANIZATION OFC, " ).append("\n"); 
		query.append("				BKG_BKG_HIS BKG," ).append("\n"); 
		query.append("				MDM_CUSTOMER MCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    REP_CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    REP_CUST_SEQ = MCUST.CUST_SEQ" ).append("\n"); 
		query.append("		AND    BKG.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		AND    OFC.OFC_CD = NVL((SELECT CR_CLT_OFC_CD" ).append("\n"); 
		query.append("								FROM MDM_CR_CUST" ).append("\n"); 
		query.append("								WHERE (CUST_CNT_CD, CUST_SEQ) = (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("																	FROM   BKG_BKG_HIS B," ).append("\n"); 
		query.append("																			BKG_CUST_HIS C" ).append("\n"); 
		query.append("																	WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("																	AND    C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("																	AND    C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("																	AND    B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("																	AND    C.CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("								AND 0 < IB_CR_TERM_DYS" ).append("\n"); 
		query.append("								AND CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("								AND CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] 		AND    CORR_NO='TMP0000001'))," ).append("\n"); 
		query.append("							(SELECT  FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("								FROM MDM_LOCATION" ).append("\n"); 
		query.append("								WHERE LOC_CD = (SELECT DEL_CD" ).append("\n"); 
		query.append("												FROM  BKG_BKG_HIS" ).append("\n"); 
		query.append("												WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("												AND CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							ORDER BY FLG" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		ROWNUM = 1" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		SELECT ROWNUM,A.* FROM " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		--CCT" ).append("\n"); 
		query.append("		SELECT  BKG.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("				21 AS FLG," ).append("\n"); 
		query.append("				'C' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				CR_CLT_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				BCUST.CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("				BCUST.CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("				MCUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    MDM_CR_CUST CUST," ).append("\n"); 
		query.append("				BKG_BOOKING BKG," ).append("\n"); 
		query.append("				BKG_CUSTOMER BCUST," ).append("\n"); 
		query.append("				MDM_CUSTOMER MCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    BKG.BKG_NO = BCUST.BKG_NO" ).append("\n"); 
		query.append("		AND    BCUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND    CUST.CUST_CNT_CD = BCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    CUST.CUST_SEQ = BCUST.CUST_SEQ" ).append("\n"); 
		query.append("		AND    BCUST.CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    BCUST.CUST_SEQ = MCUST.CUST_SEQ    " ).append("\n"); 
		query.append("		AND    IB_CR_TERM_DYS > 0" ).append("\n"); 
		query.append("		AND    CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		AND    CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--CCT OFFICE CODE2" ).append("\n"); 
		query.append("		SELECT B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("				22 AS FLG," ).append("\n"); 
		query.append("				'C' AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				FINC_CTRL_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("				S.CUST_CNT_CD  AS CUST_CNT_CD," ).append("\n"); 
		query.append("				NVL(S.CUST_SEQ,'1') AS CUST_SEQ," ).append("\n"); 
		query.append("				C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM    MDM_LOCATION M, " ).append("\n"); 
		query.append("				BKG_BOOKING B, " ).append("\n"); 
		query.append("				BKG_CUSTOMER S," ).append("\n"); 
		query.append("				MDM_CUSTOMER C" ).append("\n"); 
		query.append("		WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    S.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND    S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND    S.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    S.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("		AND    B.DEL_CD = M.LOC_CD" ).append("\n"); 
		query.append("		AND    M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		--REP CUSTOMER" ).append("\n"); 
		query.append("		SELECT BKG_NO," ).append("\n"); 
		query.append("				31 AS FLG," ).append("\n"); 
		query.append("				'R'AS BKG_CUST_TP_CD," ).append("\n"); 
		query.append("				(SELECT  FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("					FROM MDM_LOCATION" ).append("\n"); 
		query.append("					WHERE LOC_CD = (SELECT DEL_CD" ).append("\n"); 
		query.append("									FROM  BKG_BOOKING" ).append("\n"); 
		query.append("									WHERE BKG_NO =@[bkg_no])) AS OFC_CD," ).append("\n"); 
		query.append("				REP_CUST_CNT_CD AS CUST_CNT_CD," ).append("\n"); 
		query.append("				REP_CUST_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("				MCUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("		FROM   MDM_ORGANIZATION OFC, " ).append("\n"); 
		query.append("				BKG_BOOKING BKG," ).append("\n"); 
		query.append("				MDM_CUSTOMER MCUST" ).append("\n"); 
		query.append("		WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND    REP_CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("		AND    REP_CUST_SEQ = MCUST.CUST_SEQ" ).append("\n"); 
		query.append("		AND    OFC.OFC_CD = NVL((SELECT CR_CLT_OFC_CD" ).append("\n"); 
		query.append("								FROM MDM_CR_CUST" ).append("\n"); 
		query.append("								WHERE (CUST_CNT_CD, CUST_SEQ) = (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("																	FROM   BKG_BOOKING B," ).append("\n"); 
		query.append("																			BKG_CUSTOMER C" ).append("\n"); 
		query.append("																	WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("																	AND    C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("																	AND    C.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("								AND 0 < IB_CR_TERM_DYS" ).append("\n"); 
		query.append("								AND CR_ST_DT  <= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("								AND CR_END_DT >= (SELECT TO_CHAR(BKG_CRE_DT,'RRRRMMDD') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))," ).append("\n"); 
		query.append("							(SELECT  FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("								FROM MDM_LOCATION" ).append("\n"); 
		query.append("								WHERE LOC_CD = (SELECT DEL_CD" ).append("\n"); 
		query.append("												FROM  BKG_BOOKING" ).append("\n"); 
		query.append("												WHERE BKG_NO =@[bkg_no])" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							ORDER BY FLG" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		ROWNUM = 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}