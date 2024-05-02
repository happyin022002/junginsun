/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchDemandNoteIssueEtcPreviewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.05.13 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchDemandNoteIssueEtcPreviewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDemandNoteIssueEtcPreview
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchDemandNoteIssueEtcPreviewRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchDemandNoteIssueEtcPreviewRSQL").append("\n"); 
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
		query.append("SELECT B.VSL_CD" ).append("\n"); 
		query.append("|| B.SKD_VOY_NO" ).append("\n"); 
		query.append("|| B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(", (SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = B.VSL_CD) AS VVD_NM" ).append("\n"); 
		query.append(", (SELECT TO_CHAR (VPS_ETA_DT,'DDMonYY', 'NLS_DATE_LANGUAGE = American')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS_PORT_CD =" ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.POD_CD" ).append("\n"); 
		query.append("ELSE B.POR_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = 1) AS ARR" ).append("\n"); 
		query.append(", (SELECT TO_CHAR (VPS_ETD_DT,'DDMonYY', 'NLS_DATE_LANGUAGE = American')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS_PORT_CD =" ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.POD_CD" ).append("\n"); 
		query.append("ELSE B.POR_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = 1) AS DEP" ).append("\n"); 
		query.append(",B.BL_NO AS BL_NO" ).append("\n"); 
		query.append(",B.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append(", (SELECT DISTINCT CMDT_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CMDT_CD" ).append("\n"); 
		query.append(", (SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD =" ).append("\n"); 
		query.append("(SELECT DISTINCT CMDT_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1)) AS CMDT_NM" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD AS DMDT_TRF_CD" ).append("\n"); 
		query.append(", (SELECT DMDT_TRF_NM" ).append("\n"); 
		query.append("FROM DMT_TRF_TP" ).append("\n"); 
		query.append("WHERE DMDT_TRF_CD = C.DMDT_TRF_CD) AS DMDT_TRF_NM" ).append("\n"); 
		query.append(", (SELECT DISTINCT BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = C.CNTR_NO ) AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_VAL_CTNT = (SELECT DISTINCT BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = C.CNTR_NO )" ).append("\n"); 
		query.append("AND INTG_CD_ID = 'CD00764') AS BKG_RCV_TERM_NM" ).append("\n"); 
		query.append(", (SELECT DISTINCT BKG_DE_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO	 = B.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = C.CNTR_NO) AS BKG_DEL_TERM_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_VAL_CTNT = (SELECT DISTINCT BKG_DE_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = C.CNTR_NO)" ).append("\n"); 
		query.append("AND INTG_CD_ID = 'CD00765') AS BKG_DEL_TERM_NM" ).append("\n"); 
		query.append(", (CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.POD_CD" ).append("\n"); 
		query.append("ELSE B.POR_CD" ).append("\n"); 
		query.append("END) AS POD" ).append("\n"); 
		query.append(", (SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD =" ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.POD_CD" ).append("\n"); 
		query.append("ELSE B.POR_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")) AS POD_NM" ).append("\n"); 
		query.append(", (CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.DEL_CD" ).append("\n"); 
		query.append("ELSE B.POL_CD" ).append("\n"); 
		query.append("END) AS DEL" ).append("\n"); 
		query.append(", (SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD =" ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") = 'I'" ).append("\n"); 
		query.append("THEN B.DEL_CD" ).append("\n"); 
		query.append("ELSE B.POL_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")) AS DEL_NM" ).append("\n"); 
		query.append(",DECODE (C.VNDR_SEQ" ).append("\n"); 
		query.append(",0, ''" ).append("\n"); 
		query.append(", (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = C.VNDR_SEQ)" ).append("\n"); 
		query.append(") AS TRUCKER" ).append("\n"); 
		query.append(",C.VNDR_SEQ" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}