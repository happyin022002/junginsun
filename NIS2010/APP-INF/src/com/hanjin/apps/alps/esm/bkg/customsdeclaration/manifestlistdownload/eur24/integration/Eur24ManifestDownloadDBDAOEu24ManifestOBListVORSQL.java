/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEu24ManifestOBListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.20 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEu24ManifestOBListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEu24ManifestOBListVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEu24ManifestOBListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEu24ManifestOBListVORSQL").append("\n"); 
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
		query.append("/* Eu24ManifestListOBVO ManifestListDetailVO " ).append("\n"); 
		query.append("import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  ' ' AS BND_TP_CD " ).append("\n"); 
		query.append(", ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS DT_SEQ " ).append("\n"); 
		query.append(", ' ' AS BKG_NO" ).append("\n"); 
		query.append(", ' ' AS DT_CHECK" ).append("\n"); 
		query.append(", ' ' AS POL" ).append("\n"); 
		query.append(", ' ' AS POD" ).append("\n"); 
		query.append(", ' ' AS BPOL" ).append("\n"); 
		query.append(", ' ' AS BPOD" ).append("\n"); 
		query.append(", ' ' AS DEL" ).append("\n"); 
		query.append(", ' ' AS CT" ).append("\n"); 
		query.append(", ' ' AS LT" ).append("\n"); 
		query.append(", ' ' AS SH_NM" ).append("\n"); 
		query.append(", ' ' AS SH_AD" ).append("\n"); 
		query.append(", ' ' AS SH_CT" ).append("\n"); 
		query.append(", ' ' AS SH_CN" ).append("\n"); 
		query.append(", ' ' AS SH_ZIP" ).append("\n"); 
		query.append(", ' ' AS SH_STR " ).append("\n"); 
		query.append(", ' ' AS SH_EORI" ).append("\n"); 
		query.append(", ' ' AS CNEE_NM" ).append("\n"); 
		query.append(", ' ' AS CNEE_AD" ).append("\n"); 
		query.append(", ' ' AS CNEE_CT" ).append("\n"); 
		query.append(", ' ' AS CNEE_CN" ).append("\n"); 
		query.append(", ' ' AS CNEE_ZIP" ).append("\n"); 
		query.append(", ' ' AS CNEE_STR " ).append("\n"); 
		query.append(", ' ' AS CNEE_EORI" ).append("\n"); 
		query.append(", ' ' AS NTFY_NM" ).append("\n"); 
		query.append(", ' ' AS NTFY_AD" ).append("\n"); 
		query.append(", ' ' AS NTFY_CT" ).append("\n"); 
		query.append(", ' ' AS NTFY_CN" ).append("\n"); 
		query.append(", ' ' AS NTFY_ZIP" ).append("\n"); 
		query.append(", ' ' AS NTFY_STR " ).append("\n"); 
		query.append(", ' ' AS NTFY_EORI" ).append("\n"); 
		query.append(", ' ' AS BL_PK" ).append("\n"); 
		query.append(", ' ' AS BL_WT" ).append("\n"); 
		query.append(", ' ' AS BL_MS" ).append("\n"); 
		query.append(", ' ' AS CNTR_CNTR_NO" ).append("\n"); 
		query.append(", ' ' AS CNTR_SEAL" ).append("\n"); 
		query.append(", ' ' AS CNTR_PK" ).append("\n"); 
		query.append(", ' ' AS CNTR_WT" ).append("\n"); 
		query.append(", ' ' AS CNTR_MS" ).append("\n"); 
		query.append(", ' ' AS CM_PK" ).append("\n"); 
		query.append(", ' ' AS CM_WT" ).append("\n"); 
		query.append(", ' ' AS CM_MS" ).append("\n"); 
		query.append(", ' ' AS CM_DS" ).append("\n"); 
		query.append(", ' ' AS CM_MK" ).append("\n"); 
		query.append(", ' ' AS CM_HTS" ).append("\n"); 
		query.append(", ' ' AS EDI_SENT" ).append("\n"); 
		query.append(", ' ' AS EDI_TIME" ).append("\n"); 
		query.append(", ' ' AS EDI_MRN" ).append("\n"); 
		query.append(", ' ' AS EDI_REF_NO" ).append("\n"); 
		query.append(", ' ' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", ' ' AS EU_1ST_PORT" ).append("\n"); 
		query.append(", ' ' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", ' ' AS TTL_BL" ).append("\n"); 
		query.append(", ' ' AS TTL_ERR_BL" ).append("\n"); 
		query.append(", ' ' AS TTL_CNTR" ).append("\n"); 
		query.append(", ' ' AS VSL_CD" ).append("\n"); 
		query.append(", ' ' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS CNTR_LIST" ).append("\n"); 
		query.append(", ' ' AS CRE_USR_ID" ).append("\n"); 
		query.append(", ' ' AS ERR_YN" ).append("\n"); 
		query.append(", ' ' AS DOWNLOAD_YN" ).append("\n"); 
		query.append(", ' ' AS VPS_PORT_YD_CD" ).append("\n"); 
		query.append(", ' ' AS EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append(", ' ' AS POL_YD_CD" ).append("\n"); 
		query.append(", ' ' AS POD_YD_CD" ).append("\n"); 
		query.append(", ' ' AS DEL_YD_CD" ).append("\n"); 
		query.append(", ' ' AS PORT_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS SENT_TIME" ).append("\n"); 
		query.append(", ' ' AS RECEIVED_TIME" ).append("\n"); 
		query.append(", ' ' AS RESULT" ).append("\n"); 
		query.append(", ' ' AS ENS_RESULT" ).append("\n"); 
		query.append(", ' ' AS BL_STATUS" ).append("\n"); 
		query.append(", ' ' AS MSG_SND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS SENT_BL_CNT      " ).append("\n"); 
		query.append(", ' ' AS UNSENT_BL_CNT    " ).append("\n"); 
		query.append(", ' ' AS SENT_SUCCESS_CNT " ).append("\n"); 
		query.append(", ' ' AS SENT_FAIL_CNT    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS A_CNT" ).append("\n"); 
		query.append(", ' ' AS R_CNT" ).append("\n"); 
		query.append(", ' ' AS DNL_CNT" ).append("\n"); 
		query.append(", ' ' AS H_CNT" ).append("\n"); 
		query.append(", ' ' AS NR_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS DR_YN" ).append("\n"); 
		query.append(", ' ' AS ARN_YN" ).append("\n"); 
		query.append(", ' ' AS RCV_MSG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS SLAN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS ENS_EDI_SVC_FLG" ).append("\n"); 
		query.append(", ' ' AS EXS_EDI_SVC_FLG" ).append("\n"); 
		query.append(", ' ' AS AN_EDI_SVC_FLG" ).append("\n"); 
		query.append(", ' ' AS DVS_RQST_EDI_SVC_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS RESULT2" ).append("\n"); 
		query.append(", ' ' AS EU_1ST_PORT_NAME" ).append("\n"); 
		query.append(", ' ' AS SEARCH_EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS ATA_YN" ).append("\n"); 
		query.append(", ' ' AS EDI_RCV_DT" ).append("\n"); 
		query.append(", ' ' AS EDI_RCV_SEQ" ).append("\n"); 
		query.append(", ' ' AS KTS_SEND_DT" ).append("\n"); 
		query.append(", ' ' AS UPDATE_REASON" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}