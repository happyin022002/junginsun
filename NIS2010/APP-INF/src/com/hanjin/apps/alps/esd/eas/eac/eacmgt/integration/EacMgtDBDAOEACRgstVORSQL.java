/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACRgstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACRgstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Registration 화면의 VO 생성쿼리
	  * </pre>
	  */
	public EacMgtDBDAOEACRgstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACRgstVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS EAC_INP_DT" ).append("\n"); 
		query.append(", '' AS AUDR_OFC_CD" ).append("\n"); 
		query.append(", '' AS EAC_APRO_STEP_SEQ" ).append("\n"); 
		query.append(", '' AS EAC_REG_USR_NM" ).append("\n"); 
		query.append(", '' AS EAC_NO" ).append("\n"); 
		query.append(", '' AS EAC_EXPN_TP_CD " ).append("\n"); 
		query.append(", '' AS EAC_TP_CD" ).append("\n"); 
		query.append(", '' AS EAC_BIL_TP_CD" ).append("\n"); 
		query.append(", '' AS EAC_COST_CD_DESC" ).append("\n"); 
		query.append(", '' AS VNDR_SEQ" ).append("\n"); 
		query.append(", '' AS VNDR_NM" ).append("\n"); 
		query.append(", '' AS N3PTY_SRC_NO" ).append("\n"); 
		query.append(", '' AS N3PTY_SRC_DT" ).append("\n"); 
		query.append(", '' AS YD_CD" ).append("\n"); 
		query.append(", '' AS RESPB_OFC_CD" ).append("\n"); 
		query.append(", '' AS VVD_DESC" ).append("\n"); 
		query.append(", '' AS WO_NO_DESC" ).append("\n"); 
		query.append(", '' AS CURR_CD" ).append("\n"); 
		query.append(", '' AS INV_AMT" ).append("\n"); 
		query.append(", '' AS INV_CNG_AMT" ).append("\n"); 
		query.append(", '' AS INV_AUD_AMT" ).append("\n"); 
		query.append(", '' AS INV_AUD_USD_AMT" ).append("\n"); 
		query.append(", '' AS EAC_YRMON" ).append("\n"); 
		query.append(", '' AS EAC_RSN_CD" ).append("\n"); 
		query.append(", '' AS EAC_STS_NM" ).append("\n"); 
		query.append(", '' AS EAC_DESC" ).append("\n"); 
		query.append(", '' AS EAC_INTER_RMK" ).append("\n"); 
		query.append(", '' AS EAC_RSN_DESC" ).append("\n"); 
		query.append(", '' AS EAC_RJCT_OFC_CD" ).append("\n"); 
		query.append(", '' AS EAC_RJCT_USR_NM" ).append("\n"); 
		query.append(", '' AS EXPN_EVID_DESC" ).append("\n"); 
		query.append(", '' AS EAC_RJCT_RSN" ).append("\n"); 
		query.append(", '' AS EAC_RJCT_DESC" ).append("\n"); 
		query.append(", '' AS EAC_CMPL_FLG" ).append("\n"); 
		query.append(", '' AS ATCH_FILE_ID" ).append("\n"); 
		query.append(", '' AS NTC_KNT_CD" ).append("\n"); 
		query.append(", '' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", '' AS ENG_ADDR" ).append("\n"); 
		query.append(", '' AS ZIP_CD" ).append("\n"); 
		query.append(", '' AS VNDR_CNTC_PNT_NM" ).append("\n"); 
		query.append(", '' AS VNDR_EML" ).append("\n"); 
		query.append(", '' AS PHN_NO" ).append("\n"); 
		query.append(", '' AS FAX_NO" ).append("\n"); 
		query.append(", '' AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append(", '' AS EML_CTNT" ).append("\n"); 
		query.append(", '' AS EAC_DESC" ).append("\n"); 
		query.append(", '' AS N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append(", '' AS N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(", '' AS BKG_NO" ).append("\n"); 
		query.append(", '' AS BL_NO" ).append("\n"); 
		query.append(", '' AS VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(", '' AS TRD_PARTY_VAL" ).append("\n"); 
		query.append(", '' AS TRD_PARTY_NM" ).append("\n"); 
		query.append(", '' AS N3PTY_NO" ).append("\n"); 
		query.append(", '' AS STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append(", '' AS OTS_STS_NM" ).append("\n"); 
		query.append(", '' AS INV_AMT" ).append("\n"); 
		query.append(", '' AS TPB_INV_AMT" ).append("\n"); 
		query.append(", '' AS EAC_STS_CD" ).append("\n"); 
		query.append(", '' AS AUDR_USR_ID" ).append("\n"); 
		query.append(", '' AS VVD_CD_CTNT" ).append("\n"); 
		query.append(", '' AS CTY_NM" ).append("\n"); 
		query.append(", '' AS STE_NM" ).append("\n"); 
		query.append(", '' AS EAC_APRO_TP_CD" ).append("\n"); 
		query.append(", '' AS EAC_COST_DESC" ).append("\n"); 
		query.append(", '' AS STL_AMT" ).append("\n"); 
		query.append(", '' AS EAC_CMPL_CD" ).append("\n"); 
		query.append(", '' AS NTC_HIS_SEQ" ).append("\n"); 
		query.append(", '' AS WO_NO_CTNT" ).append("\n"); 
		query.append(", '' AS VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(", '' AS EQ_KND_CD" ).append("\n"); 
		query.append(", '' AS EQ_NO" ).append("\n"); 
		query.append(", '' AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(", '' AS DIFF_INV_AMT" ).append("\n"); 
		query.append(", '' AS TPB_VNDR_CNT_CD" ).append("\n"); 
		query.append(", '' AS TPB_VNDR_SEQ" ).append("\n"); 
		query.append(", '' AS CUST_CNT_CD" ).append("\n"); 
		query.append(", '' AS CUST_SEQ" ).append("\n"); 
		query.append(", '' AS N3PTY_OFC_CD" ).append("\n"); 
		query.append(", '' AS STATUS" ).append("\n"); 
		query.append(", '' AS EAC_DTL_SEQ" ).append("\n"); 
		query.append(", '' AS TPB_OFC_CD" ).append("\n"); 
		query.append(", '' AS OTS_STS_NM" ).append("\n"); 
		query.append(", '' AS INV_AMT" ).append("\n"); 
		query.append(", '' AS TPB_VNDR_NM" ).append("\n"); 
		query.append(", '' AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(", '' AS OFC_ENG_NM" ).append("\n"); 
		query.append(", '' AS EAC_EML_USE_FLG" ).append("\n"); 
		query.append(", '' AS EAC_FAX_USE_FLG" ).append("\n"); 
		query.append(", '' AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append(", '' AS FILEFLAG" ).append("\n"); 
		query.append(", '' AS EAC_SYS_IF_CD" ).append("\n"); 
		query.append(", '' AS ISS_CTY_CD" ).append("\n"); 
		query.append(", '' AS SO_SEQ" ).append("\n"); 
		query.append(", '' AS SO_DTL_SEQ" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}