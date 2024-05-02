/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPsaDGRcvMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.11.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOPsaDGRcvMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EurRcvMsgVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPsaDGRcvMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPsaDGRcvMsgVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 '' KEY_VAL" ).append("\n"); 
		query.append("	,'' RCV_LOG_SEQ" ).append("\n"); 
		query.append("	,'' ORG_MSG_TP" ).append("\n"); 
		query.append("	,'' MSG_UDT_FLG" ).append("\n"); 
		query.append("	,'' ORG_MSG_NM" ).append("\n"); 
		query.append("	,'' MSG_ACK_TP" ).append("\n"); 
		query.append("	,'' MSG_ACK_RSLT" ).append("\n"); 
		query.append("	,'' MSG_ACK_DT" ).append("\n"); 
		query.append("	,'' MSG_APPROVE_DT" ).append("\n"); 
		query.append("	,'' MSG_PHONE" ).append("\n"); 
		query.append("	,'' MSG_FAX" ).append("\n"); 
		query.append("	,'' ORG_MSG_CNTR" ).append("\n"); 
		query.append("	,'' ORG_MSG_BL" ).append("\n"); 
		query.append("	,'' MSG_R_ERROR_CODE" ).append("\n"); 
		query.append("	,'' MSG_R_ERROR_MSG" ).append("\n"); 
		query.append("	,'' MSG_R_REF1" ).append("\n"); 
		query.append("	,'' MSG_R_REF2" ).append("\n"); 
		query.append("	,'' SEC_FILE_NBR" ).append("\n"); 
		query.append("	,'' MSG_ACCEPT_REF" ).append("\n"); 
		query.append("	,'' CRE_USR_ID" ).append("\n"); 
		query.append("	,'' UPD_USR_ID" ).append("\n"); 
		query.append("  	,'' MSG_TP_ID" ).append("\n"); 
		query.append("    ,'' PSA_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("    ,'' MSG_RCV_NO" ).append("\n"); 
		query.append("    ,'' RCV_LOG_SEQ" ).append("\n"); 
		query.append("    ,'' RCV_LOG_ERR_SEQ" ).append("\n"); 
		query.append("    ,'' CSTMS_ERR_ID" ).append("\n"); 
		query.append("    ,'' CSTMS_ERR_MSG" ).append("\n"); 
		query.append("    ,'' CSTMS_ERR_REF_NO1" ).append("\n"); 
		query.append("    ,'' CSTMS_ERR_REF_NO2" ).append("\n"); 
		query.append("    ,'' CRE_USR_ID" ).append("\n"); 
		query.append("    ,'' CRE_DT" ).append("\n"); 
		query.append("    ,'' UPD_USR_ID" ).append("\n"); 
		query.append("    ,'' UPD_DT" ).append("\n"); 
		query.append("    ,'' PSA_VSL_NAME" ).append("\n"); 
		query.append("    ,'' IB_VVD_CD" ).append("\n"); 
		query.append("    ,'' OB_VVD_CD" ).append("\n"); 
		query.append("    ,'' CNTR_NO" ).append("\n"); 
		query.append("    ,'' CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("    ,'' ERR_CNTR_STS_CD" ).append("\n"); 
		query.append("    ,'' TNK_CNTR_TPSZ_FLG" ).append("\n"); 
		query.append("    ,'' TTL_PCK_QTY" ).append("\n"); 
		query.append("    ,'' TTL_PCK_TP_NM" ).append("\n"); 
		query.append("    ,'' DG_TTL_WGT" ).append("\n"); 
		query.append("    ,'' IMO_NO" ).append("\n"); 
		query.append("    ,'' IMDG_UN_NO" ).append("\n"); 
		query.append("    ,'' CNTR_TTL_KNT" ).append("\n"); 
		query.append("    ,'' CNTR_TTL_ERR_KNT" ).append("\n"); 
		query.append("    ,'' CNTR_TTL_SCS_KNT" ).append("\n"); 
		query.append("	,'' FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}