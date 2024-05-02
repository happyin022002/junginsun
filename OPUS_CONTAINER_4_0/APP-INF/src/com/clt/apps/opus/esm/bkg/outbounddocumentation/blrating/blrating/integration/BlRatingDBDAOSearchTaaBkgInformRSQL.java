/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchTaaBkgInformRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.04.29 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchTaaBkgInformRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchTaaBkgInform Taa Booking 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchTaaBkgInformRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchTaaBkgInformRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(NVL(((SELECT MAX(CGO_RCV_DT) FROM BKG_CNTR_HIS WHERE BKG_NO = MAI.BKG_NO AND CORR_NO ='TMP0000001')),(SELECT RT_APLY_DT FROM BKG_RT_HIS WHERE BKG_NO=MAI.BKG_NO AND CORR_NO ='TMP0000001')),'YYYY-MM-DD') CNTR_CDR_DT" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = MAI.CMDT_CD )CMDT_NM" ).append("\n"); 
		query.append("	,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT K WHERE K.REP_CMDT_CD = MAI.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,ACT_WGT" ).append("\n"); 
		query.append("	,MEAS_QTY" ).append("\n"); 
		query.append("	,MEAS_UT_CD" ).append("\n"); 
		query.append("	,BKG_POR_CD" ).append("\n"); 
		query.append("	,BKG_POL_CD" ).append("\n"); 
		query.append("	,BKG_POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,VV_POL_CD" ).append("\n"); 
		query.append("	,VV_POD_CD" ).append("\n"); 
		query.append("	,RCV_TERM_CD" ).append("\n"); 
		query.append("	,DE_TERM_CD" ).append("\n"); 
		query.append("	,SPECIAL" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,TAA_NO AS FTAA_NO" ).append("\n"); 
		query.append("	,(SELECT FRT_TERM_CD FROM BKG_RT_HIS WHERE BKG_NO=MAI.BKG_NO AND CORR_NO ='TMP0000001') FRT_TERM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		,CMDT_CD" ).append("\n"); 
		query.append("		,REP_CMDT_CD" ).append("\n"); 
		query.append("		,ACT_WGT" ).append("\n"); 
		query.append("		,MEAS_QTY" ).append("\n"); 
		query.append("		,MEAS_UT_CD" ).append("\n"); 
		query.append("		,BKG.POR_CD BKG_POR_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD BKG_POL_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("		,BKG.DEL_CD" ).append("\n"); 
		query.append("		,RCV_TERM_CD" ).append("\n"); 
		query.append("		,DE_TERM_CD" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,TAA_NO" ).append("\n"); 
		query.append("		, CASE " ).append("\n"); 
		query.append("			WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("		END SPECIAL  " ).append("\n"); 
		query.append("		,BKG.PRE_RLY_PORT_CD VV_POL_CD" ).append("\n"); 
		query.append("		,BKG.PST_RLY_PORT_CD VV_POD_CD  " ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_BKG_HIS BKG, BKG_BL_DOC_HIS BL " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = BL.BKG_NO " ).append("\n"); 
		query.append("		AND BKG.BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append("		AND BKG.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("		AND BL.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append(") MAI" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(NVL(((SELECT MAX(CGO_RCV_DT) FROM BKG_CONTAINER WHERE BKG_NO = MAI.BKG_NO)),(SELECT RT_APLY_DT FROM BKG_RATE WHERE BKG_NO=MAI.BKG_NO)),'YYYY-MM-DD') CNTR_CDR_DT" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = MAI.CMDT_CD )CMDT_NM" ).append("\n"); 
		query.append("	,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT K WHERE K.REP_CMDT_CD = MAI.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,ACT_WGT" ).append("\n"); 
		query.append("	,MEAS_QTY" ).append("\n"); 
		query.append("	,MEAS_UT_CD" ).append("\n"); 
		query.append("	,BKG_POR_CD" ).append("\n"); 
		query.append("	,BKG_POL_CD" ).append("\n"); 
		query.append("	,BKG_POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,VV_POL_CD" ).append("\n"); 
		query.append("	,VV_POD_CD" ).append("\n"); 
		query.append("	,RCV_TERM_CD" ).append("\n"); 
		query.append("	,DE_TERM_CD" ).append("\n"); 
		query.append("	,SPECIAL" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,TAA_NO AS FTAA_NO" ).append("\n"); 
		query.append("	,(SELECT FRT_TERM_CD FROM BKG_RATE WHERE BKG_NO=MAI.BKG_NO) FRT_TERM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		,CMDT_CD" ).append("\n"); 
		query.append("		,REP_CMDT_CD" ).append("\n"); 
		query.append("		,ACT_WGT" ).append("\n"); 
		query.append("		,MEAS_QTY" ).append("\n"); 
		query.append("		,MEAS_UT_CD" ).append("\n"); 
		query.append("		,BKG.POR_CD BKG_POR_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD BKG_POL_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("		,BKG.DEL_CD" ).append("\n"); 
		query.append("		,RCV_TERM_CD" ).append("\n"); 
		query.append("		,DE_TERM_CD" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,TAA_NO" ).append("\n"); 
		query.append("		, CASE " ).append("\n"); 
		query.append("			WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("		END SPECIAL" ).append("\n"); 
		query.append("		,BKG.PRE_RLY_PORT_CD VV_POL_CD" ).append("\n"); 
		query.append("		,BKG.PST_RLY_PORT_CD VV_POD_CD    " ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_BOOKING BKG, BKG_BL_DOC BL " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = BL.BKG_NO " ).append("\n"); 
		query.append("		AND BKG.BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append(") MAI" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}